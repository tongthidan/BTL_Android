package com.example.app_btl.service.model;

import java.io.IOException;

public enum Type {
    ISBN_10, ISBN_13;

    public String toValue() {
        switch (this) {
            case ISBN_10: return "ISBN_10";
            case ISBN_13: return "ISBN_13";
        }
        return null;
    }

    public static Type forValue(String value) throws IOException {
        if (value.equals("ISBN_10")) return ISBN_10;
        if (value.equals("ISBN_13")) return ISBN_13;
        throw new IOException("Cannot deserialize Type");
    }
}

