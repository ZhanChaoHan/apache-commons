package com.jachs.commons.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Demo {

    public static void main ( String[] args ) {
        String input = "Hello, world!";
        String md5 = getMD5(input);
        System.out.println("MD5 hash of \"" + input + "\" is: " + md5);
    }
    
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
