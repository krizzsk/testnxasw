package com.didi.component.common.widget.loading;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class DataLoadingView extends FrameLayout implements IDataLoadingView {

    /* renamed from: a */
    private ImageView f13899a;

    /* renamed from: b */
    private TextView f13900b;

    /* renamed from: c */
    private TextView f13901c;

    /* renamed from: d */
    private AnimationDrawable f13902d;

    /* renamed from: e */
    private State f13903e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnRetryListener f13904f;

    enum State {
        Loading,
        Retry,
        Fail
    }

    public View getView() {
        return this;
    }

    public DataLoadingView(Context context) {
        super(context);
        m11517a();
    }

    public DataLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11517a();
    }

    public DataLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11517a();
    }

    public void setId(int i) {
        super.setId(i);
    }

    /* renamed from: a */
    private void m11517a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_comp_view_data_loading, this);
        this.f13899a = (ImageView) findViewById(R.id.iv_loading);
        this.f13900b = (TextView) findViewById(R.id.tv_retry);
        this.f13901c = (TextView) findViewById(R.id.tv_fail);
        this.f13902d = (AnimationDrawable) this.f13899a.getDrawable();
        showLoading();
        this.f13900b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DataLoadingView.this.f13904f != null) {
                    DataLoadingView.this.f13904f.onRetry();
                }
            }
        });
    }

    public void showLoading() {
        if (this.f13903e != State.Loading) {
            this.f13899a.setVisibility(0);
            this.f13900b.setVisibility(8);
            this.f13901c.setVisibility(8);
            this.f13902d.start();
            this.f13903e = State.Loading;
        }
    }

    public void showRetry() {
        if (this.f13903e != State.Retry) {
            this.f13902d.stop();
            this.f13899a.setVisibility(8);
            this.f13900b.setVisibility(0);
            this.f13901c.setVisibility(8);
            this.f13903e = State.Retry;
        }
    }

    public void showFail(String str) {
        if (this.f13903e != State.Fail) {
            this.f13902d.stop();
            this.f13899a.setVisibility(8);
            this.f13900b.setVisibility(8);
            this.f13901c.setVisibility(0);
            this.f13903e = State.Fail;
            this.f13901c.setText(str);
        }
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        this.f13904f = onRetryListener;
    }
}
