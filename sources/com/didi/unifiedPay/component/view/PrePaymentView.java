package com.didi.unifiedPay.component.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.trackupload.sdk.Constants;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.view.IPrePayView;
import com.didi.unifiedPay.component.widget.PayMethodView;
import com.didi.unifiedPay.component.widget.RootRelativeLayout;
import com.didi.unifiedPay.component.widget.SingleSelectionListView;
import com.didi.unifiedPay.component.widget.loading.FailStateDialog;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import java.util.List;

public class PrePaymentView extends FrameLayout implements View.OnClickListener, IPrePayView {

    /* renamed from: a */
    private RootRelativeLayout f47085a;

    /* renamed from: b */
    private TextView f47086b;

    /* renamed from: c */
    private TextView f47087c;

    /* renamed from: d */
    private TextView f47088d;

    /* renamed from: e */
    private TextView f47089e;

    /* renamed from: f */
    private ImageView f47090f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayMethodView f47091g;

    /* renamed from: h */
    private ImageView f47092h;

    /* renamed from: i */
    private ImageView f47093i;

    /* renamed from: j */
    private LinearLayout f47094j;

    /* renamed from: k */
    private LinearLayout f47095k;

    /* renamed from: l */
    private ImageView f47096l;

    /* renamed from: m */
    private Context f47097m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public IPrePayView.PayViewListener f47098n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public FailStateDialog f47099o;

    /* renamed from: p */
    private ProgressDialogFragment f47100p;

    /* renamed from: q */
    private FragmentManager f47101q;

    public View getView() {
        return this;
    }

    public PrePaymentView(Context context, FragmentManager fragmentManager) {
        super(context);
        this.f47097m = context;
        this.f47101q = fragmentManager;
        m35041a();
    }

    public void setListener(IPrePayView.PayViewListener payViewListener) {
        this.f47098n = payViewListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick() && this.f47098n != null && view != null) {
            int id = view.getId();
            if (id == R.id.iv_close) {
                this.f47098n.onCloseBtnClick();
            } else if (id == R.id.oc_btn_pay) {
                this.f47098n.onPayBtnClick();
            } else if (id == R.id.iv_protocol_switch) {
                m35045b();
            } else if (id == R.id.iv_protocol_url) {
                this.f47098n.onProtocolBtnClick();
            }
        }
    }

    public void onPayFailure(FailStateDialog.Config config) {
        m35042a(config);
    }

    public void onPaySuccess() {
        enableAllViews(false);
    }

    public void onPayLoadingStart() {
        enableAllViews(false);
        if (this.f47100p == null) {
            this.f47100p = new ProgressDialogFragment();
            this.f47100p.setContent(ResourcesHelper.getString(this.f47097m, R.string.oc_uni_pre_pay_queryloading), false);
        }
        if (!this.f47100p.isAdded()) {
            this.f47100p.show(this.f47101q, "");
        }
    }

    public void onPayLoadingEnd() {
        enableAllViews(true);
        ProgressDialogFragment progressDialogFragment = this.f47100p;
        if (progressDialogFragment != null && progressDialogFragment.isAdded()) {
            this.f47100p.dismissAllowingStateLoss();
        }
    }

    public void onPageLoadingStart() {
        this.f47095k.setVisibility(8);
        if (this.f47094j.getVisibility() != 0) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.f47096l.startAnimation(rotateAnimation);
            this.f47094j.setVisibility(0);
        }
    }

    public void onPageLoadingEnd() {
        this.f47094j.clearAnimation();
        this.f47094j.setVisibility(8);
        this.f47095k.setVisibility(0);
    }

    public void onPayMethodSelected(boolean z) {
        PayMethodView payMethodView = this.f47091g;
        if (payMethodView != null && payMethodView.hasLoadingStateItem()) {
            this.f47091g.setBlockChangeResult(z);
        }
        enableAllViews(true);
    }

    public void setFee(String str) {
        UnipayTextUtil unipayTextUtil = new UnipayTextUtil(str);
        unipayTextUtil.spanNumSize(3.0f);
        this.f47088d.setText(unipayTextUtil);
    }

    public void setPayBtnText(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.f47089e.setText(str);
        }
    }

    public void setPayBtnState(PayBtnState payBtnState) {
        if (payBtnState == PayBtnState.ENABLE) {
            this.f47090f.setVisibility(8);
            this.f47089e.setVisibility(0);
            this.f47089e.setEnabled(true);
        } else if (payBtnState == PayBtnState.DISABLE) {
            this.f47090f.setVisibility(8);
            this.f47089e.setVisibility(0);
            this.f47089e.setEnabled(false);
        } else if (payBtnState == PayBtnState.LOADING) {
            this.f47089e.setVisibility(8);
            this.f47090f.setVisibility(0);
            ((AnimationDrawable) this.f47090f.getDrawable()).start();
        }
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z) {
        if (list == null || list.size() < 1 || list.size() <= i) {
            this.f47091g.setVisibility(8);
            return;
        }
        this.f47091g.setVisibility(0);
        this.f47091g.setData(list, z, false);
        this.f47091g.onItemClick(i, true);
        if (z) {
            this.f47091g.setSelection(i);
        }
        this.f47091g.setOnSelectionListener(new SingleSelectionListView.OnSelectListener() {
            public void itemClicked(int i, PayChannelItem payChannelItem) {
            }

            public void onSelect(int i, Object obj) {
                if (PrePaymentView.this.f47091g.hasLoadingStateItem()) {
                    PrePaymentView.this.enableAllViews(false);
                }
                if (PrePaymentView.this.f47098n != null) {
                    PrePaymentView.this.f47098n.onSelectPayMethod(i, (PayChannelItem) obj);
                }
            }

            public void unSelect(int i, Object obj) {
                if (PrePaymentView.this.f47098n != null) {
                    PrePaymentView.this.f47098n.onUnSelectPayMethod(i, (PayChannelItem) obj);
                }
            }
        });
    }

    public void enableClose(boolean z) {
        this.f47093i.setEnabled(z);
    }

    public void enablePay(boolean z) {
        if (z) {
            setPayBtnState(PayBtnState.ENABLE);
        } else {
            setPayBtnState(PayBtnState.DISABLE);
        }
    }

    public void enableChangeChannel(boolean z) {
        this.f47091g.setItemEnable(z);
    }

    /* renamed from: a */
    private void m35043a(boolean z) {
        this.f47092h.setEnabled(z);
    }

    public boolean isCloseEnabled() {
        return this.f47093i.isEnabled();
    }

    public void enableAllViews(boolean z) {
        if (z) {
            enableClose(true);
            m35043a(true);
            if (!m35047c() || !m35048d()) {
                enablePay(false);
                enableChangeChannel(false);
                return;
            }
            enablePay(true);
            enableChangeChannel(true);
            return;
        }
        enableClose(false);
        enableChangeChannel(false);
        enablePay(false);
        m35043a(false);
    }

    public void setTitle(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && !TextUtils.isEmpty(charSequence.toString())) {
            this.f47086b.setText(charSequence);
        }
        if (charSequence2 == null || TextUtils.isEmpty(charSequence2.toString())) {
            this.f47087c.setVisibility(8);
            return;
        }
        this.f47087c.setText(charSequence2);
        this.f47087c.setVisibility(0);
    }

    public PayTypes getPayMethodTypes() {
        PayTypes payTypes = new PayTypes();
        PayChannelItem selection = this.f47091g.getSelection();
        if (selection != null) {
            payTypes.thirdPartPayType = selection.channelId;
        }
        return payTypes;
    }

    /* renamed from: a */
    private void m35041a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_pre_pay_layout, this);
        this.f47086b = (TextView) findViewById(R.id.tv_main_title);
        this.f47087c = (TextView) findViewById(R.id.tv_subtitle);
        this.f47088d = (TextView) findViewById(R.id.tv_pre_pay_value);
        this.f47089e = (TextView) findViewById(R.id.oc_btn_pay);
        this.f47091g = (PayMethodView) findViewById(R.id.oc_paymethod_view);
        this.f47094j = (LinearLayout) findViewById(R.id.ll_page_loading);
        this.f47096l = (ImageView) findViewById(R.id.iv_page_loading_icon);
        this.f47095k = (LinearLayout) findViewById(R.id.oc_ll_pay_biz_view);
        this.f47090f = (ImageView) findViewById(R.id.oc_btn_pay_loading);
        this.f47092h = (ImageView) findViewById(R.id.iv_protocol_switch);
        this.f47085a = (RootRelativeLayout) findViewById(R.id.oc_pay_root);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f47093i = imageView;
        imageView.setOnClickListener(this);
        findViewById(R.id.iv_protocol_url).setOnClickListener(this);
        this.f47092h.setOnClickListener(this);
        this.f47092h.setSelected(true);
        this.f47089e.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m35045b() {
        if (this.f47092h.isSelected()) {
            this.f47092h.setSelected(false);
            enableChangeChannel(false);
            enablePay(false);
            return;
        }
        this.f47092h.setSelected(true);
        enableChangeChannel(true);
        enablePay(true);
    }

    /* renamed from: c */
    private boolean m35047c() {
        return this.f47092h.isSelected();
    }

    /* renamed from: d */
    private boolean m35048d() {
        return this.f47088d.getText().length() > 0;
    }

    /* renamed from: a */
    private void m35042a(FailStateDialog.Config config) {
        if (this.f47099o == null) {
            FailStateDialog failStateDialog = new FailStateDialog(this.f47097m, 2132018110);
            this.f47099o = failStateDialog;
            Window window = failStateDialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            WindowManager windowManager = this.f47099o.getWindow().getWindowManager();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.8d);
            window.setAttributes(attributes);
        }
        if (!this.f47099o.isShowing()) {
            final FailStateDialog.onClickListener onclicklistener = config.listener;
            config.listener = new FailStateDialog.onClickListener() {
                public void onCancel() {
                    PrePaymentView.this.f47099o.dismiss();
                    FailStateDialog.onClickListener onclicklistener = onclicklistener;
                    if (onclicklistener != null) {
                        onclicklistener.onCancel();
                    }
                }

                public void onConfirm() {
                    PrePaymentView.this.f47099o.dismiss();
                    FailStateDialog.onClickListener onclicklistener = onclicklistener;
                    if (onclicklistener != null) {
                        onclicklistener.onConfirm();
                    }
                }
            };
            this.f47099o.setupView(config);
            SystemUtils.showDialog(this.f47099o);
        }
    }
}
