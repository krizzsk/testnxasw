package com.didi.component.common.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.List;

public class GCommonContactsAdapter extends RecyclerView.Adapter {

    /* renamed from: c */
    private static final int f13326c = 1;

    /* renamed from: d */
    private static final int f13327d = 3;

    /* renamed from: a */
    private List<GCommonContactsModel> f13328a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GCommonCheckedChangedListener f13329b;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13330e = true;

    public interface GCommonCheckedChangedListener {
        void onCheckedChanged(GCommonContactsModel gCommonContactsModel, boolean z);
    }

    public void addData(List<GCommonContactsModel> list) {
        if (list != null && !list.isEmpty()) {
            if (this.f13328a == null) {
                this.f13328a = new GCommonContactsList();
            }
            this.f13328a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<GCommonContactsModel> getSystemDatas() {
        return this.f13328a;
    }

    public void updateCheckable(boolean z) {
        if (z != this.f13330e) {
            this.f13330e = z;
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private GCommonContactsModel m11158a(int i) {
        List<GCommonContactsModel> list = this.f13328a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public List<GCommonContactsModel> getDatas() {
        return this.f13328a;
    }

    public void updateSystemData(List<GCommonContactsModel> list) {
        this.f13328a = list;
        notifyDataSetChanged();
    }

    public void setListener(GCommonCheckedChangedListener gCommonCheckedChangedListener) {
        this.f13329b = gCommonCheckedChangedListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new GCommonContactInfoSelectVH(viewGroup);
        }
        if (i == 3) {
            return new GCommonSortHeaderVH(viewGroup);
        }
        return new GCommonContactInfoSelectVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((GCommonBaseVH) viewHolder).setData(m11158a(i));
    }

    public int getItemCount() {
        List<GCommonContactsModel> list = this.f13328a;
        if (list != null) {
            return 0 + list.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        GCommonContactsModel a = m11158a(i);
        return (a == null || a.type != 3) ? 1 : 3;
    }

    public class GCommonContactInfoSelectVH extends GCommonContactInfoBaseVH {
        public GCommonContactInfoSelectVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_common_contacts_info_layout, viewGroup, false));
            this.mContactSelectBtn.setVisibility(0);
        }

        public void setData(final GCommonContactsModel gCommonContactsModel) {
            super.setData(gCommonContactsModel);
            if (gCommonContactsModel != null) {
                this.mContactSelectBtn.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (gCommonContactsModel.checked) {
                            gCommonContactsModel.checked = false;
                        } else {
                            gCommonContactsModel.checked = true;
                        }
                        GCommonContactInfoSelectVH.this.updateViewByCheckStatus(gCommonContactsModel.checked);
                        if (GCommonContactsAdapter.this.f13329b != null) {
                            GCommonCheckedChangedListener a = GCommonContactsAdapter.this.f13329b;
                            GCommonContactsModel gCommonContactsModel = gCommonContactsModel;
                            a.onCheckedChanged(gCommonContactsModel, gCommonContactsModel.checked);
                        }
                    }
                });
                updateViewByCheckStatus(gCommonContactsModel.checked);
            }
        }

        /* access modifiers changed from: private */
        public void updateViewByCheckStatus(boolean z) {
            if (z) {
                this.mContactName.setTextColor(DidiThemeManager.getIns().getResPicker(this.itemView.getContext()).getColor(R.attr.caution_color));
                this.mContactSelectBtn.setChecked(true);
                this.mContactSelectBtn.setEnabled(true);
                this.mContactSelectBtn.setClickable(false);
                return;
            }
            this.mContactName.setTextColor(this.itemView.getContext().getResources().getColor(R.color.sf_color_333333));
            this.mContactSelectBtn.setChecked(false);
            this.mContactSelectBtn.setClickable(false);
            if (!GCommonContactsAdapter.this.f13330e) {
                this.mContactSelectBtn.setEnabled(false);
                this.itemView.setOnClickListener((View.OnClickListener) null);
                return;
            }
            this.mContactSelectBtn.setEnabled(true);
        }
    }

    public static class GCommonSortHeaderVH extends GCommonBaseVH {
        private TextView keyTv = ((TextView) this.itemView.findViewById(R.id.g_common_key_tv));

        public GCommonSortHeaderVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_common_contacts_sord_key_item, viewGroup, false));
        }

        public void setData(GCommonContactsModel gCommonContactsModel) {
            if (gCommonContactsModel != null) {
                this.keyTv.setText(gCommonContactsModel.name);
            }
        }
    }
}
