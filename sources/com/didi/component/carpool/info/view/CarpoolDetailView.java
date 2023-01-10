package com.didi.component.carpool.info.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.business.util.UiUtils;
import com.didi.component.carpool.info.model.CarPoolCardInfo;
import com.didi.component.carpool.info.model.CarpoolInfoItem;
import com.didi.component.carpool.info.model.TravelInfoMsg;
import com.didi.component.carpool.info.model.WaitLinePointData;
import com.didi.component.carpool.info.presenter.AbsCarpoolInfoPresenter;
import com.didi.component.common.util.CollectionUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarpoolDetailView implements ICarpoolInfoView {

    /* renamed from: a */
    private static final int f13269a = 9;

    /* renamed from: b */
    private final Context f13270b;

    /* renamed from: c */
    private View f13271c;

    /* renamed from: d */
    private CarpoolDetailViewCanvas f13272d;

    /* renamed from: e */
    private LinearLayout f13273e = ((LinearLayout) this.f13271c.findViewById(R.id.global_carpool_detail_list));

    /* renamed from: f */
    private ViewGroup f13274f = ((ViewGroup) this.f13271c.findViewById(R.id.global_carpool_detail_fee_layout));

    /* renamed from: g */
    private TextView f13275g = ((TextView) this.f13271c.findViewById(R.id.global_carpool_detail_fee));

    /* renamed from: h */
    private TextView f13276h = ((TextView) this.f13271c.findViewById(R.id.global_carpool_detail_payment));

    /* renamed from: i */
    private TextView f13277i = ((TextView) this.f13271c.findViewById(R.id.global_carpool_detail_price_desc));

    /* renamed from: j */
    private LEGORichInfo f13278j;

    /* renamed from: k */
    private boolean f13279k;

    public void setPresenter(AbsCarpoolInfoPresenter absCarpoolInfoPresenter) {
    }

    public CarpoolDetailView(Context context, int i) {
        this.f13270b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_carpool_detail_layout, (ViewGroup) null);
        this.f13271c = inflate;
        this.f13272d = (CarpoolDetailViewCanvas) inflate.findViewById(R.id.global_carpool_detail_canvas);
    }

    public View getView() {
        return this.f13271c;
    }

    public void setTravelDetailData(List<CarpoolInfoItem> list, int i) {
        this.f13273e.removeAllViews();
        LayoutInflater from = LayoutInflater.from(this.f13270b);
        for (int i2 = 0; i2 < list.size(); i2++) {
            LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.global_carpool_detail_item, this.f13273e, false);
            new CarpoolItemViewHolder(linearLayout, i).setData(list.get(i2), i2);
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = UiUtils.dip2px(this.f13270b, 9.0f);
            this.f13273e.addView(linearLayout);
        }
        this.f13272d.setTravelDetailData(list, i);
        this.f13272d.postInvalidate();
    }

    public void setRealtimeFee(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            this.f13274f.setVisibility(0);
            this.f13275g.setText(str);
            this.f13276h.setText(str2);
            this.f13279k = true;
            m11138a();
            return;
        }
        this.f13274f.setVisibility(8);
        this.f13279k = false;
    }

    public void setData(CarPoolCardInfo carPoolCardInfo) {
        if (carPoolCardInfo != null) {
            ArrayList arrayList = new ArrayList();
            if (!CollectionUtils.isEmpty((Collection) carPoolCardInfo.waitPoints)) {
                for (int i = 0; i < carPoolCardInfo.waitPoints.size(); i++) {
                    WaitLinePointData waitLinePointData = carPoolCardInfo.waitPoints.get(i);
                    CarpoolInfoItem carpoolInfoItem = new CarpoolInfoItem();
                    carpoolInfoItem.status = waitLinePointData.staus;
                    carpoolInfoItem.viewType = waitLinePointData.type;
                    carpoolInfoItem.title = waitLinePointData.title;
                    carpoolInfoItem.subTitle = waitLinePointData.content;
                    carpoolInfoItem.showDotLine = waitLinePointData.showDotLine;
                    arrayList.add(carpoolInfoItem);
                }
                setTravelDetailData(arrayList, carPoolCardInfo.guideType);
            }
            if (!CollectionUtils.isEmpty((Collection) carPoolCardInfo.travelInfoMsgList)) {
                ArrayList arrayList2 = new ArrayList();
                for (TravelInfoMsg next : carPoolCardInfo.travelInfoMsgList) {
                    if (next != null) {
                        CarpoolInfoItem carpoolInfoItem2 = new CarpoolInfoItem();
                        carpoolInfoItem2.viewType = next.type;
                        carpoolInfoItem2.status = next.status;
                        carpoolInfoItem2.title = next.title;
                        carpoolInfoItem2.subTitle = next.content;
                        carpoolInfoItem2.showDotLine = next.showDotLine;
                        arrayList2.add(carpoolInfoItem2);
                    }
                }
                setTravelDetailData(arrayList2, carPoolCardInfo.guideType);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13273e.getLayoutParams();
            if (carPoolCardInfo.guideType > 0) {
                layoutParams.leftMargin = UiUtils.dip2px(this.f13270b, 40.0f);
            } else {
                layoutParams.leftMargin = UiUtils.dip2px(this.f13270b, 15.0f);
            }
            this.f13278j = carPoolCardInfo.noticeInfo;
            m11138a();
        }
    }

    /* renamed from: a */
    private void m11138a() {
        if (!this.f13279k || this.f13278j == null) {
            this.f13277i.setVisibility(8);
            return;
        }
        this.f13277i.setVisibility(0);
        this.f13278j.bindTextView(this.f13277i);
        this.f13278j.setOnClickListener(new LEGORichInfo.RichInfoClickListener() {
            public void onClick(String str) {
                DRouter.build(str).start();
            }
        });
    }
}
