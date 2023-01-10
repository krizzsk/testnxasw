package com.didi.dimina.container.p065ui.title;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.service.ImageLoaderService;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.title.ImageTextButton */
public class ImageTextButton extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f19717a;

    /* renamed from: b */
    private TextView f19718b;

    public ImageTextButton(Context context) {
        super(context);
        m16791a();
    }

    public ImageTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16791a();
    }

    public ImageTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16791a();
    }

    /* renamed from: a */
    private void m16791a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_image_button, this);
        this.f19717a = (ImageView) findViewById(R.id.dimina_image_button_iv);
        this.f19718b = (TextView) findViewById(R.id.dimina_image_button_bt);
    }

    public TextView getTextView() {
        return this.f19718b;
    }

    public void showText(String str) {
        this.f19718b.setVisibility(0);
        this.f19717a.setVisibility(8);
        this.f19718b.setText(str);
    }

    public void showImage(String str) {
        this.f19718b.setVisibility(8);
        this.f19717a.setVisibility(0);
        Dimina.getConfig().getAdapterConfig().getImageLoaderService().load(getContext(), str, (ImageLoaderService.FinishBitmapListener) new ImageLoaderService.FinishBitmapListener() {
            public void onBitmapFinish(Bitmap bitmap) {
                ImageTextButton.this.f19717a.setImageBitmap(bitmap);
            }
        });
    }
}
