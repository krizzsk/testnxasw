package com.didi.component.memberpoint.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.StringUtil;
import com.didi.component.memberpoint.AbsMemberPointPresenter;
import com.didi.component.memberpoint.IMemberPointView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;

public class MemberPointView implements IMemberPointView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsMemberPointPresenter f16425a;

    /* renamed from: b */
    private View f16426b;

    /* renamed from: c */
    private Context f16427c;

    /* renamed from: d */
    private TextView f16428d = ((TextView) this.f16426b.findViewById(R.id.tv_global_memberpoint_label));

    /* renamed from: e */
    private ImageView f16429e;

    public void setMemberpoint(String str) {
    }

    public MemberPointView(Context context, ViewGroup viewGroup) {
        this.f16427c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_memberpoint_select, viewGroup, false);
        this.f16426b = inflate;
        this.f16429e = (ImageView) inflate.findViewById(R.id.iv_global_memberpoint_icon);
        this.f16426b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MemberPointView.this.f16425a.onMemberpointClick();
            }
        });
    }

    public View getView() {
        return this.f16426b;
    }

    public void setPresenter(AbsMemberPointPresenter absMemberPointPresenter) {
        this.f16425a = absMemberPointPresenter;
    }

    public void setIcon(String str) {
        if (!StringUtil.isNullOrEmpty(str) && this.f16429e != null) {
            Glide.with(this.f16427c.getApplicationContext()).load(str).into(this.f16429e);
        }
    }

    public void setLabel(String str) {
        TextView textView = this.f16428d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bindRichInfo(GlobalRichInfo globalRichInfo) {
        if (this.f16428d != null && !TextUtils.isEmpty(globalRichInfo.getContent())) {
            globalRichInfo.bindTextView(this.f16428d);
        }
    }
}
