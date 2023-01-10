package com.didi.unifylogin.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.pojo.entity.PromptPageData;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.view.adpter.HintDesListAdapter;
import com.taxis99.R;

public abstract class AbsPromptFragment extends AbsLoginBaseFragment {

    /* renamed from: a */
    TextView f47666a;

    /* renamed from: b */
    TextView f47667b;

    /* renamed from: c */
    TextView f47668c;

    /* renamed from: d */
    ListView f47669d;

    /* renamed from: e */
    Button f47670e;

    public boolean canSlide() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_prompt, viewGroup, false);
        this.f47666a = (TextView) inflate.findViewById(R.id.tv_title);
        this.f47667b = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.f47668c = (TextView) inflate.findViewById(R.id.tv_sub_sencend_title);
        this.f47669d = (ListView) inflate.findViewById(R.id.lv_des);
        this.f47670e = (Button) inflate.findViewById(R.id.btn_next);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        PromptPageData promptPageData = this.messenger.getPromptPageData();
        if (promptPageData != null) {
            this.f47666a.setText(promptPageData.getTitle());
            this.f47667b.setText(promptPageData.getSubTitle());
            if (!TextUtil.isEmpty(promptPageData.getSubSecondTitle())) {
                this.f47668c.setText(promptPageData.getSubSecondTitle());
                this.f47668c.setVisibility(0);
            }
            this.f47669d.setAdapter(new HintDesListAdapter(this.context, promptPageData.getContents()));
            this.f47670e.setText(promptPageData.getBtnStr());
        }
    }

    /* access modifiers changed from: protected */
    public ILoginBasePresenter bindPresenter() {
        return new LoginBasePresenter(this, this.context);
    }
}
