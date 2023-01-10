package com.didi.sdk.global.enterprise.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.enterprise.activity.EnterprisePaymentListActivity;
import com.didi.sdk.global.enterprise.model.bean.CompanyBean;
import com.didi.sdk.global.enterprise.model.bean.CostCenterBean;
import com.didi.sdk.global.enterprise.model.bean.ProjectBean;
import com.didi.sdk.global.enterprise.model.data.EnterpriseInfo;
import com.didi.sdk.global.enterprise.util.EnterpriseUtil;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;
import java.io.Serializable;

public class EnterprisePaymentActivity extends FragmentActivity {
    public static final String EXTRA_ENTERPRISE_INFO = "ENTERPRISE_INFO";

    /* renamed from: a */
    private static final int f38874a = 1;

    /* renamed from: b */
    private TextView f38875b;

    /* renamed from: c */
    private ImageView f38876c;

    /* renamed from: d */
    private View f38877d;

    /* renamed from: e */
    private View f38878e;

    /* renamed from: f */
    private View f38879f;

    /* renamed from: g */
    private TextView f38880g;

    /* renamed from: h */
    private TextView f38881h;

    /* renamed from: i */
    private TextView f38882i;

    /* renamed from: j */
    private EditText f38883j;

    /* renamed from: k */
    private TextView f38884k;

    /* renamed from: l */
    private TextView f38885l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public EnterpriseInfo f38886m;

    /* renamed from: n */
    private boolean f38887n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f38888o = 1;

    public static void launch(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EnterprisePaymentActivity.class), i);
    }

    public static void launch(Fragment fragment, int i) {
        fragment.startActivityForResult(new Intent(fragment.getContext(), EnterprisePaymentActivity.class), i);
    }

    public static void launch(Activity activity, int i, EnterpriseInfo enterpriseInfo) {
        Intent intent = new Intent(activity, EnterprisePaymentActivity.class);
        intent.putExtra(EXTRA_ENTERPRISE_INFO, enterpriseInfo);
        activity.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m29240a();
        super.onCreate(bundle);
        overridePendingTransition(R.anim.one_payment_in_from_right, R.anim.one_payment_out_to_left);
        setContentView((int) R.layout.one_payment_activity_enterprise_payment);
        m29243b();
        m29245c();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.one_payment_in_from_left, R.anim.one_payment_out_to_right);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            Serializable serializableExtra = intent.getSerializableExtra(EnterprisePaymentListActivity.EXTRA_RESULT);
            if (serializableExtra instanceof CompanyBean) {
                CompanyBean companyBean = (CompanyBean) serializableExtra;
                this.f38886m.setCompany(companyBean);
                if (companyBean.companyDefault != null) {
                    CostCenterBean costCenterBean = companyBean.companyDefault.costCenter;
                    if (costCenterBean != null) {
                        costCenterBean.isRequired = companyBean.costCenterRequired;
                        this.f38886m.setCostCenter(costCenterBean);
                    }
                    ProjectBean projectBean = companyBean.companyDefault.project;
                    if (projectBean != null) {
                        projectBean.isRequired = companyBean.projectRequired;
                        this.f38886m.setProject(projectBean);
                    }
                } else {
                    this.f38886m.getCostCenter().f38923id = null;
                    this.f38886m.getCostCenter().name = null;
                    this.f38886m.getProject().f38924id = null;
                    this.f38886m.getProject().name = null;
                }
                if (companyBean.comments != null) {
                    this.f38886m.setComment(companyBean.comments);
                }
            } else if (serializableExtra instanceof CostCenterBean) {
                this.f38886m.setCostCenter((CostCenterBean) serializableExtra);
                this.f38886m.getProject().f38924id = null;
                this.f38886m.getProject().name = null;
            } else if (serializableExtra instanceof ProjectBean) {
                this.f38886m.setProject((ProjectBean) serializableExtra);
            }
            m29247d();
        }
    }

    /* renamed from: a */
    private void m29240a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: b */
    private void m29243b() {
        EnterpriseInfo enterpriseInfo = EnterpriseUtil.getEnterpriseInfo();
        this.f38886m = enterpriseInfo;
        if (enterpriseInfo == null) {
            this.f38886m = (EnterpriseInfo) getIntent().getSerializableExtra(EXTRA_ENTERPRISE_INFO);
        }
        if (this.f38886m == null) {
            this.f38886m = new EnterpriseInfo();
        }
        this.f38887n = this.f38886m.isSigned();
    }

    /* renamed from: c */
    private void m29245c() {
        initTitleBar();
        this.f38877d = findViewById(R.id.layout_company);
        this.f38878e = findViewById(R.id.layout_cost_center);
        this.f38879f = findViewById(R.id.layout_project);
        this.f38880g = (TextView) findViewById(R.id.tv_company);
        this.f38881h = (TextView) findViewById(R.id.tv_cost_center);
        this.f38882i = (TextView) findViewById(R.id.tv_project);
        this.f38883j = (EditText) findViewById(R.id.et_comment);
        this.f38884k = (TextView) findViewById(R.id.tv_comment_count);
        this.f38885l = (TextView) findViewById(R.id.btn_continue);
        this.f38877d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.LaunchInfo launchInfo = new EnterprisePaymentListActivity.LaunchInfo();
                launchInfo.launchType = 1;
                launchInfo.phoneNumber = EnterprisePaymentActivity.this.f38886m.getPhone();
                launchInfo.carLevel = EnterprisePaymentActivity.this.f38886m.getCarLevel();
                launchInfo.checkedId = EnterprisePaymentActivity.this.f38886m.getCompany().f38922id;
                launchInfo.requestCode = 1;
                EnterprisePaymentListActivity.launch(EnterprisePaymentActivity.this, launchInfo);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseCompanyBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f38888o);
            }
        });
        this.f38878e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.LaunchInfo launchInfo = new EnterprisePaymentListActivity.LaunchInfo();
                launchInfo.launchType = 2;
                launchInfo.memberId = EnterprisePaymentActivity.this.f38886m.getMemberId();
                launchInfo.companyId = EnterprisePaymentActivity.this.f38886m.getCompany().f38922id;
                launchInfo.checkedId = EnterprisePaymentActivity.this.f38886m.getCostCenter().f38923id;
                launchInfo.requestCode = 1;
                EnterprisePaymentListActivity.launch(EnterprisePaymentActivity.this, launchInfo);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseCostcenterBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f38888o);
            }
        });
        this.f38879f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.LaunchInfo launchInfo = new EnterprisePaymentListActivity.LaunchInfo();
                launchInfo.launchType = 3;
                launchInfo.memberId = EnterprisePaymentActivity.this.f38886m.getMemberId();
                launchInfo.companyId = EnterprisePaymentActivity.this.f38886m.getCompany().f38922id;
                launchInfo.costCenterId = EnterprisePaymentActivity.this.f38886m.getCostCenter().f38923id;
                launchInfo.checkedId = EnterprisePaymentActivity.this.f38886m.getProject().f38924id;
                launchInfo.requestCode = 1;
                EnterprisePaymentListActivity.launch(EnterprisePaymentActivity.this, launchInfo);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseProjectBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f38888o);
            }
        });
        this.f38883j.setText(this.f38886m.getComment().comment);
        EditText editText = this.f38883j;
        editText.setSelection(editText.length());
        this.f38883j.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EnterprisePaymentActivity.this.m29247d();
            }
        });
        this.f38885l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseContinueBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f38888o);
                EnterprisePaymentActivity.this.m29251f();
            }
        });
        m29247d();
    }

    /* access modifiers changed from: protected */
    public void initTitleBar() {
        this.f38875b = (TextView) findViewById(R.id.tv_title);
        this.f38876c = (ImageView) findViewById(R.id.iv_left);
        this.f38875b.setText(R.string.one_payment_global_enterprise_title);
        this.f38876c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentActivity.this.m29249e();
            }
        });
    }

    public void onBackPressed() {
        m29249e();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29247d() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f38886m.getCompany().name);
        if (z2) {
            this.f38880g.setText(this.f38886m.getCompany().name);
            m29241a(true);
        } else {
            this.f38880g.setText(R.string.one_payment_global_enterprise_hint_company);
            m29241a(false);
            this.f38886m.getCostCenter().f38923id = null;
            this.f38886m.getCostCenter().name = null;
            this.f38886m.getProject().f38924id = null;
            this.f38886m.getProject().name = null;
        }
        boolean z3 = !TextUtils.isEmpty(this.f38886m.getCostCenter().name);
        if (z3) {
            this.f38881h.setText(this.f38886m.getCostCenter().name);
            m29244b(true);
        } else {
            this.f38881h.setText(R.string.one_payment_global_enterprise_hint_cost_center);
            m29244b(false);
            this.f38886m.getProject().f38924id = null;
            this.f38886m.getProject().name = null;
        }
        boolean z4 = !TextUtils.isEmpty(this.f38886m.getProject().name);
        if (z4) {
            this.f38882i.setText(this.f38886m.getProject().name);
        } else {
            this.f38882i.setText(R.string.one_payment_global_enterprise_hint_project);
        }
        int length = m29239a(this.f38883j.getText().toString()).length();
        int i = this.f38886m.getComment().maxSize;
        if (i > 0) {
            this.f38884k.setText(String.format("%d/%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i)}));
            this.f38884k.setVisibility(0);
            this.f38883j.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        } else {
            this.f38884k.setText("");
            this.f38884k.setVisibility(8);
        }
        if (!z2 || this.f38886m.getComment().required) {
            this.f38883j.setHint(R.string.one_payment_global_enterprise_hint_comments);
        } else {
            this.f38883j.setHint(getString(R.string.one_payment_global_enterprise_hint_comments) + getString(R.string.one_payment_global_enterprise_hint_comments_optional));
        }
        boolean z5 = !this.f38886m.getCompany().costCenterRequired || z3;
        boolean z6 = !this.f38886m.getCompany().projectRequired || z4;
        boolean z7 = !this.f38886m.getComment().required || (length >= this.f38886m.getComment().minSize && length <= this.f38886m.getComment().maxSize);
        TextView textView = this.f38885l;
        if (!z2 || !z5 || !z6 || !z7) {
            z = false;
        }
        textView.setEnabled(z);
    }

    /* renamed from: a */
    private String m29239a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceFirst("\\s++$", "");
    }

    /* renamed from: a */
    private void m29241a(boolean z) {
        this.f38878e.setClickable(z);
        this.f38881h.setTextColor(z ? -16777216 : getResources().getColor(R.color.light_gray));
    }

    /* renamed from: b */
    private void m29244b(boolean z) {
        this.f38879f.setClickable(z);
        this.f38882i.setTextColor(z ? -16777216 : getResources().getColor(R.color.light_gray));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m29249e() {
        setResult(this.f38887n ? -1 : 0);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m29251f() {
        String obj = this.f38883j.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            this.f38886m.getComment().comment = obj;
        }
        EnterpriseUtil.setEnterpriseInfo(this.f38886m);
        setResult(-1);
        finish();
    }
}
