package com.didi.unifylogin.view;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.ForgetVerifyEmailPresenter;
import com.didi.unifylogin.presenter.LoginVerifyEmailPresenter;
import com.didi.unifylogin.presenter.ability.IVerifyEmailPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.LoginNextButton;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.IVerifyEmailView;
import com.didi.unifylogin.view.adpter.EmailExportListAdapter;
import com.taxis99.R;

public class VerifyEmailFragment extends AbsLoginBaseFragment<IVerifyEmailPresenter> implements IVerifyEmailView {

    /* renamed from: a */
    EditText f47728a;

    /* renamed from: b */
    LoginNextButton f47729b;

    /* renamed from: c */
    TextView f47730c;

    /* renamed from: d */
    RecyclerView f47731d;

    /* renamed from: com.didi.unifylogin.view.VerifyEmailFragment$3 */
    static /* synthetic */ class C155753 {
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
    public IVerifyEmailPresenter bindPresenter() {
        if (C155753.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.messenger.getScene().ordinal()] != 1) {
            return new LoginVerifyEmailPresenter(this, this.context);
        }
        return new ForgetVerifyEmailPresenter(this, this.context);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_verify_email, viewGroup, false);
        this.f47728a = (EditText) inflate.findViewById(R.id.et_email);
        this.f47729b = (LoginNextButton) inflate.findViewById(R.id.btn_next);
        this.f47730c = (TextView) inflate.findViewById(R.id.tv_hide_email);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_export);
        this.f47731d = recyclerView;
        recyclerView.setAdapter(new EmailExportListAdapter(getBaseActivity(), this.messenger.getTempData()));
        this.f47731d.setLayoutManager(new LinearLayoutManager(getContext()));
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.f47730c.setText(this.messenger.getHideEmail());
    }

    public void initListener() {
        this.f47728a.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                VerifyEmailFragment.this.f47729b.setEnabled(!TextUtil.isEmpty(editable.toString()));
            }
        });
        this.f47729b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((IVerifyEmailPresenter) VerifyEmailFragment.this.presenter).verifyEmail();
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_VERIFY_EMAIL;
    }

    public String getEmail() {
        EditText editText = this.f47728a;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }
}
