package com.didiglobal.scan.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didiglobal.scan.net.ScanNetRequest;
import com.didiglobal.scan.view.weight.ViewFinder;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\"\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020\u0019H\u0016J-\u00104\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u000107062\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u0019H\u0016J\b\u0010\u0010\u001a\u00020\u0019H\u0002J\u0012\u0010<\u001a\u00020\u00192\b\b\u0001\u0010=\u001a\u00020+H\u0002J8\u0010\u0011\u001a\u00020\u00192\u0006\u0010>\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u0001072\b\u0010@\u001a\u0004\u0018\u0001072\b\u0010A\u001a\u0004\u0018\u0001072\b\u0010B\u001a\u0004\u0018\u000107H\u0016J\b\u0010C\u001a\u00020\u0019H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, mo148868d2 = {"Lcom/didiglobal/scan/view/fragment/QrCodeScanFragment;", "Lcom/didiglobal/scan/view/fragment/BaseQrScanFragment;", "Lcom/didiglobal/scan/net/ScanNetRequest$LoadingDelegate;", "Lcom/didiglobal/scan/net/ScanNetRequest$ErrorActionDelegate;", "()V", "back", "Landroid/view/View;", "barCodeView", "Lcom/didi/zxing/barcodescanner/DecoratedBarcodeView;", "captureManager", "Lcom/didi/zxing/barcodescanner/CaptureManager;", "enterPin", "Landroid/widget/ImageView;", "handler", "Landroid/os/Handler;", "rootView", "selectPhoto", "showError", "", "stoped", "torch", "torchOn", "viewFinderView", "Lcom/didiglobal/scan/view/weight/ViewFinder;", "checkPermission", "", "successAction", "Lkotlin/Function0;", "errorAction", "getTitleBarView", "handleImage", "data", "Landroid/content/Intent;", "hideLoading", "initCapture", "initEnterPin", "initListener", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setTorchIcon", "res", "error", "title", "buttonTitle", "scheme", "actionType", "showLoading", "Companion", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
public final class QrCodeScanFragment extends BaseQrScanFragment implements ScanNetRequest.ErrorActionDelegate, ScanNetRequest.LoadingDelegate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: m */
    private static final int f53920m = 100;

    /* renamed from: n */
    private static final int f53921n = 102;

    /* renamed from: a */
    private View f53922a;

    /* renamed from: b */
    private View f53923b;

    /* renamed from: c */
    private ImageView f53924c;

    /* renamed from: d */
    private ImageView f53925d;

    /* renamed from: e */
    private View f53926e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DecoratedBarcodeView f53927f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ViewFinder f53928g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CaptureManager f53929h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f53930i = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f53931j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f53932k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f53933l;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didiglobal/scan/view/fragment/QrCodeScanFragment$Companion;", "", "()V", "REQ_PERMISSION", "", "REQ_SELECT_PHOTO", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: QrCodeScanFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        this.f53922a = layoutInflater.inflate(R.layout.layout_fragment_gloabl_scan, viewGroup, false);
        m40217c();
        m40212a();
        m40219e();
        return this.f53922a;
    }

    /* renamed from: a */
    private final void m40212a() {
        View view = this.f53923b;
        if (view != null) {
            view.setOnClickListener(new QrCodeScanFragment$initListener$1(this));
        }
        ImageView imageView = this.f53924c;
        if (imageView != null) {
            imageView.setOnClickListener(new QrCodeScanFragment$initListener$2(this));
        }
        DecoratedBarcodeView decoratedBarcodeView = this.f53927f;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setTorchListener(new QrCodeScanFragment$initListener$3(this));
        }
        View view2 = this.f53926e;
        if (view2 != null) {
            view2.setOnClickListener(new QrCodeScanFragment$initListener$4(this));
        }
        ImageView imageView2 = this.f53925d;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new QrCodeScanFragment$initListener$5(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m40215a(Function0<Unit> function0, Function0<Unit> function02) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                Intrinsics.throwNpe();
            }
            boolean z = true;
            boolean z2 = ActivityCompat.checkSelfPermission(activity, Permission.WRITE_EXTERNAL_STORAGE) == 0;
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                Intrinsics.throwNpe();
            }
            if (ActivityCompat.checkSelfPermission(activity2, Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                z = false;
            }
            if (!z2 || !z) {
                FragmentActivity activity3 = getActivity();
                if (activity3 == null) {
                    Intrinsics.throwNpe();
                }
                ActivityCompat.requestPermissions(activity3, new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE}, 100);
                return;
            }
            function0.invoke();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 100) {
                m40216b();
            } else if (i == 102) {
                String dataString = intent != null ? intent.getDataString() : null;
                if (dataString != null) {
                    if (dataString.length() > 0) {
                        m40214a(intent);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final void m40214a(Intent intent) {
        QrScanFragment parentFragment;
        Uri data = intent.getData();
        if (getContext() != null && data != null && (parentFragment = getParentFragment()) != null) {
            parentFragment.showScanFromLocal(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m40216b() {
        try {
            Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
            startActivityForResult(intent, 102);
        } catch (Exception unused) {
            ToastHelper.showShortInfo(getContext(), "Open Pick App Error");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m40213a(int i) {
        ImageView imageView = this.f53924c;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m40217c() {
        /*
            r3 = this;
            android.view.View r0 = r3.f53922a
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r2 = 2131431128(0x7f0b0ed8, float:1.8483976E38)
            android.view.View r0 = r0.findViewById(r2)
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            r3.f53923b = r0
            android.view.View r0 = r3.f53922a
            if (r0 == 0) goto L_0x001e
            r2 = 2131431132(0x7f0b0edc, float:1.8483985E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            r3.f53924c = r0
            android.view.View r0 = r3.f53922a
            if (r0 == 0) goto L_0x002f
            r2 = 2131431129(0x7f0b0ed9, float:1.8483978E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            r3.f53925d = r0
            android.view.View r0 = r3.f53922a
            if (r0 == 0) goto L_0x003e
            r2 = 2131431131(0x7f0b0edb, float:1.8483983E38)
            android.view.View r0 = r0.findViewById(r2)
            goto L_0x003f
        L_0x003e:
            r0 = r1
        L_0x003f:
            r3.f53926e = r0
            android.view.View r0 = r3.f53922a
            if (r0 == 0) goto L_0x004f
            r2 = 2131428012(0x7f0b02ac, float:1.8477656E38)
            android.view.View r0 = r0.findViewById(r2)
            com.didi.zxing.barcodescanner.DecoratedBarcodeView r0 = (com.didi.zxing.barcodescanner.DecoratedBarcodeView) r0
            goto L_0x0050
        L_0x004f:
            r0 = r1
        L_0x0050:
            r3.f53927f = r0
            android.view.View r0 = r3.f53922a
            if (r0 == 0) goto L_0x0060
            r1 = 2131436050(0x7f0b2212, float:1.849396E38)
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            com.didiglobal.scan.view.weight.ViewFinder r1 = (com.didiglobal.scan.view.weight.ViewFinder) r1
        L_0x0060:
            r3.f53928g = r1
            r3.m40218d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.scan.view.fragment.QrCodeScanFragment.m40217c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getInfoList();
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m40218d() {
        /*
            r4 = this;
            com.didiglobal.scan.data.ManualInputInfo r0 = r4.getInputInfo()
            if (r0 == 0) goto L_0x0011
            java.util.ArrayList r0 = r0.getInfoList()
            if (r0 == 0) goto L_0x0011
            boolean r0 = r0.isEmpty()
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            r1 = 8
            if (r0 == 0) goto L_0x001e
            android.widget.ImageView r0 = r4.f53925d
            if (r0 == 0) goto L_0x001d
            r0.setVisibility(r1)
        L_0x001d:
            return
        L_0x001e:
            com.didiglobal.scan.data.ManualInputInfo r0 = r4.getInputInfo()
            if (r0 == 0) goto L_0x0053
            java.util.ArrayList r0 = r0.getInfoList()
            if (r0 == 0) goto L_0x0053
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.didiglobal.scan.data.ManualInputInfoItem r0 = (com.didiglobal.scan.data.ManualInputInfoItem) r0
            if (r0 == 0) goto L_0x0053
            boolean r3 = r0.getEnableEntrance()
            if (r3 == 0) goto L_0x004c
            android.widget.ImageView r1 = r4.f53925d
            if (r1 == 0) goto L_0x0040
            r1.setVisibility(r2)
        L_0x0040:
            android.widget.ImageView r1 = r4.f53925d
            if (r1 == 0) goto L_0x0053
            int r0 = r0.getEntranceIcon()
            r1.setImageResource(r0)
            goto L_0x0053
        L_0x004c:
            android.widget.ImageView r0 = r4.f53925d
            if (r0 == 0) goto L_0x0053
            r0.setVisibility(r1)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.scan.view.fragment.QrCodeScanFragment.m40218d():void");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        CaptureManager captureManager = this.f53929h;
        if (captureManager != null) {
            captureManager.onResume();
        }
    }

    public void showError(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        UiThreadHandler.getsUiHandler().post(new QrCodeScanFragment$showError$1(this, str, str2, str3, str4, str5));
    }

    /* renamed from: e */
    private final void m40219e() {
        CaptureManager captureManager = new CaptureManager(getActivity(), this.f53927f);
        this.f53929h = captureManager;
        if (captureManager != null) {
            captureManager.decodeContinuous(new QrCodeScanFragment$initCapture$1(this));
        }
        CaptureManager captureManager2 = this.f53929h;
        if (captureManager2 != null) {
            captureManager2.addStateListener(new QrCodeScanFragment$initCapture$2(this));
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f53932k && !this.f53933l) {
            CaptureManager captureManager = this.f53929h;
            if (captureManager != null) {
                captureManager.onResume();
            }
            this.f53932k = false;
        }
    }

    public void onPause() {
        super.onPause();
        if (!this.f53932k) {
            CaptureManager captureManager = this.f53929h;
            if (captureManager != null) {
                captureManager.onPauseWhioutWait();
            }
            this.f53932k = true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CaptureManager captureManager = this.f53929h;
        if (captureManager != null) {
            captureManager.onDestroy();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        CaptureManager captureManager = this.f53929h;
        if (captureManager != null) {
            captureManager.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public View getTitleBarView() {
        return this.f53923b;
    }

    public void showLoading() {
        QrScanFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.showLoading();
        }
    }

    public void hideLoading() {
        QrScanFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.hideLoading();
        }
    }
}
