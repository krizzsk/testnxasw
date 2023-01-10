package com.didi.onehybrid.log;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;

public class LogFloatingView {

    /* renamed from: a */
    boolean f32097a = false;

    /* renamed from: b */
    private ViewGroup f32098b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f32099c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout.LayoutParams f32100d;

    /* renamed from: e */
    private LinearLayout f32101e;

    /* renamed from: f */
    private LinearLayout.LayoutParams f32102f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditText f32103g;

    /* renamed from: h */
    private FrameLayout.LayoutParams f32104h;

    /* renamed from: i */
    private TextView f32105i;

    /* renamed from: j */
    private TextView f32106j;

    /* renamed from: k */
    private TextView f32107k;

    /* renamed from: l */
    private LinearLayout f32108l;

    /* renamed from: m */
    private FrameLayout.LayoutParams f32109m;

    /* renamed from: n */
    private int f32110n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f32111o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f32112p;

    /* renamed from: q */
    private int f32113q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f32114r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f32115s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f32116t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f32117u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f32118v;

    /* renamed from: w */
    private Activity f32119w;

    /* renamed from: x */
    private int f32120x = 10;

    public LogFloatingView(Activity activity) {
        this.f32119w = activity;
    }

    public void show() {
        m24426a(this.f32119w);
        this.f32119w.addContentView(this.f32099c, this.f32100d);
        this.f32098b = (ViewGroup) this.f32099c.getParent();
    }

    public void hide() {
        FrameLayout frameLayout;
        ViewGroup viewGroup = this.f32098b;
        if (viewGroup != null && (frameLayout = this.f32099c) != null) {
            viewGroup.removeView(frameLayout);
            this.f32098b = null;
        }
    }

    public void smartShow() {
        if (!this.f32097a) {
            m24426a(this.f32119w);
            this.f32119w.addContentView(this.f32099c, this.f32100d);
            this.f32098b = (ViewGroup) this.f32099c.getParent();
            this.f32097a = true;
        }
    }

    public void smartHide() {
        FrameLayout frameLayout;
        if (this.f32097a) {
            ViewGroup viewGroup = this.f32098b;
            if (!(viewGroup == null || (frameLayout = this.f32099c) == null)) {
                viewGroup.removeView(frameLayout);
                this.f32098b = null;
            }
            this.f32097a = false;
        }
    }

    public void writeLine(String str) {
        write(str + "\n");
    }

    public void write(String str) {
        EditText editText = this.f32103g;
        if (editText != null) {
            editText.append(str);
        }
    }

    /* renamed from: a */
    private void m24426a(Activity activity) {
        this.f32112p = 100;
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        this.f32110n = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels - 50;
        this.f32111o = i;
        this.f32113q = (i / 3) + 100;
        this.f32099c = new FrameLayout(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f32100d = layoutParams;
        layoutParams.height = this.f32113q;
        this.f32100d.width = this.f32110n;
        this.f32099c.setLayoutParams(this.f32100d);
        this.f32101e = new LinearLayout(activity);
        this.f32102f = new LinearLayout.LayoutParams(-1, -2);
        this.f32101e.setOrientation(1);
        this.f32103g = new EditText(activity);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f32104h = layoutParams2;
        this.f32103g.setLayoutParams(layoutParams2);
        this.f32103g.setTextSize(12.0f);
        this.f32103g.setCursorVisible(false);
        this.f32103g.setFocusable(false);
        this.f32103g.setFocusableInTouchMode(false);
        this.f32103g.setGravity(48);
        this.f32103g.setBackgroundColor(Color.argb(120, 0, 0, 0));
        this.f32103g.setTextColor(-1);
        this.f32103g.setMaxLines(this.f32120x);
        this.f32108l = new LinearLayout(activity);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        this.f32109m = layoutParams3;
        layoutParams3.height = this.f32112p;
        this.f32106j = new TextView(activity);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = 12;
        layoutParams4.bottomMargin = 12;
        layoutParams4.topMargin = 2;
        this.f32106j.setText("移动");
        this.f32106j.setTextColor(-1);
        this.f32106j.setTextSize(12.0f);
        this.f32106j.setPadding(10, 10, 10, 10);
        this.f32106j.setLayoutParams(layoutParams4);
        this.f32106j.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f32106j.setOnTouchListener(new LogPanelOnTouchListener());
        this.f32108l.addView(this.f32106j);
        this.f32105i = new TextView(activity);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = 12;
        layoutParams5.bottomMargin = 12;
        layoutParams5.topMargin = 2;
        this.f32105i.setText("清空");
        this.f32105i.setTextColor(-1);
        this.f32105i.setTextSize(12.0f);
        this.f32105i.setPadding(10, 10, 10, 10);
        this.f32105i.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f32105i.setLayoutParams(layoutParams5);
        this.f32105i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (LogFloatingView.this.f32103g != null) {
                    LogFloatingView.this.f32103g.setText("");
                }
            }
        });
        this.f32108l.addView(this.f32105i);
        this.f32107k = new TextView(activity);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = 12;
        layoutParams6.bottomMargin = 12;
        layoutParams6.topMargin = 2;
        this.f32107k.setText("关闭");
        this.f32107k.setTextColor(-1);
        this.f32107k.setTextSize(12.0f);
        this.f32107k.setPadding(10, 10, 10, 10);
        this.f32107k.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f32107k.setLayoutParams(layoutParams6);
        this.f32107k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LogFloatingView.this.smartHide();
            }
        });
        this.f32108l.addView(this.f32107k);
        this.f32101e.addView(this.f32103g);
        this.f32101e.addView(this.f32108l);
        this.f32099c.addView(this.f32101e, this.f32102f);
    }

    private class LogPanelOnTouchListener implements View.OnTouchListener {
        private LogPanelOnTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int unused = LogFloatingView.this.f32114r = (int) motionEvent.getRawY();
                return true;
            } else if (action != 2) {
                return true;
            } else {
                int rawY = ((int) motionEvent.getRawY()) - LogFloatingView.this.f32114r;
                int bottom = LogFloatingView.this.f32099c.getBottom() + rawY;
                int right = LogFloatingView.this.f32099c.getRight();
                int top = LogFloatingView.this.f32099c.getTop() + rawY;
                if (top < 0) {
                    bottom = LogFloatingView.this.f32099c.getHeight() + 0;
                    top = 0;
                }
                if (bottom > LogFloatingView.this.f32111o - LogFloatingView.this.f32112p) {
                    bottom = LogFloatingView.this.f32111o - LogFloatingView.this.f32112p;
                    top = bottom - LogFloatingView.this.f32099c.getHeight();
                }
                int unused2 = LogFloatingView.this.f32115s = 0;
                int unused3 = LogFloatingView.this.f32116t = top;
                int unused4 = LogFloatingView.this.f32117u = right;
                int unused5 = LogFloatingView.this.f32118v = bottom;
                LogFloatingView.this.f32099c.layout(0, top, right, bottom);
                int unused6 = LogFloatingView.this.f32114r = (int) motionEvent.getRawY();
                LogFloatingView.this.f32100d.setMargins(LogFloatingView.this.f32115s, LogFloatingView.this.f32116t, LogFloatingView.this.f32117u, LogFloatingView.this.f32118v);
                LogFloatingView.this.f32099c.setLayoutParams(LogFloatingView.this.f32100d);
                LogFloatingView.this.f32099c.postInvalidate();
                return true;
            }
        }
    }
}
