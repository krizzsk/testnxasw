package com.didi.soda.customer.blocks.widget.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.style.BlockLayout;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.manager.HomeFeedbackConfigHelper;
import com.didi.soda.home.topgun.model.HomeFeedbackButtonModel;
import com.didi.soda.home.topgun.model.HomeFeedbackModel;
import com.didi.soda.home.topgun.widget.HomeFeedbackGridLayout;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@WidgetNameMeta(widgetName = "FeedbackView")
@Metadata(mo148867d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J0\u0010\u000f\u001a\u00020\u00102&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002Jt\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00132\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2F\u0010$\u001aB\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110(¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"\u0012\u0004\u0012\u00020\u00100%H\u0016J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u001dH\u0002J0\u0010,\u001a\u00020\u001d2&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/widget/binder/FeedBackBinder;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clickTrack", "Lcom/didi/soda/customer/blocks/widget/binder/TrackBean;", "mFeedBackClose", "Landroid/view/View;", "mFeedBackContainer", "mFeedBackGridLayout", "Lcom/didi/soda/home/topgun/widget/HomeFeedbackGridLayout;", "mFeedBackIcon", "showTrack", "bindProps", "", "props", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "createView", "findRootCardLayout", "view", "handleFeedback", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "handleOtherTrigger", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "callBackType", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "setFeedbackLayoutVisibility", "visibility", "shouldShow", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FeedBackBinder.kt */
public final class FeedBackBinder extends BaseBinder<RelativeLayout> {

    /* renamed from: a */
    private View f43344a;

    /* renamed from: b */
    private HomeFeedbackGridLayout f43345b;

    /* renamed from: c */
    private View f43346c;

    /* renamed from: d */
    private View f43347d;

    /* renamed from: e */
    private C14481a f43348e;

    /* renamed from: f */
    private C14481a f43349f;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m32419b(View view) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackBinder(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public RelativeLayout createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_home_feedback_binder_layout, (ViewGroup) null);
        if (inflate != null) {
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            View findViewById = relativeLayout.findViewById(R.id.customer_business_feedback_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.c…iness_feedback_container)");
            this.f43344a = findViewById;
            View findViewById2 = relativeLayout.findViewById(R.id.customer_business_feedback_grid_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.c…ess_feedback_grid_layout)");
            this.f43345b = (HomeFeedbackGridLayout) findViewById2;
            View findViewById3 = relativeLayout.findViewById(R.id.customer_business_feedback_close);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.c…_business_feedback_close)");
            this.f43346c = findViewById3;
            View findViewById4 = relativeLayout.findViewById(R.id.customer_iv_home_business_feedback_img);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.c…me_business_feedback_img)");
            this.f43347d = findViewById4;
            return relativeLayout;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return HomeFeedbackConfigHelper.Companion.getInstance().isShowFeedBack();
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        super.bindProps(hashMap);
        m32417a(false);
        ((RelativeLayout) getView()).post(new Runnable() {
            public final void run() {
                FeedBackBinder.m32414a(FeedBackBinder.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32414a(FeedBackBinder feedBackBinder) {
        Intrinsics.checkNotNullParameter(feedBackBinder, "this$0");
        feedBackBinder.m32416a((HomeBusinessInfoRvModel) null);
    }

    /* renamed from: a */
    private final View m32413a(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        BlockLayout blockLayout = parent instanceof BlockLayout ? (BlockLayout) parent : null;
        if (!(blockLayout == null || blockLayout.getBlockNode() == null || blockLayout.getBlockNode().getId() == null)) {
            String id = blockLayout.getBlockNode().getId();
            Intrinsics.checkNotNull(id);
            if (StringsKt.contains$default((CharSequence) id, (CharSequence) "shopRootCard", false, 2, (Object) null)) {
                return blockLayout;
            }
        }
        return m32413a((View) blockLayout);
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(function3, "handler");
        if (Intrinsics.areEqual((Object) str, (Object) "OnFeedbackEntryClick")) {
            this.f43348e = new C14481a(this, iBlockScope, list, function3);
            return true;
        } else if (!Intrinsics.areEqual((Object) str, (Object) "OnFeedbackItemClick")) {
            return true;
        } else {
            this.f43349f = new C14481a(this, iBlockScope, list, function3);
            return true;
        }
    }

    /* renamed from: a */
    private final void m32416a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        HomeFeedbackModel homeFeedbackConfig = HomeFeedbackConfigHelper.Companion.getInstance().getHomeFeedbackConfig();
        if (HomeFeedbackConfigHelper.Companion.getInstance().isShowFeedBack()) {
            HomeFeedbackGridLayout homeFeedbackGridLayout = this.f43345b;
            HomeFeedbackGridLayout homeFeedbackGridLayout2 = null;
            if (homeFeedbackGridLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedBackGridLayout");
                homeFeedbackGridLayout = null;
            }
            homeFeedbackGridLayout.removeAllViews();
            View a = m32413a(getView());
            if (a != null) {
                a.setOnLongClickListener(new View.OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        return FeedBackBinder.m32418a(FeedBackBinder.this, view);
                    }
                });
            }
            View view = this.f43347d;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedBackIcon");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FeedBackBinder.m32420b(FeedBackBinder.this, view);
                }
            });
            View view2 = this.f43346c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedBackClose");
                view2 = null;
            }
            view2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FeedBackBinder.m32421c(FeedBackBinder.this, view);
                }
            });
            HomeFeedbackGridLayout homeFeedbackGridLayout3 = this.f43345b;
            if (homeFeedbackGridLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedBackGridLayout");
                homeFeedbackGridLayout3 = null;
            }
            homeFeedbackGridLayout3.setFeedbackItem(homeFeedbackConfig == null ? null : homeFeedbackConfig.getBtnList());
            HomeFeedbackGridLayout homeFeedbackGridLayout4 = this.f43345b;
            if (homeFeedbackGridLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedBackGridLayout");
            } else {
                homeFeedbackGridLayout2 = homeFeedbackGridLayout4;
            }
            homeFeedbackGridLayout2.setOnClickItemListener(new HomeFeedbackGridLayout.OnClickItemListener() {
                public final void onItemClick(HomeFeedbackButtonModel homeFeedbackButtonModel) {
                    FeedBackBinder.m32415a(FeedBackBinder.this, homeFeedbackButtonModel);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m32418a(FeedBackBinder feedBackBinder, View view) {
        Intrinsics.checkNotNullParameter(feedBackBinder, "this$0");
        C14481a aVar = feedBackBinder.f43348e;
        if (aVar != null) {
            aVar.mo109024e();
        }
        feedBackBinder.m32417a(true);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m32420b(FeedBackBinder feedBackBinder, View view) {
        Intrinsics.checkNotNullParameter(feedBackBinder, "this$0");
        C14481a aVar = feedBackBinder.f43348e;
        if (aVar != null) {
            aVar.mo109024e();
        }
        feedBackBinder.m32417a(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m32421c(FeedBackBinder feedBackBinder, View view) {
        Intrinsics.checkNotNullParameter(feedBackBinder, "this$0");
        feedBackBinder.m32417a(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32415a(FeedBackBinder feedBackBinder, HomeFeedbackButtonModel homeFeedbackButtonModel) {
        HashMap<String, Object> context;
        Intrinsics.checkNotNullParameter(feedBackBinder, "this$0");
        WidgetNodeModel virtualNode = feedBackBinder.getVirtualNode();
        if (!(virtualNode == null || (context = virtualNode.getContext()) == null)) {
            Integer issueNo = homeFeedbackButtonModel.getIssueNo();
            context.put("questionId", Integer.valueOf(issueNo == null ? 0 : issueNo.intValue()));
        }
        C14481a aVar = feedBackBinder.f43349f;
        if (aVar != null) {
            aVar.mo109024e();
        }
        feedBackBinder.m32417a(false);
        ToastUtil.showCustomerToast((ScopeContext) null, ResourceHelper.getString(R.string.FoodC_feedback_Your_feedback_FuwM));
    }

    /* JADX WARNING: type inference failed for: r6v14, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m32417a(boolean r6) {
        /*
            r5 = this;
            java.lang.String r0 = "mFeedBackGridLayout"
            java.lang.String r1 = "mFeedBackClose"
            java.lang.String r2 = "mFeedBackContainer"
            r3 = 0
            if (r6 == 0) goto L_0x003a
            android.view.View r6 = r5.f43344a
            if (r6 != 0) goto L_0x0011
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = r3
        L_0x0011:
            r4 = 0
            r6.setVisibility(r4)
            android.view.View r6 = r5.f43346c
            if (r6 != 0) goto L_0x001d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r6 = r3
        L_0x001d:
            r6.setVisibility(r4)
            com.didi.soda.home.topgun.widget.HomeFeedbackGridLayout r6 = r5.f43345b
            if (r6 != 0) goto L_0x0028
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r6 = r3
        L_0x0028:
            r6.setVisibility(r4)
            android.view.View r6 = r5.f43344a
            if (r6 != 0) goto L_0x0033
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0034
        L_0x0033:
            r3 = r6
        L_0x0034:
            com.didi.soda.customer.blocks.widget.binder.-$$Lambda$FeedBackBinder$A777zqv-XYJ_8luzGQVXd1kKOLY r6 = com.didi.soda.customer.blocks.widget.binder.$$Lambda$FeedBackBinder$A777zqvXYJ_8luzGQVXd1kKOLY.INSTANCE
            r3.setOnClickListener(r6)
            goto L_0x005e
        L_0x003a:
            android.view.View r6 = r5.f43344a
            if (r6 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = r3
        L_0x0042:
            r2 = 8
            r6.setVisibility(r2)
            android.view.View r6 = r5.f43346c
            if (r6 != 0) goto L_0x004f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r6 = r3
        L_0x004f:
            r6.setVisibility(r2)
            com.didi.soda.home.topgun.widget.HomeFeedbackGridLayout r6 = r5.f43345b
            if (r6 != 0) goto L_0x005a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x005b
        L_0x005a:
            r3 = r6
        L_0x005b:
            r3.setVisibility(r2)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.binder.FeedBackBinder.m32417a(boolean):void");
    }
}
