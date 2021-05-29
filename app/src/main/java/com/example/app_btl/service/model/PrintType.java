package com.example.app_btl.service.model;

import java.io.IOException;

public enum PrintType {
    BOOK;

    public String toValue() {
        switch (this) {
            case BOOK: return "BOOK";
        }
        return null;
    }

    public static PrintType forValue(String value) throws IOException {
        if (value.equals("BOOK")) return BOOK;
        throw new IOException("Cannot deserialize PrintType");
    }
}

