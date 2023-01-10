package com.didi.entrega.customer.widget.countdown;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.work.PeriodicWorkRequest;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.passenger.C11267R;
import java.util.ArrayList;
import java.util.List;

public class CountDownTextView extends CustomerAppCompatTextView {

    /* renamed from: a */
    private long f22231a = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;

    /* renamed from: b */
    private long f22232b = 1000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f22233c = "mm:ss";

    /* renamed from: d */
    private boolean f22234d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f22235e = "";

    /* renamed from: f */
    private CountDownTimer f22236f;

    /* renamed from: g */
    private boolean f22237g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CountTimeoutListener f22238h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f22239i = false;
    protected List<BaseBackgroundSpan> mBackSpanList;
    protected char[] mNonNumbers;
    protected String[] mNumbers;
    protected List<ForegroundColorSpan> mTextColorSpanList;

    public interface CountTimeoutListener {
        void onCountTimeout();
    }

    public CountDownTextView(Context context) {
        super(context);
        m18349a(context, (AttributeSet) null);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18349a(context, attributeSet);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18349a(context, attributeSet);
    }

    public void addCountFinishCallback(CountTimeoutListener countTimeoutListener) {
        this.f22238h = countTimeoutListener;
    }

    public void cancel() {
        this.f22237g = false;
        CountDownTimer countDownTimer = this.f22236f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f22236f = null;
            this.f22238h = null;
        }
    }

    public char[] getNonNumInTimerStr(String str) {
        return str.replaceAll("\\d", "").toCharArray();
    }

    public String[] getNumInTimerStr(String str) {
        return str.split("[^\\d]");
    }

    public boolean isCounting() {
        return this.f22237g;
    }

    public void removeCountFinishCallback() {
        this.f22238h = null;
    }

    public void setBackgroundSpan(String str) {
        if (!this.f22234d) {
            m18350a(str);
            this.f22234d = true;
        }
        setText(str);
    }

    public void start(long j) {
        if (!this.f22237g) {
            this.f22231a = Math.max(0, (j * 1000) - System.currentTimeMillis());
            this.f22237g = true;
            getTimer().start();
        }
    }

    /* renamed from: a */
    private void m18349a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaCountDownTextView);
        try {
            this.f22231a = (long) obtainStyledAttributes.getInt(0, 900000);
            this.f22232b = (long) obtainStyledAttributes.getInt(1, 1000);
            this.mBackSpanList = new ArrayList();
            this.mTextColorSpanList = new ArrayList();
        } finally {
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: a */
    private void m18350a(String str) {
        this.mNumbers = getNumInTimerStr(str);
        this.mNonNumbers = getNonNumInTimerStr(str);
    }

    private CountDownTimer getTimer() {
        if (this.f22236f == null) {
            this.f22236f = new CountDownTimer(this.f22231a, this.f22232b) {
                public void onFinish() {
                    CountDownTextView countDownTextView = CountDownTextView.this;
                    String unused = countDownTextView.f22235e = DurationFormatUtils.formatDuration(0, countDownTextView.f22233c);
                    CountDownTextView countDownTextView2 = CountDownTextView.this;
                    countDownTextView2.setBackgroundSpan(countDownTextView2.f22235e);
                    if (CountDownTextView.this.f22238h != null && !CountDownTextView.this.f22239i) {
                        boolean unused2 = CountDownTextView.this.f22239i = true;
                        CountDownTextView.this.f22238h.onCountTimeout();
                        CountTimeoutListener unused3 = CountDownTextView.this.f22238h = null;
                    }
                }

                public void onTick(long j) {
                    boolean unused = CountDownTextView.this.f22239i = false;
                    if (j > 0) {
                        CountDownTextView countDownTextView = CountDownTextView.this;
                        String unused2 = countDownTextView.f22235e = DurationFormatUtils.formatDuration(j, countDownTextView.f22233c);
                        CountDownTextView countDownTextView2 = CountDownTextView.this;
                        countDownTextView2.setBackgroundSpan(countDownTextView2.f22235e);
                    }
                }
            };
        }
        return this.f22236f;
    }
}
