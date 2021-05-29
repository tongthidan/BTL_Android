package com.example.app_btl.service.model;

import java.io.IOException;

public enum AccessViewStatus {
    NONE, SAMPLE;

    public String toValue() {
        switch (this) {
            case NONE: return "NONE";
            case SAMPLE: return "SAMPLE";
        }
        return null;
    }

    public static AccessViewStatus forValue(String value) throws IOException {
        if (value.equals("NONE")) return NONE;
        if (value.equals("SAMPLE")) return SAMPLE;
        throw new IOException("Cannot deserialize AccessViewStatus");
    }
}