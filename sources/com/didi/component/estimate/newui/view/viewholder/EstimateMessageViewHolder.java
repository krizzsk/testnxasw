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
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.taxis99.R;

public class EstimateMessageViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private Context f15055a;

    /* renamed from: b */
    private View f15056b;

    /* renamed from: c */
    private View f15057c;

    /* renamed from: d */
    private View f15058d;

    /* renamed from: e */
    private ImageView f15059e;

    /* renamed from: f */
    private TextView f15060f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CarMessageModel f15061g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MessageListener f15062h;

    public interface MessageListener {
        void onMessageClick(CarMessageModel carMessageModel);
    }

    public EstimateMessageViewHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.estimate_item_message, viewGroup, false));
        this.f15055a = viewGroup.getContext();
        m12381a();
    }

    /* renamed from: a */
    private void m12381a() {
        this.f15058d = this.itemView.findViewById(R.id.layout_card_root);
        this.f15057c = this.itemView.findViewById(R.id.layer_view);
        this.f15056b = this.itemView.findViewById(R.id.layout_card);
        this.f15059e = (ImageView) this.itemView.findViewById(R.id.iv_icon);
        this.f15060f = (TextView) this.itemView.findViewById(R.id.tv_message);
        this.f15056b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EstimateMessageViewHolder.this.f15062h != null) {
                    EstimateMessageViewHolder.this.f15062h.onMessageClick(EstimateMessageViewHolder.this.f15061g);
                }
            }
        });
    }

    public void setListener(MessageListener messageListener) {
        this.f15062h = messageListener;
    }

    public void setData(CarMessageModel carMessageModel) {
        this.f15061g = carMessageModel;
        update();
    }

    public void update() {
        int i;
        int i2;
        CarMessageModel carMessageModel = this.f15061g;
        if (carMessageModel == null || TextUtils.isEmpty(carMessageModel.messageBgStart) || TextUtils.isEmpty(this.f15061g.messageBgEnd)) {
            i2 = Color.parseColor("#FFDDCC");
            i = Color.parseColor("#FFF0E6");
        } else {
            try {
                i2 = Color.parseColor(this.f15061g.messageBgStart);
                i = Color.parseColor(this.f15061g.messageBgEnd);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                i2 = Color.parseColor("#FFDDCC");
                i = Color.parseColor("#FFF0E6");
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i});
        gradientDrawable.setGradientType(0);
        this.f15057c.setVisibility(8);
        this.f15057c.setVisibility(0);
        gradientDrawable.setCornerRadii(new float[]{(float) UiUtils.dip2px(this.f15055a, 20.0f), (float) UiUtils.dip2px(this.f15055a, 20.0f), (float) UiUtils.dip2px(this.f15055a, 20.0f), (float) UiUtils.dip2px(this.f15055a, 20.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        this.f15058d.setBackground(gradientDrawable);
        CarMessageModel carMessageModel2 = this.f15061g;
        if (carMessageModel2 == null || TextUtils.isEmpty(carMessageModel2.messageIcon)) {
            this.f15059e.setVisibility(8);
        } else {
            this.f15059e.setVisibility(0);
            Context context = this.f15055a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f15055a).load(this.f15061g.messageIcon).into(this.f15059e);
            }
        }
        TextView textView = this.f15060f;
        CarMessageModel carMessageModel3 = this.f15061g;
        textView.setTextColor(UiUtils.parseColor(carMessageModel3 != null ? carMessageModel3.messageTextColor : null, "#662200"));
        CarMessageModel carMessageModel4 = this.f15061g;
        if (carMessageModel4 == null || TextUtils.isEmpty(carMessageModel4.messageTex)) {
            this.f15060f.setText("");
        } else {
            this.f15060f.setText(this.f15061g.messageTex);
        }
    }
}
