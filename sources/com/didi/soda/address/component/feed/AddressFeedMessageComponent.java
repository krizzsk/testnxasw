package com.didi.soda.address.component.feed;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class AddressFeedMessageComponent extends MvpComponent<AddressFeedMessageView, C14191a> {
    public AddressFeedMessageComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public AddressFeedMessageView onCreateView() {
        return new AddressFeedMessageView();
    }

    /* access modifiers changed from: protected */
    public C14191a onCreatePresenter() {
        return new C14191a();
    }
}
