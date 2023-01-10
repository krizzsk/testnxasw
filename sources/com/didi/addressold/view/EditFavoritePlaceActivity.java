package com.didi.addressold.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.model.SugMapConstants;
import com.didi.address.model.SugParams;
import com.didi.addressold.presenter.CommonAddressPresenter;
import com.didi.addressold.util.ViewUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EditFavoritePlaceActivity extends BaseActivity implements ICommonAddressView {
    public static final String BUNDLE_RPC_COMMON_POI = "bundle_rpc_common_poi";
    public static final String BUNDLE_RPC_COMMON_POI_LIST = "bundle_rpc_common_poi_list";
    public static final int TYPE_ADD = 0;
    public static final int TYPE_EDIT = 1;

    /* renamed from: a */
    private static final int f9732a = 101;

    /* renamed from: b */
    private int f9733b = 0;

    /* renamed from: c */
    private RpcCommonPoi f9734c = new RpcCommonPoi();

    /* renamed from: d */
    private List<RpcCommonPoi> f9735d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugParams f9736e;

    /* renamed from: f */
    private Address f9737f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditText f9738g;

    /* renamed from: h */
    private TextView f9739h;

    /* renamed from: i */
    private TextView f9740i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ImageView f9741j;

    /* renamed from: k */
    private CommonAddressPresenter f9742k;

    public void loadContentView(Bundle bundle) {
    }

    public void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
    }

    public static Intent getIntent(Context context, SugParams sugParams) {
        Intent intent = new Intent(context, EditFavoritePlaceActivity.class);
        intent.putExtra(SugMapConstants.EXTRA_ADDRESS_PARAM, sugParams);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.old_layout_edit_favorite_place);
        setToolbarVisibility(0);
        setTitle(getString(R.string.global_edit_favorite_place_title_save));
        this.f9738g = (EditText) findViewById(R.id.edit_name);
        this.f9739h = (TextView) findViewById(R.id.edit_address);
        TextView textView = (TextView) findViewById(R.id.save_button);
        this.f9740i = textView;
        textView.setEnabled(false);
        this.f9741j = (ImageView) findViewById(R.id.edit_name_clear_button);
        m8472a();
        m8475c();
        this.f9738g.postDelayed(new Runnable() {
            public void run() {
                EditFavoritePlaceActivity editFavoritePlaceActivity = EditFavoritePlaceActivity.this;
                ViewUtils.showInputMethodForEditText(editFavoritePlaceActivity, editFavoritePlaceActivity.f9738g);
            }
        }, 100);
    }

    /* renamed from: a */
    private void m8472a() {
        this.f9739h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SugParams clone = EditFavoritePlaceActivity.this.f9736e.clone();
                clone.addressParam.addressType = 5;
                clone.fromType = FromType.SETTING;
                EditFavoritePlaceActivity editFavoritePlaceActivity = EditFavoritePlaceActivity.this;
                editFavoritePlaceActivity.startActivityForResult(SugContainerActivity.getIntent(editFavoritePlaceActivity, clone), 101);
            }
        });
        this.f9739h.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EditFavoritePlaceActivity.this.m8474b();
            }
        });
        this.f9738g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EditFavoritePlaceActivity.this.m8474b();
                if (editable.length() == 0) {
                    EditFavoritePlaceActivity.this.f9741j.setVisibility(8);
                } else {
                    EditFavoritePlaceActivity.this.f9741j.setVisibility(0);
                }
            }
        });
        this.f9741j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EditFavoritePlaceActivity.this.f9738g.setText("");
            }
        });
        this.f9740i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EditFavoritePlaceActivity.this.m8478d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8474b() {
        if (this.f9738g.getText().length() == 0 || this.f9739h.getText().length() == 0 || getString(R.string.global_edit_favorite_place_address_edit_hint).equals(this.f9739h.getText().toString())) {
            this.f9740i.setEnabled(false);
        } else {
            this.f9740i.setEnabled(true);
        }
    }

    /* renamed from: c */
    private void m8475c() {
        this.f9742k = new CommonAddressPresenter(this, this);
        if (getIntent().hasExtra(BUNDLE_RPC_COMMON_POI_LIST)) {
            this.f9735d = (List) getIntent().getSerializableExtra(BUNDLE_RPC_COMMON_POI_LIST);
        }
        if (!getIntent().hasExtra(BUNDLE_RPC_COMMON_POI) || !(getIntent().getSerializableExtra(BUNDLE_RPC_COMMON_POI) instanceof RpcCommonPoi)) {
            this.f9733b = 0;
        } else {
            this.f9733b = 1;
            RpcCommonPoi rpcCommonPoi = (RpcCommonPoi) getIntent().getSerializableExtra(BUNDLE_RPC_COMMON_POI);
            this.f9734c = rpcCommonPoi;
            this.f9738g.setText(rpcCommonPoi.aliasName);
            this.f9739h.setText(this.f9734c.address);
            this.f9739h.setTextColor(getResources().getColor(R.color.black));
        }
        if (getIntent().hasExtra(SugMapConstants.EXTRA_ADDRESS_PARAM) && (getIntent().getSerializableExtra(SugMapConstants.EXTRA_ADDRESS_PARAM) instanceof AddressParam)) {
            this.f9736e = (SugParams) getIntent().getSerializableExtra(SugMapConstants.EXTRA_ADDRESS_PARAM);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8478d() {
        List<RpcCommonPoi> list;
        String obj = this.f9738g.getText().toString();
        boolean z = true;
        if (!obj.equals(this.f9734c.aliasName) && (list = this.f9735d) != null) {
            for (RpcCommonPoi rpcCommonPoi : list) {
                if (obj.equals(rpcCommonPoi.aliasName)) {
                    ToastHelper.showLongInfo((Context) this, getString(R.string.global_edit_favorite_place_toast_exists, new Object[]{obj}));
                    return;
                }
            }
        }
        this.f9734c.aliasName = this.f9738g.getText().toString();
        CommonAddressPresenter commonAddressPresenter = this.f9742k;
        AddressParam addressParam = this.f9736e.addressParam;
        RpcCommonPoi rpcCommonPoi2 = this.f9734c;
        if (this.f9733b != 0) {
            z = false;
        }
        commonAddressPresenter.updateFavoritePlace(addressParam, rpcCommonPoi2, z);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AddressResult addressResult;
        super.onActivityResult(i, i2, intent);
        if (intent != null && i2 == -1 && 101 == i && (addressResult = (AddressResult) intent.getSerializableExtra("result")) != null) {
            Address address = addressResult.common;
            this.f9737f = address;
            if (address != null) {
                this.f9739h.setText(address.address);
                this.f9739h.setTextColor(getResources().getColor(R.color.black));
                RpcCommonPoi rpcCommonPoi = this.f9734c;
                String str = rpcCommonPoi != null ? rpcCommonPoi.primaryId : "";
                RpcCommonPoi a = m8471a(this.f9737f, this.f9734c);
                this.f9734c = a;
                a.primaryId = str;
            }
        }
    }

    /* renamed from: a */
    private RpcCommonPoi m8471a(Address address, RpcCommonPoi rpcCommonPoi) {
        RpcCommonPoi rpcCommonPoi2 = new RpcCommonPoi();
        if (address != null) {
            rpcCommonPoi2.address = address.address;
            rpcCommonPoi2.longitude = address.longitude;
            rpcCommonPoi2.latitude = address.latitude;
            rpcCommonPoi2.displayName = address.displayName;
            rpcCommonPoi2.cityId = address.cityId;
            rpcCommonPoi2.poi_id = address.poiId;
            rpcCommonPoi2.countryID = address.countryID;
            rpcCommonPoi2.countryCode = address.countryCode;
            if (rpcCommonPoi != null) {
                rpcCommonPoi2.primaryId = rpcCommonPoi.primaryId;
                rpcCommonPoi2.aliasName = rpcCommonPoi.aliasName;
            }
        }
        return rpcCommonPoi2;
    }

    public void onHttpRequestSuccess() {
        setResult(-1);
        finish();
    }
}
