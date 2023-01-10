package com.didi.soda.order.component.evaluatedetail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p128ui.flowlayout.NovaFlowLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationInfoReplyEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationItemsListEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.RiderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.ShopEvaluationEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CircleImageView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.order.component.evaluatedetail.Contract;
import com.didi.soda.order.view.EvaluateDetailBusinessItemView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 [2\u00020\u0001:\u0001[B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0002J\u0014\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010/H\u0002J\u001c\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010/2\u0006\u00106\u001a\u00020+H\u0002J\b\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@H\u0016J\u000e\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\nJ\b\u0010C\u001a\u000208H\u0014J\u0010\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020FH\u0002J\u0012\u0010G\u001a\u0002082\b\u0010H\u001a\u0004\u0018\u00010/H\u0002J\b\u0010I\u001a\u000208H\u0002J\u001a\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020+2\b\u0010L\u001a\u0004\u0018\u00010/H\u0002J\u001a\u0010M\u001a\u0002082\u0010\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010OH\u0002J\u0012\u0010P\u001a\u0002082\b\u0010H\u001a\u0004\u0018\u00010/H\u0002J\u0012\u0010Q\u001a\u0002082\b\u0010R\u001a\u0004\u0018\u00010/H\u0002J\u001a\u0010S\u001a\u0002082\u0006\u0010K\u001a\u00020+2\b\u0010L\u001a\u0004\u0018\u00010/H\u0002J\"\u0010T\u001a\u0002082\u0006\u0010U\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010/2\u0006\u0010V\u001a\u00020+H\u0002J \u0010W\u001a\u0002082\u0006\u0010X\u001a\u00020\f2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010OH\u0002J\u0012\u0010Z\u001a\u0002082\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006\\"}, mo148868d2 = {"Lcom/didi/soda/order/component/evaluatedetail/OrderEvaluateDetailView;", "Lcom/didi/soda/order/component/evaluatedetail/Contract$AbsOrderEvaluateDetailView;", "()V", "abnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "backBtn", "Lcom/didi/soda/customer/widget/text/IconTextView;", "businessCommentTv", "Lcom/didi/rfusion/widget/RFTextView;", "businessDivider", "Landroid/view/View;", "businessFlowLayout", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "businessHeaderIv", "Lcom/didi/soda/customer/widget/CircleImageView;", "businessNameTv", "businessRootContainer", "contentContainer", "deliveryDescTv", "faceIv", "Lcom/didi/rfusion/widget/RFIconView;", "faceLayout", "faceTipTv", "itemEvaluateLinear", "Landroid/widget/LinearLayout;", "mReplyContent", "Landroid/widget/TextView;", "mReplyTime", "mReplyTitle", "mReplyTopLine", "merchantReply", "photoLayout", "riderCommentTv", "riderDivider", "riderFlowLayout", "riderHeaderIv", "riderNameTv", "riderRootContainer", "starContainer", "starLayout", "starTipTv", "titleTv", "calculatePhotoViewBorder", "", "createAbnormalViewModel", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalViewModel;", "errorMsg", "", "createCheckedTextView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "tag", "createPhotoImageView", "Landroid/widget/ImageView;", "imageUrl", "position", "hideAbnormalView", "", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initEvaluationView", "orderEvaluationEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationEntity;", "initView", "root", "onCreate", "randerReply", "orderEvaluationInfoReplyEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationInfoReplyEntity;", "renderBusinessComment", "comment", "renderBusinessDivider", "renderFaceView", "score", "scoreTip", "renderPhotoView", "imageList", "", "renderRiderComment", "renderRiderDeliveryDesc", "deliveryDesc", "renderStarView", "setHeaderImage", "headerView", "defaultImage", "setTagList", "flowLayout", "tagList", "showErrorNetView", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderEvaluateDetailView.kt */
public final class OrderEvaluateDetailView extends Contract.AbsOrderEvaluateDetailView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int GOOD_STAR_COUNT = 4;
    public static final int MAX_PHOTO_COUNT = 5;
    public static final int MAX_STAR_COUNT = 5;
    public static final float PHOTO_MARGIN = 10.0f;

    /* renamed from: A */
    private View f45955A;

    /* renamed from: B */
    private TextView f45956B;

    /* renamed from: C */
    private TextView f45957C;

    /* renamed from: D */
    private TextView f45958D;

    /* renamed from: a */
    private IconTextView f45959a;

    /* renamed from: b */
    private TextView f45960b;

    /* renamed from: c */
    private View f45961c;

    /* renamed from: d */
    private View f45962d;

    /* renamed from: e */
    private CircleImageView f45963e;

    /* renamed from: f */
    private RFTextView f45964f;

    /* renamed from: g */
    private View f45965g;

    /* renamed from: h */
    private LinearLayout f45966h;

    /* renamed from: i */
    private TextView f45967i;

    /* renamed from: j */
    private NovaFlowLayout f45968j;

    /* renamed from: k */
    private View f45969k;

    /* renamed from: l */
    private RFTextView f45970l;

    /* renamed from: m */
    private LinearLayout f45971m;

    /* renamed from: n */
    private LinearLayout f45972n;

    /* renamed from: o */
    private LinearLayout f45973o;

    /* renamed from: p */
    private View f45974p;

    /* renamed from: q */
    private CircleImageView f45975q;

    /* renamed from: r */
    private RFTextView f45976r;

    /* renamed from: s */
    private RFTextView f45977s;

    /* renamed from: t */
    private View f45978t;

    /* renamed from: u */
    private RFIconView f45979u;

    /* renamed from: v */
    private RFTextView f45980v;

    /* renamed from: w */
    private NovaFlowLayout f45981w;

    /* renamed from: x */
    private View f45982x;

    /* renamed from: y */
    private RFTextView f45983y;

    /* renamed from: z */
    private TopGunAbnormalView f45984z;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_order_evaluate_detail, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        initView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…   initView(it)\n        }");
        return inflate;
    }

    public final void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.customer_iv_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_iv_page_back)");
        this.f45959a = (IconTextView) findViewById;
        View findViewById2 = view.findViewById(R.id.customer_tv_title_label);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.customer_tv_title_label)");
        this.f45960b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.customer_sv_content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…mer_sv_content_container)");
        this.f45961c = findViewById3;
        View findViewById4 = view.findViewById(R.id.customer_business_evaluate_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.c…iness_evaluate_container)");
        this.f45962d = findViewById4;
        View findViewById5 = view.findViewById(R.id.customer_iv_business_header_image);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.c…iv_business_header_image)");
        this.f45963e = (CircleImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.customer_business_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.customer_business_name)");
        this.f45964f = (RFTextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.customer_star_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.customer_star_layout)");
        this.f45965g = findViewById7;
        View findViewById8 = view.findViewById(R.id.customer_ll_star_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.customer_ll_star_container)");
        this.f45966h = (LinearLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.customer_star_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.customer_star_tip)");
        this.f45967i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.customer_nfl_business_evaluate_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "root.findViewById(R.id.c…fl_business_evaluate_tag)");
        this.f45968j = (NovaFlowLayout) findViewById10;
        View findViewById11 = view.findViewById(R.id.middle_business_line);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "root.findViewById(R.id.middle_business_line)");
        this.f45969k = findViewById11;
        View findViewById12 = view.findViewById(R.id.customer_evaluate_photo_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "root.findViewById(R.id.customer_evaluate_photo_ll)");
        this.f45971m = (LinearLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.customer_business_evaluate_comment);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "root.findViewById(R.id.c…usiness_evaluate_comment)");
        this.f45970l = (RFTextView) findViewById13;
        View findViewById14 = view.findViewById(R.id.customer_evaluate_item);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "root.findViewById(R.id.customer_evaluate_item)");
        this.f45973o = (LinearLayout) findViewById14;
        View findViewById15 = view.findViewById(R.id.customer_merchant_reply);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "root.findViewById(R.id.customer_merchant_reply)");
        this.f45972n = (LinearLayout) findViewById15;
        View findViewById16 = view.findViewById(R.id.customer_rider_evaluate_container);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "root.findViewById(R.id.c…rider_evaluate_container)");
        this.f45974p = findViewById16;
        View findViewById17 = view.findViewById(R.id.customer_iv_rider_header_image);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "root.findViewById(R.id.c…er_iv_rider_header_image)");
        this.f45975q = (CircleImageView) findViewById17;
        View findViewById18 = view.findViewById(R.id.customer_rider_name);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "root.findViewById(R.id.customer_rider_name)");
        this.f45976r = (RFTextView) findViewById18;
        View findViewById19 = view.findViewById(R.id.customer_delivery_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "root.findViewById(R.id.customer_delivery_desc)");
        this.f45977s = (RFTextView) findViewById19;
        View findViewById20 = view.findViewById(R.id.customer_face_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "root.findViewById(R.id.customer_face_layout)");
        this.f45978t = findViewById20;
        View findViewById21 = view.findViewById(R.id.customer_iv_face);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "root.findViewById(R.id.customer_iv_face)");
        this.f45979u = (RFIconView) findViewById21;
        View findViewById22 = view.findViewById(R.id.customer_face_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "root.findViewById(R.id.customer_face_tip)");
        this.f45980v = (RFTextView) findViewById22;
        View findViewById23 = view.findViewById(R.id.customer_nfl_rider_evaluate_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "root.findViewById(R.id.c…r_nfl_rider_evaluate_tag)");
        this.f45981w = (NovaFlowLayout) findViewById23;
        View findViewById24 = view.findViewById(R.id.middle_rider_line);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "root.findViewById(R.id.middle_rider_line)");
        this.f45982x = findViewById24;
        View findViewById25 = view.findViewById(R.id.customer_rider_evaluate_comment);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "root.findViewById(R.id.c…r_rider_evaluate_comment)");
        this.f45983y = (RFTextView) findViewById25;
        View findViewById26 = view.findViewById(R.id.customer_custom_evaluation_abnormal);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "root.findViewById(R.id.c…stom_evaluation_abnormal)");
        this.f45984z = (TopGunAbnormalView) findViewById26;
        View findViewById27 = view.findViewById(R.id.middle_business_evaluate_line);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "root.findViewById(R.id.m…e_business_evaluate_line)");
        this.f45955A = findViewById27;
        View findViewById28 = view.findViewById(R.id.customer_merchant_name);
        Intrinsics.checkNotNullExpressionValue(findViewById28, "root.findViewById(R.id.customer_merchant_name)");
        this.f45956B = (TextView) findViewById28;
        View findViewById29 = view.findViewById(R.id.customer_merchant_time);
        Intrinsics.checkNotNullExpressionValue(findViewById29, "root.findViewById(R.id.customer_merchant_time)");
        this.f45957C = (TextView) findViewById29;
        View findViewById30 = view.findViewById(R.id.customer_merchant_reply_text);
        Intrinsics.checkNotNullExpressionValue(findViewById30, "root.findViewById(R.id.c…omer_merchant_reply_text)");
        this.f45958D = (TextView) findViewById30;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        IconTextView iconTextView = this.f45959a;
        TextView textView = null;
        if (iconTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            iconTextView = null;
        }
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateDetailView.m34121a(OrderEvaluateDetailView.this, view);
            }
        });
        TextView textView2 = this.f45960b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        } else {
            textView = textView2;
        }
        textView.setText(getString(R.string.FoodC_evaluation_Order_evaluation_DIJO));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34121a(OrderEvaluateDetailView orderEvaluateDetailView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateDetailView, "this$0");
        ((Contract.AbsOrderEvaluateDetailPresenter) orderEvaluateDetailView.getPresenter()).closePage();
    }

    public void initEvaluationView(OrderEvaluationEntity orderEvaluationEntity) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Unit unit;
        Intrinsics.checkNotNullParameter(orderEvaluationEntity, "orderEvaluationEntity");
        View view = this.f45961c;
        LinearLayout linearLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        view.setVisibility(0);
        ShopEvaluationEntity shopEvaluationEntity = orderEvaluationEntity.shop;
        if (shopEvaluationEntity == null || !shopEvaluationEntity.hasEval) {
            View view2 = this.f45962d;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessRootContainer");
                view2 = null;
            }
            view2.setVisibility(8);
        } else {
            CircleImageView circleImageView = this.f45963e;
            if (circleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessHeaderIv");
                circleImageView = null;
            }
            m34118a(circleImageView, shopEvaluationEntity.shopImg, R.drawable.customer_img_business_default_logo);
            RFTextView rFTextView = this.f45964f;
            if (rFTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessNameTv");
                rFTextView = null;
            }
            String str = shopEvaluationEntity.shopName;
            if (str == null) {
                charSequence2 = "";
            } else {
                charSequence2 = str;
            }
            rFTextView.setText(charSequence2);
            if (shopEvaluationEntity.score != 0) {
                m34117a(shopEvaluationEntity.score, shopEvaluationEntity.scoreDesc);
                NovaFlowLayout novaFlowLayout = this.f45968j;
                if (novaFlowLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessFlowLayout");
                    novaFlowLayout = null;
                }
                m34119a(novaFlowLayout, shopEvaluationEntity.tags);
                m34123a(shopEvaluationEntity.imgs);
                m34128c(shopEvaluationEntity.content);
                m34125b();
            }
            OrderEvaluationInfoReplyEntity orderEvaluationInfoReplyEntity = shopEvaluationEntity.reply;
            if (orderEvaluationInfoReplyEntity == null) {
                unit = null;
            } else {
                m34120a(orderEvaluationInfoReplyEntity);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                OrderEvaluateDetailView orderEvaluateDetailView = this;
                LinearLayout linearLayout2 = orderEvaluateDetailView.f45972n;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("merchantReply");
                    linearLayout2 = null;
                }
                linearLayout2.setVisibility(8);
                View view3 = orderEvaluateDetailView.f45955A;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mReplyTopLine");
                    view3 = null;
                }
                view3.setVisibility(8);
            }
        }
        RiderEvaluationEntity riderEvaluationEntity = orderEvaluationEntity.rider;
        if (riderEvaluationEntity == null || !riderEvaluationEntity.hasEval) {
            View view4 = this.f45974p;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("riderRootContainer");
                view4 = null;
            }
            view4.setVisibility(8);
        } else {
            CircleImageView circleImageView2 = this.f45975q;
            if (circleImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("riderHeaderIv");
                circleImageView2 = null;
            }
            m34118a(circleImageView2, riderEvaluationEntity.riderImg, R.drawable.customer_icon_default_delivery);
            RFTextView rFTextView2 = this.f45976r;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("riderNameTv");
                rFTextView2 = null;
            }
            String str2 = riderEvaluationEntity.riderName;
            if (str2 != null) {
                charSequence = str2;
            }
            rFTextView2.setText(charSequence);
            if (riderEvaluationEntity.score != 0) {
                m34129d(riderEvaluationEntity.orderFinishTime);
                m34126b(riderEvaluationEntity.score, riderEvaluationEntity.scoreDesc);
                NovaFlowLayout novaFlowLayout2 = this.f45981w;
                if (novaFlowLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("riderFlowLayout");
                    novaFlowLayout2 = null;
                }
                m34119a(novaFlowLayout2, riderEvaluationEntity.tags);
                m34130e(riderEvaluationEntity.content);
            }
        }
        if (CollectionsUtil.isEmpty(orderEvaluationEntity.items)) {
            LinearLayout linearLayout3 = this.f45973o;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout4 = this.f45973o;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
            linearLayout4 = null;
        }
        linearLayout4.setVisibility(0);
        LinearLayout linearLayout5 = this.f45973o;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
            linearLayout5 = null;
        }
        linearLayout5.removeAllViews();
        List<OrderEvaluationItemsListEntity> list = orderEvaluationEntity.items;
        if (list != null) {
            for (OrderEvaluationItemsListEntity orderEvaluationItemsListEntity : list) {
                LinearLayout linearLayout6 = this.f45973o;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
                    linearLayout6 = null;
                }
                Context context = linearLayout6.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemEvaluateLinear.context");
                EvaluateDetailBusinessItemView evaluateDetailBusinessItemView = new EvaluateDetailBusinessItemView(context, orderEvaluationItemsListEntity.getItemId(), orderEvaluationItemsListEntity.getItemName(), orderEvaluationItemsListEntity.getScore());
                LinearLayout linearLayout7 = this.f45973o;
                if (linearLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
                    linearLayout7 = null;
                }
                linearLayout7.addView(evaluateDetailBusinessItemView);
            }
        }
    }

    /* renamed from: a */
    private final void m34120a(OrderEvaluationInfoReplyEntity orderEvaluationInfoReplyEntity) {
        LinearLayout linearLayout = this.f45972n;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("merchantReply");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        View view = this.f45955A;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyTopLine");
            view = null;
        }
        view.setVisibility(0);
        TextView textView2 = this.f45956B;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyTitle");
            textView2 = null;
        }
        textView2.setText(orderEvaluationInfoReplyEntity.getTitle());
        TextView textView3 = this.f45958D;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            textView3 = null;
        }
        textView3.setText(orderEvaluationInfoReplyEntity.getContent());
        TextView textView4 = this.f45957C;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyTime");
        } else {
            textView = textView4;
        }
        textView.setText(orderEvaluationInfoReplyEntity.getTime());
    }

    public void showErrorNetView(String str) {
        View view = this.f45961c;
        TopGunAbnormalView topGunAbnormalView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        view.setVisibility(8);
        TopGunAbnormalView topGunAbnormalView2 = this.f45984z;
        if (topGunAbnormalView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView2 = null;
        }
        boolean z = false;
        topGunAbnormalView2.setVisibility(0);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            str = "";
        }
        TopGunAbnormalView topGunAbnormalView3 = this.f45984z;
        if (topGunAbnormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
        } else {
            topGunAbnormalView = topGunAbnormalView3;
        }
        topGunAbnormalView.show(m34116a(str));
    }

    public void hideAbnormalView() {
        TopGunAbnormalView topGunAbnormalView = this.f45984z;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(8);
    }

    /* renamed from: a */
    private final TopGunAbnormalViewModel m34116a(String str) {
        $$Lambda$OrderEvaluateDetailView$vR2TSp8zkAX2Wzr1D0fymOrPHAU r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateDetailView.m34127b(OrderEvaluateDetailView.this, view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m34127b(OrderEvaluateDetailView orderEvaluateDetailView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateDetailView, "this$0");
        orderEvaluateDetailView.hideAbnormalView();
        ((Contract.AbsOrderEvaluateDetailPresenter) orderEvaluateDetailView.getPresenter()).retryRequest();
    }

    /* renamed from: a */
    private final void m34118a(ImageView imageView, String str, int i) {
        imageView.setBackground(getResources().getDrawable(i));
        if (!TextUtils.isEmpty(str)) {
            FlyImageLoader.loadImageUnspecified(getContext(), str).placeholder(i).into(imageView);
        }
    }

    /* renamed from: a */
    private final void m34117a(int i, String str) {
        int i2;
        View view = null;
        if (i >= 100) {
            View view2 = this.f45965g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            LinearLayout linearLayout = this.f45966h;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.f45966h;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starContainer");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
            int i3 = i / 100;
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence)) {
                TextView textView = this.f45967i;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView = null;
                }
                textView.setText(charSequence);
                TextView textView2 = this.f45967i;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView2 = null;
                }
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.f45967i;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView3 = null;
                }
                textView3.setVisibility(8);
            }
            if (i3 >= 4) {
                TextView textView4 = this.f45967i;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView4 = null;
                }
                textView4.setTextColor(SkinUtil.getBrandPrimaryColor());
            } else {
                TextView textView5 = this.f45967i;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView5 = null;
                }
                textView5.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            }
            if (i3 >= 4) {
                i2 = SkinUtil.getBrandPrimaryColor();
            } else {
                i2 = ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000);
            }
            int i4 = 1;
            while (true) {
                int i5 = i4 + 1;
                RFIconView rFIconView = new RFIconView(getContext());
                if (i3 >= i4) {
                    rFIconView.setText(R.string.rf_icon_v3_filled_stars);
                } else {
                    rFIconView.setText(R.string.rf_icon_v3_outlined_stars);
                }
                rFIconView.setTextColor(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ResourceHelper.getDimensionPixelSize(R.dimen.customer_28px), ResourceHelper.getDimensionPixelSize(R.dimen.customer_28px));
                if (i4 > 1) {
                    layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_10px);
                }
                rFIconView.setLayoutParams(layoutParams);
                LinearLayout linearLayout3 = this.f45966h;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starContainer");
                    linearLayout3 = null;
                }
                linearLayout3.addView(rFIconView);
                if (i5 <= 5) {
                    i4 = i5;
                } else {
                    return;
                }
            }
        } else {
            View view3 = this.f45965g;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starLayout");
            } else {
                view = view3;
            }
            view.setVisibility(8);
        }
    }

    /* renamed from: a */
    private final void m34119a(NovaFlowLayout novaFlowLayout, List<String> list) {
        Collection collection = list;
        int i = 0;
        if (!(collection == null || collection.isEmpty())) {
            novaFlowLayout.setVisibility(0);
            novaFlowLayout.removeAllViews();
            List arrayList = new ArrayList();
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    String str = list.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(m34124b(str));
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            novaFlowLayout.addView(arrayList);
            return;
        }
        novaFlowLayout.setVisibility(8);
    }

    /* renamed from: a */
    private final void m34123a(List<String> list) {
        List<String> list2 = list;
        Collection collection = list2;
        LinearLayout linearLayout = null;
        if (!(collection == null || collection.isEmpty())) {
            LinearLayout linearLayout2 = this.f45971m;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
            int size = list.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String str = list2.get(i);
                    CharSequence charSequence = str;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        ImageView a = m34115a(str, i);
                        if (a != null) {
                            a.setOnClickListener(new View.OnClickListener(a, str) {
                                public final /* synthetic */ ImageView f$1;
                                public final /* synthetic */ String f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(View view) {
                                    OrderEvaluateDetailView.m34122a(OrderEvaluateDetailView.this, this.f$1, this.f$2, view);
                                }
                            });
                        }
                        LinearLayout linearLayout3 = this.f45971m;
                        if (linearLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
                            linearLayout3 = null;
                        }
                        linearLayout3.addView(a);
                        FlyImageLoader.loadImage1x1(getContext(), str).placeholder((int) R.drawable.customer_skin_icon_business_round_logo).error((int) R.drawable.customer_skin_icon_business_round_logo).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(a);
                    }
                    if (i2 <= size) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            LinearLayout linearLayout4 = this.f45971m;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
            } else {
                linearLayout = linearLayout4;
            }
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34122a(OrderEvaluateDetailView orderEvaluateDetailView, ImageView imageView, String str, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateDetailView, "this$0");
        ((Contract.AbsOrderEvaluateDetailPresenter) orderEvaluateDetailView.getPresenter()).onImageItemClick(imageView, str);
    }

    /* renamed from: b */
    private final CustomerAppCompatTextView m34124b(String str) {
        if (str == null) {
            return null;
        }
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        CustomerAppCompatTextView customerAppCompatTextView = new CustomerAppCompatTextView(getContext());
        customerAppCompatTextView.setText(charSequence);
        customerAppCompatTextView.setGravity(17);
        customerAppCompatTextView.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.rf_dimen_28));
        customerAppCompatTextView.setMaxWidth(CustomerSystemUtil.getScreenWidth(getContext()) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px));
        customerAppCompatTextView.setSingleLine();
        customerAppCompatTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_1_a100));
        customerAppCompatTextView.setBackground(getResources().getDrawable(R.drawable.customer_evaluate_detail_merchant_reply_bg));
        customerAppCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        customerAppCompatTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
        int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.customer_24px);
        customerAppCompatTextView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(customerAppCompatTextView, IToolsService.FontType.MEDIUM);
        return customerAppCompatTextView;
    }

    /* renamed from: a */
    private final ImageView m34115a(String str, int i) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        ImageView imageView = new ImageView(getContext());
        int a = m34114a();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20);
        }
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* renamed from: a */
    private final int m34114a() {
        return ((CustomerSystemUtil.getScreenWidth(getContext()) - (DisplayUtils.dip2px(getContext(), 20.0f) * 2)) - (ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20) * 4)) / 5;
    }

    /* renamed from: c */
    private final void m34128c(String str) {
        CharSequence charSequence = str;
        RFTextView rFTextView = null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            RFTextView rFTextView2 = this.f45970l;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
                rFTextView2 = null;
            }
            rFTextView2.setVisibility(0);
            RFTextView rFTextView3 = this.f45970l;
            if (rFTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
            } else {
                rFTextView = rFTextView3;
            }
            rFTextView.setText(charSequence);
            return;
        }
        RFTextView rFTextView4 = this.f45970l;
        if (rFTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
        } else {
            rFTextView = rFTextView4;
        }
        rFTextView.setVisibility(8);
    }

    /* renamed from: b */
    private final void m34125b() {
        LinearLayout linearLayout = this.f45971m;
        View view = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
            linearLayout = null;
        }
        if (linearLayout.getVisibility() == 8) {
            RFTextView rFTextView = this.f45970l;
            if (rFTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
                rFTextView = null;
            }
            if (rFTextView.getVisibility() == 8) {
                View view2 = this.f45969k;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessDivider");
                } else {
                    view = view2;
                }
                view.setVisibility(8);
                return;
            }
        }
        View view3 = this.f45969k;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessDivider");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    /* renamed from: d */
    private final void m34129d(String str) {
        CharSequence charSequence = str;
        RFTextView rFTextView = null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            RFTextView rFTextView2 = this.f45977s;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryDescTv");
                rFTextView2 = null;
            }
            rFTextView2.setVisibility(0);
            RFTextView rFTextView3 = this.f45977s;
            if (rFTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryDescTv");
            } else {
                rFTextView = rFTextView3;
            }
            rFTextView.setText(charSequence);
            return;
        }
        RFTextView rFTextView4 = this.f45977s;
        if (rFTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryDescTv");
        } else {
            rFTextView = rFTextView4;
        }
        rFTextView.setVisibility(8);
    }

    /* renamed from: b */
    private final void m34126b(int i, String str) {
        View view = null;
        if (i >= 100) {
            View view2 = this.f45978t;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceLayout");
            } else {
                view = view2;
            }
            view.setVisibility(8);
        } else if (i != 0) {
            if (i == 2) {
                RFIconView rFIconView = this.f45979u;
                if (rFIconView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView = null;
                }
                rFIconView.setVisibility(0);
                RFIconView rFIconView2 = this.f45979u;
                if (rFIconView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView2 = null;
                }
                rFIconView2.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
                RFIconView rFIconView3 = this.f45979u;
                if (rFIconView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView3 = null;
                }
                rFIconView3.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
                RFTextView rFTextView = this.f45980v;
                if (rFTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView = null;
                }
                rFTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
            } else if (i != 10) {
                RFIconView rFIconView4 = this.f45979u;
                if (rFIconView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView4 = null;
                }
                rFIconView4.setVisibility(8);
            } else {
                RFIconView rFIconView5 = this.f45979u;
                if (rFIconView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView5 = null;
                }
                rFIconView5.setVisibility(0);
                RFIconView rFIconView6 = this.f45979u;
                if (rFIconView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView6 = null;
                }
                rFIconView6.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
                RFIconView rFIconView7 = this.f45979u;
                if (rFIconView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView7 = null;
                }
                rFIconView7.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
                RFTextView rFTextView2 = this.f45980v;
                if (rFTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView2 = null;
                }
                rFTextView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
            }
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence)) {
                RFTextView rFTextView3 = this.f45980v;
                if (rFTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView3 = null;
                }
                rFTextView3.setText(charSequence);
                RFTextView rFTextView4 = this.f45980v;
                if (rFTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView4 = null;
                }
                rFTextView4.setVisibility(0);
            } else {
                RFTextView rFTextView5 = this.f45980v;
                if (rFTextView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView5 = null;
                }
                rFTextView5.setVisibility(8);
            }
            RFIconView rFIconView8 = this.f45979u;
            if (rFIconView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                rFIconView8 = null;
            }
            if (rFIconView8.getVisibility() == 8) {
                RFTextView rFTextView6 = this.f45980v;
                if (rFTextView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView6 = null;
                }
                if (rFTextView6.getVisibility() == 8) {
                    View view3 = this.f45978t;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("faceLayout");
                    } else {
                        view = view3;
                    }
                    view.setVisibility(8);
                    return;
                }
            }
            View view4 = this.f45978t;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceLayout");
            } else {
                view = view4;
            }
            view.setVisibility(0);
        }
    }

    /* JADX WARNING: type inference failed for: r6v4, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m34130e(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0 = 0
            if (r6 == 0) goto L_0x000e
            int r1 = r6.length()
            if (r1 != 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r1 = 0
            goto L_0x000f
        L_0x000e:
            r1 = 1
        L_0x000f:
            java.lang.String r2 = "riderDivider"
            java.lang.String r3 = "riderCommentTv"
            r4 = 0
            if (r1 != 0) goto L_0x0039
            com.didi.rfusion.widget.RFTextView r1 = r5.f45983y
            if (r1 != 0) goto L_0x001e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r4
        L_0x001e:
            r1.setVisibility(r0)
            android.view.View r1 = r5.f45982x
            if (r1 != 0) goto L_0x0029
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x0029:
            r1.setVisibility(r0)
            com.didi.rfusion.widget.RFTextView r0 = r5.f45983y
            if (r0 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0035
        L_0x0034:
            r4 = r0
        L_0x0035:
            r4.setText(r6)
            goto L_0x0052
        L_0x0039:
            com.didi.rfusion.widget.RFTextView r6 = r5.f45983y
            if (r6 != 0) goto L_0x0041
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r6 = r4
        L_0x0041:
            r0 = 8
            r6.setVisibility(r0)
            android.view.View r6 = r5.f45982x
            if (r6 != 0) goto L_0x004e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x004f
        L_0x004e:
            r4 = r6
        L_0x004f:
            r4.setVisibility(r0)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.order.component.evaluatedetail.OrderEvaluateDetailView.m34130e(java.lang.String):void");
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/order/component/evaluatedetail/OrderEvaluateDetailView$Companion;", "", "()V", "GOOD_STAR_COUNT", "", "MAX_PHOTO_COUNT", "MAX_STAR_COUNT", "PHOTO_MARGIN", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderEvaluateDetailView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
