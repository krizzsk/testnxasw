package com.didi.nova.assembly.country;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AppCompatDialog;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.nova.assembly.country.inner.CountryModel;
import com.didi.nova.assembly.country.inner.CountrySectionModel;
import com.didi.nova.assembly.country.inner.CountrySectionedAdapter;
import com.didi.nova.assembly.country.inner.PinnedHeaderListView;
import com.didi.nova.assembly.country.inner.SideBar;
import com.didi.nova.assembly.serial.Dispatcher;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.nova.assembly.serial.Task;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.taxis99.R;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryListDialog extends Dialog implements TextWatcher, View.OnClickListener {

    /* renamed from: a */
    private static final String f31606a = "CountryListDialogTAG";

    /* renamed from: b */
    private static final String f31607b = "nova_assembly_country_zh_CN.json";

    /* renamed from: c */
    private static final String f31608c = "nova_assembly_country_en_US.json";

    /* renamed from: d */
    private static final String f31609d = "nova_assembly_country_es_MX.json";

    /* renamed from: e */
    private static final String f31610e = "nova_assembly_country_es_419.json";

    /* renamed from: f */
    private static final String f31611f = "nova_assembly_country_pt_BR.json";

    /* renamed from: g */
    private static final String f31612g = "nova_assembly_country_ja_JP.json";

    /* renamed from: h */
    private static final String f31613h = "zh-CN";

    /* renamed from: i */
    private static final String f31614i = "en-US";

    /* renamed from: j */
    private static final String f31615j = "es-MX";

    /* renamed from: k */
    private static final String f31616k = "es-419";

    /* renamed from: l */
    private static final String f31617l = "es-CO";

    /* renamed from: m */
    private static final String f31618m = "pt-BR";

    /* renamed from: n */
    private static final String f31619n = "ja-JP";

    /* renamed from: A */
    private ITransformAnimation f31620A;

    /* renamed from: o */
    private List<CountryModel> f31621o = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public OnCountrySelectListener f31622p;

    /* renamed from: q */
    private OnCountryCloseListener f31623q;

    /* renamed from: r */
    private SerialTaskQueue f31624r = new SerialTaskQueue();

    /* renamed from: s */
    private String f31625s;

    /* renamed from: t */
    private int f31626t;

    /* renamed from: u */
    private int f31627u;

    /* renamed from: v */
    private int f31628v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public CountrySectionedAdapter f31629w;

    /* renamed from: x */
    private EditText f31630x;

    /* renamed from: y */
    private ImageView f31631y;

    /* renamed from: z */
    private View f31632z;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public static void show(ScopeContext scopeContext, OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3) {
        show(scopeContext, onCountrySelectListener, i, str, i2, i3, (ITransformAnimation) null);
    }

    public static void show(ScopeContext scopeContext, OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3, ITransformAnimation iTransformAnimation) {
        if (scopeContext != null) {
            scopeContext.getNavigator().showDialog(new CountryListDialog(onCountrySelectListener, i, str, i2, i3, iTransformAnimation), f31606a);
            return;
        }
        throw null;
    }

    public static void show(Context context, final OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(context, R.style.CountryListDialog);
        CountryListDialog countryListDialog = new CountryListDialog(new OnCountrySelectListener() {
            public void onSelect(String str, int i) {
                OnCountrySelectListener onCountrySelectListener = onCountrySelectListener;
                if (onCountrySelectListener != null) {
                    onCountrySelectListener.onSelect(str, i);
                }
                appCompatDialog.dismiss();
            }
        }, i, str, i2, i3, (ITransformAnimation) null);
        View onCreateView = countryListDialog.onCreateView(LayoutInflater.from(context));
        countryListDialog.setCountryCloseListener(new OnCountryCloseListener() {
            public void onDismiss(CountryListDialog countryListDialog) {
                appCompatDialog.dismiss();
            }
        });
        appCompatDialog.supportRequestWindowFeature(1);
        appCompatDialog.addContentView(onCreateView, new FrameLayout.LayoutParams(-1, -1));
        Window window = appCompatDialog.getWindow();
        window.clearFlags(2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        SystemUtils.showDialog(appCompatDialog);
    }

    CountryListDialog(OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3, ITransformAnimation iTransformAnimation) {
        this.f31622p = onCountrySelectListener;
        this.f31626t = i;
        this.f31625s = str;
        this.f31627u = i2;
        this.f31628v = i3;
        this.f31620A = iTransformAnimation;
    }

    public void setCountryCloseListener(OnCountryCloseListener onCountryCloseListener) {
        this.f31623q = onCountryCloseListener;
    }

    public View onCreateView(LayoutInflater layoutInflater) {
        this.f31632z = layoutInflater.inflate(R.layout.nova_assembly_page_country_list, (ViewGroup) null);
        m24180f();
        m24182h();
        return this.f31632z;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f31632z = layoutInflater.inflate(R.layout.nova_assembly_page_country_list, viewGroup, false);
        m24180f();
        m24182h();
        return this.f31632z;
    }

    public void onDestroy() {
        EditText editText = this.f31630x;
        if (editText != null) {
            editText.removeTextChangedListener(this);
        }
    }

    public TransformAnimation getEnterAnimation() {
        ITransformAnimation iTransformAnimation = this.f31620A;
        if (iTransformAnimation != null) {
            return iTransformAnimation.getEnterAnimation();
        }
        return null;
    }

    public TransformAnimation getExitAnimation() {
        ITransformAnimation iTransformAnimation = this.f31620A;
        if (iTransformAnimation != null) {
            return iTransformAnimation.getExitAnimation();
        }
        return null;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.iv_back) {
            m24179e();
        } else if (id == R.id.iv_clear) {
            this.f31630x.setText("");
        }
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable)) {
            this.f31631y.setVisibility(8);
        } else {
            this.f31631y.setVisibility(0);
        }
        m24172a(editable.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m24179e() {
        OnCountryCloseListener onCountryCloseListener = this.f31623q;
        if (onCountryCloseListener != null) {
            onCountryCloseListener.onDismiss(this);
        } else {
            dismiss();
        }
    }

    /* renamed from: f */
    private void m24180f() {
        this.f31630x = (EditText) this.f31632z.findViewById(R.id.et_search);
        this.f31631y = (ImageView) this.f31632z.findViewById(R.id.iv_clear);
        final PinnedHeaderListView pinnedHeaderListView = (PinnedHeaderListView) this.f31632z.findViewById(R.id.lv_country);
        this.f31631y.setOnClickListener(this);
        ((ImageView) this.f31632z.findViewById(R.id.iv_back)).setOnClickListener(this);
        this.f31630x.addTextChangedListener(this);
        CountrySectionedAdapter countrySectionedAdapter = new CountrySectionedAdapter(this.f31632z.getContext());
        this.f31629w = countrySectionedAdapter;
        countrySectionedAdapter.setStyle(this.f31628v);
        this.f31632z.setOnClickListener(this);
        pinnedHeaderListView.setAdapter((ListAdapter) this.f31629w);
        pinnedHeaderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (!CountryListDialog.this.f31629w.isSectionHeader(i)) {
                    CountryModel countryModel = (CountryModel) CountryListDialog.this.f31629w.getItem(i);
                    if (CountryListDialog.this.f31622p != null) {
                        CountryListDialog.this.f31622p.onSelect(countryModel.callingCode, countryModel.countryId);
                    }
                    CountryListDialog.this.m24179e();
                }
            }
        });
        ((SideBar) this.f31632z.findViewById(R.id.sb_index)).setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            public void onTouchingLetterChanged(String str) {
                int positionForSection = CountryListDialog.this.f31629w.getPositionForSection(str.charAt(0));
                if (positionForSection >= 0) {
                    pinnedHeaderListView.setSelection(positionForSection);
                }
            }
        });
        m24181g();
    }

    /* renamed from: g */
    private void m24181g() {
        View view = this.f31632z;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), this.f31627u, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    /* renamed from: h */
    private void m24182h() {
        Dispatcher.async((Dispatcher.DispatchRunnable) new Dispatcher.DispatchRunnable() {
            private List<CountrySectionModel> countrySectionData;

            public void onWorkThread() {
                CountryListDialog.this.m24183i();
                this.countrySectionData = CountryListDialog.this.m24176c((String) null);
            }

            public void onMainThread() {
                CountryListDialog.this.m24173a(this.countrySectionData);
            }
        });
    }

    /* renamed from: a */
    private void m24172a(final String str) {
        this.f31624r.append(new Task() {
            private List<CountrySectionModel> countrySectionData;

            public void onCancel() {
            }

            public void onWorkThread() {
                this.countrySectionData = CountryListDialog.this.m24176c(str);
            }

            public void onMainThread() {
                CountryListDialog.this.m24173a(this.countrySectionData);
            }
        }, SerialTaskQueue.AppendMode.ReplaceStrict);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24173a(List<CountrySectionModel> list) {
        this.f31629w.setCountrySections(list);
        this.f31629w.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m24183i() {
        if (TextUtils.isEmpty(this.f31625s)) {
            this.f31625s = "en-US";
        }
        String str = this.f31625s;
        char c = 65535;
        switch (str.hashCode()) {
            case -1295825987:
                if (str.equals("es-419")) {
                    c = 2;
                    break;
                }
                break;
            case 96598594:
                if (str.equals("en-US")) {
                    c = 6;
                    break;
                }
                break;
            case 96746987:
                if (str.equals(f31617l)) {
                    c = 3;
                    break;
                }
                break;
            case 96747306:
                if (str.equals("es-MX")) {
                    c = 1;
                    break;
                }
                break;
            case 100828572:
                if (str.equals("ja-JP")) {
                    c = 0;
                    break;
                }
                break;
            case 106935481:
                if (str.equals("pt-BR")) {
                    c = 5;
                    break;
                }
                break;
            case 115813226:
                if (str.equals("zh-CN")) {
                    c = 4;
                    break;
                }
                break;
        }
        try {
            JSONArray jSONArray = new JSONArray(m24169a(this.f31632z.getContext(), c != 0 ? c != 1 ? (c == 2 || c == 3) ? f31610e : c != 4 ? c != 5 ? f31608c : f31611f : f31607b : f31609d : f31612g));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CountryModel countryModel = new CountryModel(jSONObject.optInt("country_id"), jSONObject.optString("name"), jSONObject.optString(ParamConst.PARAM_CALLING_CODE), jSONObject.getString("sort_key"));
                countryModel.isSelected = countryModel.countryId == this.f31626t;
                this.f31621o.add(countryModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private List<CountryModel> m24175b(String str) {
        ArrayList arrayList = new ArrayList();
        for (CountryModel next : this.f31621o) {
            if (!TextUtils.isEmpty(next.name)) {
                if (TextUtils.isEmpty(str)) {
                    arrayList.add(next);
                } else if (next.name.toUpperCase().contains(str.toUpperCase().trim())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<CountrySectionModel> m24176c(String str) {
        ArrayList arrayList = new ArrayList();
        List<CountryModel> b = m24175b(str);
        if (b != null && !b.isEmpty()) {
            Collections.sort(b, new Comparator<CountryModel>() {
                public int compare(CountryModel countryModel, CountryModel countryModel2) {
                    if (TextUtils.isEmpty(countryModel.sortKey) || TextUtils.isEmpty(countryModel2.sortKey)) {
                        return 0;
                    }
                    return countryModel.sortKey.compareTo(countryModel2.sortKey);
                }
            });
            CountrySectionModel countrySectionModel = new CountrySectionModel();
            for (CountryModel next : b) {
                if (!TextUtils.isEmpty(next.sortKey)) {
                    if (!next.sortKey.equalsIgnoreCase(countrySectionModel.sortKey)) {
                        countrySectionModel = new CountrySectionModel();
                        countrySectionModel.sortKey = next.sortKey;
                        arrayList.add(countrySectionModel);
                    }
                    countrySectionModel.countryModelList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m24169a(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            String str2 = new String(bArr, Charset.forName("UTF-8"));
            if (inputStream == null) {
                return str2;
            }
            try {
                inputStream.close();
                return str2;
            } catch (IOException e) {
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return "";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
