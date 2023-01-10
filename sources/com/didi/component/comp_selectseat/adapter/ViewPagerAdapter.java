package com.didi.component.comp_selectseat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.model.ItemsBean;
import com.didi.component.comp_selectseat.model.ScheduleItemModel;
import com.didi.component.comp_selectseat.model.SchedulesBean;
import com.didi.component.comp_selectseat.model.ShiftBean;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewPagerAdapter extends RecyclerView.Adapter<FrequencyScheduleViewHolder> {

    /* renamed from: a */
    private static final String f14239a = "ViewPagerAdapter";

    /* renamed from: b */
    private final Context f14240b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final FrequencySelectCallBack f14241c;

    /* renamed from: d */
    private final List<ItemsBean> f14242d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f14243e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RecycleViewScrollableListener f14244f;

    public ViewPagerAdapter(Context context, FrequencySelectCallBack frequencySelectCallBack) {
        this.f14240b = context;
        this.f14241c = frequencySelectCallBack;
    }

    public FrequencyScheduleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FrequencyScheduleViewHolder(LayoutInflater.from(this.f14240b).inflate(R.layout.view_pager_item, viewGroup, false));
    }

    public void onBindViewHolder(final FrequencyScheduleViewHolder frequencyScheduleViewHolder, final int i) {
        ItemsBean itemsBean = this.f14242d.get(i);
        if (itemsBean != null) {
            frequencyScheduleViewHolder.mRv.setLayoutManager(new LinearLayoutManager(this.f14240b));
            ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this.f14240b, new FrequencySelectClickListener() {
                public void onFrequencySelectClick(boolean z, ShiftBean shiftBean, int i) {
                    ViewPagerAdapter.this.f14241c.onFrequencySelectCallBack(shiftBean, z);
                    if (ViewPagerAdapter.this.f14243e != i) {
                        ViewPagerAdapter viewPagerAdapter = ViewPagerAdapter.this;
                        viewPagerAdapter.notifyItemChanged(viewPagerAdapter.f14243e);
                    }
                    int unused = ViewPagerAdapter.this.f14243e = i;
                }
            });
            frequencyScheduleViewHolder.mRv.setAdapter(scheduleAdapter);
            m11816a(itemsBean, scheduleAdapter);
            frequencyScheduleViewHolder.mRv.post(new Runnable() {
                public void run() {
                    if (ViewPagerAdapter.this.f14244f != null) {
                        ViewPagerAdapter.this.f14244f.updateScrollableList(i, ViewPagerAdapter.this.isRecyclerScrollable(frequencyScheduleViewHolder.mRv));
                    }
                    if (i == 0) {
                        ViewPagerAdapter.this.m11815a();
                    }
                }
            });
            return;
        }
        GLog.m11357e(f14239a, "itemsBean is null");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11815a() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, GPageIdConstant.G_PAGE_ID_CONF);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || confirmListener.getSelectedSingleAnyCarItem() == null) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.estimateId)) {
                GLog.m11357e(f14239a, "noFrequencyClickTrackEvent>> estimateId is null");
            } else {
                hashMap.put("pre_bubble_id", newEstimateItem.carConfig.estimateId);
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_minibus_request_shift_sw", (Map<String, Object>) hashMap);
            return;
        }
        AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
        if (selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.estimateId)) {
            GLog.m11357e(f14239a, "noFrequencyClickTrackEvent>> estimateId is null");
        } else {
            hashMap.put("pre_bubble_id", selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.estimateId);
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_request_shift_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m11816a(ItemsBean itemsBean, ScheduleAdapter scheduleAdapter) {
        ArrayList arrayList = new ArrayList();
        if (itemsBean.schedules == null || itemsBean.schedules.size() <= 0) {
            GLog.m11357e(f14239a, "itemsBean.schedules == null or size =0");
        } else {
            for (SchedulesBean next : itemsBean.schedules) {
                if (next != null) {
                    m11817a((List<ScheduleItemModel>) arrayList, next);
                } else {
                    GLog.m11357e(f14239a, "schedulesBean is null");
                }
            }
        }
        if (arrayList.size() > 0) {
            scheduleAdapter.setDate(arrayList);
        } else {
            GLog.m11357e(f14239a, "scheduleItemModelList size = 0 ");
        }
    }

    /* renamed from: a */
    private void m11817a(List<ScheduleItemModel> list, SchedulesBean schedulesBean) {
        ScheduleItemModel scheduleItemModel = new ScheduleItemModel();
        scheduleItemModel.setTitleBean(schedulesBean.title);
        scheduleItemModel.setViewType(ScheduleItemModel.ITEM_TYPE_TITLE);
        list.add(scheduleItemModel);
        for (ShiftBean shiftsBean : schedulesBean.shifts) {
            ScheduleItemModel scheduleItemModel2 = new ScheduleItemModel();
            scheduleItemModel2.setShiftsBean(shiftsBean);
            scheduleItemModel2.setViewType(ScheduleItemModel.ITEM_TYPE_SHIFT);
            list.add(scheduleItemModel2);
        }
    }

    public int getItemCount() {
        return this.f14242d.size();
    }

    public void setDate(List<ItemsBean> list) {
        this.f14242d.clear();
        this.f14242d.addAll(list);
        notifyDataSetChanged();
    }

    public void setRecycleViewSlidableListener(RecycleViewScrollableListener recycleViewScrollableListener) {
        this.f14244f = recycleViewScrollableListener;
    }

    public boolean isRecyclerScrollable(RecyclerView recyclerView) {
        if (recyclerView == null) {
            GLog.m11357e(f14239a, "isRecyclerScrollable>> recyclerView is null");
            return false;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (linearLayoutManager == null || adapter == null || linearLayoutManager.findLastCompletelyVisibleItemPosition() >= adapter.getItemCount() - 1) {
            return false;
        }
        return true;
    }
}
