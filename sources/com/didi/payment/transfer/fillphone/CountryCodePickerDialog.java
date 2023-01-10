package com.didi.payment.transfer.fillphone;

import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.widget.PickerWheelView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;
import java.util.List;

public class CountryCodePickerDialog extends SimplePopupBase {

    /* renamed from: a */
    private static final String f33909a = "CountryCodePicker";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public PickerWheelView f33910b;

    /* renamed from: c */
    private TextView f33911c;

    /* renamed from: d */
    private List<String> f33912d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CountryCodeSelectedListener f33913e;

    public interface CountryCodeSelectedListener {
        void onCountryCodeSelected(String str);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.trans_countrycode_picker;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f33910b = (PickerWheelView) this.mRootView.findViewById(R.id.trans_wv_phone_num_countrycode);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.trans_cfm_phone_countrycode_btn);
        this.f33911c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CountryCodePickerDialog.this.f33913e != null) {
                    CountryCodePickerDialog.this.f33913e.onCountryCodeSelected(CountryCodePickerDialog.this.f33910b.getSeletedItem());
                }
            }
        });
        m25792a(this.f33912d);
    }

    public void setData(List<String> list) {
        this.f33912d = list;
    }

    /* renamed from: a */
    private void m25792a(List<String> list) {
        if (list != null && list.size() != 0) {
            this.f33910b.setOffset(1);
            this.f33910b.setItems(list);
            this.f33910b.setOnWheelViewListener(new PickerWheelView.OnWheelViewListener() {
                public void onSelected(int i, String str) {
                    SystemUtils.log(3, CountryCodePickerDialog.f33909a, "selectedIndex: " + i + ", item: " + str, (Throwable) null, "com.didi.payment.transfer.fillphone.CountryCodePickerDialog$2", 59);
                }
            });
        }
    }

    public void dismissEmailDialog() {
        dismissAllowingStateLoss();
    }

    public void setWalletSendEmailContract(CountryCodeSelectedListener countryCodeSelectedListener) {
        this.f33913e = countryCodeSelectedListener;
    }
}
