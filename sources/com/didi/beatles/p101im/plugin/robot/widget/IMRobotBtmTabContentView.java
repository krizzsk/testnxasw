package com.didi.beatles.p101im.plugin.robot.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.plugin.robot.widget.IMRobotBtmTabContentView */
public class IMRobotBtmTabContentView extends RelativeLayout {

    /* renamed from: a */
    private static final String f11361a = IMRobotBtmTabContentView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f11362b;

    /* renamed from: c */
    private TextView f11363c;

    /* renamed from: d */
    private final boolean f11364d;

    public IMRobotBtmTabContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (IMTabInvokeEnv) null);
    }

    public IMRobotBtmTabContentView(Context context, AttributeSet attributeSet, IMTabInvokeEnv iMTabInvokeEnv) {
        super(context, attributeSet);
        boolean z = true;
        this.f11364d = (iMTabInvokeEnv == null || iMTabInvokeEnv.getPluginTheme() != 1) ? false : z;
        inflate(context, R.layout.im_plugin_robot_btm_tab_content_view, this);
        this.f11362b = (ImageView) findViewById(R.id.im_tab_icon);
        this.f11363c = (TextView) findViewById(R.id.im_tab_text);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9856a() {
        if (this.f11364d) {
            this.f11362b.setImageResource(R.drawable.im_plugin_robot_tab_icon_helper_sel);
        } else {
            this.f11362b.setImageResource(R.drawable.im_plugin_robot_tab_icon_sel);
        }
    }

    /* renamed from: a */
    private void m9857a(String str, final int i) {
        BtsImageLoader.getInstance().loadIntoAsGif(str, this.f11362b, i, new Callback() {
            public void onStart() {
            }

            public void onSuccess(Bitmap bitmap) {
                if (IMRobotBtmTabContentView.this.f11362b != null && IMRobotBtmTabContentView.this.f11362b.isSelected()) {
                    IMRobotBtmTabContentView.this.m9856a();
                }
            }

            public void onFailed() {
                IMRobotBtmTabContentView.this.f11362b.setImageResource(i);
            }
        });
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            m9856a();
        }
    }
}
