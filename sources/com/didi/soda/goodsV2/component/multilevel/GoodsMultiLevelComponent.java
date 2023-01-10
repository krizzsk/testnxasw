package com.didi.soda.goodsV2.component.multilevel;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class GoodsMultiLevelComponent extends MvpComponent<C14705b, C14704a> {

    /* renamed from: a */
    private C14704a f44922a;

    public GoodsMultiLevelComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        C14704a aVar = this.f44922a;
        if (aVar != null) {
            aVar.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public C14705b onCreateView() {
        return new C14705b();
    }

    /* access modifiers changed from: protected */
    public C14704a onCreatePresenter() {
        C14704a aVar = new C14704a();
        this.f44922a = aVar;
        return aVar;
    }
}
