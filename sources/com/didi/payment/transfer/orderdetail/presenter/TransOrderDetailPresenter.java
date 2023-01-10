package com.didi.payment.transfer.orderdetail.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.transfer.orderdetail.ITransOrderDetailView;
import com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class TransOrderDetailPresenter extends IOrderDetailPresenter {

    /* renamed from: c */
    private static final long f34007c = 1000;

    /* renamed from: d */
    private static final int f34008d = 10;

    /* renamed from: e */
    private CountDownTimer f34009e;

    /* renamed from: f */
    private Activity f34010f;

    /* renamed from: g */
    private boolean f34011g = false;
    protected TransPayResultResp.PayResultData mData;
    protected String mOrderId;
    protected int mOrderType = -1;
    protected int mPageFrom = -1;
    protected int mProductLine;
    protected TransferBizModel mTransferBizModel;

    /* renamed from: com.didi.payment.transfer.orderdetail.presenter.TransOrderDetailPresenter$4 */
    static /* synthetic */ class C118104 {

        /* renamed from: $SwitchMap$com$didi$payment$transfer$orderdetail$presenter$IOrderDetailPresenter$OperationType */
        static final /* synthetic */ int[] f34012x495c344a = new int[IOrderDetailPresenter.OperationType.values().length];
    }

    public void handleEnterHistory() {
    }

    public void trackOmega(int i) {
    }

    public TransOrderDetailPresenter(Context context, ITransOrderDetailView iTransOrderDetailView) {
        super(context, iTransOrderDetailView);
        this.f34010f = (Activity) context;
        this.mTransferBizModel = TransferBizModel.getInstance(getContext());
        Intent intent = this.f34010f.getIntent();
        if (intent != null) {
            this.mProductLine = intent.getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, 0);
            this.mOrderId = intent.getStringExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_ID);
            this.mOrderType = intent.getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, -1);
            this.mPageFrom = intent.getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
            this.f34011g = intent.getBooleanExtra(TransferContants.IntentKey.INTENT_PARAMS_KEY_HAS99PAY, false);
        }
    }

    public void onOperationButtonClick(IOrderDetailPresenter.OperationType operationType) {
        int i = C118104.f34012x495c344a[operationType.ordinal()];
    }

    public boolean isSupportCountdonw() {
        return this.f34011g;
    }

    public void executeTask() {
        ((ITransOrderDetailView) this.mPageView).onShowPageLoadding();
        m25893a();
    }

    /* renamed from: a */
    private void m25893a() {
        if (isSupportCountdonw()) {
            m25896b();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                TransOrderDetailPresenter.this.m25898c();
            }
        }, 100);
    }

    /* renamed from: b */
    private void m25896b() {
        if (this.f34009e == null) {
            this.f34009e = new CountDownTimer(10000, 1000) {
                public void onTick(long j) {
                    int i = (int) (j / 1000);
                    ((ITransOrderDetailView) TransOrderDetailPresenter.this.mPageView).onUpdateCountDownLoading(i, 10 - i);
                    if (i / 2 == 0) {
                        TransOrderDetailPresenter.this.m25898c();
                    }
                }

                public void onFinish() {
                    ((ITransOrderDetailView) TransOrderDetailPresenter.this.mPageView).stopCountdownLoading();
                    ((ITransOrderDetailView) TransOrderDetailPresenter.this.mPageView).onGotOrderStatus(TransOrderDetailPresenter.this.mData);
                    ((ITransOrderDetailView) TransOrderDetailPresenter.this.mPageView).onDismissPageLoadding();
                }
            };
        }
        this.f34009e.start();
        ((ITransOrderDetailView) this.mPageView).onUpdateCountDownLoading(10, 10);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m25898c() {
        this.mTransferBizModel.getOrderDetailInfo(this.mProductLine, this.mOrderId, new RpcService.Callback<TransPayResultResp>() {
            public void onSuccess(TransPayResultResp transPayResultResp) {
                if (transPayResultResp != null && transPayResultResp.errno == 0 && transPayResultResp.data != null) {
                    TransOrderDetailPresenter.this.mData = transPayResultResp.data;
                    if (transPayResultResp.data.status != 0) {
                        TransOrderDetailPresenter.this.m25900d();
                        ((ITransOrderDetailView) TransOrderDetailPresenter.this.mPageView).onDismissPageLoadding();
                        ((ITransOrderDetailView) TransOrderDetailPresenter.this.mPageView).stopCountdownLoading();
                        ((ITransOrderDetailView) TransOrderDetailPresenter.this.mPageView).onGotOrderStatus(transPayResultResp.data);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                String message = iOException != null ? iOException.getMessage() : "exception";
                DebugUtil.log("query order status return fail.. with excep: " + message, new Object[0]);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25900d() {
        CountDownTimer countDownTimer = this.f34009e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void handleBackClick() {
        ((ITransOrderDetailView) this.mPageView).onPageFinish();
    }
}
