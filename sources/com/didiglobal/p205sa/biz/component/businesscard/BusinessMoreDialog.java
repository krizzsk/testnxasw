package com.didiglobal.p205sa.biz.component.businesscard;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.didiglobal.p205sa.biz.component.businesscard.view.DialogAdapter;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.BusinessMoreDialog */
public class BusinessMoreDialog extends BottomSheetDialogFragment {

    /* renamed from: a */
    BusinessCardModel f53341a;

    /* renamed from: b */
    int f53342b;

    /* renamed from: c */
    private TextView f53343c;

    /* renamed from: d */
    private RecyclerView f53344d;

    /* renamed from: e */
    private DialogAdapter f53345e;

    /* renamed from: f */
    private BottomSheetBehavior f53346f;

    /* renamed from: g */
    private long f53347g = 0;

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme);
    }

    public BusinessMoreDialog(BusinessCardModel businessCardModel) {
        this.f53341a = businessCardModel;
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.f53343c = (TextView) view.findViewById(R.id.tv_title);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_business);
        this.f53344d = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        DialogAdapter dialogAdapter = new DialogAdapter();
        this.f53345e = dialogAdapter;
        this.f53344d.setAdapter(dialogAdapter);
        this.f53345e.setOnItemClickListener(new DialogAdapter.OnItemClickListener() {
            public void onItemClick(int i, BusinessCardModel.BusinessMenuModel businessMenuModel) {
                BusinessMoreDialog.this.m39891a(businessMenuModel);
                Bundle bundle = new Bundle();
                bundle.putString("action_type", "diamond");
                HashMap hashMap = new HashMap();
                hashMap.put(ParamKeys.PARAM_COMPLAIN_ENTRY, "sa");
                hashMap.put("entry_2", "sa_businesscard");
                bundle.putSerializable("sa_entry", hashMap);
                SaBusinessManager.Companion.getIns().switchBusiness(businessMenuModel.groupType, businessMenuModel.schema, bundle);
                BusinessMoreDialog.this.dismiss();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BusinessMoreDialog.this.dismiss();
            }
        });
        this.f53342b = (UiUtils.INSTANCE.getScreenHeight((Context) DIDIApplication.getAppContext()) - UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 20.0f)) - UiUtils.INSTANCE.getStatusBarHeight(DIDIApplication.getAppContext());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f53342b));
        m39892a(this.f53341a);
    }

    /* renamed from: a */
    private void m39892a(BusinessCardModel businessCardModel) {
        if (businessCardModel != null) {
            if (businessCardModel.config != null) {
                businessCardModel.config.title.bindTextView(this.f53343c);
            }
            this.f53345e.setData(businessCardModel.businessMenu);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        View inflate = View.inflate(getContext(), R.layout.business_more_dialog, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.BottomSheet);
        }
        initView(inflate);
        this.f53346f = BottomSheetBehavior.from((View) inflate.getParent());
        return bottomSheetDialog;
    }

    public void onStart() {
        super.onStart();
        this.f53346f.setPeekHeight(this.f53342b);
        this.f53346f.setState(3);
        this.f53347g = System.currentTimeMillis();
    }

    public void onStop() {
        super.onStop();
        addTrack();
    }

    public void addTrack() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put(RavenKey.VERSION, "showtime");
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f53347g));
        hashMap.put(ParamConst.PARAM_MODULE_ID, ComponentType.COMPONENT_BUSINESS_CARD);
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_businesscard_pullup_time_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39891a(BusinessCardModel.BusinessMenuModel businessMenuModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("tag", "sa_pullup");
        hashMap.put(ParamConst.PARAM_MODULE_ID, ComponentType.COMPONENT_BUSINESS_CARD);
        hashMap.put("size", Integer.valueOf(businessMenuModel.style));
        try {
            HashMap hashMap2 = (HashMap) new Gson().fromJson((JsonElement) businessMenuModel.log_data, new TypeToken<HashMap<String, Object>>() {
            }.getType());
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_icons_ck", (Map<String, Object>) hashMap);
    }
}
