package com.didi.map.sdk.sharetrack.external.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.map.sdk.sharetrack.external.view.INavigationGuidanceView;
import java.util.HashMap;

public class NavGuidanceView extends FrameLayout implements INavigationGuidanceView {

    /* renamed from: a */
    private static final String f31194a = "NavGuidanceView";

    /* renamed from: b */
    private INavCardView f31195b;

    /* renamed from: c */
    private Context f31196c;

    /* renamed from: d */
    private HashMap<String, INavCardView> f31197d;

    public NavGuidanceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavGuidanceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavGuidanceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23867a(context);
    }

    /* renamed from: a */
    private void m23867a(Context context) {
        if (context != null) {
            this.f31196c = context;
            this.f31197d = new HashMap<>();
        }
    }

    public void setDestinationText(String str) {
        INavCardView iNavCardView = this.f31195b;
        if (iNavCardView != null) {
            iNavCardView.setDestinationText(str);
        }
    }

    public void setEDAETAText(String str) {
        INavCardView iNavCardView = this.f31195b;
        if (iNavCardView != null) {
            iNavCardView.onETAEDAChanged(str);
        }
    }

    public void setOnNavigationBtnClickListener(INavigationGuidanceView.INavigationBtnClickListener iNavigationBtnClickListener) {
        INavCardView iNavCardView = this.f31195b;
        if (iNavCardView != null) {
            iNavCardView.setOnNavigationBtnClickListener(iNavigationBtnClickListener);
        }
    }

    public void setIsInNightModeForcible(boolean z) {
        INavCardView iNavCardView = this.f31195b;
        if (iNavCardView != null) {
            iNavCardView.setIsInNightModeForcible(z);
        }
    }
}
