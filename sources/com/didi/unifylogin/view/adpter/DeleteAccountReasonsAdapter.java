package com.didi.unifylogin.view.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountReasonsAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<DeleteAccountReason> f47735a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean[] f47736b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f47737c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnOtherReasonItemSelectedChangedListener f47738d;

    public interface OnOtherReasonItemSelectedChangedListener {
        void onOtherReasonItemSelectedChanged(boolean z);
    }

    public DeleteAccountReasonsAdapter(List<DeleteAccountReason> list) {
        if (list != null) {
            this.f47735a = list;
            this.f47736b = new boolean[list.size()];
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (LoginPreferredConfig.isUsePassengerUIStyle()) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_delete_account_reason_passenger_style, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_delete_account_reason, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.titleTv.setText(this.f47735a.get(i).reason);
        viewHolder.reasonCb.setSelected(false);
        this.f47736b[i] = false;
        viewHolder.reasonCb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = !viewHolder.reasonCb.isSelected();
                viewHolder.reasonCb.setSelected(z);
                if (((DeleteAccountReason) DeleteAccountReasonsAdapter.this.f47735a.get(i)).isOtherReason) {
                    boolean unused = DeleteAccountReasonsAdapter.this.f47737c = z;
                    if (DeleteAccountReasonsAdapter.this.f47738d != null) {
                        DeleteAccountReasonsAdapter.this.f47738d.onOtherReasonItemSelectedChanged(z);
                        return;
                    }
                    return;
                }
                DeleteAccountReasonsAdapter.this.f47736b[i] = z;
            }
        });
        if (i == this.f47735a.size() - 1) {
            viewHolder.divider.setVisibility(8);
        }
    }

    public int getItemCount() {
        return this.f47735a.size();
    }

    public List<String> getSelectedReasons() {
        ArrayList arrayList = new ArrayList();
        List<DeleteAccountReason> list = this.f47735a;
        if (!(list == null || this.f47736b == null)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.f47736b[i] && !this.f47735a.get(i).isOtherReason) {
                    arrayList.add(this.f47735a.get(i).reason);
                }
            }
        }
        return arrayList;
    }

    public boolean isOtherReasonSelected() {
        return this.f47737c;
    }

    public void setOnOtherReasonItemSelectedChangedListener(OnOtherReasonItemSelectedChangedListener onOtherReasonItemSelectedChangedListener) {
        this.f47738d = onOtherReasonItemSelectedChangedListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View divider;
        ImageView reasonCb;
        TextView titleTv;

        public ViewHolder(View view) {
            super(view);
            this.titleTv = (TextView) view.findViewById(R.id.tv_title);
            this.reasonCb = (ImageView) view.findViewById(R.id.cb_reason);
            this.divider = view.findViewById(R.id.divider);
        }
    }

    public static class DeleteAccountReason {
        boolean isOtherReason;
        String reason;

        public DeleteAccountReason(String str, boolean z) {
            this.reason = str;
            this.isOtherReason = z;
        }
    }
}
