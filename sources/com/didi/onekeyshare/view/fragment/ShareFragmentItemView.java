package com.didi.onekeyshare.view.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.taxis99.R;

public class ShareFragmentItemView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f32284a;

    /* renamed from: b */
    private TextView f32285b;
    protected OneKeyShareInfo mShareInfo;

    public ShareFragmentItemView(Context context) {
        super(context);
        m24528a();
    }

    public ShareFragmentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24528a();
    }

    public ShareFragmentItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24528a();
    }

    /* renamed from: a */
    private void m24528a() {
        inflate(getContext(), R.layout.fragment_share_item, this);
        this.f32284a = (ImageView) findViewById(R.id.share_item_icon);
        this.f32285b = (TextView) findViewById(R.id.share_item_name);
    }

    /* access modifiers changed from: protected */
    public void setInfo(int i, String str) {
        this.f32284a.setImageResource(i);
        this.f32285b.setText(str);
    }

    public void setShareInfo(OneKeyShareInfo oneKeyShareInfo) {
        this.mShareInfo = oneKeyShareInfo;
        if (oneKeyShareInfo.platform != null && oneKeyShareInfo.platform != SharePlatform.UNKNOWN) {
            setInfo(oneKeyShareInfo.platform.resId(), getContext().getString(oneKeyShareInfo.platform.productName()));
            setId(oneKeyShareInfo.platform.platformId() + oneKeyShareInfo.customName.hashCode());
        }
    }

    public SharePlatform getPlatform() {
        OneKeyShareInfo oneKeyShareInfo = this.mShareInfo;
        if (oneKeyShareInfo != null) {
            return oneKeyShareInfo.platform;
        }
        return null;
    }

    public OneKeyShareInfo getShareInfo() {
        return this.mShareInfo;
    }
}
