package com.didi.addressold.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.addressold.util.CommonUtils;
import com.didi.sdk.address.address.entity.Address;
import com.taxis99.R;

public class CommonAddressView extends LinearLayout {

    /* renamed from: a */
    private LinearLayout f9718a;

    /* renamed from: b */
    private ViewGroup f9719b;

    /* renamed from: c */
    private TextView f9720c;

    /* renamed from: d */
    private ViewGroup f9721d;

    /* renamed from: e */
    private TextView f9722e;

    /* renamed from: f */
    private ViewGroup f9723f;

    /* renamed from: g */
    private Address f9724g;

    /* renamed from: h */
    private Address f9725h;

    /* renamed from: i */
    private TextView f9726i;

    /* renamed from: j */
    private TextView f9727j;

    /* renamed from: k */
    private LinearLayout f9728k;

    /* renamed from: l */
    private TextView f9729l;

    /* renamed from: m */
    private LinearLayout f9730m;

    /* renamed from: n */
    private TextView f9731n;

    public CommonAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommonAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9719b = null;
        this.f9720c = null;
        this.f9721d = null;
        this.f9722e = null;
        this.f9723f = null;
        this.f9724g = null;
        this.f9725h = null;
        this.f9726i = null;
        this.f9727j = null;
        this.f9728k = null;
        this.f9729l = null;
        this.f9730m = null;
        this.f9731n = null;
        LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_common_address_view, this);
        this.f9718a = (LinearLayout) findViewById(R.id.home_company_layout);
        this.f9719b = (ViewGroup) findViewById(R.id.layout_home);
        this.f9720c = (TextView) findViewById(R.id.text_home_content);
        this.f9726i = (TextView) findViewById(R.id.text_home_title);
        this.f9721d = (ViewGroup) findViewById(R.id.layout_company);
        this.f9722e = (TextView) findViewById(R.id.text_company_content);
        this.f9727j = (TextView) findViewById(R.id.text_company_title);
        this.f9723f = (ViewGroup) findViewById(R.id.favorite_place_layout);
        this.f9728k = (LinearLayout) findViewById(R.id.home_container);
        this.f9729l = (TextView) findViewById(R.id.text_home_not_set);
        this.f9730m = (LinearLayout) findViewById(R.id.company_container);
        this.f9731n = (TextView) findViewById(R.id.text_company_not_set);
    }

    public void setHomeCompanyLayoutVisibility(int i) {
        this.f9718a.setVisibility(i);
    }

    public void setCommonAddressLayoutVisibility(int i) {
        this.f9723f.setVisibility(i);
    }

    public void setHome(Address address) {
        this.f9724g = address;
        if (this.f9720c == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f9729l.setVisibility(0);
            this.f9728k.setVisibility(8);
            this.f9729l.setText(R.string.global_sug_add_home);
            return;
        }
        this.f9728k.setVisibility(0);
        this.f9729l.setVisibility(8);
        this.f9720c.setText(address.displayName);
    }

    public void setCompany(Address address) {
        this.f9725h = address;
        if (this.f9722e == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f9731n.setVisibility(0);
            this.f9730m.setVisibility(8);
            this.f9731n.setText(R.string.global_sug_add_company);
            return;
        }
        this.f9730m.setVisibility(0);
        this.f9731n.setVisibility(8);
        this.f9722e.setText(address.displayName);
    }

    public Address getHomeAddress() {
        return this.f9724g;
    }

    public Address getCompanyAddress() {
        return this.f9725h;
    }

    public void setHomeClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f9719b;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCompanyClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f9721d;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCommonAddressClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f9723f;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.savedHomeAddress = this.f9724g;
        savedState.savedCompanyAddress = this.f9725h;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setHome(savedState.savedHomeAddress);
            setCompany(savedState.savedCompanyAddress);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Address savedCompanyAddress;
        Address savedHomeAddress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.savedHomeAddress = null;
            this.savedCompanyAddress = null;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.savedHomeAddress);
            parcel.writeSerializable(this.savedCompanyAddress);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.savedHomeAddress = null;
            this.savedCompanyAddress = null;
            this.savedHomeAddress = (Address) parcel.readSerializable();
            this.savedCompanyAddress = (Address) parcel.readSerializable();
        }
    }
}
