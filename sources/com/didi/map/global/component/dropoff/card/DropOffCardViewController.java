package com.didi.map.global.component.dropoff.card;

import android.content.Context;
import android.view.View;
import com.didi.map.global.component.dropoff.card.IDropOffCard;
import com.didi.map.global.component.dropoff.model.DropOffAddress;

public class DropOffCardViewController {

    /* renamed from: a */
    private Context f27710a;

    /* renamed from: b */
    private int f27711b = 1;

    /* renamed from: c */
    private DropOffConfirmCardView f27712c;

    /* renamed from: d */
    private IDropOffCard.DropOffCardCallback f27713d;

    public DropOffCardViewController(Context context, IDropOffCard.DropOffCardCallback dropOffCardCallback) {
        this.f27710a = context;
        this.f27713d = dropOffCardCallback;
    }

    public View getView(int i, DropOffAddress dropOffAddress) {
        this.f27711b = 1;
        if (this.f27712c == null) {
            DropOffConfirmCardView dropOffConfirmCardView = (DropOffConfirmCardView) DropOffCardFactory.getCardView(this.f27710a, 1);
            this.f27712c = dropOffConfirmCardView;
            dropOffConfirmCardView.setCardCallback(this.f27713d);
        }
        this.f27712c.updateCard(dropOffAddress);
        return this.f27712c;
    }

    public View onDataLoading() {
        if (this.f27712c == null) {
            DropOffConfirmCardView dropOffConfirmCardView = (DropOffConfirmCardView) DropOffCardFactory.getCardView(this.f27710a, 1);
            this.f27712c = dropOffConfirmCardView;
            dropOffConfirmCardView.setCardCallback(this.f27713d);
        }
        this.f27712c.onDataLoading();
        return this.f27712c;
    }

    public void setAddressName(String str) {
        DropOffConfirmCardView dropOffConfirmCardView = this.f27712c;
        if (dropOffConfirmCardView != null) {
            dropOffConfirmCardView.setAddressNameText(str);
        }
    }

    public void setSubTitle(String str) {
        DropOffConfirmCardView dropOffConfirmCardView = this.f27712c;
        if (dropOffConfirmCardView != null) {
            dropOffConfirmCardView.setSubTitleText(str);
        }
    }
}
