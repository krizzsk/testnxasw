package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.entity.IMPrivateOrderEntity;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMDateUtil;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMParseUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOrderPrivateRenderView */
public class IMOrderPrivateRenderView extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f12191a;

    /* renamed from: b */
    private TextView f12192b;

    /* renamed from: c */
    private TextView f12193c;

    /* renamed from: d */
    private TextView f12194d;

    /* renamed from: e */
    private TextView f12195e;

    /* renamed from: f */
    private TextView f12196f;

    /* renamed from: g */
    private TextView f12197g;

    /* renamed from: h */
    private TextView f12198h;

    /* renamed from: i */
    private TextView f12199i;

    /* renamed from: j */
    private IMPrivateOrderEntity f12200j;

    public IMOrderPrivateRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        View inflate = this.inflater.inflate(R.layout.bts_im_mine_private_order, viewGroup, false);
        if (this.isMine) {
            inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_white_bubble_selector));
        } else {
            inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f12191a = (TextView) findViewById(R.id.order_title);
        this.f12192b = (TextView) findViewById(R.id.order_time);
        this.f12193c = (TextView) findViewById(R.id.order_start_address);
        this.f12194d = (TextView) findViewById(R.id.order_people);
        this.f12195e = (TextView) findViewById(R.id.order_end_address);
        this.f12196f = (TextView) findViewById(R.id.order_start_subddress);
        this.f12197g = (TextView) findViewById(R.id.order_end_subddress);
        this.f12198h = (TextView) findViewById(R.id.order_detail);
        this.f12199i = (TextView) findViewById(R.id.order_price);
    }

    /* access modifiers changed from: protected */
    public void onUpdateView() {
        this.adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        IMPrivateOrderEntity iMPrivateOrderEntity = (IMPrivateOrderEntity) IMJsonUtil.objectFromJson(this.message.getContent(), IMPrivateOrderEntity.class);
        this.f12200j = iMPrivateOrderEntity;
        if (iMPrivateOrderEntity != null) {
            this.f12191a.setText(iMPrivateOrderEntity.title);
            this.f12192b.setText(IMDateUtil.getDateDetail(getContext(), this.f12200j.time));
            this.f12194d.setText(this.f12200j.passenger_num);
            this.f12193c.setText(this.f12200j.from);
            this.f12195e.setText(this.f12200j.f10965to);
            this.f12196f.setText(this.f12200j.distance);
            this.f12197g.setText(this.f12200j.business_area);
            this.f12198h.setText(this.f12200j.anchor_text);
            if (TextUtils.isEmpty(this.f12200j.price)) {
                this.f12199i.setVisibility(8);
            } else {
                this.f12199i.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        String str;
        String str2 = this.f12200j.order_id;
        if (IMParseUtil.parseInt(this.f12200j.to_user_role) == 2) {
            str = String.format(this.context.getString(R.string.im_passenger_waiting_order_uri), new Object[]{str2});
        } else {
            str = String.format(this.context.getString(R.string.im_driver_waiting_order_uri), new Object[]{str2, this.f12200j.route_id});
        }
        IMCommonUtil.startUriActivity(this.context, str);
    }
}
