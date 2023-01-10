package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.net.pojo.response.DeleteUserResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.DeleteAccountFailedPresenter;
import com.didi.unifylogin.presenter.ability.IDeleteAccountFailedPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IDeleteAccountFailedView;
import com.didi.unifylogin.view.adpter.DeleteAccountFailedTextStyleAdapter;
import com.taxis99.R;
import java.util.List;

public class DeleteAccountFailedTextStyleFragment extends AbsLoginBaseFragment<IDeleteAccountFailedPresenter> implements IDeleteAccountFailedView {

    /* renamed from: a */
    private RecyclerView f47682a;

    /* renamed from: b */
    private DeleteAccountFailedTextStyleAdapter f47683b;
    protected Button nextBtn;

    public boolean canSlide() {
        return false;
    }

    public void updateSubTitleText(String str) {
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_delete_account_failed_text_style, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.f47682a = (RecyclerView) inflate.findViewById(R.id.rv_failed_texts);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setTitleBarCenterMsg(getResources().getString(R.string.commonapi_sidebar_menu_25));
        setTitleBarCenterVisible(true);
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((IDeleteAccountFailedPresenter) DeleteAccountFailedTextStyleFragment.this.presenter).pressNext();
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_DELETE_ACCOUNT_FAILED_TEXT_STYLE;
    }

    /* access modifiers changed from: protected */
    public IDeleteAccountFailedPresenter bindPresenter() {
        return new DeleteAccountFailedPresenter(this, this.context);
    }

    public void setNextBtn(String str) {
        Button button = this.nextBtn;
        if (button != null) {
            button.setText(str);
        }
    }

    public void updateDeleteAccountFailTexts(List<DeleteUserResponse.DeleteContent> list) {
        if (list != null && list.size() > 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
            linearLayoutManager.setOrientation(1);
            this.f47682a.setLayoutManager(linearLayoutManager);
            DeleteAccountFailedTextStyleAdapter deleteAccountFailedTextStyleAdapter = new DeleteAccountFailedTextStyleAdapter(list);
            this.f47683b = deleteAccountFailedTextStyleAdapter;
            this.f47682a.setAdapter(deleteAccountFailedTextStyleAdapter);
        }
    }

    public void updatePrompTitleText(String str) {
        this.titleTv.setText(str);
    }
}
