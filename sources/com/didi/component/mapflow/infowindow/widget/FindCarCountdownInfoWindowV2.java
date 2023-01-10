package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.component.business.util.FormatUtils;
import com.didi.component.mapflow.infowindow.callback.CountDownCallback;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;

public final class FindCarCountdownInfoWindowV2 extends RelativeLayout implements ICountDownInfoWindow {
    public static final int DEFALUT_COUNT_DOWN_INTERVAL = 1;

    /* renamed from: a */
    private int f16129a;

    /* renamed from: b */
    private int f16130b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f16131c;

    /* renamed from: d */
    private boolean f16132d = false;

    /* renamed from: e */
    private RoundRctProgress f16133e;

    /* renamed from: f */
    private Context f16134f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CountDownCallback f16135g;

    /* renamed from: h */
    private CountDownTimer f16136h;

    public FindCarCountdownInfoWindowV2(Context context) {
        super(context);
        m13332a(context);
    }

    public FindCarCountdownInfoWindowV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13332a(context);
    }

    public FindCarCountdownInfoWindowV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13332a(context);
    }

    public FindCarCountdownInfoWindowV2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m13332a(context);
    }

    /* renamed from: a */
    private void m13332a(Context context) {
        inflate(context, R.layout.global_iw_find_car_count_down_v2, this);
        this.f16134f = context;
        this.f16133e = (RoundRctProgress) findViewById(R.id.count_down);
    }

    public void init(int i, int i2, int i3, CountDownCallback countDownCallback) {
        if (i > 0) {
            this.f16129a = i;
            this.f16130b = i3;
            this.f16135g = countDownCallback;
            this.f16131c = i2;
            this.f16136h = new CountDownTimer((long) (this.f16131c * 1000), (long) (i3 * 1000)) {
                public void onTick(long j) {
                    int unused = FindCarCountdownInfoWindowV2.this.f16131c = (int) (j / 1000);
                    FindCarCountdownInfoWindowV2.this.m13331a();
                    if (FindCarCountdownInfoWindowV2.this.f16135g != null) {
                        FindCarCountdownInfoWindowV2.this.f16135g.onTick((long) FindCarCountdownInfoWindowV2.this.f16131c);
                    }
                }

                public void onFinish() {
                    int unused = FindCarCountdownInfoWindowV2.this.f16131c = 0;
                    if (FindCarCountdownInfoWindowV2.this.f16135g != null) {
                        FindCarCountdownInfoWindowV2.this.f16135g.onTick((long) FindCarCountdownInfoWindowV2.this.f16131c);
                    }
                    FindCarCountdownInfoWindowV2.this.stop(true);
                }
            };
            this.f16132d = true;
            return;
        }
        throw new RuntimeException("Count must be bigger than 0");
    }

    public void start() {
        m13331a();
        this.f16136h.start();
    }

    public void stop(boolean z) {
        CountDownCallback countDownCallback;
        m13331a();
        CountDownTimer countDownTimer = this.f16136h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (z && (countDownCallback = this.f16135g) != null) {
            countDownCallback.onFinish();
        }
        this.f16132d = false;
    }

    public void restart(int i, int i2, int i3) {
        stop(false);
        this.f16132d = false;
        init(i, i2, i3, this.f16135g);
        start();
    }

    public RoundRctProgress getCountDownProgressBar() {
        return this.f16133e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13331a() {
        if (this.f16132d) {
            int i = this.f16131c;
            int i2 = i / 60;
            int i3 = i % 60;
            this.f16133e.setProgress(100.0f - (((((float) i) * 100.0f) / ((float) this.f16129a)) % 101.0f));
            RoundRctProgress roundRctProgress = this.f16133e;
            roundRctProgress.setText(FormatUtils.formatZeroWhenLessThan10(i2) + "'" + FormatUtils.formatZeroWhenLessThan10(i3) + Const.jsQuote);
            this.f16133e.update();
        }
    }
}
