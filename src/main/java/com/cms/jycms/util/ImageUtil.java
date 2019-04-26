package com.cms.jycms.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class ImageUtil {

    public static void saveImage(MultipartFile file, String path) throws IOException {
        // 生成图片
        BASE64Encoder encoder = new BASE64Encoder();
        String image = encoder.encode(file.getBytes());
        boolean imageFlag = CommUtil.base64ToImage(image, path);
        if (!imageFlag) {
            //失败
            throw new IOException("存储图片失败");
        }

    }

}
