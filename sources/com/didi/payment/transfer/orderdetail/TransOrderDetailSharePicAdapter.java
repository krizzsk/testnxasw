package com.didi.payment.transfer.orderdetail;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TransOrderDetailSharePicAdapter implements WalletOrderSharePicContract.WalletOrderSharePicAdapter {

    /* renamed from: a */
    private Activity f34000a;

    /* renamed from: b */
    private TransPayResultResp.PayResultData f34001b;

    /* renamed from: c */
    private List<TransPayResultResp.ItemModel> f34002c;

    /* renamed from: d */
    private List<TransPayResultResp.ItemModel> f34003d;

    /* renamed from: e */
    private List<TransPayResultResp.ItemModel> f34004e;

    public int getTitleColorId() {
        return 0;
    }

    public TransOrderDetailSharePicAdapter(Activity activity) {
        this.f34000a = activity;
    }

    public void setData(TransPayResultResp.PayResultData payResultData) {
        this.f34001b = payResultData;
        this.f34002c = new LinkedList();
        this.f34003d = new LinkedList();
        this.f34004e = new LinkedList();
        TransPayResultResp.PayResultData payResultData2 = this.f34001b;
        if (payResultData2 != null && !CollectionUtil.isEmpty((Collection) payResultData2.statement)) {
            this.f34002c.addAll(this.f34001b.statement);
        }
        TransPayResultResp.PayResultData payResultData3 = this.f34001b;
        if (payResultData3 != null && !CollectionUtil.isEmpty((Collection) payResultData3.statementExtend)) {
            this.f34002c.addAll(this.f34001b.statementExtend);
        }
        TransPayResultResp.PayResultData payResultData4 = this.f34001b;
        if (payResultData4 != null && !CollectionUtil.isEmpty((Collection) payResultData4.rechargeStatement)) {
            this.f34003d.addAll(this.f34001b.rechargeStatement);
        }
        TransPayResultResp.PayResultData payResultData5 = this.f34001b;
        if (payResultData5 != null && !CollectionUtil.isEmpty((Collection) payResultData5.payeeStatement)) {
            this.f34004e.addAll(this.f34001b.payeeStatement);
        }
    }

    public String getTitle() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        return payResultData != null ? payResultData.resultMainTitle : "";
    }

    public String getSubTitle() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        return payResultData != null ? payResultData.resultSubTitle : "";
    }

    public int getSubTitleColorId() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        if (payResultData == null || payResultData.subTitleColor == null) {
            return 0;
        }
        return Color.parseColor(this.f34001b.subTitleColor);
    }

    public int getSubTitleBgColorId() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        if (payResultData == null || payResultData.subTitleBgColor == null) {
            return 0;
        }
        return Color.parseColor(this.f34001b.subTitleBgColor);
    }

    public int getStatusImg() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_transfer_icon_success;
        }
        return (this.f34001b.status == 0 || this.f34001b.status == 6) ? R.drawable.wallet_transfer_icon_processing : R.drawable.wallet_transfer_icon_failed;
    }

    public String getRechargementTitle() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        return (payResultData == null || payResultData.rechargeStatementTile == null) ? "" : this.f34001b.rechargeStatementTile;
    }

    public String getPayeementTitle() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        return (payResultData == null || payResultData.payeeStatementTitle == null) ? "" : this.f34001b.payeeStatementTitle;
    }

    public int getRechargementItemCount() {
        List<TransPayResultResp.ItemModel> list = this.f34003d;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f34003d.size();
        }
        return 0;
    }

    public int getPayeementItemCount() {
        List<TransPayResultResp.ItemModel> list = this.f34004e;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f34004e.size();
        }
        return 0;
    }

    public int getResultIcon() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_toast_icon_successful;
        }
        if (this.f34001b.status == 2) {
            return R.drawable.wallet_toast_icon_fail;
        }
        return 0;
    }

    public int getItemsCount() {
        List<TransPayResultResp.ItemModel> list = this.f34002c;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f34002c.size();
        }
        return 0;
    }

    public View getItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f34002c)) {
            return null;
        }
        TransPayResultResp.ItemModel itemModel = this.f34002c.get(i);
        View inflate = LayoutInflater.from(this.f34000a).inflate(R.layout.trans_orderdetail_item_lay, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        return inflate;
    }

    public View getRechargeItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f34003d)) {
            return null;
        }
        TransPayResultResp.ItemModel itemModel = this.f34003d.get(i);
        View inflate = LayoutInflater.from(this.f34000a).inflate(R.layout.trans_orderdetail_item_lay, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        if (!TextUtils.isEmpty(itemModel.color)) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTextColor(Color.parseColor(itemModel.color));
        }
        if (itemModel.isBold) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTypeface(Typeface.defaultFromStyle(1));
        }
        return inflate;
    }

    public View getPayeeItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f34004e)) {
            return null;
        }
        TransPayResultResp.ItemModel itemModel = this.f34004e.get(i);
        View inflate = LayoutInflater.from(this.f34000a).inflate(R.layout.trans_orderdetail_item_lay, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        if (!TextUtils.isEmpty(itemModel.color)) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTextColor(Color.parseColor(itemModel.color));
        }
        if (itemModel.isBold) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTypeface(Typeface.defaultFromStyle(1));
        }
        return inflate;
    }

    public String getSymbol() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        return payResultData != null ? payResultData.currencySymbol : "";
    }

    public String getPrice() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        return payResultData != null ? payResultData.amount : "";
    }

    public String getBannerText() {
        TransPayResultResp.PayResultData payResultData = this.f34001b;
        return payResultData != null ? payResultData.shareBannerText : "";
    }
}
