package com.example.app_btl.service.model;

public class AccessInfo {
    private Country country;
    private Viewability viewability;
    private boolean embeddable;
    private boolean publicDomain;
    private TextToSpeechPermission textToSpeechPermission;
    private Epub epub;
    private Epub pdf;
    private String webReaderLink;
    private AccessViewStatus accessViewStatus;
    private boolean quoteSharingAllowed;

    public Country getCountry() { return country; }
    public void setCountry(Country value) { this.country = value; }

    public Viewability getViewability() { return viewability; }
    public void setViewability(Viewability value) { this.viewability = value; }

    public boolean getEmbeddable() { return embeddable; }
    public void setEmbeddable(boolean value) { this.embeddable = value; }

    public boolean getPublicDomain() { return publicDomain; }
    public void setPublicDomain(boolean value) { this.publicDomain = value; }

    public TextToSpeechPermission getTextToSpeechPermission() { return textToSpeechPermission; }
    public void setTextToSpeechPermission(TextToSpeechPermission value) { this.textToSpeechPermission = value; }

    public Epub getEpub() { return epub; }
    public void setEpub(Epub value) { this.epub = value; }

    public Epub getPDF() { return pdf; }
    public void setPDF(Epub value) { this.pdf = value; }

    public String getWebReaderLink() { return webReaderLink; }
    public void setWebReaderLink(String value) { this.webReaderLink = value; }

    public AccessViewStatus getAccessViewStatus() { return accessViewStatus; }
    public void setAccessViewStatus(AccessViewStatus value) { this.accessViewStatus = value; }

    public boolean getQuoteSharingAllowed() { return quoteSharingAllowed; }
    public void setQuoteSharingAllowed(boolean value) { this.quoteSharingAllowed = value; }
}
