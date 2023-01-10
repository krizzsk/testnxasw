package com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.dropoff.card.RichTextInfo;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffAddressExtendInfo;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;

public class FuzzyMatchCardView extends FrameLayout {

    /* renamed from: a */
    private static String f9046a = FuzzyMatchCardView.class.getSimpleName();

    /* renamed from: b */
    private TextView f9047b;

    /* renamed from: c */
    private TextView f9048c;

    /* renamed from: d */
    private ImageView f9049d;

    /* renamed from: e */
    private TextView f9050e;

    /* renamed from: f */
    private TextView f9051f;

    /* renamed from: g */
    private FuzzyMatchCardCallback f9052g;

    public FuzzyMatchCardView(Context context) {
        this(context, (FuzzyMatchCardCallback) null);
    }

    public FuzzyMatchCardView(Context context, FuzzyMatchCardCallback fuzzyMatchCardCallback) {
        super(context);
        init(context);
        setCardCallback(fuzzyMatchCardCallback);
    }

    public FuzzyMatchCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_fuzzymatch_card_view, this, true);
        this.f9047b = (TextView) findViewById(R.id.tv_fuzzymatch_title);
        this.f9048c = (TextView) findViewById(R.id.tv_fuzzymatch_subtitle);
        this.f9049d = (ImageView) findViewById(R.id.tv_fuzzymatch_address_name_pre_icon);
        this.f9050e = (TextView) findViewById(R.id.tv_fuzzymatch_address_name);
        this.f9051f = (TextView) findViewById(R.id.tv_fuzzymatch_request);
        try {
            this.f9051f.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f9051f.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            DLog.m10773d(f9046a, "init() get DidiThemeManager failed", new Object[0]);
            this.f9051f.setTextColor(Color.parseColor("#FFFFFF"));
            this.f9051f.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.load_btn_bg));
            th.printStackTrace();
        }
    }

    public void setCardCallback(FuzzyMatchCardCallback fuzzyMatchCardCallback) {
        this.f9052g = fuzzyMatchCardCallback;
    }

    public void updateCard(DropOffAddress dropOffAddress) {
        if (dropOffAddress != null && dropOffAddress.getAddress() != null) {
            m7755a();
            String displayName = dropOffAddress.getAddress().getDisplayName();
            if (!TextUtils.isEmpty(displayName)) {
                setAddressNameText(displayName);
            }
            boolean z = true;
            if (dropOffAddress.getExtendInfo() != null) {
                DropOffAddressExtendInfo extendInfo = dropOffAddress.getExtendInfo();
                String mainTitle = extendInfo.getMainTitle();
                if (!TextUtils.isEmpty(mainTitle)) {
                    setMainTitleText(mainTitle);
                }
                String subTitle = extendInfo.getSubTitle();
                if (!TextUtils.isEmpty(subTitle)) {
                    setSubTitleText(subTitle);
                    return;
                }
                if (dropOffAddress.getRecPointSize() <= 0) {
                    z = false;
                }
                setDefaultSubTitle(z);
                return;
            }
            if (dropOffAddress.getRecPointSize() <= 0) {
                z = false;
            }
            setDefaultSubTitle(z);
        }
    }

    private void setDefaultSubTitle(boolean z) {
        String string = getContext().getResources().getString(R.string.GRider_destination_Drag_the_uahD);
        if (z) {
            string = getContext().getResources().getString(R.string.GRider_destination_Drag_the_Mqxt);
        }
        setSubTitleText(string);
    }

    public void setAddressNameText(String str) {
        TextView textView = this.f9050e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setMainTitleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(str);
            richTextInfo.bindTo(this.f9047b);
        }
    }

    public void setSubTitleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(str);
            richTextInfo.bindTo(this.f9048c);
        }
    }

    public void onDataLoading(int i) {
        TextView textView = this.f9051f;
        if (textView != null) {
            textView.setEnabled(false);
            this.f9051f.setBackground(getResources().getDrawable(R.drawable.button_gray_bg));
            this.f9051f.setTextColor(getResources().getColor(R.color.light_gray));
        }
        setAddressNameText(getResources().getString(R.string.GRider_Sug_2020_map_searchingAddress));
        TextView textView2 = this.f9050e;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.light_gray));
        }
        if (this.f9047b == null) {
            return;
        }
        if (i == 1) {
            setMainTitleText(getResources().getString(R.string.GRider_confirmation_Confirm_starting_ZzjO));
        } else if (i == 2) {
            setMainTitleText(getResources().getString(R.string.GRider_confirmation_Confirmation_of_vbQf));
        }
    }

    /* renamed from: a */
    private void m7755a() {
        TextView textView = this.f9051f;
        if (textView != null) {
            textView.setEnabled(true);
            this.f9051f.setBackground(getResources().getDrawable(R.drawable.load_btn_bg));
            this.f9051f.setTextColor(getResources().getColor(R.color.white));
        }
        this.f9050e.setTextColor(getResources().getColor(R.color.black));
    }

    public void setAddressIcon(int i) {
        if (i == 1) {
            this.f9049d.setImageResource(R.drawable.com_icon_pickup);
        } else if (i == 2) {
            this.f9049d.setImageResource(R.drawable.com_icon_dest);
        }
    }

    public void setSubTitleEnable(boolean z) {
        if (z) {
            this.f9048c.setVisibility(0);
        } else {
            this.f9048c.setVisibility(8);
        }
    }

    public void updateView(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i) {
        DropOffAddress dropOffAddress = new DropOffAddress();
        Address address = new Address();
        if (rpcPoi.base_info != null) {
            if (rpcPoi.base_info.srctag == null) {
                address.displayName = rpcPoi.base_info.displayname;
            } else if (!rpcPoi.base_info.srctag.equals("newes_parent_child")) {
                address.displayName = rpcPoi.base_info.displayname;
            } else {
                address.displayName = rpcPoi.base_info.fullname;
            }
            address.address = rpcPoi.base_info.address;
            address.fullName = rpcPoi.base_info.addressAll;
            address.latitude = rpcPoi.base_info.lat;
            address.longitude = rpcPoi.base_info.lng;
            address.poiId = rpcPoi.base_info.poi_id;
            address.uid = rpcPoi.base_info.poi_id;
            address.cityId = rpcPoi.base_info.city_id;
            address.cityName = rpcPoi.base_info.city_name;
            address.countryID = rpcPoi.base_info.countryId;
            address.hideAddress = rpcPoi.base_info.hide_address;
        }
        dropOffAddress.setAddress(address);
        DropOffAddressExtendInfo dropOffAddressExtendInfo = new DropOffAddressExtendInfo();
        int i2 = 1;
        if (i == 1) {
            dropOffAddressExtendInfo.setMainTitle(getContext().getResources().getString(R.string.GRider_confirmation_Confirm_starting_ZzjO));
        } else if (i == 2) {
            dropOffAddressExtendInfo.setMainTitle(getContext().getResources().getString(R.string.GRider_confirmation_Confirmation_of_vbQf));
        }
        dropOffAddress.setExtendInfo(dropOffAddressExtendInfo);
        dropOffAddress.setRecommmend(rpcPoi.base_info.is_recommend_absorb == 1);
        if (rpcPoi.base_info.is_recommend_absorb != 1) {
            i2 = 0;
        }
        dropOffAddress.setRecPointSize(i2);
        setAddressIcon(i);
        setSubTitleEnable(false);
        updateCard(dropOffAddress);
        this.f9051f.setOnClickListener(new View.OnClickListener(rpcPoi, trackParameterForChild) {
            public final /* synthetic */ RpcPoi f$1;
            public final /* synthetic */ RpcRecSug.TrackParameterForChild f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                FuzzyMatchCardView.this.m7756a(this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7756a(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, View view) {
        FuzzyMatchCardCallback fuzzyMatchCardCallback = this.f9052g;
        if (fuzzyMatchCardCallback != null) {
            fuzzyMatchCardCallback.onConfirmAddress(rpcPoi, trackParameterForChild);
        }
    }
}
