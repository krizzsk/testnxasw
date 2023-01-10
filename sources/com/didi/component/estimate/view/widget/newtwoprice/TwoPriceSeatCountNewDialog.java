package com.didi.component.estimate.view.widget.newtwoprice;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.estimate.presenter.EstimatePresenter;
import com.didi.component.estimate.view.widget.newtwoprice.TwoPriceSeatCountAdapter;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.popup.PopupSelectRecyclerView;
import com.didi.travel.psnger.model.response.estimate.CarBreakSeatModel;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.List;

public class TwoPriceSeatCountNewDialog extends SimplePopupBase {

    /* renamed from: a */
    private BusinessContext f15127a;

    /* renamed from: b */
    private int f15128b;

    /* renamed from: c */
    private TextView f15129c;

    /* renamed from: d */
    private TextView f15130d;

    /* renamed from: e */
    private ImageView f15131e;

    /* renamed from: f */
    private PopupSelectRecyclerView f15132f;

    /* renamed from: g */
    private TextView f15133g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TwoPriceSeatCountAdapter f15134h;

    /* renamed from: i */
    private CarBreakSeatModel f15135i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f15136j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public EstimatePresenter f15137k;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_two_price_dialog_new_ui_layout;
    }

    public static TwoPriceSeatCountNewDialog newInstance(int i) {
        TwoPriceSeatCountNewDialog twoPriceSeatCountNewDialog = new TwoPriceSeatCountNewDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("default_people", i);
        twoPriceSeatCountNewDialog.setArguments(bundle);
        return twoPriceSeatCountNewDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f15128b = arguments.getInt("default_people", 0);
        } else {
            this.f15128b = 1;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f15129c = (TextView) this.mRootView.findViewById(R.id.global_seat_count_title);
        this.f15130d = (TextView) this.mRootView.findViewById(R.id.global_seat_count_subtitle);
        this.f15131e = (ImageView) this.mRootView.findViewById(R.id.global_seat_count_close_btn);
        this.f15132f = (PopupSelectRecyclerView) this.mRootView.findViewById(R.id.global_seat_count_recycler_view);
        this.f15133g = (TextView) this.mRootView.findViewById(R.id.global_seat_count_confirm_btn);
        m12442a();
        m12444b();
    }

    /* renamed from: a */
    private void m12442a() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.carBreakSeat != null) {
            CarBreakSeatModel carBreakSeatModel = newEstimateItem.carBreakModel.carBreakSeat;
            this.f15135i = carBreakSeatModel;
            if (!TextUtils.isEmpty(carBreakSeatModel.seatBreakTitle)) {
                this.f15129c.setText(this.f15135i.seatBreakTitle);
            }
            if (!TextUtils.isEmpty(this.f15135i.seatBreakContent)) {
                this.f15130d.setText(this.f15135i.seatBreakContent);
            }
            this.f15132f.setLayoutManager(new LinearLayoutManager(getContext()));
            TwoPriceSeatCountAdapter twoPriceSeatCountAdapter = new TwoPriceSeatCountAdapter(getContext());
            this.f15134h = twoPriceSeatCountAdapter;
            this.f15132f.setAdapter(twoPriceSeatCountAdapter);
            if (this.f15135i.seatBreakChoice != null && this.f15135i.seatBreakChoice.size() > 0) {
                this.f15134h.updateData(this.f15135i.seatBreakChoice);
            }
            int i = this.f15128b;
            if (i > 0) {
                this.f15134h.setSelectedPos(i - 1);
            }
        }
    }

    /* renamed from: b */
    private void m12444b() {
        this.f15134h.setOnSeatItemClickListener(new TwoPriceSeatCountAdapter.OnSeatItemClickListener() {
            public void onItemClick(int i) {
                int unused = TwoPriceSeatCountNewDialog.this.f15136j = i;
                TwoPriceSeatCountNewDialog.this.f15134h.setSelectedPos(i);
            }
        });
        this.f15133g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CarSeatChoiceModel carSeatChoiceModel;
                AutoTrackHelper.trackViewOnClick(view);
                if (!Utils.isFastDoubleClick()) {
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    List<CarSeatChoiceModel> data = TwoPriceSeatCountNewDialog.this.f15134h.getData();
                    if (!(data == null || data.size() <= 0 || newEstimateItem == null || (carSeatChoiceModel = data.get(TwoPriceSeatCountNewDialog.this.f15136j)) == null || carSeatChoiceModel.getselectValue() == null)) {
                        newEstimateItem.feeNumber = carSeatChoiceModel.getselectValue().seatPoolEstimatePrice;
                        newEstimateItem.estimateId = carSeatChoiceModel.getselectValue().seatPoolEstimateId;
                        FormStore.getInstance().setCurrentComboType(carSeatChoiceModel.getselectValue().comboType);
                        newEstimateItem.setSelectedValueParams(carSeatChoiceModel.getselectValue(), carSeatChoiceModel.selectValueObject);
                        newEstimateItem.setSelectPos(TwoPriceSeatCountNewDialog.this.f15136j);
                        FormStore.getInstance().setCarpoolOrderScene(carSeatChoiceModel.getselectValue().carpoolOrderScene);
                    }
                    TwoPriceSeatCountNewDialog.this.f15137k.onTwoPriceConfirmClick();
                }
            }
        });
        this.f15131e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TwoPriceSeatCountNewDialog.this.dismissDialog();
            }
        });
    }

    public void dismissDialog() {
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f15127a = businessContext;
    }

    public void setPresenter(EstimatePresenter estimatePresenter) {
        this.f15137k = estimatePresenter;
    }

    public int getSelectedSeatCount() {
        return this.f15136j + 1;
    }
}
