package com.example.app_btl.service.model;


import java.util.List;

public class SaleInfo {
    private Country country;
    private Saleability saleability;
    private boolean isEbook;
    private SaleInfoListPrice listPrice;
    private SaleInfoListPrice retailPrice;
    private String buyLink;
    private List<Offer> offers;

    public Country getCountry() { return country; }
    public void setCountry(Country value) { this.country = value; }

    public Saleability getSaleability() { return saleability; }
    public void setSaleability(Saleability value) { this.saleability = value; }

    public boolean getIsEbook() { return isEbook; }
    public void setIsEbook(boolean value) { this.isEbook = value; }

    public SaleInfoListPrice getListPrice() { return listPrice; }
    public void setListPrice(SaleInfoListPrice value) { this.listPrice = value; }

    public SaleInfoListPrice getRetailPrice() { return retailPrice; }
    public void setRetailPrice(SaleInfoListPrice value) { this.retailPrice = value; }

    public String getBuyLink() { return buyLink; }
    public void setBuyLink(String value) { this.buyLink = value; }

    public List<Offer> getOffers() { return offers; }
    public void setOffers(List<Offer> value) { this.offers = value; }
}
