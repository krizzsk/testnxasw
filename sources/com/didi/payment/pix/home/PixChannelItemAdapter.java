package com.didi.payment.pix.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.home.p136vm.ChannelEntryClickVM;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

class PixChannelItemAdapter extends RecyclerView.Adapter<PixChannelViewHolder> {

    /* renamed from: a */
    List<PixChannelResp.ChannelEntry> f33609a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f33610b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ChannelEntryClickVM f33611c;

    public PixChannelItemAdapter(FragmentActivity fragmentActivity) {
        this.f33610b = fragmentActivity;
        this.f33611c = (ChannelEntryClickVM) new ViewModelProvider(fragmentActivity).get(ChannelEntryClickVM.class);
    }

    /* renamed from: a */
    public void mo89676a(List<PixChannelResp.ChannelEntry> list) {
        this.f33609a = list;
    }

    /* renamed from: a */
    public PixChannelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PixChannelViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_channel_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(PixChannelViewHolder pixChannelViewHolder, int i) {
        pixChannelViewHolder.bind(i);
    }

    public int getItemCount() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f33609a)) {
            return this.f33609a.size();
        }
        return 0;
    }

    class PixChannelViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImg;
        /* access modifiers changed from: private */
        public PixChannelResp.ChannelEntry mChannel;
        TextView titleTv;

        public PixChannelViewHolder(View view) {
            super(view);
            this.iconImg = (ImageView) view.findViewById(R.id.pix_channel_item_icon_img);
            this.titleTv = (TextView) view.findViewById(R.id.pix_channel_item_title_tv);
            view.setOnClickListener(new DoubleCheckOnClickListener(PixChannelItemAdapter.this) {
                public void doClick(View view) {
                    if (PixChannelViewHolder.this.mChannel != null) {
                        int typeId = PixChannelViewHolder.this.mChannel.getTypeId();
                        if (typeId == 1) {
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_ck");
                        } else if (typeId == 2) {
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_ck");
                        } else if (typeId == 3) {
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_ck");
                        }
                        PixChannelItemAdapter.this.f33611c.pixChannel.setValue(PixChannelViewHolder.this.mChannel);
                    }
                }
            });
        }

        public void bind(int i) {
            if (!CollectionUtil.isEmpty((Collection<?>) PixChannelItemAdapter.this.f33609a) && i <= PixChannelItemAdapter.this.f33609a.size() - 1) {
                PixChannelResp.ChannelEntry channelEntry = PixChannelItemAdapter.this.f33609a.get(i);
                this.mChannel = channelEntry;
                if (!TextUtil.isEmpty(channelEntry.icon)) {
                    GlideUtils.with2load2into(PixChannelItemAdapter.this.f33610b, channelEntry.icon, this.iconImg);
                }
                this.titleTv.setText(channelEntry.name);
            }
        }
    }
}
