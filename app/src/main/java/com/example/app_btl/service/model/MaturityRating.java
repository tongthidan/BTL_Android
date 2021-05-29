package com.example.app_btl.service.model;

import java.io.IOException;

public enum MaturityRating {
    NOT_MATURE;

    public String toValue() {
        switch (this) {
            case NOT_MATURE: return "NOT_MATURE";
        }
        return null;
    }

    public static MaturityRating forValue(String value) throws IOException {
        if (value.equals("NOT_MATURE")) return NOT_MATURE;
        throw new IOException("Cannot deserialize MaturityRating");
    }
}