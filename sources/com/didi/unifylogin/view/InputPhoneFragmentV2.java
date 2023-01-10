package com.didi.unifylogin.view;

import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.SPUtils;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.presenter.LoginPhonePresenterV2;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenter;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenterV2;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.IInputPhoneViewV2;
import com.taxis99.R;

public class InputPhoneFragmentV2 extends InputPhoneFragment implements IInputPhoneViewV2 {

    /* renamed from: b */
    private static final String f47704b = "unify_login_image_url_key";

    /* renamed from: c */
    private TextView f47705c;

    /* renamed from: d */
    private TextView f47706d;

    /* renamed from: e */
    private ImageView f47707e;

    /* renamed from: f */
    private View f47708f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IInputPhonePresenterV2 f47709g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f47710h;

    public boolean canSlide() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getVersion() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public View getInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.login_unify_fragment_phone_v2, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        super.initView(view);
        this.f47709g = (IInputPhonePresenterV2) this.presenter;
        this.titleBar.setVisibility(8);
        this.f47708f = view.findViewById(R.id.ll_phone_container);
        this.f47707e = (ImageView) view.findViewById(R.id.iv_login_pre_bg);
        this.lawLayout = (LinearLayout) view.findViewById(R.id.ll_law2);
        this.lawCheckBox = (CheckBox) view.findViewById(R.id.cb_law2);
        this.lawLinkTv = (TextView) view.findViewById(R.id.tv_law2);
        this.lawCheckBox.setChecked(LoginPreferredConfig.getIsLawCbUseCache() && LoginStore.getInstance().isLawChecked());
        this.lawLinkTv.setText(LoginPreferredConfig.getLawHint());
        this.lawCbLl = (LinearLayout) view.findViewById(R.id.ll_cb_law2);
        this.f47705c = (TextView) view.findViewById(R.id.tv_switch_country_code2);
        this.f47706d = (TextView) view.findViewById(R.id.et_phone2);
        m35801a(view.findViewById(R.id.ll_law), false);
        m35801a(view.findViewById(R.id.rl_third_party_hint), false);
        this.f47706d.setText(this.messenger.getCell());
        this.thirdPartyGv = (GridView) view.findViewById(R.id.gv_third_party2);
        this.f47709g.initViewAnimatorHelper(view, this.titleBar);
        this.f47710h = (ImageView) view.findViewById(R.id.iv_clear_phone);
        loadImage("");
    }

    /* renamed from: a */
    private void m35801a(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    public void goBack() {
        if (!this.f47709g.onBackPressed()) {
            super.goBack();
        }
    }

    public boolean onBackPressed() {
        return this.f47709g.onBackPressed();
    }

    public void initListener() {
        super.initListener();
        this.f47708f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputPhoneFragmentV2.this.f47709g.clickPhone();
            }
        });
        this.f47705c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputPhoneFragmentV2.this.f47709g.clickCountry();
            }
        });
        this.f47710h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputPhoneFragmentV2.this.f47709g.clickClearPhone();
            }
        });
        this.phoneEt.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    InputPhoneFragmentV2.this.f47710h.setVisibility(8);
                } else {
                    InputPhoneFragmentV2.this.f47710h.setVisibility(0);
                }
            }
        });
    }

    public void onResume() {
        this.f47709g.preLoginRequest();
        super.onResume();
        this.f47705c.setText(CountryManager.getIns().getDefCountry().calling_code);
    }

    public void loadImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            SPUtils.put(getContext(), f47704b, str);
        } else {
            str = (String) SPUtils.get(getContext(), f47704b, "");
        }
        if (!TextUtils.isEmpty(str)) {
            Glide.with(getContext()).load(str).transition(DrawableTransitionOptions.withCrossFade()).into(this.f47707e);
            new LoginOmegaUtil(LoginOmegaUtil.PUB_IBTPASLOGIN_PHOTE_SW).send();
        }
    }

    /* access modifiers changed from: protected */
    public IInputPhonePresenter bindPresenter() {
        return new LoginPhonePresenterV2(this, this.context);
    }

    /* access modifiers changed from: protected */
    public void thirdPartOmega(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        new LoginOmegaUtil(LoginOmegaUtil.PUB_IBTPASLOGIN_SOCIAL_CK, absThirdPartyLoginBase).send();
    }

    public void clearPhone() {
        this.phoneEt.setText("");
    }
}
