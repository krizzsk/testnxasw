package com.didi.dimina.container.p065ui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.didi.dimina.container.util.PixUtil;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.refresh.TextOverView */
public class TextOverView extends AbsOverView {

    /* renamed from: a */
    private TextView f19558a;

    /* renamed from: b */
    private View f19559b;

    /* access modifiers changed from: protected */
    public void onScroll(int i, int i2) {
    }

    public TextOverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TextOverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextOverView(Context context) {
        super(context);
    }

    public void init() {
        this.mPullRefreshHeight = PixUtil.dip2px(getContext(), 88.0f);
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_refresh_overview, this, true);
        this.f19558a = (TextView) findViewById(R.id.text);
        this.f19559b = findViewById(R.id.iv_rotate);
        setLayoutParams(new ViewGroup.LayoutParams(-1, this.mPullRefreshHeight));
    }

    public void onVisible() {
        this.f19558a.setText("下拉刷新");
    }

    public void onOver() {
        this.f19558a.setText("松开立即刷新");
    }

    public void onRefresh() {
        this.f19558a.setText("正在刷新...");
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dimina_refresh_anim);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.f19559b.startAnimation(loadAnimation);
    }

    public void onFinish() {
        this.f19559b.clearAnimation();
    }
}
