package com.codecool.shop.config;

import java.nio.charset.StandardCharsets;

public class Util {

    public String enCodeHU(String text){
        String hunglishString = text;
        byte[] hunglishBytes = hunglishString.getBytes();
        String asciiString = new String(hunglishBytes, StandardCharsets.ISO_8859_1);
        return asciiString;
    }
}
