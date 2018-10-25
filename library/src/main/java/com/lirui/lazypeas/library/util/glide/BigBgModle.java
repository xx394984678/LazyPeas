package com.lirui.lazypeas.library.util.glide;

public class BigBgModle implements GlideLoadMoudle{

    private String baseImgUrl;

    public BigBgModle(String baseImgUrl) {
        this.baseImgUrl = baseImgUrl;
    }

    @Override
    public String requestCustomSizeUrl(int width, int height) {
        return null;
    }
}
