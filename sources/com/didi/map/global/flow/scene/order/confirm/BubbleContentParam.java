package com.didi.map.global.flow.scene.order.confirm;

import android.text.SpannableString;
import android.view.View;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.InfoWindow;

public class BubbleContentParam {

    /* renamed from: a */
    private boolean f29087a;

    /* renamed from: b */
    private String f29088b;

    /* renamed from: c */
    private SpannableString f29089c;

    /* renamed from: d */
    private View f29090d;

    /* renamed from: e */
    private InfoWindow.Position f29091e;

    /* renamed from: f */
    private OnInfoWindowClickListener f29092f;

    public boolean isLoadingToggle() {
        return this.f29087a;
    }

    public void setLoadingToggle(boolean z) {
        this.f29087a = z;
    }

    public String getContent() {
        return this.f29088b;
    }

    public void setContent(String str) {
        this.f29088b = str;
    }

    public SpannableString getFullTextContent() {
        return this.f29089c;
    }

    public void setFullTextContent(SpannableString spannableString) {
        this.f29089c = spannableString;
    }

    public View getContentView() {
        return this.f29090d;
    }

    public void setContentView(View view) {
        this.f29090d = view;
    }

    public InfoWindow.Position getPosition() {
        return this.f29091e;
    }

    public void setPosition(InfoWindow.Position position) {
        this.f29091e = position;
    }

    public OnInfoWindowClickListener getClickListener() {
        return this.f29092f;
    }

    public void setClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f29092f = onInfoWindowClickListener;
    }
}
