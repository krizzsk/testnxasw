package com.didi.map.global.flow.toolkit.nav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.global.flow.toolkit.nav.VamosNavAdapter;
import com.taxis99.R;
import java.util.List;

public class VamosNavAdapter extends RecyclerView.Adapter<VamosNavViewHolder> {

    /* renamed from: a */
    private Context f29728a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<VamosNavModel> f29729b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnNavItemClickListener f29730c;

    interface OnNavItemClickListener {
        void onNavItemClicked(VamosNavModel vamosNavModel);
    }

    public VamosNavAdapter(Context context, List<VamosNavModel> list) {
        this.f29728a = context;
        this.f29729b = list;
    }

    public void setDataList(List<VamosNavModel> list) {
        this.f29729b = list;
    }

    public VamosNavViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new VamosNavViewHolder(LayoutInflater.from(this.f29728a).inflate(R.layout.item_nav_select, viewGroup, false));
    }

    public void onBindViewHolder(VamosNavViewHolder vamosNavViewHolder, int i) {
        VamosNavModel vamosNavModel = this.f29729b.get(i);
        vamosNavViewHolder.tvName.setText(vamosNavModel.name);
        if (vamosNavModel.isInstalled) {
            vamosNavViewHolder.tvInstallStatus.setVisibility(8);
            return;
        }
        vamosNavViewHolder.tvInstallStatus.setVisibility(0);
        vamosNavViewHolder.tvInstallStatus.setText(String.format("(%s)", new Object[]{this.f29728a.getResources().getString(R.string.map_setting_nav_not_install)}));
    }

    public int getItemCount() {
        List<VamosNavModel> list = this.f29729b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setOnNavItemClickListener(OnNavItemClickListener onNavItemClickListener) {
        this.f29730c = onNavItemClickListener;
    }

    class VamosNavViewHolder extends RecyclerView.ViewHolder {
        TextView tvInstallStatus;
        TextView tvName;

        public VamosNavViewHolder(View view) {
            super(view);
            this.tvName = (TextView) view.findViewById(R.id.tv_nav_item_name);
            this.tvInstallStatus = (TextView) view.findViewById(R.id.tv_nav_item_not_installed);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    VamosNavAdapter.VamosNavViewHolder.this.lambda$new$0$VamosNavAdapter$VamosNavViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$VamosNavAdapter$VamosNavViewHolder(View view) {
            if (VamosNavAdapter.this.f29730c != null && getLayoutPosition() >= 0 && getLayoutPosition() < VamosNavAdapter.this.f29729b.size()) {
                VamosNavAdapter.this.f29730c.onNavItemClicked((VamosNavModel) VamosNavAdapter.this.f29729b.get(getLayoutPosition()));
            }
        }
    }
}
