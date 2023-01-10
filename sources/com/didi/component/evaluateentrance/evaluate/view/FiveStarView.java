package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.widget.FrameLayout;
import com.didi.component.evaluateentrance.evaluate.model.FiveStarModel;

public class FiveStarView extends AbsFiveStarView {

    /* renamed from: a */
    private IFiveStarView f15380a;

    public FiveStarView(Context context) {
        super(context);
        this.parentView = new FrameLayout(context);
        this.parentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void initData(FiveStarModel fiveStarModel) {
        if (fiveStarModel != null && fiveStarModel.normal != null) {
            this.parentView.removeAllViews();
            if (fiveStarModel.normal.status == 0) {
                IFiveStarView iFiveStarView = this.f15380a;
                if (iFiveStarView == null || !(iFiveStarView instanceof FiveStarUnevaluatedView)) {
                    this.f15380a = new FiveStarUnevaluatedView(this.context);
                }
            } else {
                IFiveStarView iFiveStarView2 = this.f15380a;
                if (iFiveStarView2 == null || !(iFiveStarView2 instanceof FiveStarEvaluatedView)) {
                    this.f15380a = new FiveStarEvaluatedView(this.context);
                }
            }
            this.parentView.addView(this.f15380a.getView());
            this.f15380a.setPresenter(this.presenter);
            this.f15380a.initData(fiveStarModel);
        }
    }

    public void showEvaluated(int i) {
        IFiveStarView iFiveStarView = this.f15380a;
        if (iFiveStarView != null) {
            iFiveStarView.showEvaluated(i);
        }
    }
}
