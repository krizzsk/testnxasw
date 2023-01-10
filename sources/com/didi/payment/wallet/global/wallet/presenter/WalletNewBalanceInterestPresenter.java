package com.didi.payment.wallet.global.wallet.presenter;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.WalletBalanceModel;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInterestResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceInterestContract;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class WalletNewBalanceInterestPresenter implements WalletNewBalanceInterestContract.Presenter {

    /* renamed from: a */
    private WalletNewBalanceInterestContract.View f34584a;

    /* renamed from: b */
    private WalletBalanceModel f34585b;

    /* renamed from: c */
    private FragmentActivity f34586c;

    /* renamed from: d */
    private WalletBalanceInterestResp.DataBean f34587d;

    /* renamed from: e */
    private String[] f34588e;

    /* renamed from: f */
    private String[] f34589f;

    /* renamed from: g */
    private String[] f34590g;

    /* renamed from: h */
    private Date f34591h;

    /* renamed from: i */
    private Calendar f34592i = Calendar.getInstance();

    /* renamed from: j */
    private SimpleDateFormat f34593j = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: k */
    private SimpleDateFormat f34594k = new SimpleDateFormat("MM/yyyy");

    /* renamed from: l */
    private SimpleDateFormat f34595l = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: m */
    private SimpleDateFormat f34596m = new SimpleDateFormat("MM/yyyy");

    /* renamed from: n */
    private SimpleDateFormat f34597n = new SimpleDateFormat("dd/MM");

    /* renamed from: o */
    private SimpleDateFormat f34598o = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: p */
    private WalletBalanceInterestResp.InterestInfo f34599p;

    public void onDestroy() {
    }

    public WalletNewBalanceInterestPresenter(FragmentActivity fragmentActivity, WalletNewBalanceInterestContract.View view) {
        this.f34586c = fragmentActivity;
        this.f34584a = view;
        this.f34585b = new WalletBalanceModel(fragmentActivity);
        WalletBalanceInterestResp.InterestInfo interestInfo = new WalletBalanceInterestResp.InterestInfo();
        this.f34599p = interestInfo;
        interestInfo.date = "";
        this.f34599p.amount = 0.0d;
        this.f34599p.amountText = DCryptoMainFragment.DCRYPTO_ZERO;
    }

    public void init() {
        requestData();
    }

    public void requestData() {
        this.f34584a.showLoadingDialog();
        C120141 r0 = new RpcService.Callback<WalletBalanceInterestResp>() {
            public void onSuccess(WalletBalanceInterestResp walletBalanceInterestResp) {
                WalletNewBalanceInterestPresenter.this.m26404a(walletBalanceInterestResp);
            }

            public void onFailure(IOException iOException) {
                WalletNewBalanceInterestPresenter.this.m26404a((WalletBalanceInterestResp) null);
            }
        };
        int type = this.f34584a.getType();
        if (type == 0) {
            this.f34585b.getBalanceInterestInfo(r0);
        } else if (type == 1) {
            this.f34585b.getBalanceCashbackInfo(r0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26404a(WalletBalanceInterestResp walletBalanceInterestResp) {
        this.f34584a.dismissLoadingDialog();
        if (walletBalanceInterestResp == null || walletBalanceInterestResp.errno != 0 || walletBalanceInterestResp.data == null) {
            if (walletBalanceInterestResp != null && !TextUtils.isEmpty(walletBalanceInterestResp.errmsg)) {
                WalletToastNew.showFailedMsg(this.f34586c, walletBalanceInterestResp.errmsg);
            }
            this.f34584a.showErrorPage();
            return;
        }
        WalletBalanceInterestResp.DataBean dataBean = walletBalanceInterestResp.data;
        this.f34584a.showIntroduction(dataBean.metaInfo);
        if (dataBean.daySet == null || dataBean.monthSet == null || dataBean.totalSet == null || CollectionUtil.isEmpty((Object[]) dataBean.daySet.infoList) || CollectionUtil.isEmpty((Object[]) dataBean.monthSet.infoList) || CollectionUtil.isEmpty((Object[]) dataBean.totalSet.infoList)) {
            this.f34584a.showEmptyPage(dataBean.metaInfo);
            return;
        }
        this.f34587d = dataBean;
        try {
            this.f34591h = this.f34593j.parse(dataBean.metaInfo.currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (this.f34587d.metaInfo != null) {
            if (!CollectionUtil.isEmpty((Object[]) this.f34587d.metaInfo.interestTitles)) {
                this.f34599p.amountItems = new String[this.f34587d.metaInfo.interestTitles.length];
                Arrays.fill(this.f34599p.amountItems, this.f34587d.metaInfo.defaultAmount);
            }
            if (!TextUtils.isEmpty(this.f34587d.metaInfo.defaultAmountValue)) {
                this.f34599p.amountText = this.f34587d.metaInfo.defaultAmountValue;
            }
        }
        m26403a(walletBalanceInterestResp.data.daySet);
        m26406b(walletBalanceInterestResp.data.monthSet);
        m26407c(walletBalanceInterestResp.data.totalSet);
        m26402a();
        this.f34584a.updateMetaData(this.f34587d.metaInfo);
        this.f34584a.showChartInDay(this.f34587d.daySet.infoList, this.f34588e);
        this.f34584a.showInterestInfo(this.f34587d.daySet.infoList[this.f34587d.daySet.infoList.length - 1], this.f34595l.format(this.f34591h));
    }

    /* renamed from: a */
    private void m26403a(WalletBalanceInterestResp.InterestSetInfo interestSetInfo) {
        try {
            Date parse = this.f34593j.parse(interestSetInfo.startDate);
            int daysBetweenDate = getDaysBetweenDate(parse, this.f34591h) + 1;
            WalletBalanceInterestResp.InterestInfo[] interestInfoArr = new WalletBalanceInterestResp.InterestInfo[daysBetweenDate];
            int i = 0;
            for (WalletBalanceInterestResp.InterestInfo interestInfo : interestSetInfo.infoList) {
                if (interestInfo != null) {
                    int daysBetweenDate2 = getDaysBetweenDate(parse, this.f34593j.parse(interestInfo.date));
                    while (i < daysBetweenDate2) {
                        interestInfoArr[i] = this.f34599p;
                        i++;
                    }
                    interestInfoArr[i] = interestInfo;
                    i = daysBetweenDate2 + 1;
                }
            }
            while (i < daysBetweenDate) {
                interestInfoArr[i] = this.f34599p;
                i++;
            }
            interestSetInfo.infoList = interestInfoArr;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m26406b(WalletBalanceInterestResp.InterestSetInfo interestSetInfo) {
        try {
            Date parse = this.f34594k.parse(interestSetInfo.startDate);
            int monthsBetweenDate = getMonthsBetweenDate(parse, this.f34591h) + 1;
            WalletBalanceInterestResp.InterestInfo[] interestInfoArr = new WalletBalanceInterestResp.InterestInfo[monthsBetweenDate];
            int i = 0;
            for (WalletBalanceInterestResp.InterestInfo interestInfo : interestSetInfo.infoList) {
                if (interestInfo != null) {
                    Date parse2 = this.f34594k.parse(interestInfo.date);
                    this.f34592i.setTime(parse2);
                    int monthsBetweenDate2 = getMonthsBetweenDate(parse, parse2);
                    while (i < monthsBetweenDate2) {
                        interestInfoArr[i] = this.f34599p;
                        i++;
                    }
                    interestInfoArr[i] = interestInfo;
                    i = monthsBetweenDate2 + 1;
                }
            }
            while (i < monthsBetweenDate) {
                interestInfoArr[i] = this.f34599p;
                i++;
            }
            interestSetInfo.infoList = interestInfoArr;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m26407c(WalletBalanceInterestResp.InterestSetInfo interestSetInfo) {
        try {
            Date parse = this.f34593j.parse(interestSetInfo.startDate);
            int daysBetweenDate = getDaysBetweenDate(parse, this.f34591h) + 1;
            WalletBalanceInterestResp.InterestInfo[] interestInfoArr = new WalletBalanceInterestResp.InterestInfo[daysBetweenDate];
            int i = 0;
            for (WalletBalanceInterestResp.InterestInfo interestInfo : interestSetInfo.infoList) {
                if (interestInfo != null) {
                    int daysBetweenDate2 = getDaysBetweenDate(parse, this.f34593j.parse(interestInfo.date));
                    while (i < daysBetweenDate2) {
                        if (i == 0) {
                            interestInfoArr[i] = interestInfo;
                        } else {
                            interestInfoArr[i] = interestInfoArr[i - 1];
                        }
                        i++;
                    }
                    interestInfoArr[i] = interestInfo;
                    i = daysBetweenDate2 + 1;
                }
            }
            if (i != 0) {
                while (i < daysBetweenDate) {
                    interestInfoArr[i] = interestInfoArr[i - 1];
                    i++;
                }
                interestSetInfo.infoList = interestInfoArr;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m26402a() {
        WalletBalanceInterestResp.DataBean dataBean;
        if (this.f34591h != null && (dataBean = this.f34587d) != null) {
            if (dataBean.daySet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.daySet.infoList)) {
                this.f34588e = new String[]{m26401a(this.f34587d.daySet.infoList.length, 0, 6, this.f34597n), this.f34597n.format(this.f34591h)};
            }
            if (this.f34587d.totalSet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.totalSet.infoList)) {
                this.f34590g = new String[]{m26401a(this.f34587d.totalSet.infoList.length, 0, 6, this.f34598o), this.f34598o.format(this.f34591h)};
            }
            if (this.f34587d.monthSet != null && this.f34587d.monthSet.startDate != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.monthSet.infoList)) {
                String[] stringArray = ResourcesHelper.getStringArray(this.f34586c, R.array.wallet_balance_interest_months);
                String[] strArr = null;
                try {
                    int length = this.f34587d.monthSet.infoList.length;
                    strArr = new String[length];
                    this.f34592i.setTime(this.f34594k.parse(this.f34587d.monthSet.startDate));
                    int i = this.f34592i.get(2);
                    for (int i2 = 0; i2 < length; i2++) {
                        strArr[i2] = stringArray[(i2 + i) % stringArray.length];
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f34589f = strArr;
            }
        }
    }

    public void onInterestDayClicked() {
        WalletBalanceInterestResp.DataBean dataBean = this.f34587d;
        if (dataBean != null && dataBean.daySet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.daySet.infoList)) {
            this.f34584a.showChartInDay(this.f34587d.daySet.infoList, this.f34588e);
            this.f34584a.showInterestInfo(this.f34587d.daySet.infoList[this.f34587d.daySet.infoList.length - 1], this.f34595l.format(this.f34591h));
        }
    }

    public void onInterestMonthClicked() {
        WalletBalanceInterestResp.DataBean dataBean = this.f34587d;
        if (dataBean != null && dataBean.monthSet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.monthSet.infoList)) {
            this.f34584a.showChartInMonth(this.f34587d.monthSet.infoList, this.f34589f);
            this.f34584a.showInterestInfo(this.f34587d.monthSet.infoList[this.f34587d.monthSet.infoList.length - 1], this.f34596m.format(this.f34591h));
        }
    }

    public void onInterestTotalClicked() {
        WalletBalanceInterestResp.DataBean dataBean = this.f34587d;
        if (dataBean != null && dataBean.totalSet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.totalSet.infoList)) {
            this.f34584a.showChartInTotal(this.f34587d.totalSet.infoList, this.f34590g);
            this.f34584a.showInterestInfo(this.f34587d.totalSet.infoList[this.f34587d.totalSet.infoList.length - 1], this.f34595l.format(this.f34591h));
        }
    }

    public void onChartItemSelectedInDay(int i) {
        WalletBalanceInterestResp.DataBean dataBean = this.f34587d;
        if (dataBean != null && dataBean.daySet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.daySet.infoList) && i < this.f34587d.daySet.infoList.length) {
            this.f34584a.showInterestInfo(this.f34587d.daySet.infoList[i], m26401a(this.f34587d.daySet.infoList.length, i, 6, this.f34595l));
        }
    }

    public void onChartItemSelectedInMonth(int i) {
        WalletBalanceInterestResp.DataBean dataBean = this.f34587d;
        if (dataBean != null && dataBean.monthSet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.monthSet.infoList) && i < this.f34587d.monthSet.infoList.length) {
            this.f34584a.showInterestInfo(this.f34587d.monthSet.infoList[i], m26401a(this.f34587d.monthSet.infoList.length, i, 2, this.f34596m));
        }
    }

    public void onChartItemSelectedInTotal(int i) {
        WalletBalanceInterestResp.DataBean dataBean = this.f34587d;
        if (dataBean != null && dataBean.totalSet != null && !CollectionUtil.isEmpty((Object[]) this.f34587d.totalSet.infoList) && i < this.f34587d.totalSet.infoList.length) {
            this.f34584a.showInterestInfo(this.f34587d.totalSet.infoList[i], m26401a(this.f34587d.totalSet.infoList.length, i, 6, this.f34595l));
        }
    }

    /* renamed from: a */
    private String m26401a(int i, int i2, int i3, SimpleDateFormat simpleDateFormat) {
        Calendar calendar;
        Date date = this.f34591h;
        if (date == null || (calendar = this.f34592i) == null || simpleDateFormat == null) {
            return "";
        }
        calendar.setTime(date);
        this.f34592i.add(i3, (i2 - i) + 1);
        return simpleDateFormat.format(this.f34592i.getTime());
    }

    public int getDaysBetweenDate(Date date, Date date2) {
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }

    public int getMonthsBetweenDate(Date date, Date date2) {
        this.f34592i.setTime(date);
        int i = this.f34592i.get(2) + 1;
        int i2 = this.f34592i.get(1);
        this.f34592i.setTime(date2);
        int i3 = this.f34592i.get(2) + 1;
        int i4 = this.f34592i.get(1);
        return i4 == i2 ? i3 - i : (i3 + ((i4 - i2) * 12)) - i;
    }
}
