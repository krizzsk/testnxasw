package com.didi.dimina.container.p065ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.Dimina;
import com.taxis99.R;
import java.io.File;

/* renamed from: com.didi.dimina.container.ui.dialog.ImageCloseView */
public class ImageCloseView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f19450a;

    /* renamed from: b */
    private ImageView f19451b;

    /* renamed from: c */
    private OnImageCloseClickListener f19452c;

    /* renamed from: com.didi.dimina.container.ui.dialog.ImageCloseView$OnImageCloseClickListener */
    public interface OnImageCloseClickListener {
        void onClick();

        void onClose();
    }

    public ImageCloseView(Context context) {
        super(context);
        m16523a();
    }

    public ImageCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16523a();
    }

    public ImageCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16523a();
    }

    /* renamed from: a */
    private void m16523a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_image_close_view, this);
        this.f19450a = (ImageView) findViewById(R.id.image);
        this.f19451b = (ImageView) findViewById(R.id.close);
        this.f19450a.setOnClickListener(this);
        this.f19451b.setOnClickListener(this);
    }

    public void setClickListener(OnImageCloseClickListener onImageCloseClickListener) {
        this.f19452c = onImageCloseClickListener;
    }

    public void setImageUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http")) {
                Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(getContext(), str, 0, this.f19450a);
            }
            if (str.startsWith("/")) {
                Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(getContext(), new File(str), this.f19450a);
            }
        }
    }

    public void onClick(View view) {
        OnImageCloseClickListener onImageCloseClickListener;
        OnImageCloseClickListener onImageCloseClickListener2;
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f19450a && (onImageCloseClickListener2 = this.f19452c) != null) {
            onImageCloseClickListener2.onClick();
        }
        if (view == this.f19451b && (onImageCloseClickListener = this.f19452c) != null) {
            onImageCloseClickListener.onClose();
        }
    }
}
