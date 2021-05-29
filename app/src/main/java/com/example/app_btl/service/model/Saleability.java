package com.example.app_btl.service.model;

import java.io.IOException;

public enum Saleability {
    FOR_SALE, NOT_FOR_SALE;

    public String toValue() {
        switch (this) {
            case FOR_SALE: return "FOR_SALE";
            case NOT_FOR_SALE: return "NOT_FOR_SALE";
        }
        return null;
    }

    public static Saleability forValue(String value) throws IOException {
        if (value.equals("FOR_SALE")) return FOR_SALE;
        if (value.equals("NOT_FOR_SALE")) return NOT_FOR_SALE;
        throw new IOException("Cannot deserialize Saleability");
    }
}
