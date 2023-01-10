package com.didi.global.fintech.cashier.fastpay.presenter;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayBaseProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayDialogProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayOrderProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPaySettingProcessor;
import com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayCorePresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPaySubmitQuizResponse;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.Constants;

@Metadata(mo148867d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002032\u0006\u00104\u001a\u000207H\u0016J'\u00108\u001a\u0004\u0018\u0001H9\"\b\b\u0000\u00109*\u00020+2\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H90*H\u0002¢\u0006\u0002\u0010;J\u0012\u0010<\u001a\u0002032\b\u0010=\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010>\u001a\u000203H\u0016J\b\u0010?\u001a\u000203H\u0016J\u0010\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u0002032\u0006\u0010A\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u0002032\u0006\u0010A\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u0002032\u0006\u0010A\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u0002032\u0006\u0010A\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u0002032\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u0002032\u0006\u0010A\u001a\u00020QH\u0016J \u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020+2\u000e\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*H\u0004J\u0010\u0010T\u001a\u0002032\u0006\u00104\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u0002032\u0006\u00104\u001a\u00020UH\u0016J\u0010\u0010W\u001a\u0002032\u0006\u00104\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u0002032\u0006\u00104\u001a\u00020ZH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\"\u0010(\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020+0*\u0012\u0004\u0012\u00020+0)X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006["}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayCorePresenter;", "Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayNetPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCorePresenter;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "actionInterceptor", "Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "getActionInterceptor", "()Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "setActionInterceptor", "(Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;)V", "<set-?>", "Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "curFastPayStatus", "getCurFastPayStatus", "()Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "setCurFastPayStatus", "(Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;)V", "fastPayParam", "Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "getFastPayParam", "()Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "setFastPayParam", "(Lcom/didi/global/fintech/cashier/user/model/FastPayParam;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "mAppId", "", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mProductId", "getMProductId", "setMProductId", "mSyncStatusStrategy", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "processors", "", "Ljava/lang/Class;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "refreshed", "", "getRefreshed", "()Z", "setRefreshed", "(Z)V", "changeFastPayLimit", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "changeFastPayOrder", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "getProcessor", "T", "clazz", "(Ljava/lang/Class;)Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "init", "param", "initNet", "onBind", "onChangePayLimitResponse", "response", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "onChangePayOrderResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "onFastPayInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "onFastPayOrderResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "onFastPayStatusResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "onRequestFailed", "api", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter$API;", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSubmitQuizResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;", "registerProcessor", "processor", "requestFastPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "requestFastPayOrder", "submitQuestionnaire", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "switchFastPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPayCorePresenter.kt */
public abstract class FastPayCorePresenter extends FastPayNetPresenter implements IFastPayCorePresenter {

    /* renamed from: a */
    private final LifecycleOwner f23432a;

    /* renamed from: b */
    private SyncStatusStrategy f23433b;

    /* renamed from: c */
    private CashierActionInterceptor f23434c;

    /* renamed from: d */
    private FastPayParam f23435d;

    /* renamed from: e */
    private boolean f23436e;

    /* renamed from: f */
    private String f23437f;

    /* renamed from: g */
    private String f23438g;

    /* renamed from: h */
    private volatile FastPayStatus f23439h = FastPayStatus.UNKNOWN;

    /* renamed from: i */
    private Map<Class<? extends IFastPayBaseProcessor>, IFastPayBaseProcessor> f23440i = new LinkedHashMap();

    /* access modifiers changed from: protected */
    public final LifecycleOwner getLifecycleOwner() {
        return this.f23432a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayCorePresenter(Context context, LifecycleOwner lifecycleOwner) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.f23432a = lifecycleOwner;
    }

    /* access modifiers changed from: protected */
    public final CashierActionInterceptor getActionInterceptor() {
        return this.f23434c;
    }

    /* access modifiers changed from: protected */
    public final void setActionInterceptor(CashierActionInterceptor cashierActionInterceptor) {
        this.f23434c = cashierActionInterceptor;
    }

    /* access modifiers changed from: protected */
    public final FastPayParam getFastPayParam() {
        return this.f23435d;
    }

    /* access modifiers changed from: protected */
    public final void setFastPayParam(FastPayParam fastPayParam) {
        this.f23435d = fastPayParam;
    }

    /* access modifiers changed from: protected */
    public final boolean getRefreshed() {
        return this.f23436e;
    }

    /* access modifiers changed from: protected */
    public final void setRefreshed(boolean z) {
        this.f23436e = z;
    }

    /* access modifiers changed from: protected */
    public final String getMProductId() {
        return this.f23437f;
    }

    /* access modifiers changed from: protected */
    public final void setMProductId(String str) {
        this.f23437f = str;
    }

    /* access modifiers changed from: protected */
    public final String getMAppId() {
        return this.f23438g;
    }

    /* access modifiers changed from: protected */
    public final void setMAppId(String str) {
        this.f23438g = str;
    }

    /* access modifiers changed from: protected */
    public final FastPayStatus getCurFastPayStatus() {
        return this.f23439h;
    }

    /* access modifiers changed from: protected */
    public final synchronized void setCurFastPayStatus(FastPayStatus fastPayStatus) {
        Intrinsics.checkNotNullParameter(fastPayStatus, "<set-?>");
        this.f23439h = fastPayStatus;
    }

    /* access modifiers changed from: protected */
    public final void registerProcessor(IFastPayBaseProcessor iFastPayBaseProcessor, Class<? extends IFastPayBaseProcessor> cls) {
        Intrinsics.checkNotNullParameter(iFastPayBaseProcessor, Constants.BUNDLE_NATIVECODE_PROCESSOR);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.f23440i.put(cls, iFastPayBaseProcessor);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <T extends IFastPayBaseProcessor> T m19195a(Class<T> cls) {
        T t = this.f23440i.get(cls);
        if (t instanceof IFastPayBaseProcessor) {
            return (IFastPayBaseProcessor) t;
        }
        return null;
    }

    public void onBind() {
        this.f23434c = new CashierActionInterceptor((String) null, 1, (DefaultConstructorMarker) null);
    }

    public void init(FastPayParam fastPayParam) {
        initNet();
        this.f23435d = fastPayParam;
        CashierOmegaUtils.Companion.setUid(CashierFacade.Companion.getInstance().getInitConfig().getUid());
    }

    public void initNet() {
        setParamsProcessor(new GlobalCommonParamsProcessor("", ParamsHelper.NATIVE));
    }

    public void requestFastPayInfo(FastPayInfoRequest fastPayInfoRequest) {
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        getFastPayInfo(fastPayInfoRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void requestFastPayOrder(FastPayInfoRequest fastPayInfoRequest) {
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        getPayOrder(fastPayInfoRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void changeFastPayOrder(ChangePayOrderRequest changePayOrderRequest) {
        Intrinsics.checkNotNullParameter(changePayOrderRequest, "request");
        changePayOrder(changePayOrderRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void changeFastPayLimit(ChangePayLimitRequest changePayLimitRequest) {
        Intrinsics.checkNotNullParameter(changePayLimitRequest, "request");
        changePayLimit(changePayLimitRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void switchFastPayStatus(FastPayStatusRequest fastPayStatusRequest) {
        Intrinsics.checkNotNullParameter(fastPayStatusRequest, "request");
        setFastPayStatus(fastPayStatusRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void submitQuestionnaire(FastPaySubmitQuizRequest fastPaySubmitQuizRequest) {
        Intrinsics.checkNotNullParameter(fastPaySubmitQuizRequest, "request");
        FastPayCorePresenter fastPayCorePresenter = this;
        List<String> answer_id_list = fastPaySubmitQuizRequest.getAnswer_id_list();
        boolean z = true;
        if (answer_id_list == null || !answer_id_list.isEmpty()) {
            z = false;
        }
        if ((z ? this : null) == null) {
            submitOffQuiz(fastPaySubmitQuizRequest);
            IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
            if (iFastPayOperateProcessor != null) {
                IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
            }
        }
    }

    public void onFastPayInfoResponse(FastPayInfoResponse fastPayInfoResponse) {
        Intrinsics.checkNotNullParameter(fastPayInfoResponse, "response");
        this.f23439h = FastPayStatus.Companion.value(fastPayInfoResponse.getSwitchStatus());
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPaySettingProcessor iFastPaySettingProcessor = (IFastPaySettingProcessor) m19195a(IFastPaySettingProcessor.class);
        if (iFastPaySettingProcessor != null) {
            iFastPaySettingProcessor.onPayInfoSuccess(fastPayInfoResponse);
        }
    }

    public void onFastPayOrderResponse(FastPayOrderResponse fastPayOrderResponse) {
        Intrinsics.checkNotNullParameter(fastPayOrderResponse, "response");
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPayOrderProcessor iFastPayOrderProcessor = (IFastPayOrderProcessor) m19195a(IFastPayOrderProcessor.class);
        if (iFastPayOrderProcessor != null) {
            iFastPayOrderProcessor.onPayOrderSuccess(fastPayOrderResponse);
        }
    }

    public void onChangePayOrderResponse(ChangePayOrderResponse changePayOrderResponse) {
        Intrinsics.checkNotNullParameter(changePayOrderResponse, "response");
        this.f23436e = true;
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPayOrderProcessor iFastPayOrderProcessor = (IFastPayOrderProcessor) m19195a(IFastPayOrderProcessor.class);
        if (iFastPayOrderProcessor != null) {
            iFastPayOrderProcessor.onChangeOrderChangeSuccess(changePayOrderResponse);
        }
    }

    public void onChangePayLimitResponse(ChangePayLimitResponse changePayLimitResponse) {
        IFastPayOperateProcessor iFastPayOperateProcessor;
        Intrinsics.checkNotNullParameter(changePayLimitResponse, "response");
        String toast = changePayLimitResponse.getToast();
        if (!(toast == null || (iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class)) == null)) {
            IFastPayOperateProcessor.DefaultImpls.toast$default(iFastPayOperateProcessor, toast, false, 2, (Object) null);
        }
        CashierActionInterceptor cashierActionInterceptor = this.f23434c;
        if (cashierActionInterceptor != null) {
            cashierActionInterceptor.intercept(getContext(), this.f23432a, changePayLimitResponse.getNextStep(), new FastPayCorePresenter$onChangePayLimitResponse$2(this), new FastPayCorePresenter$onChangePayLimitResponse$3(this, changePayLimitResponse));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFastPayStatusResponse(com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse r9) {
        /*
            r8 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = r8
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter r0 = (com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter) r0
            java.lang.String r0 = r9.getSwitchStatus()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0021
        L_0x0013:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x001d
            r0 = 1
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 != r2) goto L_0x0011
            r0 = 1
        L_0x0021:
            if (r0 == 0) goto L_0x0025
            r0 = r8
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter r0 = (com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter) r0
            if (r0 != 0) goto L_0x002b
            goto L_0x003b
        L_0x002b:
            r8.setRefreshed(r2)
            com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus$Companion r0 = com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus.Companion
            java.lang.String r3 = r9.getSwitchStatus()
            com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus r0 = r0.value(r3)
            r8.setCurFastPayStatus(r0)
        L_0x003b:
            java.lang.String r0 = r9.getToast()
            java.lang.Class<com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor> r0 = com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor.class
            com.didi.global.fintech.cashier.fastpay.api.IFastPayBaseProcessor r0 = r8.m19195a(r0)
            com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor r0 = (com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor) r0
            if (r0 != 0) goto L_0x004a
            goto L_0x004d
        L_0x004a:
            r0.dismissLoading()
        L_0x004d:
            com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor r0 = r8.f23434c
            if (r0 != 0) goto L_0x0052
            goto L_0x0074
        L_0x0052:
            android.content.Context r3 = r8.getContext()
            androidx.lifecycle.LifecycleOwner r4 = r8.f23432a
            com.didi.global.fintech.cashier.model.net.request.CashierAction r5 = r9.getNextStep()
            r6 = 2
            kotlin.jvm.functions.Function0[] r6 = new kotlin.jvm.functions.Function0[r6]
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$4 r7 = new com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$4
            r7.<init>(r8)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r6[r1] = r7
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$5 r1 = new com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$5
            r1.<init>(r8, r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r6[r2] = r1
            r0.intercept(r3, r4, r5, r6)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter.onFastPayStatusResponse(com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse):void");
    }

    public void onSubmitQuizResponse(FastPaySubmitQuizResponse fastPaySubmitQuizResponse) {
        Intrinsics.checkNotNullParameter(fastPaySubmitQuizResponse, "response");
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
    }

    public void onRequestFailed(IFastPayNetPresenter.API api, CashierError cashierError) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(cashierError, "error");
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m19195a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPayDialogProcessor iFastPayDialogProcessor = (IFastPayDialogProcessor) m19195a(IFastPayDialogProcessor.class);
        if (iFastPayDialogProcessor != null) {
            iFastPayDialogProcessor.netError(CashierError.Companion.getNET_ERROR(), api);
        }
        SystemUtils.log(4, "Arirus", "onRequestFailed: " + api + " 请求失败", (Throwable) null, "com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter", 176);
    }
}
