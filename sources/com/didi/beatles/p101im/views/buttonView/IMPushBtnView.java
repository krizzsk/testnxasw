package com.didi.beatles.p101im.views.buttonView;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.api.entity.IMPushBtnBody;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.taxis99.R;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.buttonView.IMPushBtnView */
public class IMPushBtnView extends LinearLayout {

    /* renamed from: c */
    private static final String f11971c = "IMPushBtnView";

    /* renamed from: a */
    private TextView f11972a;

    /* renamed from: b */
    private TextView f11973b;

    /* renamed from: d */
    private BtnOnClick f11974d;

    /* renamed from: com.didi.beatles.im.views.buttonView.IMPushBtnView$BtnOnClick */
    public interface BtnOnClick {
        void onClick();
    }

    public IMPushBtnView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMPushBtnView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMPushBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10304a();
    }

    /* renamed from: a */
    private void m10304a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.im_push_button_layout, this);
        this.f11972a = (TextView) inflate.findViewById(R.id.im_push_btn_left);
        this.f11973b = (TextView) inflate.findViewById(R.id.im_push_btn_right);
    }

    public void setData(final IMMessage iMMessage) {
        if (iMMessage != null) {
            final List<IMPushBtnBody> list = iMMessage.btns;
            if (list == null || list.size() == 0) {
                IMLog.m10020d(f11971c, "push button data is null !");
                setVisibility(8);
                return;
            }
            this.f11972a.setText(list.get(0).btntitle);
            this.f11972a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HashMap hashMap = new HashMap();
                    hashMap.put("msg_ck", 0);
                    hashMap.put("btn1_ck", 1);
                    hashMap.put("btn2_ck", 0);
                    OmegaUtil.trackExtendMsg("ddim_msg_all_open_ck", iMMessage, hashMap);
                    IMPushBtnView.this.m10306a(((IMPushBtnBody) list.get(0)).btnurl);
                }
            });
            if (list.size() > 1) {
                this.f11973b.setVisibility(0);
                this.f11973b.setText(list.get(1).btntitle);
                this.f11973b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        IMPushBtnView.this.m10306a(((IMPushBtnBody) list.get(1)).btnurl);
                        HashMap hashMap = new HashMap();
                        hashMap.put("msg_ck", 0);
                        hashMap.put("btn1_ck", 0);
                        hashMap.put("btn2_ck", 1);
                        OmegaUtil.trackExtendMsg("ddim_msg_all_open_ck", iMMessage, hashMap);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10306a(String str) {
        BtnOnClick btnOnClick = this.f11974d;
        if (btnOnClick != null) {
            btnOnClick.onClick();
        }
        if (TextUtils.isEmpty(str)) {
            IMLog.m10020d(f11971c, "url is null when button onclick!");
            return;
        }
        try {
            Intent intentOld = Intent.getIntentOld(str);
            if (intentOld == null) {
                IMLog.m10020d(f11971c, "url is invalid !");
                return;
            }
            intentOld.setFlags(268435456);
            getContext().startActivity(intentOld);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            IMLog.m10020d(f11971c, "url is invalid !");
        }
    }

    public void setBtnOnclickListener(BtnOnClick btnOnClick) {
        this.f11974d = btnOnClick;
    }
}
