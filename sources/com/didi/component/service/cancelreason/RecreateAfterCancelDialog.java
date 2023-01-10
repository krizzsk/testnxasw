package com.didi.component.service.cancelreason;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.Iterator;

public class RecreateAfterCancelDialog extends SimplePopupBase {

    /* renamed from: a */
    private static final String f17621a = "key_operations";

    /* renamed from: b */
    private static final String f17622b = "key_model";

    /* renamed from: c */
    private TextView f17623c;

    /* renamed from: d */
    private TextView f17624d;

    /* renamed from: e */
    private TextView f17625e;

    /* renamed from: f */
    private TextView f17626f;

    /* renamed from: g */
    private CancelReasonInfo.CancelReasonOperation f17627g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CRListModel f17628h;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_recreate_after_cancel_dialog;
    }

    public static RecreateAfterCancelDialog getInstance(CancelReasonInfo.CancelReasonOperation cancelReasonOperation, CRListModel cRListModel) {
        RecreateAfterCancelDialog recreateAfterCancelDialog = new RecreateAfterCancelDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f17621a, cancelReasonOperation);
        bundle.putSerializable(f17622b, cRListModel);
        recreateAfterCancelDialog.setArguments(bundle);
        return recreateAfterCancelDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f17627g = (CancelReasonInfo.CancelReasonOperation) getArguments().get(f17621a);
            this.f17628h = (CRListModel) getArguments().get(f17622b);
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f17623c = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_title);
        this.f17624d = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_content);
        this.f17625e = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_pos);
        this.f17626f = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_neg);
        try {
            this.f17623c.setText(this.f17627g.btn_title);
            if (!TextUtils.isEmpty(this.f17627g.btn_context)) {
                this.f17624d.setVisibility(0);
                this.f17624d.setText(this.f17627g.btn_context);
            }
            Iterator<CancelReasonInfo.CancelReasonBtn> it = this.f17627g.btn_list.iterator();
            while (it.hasNext()) {
                CancelReasonInfo.CancelReasonBtn next = it.next();
                if (next.btn_type == 1) {
                    this.f17625e.setText(next.title);
                } else {
                    this.f17626f.setText(next.title);
                }
            }
        } catch (Exception unused) {
            Context context = this.mRootView.getContext();
            if (context != null) {
                this.f17623c.setText(context.getResources().getString(R.string.global_cancel_reason_dialog_title));
                this.f17625e.setText(context.getResources().getString(R.string.global_cancel_reason_dialog_pos_btn));
                this.f17626f.setText(context.getResources().getString(R.string.global_cancel_reason_dialog_neg_btn));
            }
        }
        this.f17625e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = true;
                if (RecreateAfterCancelDialog.this.f17628h.reason_type != 1) {
                    z = false;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_SUBMIT_SKIP, Boolean.valueOf(z));
                OmegaSDKAdapter.trackEvent("gp_cancelreason_panel_request_ck");
                RecreateAfterCancelDialog.this.dismiss();
                if (RecreateAfterCancelDialog.this.getActivity() != null) {
                    RecreateAfterCancelDialog.this.getActivity().finish();
                }
            }
        });
        this.f17626f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("gp_cancelreason_panel_norequest_ck");
                RecreateAfterCancelDialog.this.dismiss();
                if (RecreateAfterCancelDialog.this.getActivity() != null) {
                    RecreateAfterCancelDialog.this.getActivity().finish();
                }
            }
        });
        setCancelable(false);
    }
}
