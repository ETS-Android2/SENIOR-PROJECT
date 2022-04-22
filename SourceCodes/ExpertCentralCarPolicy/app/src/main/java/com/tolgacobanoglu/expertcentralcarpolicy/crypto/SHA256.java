package com.tolgacobanoglu.expertcentralcarpolicy.crypto;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256
{

    private static byte[] generateSHA256(String textToHash) throws NoSuchAlgorithmException
    {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(textToHash.getBytes(Charset.defaultCharset()));

        return messageDigest.digest();
    }

    private static final String HEXADECIMALS = "0123456789abcdef";

    private static String convertByteArrayToHexString(byte[] byteArray)
    {

        final StringBuilder hexText = new StringBuilder(2 * byteArray.length);

        for (byte byteElement : byteArray) {
            hexText
                    .append(HEXADECIMALS.charAt((byteElement & 0xF0) >> 4))
                    .append(HEXADECIMALS.charAt((byteElement & 0x0F)));
        }

        return hexText.toString();
    }


    public static String hashString(String text) throws NoSuchAlgorithmException {
        String hashedValue = convertByteArrayToHexString(generateSHA256(text));
        return hashedValue;
    }
}