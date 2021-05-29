package com.example.app_btl.service.model;

import java.io.IOException;

public enum Kind {
    BOOKS_VOLUME;

    public String toValue() {
        switch (this) {
            case BOOKS_VOLUME: return "books#volume";
        }
        return null;
    }

    public static Kind forValue(String value) throws IOException {
        if (value.equals("books#volume")) return BOOKS_VOLUME;
        throw new IOException("Cannot deserialize Kind");
    }
}
