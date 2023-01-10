package com.didi.component.pudo.newversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.pudo.AbsPudoPresenter;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class ConfirmGetOnPudoView extends AbsPudoView {

    /* renamed from: a */
    private Context f17089a;

    /* renamed from: b */
    private AbsPudoPresenter f17090b;

    /* renamed from: c */
    private View f17091c;

    /* renamed from: d */
    private FrameLayout f17092d;

    public ConfirmGetOnPudoView(Context context, ViewGroup viewGroup) {
        this.f17089a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_confirm_pudo_layout_new_ui, viewGroup, false);
        this.f17091c = inflate;
        this.f17092d = (FrameLayout) inflate.findViewById(R.id.fence_card_container);
    }

    public View getView() {
        return this.f17091c;
    }

    public void setPresenter(AbsPudoPresenter absPudoPresenter) {
        this.f17090b = absPudoPresenter;
    }

    public void setFenceCardView(View view) {
        if (this.f17092d != null && view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f17092d.removeAllViews();
            this.f17092d.addView(view);
            DIDIFontUtils.Companion.updateViewGroupTypeface(view);
        }
    }
}
