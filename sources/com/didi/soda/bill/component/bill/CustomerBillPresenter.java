package com.didi.soda.bill.component.bill;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.soda.bill.BillEventToJS;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.component.cpf.CPFCheckVisibleListener;
import com.didi.soda.bill.dialog.PayErrorGuideDialogHelper;
import com.didi.soda.bill.manager.CreateOrderManager;
import com.didi.soda.bill.manager.CreateOrderOmegaBuilder;
import com.didi.soda.bill.manager.CreateOrderState;
import com.didi.soda.bill.model.BillDataFactory;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.DisclaimerModel;
import com.didi.soda.bill.model.SectionModel;
import com.didi.soda.bill.model.datamodel.BillCartItemModel;
import com.didi.soda.bill.model.datamodel.BillItemsInfoModel;
import com.didi.soda.bill.model.datamodel.ReminderModel;
import com.didi.soda.bill.repo.BillMessageRepo;
import com.didi.soda.bill.repo.CartInfoConfirmRepo;
import com.didi.soda.bill.repo.CustomerContactRepo;
import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.compose.action.ComposeActionHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillCartItemsInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillRefreshEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillSection;
import com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CipherUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.globalcart.anim.TotalPriceManager;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.router.DiRouter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\u001cH\u0002J\b\u0010?\u001a\u00020\u001cH\u0002J\b\u0010@\u001a\u00020\u001cH\u0002J\b\u0010A\u001a\u00020\u001cH\u0002J\u001c\u0010B\u001a\u00020\u001c2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010D\u001a\u00020\tH\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\n2\u0006\u0010F\u001a\u00020\tH\u0002J\u0014\u0010G\u001a\u00020\u001c2\n\u0010F\u001a\u00020H\"\u00020\tH\u0002J\u0018\u0010I\u001a\u0004\u0018\u00010\u00062\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010&J\u0006\u0010L\u001a\u00020\tJ\b\u0010M\u001a\u0004\u0018\u00010\u0006J\b\u0010N\u001a\u00020\u001cH\u0002J\b\u0010O\u001a\u00020\u001cH\u0016J\b\u0010P\u001a\u00020\u001cH\u0002J\u0012\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010S\u001a\u00020\u001cH\u0016J\b\u0010T\u001a\u00020\u001cH\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020\u001cH\u0014J\b\u0010Y\u001a\u00020\u000eH\u0016J\b\u0010Z\u001a\u00020\u001cH\u0016J\u001a\u0010[\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020\tH\u0016J\u0010\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\tH\u0002J\"\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u00062\u0006\u0010V\u001a\u00020WH\u0002J\"\u0010d\u001a\u00020\u001c2\u0006\u0010e\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\t2\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0012\u0010h\u001a\u00020\u001c2\b\u0010i\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010j\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020!H\u0002J\u0010\u0010l\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020!H\u0002J\b\u0010m\u001a\u00020\u001cH\u0002J\u0010\u0010n\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020!H\u0002J\b\u0010o\u001a\u00020\u001cH\u0002J\u0010\u0010p\u001a\u00020\u001c2\u0006\u0010q\u001a\u00020\fH\u0016J\u0010\u0010r\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020!H\u0002J\u0012\u0010s\u001a\u00020\u001c2\b\u0010t\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010u\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010v2\b\u0010e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010w\u001a\u00020\u001c2\b\b\u0002\u0010C\u001a\u00020\u000eH\u0002J\u0012\u0010x\u001a\u00020\u001c2\b\u0010y\u001a\u0004\u0018\u00010vH\u0002J\"\u0010z\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u00062\u0006\u0010{\u001a\u00020WH\u0002J\u000e\u0010|\u001a\u00020\u001c2\u0006\u0010}\u001a\u00020\u000eJ<\u0010~\u001a\u00020\u001c2\b\u0010\u001a\u0004\u0018\u00010\u00062(\u0010\u0001\u001a#\u0012\u0018\u0012\u0016\u0018\u00010\u0006¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u001c0\u0001H\u0016J\t\u0010\u0001\u001a\u00020\u001cH\u0002J\u0011\u0010\u0001\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020!H\u0002Jh\u0010\u0001\u001a\u00020\u001c2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002¢\u0006\u0003\u0010\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000RI\u0010\u0018\u001a:\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b0\u001a0\u0019j\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b0\u001a`\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\"\u0010(\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020)\u0018\u0001`\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R:\u0010.\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000/\u0018\u00010\u0019j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000/\u0018\u0001`\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u00105\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020$\u0018\u0001`\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo148868d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsBillPresenter;", "()V", "actInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "cartId", "", "componentModelMap", "", "", "Lcom/didi/soda/bill/model/ComponentModel;", "cpfVisibleListener", "Lcom/didi/soda/bill/component/cpf/CPFCheckVisibleListener;", "createFromRecovery", "", "currTotalPrice", "disclaimerManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataItemManager;", "Lcom/didi/soda/bill/model/DisclaimerModel;", "fromPage", "isAutoGotoAddressPage", "isRefreshCart", "isShowedAddressEditAlert", "isUpdateShopAndCart", "mAlertQueue", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "getMAlertQueue", "()Ljava/util/ArrayList;", "mBillInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "mBillListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/soda/bill/model/SectionModel;", "nodeList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "oldItems", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel;", "oldTotalPrice", "payErrorGuideDialogHelper", "Lcom/didi/soda/bill/dialog/PayErrorGuideDialogHelper;", "platformCouponAmount", "priceList", "", "", "priceManager", "Lcom/didi/soda/globalcart/anim/TotalPriceManager;", "rCouponAmount", "scene", "sections", "shopCouponAmount", "shopId", "source", "wineConfirm", "anchorBillTopReminder", "billUpdate", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "checkAndShowBubble", "createComponentModelMap", "diffCartItem", "fastBuy", "fetchBillData", "isLoadingCancelable", "sceneType", "findModelByType", "type", "generateModelMapByType", "", "getItemListForTracker", "sectionList", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillSection;", "getLocalPermissionState", "getSelectedAid", "hideLoading", "initDataManagers", "initParams", "isShowAddressEmpty", "addressModel", "onClickBack", "onCreate", "onCreateOrder", "buttonCallback", "Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "onDestroy", "onHandleBack", "onRecAddressClose", "onSetRecAddress", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "style", "quit", "error", "realCreateOrder", "param", "Lcom/didi/soda/bill/manager/CreateOrderState;", "addressName", "recoverBillData", "orderId", "sceneParam", "Lcom/didi/soda/customer/foundation/rpc/entity/SceneParamsEntity;", "refreshCart", "model", "refreshData", "billInfoEntity", "refreshTotalPrice", "requestBillData", "saveLastContactIfNeed", "setAddressTitleData", "setCPFVisibleListener", "listener", "setDisclaimerDesc", "showAbnormalView", "msg", "showErrorDialog", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "showLoading", "showPayErrorDialog", "alertEntity", "showPlaceOrderTipDialog", "cartPayButtonCallback", "startAlertTask", "isAutoGotoEditAddress", "startTotalPriceAnim", "newDisplay", "setTextBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "subscribeItemChange", "syncShopStatus", "tracePayClick", "itemDetail", "payChannelId", "preOrderId", "aid", "isSuc", "failureReason", "addressDetail", "poi", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;)V", "BillRpcCallback", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBillPresenter.kt */
public final class CustomerBillPresenter extends Contract.AbsBillPresenter {
    public static final int BILL_INFO = 0;
    public static final int BILL_RECOVERY = 2;
    public static final int BILL_UPDATE = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CustomerBillPresenter";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f41539A;

    /* renamed from: B */
    private boolean f41540B;

    /* renamed from: C */
    private final ArrayList<Pair<Integer, Function0<Unit>>> f41541C = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f41542a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f41543b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f41544c;

    /* renamed from: d */
    private String f41545d = "";

    /* renamed from: e */
    private int f41546e;

    /* renamed from: f */
    private List<? extends ItemNodeEntity> f41547f;

    /* renamed from: g */
    private int f41548g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ActInfoEntity f41549h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f41550i;

    /* renamed from: j */
    private ChildDataListManager<SectionModel> f41551j;

    /* renamed from: k */
    private ChildDataItemManager<DisclaimerModel> f41552k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CPFCheckVisibleListener f41553l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public BillInfoEntity f41554m;

    /* renamed from: n */
    private ArrayList<SectionModel> f41555n;

    /* renamed from: o */
    private Map<Integer, ComponentModel> f41556o;

    /* renamed from: p */
    private ArrayList<BillCartItemModel> f41557p;

    /* renamed from: q */
    private boolean f41558q;

    /* renamed from: r */
    private final TotalPriceManager f41559r = new TotalPriceManager();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final PayErrorGuideDialogHelper f41560s = new PayErrorGuideDialogHelper();
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f41561t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f41562u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f41563v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public ArrayList<Map<String, Object>> f41564w;

    /* renamed from: x */
    private String f41565x;

    /* renamed from: y */
    private String f41566y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f41567z;

    public final ArrayList<Pair<Integer, Function0<Unit>>> getMAlertQueue() {
        return this.f41541C;
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillPresenter$Companion;", "", "()V", "BILL_INFO", "", "BILL_RECOVERY", "BILL_UPDATE", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerBillPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCreate() {
        super.onCreate();
        m31191a();
        m31213b();
        m31227i();
        Contract.AbsBillView absBillView = (Contract.AbsBillView) getLogicView();
        String str = this.f41543b;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            str = null;
        }
        String str3 = this.f41542a;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
        } else {
            str2 = str3;
        }
        absBillView.loadNotify(str, str2);
    }

    public boolean onHandleBack() {
        ComposeActionEntity composeActionEntity;
        Object obj;
        BillInfoEntity billInfoEntity = this.f41554m;
        if (billInfoEntity == null) {
            return false;
        }
        String str = null;
        if (billInfoEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
            billInfoEntity = null;
        }
        List<ComposeActionEntity> interactions = billInfoEntity.getInteractions();
        if (interactions == null) {
            composeActionEntity = null;
        } else {
            Iterator it = interactions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((ComposeActionEntity) obj).getIdentifier(), (Object) "backBtn")) {
                    break;
                }
            }
            composeActionEntity = (ComposeActionEntity) obj;
        }
        CustomerBillPresenter$onHandleBack$lis$1 customerBillPresenter$onHandleBack$lis$1 = new CustomerBillPresenter$onHandleBack$lis$1(this);
        if (composeActionEntity == null) {
            return false;
        }
        ComposeActionEntity.RetainInfo retainInfo = composeActionEntity.getRetainInfo();
        if ((retainInfo == null ? null : retainInfo.getActions()) == null) {
            ArrayList arrayList = new ArrayList();
            String str2 = this.f41542a;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            } else {
                str = str2;
            }
            arrayList.add(Intrinsics.stringPlus("bsodacustomer://soda/track?name=sailing_c_x_cart_quit_popup_sw&params=cart_id%3D", str));
            ComposeActionEntity.RetainInfo retainInfo2 = composeActionEntity.getRetainInfo();
            if (retainInfo2 != null) {
                retainInfo2.setActions(arrayList);
            }
        }
        ComposeActionHelper composeActionHelper = ComposeActionHelper.INSTANCE;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        composeActionHelper.doAction(scopeContext, composeActionEntity, customerBillPresenter$onHandleBack$lis$1);
        return true;
    }

    public void onClickBack() {
        if (!onHandleBack()) {
            ScopeContext scopeContext = getScopeContext();
            String str = null;
            Object object = scopeContext == null ? null : scopeContext.getObject("PageName");
            if (object instanceof String) {
                str = (String) object;
            }
            BillOmegaHelper.Companion.trackBillPageClose(str);
            getScopeContext().getNavigator().finish();
        }
    }

    public void setCPFVisibleListener(CPFCheckVisibleListener cPFCheckVisibleListener) {
        Intrinsics.checkNotNullParameter(cPFCheckVisibleListener, "listener");
        this.f41553l = cPFCheckVisibleListener;
    }

    public void onSetRecAddress(AddressEntity addressEntity, int i) {
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(addressEntity, 5);
        String str = null;
        m31198a(this, false, 202, 1, (Object) null);
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str2 = this.f41542a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str2 = null;
        }
        String str3 = this.f41543b;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            str3 = null;
        }
        String str4 = this.f41544c;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fromPage");
        } else {
            str = str4;
        }
        companion.traceCartRecommendBubbleCK(str2, str3, str, i);
    }

    public void onRecAddressClose() {
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = this.f41542a;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str = null;
        }
        String str3 = this.f41543b;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            str3 = null;
        }
        String str4 = this.f41544c;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fromPage");
        } else {
            str2 = str4;
        }
        companion.traceCartRecommendBubbleCancel(str, str3, str2, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:174:0x038b, code lost:
        if ((r14 == null || r14.length() == 0) != false) goto L_0x038d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c9 A[Catch:{ Exception -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cf A[Catch:{ Exception -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0158 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015a A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a0 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b2 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01b3 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01df A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e0 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0216 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0244  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreateOrder(com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback r29) {
        /*
            r28 = this;
            r10 = r28
            r1 = r29
            java.lang.String r0 = "mduid"
            java.lang.String r2 = "amount"
            java.lang.String r3 = "item_id"
            java.lang.String r4 = ""
            java.lang.String r5 = "buttonCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            boolean r5 = com.didi.soda.customer.foundation.util.LoginUtil.isLogin()
            java.lang.String r6 = "sailing_c_m_bill_createorder_na_exception"
            java.lang.String r7 = "bill"
            java.lang.String r8 = "CustomerBillPresenter"
            if (r5 != 0) goto L_0x0042
            android.content.Context r0 = r28.getContext()
            r1 = 9
            com.didi.soda.customer.foundation.util.LoginUtil.loginActivityAndTrack(r0, r1)
            java.lang.String r0 = "onCreateOrder -> !LoginUtil.isLogin"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32588i((java.lang.String) r8, (java.lang.String) r0)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r0 = com.didi.soda.customer.foundation.tracker.error.ErrorTracker.create(r6)
            java.lang.String r1 = "login"
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addErrorType(r1)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addModuleName(r7)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker r0 = r0.build()
            r0.trackError()
            return
        L_0x0042:
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r5 = r10.f41554m
            java.lang.String r9 = "mBillInfoEntity"
            if (r5 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r5 = 0
        L_0x004c:
            com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo r5 = r5.getShopInfo()
            if (r5 != 0) goto L_0x0054
            r5 = 0
            goto L_0x0058
        L_0x0054:
            java.lang.String r5 = r5.getShopId()
        L_0x0058:
            r12 = r5
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x0066
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r12 = 0
            goto L_0x0067
        L_0x0066:
            r12 = 1
        L_0x0067:
            if (r12 == 0) goto L_0x0084
            java.lang.String r0 = "onCreateOrder -> businessId.isNullOrEmpty"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32588i((java.lang.String) r8, (java.lang.String) r0)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r0 = com.didi.soda.customer.foundation.tracker.error.ErrorTracker.create(r6)
            java.lang.String r1 = "businessId"
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addErrorType(r1)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addModuleName(r7)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker r0 = r0.build()
            r0.trackError()
            return
        L_0x0084:
            com.didi.soda.bill.component.bill.BillWsgTouchHelper$Companion r6 = com.didi.soda.bill.component.bill.BillWsgTouchHelper.Companion
            com.didi.soda.bill.component.bill.BillWsgTouchHelper r6 = r6.getInstance()
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r12 = r10.f41554m
            if (r12 != 0) goto L_0x0092
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = 0
        L_0x0092:
            com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo r12 = r12.getShopInfo()
            r6.report(r12)
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x0238 }
            r12.<init>()     // Catch:{ Exception -> 0x0238 }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x0238 }
            r15.<init>()     // Catch:{ Exception -> 0x0238 }
            java.util.LinkedHashMap r16 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0238 }
            r16.<init>()     // Catch:{ Exception -> 0x0238 }
            r11 = r16
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x0238 }
            r14 = 5
            com.didi.soda.bill.model.ComponentModel r14 = r10.m31212b((int) r14)     // Catch:{ Exception -> 0x0238 }
            if (r14 != 0) goto L_0x00b5
        L_0x00b3:
            r14 = 0
            goto L_0x00c7
        L_0x00b5:
            com.didi.soda.bill.model.ComponentDataModel r14 = r14.getData()     // Catch:{ Exception -> 0x0238 }
            if (r14 != 0) goto L_0x00bc
            goto L_0x00b3
        L_0x00bc:
            com.didi.soda.bill.model.datamodel.BillItemsInfoModel r14 = r14.getItemsInfoModel()     // Catch:{ Exception -> 0x0238 }
            if (r14 != 0) goto L_0x00c3
            goto L_0x00b3
        L_0x00c3:
            java.util.ArrayList r14 = r14.getItems()     // Catch:{ Exception -> 0x0238 }
        L_0x00c7:
            if (r14 != 0) goto L_0x00cf
            r19 = r4
            r21 = r9
            goto L_0x0205
        L_0x00cf:
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0238 }
        L_0x00d3:
            boolean r17 = r14.hasNext()     // Catch:{ Exception -> 0x0238 }
            if (r17 == 0) goto L_0x01fd
            java.lang.Object r17 = r14.next()     // Catch:{ Exception -> 0x0238 }
            com.didi.soda.bill.model.datamodel.BillCartItemModel r17 = (com.didi.soda.bill.model.datamodel.BillCartItemModel) r17     // Catch:{ Exception -> 0x0238 }
            java.util.LinkedHashMap r18 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0238 }
            r18.<init>()     // Catch:{ Exception -> 0x0238 }
            r6 = r18
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0238 }
            java.util.LinkedHashMap r18 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0238 }
            r18.<init>()     // Catch:{ Exception -> 0x0238 }
            r13 = r18
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x0238 }
            com.didi.soda.cart.omega.CartGuideDataManager$Companion r18 = com.didi.soda.cart.omega.CartGuideDataManager.Companion     // Catch:{ Exception -> 0x0238 }
            r19 = r4
            com.didi.soda.cart.omega.CartGuideDataManager r4 = r18.getInstance()     // Catch:{ Exception -> 0x01fb }
            r18 = r14
            java.lang.String r14 = r10.f41543b     // Catch:{ Exception -> 0x01fb }
            if (r14 != 0) goto L_0x0106
            java.lang.String r14 = "shopId"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)     // Catch:{ Exception -> 0x01fb }
            r14 = 0
        L_0x0106:
            if (r17 != 0) goto L_0x010d
        L_0x0108:
            r21 = r9
            r9 = r19
            goto L_0x0118
        L_0x010d:
            java.lang.String r20 = r17.getItemId()     // Catch:{ Exception -> 0x01fb }
            if (r20 != 0) goto L_0x0114
            goto L_0x0108
        L_0x0114:
            r21 = r9
            r9 = r20
        L_0x0118:
            com.didi.soda.cart.model.CartGuideModel r4 = r4.getCartGuideParams(r14, r9)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = r17.getItemId()     // Catch:{ Exception -> 0x0236 }
            r6.put(r3, r9)     // Catch:{ Exception -> 0x0236 }
            int r9 = r17.getPrice()     // Catch:{ Exception -> 0x0236 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0236 }
            r6.put(r2, r9)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "discount"
            int r14 = r17.getSpecialPrice()     // Catch:{ Exception -> 0x0236 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0236 }
            r6.put(r9, r14)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = r17.getMduId()     // Catch:{ Exception -> 0x0236 }
            r6.put(r0, r9)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "has_image"
            java.lang.String r14 = r17.getHeadImg()     // Catch:{ Exception -> 0x0236 }
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x0236 }
            if (r14 == 0) goto L_0x0155
            int r14 = r14.length()     // Catch:{ Exception -> 0x0236 }
            if (r14 != 0) goto L_0x0153
            goto L_0x0155
        L_0x0153:
            r14 = 0
            goto L_0x0156
        L_0x0155:
            r14 = 1
        L_0x0156:
            if (r14 == 0) goto L_0x015a
            r14 = 0
            goto L_0x015b
        L_0x015a:
            r14 = 1
        L_0x015b:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0236 }
            r6.put(r9, r14)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "item_type"
            int r14 = r17.getMduType()     // Catch:{ Exception -> 0x0236 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0236 }
            r6.put(r9, r14)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "price"
            int r14 = r17.getPrice()     // Catch:{ Exception -> 0x0236 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0236 }
            r6.put(r9, r14)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "discount_price"
            int r14 = r17.getSpecialPrice()     // Catch:{ Exception -> 0x0236 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0236 }
            r6.put(r9, r14)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "activity_type"
            int r14 = r17.getActivityType()     // Catch:{ Exception -> 0x0236 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0236 }
            r6.put(r9, r14)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "is_item_merge"
            int r14 = r17.getTyingItemsFlag()     // Catch:{ Exception -> 0x0236 }
            r1 = 1
            if (r14 == r1) goto L_0x01ab
            int r1 = r17.getTyingItemsFlag()     // Catch:{ Exception -> 0x0236 }
            r14 = 2
            if (r1 != r14) goto L_0x01a8
            goto L_0x01ab
        L_0x01a8:
            java.lang.String r1 = "0"
            goto L_0x01ad
        L_0x01ab:
            java.lang.String r1 = "1"
        L_0x01ad:
            r6.put(r9, r1)     // Catch:{ Exception -> 0x0236 }
            if (r4 != 0) goto L_0x01b3
            goto L_0x01c1
        L_0x01b3:
            java.util.Map r1 = r4.getGuideParams()     // Catch:{ Exception -> 0x0236 }
            if (r1 != 0) goto L_0x01ba
            goto L_0x01c1
        L_0x01ba:
            r6.putAll(r1)     // Catch:{ Exception -> 0x0236 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0236 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0236 }
        L_0x01c1:
            r12.add(r6)     // Catch:{ Exception -> 0x0236 }
            int r1 = r17.getAmount()     // Catch:{ Exception -> 0x0236 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0236 }
            r13.put(r2, r1)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r1 = r17.getItemId()     // Catch:{ Exception -> 0x0236 }
            r13.put(r3, r1)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r1 = r17.getMduId()     // Catch:{ Exception -> 0x0236 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0236 }
            if (r4 != 0) goto L_0x01e0
            goto L_0x01ee
        L_0x01e0:
            java.util.Map r1 = r4.getGuideParams()     // Catch:{ Exception -> 0x0236 }
            if (r1 != 0) goto L_0x01e7
            goto L_0x01ee
        L_0x01e7:
            r13.putAll(r1)     // Catch:{ Exception -> 0x0236 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0236 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0236 }
        L_0x01ee:
            r15.add(r13)     // Catch:{ Exception -> 0x0236 }
            r1 = r29
            r14 = r18
            r4 = r19
            r9 = r21
            goto L_0x00d3
        L_0x01fb:
            r0 = move-exception
            goto L_0x023b
        L_0x01fd:
            r19 = r4
            r21 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0236 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0236 }
        L_0x0205:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0236 }
            java.lang.String r0 = "item_detail"
            java.lang.String r1 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r15)     // Catch:{ Exception -> 0x0236 }
            r11.put(r0, r1)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r0 = "cart_id"
            java.lang.String r1 = r10.f41542a     // Catch:{ Exception -> 0x0236 }
            if (r1 != 0) goto L_0x021c
            java.lang.String r1 = "cartId"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ Exception -> 0x0236 }
            r1 = 0
        L_0x021c:
            r11.put(r0, r1)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r0 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r12)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r1 = "toJson(itemDetailMapList)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r1 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r11)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r2 = "toJson(dataAuditRootMap)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x0236 }
            r2 = r0
            r4 = r1
            goto L_0x0268
        L_0x0236:
            r0 = move-exception
            goto L_0x023d
        L_0x0238:
            r0 = move-exception
            r19 = r4
        L_0x023b:
            r21 = r9
        L_0x023d:
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x0244
            goto L_0x0265
        L_0x0244:
            java.lang.String r1 = "sailing_c_m_bill_createorder_itemdetail_exception"
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r1 = com.didi.soda.customer.foundation.tracker.error.ErrorTracker.create(r1)
            java.lang.String r2 = "parse"
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r1 = r1.addErrorType(r2)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r1 = r1.addModuleName(r7)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r1.addErrorMsg(r0)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker r0 = r0.build()
            r0.trackError()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0265:
            r2 = r19
            r4 = r2
        L_0x0268:
            r1 = 2
            com.didi.soda.bill.model.ComponentModel r0 = r10.m31212b((int) r1)
            r1 = 4
            com.didi.soda.bill.model.ComponentModel r3 = r10.m31212b((int) r1)
            if (r0 != 0) goto L_0x0276
        L_0x0274:
            r6 = 0
            goto L_0x0288
        L_0x0276:
            com.didi.soda.bill.model.ComponentDataModel r6 = r0.getData()
            if (r6 != 0) goto L_0x027d
            goto L_0x0274
        L_0x027d:
            com.didi.soda.bill.model.datamodel.AddressModel r6 = r6.getAddressModel()
            if (r6 != 0) goto L_0x0284
            goto L_0x0274
        L_0x0284:
            java.lang.String r6 = r6.getAid()
        L_0x0288:
            if (r0 != 0) goto L_0x028c
        L_0x028a:
            r7 = 0
            goto L_0x029e
        L_0x028c:
            com.didi.soda.bill.model.ComponentDataModel r7 = r0.getData()
            if (r7 != 0) goto L_0x0293
            goto L_0x028a
        L_0x0293:
            com.didi.soda.bill.model.datamodel.AddressModel r7 = r7.getAddressModel()
            if (r7 != 0) goto L_0x029a
            goto L_0x028a
        L_0x029a:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r7 = r7.getPoiEntity()
        L_0x029e:
            if (r7 != 0) goto L_0x02b2
            java.lang.Class<com.didi.soda.manager.base.ICustomerAddressManager> r7 = com.didi.soda.manager.base.ICustomerAddressManager.class
            com.didi.soda.manager.base.ICustomerManager r7 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r7)
            com.didi.soda.manager.base.ICustomerAddressManager r7 = (com.didi.soda.manager.base.ICustomerAddressManager) r7
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r7 = r7.getDelieveryAddress()
            if (r7 != 0) goto L_0x02b0
            r9 = 0
            goto L_0x02b3
        L_0x02b0:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r7 = r7.poi
        L_0x02b2:
            r9 = r7
        L_0x02b3:
            if (r3 != 0) goto L_0x02b7
        L_0x02b5:
            r7 = 0
            goto L_0x02c9
        L_0x02b7:
            com.didi.soda.bill.model.ComponentDataModel r7 = r3.getData()
            if (r7 != 0) goto L_0x02be
            goto L_0x02b5
        L_0x02be:
            com.didi.soda.bill.model.datamodel.PayChannelModel r7 = r7.getPayChannelModel()
            if (r7 != 0) goto L_0x02c5
            goto L_0x02b5
        L_0x02c5:
            com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r7 = r7.getPayChannelEntity()
        L_0x02c9:
            if (r0 != 0) goto L_0x02cd
        L_0x02cb:
            r11 = 0
            goto L_0x02e6
        L_0x02cd:
            com.didi.soda.bill.model.ComponentDataModel r11 = r0.getData()
            if (r11 != 0) goto L_0x02d4
            goto L_0x02cb
        L_0x02d4:
            com.didi.soda.bill.model.datamodel.AddressModel r11 = r11.getAddressModel()
            if (r11 != 0) goto L_0x02db
            goto L_0x02cb
        L_0x02db:
            java.lang.CharSequence r11 = r11.getAddressName()
            if (r11 != 0) goto L_0x02e2
            goto L_0x02cb
        L_0x02e2:
            java.lang.String r11 = r11.toString()
        L_0x02e6:
            boolean r12 = r10.m31210a((com.didi.soda.bill.model.ComponentModel) r0)
            java.lang.String r13 = "logicView"
            if (r12 == 0) goto L_0x0336
            java.lang.String r1 = "onCreateOrder -> aid.isNullOrEmpty"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32588i((java.lang.String) r8, (java.lang.String) r1)
            r12 = r29
            r12.fail(r5)
            com.didi.soda.bill.BillOmegaHelper$Companion r1 = com.didi.soda.bill.BillOmegaHelper.Companion
            r1.addressVerifySw()
            if (r7 != 0) goto L_0x0302
            r1 = 0
            r3 = 0
            goto L_0x030a
        L_0x0302:
            int r1 = r7.channelId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r1
            r1 = 0
        L_0x030a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r1 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            r1 = r28
            r8 = r11
            r1.m31206a(r2, r3, r4, r5, r6, r7, r8, r9)
            com.didi.app.nova.skeleton.mvp.IView r1 = r28.getLogicView()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            r22 = r1
            com.didi.soda.bill.component.Contract$AbsBillView r22 = (com.didi.soda.bill.component.Contract.AbsBillView) r22
            r24 = 2
            r25 = 0
            r26 = 4
            r27 = 0
            r23 = r0
            com.didi.soda.bill.component.Contract.AbsBillView.autoClickItem$default(r22, r23, r24, r25, r26, r27)
            return
        L_0x0336:
            r12 = r29
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r14 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r14 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r14)
            com.didi.soda.manager.base.ICustomerBillManager r14 = (com.didi.soda.manager.base.ICustomerBillManager) r14
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r14 = r14.getCurrentContact()
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r15 = r10.f41554m
            if (r15 != 0) goto L_0x034c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r21)
            r15 = 0
        L_0x034c:
            com.didi.soda.customer.foundation.rpc.entity.bill.IsValidationEntity r15 = r15.isValidation()
            if (r15 != 0) goto L_0x0354
        L_0x0352:
            r15 = 0
            goto L_0x035b
        L_0x0354:
            int r15 = r15.getFullNameSwitch()
            if (r15 != 0) goto L_0x0352
            r15 = 1
        L_0x035b:
            if (r15 != 0) goto L_0x03c4
            if (r14 != 0) goto L_0x0361
            r15 = 0
            goto L_0x0365
        L_0x0361:
            java.lang.String r15 = r14.getFirstName()
        L_0x0365:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            if (r15 == 0) goto L_0x0372
            int r15 = r15.length()
            if (r15 != 0) goto L_0x0370
            goto L_0x0372
        L_0x0370:
            r15 = 0
            goto L_0x0373
        L_0x0372:
            r15 = 1
        L_0x0373:
            if (r15 != 0) goto L_0x038d
            if (r14 != 0) goto L_0x0379
            r14 = 0
            goto L_0x037d
        L_0x0379:
            java.lang.String r14 = r14.getLastName()
        L_0x037d:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            if (r14 == 0) goto L_0x038a
            int r14 = r14.length()
            if (r14 != 0) goto L_0x0388
            goto L_0x038a
        L_0x0388:
            r14 = 0
            goto L_0x038b
        L_0x038a:
            r14 = 1
        L_0x038b:
            if (r14 == 0) goto L_0x03c4
        L_0x038d:
            com.didi.app.nova.skeleton.mvp.IView r3 = r28.getLogicView()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r22 = r3
            com.didi.soda.bill.component.Contract$AbsBillView r22 = (com.didi.soda.bill.component.Contract.AbsBillView) r22
            r24 = 4
            r25 = 0
            r26 = 4
            r27 = 0
            r23 = r0
            com.didi.soda.bill.component.Contract.AbsBillView.autoClickItem$default(r22, r23, r24, r25, r26, r27)
            if (r7 != 0) goto L_0x03a9
            r3 = 0
            goto L_0x03b0
        L_0x03a9:
            int r0 = r7.channelId
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3 = r0
        L_0x03b0:
            r4 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = ""
            r1 = r28
            r5 = r6
            r6 = r0
            r8 = r11
            r1.m31206a(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        L_0x03c4:
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r0 = r10.f41554m
            if (r0 != 0) goto L_0x03cc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r21)
            r0 = 0
        L_0x03cc:
            com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r0 = r0.getPayCheckAlert()
            if (r0 != 0) goto L_0x03d4
        L_0x03d2:
            r1 = 0
            goto L_0x03dd
        L_0x03d4:
            int r0 = r0.getType()
            r1 = 100
            if (r0 != r1) goto L_0x03d2
            r1 = 1
        L_0x03dd:
            if (r1 == 0) goto L_0x0418
            com.didi.app.nova.skeleton.mvp.IView r0 = r28.getLogicView()
            com.didi.soda.bill.component.Contract$AbsBillView r0 = (com.didi.soda.bill.component.Contract.AbsBillView) r0
            r0.focusItem(r3)
            java.lang.String r0 = "onCreateOrder -> payChannelIntercept"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32588i((java.lang.String) r8, (java.lang.String) r0)
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r0 = r10.f41554m
            if (r0 != 0) goto L_0x03f5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r21)
            r0 = 0
        L_0x03f5:
            com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r0 = r0.getPayCheckAlert()
            r10.m31202a((com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity) r0)
            r12.fail(r5)
            r1 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r1 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = ""
            r1 = r28
            r5 = r6
            r6 = r0
            r8 = r11
            r1.m31206a(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        L_0x0418:
            com.didi.soda.bill.manager.CreateOrderState r0 = new com.didi.soda.bill.manager.CreateOrderState
            r0.<init>()
            r0.setShopId(r5)
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r1 = r10.f41554m
            if (r1 != 0) goto L_0x0428
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r21)
            r1 = 0
        L_0x0428:
            java.lang.String r1 = r1.getCartId()
            r0.setCartId(r1)
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r1 = r10.f41554m
            if (r1 != 0) goto L_0x0437
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r21)
            r1 = 0
        L_0x0437:
            java.lang.String r1 = r1.getSn()
            r0.setSn(r1)
            r0.setAid(r6)
            r0.setPoiEntity(r9)
            r0.setPayChannelEntity(r7)
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r1 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r1 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r1)
            com.didi.soda.manager.base.ICustomerBillManager r1 = (com.didi.soda.manager.base.ICustomerBillManager) r1
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r1 = r1.getCurrentContact()
            r0.setUserInfo(r1)
            r0.setItemDetail(r2)
            r0.setDataAudit(r4)
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r1 = r10.f41554m
            if (r1 != 0) goto L_0x0464
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r21)
            r1 = 0
        L_0x0464:
            com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo r1 = r1.getShopInfo()
            if (r1 != 0) goto L_0x046c
            r1 = 0
            goto L_0x0474
        L_0x046c:
            int r1 = r1.getDeliveryType()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0474:
            r0.setDeliveryType(r1)
            r10.m31200a((com.didi.soda.bill.manager.CreateOrderState) r0, (java.lang.String) r11, (com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillPresenter.onCreateOrder(com.didi.soda.manager.base.ICustomerPayManager$CartPayButtonCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r1 = (r1 = r6.getData()).getAddressModel();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m31210a(com.didi.soda.bill.model.ComponentModel r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0017
        L_0x0005:
            com.didi.soda.bill.model.ComponentDataModel r1 = r6.getData()
            if (r1 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            com.didi.soda.bill.model.datamodel.AddressModel r1 = r1.getAddressModel()
            if (r1 != 0) goto L_0x0013
            goto L_0x0003
        L_0x0013:
            java.lang.String r1 = r1.getAid()
        L_0x0017:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0026
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r1 = 0
            goto L_0x0027
        L_0x0026:
            r1 = 1
        L_0x0027:
            if (r1 != 0) goto L_0x005f
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r1 = r5.f41554m
            java.lang.String r4 = "mBillInfoEntity"
            if (r1 != 0) goto L_0x0033
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r0
        L_0x0033:
            int r1 = r1.getAddressRecStrategy()
            if (r1 == 0) goto L_0x0060
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r1 = r5.f41554m
            if (r1 != 0) goto L_0x0041
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r0
        L_0x0041:
            int r1 = r1.getAddressRecStrategy()
            r4 = 3
            if (r1 == r4) goto L_0x0060
            if (r6 != 0) goto L_0x004b
            goto L_0x005d
        L_0x004b:
            com.didi.soda.bill.model.ComponentDataModel r6 = r6.getData()
            if (r6 != 0) goto L_0x0052
            goto L_0x005d
        L_0x0052:
            com.didi.soda.bill.model.datamodel.AddressModel r6 = r6.getAddressModel()
            if (r6 != 0) goto L_0x0059
            goto L_0x005d
        L_0x0059:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r0 = r6.getRecAddressEntity()
        L_0x005d:
            if (r0 == 0) goto L_0x0060
        L_0x005f:
            r2 = 1
        L_0x0060:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillPresenter.m31210a(com.didi.soda.bill.model.ComponentModel):boolean");
    }

    /* renamed from: a */
    private final void m31206a(String str, Integer num, String str2, String str3, Integer num2, Integer num3, String str4, AddressEntity.PoiEntity poiEntity) {
        int i;
        int i2;
        int i3;
        String str5 = "";
        String string = getScopeContext().getBundle().getString("from_page", str5);
        try {
            CreateOrderOmegaBuilder createOrderOmegaBuilder = new CreateOrderOmegaBuilder();
            if (string == null) {
                string = str5;
            }
            CreateOrderOmegaBuilder fromPage = createOrderOmegaBuilder.fromPage(string);
            String str6 = this.f41542a;
            String str7 = null;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
                str6 = null;
            }
            CreateOrderOmegaBuilder cartId = fromPage.cartId(str6);
            String str8 = this.f41543b;
            if (str8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopId");
                str8 = null;
            }
            CreateOrderOmegaBuilder shopId = cartId.shopId(str8);
            if (str == null) {
                str = str5;
            }
            CreateOrderOmegaBuilder itemDetail = shopId.itemDetail(str);
            int i4 = 0;
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            CreateOrderOmegaBuilder payMethod = itemDetail.payMethod(Integer.valueOf(i));
            BillInfoEntity billInfoEntity = this.f41554m;
            if (billInfoEntity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
                billInfoEntity = null;
            }
            CreateOrderOmegaBuilder createOrderOmegaBuilder2 = payMethod.total(Integer.valueOf(billInfoEntity.getRealPayPrice()));
            if (str2 == null) {
                str2 = str5;
            }
            CreateOrderOmegaBuilder preOrderId = createOrderOmegaBuilder2.preOrderId(str2);
            if (str3 == null) {
                str3 = str5;
            }
            CreateOrderOmegaBuilder aid = preOrderId.aid(str3);
            if (num2 == null) {
                i2 = 0;
            } else {
                i2 = num2.intValue();
            }
            CreateOrderOmegaBuilder isSuc = aid.isSuc(Integer.valueOf(i2));
            if (num3 == null) {
                i3 = 0;
            } else {
                i3 = num3.intValue();
            }
            CreateOrderOmegaBuilder shopCouponAmount = isSuc.payFailureReason(Integer.valueOf(i3)).eventType(Integer.valueOf(this.f41550i ? 1 : 0)).priceList(GsonUtil.toJson(this.f41564w)).platformCouponAmount(Integer.valueOf(this.f41561t)).shopCouponAmount(Integer.valueOf(this.f41562u));
            BillInfoEntity billInfoEntity2 = this.f41554m;
            if (billInfoEntity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
                billInfoEntity2 = null;
            }
            ShopInfo shopInfo = billInfoEntity2.getShopInfo();
            if (shopInfo != null) {
                i4 = shopInfo.getDeliveryType();
            }
            CreateOrderOmegaBuilder rCouponAmount = shopCouponAmount.deliveryType(Integer.valueOf(i4)).rCouponAmount(Integer.valueOf(this.f41563v));
            if (str4 == null) {
                str4 = str5;
            }
            CreateOrderOmegaBuilder addressDetail = rCouponAmount.addressDetail(str4);
            if (poiEntity != null) {
                str7 = poiEntity.poiType;
            }
            if (str7 == null) {
                str7 = str5;
            }
            BillOmegaHelper.Companion.onPayClick(addressDetail.poiType(str7).pubBizType(Const.PubBizLine.FIN));
        } catch (Exception e) {
            ErrorTracker.Builder create = ErrorTracker.create(ErrorConst.ErrorName.SALING_C_BILL_PAY_CK_TRACK_ERROR);
            String message = e.getMessage();
            if (message != null) {
                str5 = message;
            }
            create.addErrorMsg(str5).addModuleName("bill").build().trackError();
            LogUtil.m32584d("CustomerBillPresenter", "onPayClick crash");
        }
    }

    /* renamed from: a */
    private final void m31200a(CreateOrderState createOrderState, String str, ICustomerPayManager.CartPayButtonCallback cartPayButtonCallback) {
        if (CustomerApolloUtil.isPlaceOrderTipDialog()) {
            LogUtil.m32588i("CustomerBillPresenter", "showPlaceOrderTipDialog -> isPlaceOrderTipDialog");
            DiRouter.request().path(RoutePath.CART_INFO_CONFIRM).putSerializable(Const.PageParams.CART_INFO_CONFIRM_ENTITY, createOrderState).open();
            ((CartInfoConfirmRepo) RepoFactory.getRepo(CartInfoConfirmRepo.class)).subscribe(getScopeContext(), new Action2(createOrderState, str, cartPayButtonCallback) {
                public final /* synthetic */ CreateOrderState f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ ICustomerPayManager.CartPayButtonCallback f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void call(Object obj, Subscription subscription) {
                    CustomerBillPresenter.m31195a(CustomerBillPresenter.this, this.f$1, this.f$2, this.f$3, (Integer) obj, subscription);
                }
            });
            BillOmegaHelper.Companion.payTipDialogTrack(EventConst.Pay.EVENT_PAY_TIP_DIALOG_SW, getScopeContext(), 0);
            return;
        }
        m31215b(createOrderState, str, cartPayButtonCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31195a(CustomerBillPresenter customerBillPresenter, CreateOrderState createOrderState, String str, ICustomerPayManager.CartPayButtonCallback cartPayButtonCallback, Integer num, Subscription subscription) {
        Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
        Intrinsics.checkNotNullParameter(createOrderState, "$param");
        Intrinsics.checkNotNullParameter(cartPayButtonCallback, "$cartPayButtonCallback");
        subscription.unsubscribe();
        if (num != null && num.intValue() == 3) {
            customerBillPresenter.m31215b(createOrderState, str, cartPayButtonCallback);
            BillOmegaHelper.Companion.payTipDialogTrack(EventConst.Pay.EVENT_PAY_TIP_DIALOG_CONFIRM_CK, customerBillPresenter.getScopeContext(), 0);
        } else if (num != null && num.intValue() == 4) {
            cartPayButtonCallback.fail(createOrderState.getShopId());
            BillOmegaHelper.Companion.payTipDialogTrack(EventConst.Pay.EVENT_PAY_TIP_DIALOG_CORRECT_CK, customerBillPresenter.getScopeContext(), 0);
            String itemDetail = createOrderState.getItemDetail();
            PayChannelEntity payChannelEntity = createOrderState.getPayChannelEntity();
            customerBillPresenter.m31206a(itemDetail, payChannelEntity == null ? null : Integer.valueOf(payChannelEntity.channelId), createOrderState.getPreOrderId(), createOrderState.getAid(), 0, 3, str, createOrderState.getPoiEntity());
            LogUtil.m32588i("CustomerBillPresenter", "showPlaceOrderTipDialog -> fail0");
        } else if (num != null && num.intValue() == 1) {
            cartPayButtonCallback.fail(createOrderState.getShopId());
            BillOmegaHelper.Companion.payTipDialogTrack(EventConst.Pay.EVENT_PAY_TIP_DIALOG_CLOSE_CK, customerBillPresenter.getScopeContext(), 1);
            String itemDetail2 = createOrderState.getItemDetail();
            PayChannelEntity payChannelEntity2 = createOrderState.getPayChannelEntity();
            customerBillPresenter.m31206a(itemDetail2, payChannelEntity2 == null ? null : Integer.valueOf(payChannelEntity2.channelId), createOrderState.getPreOrderId(), createOrderState.getAid(), 0, 3, str, createOrderState.getPoiEntity());
            LogUtil.m32588i("CustomerBillPresenter", "showPlaceOrderTipDialog -> fail1");
        } else if (num != null && num.intValue() == 2) {
            cartPayButtonCallback.fail(createOrderState.getShopId());
            BillOmegaHelper.Companion.payTipDialogTrack(EventConst.Pay.EVENT_PAY_TIP_DIALOG_CLOSE_CK, customerBillPresenter.getScopeContext(), 2);
            String itemDetail3 = createOrderState.getItemDetail();
            PayChannelEntity payChannelEntity3 = createOrderState.getPayChannelEntity();
            customerBillPresenter.m31206a(itemDetail3, payChannelEntity3 == null ? null : Integer.valueOf(payChannelEntity3.channelId), createOrderState.getPreOrderId(), createOrderState.getAid(), 0, 3, str, createOrderState.getPoiEntity());
            LogUtil.m32588i("CustomerBillPresenter", "showPlaceOrderTipDialog -> fail2");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31192a(int i) {
        getScopeContext().getNavigator().finish();
        if (i == 10) {
            String str = this.f41544c;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fromPage");
                str = null;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "homePage")) {
                ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).activityInvalidedRefreshHome();
            }
        }
    }

    /* renamed from: b */
    private final void m31215b(CreateOrderState createOrderState, String str, ICustomerPayManager.CartPayButtonCallback cartPayButtonCallback) {
        LogUtil.m32588i("CustomerBillPresenter", "realCreateOrder");
        getScopeContext().attach("pay_callback", cartPayButtonCallback);
        if (cartPayButtonCallback.isLoading()) {
            LogUtil.m32588i("CustomerBillPresenter", "realCreateOrder -> buttonCallback.isLoading");
            return;
        }
        cartPayButtonCallback.loading();
        DialogUtil.showBlockDialog(getScopeContext());
        getScopeContext().attach("bill_pay_callback", new CustomerBillPresenter$realCreateOrder$1(this));
        createOrderState.setPreOrderId(CipherUtil.md5(LoginUtil.getUid() + "16" + (System.currentTimeMillis() / ((long) 1000))));
        String itemDetail = createOrderState.getItemDetail();
        PayChannelEntity payChannelEntity = createOrderState.getPayChannelEntity();
        m31206a(itemDetail, payChannelEntity == null ? null : Integer.valueOf(payChannelEntity.channelId), createOrderState.getPreOrderId(), createOrderState.getAid(), 1, 0, str, createOrderState.getPoiEntity());
        LogUtil.m32588i("CustomerBillPresenter", Intrinsics.stringPlus("realCreateOrder -> createOrder preOrderId: ", createOrderState.getPreOrderId()));
        CreateOrderManager.Companion companion = CreateOrderManager.Companion;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        companion.assemble(scopeContext, createOrderState).createOrder();
    }

    public void startTotalPriceAnim(String str, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setTextBlock");
        if (CustomerApolloUtil.isBillPriceAnimOn()) {
            TotalPriceManager totalPriceManager = this.f41559r;
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            totalPriceManager.startAnim(scopeContext, str, this.f41566y, function1);
            return;
        }
        function1.invoke(str);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LogUtil.m32588i("CustomerBillPresenter", Intrinsics.stringPlus("onDestroy isRefreshCart ", Boolean.valueOf(this.f41558q)));
        if (this.f41558q) {
            ICustomerCartManager iCustomerCartManager = (ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class);
            BillInfoEntity billInfoEntity = this.f41554m;
            String str = null;
            if (billInfoEntity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
                billInfoEntity = null;
            }
            ShopInfo shopInfo = billInfoEntity.getShopInfo();
            if (shopInfo != null) {
                str = shopInfo.getShopId();
            }
            iCustomerCartManager.fetchCartInfo(str);
            BillEventToJS.triggerEvent$default(BillEventToJS.INSTANCE, 8, (Integer) null, (String) null, (IEntity) null, 14, (Object) null);
        }
        if (this.f41567z) {
            ((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).refreshBusinessPage(new BusinessActionParam(true, !this.f41558q, true));
        }
        this.f41559r.release();
    }

    /* renamed from: a */
    private final void m31191a() {
        String string = getScopeContext().getBundle().getString("cart_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "scopeContext.bundle.getS…st.BundleKey.CART_ID, \"\")");
        this.f41542a = string;
        String str = null;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            String string2 = getScopeContext().getBundle().getString(Const.PageParams.CART_ID, "");
            Intrinsics.checkNotNullExpressionValue(string2, "scopeContext.bundle.getS…t.PageParams.CART_ID, \"\")");
            this.f41542a = string2;
        }
        String string3 = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID, "");
        Intrinsics.checkNotNullExpressionValue(string3, "scopeContext.bundle.getS…t.PageParams.SHOP_ID, \"\")");
        this.f41543b = string3;
        String string4 = getScopeContext().getBundle().getString("from_page", "");
        Intrinsics.checkNotNullExpressionValue(string4, "scopeContext.bundle.getS….BundleKey.FROM_PAGE, \"\")");
        this.f41544c = string4;
        this.f41546e = getScopeContext().getBundle().getInt("source", 0);
        this.f41548g = getScopeContext().getBundle().getInt(Const.PageParams.WINE_CONFIRM, 0);
        String string5 = getScopeContext().getBundle().getString("scene", "");
        Intrinsics.checkNotNullExpressionValue(string5, "scopeContext.bundle.getS…nst.PageParams.SCENE, \"\")");
        this.f41545d = string5;
        try {
            Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.NODE_LIST);
            if (serializable != null) {
                this.f41547f = (List) serializable;
            }
            String string6 = getScopeContext().getBundle().getString(Const.PageParams.ACT_INFO);
            if (string6 != null) {
                this.f41549h = (ActInfoEntity) GsonUtil.fromJson(string6, ActInfoEntity.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f41549h == null) {
            this.f41549h = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getActInfo();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initParams cartId ");
        String str2 = this.f41542a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str2 = null;
        }
        sb.append(str2);
        sb.append(" shopId ");
        String str3 = this.f41543b;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            str3 = null;
        }
        sb.append(str3);
        sb.append(" fromPage ");
        String str4 = this.f41544c;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fromPage");
        } else {
            str = str4;
        }
        sb.append(str);
        sb.append(" source = ");
        sb.append(this.f41546e);
        LogUtil.m32588i("CustomerBillPresenter", sb.toString());
    }

    /* renamed from: b */
    private final void m31213b() {
        ((BillMessageRepo) RepoFactory.getRepo(BillMessageRepo.class)).clearMessages();
        ((BillMessageRepo) RepoFactory.getRepo(BillMessageRepo.class)).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                CustomerBillPresenter.m31196a(CustomerBillPresenter.this, (IEntity) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31196a(CustomerBillPresenter customerBillPresenter, IEntity iEntity) {
        Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
        if (iEntity != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("subscribeItemChange entity ");
            sb.append(iEntity);
            sb.append(" ,cartId ");
            String str = customerBillPresenter.f41542a;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
                str = null;
            }
            sb.append(str);
            LogUtil.m32588i("CustomerBillPresenter", sb.toString());
            if (iEntity instanceof AddressEntity) {
                customerBillPresenter.m31208a(false, 202);
            } else if (iEntity instanceof CouponInfoEntity) {
                customerBillPresenter.f41558q = true;
                customerBillPresenter.m31201a(iEntity);
            } else if (iEntity instanceof BillRefreshEntity) {
                BillRefreshEntity billRefreshEntity = (BillRefreshEntity) iEntity;
                int from = billRefreshEntity.getFrom();
                if (from == 1) {
                    m31198a(customerBillPresenter, false, 202, 1, (Object) null);
                } else if (from == 2) {
                    customerBillPresenter.onSetRecAddress(billRefreshEntity.getAddressEntity(), 1);
                }
            } else {
                customerBillPresenter.m31201a(iEntity);
            }
        }
    }

    /* renamed from: a */
    private final void m31201a(IEntity iEntity) {
        String str;
        m31199a(this, false, 1, (Object) null);
        ContactEntity currentContact = ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).getCurrentContact();
        ICustomerBillManager iCustomerBillManager = (ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class);
        String str2 = this.f41542a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str = null;
        } else {
            str = str2;
        }
        String selectedAid = getSelectedAid();
        int localPermissionState = getLocalPermissionState();
        String str3 = currentContact.phone;
        String str4 = str3 != null ? str3 : "";
        String str5 = currentContact.callingCode;
        iCustomerBillManager.billUpdate(str, iEntity, selectedAid, localPermissionState, str4, str5 != null ? str5 : "", this.f41545d, new BillRpcCallback(1, (String) null, 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31203a(BillInfoEntity billInfoEntity) {
        LogUtil.m32584d("CustomerBillPresenter", Intrinsics.stringPlus("refreshData  = ", billInfoEntity.getCartId()));
        ArrayList<SectionModel> createSectionModels = BillDataFactory.Companion.getFactory().createSectionModels(billInfoEntity, 2, this.f41546e);
        this.f41555n = createSectionModels;
        ChildDataListManager<SectionModel> childDataListManager = this.f41551j;
        if (childDataListManager != null) {
            childDataListManager.set(createSectionModels);
        }
        m31225g();
        m31219c(billInfoEntity);
        m31217b(billInfoEntity);
        ((Contract.AbsBillView) getLogicView()).setPayPrice(billInfoEntity);
        m31220d();
        m31224f();
        m31222e();
        m31218c();
        ((Contract.AbsBillView) getLogicView()).showNotice();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        r1 = r1.getAddressModel();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m31218c() {
        /*
            r5 = this;
            r0 = 2
            com.didi.soda.bill.model.ComponentModel r0 = r5.m31212b((int) r0)
            if (r0 != 0) goto L_0x0009
            goto L_0x0073
        L_0x0009:
            com.didi.app.nova.skeleton.mvp.IView r1 = r5.getLogicView()
            com.didi.soda.bill.component.Contract$AbsBillView r1 = (com.didi.soda.bill.component.Contract.AbsBillView) r1
            r2 = 0
            r1.setTipsContent(r2)
            com.didi.soda.bill.model.ComponentDataModel r1 = r0.getData()
            if (r1 != 0) goto L_0x001b
        L_0x0019:
            r1 = r2
            goto L_0x0026
        L_0x001b:
            com.didi.soda.bill.model.datamodel.AddressModel r1 = r1.getAddressModel()
            if (r1 != 0) goto L_0x0022
            goto L_0x0019
        L_0x0022:
            java.lang.String r1 = r1.getAid()
        L_0x0026:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 1
            if (r1 == 0) goto L_0x0034
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            if (r1 != 0) goto L_0x0073
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r1 = r5.f41554m
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = "mBillInfoEntity"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0042
        L_0x0041:
            r2 = r1
        L_0x0042:
            int r1 = r2.getAddressRecStrategy()
            if (r1 != r3) goto L_0x0073
            com.didi.soda.bill.model.ComponentDataModel r1 = r0.getData()
            if (r1 != 0) goto L_0x004f
            goto L_0x0073
        L_0x004f:
            com.didi.soda.bill.model.datamodel.AddressModel r1 = r1.getAddressModel()
            if (r1 != 0) goto L_0x0056
            goto L_0x0073
        L_0x0056:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getRecAddressEntity()
            if (r1 != 0) goto L_0x005d
            goto L_0x0073
        L_0x005d:
            java.util.ArrayList r2 = r5.getMAlertQueue()
            r3 = 300(0x12c, float:4.2E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.didi.soda.bill.component.bill.CustomerBillPresenter$checkAndShowBubble$1$1$1 r4 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$checkAndShowBubble$1$1$1
            r4.<init>(r5, r1, r0)
            kotlin.Pair r0 = kotlin.TuplesKt.m41339to(r3, r4)
            r2.add(r0)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillPresenter.m31218c():void");
    }

    /* renamed from: b */
    private final void m31217b(BillInfoEntity billInfoEntity) {
        this.f41566y = this.f41565x;
        this.f41565x = billInfoEntity.getRealPayPriceDisplay();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31204a(String str) {
        TopGunAbnormalViewModel topGunAbnormalViewModel;
        LogUtil.m32588i("CustomerBillPresenter", Intrinsics.stringPlus("showAbnormalView  ", str));
        $$Lambda$CustomerBillPresenter$wSGRNNh1C9_nweUVqhzpmOQq74 r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerBillPresenter.m31193a(CustomerBillPresenter.this, view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            topGunAbnormalViewModel = TopGunAbnormalFactory.buildNoNetwork(r0);
        } else {
            if (str == null) {
                topGunAbnormalViewModel = null;
            } else {
                topGunAbnormalViewModel = TopGunAbnormalFactory.buildHomeNoService(str, r0);
            }
            if (topGunAbnormalViewModel == null) {
                topGunAbnormalViewModel = TopGunAbnormalFactory.buildNoNetwork(r0);
            }
        }
        Intrinsics.checkNotNullExpressionValue(topGunAbnormalViewModel, "model");
        ((Contract.AbsBillView) getLogicView()).showAbnormalView(topGunAbnormalViewModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31193a(CustomerBillPresenter customerBillPresenter, View view) {
        Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
        customerBillPresenter.m31227i();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m31211a(com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 1
            if (r11 != 0) goto L_0x0005
            goto L_0x018f
        L_0x0005:
            java.lang.String r1 = r11.getContent()
            if (r1 != 0) goto L_0x000d
            goto L_0x018f
        L_0x000d:
            com.didi.soda.bill.BillOmegaHelper$Companion r2 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r3 = r10.f41542a
            java.lang.String r4 = "cartId"
            r5 = 0
            if (r3 != 0) goto L_0x001a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r5
        L_0x001a:
            java.lang.String r6 = r10.f41543b
            java.lang.String r7 = "shopId"
            if (r6 != 0) goto L_0x0025
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r6 = r5
        L_0x0025:
            int r8 = r11.getType()
            int r9 = r11.getContentType()
            r2.traceCartContentPopupSW(r3, r6, r8, r9)
            int r2 = r11.getType()
            if (r2 == r0) goto L_0x017f
            r3 = 7
            r6 = 0
            if (r2 == r3) goto L_0x017b
            r3 = 3
            java.lang.String r8 = "scopeContext.navigator"
            if (r2 == r3) goto L_0x013a
            r3 = 4
            if (r2 == r3) goto L_0x013a
            r12 = 5
            if (r2 == r12) goto L_0x0058
            com.didi.app.nova.skeleton.ScopeContext r11 = r10.getScopeContext()
            com.didi.app.nova.skeleton.INavigator r11 = r11.getNavigator()
            com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$IJe6Az0LczEmzIWBY_gPkhbmYXM r12 = new com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$IJe6Az0LczEmzIWBY_gPkhbmYXM
            r12.<init>()
            com.didi.soda.customer.foundation.util.DialogUtil.showBillErrorDialog(r11, r1, r12)
            goto L_0x018f
        L_0x0058:
            java.util.List r12 = r11.getBtnList()
            if (r12 != 0) goto L_0x0060
        L_0x005e:
            r12 = 0
            goto L_0x006a
        L_0x0060:
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            r12 = r12 ^ r0
            if (r12 != r0) goto L_0x005e
            r12 = 1
        L_0x006a:
            if (r12 == 0) goto L_0x0139
            boolean r12 = r10.f41540B
            if (r12 != 0) goto L_0x0139
            r10.f41540B = r0
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r12 = r10.f41554m
            if (r12 != 0) goto L_0x007c
            java.lang.String r12 = "mBillInfoEntity"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r12 = r5
        L_0x007c:
            java.util.List r12 = r12.getSections()
            if (r12 != 0) goto L_0x0085
        L_0x0082:
            r12 = r5
            goto L_0x00fc
        L_0x0085:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r12 = r12.iterator()
        L_0x0092:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x00a8
            java.lang.Object r2 = r12.next()
            com.didi.soda.customer.foundation.rpc.entity.bill.BillSection r2 = (com.didi.soda.customer.foundation.rpc.entity.bill.BillSection) r2
            java.util.ArrayList r2 = r2.getComponents()
            if (r2 == 0) goto L_0x0092
            r1.add(r2)
            goto L_0x0092
        L_0x00a8:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r1 = r1.iterator()
        L_0x00b7:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00c9
            java.lang.Object r2 = r1.next()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            kotlin.collections.CollectionsKt.addAll(r12, r2)
            goto L_0x00b7
        L_0x00c9:
            java.util.List r12 = (java.util.List) r12
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x00d1:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x00eb
            java.lang.Object r1 = r12.next()
            r2 = r1
            com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity r2 = (com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity) r2
            int r2 = r2.getType()
            r3 = 2
            if (r2 != r3) goto L_0x00e7
            r2 = 1
            goto L_0x00e8
        L_0x00e7:
            r2 = 0
        L_0x00e8:
            if (r2 == 0) goto L_0x00d1
            goto L_0x00ec
        L_0x00eb:
            r1 = r5
        L_0x00ec:
            com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity r1 = (com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity) r1
            if (r1 != 0) goto L_0x00f1
            goto L_0x0082
        L_0x00f1:
            com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity r12 = r1.getData()
            if (r12 != 0) goto L_0x00f8
            goto L_0x0082
        L_0x00f8:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r12 = r12.getRecAddress()
        L_0x00fc:
            if (r12 != 0) goto L_0x0100
            r12 = r5
            goto L_0x0104
        L_0x0100:
            java.lang.String r12 = r12.getAptBuildAndContact()
        L_0x0104:
            if (r12 == 0) goto L_0x0107
            goto L_0x0109
        L_0x0107:
            java.lang.String r12 = ""
        L_0x0109:
            r11.setContent(r12)
            com.didi.soda.bill.BillOmegaHelper$Companion r12 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r0 = r10.f41542a
            if (r0 != 0) goto L_0x0116
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r5
        L_0x0116:
            java.lang.String r1 = r10.f41543b
            if (r1 != 0) goto L_0x011e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L_0x011f
        L_0x011e:
            r5 = r1
        L_0x011f:
            r12.traceDeliveryConfirmSW(r0, r5)
            com.didi.soda.bill.dialog.PayCardDialogHelper$Companion r12 = com.didi.soda.bill.dialog.PayCardDialogHelper.Companion
            com.didi.app.nova.skeleton.ScopeContext r0 = r10.getScopeContext()
            com.didi.app.nova.skeleton.INavigator r0 = r0.getNavigator()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            com.didi.soda.bill.component.bill.CustomerBillPresenter$showErrorDialog$1$3 r1 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$showErrorDialog$1$3
            r1.<init>(r10)
            com.didi.soda.bill.component.Contract$IPayCardErrorListener r1 = (com.didi.soda.bill.component.Contract.IPayCardErrorListener) r1
            r12.showBillCardErrorDialog(r0, r11, r1)
        L_0x0139:
            return r6
        L_0x013a:
            java.util.List r1 = r11.getBtnList()
            if (r1 != 0) goto L_0x0142
        L_0x0140:
            r0 = 0
            goto L_0x014b
        L_0x0142:
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r0
            if (r1 != r0) goto L_0x0140
        L_0x014b:
            if (r0 == 0) goto L_0x017a
            com.didi.soda.bill.BillOmegaHelper$Companion r0 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r1 = r10.f41543b
            if (r1 != 0) goto L_0x0157
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r5
        L_0x0157:
            java.lang.String r2 = r10.f41542a
            if (r2 != 0) goto L_0x015f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0160
        L_0x015f:
            r5 = r2
        L_0x0160:
            r0.traceGuideCashDialogSW(r12, r1, r5)
            com.didi.soda.bill.dialog.PayCardDialogHelper$Companion r0 = com.didi.soda.bill.dialog.PayCardDialogHelper.Companion
            com.didi.app.nova.skeleton.ScopeContext r1 = r10.getScopeContext()
            com.didi.app.nova.skeleton.INavigator r1 = r1.getNavigator()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            com.didi.soda.bill.component.bill.CustomerBillPresenter$showErrorDialog$1$2 r2 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$showErrorDialog$1$2
            r2.<init>(r10, r12)
            com.didi.soda.bill.component.Contract$IPayCardErrorListener r2 = (com.didi.soda.bill.component.Contract.IPayCardErrorListener) r2
            r0.showBillCardErrorDialog(r1, r11, r2)
        L_0x017a:
            return r6
        L_0x017b:
            r10.m31202a((com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity) r11)
            return r6
        L_0x017f:
            com.didi.app.nova.skeleton.ScopeContext r11 = r10.getScopeContext()
            com.didi.app.nova.skeleton.INavigator r11 = r11.getNavigator()
            com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$t9LtMJXEEX-H8oirmLI-V251h1E r12 = new com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$t9LtMJXEEX-H8oirmLI-V251h1E
            r12.<init>()
            com.didi.soda.customer.foundation.util.DialogUtil.showBillErrorDialog(r11, r1, r12)
        L_0x018f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillPresenter.m31211a(com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31194a(CustomerBillPresenter customerBillPresenter, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
        rFDialog.dismiss();
        BillInfoEntity billInfoEntity = customerBillPresenter.f41554m;
        BillInfoEntity billInfoEntity2 = null;
        if (billInfoEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
            billInfoEntity = null;
        }
        customerBillPresenter.m31203a(billInfoEntity);
        BillInfoEntity billInfoEntity3 = customerBillPresenter.f41554m;
        if (billInfoEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
        } else {
            billInfoEntity2 = billInfoEntity3;
        }
        ShopInfo shopInfo = billInfoEntity2.getShopInfo();
        Intrinsics.checkNotNull(shopInfo);
        if (shopInfo.getCShopStatus() == 3) {
            ((Contract.AbsBillView) customerBillPresenter.getLogicView()).getNovaRecyclerView().scrollToPosition(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31214b(CustomerBillPresenter customerBillPresenter, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
        rFDialog.dismiss();
        customerBillPresenter.getScopeContext().getNavigator().finish();
    }

    /* renamed from: d */
    private final void m31220d() {
        ((Contract.AbsBillView) getLogicView()).setAddressData(m31212b(2));
    }

    /* renamed from: e */
    private final void m31222e() {
        ReminderModel reminderModel;
        ComponentDataModel data;
        ComponentModel b = m31212b(1);
        String str = null;
        if (b == null || (data = b.getData()) == null) {
            reminderModel = null;
        } else {
            reminderModel = data.getReminderModel();
        }
        Contract.AbsBillView absBillView = (Contract.AbsBillView) getLogicView();
        if (reminderModel != null) {
            str = reminderModel.getContent();
        }
        absBillView.anchorBeforePosition(str);
    }

    /* renamed from: f */
    private final void m31224f() {
        m31216b(m31212b(5));
    }

    /* renamed from: b */
    private final void m31216b(ComponentModel componentModel) {
        ComponentDataModel data;
        BillItemsInfoModel itemsInfoModel;
        ArrayList<BillCartItemModel> items;
        if (!this.f41558q && componentModel != null && (data = componentModel.getData()) != null && (itemsInfoModel = data.getItemsInfoModel()) != null && (items = itemsInfoModel.getItems()) != null) {
            ArrayList<BillCartItemModel> arrayList = this.f41557p;
            if (arrayList != null) {
                if (arrayList.size() != items.size()) {
                    this.f41558q = true;
                } else {
                    Iterator<BillCartItemModel> it = arrayList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        int i2 = i + 1;
                        if (!Intrinsics.areEqual((Object) it.next(), (Object) items.get(i))) {
                            this.f41558q = true;
                            return;
                        }
                        i = i2;
                    }
                }
            }
            this.f41557p = items;
        }
    }

    /* renamed from: c */
    private final void m31219c(BillInfoEntity billInfoEntity) {
        DisclaimerModel disclaimerModel = new DisclaimerModel();
        CharSequence orderDisclaimer = billInfoEntity.getOrderDisclaimer();
        if (!(orderDisclaimer == null || orderDisclaimer.length() == 0)) {
            disclaimerModel.setOrderDisclaimer(billInfoEntity.getOrderDisclaimer());
            ChildDataItemManager<DisclaimerModel> childDataItemManager = this.f41552k;
            if (childDataItemManager != null) {
                childDataItemManager.setItem(disclaimerModel);
                return;
            }
            return;
        }
        ChildDataItemManager<DisclaimerModel> childDataItemManager2 = this.f41552k;
        if (childDataItemManager2 != null) {
            childDataItemManager2.removeItem();
        }
    }

    /* renamed from: g */
    private final void m31225g() {
        m31209a(2, 4, 1, 5);
    }

    /* renamed from: a */
    private final void m31209a(int... iArr) {
        Map<Integer, ComponentModel> map;
        this.f41556o = new HashMap();
        ArrayList<SectionModel> arrayList = this.f41555n;
        if (arrayList != null) {
            Iterator<SectionModel> it = arrayList.iterator();
            while (it.hasNext()) {
                Iterator<ComponentModel> it2 = it.next().getComponents().iterator();
                while (it2.hasNext()) {
                    ComponentModel next = it2.next();
                    if (ArraysKt.contains(iArr, next.getType()) && (map = this.f41556o) != null) {
                        Integer valueOf = Integer.valueOf(next.getType());
                        Intrinsics.checkNotNullExpressionValue(next, "componentItem");
                        ComponentModel put = map.put(valueOf, next);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final ComponentModel m31212b(int i) {
        Map<Integer, ComponentModel> map = this.f41556o;
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f41551j == null) {
            ChildDataListManager<SectionModel> createChildDataListManager = createChildDataListManager();
            this.f41551j = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        if (this.f41552k == null) {
            ChildDataItemManager<DisclaimerModel> createChildDataItemManager = createChildDataItemManager();
            this.f41552k = createChildDataItemManager;
            addDataManager(createChildDataItemManager);
        }
    }

    /* renamed from: h */
    private final void m31226h() {
        String str;
        String str2;
        String str3 = null;
        m31199a(this, false, 1, (Object) null);
        AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
        ContactEntity currentContact = ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).getCurrentContact();
        ICustomerBillManager iCustomerBillManager = (ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class);
        String str4 = this.f41543b;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            str = null;
        } else {
            str = str4;
        }
        if (delieveryAddress != null) {
            str3 = delieveryAddress.aid;
        }
        String str5 = str3;
        List<? extends ItemNodeEntity> list = this.f41547f;
        int i = this.f41548g;
        ActInfoEntity actInfoEntity = this.f41549h;
        String selectedAid = getSelectedAid();
        int localPermissionState = getLocalPermissionState();
        String str6 = currentContact.phone;
        String str7 = str6 != null ? str6 : "";
        String str8 = currentContact.callingCode;
        if (str8 != null) {
            str2 = str8;
        } else {
            str2 = "";
        }
        iCustomerBillManager.fastBuy(str, str5, list, i, actInfoEntity, selectedAid, localPermissionState, str7, str2, new BillRpcCallback(0, (String) null, 2, (DefaultConstructorMarker) null));
    }

    /* renamed from: i */
    private final void m31227i() {
        if (this.f41546e == 1 && this.f41554m == null) {
            m31226h();
        } else {
            m31198a(this, false, 200, 1, (Object) null);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m31198a(CustomerBillPresenter customerBillPresenter, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        customerBillPresenter.m31208a(z, i);
    }

    /* renamed from: a */
    private final void m31208a(boolean z, int i) {
        String str;
        String str2;
        String str3;
        m31207a(z);
        LogUtil.m32588i("CustomerBillPresenter", "fetchBillData");
        AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
        ContactEntity currentContact = ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).getCurrentContact();
        ICustomerBillManager iCustomerBillManager = (ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class);
        String str4 = this.f41542a;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str = null;
        } else {
            str = str4;
        }
        if (delieveryAddress == null) {
            str2 = null;
        } else {
            str2 = delieveryAddress.aid;
        }
        String selectedAid = getSelectedAid();
        int localPermissionState = getLocalPermissionState();
        String str5 = currentContact.phone;
        String str6 = str5 != null ? str5 : "";
        String str7 = currentContact.callingCode;
        if (str7 != null) {
            str3 = str7;
        } else {
            str3 = "";
        }
        iCustomerBillManager.fetchBillInfo(str, str2, "", selectedAid, localPermissionState, i, (SceneParamsEntity) null, str6, str3, this.f41545d, new BillRpcCallback(0, (String) null, 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31205a(String str, int i, SceneParamsEntity sceneParamsEntity) {
        String str2;
        String str3 = str;
        String str4 = null;
        m31199a(this, false, 1, (Object) null);
        LogUtil.m32588i("CustomerBillPresenter", Intrinsics.stringPlus("recoverBillData orderId = ", str));
        AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
        ContactEntity currentContact = ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).getCurrentContact();
        ICustomerBillManager iCustomerBillManager = (ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class);
        String str5 = this.f41542a;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str5 = null;
        }
        if (delieveryAddress != null) {
            str4 = delieveryAddress.aid;
        }
        String selectedAid = getSelectedAid();
        int localPermissionState = getLocalPermissionState();
        String str6 = currentContact.phone;
        String str7 = str6 != null ? str6 : "";
        String str8 = currentContact.callingCode;
        if (str8 != null) {
            str2 = str8;
        } else {
            str2 = "";
        }
        iCustomerBillManager.fetchBillInfo(str5, str4, str, selectedAid, localPermissionState, i, sceneParamsEntity, str7, str2, this.f41545d, new BillRpcCallback(this, 2, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m31221d(BillInfoEntity billInfoEntity) {
        LogUtil.m32588i("CustomerBillPresenter", Intrinsics.stringPlus("syncShopStatus billInfoEntity = ", billInfoEntity));
        ShopInfo shopInfo = billInfoEntity.getShopInfo();
        if (shopInfo != null) {
            String shopId = shopInfo.getShopId();
            Intrinsics.checkNotNull(shopId);
            BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(shopId);
            if (state == null) {
                state = new BusinessState();
            }
            state.shopId = shopInfo.getShopId();
            state.shopStatus = shopInfo.getCShopStatus();
            state.shopStatusDesc = shopInfo.getCShopStatusDesc();
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m31199a(CustomerBillPresenter customerBillPresenter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        customerBillPresenter.m31207a(z);
    }

    /* renamed from: a */
    private final void m31207a(boolean z) {
        if (z) {
            DialogUtil.showBlockDialog(getScopeContext());
            DialogUtil.showLoadingDialog(getScopeContext(), false);
            return;
        }
        DialogUtil.showLoadingDialog(getScopeContext(), false, false, new CustomerBillPresenter$showLoading$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m31228j() {
        DialogUtil.hideLoadingDialog();
        DialogUtil.hideBlockDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m31223e(BillInfoEntity billInfoEntity) {
        BillComponentDataEntity data;
        AddressEntity address;
        List<BillSection> sections = billInfoEntity.getSections();
        if (sections != null) {
            for (BillSection components : sections) {
                ArrayList<BillComponentEntity> components2 = components.getComponents();
                if (components2 != null) {
                    Iterator<BillComponentEntity> it = components2.iterator();
                    while (it.hasNext()) {
                        BillComponentEntity next = it.next();
                        if (2 == next.getType() && (data = next.getData()) != null && (address = data.getAddress()) != null && address.source == 1) {
                            ContactEntity contactEntity = (ContactEntity) ((CustomerContactRepo) RepoFactory.getRepo(CustomerContactRepo.class)).getValue();
                            if (contactEntity == null || contactEntity.lastModifyFrom == 1) {
                                ContactEntity contactEntity2 = new ContactEntity();
                                contactEntity2.setName(address.firstName, address.lastName);
                                contactEntity2.phone = address.phone;
                                contactEntity2.callingCode = address.callingCode;
                                contactEntity2.countryId = address.countryId;
                                ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).setCurrentContact(contactEntity2);
                            }
                        }
                    }
                }
            }
        }
    }

    @Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillPresenter$BillRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId;", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "type", "", "orderId", "", "(Lcom/didi/soda/bill/component/bill/CustomerBillPresenter;ILjava/lang/String;)V", "billType", "getOrderId", "()Ljava/lang/String;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "time", "", "traceId", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerBillPresenter.kt */
    public final class BillRpcCallback extends CRpcCallBackWithTraceId<BillInfoEntity> {
        private final int billType;
        private final String orderId;

        public BillRpcCallback(CustomerBillPresenter customerBillPresenter, int i, String str) {
            Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
            CustomerBillPresenter.this = customerBillPresenter;
            this.orderId = str;
            this.billType = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BillRpcCallback(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(CustomerBillPresenter.this, i, (i2 & 2) != 0 ? "" : str);
        }

        public final String getOrderId() {
            return this.orderId;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r3v8, types: [kotlin.Unit] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r18, long r19, java.lang.String r21) {
            /*
                r17 = this;
                r1 = r17
                r2 = r18
                java.lang.String r3 = " , billType = "
                java.lang.String r4 = "CustomerBillPresenter"
                java.lang.String r0 = "entity"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "traceId"
                r10 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r0.m31228j()
                com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew$Companion r0 = com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew.Companion
                com.didi.soda.bill.component.bill.CustomerBillPresenter r5 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.app.nova.skeleton.ScopeContext r5 = r5.getScopeContext()
                r0.trackEndAndReportUtil(r5)
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r0.f41554m = r2
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r0 = r0.f41554m
                java.lang.String r12 = "mBillInfoEntity"
                r13 = 0
                if (r0 != 0) goto L_0x0039
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
                r0 = r13
            L_0x0039:
                java.lang.String r0 = r0.getCartId()
                if (r0 != 0) goto L_0x0040
                goto L_0x0045
            L_0x0040:
                com.didi.soda.bill.component.bill.CustomerBillPresenter r5 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r5.f41542a = r0
            L_0x0045:
                r14 = 2
                r15 = 1
                com.didi.soda.bill.component.bill.CustomerBillPresenter$BillRpcCallback$onRpcSuccess$copyFunction$1 r0 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$BillRpcCallback$onRpcSuccess$copyFunction$1     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.bill.component.bill.CustomerBillPresenter r5 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this     // Catch:{ Exception -> 0x00ca }
                r0.<init>(r5)     // Catch:{ Exception -> 0x00ca }
                r11 = r0
                kotlin.jvm.functions.Function4 r11 = (kotlin.jvm.functions.Function4) r11     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.bill.component.bill.CustomerBillPresenter r5 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r5 = r5.f41554m     // Catch:{ Exception -> 0x00ca }
                if (r5 != 0) goto L_0x005f
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)     // Catch:{ Exception -> 0x00ca }
                r5 = r13
            L_0x005f:
                r0.m31223e(r5)     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.bill.BillOmegaHelper$Companion r5 = com.didi.soda.bill.BillOmegaHelper.Companion     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this     // Catch:{ Exception -> 0x00ca }
                com.didi.app.nova.skeleton.ScopeContext r6 = r0.getScopeContext()     // Catch:{ Exception -> 0x00ca }
                java.lang.String r0 = "scopeContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this     // Catch:{ Exception -> 0x00ca }
                java.lang.String r0 = r0.f41544c     // Catch:{ Exception -> 0x00ca }
                java.lang.String r16 = "fromPage"
                if (r0 != 0) goto L_0x007f
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x00ca }
                r7 = r13
                goto L_0x0080
            L_0x007f:
                r7 = r0
            L_0x0080:
                int r0 = r1.billType     // Catch:{ Exception -> 0x00ca }
                if (r0 != r14) goto L_0x0086
                r8 = 2
                goto L_0x0087
            L_0x0086:
                r8 = 1
            L_0x0087:
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r0 = r0.f41554m     // Catch:{ Exception -> 0x00ca }
                if (r0 != 0) goto L_0x0094
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)     // Catch:{ Exception -> 0x00ca }
                r9 = r13
                goto L_0x0095
            L_0x0094:
                r9 = r0
            L_0x0095:
                r10 = r21
                r5.billPageSW(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00ca }
                com.didi.soda.customer.app.constant.Const$ABConfigName r0 = com.didi.soda.customer.app.constant.Const.ABConfigName.BILL_PAGE     // Catch:{ Exception -> 0x00ca }
                if (r0 != 0) goto L_0x00a0
                r0 = r13
                goto L_0x00a4
            L_0x00a0:
                com.didi.soda.customer.foundation.rpc.entity.ABConfigEntity r0 = r0.getConfigEntity()     // Catch:{ Exception -> 0x00ca }
            L_0x00a4:
                com.didi.soda.bill.BillOmegaHelper$Companion r5 = com.didi.soda.bill.BillOmegaHelper.Companion     // Catch:{ Exception -> 0x00ca }
                if (r0 != 0) goto L_0x00aa
                r6 = r13
                goto L_0x00ae
            L_0x00aa:
                java.lang.String r6 = r0.getName()     // Catch:{ Exception -> 0x00ca }
            L_0x00ae:
                com.didi.soda.bill.component.bill.CustomerBillPresenter r7 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this     // Catch:{ Exception -> 0x00ca }
                java.lang.String r7 = r7.f41544c     // Catch:{ Exception -> 0x00ca }
                if (r7 != 0) goto L_0x00ba
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)     // Catch:{ Exception -> 0x00ca }
                r7 = r13
            L_0x00ba:
                if (r0 != 0) goto L_0x00be
                r0 = r13
                goto L_0x00c6
            L_0x00be:
                int r0 = r0.getValue()     // Catch:{ Exception -> 0x00ca }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00ca }
            L_0x00c6:
                r5.traceExperimentSW(r6, r7, r0)     // Catch:{ Exception -> 0x00ca }
                goto L_0x0106
            L_0x00ca:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                if (r0 != 0) goto L_0x00d2
                goto L_0x0106
            L_0x00d2:
                java.lang.String r5 = "sailing_c_bill_page_sw_tracker_error"
                com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r5 = com.didi.soda.customer.foundation.tracker.error.ErrorTracker.create(r5)
                com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r5 = r5.addErrorMsg(r0)
                java.lang.String r6 = "bill"
                com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r5 = r5.addModuleName(r6)
                com.didi.soda.customer.foundation.tracker.error.ErrorTracker r5 = r5.build()
                r5.trackError()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "billPageSW crash = "
                r5.append(r6)
                r5.append(r0)
                r5.append(r3)
                int r0 = r1.billType
                r5.append(r0)
                java.lang.String r0 = r5.toString()
                com.didi.soda.customer.foundation.log.util.LogUtil.m32584d(r4, r0)
            L_0x0106:
                kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
                r0.<init>()
                com.didi.soda.customer.foundation.rpc.entity.bill.ToastEntity r5 = r18.getToast()
                java.lang.String r6 = ""
                r7 = 0
                if (r5 != 0) goto L_0x0115
                goto L_0x0168
            L_0x0115:
                java.lang.String r5 = r5.getContent()
                if (r5 != 0) goto L_0x011c
                goto L_0x0168
            L_0x011c:
                com.didi.soda.bill.component.bill.CustomerBillPresenter r8 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.soda.customer.foundation.rpc.entity.bill.ToastEntity r9 = r18.getToast()
                com.didi.soda.bill.component.bill.CustomerBillPresenter$BillRpcCallback$onRpcSuccess$3$1 r10 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$BillRpcCallback$onRpcSuccess$3$1
                r10.<init>(r0)
                kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
                com.didi.soda.customer.helper.ToastActionHelper.toastAction(r9, r10)
                com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r9 = r8.f41549h
                if (r9 != 0) goto L_0x0134
                r9 = r13
                goto L_0x0138
            L_0x0134:
                java.lang.String r9 = r9.getActId()
            L_0x0138:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                if (r9 == 0) goto L_0x0145
                int r9 = r9.length()
                if (r9 != 0) goto L_0x0143
                goto L_0x0145
            L_0x0143:
                r9 = 0
                goto L_0x0146
            L_0x0145:
                r9 = 1
            L_0x0146:
                if (r9 != 0) goto L_0x0159
                com.didi.soda.bill.BillOmegaHelper$Companion r9 = com.didi.soda.bill.BillOmegaHelper.Companion
                com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r8 = r8.f41549h
                if (r8 != 0) goto L_0x0152
                r8 = r13
                goto L_0x0156
            L_0x0152:
                java.lang.String r8 = r8.getActId()
            L_0x0156:
                r9.traceCartToastSW(r8, r5)
            L_0x0159:
                com.didi.soda.bill.BillEventToJS r5 = com.didi.soda.bill.BillEventToJS.INSTANCE
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                com.didi.soda.customer.foundation.rpc.entity.bill.ToastEntity r9 = r18.getToast()
                com.didi.soda.customer.foundation.rpc.entity.IEntity r9 = (com.didi.soda.customer.foundation.rpc.entity.IEntity) r9
                r5.triggerEvent(r14, r8, r6, r9)
            L_0x0168:
                com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r5 = r18.getAlert()
                if (r5 != 0) goto L_0x0170
                goto L_0x0222
            L_0x0170:
                java.lang.String r5 = r5.getContent()
                if (r5 != 0) goto L_0x0178
                goto L_0x0222
            L_0x0178:
                com.didi.soda.bill.component.bill.CustomerBillPresenter r8 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r0.element = r15
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "show alert content = "
                r9.append(r10)
                r9.append(r5)
                r9.append(r3)
                int r5 = r1.billType
                r9.append(r5)
                java.lang.String r5 = r9.toString()
                com.didi.soda.customer.foundation.log.util.LogUtil.m32584d(r4, r5)
                com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r5 = r18.getAlert()
                java.lang.String r9 = r17.getOrderId()
                boolean r5 = r8.m31211a((com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity) r5, (java.lang.String) r9)
                com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r9 = r18.getAlert()
                if (r9 != 0) goto L_0x01ac
                goto L_0x01d2
            L_0x01ac:
                int r9 = r9.getContentType()
                com.didi.soda.bill.BillOmegaHelper$Companion r10 = com.didi.soda.bill.BillOmegaHelper.Companion
                r10.dialogShowTracker(r9)
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r11 = "show alert contentType = "
                r10.append(r11)
                r10.append(r9)
                r10.append(r3)
                int r3 = r1.billType
                r10.append(r3)
                java.lang.String r3 = r10.toString()
                com.didi.soda.customer.foundation.log.util.LogUtil.m32584d(r4, r3)
            L_0x01d2:
                com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r3 = r18.getAlert()
                if (r3 != 0) goto L_0x01d9
                goto L_0x01f0
            L_0x01d9:
                java.lang.String r3 = r3.getContent()
                if (r3 != 0) goto L_0x01e0
                goto L_0x01f0
            L_0x01e0:
                com.didi.soda.bill.BillEventToJS r3 = com.didi.soda.bill.BillEventToJS.INSTANCE
                r4 = 3
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r9 = r18.getAlert()
                com.didi.soda.customer.foundation.rpc.entity.IEntity r9 = (com.didi.soda.customer.foundation.rpc.entity.IEntity) r9
                r3.triggerEvent(r4, r7, r6, r9)
            L_0x01f0:
                if (r5 == 0) goto L_0x0222
                com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r3 = r8.f41554m
                if (r3 != 0) goto L_0x01fc
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
                r3 = r13
            L_0x01fc:
                r8.m31221d(r3)
                java.lang.Class<com.didi.soda.manager.base.ICustomerCartManager> r3 = com.didi.soda.manager.base.ICustomerCartManager.class
                com.didi.soda.manager.base.ICustomerManager r3 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r3)
                com.didi.soda.manager.base.ICustomerCartManager r3 = (com.didi.soda.manager.base.ICustomerCartManager) r3
                com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r4 = r8.f41554m
                if (r4 != 0) goto L_0x0211
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
                r4 = r13
            L_0x0211:
                com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo r4 = r4.getShopInfo()
                if (r4 != 0) goto L_0x0218
                goto L_0x021c
            L_0x0218:
                java.lang.String r13 = r4.getShopId()
            L_0x021c:
                r3.fetchCartInfo(r13)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                r13 = r3
            L_0x0222:
                if (r13 != 0) goto L_0x0231
                com.didi.soda.bill.component.bill.CustomerBillPresenter r3 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r4 = r1
                com.didi.soda.bill.component.bill.CustomerBillPresenter$BillRpcCallback r4 = (com.didi.soda.bill.component.bill.CustomerBillPresenter.BillRpcCallback) r4
                r3.m31203a((com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity) r2)
                boolean r0 = r0.element
                r3.startAlertTask(r0)
            L_0x0231:
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.app.nova.skeleton.mvp.IView r0 = r0.getLogicView()
                com.didi.soda.bill.component.Contract$AbsBillView r0 = (com.didi.soda.bill.component.Contract.AbsBillView) r0
                r0.hideAbnormalView()
                int r0 = r1.billType
                if (r0 != r14) goto L_0x024e
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r0.f41550i = r15
                com.didi.soda.bill.BillOmegaHelper$Companion r0 = com.didi.soda.bill.BillOmegaHelper.Companion
                java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
                r0.orderRecoveryTech(r2)
            L_0x024e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillPresenter.BillRpcCallback.onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity, long, java.lang.String):void");
        }

        /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.Integer] */
        /* JADX WARNING: type inference failed for: r1v20, types: [java.lang.Integer] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onRpcFailure(com.didi.soda.customer.foundation.rpc.net.SFRpcException r8) {
            /*
                r7 = this;
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r0.m31228j()
                r0 = 1
                r1 = 0
                if (r8 == 0) goto L_0x002e
                com.didi.soda.bill.BillEventToJS r2 = com.didi.soda.bill.BillEventToJS.INSTANCE
                int r3 = r8.getCode()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r4 = r8.getMessage()
                com.didi.soda.customer.foundation.rpc.net.SFRpcResult r5 = r8.getResult()
                if (r5 != 0) goto L_0x001f
                r5 = r1
                goto L_0x0023
            L_0x001f:
                java.lang.Object r5 = r5.getData()
            L_0x0023:
                boolean r6 = r5 instanceof com.didi.soda.customer.foundation.rpc.entity.IEntity
                if (r6 == 0) goto L_0x002a
                com.didi.soda.customer.foundation.rpc.entity.IEntity r5 = (com.didi.soda.customer.foundation.rpc.entity.IEntity) r5
                goto L_0x002b
            L_0x002a:
                r5 = r1
            L_0x002b:
                r2.triggerEvent(r0, r3, r4, r5)
            L_0x002e:
                com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew$Companion r2 = com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew.Companion
                com.didi.soda.bill.component.bill.CustomerBillPresenter r3 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.app.nova.skeleton.ScopeContext r3 = r3.getScopeContext()
                r2.trackExceptionUtil(r3)
                int r2 = r7.billType
                java.lang.String r3 = ""
                if (r2 == 0) goto L_0x010d
                if (r2 == r0) goto L_0x00bb
                r4 = 2
                if (r2 == r4) goto L_0x0046
                goto L_0x0139
            L_0x0046:
                com.didi.soda.bill.BillOmegaHelper$Companion r2 = com.didi.soda.bill.BillOmegaHelper.Companion
                if (r8 != 0) goto L_0x004b
                goto L_0x0053
            L_0x004b:
                int r1 = r8.getCode()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            L_0x0053:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                if (r8 != 0) goto L_0x005a
                goto L_0x0062
            L_0x005a:
                java.lang.String r8 = r8.getMessage()
                if (r8 != 0) goto L_0x0061
                goto L_0x0062
            L_0x0061:
                r3 = r8
            L_0x0062:
                r2.trackBillInfoError(r1, r3)
                com.didi.soda.bill.component.bill.CustomerBillPresenter r8 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.app.nova.skeleton.ScopeContext r8 = r8.getScopeContext()
                com.didi.app.nova.skeleton.INavigator r8 = r8.getNavigator()
                com.didi.rfusion.widget.dialog.RFCommonDialog$Builder r1 = new com.didi.rfusion.widget.dialog.RFCommonDialog$Builder
                r1.<init>()
                r2 = 2131951953(0x7f130151, float:1.9540335E38)
                java.lang.String r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r2)
                com.didi.rfusion.widget.dialog.RFDialogBuilder r1 = r1.setTitle(r2)
                com.didi.rfusion.widget.dialog.RFCommonDialog$Builder r1 = (com.didi.rfusion.widget.dialog.RFCommonDialog.Builder) r1
                r2 = 2131952141(0x7f13020d, float:1.9540716E38)
                java.lang.String r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r2)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                com.didi.rfusion.widget.dialog.RFCommonDialog$Builder r1 = r1.setMessage(r2)
                r2 = 2131951952(0x7f130150, float:1.9540333E38)
                java.lang.String r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r2)
                com.didi.soda.bill.component.bill.CustomerBillPresenter r3 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$BillRpcCallback$Yh8waN21YIPRaqucMhqXC0Fcj6U r5 = new com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$BillRpcCallback$Yh8waN21YIPRaqucMhqXC0Fcj6U
                r5.<init>()
                com.didi.rfusion.widget.dialog.RFDialogBuilder r1 = r1.setMainAction(r2, r5)
                com.didi.rfusion.widget.dialog.RFCommonDialog$Builder r1 = (com.didi.rfusion.widget.dialog.RFCommonDialog.Builder) r1
                com.didi.rfusion.widget.dialog.RFDialog r1 = r1.create()
                com.didi.app.nova.skeleton.dialog.Dialog r1 = (com.didi.app.nova.skeleton.dialog.Dialog) r1
                com.didi.soda.customer.widget.dialog.SodaWindowFactory.showDialog((com.didi.app.nova.skeleton.INavigator) r8, (com.didi.app.nova.skeleton.dialog.Dialog) r1)
                com.didi.soda.bill.BillOmegaHelper$Companion r8 = com.didi.soda.bill.BillOmegaHelper.Companion
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
                r8.orderRecoveryTech(r1)
                com.didi.soda.bill.component.bill.CustomerBillPresenter r8 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                r8.f41550i = r0
                goto L_0x0139
            L_0x00bb:
                com.didi.soda.bill.BillOmegaHelper$Companion r2 = com.didi.soda.bill.BillOmegaHelper.Companion
                if (r8 != 0) goto L_0x00c0
                goto L_0x00c8
            L_0x00c0:
                int r1 = r8.getCode()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            L_0x00c8:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                if (r8 != 0) goto L_0x00cf
                goto L_0x00d7
            L_0x00cf:
                java.lang.String r4 = r8.getMessage()
                if (r4 != 0) goto L_0x00d6
                goto L_0x00d7
            L_0x00d6:
                r3 = r4
            L_0x00d7:
                r2.trackBillUpdateError(r1, r3)
                r1 = 0
                if (r8 != 0) goto L_0x00df
            L_0x00dd:
                r0 = 0
                goto L_0x00e6
            L_0x00df:
                int r2 = r8.getCode()
                r3 = -1
                if (r2 != r3) goto L_0x00dd
            L_0x00e6:
                if (r0 == 0) goto L_0x0109
                java.lang.String r8 = r8.getMessage()
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                android.content.Context r0 = r0.getContext()
                boolean r0 = com.didi.soda.customer.foundation.util.NetWorkUtils.isNetworkConnected(r0)
                if (r0 != 0) goto L_0x00ff
                r8 = 2131954314(0x7f130a8a, float:1.9545124E38)
                java.lang.String r8 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r8)
            L_0x00ff:
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                com.didi.app.nova.skeleton.ScopeContext r0 = r0.getScopeContext()
                com.didi.soda.customer.foundation.util.ToastUtil.showCustomerErrorToast(r0, r8)
                goto L_0x0139
            L_0x0109:
                super.onRpcFailure(r8)
                goto L_0x0139
            L_0x010d:
                com.didi.soda.bill.BillOmegaHelper$Companion r0 = com.didi.soda.bill.BillOmegaHelper.Companion
                if (r8 != 0) goto L_0x0113
                r2 = r1
                goto L_0x011b
            L_0x0113:
                int r2 = r8.getCode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            L_0x011b:
                java.lang.String r2 = java.lang.String.valueOf(r2)
                if (r8 != 0) goto L_0x0122
                goto L_0x012a
            L_0x0122:
                java.lang.String r4 = r8.getMessage()
                if (r4 != 0) goto L_0x0129
                goto L_0x012a
            L_0x0129:
                r3 = r4
            L_0x012a:
                r0.trackBillInfoError(r2, r3)
                com.didi.soda.bill.component.bill.CustomerBillPresenter r0 = com.didi.soda.bill.component.bill.CustomerBillPresenter.this
                if (r8 != 0) goto L_0x0132
                goto L_0x0136
            L_0x0132:
                java.lang.String r1 = r8.getMessage()
            L_0x0136:
                r0.m31204a((java.lang.String) r1)
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillPresenter.BillRpcCallback.onRpcFailure(com.didi.soda.customer.foundation.rpc.net.SFRpcException):void");
        }

        /* access modifiers changed from: private */
        /* renamed from: onRpcFailure$lambda-7  reason: not valid java name */
        public static final void m47246onRpcFailure$lambda7(CustomerBillPresenter customerBillPresenter, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
            rFDialog.dismiss();
            customerBillPresenter.getScopeContext().getNavigator().finish();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        if (((r9 == null || (r9 = r9.getAddressModel()) == null) ? null : r9.getRecAddressEntity()) != null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00df, code lost:
        if (com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r2) != false) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startAlertTask(boolean r9) {
        /*
            r8 = this;
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r0 = r8.f41554m
            java.lang.String r1 = "mBillInfoEntity"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            com.didi.soda.customer.foundation.rpc.entity.bill.IsValidationEntity r0 = r0.isValidation()
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x0014
            goto L_0x004a
        L_0x0014:
            int r0 = r0.isShowCpfValidation()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5 = r0
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 != r4) goto L_0x0027
            r5 = 1
            goto L_0x0028
        L_0x0027:
            r5 = 0
        L_0x0028:
            if (r5 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r2
        L_0x002c:
            if (r0 != 0) goto L_0x002f
            goto L_0x004a
        L_0x002f:
            java.lang.Number r0 = (java.lang.Number) r0
            r0.intValue()
            java.util.ArrayList r0 = r8.getMAlertQueue()
            r5 = 100
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.didi.soda.bill.component.bill.CustomerBillPresenter$startAlertTask$2$1 r6 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$startAlertTask$2$1
            r6.<init>(r8)
            kotlin.Pair r5 = kotlin.TuplesKt.m41339to(r5, r6)
            r0.add(r5)
        L_0x004a:
            r0 = 2
            com.didi.soda.bill.model.ComponentModel r5 = r8.m31212b((int) r0)
            if (r5 != 0) goto L_0x0053
            goto L_0x010a
        L_0x0053:
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r6 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r6 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r6)
            com.didi.soda.manager.base.ICustomerBillManager r6 = (com.didi.soda.manager.base.ICustomerBillManager) r6
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r6 = r6.getCurrentContact()
            boolean r7 = r8.f41539A
            if (r7 != 0) goto L_0x010a
            if (r9 != 0) goto L_0x010a
            com.didi.soda.bill.model.ComponentDataModel r9 = r5.getData()
            if (r9 != 0) goto L_0x006d
        L_0x006b:
            r9 = r2
            goto L_0x0078
        L_0x006d:
            com.didi.soda.bill.model.datamodel.AddressModel r9 = r9.getAddressModel()
            if (r9 != 0) goto L_0x0074
            goto L_0x006b
        L_0x0074:
            java.lang.String r9 = r9.getAid()
        L_0x0078:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0085
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r9 = 0
            goto L_0x0086
        L_0x0085:
            r9 = 1
        L_0x0086:
            r7 = 200(0xc8, float:2.8E-43)
            if (r9 != 0) goto L_0x00f6
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r9 = r8.f41554m
            if (r9 != 0) goto L_0x0092
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r9 = r2
        L_0x0092:
            int r9 = r9.getAddressRecStrategy()
            if (r9 != r0) goto L_0x00ae
            com.didi.soda.bill.model.ComponentDataModel r9 = r5.getData()
            if (r9 != 0) goto L_0x00a0
        L_0x009e:
            r9 = r2
            goto L_0x00ab
        L_0x00a0:
            com.didi.soda.bill.model.datamodel.AddressModel r9 = r9.getAddressModel()
            if (r9 != 0) goto L_0x00a7
            goto L_0x009e
        L_0x00a7:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r9 = r9.getRecAddressEntity()
        L_0x00ab:
            if (r9 == 0) goto L_0x00ae
            goto L_0x00f6
        L_0x00ae:
            com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r9 = r8.f41554m
            if (r9 != 0) goto L_0x00b6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r9 = r2
        L_0x00b6:
            com.didi.soda.customer.foundation.rpc.entity.bill.IsValidationEntity r9 = r9.isValidation()
            if (r9 != 0) goto L_0x00bd
            goto L_0x00c4
        L_0x00bd:
            int r9 = r9.getFullNameSwitch()
            if (r9 != 0) goto L_0x00c4
            r3 = 1
        L_0x00c4:
            if (r3 != 0) goto L_0x010a
            if (r6 != 0) goto L_0x00ca
            r9 = r2
            goto L_0x00ce
        L_0x00ca:
            java.lang.String r9 = r6.getFirstName()
        L_0x00ce:
            boolean r9 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r9)
            if (r9 != 0) goto L_0x00e1
            if (r6 != 0) goto L_0x00d7
            goto L_0x00db
        L_0x00d7:
            java.lang.String r2 = r6.getLastName()
        L_0x00db:
            boolean r9 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r2)
            if (r9 == 0) goto L_0x010a
        L_0x00e1:
            java.util.ArrayList r9 = r8.getMAlertQueue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            com.didi.soda.bill.component.bill.CustomerBillPresenter$startAlertTask$3$2 r1 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$startAlertTask$3$2
            r1.<init>(r8, r5)
            kotlin.Pair r0 = kotlin.TuplesKt.m41339to(r0, r1)
            r9.add(r0)
            goto L_0x010a
        L_0x00f6:
            java.util.ArrayList r9 = r8.getMAlertQueue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            com.didi.soda.bill.component.bill.CustomerBillPresenter$startAlertTask$3$1 r1 = new com.didi.soda.bill.component.bill.CustomerBillPresenter$startAlertTask$3$1
            r1.<init>(r8, r5)
            kotlin.Pair r0 = kotlin.TuplesKt.m41339to(r0, r1)
            r9.add(r0)
        L_0x010a:
            java.util.ArrayList<kotlin.Pair<java.lang.Integer, kotlin.jvm.functions.Function0<kotlin.Unit>>> r9 = r8.f41541C
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r4
            if (r9 == 0) goto L_0x0130
            java.lang.Class<com.didi.soda.bill.repo.BillAlertRepo> r9 = com.didi.soda.bill.repo.BillAlertRepo.class
            com.didi.app.nova.skeleton.repo.Repo r9 = com.didi.soda.customer.repo.RepoFactory.getRepo(r9)
            com.didi.soda.bill.repo.BillAlertRepo r9 = (com.didi.soda.bill.repo.BillAlertRepo) r9
            com.didi.app.nova.skeleton.ScopeContext r0 = r8.getScopeContext()
            com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$pQl2r26nJZm6rkCBxcTkEz9RE-8 r1 = new com.didi.soda.bill.component.bill.-$$Lambda$CustomerBillPresenter$pQl2r26nJZm6rkCBxcTkEz9RE-8
            r1.<init>()
            com.didi.app.nova.skeleton.repo.Action r1 = (com.didi.app.nova.skeleton.repo.Action) r1
            r9.shutViscidityNoticeSubscribe(r0, r1)
            com.didi.soda.bill.repo.BillAlertRepo$Companion r9 = com.didi.soda.bill.repo.BillAlertRepo.Companion
            r9.notifyDataChange(r4)
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillPresenter.startAlertTask(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31197a(CustomerBillPresenter customerBillPresenter, Boolean bool) {
        Intrinsics.checkNotNullParameter(customerBillPresenter, "this$0");
        if (!customerBillPresenter.getMAlertQueue().isEmpty()) {
            List mAlertQueue = customerBillPresenter.getMAlertQueue();
            if (mAlertQueue.size() > 1) {
                CollectionsKt.sortWith(mAlertQueue, new CustomerBillPresenter$startAlertTask$lambda38$$inlined$sortBy$1());
            }
            ((Function0) customerBillPresenter.getMAlertQueue().remove(0).getSecond()).invoke();
        }
    }

    public final String getItemListForTracker(List<BillSection> list) {
        BillCartItemsInfo itemsInfo;
        if (list == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (BillSection components : list) {
            ArrayList<BillComponentEntity> components2 = components.getComponents();
            if (components2 != null) {
                arrayList.add(components2);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (ArrayList addAll : (List) arrayList) {
            CollectionsKt.addAll(arrayList2, addAll);
        }
        Collection arrayList3 = new ArrayList();
        for (Object next : (List) arrayList2) {
            if (((BillComponentEntity) next).getType() == 5) {
                arrayList3.add(next);
            }
        }
        Collection arrayList4 = new ArrayList();
        for (BillComponentEntity data : (List) arrayList3) {
            BillComponentDataEntity data2 = data.getData();
            ArrayList<CartItemEntity> items = (data2 == null || (itemsInfo = data2.getItemsInfo()) == null) ? null : itemsInfo.getItems();
            if (items != null) {
                arrayList4.add(items);
            }
        }
        Collection arrayList5 = new ArrayList();
        for (ArrayList addAll2 : (List) arrayList4) {
            CollectionsKt.addAll(arrayList5, addAll2);
        }
        return CollectionsKt.joinToString$default((List) arrayList5, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, CustomerBillPresenter$getItemListForTracker$6.INSTANCE, 30, (Object) null);
    }

    public final String getSelectedAid() {
        return ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getSelectedAid();
    }

    public final int getLocalPermissionState() {
        Context context = getContext();
        if (context != null) {
            return LocationUtil.hasLocationPermission((Activity) context) ? 1 : 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* renamed from: a */
    private final void m31202a(AlertEntity alertEntity) {
        BillComponentEntity billComponentEntity;
        PayChannelEntity payChannelEntity;
        BillComponentDataEntity data;
        Object obj;
        boolean z;
        BillInfoEntity billInfoEntity = this.f41554m;
        String str = null;
        if (billInfoEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
            billInfoEntity = null;
        }
        List<BillSection> sections = billInfoEntity.getSections();
        if (sections == null) {
            billComponentEntity = null;
        } else {
            Collection arrayList = new ArrayList();
            for (BillSection components : sections) {
                ArrayList<BillComponentEntity> components2 = components.getComponents();
                if (components2 != null) {
                    arrayList.add(components2);
                }
            }
            Collection arrayList2 = new ArrayList();
            for (ArrayList addAll : (List) arrayList) {
                CollectionsKt.addAll(arrayList2, addAll);
            }
            Iterator it = ((List) arrayList2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((BillComponentEntity) obj).getType() == 4) {
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
            billComponentEntity = (BillComponentEntity) obj;
        }
        if (billComponentEntity == null || (data = billComponentEntity.getData()) == null) {
            payChannelEntity = null;
        } else {
            payChannelEntity = data.getPayChannel();
        }
        PayErrorGuideDialogHelper payErrorGuideDialogHelper = this.f41560s;
        String str2 = this.f41542a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str2 = null;
        }
        payErrorGuideDialogHelper.setCartId(str2);
        PayErrorGuideDialogHelper payErrorGuideDialogHelper2 = this.f41560s;
        String str3 = this.f41543b;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
        } else {
            str = str3;
        }
        payErrorGuideDialogHelper2.setShopId(str);
        if (alertEntity != null) {
            PayErrorGuideDialogHelper payErrorGuideDialogHelper3 = this.f41560s;
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            payErrorGuideDialogHelper3.showPayFailGuideView(scopeContext, alertEntity, new CustomerBillPresenter$showPayErrorDialog$1$1(this, payChannelEntity), new CustomerBillPresenter$showPayErrorDialog$1$2(this, billComponentEntity, payChannelEntity));
        }
    }
}
