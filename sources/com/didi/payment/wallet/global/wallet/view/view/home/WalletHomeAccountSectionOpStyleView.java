package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.WalletTriangleView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class WalletHomeAccountSectionOpStyleView extends WalletHomeAbsSectionView<WalletHomeResp.AccountSection, WalletHomeContract.Listener> implements View.OnClickListener {

    /* renamed from: a */
    private View f35094a;

    /* renamed from: b */
    private ImageView f35095b;

    /* renamed from: c */
    private TextView f35096c;

    /* renamed from: d */
    private TextView f35097d;

    /* renamed from: e */
    private TextView f35098e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f35099f;

    /* renamed from: g */
    private TextView f35100g;

    /* renamed from: h */
    private TextView f35101h;

    /* renamed from: i */
    private WalletTriangleView f35102i;

    /* renamed from: j */
    private TextView f35103j;

    /* renamed from: k */
    private View f35104k;

    /* renamed from: l */
    private View f35105l;

    /* renamed from: m */
    private WalletHomeOpCardButton f35106m;

    /* renamed from: n */
    private LottieAnimationView f35107n;

    /* renamed from: o */
    private View f35108o;

    /* renamed from: p */
    private WalletHomeResp.AccountSection f35109p;

    /* renamed from: q */
    private View f35110q;

    /* renamed from: r */
    private boolean f35111r;

    public WalletHomeAccountSectionOpStyleView(Context context) {
        super(context);
    }

    public WalletHomeAccountSectionOpStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeAccountSectionOpStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f35110q = LayoutInflater.from(context).inflate(R.layout.wallet_global_home_account_op_section, this, true);
        this.f35094a = findViewById(R.id.wallet_home_account_op_root_view);
        this.f35101h = (TextView) findViewById(R.id.tv_account_op_total_label);
        this.f35095b = (ImageView) findViewById(R.id.iv_account_op_account_promotion_bg);
        this.f35096c = (TextView) findViewById(R.id.tv_account_op_promotion_header);
        this.f35097d = (TextView) findViewById(R.id.tv_account_op_promotion_label);
        this.f35098e = (TextView) findViewById(R.id.tv_account_op_msg);
        this.f35099f = (TextView) findViewById(R.id.tv_account_op_msg2);
        this.f35100g = (TextView) findViewById(R.id.tv_account_op_details);
        this.f35103j = (TextView) findViewById(R.id.tv_account_op_interest_msg);
        this.f35106m = (WalletHomeOpCardButton) findViewById(R.id.tv_account_op_btn);
        this.f35107n = (LottieAnimationView) findViewById(R.id.lav_top_up_lottie);
        this.f35108o = findViewById(R.id.v_account_op_btn_mask);
        WalletTriangleView walletTriangleView = (WalletTriangleView) findViewById(R.id.wt_account_op_details_arrow);
        this.f35102i = walletTriangleView;
        walletTriangleView.setColor(ResourcesHelper.getColor(this.mContext, R.color.wallet_color_43CE96));
        this.f35104k = findViewById(R.id.v_account_op_bottom_left);
        this.f35105l = findViewById(R.id.v_account_op_bottom_right);
        this.f35106m.setOnClickListener(this);
        this.f35094a.setOnClickListener(this);
        this.f35098e.setOnClickListener(this);
        this.f35107n.setOnClickListener(this);
        this.f35100g.setOnClickListener(this);
    }

    public void updateContent(WalletHomeResp.AccountSection accountSection) {
        if (accountSection == null) {
            setVisibility(8);
            return;
        }
        WalletHomeResp.AccountSection accountSection2 = this.f35109p;
        this.f35109p = accountSection;
        setVisibility(0);
        this.f35101h.setText(accountSection.title);
        if (accountSection.promotionHeader != null) {
            accountSection.promotionHeader.bindTextView(this.f35096c);
            if (!TextUtils.isEmpty(accountSection.promotionLink)) {
                this.f35096c.setOnClickListener(this);
                this.f35095b.setOnClickListener(this);
                PayRichInfo.appendImageSpan(this.f35096c, R.drawable.wallet_global_home_account_op_promotion_arrow);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(accountSection.status));
            PayTracker.trackEvent("ibt_gp_didipay_top_banner_promo_sw", hashMap);
        }
        this.f35097d.setText(accountSection.promotionLabel);
        if (accountSection.statusMsg != null) {
            accountSection.statusMsg.bindTextView(this.f35098e);
            accountSection.statusMsg.bindTextView(this.f35099f);
        }
        if (TextUtils.isEmpty(accountSection.detailsMsg)) {
            this.f35102i.setVisibility(8);
            this.f35100g.setVisibility(8);
        } else {
            this.f35102i.setVisibility(0);
            this.f35100g.setVisibility(0);
            TextView textView = this.f35100g;
            textView.setText(accountSection.detailsMsg + " >");
        }
        if (accountSection.interestMsg != null) {
            accountSection.interestMsg.bindTextView(this.f35103j);
        }
        if (TextUtils.isEmpty(accountSection.detailsMsg) && accountSection.interestMsg == null) {
            setContentHeight(364);
        } else if (accountSection.interestMsg == null) {
            setContentHeight(404);
        } else if (!TextUtils.isEmpty(accountSection.detailsMsg) && accountSection.interestMsg != null) {
            setContentHeight(416);
        }
        if (!TextUtils.isEmpty(accountSection.buttonText)) {
            this.f35106m.setText(accountSection.buttonText);
            this.f35106m.showTopUpStyle();
        }
        m26738a(accountSection.promotionHeaderImageUrl);
        setContentBg(accountSection.contentBgColors);
        setMsgStatusDrawable(accountSection.status);
        showButtonAnimationIfNeeded(accountSection);
        m26736a(accountSection2);
    }

    private void setContentHeight(int i) {
        int dip2px = UIUtil.dip2px(getContext(), (float) i);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35094a.getLayoutParams();
        marginLayoutParams.height = dip2px;
        this.f35094a.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: a */
    private void m26736a(WalletHomeResp.AccountSection accountSection) {
        if (accountSection != null && this.f35109p != null && accountSection.status == 1 && this.f35109p.status == 1 && accountSection.statusMsg != null) {
            this.f35099f.setVisibility(0);
            accountSection.statusMsg.bindTextView(this.f35099f);
            int measuredHeight = this.f35099f.getMeasuredHeight();
            int measuredHeight2 = this.f35098e.getMeasuredHeight();
            this.f35099f.setTranslationY(0.0f);
            this.f35098e.setTranslationY((float) measuredHeight2);
            C121941 r0 = new DynamicAnimation.OnAnimationEndListener() {
                public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                    WalletHomeAccountSectionOpStyleView.this.f35099f.setVisibility(4);
                }
            };
            final SpringAnimation springAnimation = new SpringAnimation(this.f35099f, SpringAnimation.TRANSLATION_Y, (float) (-measuredHeight));
            springAnimation.getSpring().setDampingRatio(0.75f);
            springAnimation.getSpring().setStiffness(30.0f);
            springAnimation.addEndListener(r0);
            final SpringAnimation springAnimation2 = new SpringAnimation(this.f35098e, SpringAnimation.TRANSLATION_Y, 0.0f);
            springAnimation2.getSpring().setDampingRatio(0.75f);
            springAnimation2.getSpring().setStiffness(30.0f);
            post(new Runnable() {
                public void run() {
                    springAnimation.start();
                    springAnimation2.start();
                }
            });
        }
    }

    /* renamed from: a */
    private void m26738a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int screenWidth = UIUtils.getScreenWidth(this.mContext);
            ViewGroup.LayoutParams layoutParams = this.f35095b.getLayoutParams();
            GlideUtils.loadSuperBigImageSafely(this.mContext, str, Math.max(500, screenWidth), Math.max(500, layoutParams != null ? layoutParams.height : UIUtil.dip2px(this.mContext, 160.0f)), this.f35095b);
        }
    }

    private void setContentBg(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            int[] iArr = new int[strArr.length];
            int i = 0;
            while (i < strArr.length) {
                try {
                    iArr[i] = Color.parseColor(strArr[i]);
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setGradientCenter(0.5f, 0.5f);
            this.f35094a.setBackground(gradientDrawable);
        }
    }

    private void setMsgStatusDrawable(int i) {
        this.f35098e.setCompoundDrawablesWithIntrinsicBounds(0, 0, (i == 0 || i == 1 || i == 2 || i == 3) ? R.drawable.wallet_global_home_status_msg_op_arrow : 0, 0);
        this.f35098e.setCompoundDrawablePadding(UIUtil.dip2px(getContext(), 9.0f));
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null) {
            if (view.getId() == R.id.tv_account_op_btn || view.getId() == R.id.lav_top_up_lottie) {
                m26740b();
                ((WalletHomeContract.Listener) this.mListener).onAccountMainEnterClicked(this.f35109p);
            } else if (view.getId() == R.id.wallet_home_account_op_root_view) {
                ((WalletHomeContract.Listener) this.mListener).onWholeCardClicked(this.f35109p);
            } else if (view.getId() == R.id.tv_account_op_msg) {
                ((WalletHomeContract.Listener) this.mListener).onStatusMsgClicked(this.f35109p);
            } else if (view.getId() == R.id.tv_account_op_promotion_header || view.getId() == R.id.iv_account_op_account_promotion_bg) {
                ((WalletHomeContract.Listener) this.mListener).onPromotionHeaderClicked(this.f35109p);
            } else if (view.getId() == R.id.tv_account_op_details) {
                ((WalletHomeContract.Listener) this.mListener).onDetailsClicked(this.f35109p);
            }
        }
    }

    public void showButtonAnimationIfNeeded(WalletHomeResp.AccountSection accountSection) {
        if (!this.f35111r && this.f35107n != null && accountSection != null && !TextUtils.isEmpty(accountSection.buttonText)) {
            this.f35106m.setVisibility(4);
            this.f35111r = true;
            new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public LottieResult<LottieComposition> call() {
                    return WalletHomeAccountSectionOpStyleView.this.m26734a();
                }
            }).addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition lottieComposition) {
                    WalletHomeAccountSectionOpStyleView.this.m26735a(lottieComposition);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LottieResult<LottieComposition> m26734a() {
        String str = "button_pr.json";
        try {
            if (getResources().getConfiguration().locale.getLanguage().equalsIgnoreCase("en")) {
                str = "button_en.json";
            }
            return LottieCompositionFactory.fromJsonInputStreamSync(this.mContext.getAssets().open(str), (String) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26735a(LottieComposition lottieComposition) {
        try {
            this.f35107n.setImageAssetsFolder("wallet_button_images/");
            this.f35107n.setComposition(lottieComposition);
            this.f35107n.setRepeatCount(-1);
            this.f35107n.playAnimation();
            this.f35106m.setVisibility(4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m26740b() {
        try {
            this.f35106m.setVisibility(0);
            if (this.f35107n != null) {
                if (this.f35107n.getParent() == null) {
                    this.f35107n = null;
                    return;
                }
                ((ViewGroup) this.f35107n.getParent()).removeView(this.f35107n);
                this.f35107n = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setBackgroudStyle(int i) {
        if (i == 1) {
            this.f35094a.setBackgroundColor(getResources().getColor(R.color.wallet_color_EEFAF1));
            this.f35104k.setBackgroundResource(R.drawable.wallet_account_card_op_bottom_bg_left4pix);
            this.f35105l.setBackgroundResource(R.drawable.wallet_account_card_op_bottom_bg_left4pix);
        }
    }
}
