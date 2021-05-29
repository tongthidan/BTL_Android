package com.example.app_btl.service.model;

import java.io.IOException;

public enum Country {
    SG;

    public String toValue() {
        switch (this) {
            case SG: return "SG";
        }
        return null;
    }

    public static Country forValue(String value) throws IOException {
        if (value.equals("SG")) return SG;
        throw new IOException("Cannot deserialize Country");
    }
}