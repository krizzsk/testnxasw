package rui.config.model.resource;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import rui.config.model.color.IRModelColor;

public class ResDrawable implements IRModelColor {

    /* renamed from: a */
    private String f8597a;

    /* renamed from: b */
    private int f8598b;

    /* renamed from: c */
    private Drawable f8599c;

    /* renamed from: d */
    private Uri f8600d;

    public ResDrawable(String str, int i, Drawable drawable, Uri uri) {
        this.f8597a = str;
        this.f8598b = i;
        this.f8599c = drawable;
        this.f8600d = uri;
    }

    public String getResName() {
        return this.f8597a;
    }

    public int getResId() {
        return this.f8598b;
    }

    public Drawable getResDrawable() {
        return this.f8599c;
    }

    public Uri getResUri() {
        return this.f8600d;
    }
}
