package com.didi.beatles.p101im.views.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.didi.beatles.p101im.views.widget.TriangleView;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView */
public class IMSimpleGuideView {
    public static final int GRAVITY_BOTTOM = 2;
    public static final int GRAVITY_CENTER = 2;
    public static final int GRAVITY_END = 3;
    public static final int GRAVITY_LEFT = 1;
    public static final int GRAVITY_RIGHT = 3;
    public static final int GRAVITY_START = 1;
    public static final int GRAVITY_TOP = 0;

    /* renamed from: a */
    private static final String f12325a = "IMSimpleGuideView";

    /* renamed from: j */
    private static final int f12326j = 22;

    /* renamed from: k */
    private static final int f12327k = 18;

    /* renamed from: l */
    private static final int f12328l = 6;

    /* renamed from: b */
    private Context f12329b;

    /* renamed from: c */
    private PopupWindow f12330c;

    /* renamed from: d */
    private RelativeLayout f12331d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Builder f12332e;

    /* renamed from: f */
    private IMForkView f12333f;

    /* renamed from: g */
    private TextView f12334g;

    /* renamed from: h */
    private TriangleView f12335h;

    /* renamed from: i */
    private LinearLayout f12336i;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f12337m;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView$Gravity */
    public @interface Gravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView$LayoutGravity */
    public @interface LayoutGravity {
    }

    private IMSimpleGuideView(Builder builder) {
        this.f12337m = -1;
        this.f12329b = builder.context;
        this.f12332e = builder;
        m10510a();
        m10515c();
    }

    /* renamed from: a */
    private void m10510a() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f12329b).inflate(R.layout.im_simple_guide_view, (ViewGroup) null);
        this.f12331d = relativeLayout;
        this.f12333f = (IMForkView) relativeLayout.findViewById(R.id.im_simple_guide_forkview);
        TextView textView = (TextView) this.f12331d.findViewById(R.id.im_simple_guide_tv);
        this.f12334g = textView;
        textView.setFitsSystemWindows(false);
        this.f12333f.setFitsSystemWindows(false);
        this.f12336i = (LinearLayout) this.f12331d.findViewById(R.id.im_simple_guide_ll);
        if (this.f12332e.showForkView) {
            m10511a((View) this.f12333f);
        } else {
            m10511a((View) this.f12331d);
        }
        PopupWindow popupWindow = new PopupWindow(this.f12331d, m10517e(), m10519g());
        this.f12330c = popupWindow;
        popupWindow.setOutsideTouchable(this.f12332e.dismissTouchOutside);
        this.f12330c.setFocusable(true);
        if (Build.VERSION.SDK_INT < 21) {
            this.f12330c.setBackgroundDrawable(new BitmapDrawable());
        }
        if (this.f12332e.dismissListener != null) {
            this.f12330c.setOnDismissListener(this.f12332e.dismissListener);
        }
    }

    /* renamed from: a */
    private void m10511a(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMSimpleGuideView.this.dismiss();
                    if (IMSimpleGuideView.this.f12332e.listener != null) {
                        IMSimpleGuideView.this.f12332e.listener.onClick(view);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private void m10512b() {
        this.f12334g.setText(m10509a(this.f12332e.guideText));
    }

    /* renamed from: c */
    private void m10515c() {
        m10512b();
        if (this.f12332e.showForkView) {
            this.f12333f.setVisibility(0);
            if (this.f12332e.forkViewColor != 0) {
                this.f12333f.setViewColor(this.f12332e.forkViewColor);
            }
            this.f12333f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMSimpleGuideView.this.dismiss();
                    if (IMSimpleGuideView.this.f12332e.listener != null) {
                        IMSimpleGuideView.this.f12332e.listener.onClick(view);
                    }
                }
            });
        } else {
            this.f12333f.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12336i.getLayoutParams();
        layoutParams.height = m10506a((m10522j() * 18) + 22);
        this.f12336i.setLayoutParams(layoutParams);
        m10516d();
    }

    /* renamed from: a */
    private String m10509a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f12332e.notAutoBreakLine) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        int i = 1;
        while (true) {
            int i2 = i - 1;
            if ((this.f12332e.maxNumSingleLine * i) + i2 >= sb.length()) {
                return sb.toString();
            }
            sb.insert((this.f12332e.maxNumSingleLine * i) + i2, 10);
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10516d() {
        int i;
        int i2;
        if (this.f12332e.targetView.getMeasuredWidth() == 0) {
            this.f12332e.targetView.post(new Runnable() {
                public void run() {
                    IMSimpleGuideView.this.m10516d();
                }
            });
            return;
        }
        TriangleView triangleView = new TriangleView(this.f12331d.getContext());
        this.f12335h = triangleView;
        triangleView.setId(R.id.guideview_triangle_id);
        if (this.f12332e.layoutGravity == 0 || this.f12332e.layoutGravity == 2) {
            i2 = m10506a(this.f12332e.triangleSize * 2);
            i = m10506a(this.f12332e.triangleSize);
        } else {
            i2 = m10506a(this.f12332e.triangleSize);
            i = m10506a(this.f12332e.triangleSize * 2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f12336i.getLayoutParams();
        int access$1200 = this.f12332e.layoutGravity;
        if (access$1200 == 0) {
            if (this.f12332e.gravity == 1) {
                layoutParams.setMargins(((this.f12332e.targetView.getMeasuredWidth() - i2) / 2) - m10520h(), 0, 0, 0);
            } else if (this.f12332e.gravity == 3) {
                layoutParams.addRule(11);
                layoutParams.setMargins(0, 0, ((this.f12332e.targetView.getMeasuredWidth() - i2) / 2) + m10520h(), 0);
                layoutParams2.addRule(11);
            } else {
                layoutParams.setMargins(-m10520h(), 0, 0, 0);
                layoutParams.addRule(14);
            }
            this.f12335h.setDirection(TriangleView.Direction.DOWN);
            layoutParams.addRule(3, this.f12336i.getId());
            this.f12331d.addView(this.f12335h, 1, layoutParams);
        } else if (access$1200 == 1) {
            if (this.f12332e.gravity == 1) {
                layoutParams.setMargins(0, ((this.f12332e.targetView.getMeasuredHeight() - i) / 2) - m10520h(), 0, 0);
            } else if (this.f12332e.gravity == 3) {
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, ((this.f12332e.targetView.getMeasuredHeight() - i) / 2) + m10520h());
                layoutParams2.addRule(12);
            } else {
                layoutParams.setMargins(0, -m10520h(), 0, 0);
                layoutParams.addRule(15);
            }
            this.f12335h.setDirection(TriangleView.Direction.RIGHT);
            layoutParams.addRule(1, this.f12336i.getId());
            this.f12331d.addView(this.f12335h, 1, layoutParams);
        } else if (access$1200 == 2) {
            this.f12335h.setDirection(TriangleView.Direction.UP);
            if (this.f12332e.gravity == 1) {
                layoutParams.setMargins(((this.f12332e.targetView.getMeasuredWidth() - i2) / 2) - m10520h(), 0, 0, 0);
            } else if (this.f12332e.gravity == 3) {
                layoutParams.addRule(11);
                layoutParams.setMargins(0, 0, ((this.f12332e.targetView.getMeasuredWidth() - i2) / 2) + m10520h(), 0);
                layoutParams2.addRule(11);
            } else {
                layoutParams.setMargins(-m10520h(), 0, 0, 0);
                layoutParams.addRule(14);
            }
            this.f12331d.addView(this.f12335h, 0, layoutParams);
            layoutParams2.addRule(3, this.f12335h.getId());
            this.f12336i.setLayoutParams(layoutParams2);
        } else if (access$1200 == 3) {
            if (this.f12332e.gravity == 1) {
                layoutParams.setMargins(0, ((this.f12332e.targetView.getMeasuredHeight() - i) / 2) - m10520h(), 0, 0);
            } else if (this.f12332e.gravity == 3) {
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, ((this.f12332e.targetView.getMeasuredHeight() - i) / 2) + m10520h());
                layoutParams2.addRule(12);
            } else {
                layoutParams.setMargins(0, -m10520h(), 0, 0);
                layoutParams.addRule(15);
            }
            this.f12335h.setDirection(TriangleView.Direction.LEFT);
            this.f12331d.addView(this.f12335h, 0, layoutParams);
            layoutParams2.addRule(1, this.f12335h.getId());
            this.f12336i.setLayoutParams(layoutParams2);
        }
    }

    public void setGuideText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12334g.setText(str);
        }
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f12330c;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public boolean isShow() {
        PopupWindow popupWindow = this.f12330c;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    /* renamed from: a */
    private int m10506a(int i) {
        return IMViewUtil.dp2px(this.f12331d.getContext(), (float) i);
    }

    public void show() {
        show(0, 0);
    }

    public void show(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        final int i11 = i;
        final int i12 = i2;
        Context context = this.f12329b;
        if (!(context instanceof Activity)) {
            IMLog.m10021e(f12325a, "[show] with invalid context=" + this.f12329b);
        } else if (((Activity) context).isFinishing()) {
            IMLog.m10021e(f12325a, "[show] with activity finished");
        } else {
            View access$1000 = this.f12332e.targetView;
            if (access$1000 != null) {
                if (access$1000.getWindowToken() == null || access$1000.getMeasuredWidth() == 0) {
                    if (this.f12337m < 0) {
                        this.f12337m = System.currentTimeMillis();
                    }
                    UiThreadHandler.postDelayed(new Runnable() {
                        public void run() {
                            if (System.currentTimeMillis() - IMSimpleGuideView.this.f12337m > 3000) {
                                IMLog.m10026w("show simple guide run out of time", new Object[0]);
                            } else {
                                IMSimpleGuideView.this.show(i11, i12);
                            }
                        }
                    }, 100);
                    return;
                }
                int[] iArr = new int[2];
                access$1000.getLocationOnScreen(iArr);
                int i13 = iArr[0];
                int i14 = iArr[1];
                int access$1200 = this.f12332e.layoutGravity;
                if (access$1200 != 0) {
                    if (access$1200 == 1) {
                        i13 = (int) (((double) iArr[0]) - (((double) (m10523k() + m10517e())) * 0.5d));
                        i11 -= m10506a(6);
                        if (this.f12332e.gravity == 2) {
                            i8 = (int) (((double) i14) + (((double) (access$1000.getMeasuredHeight() - m10519g())) * 0.5d));
                            i7 = m10520h();
                        } else if (this.f12332e.gravity == 3) {
                            i5 = (i14 + access$1000.getMeasuredHeight()) - m10519g();
                            i6 = m10520h();
                            i14 = i5 + i6;
                        }
                    } else if (access$1200 == 2) {
                        i14 += access$1000.getMeasuredHeight();
                        int access$1400 = this.f12332e.gravity;
                        if (access$1400 != 1) {
                            if (access$1400 == 2) {
                                i10 = (int) (((double) iArr[0]) + (((double) (access$1000.getMeasuredWidth() - m10523k())) * 0.5d));
                                i9 = m10520h();
                            } else if (access$1400 == 3) {
                                i10 = (int) ((((double) (access$1000.getMeasuredWidth() + iArr[0])) - (((double) m10523k()) * 0.5d)) - (((double) m10517e()) * 0.5d));
                                i9 = m10520h();
                            }
                            i13 = i10 + i9;
                        } else {
                            i10 = (int) (-(((((double) m10523k()) * 0.5d) - ((double) iArr[0])) - (((double) m10517e()) * 0.5d)));
                            i9 = m10520h();
                            i13 = i10 + i9;
                        }
                        i12 += m10506a(6);
                    } else if (access$1200 == 3) {
                        i13 = (int) (-((((((double) m10523k()) * 0.5d) - ((double) iArr[0])) - ((double) access$1000.getMeasuredWidth())) - (((double) m10517e()) * 0.5d)));
                        i11 += m10506a(6);
                        if (this.f12332e.gravity == 2) {
                            i8 = (int) (((double) i14) + (((double) (access$1000.getMeasuredHeight() - m10519g())) * 0.5d));
                            i7 = m10520h();
                        } else if (this.f12332e.gravity == 3) {
                            i5 = (i14 + access$1000.getMeasuredHeight()) - m10519g();
                            i6 = m10520h();
                            i14 = i5 + i6;
                        }
                    }
                    i14 = i8 + i7;
                } else {
                    i14 -= m10519g();
                    int access$14002 = this.f12332e.gravity;
                    if (access$14002 == 1) {
                        i4 = (int) (-(((((double) m10523k()) * 0.5d) - ((double) iArr[0])) - (((double) m10517e()) * 0.5d)));
                        i3 = m10520h();
                        i13 = i4 + i3;
                    } else if (access$14002 == 2) {
                        i13 = (int) (((double) iArr[0]) + (((double) (access$1000.getMeasuredWidth() - m10523k())) * 0.5d) + ((double) m10520h()));
                    } else if (access$14002 == 3) {
                        i4 = (int) ((((double) (access$1000.getMeasuredWidth() + iArr[0])) - (((double) m10523k()) * 0.5d)) - (((double) m10517e()) * 0.5d));
                        i3 = m10520h();
                        i13 = i4 + i3;
                    }
                    i12 -= m10506a(6);
                }
                try {
                    this.f12330c.showAtLocation(access$1000, 48, i13 + i11, i14 + i12);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: e */
    private int m10517e() {
        int i = 0;
        if (this.f12332e.layoutGravity == 1 || this.f12332e.layoutGravity == 3) {
            i = 0 + m10506a(this.f12332e.triangleSize);
        }
        if (this.f12332e.showForkView) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12333f.getLayoutParams();
            i = i + layoutParams.width + layoutParams.rightMargin;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12334g.getLayoutParams();
        return m10507a(this.f12334g, m10518f()) + i + layoutParams2.leftMargin + layoutParams2.rightMargin;
    }

    /* renamed from: f */
    private String m10518f() {
        return this.f12332e.guideText;
    }

    /* renamed from: g */
    private int m10519g() {
        if (this.f12332e.layoutGravity == 1 || this.f12332e.layoutGravity == 3) {
            return m10506a(m10521i());
        }
        return m10506a(m10521i() + this.f12332e.triangleSize);
    }

    /* renamed from: h */
    private int m10520h() {
        return m10506a(this.f12332e.offset);
    }

    /* renamed from: i */
    private int m10521i() {
        return (m10522j() * 18) + 22;
    }

    /* renamed from: a */
    private int m10507a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f12332e.notAutoBreakLine) {
            TextPaint paint = textView.getPaint();
            int indexOf = str.indexOf(10);
            float f = 0.0f;
            while (indexOf > -1) {
                float measureText = paint.measureText(str.substring(0, indexOf));
                if (measureText > f) {
                    f = measureText;
                }
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(10);
            }
            float measureText2 = paint.measureText(str);
            if (measureText2 > f) {
                f = measureText2;
            }
            return (int) f;
        }
        if (str.length() > this.f12332e.maxNumSingleLine) {
            str = str.substring(0, this.f12332e.maxNumSingleLine);
        }
        return (int) textView.getPaint().measureText(str);
    }

    /* renamed from: j */
    private int m10522j() {
        String f = m10518f();
        int i = 0;
        if (TextUtils.isEmpty(f)) {
            return 0;
        }
        if (this.f12332e.notAutoBreakLine) {
            int indexOf = f.indexOf(10);
            while (indexOf > -1) {
                i++;
                f = f.substring(indexOf + 1);
                indexOf = f.indexOf(10);
            }
            return i + 1;
        }
        if (f.length() % this.f12332e.maxNumSingleLine != 0) {
            i = 1;
        }
        return (f.length() / this.f12332e.maxNumSingleLine) + i;
    }

    /* renamed from: k */
    private int m10523k() {
        return ((WindowManager) this.f12331d.getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public View getContentView() {
        return this.f12331d;
    }

    /* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public PopupWindow.OnDismissListener dismissListener;
        /* access modifiers changed from: private */
        public boolean dismissTouchOutside = false;
        /* access modifiers changed from: private */
        public int forkViewColor = -1;
        /* access modifiers changed from: private */
        public int gravity = 2;
        /* access modifiers changed from: private */
        public String guideText;
        /* access modifiers changed from: private */
        public int layoutGravity = 2;
        /* access modifiers changed from: private */
        public View.OnClickListener listener;
        /* access modifiers changed from: private */
        public int maxNumSingleLine = 14;
        /* access modifiers changed from: private */
        public boolean notAutoBreakLine = false;
        /* access modifiers changed from: private */
        public int offset;
        /* access modifiers changed from: private */
        public boolean showForkView = true;
        /* access modifiers changed from: private */
        public View targetView;
        /* access modifiers changed from: private */
        public int triangleSize = 6;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder isShowForkView(boolean z) {
            this.showForkView = z;
            return this;
        }

        public Builder setForkViewColor(int i) {
            this.forkViewColor = i;
            return this;
        }

        public Builder setGuideText(String str) {
            this.guideText = str;
            return this;
        }

        public Builder setPopClickListener(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public Builder setDismissListener(PopupWindow.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
            return this;
        }

        public Builder setOffset(int i) {
            this.offset = i;
            return this;
        }

        public Builder setLayoutGravity(int i) {
            this.layoutGravity = i;
            return this;
        }

        public Builder setTriangleSize(int i) {
            this.triangleSize = i;
            return this;
        }

        public Builder setMaxWordNumSingleLine(int i) {
            this.maxNumSingleLine = i;
            return this;
        }

        public Builder setGrivaty(int i) {
            this.gravity = i;
            return this;
        }

        public Builder setOutsideTouchable(boolean z) {
            this.dismissTouchOutside = z;
            return this;
        }

        public Builder setNotAutoBreakLine(boolean z) {
            this.notAutoBreakLine = z;
            return this;
        }

        public Builder setTargetView(View view) {
            if (view != null) {
                this.targetView = view;
                return this;
            }
            throw new RuntimeException("targetView can't be null !");
        }

        public IMSimpleGuideView create() {
            if (this.targetView != null) {
                return new IMSimpleGuideView(this);
            }
            throw new RuntimeException("did you forget setTargetView ?");
        }
    }
}
