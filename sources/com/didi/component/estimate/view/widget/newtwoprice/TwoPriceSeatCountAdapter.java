package com.didi.component.estimate.view.widget.newtwoprice;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class TwoPriceSeatCountAdapter extends RecyclerView.Adapter<SeatCountViewHolder> {

    /* renamed from: a */
    private Context f15122a;

    /* renamed from: b */
    private List<CarSeatChoiceModel> f15123b;

    /* renamed from: c */
    private LayoutInflater f15124c;

    /* renamed from: d */
    private int f15125d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnSeatItemClickListener f15126e;

    public interface OnSeatItemClickListener {
        void onItemClick(int i);
    }

    public TwoPriceSeatCountAdapter(Context context) {
        this.f15122a = context;
        this.f15123b = new ArrayList();
        this.f15124c = LayoutInflater.from(context);
    }

    public List<CarSeatChoiceModel> getData() {
        return this.f15123b;
    }

    public void updateData(List<CarSeatChoiceModel> list) {
        this.f15123b = list;
        notifyDataSetChanged();
    }

    public void setOnSeatItemClickListener(OnSeatItemClickListener onSeatItemClickListener) {
        this.f15126e = onSeatItemClickListener;
    }

    public SeatCountViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SeatCountViewHolder(this.f15124c.inflate(R.layout.global_two_price_list_item_new_ui, viewGroup, false));
    }

    public void onBindViewHolder(SeatCountViewHolder seatCountViewHolder, final int i) {
        CarSeatChoiceModel carSeatChoiceModel = this.f15123b.get(i);
        seatCountViewHolder.seatCount.setText(carSeatChoiceModel.choiceText.getContent());
        if (this.f15125d == i) {
            seatCountViewHolder.itemImg.setImageResource(DidiThemeManager.getIns().getResPicker(this.f15122a).getResIdByTheme(R.attr.new_ui_common_icon_radio_large));
            carSeatChoiceModel.valueText.bindTextView(seatCountViewHolder.price);
        } else {
            seatCountViewHolder.itemImg.setImageResource(R.drawable.com_icon_radio_large_unsel);
            seatCountViewHolder.price.setText("");
        }
        if (this.f15125d != i || carSeatChoiceModel == null || carSeatChoiceModel.extraText == null || TextUtils.isEmpty(carSeatChoiceModel.extraText.getContent())) {
            seatCountViewHolder.tips.setText("");
        } else {
            carSeatChoiceModel.extraText.bindTextView(seatCountViewHolder.tips);
        }
        seatCountViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TwoPriceSeatCountAdapter.this.f15126e != null) {
                    TwoPriceSeatCountAdapter.this.f15126e.onItemClick(i);
                }
            }
        });
    }

    public int getItemCount() {
        List<CarSeatChoiceModel> list = this.f15123b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setSelectedPos(int i) {
        if (i >= 0) {
            this.f15125d = i;
            notifyDataSetChanged();
        }
    }

    static class SeatCountViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;
        View itemLayout;
        TextView peopleTv;
        TextView price;
        TextView seatCount;
        TextView tips;

        public SeatCountViewHolder(View view) {
            super(view);
            this.itemLayout = view;
            this.seatCount = (TextView) view.findViewById(R.id.seat_count_number);
            this.peopleTv = (TextView) view.findViewById(R.id.seat_rider_text);
            this.price = (TextView) view.findViewById(R.id.seat_count_estimate_price);
            this.itemImg = (ImageView) view.findViewById(R.id.seat_count_select_item_icon);
            this.tips = (TextView) view.findViewById(R.id.seat_count_tips);
        }
    }
}
