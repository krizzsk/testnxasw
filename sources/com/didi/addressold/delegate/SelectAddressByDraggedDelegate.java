package com.didi.addressold.delegate;

import android.text.TextUtils;
import com.didi.address.FromType;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.util.ApolloUtil;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.view.SugSearchView;
import com.didi.addressold.widget.EditTextErasable;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.AddressParam;

public class SelectAddressByDraggedDelegate {

    /* renamed from: a */
    private SugSearchView f9579a;

    /* renamed from: b */
    private AddressParam f9580b;

    /* renamed from: c */
    private int f9581c;

    /* renamed from: d */
    private boolean f9582d = ApolloUtil.canSelectAddressByDragged();

    /* renamed from: e */
    private Address f9583e;

    /* renamed from: f */
    private Address f9584f;

    /* renamed from: g */
    private FromType f9585g;

    public SelectAddressByDraggedDelegate(AddressParam addressParam, FromType fromType) {
        this.f9580b = addressParam;
        this.f9585g = fromType;
        this.f9581c = addressParam.addressType;
    }

    public void setSugSearchView(SugSearchView sugSearchView) {
        this.f9579a = sugSearchView;
    }

    public void setCurrAddressType(int i) {
        this.f9581c = i;
    }

    public Address getStartAddressByDragged() {
        return this.f9583e;
    }

    public Address getEndAddressByDragged() {
        return this.f9584f;
    }

    public boolean canSelectAddressByDragged() {
        if (this.f9582d) {
            if (CommonUtils.isFromHomePage(this.f9585g) || CommonUtils.isFromConfirmPage(this.f9585g)) {
                return true;
            }
            if (!CommonUtils.isFromGetOnPage(this.f9585g) || this.f9581c != 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void onPinLoading(Address address) {
        int i = this.f9581c;
        if (i == 1) {
            this.f9583e = address;
            this.f9584f = null;
            this.f9579a.onStartPoiInfoFetchBefore();
        } else if (i == 2) {
            address.displayName = null;
            this.f9583e = null;
            this.f9584f = address;
            this.f9579a.onEndPoiInfoFetchBefore();
        }
    }

    public void onPinPoiChanged(Address address) {
        EditTextErasable editTextErasable;
        int i = this.f9581c;
        if (i == 1) {
            this.f9583e = address;
            editTextErasable = this.f9579a.getStartEditText();
            this.f9579a.onStartPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(1, 1);
        } else if (i == 2) {
            this.f9584f = address;
            editTextErasable = this.f9579a.getEndEditText();
            this.f9579a.onEndPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(2, 1);
        } else {
            editTextErasable = null;
        }
        if (editTextErasable != null && address != null) {
            editTextErasable.setText(address.displayName);
            if (!TextUtils.isEmpty(address.displayName)) {
                editTextErasable.setSelection(address.displayName.length());
            }
        }
    }

    public void onPinFetchPoiFailed(Address address) {
        EditTextErasable editTextErasable;
        int i = this.f9581c;
        if (i == 1) {
            this.f9583e = address;
            editTextErasable = this.f9579a.getStartEditText();
            this.f9579a.onStartPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(1, 1);
        } else if (i == 2) {
            this.f9584f = address;
            editTextErasable = this.f9579a.getEndEditText();
            this.f9579a.onEndPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(2, 1);
        } else {
            editTextErasable = null;
        }
        if (editTextErasable != null && address != null) {
            editTextErasable.setText(address.displayName);
            if (!TextUtils.isEmpty(address.displayName)) {
                editTextErasable.setSelection(address.displayName.length());
            }
        }
    }
}
