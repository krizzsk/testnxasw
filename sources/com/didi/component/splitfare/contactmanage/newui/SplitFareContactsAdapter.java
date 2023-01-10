package com.didi.component.splitfare.contactmanage.newui;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.splitfare.contactmanage.GlobalBaseVH;
import com.didi.component.splitfare.contactmanage.GlobalContactInfoBaseVH;
import com.didi.component.splitfare.contactmanage.GlobalContactsList;
import com.didi.component.splitfare.contactmanage.GlobalContactsModel;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SplitFareContactsAdapter extends RecyclerView.Adapter {
    public static final int TYPE_TIPS = 4;

    /* renamed from: f */
    private static final int f17836f = 1;

    /* renamed from: g */
    private static final int f17837g = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<GlobalContactsModel> f17838a;

    /* renamed from: b */
    private List<GlobalContactsModel> f17839b;

    /* renamed from: c */
    private List<GlobalContactsModel> f17840c;

    /* renamed from: d */
    private List<GlobalContactsModel> f17841d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GlobalCheckedChangedListener f17842e;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f17843h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f17844i;

    public interface GlobalCheckedChangedListener {
        void onCheckedChanged(GlobalContactsModel globalContactsModel, boolean z);

        void onSearchContactsClick(boolean z);
    }

    public SplitFareContactsAdapter(int i) {
        this.f17843h = i;
    }

    public void addData(List<GlobalContactsModel> list) {
        if (list != null && !list.isEmpty()) {
            if (this.f17839b == null) {
                this.f17839b = new GlobalContactsList();
            }
            m15104a(this.f17839b, list);
            if (this.f17841d == null) {
                this.f17841d = new GlobalContactsList();
            }
            this.f17841d.clear();
            m15104a(this.f17841d, this.f17839b);
            notifyDataSetChanged();
        }
    }

    public void addSplitFareData(GlobalContactsModel globalContactsModel) {
        if (!CollectionUtils.isEmpty((Collection) this.f17838a)) {
            for (GlobalContactsModel next : this.f17838a) {
                if (!TextUtils.isEmpty(next.phone) && !TextUtils.isEmpty(globalContactsModel.phone) && next.phone.equals(globalContactsModel.phone)) {
                    next.checked = globalContactsModel.checked;
                    notifyDataSetChanged();
                    return;
                }
            }
        }
        GlobalContactsModel globalContactsModel2 = new GlobalContactsModel();
        globalContactsModel2.name = globalContactsModel.name;
        globalContactsModel2.phone = globalContactsModel.phone;
        globalContactsModel2.checked = globalContactsModel.checked;
        globalContactsModel2.canSelected = globalContactsModel.canSelected;
        globalContactsModel2.type = 2;
        if (this.f17838a == null) {
            this.f17838a = new CopyOnWriteArrayList();
        }
        GlobalContactsModel globalContactsModel3 = null;
        if (this.f17838a.size() > 0) {
            Iterator<GlobalContactsModel> it = this.f17838a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GlobalContactsModel next2 = it.next();
                if (next2.type == 4) {
                    this.f17838a.remove(next2);
                    globalContactsModel3 = next2;
                    break;
                }
            }
        }
        this.f17838a.add(globalContactsModel2);
        if (globalContactsModel3 != null) {
            List<GlobalContactsModel> list = this.f17838a;
            list.add(list.size(), globalContactsModel3);
        }
        if (this.f17841d == null) {
            this.f17841d = new GlobalContactsList();
        }
        this.f17841d.clear();
        m15104a(this.f17841d, this.f17838a);
        m15104a(this.f17841d, this.f17839b);
        notifyDataSetChanged();
    }

    public void addTipsData(GlobalContactsModel globalContactsModel) {
        GlobalContactsModel globalContactsModel2 = new GlobalContactsModel();
        globalContactsModel2.name = globalContactsModel.name;
        globalContactsModel2.type = 4;
        if (this.f17838a == null) {
            this.f17838a = new CopyOnWriteArrayList();
        }
        if (this.f17838a.size() > 0) {
            List<GlobalContactsModel> list = this.f17838a;
            list.add(list.size(), globalContactsModel2);
        } else {
            this.f17838a.add(globalContactsModel2);
        }
        if (this.f17841d == null) {
            this.f17841d = new GlobalContactsList();
        }
        this.f17841d.clear();
        m15104a(this.f17841d, this.f17838a);
        m15104a(this.f17841d, this.f17839b);
        notifyDataSetChanged();
    }

    public void deleteTipsData(GlobalContactsModel globalContactsModel) {
        this.f17838a.remove(globalContactsModel);
        if (this.f17841d == null) {
            this.f17841d = new GlobalContactsList();
        }
        this.f17841d.clear();
        m15104a(this.f17841d, this.f17838a);
        m15104a(this.f17841d, this.f17839b);
        notifyDataSetChanged();
    }

    public void showDatas() {
        if (this.f17841d == null) {
            this.f17841d = new GlobalContactsList();
        }
        this.f17841d.clear();
        m15104a(this.f17841d, this.f17838a);
        m15104a(this.f17841d, this.f17839b);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m15104a(List<GlobalContactsModel> list, List<GlobalContactsModel> list2) {
        if (list != null && !CollectionUtils.isEmpty((Collection) list2)) {
            list.addAll(list2);
        }
    }

    /* renamed from: a */
    private GlobalContactsModel m15102a(int i) {
        List<GlobalContactsModel> list = this.f17841d;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public void updateSearchData(List<GlobalContactsModel> list) {
        this.f17844i = true;
        if (this.f17840c == null) {
            this.f17840c = new GlobalContactsList();
        }
        this.f17840c.clear();
        m15104a(this.f17840c, list);
        if (this.f17841d == null) {
            this.f17841d = new GlobalContactsList();
        }
        this.f17841d.clear();
        m15104a(this.f17841d, this.f17840c);
        notifyDataSetChanged();
    }

    public void deleteSplitFareData(GlobalContactsModel globalContactsModel) {
        if (!CollectionUtils.isEmpty((Collection) this.f17838a)) {
            Iterator<GlobalContactsModel> it = this.f17838a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GlobalContactsModel next = it.next();
                if (!TextUtils.isEmpty(next.phone) && !TextUtils.isEmpty(globalContactsModel.phone) && next.phone.equals(globalContactsModel.phone)) {
                    this.f17838a.remove(next);
                    if (this.f17841d == null) {
                        this.f17841d = new GlobalContactsList();
                    }
                    this.f17841d.clear();
                    m15104a(this.f17841d, this.f17838a);
                    m15104a(this.f17841d, this.f17839b);
                }
            }
            if (globalContactsModel.type == 2 && !CollectionUtils.isEmpty((Collection) this.f17839b)) {
                for (GlobalContactsModel next2 : this.f17839b) {
                    if (!TextUtils.isEmpty(next2.phone) && !TextUtils.isEmpty(globalContactsModel.phone) && globalContactsModel.phone.contains(next2.phone) && next2.checked) {
                        next2.checked = false;
                        next2.canSelected = true;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public void updateSosContacts(GlobalContactsModel globalContactsModel) {
        if (!CollectionUtils.isEmpty((Collection) this.f17838a)) {
            Iterator<GlobalContactsModel> it = this.f17838a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GlobalContactsModel next = it.next();
                if (!TextUtils.isEmpty(next.phone)) {
                    if (!TextUtils.isEmpty(globalContactsModel.originPhone) && next.phone.contains(globalContactsModel.originPhone)) {
                        next.checked = globalContactsModel.checked;
                        next.phone = globalContactsModel.phone;
                        break;
                    } else if (next.phone.contains(globalContactsModel.phone)) {
                        next.checked = globalContactsModel.checked;
                        next.phone = globalContactsModel.phone;
                        break;
                    }
                }
            }
            if (CollectionUtils.isEmpty((Collection) this.f17839b)) {
                notifyDataSetChanged();
                return;
            }
            Iterator<GlobalContactsModel> it2 = this.f17839b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                GlobalContactsModel next2 = it2.next();
                if (!TextUtils.isEmpty(next2.phone)) {
                    if (TextUtils.isEmpty(globalContactsModel.originPhone) || !next2.phone.contains(globalContactsModel.originPhone) || !globalContactsModel.name.equals(next2.name)) {
                        if (next2.phone.contains(globalContactsModel.phone) && globalContactsModel.name.equals(next2.name)) {
                            next2.checked = globalContactsModel.checked;
                            next2.phone = globalContactsModel.phone;
                            break;
                        }
                    } else {
                        next2.checked = globalContactsModel.checked;
                        next2.phone = globalContactsModel.phone;
                        break;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public void setListener(GlobalCheckedChangedListener globalCheckedChangedListener) {
        this.f17842e = globalCheckedChangedListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 4) {
            return new GlobalContactTipsVH(viewGroup);
        }
        if (i == 1) {
            return new GlobalContactInfoSelectVH(viewGroup);
        }
        if (i == 3) {
            return new GlobalSortHeaderVH(viewGroup);
        }
        return new GlobalContactInfoSelectVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((GlobalBaseVH) viewHolder).setData(m15102a(i));
    }

    public int getItemCount() {
        if (CollectionUtils.isEmpty((Collection) this.f17841d)) {
            return 0;
        }
        return this.f17841d.size();
    }

    public int getItemViewType(int i) {
        GlobalContactsModel a = m15102a(i);
        if (a == null || a.type != 4) {
            return (a == null || a.type != 3) ? 1 : 3;
        }
        return 4;
    }

    public class GlobalContactInfoSelectVH extends GlobalContactInfoBaseVH {
        protected TextView mCancel = ((TextView) this.itemView.findViewById(R.id.g_contact_cancel_btn));

        public GlobalContactInfoSelectVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_contacts_info_layout_new_selected, viewGroup, false));
            this.mContactSelectBtn.setVisibility(0);
        }

        public void setData(final GlobalContactsModel globalContactsModel) {
            super.setData(globalContactsModel);
            if (globalContactsModel != null) {
                C77411 r0 = new View.OnClickListener() {
                    public void onClick(View view) {
                        int i;
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SplitFareContactsAdapter.this.f17838a != null) {
                            i = 0;
                            for (GlobalContactsModel globalContactsModel : SplitFareContactsAdapter.this.f17838a) {
                                if (globalContactsModel.checked) {
                                    i++;
                                }
                            }
                        } else {
                            i = 0;
                        }
                        if (globalContactsModel.type == 1 && i == SplitFareContactsAdapter.this.f17843h) {
                            if (globalContactsModel.checked) {
                                globalContactsModel.checked = false;
                            } else {
                                ToastHelper.showShortInfo(GlobalContactInfoSelectVH.this.itemView.getContext(), String.format(GlobalContactInfoSelectVH.this.itemView.getContext().getString(R.string.g_splitfare_contacts_limit_time), new Object[]{Integer.valueOf(SplitFareContactsAdapter.this.f17843h)}), (int) R.drawable.global_toast_error);
                                return;
                            }
                        } else if (globalContactsModel.type == 2 && globalContactsModel.checked && !globalContactsModel.canSelected) {
                            GlobalContactsModel globalContactsModel2 = globalContactsModel;
                            globalContactsModel2.checked = globalContactsModel2.checked;
                        } else if (globalContactsModel.checked) {
                            globalContactsModel.checked = false;
                        } else {
                            globalContactsModel.checked = true;
                        }
                        GlobalContactInfoSelectVH.this.updateViewByCheckStatus(globalContactsModel.checked);
                        if (SplitFareContactsAdapter.this.f17842e != null) {
                            GlobalCheckedChangedListener c = SplitFareContactsAdapter.this.f17842e;
                            GlobalContactsModel globalContactsModel3 = globalContactsModel;
                            c.onCheckedChanged(globalContactsModel3, globalContactsModel3.checked);
                            if (SplitFareContactsAdapter.this.f17844i) {
                                SplitFareContactsAdapter.this.f17842e.onSearchContactsClick(globalContactsModel.checked);
                                boolean unused = SplitFareContactsAdapter.this.f17844i = false;
                            }
                        }
                    }
                };
                if (globalContactsModel.type == 1) {
                    this.mCancel.setVisibility(8);
                    this.mContactSelectBtn.setVisibility(0);
                    this.itemView.setOnClickListener(r0);
                    this.mCancel.setOnClickListener((View.OnClickListener) null);
                }
                if (globalContactsModel.type == 2) {
                    this.mContactSelectBtn.setVisibility(8);
                    this.mCancel.setVisibility(0);
                    this.mCancel.setOnClickListener(r0);
                    this.itemView.setOnClickListener((View.OnClickListener) null);
                }
                updateViewByCheckStatus(globalContactsModel.checked);
                if (globalContactsModel.type == 2) {
                    this.mHeader.setVisibility(0);
                } else {
                    this.mHeader.setVisibility(8);
                }
                if (!globalContactsModel.canSelected) {
                    this.mContactSelectBtn.setEnabled(false);
                    this.itemView.setOnClickListener((View.OnClickListener) null);
                    return;
                }
                this.mContactSelectBtn.setEnabled(true);
            }
        }

        /* access modifiers changed from: private */
        public void updateViewByCheckStatus(boolean z) {
            if (z) {
                this.mContactName.setTextColor(DidiThemeManager.getIns().getResPicker(DIDIApplicationDelegate.getAppContext()).getColor(R.attr.caution_color));
                this.mContactSelectBtn.setChecked(true);
                this.mContactSelectBtn.setEnabled(true);
                this.mContactSelectBtn.setClickable(false);
                return;
            }
            this.mContactName.setTextColor(DIDIApplicationDelegate.getAppContext().getResources().getColor(R.color.g_color_333333));
            this.mContactSelectBtn.setChecked(false);
            this.mContactSelectBtn.setClickable(false);
            this.mContactSelectBtn.setEnabled(false);
        }
    }

    public class GlobalContactTipsVH extends GlobalBaseVH {
        private ImageView mCloseIv = ((ImageView) this.itemView.findViewById(R.id.g_split_fare_guide_close));
        private TextView mTipsTv = ((TextView) this.itemView.findViewById(R.id.g_split_fare_guide_tv));

        public GlobalContactTipsVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_contacts_tips_item, viewGroup, false));
        }

        public void setData(final GlobalContactsModel globalContactsModel) {
            if (globalContactsModel != null) {
                this.mTipsTv.setText(globalContactsModel.name);
            }
            this.mCloseIv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SplitFareContactsAdapter.this.deleteTipsData(globalContactsModel);
                }
            });
        }
    }

    public class GlobalSortHeaderVH extends GlobalBaseVH {
        private TextView keyTv = ((TextView) this.itemView.findViewById(R.id.g_key_tv));

        public GlobalSortHeaderVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_contacts_sort_key_item, viewGroup, false));
        }

        public void setData(GlobalContactsModel globalContactsModel) {
            if (globalContactsModel != null) {
                this.keyTv.setText(globalContactsModel.name);
            }
        }
    }
}
