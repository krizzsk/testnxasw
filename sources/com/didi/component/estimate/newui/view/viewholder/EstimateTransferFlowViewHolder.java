package com.didi.component.estimate.newui.view.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.estimate.newui.view.DynamicArrowDrawable;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.taxis99.R;

public class EstimateTransferFlowViewHolder extends RecyclerView.ViewHolder {
    public static final int TYPE_HORIZON = 0;
    public static final int TYPE_VERTICAL = 1;

    /* renamed from: a */
    private Context f15063a;

    /* renamed from: b */
    private View f15064b;

    /* renamed from: c */
    private ImageView f15065c;

    /* renamed from: d */
    private TextView f15066d;

    /* renamed from: e */
    private View f15067e;

    /* renamed from: f */
    private GradientDrawable f15068f;

    /* renamed from: g */
    private DynamicArrowDrawable f15069g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CarMessageModel f15070h;

    /* renamed from: i */
    private int f15071i = -1;

    /* renamed from: j */
    private float f15072j;

    /* renamed from: k */
    private float f15073k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TransferFlowListener f15074l;

    /* renamed from: m */
    private RecyclerView f15075m;

    /* renamed from: n */
    private int f15076n = 0;

    /* renamed from: o */
    private RecyclerView.OnScrollListener f15077o = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            EstimateTransferFlowViewHolder.this.m12386b();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            EstimateTransferFlowViewHolder.this.m12386b();
        }
    };

    public interface TransferFlowListener {
        void onTransferFlowClick(CarMessageModel carMessageModel);

        void onTransferFlowCloseClick(CarMessageModel carMessageModel);
    }

    public EstimateTransferFlowViewHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.estimate_item_transfer_flow, viewGroup, false));
        this.f15063a = viewGroup.getContext();
        m12383a();
    }

    /* renamed from: a */
    private void m12383a() {
        this.f15064b = this.itemView.findViewById(R.id.layout_card);
        this.f15065c = (ImageView) this.itemView.findViewById(R.id.iv_icon);
        this.f15066d = (TextView) this.itemView.findViewById(R.id.tv_msg);
        this.f15067e = this.itemView.findViewById(R.id.layout_close);
        this.f15072j = (float) UiUtils.dip2px(this.f15063a, 12.0f);
        this.f15073k = (float) UiUtils.dip2px(this.f15063a, 8.0f);
        DynamicArrowDrawable dynamicArrowDrawable = new DynamicArrowDrawable();
        this.f15069g = dynamicArrowDrawable;
        dynamicArrowDrawable.setCornerRadius((float) UiUtils.dip2px(this.f15063a, 20.0f));
        this.f15069g.setArrow(3, 0.0f, 0.0f, this.f15072j, this.f15073k);
        this.f15064b.setBackground(this.f15069g);
        this.f15064b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EstimateTransferFlowViewHolder.this.f15074l != null) {
                    EstimateTransferFlowViewHolder.this.f15074l.onTransferFlowClick(EstimateTransferFlowViewHolder.this.f15070h);
                }
            }
        });
        this.f15067e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EstimateTransferFlowViewHolder.this.f15074l != null) {
                    EstimateTransferFlowViewHolder.this.f15074l.onTransferFlowCloseClick(EstimateTransferFlowViewHolder.this.f15070h);
                }
            }
        });
    }

    public void setListener(TransferFlowListener transferFlowListener) {
        this.f15074l = transferFlowListener;
    }

    public void setCarRecyclerView(RecyclerView recyclerView) {
        this.f15075m = recyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.f15077o);
        }
    }

    public void setData(CarMessageModel carMessageModel, int i) {
        this.f15070h = carMessageModel;
        this.f15071i = i;
        update();
    }

    public void update() {
        int i;
        int i2;
        CarMessageModel carMessageModel = this.f15070h;
        if (carMessageModel == null || TextUtils.isEmpty(carMessageModel.messageBgStart) || TextUtils.isEmpty(this.f15070h.messageBgEnd)) {
            i2 = Color.parseColor("#FFEACC");
            i = Color.parseColor("#FFF7E6");
        } else {
            try {
                i2 = Color.parseColor(this.f15070h.messageBgStart);
                i = Color.parseColor(this.f15070h.messageBgEnd);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                i2 = Color.parseColor("#FFEACC");
                i = Color.parseColor("#FFF7E6");
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i});
        this.f15068f = gradientDrawable;
        gradientDrawable.setGradientType(0);
        this.f15069g.setSrcDrawable(this.f15068f);
        this.f15064b.setBackground(this.f15069g);
        this.itemView.post(new Runnable() {
            public void run() {
                EstimateTransferFlowViewHolder.this.m12386b();
            }
        });
        if (!TextUtils.isEmpty(this.f15070h.messageIcon)) {
            this.f15065c.setVisibility(0);
            Context context = this.f15063a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f15063a).load(this.f15070h.messageIcon).into(this.f15065c);
            }
        } else {
            this.f15065c.setVisibility(8);
        }
        this.f15066d.setTextColor(UiUtils.parseColor(this.f15070h.messageTextColor, "#663300"));
        if (!TextUtils.isEmpty(this.f15070h.messageTex)) {
            this.f15066d.setText(this.f15070h.messageTex);
        } else {
            this.f15066d.setText("");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12386b() {
        int i;
        int i2;
        RecyclerView recyclerView = this.f15075m;
        if (recyclerView != null && (i = this.f15071i) >= 0) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
            if (findViewHolderForAdapterPosition == null) {
                this.f15069g.setArrow(3, 0.0f, 0.0f, this.f15072j, this.f15073k);
                return;
            }
            int[] iArr = new int[2];
            findViewHolderForAdapterPosition.itemView.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            this.f15064b.getLocationOnScreen(iArr2);
            float max = (float) Math.max(iArr[0], iArr2[0]);
            float min = (float) Math.min(iArr[0] + findViewHolderForAdapterPosition.itemView.getWidth(), iArr2[0] + this.f15064b.getWidth());
            if (this.f15076n == 1) {
                i2 = UiUtils.dip2px(this.f15063a, 80.0f);
            } else {
                i2 = (((int) (max + min)) / 2) - iArr2[0];
            }
            this.f15069g.setArrow(3, (float) i2, (float) UiUtils.dip2px(this.f15063a, 40.0f), this.f15072j, this.f15073k);
        }
    }

    public void setType(int i) {
        this.f15076n = i;
    }
}
