package com.didi.component.expectation.impl;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.work.PeriodicWorkRequest;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.FormatUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.expectation.AbsExpectationPresenter;
import com.didi.component.expectation.IExpectationView;
import com.didi.component.expectation.model.ExpectationData;
import com.didi.component.expectation.model.MatchingState;
import com.didi.component.expectation.model.ProgressState;
import com.didi.component.expectation.model.UsePrivilege;
import com.didi.component.expectation.model.UsePrivilegeMatchingState;
import com.didi.component.expectation.view.FlexRaiseDialogView;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didi.travel.psnger.utils.TextUtil;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.travel.util.CollectionUtils;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class ExpectationPresenter extends AbsExpectationPresenter<IExpectationView> implements IXpCardLifeCycle, IXpCompRefresh, XpNewAdapter {

    /* renamed from: A */
    private static final int f15446A = 2;

    /* renamed from: D */
    private static final int f15447D = 400;

    /* renamed from: E */
    private static final float f15448E = 4.0f;

    /* renamed from: F */
    private static final int f15449F = 66;

    /* renamed from: G */
    private static final float f15450G = 8.0f;

    /* renamed from: S */
    private static final int f15451S = 1;

    /* renamed from: b */
    private static final String f15452b = "ExpectationPresenter";

    /* renamed from: d */
    private static final int f15453d = 100;

    /* renamed from: e */
    private static final int f15454e = 1000;

    /* renamed from: f */
    private static final int f15455f = 300000;

    /* renamed from: z */
    private static final int f15456z = 0;

    /* renamed from: B */
    private int f15457B = 0;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f15458C = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f15459H = true;

    /* renamed from: I */
    private int f15460I;

    /* renamed from: J */
    private boolean f15461J = false;

    /* renamed from: K */
    private CountDownTimer f15462K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f15463L;

    /* renamed from: M */
    private int f15464M = 0;

    /* renamed from: N */
    private boolean f15465N;

    /* renamed from: O */
    private boolean f15466O = false;

    /* renamed from: P */
    private ProgressState f15467P;

    /* renamed from: Q */
    private boolean f15468Q = false;

    /* renamed from: R */
    private FlexRaiseDialogView f15469R;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public final Handler f15470T = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ExpectationPresenter.this.m12792q();
                ExpectationPresenter.this.f15470T.sendEmptyMessageDelayed(1, 30000);
            }
        }
    };

    /* renamed from: a */
    long f15471a = 400;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Logger f15472c = LoggerFactory.getLogger(f15452b);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ExpectationData f15473g;

    /* renamed from: h */
    private CountDownTimer f15474h;

    /* renamed from: i */
    private CountDownTimer f15475i;

    /* renamed from: j */
    private CountDownTimer f15476j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f15477k = 0;

    /* renamed from: l */
    private long f15478l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f15479m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f15480n = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f15481p = 0;

    /* renamed from: q */
    private BusinessContext f15482q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public LEGODrawer f15483r;

    /* renamed from: s */
    private boolean f15484s = false;

    /* renamed from: t */
    private int f15485t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f15486u;

    /* renamed from: v */
    private int f15487v = -1;

    /* renamed from: w */
    private final ExpectationModel<ExpectationPresenter> f15488w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f15489x = 0;

    /* renamed from: y */
    private long f15490y = 0;

    interface TimeCountCallBack {
        void onFinish();

        void onProgress(float f);
    }

    /* renamed from: D */
    static /* synthetic */ long m12723D(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f15478l;
        expectationPresenter.f15478l = 1 + j;
        return j;
    }

    /* renamed from: E */
    static /* synthetic */ long m12724E(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f15490y;
        expectationPresenter.f15490y = 1 + j;
        return j;
    }

    /* renamed from: F */
    static /* synthetic */ long m12725F(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f15490y;
        expectationPresenter.f15490y = j - 1;
        return j;
    }

    /* renamed from: v */
    static /* synthetic */ long m12797v(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f15479m;
        expectationPresenter.f15479m = 1 + j;
        return j;
    }

    /* renamed from: w */
    static /* synthetic */ long m12798w(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f15479m;
        expectationPresenter.f15479m = j - 1;
        return j;
    }

    /* renamed from: x */
    static /* synthetic */ long m12799x(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f15477k;
        expectationPresenter.f15477k = 1 + j;
        return j;
    }

    /* renamed from: y */
    static /* synthetic */ int m12800y(ExpectationPresenter expectationPresenter) {
        int i = expectationPresenter.f15489x;
        expectationPresenter.f15489x = i + 1;
        return i;
    }

    public ExpectationPresenter(ComponentParams componentParams) {
        super(componentParams.bizCtx.getContext());
        this.f15482q = componentParams.bizCtx;
        ExpectationModel<ExpectationPresenter> expectationModel = new ExpectationModel<>();
        this.f15488w = expectationModel;
        expectationModel.setPresenter(this);
    }

    public void onFinishAnimate(int i) {
        m12756b();
        if (i > 0 && this.f15473g != null) {
            ((IExpectationView) this.mView).finishProgressBar(m12773h(), i);
        }
    }

    public void onFlexClick() {
        if (this.f15473g.flex_raise == null || this.f15473g.flex_raise.raise_sheet == null) {
            this.f15472c.info(" raise_sheet is null", new Object[0]);
            return;
        }
        this.f15469R = FlexRaiseDialogView.newInstance(this.f15473g.flex_raise.raise_sheet);
        if (!(this.mContext == null || ((FragmentActivity) this.mContext).getSupportFragmentManager() == null)) {
            this.f15469R.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "flexRaiseDialogView");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "raisefare");
        if (!(this.f15473g.flex_raise.raise_sheet == null || this.f15473g.flex_raise.raise_sheet.config == null)) {
            hashMap.put("price", this.f15473g.flex_raise.raise_sheet.config.current_price);
        }
        hashMap.put("time", Integer.valueOf(m12767e()));
        if (!(this.f15473g.flex_raise.raise_sheet == null || this.f15473g.flex_raise.raise_sheet.config == null)) {
            hashMap.put("price", this.f15473g.flex_raise.raise_sheet.config.current_price);
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_ck", (Map<String, Object>) hashMap);
    }

    public void onTipsClick() {
        OmegaUtils.trackEvent("ibt_gp_waitforresponse_whywait_ck");
        LEGODrawer lEGODrawer = this.f15483r;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(this.mContext.getString(R.string.GRider_0930_Just_a_rzTo), new LEGOBtnTextAndCallback(this.mContext.getString(R.string.GRider_0930_I_see_MOst), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (ExpectationPresenter.this.f15483r != null) {
                    ExpectationPresenter.this.f15483r.dismiss();
                }
            }
        }));
        lEGODrawerModel1.setSubTitle(this.mContext.getString(R.string.GRider_0930_We_use_ZQLn));
        this.f15483r = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
    }

    public void processDuseInfo(ExpectationManagementModel expectationManagementModel) {
        if (expectationManagementModel != null) {
            if (this.f15473g.skip_push == 1) {
                this.f15472c.info("skip_duse_push ", new Object[0]);
                return;
            }
            try {
                int i = expectationManagementModel.duse_status;
                int i2 = expectationManagementModel.driver_num;
                String str = expectationManagementModel.use_pmsg == 1 ? expectationManagementModel.pmsg : null;
                String str2 = expectationManagementModel.oid_base64;
                if (i == 1) {
                    if (TextUtils.isEmpty(str) && i2 > 0) {
                        str = this.mContext.getResources().getString(R.string.global_wait_4_resp_drivers_founds, new Object[]{Integer.valueOf(i2)});
                    }
                    m12780k();
                    if (!TextUtils.isEmpty(str)) {
                        m12746a(str);
                    }
                    if (this.f15487v == 2 && !TextUtils.isEmpty(this.f15486u)) {
                        int e = m12767e();
                        if (this.f15473g != null) {
                            if (m12785n() == 2) {
                                e = m12787o();
                            } else {
                                e = m12767e();
                            }
                        }
                        if (e < this.f15485t) {
                            m12738a(this.f15485t - e, (TimeCountCallBack) new TimeCountCallBack() {
                                public void onProgress(float f) {
                                    ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                    expectationPresenter.m12763c(expectationPresenter.f15473g.getMatchingStateList().get(ExpectationPresenter.this.f15481p));
                                    if (ExpectationPresenter.this.m12785n() == 2) {
                                        ExpectationPresenter expectationPresenter2 = ExpectationPresenter.this;
                                        expectationPresenter2.m12766d(expectationPresenter2.f15473g.getMatchingStateList().get(ExpectationPresenter.this.f15481p));
                                    }
                                }

                                public void onFinish() {
                                    ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                    expectationPresenter.m12746a(expectationPresenter.f15486u);
                                }
                            }, m12773h());
                        } else {
                            m12746a(this.f15486u);
                        }
                    }
                } else if (i != 2) {
                    if (i == 3) {
                        if (TextUtils.isEmpty(str)) {
                            str = ResourcesHelper.getString(this.mContext, R.string.global_wait_4_resp_driver_matching);
                        }
                        m12780k();
                        m12746a(str);
                        if (expectationManagementModel.showtime > 0) {
                            m12738a(expectationManagementModel.showtime, (TimeCountCallBack) new TimeCountCallBack() {
                                public void onProgress(float f) {
                                    if (ExpectationPresenter.this.f15473g == null || ExpectationPresenter.this.f15473g.getMatchingStateList() == null || ExpectationPresenter.this.f15473g.getMatchingStateList().size() <= ExpectationPresenter.this.f15481p) {
                                        ExpectationPresenter.this.f15472c.info("ExpectationData MatchingStateList size < mMatchingStep", new Object[0]);
                                        return;
                                    }
                                    ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                    expectationPresenter.m12763c(expectationPresenter.f15473g.getMatchingStateList().get(ExpectationPresenter.this.f15481p));
                                    if (ExpectationPresenter.this.m12785n() == 2) {
                                        ExpectationPresenter expectationPresenter2 = ExpectationPresenter.this;
                                        expectationPresenter2.m12766d(expectationPresenter2.f15473g.getMatchingStateList().get(ExpectationPresenter.this.f15481p));
                                    }
                                }

                                public void onFinish() {
                                    ExpectationPresenter.this.doPublish(BaseEventKeys.Expectation.EVENT_EXPECTATION_DUSE_BROADCAST_FAIL);
                                    CarOrder order = CarOrderHelper.getOrder();
                                    if (order != null) {
                                        long unused = ExpectationPresenter.this.f15477k = (TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - order.getCreateTime()) / 1000;
                                        ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                        int b = expectationPresenter.m12731a(expectationPresenter.f15477k);
                                        if (ExpectationPresenter.this.f15473g != null) {
                                            if (ExpectationPresenter.this.m12785n() == 2) {
                                                ExpectationPresenter expectationPresenter2 = ExpectationPresenter.this;
                                                b = expectationPresenter2.m12731a((long) expectationPresenter2.m12787o());
                                            } else {
                                                ExpectationPresenter expectationPresenter3 = ExpectationPresenter.this;
                                                b = expectationPresenter3.m12731a(expectationPresenter3.f15477k);
                                            }
                                        }
                                        MatchingState a = ExpectationPresenter.this.m12733a(b);
                                        if (a != null) {
                                            ExpectationPresenter.this.m12758b(a);
                                        }
                                    }
                                }
                            }, m12773h());
                        }
                    }
                } else if (this.f15473g == null || this.f15473g.getExpectationManagementModel() == null) {
                    if (expectationManagementModel.use_pmsg == 1 && expectationManagementModel.wait_time > 0 && !TextUtil.isEmpty(expectationManagementModel.pmsg)) {
                        this.f15485t = expectationManagementModel.wait_time;
                        this.f15486u = expectationManagementModel.pmsg;
                    }
                }
                this.f15487v = i;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BusinessContext getBizContext() {
        return this.f15482q;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        int i = bundle.getInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 0);
        this.f15460I = i;
        if (i == 0) {
            this.f15484s = true;
        }
        this.f15468Q = false;
        m12749a(false);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        ExpectationData expectationData = this.f15473g;
        if (!(expectationData == null || expectationData.carRequestingBubbleTip == null)) {
            ((IExpectationView) this.mView).closeAnyCarTipComplete(this.f15473g.carRequestingBubbleTip.bubbleId);
        }
        onCardRemove();
        this.f15468Q = false;
    }

    /* renamed from: b */
    private void m12756b() {
        m12776i();
        m12778j();
        m12780k();
    }

    /* renamed from: c */
    private void m12761c() {
        int i;
        int i2;
        if (this.f15484s) {
            this.f15477k = 0;
            this.f15479m = 0;
            this.f15484s = false;
        } else {
            this.f15477k = (long) m12767e();
            this.f15479m = (long) m12767e();
            this.f15478l = (long) m12767e();
        }
        if (m12785n() == 2) {
            this.f15489x = m12787o();
            this.f15490y = (long) m12787o();
            this.f15458C = true;
            this.f15478l = (long) m12787o();
        }
        if (m12785n() == 2) {
            i = m12731a((long) this.f15489x);
        } else {
            i = m12731a(this.f15477k);
        }
        if (m12785n() == 2) {
            i2 = m12751b((long) this.f15489x);
        } else {
            i2 = m12751b(this.f15477k);
        }
        if (m12773h() == 1 && !this.f15466O) {
            this.f15479m = ((long) this.f15473g.getTotalWaitTime()) - this.f15479m;
            if (m12785n() == 2) {
                this.f15490y = ((long) this.f15473g.getTotalWaitTime()) - this.f15490y;
            }
        }
        if (this.f15466O) {
            ((IExpectationView) this.mView).setAnyCarRequestingList(this.f15473g.carRequestingList);
            ((IExpectationView) this.mView).showAnyCarRequestTip(this.f15473g.carRequestingBubbleTip);
        }
        MatchingState a = m12733a(i);
        if (a != null) {
            m12758b(a);
        }
        if (m12785n() != 2 || m12787o() < this.f15473g.getTotalWaitTime()) {
            ProgressState b = m12755b(i2);
            if (b != null) {
                m12744a(b);
            }
            m12790p();
        }
    }

    /* renamed from: d */
    private void m12765d() {
        ((IExpectationView) this.mView).setAnyCarRequestingList(this.f15473g.carRequestingList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12746a(String str) {
        ((IExpectationView) this.mView).setTitleText(str);
        doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_UPDATE_TITLE, str);
    }

    /* renamed from: a */
    private void m12743a(MatchingState matchingState) {
        Objects.requireNonNull(matchingState);
        LEGORichInfo titleInfo = matchingState.getTitleInfo();
        String str = null;
        CharSequence parseRichInfo = Preconditions.nonNull(titleInfo) ? titleInfo.parseRichInfo(m12783m()) : null;
        if (TextUtils.isEmpty(parseRichInfo)) {
            parseRichInfo = matchingState.getTitle();
        }
        IExpectationView iExpectationView = (IExpectationView) this.mView;
        if (Preconditions.nonNull(iExpectationView)) {
            iExpectationView.setTitleText(parseRichInfo);
            iExpectationView.setTimeDes(matchingState.getTimeDes());
        }
        if (Preconditions.nonNull(parseRichInfo)) {
            str = parseRichInfo.toString();
        }
        doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_UPDATE_TITLE, str);
    }

    /* renamed from: e */
    private int m12767e() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.getCreateTime() <= 0) {
            return 0;
        }
        Logger logger = this.f15472c;
        logger.info("getOrderSpendTime: isNTPEnabled() " + TimeServiceManager.getInstance().isNTPEnabled() + " isNTPAvailable() " + TimeServiceManager.getInstance().isNTPAvailable(), new Object[0]);
        Logger logger2 = this.f15472c;
        StringBuilder sb = new StringBuilder();
        sb.append("getOrderSpendTime: order.getCreateTime() ");
        sb.append(order.getCreateTime());
        logger2.info(sb.toString(), new Object[0]);
        Logger logger3 = this.f15472c;
        logger3.info("getOrderSpendTime: diff " + TimeServiceManager.getInstance().getNTPTimeDiffMillis() + " npttime " + TimeServiceManager.getInstance().getNTPCurrenTimeMillis() + " System.currentTimeMillis() " + System.currentTimeMillis(), new Object[0]);
        Logger logger4 = this.f15472c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getOrderSpendTime() CarOrder ");
        sb2.append((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - order.getCreateTime()) / 1000);
        logger4.info(sb2.toString(), new Object[0]);
        return (int) ((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - order.getCreateTime()) / 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m12731a(long j) {
        this.f15481p = 0;
        ExpectationData expectationData = this.f15473g;
        if (expectationData == null || expectationData.getMatchingStateList() == null || j <= 0) {
            return -1;
        }
        for (MatchingState next : this.f15473g.getMatchingStateList()) {
            if (j < ((long) next.getTimeInterval())) {
                break;
            }
            this.f15481p++;
            j -= (long) next.getTimeInterval();
        }
        if (this.f15481p == this.f15473g.getMatchingStateList().size()) {
            return -1;
        }
        return (int) j;
    }

    /* renamed from: b */
    private int m12751b(long j) {
        this.f15480n = 0;
        ExpectationData expectationData = this.f15473g;
        if (expectationData == null || expectationData.getProgressStateList() == null || j <= 0) {
            return -1;
        }
        for (ProgressState next : this.f15473g.getProgressStateList()) {
            if (j < ((long) next.getTimeInterval())) {
                break;
            }
            this.f15480n++;
            j -= (long) next.getTimeInterval();
        }
        if (this.f15480n == this.f15473g.getProgressStateList().size()) {
            return -1;
        }
        return (int) j;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MatchingState m12733a(int i) {
        ExpectationData expectationData = this.f15473g;
        if (expectationData == null || expectationData.getMatchingStateList() == null || this.f15473g.getMatchingStateList().size() <= 0) {
            return null;
        }
        if (this.f15481p >= this.f15473g.getMatchingStateList().size()) {
            this.f15481p = this.f15473g.getMatchingStateList().size() - 1;
        }
        MatchingState matchingState = this.f15473g.getMatchingStateList().get(this.f15481p);
        if (i > 0 && matchingState != null) {
            matchingState.setTimeInterval(matchingState.getTimeInterval() - i);
        }
        return matchingState;
    }

    /* renamed from: b */
    private ProgressState m12755b(int i) {
        ExpectationData expectationData = this.f15473g;
        if (expectationData == null || expectationData.getProgressStateList() == null || this.f15480n >= this.f15473g.getProgressStateList().size()) {
            return null;
        }
        ProgressState progressState = this.f15473g.getProgressStateList().get(this.f15480n);
        this.f15467P = progressState;
        if (i > 0 && progressState != null) {
            progressState.setStartProgress(((progressState.getEndProgress() - progressState.getStartProgress()) * (((float) i) / ((float) progressState.getTimeInterval()))) + progressState.getStartProgress());
            progressState.setTimeInterval(progressState.getTimeInterval() - i);
        }
        return progressState;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public MatchingState m12769f() {
        this.f15481p++;
        return m12733a(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public ProgressState m12772g() {
        this.f15480n++;
        return m12755b(0);
    }

    public void iconClick(String str) {
        DRouter.build(str).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12758b(final MatchingState matchingState) {
        if (matchingState != null) {
            m12743a(matchingState);
            if (m12785n() != 2) {
                GlobalRichInfo subtitleRich = matchingState.getSubtitleRich();
                CharSequence parseRichInfo = Preconditions.nonNull(subtitleRich) ? subtitleRich.parseRichInfo(m12783m()) : null;
                if (TextUtils.isEmpty(parseRichInfo)) {
                    parseRichInfo = matchingState.getSubtitle();
                }
                if (TextUtils.isEmpty(parseRichInfo)) {
                    ((IExpectationView) this.mView).hideSubTitleText();
                } else {
                    ((IExpectationView) this.mView).setSubTitleText(parseRichInfo);
                }
            } else if (matchingState.getSubtitleRich() == null || TextUtil.isEmpty(matchingState.getSubtitleRich().getContent())) {
                ((IExpectationView) this.mView).hideSubTitleText();
            } else {
                m12766d(matchingState);
            }
            if (TextUtils.isEmpty(matchingState.getCaption())) {
                ((IExpectationView) this.mView).hideCaptionText();
            } else {
                ((IExpectationView) this.mView).setCaptionText(matchingState.getCaption().replace("\\n", "\n").replace("%@", "00:00"));
                ((IExpectationView) this.mView).setTipsBackground((Drawable) null);
            }
            if (matchingState.getTipsText() == null || TextUtils.isEmpty(matchingState.getTipsText().getContent())) {
                ((IExpectationView) this.mView).hideTips();
            } else {
                ((IExpectationView) this.mView).setTips(matchingState.getTipsText(), matchingState.getRightIcon(), matchingState.getRightIconClick());
                if (m12785n() == 2) {
                    ((IExpectationView) this.mView).setTipsBackground(ContextCompat.getDrawable(this.mContext, R.drawable.tips_background));
                } else {
                    ((IExpectationView) this.mView).setTipsBackground((Drawable) null);
                }
            }
            ((IExpectationView) this.mView).setMainIcon(WebpLocResEnum.getEnum(matchingState.getAnimationImageType()));
            m12780k();
            m12738a(matchingState.getTimeInterval(), (TimeCountCallBack) new TimeCountCallBack() {
                public void onProgress(float f) {
                    ExpectationPresenter.this.m12763c(matchingState);
                    if (ExpectationPresenter.this.m12785n() == 2) {
                        ExpectationPresenter.this.m12766d(matchingState);
                    }
                }

                public void onFinish() {
                    MatchingState i = ExpectationPresenter.this.m12769f();
                    if (i != null) {
                        ExpectationPresenter.this.m12758b(i);
                    }
                }
            }, m12773h());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12744a(ProgressState progressState) {
        if (progressState != null) {
            boolean z = true;
            if (this.f15466O && progressState.getCountOrder() == 1) {
                this.f15479m = (long) progressState.getTimeInterval();
            }
            if (this.f15473g != null) {
                if (m12785n() == 2) {
                    ((IExpectationView) this.mView).setWaitProgressBar(progressState.getStartProgress(), progressState, this.f15480n);
                    ((IExpectationView) this.mView).showThumb(progressState.getProcessIconUri(), progressState.getProcessIconType(), progressState.getStartProgress(), progressState.getEndProgress(), progressState.getTimeInterval(), this.f15458C, this.f15480n, m12787o(), this.f15473g.getTotalWaitTime());
                    ((IExpectationView) this.mView).shakeGiftBox(4.0f, 400, -1, this.f15480n, (Animator.AnimatorListener) null);
                } else {
                    ((IExpectationView) this.mView).setProgressBar(progressState.getStartProgress());
                }
            }
            m12776i();
            if (progressState.getEndProgress() != progressState.getStartProgress()) {
                m12736a(progressState.getStartProgress(), progressState.getEndProgress(), progressState.getTimeInterval());
            }
            m12778j();
            if (progressState.getShowTime() != 1) {
                ((IExpectationView) this.mView).hideTime();
            } else if (m12785n() == 2) {
                ((IExpectationView) this.mView).hideTime();
            } else {
                ExpectationData expectationData = this.f15473g;
                ((IExpectationView) this.mView).setTimes(FormatUtils.formatTime(this.f15479m), (expectationData == null || TextUtils.isEmpty(expectationData.getTimePreFix())) ? "" : this.f15473g.getTimePreFix());
            }
            if (progressState.getTimeInterval() != -1) {
                int timeInterval = progressState.getTimeInterval();
                int h = m12773h();
                if (progressState.getShowTime() != 1) {
                    z = false;
                }
                m12737a(timeInterval, h, z);
            }
        }
    }

    /* renamed from: h */
    private int m12773h() {
        ExpectationData expectationData = this.f15473g;
        if (expectationData == null) {
            return 0;
        }
        if (this.f15467P == null && expectationData.getProgressStateList() != null && this.f15473g.getProgressStateList().size() > 0) {
            this.f15467P = this.f15473g.getProgressStateList().get(0);
        }
        ProgressState progressState = this.f15467P;
        if (progressState == null || progressState.getCountOrder() == -1000) {
            return this.f15473g.getCountOrder();
        }
        return this.f15467P.getCountOrder();
    }

    /* renamed from: a */
    private void m12736a(final float f, final float f2, int i) {
        m12776i();
        final C62895 r6 = new TimeCountCallBack() {
            public void onProgress(float f) {
                if (ExpectationPresenter.this.m12785n() == 2) {
                    float f2 = f;
                    ((IExpectationView) ExpectationPresenter.this.mView).setWaitProgressBar(f2 + ((f2 - f2) * f), ExpectationPresenter.this.f15473g.getProgressStateList().get(ExpectationPresenter.this.f15480n), ExpectationPresenter.this.f15480n);
                    if (f2 == 1.0f && ExpectationPresenter.this.f15459H && ((double) f) > 0.95d) {
                        ((IExpectationView) ExpectationPresenter.this.mView).shakeGiftBox(8.0f, 66, 0, ExpectationPresenter.this.f15480n, new Animator.AnimatorListener() {
                            public void onAnimationCancel(Animator animator) {
                            }

                            public void onAnimationRepeat(Animator animator) {
                            }

                            public void onAnimationStart(Animator animator) {
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (animator != null) {
                                    animator.cancel();
                                    animator.removeAllListeners();
                                }
                                if (ExpectationPresenter.this.f15473g != null && ExpectationPresenter.this.f15473g.getCouponInfo() != null) {
                                    ((IExpectationView) ExpectationPresenter.this.mView).openBoxAndShowCoupon(ExpectationPresenter.this.f15473g.getCouponInfo().getDiscount());
                                }
                            }
                        });
                        boolean unused = ExpectationPresenter.this.f15459H = false;
                        return;
                    }
                    return;
                }
                float f3 = f;
                ((IExpectationView) ExpectationPresenter.this.mView).setProgressBar(f3 + ((f2 - f3) * f));
            }

            public void onFinish() {
                if (ExpectationPresenter.this.m12785n() != 2) {
                    ((IExpectationView) ExpectationPresenter.this.mView).setProgressBar(f2);
                } else if (ExpectationPresenter.this.f15480n < ExpectationPresenter.this.f15473g.getProgressStateList().size()) {
                    ((IExpectationView) ExpectationPresenter.this.mView).setWaitProgressBar(f2, ExpectationPresenter.this.f15473g.getProgressStateList().get(ExpectationPresenter.this.f15480n), ExpectationPresenter.this.f15480n);
                } else {
                    ((IExpectationView) ExpectationPresenter.this.mView).setWaitProgressBar(f2, ExpectationPresenter.this.f15473g.getProgressStateList().get(ExpectationPresenter.this.f15473g.getProgressStateList().size() - 1), ExpectationPresenter.this.f15473g.getProgressStateList().size() - 1);
                }
            }
        };
        final int i2 = i;
        this.f15475i = new CountDownTimer((long) (i * 1000), 100) {
            public void onTick(long j) {
                r6.onProgress((float) (1.0d - (((double) (j / ((long) i2))) / 1000.0d)));
            }

            public void onFinish() {
                r6.onFinish();
            }
        }.start();
    }

    /* renamed from: i */
    private void m12776i() {
        CountDownTimer countDownTimer = this.f15475i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* renamed from: a */
    private void m12737a(int i, final int i2, final boolean z) {
        m12778j();
        final C62927 r6 = new TimeCountCallBack() {
            public void onProgress(float f) {
                if (z) {
                    if (ExpectationPresenter.this.m12785n() == 2) {
                        ((IExpectationView) ExpectationPresenter.this.mView).hideTime();
                    } else {
                        ((IExpectationView) ExpectationPresenter.this.mView).setTimes(FormatUtils.formatTime(ExpectationPresenter.this.f15479m), (ExpectationPresenter.this.f15473g == null || TextUtils.isEmpty(ExpectationPresenter.this.f15473g.getTimePreFix())) ? "" : ExpectationPresenter.this.f15473g.getTimePreFix());
                    }
                    if (i2 == 0) {
                        ExpectationPresenter.m12797v(ExpectationPresenter.this);
                    } else {
                        ExpectationPresenter.m12798w(ExpectationPresenter.this);
                    }
                    ExpectationPresenter.m12799x(ExpectationPresenter.this);
                    if (ExpectationPresenter.this.m12785n() == 2) {
                        ExpectationPresenter.m12800y(ExpectationPresenter.this);
                        if (ExpectationPresenter.this.f15473g != null) {
                            ExpectationPresenter.this.f15473g.setWaitedTime(ExpectationPresenter.this.f15489x);
                        }
                    }
                }
            }

            public void onFinish() {
                if (!z) {
                    if (ExpectationPresenter.this.m12785n() == 2) {
                        ((IExpectationView) ExpectationPresenter.this.mView).hideTime();
                    } else {
                        ((IExpectationView) ExpectationPresenter.this.mView).setTimes(FormatUtils.formatTime(ExpectationPresenter.this.f15479m), (ExpectationPresenter.this.f15473g == null || TextUtils.isEmpty(ExpectationPresenter.this.f15473g.getTimePreFix())) ? "" : ExpectationPresenter.this.f15473g.getTimePreFix());
                    }
                }
                ProgressState C = ExpectationPresenter.this.m12772g();
                if (C != null) {
                    if (ExpectationPresenter.this.m12785n() == 2) {
                        boolean unused = ExpectationPresenter.this.f15458C = false;
                    }
                    ExpectationPresenter.this.m12744a(C);
                }
            }
        };
        final int i3 = i;
        this.f15474h = new CountDownTimer((long) (i * 1000), 1000) {
            public void onTick(long j) {
                r6.onProgress((float) (1 - ((j / ((long) i3)) / 1000)));
            }

            public void onFinish() {
                r6.onFinish();
            }
        }.start();
    }

    /* renamed from: j */
    private void m12778j() {
        CountDownTimer countDownTimer = this.f15474h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* renamed from: a */
    private void m12738a(int i, TimeCountCallBack timeCountCallBack, int i2) {
        m12780k();
        final int i3 = i2;
        final TimeCountCallBack timeCountCallBack2 = timeCountCallBack;
        final int i4 = i;
        this.f15476j = new CountDownTimer(i < 0 ? PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS : (long) (i * 1000), 1000) {
            public void onTick(long j) {
                ExpectationPresenter.m12723D(ExpectationPresenter.this);
                if (ExpectationPresenter.this.m12785n() == 2) {
                    if (i3 == 0) {
                        ExpectationPresenter.m12724E(ExpectationPresenter.this);
                    } else {
                        ExpectationPresenter.m12725F(ExpectationPresenter.this);
                    }
                }
                timeCountCallBack2.onProgress((float) (1 - ((j / ((long) i4)) / 1000)));
            }

            public void onFinish() {
                if (i4 >= 0) {
                    timeCountCallBack2.onFinish();
                }
            }
        }.start();
    }

    /* renamed from: k */
    private void m12780k() {
        CountDownTimer countDownTimer = this.f15476j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        JSONObject optJSONObject = jSONObject.optJSONObject("normal");
        if (optJSONObject != null) {
            ExpectationData expectationData = (ExpectationData) GsonUtils.singleGson().fromJson(optJSONObject.optString("data"), ExpectationData.class);
            this.f15473g = expectationData;
            if (expectationData != null) {
                if (expectationData.carRequestingList == null || this.f15473g.carRequestingList.size() <= 0) {
                    this.f15466O = false;
                    ((IExpectationView) this.mView).setIsAnyCar(false);
                    m12749a(false);
                    OmegaSDK.removeGlobalAttr("pub_allbiz");
                } else {
                    this.f15466O = true;
                    ((IExpectationView) this.mView).setIsAnyCar(true);
                    if (!this.f15468Q) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < this.f15473g.carRequestingList.size(); i++) {
                            if (i < this.f15473g.carRequestingList.size() - 1) {
                                sb.append(this.f15473g.carRequestingList.get(i).business_id);
                                sb.append(",");
                            } else {
                                sb.append(this.f15473g.carRequestingList.get(i).business_id);
                            }
                        }
                        OmegaSDK.putGlobalAttr("pub_allbiz", sb.toString());
                        m12749a(true);
                    }
                }
                ((IExpectationView) this.mView).setSceneVisibility(this.f15473g.getSceneType());
                if (this.f15473g.getSceneType() == 2 && this.f15457B != 2) {
                    ((IExpectationView) this.mView).addProgressNode(this.f15473g.getProgressStateList());
                    ((IExpectationView) this.mView).setObtainedCouponViewVisibility(this.f15473g.getWaitedTime(), this.f15473g.getTotalWaitTime());
                    if (this.f15460I == 0 && !CarOrderHelper.isAssignOrder() && this.f15461J) {
                        m12781l();
                    }
                }
                this.f15457B = this.f15473g.getSceneType();
                if (this.f15473g.usePrivilege != null && !this.f15465N) {
                    m12745a(this.f15473g.usePrivilege);
                }
            }
            ExpectationManagementModel expectationManagementModel = Preconditions.nonNull(this.f15473g) ? this.f15473g.getExpectationManagementModel() : null;
            if (Preconditions.nonNull(expectationManagementModel)) {
                processDuseInfo(expectationManagementModel);
            }
            if (CarOrderHelper.getOrderStatus() == 7 && CarOrderHelper.getOrderSubStatus() == 7005) {
                m12761c();
            } else if (CarOrderHelper.getOrderStatus() == 7 && this.f15466O) {
                m12765d();
            }
            ExpectationData expectationData2 = this.f15473g;
            if (!(expectationData2 == null || expectationData2.flex_raise == null)) {
                ((IExpectationView) this.mView).updateFlex(this.f15473g.flex_raise);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "show");
                hashMap.put(RavenKey.VERSION, "raisefare");
                if (!(this.f15473g.flex_raise.raise_sheet == null || this.f15473g.flex_raise.raise_sheet.config == null)) {
                    hashMap.put("price", this.f15473g.flex_raise.raise_sheet.config.current_price);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_sw", (Map<String, Object>) hashMap);
            }
        }
        this.f15468Q = true;
        iXpCardBindDataReadyCallback.ready(true);
    }

    /* renamed from: l */
    private void m12781l() {
        if (this.f15473g != null) {
            if (CarOrderHelper.isAssignOrder()) {
                this.f15484s = true;
            }
            m12761c();
        }
    }

    public void onCardAdd() {
        this.f15488w.subscribe();
        this.f15461J = true;
        m12781l();
    }

    public void onCardRemove() {
        this.f15488w.unSubscribe();
        m12756b();
        ((IExpectationView) this.mView).cancelAnim();
        ((IExpectationView) this.mView).cancelCircleAnim();
        ((IExpectationView) this.mView).setTranslationX(0.0f);
        ((IExpectationView) this.mView).resetViewStatus();
        this.f15459H = true;
        this.f15461J = false;
        this.f15457B = 0;
        this.f15473g = null;
        this.f15465N = false;
        this.f15464M = 0;
        CountDownTimer countDownTimer = this.f15462K;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f15462K = null;
        }
        this.f15470T.removeMessages(1);
        FlexRaiseDialogView flexRaiseDialogView = this.f15469R;
        if (flexRaiseDialogView != null) {
            flexRaiseDialogView.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12763c(MatchingState matchingState) {
        if (!TextUtil.isEmpty(matchingState.getCaption())) {
            String replace = matchingState.getCaption().replace("\\n", "\n").replace("%@", FormatUtils.formatTime(this.f15478l));
            ((IExpectationView) this.mView).setTime(FormatUtils.formatTime(this.f15478l));
            ((IExpectationView) this.mView).setCaptionText(replace);
            ((IExpectationView) this.mView).setTipsBackground((Drawable) null);
        }
    }

    public void compRefresh(int i, String str, int i2, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        if (TextUtils.equals("passenger_newXpanel+bargainingCard_logic+bargaining_card", str)) {
            IExpectationView iExpectationView = (IExpectationView) this.mView;
            if (!Preconditions.isNull(Preconditions.nonNull(iExpectationView) ? iExpectationView.getView() : null)) {
                if (i == 1) {
                    iExpectationView.updateViewByIndriver(true, true, this.f15471a, iXpCompRefreshCb);
                } else if (i == 2) {
                    iExpectationView.updateViewByIndriver(false, true, this.f15471a, iXpCompRefreshCb);
                }
            }
        }
    }

    public void compIds(final List<String> list, int i, final IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        SystemUtils.log(6, "dxt", "mode ==== " + list, (Throwable) null, "com.didi.component.expectation.impl.ExpectationPresenter", 1096);
        if (CollectionUtils.contains(list, ComponentType.RIDE_EXPECTATION)) {
            ((IExpectationView) this.mView).getView().postDelayed(new Runnable() {
                public void run() {
                    if (list.contains("passenger_newXpanel+bargainingCard_logic+bargaining_card")) {
                        ((IExpectationView) ExpectationPresenter.this.mView).updateViewByIndriver(true, false, 100, iXpCompRefreshCb);
                    } else {
                        ((IExpectationView) ExpectationPresenter.this.mView).updateViewByIndriver(false, false, 200, iXpCompRefreshCb);
                    }
                }
            }, this.f15471a);
        }
    }

    /* renamed from: m */
    private Context m12783m() {
        return Preconditions.nonNull(this.mContext) ? this.mContext : DIDIApplication.getAppContext();
    }

    /* renamed from: a */
    private void m12749a(boolean z) {
        TripListener tripListener = PageCompDataTransfer.getInstance().getTripListener();
        if (z || (tripListener != null && tripListener.getIsAnyCar())) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_anycar", 1);
            PubSIDManager.getInstance().setPubSID(hashMap);
            return;
        }
        PubSIDManager.getInstance().removePubSID("is_anycar", 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m12766d(MatchingState matchingState) {
        GlobalRichInfo subtitleRich = matchingState.getSubtitleRich();
        if (subtitleRich != null && !TextUtil.isEmpty(subtitleRich.getContent())) {
            GlobalRichInfo globalRichInfo = new GlobalRichInfo();
            globalRichInfo.setContent(subtitleRich.getContent());
            globalRichInfo.setInfoList(subtitleRich.getInfoList());
            String content = globalRichInfo.getContent();
            if (content.contains("[!!") && content.contains("!!]")) {
                String substring = content.substring(content.indexOf("[!!"), content.indexOf("!!]") + 3);
                String valueOf = String.valueOf(this.f15490y);
                String replace = content.replace(substring, valueOf);
                globalRichInfo.setContent(replace);
                List<GlobalRichInfo.RichInfo> infoList = globalRichInfo.getInfoList();
                if (infoList != null && infoList.size() > 0) {
                    int indexOf = replace.indexOf(valueOf);
                    int length = valueOf.length();
                    GlobalRichInfo.RichInfo richInfo = infoList.get(0);
                    richInfo.start = indexOf;
                    richInfo.length = length;
                    infoList.set(0, richInfo);
                    globalRichInfo.setInfoList(infoList);
                }
            }
            ((IExpectationView) this.mView).setRichSubtitle(globalRichInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public int m12785n() {
        ExpectationData expectationData = this.f15473g;
        if (expectationData != null) {
            return expectationData.getSceneType();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public int m12787o() {
        ExpectationData expectationData = this.f15473g;
        if (expectationData != null) {
            return expectationData.getWaitedTime();
        }
        return 0;
    }

    /* renamed from: a */
    private void m12745a(UsePrivilege usePrivilege) {
        if (CollectionUtils.isNotEmpty((Collection<?>) usePrivilege.mMatchingState)) {
            ((IExpectationView) this.mView).showEquityUI(usePrivilege);
            this.f15465N = true;
            m12747a(usePrivilege.mMatchingState);
            return;
        }
        this.f15472c.info("processEquityInfo>>usePrivilege.mMatchingState is mull", new Object[0]);
    }

    /* renamed from: a */
    private void m12747a(List<UsePrivilegeMatchingState> list) {
        String str;
        int size = list.size();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            if (list.get(i) != null) {
                if (list.get(i).mTimeInterval == -1) {
                    str = list.get(i).mText;
                    break;
                }
                i2 += list.get(i).mTimeInterval;
                arrayList.add(Integer.valueOf(i2));
                arrayList2.add(list.get(i).mText);
            } else {
                this.f15472c.info("usePrivilegeMatchingState is null", new Object[0]);
            }
            i++;
        }
        final String str2 = str;
        if (i2 <= 0 || arrayList2.size() <= 0) {
            ((IExpectationView) this.mView).setEquityText(str2);
            return;
        }
        ((IExpectationView) this.mView).setEquityText((String) arrayList2.get(0));
        this.f15462K = new CountDownTimer((long) (i2 * 1000), 1000) {
            public void onTick(long j) {
                ExpectationPresenter.this.m12748a((List<Integer>) arrayList, (List<String>) arrayList2);
            }

            public void onFinish() {
                int unused = ExpectationPresenter.this.f15463L = 0;
                if (!TextUtils.isEmpty(str2)) {
                    ((IExpectationView) ExpectationPresenter.this.mView).setEquityText(str2);
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12748a(List<Integer> list, List<String> list2) {
        try {
            if (this.f15463L > list.get(this.f15464M).intValue()) {
                this.f15464M++;
                ((IExpectationView) this.mView).setEquityText(list2.get(this.f15464M));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f15463L++;
    }

    /* renamed from: p */
    private void m12790p() {
        this.f15470T.sendEmptyMessageDelayed(1, 30000);
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m12792q() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_WAIT_TIME, String.valueOf((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - CarOrderHelper.getOrderCreateTime()) / 1000));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            hashMap.put("oid", order.oid);
        }
        GlobalOmegaUtils.trackEvent("tech_pax_event_call_wait_time", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        ((IExpectationView) this.mView).startCircleAnim();
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        ((IExpectationView) this.mView).cancelCircleAnim();
        super.onPagePause();
    }
}
