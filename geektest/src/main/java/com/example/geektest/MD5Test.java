package com.example.geektest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


/**
 * Created by  on 2021/6/4.
 **/
public class MD5Test {

    private static  String s1="d131dd02c5e6eec4693d9a0698aff95c2fcab58712467eab4004583eb8fb7f8955ad340609f4b30283e488832571415a085125e8f7cdc99fd91dbdf280373c5bd8823e3156348f5bae6dacd436c919c6dd53e2b487da03fd02396306d248cda0e99f33420f577ee8ce54b67080a80d1ec69821bcb6a8839396f9652b6ff72a70";
    private  static String s2="d131dd02c5e6eec4693d9a0698aff95c2fcab50712467eab4004583eb8fb7f8955ad340609f4b30283e4888325f1415a085125e8f7cdc99fd91dbd7280373c5bd8823e3156348f5bae6dacd436c919c6dd53e23487da03fd02396306d248cda0e99f33420f577ee8ce54b67080280d1ec69821bcb6a8839396f965ab6ff72a70";

    public static void main(String[] args) {

        for (int i = 0; i < s1.length(); i++) {
            char chr1=s1.charAt(i);
            char chr2=s2.charAt(i);
            if (chr1!=chr2){
                System.out.print(" index"+i+":"+chr1+";"+chr2);
            }
        }
        System.out.println("");
        String r1=md5(s1);
        String  r2=md5(s2);
        //79054025255fb1a26e4bc422aef54eb4
        System.out.println(r1);
        System.out.println(r2);
    }
    private static MessageDigest md5;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public final static String md52(String jiami) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = jiami.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static  String  md5(String str){
        try {
            try {
                byte[] bs = md5.digest(str.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder(32);
                for (byte x : bs) {
                    if ((x & 0xff) >> 4 == 0) {
                        sb.append("0").append(Integer.toHexString(x & 0xff));
                    } else {
                        sb.append(Integer.toHexString(x & 0xff));
                    }
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    return "";
    }
}

