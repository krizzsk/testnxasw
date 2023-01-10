package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WalletTopUpAdapterOldServer extends RecyclerView.Adapter<AmountHolder> implements View.OnClickListener {

    /* renamed from: a */
    private final List<WalletTopUpChannelResp.ExtraDataMexicoOnlineItem> f34881a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final OnAmountClickListener f34882b;

    /* renamed from: c */
    private final Context f34883c;

    public interface OnAmountClickListener {
        void onClick(WalletTopUpChannelResp.ExtraDataMexicoOnlineItem extraDataMexicoOnlineItem);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public WalletTopUpAdapterOldServer(Context context, List<WalletTopUpChannelResp.ExtraDataMexicoOnlineItem> list, OnAmountClickListener onAmountClickListener) {
        ArrayList arrayList = new ArrayList();
        this.f34881a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f34882b = onAmountClickListener;
        this.f34883c = context;
    }

    public void refreshSelectAmount(WalletTopUpChannelResp.ExtraDataMexicoOnlineItem extraDataMexicoOnlineItem) {
        for (WalletTopUpChannelResp.ExtraDataMexicoOnlineItem next : this.f34881a) {
            if (next == extraDataMexicoOnlineItem) {
                next.selected = true;
            } else {
                next.selected = false;
            }
        }
        notifyDataSetChanged();
    }

    public WalletTopUpChannelResp.ExtraDataMexicoOnlineItem getCurrentSelectItem() {
        for (WalletTopUpChannelResp.ExtraDataMexicoOnlineItem next : this.f34881a) {
            if (next.selected) {
                return next;
            }
        }
        return null;
    }

    public AmountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AmountHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_v_topup_amount_item, viewGroup, false), this.f34882b);
    }

    public void onBindViewHolder(AmountHolder amountHolder, int i) {
        amountHolder.bind(this.f34881a.get(i));
    }

    public int getItemCount() {
        return this.f34881a.size();
    }

    public class AmountHolder extends RecyclerView.ViewHolder {
        private TextView mTvDesc;
        private TextView mTvExtra;
        private TextView mTvName;
        private View mVSelected;

        public AmountHolder(View view, OnAmountClickListener onAmountClickListener) {
            super(view);
            this.mTvName = (TextView) view.findViewById(R.id.tv_name);
            this.mTvDesc = (TextView) view.findViewById(R.id.tv_desc);
            this.mTvExtra = (TextView) view.findViewById(R.id.tv_extra);
            this.mVSelected = view.findViewById(R.id.v_selected);
        }

        public void bind(final WalletTopUpChannelResp.ExtraDataMexicoOnlineItem extraDataMexicoOnlineItem) {
            if (TextUtils.isEmpty(extraDataMexicoOnlineItem.extra_info)) {
                this.mTvDesc.setVisibility(8);
                this.mTvExtra.setVisibility(8);
                this.mTvName.setText(WalletTopUpAdapterOldServer.this.m26642a(extraDataMexicoOnlineItem.name, true));
            } else {
                this.mTvDesc.setVisibility(0);
                this.mTvExtra.setVisibility(0);
                this.mTvName.setText(WalletTopUpAdapterOldServer.this.m26642a(extraDataMexicoOnlineItem.name, false));
                this.mTvDesc.setText(WalletTopUpAdapterOldServer.this.m26642a(extraDataMexicoOnlineItem.desc, false));
                this.mTvExtra.setText(WalletTopUpAdapterOldServer.this.m26641a(extraDataMexicoOnlineItem.extra_info));
            }
            if (extraDataMexicoOnlineItem.selected) {
                this.mVSelected.setVisibility(0);
            } else {
                this.mVSelected.setVisibility(8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletTopUpAdapterOldServer.this.f34882b != null) {
                        WalletTopUpAdapterOldServer.this.f34882b.onClick(extraDataMexicoOnlineItem);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public SpannableStringBuilder m26642a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder("");
        }
        String[] split = str.split("/");
        if (split.length != 3) {
            return new SpannableStringBuilder(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f34883c, 14.0f));
        spannableStringBuilder.append(split[0] + " ");
        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 34);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f34883c, 11.0f));
        spannableStringBuilder.append(split[1]);
        spannableStringBuilder.setSpan(absoluteSizeSpan2, split[0].length() + 1, spannableStringBuilder.length(), 34);
        AbsoluteSizeSpan absoluteSizeSpan3 = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f34883c, 18.0f));
        spannableStringBuilder.append(split[2]);
        spannableStringBuilder.setSpan(absoluteSizeSpan3, split[0].length() + split[1].length() + 1, spannableStringBuilder.length(), 34);
        if (z) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff6f2f")), split[0].length() + split[1].length() + 1, spannableStringBuilder.length(), 34);
        }
        return spannableStringBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public SpannableStringBuilder m26641a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder("");
        }
        String[] split = str.split("/");
        if (split.length != 2) {
            return new SpannableStringBuilder(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f34883c, 11.0f));
        spannableStringBuilder.append(split[0]);
        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 34);
        spannableStringBuilder.append("\n");
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f34883c, 9.0f));
        spannableStringBuilder.append(split[1]);
        spannableStringBuilder.setSpan(absoluteSizeSpan2, split[0].length(), spannableStringBuilder.length(), 34);
        return spannableStringBuilder;
    }
}
