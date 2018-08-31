package luhut.belajar.jepang.com.belajarjepang.model;

import android.graphics.drawable.Drawable;

public class MenuModel {

    private String title, content;
    private Drawable mImage;
    private String codePdf;
    private String codeS;

    public MenuModel(String title, String content, Drawable image, String codePdf, String code){
        this.title = title;
        this.content = content;
        this.mImage = image;
        this.codePdf = codePdf;
        this.codeS = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public void setmImage(Drawable mImage) {
        this.mImage = mImage;
    }

    public String getCodePdf() {
        return codePdf;
    }

    public void setCodePdf(String codePdf) {
        this.codePdf = codePdf;
    }

    public String getCodeS() {
        return codeS;
    }

    public void setCodeS(String codeS) {
        this.codeS = codeS;
    }
}
