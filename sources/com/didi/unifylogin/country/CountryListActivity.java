package com.didi.unifylogin.country;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.List;

public class CountryListActivity extends FragmentActivity {
    public static final String RESULT_COUNTRY = "country";
    public static final String SEND_RESULT_2_CALLER = "sendResult2Caller";

    /* renamed from: a */
    private static final String f47378a = "CountryListActivity";

    /* renamed from: b */
    private PinnedHeaderListView f47379b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CountrySectionedAdapter f47380c;

    /* renamed from: d */
    private ImageView f47381d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public EditText f47382e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ImageView f47383f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f47384g = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        new LoginOmegaUtil("pub_ibt_passport_countrycode_sw").send();
        this.f47384g = getIntent().getBooleanExtra(SEND_RESULT_2_CALLER, false);
        if (ListenerManager.getActivityDelegate() != null) {
            ListenerManager.getActivityDelegate().onCreate(bundle, this);
            LoginLog.write("CountryListActivityonCreate: ActivityDelegate");
        } else {
            SystemUtils.hookSetRequestedOrientation(this, 7);
        }
        setTheme(LoginPreferredConfig.getThemeResInt());
        setContentView((int) R.layout.login_unify_activity_country_list);
        m35222a();
        m35224b();
        m35226c();
    }

    /* renamed from: a */
    private void m35222a() {
        this.f47380c = new CountrySectionedAdapter(CountrySortManager.getCountrySectionData((String) null), this);
        CountryManager.getIns().getCountriesFromNet(new StaticCountriesChangeListener(this.f47380c));
    }

    private static class StaticCountriesChangeListener implements CountryManager.CountriesChangeListener {
        private WeakReference<CountrySectionedAdapter> mWeakAdapter;

        public void onServerResponse(CountryListResponse countryListResponse) {
        }

        public StaticCountriesChangeListener(CountrySectionedAdapter countrySectionedAdapter) {
            this.mWeakAdapter = new WeakReference<>(countrySectionedAdapter);
        }

        public void onChange(List<CountryListResponse.CountryRule> list) {
            CountrySectionedAdapter countrySectionedAdapter;
            WeakReference<CountrySectionedAdapter> weakReference = this.mWeakAdapter;
            if (weakReference != null && (countrySectionedAdapter = (CountrySectionedAdapter) weakReference.get()) != null) {
                countrySectionedAdapter.setCountrySections(CountrySortManager.getCountrySectionData((String) null));
                countrySectionedAdapter.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: b */
    private void m35224b() {
        this.f47381d = (ImageView) findViewById(R.id.iv_back);
        this.f47382e = (EditText) findViewById(R.id.et_search);
        this.f47383f = (ImageView) findViewById(R.id.iv_clear);
        PinnedHeaderListView pinnedHeaderListView = (PinnedHeaderListView) findViewById(R.id.lv_country);
        this.f47379b = pinnedHeaderListView;
        pinnedHeaderListView.setAdapter((ListAdapter) this.f47380c);
    }

    /* renamed from: c */
    private void m35226c() {
        this.f47383f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CountryListActivity.this.f47382e.setText("");
            }
        });
        this.f47381d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CountryListActivity.this.finish();
            }
        });
        this.f47382e.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    CountryListActivity.this.f47383f.setVisibility(8);
                } else {
                    CountryListActivity.this.f47383f.setVisibility(0);
                }
                CountryListActivity.this.f47380c.setCountrySections(CountrySortManager.getCountrySectionData(editable.toString()));
                CountryListActivity.this.f47380c.notifyDataSetChanged();
            }
        });
        this.f47382e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    CountryListActivity.this.f47382e.setHint(CountryListActivity.this.getString(R.string.login_unify_search_focused_hint));
                } else {
                    CountryListActivity.this.f47382e.setHint(CountryListActivity.this.getString(R.string.login_unify_search_normal_hint));
                }
            }
        });
        this.f47379b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (!CountryListActivity.this.f47380c.isSectionHeader(i)) {
                    CountryListResponse.CountryRule countryRule = (CountryListResponse.CountryRule) CountryListActivity.this.f47380c.getItem(i);
                    if (CountryListActivity.this.f47384g) {
                        Intent intent = new Intent();
                        intent.putExtra("country", countryRule);
                        CountryListActivity.this.setResult(-1, intent);
                        CountryListResponse.CountryRule currentCountry = CountryManager.getIns().getCurrentCountry();
                        CountryManager.getIns().setCurrentCountry(countryRule);
                        CountryListActivity.this.f47380c.notifyDataSetChanged();
                        CountryManager.getIns().setCurrentCountry(currentCountry);
                    } else {
                        CountryManager.getIns().setCurrentCountry(countryRule);
                        CountryListActivity.this.f47380c.notifyDataSetChanged();
                    }
                    CountryListActivity.this.finish();
                }
            }
        });
    }
}
