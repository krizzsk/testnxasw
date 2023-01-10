package com.didi.addressold.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.didi.address.FromType;
import com.didi.address.TransparentStatusBarManager;
import com.didi.address.model.SugMapConstants;
import com.didi.address.model.SugParams;
import com.didi.addressold.presenter.CommonAddressPresenter;
import com.didi.addressold.presenter.ICommonAddressPresenter;
import com.didi.addressold.util.AddressConvertUtil;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.util.FireBaseEventTracker;
import com.didi.addressold.util.SavedInstance;
import com.didi.addressold.vamos.Util.VamosGlobalVariableHub;
import com.didi.addressold.view.CommonAddressItemView;
import com.didi.addressold.view.FavoritePlaceListAdapter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommonAddressActivity extends BaseActivity implements CommonAddressItemView.DragStateCallback, ICommonAddressView {
    public static final String BUNDLE_TYPE = "bundle_type";
    public static final String KEY_HAS_HOME = "key_has_home";
    public static final String KEY_HAS_WORK = "key_has_work";
    public static final String KEY_RESULT_RECEIVER = "key_result_receiver";
    public static final int RESULT_CODE = 1;
    public static final int TYPE_ALL_PLACE = 0;
    public static final int TYPE_FAVORITE_PLACE = 2;
    public static final int TYPE_HOME_AND_COMPANY = 1;

    /* renamed from: a */
    private static final int f9690a = 101;

    /* renamed from: b */
    private static final int f9691b = 102;

    /* renamed from: c */
    private static final int f9692c = 103;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f9693d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ICommonAddressPresenter f9694e = null;
    /* access modifiers changed from: private */
    @SavedInstance

    /* renamed from: f */
    public SugParams f9695f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FavoritePlaceListView f9696g;
    /* access modifiers changed from: private */
    @SavedInstance

    /* renamed from: h */
    public ArrayList<RpcCommonPoi> f9697h = new ArrayList<>();

    /* renamed from: i */
    private ResultReceiver f9698i;

    /* renamed from: j */
    private FavoritePlaceListAdapter.OnFavoritePlaceItemClickListener f9699j = new FavoritePlaceListAdapter.OnFavoritePlaceItemClickListener() {
        public void onItemClick(FavoritePlaceListAdapter.FavoritePlaceModel favoritePlaceModel, int i) {
            if (favoritePlaceModel != null) {
                SugParams clone = CommonAddressActivity.this.f9695f.clone();
                int i2 = favoritePlaceModel.type;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 3) {
                                clone.addressParam.addressType = 5;
                                clone.fromType = FromType.SETTING;
                                CommonAddressActivity commonAddressActivity = CommonAddressActivity.this;
                                commonAddressActivity.m8456a((RpcCommonPoi) null, commonAddressActivity.f9697h, clone, 103);
                                AddressTrack.trackAddNewFavPlace(CommonAddressActivity.this.f9695f.fromType);
                                FireBaseEventTracker.trackAddNewFavPlace(CommonAddressActivity.this.f9695f.fromType);
                            }
                        } else if (CommonAddressActivity.this.f9693d != 2 || !CommonUtils.isValidLocation(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(favoritePlaceModel.rpcCommonPoi)))) {
                            clone.addressParam.addressType = 4;
                            clone.fromType = FromType.SETTING;
                            CommonAddressActivity.this.m8453a(clone, 102);
                            AddressTrack.trackEditHomeOrWorkAddress(clone.addressParam.addressType, favoritePlaceModel.rpcCommonPoi);
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("result", favoritePlaceModel.rpcCommonPoi);
                            CommonAddressActivity.this.setResult(101, intent);
                            CommonAddressActivity.this.finish();
                        }
                    } else if (CommonAddressActivity.this.f9693d != 2 || !CommonUtils.isValidLocation(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(favoritePlaceModel.rpcCommonPoi)))) {
                        clone.addressParam.addressType = 3;
                        clone.fromType = FromType.SETTING;
                        CommonAddressActivity.this.m8453a(clone, 101);
                        AddressTrack.trackEditHomeOrWorkAddress(clone.addressParam.addressType, favoritePlaceModel.rpcCommonPoi);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("result", favoritePlaceModel.rpcCommonPoi);
                        CommonAddressActivity.this.setResult(101, intent2);
                        CommonAddressActivity.this.finish();
                    }
                } else if (CommonAddressActivity.this.f9693d == 2) {
                    Intent intent3 = new Intent();
                    if (favoritePlaceModel.rpcCommonPoi != null) {
                        intent3.putExtra("result", favoritePlaceModel.rpcCommonPoi);
                    }
                    AddressTrack.trackCommonClick(clone, favoritePlaceModel.rpcCommonPoi, clone.addressParam.addressType, i + 1);
                    CommonAddressActivity.this.setResult(101, intent3);
                    CommonAddressActivity.this.finish();
                    AddressTrack.trackSugFavoriteClick();
                } else {
                    clone.addressParam.addressType = 5;
                    clone.fromType = FromType.SETTING;
                    CommonAddressActivity.this.m8456a(favoritePlaceModel.rpcCommonPoi, CommonAddressActivity.this.f9697h, clone, 103);
                    AddressTrack.trackSettingsFavoriteClick();
                }
            }
        }

        public void onDeleteClick(FavoritePlaceListAdapter.FavoritePlaceModel favoritePlaceModel) {
            if (favoritePlaceModel != null && favoritePlaceModel.rpcCommonPoi != null) {
                SugParams clone = CommonAddressActivity.this.f9695f.clone();
                if (favoritePlaceModel.rpcCommonPoi.type == 4) {
                    clone.addressParam.addressType = 4;
                    CommonAddressActivity.this.f9694e.deleteCommonAddress(clone.addressParam);
                    CommonAddressActivity.this.m8452a();
                } else if (favoritePlaceModel.rpcCommonPoi.type == 3) {
                    clone.addressParam.addressType = 3;
                    CommonAddressActivity.this.f9694e.deleteCommonAddress(clone.addressParam);
                    CommonAddressActivity.this.m8452a();
                } else if (favoritePlaceModel.rpcCommonPoi.type == 5 && !TextUtils.isEmpty(favoritePlaceModel.rpcCommonPoi.primaryId)) {
                    clone.addressParam.addressType = 5;
                    CommonAddressActivity.this.f9694e.deletFavoritePlace(clone.addressParam, favoritePlaceModel.rpcCommonPoi.primaryId);
                    CommonAddressActivity.this.m8452a();
                    AddressTrack.trackFavoriteDeleteClick();
                }
            }
        }
    };

    /* renamed from: k */
    private View.OnClickListener f9700k = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CommonAddressActivity.this.m8458b();
            if (CommonAddressActivity.this.f9696g != null) {
                CommonAddressActivity.this.f9696g.showListDeleteButton(true);
            }
        }
    };

    /* renamed from: l */
    private View.OnClickListener f9701l = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CommonAddressActivity.this.m8452a();
            if (CommonAddressActivity.this.f9696g != null) {
                CommonAddressActivity.this.f9696g.showListDeleteButton(false);
            }
        }
    };

    public void onDragToExpand() {
    }

    public void onHttpRequestSuccess() {
    }

    public static Intent getIntent(Context context, SugParams sugParams) {
        Intent intent = new Intent(context, CommonAddressActivity.class);
        intent.putExtra(SugMapConstants.EXTRA_ADDRESS_PARAM, sugParams);
        return intent;
    }

    public static Intent getIntent(Context context, SugParams sugParams, ResultReceiver resultReceiver) {
        Intent intent = getIntent(context, sugParams);
        intent.putExtra(KEY_RESULT_RECEIVER, resultReceiver);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        TransparentStatusBarManager.OnStatusBarTransparentListener onStatusBarTransparentListener = TransparentStatusBarManager.getInstance().getOnStatusBarTransparentListener();
        if (onStatusBarTransparentListener != null) {
            onStatusBarTransparentListener.OnStartusBarTransparent(this);
        }
        super.onCreate(bundle);
        setContentView(R.layout.old_poi_one_address_activity_common_address);
        setToolbarVisibility(0);
        setTitle(getString(R.string.global_sug_common_address));
        Intent intent = getIntent();
        if (intent != null) {
            this.f9695f = (SugParams) intent.getSerializableExtra(SugMapConstants.EXTRA_ADDRESS_PARAM);
            int intExtra = intent.getIntExtra(BUNDLE_TYPE, 0);
            this.f9693d = intExtra;
            if (intExtra == 2) {
                setTitle(getString(R.string.global_sug_choose_address));
                VamosGlobalVariableHub.isInFavoriteLyfeCycle = true;
            }
            this.f9698i = (ResultReceiver) intent.getParcelableExtra(KEY_RESULT_RECEIVER);
        }
        m8452a();
        this.f9694e = new CommonAddressPresenter(this, this);
        FavoritePlaceListView favoritePlaceListView = (FavoritePlaceListView) findViewById(R.id.favorite_place_list_view);
        this.f9696g = favoritePlaceListView;
        favoritePlaceListView.setOnFavoritePlaceItemClickListener(this.f9699j);
        loadContentView(bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8453a(SugParams sugParams, int i) {
        startActivityForResult(SugContainerActivity.getIntent(this, sugParams), i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8456a(RpcCommonPoi rpcCommonPoi, List<RpcCommonPoi> list, SugParams sugParams, int i) {
        Intent intent = EditFavoritePlaceActivity.getIntent(this, sugParams);
        if (rpcCommonPoi != null) {
            intent.putExtra(EditFavoritePlaceActivity.BUNDLE_RPC_COMMON_POI, rpcCommonPoi);
        }
        if (list != null) {
            intent.putExtra(EditFavoritePlaceActivity.BUNDLE_RPC_COMMON_POI_LIST, (Serializable) list);
        }
        startActivityForResult(intent, i);
    }

    public void loadContentView(Bundle bundle) {
        if (bundle == null) {
            this.f9694e.getCommonAddress(this.f9695f.addressParam);
        } else {
            updateCommonAddress(this.f9697h);
        }
    }

    public void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
        this.f9697h = arrayList;
        m8452a();
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<RpcCommonPoi> it = arrayList.iterator();
            RpcCommonPoi rpcCommonPoi = null;
            RpcCommonPoi rpcCommonPoi2 = null;
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                RpcCommonPoi next = it.next();
                if (next != null && next.type == 3) {
                    next.name = getString(R.string.global_sug_home);
                    rpcCommonPoi = next;
                    z = true;
                } else if (next != null && next.type == 4) {
                    next.name = getString(R.string.global_sug_company);
                    rpcCommonPoi2 = next;
                    z2 = true;
                } else if (next != null && next.type == 5) {
                    arrayList2.add(next);
                }
            }
            if (!z) {
                arrayList.add(0, getBaseHome(this));
            } else {
                arrayList.remove(rpcCommonPoi);
                arrayList.add(0, rpcCommonPoi);
            }
            if (!z2) {
                arrayList.add(1, getBaseCompany(this));
            } else {
                arrayList.remove(rpcCommonPoi2);
                arrayList.add(1, rpcCommonPoi2);
            }
            if (this.f9698i != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(KEY_HAS_HOME, z);
                bundle.putBoolean(KEY_HAS_WORK, z2);
                this.f9698i.send(1, bundle);
            }
            this.f9696g.setFavoritePlaceItems(arrayList, this.f9693d);
        }
    }

    public void finish() {
        super.finish();
        VamosGlobalVariableHub.isInFavoriteLyfeCycle = false;
        overridePendingTransition(0, R.anim.old_poi_one_address_right_out);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (103 == i) {
            loadContentView((Bundle) null);
        } else if ((102 == i || 101 == i) && intent != null) {
            this.f9694e.getCommonAddressCache(this.f9695f.addressParam);
        }
    }

    public static RpcCommonPoi getBaseHome(Context context) {
        RpcCommonPoi rpcCommonPoi = new RpcCommonPoi();
        rpcCommonPoi.type = 3;
        rpcCommonPoi.name = context.getString(R.string.global_sug_home);
        rpcCommonPoi.displayName = context.getString(R.string.global_sug_add_home);
        return rpcCommonPoi;
    }

    public static RpcCommonPoi getBaseCompany(Context context) {
        RpcCommonPoi rpcCommonPoi = new RpcCommonPoi();
        rpcCommonPoi.type = 4;
        rpcCommonPoi.name = context.getString(R.string.global_sug_company);
        rpcCommonPoi.displayName = context.getString(R.string.global_sug_add_company);
        return rpcCommonPoi;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8452a() {
        /*
            r4 = this;
            int r0 = r4.f9693d
            r1 = 0
            r2 = 2
            if (r0 != r2) goto L_0x000a
            r4.setSingleMenu(r1, r1)
            goto L_0x0046
        L_0x000a:
            java.util.ArrayList<com.sdk.poibase.model.common.RpcCommonPoi> r0 = r4.f9697h
            if (r0 == 0) goto L_0x0043
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0043
            java.util.ArrayList<com.sdk.poibase.model.common.RpcCommonPoi> r0 = r4.f9697h
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r0.next()
            com.sdk.poibase.model.common.RpcCommonPoi r2 = (com.sdk.poibase.model.common.RpcCommonPoi) r2
            java.lang.String r3 = r2.address
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0036
            java.lang.String r2 = r2.addressDetail
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x001a
        L_0x0036:
            r0 = 2131955456(0x7f130f00, float:1.954744E38)
            java.lang.String r0 = r4.getString(r0)
            android.view.View$OnClickListener r1 = r4.f9700k
            r4.setSingleMenu(r0, r1)
            return
        L_0x0043:
            r4.setSingleMenu(r1, r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.view.CommonAddressActivity.m8452a():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8458b() {
        if (this.f9693d == 2) {
            setSingleMenu((String) null, (View.OnClickListener) null);
        } else {
            setSingleMenu(getString(R.string.global_sug_complete), this.f9701l);
        }
    }
}
