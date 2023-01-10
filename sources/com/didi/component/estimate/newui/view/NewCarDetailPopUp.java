package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.global.globalgenerickit.drawer.GGKAbsDrawer;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailInfoListModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewCarDetailPopUp extends GGKAbsDrawer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<CarDetailInfoListModel> f14942a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView[] f14943b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f14944c;

    /* renamed from: d */
    private LinearLayout f14945d;

    /* renamed from: e */
    private ViewPager f14946e;

    /* renamed from: f */
    private CarDetailPagerAdapter f14947f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f14948g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f14949h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DetailSelectChangeListener f14950i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CarDetailInfoListModel f14951j;

    /* renamed from: k */
    private View f14952k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public EstimateItemModel f14953l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public AnyCarEstimateItemModel f14954m;

    /* renamed from: n */
    private ImageView f14955n;

    public interface DetailSelectChangeListener {
        void detailSelectItem(String str, boolean z);
    }

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.new_estimate_detail_popup;
    }

    public NewCarDetailPopUp(Context context, List<CarDetailInfoListModel> list, CarDetailInfoListModel carDetailInfoListModel, AnyCarEstimateItemModel anyCarEstimateItemModel, DetailSelectChangeListener detailSelectChangeListener) {
        super(context);
        this.f14942a = list;
        this.f14944c = context;
        this.f14950i = detailSelectChangeListener;
        this.f14951j = carDetailInfoListModel;
        this.f14949h = list.indexOf(carDetailInfoListModel);
        this.f14954m = anyCarEstimateItemModel;
    }

    public NewCarDetailPopUp(Context context, List<CarDetailInfoListModel> list, CarDetailInfoListModel carDetailInfoListModel, EstimateItemModel estimateItemModel, DetailSelectChangeListener detailSelectChangeListener) {
        super(context);
        this.f14942a = list;
        this.f14944c = context;
        this.f14950i = detailSelectChangeListener;
        this.f14951j = carDetailInfoListModel;
        this.f14949h = list.indexOf(carDetailInfoListModel);
        this.f14953l = estimateItemModel;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        setBackPressedEnabled(true);
        this.f14955n = (ImageView) findViewById(R.id.car_detail_close_ic);
        this.f14945d = (LinearLayout) findViewById(R.id.car_detail_dots);
        TextView textView = (TextView) findViewById(R.id.car_detail_select_btn);
        this.f14948g = textView;
        textView.setText(ResourcesHelper.getString(this.f14944c, R.string.GRider_page_Finished_mkEi));
        m12296a();
        this.f14946e = (ViewPager) findViewById(R.id.car_detail_pages);
        CarDetailPagerAdapter carDetailPagerAdapter = new CarDetailPagerAdapter();
        this.f14947f = carDetailPagerAdapter;
        this.f14946e.setAdapter(carDetailPagerAdapter);
        this.f14946e.setCurrentItem(this.f14949h, false);
        this.f14946e.setPageTransformer(true, new C6042a());
        this.f14946e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                for (int i2 = 0; i2 < NewCarDetailPopUp.this.f14943b.length; i2++) {
                    if (i == i2) {
                        NewCarDetailPopUp.this.f14943b[i2].setImageResource(R.drawable.estimate_detail_select_dot);
                    } else {
                        NewCarDetailPopUp.this.f14943b[i2].setImageResource(R.drawable.estimate_detail_not_select_dot);
                    }
                }
                if (NewCarDetailPopUp.this.f14942a.indexOf(NewCarDetailPopUp.this.f14951j) == i) {
                    NewCarDetailPopUp.this.f14948g.setText(ResourcesHelper.getString(NewCarDetailPopUp.this.f14944c, R.string.GRider_page_Finished_mkEi));
                } else {
                    NewCarDetailPopUp.this.f14948g.setText(ResourcesHelper.getString(NewCarDetailPopUp.this.f14944c, R.string.GRider_page_Select_fcKj));
                }
                if (i < NewCarDetailPopUp.this.f14949h) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_sd", "type", "left");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_sd", "type", "right");
                }
                int unused = NewCarDetailPopUp.this.f14949h = i;
            }
        });
        this.f14948g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewCarDetailPopUp.this.dismiss();
                CarDetailInfoListModel carDetailInfoListModel = (CarDetailInfoListModel) NewCarDetailPopUp.this.f14942a.get(NewCarDetailPopUp.this.f14949h);
                if (NewCarDetailPopUp.this.f14942a.indexOf(NewCarDetailPopUp.this.f14951j) != NewCarDetailPopUp.this.f14949h) {
                    NewCarDetailPopUp.this.sendOmegaEvent(carDetailInfoListModel);
                }
                List<CarDetailModel> list = carDetailInfoListModel.carDetailModels;
                if (!CollectionUtils.isEmpty((Collection) list)) {
                    boolean z = false;
                    if (list.get(0).carDetailUid != null && !list.get(0).carDetailUid.isEmpty()) {
                        DetailSelectChangeListener g = NewCarDetailPopUp.this.f14950i;
                        String str = list.get(0).carDetailUid;
                        if (list.size() > 1 && list.get(1).carTwoPrice != null) {
                            z = true;
                        }
                        g.detailSelectItem(str, z);
                    }
                }
            }
        });
        this.f14955n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewCarDetailPopUp.this.dismiss();
            }
        });
        return true;
    }

    class CarDetailPagerAdapter extends PagerAdapter {
        private EstimateDetailPageView mCurrentView;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        CarDetailPagerAdapter() {
        }

        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            this.mCurrentView = (EstimateDetailPageView) obj;
        }

        public EstimateDetailPageView getPrimaryItem() {
            return this.mCurrentView;
        }

        public int getCount() {
            return NewCarDetailPopUp.this.f14942a.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            EstimateDetailPageView estimateDetailPageView;
            if (NewCarDetailPopUp.this.f14954m != null) {
                estimateDetailPageView = new EstimateDetailPageView(NewCarDetailPopUp.this.f14944c, ((CarDetailInfoListModel) NewCarDetailPopUp.this.f14942a.get(i)).carDetailModels, NewCarDetailPopUp.this.f14954m);
            } else {
                estimateDetailPageView = new EstimateDetailPageView(NewCarDetailPopUp.this.f14944c, ((CarDetailInfoListModel) NewCarDetailPopUp.this.f14942a.get(i)).carDetailModels, NewCarDetailPopUp.this.f14953l);
            }
            estimateDetailPageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            viewGroup.addView(estimateDetailPageView);
            return estimateDetailPageView;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    /* renamed from: a */
    private void m12296a() {
        int i;
        int size = this.f14942a.size();
        this.f14943b = new ImageView[size];
        if (DRtlToolkit.rtl()) {
            i = (size - 1) - this.f14949h;
        } else {
            i = this.f14949h;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ImageView imageView = new ImageView(this.f14944c);
            imageView.setPaddingRelative(UIUtils.dip2pxInt(this.f14944c, 8.0f), 0, UIUtils.dip2pxInt(this.f14944c, 8.0f), 0);
            this.f14943b[i2] = imageView;
            if (i2 == i) {
                imageView.setImageResource(R.drawable.estimate_detail_select_dot);
            } else {
                imageView.setImageResource(R.drawable.estimate_detail_not_select_dot);
            }
            this.f14945d.addView(imageView);
        }
    }

    public void sendOmegaEvent(CarDetailInfoListModel carDetailInfoListModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", carDetailInfoListModel != null ? carDetailInfoListModel.hasCoupon() ? "1" : "2" : "");
        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f14954m;
        if (anyCarEstimateItemModel == null) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
                hashMap.put("cartype", Integer.valueOf(newEstimateItem.carConfig.carLevel));
                if (newEstimateItem.carConfig.extraData != null) {
                    newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
                }
            }
        } else if (!(anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || this.f14954m.mAnyCarEstimateNetItem.carConfig == null)) {
            hashMap.put("cartype", Integer.valueOf(this.f14954m.mAnyCarEstimateNetItem.carConfig.carLevel));
            if (this.f14954m.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                this.f14954m.mAnyCarEstimateNetItem.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_select_ck", (Map<String, Object>) hashMap);
    }

    public void show() {
        AbsConfirmConfigState.isShowPopInConfirmPage = true;
        super.show();
    }

    public void dismiss() {
        AbsConfirmConfigState.isShowPopInConfirmPage = false;
        super.dismiss();
    }
}
