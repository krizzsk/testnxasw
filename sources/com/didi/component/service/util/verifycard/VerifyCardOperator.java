package com.didi.component.service.util.verifycard;

import android.content.Context;
import com.didi.component.business.data.form.FormStore;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class VerifyCardOperator {
    public static final int VERIFY_FAILED = 100001;
    public static final int VERIFY_SUCCESS = 100000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IVerifyOperation f17667a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IDialogOperation f17668b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IProgressOperation f17669c;

    /* renamed from: d */
    private Context f17670d;

    public VerifyCardOperator(Context context) {
        this.f17670d = context;
    }

    public void setIVerifyOperation(IVerifyOperation iVerifyOperation) {
        this.f17667a = iVerifyOperation;
    }

    public void setIDialogOperation(IDialogOperation iDialogOperation) {
        this.f17668b = iDialogOperation;
    }

    public void setIProgressOperation(IProgressOperation iProgressOperation) {
        this.f17669c = iProgressOperation;
    }

    public void createVerifyDialog(final CarOrder carOrder) {
        VerifyCardDialogBuilder verifyCardDialogBuilder = new VerifyCardDialogBuilder(this.f17670d);
        verifyCardDialogBuilder.setDialogStatus(0);
        verifyCardDialogBuilder.setDialogOperation(new IDialogOperation() {
            public void dismiss() {
                VerifyCardOperator.this.f17668b.dismiss();
            }

            public void cancelDismiss() {
                VerifyCardOperator.this.f17668b.cancelDismiss();
            }
        });
        verifyCardDialogBuilder.setVerifyOperation(new IVerifyOperation() {
            public void onVerify(DidiGlobalCheckCardData.CheckCardParam checkCardParam) {
                if (checkCardParam.cardNo == null || checkCardParam.cardNo.length() >= 8) {
                    checkCardParam.cardIndex = VerifyCardOperator.this.m14953a();
                    checkCardParam.businessId = carOrder.productid;
                    VerifyCardOperator.this.m14955a(checkCardParam);
                    return;
                }
                VerifyCardOperator.this.f17668b.dismiss();
                VerifyCardDialogBuilder createResultDialog = VerifyCardOperator.this.createResultDialog();
                createResultDialog.setDialogStatus(2);
                VerifyCardOperator.this.f17668b.show(createResultDialog.buildDialog());
            }
        });
        this.f17668b.show(verifyCardDialogBuilder.buildDialog(carOrder));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m14953a() {
        return FormStore.getInstance().getCardIndex();
    }

    /* renamed from: b */
    private String m14956b() {
        return (NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLocCountry() == null) ? "" : NationTypeUtil.getNationComponentData().getLocCountry();
    }

    public VerifyCardDialogBuilder createResultDialog() {
        VerifyCardDialogBuilder verifyCardDialogBuilder = new VerifyCardDialogBuilder(this.f17670d);
        verifyCardDialogBuilder.setDialogOperation(new IDialogOperation() {
            public void dismiss() {
                if (VerifyCardOperator.this.f17668b != null) {
                    VerifyCardOperator.this.f17668b.dismiss();
                }
            }

            public void cancelDismiss() {
                VerifyCardOperator.this.f17668b.cancelDismiss();
            }
        });
        verifyCardDialogBuilder.setVerifyOperation(new IVerifyOperation() {
            public void onReVerfiry() {
                if (VerifyCardOperator.this.f17667a != null) {
                    VerifyCardOperator.this.f17667a.onReVerfiry();
                }
            }

            public void onSuccess() {
                if (VerifyCardOperator.this.f17667a != null) {
                    VerifyCardOperator.this.f17667a.onSuccess();
                }
            }

            public void onChangePayMethod() {
                if (VerifyCardOperator.this.f17667a != null) {
                    VerifyCardOperator.this.f17667a.onChangePayMethod();
                }
            }
        });
        return verifyCardDialogBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14955a(DidiGlobalCheckCardData.CheckCardParam checkCardParam) {
        IProgressOperation iProgressOperation = this.f17669c;
        if (iProgressOperation != null) {
            iProgressOperation.show();
        }
        DidiCreditCardFactory.createGlobalCreditCardApi().checkCardNo(this.f17670d, checkCardParam, new RpcService.Callback<DidiGlobalCheckCardData.CheckCardResult>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(DidiGlobalCheckCardData.CheckCardResult checkCardResult) {
                if (checkCardResult != null && checkCardResult.errNo == 0) {
                    VerifyCardOperator.this.f17669c.dismiss();
                    VerifyCardOperator.this.f17668b.dismiss();
                    VerifyCardDialogBuilder createResultDialog = VerifyCardOperator.this.createResultDialog();
                    if (checkCardResult.data != null && checkCardResult.data.code == 100000) {
                        createResultDialog.setDialogStatus(1);
                    } else if (checkCardResult.data != null && checkCardResult.data.code == 100001) {
                        createResultDialog.setDialogStatus(2);
                    }
                    VerifyCardOperator.this.f17668b.show(createResultDialog.buildDialog());
                }
            }
        });
    }
}
