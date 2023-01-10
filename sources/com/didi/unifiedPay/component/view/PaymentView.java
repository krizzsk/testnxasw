package com.didi.unifiedPay.component.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.Utils;
import com.didi.unifiedPay.component.manager.PayMethodManager;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.widget.CardTitleView;
import com.didi.unifiedPay.component.widget.FailStateView;
import com.didi.unifiedPay.component.widget.LoadingStateView;
import com.didi.unifiedPay.component.widget.PayMethodView;
import com.didi.unifiedPay.component.widget.PayRootLinearLayout;
import com.didi.unifiedPay.component.widget.PlatformPayView;
import com.didi.unifiedPay.component.widget.SingleSelectionListView;
import com.didi.unifiedPay.component.widget.ToastView;
import com.didi.unifiedPay.util.HighlightUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;
import global.didi.pay.model.LoadingState;
import global.didi.pay.p239ui.theme.UnifiedPayThemeManager;
import java.util.ArrayList;
import java.util.List;

public class PaymentView extends FrameLayout implements View.OnClickListener, IPayView {

    /* renamed from: A */
    private static final int f47055A = 50;

    /* renamed from: B */
    private static final int f47056B = 29;

    /* renamed from: x */
    private static final String f47057x = "PaymentView";

    /* renamed from: y */
    private static final int f47058y = 20;

    /* renamed from: z */
    private static final int f47059z = 10;

    /* renamed from: C */
    private TotalPayAreaView f47060C;

    /* renamed from: D */
    private TextView f47061D;

    /* renamed from: a */
    private Context f47062a;

    /* renamed from: b */
    private CardTitleView f47063b;

    /* renamed from: c */
    private TextView f47064c;

    /* renamed from: d */
    private LinearLayout f47065d;

    /* renamed from: e */
    private TextView f47066e;

    /* renamed from: f */
    private TextView f47067f;

    /* renamed from: g */
    private LinearLayout f47068g;

    /* renamed from: h */
    private LinearLayout f47069h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PlatformPayView f47070i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PayMethodView f47071j;

    /* renamed from: k */
    private TextView f47072k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextView f47073l;

    /* renamed from: m */
    private TextView f47074m;
    protected IPayView.PayViewListener mListener;
    protected View mView;

    /* renamed from: n */
    private ImageView f47075n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ScrollView f47076o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LinearLayout f47077p;
    protected LinearLayout payBizViewLayout;
    protected boolean payBtnClicked;
    protected FrameLayout payStateLayout;

    /* renamed from: q */
    private List<PlatformPayItem> f47078q;

    /* renamed from: r */
    private int f47079r;
    protected PayRootLinearLayout rootGroupView;

    /* renamed from: s */
    private List f47080s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f47081t;

    /* renamed from: u */
    private ViewTreeObserver.OnGlobalLayoutListener f47082u;

    /* renamed from: v */
    private PayBizType f47083v;

    /* renamed from: w */
    private IPayManager f47084w;

    /* access modifiers changed from: protected */
    public int getPayDisableResourceId() {
        return R.drawable.oc_button_normal_shape;
    }

    /* access modifiers changed from: protected */
    public int getPayResourceId() {
        return R.drawable.oc_button_selector;
    }

    public View getView() {
        return this;
    }

    public void setCrossFeeWithUnit(String str) {
    }

    public PaymentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PaymentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaymentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f47062a = context;
        this.f47083v = PayBizType.BIZ_TRIP;
        loadView();
        initView();
    }

    /* access modifiers changed from: protected */
    public void loadView() {
        this.mView = LayoutInflater.from(getContext()).inflate(R.layout.oc_unified_pay_layout, this);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f47084w = new TripPayManager(this.f47062a, this);
        m35031b();
        this.rootGroupView = (PayRootLinearLayout) findViewById(R.id.oc_pay_root);
        this.payBizViewLayout = (LinearLayout) findViewById(R.id.oc_ll_pay_biz_view);
        this.payStateLayout = (FrameLayout) findViewById(R.id.oc_fl_pay_state);
        this.f47064c = (TextView) findViewById(R.id.oc_tv_pay_type_info);
        this.f47060C = (TotalPayAreaView) findViewById(R.id.oc_pay_totalpayview);
        m35022a();
        this.f47068g = (LinearLayout) findViewById(R.id.oc_pay_supplement_container);
        this.f47076o = (ScrollView) findViewById(R.id.oc_sv_pay_list);
        this.f47069h = (LinearLayout) findViewById(R.id.oc_ll_platform_pay);
        this.f47070i = (PlatformPayView) findViewById(R.id.oc_lv_platform_pay);
        this.f47071j = (PayMethodView) findViewById(R.id.oc_paymethod_view);
        this.f47061D = (TextView) findViewById(R.id.oc_tv_pay_marketing);
        TextView textView = (TextView) findViewById(R.id.oc_tv_more_pay_item);
        this.f47072k = textView;
        textView.setContentDescription(this.f47072k.getText() + getResources().getString(R.string.oc_voice_button));
        this.f47077p = (LinearLayout) findViewById(R.id.oc_ll_pay_area);
        this.f47073l = (TextView) findViewById(R.id.oc_tv_pay_statement);
        ImageView imageView = (ImageView) findViewById(R.id.oc_btn_pay_loading);
        this.f47075n = imageView;
        imageView.setBackgroundResource(getPayResourceId());
        this.f47074m = (TextView) findViewById(R.id.oc_btn_pay);
        this.f47074m.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getNewMainBtnBg()));
        this.f47074m.setTextColor(getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getPayBtnTxtColor()));
        this.f47074m.setOnClickListener(this);
        this.f47072k.setOnClickListener(this);
        m35036d();
        m35023a(this.f47076o, this.f47077p, this.f47073l.getVisibility() == 0);
    }

    /* renamed from: a */
    private void m35022a() {
        this.f47065d = (LinearLayout) findViewById(R.id.oc_pay_total_fee_container);
        View inflate = LayoutInflater.from(this.f47062a).inflate(R.layout.gua_oc_unified_pay_include_pay_total_fee, this.f47065d, false);
        this.f47066e = (TextView) inflate.findViewById(R.id.oc_tv_pay_toal_fee);
        this.f47067f = (TextView) inflate.findViewById(R.id.oc_tv_pay_total_fee_more);
        this.f47065d.addView(inflate);
    }

    /* renamed from: b */
    private void m35031b() {
        this.f47063b = (CardTitleView) this.mView.findViewById(R.id.oc_include_pay_title);
    }

    public void setMarketing(String str, View.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.f47061D.setVisibility(8);
            return;
        }
        this.f47061D.setVisibility(0);
        this.f47061D.setText(HighlightUtil.highlight(str));
        this.f47061D.setOnClickListener(onClickListener);
    }

    public void setCardPaddingTop(int i) {
        this.rootGroupView.setPadding(0, i, 0, 0);
    }

    public void setBizType(PayBizType payBizType) {
        if (this.f47083v != payBizType) {
            if (payBizType == PayBizType.BIZ_NON_TRIP) {
                this.f47084w = new NonTripPayManager(this.f47062a, this);
            } else if (payBizType == PayBizType.BIZ_TRIP) {
                this.f47084w = new TripPayManager(this.f47062a, this);
            }
            this.f47083v = payBizType;
        }
    }

    public void setCradTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47063b.setTitle(str);
        }
    }

    public void refreshTotalPayArea(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            this.f47060C.setVisibility(8);
            return;
        }
        this.f47060C.setVisibility(0);
        this.f47060C.refresh(str, str2, str3);
    }

    public void setPayTypeInfo(CharSequence charSequence) {
        if (UnipayTextUtil.isEmpty(charSequence)) {
            this.f47064c.setVisibility(8);
            return;
        }
        this.f47064c.setText(charSequence);
        this.f47064c.setVisibility(0);
    }

    public void setPayTypeInfo(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            this.f47064c.setVisibility(8);
            return;
        }
        this.f47064c.setText(str);
        this.f47064c.setVisibility(0);
    }

    public void setDisplayFee(String str) {
        setDisplayFeeWithUnit(this.f47062a.getString(R.string.oc_pay_total_str) + this.f47062a.getString(R.string.oc_pay_total_fee_str, new Object[]{str}));
    }

    public void setDisplayFeeWithUnit(String str) {
        UnipayTextUtil unipayTextUtil = new UnipayTextUtil(str);
        unipayTextUtil.spanNumSize(3.0f);
        this.f47066e.setText(unipayTextUtil);
    }

    public void setJumpableItem(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            showFeeDetailEntraView(false);
            return;
        }
        this.f47067f.setText(str);
        showFeeDetailEntraView(true);
    }

    public void setVoucherDeductible(double d) {
        if (d > 0.0d) {
            String string = getResources().getString(R.string.oc_pay_voucher_deduction_str);
            Resources resources = getResources();
            setVoucherView(new VoucherViewConfig(string, resources.getString(R.string.oc_uni_pay_voucher_deduction_value, new Object[]{"" + d}), true));
            return;
        }
        showOrHideDeductionItem(DeductionItemType.TYPE_VOUCHER, false);
    }

    public void setVoucherView(VoucherViewConfig voucherViewConfig) {
        removeDeductionItem(DeductionItemType.TYPE_VOUCHER);
        voucherViewConfig.deductionType = DeductionItemType.TYPE_VOUCHER;
        addDeductionItem(voucherViewConfig);
    }

    public void addDeductionItem(VoucherViewConfig voucherViewConfig) {
        if (voucherViewConfig != null) {
            View inflate = LayoutInflater.from(this.f47062a).inflate(R.layout.oc_unified_pay_supply_item, this.f47068g, false);
            inflate.setTag(voucherViewConfig);
            TextView textView = (TextView) inflate.findViewById(R.id.oc_tv_voucher_left);
            textView.setText(voucherViewConfig.leftDes);
            TextView textView2 = (TextView) inflate.findViewById(R.id.oc_tv_voucher_desc);
            if (TextUtils.isEmpty(voucherViewConfig.desc)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(Const.jaLeft + voucherViewConfig.desc + Const.jaRight);
            }
            TextView textView3 = (TextView) inflate.findViewById(R.id.oc_tv_voucher_mount);
            textView3.setText(voucherViewConfig.rightDes);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.oc_iv_pay_voucher_icon);
            if (voucherViewConfig.showOrangeText) {
                textView.setTextColor(getResources().getColor(R.color.oc_color_FC9153));
                textView3.setTextColor(getResources().getColor(R.color.oc_color_FC9153));
                imageView.setImageResource(R.mipmap.pay_icon_right_oringe);
            } else {
                textView.setTextColor(getResources().getColor(R.color.oc_color_333333));
                textView3.setTextColor(getResources().getColor(R.color.oc_color_999999));
                imageView.setImageResource(R.drawable.pay_icon_right_grey);
            }
            if (voucherViewConfig.showRightIcon) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (voucherViewConfig.canClick) {
                inflate.setOnClickListener(this);
                inflate.setBackgroundDrawable(this.f47062a.getResources().getDrawable(R.drawable.oc_view_selector));
            } else {
                inflate.setOnClickListener((View.OnClickListener) null);
                inflate.setBackgroundDrawable((Drawable) null);
            }
            this.f47068g.addView(inflate);
            if (this.f47068g.getVisibility() != 0) {
                this.f47068g.setVisibility(0);
            }
        }
    }

    public void addDeductionItems(List<VoucherViewConfig> list) {
        if (list != null && list.size() >= 1) {
            removeAllDeductions();
            for (int i = 0; i < list.size(); i++) {
                addDeductionItem(list.get(i));
            }
        }
    }

    public void showOrHideDeductionItem(DeductionItemType deductionItemType, boolean z) {
        if (this.f47068g.getChildCount() > 0) {
            for (int i = 0; i < this.f47068g.getChildCount(); i++) {
                View childAt = this.f47068g.getChildAt(i);
                if (childAt.getTag() == deductionItemType) {
                    childAt.setVisibility(z ? 0 : 8);
                    if (z) {
                        this.f47068g.setVisibility(0);
                    }
                }
            }
        }
        if (!z && m35029a((ViewGroup) this.f47068g)) {
            this.f47068g.setVisibility(8);
        }
    }

    public void showOrHideDeductions(boolean z) {
        if (z) {
            this.f47068g.setVisibility(0);
            if (this.f47068g.getVisibility() != 0) {
                this.f47068g.setVisibility(0);
                return;
            }
            return;
        }
        this.f47068g.setVisibility(8);
    }

    public void removeAllDeductions() {
        if (this.f47068g.getChildCount() > 0) {
            this.f47068g.removeAllViews();
        }
        this.f47068g.setVisibility(8);
    }

    public void removeDeductionItem(DeductionItemType deductionItemType) {
        if (this.f47068g.getChildCount() > 0) {
            for (int i = 0; i < this.f47068g.getChildCount(); i++) {
                if (this.f47068g.getChildAt(i).getTag() == deductionItemType) {
                    this.f47068g.removeViewAt(i);
                }
            }
        }
    }

    public void showVoucherView(boolean z) {
        showOrHideDeductionItem(DeductionItemType.TYPE_VOUCHER, z);
    }

    public void updatePlatformPayView(List<PlatformPayItem> list) {
        updatePlatformPayView(list, false);
    }

    public void updatePlatformPayView(List<PlatformPayItem> list, boolean z) {
        this.f47078q = list;
        if (list == null || list.size() < 1) {
            this.f47069h.setVisibility(8);
            return;
        }
        this.payBtnClicked = false;
        LogUtil.m35171d(f47057x, "updatePlatformPayView platformPayItems:" + list);
        m35036d();
        m35026a(list);
        this.f47070i.setData(list, z);
        this.f47070i.setOnSelectListener(new PlatformPayView.OnselectListener() {
            public void onItemSelectChange(int i, boolean z, PlatformPayItem platformPayItem, boolean z2) {
                if (PaymentView.this.f47070i.hasLoadingStateItem()) {
                    PaymentView.this.m35032b(false);
                }
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.onPlatformItemSelectChange(i, z, platformPayItem, z2);
                }
            }

            public void itemClicked(int i, PlatformPayItem platformPayItem) {
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.itemClicked(i, platformPayItem);
                }
            }
        });
        this.f47069h.setVisibility(0);
    }

    /* renamed from: a */
    private void m35026a(List<PlatformPayItem> list) {
        if (this.f47080s == null) {
            this.f47080s = new ArrayList();
            for (PlatformPayItem next : list) {
                if (!next.canSelect) {
                    this.f47080s.add(Integer.valueOf(next.channelId));
                } else if (next.selected) {
                    this.f47080s.add(Integer.valueOf(next.channelId));
                }
            }
        }
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i) {
        updateThirdPartPayView(list, i, false);
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z) {
        if (list == null || list.size() < 1 || list.size() <= i) {
            this.f47071j.setVisibility(8);
            return;
        }
        this.payBtnClicked = false;
        LogUtil.m35171d(f47057x, "updateThirdPartPayView payChannelItems:" + list);
        if (this.f47079r <= 0 && i >= 0) {
            this.f47079r = list.get(i).channelId;
        }
        m35036d();
        this.f47071j.setData(list, z, false);
        if (z) {
            this.f47071j.onItemClick(i, true);
            this.f47071j.setSelection(i);
        } else {
            this.f47071j.onItemClick(i, true);
        }
        this.f47071j.setVisibility(0);
        m35027a(this.f47071j.hasHidePayItem());
        this.f47071j.setOnSelectionListener(new SingleSelectionListView.OnSelectListener() {
            public void onSelect(int i, Object obj) {
                if (PaymentView.this.f47071j.hasLoadingStateItem()) {
                    PaymentView.this.m35032b(false);
                }
                PayChannelItem payChannelItem = (PayChannelItem) obj;
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.onPayItemSelected(i, payChannelItem);
                }
            }

            public void unSelect(int i, Object obj) {
                PayChannelItem payChannelItem = (PayChannelItem) obj;
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.unSelectThirdPartItem(i, payChannelItem);
                }
            }

            public void itemClicked(int i, PayChannelItem payChannelItem) {
                PaymentView.this.mListener.onThirdPartPayItemClicked(i, payChannelItem);
            }
        });
    }

    public void setChangePayItemResult(boolean z) {
        PayMethodView payMethodView = this.f47071j;
        if (payMethodView != null && payMethodView.hasLoadingStateItem()) {
            this.f47071j.setBlockChangeResult(z);
        }
        PlatformPayView platformPayView = this.f47070i;
        if (platformPayView != null && platformPayView.hasLoadingStateItem()) {
            this.f47070i.setBlockChangeResult(z);
        }
        m35032b(true);
    }

    public void setThirdPartPayChangeMode(boolean z) {
        this.f47071j.setItemChangeMode(z);
    }

    public void setCancelableForThirdPay(boolean z) {
        this.f47071j.setCancelable(z);
    }

    /* renamed from: a */
    private void m35027a(boolean z) {
        if (z) {
            this.f47072k.setVisibility(0);
        } else {
            this.f47072k.setVisibility(8);
        }
    }

    public void selectedPayItem(PayChannelItem payChannelItem) {
        this.f47071j.onItemClick(payChannelItem);
    }

    public void setPayStatement(String str) {
        m35036d();
        if (!UnipayTextUtil.isEmpty(str)) {
            this.f47073l.setText(str);
            this.f47073l.setVisibility(0);
            return;
        }
        this.f47073l.setVisibility(8);
    }

    public void setPayBtnText(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.f47074m.setText(str);
        }
    }

    public boolean isPayItemsExpand() {
        return this.f47071j.getChildCount() > 0 && this.f47072k.getVisibility() == 8;
    }

    public void showFeeDetailEntraView(boolean z) {
        if (z) {
            this.f47067f.setVisibility(0);
            this.f47065d.setOnClickListener(this);
            return;
        }
        this.f47067f.setVisibility(8);
        this.f47065d.setOnClickListener((View.OnClickListener) null);
    }

    public PayTypes getPayMethodTypes() {
        PayTypes payTypes = new PayTypes();
        PayChannelItem selection = this.f47071j.getSelection();
        if (selection != null) {
            payTypes.thirdPartPayType = selection.channelId;
        }
        payTypes.canUseEntraprisepay = this.f47070i.canUseEntraprisePay();
        payTypes.platformPayType = this.f47070i.isDDCreditSected() ? 161 : 0;
        return payTypes;
    }

    public void setCloseIconEnable(boolean z) {
        this.f47063b.setClosable(z);
    }

    public boolean isCloseIconEnable() {
        return this.f47063b.isCloseAble();
    }

    public void setListener(IPayView.PayViewListener payViewListener) {
        this.mListener = payViewListener;
        this.f47063b.setCloseIconListener(new CardTitleView.CardTitleCloseBtnListener() {
            public void onCloseBtnClick() {
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.onCloseBtnClick();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35032b(boolean z) {
        if (z) {
            this.f47074m.setBackgroundResource(getPayResourceId());
            this.f47074m.setEnabled(true);
            this.f47071j.setItemEnable(true);
            this.f47070i.setItemEnable(true);
            return;
        }
        this.f47074m.setBackgroundResource(getPayDisableResourceId());
        this.f47074m.setEnabled(false);
        this.f47071j.setItemEnable(false);
        this.f47070i.setItemEnable(false);
    }

    public void showQueryPayResultView(boolean z, LoadingState loadingState, int i) {
        this.f47084w.showQueryPayResultView(z);
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showLoadingView(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            r0 = 8
            r1 = 0
            if (r6 == 0) goto L_0x0041
            r6 = 0
            android.widget.FrameLayout r2 = r4.payStateLayout
            int r2 = r2.getChildCount()
            if (r2 <= 0) goto L_0x001d
            android.widget.FrameLayout r2 = r4.payStateLayout
            android.view.View r2 = r2.getChildAt(r1)
            boolean r3 = r2 instanceof com.didi.unifiedPay.component.widget.LoadingStateView
            if (r3 == 0) goto L_0x001d
            r6 = r2
            com.didi.unifiedPay.component.widget.LoadingStateView r6 = (com.didi.unifiedPay.component.widget.LoadingStateView) r6
            r2 = 1
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            if (r6 != 0) goto L_0x0029
            com.didi.unifiedPay.component.widget.LoadingStateView r6 = new com.didi.unifiedPay.component.widget.LoadingStateView
            android.content.Context r3 = r4.getContext()
            r6.<init>(r3)
        L_0x0029:
            com.didi.unifiedPay.component.widget.LoadingStateView$State r3 = com.didi.unifiedPay.component.widget.LoadingStateView.State.LOADING_STATE
            r6.changeState(r3)
            r6.setText((java.lang.String) r5)
            if (r2 != 0) goto L_0x0050
            r4.showPayStateView(r6)
            android.widget.LinearLayout r5 = r4.payBizViewLayout
            r5.setVisibility(r0)
            android.widget.FrameLayout r5 = r4.payStateLayout
            r5.setVisibility(r1)
            goto L_0x0050
        L_0x0041:
            android.widget.FrameLayout r5 = r4.payStateLayout
            r5.removeAllViews()
            android.widget.FrameLayout r5 = r4.payStateLayout
            r5.setVisibility(r0)
            android.widget.LinearLayout r5 = r4.payBizViewLayout
            r5.setVisibility(r1)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.component.view.PaymentView.showLoadingView(java.lang.String, boolean):void");
    }

    public void showSuccessOnPayBtn() {
        if (!this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(true);
        }
        setPayBtnState(PayBtnState.ENABLE);
        setPayBtnText(getResources().getString(R.string.oc_pay_success_string));
    }

    public boolean isShowSuccessOnBtn() {
        return getResources().getString(R.string.oc_pay_success_string).equals(this.f47074m.getText());
    }

    public void showSuccessView(boolean z) {
        this.f47084w.showSuccessView(z, this.f47062a.getString(R.string.oc_pay_success_state_string));
    }

    public void showSuccessView(boolean z, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f47062a.getResources().getString(R.string.oc_pay_success_state_string);
        }
        this.f47084w.showSuccessView(z, str);
    }

    public void showToastView(final ToastView.Config config) {
        ToastView toastView = new ToastView(getContext());
        toastView.setListener(new ToastView.DismissListener() {
            public void onDismiss() {
                PaymentView.this.showBizViewLayout();
                if (config.listener != null) {
                    config.listener.onDismiss();
                }
            }
        });
        toastView.setupView(config);
        showPayStateView(toastView);
        this.payBizViewLayout.setVisibility(8);
        this.payStateLayout.setVisibility(0);
    }

    public void showErrorView(final FailStateView.Config config) {
        FailStateView failStateView = new FailStateView(getContext());
        failStateView.setupView(config);
        failStateView.setTag(new PayErrorEvent(config.errorCode, config.message));
        failStateView.setFailViewClickListener(new FailStateView.ClickListener() {
            public void onCancel() {
                PaymentView.this.showBizViewLayout();
                if (config.listener != null) {
                    config.listener.onCancel();
                }
            }

            public void onConfirm() {
                PaymentView.this.showBizViewLayout();
                if (config.listener != null) {
                    config.listener.onConfirm();
                }
            }
        });
        showPayStateView(failStateView);
        this.payBizViewLayout.setVisibility(8);
        this.payStateLayout.setVisibility(0);
        resetViewClickable();
    }

    public PayErrorEvent isShowErrorView() {
        View childAt;
        if (this.payBizViewLayout.getVisibility() != 8 || this.payStateLayout.getVisibility() != 0 || (childAt = this.payStateLayout.getChildAt(0)) == null || !(childAt.getTag() instanceof PayErrorEvent)) {
            return null;
        }
        return (PayErrorEvent) childAt.getTag();
    }

    /* access modifiers changed from: protected */
    public boolean isShowLoadingStateView() {
        if (this.payStateLayout.getChildCount() <= 0 || !(this.payStateLayout.getChildAt(0) instanceof LoadingStateView)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void showBizViewLayout() {
        this.payStateLayout.setVisibility(8);
        this.payBizViewLayout.setVisibility(0);
        resetViewClickable();
    }

    /* access modifiers changed from: protected */
    public boolean isShowBizView() {
        return this.payBizViewLayout.getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void showPayStateView(View view) {
        this.payStateLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.payStateLayout.getLayoutParams();
        int payBizViewHeight = getPayBizViewHeight();
        if (payBizViewHeight > 0) {
            layoutParams.height = payBizViewHeight;
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            int dimension = (int) this.f47062a.getResources().getDimension(R.dimen.oc_pay_state_margin);
            layoutParams.setMargins(0, dimension, 0, dimension);
        }
        this.payStateLayout.addView(view);
    }

    public void setPayBtnState(PayBtnState payBtnState) {
        if (payBtnState == PayBtnState.ENABLE) {
            this.f47075n.setVisibility(8);
            this.f47074m.setVisibility(0);
            this.f47074m.setEnabled(true);
        } else if (payBtnState == PayBtnState.DISABLE) {
            this.f47075n.setVisibility(8);
            this.f47074m.setVisibility(0);
            this.f47074m.setEnabled(false);
        } else if (payBtnState == PayBtnState.LOADING) {
            this.f47074m.setVisibility(8);
            this.f47075n.setVisibility(0);
            ((AnimationDrawable) this.f47075n.getDrawable()).start();
        }
    }

    public void resetViewClickable() {
        setPayBtnState(PayBtnState.ENABLE);
        setCloseIconEnable(true);
        if (this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(false);
        }
    }

    private int getPayBizViewHeight() {
        return this.payBizViewLayout.getHeight();
    }

    /* renamed from: a */
    private boolean m35029a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return true;
        }
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i).getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public String getPayMethod() {
        PayChannelItem selection;
        List<PlatformPayItem> list = this.f47078q;
        String str = "";
        if (list != null && list.size() > 0) {
            for (PlatformPayItem next : this.f47078q) {
                if (next != null) {
                    String payMethodFromType = PayMethodManager.getPayMethodFromType(next.channelId);
                    if (!UnipayTextUtil.isEmpty(payMethodFromType)) {
                        payMethodFromType = payMethodFromType + ",";
                    }
                    str = str + payMethodFromType;
                }
            }
        }
        PayMethodView payMethodView = this.f47071j;
        if (payMethodView == null || (selection = payMethodView.getSelection()) == null) {
            return str;
        }
        return str + PayMethodManager.getPayMethodFromType(selection.channelId);
    }

    public void removeThirdPartPay() {
        findViewById(R.id.oc_iv_pay_pay_line).setVisibility(8);
        this.f47071j.setVisibility(8);
        this.f47072k.setVisibility(8);
    }

    public void showThirdPartPay() {
        findViewById(R.id.oc_iv_pay_pay_line).setVisibility(0);
        this.f47071j.setVisibility(0);
        if (this.f47071j.hasHidePayItem()) {
            this.f47072k.setVisibility(0);
        }
    }

    public String getInitPayMethod() {
        List list = this.f47080s;
        String str = "";
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.f47080s.size(); i++) {
                Integer num = (Integer) this.f47080s.get(i);
                if (num != null) {
                    String payMethodFromType = PayMethodManager.getPayMethodFromType(num.intValue());
                    if (!UnipayTextUtil.isEmpty(payMethodFromType)) {
                        payMethodFromType = payMethodFromType + ",";
                    }
                    str = str + payMethodFromType;
                }
            }
        }
        if (this.f47079r <= 0) {
            return str;
        }
        return str + PayMethodManager.getPayMethodFromType(this.f47079r);
    }

    /* renamed from: c */
    private boolean m35035c() {
        return this.f47071j.hasLoadingStateItem() || this.f47070i.hasLoadingStateItem();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null && view != null && !Utils.isFastDoubleClick()) {
            if (view == this.f47065d) {
                this.mListener.onShowFeeDetailClick();
            } else if (view == this.f47072k) {
                m35027a(false);
                this.f47071j.showAllPayItem(!m35035c());
                this.mListener.onExpandAllThirdPayItemByUser();
            } else if (view == this.f47074m) {
                onPayBtnClick();
            } else if (m35028a(view)) {
                this.mListener.onDeductionItemClick((VoucherViewConfig) view.getTag());
            }
        }
    }

    public void onPayBtnClick() {
        this.f47084w.onPayBtnClick();
        this.payBtnClicked = true;
        this.mListener.onPayButtonClick();
    }

    /* renamed from: a */
    private boolean m35028a(View view) {
        if (view == null) {
            return false;
        }
        DeductionItemType deductionItemType = ((VoucherViewConfig) view.getTag()).deductionType;
        if (deductionItemType == DeductionItemType.TYPE_VOUCHER || deductionItemType == DeductionItemType.TYPE_SVIP || deductionItemType == DeductionItemType.REPLACE_ORDER_DEDUCTION || deductionItemType == DeductionItemType.MERCHANT_RIGHT_DEDUCTIO) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private void m35036d() {
        if (this.f47082u == null) {
            this.f47082u = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (PaymentView.this.f47076o != null) {
                        if (Build.VERSION.SDK_INT < 16) {
                            PaymentView.this.f47076o.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            PaymentView.this.f47076o.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                        boolean z = false;
                        boolean z2 = PaymentView.this.f47076o.getMeasuredHeight() < PaymentView.this.f47076o.getChildAt(0).getHeight();
                        if (z2 != PaymentView.this.f47081t) {
                            LogUtil.m35171d(PaymentView.f47057x, " mIsScrollable:" + z2);
                            boolean unused = PaymentView.this.f47081t = z2;
                            PaymentView paymentView = PaymentView.this;
                            ScrollView c = paymentView.f47076o;
                            LinearLayout e = PaymentView.this.f47077p;
                            if (PaymentView.this.f47073l.getVisibility() == 0) {
                                z = true;
                            }
                            paymentView.m35023a(c, e, z);
                        }
                    }
                }
            };
        }
        this.f47076o.getViewTreeObserver().addOnGlobalLayoutListener(this.f47082u);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35023a(ScrollView scrollView, LinearLayout linearLayout, boolean z) {
        Context context;
        if (scrollView != null && linearLayout != null && (context = this.f47062a) != null) {
            int dip2pxInt = UIUtils.dip2pxInt(context, z ? 79.0f : 50.0f);
            int dip2pxInt2 = UIUtils.dip2pxInt(this.f47062a, 10.0f) + dip2pxInt;
            LogUtil.m35171d(f47057x, "reLayout payArea Height:" + dip2pxInt + " marginBttom:" + dip2pxInt2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) scrollView.getLayoutParams();
            if (this.f47081t) {
                layoutParams.setMargins(0, 0, 0, dip2pxInt2);
            } else {
                layoutParams.setMargins(0, 0, 0, UIUtils.dip2pxInt(this.f47062a, 20.0f) + dip2pxInt2);
            }
            scrollView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.setMargins(0, -dip2pxInt2, 0, 0);
            linearLayout.setLayoutParams(layoutParams2);
        }
    }
}
