package com.didi.consume.phone.view.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.phone.model.CsAmountListResp;
import com.didi.payment.base.utils.UIUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsMobileAmountAdapter extends RecyclerView.Adapter<AmountHolder> implements View.OnClickListener {

    /* renamed from: a */
    private final List<CsAmountListResp.Amount> f18154a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final OnAmountClickListener f18155b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f18156c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f18157d = "";

    public interface OnAmountClickListener {
        void onClick(CsAmountListResp.Amount amount, String str);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public CsMobileAmountAdapter(Context context, List<CsAmountListResp.Amount> list, String str, OnAmountClickListener onAmountClickListener) {
        ArrayList arrayList = new ArrayList();
        this.f18154a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f18157d = str;
        this.f18155b = onAmountClickListener;
        this.f18156c = context;
    }

    public void refreshSelectAmount(CsAmountListResp.Amount amount) {
        Iterator<CsAmountListResp.Amount> it = this.f18154a.iterator();
        while (it.hasNext()) {
            CsAmountListResp.Amount next = it.next();
            next.selected = next == amount;
        }
        notifyDataSetChanged();
    }

    public CsAmountListResp.Amount getCurrentSelectItem() {
        for (CsAmountListResp.Amount next : this.f18154a) {
            if (next.selected) {
                return next;
            }
        }
        return null;
    }

    public AmountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AmountHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cs_fragment_amount_item, viewGroup, false), this.f18155b);
    }

    public void onBindViewHolder(AmountHolder amountHolder, int i) {
        amountHolder.bind(this.f18154a.get(i));
    }

    public int getItemCount() {
        return this.f18154a.size();
    }

    public class AmountHolder extends RecyclerView.ViewHolder {
        private TextView mTVAmount;
        private TextView mTVCashBack;
        private View mVSelected;

        public AmountHolder(View view, OnAmountClickListener onAmountClickListener) {
            super(view);
            this.mTVAmount = (TextView) view.findViewById(R.id.tv_amount_text);
            this.mTVCashBack = (TextView) view.findViewById(R.id.tv_cashback);
            this.mVSelected = view.findViewById(R.id.v_amount_selected);
        }

        public void bind(final CsAmountListResp.Amount amount) {
            setAmount(amount.currencySymbol, amount.amount, "1".equalsIgnoreCase(amount.disabled));
            if (amount.cashBackAmount != null) {
                amount.cashBackAmount.bindTextView(this.mTVCashBack);
                this.mTVCashBack.setVisibility(0);
            } else {
                this.mTVCashBack.setVisibility(8);
            }
            if (amount.selected) {
                this.mVSelected.setVisibility(0);
            } else {
                this.mVSelected.setVisibility(8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (CsMobileAmountAdapter.this.f18155b != null) {
                        CsMobileAmountAdapter.this.f18155b.onClick(amount, CsMobileAmountAdapter.this.f18157d);
                    }
                }
            });
        }

        private void setAmount(String str, String str2, boolean z) {
            String str3 = str + str2;
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(new AbsoluteSizeSpan(UIUtil.dip2px(CsMobileAmountAdapter.this.f18156c, 28.0f)), 0, str3.length(), 0);
            spannableString.setSpan(new AbsoluteSizeSpan(UIUtil.dip2px(CsMobileAmountAdapter.this.f18156c, 21.0f)), 0, str.length(), 0);
            spannableString.setSpan(new ForegroundColorSpan(CsMobileAmountAdapter.this.f18156c.getResources().getColor(z ? R.color.wallet_color_D4D7D9 : R.color.color_333333)), 0, str3.length(), 0);
            spannableString.setSpan(new StyleSpan(1), 0, str3.length(), 0);
            this.mTVAmount.setText(spannableString);
        }
    }
}
