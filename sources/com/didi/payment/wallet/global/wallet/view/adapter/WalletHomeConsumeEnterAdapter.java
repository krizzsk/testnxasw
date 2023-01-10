package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.utils.ColorsUtils;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.List;

public class WalletHomeConsumeEnterAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    OnActionInterceptor f34844a;

    /* renamed from: b */
    private List<WalletHomeResp.ConsumeItem> f34845b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f34846c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AdapterItemCallback f34847d;

    public interface AdapterItemCallback {
        void onConsumeEntryItemClicked(WalletHomeResp.ConsumeItem consumeItem);
    }

    public interface OnActionInterceptor {
        boolean onIntercept(int i, WalletHomeResp.ConsumeItem consumeItem);
    }

    public WalletHomeConsumeEnterAdapter(Context context, AdapterItemCallback adapterItemCallback) {
        this.f34846c = context;
        this.f34847d = adapterItemCallback;
    }

    public void setData(List<WalletHomeResp.ConsumeItem> list) {
        this.f34845b = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CardViewHolder(LayoutInflater.from(this.f34846c).inflate(R.layout.wallet_global_home_consume_enter_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((CardViewHolder) viewHolder).bindData(this.f34845b.get(i));
    }

    public int getItemCount() {
        List<WalletHomeResp.ConsumeItem> list = this.f34845b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvIcon;
        private View mShadowView;
        private TextView mTvTag;
        private TextView mTvTitle;

        public CardViewHolder(View view) {
            super(view);
            this.mTvTitle = (TextView) view.findViewById(R.id.tv_consume_item_title);
            this.mTvTag = (TextView) view.findViewById(R.id.tv_consume_item_tag);
            this.mIvIcon = (ImageView) view.findViewById(R.id.iv_consume_item_icon);
            this.mShadowView = view.findViewById(R.id.view_shadow);
            resetWidth();
        }

        private void resetWidth() {
            int screenWidth = UIUtils.getScreenWidth(WalletHomeConsumeEnterAdapter.this.f34846c);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            layoutParams.width = (screenWidth / 2) - UIUtils.dip2px(WalletHomeConsumeEnterAdapter.this.f34846c, 8.0f);
            this.itemView.setLayoutParams(layoutParams);
        }

        public void bindData(final WalletHomeResp.ConsumeItem consumeItem) {
            int parseColor;
            if (consumeItem != null) {
                this.mTvTitle.setText(consumeItem.name);
                if (TextUtils.isEmpty(consumeItem.promotionText)) {
                    this.mTvTag.setVisibility(8);
                } else {
                    this.mTvTag.setVisibility(0);
                    this.mTvTag.setText(consumeItem.promotionText);
                    int parseColor2 = ColorsUtils.parseColor(consumeItem.promotionTextFontColor);
                    if (parseColor2 != -1) {
                        this.mTvTag.setTextColor(parseColor2);
                    }
                    Drawable background = this.mTvTag.getBackground();
                    if ((background instanceof GradientDrawable) && (parseColor = ColorsUtils.parseColor(consumeItem.promotionTextBgColor, "#BDF3A6")) != -1) {
                        ((GradientDrawable) background).setColor(parseColor);
                    }
                }
                if (consumeItem.productLine == 606) {
                    this.mIvIcon.setImageResource(R.drawable.wallet_global_home_consume_utilities_icon);
                } else if (consumeItem.productLine == 605) {
                    this.mIvIcon.setImageResource(R.drawable.wallet_global_home_consume_phone_icon);
                } else if (consumeItem.productLine == 99999) {
                    FinOmegaSDK.trackEvent("ibt_didipay_p2p_transfer_sw");
                }
                if (!TextUtils.isEmpty(consumeItem.iconUrl)) {
                    GlideUtils.with2load2into(WalletHomeConsumeEnterAdapter.this.f34846c, consumeItem.iconUrl, this.mIvIcon);
                }
                if (consumeItem.isBlocked) {
                    this.mShadowView.setVisibility(0);
                } else {
                    this.mShadowView.setVisibility(4);
                }
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if ((WalletHomeConsumeEnterAdapter.this.f34844a == null || !WalletHomeConsumeEnterAdapter.this.f34844a.onIntercept(0, consumeItem)) && WalletHomeConsumeEnterAdapter.this.f34847d != null && !consumeItem.isBlocked) {
                            WalletHomeConsumeEnterAdapter.this.f34847d.onConsumeEntryItemClicked(consumeItem);
                        }
                    }
                });
            }
        }
    }

    public void setInternalActionInterceptor(OnActionInterceptor onActionInterceptor) {
        this.f34844a = onActionInterceptor;
    }
}
