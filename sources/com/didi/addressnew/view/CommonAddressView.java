package com.didi.addressnew.view;

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
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.ViewUtils;
import com.didi.sdk.address.address.entity.Address;
import com.taxis99.R;

public class CommonAddressView extends LinearLayout {

    /* renamed from: a */
    private LinearLayout f9336a;

    /* renamed from: b */
    private ViewGroup f9337b;

    /* renamed from: c */
    private TextView f9338c;

    /* renamed from: d */
    private ViewGroup f9339d;

    /* renamed from: e */
    private TextView f9340e;

    /* renamed from: f */
    private ViewGroup f9341f;

    /* renamed from: g */
    private Address f9342g;

    /* renamed from: h */
    private Address f9343h;

    /* renamed from: i */
    private LinearLayout f9344i;

    /* renamed from: j */
    private LinearLayout f9345j;

    public CommonAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommonAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9337b = null;
        this.f9338c = null;
        this.f9339d = null;
        this.f9340e = null;
        this.f9341f = null;
        this.f9342g = null;
        this.f9343h = null;
        this.f9344i = null;
        this.f9345j = null;
        LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_common_address_view, this);
        this.f9336a = (LinearLayout) findViewById(R.id.home_company_layout);
        this.f9337b = (ViewGroup) findViewById(R.id.layout_home);
        this.f9338c = (TextView) findViewById(R.id.text_home_content);
        this.f9339d = (ViewGroup) findViewById(R.id.layout_company);
        this.f9340e = (TextView) findViewById(R.id.text_company_content);
        this.f9341f = (ViewGroup) findViewById(R.id.layout_favorite);
        this.f9344i = (LinearLayout) findViewById(R.id.layout_home);
        this.f9345j = (LinearLayout) findViewById(R.id.layout_company);
    }

    public void setHomeCompanyLayoutVisibility(int i) {
        this.f9336a.setVisibility(i);
    }

    public void setCommonAddressLayoutVisibility(int i) {
        this.f9341f.setVisibility(i);
    }

    public void setHome(Address address) {
        this.f9342g = address;
        if (this.f9338c == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f9344i.setVisibility(0);
            this.f9338c.setText(getContext().getString(R.string.GRider_Sug_2020_home));
            if (ViewUtils.isRTL()) {
                this.f9338c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.poi_one_address_arrow_right, 0, 0, 0);
            } else {
                this.f9338c.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.poi_one_address_arrow_right, 0);
            }
        } else {
            this.f9344i.setVisibility(0);
            this.f9338c.setText(address.displayName);
            this.f9338c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void setCompany(Address address) {
        this.f9343h = address;
        if (this.f9340e == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f9345j.setVisibility(0);
            this.f9340e.setText(getContext().getString(R.string.GRider_Sug_2020_work));
            if (ViewUtils.isRTL()) {
                this.f9340e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.poi_one_address_arrow_right, 0, 0, 0);
            } else {
                this.f9340e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.poi_one_address_arrow_right, 0);
            }
        } else {
            this.f9345j.setVisibility(0);
            this.f9340e.setText(address.displayName);
            this.f9340e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public Address getHomeAddress() {
        return this.f9342g;
    }

    public Address getCompanyAddress() {
        return this.f9343h;
    }

    public void setHomeClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f9337b;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCompanyClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f9339d;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCommonAddressClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f9341f;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.savedHomeAddress = this.f9342g;
        savedState.savedCompanyAddress = this.f9343h;
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
