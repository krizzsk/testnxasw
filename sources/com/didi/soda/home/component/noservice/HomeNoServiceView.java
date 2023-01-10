package com.didi.soda.home.component.noservice;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.debug.PoiUtil;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCityEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.NativePageInfoEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.home.component.noservice.HomeNoServiceView;
import com.didi.soda.home.widget.HeaderInfoLayout;
import com.didi.soda.home.widget.SubscribeButton;
import com.taxis99.R;
import java.util.List;

public class HomeNoServiceView extends ICustomerView<HomeNoServicePresenter> {

    /* renamed from: b */
    private static final String f45077b = "no_city_brazil.json";

    /* renamed from: c */
    private static final String f45078c = "no_city_janpan.json";

    /* renamed from: d */
    private static final String f45079d = "no_city_mexico.json";

    /* renamed from: a */
    private SubscribeButton f45080a;
    @BindView(18265)
    LinearLayout mButtonLayout;
    @BindView(18267)
    HeaderInfoLayout mHeaderInfoLayout;
    @BindView(18268)
    LottieAnimationView mImageView;
    @BindView(18733)
    ScrollView mScrollView;
    @BindView(18270)
    View mStatusBarView;
    @BindView(19027)
    TextView mSubtitleView;
    @BindView(19028)
    TextView mTitleView;

    public interface BtnCallback {
        void invoke(ButtonInfo buttonInfo);
    }

    public void showOrHide(boolean z) {
        getView().setVisibility(z ? 0 : 8);
    }

    public void updateData(NativePageInfoEntity nativePageInfoEntity, List<ButtonInfo> list) {
        this.mTitleView.setText(nativePageInfoEntity.title);
        this.mSubtitleView.setText(nativePageInfoEntity.subTitle);
        m33442a(nativePageInfoEntity.image);
        this.mButtonLayout.removeAllViews();
        m33443a(list);
    }

    /* renamed from: a */
    private void m33442a(final String str) {
        String str2;
        if (GlobalContext.isBrazil()) {
            str2 = f45077b;
        } else {
            str2 = TextUtils.equals("JP", PoiUtil.getPoiCountryCode()) ? f45078c : f45079d;
        }
        this.mImageView.setAnimation(str2);
        this.mImageView.setFailureListener(new LottieListener<Throwable>() {
            public void onResult(Throwable th) {
                FlyImageLoader.loadImage1x1(HomeNoServiceView.this.getScopeContext(), str).placeholder((int) R.drawable.customer_img_home_non_placeholder).centerCrop().dontAnimate().into((ImageView) HomeNoServiceView.this.mImageView);
            }
        });
        this.mImageView.playAnimation();
    }

    public void playSubscribeAnimation() {
        SubscribeButton subscribeButton = this.f45080a;
        if (subscribeButton != null) {
            subscribeButton.playAnimation();
        }
    }

    public void showOrHideSubscribeLoading(boolean z) {
        SubscribeButton subscribeButton = this.f45080a;
        if (subscribeButton == null) {
            return;
        }
        if (z) {
            subscribeButton.loading();
        } else {
            subscribeButton.hideLoading();
        }
    }

    public void scrollToTop() {
        this.mScrollView.fullScroll(33);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mHeaderInfoLayout.updateHeaderInfo(getScopeContext());
        getView().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_home_no_service, viewGroup);
    }

    /* renamed from: a */
    private void m33443a(List<ButtonInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            ButtonInfo buttonInfo = list.get(i);
            if (buttonInfo.style == 1) {
                m33439a(buttonInfo);
            } else if (buttonInfo.style == 2) {
                m33444b(buttonInfo);
            } else if (buttonInfo.style == 3) {
                m33446c(buttonInfo);
            }
        }
    }

    /* renamed from: a */
    private void m33439a(ButtonInfo buttonInfo) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_view_home_non_btn_style_color, this.mButtonLayout, false);
        SubscribeButton subscribeButton = (SubscribeButton) inflate.findViewById(R.id.customer_home_non_subscribe_btn);
        subscribeButton.setSubscribeText(buttonInfo.buttonText, buttonInfo.subscribedText);
        subscribeButton.setOnClickListener(new View.OnClickListener(subscribeButton) {
            public final /* synthetic */ SubscribeButton f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeNoServiceView.m33441a(HomeNoServiceView.ButtonInfo.this, this.f$1, view);
            }
        });
        this.mButtonLayout.addView(inflate);
        this.f45080a = subscribeButton;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m33441a(ButtonInfo buttonInfo, SubscribeButton subscribeButton, View view) {
        buttonInfo.isSubscribed = subscribeButton.isSubscribed();
        buttonInfo.invokeCallback();
    }

    /* renamed from: b */
    private void m33444b(ButtonInfo buttonInfo) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_view_home_non_btn_style_border, this.mButtonLayout, false);
        RFGhostButton rFGhostButton = (RFGhostButton) inflate.findViewById(R.id.customer_home_non_border_btn);
        rFGhostButton.setText(buttonInfo.buttonText);
        rFGhostButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeNoServiceView.ButtonInfo.this.invokeCallback();
            }
        });
        this.mButtonLayout.addView(inflate);
    }

    /* renamed from: c */
    private void m33446c(ButtonInfo buttonInfo) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_view_home_non_btn_style_text, this.mButtonLayout, false);
        ((TextView) inflate.findViewById(R.id.customer_home_non_center_text)).setText(buttonInfo.buttonText);
        inflate.findViewById(R.id.customer_home_non_text_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeNoServiceView.ButtonInfo.this.invokeCallback();
            }
        });
        this.mButtonLayout.addView(inflate);
    }

    static class ButtonInfo {
        public static final int STYLE_BORDER = 2;
        public static final int STYLE_COLOR = 1;
        public static final int STYLE_TEXT = 3;
        public String buttonText;
        public BtnCallback callback;
        public String callingCode;
        public int countryId;
        public boolean display;
        public boolean isSubscribed;
        public HomeServiceCityEntity poiInfo;
        public int style;
        public String subscribedText;

        ButtonInfo() {
        }

        public static ButtonInfo create(NativePageInfoEntity.ButtonInfoEntity buttonInfoEntity, BtnCallback btnCallback) {
            ButtonInfo buttonInfo = new ButtonInfo();
            boolean z = true;
            if (buttonInfoEntity.display != 1) {
                z = false;
            }
            buttonInfo.display = z;
            buttonInfo.callingCode = buttonInfoEntity.callingCode;
            buttonInfo.countryId = buttonInfoEntity.countryId;
            buttonInfo.poiInfo = buttonInfoEntity.poiInfo;
            buttonInfo.style = buttonInfoEntity.style;
            buttonInfo.callback = btnCallback;
            return buttonInfo;
        }

        public void invokeCallback() {
            BtnCallback btnCallback = this.callback;
            if (btnCallback != null) {
                btnCallback.invoke(this);
            }
        }
    }
}
