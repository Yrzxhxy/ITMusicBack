package com.javaclimb.itmusic.common;

import java.util.UUID;

public class RandomID {
    public String generateRandomFileName(String originalFileName) {
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String randomName = UUID.randomUUID().toString() + extension;
        return randomName;
    }
}
