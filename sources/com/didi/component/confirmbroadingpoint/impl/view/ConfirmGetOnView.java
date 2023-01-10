package com.didi.component.confirmbroadingpoint.impl.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.confirmbroadingpoint.AbsConfirmBroadingPointPresenter;
import com.didi.component.confirmbroadingpoint.IConfirmBroadingPointView;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.taxis99.R;

public class ConfirmGetOnView implements View.OnClickListener, IConfirmBroadingPointView {

    /* renamed from: a */
    private final Context f14511a;

    /* renamed from: b */
    private final View f14512b;

    /* renamed from: c */
    private AbsConfirmBroadingPointPresenter f14513c;

    /* renamed from: d */
    private FrameLayout f14514d;

    public void enableConfirm(boolean z) {
    }

    public void enableContent(boolean z) {
    }

    public TextView getMainTitleView() {
        return null;
    }

    public TextView getSubTitleView() {
        return null;
    }

    public void hideSubTitle() {
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public void setConfirmAction(String str) {
    }

    public void setContent(CharSequence charSequence) {
    }

    public void setContentColor(int i) {
    }

    public void setSubTitle(CharSequence charSequence) {
    }

    public void setSubTitleColor(int i) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public void setVisible(boolean z) {
    }

    public void showError() {
    }

    public void showLoading() {
    }

    public void showSubTitle() {
    }

    public void stopLoading() {
    }

    public ConfirmGetOnView(Activity activity, ViewGroup viewGroup) {
        this.f14511a = activity;
        LayoutInflater from = LayoutInflater.from(activity);
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.global_confirm_broading_point_layout_new_ui);
        viewByResId = viewByResId == null ? from.inflate(R.layout.global_confirm_broading_point_layout_new_ui, viewGroup, false) : viewByResId;
        this.f14512b = viewByResId;
        this.f14514d = (FrameLayout) viewByResId.findViewById(R.id.normal_card_container);
    }

    public void setNormalCardView(View view) {
        if (this.f14514d != null && view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f14514d.removeAllViews();
            this.f14514d.addView(view);
        }
    }

    public void setNormalVisible(int i) {
        FrameLayout frameLayout = this.f14514d;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }

    public void setPresenter(AbsConfirmBroadingPointPresenter absConfirmBroadingPointPresenter) {
        this.f14513c = absConfirmBroadingPointPresenter;
    }

    public View getView() {
        return this.f14512b;
    }
}
