package com.didi.component.service.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.cpf.CPFAuthWebActivity;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.travel.psnger.model.CommonPopUp;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class CPFBlockingPopup extends SimplePopupBase {

    /* renamed from: a */
    private static final String f17671a = "BLOCKING_DATA_KEY";

    /* renamed from: b */
    private static final String f17672b = "BLOCKING_EXTENSION";

    /* renamed from: c */
    private static final String f17673c = "BLOCKING_AUTH_URL";

    /* renamed from: d */
    private static final int f17674d = 0;

    /* renamed from: e */
    private static final int f17675e = 1;

    /* renamed from: f */
    private TextView f17676f;

    /* renamed from: g */
    private TextView f17677g;

    /* renamed from: h */
    private TextView f17678h;

    /* renamed from: i */
    private TextView f17679i;

    /* renamed from: j */
    private TextView f17680j;

    /* renamed from: k */
    private ImageView f17681k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f17682l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f17683m;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_cpf_blocking_popup_new_ui;
    }

    public static CPFBlockingPopup getInstance(CommonPopUp commonPopUp, String str, String str2) {
        CPFBlockingPopup cPFBlockingPopup = new CPFBlockingPopup();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f17671a, commonPopUp);
        bundle.putSerializable(f17673c, str);
        bundle.putString(f17672b, str2);
        cPFBlockingPopup.setArguments(bundle);
        return cPFBlockingPopup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f17676f = (TextView) this.mRootView.findViewById(R.id.cpf_blocking_title);
            this.f17677g = (TextView) this.mRootView.findViewById(R.id.cpf_blocking_content);
            this.f17678h = (TextView) this.mRootView.findViewById(R.id.cpf_blocking_selection_left);
            this.f17679i = (TextView) this.mRootView.findViewById(R.id.cpf_blocking_selection_right);
            this.f17680j = (TextView) this.mRootView.findViewById(R.id.cpf_blocking_confirm_btn);
            this.f17681k = (ImageView) this.mRootView.findViewById(R.id.cpf_blocking_close_btn);
            CommonPopUp commonPopUp = null;
            if (getArguments() != null) {
                commonPopUp = (CommonPopUp) getArguments().getSerializable(f17671a);
                this.f17682l = getArguments().getString(f17673c);
                this.f17683m = getArguments().getString(f17672b);
            }
            if (commonPopUp != null && commonPopUp.selection != null && commonPopUp.selection.size() >= 2 && commonPopUp.options != null && commonPopUp.options.size() >= 2) {
                HashMap hashMap = new HashMap();
                hashMap.put("title", commonPopUp.title);
                hashMap.put("subtitle", commonPopUp.showMsg);
                OmegaSDKAdapter.trackEvent("gp_CPFpopup_view_sw", (Map<String, Object>) hashMap);
                try {
                    this.f17676f.setText(commonPopUp.title);
                    this.f17677g.setText(commonPopUp.showMsg);
                    this.f17678h.setText(commonPopUp.selection.get(0).text);
                    this.f17679i.setText(commonPopUp.selection.get(1).text);
                    this.f17681k.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            CPFBlockingPopup.this.dismiss();
                        }
                    });
                    this.f17679i.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                            addCardParam.bindType = 15;
                            addCardParam.isShowLoading = false;
                            DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity((Fragment) CPFBlockingPopup.this, 73, addCardParam);
                            OmegaSDKAdapter.trackEvent("gp_CPFpopup_usecredit_btn_ck");
                        }
                    });
                    for (CommonPopUp.PopUpOptions next : commonPopUp.options) {
                        if (next.type != 0 && next.type == 1) {
                            this.f17680j.setText(next.text);
                        }
                    }
                    this.f17680j.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            String authH5UrlWithSourceAdded = DDTravelConfigStore.getInstance().getAuthH5UrlWithSourceAdded(3, CPFBlockingPopup.this.f17682l);
                            if (!TextUtils.isEmpty(authH5UrlWithSourceAdded)) {
                                Intent intent = new Intent(activity, CPFAuthWebActivity.class);
                                CPFBlockingPopup cPFBlockingPopup = CPFBlockingPopup.this;
                                intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(GlobalWebUrl.buildUrl(authH5UrlWithSourceAdded, cPFBlockingPopup.m14962a(cPFBlockingPopup.f17683m))));
                                intent.putExtra("CPF_AUTH_SOURCE_KEY", 3);
                                CPFBlockingPopup.this.startActivityForResult(intent, 72);
                                OmegaSDKAdapter.trackEvent("gp_CPFpopup_fillin_btn_ck");
                            }
                        }
                    });
                    setCancelable(false);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, Object> m14962a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 72) {
            if (i != 73) {
                return;
            }
        } else if (i2 == 0 && intent != null && intent.getBooleanExtra(BaseEventKeys.Confirm.INTENT_KEY_SIGN_CREDIT_CARD, false)) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_ONE_KEY_SEND_ORDER_BLOCKING_BY_CPF);
        }
        dismiss();
    }

    public void show(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            show(fragmentManager, CPFBlockingPopup.class.getName());
        }
    }
}
