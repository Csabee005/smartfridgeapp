package com.kmooc.smartfridgeapp.com.szak.util.image;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.kmooc.smartfridgeapp.R;

public enum ProductImageType {
    APPLE, BANANA, GUAVA, KIWI, ORANGE, PEACH, PEAR, PLUM, TOMATO, EGGCONTAINER;

    private Drawable drawableSource;
    static {
        APPLE.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_apple_red);
        BANANA.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_banana);
        GUAVA.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_guava);
        KIWI.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_kiwi);
        ORANGE.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_orange);
        PEACH.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_peach);
        PEAR.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_pear);
        PLUM.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_plum);
        TOMATO.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_tomato);
        EGGCONTAINER.drawableSource = Resources.getSystem().getDrawable(R.mipmap.ic_eggcontainer);

    }

    public Drawable getDrawableSource() {
        return this.drawableSource;
    }
}