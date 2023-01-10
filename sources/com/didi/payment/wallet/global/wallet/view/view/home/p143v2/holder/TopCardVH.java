package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountStatusMessage;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.BulletinBoardSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.QuickFunctionSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.FreezeInterceptor;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 }2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001}B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020q2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00030yH\u0016J\u0012\u0010z\u001a\u00020q2\b\u0010{\u001a\u0004\u0018\u00010|H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010#\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010%\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010'\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010)\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0011\u00107\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0011\u00109\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0011\u0010;\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0011\u0010=\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b>\u00104R\u0011\u0010?\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bD\u0010BR\u0011\u0010E\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bF\u0010BR\u0011\u0010G\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bH\u0010BR\u0011\u0010I\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010BR\u0011\u0010K\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bL\u0010BR\u0011\u0010M\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bN\u0010BR\u0011\u0010O\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bP\u0010BR\u0011\u0010Q\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bR\u0010BR\u0011\u0010S\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bT\u0010BR\u0011\u0010U\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bV\u0010BR\u0011\u0010W\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bX\u0010BR\u0011\u0010Y\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010BR\u0011\u0010[\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010BR\u0011\u0010]\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\b^\u0010BR\u0011\u0010_\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\b`\u0010BR\u0011\u0010a\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bb\u0010BR\u0011\u0010c\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bd\u0010BR\u0011\u0010e\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bf\u0010BR\u0011\u0010g\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0011\u0010j\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010iR\u0011\u0010l\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010iR\u0011\u0010n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u0010i¨\u0006~"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/IHomeViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "clCard", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClCard", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "clFreeze", "getClFreeze", "clTopUp", "getClTopUp$wallet_globalRelease", "flAddCard", "Landroid/widget/FrameLayout;", "getFlAddCard", "()Landroid/widget/FrameLayout;", "flPublic", "getFlPublic", "flRoot", "getFlRoot", "ivAddBank", "Landroid/widget/ImageView;", "getIvAddBank", "()Landroid/widget/ImageView;", "ivAddGifBank", "getIvAddGifBank", "ivCardRight", "getIvCardRight", "ivFreeze", "getIvFreeze", "ivFreezeIcon", "getIvFreezeIcon", "ivPayLogo", "getIvPayLogo", "ivPrepaid", "getIvPrepaid", "ivPublicClose", "getIvPublicClose", "ivTopUp", "getIvTopUp", "lister", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "getLister", "()Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "setLister", "(Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "llBank", "Landroid/widget/LinearLayout;", "getLlBank", "()Landroid/widget/LinearLayout;", "llBottom", "getLlBottom", "llCoupon", "getLlCoupon", "llPrepaidMsg", "getLlPrepaidMsg", "llQuickFunction", "getLlQuickFunction", "llTag", "getLlTag", "tvAddCard", "Landroid/widget/TextView;", "getTvAddCard", "()Landroid/widget/TextView;", "tvBalance", "getTvBalance", "tvBank", "getTvBank", "tvBankCount", "getTvBankCount", "tvCashback", "getTvCashback", "tvCoupon", "getTvCoupon", "tvCouponCount", "getTvCouponCount", "tvDesc", "getTvDesc", "tvDiscount", "getTvDiscount", "tvEarnings", "getTvEarnings", "tvFreezeDesc", "getTvFreezeDesc", "tvFreezeTitle", "getTvFreezeTitle", "tvPrepaidDate", "getTvPrepaidDate", "tvPrepaidMsg", "getTvPrepaidMsg", "tvPrepaidNo", "getTvPrepaidNo", "tvPublic", "getTvPublic", "tvStatus", "getTvStatus", "tvTitle", "getTvTitle", "tvTopUp", "getTvTopUp", "viewCardDot", "getViewCardDot", "()Landroid/view/View;", "viewDot", "getViewDot", "viewLine", "getViewLine", "viewTopCard", "getViewTopCard", "layoutQuickFunction", "", "data", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/QuickFunctionSection;", "status", "", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/QuickFunctionSection;Ljava/lang/Integer;)V", "onBindViewHolder", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "uploadPublic", "bulletinBoardSection", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BulletinBoardSection;", "Companion", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardVH */
/* compiled from: TopCardVH.kt */
public abstract class TopCardVH extends RecyclerView.ViewHolder implements IHomeViewHolder<Data> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: T */
    public static int f35236T = R.drawable.ic_home_top_card_hide;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public static int f35237U = R.drawable.ic_home_top_card_open;

    /* renamed from: A */
    private final ImageView f35238A;

    /* renamed from: B */
    private final TextView f35239B;

    /* renamed from: C */
    private final ImageView f35240C;

    /* renamed from: D */
    private final ImageView f35241D;

    /* renamed from: E */
    private final View f35242E;

    /* renamed from: F */
    private final ConstraintLayout f35243F;

    /* renamed from: G */
    private final ConstraintLayout f35244G;

    /* renamed from: H */
    private final ConstraintLayout f35245H;

    /* renamed from: I */
    private final TextView f35246I;

    /* renamed from: J */
    private final ImageView f35247J;

    /* renamed from: K */
    private final FrameLayout f35248K;

    /* renamed from: L */
    private final TextView f35249L;

    /* renamed from: M */
    private final TextView f35250M;

    /* renamed from: N */
    private final ImageView f35251N;

    /* renamed from: O */
    private final ImageView f35252O;

    /* renamed from: P */
    private final ImageView f35253P;

    /* renamed from: Q */
    private final LinearLayout f35254Q;

    /* renamed from: R */
    private final ImageView f35255R;

    /* renamed from: S */
    private final View f35256S;

    /* renamed from: a */
    private WalletHomeContract.V2Listener f35257a;

    /* renamed from: b */
    private final View f35258b;

    /* renamed from: c */
    private final TextView f35259c;

    /* renamed from: d */
    private final TextView f35260d;

    /* renamed from: e */
    private final TextView f35261e;

    /* renamed from: f */
    private final TextView f35262f;

    /* renamed from: g */
    private final TextView f35263g;

    /* renamed from: h */
    private final TextView f35264h;

    /* renamed from: i */
    private final TextView f35265i;

    /* renamed from: j */
    private final TextView f35266j;

    /* renamed from: k */
    private final LinearLayout f35267k;

    /* renamed from: l */
    private final LinearLayout f35268l;

    /* renamed from: m */
    private final FrameLayout f35269m;

    /* renamed from: n */
    private final TextView f35270n;

    /* renamed from: o */
    private final LinearLayout f35271o;

    /* renamed from: p */
    private final View f35272p;

    /* renamed from: q */
    private final FrameLayout f35273q;

    /* renamed from: r */
    private final TextView f35274r;

    /* renamed from: s */
    private final TextView f35275s;

    /* renamed from: t */
    private final TextView f35276t;

    /* renamed from: u */
    private final TextView f35277u;

    /* renamed from: v */
    private final LinearLayout f35278v;

    /* renamed from: w */
    private final ImageView f35279w;

    /* renamed from: x */
    private final TextView f35280x;

    /* renamed from: y */
    private final TextView f35281y;

    /* renamed from: z */
    private final LinearLayout f35282z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopCardVH(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.view_topCard);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.view_topCard)");
        this.f35258b = findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_title)");
        this.f35259c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_balance);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_balance)");
        this.f35260d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_desc)");
        this.f35261e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_status);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_status)");
        this.f35262f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_bank);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.tv_bank)");
        this.f35263g = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_bank_count);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.tv_bank_count)");
        this.f35264h = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.tv_coupon);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.tv_coupon)");
        this.f35265i = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.tv_coupon_count);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.tv_coupon_count)");
        this.f35266j = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.ll_bank);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.ll_bank)");
        this.f35267k = (LinearLayout) findViewById10;
        View findViewById11 = view.findViewById(R.id.ll_coupon);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.id.ll_coupon)");
        this.f35268l = (LinearLayout) findViewById11;
        View findViewById12 = view.findViewById(R.id.fl_public);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(R.id.fl_public)");
        this.f35269m = (FrameLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.tv_public);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "itemView.findViewById(R.id.tv_public)");
        this.f35270n = (TextView) findViewById13;
        View findViewById14 = view.findViewById(R.id.ll_function);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "itemView.findViewById(R.id.ll_function)");
        this.f35271o = (LinearLayout) findViewById14;
        View findViewById15 = view.findViewById(R.id.view_dot);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "itemView.findViewById(R.id.view_dot)");
        this.f35272p = findViewById15;
        View findViewById16 = view.findViewById(R.id.fl_add_card);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "itemView.findViewById(R.id.fl_add_card)");
        this.f35273q = (FrameLayout) findViewById16;
        View findViewById17 = view.findViewById(R.id.tv_add_card_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "itemView.findViewById(R.id.tv_add_card_discount)");
        this.f35274r = (TextView) findViewById17;
        View findViewById18 = view.findViewById(R.id.tv_add_card);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "itemView.findViewById(R.id.tv_add_card)");
        this.f35275s = (TextView) findViewById18;
        View findViewById19 = view.findViewById(R.id.tv_earnings);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "itemView.findViewById(R.id.tv_earnings)");
        this.f35276t = (TextView) findViewById19;
        View findViewById20 = view.findViewById(R.id.tv_cashback);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "itemView.findViewById(R.id.tv_cashback)");
        this.f35277u = (TextView) findViewById20;
        View findViewById21 = view.findViewById(R.id.ll_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "itemView.findViewById(R.id.ll_tag)");
        this.f35278v = (LinearLayout) findViewById21;
        View findViewById22 = view.findViewById(R.id.iv_public_close);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "itemView.findViewById(R.id.iv_public_close)");
        this.f35279w = (ImageView) findViewById22;
        View findViewById23 = view.findViewById(R.id.tv_prepaid_no);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "itemView.findViewById(R.id.tv_prepaid_no)");
        this.f35280x = (TextView) findViewById23;
        View findViewById24 = view.findViewById(R.id.tv_prepaid_date);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "itemView.findViewById(R.id.tv_prepaid_date)");
        this.f35281y = (TextView) findViewById24;
        View findViewById25 = view.findViewById(R.id.fl_prepaid_msg);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "itemView.findViewById(R.id.fl_prepaid_msg)");
        this.f35282z = (LinearLayout) findViewById25;
        View findViewById26 = view.findViewById(R.id.iv_prepaid);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "itemView.findViewById(R.id.iv_prepaid)");
        this.f35238A = (ImageView) findViewById26;
        View findViewById27 = view.findViewById(R.id.tv_prepaid_msg);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "itemView.findViewById(R.id.tv_prepaid_msg)");
        this.f35239B = (TextView) findViewById27;
        View findViewById28 = view.findViewById(R.id.iv_add_bank);
        Intrinsics.checkNotNullExpressionValue(findViewById28, "itemView.findViewById(R.id.iv_add_bank)");
        this.f35240C = (ImageView) findViewById28;
        View findViewById29 = view.findViewById(R.id.iv_add_gif);
        Intrinsics.checkNotNullExpressionValue(findViewById29, "itemView.findViewById(R.id.iv_add_gif)");
        this.f35241D = (ImageView) findViewById29;
        View findViewById30 = view.findViewById(R.id.view_card_dot);
        Intrinsics.checkNotNullExpressionValue(findViewById30, "itemView.findViewById(R.id.view_card_dot)");
        this.f35242E = findViewById30;
        View findViewById31 = view.findViewById(R.id.cl_freeze);
        Intrinsics.checkNotNullExpressionValue(findViewById31, "itemView.findViewById(R.id.cl_freeze)");
        this.f35243F = (ConstraintLayout) findViewById31;
        View findViewById32 = view.findViewById(R.id.cl_card);
        Intrinsics.checkNotNullExpressionValue(findViewById32, "itemView.findViewById(R.id.cl_card)");
        this.f35244G = (ConstraintLayout) findViewById32;
        View findViewById33 = view.findViewById(R.id.cl_topup);
        Intrinsics.checkNotNullExpressionValue(findViewById33, "itemView.findViewById(R.id.cl_topup)");
        this.f35245H = (ConstraintLayout) findViewById33;
        View findViewById34 = view.findViewById(R.id.tv_topup);
        Intrinsics.checkNotNullExpressionValue(findViewById34, "itemView.findViewById(R.id.tv_topup)");
        this.f35246I = (TextView) findViewById34;
        View findViewById35 = view.findViewById(R.id.iv_topup);
        Intrinsics.checkNotNullExpressionValue(findViewById35, "itemView.findViewById(R.id.iv_topup)");
        this.f35247J = (ImageView) findViewById35;
        View findViewById36 = view.findViewById(R.id.fl_root);
        Intrinsics.checkNotNullExpressionValue(findViewById36, "itemView.findViewById(R.id.fl_root)");
        this.f35248K = (FrameLayout) findViewById36;
        View findViewById37 = view.findViewById(R.id.tv_freeze_title);
        Intrinsics.checkNotNullExpressionValue(findViewById37, "itemView.findViewById(R.id.tv_freeze_title)");
        this.f35249L = (TextView) findViewById37;
        View findViewById38 = view.findViewById(R.id.tv_freeze_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById38, "itemView.findViewById(R.id.tv_freeze_desc)");
        this.f35250M = (TextView) findViewById38;
        View findViewById39 = view.findViewById(R.id.iv_freeze);
        Intrinsics.checkNotNullExpressionValue(findViewById39, "itemView.findViewById(R.id.iv_freeze)");
        this.f35251N = (ImageView) findViewById39;
        View findViewById40 = view.findViewById(R.id.iv_freeze_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById40, "itemView.findViewById(R.id.iv_freeze_icon)");
        this.f35252O = (ImageView) findViewById40;
        View findViewById41 = view.findViewById(R.id.iv_card_right);
        Intrinsics.checkNotNullExpressionValue(findViewById41, "itemView.findViewById(R.id.iv_card_right)");
        this.f35253P = (ImageView) findViewById41;
        View findViewById42 = view.findViewById(R.id.ll_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById42, "itemView.findViewById(R.id.ll_bottom)");
        this.f35254Q = (LinearLayout) findViewById42;
        View findViewById43 = view.findViewById(R.id.iv_pay_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById43, "itemView.findViewById(R.id.iv_pay_logo)");
        this.f35255R = (ImageView) findViewById43;
        View findViewById44 = view.findViewById(R.id.v_line);
        Intrinsics.checkNotNullExpressionValue(findViewById44, "itemView.findViewById(R.id.v_line)");
        this.f35256S = findViewById44;
    }

    @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardVH$Companion;", "", "()V", "balanceEycHideDrawableId", "", "getBalanceEycHideDrawableId", "()I", "setBalanceEycHideDrawableId", "(I)V", "balanceEyeShowDrawableId", "getBalanceEyeShowDrawableId", "setBalanceEyeShowDrawableId", "switchAmountStatus", "", "amountStatus", "", "tvTitle", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardVH$Companion */
    /* compiled from: TopCardVH.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getBalanceEyeShowDrawableId() {
            return TopCardVH.f35236T;
        }

        public final void setBalanceEyeShowDrawableId(int i) {
            TopCardVH.f35236T = i;
        }

        public final int getBalanceEycHideDrawableId() {
            return TopCardVH.f35237U;
        }

        public final void setBalanceEycHideDrawableId(int i) {
            TopCardVH.f35237U = i;
        }

        public final void switchAmountStatus(boolean z, TextView textView, Context context) {
            Intrinsics.checkNotNullParameter(textView, "tvTitle");
            Intrinsics.checkNotNullParameter(context, "context");
            int balanceEyeShowDrawableId = z ? getBalanceEyeShowDrawableId() : getBalanceEycHideDrawableId();
            if (Build.VERSION.SDK_INT >= 21) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, context.getResources().getDrawable(balanceEyeShowDrawableId, (Resources.Theme) null), (Drawable) null);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, context.getResources().getDrawable(balanceEyeShowDrawableId), (Drawable) null);
            }
        }
    }

    public final WalletHomeContract.V2Listener getLister() {
        return this.f35257a;
    }

    public final void setLister(WalletHomeContract.V2Listener v2Listener) {
        this.f35257a = v2Listener;
    }

    public final View getViewTopCard() {
        return this.f35258b;
    }

    public final TextView getTvTitle() {
        return this.f35259c;
    }

    public final TextView getTvBalance() {
        return this.f35260d;
    }

    public final TextView getTvDesc() {
        return this.f35261e;
    }

    public final TextView getTvStatus() {
        return this.f35262f;
    }

    public final TextView getTvBank() {
        return this.f35263g;
    }

    public final TextView getTvBankCount() {
        return this.f35264h;
    }

    public final TextView getTvCoupon() {
        return this.f35265i;
    }

    public final TextView getTvCouponCount() {
        return this.f35266j;
    }

    public final LinearLayout getLlBank() {
        return this.f35267k;
    }

    public final LinearLayout getLlCoupon() {
        return this.f35268l;
    }

    public final FrameLayout getFlPublic() {
        return this.f35269m;
    }

    public final TextView getTvPublic() {
        return this.f35270n;
    }

    public final LinearLayout getLlQuickFunction() {
        return this.f35271o;
    }

    public final View getViewDot() {
        return this.f35272p;
    }

    public final FrameLayout getFlAddCard() {
        return this.f35273q;
    }

    public final TextView getTvDiscount() {
        return this.f35274r;
    }

    public final TextView getTvAddCard() {
        return this.f35275s;
    }

    public final TextView getTvEarnings() {
        return this.f35276t;
    }

    public final TextView getTvCashback() {
        return this.f35277u;
    }

    public final LinearLayout getLlTag() {
        return this.f35278v;
    }

    public final ImageView getIvPublicClose() {
        return this.f35279w;
    }

    public final TextView getTvPrepaidNo() {
        return this.f35280x;
    }

    public final TextView getTvPrepaidDate() {
        return this.f35281y;
    }

    public final LinearLayout getLlPrepaidMsg() {
        return this.f35282z;
    }

    public final ImageView getIvPrepaid() {
        return this.f35238A;
    }

    public final TextView getTvPrepaidMsg() {
        return this.f35239B;
    }

    public final ImageView getIvAddBank() {
        return this.f35240C;
    }

    public final ImageView getIvAddGifBank() {
        return this.f35241D;
    }

    public final View getViewCardDot() {
        return this.f35242E;
    }

    public final ConstraintLayout getClFreeze() {
        return this.f35243F;
    }

    public final ConstraintLayout getClCard() {
        return this.f35244G;
    }

    public final ConstraintLayout getClTopUp$wallet_globalRelease() {
        return this.f35245H;
    }

    public final TextView getTvTopUp() {
        return this.f35246I;
    }

    public final ImageView getIvTopUp() {
        return this.f35247J;
    }

    public final FrameLayout getFlRoot() {
        return this.f35248K;
    }

    public final TextView getTvFreezeTitle() {
        return this.f35249L;
    }

    public final TextView getTvFreezeDesc() {
        return this.f35250M;
    }

    public final ImageView getIvFreeze() {
        return this.f35251N;
    }

    public final ImageView getIvFreezeIcon() {
        return this.f35252O;
    }

    public final ImageView getIvCardRight() {
        return this.f35253P;
    }

    public final LinearLayout getLlBottom() {
        return this.f35254Q;
    }

    public final ImageView getIvPayLogo() {
        return this.f35255R;
    }

    public final View getViewLine() {
        return this.f35256S;
    }

    public void onBindViewHolder(WalletHomeHolderData<Data> walletHomeHolderData) {
        AccountStatusMessage accountStatusMessage;
        String status;
        Intrinsics.checkNotNullParameter(walletHomeHolderData, "info");
        Data contentObj = walletHomeHolderData.getContentObj();
        if (contentObj != null) {
            m26802a(contentObj.getBulletinBoardSection());
            QuickFunctionSection quickFunctionSection = contentObj.getQuickFunctionSection();
            AccountSection accountSection = contentObj.getAccountSection();
            Integer num = null;
            if (!(accountSection == null || (accountStatusMessage = accountSection.getAccountStatusMessage()) == null || (status = accountStatusMessage.getStatus()) == null)) {
                num = Integer.valueOf(WalletHomeModelKt.toDefaultInt$default(status, 0, 1, (Object) null));
            }
            m26803a(quickFunctionSection, num);
        }
    }

    /* renamed from: a */
    private final void m26803a(QuickFunctionSection quickFunctionSection, Integer num) {
        List<Entry> entryList;
        if (quickFunctionSection != null && (entryList = quickFunctionSection.getEntryList()) != null) {
            Map linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (Object next : entryList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Entry entry = (Entry) next;
                int i3 = i / 3;
                if (linkedHashMap.get(Integer.valueOf(i3)) == null) {
                    linkedHashMap.put(Integer.valueOf(i3), new ArrayList());
                }
                List list = (List) linkedHashMap.get(Integer.valueOf(i3));
                if (list != null) {
                    list.add(entry);
                }
                i = i2;
            }
            getLlQuickFunction().removeAllViews();
            for (Map.Entry value : linkedHashMap.entrySet()) {
                LinearLayout linearLayout = new LinearLayout(this.itemView.getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, UIUtils.dip2px(this.itemView.getContext(), 69.0f));
                linearLayout.setOrientation(0);
                int dip2px = UIUtils.dip2px(this.itemView.getContext(), 12.0f);
                layoutParams.leftMargin = dip2px;
                layoutParams.rightMargin = dip2px;
                linearLayout.setLayoutParams(layoutParams);
                for (Entry entry2 : (Iterable) value.getValue()) {
                    LinearLayout linearLayout2 = new LinearLayout(this.itemView.getContext());
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((UIUtils.getScreenWidth(this.itemView.getContext()) - (dip2px * 2)) / 3, -1);
                    linearLayout2.setGravity(17);
                    linearLayout2.setLayoutParams(layoutParams2);
                    linearLayout2.setOrientation(1);
                    ImageView imageView = new ImageView(this.itemView.getContext());
                    int dip2px2 = UIUtils.dip2px(this.itemView.getContext(), 24.0f);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(dip2px2, dip2px2));
                    GlideUtils.with2load2into(this.itemView.getContext(), entry2.getIconUrl(), imageView);
                    linearLayout2.addView(imageView);
                    TextView textView = new TextView(this.itemView.getContext());
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    textView.setLayoutParams(layoutParams3);
                    layoutParams3.topMargin = UIUtils.dip2px(this.itemView.getContext(), 8.0f);
                    textView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.wallet_color_000000));
                    textView.setTextSize(14.0f);
                    textView.setText(entry2.getName());
                    linearLayout2.addView(textView);
                    linearLayout2.setOnClickListener(new View.OnClickListener(entry2, num) {
                        public final /* synthetic */ Entry f$1;
                        public final /* synthetic */ Integer f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            TopCardVH.m26801a(TopCardVH.this, this.f$1, this.f$2, view);
                        }
                    });
                    linearLayout.addView(linearLayout2);
                }
                getLlQuickFunction().addView(linearLayout);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26801a(TopCardVH topCardVH, Entry entry, Integer num, View view) {
        Intrinsics.checkNotNullParameter(topCardVH, "this$0");
        Intrinsics.checkNotNullParameter(entry, "$entry");
        FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, topCardVH.itemView.getContext(), 1, false, new TopCardVH$layoutQuickFunction$1$2$1$1$1(entry, num, topCardVH), 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m26802a(com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.BulletinBoardSection r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.itemView
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "wallet_home_public_msg"
            java.lang.String r0 = com.didi.payment.wallet.global.utils.WalletSPUtils.getPublicMessageId(r0, r1)
            java.lang.String r1 = "getPublicMessageId(itemV…\"wallet_home_public_msg\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x002d
            if (r5 != 0) goto L_0x0020
            r1 = r3
            goto L_0x0024
        L_0x0020:
            java.lang.String r1 = r5.getId()
        L_0x0024:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r0 = 0
            goto L_0x002e
        L_0x002d:
            r0 = 1
        L_0x002e:
            android.widget.FrameLayout r1 = r4.f35269m
            if (r5 != 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            java.lang.String r3 = r5.getTitle()
        L_0x0037:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0042
            if (r0 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r2 = 8
        L_0x0044:
            r1.setVisibility(r2)
            android.widget.FrameLayout r0 = r4.f35269m
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0054
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion
            r0.trackHomePublicMsgSW()
        L_0x0054:
            if (r5 != 0) goto L_0x0057
            goto L_0x0077
        L_0x0057:
            android.widget.TextView r0 = r4.getTvPublic()
            java.lang.String r1 = r5.getTitle()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            java.lang.String r0 = r5.getLinkUrl()
            if (r0 != 0) goto L_0x006b
            goto L_0x0077
        L_0x006b:
            android.widget.TextView r1 = r4.getTvPublic()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardVH$QibgFXi2lwZ7ytSijOoPCVEAhQw r2 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardVH$QibgFXi2lwZ7ytSijOoPCVEAhQw
            r2.<init>(r0, r4)
            r1.setOnClickListener(r2)
        L_0x0077:
            android.widget.ImageView r0 = r4.f35279w
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardVH$8-ZOljrh9CdEVk20EU23YFrzUgM r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardVH$8-ZOljrh9CdEVk20EU23YFrzUgM
            r1.<init>(r5)
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardVH.m26802a(com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BulletinBoardSection):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26804a(String str, TopCardVH topCardVH, View view) {
        Intrinsics.checkNotNullParameter(str, "$link");
        Intrinsics.checkNotNullParameter(topCardVH, "this$0");
        Uri parse = Uri.parse(str);
        String findUrlStrParam = WalletUriParam.Companion.findUrlStrParam(parse, "crashPageTitle");
        String findUrlStrParam2 = WalletUriParam.Companion.findUrlStrParam(parse, "crashPageText");
        Request request = (Request) ((Request) ((Request) DRouter.build(str).putExtra(WalletExtraConstant.Key.CRASH_PAGE_TITLE, findUrlStrParam)).putExtra(WalletExtraConstant.Key.CRASH_PAGE_SUBTITLE, findUrlStrParam2)).putExtra(WalletExtraConstant.Key.CRASH_TYPE, WalletUriParam.Companion.findUrlStrParam(parse, "crashType"));
        Context context = topCardVH.itemView.getContext();
        if (context != null) {
            request.start(((ContextThemeWrapper) context).getBaseContext());
            WalletHomeTrackerManager.Companion.trackHomePublicMsgCK();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26800a(TopCardVH topCardVH, BulletinBoardSection bulletinBoardSection, View view) {
        String str;
        Intrinsics.checkNotNullParameter(topCardVH, "this$0");
        topCardVH.getFlPublic().setVisibility(8);
        Context context = topCardVH.itemView.getContext();
        if (bulletinBoardSection == null) {
            str = null;
        } else {
            str = bulletinBoardSection.getId();
        }
        WalletSPUtils.savePublicMessageId(context, "wallet_home_public_msg", str);
        WalletHomeTrackerManager.Companion.trackHomePublicMsgClose();
    }
}
