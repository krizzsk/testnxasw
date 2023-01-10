package com.didi.payment.pix.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.dqr.ResultPoint;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p130ui.WBaseActivity;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.qrcode.p139vm.PixQueryQrCodeVM;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.List;

public class PixQrScanActivity extends WBaseActivity<PixQueryQrCodeVM> {
    public static ScanResultListener scanListener;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f33692a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f33693b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecoratedBarcodeView f33694c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewfinderView f33695d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Button f33696e;

    /* renamed from: f */
    private Button f33697f;

    /* renamed from: g */
    private View f33698g;

    /* renamed from: h */
    private TextView f33699h;

    /* renamed from: i */
    private LinearLayout f33700i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f33701j;
    public Runnable runnable = new Runnable() {
        public void run() {
            PixQrScanActivity.this.m25595e();
        }
    };

    public interface ScanResultListener {
        void onCancel();

        void onSuccess(String str);
    }

    public boolean registeBackstackEvent() {
        return true;
    }

    public static void start(Activity activity, ScanResultListener scanResultListener) {
        scanListener = scanResultListener;
        Intent intent = new Intent();
        intent.setClass(activity, PixQrScanActivity.class);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.pix_activity_scan);
        m25579a();
        m25588b();
        this.f32639vm = (WBaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new PixQueryQrCodeVM.Factory(getApplication())).get(PixQueryQrCodeVM.class);
        subscribeUi((PixQueryQrCodeVM) this.f32639vm);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_sw");
    }

    /* access modifiers changed from: protected */
    public void onReceivePopbackEvent() {
        finish();
    }

    public void subscribeUi(PixQueryQrCodeVM pixQueryQrCodeVM) {
        super.subscribeUi(pixQueryQrCodeVM);
        pixQueryQrCodeVM.mQuerySuccess.observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PixQrScanActivity.this.m25583a((Boolean) obj);
            }
        });
        pixQueryQrCodeVM.mErrorMessage.observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PixQrScanActivity.this.m25584a((String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m25583a(Boolean bool) {
        if (bool.booleanValue()) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m25584a(String str) {
        final GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
        globalAlertDialog.setTitle(getString(R.string.GRider_payment_Identification_failed_UAhS));
        globalAlertDialog.setMsg(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(getString(R.string.GRider_payment_Try_again_SxKx));
        arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
            public void onBtnClick(DialogFragment dialogFragment, int i) {
                globalAlertDialog.dismiss();
                PixQrScanActivity.this.f33693b.onResume();
                UiThreadHandler.postDelayed(PixQrScanActivity.this.runnable, 30000);
            }
        });
        globalAlertDialog.setButtons(arrayList);
        globalAlertDialog.setCancelable(false);
        globalAlertDialog.setListeners(arrayList2);
        globalAlertDialog.show(getSupportFragmentManager(), "showErrorDialog");
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return this.f33700i;
    }

    /* renamed from: a */
    private void m25579a() {
        this.f33694c = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.f33695d = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        this.f33696e = (Button) findViewById(R.id.torch_button);
        this.f33697f = (Button) findViewById(R.id.pix_scan_back);
        this.f33698g = findViewById(R.id.pix_scan_file);
        this.f33699h = (TextView) findViewById(R.id.pix_scan_tip);
        this.f33700i = (LinearLayout) findViewById(R.id.pix_scan_titlebar);
        this.f33697f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrScanActivity.this.m25589b(view);
            }
        });
        this.f33696e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (PixQrScanActivity.this.f33701j) {
                    PixQrScanActivity.this.f33694c.setTorchOff();
                } else {
                    PixQrScanActivity.this.f33694c.setTorchOn();
                }
            }
        });
        this.f33698g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrScanActivity.this.m25580a(view);
            }
        });
        this.f33694c.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                PixQrScanActivity.this.f33696e.setBackgroundResource(R.drawable.pix_torch_open);
                boolean unused = PixQrScanActivity.this.f33701j = true;
            }

            public void onTorchOff() {
                PixQrScanActivity.this.f33696e.setBackgroundResource(R.drawable.pix_torch_close);
                boolean unused = PixQrScanActivity.this.f33701j = false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m25589b(View view) {
        FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_back_ck");
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m25580a(View view) {
        FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_ck");
        if (PaySharedPreferencesUtil.isPixPhotoInputGuideShown(this)) {
            m25593d();
        } else {
            m25591c();
        }
    }

    /* renamed from: b */
    private void m25588b() {
        CaptureManager captureManager = new CaptureManager(this, this.f33694c);
        this.f33693b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                PixQrScanActivity.this.f33693b.onPauseWhioutWait();
                PixQrScanActivity.this.m25582a(barcodeResult);
            }
        });
        this.f33693b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                PixQrScanActivity.this.f33695d.setAnimeFlag(true);
            }

            public void previewStopped() {
                PixQrScanActivity.this.f33695d.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                PixQrScanActivity.this.f33692a.postDelayed(new Runnable() {
                    public void run() {
                        PixQrScanActivity.this.f33693b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        this.f33693b.onResume();
    }

    /* renamed from: c */
    private void m25591c() {
        final WalletDialog createDrawer = WalletDialog.createDrawer(this);
        WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
        builder.setTitle(getString(R.string.GRider_payment_Select_a_IXgF));
        builder.setContent(getString(R.string.pix_scan_select_img_content));
        builder.setFirstBtnText(getString(R.string.pix_scan_select_img_button_text));
        builder.setFirstClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                createDrawer.dismiss();
                PixQrScanActivity.this.m25593d();
            }
        });
        createDrawer.setContentView((View) builder.build(this));
        SystemUtils.showDialog(createDrawer);
        PaySharedPreferencesUtil.setPixPhotoInputGuideShown(this, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25582a(BarcodeResult barcodeResult) {
        String text = barcodeResult.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        UiThreadHandler.removeCallbacks(this.runnable);
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onSuccess(text);
        }
        ((PixQueryQrCodeVM) this.f32639vm).queryQrCode(text, "scan_qrcode");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25593d() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    PixQrScanActivity.this.startActivity(new Intent(PixQrScanActivity.this, PixPhotoInputActivity.class));
                } else if (!ActivityCompat.shouldShowRequestPermissionRationale(PixQrScanActivity.this, Permission.WRITE_EXTERNAL_STORAGE)) {
                    PixQrScanActivity pixQrScanActivity = PixQrScanActivity.this;
                    WalletToastNew.showFailedMsg(pixQrScanActivity, pixQrScanActivity.getString(R.string.pix_scan_photo_permission_tip));
                }
            }
        }, new String[]{Permission.WRITE_EXTERNAL_STORAGE}, false);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        System.out.println("scanact#onResume===");
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    PixQrScanActivity.this.f33693b.onResume();
                    UiThreadHandler.postDelayed(PixQrScanActivity.this.runnable, 30000);
                }
            }
        }, new String[]{Permission.CAMERA}, false);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        System.out.println("scanact#onPause===");
        this.f33693b.onPauseWhioutWait();
        UiThreadHandler.removeCallbacks(this.runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m25595e() {
        final GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
        globalAlertDialog.setTitle(getString(R.string.GRider_payment_Identification_failed_UAhS));
        globalAlertDialog.setMsg(getString(R.string.GRider_payment_Make_sure_bDKK));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(getString(R.string.GRider_payment_Try_again_SxKx));
        arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
            public void onBtnClick(DialogFragment dialogFragment, int i) {
                globalAlertDialog.dismiss();
                UiThreadHandler.postDelayed(PixQrScanActivity.this.runnable, 30000);
            }
        });
        globalAlertDialog.setCancelable(false);
        globalAlertDialog.setButtons(arrayList);
        globalAlertDialog.setListeners(arrayList2);
        globalAlertDialog.show(getSupportFragmentManager(), "showTimeoutDialog");
    }

    public void onBackPressed() {
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onCancel();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        scanListener = null;
        this.f33693b.onDestroy();
    }
}
