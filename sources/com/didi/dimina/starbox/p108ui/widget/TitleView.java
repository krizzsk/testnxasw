package com.didi.dimina.starbox.p108ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C11267R;
import com.taxis99.R;

/* renamed from: com.didi.dimina.starbox.ui.widget.TitleView */
public class TitleView extends FrameLayout {

    /* renamed from: a */
    private final TextView f20009a;

    public TitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.dimina_starbox_kit_layout_title, this, true);
        TextView textView = (TextView) findViewById(R.id.tv_back);
        this.f20009a = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((Activity) context).finish();
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.TitleView);
            this.f20009a.setText(obtainStyledAttributes.getString(0));
            obtainStyledAttributes.recycle();
        }
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f20009a.setText("返回");
            return;
        }
        this.f20009a.setText(str);
        this.f20009a.setAlpha(0.0f);
        this.f20009a.setVisibility(0);
        this.f20009a.animate().alpha(1.0f).start();
    }
}
