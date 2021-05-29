package com.example.app_btl.service.model;

public class Offer {
    private long finskyOfferType;
    private OfferListPrice listPrice;
    private OfferListPrice retailPrice;

    public long getFinskyOfferType() { return finskyOfferType; }
    public void setFinskyOfferType(long value) { this.finskyOfferType = value; }

    public OfferListPrice getListPrice() { return listPrice; }
    public void setListPrice(OfferListPrice value) { this.listPrice = value; }

    public OfferListPrice getRetailPrice() { return retailPrice; }
    public void setRetailPrice(OfferListPrice value) { this.retailPrice = value; }
}
