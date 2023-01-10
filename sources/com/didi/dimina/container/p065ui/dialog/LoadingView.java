package com.didi.dimina.container.p065ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.dimina.container.util.PixUtil;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.dialog.LoadingView */
public class LoadingView extends FrameLayout {

    /* renamed from: a */
    private TextView f19457a;

    /* renamed from: b */
    private ProgressBar f19458b;

    public LoadingView(Context context) {
        super(context);
        m16526a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16526a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16526a();
    }

    /* renamed from: a */
    private void m16526a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_loading_view, this);
        this.f19457a = (TextView) findViewById(R.id.tv_msg);
        this.f19458b = (ProgressBar) findViewById(R.id.progress_bar);
    }

    public void setMessage(String str) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19458b.getLayoutParams();
        if (TextUtils.isEmpty(str)) {
            this.f19457a.setVisibility(8);
            layoutParams.topMargin = PixUtil.dip2px(getContext(), 0.0f);
            return;
        }
        layoutParams.topMargin = PixUtil.dip2px(getContext(), 22.0f);
        this.f19457a.setVisibility(0);
        this.f19457a.setText(str);
    }
}
