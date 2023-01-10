package com.didi.safetoolkit.business.areaCode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.areaCode.AreaCodeAddDialog;
import com.didi.safetoolkit.business.areaCode.MandatoryGuidePresenter;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfAddAreaCodeQuitBiz;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Iterator;

public class MandatoryGuideActivity extends BaseSafeToolkitActivity implements View.OnClickListener, SfGuideIView {
    public static final int MANDATORY_RESULT_CODE_FROM_SHARE_DIALOG = 220;
    public static final String SF_CONSTANT_MANAGER_KEY = "sf_constant_manager_key";

    /* renamed from: a */
    private RecyclerView f36986a;

    /* renamed from: b */
    private TextView f36987b;

    /* renamed from: c */
    private TextView f36988c;

    /* renamed from: d */
    private ImageView f36989d;

    /* renamed from: e */
    private SfContactsManageModel f36990e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MandatoryGuidePresenter f36991f;

    /* renamed from: g */
    private AreaCodeAddDialog f36992g;

    /* renamed from: h */
    private boolean f36993h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f36994i;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_mandatory_guide_activity;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f36986a = (RecyclerView) findViewById(R.id.rv_contacts_view);
        this.f36987b = (TextView) findViewById(R.id.manually_add_button);
        this.f36988c = (TextView) findViewById(R.id.auto_add_button);
        this.f36989d = (ImageView) findViewById(R.id.sf_left_btn);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f36990e = (SfContactsManageModel) bundle.getSerializable("sf_constant_manager_key");
            this.f36993h = bundle.getBoolean("param_key_open_from_share_dialog", false);
            this.f36994i = bundle.getInt("param_key_open_way_source", 0);
        }
        m27938a();
    }

    /* renamed from: a */
    private void m27938a() {
        HashMap hashMap = new HashMap();
        SfContactsManageModel sfContactsManageModel = this.f36990e;
        int i = 1;
        int i2 = 0;
        if (sfContactsManageModel != null && sfContactsManageModel.datas != null && this.f36990e.datas.contacts != null && !this.f36990e.datas.contacts.isEmpty()) {
            Iterator<SfContactsModel> it = this.f36990e.datas.contacts.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!it.next().need_areacode) {
                        i2 = 1;
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            i = 0;
        }
        hashMap.put("has_concat", Integer.valueOf(i));
        hashMap.put("has_areaCode", Integer.valueOf(i2));
        SfOmegaUtil.addEventId("gp_addAreaCode_view_sw").addKeyValue(hashMap).report();
    }

    /* access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent, boolean z) {
        if (i == 150) {
            ISfContactCallbackService iSfContactCallbackService = (ISfContactCallbackService) ServiceLoader.load(ISfContactCallbackService.class, SafeToolKit.getIns().getBusinessType()).get();
            if (iSfContactCallbackService != null) {
                iSfContactCallbackService.onNewTrustedContactAdded(i2 == 10);
            }
            setResult(220);
            finish();
        }
        return super.onActivityResult(i, i2, intent, z);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        String str;
        this.f36991f = new MandatoryGuidePresenter(this);
        if (!m27942b(this.f36990e)) {
            int i = this.f36994i;
            if (i == 1) {
                str = getResources().getString(R.string.sf_add_automatic_by_share, new Object[]{this.f36990e.datas.defaultAreaCode.code});
            } else if (i != 2) {
                str = getResources().getString(R.string.sf_add_automatic, new Object[]{this.f36990e.datas.defaultAreaCode.code});
            } else {
                str = getResources().getString(R.string.sf_add_automatic_by_stock, new Object[]{this.f36990e.datas.defaultAreaCode.code});
            }
            this.f36988c.setText(str);
            this.f36986a.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.f36986a.setAdapter(new MandatoryGuideAdapter(this, this.f36990e));
            this.f36986a.addItemDecoration(new AreaCodeDividerDecoration(getContext()));
            this.f36991f.setContactsList(this.f36990e.datas.needAreaCodeContacts);
            this.f36991f.setCode(this.f36990e.datas.defaultAreaCode.code);
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f36988c.setOnClickListener(this);
        this.f36987b.setOnClickListener(this);
        this.f36989d.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.manually_add_button) {
            m27941b();
        } else if (view.getId() == R.id.auto_add_button) {
            m27943c();
        } else {
            onBackPressedCall();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressedCall() {
        if (this.f36993h) {
            finish();
            return false;
        }
        SfAddAreaCodeQuitBiz.onAddAreaCodeQuit(this);
        return false;
    }

    /* renamed from: b */
    private void m27941b() {
        SafeToolKit.getIns().startManuallyAddPage(this, this.f36993h ? 150 : 0, this.f36994i, this.f36990e);
    }

    /* renamed from: c */
    private void m27943c() {
        if (!m27942b(this.f36990e)) {
            AreaCodeAddDialog.Builder builder = new AreaCodeAddDialog.Builder(this);
            if (this.f36992g == null) {
                builder.setContent(getString(R.string.sf_add_area_code_sec_confirm_hint, new Object[]{this.f36990e.datas.defaultAreaCode.code})).setCancelable(false).setListener(new AreaCodeAddDialog.Builder.DialogListener() {
                    public void onNegativeClick(BaseDialogFragment baseDialogFragment) {
                        SfOmegaUtil.addEventId("gp_askAddAreaCode_cancel_ck").report();
                        baseDialogFragment.dismiss();
                    }

                    public void onPositiveClick(final BaseDialogFragment baseDialogFragment) {
                        SfOmegaUtil.addEventId("gp_askAddAreaCode_confirm_ck").report();
                        MandatoryGuideActivity.this.f36991f.addAllOfThemAndShare(MandatoryGuideActivity.this.f36994i, new MandatoryGuidePresenter.Callback() {
                            public void onAddAreaSuccess() {
                                SfOmegaUtil.addEventId("gp_askAddAreaCode_success_rsp").report();
                                BaseDialogFragment baseDialogFragment = baseDialogFragment;
                                if (baseDialogFragment != null && baseDialogFragment.isShowing()) {
                                    baseDialogFragment.dismiss();
                                }
                            }
                        });
                    }
                });
                this.f36992g = builder.create();
            }
            SfOmegaUtil.addEventId("gp_askAddAreaCode_view_sw").report();
            this.f36992g.show(getSupportFragmentManager(), "");
        }
    }

    public void onAllNumberAdded() {
        if (this.f36993h) {
            ISfContactCallbackService iSfContactCallbackService = (ISfContactCallbackService) ServiceLoader.load(ISfContactCallbackService.class, SafeToolKit.getIns().getBusinessType()).get();
            if (iSfContactCallbackService != null) {
                iSfContactCallbackService.onNewTrustedContactAdded(true);
            }
        } else {
            SfAddAreaCodeQuitBiz.onAddAreaCodeQuit(this);
        }
        finish();
    }

    private static class MandatoryGuideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int CONTACTS = 2;
        private static final int HEAD = 1;
        private MandatoryGuideActivity activity;
        private SfContactsManageModel model;

        public int getItemViewType(int i) {
            return i == 0 ? 1 : 2;
        }

        public MandatoryGuideAdapter(MandatoryGuideActivity mandatoryGuideActivity, SfContactsManageModel sfContactsManageModel) {
            this.activity = mandatoryGuideActivity;
            this.model = sfContactsManageModel;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new GuideHeadVH(viewGroup);
            }
            return new SfContactInfoBaseVH4Guide(viewGroup);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String str;
            if (getItemViewType(i) == 1) {
                if (!MandatoryGuideActivity.m27942b(this.model)) {
                    int a = this.activity.f36994i;
                    if (a == 1) {
                        str = this.activity.getResources().getString(R.string.sf_add_area_code_guide_with_share, new Object[]{this.model.datas.defaultAreaCode.code});
                    } else if (a != 2) {
                        str = this.activity.getResources().getString(R.string.sf_add_area_code_guide, new Object[]{this.model.datas.defaultAreaCode.code});
                    } else {
                        str = this.activity.getResources().getString(R.string.sf_add_area_code_guide_with_stock, new Object[]{this.model.datas.defaultAreaCode.code});
                    }
                    ((GuideHeadVH) viewHolder).setData(str, this.model.datas.defaultAreaCode.tips);
                }
            } else if (!MandatoryGuideActivity.m27942b(this.model) && this.model.datas.needAreaCodeContacts.size() > 0) {
                ((SfContactInfoBaseVH4Guide) viewHolder).setData(this.model.datas.needAreaCodeContacts.get(i - 1));
            }
        }

        public int getItemCount() {
            SfContactsManageModel sfContactsManageModel = this.model;
            if (sfContactsManageModel == null || sfContactsManageModel.datas == null || this.model.datas.needAreaCodeContacts == null) {
                return 1;
            }
            return this.model.datas.needAreaCodeContacts.size() + 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m27942b(SfContactsManageModel sfContactsManageModel) {
        return sfContactsManageModel == null || sfContactsManageModel.datas == null || sfContactsManageModel.datas.needAreaCodeContacts == null || sfContactsManageModel.datas.defaultAreaCode == null;
    }

    public View getFallbackView() {
        AreaCodeAddDialog areaCodeAddDialog = this.f36992g;
        if (areaCodeAddDialog == null || areaCodeAddDialog.getLoadingView() == null) {
            return null;
        }
        return this.f36992g.getLoadingView();
    }
}
