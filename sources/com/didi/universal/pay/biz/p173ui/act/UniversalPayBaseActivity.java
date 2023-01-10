package com.didi.universal.pay.biz.p173ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.universal.pay.biz.p173ui.IUniversalPayView;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.util.JsonUtil;
import com.didi.universal.pay.sdk.util.UniversalPayConstant;
import com.taxis99.R;
import java.io.Serializable;

/* renamed from: com.didi.universal.pay.biz.ui.act.UniversalPayBaseActivity */
public abstract class UniversalPayBaseActivity extends FragmentActivity {

    /* renamed from: a */
    private UniversalPayParams f47764a;

    /* renamed from: b */
    private IUniversalPayView f47765b;

    public abstract ViewGroup getContentView();

    public abstract IUniversalPayView getPayView();

    public abstract ViewGroup getPayViewContainer();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        SystemUtil.init(this);
        Bundle extras = getIntent().getExtras();
        m35869a(extras);
        try {
            serializable = extras.getSerializable(UniversalPayConstant.Params.KEY_PARAMS);
        } catch (Exception e) {
            e.printStackTrace();
            serializable = null;
        }
        m35869a(serializable);
        if (serializable instanceof String) {
            String str = (String) serializable;
            if (TextUtils.isEmpty(str)) {
                finish();
            }
            this.f47764a = (UniversalPayParams) JsonUtil.objectFromJson(str, UniversalPayParams.class);
            extras.remove(UniversalPayConstant.Params.KEY_PARAMS);
            extras.putSerializable(UniversalPayConstant.Params.KEY_PARAMS, this.f47764a);
        } else if (serializable instanceof UniversalPayParams) {
            this.f47764a = (UniversalPayParams) serializable;
        }
        m35869a(this.f47764a);
        setContentView((View) getContentView());
        ViewGroup payViewContainer = getPayViewContainer();
        this.f47765b = getPayView();
        payViewContainer.removeAllViews();
        payViewContainer.addView(this.f47765b.getView());
        overridePendingTransition(R.anim.bottom_in, 0);
    }

    /* renamed from: a */
    private void m35869a(Object obj) {
        if (obj == null) {
            finish();
        }
    }

    public UniversalPayParams getPayParam() {
        return this.f47764a;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.bottom_out);
    }

    public void finishWithSuccess() {
        Intent intent = new Intent();
        intent.putExtra("code", 1);
        setResult(-1, intent);
        finish();
    }

    public void finishWithCancel() {
        Intent intent = new Intent();
        intent.putExtra("code", 2);
        setResult(-1, intent);
        finish();
    }
}
