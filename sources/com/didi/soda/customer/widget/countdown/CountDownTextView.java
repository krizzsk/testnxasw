package com.didi.soda.customer.widget.countdown;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.work.PeriodicWorkRequest;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.widget.text.RichTextView;
import java.util.ArrayList;
import java.util.List;

public class CountDownTextView extends RichTextView {

    /* renamed from: a */
    private long f44290a = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;

    /* renamed from: b */
    private long f44291b = 1000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f44292c = "mm:ss";

    /* renamed from: d */
    private boolean f44293d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f44294e = "";

    /* renamed from: f */
    private CountDownTimer f44295f;

    /* renamed from: g */
    private boolean f44296g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CountTimeoutListener f44297h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f44298i = false;
    protected List<BaseBackgroundSpan> mBackSpanList;
    protected char[] mNonNumbers;
    protected String[] mNumbers;
    protected List<ForegroundColorSpan> mTextColorSpanList;

    public interface CountTimeoutListener {
        void onCountTimeout();
    }

    public CountDownTextView(Context context) {
        super(context);
        m32936a(context, (AttributeSet) null);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32936a(context, attributeSet);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32936a(context, attributeSet);
    }

    public void addCountFinishCallback(CountTimeoutListener countTimeoutListener) {
        this.f44297h = countTimeoutListener;
    }

    public void cancel() {
        this.f44296g = false;
        CountDownTimer countDownTimer = this.f44295f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f44295f = null;
            this.f44297h = null;
        }
    }

    public char[] getNonNumInTimerStr(String str) {
        return str.replaceAll("\\d", "").toCharArray();
    }

    public String[] getNumInTimerStr(String str) {
        return str.split("[^\\d]");
    }

    public boolean isCounting() {
        return this.f44296g;
    }

    public void removeCountFinishCallback() {
        this.f44297h = null;
    }

    public void setBackgroundSpan(String str) {
        if (!this.f44293d) {
            m32937a(str);
            this.f44293d = true;
        }
        setText(str);
    }

    public void start(long j) {
        if (!this.f44296g) {
            this.f44290a = Math.max(0, (j * 1000) - System.currentTimeMillis());
            this.f44296g = true;
            getTimer().start();
        }
    }

    /* renamed from: a */
    private void m32936a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CountDownTextView);
        try {
            this.f44290a = (long) obtainStyledAttributes.getInt(0, 900000);
            this.f44291b = (long) obtainStyledAttributes.getInt(1, 1000);
            this.mBackSpanList = new ArrayList();
            this.mTextColorSpanList = new ArrayList();
        } finally {
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: a */
    private void m32937a(String str) {
        this.mNumbers = getNumInTimerStr(str);
        this.mNonNumbers = getNonNumInTimerStr(str);
    }

    private CountDownTimer getTimer() {
        if (this.f44295f == null) {
            this.f44295f = new CountDownTimer(this.f44290a, this.f44291b) {
                public void onFinish() {
                    CountDownTextView countDownTextView = CountDownTextView.this;
                    String unused = countDownTextView.f44294e = DurationFormatUtils.formatDuration(0, countDownTextView.f44292c);
                    CountDownTextView countDownTextView2 = CountDownTextView.this;
                    countDownTextView2.setBackgroundSpan(countDownTextView2.f44294e);
                    if (CountDownTextView.this.f44297h != null && !CountDownTextView.this.f44298i) {
                        boolean unused2 = CountDownTextView.this.f44298i = true;
                        CountDownTextView.this.f44297h.onCountTimeout();
                        CountTimeoutListener unused3 = CountDownTextView.this.f44297h = null;
                    }
                }

                public void onTick(long j) {
                    boolean unused = CountDownTextView.this.f44298i = false;
                    if (j > 0) {
                        CountDownTextView countDownTextView = CountDownTextView.this;
                        String unused2 = countDownTextView.f44294e = DurationFormatUtils.formatDuration(j, countDownTextView.f44292c);
                        CountDownTextView countDownTextView2 = CountDownTextView.this;
                        countDownTextView2.setBackgroundSpan(countDownTextView2.f44294e);
                    }
                }
            };
        }
        return this.f44295f;
    }
}
