package com.didi.nova.assembly.country.inner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CountrySectionedAdapter extends BaseAdapter {

    /* renamed from: a */
    private static final int f31633a = 2;

    /* renamed from: b */
    private static int f31634b = 1;

    /* renamed from: c */
    private static int f31635c;

    /* renamed from: d */
    private SparseArray<Integer> f31636d = new SparseArray<>();

    /* renamed from: e */
    private SparseArray<Integer> f31637e = new SparseArray<>();

    /* renamed from: f */
    private SparseArray<Integer> f31638f = new SparseArray<>();

    /* renamed from: g */
    private int f31639g = -1;

    /* renamed from: h */
    private int f31640h = -1;

    /* renamed from: i */
    private List<CountrySectionModel> f31641i = new ArrayList();

    /* renamed from: j */
    private Context f31642j;

    /* renamed from: k */
    private int f31643k;

    public long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public CountrySectionedAdapter(Context context) {
        this.f31642j = context;
    }

    public void setStyle(int i) {
        this.f31643k = i;
    }

    public CountrySectionedAdapter setCountrySections(List<CountrySectionModel> list) {
        this.f31641i = list;
        return this;
    }

    /* renamed from: b */
    private int m24186b(int i) {
        return this.f31641i.get(i).countryModelList.size();
    }

    /* renamed from: a */
    private View m24185a(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f31642j).inflate(R.layout.nova_assembly_item_country, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_select);
        CountrySectionModel countrySectionModel = this.f31641i.get(i);
        CountryModel countryModel = countrySectionModel.countryModelList.get(i2);
        ((TextView) view.findViewById(R.id.tv_calling_code)).setText(countryModel.callingCode);
        ((TextView) view.findViewById(R.id.tv_name)).setText(countryModel.name);
        imageView.setVisibility(4);
        if (this.f31643k <= 0) {
            this.f31643k = R.style.NovaAssemblyCountryStyleOrange;
        }
        TypedArray obtainStyledAttributes = this.f31642j.obtainStyledAttributes(this.f31643k, C11267R.styleable.CountryList);
        if (obtainStyledAttributes != null) {
            imageView.setImageResource(obtainStyledAttributes.getResourceId(0, R.drawable.nova_assembly_ic_selected_orange));
            obtainStyledAttributes.recycle();
        }
        if (countryModel.isSelected) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
        View findViewById = view.findViewById(R.id.item_divider);
        if (countrySectionModel.countryModelList.size() - 1 == i2) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo86084a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f31642j).inflate(R.layout.nova_assembly_layout_country_item_header, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.tv_name)).setText(String.valueOf(this.f31641i.get(i).sortKey).toUpperCase());
        return view;
    }

    public void notifyDataSetChanged() {
        this.f31637e.clear();
        this.f31636d.clear();
        this.f31638f.clear();
        this.f31639g = -1;
        this.f31640h = -1;
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        this.f31637e.clear();
        this.f31636d.clear();
        this.f31638f.clear();
        this.f31639g = -1;
        this.f31640h = -1;
        super.notifyDataSetInvalidated();
    }

    public final int getCount() {
        int i = this.f31639g;
        if (i >= 0) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < m24184a(); i3++) {
            i2 = i2 + m24188d(i3) + 1;
        }
        this.f31639g = i2;
        return i2;
    }

    public final Object getItem(int i) {
        return this.f31641i.get(mo86083a(i)).countryModelList.get(m24187c(i));
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return isSectionHeader(i) ? mo86084a(mo86083a(i), view, viewGroup) : m24185a(mo86083a(i), m24187c(i), view, viewGroup);
    }

    public final int getItemViewType(int i) {
        return isSectionHeader(i) ? f31634b : f31635c;
    }

    public int getPositionForSection(int i) {
        List<CountrySectionModel> list = this.f31641i;
        int i2 = -1;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            CountrySectionModel countrySectionModel = this.f31641i.get(i3);
            if (countrySectionModel.sortKey.charAt(0) == i) {
                return i2 + i3 + 1;
            }
            i2 += countrySectionModel.countryModelList.size();
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo86083a(int i) {
        Integer num = this.f31637e.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < m24184a()) {
            int d = m24188d(i2) + i3 + 1;
            if (i < i3 || i >= d) {
                i2++;
                i3 = d;
            } else {
                this.f31637e.put(i, Integer.valueOf(i2));
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: c */
    private int m24187c(int i) {
        Integer num = this.f31636d.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < m24184a()) {
            int d = m24188d(i2) + i3 + 1;
            if (i < i3 || i >= d) {
                i2++;
                i3 = d;
            } else {
                int i4 = (i - i3) - 1;
                this.f31636d.put(i, Integer.valueOf(i4));
                return i4;
            }
        }
        return 0;
    }

    public final boolean isSectionHeader(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < m24184a(); i3++) {
            if (i == i2) {
                return true;
            }
            if (i < i2) {
                return false;
            }
            i2 += m24188d(i3) + 1;
        }
        return false;
    }

    /* renamed from: d */
    private int m24188d(int i) {
        Integer num = this.f31638f.get(i);
        if (num != null) {
            return num.intValue();
        }
        int b = m24186b(i);
        this.f31638f.put(i, Integer.valueOf(b));
        return b;
    }

    /* renamed from: a */
    private int m24184a() {
        int i = this.f31640h;
        if (i >= 0) {
            return i;
        }
        int size = this.f31641i.size();
        this.f31640h = size;
        return size;
    }
}
