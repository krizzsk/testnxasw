package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletNewPayMethodListContract;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WalletNewPayMethodAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f34857a = R.drawable.wallet_global_home_pay_method_item_bg_selector;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f34858b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<WalletNewPayMethodListContract.ItemModel> f34859c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Callback f34860d;

    public interface Callback {
        void onItemClicked(int i);

        void onItemRightLabelClicked(int i);
    }

    public WalletNewPayMethodAdapter(Context context) {
        this.f34858b = context;
        this.f34859c = new ArrayList();
    }

    public void setCallback(Callback callback) {
        this.f34860d = callback;
    }

    public void setItemBgSelector(int i) {
        this.f34857a = i;
    }

    public void setData(List<WalletNewPayMethodListContract.ItemModel> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f34859c.clear();
            this.f34859c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<WalletNewPayMethodListContract.ItemModel> getData() {
        return this.f34859c;
    }

    public int getItemViewType(int i) {
        if (this.f34859c.get(i) != null) {
            return this.f34859c.get(i).type;
        }
        return 0;
    }

    public int getItemCount() {
        return this.f34859c.size();
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new LabelViewHolder(m26618a(viewGroup, R.layout.wallet_global_new_paymethod_item_label));
        }
        return new NormalViewHolder(m26618a(viewGroup, R.layout.wallet_global_new_paymethod_item_normal));
    }

    /* renamed from: a */
    private View m26618a(ViewGroup viewGroup, int i) {
        return LayoutInflater.from(this.f34858b).inflate(i, viewGroup, false);
    }

    abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: protected */
        public abstract void bind(int i, WalletNewPayMethodListContract.ItemModel itemModel);

        /* access modifiers changed from: protected */
        public abstract void initView();

        private BaseViewHolder(View view) {
            super(view);
            initView();
        }

        /* access modifiers changed from: protected */
        public void onBind(final int i) {
            WalletNewPayMethodListContract.ItemModel itemModel = (WalletNewPayMethodListContract.ItemModel) WalletNewPayMethodAdapter.this.f34859c.get(i);
            bind(i, itemModel);
            final boolean z = itemModel != null && itemModel.isInFreezeMode;
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!z && WalletNewPayMethodAdapter.this.f34860d != null) {
                        WalletNewPayMethodAdapter.this.f34860d.onItemClicked(i);
                    }
                }
            });
        }
    }

    private class NormalViewHolder extends BaseViewHolder {
        private ImageView mIvIcon;
        private ImageView mIvRightIcon;
        private TextView mTvDesc;
        private TextView mTvName;
        private TextView mTvRightLabel;

        NormalViewHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void initView() {
            this.mIvIcon = (ImageView) this.itemView.findViewById(R.id.iv_paymethod_icon);
            this.mTvName = (TextView) this.itemView.findViewById(R.id.tv_paymethod_name);
            this.mTvDesc = (TextView) this.itemView.findViewById(R.id.tv_paymethod_desc);
            this.mTvRightLabel = (TextView) this.itemView.findViewById(R.id.tv_paymethod_right_text);
            this.mIvRightIcon = (ImageView) this.itemView.findViewById(R.id.iv_paymethod_right_icon);
        }

        /* access modifiers changed from: protected */
        public void bind(final int i, WalletNewPayMethodListContract.ItemModel itemModel) {
            if (itemModel != null) {
                this.itemView.setBackgroundResource(WalletNewPayMethodAdapter.this.f34857a);
                this.mIvIcon.setImageBitmap((Bitmap) null);
                if (!TextUtils.isEmpty(itemModel.iconUrl)) {
                    GlideUtils.with2load2into(WalletNewPayMethodAdapter.this.f34858b, itemModel.iconUrl, this.mIvIcon);
                } else if (itemModel.iconId != 0) {
                    this.mIvIcon.setImageResource(itemModel.iconId);
                }
                this.mTvName.setText(TextUtils.isEmpty(itemModel.name) ? "" : itemModel.name);
                if (TextUtils.isEmpty(itemModel.desc)) {
                    this.mTvDesc.setVisibility(8);
                } else {
                    this.mTvDesc.setVisibility(0);
                    this.mTvDesc.setText(itemModel.desc);
                    this.mTvDesc.setTextColor(ResourcesHelper.getColor(WalletNewPayMethodAdapter.this.f34858b, itemModel.descColor));
                }
                this.mTvRightLabel.setVisibility(8);
                this.mIvRightIcon.setVisibility(8);
                if (itemModel.rightStyle != 0) {
                    if (itemModel.rightStyle == 1) {
                        setRightArrow(itemModel.rightText, itemModel.rightTextColor, itemModel.rightTextBg);
                    } else if (itemModel.rightStyle == 2) {
                        setRightLabelIcon(itemModel.rightText, itemModel.rightTextColor, itemModel.rightTextBg);
                    }
                }
                if (itemModel.rightClickable) {
                    this.mTvRightLabel.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (WalletNewPayMethodAdapter.this.f34860d != null) {
                                WalletNewPayMethodAdapter.this.f34860d.onItemRightLabelClicked(i);
                            }
                        }
                    });
                } else {
                    this.mTvRightLabel.setOnClickListener((View.OnClickListener) null);
                }
            }
        }

        private void setRightArrow(String str, int i, int i2) {
            this.mIvRightIcon.setVisibility(0);
            if (!TextUtil.isEmpty(str)) {
                this.mTvRightLabel.setVisibility(0);
                this.mTvRightLabel.setTextColor(ResourcesHelper.getColor(WalletNewPayMethodAdapter.this.f34858b, i));
                this.mTvRightLabel.setText(str);
                this.mTvRightLabel.setBackgroundResource(i2);
                if (i2 != 0) {
                    this.mTvRightLabel.setTypeface(Typeface.defaultFromStyle(1));
                    this.mTvRightLabel.setPadding(UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 10.0f), 0, UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 10.0f), 0);
                } else {
                    this.mTvRightLabel.setTypeface(Typeface.defaultFromStyle(0));
                    this.mTvRightLabel.setPadding(0, 0, 0, 0);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTvRightLabel.getLayoutParams();
                layoutParams.removeRule(21);
                layoutParams.addRule(16, R.id.iv_paymethod_right_icon);
                layoutParams.setMarginEnd(UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 5.0f));
                this.mTvRightLabel.setLayoutParams(layoutParams);
            }
        }

        private void setRightLabelIcon(String str, int i, int i2) {
            if (!TextUtil.isEmpty(str)) {
                this.mTvRightLabel.setVisibility(0);
                this.mTvRightLabel.setTextColor(ResourcesHelper.getColor(WalletNewPayMethodAdapter.this.f34858b, i));
                this.mTvRightLabel.setText(str);
                this.mTvRightLabel.setBackgroundResource(i2);
                if (i2 != 0) {
                    this.mTvRightLabel.setTypeface(Typeface.defaultFromStyle(1));
                    this.mTvRightLabel.setPadding(UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 10.0f), UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 5.0f), UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 10.0f), UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 4.0f));
                } else {
                    this.mTvRightLabel.setTypeface(Typeface.defaultFromStyle(0));
                    this.mTvRightLabel.setPadding(0, 0, 0, 0);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTvRightLabel.getLayoutParams();
                layoutParams.removeRule(16);
                layoutParams.addRule(21);
                layoutParams.setMarginEnd(UIUtils.dip2px(WalletNewPayMethodAdapter.this.f34858b, 20.0f));
                this.mTvRightLabel.setLayoutParams(layoutParams);
            }
        }
    }

    private class LabelViewHolder extends BaseViewHolder {
        private TextView mTvLabel;

        private LabelViewHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void initView() {
            this.mTvLabel = (TextView) this.itemView.findViewById(R.id.tv_paymethod_label);
        }

        /* access modifiers changed from: protected */
        public void bind(int i, WalletNewPayMethodListContract.ItemModel itemModel) {
            if (itemModel != null) {
                this.itemView.setEnabled(!itemModel.isInFreezeMode);
                if (!itemModel.isInFreezeMode || itemModel.mainTextColor <= 0) {
                    this.mTvLabel.setTextColor(ResourcesHelper.getColor(WalletNewPayMethodAdapter.this.f34858b, R.color.wallet_color_FF8040));
                } else {
                    this.mTvLabel.setTextColor(ResourcesHelper.getColor(WalletNewPayMethodAdapter.this.f34858b, itemModel.mainTextColor));
                }
                this.itemView.setBackgroundResource(WalletNewPayMethodAdapter.this.f34857a);
                if (TextUtils.isEmpty(itemModel.name)) {
                    this.mTvLabel.setVisibility(8);
                    return;
                }
                this.mTvLabel.setVisibility(0);
                this.mTvLabel.setText(itemModel.name);
            }
        }
    }
}
