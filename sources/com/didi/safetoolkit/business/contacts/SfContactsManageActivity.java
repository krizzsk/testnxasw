package com.didi.safetoolkit.business.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.safetoolkit.business.contacts.viewhoder.SfContactInfoShowVH;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.controller.SfShareOptController;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.util.SfCollectionUtil;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class SfContactsManageActivity extends BaseSafeToolkitActivity {
    public static final int MAX_CONTACTS_NUM = 5;
    public static final int SF_GET_CONTACTS_REQUESTCODE = 1;
    public static final String TAG = "contact";

    /* renamed from: a */
    private SfCommonTitleBar f37044a;

    /* renamed from: b */
    private RecyclerView f37045b;

    /* renamed from: c */
    private View f37046c;

    /* renamed from: d */
    private TextView f37047d;

    /* renamed from: e */
    private TextView f37048e;

    /* renamed from: f */
    private TextView f37049f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SfContactsManageAdapter f37050g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfContactsManageStore f37051h;

    /* renamed from: i */
    private View f37052i;

    /* renamed from: j */
    private View f37053j;

    /* renamed from: k */
    private TextView f37054k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SfContactsManageModel f37055l;

    /* renamed from: m */
    private boolean f37056m = false;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_layout_act_manage_contacts;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f37044a = (SfCommonTitleBar) findViewById(R.id.sf_manage_contacts_title_bar);
        this.f37045b = (RecyclerView) findViewById(R.id.sf_added_trusted_contact_list);
        this.f37046c = findViewById(R.id.sf_trusted_contact_guide_view);
        this.f37047d = (TextView) findViewById(R.id.sf_add_trusted_contact_title);
        this.f37048e = (TextView) findViewById(R.id.sf_add_trusted_contact_intro);
        this.f37049f = (TextView) findViewById(R.id.sf_add_trusted_contact_btn);
        this.f37052i = findViewById(R.id.sf_trusted_contact_error_view);
        this.f37053j = findViewById(R.id.sf_error_try_again);
        this.f37054k = (TextView) findViewById(R.id.sf_error_again_text);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f37056m = bundle.getInt("target", 2) == 3;
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        super.initObjects();
        this.f37045b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f37045b.addItemDecoration(new SimpleDividerDecoration(this));
        this.f37051h = new SfContactsManageStore();
        SfContactsManageAdapter sfContactsManageAdapter = new SfContactsManageAdapter();
        this.f37050g = sfContactsManageAdapter;
        this.f37045b.setAdapter(sfContactsManageAdapter);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.f37044a.setTitleText(SfStringGetter.getString(R.string.sf_trusted_contacts_title));
        this.f37047d.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_loved));
        this.f37048e.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_content));
        this.f37049f.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_add));
        this.f37054k.setText(SfStringGetter.getString(R.string.sf_error_try_again));
        m27988a();
        showPDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27988a() {
        showPDialog();
        this.f37051h.getTrustedContacts(new SfContactsManageStore.Callback() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (!SfContactsManageActivity.this.isDestory()) {
                    SfContactsManageActivity.this.closePDialog();
                    SfContactsManageModel unused = SfContactsManageActivity.this.f37055l = sfContactsManageModel;
                    if (sfContactsManageModel == null || !sfContactsManageModel.isAvailable() || sfContactsManageModel.datas == null || SfCollectionUtil.isEmpty((Collection) sfContactsManageModel.datas.contacts)) {
                        SfContactsManageActivity.this.m27996d();
                        return;
                    }
                    SfContactsManageActivity.this.m27999e();
                    SfContactsManageActivity.this.f37050g.setData(sfContactsManageModel.datas.contacts);
                    SfContactsManageActivity.this.f37050g.notifyDataSetChanged();
                }
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                if (!SfContactsManageActivity.this.isDestory()) {
                    SfContactsManageModel unused = SfContactsManageActivity.this.f37055l = null;
                    SfContactsManageActivity.this.closePDialog();
                    SfContactsManageActivity.this.m27994c();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27993b() {
        this.f37052i.setVisibility(8);
        this.f37046c.setVisibility(8);
        this.f37045b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m27994c() {
        this.f37052i.setVisibility(0);
        this.f37046c.setVisibility(8);
        this.f37045b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m27996d() {
        this.f37046c.setVisibility(0);
        this.f37045b.setVisibility(8);
        this.f37052i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m27999e() {
        this.f37045b.setVisibility(0);
        this.f37046c.setVisibility(8);
        this.f37052i.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f37044a.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactsManageActivity.this.finish();
            }
        });
        this.f37049f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SfApolloUtil.isAddContactOpt()) {
                    SafeToolKit.getIns().startContactsManagerOptPage(SfContactsManageActivity.this, 1, 5);
                } else {
                    SafeToolKit.getIns().startGetContactsPage(SfContactsManageActivity.this, 1, 5);
                }
            }
        });
        this.f37050g.setAddContactVHClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SfApolloUtil.isAddContactOpt()) {
                    SafeToolKit ins = SafeToolKit.getIns();
                    SfContactsManageActivity sfContactsManageActivity = SfContactsManageActivity.this;
                    ins.startContactsManagerOptPage(sfContactsManageActivity, 1, sfContactsManageActivity.m28000f());
                    return;
                }
                SafeToolKit ins2 = SafeToolKit.getIns();
                SfContactsManageActivity sfContactsManageActivity2 = SfContactsManageActivity.this;
                ins2.startGetContactsPage(sfContactsManageActivity2, 1, sfContactsManageActivity2.m28000f());
            }
        });
        this.f37050g.setDeleteListener(new SfContactInfoShowVH.Callback() {
            public void deleteDialogClickPerform(String str) {
                SfContactsManageActivity.this.showPDialog();
                SfContactsManageActivity.this.f37051h.deleteContact(str, new SfContactsManageStore.Callback() {
                    public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                        if (!SfContactsManageActivity.this.isDestory()) {
                            SfContactsManageActivity.this.closePDialog();
                            SfContactsManageModel unused = SfContactsManageActivity.this.f37055l = sfContactsManageModel;
                            if (sfContactsManageModel.datas != null) {
                                SfContactsManageActivity.this.m27991a("sf_delete_contacts_success");
                                if (SfCollectionUtil.isEmpty((Collection) sfContactsManageModel.datas.contacts)) {
                                    SfContactsManageActivity.this.m27996d();
                                }
                                SfContactsManageActivity.this.f37050g.setData(sfContactsManageModel.datas.contacts);
                                SfContactsManageActivity.this.f37050g.notifyDataSetChanged();
                                SfLog.m28130d("lxs delete success!");
                            }
                        }
                    }

                    public void onError(SfContactsManageModel sfContactsManageModel) {
                        SfContactsManageModel unused = SfContactsManageActivity.this.f37055l = null;
                        SfContactsManageActivity.this.closePDialog();
                        SfContactsManageActivity.this.m27991a("sf_delete_contacts_fail");
                    }
                });
            }

            public void onAddAreaCodeClick(SfContactsModel sfContactsModel) {
                if (SfContactsManageActivity.this.f37055l != null && SfContactsManageActivity.this.f37055l.datas != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(sfContactsModel);
                    SfContactsManageActivity.this.f37055l.datas.needAreaCodeContacts = arrayList;
                    SafeToolKit ins = SafeToolKit.getIns();
                    SfContactsManageActivity sfContactsManageActivity = SfContactsManageActivity.this;
                    ins.startAreaCodeAddPage(sfContactsManageActivity, 151, 2, sfContactsManageActivity.f37055l);
                    SfContactsManageModel unused = SfContactsManageActivity.this.f37055l = null;
                }
            }
        });
        this.f37053j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactsManageActivity.this.m27993b();
                SfContactsManageActivity.this.m27988a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public int m28000f() {
        int dataSize = this.f37051h.getDataSize();
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
                m27999e();
                this.f37050g.setData(arrayList);
                this.f37050g.notifyDataSetChanged();
                if (this.f37056m) {
                    new SfShareOptController().share(this);
                }
            }
        }
        return super.onActivityResult(i, i2, intent, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27991a(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }

    public View getFallbackView() {
        return this.f37044a.getLoadingFallback();
    }

    public static void startSfManageActivity(Activity activity) {
        Intent intent = new Intent(activity, SfContactsManageActivity.class);
        intent.setFlags(335544320);
        activity.startActivity(intent);
    }
}
