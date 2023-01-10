package com.didi.soda.home.component.web;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class WebHomeView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WebHomeView f45106a;

    public WebHomeView_ViewBinding(WebHomeView webHomeView, View view) {
        this.f45106a = webHomeView;
        webHomeView.mWebLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.web_home_layout, "field 'mWebLayout'", FrameLayout.class);
    }

    public void unbind() {
        WebHomeView webHomeView = this.f45106a;
        if (webHomeView != null) {
            this.f45106a = null;
            webHomeView.mWebLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
