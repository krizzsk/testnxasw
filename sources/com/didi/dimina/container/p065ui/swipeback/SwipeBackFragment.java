package com.didi.dimina.container.p065ui.swipeback;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.didi.dimina.container.p065ui.swipeback.SwipeBackLayout;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackFragment */
public class SwipeBackFragment extends Fragment {

    /* renamed from: a */
    private static final String f19668a = "SWIPEBACKFRAGMENT_STATE_SAVE_IS_HIDDEN";
    protected Activity _mActivity;

    /* renamed from: b */
    boolean f19669b = false;

    /* renamed from: c */
    private SwipeBackLayout f19670c;

    /* renamed from: d */
    private Animation f19671d;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this._mActivity = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            boolean z = bundle.getBoolean(f19668a);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            if (z) {
                beginTransaction.hide(this);
            } else {
                beginTransaction.show(this);
            }
            beginTransaction.commit();
        }
        this.f19671d = AnimationUtils.loadAnimation(getActivity(), R.anim.dimina_no_anim);
        m16723a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f19668a, isHidden());
    }

    /* renamed from: a */
    private void m16723a() {
        this.f19670c = new SwipeBackLayout(getActivity());
        this.f19670c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f19670c.setBackgroundColor(0);
    }

    /* access modifiers changed from: protected */
    public View attachToSwipeBack(View view) {
        this.f19670c.attachToFragment(this, view);
        return this.f19670c;
    }

    /* access modifiers changed from: protected */
    public View attachToSwipeBack(View view, SwipeBackLayout.EdgeLevel edgeLevel) {
        this.f19670c.attachToFragment(this, view);
        this.f19670c.setEdgeLevel(edgeLevel);
        return this.f19670c;
    }

    /* access modifiers changed from: protected */
    public void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
        this.f19670c.setEdgeLevel(edgeLevel);
    }

    /* access modifiers changed from: protected */
    public void setEdgeLevel(int i) {
        this.f19670c.setEdgeLevel(i);
    }

    public void onHiddenChanged(boolean z) {
        SwipeBackLayout swipeBackLayout;
        super.onHiddenChanged(z);
        if (z && (swipeBackLayout = this.f19670c) != null) {
            swipeBackLayout.hiddenPreView();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        SwipeBackLayout swipeBackLayout = this.f19670c;
        if (swipeBackLayout != null) {
            swipeBackLayout.hiddenPreView();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        m16724a(view);
        if (view != null) {
            view.setClickable(true);
        }
    }

    /* renamed from: a */
    private void m16724a(View view) {
        if (view instanceof SwipeBackLayout) {
            m16725b(((SwipeBackLayout) view).getChildAt(0));
        } else {
            m16725b(view);
        }
    }

    /* renamed from: b */
    private void m16725b(View view) {
        if (view != null && view.getBackground() == null) {
            int i = 0;
            Activity activity = this._mActivity;
            if (activity instanceof SwipeBackActivity) {
                i = ((SwipeBackActivity) activity).mo61653b();
            }
            if (i == 0) {
                view.setBackgroundResource(getWindowBackground());
            } else {
                view.setBackgroundResource(i);
            }
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (this.f19669b) {
            return this.f19671d;
        }
        return super.onCreateAnimation(i, z, i2);
    }

    /* access modifiers changed from: protected */
    public int getWindowBackground() {
        TypedArray obtainStyledAttributes = getActivity().getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.f19670c;
    }

    public void setSwipeBackEnable(boolean z) {
        this.f19670c.setEnableGesture(z);
    }
}
