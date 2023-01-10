package com.didi.addressold.widget;

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
import com.didi.addressold.view.enhance.SubAddressItemEnhancer;
import com.didi.addressold.widget.SubAddressViewApi;
import com.didi.autotracker.AutoTrackHelper;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;
import java.util.ArrayList;

public class GlobalSubAddressView extends LinearLayout implements SubAddressViewApi {

    /* renamed from: a */
    private final int f9907a;

    /* renamed from: b */
    private ViewGroup f9908b;

    /* renamed from: c */
    private ViewGroup f9909c;

    /* renamed from: d */
    private ViewGroup f9910d;

    /* renamed from: e */
    private ViewGroup f9911e;

    /* renamed from: f */
    private SubAddressItemEnhancer f9912f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SubAddressViewApi.OnItemClickListener f9913g;

    /* renamed from: h */
    private ArrayList<RpcPoi> f9914h;

    public GlobalSubAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalSubAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9907a = 3;
        this.f9912f = new SubAddressItemEnhancer();
        m8636a(context);
    }

    /* renamed from: a */
    private void m8636a(Context context) {
        setOrientation(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.old_poi_one_address_sub_poi_global, this);
        this.f9908b = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_left);
        this.f9909c = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_middle);
        this.f9910d = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_right);
        this.f9911e = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_backup);
    }

    public void setOnItemClickLister(SubAddressViewApi.OnItemClickListener onItemClickListener) {
        this.f9913g = onItemClickListener;
    }

    public void fillData(ArrayList<RpcPoi> arrayList) {
        this.f9914h = arrayList;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f9908b);
        arrayList2.add(this.f9909c);
        arrayList2.add(this.f9910d);
        arrayList2.add(this.f9911e);
        int size = arrayList2.size();
        int size2 = arrayList.size();
        for (final int i = 0; i < size; i++) {
            ViewGroup viewGroup = (ViewGroup) arrayList2.get(i);
            if (i <= size2 - 1) {
                final RpcPoi rpcPoi = arrayList.get(i);
                ((TextView) viewGroup.findViewById(R.id.sub_item_content)).setText(rpcPoi != null ? rpcPoi.base_info.displayname : "");
                viewGroup.setVisibility(0);
                viewGroup.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (GlobalSubAddressView.this.f9913g != null) {
                            GlobalSubAddressView.this.f9913g.onItemClick(rpcPoi, i);
                        }
                    }
                });
                this.f9912f.enhance(viewGroup, i, rpcPoi);
                TextView textView = (TextView) viewGroup.findViewById(R.id.sub_item_distance);
                if (!TextUtils.isEmpty(rpcPoi.extend_info.distance)) {
                    textView.setVisibility(0);
                    textView.setText(rpcPoi.extend_info.distance);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                viewGroup.setVisibility(8);
                viewGroup.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.addresses = this.f9914h;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            fillData(savedState.addresses);
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
        ArrayList<RpcPoi> addresses;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.addresses);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.addresses = (ArrayList) parcel.readSerializable();
        }
    }
}
