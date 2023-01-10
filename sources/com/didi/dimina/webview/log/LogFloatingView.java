package com.didi.dimina.webview.log;

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
    boolean f20165a = false;

    /* renamed from: b */
    private ViewGroup f20166b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f20167c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout.LayoutParams f20168d;

    /* renamed from: e */
    private LinearLayout f20169e;

    /* renamed from: f */
    private LinearLayout.LayoutParams f20170f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditText f20171g;

    /* renamed from: h */
    private FrameLayout.LayoutParams f20172h;

    /* renamed from: i */
    private TextView f20173i;

    /* renamed from: j */
    private TextView f20174j;

    /* renamed from: k */
    private TextView f20175k;

    /* renamed from: l */
    private LinearLayout f20176l;

    /* renamed from: m */
    private FrameLayout.LayoutParams f20177m;

    /* renamed from: n */
    private int f20178n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f20179o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f20180p;

    /* renamed from: q */
    private int f20181q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f20182r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f20183s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f20184t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f20185u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f20186v;

    /* renamed from: w */
    private final Activity f20187w;

    /* renamed from: x */
    private final int f20188x = 10;

    public LogFloatingView(Activity activity) {
        this.f20187w = activity;
    }

    public void show() {
        m17034a(this.f20187w);
        this.f20187w.addContentView(this.f20167c, this.f20168d);
        this.f20166b = (ViewGroup) this.f20167c.getParent();
    }

    public void hide() {
        FrameLayout frameLayout;
        ViewGroup viewGroup = this.f20166b;
        if (viewGroup != null && (frameLayout = this.f20167c) != null) {
            viewGroup.removeView(frameLayout);
            this.f20166b = null;
        }
    }

    public void smartShow() {
        if (!this.f20165a) {
            m17034a(this.f20187w);
            this.f20187w.addContentView(this.f20167c, this.f20168d);
            this.f20166b = (ViewGroup) this.f20167c.getParent();
            this.f20165a = true;
        }
    }

    public void smartHide() {
        FrameLayout frameLayout;
        if (this.f20165a) {
            ViewGroup viewGroup = this.f20166b;
            if (!(viewGroup == null || (frameLayout = this.f20167c) == null)) {
                viewGroup.removeView(frameLayout);
                this.f20166b = null;
            }
            this.f20165a = false;
        }
    }

    public void writeLine(String str) {
        write(str + "\n");
    }

    public void write(String str) {
        EditText editText = this.f20171g;
        if (editText != null) {
            editText.append(str);
        }
    }

    /* renamed from: a */
    private void m17034a(Activity activity) {
        this.f20180p = 100;
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        this.f20178n = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels - 50;
        this.f20179o = i;
        this.f20181q = (i / 3) + 100;
        this.f20167c = new FrameLayout(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f20168d = layoutParams;
        layoutParams.height = this.f20181q;
        this.f20168d.width = this.f20178n;
        this.f20167c.setLayoutParams(this.f20168d);
        this.f20169e = new LinearLayout(activity);
        this.f20170f = new LinearLayout.LayoutParams(-1, -2);
        this.f20169e.setOrientation(1);
        this.f20171g = new EditText(activity);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f20172h = layoutParams2;
        this.f20171g.setLayoutParams(layoutParams2);
        this.f20171g.setTextSize(12.0f);
        this.f20171g.setCursorVisible(false);
        this.f20171g.setFocusable(false);
        this.f20171g.setFocusableInTouchMode(false);
        this.f20171g.setGravity(48);
        this.f20171g.setBackgroundColor(Color.argb(120, 0, 0, 0));
        this.f20171g.setTextColor(-1);
        this.f20171g.setMaxLines(10);
        this.f20176l = new LinearLayout(activity);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        this.f20177m = layoutParams3;
        layoutParams3.height = this.f20180p;
        this.f20174j = new TextView(activity);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = 12;
        layoutParams4.bottomMargin = 12;
        layoutParams4.topMargin = 2;
        this.f20174j.setText("移动");
        this.f20174j.setTextColor(-1);
        this.f20174j.setTextSize(12.0f);
        this.f20174j.setPadding(10, 10, 10, 10);
        this.f20174j.setLayoutParams(layoutParams4);
        this.f20174j.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f20174j.setOnTouchListener(new LogPanelOnTouchListener());
        this.f20176l.addView(this.f20174j);
        this.f20173i = new TextView(activity);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = 12;
        layoutParams5.bottomMargin = 12;
        layoutParams5.topMargin = 2;
        this.f20173i.setText("清空");
        this.f20173i.setTextColor(-1);
        this.f20173i.setTextSize(12.0f);
        this.f20173i.setPadding(10, 10, 10, 10);
        this.f20173i.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f20173i.setLayoutParams(layoutParams5);
        this.f20173i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (LogFloatingView.this.f20171g != null) {
                    LogFloatingView.this.f20171g.setText("");
                }
            }
        });
        this.f20176l.addView(this.f20173i);
        this.f20175k = new TextView(activity);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = 12;
        layoutParams6.bottomMargin = 12;
        layoutParams6.topMargin = 2;
        this.f20175k.setText("关闭");
        this.f20175k.setTextColor(-1);
        this.f20175k.setTextSize(12.0f);
        this.f20175k.setPadding(10, 10, 10, 10);
        this.f20175k.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f20175k.setLayoutParams(layoutParams6);
        this.f20175k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LogFloatingView.this.smartHide();
            }
        });
        this.f20176l.addView(this.f20175k);
        this.f20169e.addView(this.f20171g);
        this.f20169e.addView(this.f20176l);
        this.f20167c.addView(this.f20169e, this.f20170f);
    }

    private class LogPanelOnTouchListener implements View.OnTouchListener {
        private LogPanelOnTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int unused = LogFloatingView.this.f20182r = (int) motionEvent.getRawY();
                return true;
            } else if (action != 2) {
                return true;
            } else {
                int rawY = ((int) motionEvent.getRawY()) - LogFloatingView.this.f20182r;
                int bottom = LogFloatingView.this.f20167c.getBottom() + rawY;
                int right = LogFloatingView.this.f20167c.getRight();
                int top = LogFloatingView.this.f20167c.getTop() + rawY;
                if (top < 0) {
                    bottom = LogFloatingView.this.f20167c.getHeight() + 0;
                    top = 0;
                }
                if (bottom > LogFloatingView.this.f20179o - LogFloatingView.this.f20180p) {
                    bottom = LogFloatingView.this.f20179o - LogFloatingView.this.f20180p;
                    top = bottom - LogFloatingView.this.f20167c.getHeight();
                }
                int unused2 = LogFloatingView.this.f20183s = 0;
                int unused3 = LogFloatingView.this.f20184t = top;
                int unused4 = LogFloatingView.this.f20185u = right;
                int unused5 = LogFloatingView.this.f20186v = bottom;
                LogFloatingView.this.f20167c.layout(0, top, right, bottom);
                int unused6 = LogFloatingView.this.f20182r = (int) motionEvent.getRawY();
                LogFloatingView.this.f20168d.setMargins(LogFloatingView.this.f20183s, LogFloatingView.this.f20184t, LogFloatingView.this.f20185u, LogFloatingView.this.f20186v);
                LogFloatingView.this.f20167c.setLayoutParams(LogFloatingView.this.f20168d);
                LogFloatingView.this.f20167c.postInvalidate();
                return true;
            }
        }
    }
}
