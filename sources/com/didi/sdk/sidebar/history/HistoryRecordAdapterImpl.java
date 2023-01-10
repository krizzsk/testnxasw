package com.didi.sdk.sidebar.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.sdk.sidebar.history.adapter.HistoryRecordAdapter;
import com.didi.sdk.sidebar.history.manager.HistoryManagerBuilder;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.view.DropPinnedHeaderList;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HistoryRecordAdapterImpl extends HistoryRecordAdapter implements DropPinnedHeaderList.PinnedHeaderAdapter {
    public static final int ITEM_TYPE_DATA = 0;
    public static final int ITEM_TYPE_TYPE = 1;

    /* renamed from: a */
    private Context f40008a;

    /* renamed from: b */
    private LayoutInflater f40009b;

    /* renamed from: c */
    private List<AbsHistoryOrder> f40010c;

    /* renamed from: d */
    private List<AbsHistoryOrder> f40011d;

    /* renamed from: e */
    private List<Object> f40012e = new ArrayList();

    /* renamed from: f */
    private boolean f40013f = false;

    /* renamed from: g */
    private boolean f40014g;

    /* renamed from: h */
    private String f40015h = "soda";

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void init(Context context, List<AbsHistoryOrder> list, List<AbsHistoryOrder> list2, String str) {
        this.f40008a = context;
        this.f40009b = LayoutInflater.from(context);
        this.f40015h = str;
        updateData(list, list2);
    }

    public void updateData(List<AbsHistoryOrder> list, List<AbsHistoryOrder> list2) {
        this.f40010c = list;
        this.f40011d = list2;
        this.f40012e.clear();
        int size = CollectionUtil.size((Collection<?>) list);
        int size2 = CollectionUtil.size((Collection<?>) list2);
        if (size > 0) {
            this.f40012e.add(new Object());
            this.f40012e.addAll(list);
            if (size2 > 0) {
                this.f40012e.add(new Object());
                this.f40012e.addAll(list2);
            }
        } else if (size2 > 0) {
            this.f40012e.add(new Object());
            this.f40012e.addAll(list2);
        }
    }

    public boolean isInvoiceMode() {
        return this.f40014g;
    }

    public void setInvoiceMode(boolean z) {
        this.f40014g = z;
    }

    public List<AbsHistoryOrder> getFinishedOrderList() {
        return this.f40011d;
    }

    public int getCount() {
        int size = CollectionUtil.size((Collection<?>) this.f40011d);
        int size2 = CollectionUtil.size((Collection<?>) this.f40010c);
        int i = 1;
        int i2 = size2 + size + (size > 0 ? 1 : 0);
        if (size2 <= 0) {
            i = 0;
        }
        return i2 + i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TypeViewHolder typeViewHolder;
        Object tag = view == null ? null : view.getTag();
        if (i < this.f40012e.size()) {
            if (getItemViewType(i) == 0) {
                if (tag == null || (tag instanceof TypeViewHolder)) {
                    view = HistoryManagerBuilder.getInstance().createHistoryManager(this.f40015h).getHistoryItemView(this.f40008a);
                }
                HistoryManagerBuilder.getInstance().createHistoryManager(this.f40015h).bindDateForHistoryItemView(getItem(i), view, isInvoiceMode());
            } else {
                if (!(tag instanceof TypeViewHolder) || (typeViewHolder = (TypeViewHolder) tag) == null) {
                    typeViewHolder = new TypeViewHolder();
                    view = this.f40009b.inflate(R.layout.v_history_record_group, (ViewGroup) null);
                    typeViewHolder.typeTV = (TextView) view.findViewById(R.id.status_tv);
                    view.setTag(typeViewHolder);
                }
                typeViewHolder.typeTV.setTextColor(this.f40008a.getResources().getColor(R.color.light_gray));
                if (this.f40010c.size() <= 0 || i != 0) {
                    typeViewHolder.typeTV.setText(R.string.history_record_finished_type);
                } else {
                    typeViewHolder.typeTV.setText(R.string.history_record_unfinished_type);
                }
            }
        }
        return view;
    }

    public int getItemViewType(int i) {
        if (i >= this.f40012e.size()) {
            return 0;
        }
        return (this.f40012e.get(i) instanceof AbsHistoryOrder) ^ true ? 1 : 0;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty((Collection<?>) this.f40010c) && CollectionUtil.isEmpty((Collection<?>) this.f40011d);
    }

    public AbsHistoryOrder getItem(int i) {
        if (getItemViewType(i) != 0 || i >= this.f40012e.size()) {
            return null;
        }
        return (AbsHistoryOrder) this.f40012e.get(i);
    }

    public boolean isEditMode() {
        return this.f40013f;
    }

    public void setEditMode(boolean z) {
        if (this.f40013f != z) {
            this.f40013f = z;
            notifyDataSetChanged();
        }
    }

    public int getPinnedHeaderState(int i) {
        return (this.f40010c.size() <= 0 || i != this.f40010c.size()) ? 1 : 2;
    }

    public void configurePinnedHeader(View view, int i, int i2) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.status_tv);
            if (this.f40010c.size() <= 0 || i >= this.f40010c.size() + 1) {
                textView.setText(R.string.history_record_finished_type);
                textView.setTextColor(this.f40008a.getResources().getColor(R.color.light_gray));
                return;
            }
            textView.setText(R.string.history_record_unfinished_type);
            if (DidiThemeManager.getIns() == null || DidiThemeManager.getIns().getResPicker(this.f40008a) == null) {
                textView.setTextColor(this.f40008a.getResources().getColor(R.color.light_gray));
            } else {
                textView.setTextColor(DidiThemeManager.getIns().getResPicker(this.f40008a).getColor(R.attr.caution_color));
            }
        }
    }

    public void removeItem(int i) {
        List<Object> list = this.f40012e;
        if (list != null && list.size() > i) {
            Object remove = this.f40012e.remove(i);
            if ((remove instanceof AbsHistoryOrder) && this.f40011d.contains(remove)) {
                this.f40011d.remove(remove);
                notifyDataSetChanged();
            }
        }
    }

    public int getOrderCount() {
        return this.f40010c.size() + this.f40011d.size();
    }

    public boolean isFinishOrderByPosition(int i) {
        List<Object> list = this.f40012e;
        if (list == null || list.size() <= i) {
            return false;
        }
        return this.f40011d.contains(this.f40012e.get(i));
    }

    private static class TypeViewHolder {
        TextView typeTV;

        private TypeViewHolder() {
        }
    }
}
