package com.didichuxing.dfbasesdk.act;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.PermissionUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DFPermissionActivity extends DFBaseAct {

    /* renamed from: a */
    private static final String f49138a = "permission_param";

    /* renamed from: b */
    private static final String f49139b = "not_prevent_permission";

    /* renamed from: c */
    private static final String f49140c = "dialog_title";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static IPermissionCallback f49141d = null;

    /* renamed from: e */
    private static final int f49142e = 1;

    /* renamed from: f */
    private List<String> f49143f;

    /* renamed from: g */
    private String f49144g;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
    }

    public static void start(Context context, String[] strArr, String[] strArr2, String str, IPermissionCallback iPermissionCallback) {
        if (PermissionUtils.checkPermissionsGranted(context, strArr)) {
            iPermissionCallback.onPermissionSuccess(context);
            return;
        }
        Intent intent = new Intent(context, DFPermissionActivity.class);
        intent.putExtra(f49138a, strArr);
        intent.putExtra(f49139b, strArr2);
        intent.putExtra(f49140c, str);
        intent.addFlags(268435456);
        context.startActivity(intent);
        f49141d = iPermissionCallback;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        String[] stringArrayExtra = intent.getStringArrayExtra(f49138a);
        String[] stringArrayExtra2 = intent.getStringArrayExtra(f49139b);
        this.f49144g = intent.getStringExtra(f49140c);
        this.f49143f = stringArrayExtra2 != null ? Arrays.asList(stringArrayExtra2) : new ArrayList<>();
        ActivityCompat.requestPermissions(this, stringArrayExtra, 1);
        IPermissionCallback iPermissionCallback = f49141d;
        if (iPermissionCallback != null) {
            iPermissionCallback.onEnter();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, final int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        LogUtils.m37051d("permissons===" + Arrays.toString(strArr));
        LogUtils.m37051d("grantResults===" + Arrays.toString(iArr));
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (!this.f49143f.contains(strArr[i2]) && iArr[i2] != 0) {
                    sb.append(strArr[i2]);
                    sb.append(" not granted,");
                }
            }
            final String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                LogUtils.m37051d(sb2);
                new HashMap().put("permissionsDenied", sb2);
                new AlertDialogFragment.Builder(this).setTitle(this.f49144g).setPositiveButton((CharSequence) "去设置", (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                    public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        alertDialogFragment.dismiss();
                        DFPermissionActivity.this.m36802b();
                        if (DFPermissionActivity.f49141d != null) {
                            DFPermissionActivity.f49141d.onPermissionGrantSetting(sb2, iArr);
                            IPermissionCallback unused = DFPermissionActivity.f49141d = null;
                        }
                        DFPermissionActivity.this.finish();
                    }
                }).setPositiveButtonDefault().setNegativeButton((CharSequence) "取消", (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                    public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        alertDialogFragment.dismiss();
                        if (DFPermissionActivity.f49141d != null) {
                            DFPermissionActivity.f49141d.onPermissionGrantCancel(sb2, iArr);
                            IPermissionCallback unused = DFPermissionActivity.f49141d = null;
                        }
                        DFPermissionActivity.this.finish();
                    }
                }).create().show(getSupportFragmentManager(), "");
                return;
            }
            IPermissionCallback iPermissionCallback = f49141d;
            if (iPermissionCallback != null) {
                iPermissionCallback.onPermissionSuccess(this);
                f49141d = null;
            }
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36802b() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(268435456);
            intent.setData(Uri.fromParts("package", WsgSecInfo.packageName(this), (String) null));
            startActivity(intent);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            try {
                Intent intent2 = new Intent("android.settings.SETTINGS");
                intent2.setFlags(268435456);
                startActivity(intent2);
            } catch (Exception e2) {
                LogUtils.logStackTrace(e2);
            }
        }
    }
}
