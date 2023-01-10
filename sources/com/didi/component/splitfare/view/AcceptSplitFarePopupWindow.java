package com.didi.component.splitfare.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.dialog.GlobalAbsBottomPopWin;
import com.didi.component.splitfare.event.SplitFareEventTracker;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.taxis99.R;
import java.util.List;

public class AcceptSplitFarePopupWindow extends GlobalAbsBottomPopWin implements View.OnClickListener {

    /* renamed from: a */
    private AcceptPaymentsView f17878a;

    /* renamed from: b */
    private TextView f17879b;

    /* renamed from: c */
    private TextView f17880c;

    /* renamed from: d */
    private View f17881d;

    /* renamed from: e */
    private View f17882e;

    /* renamed from: f */
    private DTSDKSplitFareInfo f17883f;

    /* renamed from: g */
    private OnSplitFareActionListener f17884g;

    public interface OnSplitFareActionListener {
        void onAccept(View view);

        void onDecline(View view);

        void onPaymentClick(View view);
    }

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.accept_splitfare_view;
    }

    public AcceptSplitFarePopupWindow(Context context, DTSDKSplitFareInfo dTSDKSplitFareInfo) {
        super(context);
        this.f17883f = dTSDKSplitFareInfo;
    }

    public void setActionListener(OnSplitFareActionListener onSplitFareActionListener) {
        this.f17884g = onSplitFareActionListener;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_REQUEST_DLG_SW);
        this.f17878a = (AcceptPaymentsView) findViewById(R.id.accept_payment_methods);
        this.f17879b = (TextView) findViewById(R.id.accept_title_view);
        this.f17880c = (TextView) findViewById(R.id.accept_content_view);
        this.f17881d = findViewById(R.id.accept_submit_btn);
        this.f17882e = findViewById(R.id.accept_cancel_btn);
        if (this.f17883f == null) {
            return true;
        }
        findViewById(R.id.accept_payment_layout).setOnClickListener(this);
        this.f17881d.setOnClickListener(this);
        this.f17882e.setOnClickListener(this);
        this.f17879b.setText(this.f17883f.split_msg_title);
        this.f17880c.setText(this.f17883f.split_msg_content);
        return true;
    }

    public void updatePaymentLabel(List<PayWayModel.PayWayItem> list) {
        if (list != null && list.size() > 0) {
            this.f17878a.updateLabel(list);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        OnSplitFareActionListener onSplitFareActionListener = this.f17884g;
        if (onSplitFareActionListener != null) {
            if (id == R.id.accept_submit_btn) {
                onSplitFareActionListener.onAccept(view);
            } else if (id == R.id.accept_cancel_btn) {
                onSplitFareActionListener.onDecline(view);
            } else if (id == R.id.accept_payment_layout) {
                onSplitFareActionListener.onPaymentClick(view);
            }
        }
    }
}
