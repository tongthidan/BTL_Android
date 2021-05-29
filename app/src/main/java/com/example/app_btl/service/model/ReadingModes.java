package com.example.app_btl.service.model;

public class ReadingModes {
    private boolean text;
    private boolean image;

    public boolean getText() { return text; }
    public void setText(boolean value) { this.text = value; }

    public boolean getImage() { return image; }
    public void setImage(boolean value) { this.image = value; }
}