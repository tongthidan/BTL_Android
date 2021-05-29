package com.example.app_btl.service.model;

public class Item {
    private Kind kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;
    private SaleInfo saleInfo;
    private AccessInfo accessInfo;
    private SearchInfo searchInfo;

    public Kind getKind() { return kind; }
    public void setKind(Kind value) { this.kind = value; }

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getEtag() { return etag; }
    public void setEtag(String value) { this.etag = value; }

    public String getSelfLink() { return selfLink; }
    public void setSelfLink(String value) { this.selfLink = value; }

    public VolumeInfo getVolumeInfo() { return volumeInfo; }
    public void setVolumeInfo(VolumeInfo value) { this.volumeInfo = value; }

    public SaleInfo getSaleInfo() { return saleInfo; }
    public void setSaleInfo(SaleInfo value) { this.saleInfo = value; }

    public AccessInfo getAccessInfo() { return accessInfo; }
    public void setAccessInfo(AccessInfo value) { this.accessInfo = value; }

    public SearchInfo getSearchInfo() { return searchInfo; }
    public void setSearchInfo(SearchInfo value) { this.searchInfo = value; }
}