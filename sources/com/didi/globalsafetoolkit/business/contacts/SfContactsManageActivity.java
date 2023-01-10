package com.didi.globalsafetoolkit.business.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.globalsafetoolkit.base.BaseSafeToolkitActivity;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.globalsafetoolkit.business.contacts.viewhoder.SfContactInfoShowVH;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import com.didi.globalsafetoolkit.business.share.controller.SfShareOptController;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.didi.globalsafetoolkit.util.SfCollectionUtil;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didi.globalsafetoolkit.widget.SfCommonTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class SfContactsManageActivity extends BaseSafeToolkitActivity {
    public static final int MAX_CONTACTS_NUM = 5;
    public static final int SF_GET_CONTACTS_REQUESTCODE = 1;
    public static final String TAG = "contact";

    /* renamed from: a */
    private SfCommonTitleBar f24958a;

    /* renamed from: b */
    private RecyclerView f24959b;

    /* renamed from: c */
    private View f24960c;

    /* renamed from: d */
    private TextView f24961d;

    /* renamed from: e */
    private TextView f24962e;

    /* renamed from: f */
    private TextView f24963f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SfContactsManageAdapter f24964g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfContactsManageStore f24965h;

    /* renamed from: i */
    private View f24966i;

    /* renamed from: j */
    private View f24967j;

    /* renamed from: k */
    private TextView f24968k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SfContactsManageModel f24969l;

    /* renamed from: m */
    private boolean f24970m = false;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_layout_act_manage_contacts;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f24958a = (SfCommonTitleBar) findViewById(R.id.sf_manage_contacts_title_bar);
        this.f24959b = (RecyclerView) findViewById(R.id.sf_added_trusted_contact_list);
        this.f24960c = findViewById(R.id.sf_trusted_contact_guide_view);
        this.f24961d = (TextView) findViewById(R.id.sf_add_trusted_contact_title);
        this.f24962e = (TextView) findViewById(R.id.sf_add_trusted_contact_intro);
        this.f24963f = (TextView) findViewById(R.id.sf_add_trusted_contact_btn);
        this.f24966i = findViewById(R.id.sf_trusted_contact_error_view);
        this.f24967j = findViewById(R.id.sf_error_try_again);
        this.f24968k = (TextView) findViewById(R.id.sf_error_again_text);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f24970m = bundle.getInt("target", 2) == 3;
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        super.initObjects();
        this.f24959b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f24959b.addItemDecoration(new SimpleDividerDecoration(this));
        this.f24965h = new SfContactsManageStore();
        SfContactsManageAdapter sfContactsManageAdapter = new SfContactsManageAdapter();
        this.f24964g = sfContactsManageAdapter;
        this.f24959b.setAdapter(sfContactsManageAdapter);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.f24958a.setTitleText(SfStringGetter.getString(R.string.sf_trusted_contacts_title));
        this.f24961d.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_loved));
        this.f24962e.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_content));
        this.f24963f.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_add));
        this.f24968k.setText(SfStringGetter.getString(R.string.sf_error_try_again));
        m20013a();
        showPDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20013a() {
        showPDialog();
        this.f24965h.getTrustedContacts(new SfContactsManageStore.Callback() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (!SfContactsManageActivity.this.isDestory()) {
                    SfContactsManageActivity.this.closePDialog();
                    SfContactsManageModel unused = SfContactsManageActivity.this.f24969l = sfContactsManageModel;
                    if (sfContactsManageModel == null || !sfContactsManageModel.isAvailable() || sfContactsManageModel.datas == null || SfCollectionUtil.isEmpty((Collection) sfContactsManageModel.datas.contacts)) {
                        SfContactsManageActivity.this.m20021d();
                        return;
                    }
                    SfContactsManageActivity.this.m20024e();
                    SfContactsManageActivity.this.f24964g.setData(sfContactsManageModel.datas.contacts);
                    SfContactsManageActivity.this.f24964g.notifyDataSetChanged();
                }
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                if (!SfContactsManageActivity.this.isDestory()) {
                    SfContactsManageModel unused = SfContactsManageActivity.this.f24969l = null;
                    SfContactsManageActivity.this.closePDialog();
                    SfContactsManageActivity.this.m20019c();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20018b() {
        this.f24966i.setVisibility(8);
        this.f24960c.setVisibility(8);
        this.f24959b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20019c() {
        this.f24966i.setVisibility(0);
        this.f24960c.setVisibility(8);
        this.f24959b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m20021d() {
        this.f24960c.setVisibility(0);
        this.f24959b.setVisibility(8);
        this.f24966i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m20024e() {
        this.f24959b.setVisibility(0);
        this.f24960c.setVisibility(8);
        this.f24966i.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f24958a.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactsManageActivity.this.finish();
            }
        });
        this.f24963f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SfApolloUtil.isAddContactOpt()) {
                    GlobalSafeToolKit.getIns().startContactsManagerOptPage(SfContactsManageActivity.this, 1, 5);
                } else {
                    GlobalSafeToolKit.getIns().startGetContactsPage(SfContactsManageActivity.this, 1, 5);
                }
            }
        });
        this.f24964g.setAddContactVHClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SfApolloUtil.isAddContactOpt()) {
                    GlobalSafeToolKit ins = GlobalSafeToolKit.getIns();
                    SfContactsManageActivity sfContactsManageActivity = SfContactsManageActivity.this;
                    ins.startContactsManagerOptPage(sfContactsManageActivity, 1, sfContactsManageActivity.m20025f());
                    return;
                }
                GlobalSafeToolKit ins2 = GlobalSafeToolKit.getIns();
                SfContactsManageActivity sfContactsManageActivity2 = SfContactsManageActivity.this;
                ins2.startGetContactsPage(sfContactsManageActivity2, 1, sfContactsManageActivity2.m20025f());
            }
        });
        this.f24964g.setDeleteListener(new SfContactInfoShowVH.Callback() {
            public void deleteDialogClickPerform(String str) {
                SfContactsManageActivity.this.showPDialog();
                SfContactsManageActivity.this.f24965h.deleteContact(str, new SfContactsManageStore.Callback() {
                    public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                        if (!SfContactsManageActivity.this.isDestory()) {
                            SfContactsManageActivity.this.closePDialog();
                            SfContactsManageModel unused = SfContactsManageActivity.this.f24969l = sfContactsManageModel;
                            if (sfContactsManageModel.datas != null) {
                                SfContactsManageActivity.this.m20016a("sf_delete_contacts_success");
                                if (SfCollectionUtil.isEmpty((Collection) sfContactsManageModel.datas.contacts)) {
                                    SfContactsManageActivity.this.m20021d();
                                }
                                SfContactsManageActivity.this.f24964g.setData(sfContactsManageModel.datas.contacts);
                                SfContactsManageActivity.this.f24964g.notifyDataSetChanged();
                                SfLog.m20144d("lxs delete success!");
                            }
                        }
                    }

                    public void onError(SfContactsManageModel sfContactsManageModel) {
                        SfContactsManageModel unused = SfContactsManageActivity.this.f24969l = null;
                        SfContactsManageActivity.this.closePDialog();
                        SfContactsManageActivity.this.m20016a("sf_delete_contacts_fail");
                    }
                });
            }

            public void onAddAreaCodeClick(SfContactsModel sfContactsModel) {
                if (SfContactsManageActivity.this.f24969l != null && SfContactsManageActivity.this.f24969l.datas != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(sfContactsModel);
                    SfContactsManageActivity.this.f24969l.datas.needAreaCodeContacts = arrayList;
                    GlobalSafeToolKit ins = GlobalSafeToolKit.getIns();
                    SfContactsManageActivity sfContactsManageActivity = SfContactsManageActivity.this;
                    ins.startAreaCodeAddPage(sfContactsManageActivity, 151, 2, sfContactsManageActivity.f24969l);
                    SfContactsManageModel unused = SfContactsManageActivity.this.f24969l = null;
                }
            }
        });
        this.f24967j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactsManageActivity.this.m20018b();
                SfContactsManageActivity.this.m20013a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public int m20025f() {
        int dataSize = this.f24965h.getDataSize();
        if (dataSize < 0 || dataSize > 5) {
            return 0;
        }
        return 5 - dataSize;
    }

    /* access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent, boolean z) {
        Bundle bundleExtra;
        if (i == 1 && i2 == -1) {
            if (intent == null || (bundleExtra = intent.getBundleExtra("data")) == null) {
                return false;
            }
            ArrayList arrayList = (ArrayList) bundleExtra.getSerializable("list");
            if (!SfCollectionUtil.isEmpty((Collection) arrayList)) {
                m20024e();
                this.f24964g.setData(arrayList);
                this.f24964g.notifyDataSetChanged();
                if (this.f24970m) {
                    new SfShareOptController().share(this);
                }
            }
        }
        return super.onActivityResult(i, i2, intent, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20016a(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }

    public View getFallbackView() {
        return this.f24958a.getLoadingFallback();
    }

    public static void startSfManageActivity(Activity activity) {
        Intent intent = new Intent(activity, SfContactsManageActivity.class);
        intent.setFlags(335544320);
        activity.startActivity(intent);
    }
}
