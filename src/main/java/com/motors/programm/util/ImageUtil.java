package com.motors.programm.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public final class ImageUtil {
    private static ImageUtil instance = null;

    private ImageUtil() {
    }

    public static ImageUtil getInstance() {
        if (instance == null) {
            instance = new ImageUtil();
        }
        return instance;
    }

    /**
     * Encode byte image to byte string ISO-8859-2
     *
     * @param image
     * @param ifNull
     * @return
     */
    public String getEncoded(byte[] image, String ifNull) {
        try {
            return new String(Base64.encodeBase64(image), "ISO-8859-2");
        } catch (UnsupportedEncodingException e) {
            return ifNull;
        }
    }
}
