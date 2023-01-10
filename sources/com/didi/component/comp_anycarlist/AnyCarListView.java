package com.didi.component.comp_anycarlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.data.form.listener.observer.AnycarItemStatusListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.core.IView;
import com.didi.component.core.IViewContainer;
import com.didi.component.estimate.newui.view.NewCarDetailPopUp;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarDetailInfoListModel;
import com.didiglobal.comp.carmodellist.AnyCarModelList;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnyCarListView implements IAnyCarListView, IView<AbsAnyCarListPresenter>, IViewContainer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f13960a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecyclerView f13961b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AbsAnyCarListPresenter f13962c;

    /* renamed from: d */
    private IViewContainer.IComponentCreator f13963d;

    /* renamed from: e */
    private AnyCarModelList f13964e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<AnyCarEstimateItemModel> f13965f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AnyCarEstimateItemModel f13966g;

    public AnyCarListView(Context context, ViewGroup viewGroup) {
        this.f13960a = context;
        AnyCarModelList anyCarModelList = new AnyCarModelList(context, viewGroup, new AnyCarSelectListener() {
            public void defaultSelectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarListView.this.m11570a(anyCarEstimateItemModel, true);
            }

            public void selectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarListView.this.m11570a(anyCarEstimateItemModel, false);
                AnyCarListView.this.f13962c.bubbleSelected(anyCarEstimateItemModel, true);
                AnyCarListView.this.f13962c.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT);
            }

            public void unSelectItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null) {
                    AnyCarListView.this.f13962c.bubbleSelected(anyCarEstimateItemModel, false);
                    AnyCarListView.this.m11569a(anyCarEstimateItemModel);
                    AnyCarListView.this.f13965f.remove(anyCarEstimateItemModel);
                    confirmListener.setSelectedAnyCarItem(AnyCarListView.this.f13965f);
                    AnyCarListView.this.f13962c.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT);
                }
            }

            public void singleSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null) {
                    AnyCarEstimateItemModel unused = AnyCarListView.this.f13966g = anyCarEstimateItemModel;
                    confirmListener.setSelectedSingleAnyCarItem(AnyCarListView.this.f13966g);
                    AnyCarListView.this.f13962c.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SINGLE_CLICK);
                    AnyCarListView.this.f13962c.bubbleSelected(anyCarEstimateItemModel, true);
                }
            }

            public void openDetail(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarListView.this.omegaOpenDetailClick(anyCarEstimateItemModel);
                if (anyCarEstimateItemModel != null && !CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carDetail)) {
                    CarDetailInfoListModel carDetailInfoListModel = null;
                    if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carDetail.size() > 0) {
                        carDetailInfoListModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carDetail.get(0);
                    }
                    CarDetailInfoListModel carDetailInfoListModel2 = carDetailInfoListModel;
                    if (carDetailInfoListModel2 != null && !CollectionUtil.isEmpty((Collection<?>) carDetailInfoListModel2.carDetailModels)) {
                        new NewCarDetailPopUp(AnyCarListView.this.f13960a, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carDetail, carDetailInfoListModel2, anyCarEstimateItemModel, (NewCarDetailPopUp.DetailSelectChangeListener) new NewCarDetailPopUp.DetailSelectChangeListener() {
                            public void detailSelectItem(String str, boolean z) {
                            }
                        }).show();
                        AnyCarListView.this.f13962c.doPublish(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP);
                    }
                }
            }

            public void carpoolSeatSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarListView.this.f13962c.doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }

            public void setAllItems(List<AnyCarEstimateItemModel> list) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null) {
                    confirmListener.setAllCarItems(list);
                }
            }
        });
        this.f13964e = anyCarModelList;
        this.f13961b = anyCarModelList.getRootView();
        final ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            confirmListener.setItemStatusLisener(new AnycarItemStatusListener() {
                public boolean isSwipe(int i) {
                    if (!(confirmListener.getAllCarItems() == null || confirmListener.getSelectedAnyCarItems() == null)) {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) AnyCarListView.this.f13961b.getLayoutManager();
                        for (AnyCarEstimateItemModel indexOf : confirmListener.getSelectedAnyCarItems()) {
                            if (UiUtils.getViewLocation(linearLayoutManager.findViewByPosition(confirmListener.getAllCarItems().indexOf(indexOf)))[1] > i) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            });
        }
    }

    public void omegaOpenDetailClick(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        HashMap hashMap = new HashMap();
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null) {
            hashMap.put("price_type", Integer.valueOf(anyCarEstimateItemModel.countPriceType));
            hashMap.put("bubble_id", anyCarEstimateItemModel.estimateId);
            m11571a((Map<String, Object>) hashMap);
            hashMap.put("cartype", Integer.valueOf(anyCarEstimateItemModel.getCarLevel()));
            hashMap.put("actual_biz", Integer.valueOf(anyCarEstimateItemModel.getCarBussinessId()));
            hashMap.put("combotype", Integer.valueOf(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carComboType));
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_price_ck", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11569a(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        HashMap hashMap = new HashMap();
        if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
            hashMap.put("carlevel", Integer.valueOf(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel));
            hashMap.put("actual_biz", Integer.valueOf(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId));
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_anycar_cancel_cartype_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11570a(AnyCarEstimateItemModel anyCarEstimateItemModel, boolean z) {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            m11574b(anyCarEstimateItemModel, z);
            this.f13965f.add(anyCarEstimateItemModel);
            confirmListener.setSelectedAnyCarItem(this.f13965f);
        }
    }

    /* renamed from: b */
    private void m11574b(AnyCarEstimateItemModel anyCarEstimateItemModel, boolean z) {
        if (anyCarEstimateItemModel != null) {
            AnyCarEstimateNetModel anyCarEstimateNetModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem;
            HashMap hashMap = new HashMap();
            if (anyCarEstimateNetModel != null) {
                if (anyCarEstimateNetModel.carConfig != null) {
                    hashMap.put("carlevel", Integer.valueOf(anyCarEstimateNetModel.carConfig.carLevel));
                    hashMap.put("actual_biz", Integer.valueOf(anyCarEstimateNetModel.carConfig.carBussinessId));
                    hashMap.put("bubble_id", anyCarEstimateItemModel.estimateId);
                    hashMap.put("comboType", Integer.valueOf(anyCarEstimateNetModel.carConfig.carComboType));
                }
                hashMap.put("style", Integer.valueOf(z ? 1 : 2));
                m11571a((Map<String, Object>) hashMap);
                if (!(anyCarEstimateNetModel.carConfig == null || anyCarEstimateNetModel.carConfig.extraData == null)) {
                    anyCarEstimateNetModel.carConfig.extraData.putAllExtraLog(hashMap);
                }
            }
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_mode_ck", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private void m11571a(Map<String, Object> map) {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null && confirmListener.getAnyCarResponse() != null && confirmListener.getAnyCarResponse().globalConfig != null) {
            map.put("estimate_trace_id", confirmListener.getAnyCarResponse().globalConfig.globalEstimateTraceId);
        }
    }

    public View getView() {
        return this.f13961b;
    }

    public void setPresenter(AbsAnyCarListPresenter absAnyCarListPresenter) {
        this.f13962c = absAnyCarListPresenter;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f13963d = iComponentCreator;
    }

    public void setData(List<AnyCarGroup> list) {
        this.f13965f.clear();
        this.f13964e.setData(list);
    }

    public void setInitParam(List<AnyCarEstimateItemModel> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f13964e.setInitParam(list);
        }
    }
}
