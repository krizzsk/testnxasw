package com.didi.component.confirmupdateaddress.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.GLog;
import com.didi.component.confirmupdateaddress.presenter.ConfirmUpdateAddressPresenter;
import com.didi.component.confirmupdateaddress.util.ConfirmGuideUtil;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class ConfirmUpdateAddressView implements View.OnClickListener, IConfirmUpdateAddress {

    /* renamed from: a */
    private final BusinessContext f14553a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f14554b;

    /* renamed from: c */
    private final ViewGroup f14555c;

    /* renamed from: d */
    private View f14556d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ConfirmUpdateAddressPresenter f14557e;

    /* renamed from: f */
    private TextView f14558f;

    /* renamed from: g */
    private TextView f14559g;

    /* renamed from: h */
    private TextView f14560h;

    /* renamed from: i */
    private FrameLayout f14561i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public FrameLayout f14562j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f14563k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f14564l;

    public ConfirmUpdateAddressView(BusinessContext businessContext, ViewGroup viewGroup) {
        this.f14553a = businessContext;
        this.f14554b = businessContext.getContext();
        this.f14555c = viewGroup;
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.global_confirm_update_address_layout);
        viewByResId = viewByResId == null ? LayoutInflater.from(this.f14554b).inflate(R.layout.global_confirm_update_address_layout, viewGroup, false) : viewByResId;
        this.f14556d = viewByResId;
        this.f14558f = (TextView) viewByResId.findViewById(R.id.global_confirm_update_address_pick_up_tv);
        this.f14559g = (TextView) this.f14556d.findViewById(R.id.global_confirm_update_address_destination_tv);
        this.f14560h = (TextView) this.f14556d.findViewById(R.id.global_confirm_update_address_change_tv);
        this.f14561i = (FrameLayout) this.f14556d.findViewById(R.id.global_confirm_update_address_change_select_area);
        this.f14562j = (FrameLayout) this.f14556d.findViewById(R.id.guideLayout);
        this.f14561i.setOnClickListener(this);
        Address startAddress = FormStore.getInstance().getStartAddress();
        if (startAddress != null && !TextUtils.isEmpty(startAddress.getDisplayName())) {
            this.f14558f.setText(startAddress.getDisplayName());
        } else if (!TextUtils.isEmpty(FormStore.getInstance().getDisplayName())) {
            this.f14558f.setText(FormStore.getInstance().getDisplayName());
        } else {
            this.f14558f.setText(ResourcesHelper.getString(this.f14554b, R.string.map_flow_current_location));
        }
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (endAddress != null) {
            this.f14559g.setText(endAddress.getDisplayName());
        }
        m12055a();
    }

    public View getView() {
        return this.f14556d;
    }

    public void setPresenter(ConfirmUpdateAddressPresenter confirmUpdateAddressPresenter) {
        this.f14557e = confirmUpdateAddressPresenter;
    }

    public void onClick(View view) {
        ConfirmUpdateAddressPresenter confirmUpdateAddressPresenter;
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_confirm_update_address_change_select_area && (confirmUpdateAddressPresenter = this.f14557e) != null) {
            confirmUpdateAddressPresenter.onChangeClick();
        }
    }

    public void setPickUpText(String str) {
        TextView textView = this.f14558f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDestinationText(String str) {
        TextView textView = this.f14559g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setVisible(int i) {
        View view = this.f14556d;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m12055a() {
        if (ConfirmGuideUtil.INSTANCE.isShowEditGuideOnConfirm(this.f14554b)) {
            hideGuide();
            return;
        }
        final LEGOBubble createBubble = LEGOUICreator.createBubble(this.f14556d.getContext(), ResourcesHelper.getString(this.f14554b, R.string.GRider_page_Click_to_jxKZ), Color.parseColor("#5C6166"), "top_right", 3, false, (BubbleCloseListener) null);
        this.f14562j.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        View view = createBubble.getView();
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ConfirmUpdateAddressView.this.f14557e != null) {
                    ConfirmUpdateAddressView.this.f14557e.onChangeClick();
                }
            }
        });
        this.f14562j.addView(view, layoutParams);
        this.f14562j.post(new Runnable() {
            public void run() {
                int[] iArr = new int[2];
                ConfirmUpdateAddressView.this.f14562j.getLocationInWindow(iArr);
                ConfirmUpdateAddressView confirmUpdateAddressView = ConfirmUpdateAddressView.this;
                int unused = confirmUpdateAddressView.f14563k = (confirmUpdateAddressView.f14562j.getMeasuredHeight() + iArr[1]) - ((ConfirmUpdateAddressView.this.f14562j.getMeasuredHeight() - createBubble.getPopupHeight()) / 2);
                int i = iArr[1];
                GLog.m11353d("showGuide>>>mBestViewPaddingTop: " + ConfirmUpdateAddressView.this.f14563k);
                if (ConfirmUpdateAddressView.this.f14563k != 0) {
                    ConfirmGuideUtil.INSTANCE.setBestViewPaddingTopValue(ConfirmUpdateAddressView.this.f14554b, i);
                }
                if (ConfirmUpdateAddressView.this.f14564l) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Location.EVENT_PADDING_TOP, Integer.valueOf(ConfirmUpdateAddressView.this.f14563k));
                }
            }
        });
    }

    public void hideGuide() {
        FrameLayout frameLayout = this.f14562j;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public int getBestViewTopPadding() {
        if (!ConfirmGuideUtil.INSTANCE.isShowEditGuideOnConfirm(this.f14554b)) {
            return this.f14563k;
        }
        return ConfirmGuideUtil.INSTANCE.getBestViewPaddingTopValue(this.f14554b);
    }

    public void sendGetBestViewTopPaddingEvent() {
        this.f14564l = true;
    }

    public void updateAlpha(float f) {
        View view = this.f14556d;
        if (view != null) {
            if (view.getAlpha() != f) {
                this.f14556d.setAlpha(f);
            }
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i == 0 && this.f14556d.getVisibility() != 8) {
                this.f14556d.setVisibility(8);
            }
            if (i > 0 && this.f14556d.getVisibility() != 0) {
                this.f14556d.setVisibility(0);
            }
        }
    }
}
