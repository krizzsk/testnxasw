package com.didi.app.nova.skeleton.image.glide.internal;

import android.net.Uri;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.app.nova.skeleton.image.glide.internal.DiFitUriLoader;

public class SodaUrl {

    /* renamed from: a */
    private GlideUrl f10305a;

    /* renamed from: b */
    private DiFitUriLoader.FitSize f10306b;

    public SodaUrl(Uri uri, DiFitUriLoader.FitSize fitSize) {
        this.f10305a = new GlideUrl(uri.toString());
        this.f10306b = fitSize;
    }

    public GlideUrl getSourceUrl() {
        return this.f10305a;
    }

    public DiFitUriLoader.FitSize getFitSize() {
        return this.f10306b;
    }

    public GlideUrl getResizeUrl() {
        if (this.f10306b == null) {
            return this.f10305a;
        }
        return new GlideUrl(this.f10305a.toStringUrl() + "!" + this.f10306b.width() + "x" + this.f10306b.height() + "_m");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SodaUrl)) {
            return false;
        }
        SodaUrl sodaUrl = (SodaUrl) obj;
        if (!this.f10305a.equals(sodaUrl.f10305a) || !DiFitUriLoader.isEqualsSize(this.f10306b, sodaUrl.getFitSize())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.f10305a.hashCode() + 31;
        DiFitUriLoader.FitSize fitSize = this.f10306b;
        return hashCode + (fitSize == null ? 0 : fitSize.width() * this.f10306b.height());
    }
}
