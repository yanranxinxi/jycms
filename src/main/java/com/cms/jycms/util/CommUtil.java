package com.cms.jycms.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommUtil {
    public static boolean base64ToImage(String imageIo, String path){
        boolean imageFlag = false;
        FileOutputStream fileOutputStream = null;
        try {
            //把加密的图片流解密成字符
            byte[] faceBytes = Base64.decodeBase64(imageIo);
            // 生成图片
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(path);
            IOUtils.write(faceBytes, fileOutputStream);
            imageFlag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fileOutputStream);
        }
        return imageFlag;
    }
}
