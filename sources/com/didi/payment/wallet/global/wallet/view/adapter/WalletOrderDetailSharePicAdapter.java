package com.didi.payment.wallet.global.wallet.view.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class WalletOrderDetailSharePicAdapter implements WalletOrderSharePicContract.WalletOrderSharePicAdapter {

    /* renamed from: a */
    private Activity f34861a;

    /* renamed from: b */
    private boolean f34862b;

    /* renamed from: c */
    private WalletPayResultResp.PayResultData f34863c;

    /* renamed from: d */
    private List<WalletPayResultResp.ItemModel> f34864d;

    /* renamed from: e */
    private List<WalletPayResultResp.ItemModel> f34865e;

    /* renamed from: f */
    private List<WalletPayResultResp.ItemModel> f34866f;

    public int getTitleColorId() {
        return 0;
    }

    public WalletOrderDetailSharePicAdapter(Activity activity, boolean z) {
        this.f34861a = activity;
        this.f34862b = z;
    }

    public void setData(WalletPayResultResp.PayResultData payResultData) {
        this.f34863c = payResultData;
        this.f34864d = new LinkedList();
        this.f34865e = new LinkedList();
        this.f34866f = new LinkedList();
        WalletPayResultResp.PayResultData payResultData2 = this.f34863c;
        if (payResultData2 != null && !CollectionUtil.isEmpty((Collection) payResultData2.statement)) {
            this.f34864d.addAll(this.f34863c.statement);
        }
        WalletPayResultResp.PayResultData payResultData3 = this.f34863c;
        if (payResultData3 != null && !CollectionUtil.isEmpty((Collection) payResultData3.statementExtend)) {
            this.f34864d.addAll(this.f34863c.statementExtend);
        }
        WalletPayResultResp.PayResultData payResultData4 = this.f34863c;
        if (payResultData4 != null && !CollectionUtil.isEmpty((Collection) payResultData4.rechargeStatement)) {
            this.f34865e.addAll(this.f34863c.rechargeStatement);
        }
        WalletPayResultResp.PayResultData payResultData5 = this.f34863c;
        if (payResultData5 != null && !CollectionUtil.isEmpty((Collection) payResultData5.payeeStatement)) {
            this.f34866f.addAll(this.f34863c.payeeStatement);
        }
    }

    public String getTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        return payResultData != null ? payResultData.resultMainTitle : "";
    }

    public String getSubTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        return payResultData != null ? payResultData.resultSubTitle : "";
    }

    public int getSubTitleColorId() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        if (payResultData == null || payResultData.subTitleColor == null) {
            return 0;
        }
        return Color.parseColor(this.f34863c.subTitleColor);
    }

    public int getSubTitleBgColorId() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        if (payResultData == null || payResultData.subTitleBgColor == null) {
            return 0;
        }
        return Color.parseColor(this.f34863c.subTitleBgColor);
    }

    public int getStatusImg() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_transfer_icon_success;
        }
        return (this.f34863c.status == 0 || this.f34863c.status == 6) ? R.drawable.wallet_transfer_icon_processing : R.drawable.wallet_transfer_icon_failed;
    }

    public String getRechargementTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        return (payResultData == null || payResultData.rechargeStatementTile == null) ? "" : this.f34863c.rechargeStatementTile;
    }

    public String getPayeementTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        return (payResultData == null || payResultData.payeeStatementTitle == null) ? "" : this.f34863c.payeeStatementTitle;
    }

    public int getRechargementItemCount() {
        List<WalletPayResultResp.ItemModel> list = this.f34865e;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f34865e.size();
        }
        return 0;
    }

    public int getPayeementItemCount() {
        List<WalletPayResultResp.ItemModel> list = this.f34866f;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f34866f.size();
        }
        return 0;
    }

    public int getResultIcon() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_toast_icon_successful;
        }
        if (this.f34863c.status == 2) {
            return R.drawable.wallet_toast_icon_fail;
        }
        return 0;
    }

    public int getItemsCount() {
        List<WalletPayResultResp.ItemModel> list = this.f34864d;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f34864d.size();
        }
        return 0;
    }

    public View getItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f34864d)) {
            return null;
        }
        WalletPayResultResp.ItemModel itemModel = this.f34864d.get(i);
        View inflate = LayoutInflater.from(this.f34861a).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        if (!TextUtils.isEmpty(itemModel.color)) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTextColor(Color.parseColor(itemModel.color));
        }
        return inflate;
    }

    public View getRechargeItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f34865e)) {
            return null;
        }
        WalletPayResultResp.ItemModel itemModel = this.f34865e.get(i);
        View inflate = LayoutInflater.from(this.f34861a).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, viewGroup, false);
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
        if (CollectionUtil.isEmpty((Collection) this.f34866f)) {
            return null;
        }
        WalletPayResultResp.ItemModel itemModel = this.f34866f.get(i);
        View inflate = LayoutInflater.from(this.f34861a).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, viewGroup, false);
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
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        return payResultData != null ? payResultData.currencySymbol : "";
    }

    public String getPrice() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        return payResultData != null ? payResultData.amount : "";
    }

    public String getBannerText() {
        WalletPayResultResp.PayResultData payResultData = this.f34863c;
        return payResultData != null ? payResultData.shareBannerText : "";
    }
}
