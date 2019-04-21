package com.cms.jycms.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class Md5Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Md5Util.class);

    public static String sign(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return byteToStringHex(md.digest());
        } catch (Exception e) {
            LOGGER.error("sign", e);
        }
        return null;
    }

    private static String byteToStringHex(byte[] result) {
        StringBuffer sb = new StringBuffer();
        for (byte element : result) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString().toUpperCase();
    }

}
