package com.didi.soda.security;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.rpc.entity.FacebookRiskEntity;
import com.didi.soda.customer.foundation.rpc.extra.CustomerRiskRpcManager;
import com.didi.soda.customer.foundation.rpc.extra.CustomerRiskRpcService;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.taxis99.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public class FacebookBinder extends ItemBinder<SecurityMethodModel, ViewHolder> implements FacebookCallback<LoginResult> {

    /* renamed from: a */
    private static final String f46358a = "FacebookBinder";

    /* renamed from: b */
    private CallbackManager f46359b = CallbackManager.Factory.create();

    /* renamed from: c */
    private CustomerRiskRpcService f46360c = CustomerRiskRpcManager.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WeakReference<ScopeContext> f46361d;

    /* renamed from: e */
    private WeakReference<Activity> f46362e;

    /* renamed from: f */
    private Callback f46363f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ViewHolder f46364g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View.OnClickListener f46365h;

    public interface Callback {
        void disable(int i);

        boolean hasEnable();
    }

    public FacebookBinder(ScopeContext scopeContext, Activity activity, View.OnClickListener onClickListener, Callback callback) {
        this.f46361d = new WeakReference<>(scopeContext);
        this.f46365h = onClickListener;
        this.f46362e = new WeakReference<>(activity);
        this.f46363f = callback;
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        LoginManager.getInstance().registerCallback(this.f46359b, this);
    }

    public void bind(ViewHolder viewHolder, final SecurityMethodModel securityMethodModel) {
        viewHolder.mTitle.setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.customer_selector_facebook), (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.mTitle.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_title_facebook));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FacebookBinder.this.f46365h != null) {
                    FacebookBinder.this.f46365h.onClick(view);
                }
                BillOmegaHelper.Companion.clickSecurityPage(securityMethodModel.cid, Integer.valueOf(securityMethodModel.code));
            }
        });
        m34499a(viewHolder, securityMethodModel);
    }

    public Class<SecurityMethodModel> bindDataType() {
        return SecurityMethodModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_security_item, viewGroup, false));
        this.f46364g = viewHolder;
        return viewHolder;
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        return 41057 == securityMethodModel.code;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f46359b.onActivityResult(i, i2, intent);
    }

    public void onCancel() {
        LogUtil.m32588i(f46358a, "验证取消");
        LoginManager.getInstance().logOut();
    }

    public void onError(FacebookException facebookException) {
        LogUtil.m32588i(f46358a, "验证失败" + facebookException.toString());
        m34500b();
    }

    public void onSuccess(LoginResult loginResult) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(ParamsHelper.getCommonParams());
        if (loginResult != null) {
            AccessToken accessToken = loginResult.getAccessToken();
            if (accessToken != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(accessToken.getToken());
                String str = "";
                sb.append(str);
                hashMap.put("fb_token", sb.toString());
                hashMap.put("fb_userid", accessToken.getUserId() + str);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.addAll(accessToken.getPermissions());
                hashSet.removeAll(accessToken.getDeclinedPermissions());
                for (String str2 : hashSet) {
                    str = str + str2 + ",";
                }
                if (str.lastIndexOf(",") != -1) {
                    str = str.substring(0, str.length() - 1);
                }
                hashMap.put("fb_permissions", str);
            }
            DialogUtil.showLoadingDialog((ScopeContext) this.f46361d.get(), false);
            DialogUtil.showBlockDialog((ScopeContext) this.f46361d.get());
            hashMap.put("passenger_id", LoginUtil.getUid());
            hashMap.put("platform_type", 2);
            hashMap.put("appversion", SystemUtil.getVersionName());
            this.f46360c.uploadFacebookToken(hashMap, new RpcService.Callback<String>() {
                public void onFailure(IOException iOException) {
                    iOException.printStackTrace();
                    LogUtil.m32588i(FacebookBinder.f46358a, "验证失败:" + iOException.toString());
                    FacebookBinder.this.m34500b();
                    DialogUtil.hideBlockDialog();
                    DialogUtil.hideLoadingDialog();
                }

                public void onSuccess(String str) {
                    try {
                        FacebookRiskEntity facebookRiskEntity = (FacebookRiskEntity) GsonUtil.fromJson(str, FacebookRiskEntity.class);
                        LogUtil.m32588i(FacebookBinder.f46358a, facebookRiskEntity.toString());
                        if (facebookRiskEntity.errno != 0) {
                            FacebookBinder.this.m34500b();
                        } else {
                            int i = facebookRiskEntity.status;
                            if (i == 1) {
                                if (FacebookBinder.this.f46361d.get() != null) {
                                    ((ScopeContext) FacebookBinder.this.f46361d.get()).getNavigator().finish();
                                }
                                ToastUtil.showCustomerSuccessToast((ScopeContext) FacebookBinder.this.f46361d.get(), FacebookBinder.this.f46364g.itemView.getResources().getString(R.string.customer_security_success_title));
                            } else if (i == 2) {
                                FacebookBinder.this.m34500b();
                            } else if (i == 3) {
                                FacebookBinder.this.m34498a();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        FacebookBinder.this.m34500b();
                    } catch (Throwable th) {
                        DialogUtil.hideBlockDialog();
                        DialogUtil.hideLoadingDialog();
                        throw th;
                    }
                    DialogUtil.hideBlockDialog();
                    DialogUtil.hideLoadingDialog();
                }
            });
        }
    }

    /* renamed from: a */
    private void m34499a(ViewHolder viewHolder, SecurityMethodModel securityMethodModel) {
        if (securityMethodModel.isEnable) {
            viewHolder.mCaution.setVisibility(8);
            viewHolder.mTitle.setTextColor(viewHolder.itemView.getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
            viewHolder.itemView.setEnabled(true);
            return;
        }
        viewHolder.itemView.setEnabled(false);
        viewHolder.mTitle.setTextColor(viewHolder.itemView.getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        viewHolder.mCaution.setVisibility(0);
        if (this.f46363f.hasEnable()) {
            viewHolder.mCaution.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_fail_caution_content_1));
        } else {
            viewHolder.mCaution.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_fail_caution_content_2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34498a() {
        DialogUtil.showFacebookFailAlreadyVerifyDialog(((ScopeContext) this.f46361d.get()).getNavigator());
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34500b() {
        SecurityMethodModel securityMethodModel = new SecurityMethodModel();
        securityMethodModel.isEnable = false;
        securityMethodModel.code = 41057;
        this.f46363f.disable(securityMethodModel.code);
        if (this.f46363f.hasEnable()) {
            DialogUtil.showFacebookFailSelectOtherDialog(((ScopeContext) this.f46361d.get()).getNavigator());
        } else {
            DialogUtil.showFacebookFailNotSelectDialog(((ScopeContext) this.f46361d.get()).getNavigator());
        }
    }

    public static class ViewHolder extends ItemViewHolder<SecurityMethodModel> {
        /* access modifiers changed from: private */
        public TextView mCaution = ((TextView) findViewById(R.id.customer_tv_security_method_caution));
        /* access modifiers changed from: private */
        public TextView mTitle = ((TextView) findViewById(R.id.customer_tv_security_method_title));

        public ViewHolder(View view) {
            super(view);
        }
    }
}
