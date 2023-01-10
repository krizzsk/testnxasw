package com.didi.component.payentrance.activity.confirmfare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.payentrance.model.OrderRecord;
import com.didi.component.payentrance.presenter.AbsUnifiedPayEntrancePresenter;
import com.didi.component.payentrance.view.OrderRecordView;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifiedPay.sdk.model.BillConfirm;
import com.taxis99.R;
import java.io.Serializable;

public class ConfirmFareFragment extends AbsNormalFragment<ConfirmFarePresenter> implements View.OnClickListener, IConfirmFareView {

    /* renamed from: a */
    private TextView f16720a;

    /* renamed from: b */
    private ViewGroup f16721b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OrderRecordView f16722c;

    /* renamed from: d */
    private TextView f16723d;

    /* renamed from: e */
    private TextView f16724e;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1015;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public ConfirmFarePresenter onCreateTopPresenter() {
        return new ConfirmFarePresenter(getContext(), getArguments());
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.global_pe_pay_confirm_fare_fragment, viewGroup, false);
        this.f16721b = viewGroup2;
        m14094a(viewGroup2);
        m14093a();
        return this.f16721b;
    }

    /* renamed from: a */
    private void m14094a(ViewGroup viewGroup) {
        m14096b(viewGroup);
        this.f16722c = (OrderRecordView) viewGroup.findViewById(R.id.oc_order_record);
        this.f16723d = (TextView) viewGroup.findViewById(R.id.oc_not_me_button);
        this.f16724e = (TextView) viewGroup.findViewById(R.id.oc_confirm_button);
        this.f16723d.setOnClickListener(this);
        this.f16724e.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m14096b(ViewGroup viewGroup) {
        TextView textView = (TextView) viewGroup.findViewById(R.id.oc_title_bar);
        this.f16720a = textView;
        textView.setText(R.string.pe_pay_confirm_fare_title);
    }

    /* renamed from: a */
    private void m14093a() {
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra(AbsUnifiedPayEntrancePresenter.EXTRA_PIN_ERR_KEY);
        String stringExtra = getActivity().getIntent().getStringExtra(AbsUnifiedPayEntrancePresenter.EXTRA_PIN_CURRENCY_KEY);
        if (serializableExtra == null || !(serializableExtra instanceof BillConfirm)) {
            ((ConfirmFarePresenter) this.mTopPresenter).bind((BillConfirm) null, stringExtra);
        } else {
            ((ConfirmFarePresenter) this.mTopPresenter).bind((BillConfirm) serializableExtra, stringExtra);
        }
    }

    public void showOrderRecord(final OrderRecord orderRecord) {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                ConfirmFareFragment.this.f16722c.show(orderRecord);
            }
        });
    }

    public void finishWithNotMeResult() {
        Intent intent = new Intent();
        intent.putExtra(AbsUnifiedPayEntrancePresenter.EXTRA_CONFIRM_RESULT_KEY, 2);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public void finishWithConfirmResult() {
        Intent intent = new Intent();
        intent.putExtra(AbsUnifiedPayEntrancePresenter.EXTRA_CONFIRM_RESULT_KEY, 1);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f16723d) {
            m14095b();
        } else if (view == this.f16724e) {
            finishWithConfirmResult();
        }
    }

    /* renamed from: b */
    private void m14095b() {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        AlertDialogFragment create = new AlertDialogFragment.Builder(getContext()).setMessage(getString(R.string.pe_pay_confirm_fare_not_me_confirm_dialog_content)).setIcon(AlertController.IconType.INFO).setCancelable(false).setNegativeButton((CharSequence) getString(R.string.pe_pay_confirm_fare_not_me_confirm_dialog_negative_text)).setPositiveButton((CharSequence) getString(R.string.pe_pay_confirm_fare_not_me_confirm_dialog_positive_text), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                ConfirmFareFragment.this.finishWithNotMeResult();
            }
        }).setPositiveButtonDefault().create();
        if (supportFragmentManager != null) {
            try {
                create.show(supportFragmentManager, (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
