package com.myappinterns;

public class Bean {
    String strLang;
    int imgLang;

    public Bean(String strLang, int imgLang) {

        this.strLang = strLang;
        this.imgLang = imgLang;
    }

    public String getStrLang() {
        return strLang;
    }

    public void setStrLang(String strLang) {
        this.strLang = strLang;
    }

    public int getImgLang() {
        return imgLang;
    }

    public void setImgLang(int imgLang) {
        this.imgLang = imgLang;
    }
}
