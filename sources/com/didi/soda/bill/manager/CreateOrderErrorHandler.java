package com.didi.soda.bill.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.dialog.SeriesDialogHelper;
import com.didi.soda.bill.dialog.entity.CommonConfirmationDialogEntity;
import com.didi.soda.bill.manager.CreateOrderState;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import com.didi.soda.customer.foundation.rpc.entity.DebtInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RiskControlEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.order.flutterpage.OrderPage;
import com.didi.soda.pay.ValidateCardHelper;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import p218io.flutter.embedding.android.BaseNachoSkeletonPage;
import p218io.flutter.embedding.android.registry.NFlutterContainerRegistry;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006 "}, mo148868d2 = {"Lcom/didi/soda/bill/manager/CreateOrderErrorHandler;", "", "()V", "dispatcher", "Lcom/didi/soda/bill/manager/CreateOrderDispatcher;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "dealRiskControl", "", "risk", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/RiskControlEntity;", "cid", "", "goOrderPage", "orderId", "isPaying", "", "gotoEditPage", "msg", "handle", "state", "Lcom/didi/soda/bill/manager/CreateOrderState;", "quitBill", "error", "", "recoverBill", "sceneType", "sceneParam", "Lcom/didi/soda/customer/foundation/rpc/entity/SceneParamsEntity;", "updateBill", "updateBusinessAndCart", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CreateOrderErrorHandler.kt */
public final class CreateOrderErrorHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CreateOrderErrorHandler";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ScopeContext f41722a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CreateOrderDispatcher f41723b;

    public /* synthetic */ CreateOrderErrorHandler(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31369a(RFDialog rFDialog) {
    }

    private CreateOrderErrorHandler() {
    }

    public final void handle(CreateOrderState createOrderState, ScopeContext scopeContext) {
        DebtInfoEntity debtInfoEntity;
        T t;
        T confirm;
        DebtInfoEntity debtInfoEntity2;
        Intrinsics.checkNotNullParameter(createOrderState, "state");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        CreateOrderState.OrderErrorState errorState = createOrderState.getErrorState();
        if (errorState != null) {
            LogUtil.m32588i(TAG, Intrinsics.stringPlus("handle -> errorType: ", Integer.valueOf(errorState.getMErrorType())));
            int mErrorType = errorState.getMErrorType();
            if (mErrorType != 65536) {
                T t2 = null;
                T t3 = "";
                switch (mErrorType) {
                    case 0:
                        DialogUtil.showErrorDialog(errorState.getMErrorMessage(), scopeContext, new RFDialogInterface.OnClickListener() {
                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31389c(CreateOrderErrorHandler.this, rFDialog);
                            }
                        });
                        return;
                    case 1:
                        DialogUtil.showErrorDialog(errorState.getMErrorMessage(), scopeContext, $$Lambda$CreateOrderErrorHandler$d_Zluzc4Hg8AfWnPpEgry0Org.INSTANCE);
                        return;
                    case 2:
                    case 10:
                        DialogUtil.showErrorDialog(errorState.getMErrorMessage(), scopeContext, new RFDialogInterface.OnClickListener(mErrorType) {
                            public final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31370a(CreateOrderErrorHandler.this, this.f$1, rFDialog);
                            }
                        });
                        return;
                    case 3:
                        DialogUtil.showWarningDialog(errorState.getMErrorMessage(), R.string.customer_dialog_cancel, R.string.customer_dialog_continue_create_order, scopeContext, new RFDialogInterface.OnClickListener() {
                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31372a(CreateOrderErrorHandler.this, rFDialog);
                            }
                        }, new RFDialogInterface.OnClickListener() {
                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31387b(CreateOrderErrorHandler.this, rFDialog);
                            }
                        });
                        return;
                    case 4:
                        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = t3;
                        String mErrorMessage = errorState.getMErrorMessage();
                        OrderInfoEntity order = createOrderState.getOrder();
                        if (!(order == null || (debtInfoEntity = order.debtInfo) == null || (t = debtInfoEntity.orderId) == null)) {
                            booleanRef.element = true;
                            objectRef.element = t;
                        }
                        DialogUtil.showNotPayDialog(scopeContext, mErrorMessage, booleanRef.element, new RFDialogInterface.OnClickListener(booleanRef, objectRef, this, createOrderState) {
                            public final /* synthetic */ Ref.BooleanRef f$1;
                            public final /* synthetic */ Ref.ObjectRef f$2;
                            public final /* synthetic */ CreateOrderErrorHandler f$3;
                            public final /* synthetic */ CreateOrderState f$4;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                            }

                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31382a(Ref.BooleanRef.this, this.f$1, this.f$2, this.f$3, this.f$4, rFDialog);
                            }
                        }, new RFDialogInterface.OnClickListener(objectRef, this) {
                            public final /* synthetic */ Ref.ObjectRef f$1;
                            public final /* synthetic */ CreateOrderErrorHandler f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31383a(Ref.BooleanRef.this, this.f$1, this.f$2, rFDialog);
                            }
                        });
                        return;
                    case 5:
                        PayChannelEntity payChannelEntity = createOrderState.getPayChannelEntity();
                        if (payChannelEntity != null) {
                            if (CustomerApolloUtil.isValidateCardEnable()) {
                                ValidateCardHelper.Companion.validateCardV2(payChannelEntity.cardSuffix, payChannelEntity.cardIndex, new CreateOrderErrorHandler$handle$1$9$1(this), new CreateOrderErrorHandler$handle$1$9$2(this));
                                return;
                            } else {
                                ValidateCardHelper.Companion.validateCard(payChannelEntity.cardSuffix, payChannelEntity.cardIndex, 102);
                                return;
                            }
                        } else {
                            return;
                        }
                    case 6:
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = t3;
                        OrderInfoEntity order2 = createOrderState.getOrder();
                        if (order2 != null) {
                            T t4 = order2.progressingOrderId;
                            if (t4 != null) {
                                t3 = t4;
                            }
                            objectRef2.element = t3;
                        }
                        DialogUtil.showDuplicateOrderDialog(scopeContext, new RFDialogInterface.OnClickListener(this, scopeContext) {
                            public final /* synthetic */ CreateOrderErrorHandler f$1;
                            public final /* synthetic */ ScopeContext f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31384a(Ref.ObjectRef.this, this.f$1, this.f$2, rFDialog);
                            }
                        });
                        return;
                    case 7:
                        DialogUtil.showErrorDialog(errorState.getMErrorMessage(), scopeContext);
                        return;
                    case 8:
                        SeriesDialogHelper.showSeriesDialog(errorState.getMDialogEntity(), scopeContext, GlobalContext.getContext(), new View.OnClickListener() {
                            public final void onClick(View view) {
                                CreateOrderErrorHandler.m31371a(CreateOrderErrorHandler.this, view);
                            }
                        });
                        return;
                    case 9:
                        m31377a(errorState.getMRisk(), createOrderState.getCartId());
                        return;
                    case 11:
                        CommonConfirmationDialogEntity mDialogEntity = errorState.getMDialogEntity();
                        if (mDialogEntity != null && (confirm = mDialogEntity.getConfirm()) != null) {
                            CharSequence charSequence = confirm.msg;
                            if (true ^ (charSequence == null || charSequence.length() == 0)) {
                                t2 = confirm;
                            }
                            if (t2 != null) {
                                BillOmegaHelper.Companion.tracePreMatchBlockSW(errorState.getMErrorMessage(), LoginUtil.getUid(), createOrderState.getShopId(), createOrderState.getCartId());
                                DialogUtil.showNoCapacityConfirm(scopeContext.getNavigator(), t2, new RFDialogInterface.OnClickListener(createOrderState) {
                                    public final /* synthetic */ CreateOrderState f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final void onClick(RFDialog rFDialog) {
                                        CreateOrderErrorHandler.m31373a(CreateOrderErrorHandler.this, this.f$1, rFDialog);
                                    }
                                }, new RFDialogInterface.OnClickListener(createOrderState) {
                                    public final /* synthetic */ CreateOrderState f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final void onClick(RFDialog rFDialog) {
                                        CreateOrderErrorHandler.m31368a(ScopeContext.this, this.f$1, rFDialog);
                                    }
                                }, new RFDialogInterface.OnClickListener() {
                                    public final void onClick(RFDialog rFDialog) {
                                        CreateOrderErrorHandler.m31375a(CreateOrderState.this, rFDialog);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        return;
                    case 12:
                        DialogUtil.showErrorDialog(errorState.getMErrorMessage(), scopeContext, new RFDialogInterface.OnClickListener() {
                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31391e(CreateOrderErrorHandler.this, rFDialog);
                            }
                        });
                        return;
                    case 13:
                        DialogUtil.showOrderCreateConnectError(scopeContext, new RFDialogInterface.OnClickListener(createOrderState) {
                            public final /* synthetic */ CreateOrderState f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31388b(CreateOrderErrorHandler.this, this.f$1, rFDialog);
                            }
                        }, new RFDialogInterface.OnClickListener() {
                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31390d(CreateOrderErrorHandler.this, rFDialog);
                            }
                        });
                        return;
                    case 14:
                        if (41025 == errorState.getMErrorCode()) {
                            OrderInfoEntity order3 = createOrderState.getOrder();
                            if (!(order3 == null || (debtInfoEntity2 = order3.debtInfo) == null)) {
                                t2 = debtInfoEntity2.orderId;
                            }
                            if (t2 != null) {
                                t3 = t2;
                            }
                            BillOmegaHelper.Companion.trackArrearsOrderInterceptSw(t3);
                        }
                        SceneParamsEntity sceneParamsEntity = new SceneParamsEntity();
                        sceneParamsEntity.setCode(errorState.getMErrorCode());
                        m31367a(100, sceneParamsEntity);
                        return;
                    case 15:
                        T mErrorMessage2 = errorState.getMErrorMessage();
                        if (mErrorMessage2 != null) {
                            t3 = mErrorMessage2;
                        }
                        m31379a((String) t3);
                        return;
                    default:
                        DialogUtil.showErrorDialog(errorState.getMErrorMessage(), scopeContext, new RFDialogInterface.OnClickListener() {
                            public final void onClick(RFDialog rFDialog) {
                                CreateOrderErrorHandler.m31392f(CreateOrderErrorHandler.this, rFDialog);
                            }
                        });
                        return;
                }
            } else {
                ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(GlobalContext.getContext(), ApiErrorConst.LogoutReasons.getSignReasonByErrorCode(errorState.getMErrorCode()));
                LoginUtil.trackLogOut(errorState.getMErrorCode());
                DialogUtil.showErrorDialog(errorState.getMErrorMessage(), R.string.customer_dialog_go_login, scopeContext, $$Lambda$CreateOrderErrorHandler$950fCKIQWEyl3WZ81e3bjcAGAbI.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31370a(CreateOrderErrorHandler createOrderErrorHandler, int i, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.m31366a(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31372a(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.m31365a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31387b(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        CreateOrderDispatcher createOrderDispatcher = createOrderErrorHandler.f41723b;
        if (createOrderDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            createOrderDispatcher = null;
        }
        createOrderDispatcher.dispatch(CreateOrderDispatcher.Companion.createOrderEtaConfirm());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31386b(RFDialog rFDialog) {
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 12);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        r0 = r0.debtInfo;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m31382a(kotlin.jvm.internal.Ref.BooleanRef r0, kotlin.jvm.internal.Ref.BooleanRef r1, kotlin.jvm.internal.Ref.ObjectRef r2, com.didi.soda.bill.manager.CreateOrderErrorHandler r3, com.didi.soda.bill.manager.CreateOrderState r4, com.didi.rfusion.widget.dialog.RFDialog r5) {
        /*
            java.lang.String r5 = "$isArrearsOrder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            java.lang.String r5 = "$guideUsersRepay"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "$arrearsOrderId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "$state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            boolean r0 = r0.element
            if (r0 == 0) goto L_0x0050
            boolean r0 = r1.element
            if (r0 == 0) goto L_0x0046
            com.didi.soda.bill.BillOmegaHelper$Companion r0 = com.didi.soda.bill.BillOmegaHelper.Companion
            T r1 = r2.element
            java.lang.String r1 = (java.lang.String) r1
            r2 = 1
            r0.trackArrearsOrderInterceptCk(r1, r2)
            com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity r0 = r4.getOrder()
            r1 = 0
            if (r0 != 0) goto L_0x0035
        L_0x0033:
            r0 = r1
            goto L_0x003c
        L_0x0035:
            com.didi.soda.customer.foundation.rpc.entity.DebtInfoEntity r0 = r0.debtInfo
            if (r0 != 0) goto L_0x003a
            goto L_0x0033
        L_0x003a:
            java.lang.String r0 = r0.orderId
        L_0x003c:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2 = 0
            r4 = 2
            m31374a(r3, r0, r2, r4, r1)
            return
        L_0x0046:
            com.didi.soda.bill.BillOmegaHelper$Companion r0 = com.didi.soda.bill.BillOmegaHelper.Companion
            T r1 = r2.element
            java.lang.String r1 = (java.lang.String) r1
            r2 = 3
            r0.trackArrearsOrderInterceptCk(r1, r2)
        L_0x0050:
            java.lang.Class<com.didi.soda.customer.foundation.storage.ServerConfigStorage> r0 = com.didi.soda.customer.foundation.storage.ServerConfigStorage.class
            java.lang.Object r0 = com.didi.soda.customer.foundation.util.SingletonFactory.get(r0)
            com.didi.soda.customer.foundation.storage.ServerConfigStorage r0 = (com.didi.soda.customer.foundation.storage.ServerConfigStorage) r0
            com.didi.soda.customer.foundation.rpc.entity.ServerConfigEntity r0 = r0.getData()
            java.lang.String r0 = r0.servicePhone
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006e
            android.content.Context r1 = com.didi.soda.customer.app.GlobalContext.getContext()
            com.didi.soda.customer.foundation.util.CustomerSystemUtil.doCall(r1, r0)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.manager.CreateOrderErrorHandler.m31382a(kotlin.jvm.internal.Ref$BooleanRef, kotlin.jvm.internal.Ref$BooleanRef, kotlin.jvm.internal.Ref$ObjectRef, com.didi.soda.bill.manager.CreateOrderErrorHandler, com.didi.soda.bill.manager.CreateOrderState, com.didi.rfusion.widget.dialog.RFDialog):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31383a(Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(booleanRef, "$isArrearsOrder");
        Intrinsics.checkNotNullParameter(objectRef, "$arrearsOrderId");
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        if (booleanRef.element) {
            BillOmegaHelper.Companion.trackArrearsOrderInterceptCk((String) objectRef.element, 2);
        }
        createOrderErrorHandler.m31365a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31384a(Ref.ObjectRef objectRef, CreateOrderErrorHandler createOrderErrorHandler, ScopeContext scopeContext, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(objectRef, "$existingOrderId");
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        Intrinsics.checkNotNullParameter(scopeContext, "$scopeContext");
        if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
            createOrderErrorHandler.m31381a((String) objectRef.element, true);
            BillOmegaHelper.Companion.clickDuplicateOrder((String) objectRef.element, 1);
            return;
        }
        scopeContext.getNavigator().popToRoot();
        BillOmegaHelper.Companion.clickDuplicateOrder("", 3);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31371a(CreateOrderErrorHandler createOrderErrorHandler, View view) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        CreateOrderDispatcher createOrderDispatcher = createOrderErrorHandler.f41723b;
        if (createOrderDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            createOrderDispatcher = null;
        }
        createOrderDispatcher.dispatch(CreateOrderDispatcher.Companion.createOrderMinorConfirm());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31373a(CreateOrderErrorHandler createOrderErrorHandler, CreateOrderState createOrderState, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        Intrinsics.checkNotNullParameter(createOrderState, "$state");
        CreateOrderDispatcher createOrderDispatcher = createOrderErrorHandler.f41723b;
        if (createOrderDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            createOrderDispatcher = null;
        }
        createOrderDispatcher.dispatch(CreateOrderDispatcher.Companion.createOrderLackRider(createOrderState));
        BillOmegaHelper.Companion.tracePreMatchBlockCK(1, LoginUtil.getUid(), createOrderState.getShopId(), createOrderState.getCartId());
        rFDialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31368a(ScopeContext scopeContext, CreateOrderState createOrderState, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(scopeContext, "$scopeContext");
        Intrinsics.checkNotNullParameter(createOrderState, "$state");
        scopeContext.getNavigator().popToRoot();
        BillOmegaHelper.Companion.tracePreMatchBlockCK(2, LoginUtil.getUid(), createOrderState.getShopId(), createOrderState.getCartId());
        rFDialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31375a(CreateOrderState createOrderState, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderState, "$state");
        BillOmegaHelper.Companion.tracePreMatchBlockCK(3, LoginUtil.getUid(), createOrderState.getShopId(), createOrderState.getCartId());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m31389c(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.m31365a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31388b(CreateOrderErrorHandler createOrderErrorHandler, CreateOrderState createOrderState, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        Intrinsics.checkNotNullParameter(createOrderState, "$state");
        CreateOrderDispatcher createOrderDispatcher = createOrderErrorHandler.f41723b;
        if (createOrderDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            createOrderDispatcher = null;
        }
        createOrderDispatcher.dispatch(CreateOrderDispatcher.Companion.createOrder(createOrderState));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m31390d(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.m31365a();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m31391e(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.m31365a();
        createOrderErrorHandler.m31385b();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static final void m31392f(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.m31365a();
    }

    /* renamed from: a */
    static /* synthetic */ void m31374a(CreateOrderErrorHandler createOrderErrorHandler, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        createOrderErrorHandler.m31381a(str, z);
    }

    /* renamed from: a */
    private final void m31381a(String str, boolean z) {
        Map<String, WeakReference<BaseNachoSkeletonPage>> pageRegistry = NFlutterContainerRegistry.getPageRegistry();
        if (pageRegistry != null) {
            for (Map.Entry next : pageRegistry.entrySet()) {
                if (((WeakReference) next.getValue()).get() instanceof OrderPage) {
                    Object obj = ((WeakReference) next.getValue()).get();
                    if (obj != null) {
                        ((OrderPage) obj).hideOrderContainer();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.order.flutterpage.OrderPage");
                    }
                }
            }
        }
        DiRouter.request().path("orderPage").putString("orderid", str).putString("path", "/order_page").putInt("from", 2).putBoolean("orderpaying", z).open();
    }

    /* renamed from: a */
    private final void m31366a(int i) {
        ScopeContext scopeContext = this.f41722a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        Object object = scopeContext.getObject("bill_pay_callback");
        if (object != null) {
            ((ICustomerPayManager.BillPayCallback) object).quitBill(i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.BillPayCallback");
    }

    /* renamed from: a */
    private final void m31365a() {
        ScopeContext scopeContext = this.f41722a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        Object object = scopeContext.getObject("bill_pay_callback");
        if (object != null) {
            ((ICustomerPayManager.BillPayCallback) object).refreshBill();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.BillPayCallback");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31367a(int i, SceneParamsEntity sceneParamsEntity) {
        ScopeContext scopeContext = this.f41722a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        Object object = scopeContext.getObject("bill_pay_callback");
        if (object != null) {
            ICustomerPayManager.BillPayCallback.DefaultImpls.recoverBill$default((ICustomerPayManager.BillPayCallback) object, (String) null, i, sceneParamsEntity, 1, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.BillPayCallback");
    }

    /* renamed from: a */
    private final void m31379a(String str) {
        ScopeContext scopeContext = this.f41722a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        Object object = scopeContext.getObject("bill_pay_callback");
        if (object != null) {
            ((ICustomerPayManager.BillPayCallback) object).gotoEditPage(str);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.BillPayCallback");
    }

    /* renamed from: b */
    private final void m31385b() {
        ScopeContext scopeContext = this.f41722a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        Object object = scopeContext.getObject("bill_pay_callback");
        if (object != null) {
            ((ICustomerPayManager.BillPayCallback) object).updateBusinessAndCart();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.BillPayCallback");
    }

    /* renamed from: a */
    private final void m31377a(RiskControlEntity riskControlEntity, String str) {
        Integer num;
        Object obj;
        boolean z;
        if (riskControlEntity != null) {
            int i = riskControlEntity.riskCode;
            ScopeContext scopeContext = null;
            if (i == 10003 || i == 100008) {
                BillOmegaHelper.Companion.showSecurityCheck(str);
                ScopeContext scopeContext2 = this.f41722a;
                if (scopeContext2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
                } else {
                    scopeContext = scopeContext2;
                }
                DialogUtil.showVerifyErrorDialog(scopeContext, new RFDialogInterface.OnClickListener(str) {
                    public final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(RFDialog rFDialog) {
                        CreateOrderErrorHandler.m31378a(RiskControlEntity.this, this.f$1, rFDialog);
                    }
                }, new RFDialogInterface.OnClickListener(str) {
                    public final /* synthetic */ String f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onClick(RFDialog rFDialog) {
                        CreateOrderErrorHandler.m31380a(this.f$0, rFDialog);
                    }
                });
                return;
            }
            if (riskControlEntity.riskCode == 100007) {
                List<Integer> list = riskControlEntity.subCodeList;
                if (list == null) {
                    num = null;
                } else {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        Integer num2 = (Integer) obj;
                        if (num2 != null && num2.intValue() == 41069) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                    num = (Integer) obj;
                }
                if (num != null) {
                    String str2 = riskControlEntity.frontMsg;
                    ScopeContext scopeContext3 = this.f41722a;
                    if (scopeContext3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
                    } else {
                        scopeContext = scopeContext3;
                    }
                    DialogUtil.showErrorDialog(str2, R.string.FoodC_sale_OK_NWns, scopeContext, new RFDialogInterface.OnClickListener() {
                        public final void onClick(RFDialog rFDialog) {
                            CreateOrderErrorHandler.m31393g(CreateOrderErrorHandler.this, rFDialog);
                        }
                    });
                    return;
                }
            }
            String str3 = riskControlEntity.frontMsg;
            ScopeContext scopeContext4 = this.f41722a;
            if (scopeContext4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            } else {
                scopeContext = scopeContext4;
            }
            DialogUtil.showErrorDialog(str3, scopeContext, new RFDialogInterface.OnClickListener(this) {
                public final /* synthetic */ CreateOrderErrorHandler f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(RFDialog rFDialog) {
                    CreateOrderErrorHandler.m31376a(RiskControlEntity.this, this.f$1, rFDialog);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31378a(RiskControlEntity riskControlEntity, String str, RFDialog rFDialog) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (riskControlEntity.subCodeList != null) {
            arrayList.addAll(riskControlEntity.subCodeList);
        }
        bundle.putIntegerArrayList("securitylist", arrayList);
        DiRouter.request().path("securityPage").putString("cart_id", str).putBundle("bundle", bundle).open();
        BillOmegaHelper.Companion.clickSecurityCheck(2, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31380a(String str, RFDialog rFDialog) {
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            str = "";
        }
        companion.clickSecurityCheck(1, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static final void m31393g(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        ScopeContext scopeContext = createOrderErrorHandler.f41722a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        scopeContext.getNavigator().finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31376a(RiskControlEntity riskControlEntity, CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        ScopeContext scopeContext;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        if (riskControlEntity.riskCode == 100007) {
            List<Integer> list = riskControlEntity.subCodeList;
            Intrinsics.checkNotNullExpressionValue(list, "risk.subCodeList");
            Iterator it = list.iterator();
            while (true) {
                scopeContext = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer num = (Integer) obj;
                if (num != null && num.intValue() == 41067) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (((Integer) obj) != null) {
                ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).activityInvalidedRefreshHome();
                ScopeContext scopeContext2 = createOrderErrorHandler.f41722a;
                if (scopeContext2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
                } else {
                    scopeContext = scopeContext2;
                }
                scopeContext.getNavigator().popToRoot();
            }
        }
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/soda/bill/manager/CreateOrderErrorHandler$Companion;", "", "()V", "TAG", "", "assemble", "Lcom/didi/soda/bill/manager/CreateOrderErrorHandler;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "dispatcher", "Lcom/didi/soda/bill/manager/CreateOrderDispatcher;", "classifyError", "Lcom/didi/soda/bill/manager/CreateOrderState$OrderErrorState;", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CreateOrderErrorHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOrderErrorHandler assemble(ScopeContext scopeContext, CreateOrderDispatcher createOrderDispatcher) {
            Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
            Intrinsics.checkNotNullParameter(createOrderDispatcher, "dispatcher");
            CreateOrderErrorHandler createOrderErrorHandler = new CreateOrderErrorHandler((DefaultConstructorMarker) null);
            createOrderErrorHandler.f41722a = scopeContext;
            createOrderErrorHandler.f41723b = createOrderDispatcher;
            return createOrderErrorHandler;
        }

        public final CreateOrderState.OrderErrorState classifyError(SFRpcException sFRpcException) {
            if (sFRpcException == null) {
                return null;
            }
            CreateOrderState.OrderErrorState orderErrorState = new CreateOrderState.OrderErrorState();
            orderErrorState.setMErrorCode(sFRpcException.getCode());
            orderErrorState.setMErrorMessage(sFRpcException.getMessage());
            if (orderErrorState.getMErrorCode() == -1 && !NetWorkUtils.isNetworkConnected(GlobalContext.getContext())) {
                orderErrorState.setMErrorMessage(ResourceHelper.getString(R.string.customer_net_error_tip_subtitle));
            }
            switch (sFRpcException.getCode()) {
                case -1:
                    orderErrorState.setMErrorType(13);
                    break;
                case 40115:
                case 41033:
                case 41036:
                case 41040:
                case 41045:
                    orderErrorState.setMErrorType(1);
                    break;
                case 41010:
                case 41013:
                case 41020:
                case 41034:
                case 41038:
                case 41039:
                case 41043:
                case ApiErrorConst.Code.CREATE_ORDER_LIMIT /*41090*/:
                case ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR /*44100*/:
                    orderErrorState.setMErrorType(0);
                    break;
                case 41025:
                case 41054:
                case ApiErrorConst.Code.CREATE_ORDER_MONEY_LOWER_THAN_PAY_CHANNEL /*41094*/:
                    orderErrorState.setMErrorType(14);
                    break;
                case 41035:
                case 41042:
                    orderErrorState.setMErrorType(3);
                    break;
                case 41046:
                case 41047:
                    if (sFRpcException.getResult().getData() instanceof OrderInfoEntity) {
                        Object data = sFRpcException.getResult().getData();
                        if (data != null) {
                            orderErrorState.setMDialogEntity(((OrderInfoEntity) data).adultConfirmation);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity");
                        }
                    }
                    orderErrorState.setMErrorType(8);
                    break;
                case 41049:
                    orderErrorState.setMErrorType(10);
                    break;
                case 41051:
                case 41053:
                case 41055:
                case 41060:
                case 41067:
                case 41069:
                    if (sFRpcException.getResult().getData() instanceof OrderInfoEntity) {
                        Object data2 = sFRpcException.getResult().getData();
                        if (data2 != null) {
                            orderErrorState.setMRisk(((OrderInfoEntity) data2).riskControl);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity");
                        }
                    }
                    orderErrorState.setMErrorType(9);
                    break;
                case 41063:
                    orderErrorState.setMErrorType(5);
                    break;
                case 41068:
                    orderErrorState.setMErrorType(12);
                    break;
                case 41072:
                    orderErrorState.setMErrorType(2);
                    break;
                case 41091:
                    orderErrorState.setMErrorType(4);
                    break;
                case ApiErrorConst.Code.CREATE_NO_CAPACITY_CONFIRM /*41093*/:
                    Object data3 = sFRpcException.getResult().getData();
                    if (data3 instanceof OrderInfoEntity) {
                        orderErrorState.setMDialogEntity(((OrderInfoEntity) data3).noCapacityConfirm);
                    }
                    orderErrorState.setMErrorType(11);
                    break;
                case ApiErrorConst.Code.EDIT_ADDRESS_NAME_ERROR /*42424*/:
                    orderErrorState.setMErrorType(15);
                    break;
                case 46900:
                    orderErrorState.setMErrorType(6);
                    break;
                case 47101:
                    orderErrorState.setMErrorType(7);
                    break;
                case 50001:
                case 50002:
                case 50004:
                    orderErrorState.setMErrorType(65536);
                    break;
                default:
                    orderErrorState.setMErrorType(0);
                    break;
            }
            return orderErrorState;
        }
    }
}
