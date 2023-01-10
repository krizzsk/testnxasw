package com.didi.soda.customer.widget.loading.render;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.taxis99.R;

public class ProgressBarLoadingRender extends BaseLoadingRender {
    public static String sIndeterminateDrawableId = "Loading::ProgressBar::Indeterminate::Drawable::Id";

    /* renamed from: b */
    private ProgressBar f44677b;

    public boolean isRunning() {
        return this.f44677b.isIndeterminate() && this.f44677b.getWindowVisibility() == 0 && this.f44677b.isShown();
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        this.f44677b = (ProgressBar) LayoutInflater.from(context).inflate(R.layout.loading_progressbar, (ViewGroup) null);
        int i = bundle.getInt(sIndeterminateDrawableId);
        if (i != 0) {
            this.f44677b.setIndeterminateDrawable(context.getResources().getDrawable(i));
        }
        if (bundle.getInt("Loading::Interpolator::Id") != 0) {
            this.f44677b.setInterpolator(context, bundle.getInt("Loading::Interpolator::Id"));
        }
        this.f44677b.setBackgroundColor(bundle.getInt("Loading::Background::Color", 0));
        return this.f44677b;
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        this.f44677b.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f44677b.setVisibility(8);
    }
}
