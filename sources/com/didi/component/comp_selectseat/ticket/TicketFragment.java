package com.didi.component.comp_selectseat.ticket;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.GLog;
import com.didi.component.core.IPresenter;
import com.didi.component.core.PresenterGroup;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.taxis99.R;

public class TicketFragment extends AbsNormalFragment implements View.OnClickListener, ITicketView {

    /* renamed from: a */
    private static final String f14323a = "TicketFragment";

    /* renamed from: b */
    private TicketPresenter f14324b;

    /* renamed from: c */
    private View f14325c;

    /* renamed from: d */
    private TextView f14326d;

    /* renamed from: e */
    private TextView f14327e;

    /* renamed from: f */
    private TextView f14328f;

    /* renamed from: g */
    private TextView f14329g;

    /* renamed from: h */
    private TextView f14330h;

    /* renamed from: i */
    private TextView f14331i;

    /* renamed from: j */
    private TextView f14332j;

    /* renamed from: k */
    private TextView f14333k;

    /* renamed from: l */
    private TextView f14334l;

    /* renamed from: m */
    private TextView f14335m;

    /* renamed from: n */
    private View f14336n;

    /* renamed from: o */
    private RelativeLayout f14337o;

    /* renamed from: p */
    private RelativeLayout f14338p;

    /* renamed from: q */
    private ImageView f14339q;

    /* renamed from: r */
    private ImageView f14340r;

    /* renamed from: s */
    private TicketActivity f14341s;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    public void setPresenter(IPresenter iPresenter) {
    }

    public static TicketFragment newInstance(String str) {
        TicketFragment ticketFragment = new TicketFragment();
        Bundle bundle = new Bundle();
        bundle.putString("detail_data", str);
        ticketFragment.setArguments(bundle);
        return ticketFragment;
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        TicketPresenter ticketPresenter = new TicketPresenter(getContext(), getArguments());
        this.f14324b = ticketPresenter;
        return ticketPresenter;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f14341s = (TicketActivity) context;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f14341s = null;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14325c = layoutInflater.inflate(R.layout.ticket_layout, viewGroup, false);
        m11877b();
        m11876a();
        return this.f14325c;
    }

    /* renamed from: a */
    private void m11876a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14324b.setData(arguments.getString("detail_data"));
            return;
        }
        GLog.m11357e(f14323a, "setData>> bundle is null");
    }

    /* renamed from: b */
    private void m11877b() {
        this.f14326d = (TextView) this.f14325c.findViewById(R.id.tv_titleBar);
        this.f14327e = (TextView) this.f14325c.findViewById(R.id.tv_payment);
        this.f14328f = (TextView) this.f14325c.findViewById(R.id.tv_price);
        this.f14336n = this.f14325c.findViewById(R.id.fl_title_hide_shadow);
        this.f14337o = (RelativeLayout) this.f14325c.findViewById(R.id.rl_title_head);
        this.f14338p = (RelativeLayout) this.f14325c.findViewById(R.id.rl_ticket_body);
        this.f14329g = (TextView) this.f14325c.findViewById(R.id.tv_ticket_num);
        this.f14330h = (TextView) this.f14325c.findViewById(R.id.tv_name);
        this.f14331i = (TextView) this.f14325c.findViewById(R.id.tv_role);
        this.f14332j = (TextView) this.f14325c.findViewById(R.id.tv_seat_num);
        this.f14333k = (TextView) this.f14325c.findViewById(R.id.tv_seat_units);
        ImageView imageView = (ImageView) this.f14325c.findViewById(R.id.btn_back);
        this.f14339q = imageView;
        imageView.setOnClickListener(this);
        this.f14340r = (ImageView) this.f14325c.findViewById(R.id.iv_monetary_unit);
        TextView textView = (TextView) this.f14325c.findViewById(R.id.tv_next);
        this.f14334l = textView;
        textView.setOnClickListener(this);
        this.f14335m = (TextView) this.f14325c.findViewById(R.id.tv_ticket_intro);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.btn_back) {
            this.f14341s.finish();
        } else if (view.getId() == R.id.tv_next) {
            this.f14341s.finish();
        }
    }

    public void setTitleBarText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14326d.setText(str);
        } else {
            GLog.m11357e(f14323a, "setTitleBarText>> title is null");
        }
    }

    public void setPayment(LEGORichInfo lEGORichInfo) {
        if (lEGORichInfo == null || TextUtils.isEmpty(lEGORichInfo.getContent())) {
            GLog.m11357e(f14323a, "setPayment>> payment is null");
        } else {
            lEGORichInfo.bindTextView(this.f14327e);
        }
    }

    public void setPrice(LEGORichInfo lEGORichInfo) {
        if (lEGORichInfo == null || TextUtils.isEmpty(lEGORichInfo.getContent())) {
            GLog.m11357e(f14323a, "setPrice>> price is null");
        } else {
            lEGORichInfo.bindTextView(this.f14328f);
        }
    }

    public void setTicketHeadBgColor(String str) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            try {
                i = Color.parseColor(str);
            } catch (Exception e) {
                int parseColor = Color.parseColor("#1F2B4D");
                e.printStackTrace();
                GLog.m11357e(f14323a, "setTicketHeadBgColor>> " + str);
                i = parseColor;
            }
            if (getContext() != null) {
                gradientDrawable.setCornerRadius((float) UiUtils.dip2px(getContext(), 20.0f));
                float dip2px = (float) UiUtils.dip2px(getContext(), 20.0f);
                gradientDrawable.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
                gradientDrawable.setColor(i);
                this.f14337o.setBackground(gradientDrawable);
                return;
            }
            return;
        }
        GLog.m11357e(f14323a, "setTicketHeadBgColor>> color is null");
    }

    public void showPaymentMark(String str) {
        if (TextUtils.isEmpty(str) || getContext() == null) {
            this.f14340r.setVisibility(8);
            return;
        }
        this.f14340r.setVisibility(0);
        Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(str)).into(this.f14340r);
    }

    public void setTicketNum(String str) {
        this.f14329g.setText(str);
    }

    public void setTicketIntro(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14335m.setText(str);
        } else {
            GLog.m11357e(f14323a, "setTicketIntro>> intro is null");
        }
    }

    public void setName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14330h.setText(str);
        } else {
            GLog.m11357e(f14323a, "setName>> name is null");
        }
    }

    public void setRole(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14331i.setText(str);
        } else {
            GLog.m11357e(f14323a, "setRole>> role is null");
        }
    }

    public void setSeatNum(int i) {
        this.f14332j.setText(String.valueOf(i));
    }

    public void setSeatUnits(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14333k.setText(str);
        } else {
            GLog.m11357e(f14323a, "setSeatUnits>> seatUnits is null");
        }
    }
}
