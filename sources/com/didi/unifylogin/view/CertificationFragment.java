package com.didi.unifylogin.view;

import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.presenter.ForgetCertificationPresenter;
import com.didi.unifylogin.presenter.LoginCertificationPresenter;
import com.didi.unifylogin.presenter.ability.ICertificationPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.LoginNextButton;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.ICertificationView;
import com.taxis99.R;

public class CertificationFragment extends AbsLoginBaseFragment<ICertificationPresenter> implements ICertificationView {

    /* renamed from: a */
    EditText f47672a;

    /* renamed from: b */
    EditText f47673b;

    /* renamed from: c */
    EditText f47674c;

    /* renamed from: d */
    TextView f47675d;

    /* renamed from: e */
    TextView f47676e;

    /* renamed from: f */
    TextView f47677f;

    /* renamed from: g */
    LoginNextButton f47678g;

    /* access modifiers changed from: protected */
    public void setScrolLayoutChange(ScrollView scrollView) {
    }

    /* renamed from: com.didi.unifylogin.view.CertificationFragment$2 */
    static /* synthetic */ class C154792 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginScene;

        static {
            int[] iArr = new int[LoginScene.values().length];
            $SwitchMap$com$didi$unifylogin$base$net$LoginScene = iArr;
            try {
                iArr[LoginScene.SCENE_FORGETPWD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public ICertificationPresenter bindPresenter() {
        if (C154792.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.messenger.getScene().ordinal()] != 1) {
            return new LoginCertificationPresenter(this, this.context);
        }
        return new ForgetCertificationPresenter(this, this.context);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_certification, viewGroup, false);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.f47672a = (EditText) inflate.findViewById(R.id.et_name);
        this.f47673b = (EditText) inflate.findViewById(R.id.et_last_name);
        this.f47674c = (EditText) inflate.findViewById(R.id.et_id_num);
        this.f47678g = (LoginNextButton) inflate.findViewById(R.id.btn_next);
        this.f47675d = (TextView) inflate.findViewById(R.id.tv_last_name_hint);
        this.f47676e = (TextView) inflate.findViewById(R.id.tv_name_hint);
        this.f47677f = (TextView) inflate.findViewById(R.id.tv_certification_num_hint);
        return inflate;
    }

    public void initListener() {
        this.f47678g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((ICertificationPresenter) CertificationFragment.this.presenter).certification();
            }
        });
        this.f47673b.addTextChangedListener(new CertifiCationTextWatcher());
        this.f47672a.addTextChangedListener(new CertifiCationTextWatcher());
        this.f47674c.addTextChangedListener(new CertifiCationTextWatcher());
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        if (!TextUtils.isEmpty(this.messenger.getCredential())) {
            this.f47677f.setText(this.messenger.getCredential());
        }
        if (CountryManager.getIns().getCurrentCountry() != null && CountryManager.getIns().getCurrentCountry().country_id == 156) {
            this.f47673b.setVisibility(8);
            this.f47675d.setVisibility(8);
            this.f47676e.setText(getText(R.string.login_unify_certification_name_hint));
        }
    }

    public LoginState getNowState() {
        return LoginState.STATE_CERTIFICATION;
    }

    public String getName() {
        EditText editText = this.f47672a;
        if (editText != null) {
            return editText.getText().toString().trim();
        }
        return null;
    }

    public String getLastName() {
        EditText editText = this.f47673b;
        if (editText != null) {
            return editText.getText().toString().trim();
        }
        return null;
    }

    public String getIdNum() {
        EditText editText = this.f47674c;
        if (editText != null) {
            return editText.getText().toString().trim();
        }
        return null;
    }

    class CertifiCationTextWatcher extends LoginTextWatcher {
        CertifiCationTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
            boolean z = false;
            boolean z2 = CertificationFragment.this.f47672a.getVisibility() != 0 || !TextUtils.isEmpty(CertificationFragment.this.f47672a.getText());
            if (CertificationFragment.this.f47673b.getVisibility() == 0 && TextUtils.isEmpty(CertificationFragment.this.f47673b.getText())) {
                z2 = false;
            }
            if (CertificationFragment.this.f47674c.getVisibility() != 0 || !TextUtils.isEmpty(CertificationFragment.this.f47674c.getText())) {
                z = z2;
            }
            CertificationFragment.this.f47678g.setEnabled(z);
        }
    }
}
