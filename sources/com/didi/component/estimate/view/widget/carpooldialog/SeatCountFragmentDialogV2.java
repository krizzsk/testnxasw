package com.didi.component.estimate.view.widget.carpooldialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.view.widget.carpooldialog.SeatCountAdapter;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.popup.PopupSelectRecyclerView;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakSeatModel;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatCountFragmentDialogV2 extends SimplePopupBase {

    /* renamed from: a */
    private BusinessContext f15111a;

    /* renamed from: b */
    private int f15112b;

    /* renamed from: c */
    private TextView f15113c;

    /* renamed from: d */
    private TextView f15114d;

    /* renamed from: e */
    private ImageView f15115e;

    /* renamed from: f */
    private PopupSelectRecyclerView f15116f;

    /* renamed from: g */
    private TextView f15117g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SeatCountAdapter f15118h;

    /* renamed from: i */
    private CarBreakSeatModel f15119i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f15120j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AnyCarEstimateItemModel f15121k;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_seat_count_dialog_new_ui_layout;
    }

    public static SeatCountFragmentDialogV2 newInstance(int i) {
        SeatCountFragmentDialogV2 seatCountFragmentDialogV2 = new SeatCountFragmentDialogV2();
        Bundle bundle = new Bundle();
        bundle.putInt("default_people", i);
        seatCountFragmentDialogV2.setArguments(bundle);
        return seatCountFragmentDialogV2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f15112b = arguments.getInt("default_people", 0);
        } else {
            this.f15112b = 1;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f15113c = (TextView) this.mRootView.findViewById(R.id.global_seat_count_title);
        this.f15114d = (TextView) this.mRootView.findViewById(R.id.global_seat_count_subtitle);
        this.f15115e = (ImageView) this.mRootView.findViewById(R.id.global_seat_count_close_btn);
        this.f15116f = (PopupSelectRecyclerView) this.mRootView.findViewById(R.id.global_seat_count_recycler_view);
        this.f15117g = (TextView) this.mRootView.findViewById(R.id.global_seat_count_confirm_btn);
        m12432a();
        m12435b();
    }

    /* renamed from: a */
    private void m12432a() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (!confirmListener.getIsAnyCar() || selectedSingleAnyCarItem == null) {
                EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                if (newEstimateItem != null && newEstimateItem.carBreakModel != null) {
                    m12433a(newEstimateItem.carBreakModel);
                    return;
                }
                return;
            }
            this.f15121k = selectedSingleAnyCarItem;
            if (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel != null) {
                m12433a(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel);
            }
        }
    }

    /* renamed from: a */
    private void m12433a(CarBreakModel carBreakModel) {
        if (carBreakModel.carBreakSeat != null) {
            CarBreakSeatModel carBreakSeatModel = carBreakModel.carBreakSeat;
            this.f15119i = carBreakSeatModel;
            if (!TextUtils.isEmpty(carBreakSeatModel.seatBreakTitle)) {
                this.f15113c.setVisibility(0);
                this.f15113c.setText(this.f15119i.seatBreakTitle);
            } else {
                this.f15113c.setText(ResourcesHelper.getString(getContext(), R.string.global_seat_count_title));
            }
            if (!TextUtils.isEmpty(this.f15119i.seatBreakContent)) {
                this.f15114d.setVisibility(0);
                this.f15114d.setText(this.f15119i.seatBreakContent);
            } else {
                this.f15114d.setVisibility(8);
            }
            this.f15116f.setLayoutManager(new LinearLayoutManager(getContext()));
            SeatCountAdapter seatCountAdapter = new SeatCountAdapter(getContext());
            this.f15118h = seatCountAdapter;
            this.f15116f.setAdapter(seatCountAdapter);
            if (this.f15119i.seatBreakChoice != null && this.f15119i.seatBreakChoice.size() > 0) {
                this.f15118h.updateData(this.f15119i.seatBreakChoice);
            }
            int i = this.f15112b;
            if (i > 0) {
                this.f15118h.setSelectedPos(i - 1);
            }
        }
    }

    /* renamed from: b */
    private void m12435b() {
        this.f15118h.setOnSeatItemClickListener(new SeatCountAdapter.OnSeatItemClickListener() {
            public void onItemClick(int i) {
                List<CarSeatChoiceModel> data = SeatCountFragmentDialogV2.this.f15118h.getData();
                CarSeatChoiceModel carSeatChoiceModel = (data == null || data.size() <= i) ? null : data.get(i);
                if (carSeatChoiceModel != null && !carSeatChoiceModel.isUnavailable) {
                    int unused = SeatCountFragmentDialogV2.this.f15120j = i;
                    SeatCountFragmentDialogV2.this.f15118h.setSelectedPos(i);
                }
            }
        });
        this.f15117g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!Utils.isFastDoubleClick()) {
                    if (SeatCountFragmentDialogV2.this.f15121k != null) {
                        FormStore.getInstance().setSeatCount(SeatCountFragmentDialogV2.this.f15120j + 1);
                        if (SeatCountFragmentDialogV2.this.f15121k.mAnyCarEstimateNetItem.carConfig != null && !TextUtils.isEmpty(SeatCountFragmentDialogV2.this.f15121k.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
                            FormStore.getInstance().setIsSeatConfirmDialogShowed(SeatCountFragmentDialogV2.this.f15121k.mAnyCarEstimateNetItem.carConfig.uniqueId, true);
                        }
                        List<CarSeatChoiceModel> data = SeatCountFragmentDialogV2.this.f15118h.getData();
                        if (data != null && data.size() > 0 && SeatCountFragmentDialogV2.this.f15121k != null && SeatCountFragmentDialogV2.this.f15120j < data.size()) {
                            CarSeatChoiceModel carSeatChoiceModel = data.get(SeatCountFragmentDialogV2.this.f15120j);
                            if (!(carSeatChoiceModel == null || carSeatChoiceModel.getselectValue() == null)) {
                                SeatCountFragmentDialogV2.this.f15121k.feeNumber = carSeatChoiceModel.getselectValue().seatPoolEstimatePrice;
                                SeatCountFragmentDialogV2.this.f15121k.estimateId = carSeatChoiceModel.getselectValue().seatPoolEstimateId;
                                FormStore.getInstance().setCurrentComboType(carSeatChoiceModel.getselectValue().comboType);
                                SeatCountFragmentDialogV2.this.f15121k.setSelectedValueParams(carSeatChoiceModel.getselectValue(), carSeatChoiceModel.selectValueObject);
                                SeatCountFragmentDialogV2.this.f15121k.setSelectPos(SeatCountFragmentDialogV2.this.f15120j);
                                FormStore.getInstance().setCarpoolOrderScene(carSeatChoiceModel.getselectValue().carpoolOrderScene);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", 1);
                            hashMap.put("num", Integer.valueOf(SeatCountFragmentDialogV2.this.f15120j + 1));
                            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_sharenum_order_ck", (Map<String, Object>) hashMap);
                        }
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.AnyCar.ANYCAR_EVENT_ONE_PRICE_SELECT_CONFIRM);
                        SeatCountFragmentDialogV2.this.m12437c();
                        return;
                    }
                    FormStore.getInstance().setSeatCount(SeatCountFragmentDialogV2.this.f15120j + 1);
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    if (!(newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.uniqueId))) {
                        FormStore.getInstance().setIsSeatConfirmDialogShowed(newEstimateItem.carConfig.uniqueId, true);
                    }
                    List<CarSeatChoiceModel> data2 = SeatCountFragmentDialogV2.this.f15118h.getData();
                    if (data2 != null && data2.size() > 0 && newEstimateItem != null && SeatCountFragmentDialogV2.this.f15120j < data2.size()) {
                        CarSeatChoiceModel carSeatChoiceModel2 = data2.get(SeatCountFragmentDialogV2.this.f15120j);
                        if (!(carSeatChoiceModel2 == null || carSeatChoiceModel2.getselectValue() == null)) {
                            newEstimateItem.feeNumber = carSeatChoiceModel2.getselectValue().seatPoolEstimatePrice;
                            newEstimateItem.estimateId = carSeatChoiceModel2.getselectValue().seatPoolEstimateId;
                            FormStore.getInstance().setCurrentComboType(carSeatChoiceModel2.getselectValue().comboType);
                            newEstimateItem.setSelectedValueParams(carSeatChoiceModel2.getselectValue(), carSeatChoiceModel2.selectValueObject);
                            newEstimateItem.setSelectPos(SeatCountFragmentDialogV2.this.f15120j);
                            FormStore.getInstance().setCarpoolOrderScene(carSeatChoiceModel2.getselectValue().carpoolOrderScene);
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("type", 1);
                        hashMap2.put("num", Integer.valueOf(SeatCountFragmentDialogV2.this.f15120j + 1));
                        GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_sharenum_order_ck", (Map<String, Object>) hashMap2);
                    }
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.CarPool.EVENT_ONE_PRICE_SELECT_CONFIRM);
                    SeatCountFragmentDialogV2.this.m12437c();
                }
            }
        });
        this.f15115e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SeatCountFragmentDialogV2.this.m12437c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12437c() {
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f15111a = businessContext;
    }
}
