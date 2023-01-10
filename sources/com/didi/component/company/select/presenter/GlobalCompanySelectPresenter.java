package com.didi.component.company.select.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.EstimateUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.company.model.CompanyInfo;
import com.didi.component.company.select.view.CompanyEmptyPopupWindow;
import com.didi.component.company.select.view.GlobalCompanySelectActivity;
import com.didi.component.company.select.view.ICompanySelectView;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalCompanySelectPresenter implements ICompanySelectPresenter {

    /* renamed from: a */
    Runnable f14399a = new Runnable() {
        public void run() {
            GlobalCompanySelectPresenter.this.f14400b.finish();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FragmentActivity f14400b;

    /* renamed from: c */
    private ICompanySelectView f14401c;

    /* renamed from: d */
    private String f14402d = "0";

    /* renamed from: e */
    private double f14403e;

    /* renamed from: f */
    private double f14404f;

    /* renamed from: g */
    private List<CompanyInfo> f14405g;

    /* renamed from: h */
    private boolean f14406h;

    public GlobalCompanySelectPresenter(FragmentActivity fragmentActivity) {
        this.f14400b = fragmentActivity;
    }

    public void setView(ICompanySelectView iCompanySelectView) {
        this.f14401c = iCompanySelectView;
    }

    public void onAdd(Bundle bundle) {
        init(bundle);
        if ((GlobalSPUtil.getCompChooseTipsDisplayCount(this.f14400b) & 3) > 0) {
            GlobalSPUtil.setCompChooseTipsDisplayCount(this.f14400b, 1);
        }
    }

    public void init(Bundle bundle) {
        if (bundle != null) {
            this.f14402d = bundle.getString("company_id", "0");
            this.f14403e = bundle.getDouble(GlobalCompanySelectActivity.DATA_EXTRA_START_LAT, 0.0d);
            this.f14404f = bundle.getDouble(GlobalCompanySelectActivity.DATA_EXTRA_START_LNG, 0.0d);
            boolean z = bundle.getBoolean(GlobalCompanySelectActivity.DATA_EXTRA_SHOW_DEFAULT, true);
            this.f14406h = z;
            this.f14401c.showDefault(z);
        }
        GlobalOmegaUtils.trackEvent("CompanySelect_Enter");
        m11931a();
    }

    /* renamed from: a */
    private void m11931a() {
        C58091 r5 = new ResponseListener<TaxiCompanyListModel>() {
            public void onFinish(TaxiCompanyListModel taxiCompanyListModel) {
                GlobalCompanySelectPresenter.this.m11933a(taxiCompanyListModel);
            }
        };
        this.f14401c.showLoading();
        CarRequest.getTaxiCompanyListInfo(this.f14400b, this.f14403e, this.f14404f, r5);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11933a(TaxiCompanyListModel taxiCompanyListModel) {
        this.f14401c.hideLoading();
        ArrayList<CompanyInfo> arrayList = new ArrayList<>();
        CompanyInfo a = m11928a(taxiCompanyListModel.multiDesc);
        arrayList.add(a);
        CompanyInfo b = m11935b(taxiCompanyListModel);
        if (b != null) {
            arrayList.add(b);
        }
        if (taxiCompanyListModel != null && taxiCompanyListModel.isAvailable()) {
            if (!CollectionUtils.isEmpty((Collection) taxiCompanyListModel.list)) {
                arrayList.addAll(m11930a(taxiCompanyListModel.list));
                if (b != null) {
                    a = b;
                }
                a.extend = taxiCompanyListModel.listDesc;
            } else if (a != null) {
                a.extend = null;
            }
        }
        for (CompanyInfo companyInfo : arrayList) {
            if (m11934a(taxiCompanyListModel, companyInfo.companyId)) {
                companyInfo.isPickupSvrFree = true;
            }
        }
        this.f14405g = arrayList;
        if (taxiCompanyListModel != null && !CollectionUtils.isEmpty((Collection) taxiCompanyListModel.list)) {
            this.f14401c.showCompanys(arrayList, this.f14402d);
        } else if (!this.f14406h) {
            m11936b();
        } else {
            m11937c();
        }
    }

    /* renamed from: a */
    private boolean m11934a(TaxiCompanyListModel taxiCompanyListModel, String str) {
        if (!CollectionUtil.isEmpty((Collection<?>) taxiCompanyListModel.comp4FreePickup)) {
            return taxiCompanyListModel.comp4FreePickup.contains(str);
        }
        return false;
    }

    /* renamed from: a */
    private CompanyInfo m11928a(String str) {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.companyId = "0";
        companyInfo.companyName = ResourcesHelper.getString(this.f14400b, R.string.global_company_name_any);
        companyInfo.companyDesc = ResourcesHelper.getString(this.f14400b, R.string.global_company_any_desc);
        if (!TextUtil.isEmpty(str)) {
            companyInfo.extendTop = str;
        }
        return companyInfo;
    }

    /* renamed from: b */
    private CompanyInfo m11935b(TaxiCompanyListModel taxiCompanyListModel) {
        if (taxiCompanyListModel.comp4freeOption == null) {
            return null;
        }
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.companyId = "1";
        companyInfo.companyName = taxiCompanyListModel.comp4freeOption.name;
        companyInfo.companyDesc = taxiCompanyListModel.comp4freeOption.desc;
        companyInfo.companyIconUrl = taxiCompanyListModel.comp4freeOption.logo;
        if (!CollectionUtil.isEmpty((Collection<?>) taxiCompanyListModel.comp4FreePickup)) {
            companyInfo.childCids = new ArrayList();
            companyInfo.childCids.addAll(taxiCompanyListModel.comp4FreePickup);
        }
        return companyInfo;
    }

    /* renamed from: a */
    private List<CompanyInfo> m11930a(List<TaxiCompanyListModel.CompanyModel> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty((Collection) list)) {
            return arrayList;
        }
        for (TaxiCompanyListModel.CompanyModel next : list) {
            CompanyInfo companyInfo = new CompanyInfo();
            companyInfo.companyId = next.f46886id;
            companyInfo.companyIconUrl = next.iconUrl;
            companyInfo.companyName = next.name;
            companyInfo.companyDesc = !TextUtils.isEmpty(next.desc) ? next.desc : next.extraFeeDesc;
            arrayList.add(companyInfo);
        }
        return arrayList;
    }

    /* renamed from: a */
    private TaxiCompanyListModel.CompanyModel m11929a(CompanyInfo companyInfo) {
        if (companyInfo == null) {
            return null;
        }
        if (TextUtils.isEmpty(companyInfo.companyId)) {
            return companyInfo.toCompanyModel();
        }
        int i = 0;
        while (true) {
            if (i >= CollectionUtil.size((Collection<?>) this.f14405g)) {
                break;
            }
            CompanyInfo companyInfo2 = this.f14405g.get(i);
            if (companyInfo.companyId.equalsIgnoreCase(companyInfo2.companyId) && companyInfo2.childCids != null) {
                companyInfo.childCids = companyInfo2.childCids;
                break;
            }
            i++;
        }
        return companyInfo.toCompanyModel();
    }

    public void onCompanySelected(CompanyInfo companyInfo) {
        String str;
        Intent intent = new Intent();
        intent.putExtra(GlobalCompanySelectActivity.DATA_EXTRA_SELECTED_COMPANY_INFO, m11929a(companyInfo));
        this.f14400b.setResult(-1, intent);
        String str2 = companyInfo.companyId;
        this.f14402d = str2;
        this.f14401c.showCompanys(this.f14405g, str2);
        UiThreadHandler.post(this.f14399a);
        if ("0".equals(this.f14402d)) {
            str = "All";
        } else {
            str = "1".equals(this.f14402d) ? "nopickupfeegroup" : this.f14402d;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("CompanyChoice", str);
        hashMap.put(ServerParam.PARAM_ORDER_TYPE, Integer.valueOf(EstimateUtils.isFixedPricingTypeShowing() ? 1 : 0));
        GlobalOmegaUtils.trackEvent("CompanySelect_SelectSomeone", (Map<String, Object>) hashMap);
    }

    public void onRemove() {
        UiThreadHandler.removeCallbacks(this.f14399a);
    }

    /* renamed from: b */
    private void m11936b() {
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.f14400b);
        builder.setCancelable(false);
        builder.setIconVisible(true);
        builder.setCloseVisible(false);
        builder.setSupprtMullineTitle(true);
        C58113 r1 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCompanySelectPresenter.this.f14400b.finish();
            }
        };
        builder.setIcon(AlertController.IconType.INFO);
        builder.setMessage(ResourcesHelper.getString(this.f14400b, R.string.global_company_empty_dialog_content));
        builder.setPositiveButton((int) R.string.confirm, (View.OnClickListener) r1);
        builder.setPositiveButtonDefault();
        AlertDialogFragment create = builder.create();
        if (create != null) {
            create.show(this.f14400b.getSupportFragmentManager(), (String) null);
        }
    }

    /* renamed from: c */
    private void m11937c() {
        FragmentActivity fragmentActivity = this.f14400b;
        if (!(fragmentActivity instanceof Activity)) {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            CompanyEmptyPopupWindow companyEmptyPopupWindow = new CompanyEmptyPopupWindow(this.f14400b);
            if (!companyEmptyPopupWindow.isShowing()) {
                companyEmptyPopupWindow.show();
            }
        }
    }
}
