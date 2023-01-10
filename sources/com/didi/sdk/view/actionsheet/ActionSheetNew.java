package com.didi.sdk.view.actionsheet;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.taxis99.R;

public class ActionSheetNew extends ActionSheet {

    /* renamed from: a */
    private View f40650a;

    /* renamed from: b */
    private View f40651b;

    /* renamed from: c */
    private View f40652c;

    /* access modifiers changed from: protected */
    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void initView(View view, String[] strArr) {
        super.initView(view, strArr);
        if (isAdded() && getActivity() != null) {
            this.f40650a = view.findViewById(R.id.cancel_text);
            View findViewById = view.findViewById(R.id.bottom_view_layout);
            this.f40652c = findViewById;
            findViewById.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.down_slide_in));
            this.f40651b = view.findViewById(R.id.menu_list);
        }
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public void dismiss() {
        if (getActivity() != null && this.f40652c != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.down_slide_out_new);
            this.f40652c.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    ActionSheetNew.super.dismissAllowingStateLoss();
                }
            });
        }
    }
}
