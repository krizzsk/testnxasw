package com.didi.global.qrscan;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.global.qrscan.NetWorkReceiver;
import com.didi.sdk.util.Utils;
import com.taxis99.R;

public class NetWorkStatusBar extends LinearLayout {

    /* renamed from: a */
    private NetWorkReceiver f24816a = NetWorkReceiver.getInstance();

    /* renamed from: b */
    private TextView f24817b;

    /* renamed from: c */
    private String f24818c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f24819d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnViewVisibilityChangeListener f24820e;

    /* renamed from: f */
    private NetWorkReceiver.NetWorkChangedListener f24821f = new NetWorkReceiver.NetWorkChangedListener() {
        public void onChanged(int i) {
            boolean unused = NetWorkStatusBar.this.f24819d = i != 0;
            NetWorkStatusBar.this.m19895b();
        }
    };

    public interface OnViewVisibilityChangeListener {
        void onNetWorkStateChanged(View view);
    }

    public void setOnViewVisibilityChangeListener(OnViewVisibilityChangeListener onViewVisibilityChangeListener) {
        this.f24820e = onViewVisibilityChangeListener;
    }

    public NetWorkStatusBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24818c = context.getString(R.string.common_network_disabled);
        LayoutInflater.from(getContext()).inflate(R.layout.global_qrcode_scanner_network_new, this, true);
        TextView textView = (TextView) findViewById(R.id.textviewStatus);
        this.f24817b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NetWorkStatusBar.this.m19896c();
            }
        });
    }

    public void setVisibility(int i) {
        if (i == 0) {
            super.setVisibility(i);
            OnViewVisibilityChangeListener onViewVisibilityChangeListener = this.f24820e;
            if (onViewVisibilityChangeListener != null) {
                onViewVisibilityChangeListener.onNetWorkStateChanged(this);
                return;
            }
            return;
        }
        m19890a();
    }

    /* renamed from: a */
    private void m19890a() {
        if (getVisibility() != 8) {
            clearAnimation();
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(500);
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    NetWorkStatusBar.this.clearAnimation();
                    NetWorkStatusBar.super.setVisibility(8);
                    if (NetWorkStatusBar.this.f24820e != null) {
                        NetWorkStatusBar.this.f24820e.onNetWorkStateChanged(NetWorkStatusBar.this);
                    }
                }
            });
            startAnimation(animationSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19895b() {
        if (!this.f24819d) {
            this.f24817b.setText(this.f24818c);
            this.f24817b.setBackgroundColor(getResources().getColor(R.color.common_disabled_network));
            setVisibility(0);
            setContentDescription(this.f24818c);
            return;
        }
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19896c() {
        getContext().startActivity(new Intent("android.settings.SETTINGS"));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m19898d();
        NetWorkReceiver.getInstance().register(this.f24821f);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getContext().unregisterReceiver(this.f24816a);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        NetWorkReceiver.getInstance().unRegister(this.f24821f);
    }

    /* renamed from: d */
    private void m19898d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            getContext().registerReceiver(this.f24816a, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void refreshOnResume() {
        this.f24819d = Utils.isNetworkConnected(getContext());
        m19895b();
    }
}
