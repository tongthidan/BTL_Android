package com.example.app_btl.service.model;

import java.io.IOException;

public enum Viewability {
    NO_PAGES, PARTIAL;

    public String toValue() {
        switch (this) {
            case NO_PAGES: return "NO_PAGES";
            case PARTIAL: return "PARTIAL";
        }
        return null;
    }

    public static Viewability forValue(String value) throws IOException {
        if (value.equals("NO_PAGES")) return NO_PAGES;
        if (value.equals("PARTIAL")) return PARTIAL;
        throw new IOException("Cannot deserialize Viewability");
    }
}
