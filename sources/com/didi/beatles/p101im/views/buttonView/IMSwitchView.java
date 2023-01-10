package com.didi.beatles.p101im.views.buttonView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.resource.IMResource;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.views.buttonView.IMSwitchView */
public class IMSwitchView extends LinearLayout {
    public static final int LEFT_CHECKED = 1;
    public static final int RIGHT_CHECKED = 2;

    /* renamed from: b */
    private static int f11975b = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f11976a;

    /* renamed from: c */
    private Context f11977c;

    /* renamed from: d */
    private TextView f11978d;

    /* renamed from: e */
    private TextView f11979e;

    /* renamed from: f */
    private TextView f11980f;

    /* renamed from: g */
    private TextView f11981g;

    /* renamed from: h */
    private View f11982h;

    /* renamed from: i */
    private View f11983i;

    /* renamed from: j */
    private IMSwitchCheckListener f11984j;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.buttonView.IMSwitchView$Checked */
    public @interface Checked {
    }

    /* renamed from: com.didi.beatles.im.views.buttonView.IMSwitchView$IMSwitchCheckListener */
    public interface IMSwitchCheckListener {
        void leftBtnChecked();

        void rightBtnChecked();
    }

    public IMSwitchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11977c = context;
        m10308a();
    }

    /* renamed from: a */
    private void m10308a() {
        View inflate = LayoutInflater.from(this.f11977c).inflate(R.layout.im_switch_view, this);
        this.f11978d = (TextView) inflate.findViewById(R.id.im_switch_left_btn);
        this.f11979e = (TextView) inflate.findViewById(R.id.im_switch_left_line);
        this.f11980f = (TextView) inflate.findViewById(R.id.im_switch_right_btn);
        this.f11981g = (TextView) inflate.findViewById(R.id.im_switch_right_line);
        this.f11982h = inflate.findViewById(R.id.im_switch_left_ll);
        this.f11983i = inflate.findViewById(R.id.im_switch_right_ll);
        m10309b();
        setDefaultChecked(1);
    }

    public void setDefaultChecked(int i) {
        if (this.f11984j == null) {
            f11975b = i;
            if (i == 1) {
                leftChecked();
            } else {
                m10311c();
            }
        }
    }

    /* renamed from: b */
    private void m10309b() {
        C48751 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.im_switch_left_ll) {
                    if (IMSwitchView.this.f11976a != 1) {
                        IMSwitchView.this.leftChecked();
                    }
                } else if (view.getId() == R.id.im_switch_right_ll && IMSwitchView.this.f11976a != 2) {
                    IMSwitchView.this.m10311c();
                }
            }
        };
        this.f11982h.setOnClickListener(r0);
        this.f11983i.setOnClickListener(r0);
    }

    public void leftChecked() {
        this.f11976a = 1;
        this.f11978d.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
        this.f11979e.setVisibility(0);
        this.f11979e.setBackgroundColor(IMResource.getColor(R.color.im_nomix_orange));
        this.f11980f.setTextColor(IMResource.getColor(R.color.im_color_333));
        this.f11981g.setVisibility(8);
        IMSwitchCheckListener iMSwitchCheckListener = this.f11984j;
        if (iMSwitchCheckListener != null) {
            iMSwitchCheckListener.leftBtnChecked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10311c() {
        this.f11976a = 2;
        this.f11978d.setTextColor(IMResource.getColor(R.color.im_color_333));
        this.f11979e.setVisibility(8);
        this.f11980f.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
        this.f11981g.setVisibility(0);
        this.f11981g.setBackgroundColor(IMResource.getColor(R.color.im_nomix_orange));
        IMSwitchCheckListener iMSwitchCheckListener = this.f11984j;
        if (iMSwitchCheckListener != null) {
            iMSwitchCheckListener.rightBtnChecked();
        }
    }

    public void setOnCheckListener(IMSwitchCheckListener iMSwitchCheckListener) {
        this.f11984j = iMSwitchCheckListener;
    }

    public void setText(String str, String str2) {
        TextView textView = this.f11978d;
        if (textView != null && this.f11980f != null) {
            textView.setText(str);
            this.f11980f.setText(str2);
        }
    }
}
