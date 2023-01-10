package com.didi.consume.phone.view.widget;

import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.phone.view.contract.CsCountryCodePickerContract;
import com.didi.consume.phone.view.picker.WheelView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;
import java.util.List;

public class CountryCodePickerFragment extends SimplePopupBase {

    /* renamed from: a */
    private static final String f18264a = "CountryCodePicker";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WheelView f18265b;

    /* renamed from: c */
    private TextView f18266c;

    /* renamed from: d */
    private List<String> f18267d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CsCountryCodePickerContract f18268e;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.cs_countrycode_picker;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f18265b = (WheelView) this.mRootView.findViewById(R.id.wv_phone_num_countrycode);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.btn_phone_num_countrycode_picker_ok);
        this.f18266c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CountryCodePickerFragment.this.f18268e != null) {
                    CountryCodePickerFragment.this.f18268e.onCountryCodeSelected(CountryCodePickerFragment.this.f18265b.getSeletedItem());
                }
            }
        });
        m15444a(this.f18267d);
    }

    public void setData(List<String> list) {
        this.f18267d = list;
    }

    public void setWalletSendEmailContract(CsCountryCodePickerContract csCountryCodePickerContract) {
        this.f18268e = csCountryCodePickerContract;
    }

    /* renamed from: a */
    private void m15444a(List<String> list) {
        if (list != null && list.size() != 0) {
            this.f18265b.setOffset(1);
            this.f18265b.setItems(list);
            this.f18265b.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                public void onSelected(int i, String str) {
                    SystemUtils.log(3, CountryCodePickerFragment.f18264a, "selectedIndex: " + i + ", item: " + str, (Throwable) null, "com.didi.consume.phone.view.widget.CountryCodePickerFragment$2", 63);
                }
            });
        }
    }

    public void dismissEmailDialog() {
        dismissAllowingStateLoss();
    }
}
