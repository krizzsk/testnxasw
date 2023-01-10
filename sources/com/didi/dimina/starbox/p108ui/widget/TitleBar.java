package com.didi.dimina.starbox.p108ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C11267R;
import com.taxis99.R;

/* renamed from: com.didi.dimina.starbox.ui.widget.TitleBar */
public class TitleBar extends FrameLayout {

    /* renamed from: a */
    private ImageView f20003a;

    /* renamed from: b */
    private ImageView f20004b;

    /* renamed from: c */
    private TextView f20005c;

    /* renamed from: d */
    private TextView f20006d;

    /* renamed from: e */
    private TextView f20007e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnTitleBarClickListener f20008f;

    /* renamed from: com.didi.dimina.starbox.ui.widget.TitleBar$OnTitleBarClickListener */
    public interface OnTitleBarClickListener {
        void onLeftClick();

        void onRightClick();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public TitleBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16968a(context, attributeSet);
    }

    /* renamed from: a */
    private void m16968a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.dimina_starbox_title_bar, this, true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.TitleBar);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(3, 0);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(7, 0);
        int color2 = obtainStyledAttributes.getColor(6, getResources().getColor(R.color.dk_color_FFFFFF));
        String string2 = obtainStyledAttributes.getString(4);
        String string3 = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        this.f20003a = (ImageView) findViewById(R.id.left_icon);
        this.f20004b = (ImageView) findViewById(R.id.right_icon);
        this.f20005c = (TextView) findViewById(R.id.title);
        this.f20007e = (TextView) findViewById(R.id.right_text);
        this.f20006d = (TextView) findViewById(R.id.left_text);
        ((ViewGroup) this.f20003a.getParent()).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TitleBar.this.f20008f != null) {
                    TitleBar.this.f20008f.onLeftClick();
                }
            }
        });
        if (resourceId3 == 0) {
            ((ViewGroup) this.f20004b.getParent()).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (TitleBar.this.f20008f != null) {
                        TitleBar.this.f20008f.onRightClick();
                    }
                }
            });
            ((ViewGroup) this.f20007e.getParent()).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (TitleBar.this.f20008f != null) {
                        TitleBar.this.f20008f.onRightClick();
                    }
                }
            });
        } else {
            this.f20004b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (TitleBar.this.f20008f != null) {
                        TitleBar.this.f20008f.onRightClick();
                    }
                }
            });
        }
        setLeftIcon(resourceId);
        setLeftText(string3);
        setRightText(string2);
        setRightIcon(resourceId2);
        setRightTextColor(color);
        setTitle(string);
        setTitleColor(color);
        setBackgroundColor(color2);
    }

    private void setRightTextColor(int i) {
        if (i != 0) {
            this.f20007e.setTextColor(i);
            this.f20007e.setVisibility(0);
        }
    }

    private void setTitleColor(int i) {
        if (i != 0) {
            this.f20005c.setTextColor(i);
            this.f20005c.setVisibility(0);
        }
    }

    public void setTitle(String str) {
        setTitle(str, true);
    }

    public void setTitle(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f20005c.setText("");
            return;
        }
        this.f20005c.setText(str);
        this.f20005c.setVisibility(0);
        if (z) {
            this.f20005c.setAlpha(0.0f);
            this.f20005c.animate().alpha(1.0f).start();
        }
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener) {
        this.f20008f = onTitleBarClickListener;
    }

    public void setLeftIcon(int i) {
        if (i != 0) {
            this.f20003a.setImageResource(i);
            this.f20003a.setVisibility(0);
        }
    }

    public void setRightIcon(int i) {
        if (i != 0) {
            this.f20004b.setImageResource(i);
            this.f20004b.setVisibility(0);
        }
    }

    public void setRightText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f20007e.setText(str);
            this.f20007e.setVisibility(0);
            this.f20004b.setVisibility(8);
        }
    }

    public void setLeftText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f20006d.setText(str);
            this.f20006d.setVisibility(0);
        }
    }
}
