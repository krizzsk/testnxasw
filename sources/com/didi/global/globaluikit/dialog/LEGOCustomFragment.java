package com.didi.global.globaluikit.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.globaluikit.button.UnitUtils;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;

public class LEGOCustomFragment extends LEGOBaseAlertDialogFragment {

    /* renamed from: a */
    private View f24401a;

    public static LEGOCustomFragment getInstance() {
        return new LEGOCustomFragment();
    }

    public void setRootView(View view) {
        RoundCornerRelativeLayout roundCornerRelativeLayout = new RoundCornerRelativeLayout(view.getContext());
        roundCornerRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        roundCornerRelativeLayout.setRadius(UnitUtils.dp2px(view.getContext(), 20.0f));
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        roundCornerRelativeLayout.addView(view);
        this.f24401a = roundCornerRelativeLayout;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f24401a;
    }
}
