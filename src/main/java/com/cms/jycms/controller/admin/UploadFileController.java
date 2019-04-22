package com.cms.jycms.controller.admin;

import com.cms.jycms.common.R;
import com.cms.jycms.util.CommUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

@RestController
@RequestMapping("/admin/api/uploadFile")
public class UploadFileController {

    @Value("${web.upload-path}")
    private String uploadFilePath;
    @Value("${web.imagesDir}")
    private String imagesDir;

    @PostMapping("add")
    public R add(MultipartHttpServletRequest request) {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;
        //上传路径

        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            String absPath = "/" + imagesDir + "/" + LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/"
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")) + "."
                    + mpf.getOriginalFilename().substring((mpf.getOriginalFilename().indexOf(".") + 1));
            String url = uploadFilePath + absPath;
            try {
                // 生成图片
                BASE64Encoder encoder = new BASE64Encoder();
                String image = encoder.encode(mpf.getBytes());
                boolean imageFlag = CommUtil.base64ToImage(image, url);
                if (!imageFlag) {
                    //失败
                    return R.error();
                }
                return R.ok().put("url", absPath);
            } catch (IOException e) {
                return R.error();
            }
        }
        return R.error();
    }
}
