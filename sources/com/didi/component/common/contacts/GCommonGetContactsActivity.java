package com.didi.component.common.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import com.android.didi.safetoolkit.activity.permisstion.PermissionToolsCompat;
import com.android.didi.safetoolkit.activity.permisstion.callback.IPermissionRequest;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.contacts.GCommonContactsAdapter;
import com.didi.component.common.util.CollectionUtils;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.loading.app.AbsLoadingAppCompatActivity;
import com.didi.safetoolkit.business.contacts.SimpleDividerDecoration;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GCommonGetContactsActivity extends AbsLoadingAppCompatActivity {

    /* renamed from: a */
    private static final String f13338a = "GCommonGetContactsActivity";

    /* renamed from: b */
    private static final String f13339b = "threshold";

    /* renamed from: c */
    private static final String f13340c = "getcount";

    /* renamed from: d */
    private ViewGroup f13341d;

    /* renamed from: e */
    private RecyclerView f13342e;

    /* renamed from: f */
    private EditText f13343f;

    /* renamed from: g */
    private boolean f13344g = false;

    /* renamed from: h */
    private ImageView f13345h;

    /* renamed from: i */
    private TextView f13346i;

    /* renamed from: j */
    private GCommonContactsCallback f13347j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IGCommonContactsStore f13348k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public GCommonContactsAdapter f13349l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ArrayList<GCommonContactsModel> f13350m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LEGODrawer f13351n;

    /* renamed from: o */
    private View f13352o;

    /* renamed from: p */
    private TextView f13353p;

    /* renamed from: q */
    private PermissionToolsCompat f13354q;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11180a(List<GCommonContactsModel> list) {
    }

    public View getFallbackView() {
        return null;
    }

    public static Intent getIntent(Context context, int i) {
        Intent intent = new Intent(context, GCommonGetContactsActivity.class);
        intent.putExtra(f13340c, i);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        this.f13354q = new PermissionToolsCompat(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_g_common_get_contacts);
        m11177a();
        m11182b();
        m11184c();
        m11186d();
    }

    /* renamed from: a */
    private void m11177a() {
        this.f13341d = (ViewGroup) findViewById(R.id.list_layout);
        this.f13345h = (ImageView) findViewById(R.id.title_bar_back_img);
        this.f13346i = (TextView) findViewById(R.id.title_bar_text);
        this.f13343f = (EditText) findViewById(R.id.search_et);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        this.f13342e = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f13342e.addItemDecoration(new SimpleDividerDecoration(this));
        try {
            this.f13346i.setText(getResources().getString(R.string.sf_contacts));
            this.f13343f.setHint(getResources().getString(R.string.sf_search_contacts));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f13343f.setCursorVisible(true);
        this.f13352o = findViewById(R.id.bottom_layout);
        TextView textView = (TextView) findViewById(R.id.bottom_btn);
        this.f13353p = textView;
        textView.setText(getResources().getString(R.string.GRider_Req_Join_the_UucQ));
    }

    /* renamed from: b */
    private void m11182b() {
        this.f13353p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GCommonGetContactsActivity.this.m11195i();
            }
        });
        this.f13345h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GCommonGetContactsActivity.this.finish();
            }
        });
        this.f13343f.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                GCommonGetContactsActivity.this.f13348k.getMatchList(editable.toString(), new GCommonContactsCallback() {
                    public void onFailed(String str) {
                    }

                    public void onSucceed(List<GCommonContactsModel> list) {
                        GCommonGetContactsActivity.this.f13349l.updateSystemData(list);
                    }
                });
            }
        });
    }

    /* renamed from: c */
    private void m11184c() {
        this.f13348k = GCommonContactsStore.getInstance();
        GCommonContactsAdapter gCommonContactsAdapter = new GCommonContactsAdapter();
        this.f13349l = gCommonContactsAdapter;
        this.f13342e.setAdapter(gCommonContactsAdapter);
        this.f13347j = new GCommonContactsCallback() {
            public void onSucceed(List<GCommonContactsModel> list) {
                GCommonGetContactsActivity.this.hideLoading();
                GCommonGetContactsActivity.this.m11180a(list);
                GCommonGetContactsActivity.this.f13349l.addData(list);
            }

            public void onFailed(String str) {
                GCommonGetContactsActivity.this.hideLoading();
                GCommonGetContactsActivity.this.m11180a((List<GCommonContactsModel>) null);
            }
        };
        this.f13350m = new ArrayList<>();
        this.f13349l.setListener(new GCommonContactsAdapter.GCommonCheckedChangedListener() {
            public void onCheckedChanged(GCommonContactsModel gCommonContactsModel, boolean z) {
                if (GCommonGetContactsActivity.this.m11191g() == 1) {
                    List<GCommonContactsModel> systemDatas = GCommonGetContactsActivity.this.f13349l.getSystemDatas();
                    if (!CollectionUtils.isEmpty((Collection) systemDatas)) {
                        for (int i = 0; i < systemDatas.size(); i++) {
                            GCommonContactsModel gCommonContactsModel2 = systemDatas.get(i);
                            if (gCommonContactsModel2 != null && !gCommonContactsModel2.equals(gCommonContactsModel) && gCommonContactsModel2.checked) {
                                gCommonContactsModel2.checked = false;
                                GCommonGetContactsActivity.this.f13349l.notifyItemChanged(i);
                                GCommonGetContactsActivity.this.f13350m.clear();
                            }
                        }
                    }
                }
                if (z) {
                    GCommonGetContactsActivity.this.f13350m.add(gCommonContactsModel);
                } else {
                    GCommonGetContactsActivity.this.f13350m.remove(gCommonContactsModel);
                }
                GCommonGetContactsActivity.this.m11188e();
                GCommonGetContactsActivity gCommonGetContactsActivity = GCommonGetContactsActivity.this;
                gCommonGetContactsActivity.onSelectDateChanged(gCommonGetContactsActivity.f13350m.size());
            }
        });
    }

    /* renamed from: d */
    private void m11186d() {
        final LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(ResourcesHelper.getString(this, R.string.GRider_adjustment_Privacy_Notice_ibyJ), new LEGOBtnTextAndCallback(ResourcesHelper.getString(this, R.string.GRider_adjustment_Agree_tHbn), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GCommonGetContactsActivity.this.f13351n.dismiss();
                GCommonGetContactsActivity.this.m11193h();
            }
        }));
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(ResourcesHelper.getString(this, R.string.GRider_adjustment_Refusal_SMsG), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GCommonGetContactsActivity.this.finish();
            }
        }));
        lEGODrawerModel1.setSubTitle(ResourcesHelper.getString(this, R.string.GRider_adjustment_To_facilitate_pGOr)).setIsShowCloseImg(false).setClickOutsideCanCancel(false);
        lEGODrawerModel1.setmBackPressedEnabled(false);
        UiThreadHandler.getsUiHandler().postDelayed(new Runnable() {
            public void run() {
                GCommonGetContactsActivity gCommonGetContactsActivity = GCommonGetContactsActivity.this;
                LEGODrawer unused = gCommonGetContactsActivity.f13351n = LEGOUICreator.showDrawerTemplate(gCommonGetContactsActivity, lEGODrawerModel1);
            }
        }, 1000);
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11188e() {
        ArrayList<GCommonContactsModel> arrayList = this.f13350m;
        if (arrayList != null) {
            if (arrayList.size() >= m11189f()) {
                this.f13349l.updateCheckable(false);
            } else {
                this.f13349l.updateCheckable(true);
            }
        }
    }

    /* renamed from: f */
    private int m11189f() {
        if (getIntent().getIntExtra("threshold", 0) != 0) {
            return getIntent().getIntExtra("threshold", Integer.MAX_VALUE);
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m11191g() {
        if (getIntent().getIntExtra(f13340c, 0) != 0) {
            return getIntent().getIntExtra(f13340c, 1);
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public void showNoPermissionPage(boolean z) {
        this.f13344g = z;
    }

    /* access modifiers changed from: protected */
    public void showContractList() {
        this.f13341d.setVisibility(0);
        showLoading();
        getDataList();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m11193h() {
        this.f13354q.requestPermission(new PermissionCallback() {
            public void onBeforeGranted(List<AuthorizationInfo> list, IPermissionRequest iPermissionRequest) {
                iPermissionRequest.proceed();
            }

            public void onGranted(List<AuthorizationInfo> list) {
                GCommonGetContactsActivity.this.showContractList();
            }

            public void onRefuse(List<AuthorizationInfo> list) {
                AuthorizationInfo authorizationInfo;
                if (list != null && list.size() != 0 && (authorizationInfo = list.get(0)) != null) {
                    GCommonGetContactsActivity.this.showNoPermissionPage(authorizationInfo.isDoNotAskAgain());
                }
            }
        }, Permission.READ_CONTACTS);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f13354q.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m11195i() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        ArrayList<GCommonContactsModel> arrayList = this.f13350m;
        if (arrayList != null) {
            bundle.putSerializable("list", arrayList);
        }
        intent.putExtra("data", bundle);
        setResult(-1, intent);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f13348k.clearData();
    }

    /* access modifiers changed from: protected */
    public void getDataList() {
        this.f13348k.getSystemContacts(this.f13347j);
    }

    /* access modifiers changed from: protected */
    public void onPermissionRefused(boolean z) {
        showNoPermissionPage(z);
    }

    /* access modifiers changed from: protected */
    public void onSelectDateChanged(int i) {
        if (i > 0) {
            this.f13352o.setVisibility(0);
        } else {
            this.f13352o.setVisibility(8);
        }
    }
}
