package com.example.app_btl.service.model;

import java.io.IOException;

public enum Language {
    EN, UN;

    public String toValue() {
        switch (this) {
            case EN: return "en";
            case UN: return "un";
        }
        return null;
    }

    public static Language forValue(String value) throws IOException {
        if (value.equals("en")) return EN;
        if (value.equals("un")) return UN;
        throw new IOException("Cannot deserialize Language");
    }
}
