package com.example.app_btl.service.model;

import java.io.IOException;

public enum  TextToSpeechPermission {
    ALLOWED, ALLOWED_FOR_ACCESSIBILITY;

    public String toValue() {
        switch (this) {
            case ALLOWED: return "ALLOWED";
            case ALLOWED_FOR_ACCESSIBILITY: return "ALLOWED_FOR_ACCESSIBILITY";
        }
        return null;
    }

    public static TextToSpeechPermission forValue(String value) throws IOException {
        if (value.equals("ALLOWED")) return ALLOWED;
        if (value.equals("ALLOWED_FOR_ACCESSIBILITY")) return ALLOWED_FOR_ACCESSIBILITY;
        throw new IOException("Cannot deserialize TextToSpeechPermission");
    }

}

