package com.cms.jycms.controller.admin;

import com.cms.jycms.common.R;
import com.cms.jycms.dto.ImageNameDTO;
import com.cms.jycms.util.CommUtil;
import com.cms.jycms.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/admin/api/uploadFile")
public class UploadFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

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
            try {
                mpf = request.getFile(itr.next());
                String absPath = "/" + imagesDir + "/" + LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/"
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")) + "."
                        + mpf.getOriginalFilename().substring((mpf.getOriginalFilename().indexOf(".") + 1));
                String url = uploadFilePath + absPath;

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
                LOGGER.error("add", e);
                return R.error();
            }
        }
        return R.error();
    }

    @PostMapping("batchAdd")
    public R batchAdd(MultipartHttpServletRequest request) {
        List<ImageNameDTO> result = new ArrayList<>();
        List<MultipartFile> files = request.getFiles("files[]");
        Iterator<MultipartFile> itr = files.iterator();
        MultipartFile mpf;
        //上传路径
        while (itr.hasNext()) {
            try {
                mpf = itr.next();
                String absPath = "/" + imagesDir + "/" + LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/"
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")) + result.size() + "."
                        + mpf.getOriginalFilename().substring((mpf.getOriginalFilename().indexOf(".") + 1));
                String url = uploadFilePath + absPath;

                ImageUtil.saveImage(mpf, url);
                ImageNameDTO imageNameDTO = new ImageNameDTO();
                imageNameDTO.setName(mpf.getOriginalFilename().substring(0, mpf.getOriginalFilename().indexOf(".")));
                imageNameDTO.setUrl(absPath);
                result.add(imageNameDTO);
            } catch (IOException e) {
                LOGGER.error("batchAdd#ImageUtil.saveImage", e);
                return R.error();
            }
        }
        return R.ok().put("files", result);
    }

}
