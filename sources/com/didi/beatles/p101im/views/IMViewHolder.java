package com.didi.beatles.p101im.views;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;

/* renamed from: com.didi.beatles.im.views.IMViewHolder */
public class IMViewHolder extends RecyclerView.ViewHolder {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_EXTEND = 1;
    public static final int TYPE_PLUGIN = 2;

    /* renamed from: a */
    private int f11801a = 0;
    public IMBaseRenderView mRenderView;

    public IMViewHolder(View view) {
        super(view);
        this.mRenderView = (IMBaseRenderView) view;
    }

    public void setType(int i) {
        this.f11801a = i;
    }

    public boolean isExtendType() {
        return this.f11801a == 1;
    }

    public boolean isPluginType() {
        return this.f11801a == 2;
    }
}
