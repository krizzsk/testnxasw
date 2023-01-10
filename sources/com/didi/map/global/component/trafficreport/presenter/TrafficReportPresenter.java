package com.didi.map.global.component.trafficreport.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.trafficreport.ITrafficReportDelegate;
import com.didi.map.global.component.trafficreport.TrafficReportParam;
import com.didi.map.global.component.trafficreport.data.TrafficReportFetchManager;
import com.didi.map.global.component.trafficreport.model.LocalButtonInfo;
import com.didi.map.global.component.trafficreport.model.LocalCategory;
import com.didi.map.global.component.trafficreport.model.ReportGroup;
import com.didi.map.global.component.trafficreport.model.ReportItem;
import com.didi.map.global.component.trafficreport.util.ComparatorSort;
import com.didi.map.global.component.trafficreport.util.DisplayUtil;
import com.didi.map.global.component.trafficreport.util.LocUtils;
import com.didi.map.global.component.trafficreport.util.ReportOmegaUtil;
import com.didi.map.global.component.trafficreport.view.IReportCenterView;
import com.didi.map.global.component.trafficreport.view.ReportCenterView;
import com.didi.map.global.component.trafficreport.view.TrafficReportActivity;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.event.ButtonInfo;
import com.didi.map.sdk.proto.driver_gl.event.ButtonModeInfo;
import com.didi.map.sdk.proto.driver_gl.event.EventCategory;
import com.didi.map.sdk.proto.driver_gl.event.EventElementRes;
import com.squareup.wire.Message;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TrafficReportPresenter implements ITrafficReportPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f28605a = TrafficReportPresenter.class.getSimpleName();

    /* renamed from: i */
    private static final int f28606i = 1;

    /* renamed from: b */
    private final TrafficReportFetchManager f28607b;

    /* renamed from: c */
    private PaxEnvironment f28608c;

    /* renamed from: d */
    private List<LocalButtonInfo> f28609d;

    /* renamed from: e */
    private List<LocalCategory> f28610e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f28611f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<ReportGroup> f28612g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ITrafficReportDelegate f28613h;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WeakReference<ITrafficReportPresenter> f28614j;

    /* renamed from: k */
    private TrafficReportParam f28615k;

    /* renamed from: l */
    private final TrafficReportFetchManager.FetcherCallback f28616l = new TrafficReportFetchManager.FetcherCallback() {
        public void onBeginToFetch() {
        }

        public void onFinishToFetch(Message message) {
            if (message instanceof EventElementRes) {
                EventElementRes eventElementRes = (EventElementRes) message;
                if (eventElementRes.ret.intValue() != 0 || eventElementRes.btns == null || eventElementRes.btns.size() <= 0) {
                    DisplayUtil.toastShow(TrafficReportPresenter.this.mContext, TrafficReportPresenter.this.mContext.getResources().getString(R.string.GRider_Sug_2020_timeout_1), R.drawable.icon_toast_failure);
                    String a = TrafficReportPresenter.f28605a;
                    DLog.m10773d(a, "requireEventElements result: " + eventElementRes.msg, new Object[0]);
                    return;
                }
                TrafficReportPresenter.this.m22304a(eventElementRes);
                TrafficReportPresenter trafficReportPresenter = TrafficReportPresenter.this;
                List unused = trafficReportPresenter.f28612g = trafficReportPresenter.m22308c();
                TrafficReportPresenter trafficReportPresenter2 = TrafficReportPresenter.this;
                String unused2 = trafficReportPresenter2.f28611f = trafficReportPresenter2.getListType(trafficReportPresenter2.f28612g);
                TrafficReportPresenter.this.f28613h.updateButtonInfoList(TrafficReportPresenter.this.f28612g);
                if (TrafficReportPresenter.this.mView != null) {
                    TrafficReportPresenter.this.mView.performCreateView((ITrafficReportPresenter) TrafficReportPresenter.this.f28614j.get(), TrafficReportPresenter.this.f28612g);
                    TrafficReportPresenter.this.mView.show();
                    TrafficReportPresenter.this.mView.setCancelListener();
                    return;
                }
                return;
            }
            DisplayUtil.toastShow(TrafficReportPresenter.this.mContext, TrafficReportPresenter.this.mContext.getResources().getString(R.string.GRider_Sug_2020_timeout_1), R.drawable.icon_toast_failure);
            DLog.m10773d(TrafficReportPresenter.f28605a, "requestEventElements res is null", new Object[0]);
        }
    };
    protected Context mContext;
    protected IReportCenterView mView;

    public TrafficReportPresenter(Context context, IReportCenterView iReportCenterView, ITrafficReportDelegate iTrafficReportDelegate, TrafficReportParam trafficReportParam, PaxEnvironment paxEnvironment) {
        if (context != null) {
            this.mContext = context;
        }
        m22306b();
        this.f28613h = iTrafficReportDelegate;
        this.mView = iReportCenterView;
        this.f28615k = trafficReportParam;
        this.f28608c = paxEnvironment;
        this.f28607b = TrafficReportFetchManager.getInstance();
        this.f28614j = new WeakReference<>(this);
    }

    /* renamed from: b */
    private void m22306b() {
        this.f28609d = new ArrayList();
        this.f28610e = new ArrayList();
        this.f28612g = new ArrayList();
    }

    public void requestData() {
        TrafficReportFetchManager trafficReportFetchManager = this.f28607b;
        if (trafficReportFetchManager != null) {
            trafficReportFetchManager.requestEventElements(this.mContext, this.f28608c, this.f28616l);
        }
    }

    public void onReportItemClick(int i, int i2) {
        List<ReportGroup> list = this.f28612g;
        if (list != null && list.size() > i && this.f28612g.get(i) != null && !CollectionUtil.isEmpty((Collection<?>) this.f28612g.get(i).getMembers()) && this.f28612g.get(i).getMembers().size() > i2) {
            ReportOmegaUtil.trackPaxChooseType(PaxEnvironment.getInstance().getUid(), this.f28615k.getOrderId(), LocUtils.getCurrentLocation(this.mContext), this.f28611f, this.f28612g.get(i).getMembers().get(i2).getItemValue().intValue());
            TrafficReportActivity.startTrafficReportActivity(this.mContext, new WeakReference((ReportCenterView) this.mView), this.f28612g.get(i).getMembers().get(i2), this.f28615k.getOrderId());
        }
    }

    public void onViewClose(int i) {
        if (i == 0) {
            ReportOmegaUtil.trackPaxOpenOrCloseReport(PaxEnvironment.getInstance().getUid(), this.f28615k.getOrderId(), LocUtils.getCurrentLocation(this.mContext), "close");
        }
        IReportCenterView iReportCenterView = this.mView;
        if (iReportCenterView != null) {
            iReportCenterView.hide();
        }
    }

    public void setData(Context context, TrafficReportParam trafficReportParam, IReportCenterView iReportCenterView, List<ReportGroup> list) {
        this.mContext = context;
        this.f28615k = trafficReportParam;
        this.mView = iReportCenterView;
        this.f28612g = list;
        this.f28611f = getListType(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22304a(EventElementRes eventElementRes) {
        this.f28609d.clear();
        this.f28610e.clear();
        try {
            for (ButtonInfo next : eventElementRes.btns) {
                SparseArray sparseArray = new SparseArray();
                for (ButtonModeInfo next2 : next.modeInfo) {
                    sparseArray.put(next2.buttonMode.intValue(), next2.buttonPicUrl);
                }
                if (TextUtils.isEmpty(next.buttonTitle)) {
                    DLog.m10773d(f28605a, "results of request event elements buttonTitle have error !!!", new Object[0]);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (ButtonInfo next3 : next.secondary) {
                        SparseArray sparseArray2 = new SparseArray();
                        for (ButtonModeInfo next4 : next.modeInfo) {
                            sparseArray2.put(next4.buttonMode.intValue(), next4.buttonPicUrl);
                        }
                        arrayList.add(new LocalButtonInfo.Builder().buttonTitle(next3.buttonTitle).modeInfo(sparseArray2).buttonValue(next3.buttonValue.intValue()).buttonIndex(next3.buttonIndex.intValue()).cateCode(next3.cateCode.intValue()).secondary((List<LocalButtonInfo>) null).build());
                    }
                    this.f28609d.add(new LocalButtonInfo.Builder().buttonTitle(next.buttonTitle).modeInfo(sparseArray).buttonValue(next.buttonValue.intValue()).buttonIndex(next.buttonIndex.intValue()).cateCode(next.cateCode.intValue()).secondary(arrayList).build());
                }
            }
            for (EventCategory next5 : eventElementRes.cates) {
                this.f28610e.add(new LocalCategory.Builder().cateCode(next5.cateCode.intValue()).cateName(next5.cateName).build());
            }
            String str = f28605a;
            DLog.m10773d(str, "Request event elements success, mLocalButtonInfoList size = " + this.f28609d.size(), new Object[0]);
        } catch (Exception e) {
            DLog.m10773d(f28605a, "Exception during updating mLocalButtonInfoList", e);
            this.f28609d.clear();
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<ReportGroup> m22308c() {
        ReportGroup reportGroup;
        if (CollectionUtil.isEmpty((Collection<?>) this.f28609d) || CollectionUtil.isEmpty((Collection<?>) this.f28610e)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f28609d.size(); i++) {
            LocalButtonInfo localButtonInfo = this.f28609d.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    reportGroup = null;
                    i2 = -1;
                    break;
                } else if (((ReportGroup) arrayList.get(i2)).getCateCode() == localButtonInfo.getCateCode().intValue()) {
                    reportGroup = (ReportGroup) arrayList.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
            if (reportGroup != null) {
                ReportItem.Builder builder = new ReportItem.Builder();
                builder.itemTitle(localButtonInfo.getButtonTitle());
                builder.itemIcon(localButtonInfo.getModeInfo().get(1));
                builder.itemIndex(localButtonInfo.getButtonIndex().intValue());
                builder.itemValue(localButtonInfo.getButtonValue().intValue());
                List<ReportGroup> a = m22300a(localButtonInfo);
                Collections.sort(a, new ComparatorSort());
                builder.secondaryList(a);
                reportGroup.getMembers().add(builder.build());
                Collections.sort(reportGroup.getMembers(), new ComparatorSort());
                arrayList.set(i2, reportGroup);
            } else {
                ReportGroup.Builder builder2 = new ReportGroup.Builder();
                builder2.cateCode(localButtonInfo.getCateCode().intValue());
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f28610e.size()) {
                        break;
                    } else if (localButtonInfo.getCateCode() == this.f28610e.get(i3).getCateCode()) {
                        builder2.title(this.f28610e.get(i3).getCateName());
                        break;
                    } else {
                        i3++;
                    }
                }
                ReportGroup build = builder2.build();
                ReportItem.Builder builder3 = new ReportItem.Builder();
                builder3.itemTitle(localButtonInfo.getButtonTitle());
                builder3.itemIcon(localButtonInfo.getModeInfo().get(1));
                builder3.itemIndex(localButtonInfo.getButtonIndex().intValue());
                builder3.itemValue(localButtonInfo.getButtonValue().intValue());
                List<ReportGroup> a2 = m22300a(localButtonInfo);
                Collections.sort(a2, new ComparatorSort());
                builder3.secondaryList(a2);
                build.getMembers().add(builder3.build());
                Collections.sort(build.getMembers(), new ComparatorSort());
                arrayList.add(build);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<ReportGroup> m22300a(LocalButtonInfo localButtonInfo) {
        ReportGroup reportGroup;
        if (localButtonInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= (!CollectionUtil.isEmpty((Collection<?>) localButtonInfo.getSecondary()) ? localButtonInfo.getSecondary().size() : 0)) {
                return arrayList;
            }
            LocalButtonInfo localButtonInfo2 = localButtonInfo.getSecondary().get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    reportGroup = null;
                    i2 = -1;
                    break;
                } else if (((ReportGroup) arrayList.get(i2)).getCateCode() == localButtonInfo2.getCateCode().intValue()) {
                    reportGroup = (ReportGroup) arrayList.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
            ReportItem.Builder builder = new ReportItem.Builder();
            if (reportGroup != null) {
                builder.itemTitle(localButtonInfo2.getButtonTitle());
                builder.itemIcon(localButtonInfo2.getModeInfo().get(1));
                builder.itemIndex(localButtonInfo2.getButtonIndex().intValue());
                builder.itemValue(localButtonInfo2.getButtonValue().intValue());
                reportGroup.getMembers().add(builder.build());
                Collections.sort(reportGroup.getMembers(), new ComparatorSort());
                arrayList.set(i2, reportGroup);
            } else {
                ReportGroup.Builder builder2 = new ReportGroup.Builder();
                builder2.cateCode(localButtonInfo2.getCateCode().intValue());
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f28610e.size()) {
                        break;
                    } else if (localButtonInfo2.getCateCode() == this.f28610e.get(i3).getCateCode()) {
                        builder2.title(this.f28610e.get(i3).getCateName());
                        break;
                    } else {
                        i3++;
                    }
                }
                ReportGroup build = builder2.build();
                builder.itemTitle(localButtonInfo2.getButtonTitle());
                builder.itemIcon(localButtonInfo2.getModeInfo().get(1));
                builder.itemIndex(localButtonInfo2.getButtonIndex().intValue());
                builder.itemValue(localButtonInfo2.getButtonValue().intValue());
                build.getMembers().add(builder.build());
                Collections.sort(build.getMembers(), new ComparatorSort());
                arrayList.add(build);
            }
            i++;
        }
    }

    public String getListType(List<ReportGroup> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (ReportGroup members : list) {
            for (ReportItem next : members.getMembers()) {
                if (next != null) {
                    sb.append(next.getItemValue());
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
}
