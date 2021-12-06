package com.yuan.practice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Yuan
 */
public class MD5Util {
    public static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(str.getBytes());
            byte[] mdBytes = md.digest();
            StringBuilder hash = new StringBuilder();
            for (byte mdByte : mdBytes) {
                int temp;
                if (mdByte < 0) {
                    temp = 256 + mdByte;
                } else {
                    temp = mdByte;
                }
                if (temp < 16) {
                    hash.append("0");
                }
                hash.append(Integer.toString(temp, 16));
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
