package com.didi.component.travelGroupInfo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.taxis99.R;
import org.json.JSONObject;

public class TravelGroupInfoPresenterV2 extends AbsTravelGroupInfoPresenterV2 implements XpNewAdapter {

    /* renamed from: a */
    private View f18023a;

    /* renamed from: b */
    private View f18024b;

    /* renamed from: c */
    private LEGOBubble f18025c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout f18026d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f18027e = "";

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener f18028f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TravelGroupInfoPresenterV2.this.f18026d != null) {
                TravelGroupInfoPresenterV2.this.f18026d.removeAllViews();
                GlobalSPUtil.setChangePaywayBubbleID(TravelGroupInfoPresenterV2.this.mContext, TravelGroupInfoPresenterV2.this.f18027e);
            }
        }
    };
    protected IViewContainer.IComponentCreator mCompCreator;

    public TravelGroupInfoPresenterV2(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m15274b();
        subscribe(BaseEventKeys.Service.OnService.EVENT_PAYWAY_CHANGE_GUIDE_DISMISS, this.f18028f);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.OnService.EVENT_PAYWAY_CHANGE_GUIDE_DISMISS, this.f18028f);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mCompCreator = iComponentCreator;
    }

    /* renamed from: b */
    private void m15274b() {
        this.f18023a = inflateComponent(ComponentType.REAL_TIME_PRICE, (ViewGroup) ((ITravelGroupInfoViewV2) this.mView).getView().findViewById(R.id.real_price_container), (Bundle) null);
        this.f18024b = inflateComponent(ComponentType.TRAVEL_DETAIL_V2, (ViewGroup) ((ITravelGroupInfoViewV2) this.mView).getView().findViewById(R.id.travel_detail_container), (Bundle) null);
        this.f18026d = (FrameLayout) ((ITravelGroupInfoViewV2) this.mView).getView().findViewById(R.id.guide_layout);
    }

    /* access modifiers changed from: protected */
    public View inflateComponent(String str, ViewGroup viewGroup, Bundle bundle) {
        IComponent newComponent = this.mCompCreator.newComponent(str, viewGroup, bundle);
        if (newComponent == null || newComponent.getView() == null || newComponent.getView().getView() == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = newComponent.getView().getView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        viewGroup.addView(newComponent.getView().getView(), layoutParams);
        return newComponent.getView().getView();
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (this.f18023a == null || CarOrderHelper.isOrderEnd()) {
            this.f18023a.setVisibility(8);
            this.f18024b.setPadding(UiUtils.dip2px(this.mContext, 14.0f), UiUtils.dip2px(this.mContext, 19.0f), UiUtils.dip2px(this.mContext, 20.0f), UiUtils.dip2px(this.mContext, 19.0f));
        } else {
            this.f18023a.setVisibility(0);
            showPaywayChangeBubble(jSONObject);
            this.f18024b.setPadding(UiUtils.dip2px(this.mContext, 14.0f), UiUtils.dip2px(this.mContext, 14.0f), UiUtils.dip2px(this.mContext, 20.0f), UiUtils.dip2px(this.mContext, 19.0f));
        }
        BaseEventPublisher.getPublisher().publishSync(BaseEventKeys.OnService.EVENT_SHOW_GROUP_INFO_V2, jSONObject);
        iXpCardBindDataReadyCallback.ready(true);
    }

    public void showPaywayChangeBubble(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("normal")) != null && (optJSONObject2 = optJSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("pay_info");
            if (optJSONObject4 == null) {
                this.f18023a.setVisibility(8);
                this.f18024b.setPadding(UiUtils.dip2px(this.mContext, 14.0f), UiUtils.dip2px(this.mContext, 19.0f), UiUtils.dip2px(this.mContext, 20.0f), UiUtils.dip2px(this.mContext, 19.0f));
            } else if (optJSONObject4.has("pay_bubble") && (optJSONObject3 = optJSONObject4.optJSONObject("pay_bubble")) != null) {
                String optString = optJSONObject3.optString("text");
                this.f18027e = optJSONObject3.optString("bubble_id");
                if (GlobalSPUtil.isShowChangePaywayBubble(this.mContext, this.f18027e) && !TextUtils.isEmpty(optString)) {
                    if (this.f18025c == null) {
                        LEGOBubble.Builder builder = new LEGOBubble.Builder(this.mContext);
                        builder.setWidthAndHeight(UiUtils.dip2px(this.mContext, 250.0f), -2);
                        this.f18025c = builder.setDirection("top_right").setCloseBtnListener((BubbleCloseListener) null).setText(optString).setTextTypeface(3).setCloseBtnVisible(false).setBgColor(Color.parseColor("#E05C6166")).setContentViewOnClick(new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                TravelGroupInfoPresenterV2.this.f18026d.removeAllViews();
                                GlobalSPUtil.setChangePaywayBubbleID(TravelGroupInfoPresenterV2.this.mContext, TravelGroupInfoPresenterV2.this.f18027e);
                            }
                        }).build();
                    }
                    this.f18026d.removeAllViews();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 8388629;
                    this.f18026d.addView(this.f18025c.getView(), layoutParams);
                    GlobalOmegaUtils.trackEvent("ibt_gp_noob_tutorial_sw");
                }
            }
        }
    }
}
