package com.didi.payment.pix.transfer.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel0;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p130ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.p130ui.event.BackStackEvent;
import com.didi.payment.commonsdk.p130ui.helper.NFloatInputHelper;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.didi.payment.pix.transfer.p142vm.model.AmountEditVM;
import com.didi.payment.pix.transfer.p142vm.model.BankAccountMetaData;
import com.didi.payment.pix.utils.ViewExtsKt;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.pay99.diff_base.base.ITransferAmountTip;
import com.taxis99.R;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Ê\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002Ê\u0001B\u0005¢\u0006\u0002\u0010\u0003J1\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002062\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002JQ\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002062\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u0001062\t\u0010\u0001\u001a\u0004\u0018\u0001062\b\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u000206H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020FH\u0016J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0005H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u001e\u0010 \u0001\u001a\u00030\u00012\u0007\u0010¡\u0001\u001a\u0002062\t\u0010¢\u0001\u001a\u0004\u0018\u00010SH\u0002J<\u0010£\u0001\u001a\u00030\u00012\u0007\u0010¤\u0001\u001a\u00020p2\b\u0010¥\u0001\u001a\u00030\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000206H\u0002JF\u0010¨\u0001\u001a\u00030\u00012\u0007\u0010¤\u0001\u001a\u00020p2\b\u0010¥\u0001\u001a\u00030\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002062\b\u0010\u0001\u001a\u00030\u0001H\u0002J(\u0010©\u0001\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\u00052\u0007\u0010«\u0001\u001a\u00020\u00052\n\u0010¬\u0001\u001a\u0005\u0018\u00010­\u0001H\u0016J\t\u0010®\u0001\u001a\u00020pH\u0016J\u0016\u0010¯\u0001\u001a\u00030\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\n\u0010²\u0001\u001a\u00030\u0001H\u0016J\n\u0010³\u0001\u001a\u00030\u0001H\u0016J\t\u0010´\u0001\u001a\u00020\u0005H\u0016J\n\u0010µ\u0001\u001a\u00030\u0001H\u0016J\u001f\u0010¶\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020F2\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\n\u0010·\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010¸\u0001\u001a\u00030\u00012\u0007\u0010¹\u0001\u001a\u00020pH\u0002J\u0011\u0010º\u0001\u001a\u00030\u00012\u0007\u0010»\u0001\u001a\u00020\u0005J\n\u0010¼\u0001\u001a\u00030\u0001H\u0002JM\u0010½\u0001\u001a\u00030\u00012\u0007\u0010¾\u0001\u001a\u00020\"2\u0007\u0010¿\u0001\u001a\u00020p2\t\u0010À\u0001\u001a\u0004\u0018\u0001062\u0011\u0010Á\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010Â\u00012\u0011\u0010Ã\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010Â\u0001H\u0002J\u0011\u0010Ä\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020FJ \u0010Å\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u0001062\t\u0010\u0001\u001a\u0004\u0018\u000106H\u0002J\u001c\u0010Æ\u0001\u001a\u00030\u00012\u0007\u0010Ç\u0001\u001a\u0002062\u0007\u0010È\u0001\u001a\u000206H\u0002J\n\u0010É\u0001\u001a\u00030\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&R\u001a\u0010<\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001a\u0010E\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010H\"\u0004\bO\u0010JR\u000e\u0010P\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020FX.¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\"X.¢\u0006\u0002\n\u0000R*\u0010X\u001a\u001e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020Z0Yj\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020Z`[X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010$\"\u0004\b^\u0010&R\u001a\u0010_\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010$\"\u0004\ba\u0010&R\u001a\u0010b\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010$\"\u0004\bd\u0010&R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\t\"\u0004\bn\u0010\u000bR\u001a\u0010o\u001a\u00020pX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\t\"\u0004\bw\u0010\u000bR\u001a\u0010x\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010H\"\u0004\bz\u0010JR\u001a\u0010{\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\t\"\u0004\b}\u0010\u000bR\u001b\u0010~\u001a\u00020\"X.¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010$\"\u0005\b\u0001\u0010&R#\u0010\u0001\u001a\u0005\u0018\u00010\u00018BX\u0002¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001¨\u0006Ë\u0001"}, mo148868d2 = {"Lcom/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/pix/transfer/vm/model/AmountEditVM;", "()V", "EDIT_MODE_NORMAL", "", "EDIT_MODE_UNMODIFIED", "MAX_EXTRA_INPUT_LENGTH", "getMAX_EXTRA_INPUT_LENGTH", "()I", "setMAX_EXTRA_INPUT_LENGTH", "(I)V", "MODE_BANKMETA", "getMODE_BANKMETA", "setMODE_BANKMETA", "MODE_PIXACOUNT", "getMODE_PIXACOUNT", "setMODE_PIXACOUNT", "MODE_QRCODE", "getMODE_QRCODE", "setMODE_QRCODE", "NFloatParser", "Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "getNFloatParser", "()Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "setNFloatParser", "(Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;)V", "amountInputEt", "Landroidx/appcompat/widget/AppCompatEditText;", "getAmountInputEt", "()Landroidx/appcompat/widget/AppCompatEditText;", "setAmountInputEt", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "balanceTv", "Landroid/widget/TextView;", "getBalanceTv", "()Landroid/widget/TextView;", "setBalanceTv", "(Landroid/widget/TextView;)V", "bankAccountMeta", "Lcom/didi/payment/pix/transfer/vm/model/BankAccountMetaData;", "blockDialog", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "getBlockDialog", "()Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "setBlockDialog", "(Lcom/didi/global/globaluikit/drawer/LEGODrawer;)V", "btnLoadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "getBtnLoadingView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setBtnLoadingView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "cpfNo", "", "defaultTextWatcher", "Landroid/text/TextWatcher;", "exceedTv", "getExceedTv", "setExceedTv", "extraInfoEt", "getExtraInfoEt", "setExtraInfoEt", "headIconImg", "Landroid/widget/ImageView;", "headIconTv", "inputLeftTv", "getInputLeftTv", "setInputLeftTv", "mBottomBtn", "Landroid/view/View;", "getMBottomBtn", "()Landroid/view/View;", "setMBottomBtn", "(Landroid/view/View;)V", "mConfirmDrawer", "Lcom/didi/global/globalgenerickit/drawer/GGKDrawer;", "mEditContentVp", "getMEditContentVp", "setMEditContentVp", "mEditMode", "mPayeeHeadView", "mTransferOption", "Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "mUnableAmountBtn", "mUnableAmountContainer", "Landroid/widget/RelativeLayout;", "mUnableAmountLabel", "omegaPageParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "payButton", "getPayButton", "setPayButton", "paymentToDescTv", "getPaymentToDescTv", "setPaymentToDescTv", "paymentToTv", "getPaymentToTv", "setPaymentToTv", "pixAccount", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixAccount;", "pixAccountFromQR", "pixAmountSourcePage", "pixPayeeKey", "pixQRCodeData", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "productId", "getProductId", "setProductId", "refreshFromTopup", "", "getRefreshFromTopup", "()Z", "setRefreshFromTopup", "(Z)V", "textColorNormal", "getTextColorNormal", "setTextColorNormal", "titlebar", "getTitlebar", "setTitlebar", "tradeType", "getTradeType", "setTradeType", "tvCurrency", "getTvCurrency", "setTvCurrency", "warnMsg", "Lcom/pay99/diff_base/base/ITransferAmountTip;", "getWarnMsg", "()Lcom/pay99/diff_base/base/ITransferAmountTip;", "warnMsg$delegate", "Lkotlin/Lazy;", "checkNightAndMaxAvailableLimit", "", "value", "", "nightLimit", "nightLimitEffectiveTime", "maxAvailable", "checkSingleLimit", "limit", "checkValue", "riskLimitQuota", "description", "link", "gotoTopupBalance", "handleValueForSecurity", "origin", "initAmountEditText", "initCommonTitlebar", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "initPayeeHeader", "mode", "initViewModels", "invalidatePayButton", "userInput", "transferOption", "limitNewCheck", "isSameCpf", "centsValue", "vo", "Lcom/didi/payment/wallet/global/model/resp/GetNightlyLimitResp$NightlyLimitVo;", "limitOldCheck", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackKeyPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onInflateLayout", "onResume", "onViewCreated", "parserARguments", "payButtonLoading", "loading", "refreshPageUIVisibility", "visibility", "refreshUI", "setOutOfLimitInfo", "textView", "clickable", "text", "listener", "Lkotlin/Function0;", "omegaAction", "setParentLayout", "showLimitInfoCommon", "showUnableDialogView", "title", "confirmBtn", "trackReturn", "Companion", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
public final class PixTransferAmountEditFragment extends AbsWBaseFragment<AmountEditVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE_NEW_CASHIER = 200;

    /* renamed from: A */
    private String f33768A;

    /* renamed from: B */
    private String f33769B;

    /* renamed from: C */
    private final Lazy f33770C = LazyKt.lazy(PixTransferAmountEditFragment$warnMsg$2.INSTANCE);

    /* renamed from: D */
    private View f33771D;

    /* renamed from: E */
    private TextWatcher f33772E = new PixTransferAmountEditFragment$defaultTextWatcher$1(this);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap<String, Object> f33773a = new HashMap<>();
    public AppCompatEditText amountInputEt;

    /* renamed from: b */
    private String f33774b;
    public TextView balanceTv;
    public LottieAnimationView btnLoadingView;

    /* renamed from: c */
    private TextView f33775c;

    /* renamed from: d */
    private ImageView f33776d;

    /* renamed from: e */
    private RelativeLayout f33777e;
    public TextView exceedTv;
    public AppCompatEditText extraInfoEt;

    /* renamed from: f */
    private TextView f33778f;

    /* renamed from: g */
    private TextView f33779g;

    /* renamed from: h */
    private GGKDrawer f33780h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PixTransferOption.TransferOptionInfo f33781i;
    public TextView inputLeftTv;

    /* renamed from: j */
    private int f33782j = -16777216;

    /* renamed from: k */
    private boolean f33783k;

    /* renamed from: l */
    private int f33784l = 140;

    /* renamed from: m */
    private NFloatInputHelper f33785m = new NFloatInputHelper();
    public View mBottomBtn;
    public View mEditContentVp;

    /* renamed from: n */
    private int f33786n;

    /* renamed from: o */
    private int f33787o;

    /* renamed from: p */
    private LEGODrawer f33788p;
    public TextView payButton;
    public TextView paymentToDescTv;
    public TextView paymentToTv;

    /* renamed from: q */
    private int f33789q = 1;

    /* renamed from: r */
    private int f33790r = 2;

    /* renamed from: s */
    private int f33791s = 3;

    /* renamed from: t */
    private int f33792t;
    public View titlebar;
    public TextView tvCurrency;

    /* renamed from: u */
    private int f33793u = 1;

    /* renamed from: v */
    private int f33794v = this.f33792t;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public BankAccountMetaData f33795w;

    /* renamed from: x */
    private PixKeyVerifyResp.PixAccount f33796x;

    /* renamed from: y */
    private PixKeyVerifyResp.PixAccount f33797y;

    /* renamed from: z */
    private PixQrCodeQueryResp.QRCodeData f33798z;

    /* renamed from: a */
    private final boolean m25668a(long j, long j2) {
        return j2 < 0 || j <= j2;
    }

    public int onInflateLayout() {
        return R.layout.fragment_transfer_amount_edit;
    }

    public final void refreshPageUIVisibility(int i) {
    }

    public static final /* synthetic */ AmountEditVM access$getVm(PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        return (AmountEditVM) pixTransferAmountEditFragment.getVm();
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment$Companion;", "", "()V", "REQUEST_CODE_NEW_CASHIER", "", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixTransferAmountEditFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final TextView getExceedTv() {
        TextView textView = this.exceedTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("exceedTv");
        return null;
    }

    public final void setExceedTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.exceedTv = textView;
    }

    public final View getTitlebar() {
        View view = this.titlebar;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titlebar");
        return null;
    }

    public final void setTitlebar(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.titlebar = view;
    }

    public final TextView getPaymentToTv() {
        TextView textView = this.paymentToTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentToTv");
        return null;
    }

    public final void setPaymentToTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.paymentToTv = textView;
    }

    public final TextView getPaymentToDescTv() {
        TextView textView = this.paymentToDescTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentToDescTv");
        return null;
    }

    public final void setPaymentToDescTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.paymentToDescTv = textView;
    }

    public final TextView getBalanceTv() {
        TextView textView = this.balanceTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("balanceTv");
        return null;
    }

    public final void setBalanceTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.balanceTv = textView;
    }

    public final TextView getInputLeftTv() {
        TextView textView = this.inputLeftTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputLeftTv");
        return null;
    }

    public final void setInputLeftTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.inputLeftTv = textView;
    }

    public final TextView getTvCurrency() {
        TextView textView = this.tvCurrency;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvCurrency");
        return null;
    }

    public final void setTvCurrency(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvCurrency = textView;
    }

    public final AppCompatEditText getAmountInputEt() {
        AppCompatEditText appCompatEditText = this.amountInputEt;
        if (appCompatEditText != null) {
            return appCompatEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("amountInputEt");
        return null;
    }

    public final void setAmountInputEt(AppCompatEditText appCompatEditText) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "<set-?>");
        this.amountInputEt = appCompatEditText;
    }

    public final AppCompatEditText getExtraInfoEt() {
        AppCompatEditText appCompatEditText = this.extraInfoEt;
        if (appCompatEditText != null) {
            return appCompatEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoEt");
        return null;
    }

    public final void setExtraInfoEt(AppCompatEditText appCompatEditText) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "<set-?>");
        this.extraInfoEt = appCompatEditText;
    }

    public final TextView getPayButton() {
        TextView textView = this.payButton;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payButton");
        return null;
    }

    public final void setPayButton(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.payButton = textView;
    }

    public final LottieAnimationView getBtnLoadingView() {
        LottieAnimationView lottieAnimationView = this.btnLoadingView;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnLoadingView");
        return null;
    }

    public final void setBtnLoadingView(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.btnLoadingView = lottieAnimationView;
    }

    public final int getTextColorNormal() {
        return this.f33782j;
    }

    public final void setTextColorNormal(int i) {
        this.f33782j = i;
    }

    public final boolean getRefreshFromTopup() {
        return this.f33783k;
    }

    public final void setRefreshFromTopup(boolean z) {
        this.f33783k = z;
    }

    public final int getMAX_EXTRA_INPUT_LENGTH() {
        return this.f33784l;
    }

    public final void setMAX_EXTRA_INPUT_LENGTH(int i) {
        this.f33784l = i;
    }

    public final NFloatInputHelper getNFloatParser() {
        return this.f33785m;
    }

    public final void setNFloatParser(NFloatInputHelper nFloatInputHelper) {
        Intrinsics.checkNotNullParameter(nFloatInputHelper, "<set-?>");
        this.f33785m = nFloatInputHelper;
    }

    public final int getProductId() {
        return this.f33786n;
    }

    public final void setProductId(int i) {
        this.f33786n = i;
    }

    public final int getTradeType() {
        return this.f33787o;
    }

    public final void setTradeType(int i) {
        this.f33787o = i;
    }

    public final LEGODrawer getBlockDialog() {
        return this.f33788p;
    }

    public final void setBlockDialog(LEGODrawer lEGODrawer) {
        this.f33788p = lEGODrawer;
    }

    public final int getMODE_BANKMETA() {
        return this.f33789q;
    }

    public final void setMODE_BANKMETA(int i) {
        this.f33789q = i;
    }

    public final int getMODE_PIXACOUNT() {
        return this.f33790r;
    }

    public final void setMODE_PIXACOUNT(int i) {
        this.f33790r = i;
    }

    public final int getMODE_QRCODE() {
        return this.f33791s;
    }

    public final void setMODE_QRCODE(int i) {
        this.f33791s = i;
    }

    /* renamed from: a */
    private final ITransferAmountTip m25647a() {
        return (ITransferAmountTip) this.f33770C.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m25670b();
    }

    /* renamed from: b */
    private final void m25670b() {
        Integer amount;
        Serializable serializable;
        String str;
        Serializable serializable2;
        String str2;
        Serializable serializable3;
        String str3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            Float f = null;
            if (arguments.containsKey("bank_metadata") && (serializable3 = arguments.getSerializable("bank_metadata")) != null) {
                BankAccountMetaData bankAccountMetaData = (BankAccountMetaData) serializable3;
                this.f33795w = bankAccountMetaData;
                if (bankAccountMetaData == null) {
                    str3 = null;
                } else {
                    str3 = bankAccountMetaData.getCpf();
                }
                this.f33769B = str3;
            }
            if (arguments.containsKey("pix_account") && (serializable2 = arguments.getSerializable("pix_account")) != null) {
                PixKeyVerifyResp.PixAccount pixAccount = (PixKeyVerifyResp.PixAccount) serializable2;
                this.f33796x = pixAccount;
                if (pixAccount == null) {
                    str2 = null;
                } else {
                    str2 = pixAccount.getKey();
                }
                this.f33768A = str2;
                PixKeyVerifyResp.PixAccount pixAccount2 = this.f33796x;
                this.f33769B = pixAccount2 == null ? null : pixAccount2.getCpf();
            }
            if (arguments.containsKey("detected_qrcode") && (serializable = arguments.getSerializable("detected_qrcode")) != null) {
                PixQrCodeQueryResp.QRCodeData qRCodeData = (PixQrCodeQueryResp.QRCodeData) serializable;
                this.f33798z = qRCodeData;
                if (qRCodeData == null) {
                    str = null;
                } else {
                    str = qRCodeData.getKey();
                }
                this.f33768A = str;
            }
            this.f33773a.put("pix_payee_key", String.valueOf(this.f33768A));
            this.f33773a.put("cpf_number", String.valueOf(this.f33769B));
            String string = arguments.getString("source_page");
            this.f33774b = string;
            this.f33773a.put("pix_amount_source_page", String.valueOf(string));
            PixQrCodeQueryResp.QRCodeData qRCodeData2 = this.f33798z;
            if (!(qRCodeData2 == null || (amount = qRCodeData2.getAmount()) == null)) {
                f = Float.valueOf((float) amount.intValue());
            }
            this.f33773a.put("pre_filled_amount", Integer.valueOf(f != null ? 1 : 0));
        }
    }

    public void initViewModels() {
        String key;
        ViewModel viewModel = new ViewModelProvider(this).get(AmountEditVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…AmountEditVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        ((AmountEditVM) getVm()).getTransferOption().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25658a(PixTransferAmountEditFragment.this, (PixTransferOption.TransferOptionInfo) obj);
            }
        });
        ((AmountEditVM) getVm()).getErrCreateOrder().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25655a(PixTransferAmountEditFragment.this, (WBaseResp) obj);
            }
        });
        ((AmountEditVM) getVm()).getNightlyLimitVo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25659a(PixTransferAmountEditFragment.this, (GetNightlyLimitResp.NightlyLimitVo) obj);
            }
        });
        ((AmountEditVM) getVm()).getPwdData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25660a(PixTransferAmountEditFragment.this, (PasswordDataVo) obj);
            }
        });
        ((AmountEditVM) getVm()).getOrderDetailLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25657a(PixTransferAmountEditFragment.this, (PixOrderDetailResp.OrderDetail) obj);
            }
        });
        ((AmountEditVM) getVm()).getOrderDetailLooping().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25661a(PixTransferAmountEditFragment.this, (Boolean) obj);
            }
        });
        ((AmountEditVM) getVm()).getTransferOption().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25672b(PixTransferAmountEditFragment.this, (PixTransferOption.TransferOptionInfo) obj);
            }
        });
        ((AmountEditVM) getVm()).getPixAccountQueryByQr().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25656a(PixTransferAmountEditFragment.this, (PixKeyVerifyResp.PixAccount) obj);
            }
        });
        PixQrCodeQueryResp.QRCodeData qRCodeData = this.f33798z;
        if (!(qRCodeData == null || (key = qRCodeData.getKey()) == null)) {
            ((AmountEditVM) getVm()).queryPixKeyDetail(key);
            ((AmountEditVM) getVm()).triggerRealtimePush(key, 1);
        }
        ((AmountEditVM) getVm()).getOutTradeIdVo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m25662a(PixTransferAmountEditFragment.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25658a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (transferOptionInfo != null) {
            pixTransferAmountEditFragment.f33781i = transferOptionInfo;
            pixTransferAmountEditFragment.m25663a(String.valueOf(pixTransferAmountEditFragment.getAmountInputEt().getText()), transferOptionInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25655a(PixTransferAmountEditFragment pixTransferAmountEditFragment, WBaseResp wBaseResp) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (wBaseResp != null && (activity = pixTransferAmountEditFragment.getActivity()) != null) {
            WalletToastNew.showFailedMsg(activity, wBaseResp.errmsg);
            pixTransferAmountEditFragment.m25665a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25659a(PixTransferAmountEditFragment pixTransferAmountEditFragment, GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (nightlyLimitVo != null) {
            Editable text = pixTransferAmountEditFragment.getAmountInputEt().getText();
            String obj = text == null ? null : text.toString();
            CharSequence charSequence = obj;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                pixTransferAmountEditFragment.m25663a(obj, ((AmountEditVM) pixTransferAmountEditFragment.getVm()).getTransferOption().getValue());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25660a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PasswordDataVo passwordDataVo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        pixTransferAmountEditFragment.m25665a(false);
        if (passwordDataVo.getType() == 0) {
            if (passwordDataVo.getTitle() != null && passwordDataVo.getContent() != null && passwordDataVo.getConfirmButton() != null && passwordDataVo.getCancelButton() != null) {
                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m41339to("pub_page", "cashier"), TuplesKt.m41339to(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE, PasswordScene.PIX_IN.name()), TuplesKt.m41339to("pub_biz", "fintech"));
                FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_sw", MapsKt.toMap(mutableMapOf));
                Context context = pixTransferAmountEditFragment.getContext();
                if (context != null) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    WalletDialog.Companion companion = WalletDialog.Companion;
                    WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
                    builder.setTitle(passwordDataVo.getTitle());
                    builder.setContent(passwordDataVo.getContent());
                    builder.setSecondBtnText(passwordDataVo.getCancelButton());
                    builder.setSecondClickListener(new PixTransferAmountEditFragment$initViewModels$4$1$1(mutableMapOf, objectRef));
                    builder.setFirstBtnText(passwordDataVo.getConfirmButton());
                    builder.setFirstClickListener(new PixTransferAmountEditFragment$initViewModels$4$1$2(mutableMapOf, objectRef, pixTransferAmountEditFragment, passwordDataVo));
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = WalletDialog.Companion.configDrawer$default(companion, context, builder, false, false, 12, (Object) null);
                    SystemUtils.showDialog((WalletDialog) objectRef.element);
                }
            }
        } else if (passwordDataVo.getType() == 1) {
            OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
            String paySessionId = passwordDataVo.getPaySessionId();
            if (openCertificationListener != null && paySessionId != null) {
                PaySecure paySecure = PaySecure.INSTANCE;
                String name = PasswordScene.CHECK_OUT_WALLET.name();
                StringBuilder sb = new StringBuilder();
                sb.append(pixTransferAmountEditFragment.getTvCurrency().getText());
                sb.append(pixTransferAmountEditFragment.getAmountInputEt().getText());
                paySecure.verifyPayPassword(name, paySessionId, sb.toString(), new PixTransferAmountEditFragment$initViewModels$4$2(pixTransferAmountEditFragment, passwordDataVo), openCertificationListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25657a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixOrderDetailResp.OrderDetail orderDetail) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (orderDetail != null) {
            if (orderDetail.isDialogBlock()) {
                Context context = pixTransferAmountEditFragment.getContext();
                if (context != null) {
                    WalletDialog createDrawer$default = WalletDialog.Companion.createDrawer$default(WalletDialog.Companion, context, false, false, 6, (Object) null);
                    WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
                    PixOrderDetailResp.DialogInfo dialog = orderDetail.getDialog();
                    String str = null;
                    String title = dialog == null ? null : dialog.getTitle();
                    String str2 = "";
                    if (title == null) {
                        title = str2;
                    }
                    builder.setTitle(title);
                    PixOrderDetailResp.DialogInfo dialog2 = orderDetail.getDialog();
                    String desc = dialog2 == null ? null : dialog2.getDesc();
                    if (desc == null) {
                        desc = str2;
                    }
                    builder.setContent(desc);
                    PixOrderDetailResp.DialogInfo dialog3 = orderDetail.getDialog();
                    String considerBtn = dialog3 == null ? null : dialog3.getConsiderBtn();
                    if (considerBtn == null) {
                        considerBtn = str2;
                    }
                    builder.setFirstBtnText(considerBtn);
                    builder.setFirstClickListener(new PixTransferAmountEditFragment$initViewModels$5$content$1$1(pixTransferAmountEditFragment, createDrawer$default));
                    PixOrderDetailResp.DialogInfo dialog4 = orderDetail.getDialog();
                    if (dialog4 != null) {
                        str = dialog4.getIgnoreBtn();
                    }
                    if (str != null) {
                        str2 = str;
                    }
                    builder.setSecondBtnText(str2);
                    builder.setSecondClickListener(new PixTransferAmountEditFragment$initViewModels$5$content$1$2(createDrawer$default));
                    createDrawer$default.setContentView((View) builder.build(context));
                    SystemUtils.showDialog(createDrawer$default);
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("order_id", orderDetail.getOrderId());
            bundle.putSerializable("order_detail", orderDetail);
            ((Request) DRouter.build(PixRouter.build("/pix_order_detail")).putExtras(bundle)).start(pixTransferAmountEditFragment.getActivity());
            EventBus.getDefault().post(new WalletRefreshDataEvent());
            EventBus.getDefault().post(new BackStackEvent());
            FragmentActivity activity = pixTransferAmountEditFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25661a(PixTransferAmountEditFragment pixTransferAmountEditFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        pixTransferAmountEditFragment.m25665a(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25672b(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        pixTransferAmountEditFragment.m25676d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25656a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixKeyVerifyResp.PixAccount pixAccount) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        pixTransferAmountEditFragment.f33797y = pixAccount;
        pixTransferAmountEditFragment.m25649a(pixTransferAmountEditFragment.getMODE_PIXACOUNT());
        pixTransferAmountEditFragment.m25676d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25662a(PixTransferAmountEditFragment pixTransferAmountEditFragment, String str) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (((AmountEditVM) pixTransferAmountEditFragment.getVm()).isNewLimitCheck()) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(str);
            CashierFacade.Companion.getInstance().launchForResult((Fragment) pixTransferAmountEditFragment, 200, cashierParam, (CashierLaunchListener) null);
            pixTransferAmountEditFragment.m25665a(false);
        }
    }

    /* renamed from: a */
    private final void m25665a(boolean z) {
        if (z) {
            getPayButton().setText("");
            getBtnLoadingView().setRepeatCount(-1);
            getBtnLoadingView().setVisibility(0);
            getBtnLoadingView().playAnimation();
            return;
        }
        getPayButton().setText(getString(R.string.pay_base_confirm));
        getBtnLoadingView().setVisibility(8);
        if (getBtnLoadingView().isAnimating()) {
            getBtnLoadingView().cancelAnimation();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_amount_sw", this.f33773a);
        ((AmountEditVM) getVm()).loadData();
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        commonTitleBar.setTitle(getString(R.string.CS_payment_PIX_Transfer_Onrd));
        View findViewById = commonTitleBar.findViewById(R.id.title_bar_layout_above);
        if (findViewById != null) {
            findViewById.setBackgroundColor(0);
        }
        commonTitleBar.setLeftBackListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixTransferAmountEditFragment.m25654a(PixTransferAmountEditFragment.this, view);
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25654a(PixTransferAmountEditFragment pixTransferAmountEditFragment, View view) {
        String key;
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        pixTransferAmountEditFragment.m25677e();
        PixQrCodeQueryResp.QRCodeData qRCodeData = pixTransferAmountEditFragment.f33798z;
        if (!(qRCodeData == null || (key = qRCodeData.getKey()) == null)) {
            ((AmountEditVM) pixTransferAmountEditFragment.getVm()).triggerRealtimePush(key, 2);
        }
        pixTransferAmountEditFragment.backToPrePage();
    }

    public final View getMEditContentVp() {
        View view = this.mEditContentVp;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEditContentVp");
        return null;
    }

    public final void setMEditContentVp(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mEditContentVp = view;
    }

    public final View getMBottomBtn() {
        View view = this.mBottomBtn;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBottomBtn");
        return null;
    }

    public final void setMBottomBtn(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mBottomBtn = view;
    }

    public void initContentView(View view) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        super.initContentView(view);
        View findViewById = view.findViewById(R.id.transfer_amount_edit_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.t…fer_amount_edit_titlebar)");
        setTitlebar(findViewById);
        View findViewById2 = view.findViewById(R.id.payee_header_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.payee_header_view)");
        this.f33771D = findViewById2;
        View findViewById3 = view.findViewById(R.id.pix_amount_edit_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.pix_amount_edit_content)");
        setMEditContentVp(findViewById3);
        ViewParent parent = getMEditContentVp().getParent();
        if (parent != null) {
            ((ViewGroup) parent).setOnClickListener(C11679x728e150b.INSTANCE);
        }
        View findViewById4 = view.findViewById(R.id.pix_amount_edit_bottom_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.pix_amount_edit_bottom_btn)");
        setMBottomBtn(findViewById4);
        View findViewById5 = view.findViewById(R.id.payment_to_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.payment_to_tv)");
        setPaymentToTv((TextView) findViewById5);
        View findViewById6 = view.findViewById(R.id.payment_to_desc_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.payment_to_desc_tv)");
        setPaymentToDescTv((TextView) findViewById6);
        this.f33776d = (ImageView) view.findViewById(R.id.payee_head_icon_img);
        this.f33775c = (TextView) view.findViewById(R.id.payee_head_icon_tv);
        View findViewById7 = view.findViewById(R.id.current_balance_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.current_balance_tv)");
        setBalanceTv((TextView) findViewById7);
        View findViewById8 = view.findViewById(R.id.tv_currency);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.tv_currency)");
        setTvCurrency((TextView) findViewById8);
        View findViewById9 = view.findViewById(R.id.pix_transfer_amount_et);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.pix_transfer_amount_et)");
        setAmountInputEt((AppCompatEditText) findViewById9);
        View findViewById10 = view.findViewById(R.id.confirm_button_animation_view);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.c…rm_button_animation_view)");
        setBtnLoadingView((LottieAnimationView) findViewById10);
        View findViewById11 = view.findViewById(R.id.transfer_amount_confirm_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.t…er_amount_confirm_btn_tv)");
        setPayButton((TextView) findViewById11);
        getPayButton().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixTransferAmountEditFragment.m25671b(PixTransferAmountEditFragment.this, view);
            }
        });
        getPayButton().setEnabled(false);
        getAmountInputEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return PixTransferAmountEditFragment.m25669a(PixTransferAmountEditFragment.this, textView, i, keyEvent);
            }
        });
        View findViewById12 = view.findViewById(R.id.append_info_et);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.append_info_et)");
        setExtraInfoEt((AppCompatEditText) findViewById12);
        getExtraInfoEt().setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f33784l)});
        View findViewById13 = view.findViewById(R.id.input_left_number_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.input_left_number_tv)");
        setInputLeftTv((TextView) findViewById13);
        getInputLeftTv().setText(Intrinsics.stringPlus("0/", Integer.valueOf(this.f33784l)));
        View findViewById14 = view.findViewById(R.id.input_amount_exceed_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.input_amount_exceed_tv)");
        setExceedTv((TextView) findViewById14);
        m25674c();
        if (this.f33795w != null) {
            i = this.f33789q;
        } else {
            i = this.f33796x != null ? this.f33790r : this.f33791s;
        }
        m25649a(i);
        View findViewById15 = view.findViewById(R.id.unable_amount_container);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.unable_amount_container)");
        this.f33777e = (RelativeLayout) findViewById15;
        View findViewById16 = view.findViewById(R.id.unable_amount_label);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "view.findViewById(R.id.unable_amount_label)");
        this.f33778f = (TextView) findViewById16;
        View findViewById17 = view.findViewById(R.id.unable_amount_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "view.findViewById(R.id.unable_amount_btn)");
        TextView textView = (TextView) findViewById17;
        this.f33779g = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnableAmountBtn");
            textView = null;
        }
        textView.setOnClickListener(new PixTransferAmountEditFragment$initContentView$4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25652a(View view) {
        SystemUtils.log(3, "", "page level click event consume...", (Throwable) null, "com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment", 504);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25671b(PixTransferAmountEditFragment pixTransferAmountEditFragment, View view) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_amount_ck", pixTransferAmountEditFragment.f33773a);
        NFloatInputHelper nFloatParser = pixTransferAmountEditFragment.getNFloatParser();
        Editable text = pixTransferAmountEditFragment.getAmountInputEt().getText();
        String str = null;
        int dollarToCent = MathUtil.dollarToCent(nFloatParser.parseFloatValue(text == null ? null : text.toString()));
        BankAccountMetaData bankAccountMetaData = pixTransferAmountEditFragment.f33795w;
        if (bankAccountMetaData != null) {
            JSONObject bizContent = bankAccountMetaData.toBizContent();
            bizContent.put("tradeType", 3);
            bizContent.put("amount", dollarToCent);
            Editable text2 = pixTransferAmountEditFragment.getExtraInfoEt().getText();
            bizContent.put("note", text2 == null ? null : text2.toString());
            bizContent.put("useCashier", ((AmountEditVM) pixTransferAmountEditFragment.getVm()).isNewLimitCheck() ? 1 : 0);
            String jSONObject = bizContent.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "bizContentJson.toString()");
            AmountEditVM.createPixTransferOrder$default((AmountEditVM) pixTransferAmountEditFragment.getVm(), 99996, jSONObject, (String) null, 4, (Object) null);
        }
        PixKeyVerifyResp.PixAccount pixAccount = pixTransferAmountEditFragment.f33796x;
        if (pixAccount != null) {
            JSONObject bizContent2 = pixAccount.toBizContent();
            bizContent2.put("tradeType", 1);
            bizContent2.put("amount", dollarToCent);
            Editable text3 = pixTransferAmountEditFragment.getExtraInfoEt().getText();
            bizContent2.put("note", text3 == null ? null : text3.toString());
            bizContent2.put("useCashier", ((AmountEditVM) pixTransferAmountEditFragment.getVm()).isNewLimitCheck() ? 1 : 0);
            String jSONObject2 = bizContent2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "bizContentJson.toString()");
            AmountEditVM.createPixTransferOrder$default((AmountEditVM) pixTransferAmountEditFragment.getVm(), 99996, jSONObject2, (String) null, 4, (Object) null);
        }
        PixQrCodeQueryResp.QRCodeData qRCodeData = pixTransferAmountEditFragment.f33798z;
        if (qRCodeData != null) {
            JSONObject bizContent3 = qRCodeData.toBizContent();
            PixKeyVerifyResp.PixAccount pixAccount2 = pixTransferAmountEditFragment.f33797y;
            if (pixAccount2 != null) {
                bizContent3.put("toIconUrl", pixAccount2.getIcon());
            }
            bizContent3.put("tradeType", 2);
            bizContent3.put("amount", dollarToCent);
            Editable text4 = pixTransferAmountEditFragment.getExtraInfoEt().getText();
            if (text4 != null) {
                str = text4.toString();
            }
            bizContent3.put("note", str);
            bizContent3.put("useCashier", ((AmountEditVM) pixTransferAmountEditFragment.getVm()).isNewLimitCheck() ? 1 : 0);
            String jSONObject3 = bizContent3.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "bizContentJson.toString()");
            AmountEditVM.createPixTransferOrder$default((AmountEditVM) pixTransferAmountEditFragment.getVm(), 99996, jSONObject3, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25669a(PixTransferAmountEditFragment pixTransferAmountEditFragment, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (5 != i || !pixTransferAmountEditFragment.getPayButton().isEnabled()) {
            return false;
        }
        pixTransferAmountEditFragment.getPayButton().performClick();
        InputTools.hideKeyboard(textView);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25664a(String str, String str2) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_title_layout, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…itle_layout, null, false)");
        TextView textView = (TextView) inflate.findViewById(R.id.drawer_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.drawer_btn_ok);
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixTransferAmountEditFragment.m25675c(PixTransferAmountEditFragment.this, view);
            }
        });
        textView.setText(str);
        Intrinsics.checkNotNullExpressionValue(textView, "contentView");
        setParentLayout(textView);
        Intrinsics.checkNotNullExpressionValue(textView2, "okBtn");
        setParentLayout(textView2);
        this.f33780h = GGKUICreatorWithThemeCheck.showDrawerModel(getActivity(), new GGKDrawerModel0().setExtendedView(inflate).setClickOutsideCanCancel(false));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m25675c(PixTransferAmountEditFragment pixTransferAmountEditFragment, View view) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        GGKDrawer gGKDrawer = pixTransferAmountEditFragment.f33780h;
        if (gGKDrawer != null) {
            gGKDrawer.dismiss();
        }
    }

    public final void setParentLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = UiUtils.dip2px(getContext(), 18.0f);
            marginLayoutParams.rightMargin = UiUtils.dip2px(getContext(), 18.0f);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* renamed from: a */
    private final String m25648a(String str) {
        if ((StringsKt.startsWith$default(str, "*", false, 2, (Object) null) && StringsKt.endsWith$default(str, "*", false, 2, (Object) null)) || str.length() <= 5) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("***");
        int length = str.length() - 2;
        if (str != null) {
            String substring = str.substring(3, length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("**");
            return sb.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private final void m25649a(int i) {
        PixQrCodeQueryResp.QRCodeData qRCodeData;
        Integer amount;
        int intValue;
        String str;
        if (i == this.f33789q) {
            BankAccountMetaData bankAccountMetaData = this.f33795w;
            if (bankAccountMetaData != null) {
                TextView paymentToTv2 = getPaymentToTv();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.GRider_payment_Transfer_to_gulk);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRide…payment_Transfer_to_gulk)");
                String format = String.format(string, Arrays.copyOf(new Object[]{bankAccountMetaData.getPayeeName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                paymentToTv2.setText(format);
                CharSequence cpf4Display = bankAccountMetaData.getCpf4Display();
                if (cpf4Display.length() == 0) {
                    cpf4Display = bankAccountMetaData.getCpf();
                }
                TextView paymentToDescTv2 = getPaymentToDescTv();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = getString(R.string.GRider_payment__cpf_sBCN);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.GRider_payment__cpf_sBCN)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{m25648a((String) cpf4Display), bankAccountMetaData.getPspName()}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                paymentToDescTv2.setText(format2);
                if (!TextUtil.isEmpty(bankAccountMetaData.getPayeeName())) {
                    ImageView imageView = this.f33776d;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    TextView textView = this.f33775c;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    TextView textView2 = this.f33775c;
                    if (textView2 != null) {
                        String payeeName = bankAccountMetaData.getPayeeName();
                        if (payeeName != null) {
                            String substring = payeeName.substring(0, 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            textView2.setText(substring);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    return;
                }
                ImageView imageView2 = this.f33776d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
        } else if (i == this.f33790r) {
            PixKeyVerifyResp.PixAccount pixAccount = this.f33796x;
            if (pixAccount == null) {
                pixAccount = this.f33797y;
            }
            if (pixAccount != null) {
                TextView paymentToTv3 = getPaymentToTv();
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String string3 = getString(R.string.GRider_payment_Transfer_to_gulk);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.GRide…payment_Transfer_to_gulk)");
                String format3 = String.format(string3, Arrays.copyOf(new Object[]{pixAccount.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
                paymentToTv3.setText(format3);
                PixKeyVerifyResp.PspInfo psp = pixAccount.getPsp();
                String name = !TextUtil.isEmpty(psp.getName()) ? psp.getName() : "";
                TextView paymentToDescTv3 = getPaymentToDescTv();
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String string4 = getString(R.string.GRider_payment__cpf_sBCN);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.GRider_payment__cpf_sBCN)");
                Object[] objArr = new Object[2];
                String cpf = pixAccount.getCpf();
                String str2 = null;
                if (cpf == null) {
                    str = null;
                } else {
                    str = m25648a(cpf);
                }
                objArr[0] = str;
                objArr[1] = name;
                String format4 = String.format(string4, Arrays.copyOf(objArr, 2));
                Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
                paymentToDescTv3.setText(format4);
                if (!TextUtil.isEmpty(pixAccount.getIcon())) {
                    ImageView imageView3 = this.f33776d;
                    if (imageView3 != null) {
                        imageView3.setVisibility(0);
                    }
                    TextView textView3 = this.f33775c;
                    if (textView3 != null) {
                        textView3.setVisibility(4);
                    }
                    GlideUtils.loadCircleImageWithDefaultImg(getContext(), Uri.parse(pixAccount.getIcon()), R.drawable.pay_icon_contacts, this.f33776d);
                    return;
                }
                ImageView imageView4 = this.f33776d;
                if (imageView4 != null) {
                    imageView4.setVisibility(4);
                }
                TextView textView4 = this.f33775c;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                TextView textView5 = this.f33775c;
                if (textView5 != null) {
                    String name2 = pixAccount.getName();
                    if (name2 != null) {
                        str2 = name2.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    textView5.setText(str2);
                }
            }
        } else if (i == this.f33791s && (qRCodeData = this.f33798z) != null && (amount = qRCodeData.getAmount()) != null && (intValue = amount.intValue()) >= 0) {
            String centToDollar = MathUtil.centToDollar(Double.valueOf((double) intValue));
            getAmountInputEt().removeTextChangedListener(this.f33772E);
            getAmountInputEt().setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(10)});
            getAmountInputEt().setText(centToDollar);
            getAmountInputEt().setEnabled(false);
            this.f33794v = this.f33793u;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m25663a(java.lang.String r13, com.didi.payment.pix.net.response.PixTransferOption.TransferOptionInfo r14) {
        /*
            r12 = this;
            android.content.Context r0 = r12.getContext()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.didi.payment.pix.net.response.PixKeyVerifyResp$PixAccount r0 = r12.f33796x
            r1 = 0
            if (r0 == 0) goto L_0x001d
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r3 = 0
            goto L_0x003c
        L_0x0010:
            java.lang.Boolean r0 = r0.isSameCpf()
            if (r0 != 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            boolean r0 = r0.booleanValue()
        L_0x001b:
            r3 = r0
            goto L_0x003c
        L_0x001d:
            com.didi.payment.pix.net.response.PixKeyVerifyResp$PixAccount r0 = r12.f33797y
            if (r0 == 0) goto L_0x0030
            if (r0 != 0) goto L_0x0024
            goto L_0x000e
        L_0x0024:
            java.lang.Boolean r0 = r0.isSameCpf()
            if (r0 != 0) goto L_0x002b
            goto L_0x000e
        L_0x002b:
            boolean r0 = r0.booleanValue()
            goto L_0x001b
        L_0x0030:
            com.didi.payment.pix.transfer.vm.model.BankAccountMetaData r0 = r12.f33795w
            if (r0 == 0) goto L_0x000e
            if (r0 != 0) goto L_0x0037
            goto L_0x000e
        L_0x0037:
            boolean r0 = r0.isSameCpf()
            goto L_0x001b
        L_0x003c:
            com.didi.payment.commonsdk.ui.helper.NFloatInputHelper r0 = r12.f33785m
            float r13 = r0.parseFloatValue(r13)
            int r13 = com.didi.payment.base.utils.MathUtil.dollarToCent((float) r13)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r12.getVm()
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = (com.didi.payment.pix.transfer.p142vm.model.AmountEditVM) r0
            androidx.lifecycle.MutableLiveData r0 = r0.getNightlyLimitVo()
            java.lang.Object r0 = r0.getValue()
            r6 = r0
            com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp$NightlyLimitVo r6 = (com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp.NightlyLimitVo) r6
            r0 = 1
            if (r3 != 0) goto L_0x0068
            if (r6 != 0) goto L_0x005e
        L_0x005c:
            r2 = 0
            goto L_0x0063
        L_0x005e:
            boolean r2 = r6.isHit
            if (r2 != r0) goto L_0x005c
            r2 = 1
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            long r4 = r6.remainingLimit
            goto L_0x006a
        L_0x0068:
            r4 = -1
        L_0x006a:
            r7 = r4
            java.lang.String r2 = ""
            if (r3 != 0) goto L_0x007f
            if (r6 != 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            boolean r4 = r6.isHit
            if (r4 != r0) goto L_0x0077
            r1 = 1
        L_0x0077:
            if (r1 == 0) goto L_0x007f
            java.lang.String r0 = r6.effectiveTime
            if (r0 == 0) goto L_0x007f
            r9 = r0
            goto L_0x0080
        L_0x007f:
            r9 = r2
        L_0x0080:
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r12.getVm()
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = (com.didi.payment.pix.transfer.p142vm.model.AmountEditVM) r0
            boolean r0 = r0.isNewLimitCheck()
            if (r0 == 0) goto L_0x0092
            long r4 = (long) r13
            r2 = r12
            r2.m25666a((boolean) r3, (long) r4, (com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp.NightlyLimitVo) r6, (long) r7, (java.lang.String) r9)
            goto L_0x00a0
        L_0x0092:
            if (r14 != 0) goto L_0x0096
            r14 = -1
            goto L_0x009a
        L_0x0096:
            int r14 = r14.getUserAvailableAmount()
        L_0x009a:
            long r4 = (long) r13
            long r10 = (long) r14
            r2 = r12
            r2.m25667a(r3, r4, r6, r7, r9, r10)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.m25663a(java.lang.String, com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m25667a(boolean r16, long r17, com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp.NightlyLimitVo r19, long r20, java.lang.String r22, long r23) {
        /*
            r15 = this;
            r0 = r19
            r1 = -1
            if (r16 == 0) goto L_0x0008
        L_0x0006:
            r9 = r1
            goto L_0x0013
        L_0x0008:
            if (r0 != 0) goto L_0x000b
            goto L_0x0006
        L_0x000b:
            com.didi.payment.wallet.global.model.resp.LimitRiskDetailVo r3 = r0.limitRiskDetail
            if (r3 != 0) goto L_0x0010
            goto L_0x0006
        L_0x0010:
            long r1 = r3.riskLimitQuota
            goto L_0x0006
        L_0x0013:
            r1 = 0
            if (r16 == 0) goto L_0x001b
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
        L_0x0019:
            r11 = r2
            goto L_0x0027
        L_0x001b:
            if (r0 != 0) goto L_0x001f
        L_0x001d:
            r11 = r1
            goto L_0x0027
        L_0x001f:
            com.didi.payment.wallet.global.model.resp.LimitRiskDetailVo r2 = r0.limitRiskDetail
            if (r2 != 0) goto L_0x0024
            goto L_0x001d
        L_0x0024:
            java.lang.String r2 = r2.description
            goto L_0x0019
        L_0x0027:
            if (r16 == 0) goto L_0x002d
            java.lang.String r1 = (java.lang.String) r1
        L_0x002b:
            r12 = r1
            goto L_0x0038
        L_0x002d:
            if (r0 != 0) goto L_0x0030
        L_0x002f:
            goto L_0x002b
        L_0x0030:
            com.didi.payment.wallet.global.model.resp.LimitRiskDetailVo r0 = r0.limitRiskDetail
            if (r0 != 0) goto L_0x0035
            goto L_0x002f
        L_0x0035:
            java.lang.String r0 = r0.link
            r12 = r0
        L_0x0038:
            r3 = r15
            r4 = r17
            r6 = r20
            r8 = r22
            r13 = r23
            r3.m25651a(r4, r6, r8, r9, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.m25667a(boolean, long, com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp$NightlyLimitVo, long, java.lang.String, long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m25666a(boolean r17, long r18, com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp.NightlyLimitVo r20, long r21, java.lang.String r23) {
        /*
            r16 = this;
            r12 = r16
            r0 = r20
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r0 = 0
            goto L_0x0016
        L_0x000d:
            com.didi.payment.wallet.global.model.resp.LimitOfPaymentMethodVo r0 = r0.limitOfPaymentMethod
            if (r0 != 0) goto L_0x0012
            goto L_0x000b
        L_0x0012:
            java.util.List r0 = r0.getPaymentLimitList()
        L_0x0016:
            r3 = 1
            if (r0 != 0) goto L_0x0020
            r1 = r18
            r8 = 0
            r10 = -1
            goto L_0x009f
        L_0x0020:
            r7 = r0
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 0
            r9 = 0
            r10 = -1
        L_0x002b:
            boolean r13 = r7.hasNext()
            if (r13 == 0) goto L_0x009d
            java.lang.Object r13 = r7.next()
            int r14 = r9 + 1
            if (r9 >= 0) goto L_0x003c
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x003c:
            com.didi.payment.wallet.global.model.resp.LimitOfPaymentMethodVo$PaymentLimitVo r13 = (com.didi.payment.wallet.global.model.resp.LimitOfPaymentMethodVo.PaymentLimitVo) r13
            java.lang.Long r15 = r13.getRiskLimitQuota()
            if (r15 != 0) goto L_0x0048
            r1 = r18
        L_0x0046:
            r9 = 0
            goto L_0x009b
        L_0x0048:
            java.lang.Number r15 = (java.lang.Number) r15
            long r4 = r15.longValue()
            r1 = r18
            boolean r4 = r12.m25668a((long) r1, (long) r4)
            if (r4 != 0) goto L_0x0046
            int r4 = r0.size()
            int r4 = r4 - r3
            if (r9 >= r4) goto L_0x0072
            if (r17 == 0) goto L_0x0060
            goto L_0x0074
        L_0x0060:
            java.lang.Object r4 = r0.get(r14)
            com.didi.payment.wallet.global.model.resp.LimitOfPaymentMethodVo$PaymentLimitVo r4 = (com.didi.payment.wallet.global.model.resp.LimitOfPaymentMethodVo.PaymentLimitVo) r4
            java.lang.Long r4 = r4.getRiskLimitQuota()
            if (r4 != 0) goto L_0x006d
            goto L_0x0074
        L_0x006d:
            long r4 = r4.longValue()
            goto L_0x0082
        L_0x0072:
            if (r17 == 0) goto L_0x0077
        L_0x0074:
            r4 = -1
            goto L_0x0082
        L_0x0077:
            java.lang.Long r4 = r13.getRiskLimitQuota()
            if (r4 != 0) goto L_0x007e
            goto L_0x0074
        L_0x007e:
            long r4 = r4.longValue()
        L_0x0082:
            if (r17 == 0) goto L_0x0089
            r9 = 0
            r8 = r9
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x008e
        L_0x0089:
            r9 = 0
            java.lang.String r8 = r13.getDescription()
        L_0x008e:
            if (r17 == 0) goto L_0x0094
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0098
        L_0x0094:
            java.lang.String r10 = r13.getLink()
        L_0x0098:
            r6.element = r10
            r10 = r4
        L_0x009b:
            r9 = r14
            goto L_0x002b
        L_0x009d:
            r1 = r18
        L_0x009f:
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00ad
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r0 = 0
            goto L_0x00ae
        L_0x00ad:
            r0 = 1
        L_0x00ae:
            if (r0 != 0) goto L_0x00f9
            r0 = 3
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            java.lang.String r4 = "error_message"
            kotlin.Pair r4 = kotlin.TuplesKt.m41339to(r4, r8)
            r5 = 0
            r0[r5] = r4
            java.lang.String r4 = "pub_page"
            java.lang.String r5 = "pix_transfer"
            kotlin.Pair r4 = kotlin.TuplesKt.m41339to(r4, r5)
            r0[r3] = r4
            r3 = 2
            java.lang.String r4 = "pub_from_page"
            java.lang.String r5 = ""
            kotlin.Pair r4 = kotlin.TuplesKt.m41339to(r4, r5)
            r0[r3] = r4
            java.util.Map r0 = kotlin.collections.MapsKt.mutableMapOf(r0)
            android.widget.TextView r3 = r16.getExceedTv()
            r4 = 1
            java.lang.String r5 = " >"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r5)
            com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment$limitNewCheck$2 r7 = new com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment$limitNewCheck$2
            r7.<init>(r6, r12, r0)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment$limitNewCheck$3 r9 = new com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment$limitNewCheck$3
            r9.<init>(r0)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r0 = r16
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r7
            r5 = r9
            r0.m25653a((android.widget.TextView) r1, (boolean) r2, (java.lang.String) r3, (kotlin.jvm.functions.Function0<kotlin.Unit>) r4, (kotlin.jvm.functions.Function0<kotlin.Unit>) r5)
            goto L_0x0106
        L_0x00f9:
            android.widget.TextView r1 = r16.getExceedTv()
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r16
            r0.m25653a((android.widget.TextView) r1, (boolean) r2, (java.lang.String) r3, (kotlin.jvm.functions.Function0<kotlin.Unit>) r4, (kotlin.jvm.functions.Function0<kotlin.Unit>) r5)
        L_0x0106:
            T r0 = r6.element
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            r13 = -1
            r0 = r16
            r1 = r18
            r3 = r21
            r5 = r23
            r6 = r10
            r10 = r13
            r0.m25651a(r1, r3, r5, r6, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.m25666a(boolean, long, com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp$NightlyLimitVo, long, java.lang.String):void");
    }

    /* renamed from: c */
    private final void m25674c() {
        getAmountInputEt().addTextChangedListener(this.f33772E);
        getAmountInputEt().setFilters(new InputFilter[]{new NFloatInputHelper.NumberDecimalInputFilter(2, this.f33785m.decimalSeperatorBySys), new InputFilter.LengthFilter(10)});
        getExtraInfoEt().addTextChangedListener(new PixTransferAmountEditFragment$initAmountEditText$1(this));
    }

    /* renamed from: a */
    private final void m25651a(long j, long j2, String str, long j3, String str2, String str3, long j4) {
        long j5 = j;
        if (m25668a(j, j3)) {
            m25650a(j, j2, str, j4);
            return;
        }
        m25673b(str2, str3);
        Context context = getContext();
        if (context != null) {
            getTvCurrency().setTextColor(ContextCompat.getColor(context, R.color.wallet_pix_transfer_amount_error_color));
            getAmountInputEt().setTextColor(ContextCompat.getColor(context, R.color.wallet_pix_transfer_amount_error_color));
        }
        getPayButton().setEnabled(false);
    }

    /* renamed from: b */
    private final void m25673b(String str, String str2) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            m25653a(getExceedTv(), true, Intrinsics.stringPlus(str, " >"), (Function0<Unit>) new PixTransferAmountEditFragment$showLimitInfoCommon$1(str2, this), (Function0<Unit>) PixTransferAmountEditFragment$showLimitInfoCommon$2.INSTANCE);
        } else {
            m25653a(getExceedTv(), true, (String) null, (Function0<Unit>) null, (Function0<Unit>) null);
        }
    }

    /* renamed from: a */
    private final void m25650a(long j, long j2, String str, long j3) {
        String str2;
        boolean z = false;
        if (!m25668a(j, j2)) {
            if (!TextUtils.isEmpty(str)) {
                str2 = getString(R.string.GRider_2_When_the_QyBM);
            } else if (((AmountEditVM) getVm()).isNewLimitCheck()) {
                str2 = getString(R.string.Fintech_Payment_installment__CLyL);
            } else {
                str2 = getString(R.string.GRider_limit_Beyond_the_GuvV);
            }
            m25653a(getExceedTv(), true, Intrinsics.stringPlus(str2, " >"), (Function0<Unit>) new PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$3(this), (Function0<Unit>) new PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$4(j));
            Context context = getContext();
            if (context != null) {
                getTvCurrency().setTextColor(ContextCompat.getColor(context, R.color.wallet_pix_transfer_amount_error_color));
                getAmountInputEt().setTextColor(ContextCompat.getColor(context, R.color.wallet_pix_transfer_amount_error_color));
            }
            getPayButton().setEnabled(false);
        } else if (m25668a(j, j3)) {
            TextView payButton2 = getPayButton();
            if (j > 0) {
                z = true;
            }
            payButton2.setEnabled(z);
            getTvCurrency().setTextColor(-16777216);
            getAmountInputEt().setTextColor(-16777216);
            if (!((AmountEditVM) getVm()).isNewLimitCheck()) {
                m25653a(getExceedTv(), true, (String) null, (Function0<Unit>) null, (Function0<Unit>) null);
            }
        } else {
            TextView exceedTv2 = getExceedTv();
            ITransferAmountTip a = m25647a();
            boolean isEnableClick = a == null ? false : a.isEnableClick();
            ITransferAmountTip a2 = m25647a();
            String warningMsg = a2 == null ? null : a2.getWarningMsg(getContext());
            if (warningMsg == null) {
                warningMsg = "";
            }
            m25653a(exceedTv2, isEnableClick, warningMsg, (Function0<Unit>) new PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$1(this), (Function0<Unit>) null);
            Context context2 = getContext();
            if (context2 != null) {
                getTvCurrency().setTextColor(ContextCompat.getColor(context2, R.color.wallet_pix_transfer_amount_error_color));
                getAmountInputEt().setTextColor(ContextCompat.getColor(context2, R.color.wallet_pix_transfer_amount_error_color));
            }
            getPayButton().setEnabled(false);
        }
    }

    /* renamed from: a */
    private final void m25653a(TextView textView, boolean z, String str, Function0<Unit> function0, Function0<Unit> function02) {
        CharSequence charSequence = str;
        textView.setText(charSequence);
        textView.setClickable(z);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        ViewExtsKt.click(textView, function0);
        if (!TextUtils.isEmpty(charSequence) && function02 != null) {
            function02.invoke();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9, types: [android.widget.RelativeLayout] */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m25676d() {
        /*
            r9 = this;
            com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo r0 = r9.f33781i
            if (r0 != 0) goto L_0x0006
            goto L_0x00fe
        L_0x0006:
            int r1 = r0.getUserAvailableAmount()
            android.widget.TextView r2 = r9.getBalanceTv()
            android.view.View r2 = (android.view.View) r2
            com.didi.payment.commonsdk.ui.WBaseViewModel r3 = r9.getVm()
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r3 = (com.didi.payment.pix.transfer.p142vm.model.AmountEditVM) r3
            boolean r3 = r3.isNewLimitCheck()
            r4 = 1
            r3 = r3 ^ r4
            r5 = 8
            r6 = 0
            if (r3 == 0) goto L_0x0023
            r3 = 0
            goto L_0x0025
        L_0x0023:
            r3 = 8
        L_0x0025:
            r2.setVisibility(r3)
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.String r1 = com.didi.payment.base.utils.MathUtil.centToDollar(r1)
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            r2 = 2131952938(0x7f13052a, float:1.9542333E38)
            java.lang.String r2 = r9.getString(r2)
            java.lang.String r3 = "%s"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            java.lang.Object[] r3 = new java.lang.Object[r4]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = " {R$ "
            r7.append(r8)
            r7.append(r1)
            r1 = 125(0x7d, float:1.75E-43)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            r3[r6] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r4)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            java.lang.String r2 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.content.res.Resources r2 = r9.getResources()
            r3 = 2131101914(0x7f0608da, float:1.7816251E38)
            int r2 = r2.getColor(r3)
            android.text.SpannableStringBuilder r1 = com.didi.payment.base.utils.TextHighlightUtil.highlight((java.lang.CharSequence) r1, (int) r2, (boolean) r4)
            android.widget.TextView r2 = r9.getBalanceTv()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            int r1 = r0.getUserBlockAmount()
            java.lang.String r2 = "mUnableAmountContainer"
            r3 = 0
            if (r1 == 0) goto L_0x00f2
            java.lang.String r1 = r0.getUnableAmountDesc()
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r1)
            if (r1 != 0) goto L_0x00f2
            java.lang.String r1 = r0.getUnableAmountBtnLabel()
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r1)
            if (r1 != 0) goto L_0x00f2
            java.lang.String r0 = r0.getUnableAmountLabel()
            boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r0)
            if (r0 != 0) goto L_0x00f2
            android.widget.RelativeLayout r0 = r9.f33777e
            if (r0 != 0) goto L_0x00b0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x00b0:
            r0.setVisibility(r6)
            android.widget.TextView r0 = r9.f33778f
            if (r0 != 0) goto L_0x00bd
            java.lang.String r0 = "mUnableAmountLabel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r3
        L_0x00bd:
            com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo r1 = r9.f33781i
            if (r1 != 0) goto L_0x00c3
            r1 = r3
            goto L_0x00c7
        L_0x00c3:
            java.lang.String r1 = r1.getUnableAmountLabel()
        L_0x00c7:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r9.f33779g
            java.lang.String r1 = "mUnableAmountBtn"
            if (r0 != 0) goto L_0x00d6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L_0x00d6:
            com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo r2 = r9.f33781i
            if (r2 != 0) goto L_0x00dc
            r2 = r3
            goto L_0x00e0
        L_0x00dc:
            java.lang.String r2 = r2.getUnableAmountBtnLabel()
        L_0x00e0:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r9.f33779g
            if (r0 != 0) goto L_0x00ed
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x00ee
        L_0x00ed:
            r3 = r0
        L_0x00ee:
            r3.setVisibility(r6)
            goto L_0x00fe
        L_0x00f2:
            android.widget.RelativeLayout r0 = r9.f33777e
            if (r0 != 0) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x00fb
        L_0x00fa:
            r3 = r0
        L_0x00fb:
            r3.setVisibility(r5)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.m25676d():void");
    }

    public void onResume() {
        super.onResume();
        if (this.f33783k) {
            this.f33783k = false;
            ((AmountEditVM) getVm()).loadData();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    public final void gotoTopupBalance() {
        this.f33783k = true;
        if (WalletApolloUtil.getTopUpIsNew()) {
            DRouter.build("GuaranaOneTravel://one/ddw_top_up?pub_source=pix_transfer").start(getActivity());
        } else {
            DRouter.build("99pay://one/wallet_topup_amount").start(getActivity());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Integer num;
        String orderId;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 200) {
            if (intent == null) {
                num = null;
            } else {
                num = Integer.valueOf(intent.getIntExtra("code", 3));
            }
            if (CollectionsKt.contains(CollectionsKt.listOf(1, 3), num) && (orderId = ((AmountEditVM) getVm()).getOrderId()) != null) {
                ((AmountEditVM) getVm()).loopQueryOrderDetail(orderId);
            }
        }
    }

    public boolean onBackKeyPressed() {
        String key;
        m25677e();
        PixQrCodeQueryResp.QRCodeData qRCodeData = this.f33798z;
        if (!(qRCodeData == null || (key = qRCodeData.getKey()) == null)) {
            ((AmountEditVM) getVm()).triggerRealtimePush(key, 2);
        }
        return super.onBackKeyPressed();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((AmountEditVM) getVm()).stopCountTimer();
    }

    /* renamed from: e */
    private final void m25677e() {
        Pair[] pairArr = new Pair[3];
        CharSequence text = getAmountInputEt().getText();
        pairArr[0] = TuplesKt.m41339to("if_input", Integer.valueOf(((text == null || text.length() == 0) ? 1 : 0) ^ 1));
        pairArr[1] = TuplesKt.m41339to("pub_page", "pix_transfer");
        pairArr[2] = TuplesKt.m41339to("pub_from_page", "");
        FinOmegaSDK.trackEvent("fin_pix_transfer_return_ck", MapsKt.mutableMapOf(pairArr));
    }
}
