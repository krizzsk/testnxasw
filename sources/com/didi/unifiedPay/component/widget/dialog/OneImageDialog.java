package com.didi.unifiedPay.component.widget.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifiedPay.component.widget.dialog.IDialog;
import com.didi.unifiedPay.util.HighlightUtil;
import com.taxis99.R;

@Deprecated
public class OneImageDialog implements IDialog {

    /* renamed from: a */
    private final int f47136a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f47137b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FragmentManager f47138c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AlertDialogFragment f47139d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f47140e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f47141f;

    public boolean cancelable() {
        return false;
    }

    private OneImageDialog(int i) {
        this.f47136a = i;
    }

    public int getId() {
        return this.f47136a;
    }

    public void show() {
        UiThreadHandler.post(new Runnable() {
            public void run() {
                if (OneImageDialog.this.f47141f) {
                    boolean unused = OneImageDialog.this.f47140e = true;
                    if (!OneImageDialog.this.f47139d.isAdded()) {
                        OneImageDialog.this.f47139d.show(OneImageDialog.this.f47138c, (String) null);
                    }
                }
            }
        });
    }

    public boolean isShowing() {
        return this.f47140e;
    }

    public void dismiss() {
        UiThreadHandler.post(new Runnable() {
            public void run() {
                OneImageDialog.this.f47139d.dismiss();
                boolean unused = OneImageDialog.this.f47140e = false;
            }
        });
    }

    public void update(DialogInfo dialogInfo) {
        m35076a((OneImageInfo) dialogInfo, this.f47139d.getView());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35076a(OneImageInfo oneImageInfo, View view) {
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.dialog_top_image);
            GlideUtils.with2load2into(this.f47137b, oneImageInfo.imageUrl, imageView);
            this.f47141f = true;
            imageView.setVisibility(0);
            if (!isShowing()) {
                show();
            }
        }
    }

    /* renamed from: a */
    private void m35072a(final ImageView imageView, final Bitmap bitmap) {
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int width = imageView.getWidth();
                if (width > 0) {
                    OneImageDialog.this.m35073a(imageView, bitmap, width);
                    imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
        imageView.setBackgroundResource(0);
        imageView.setImageBitmap(bitmap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35073a(ImageView imageView, Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i > 0 && width > 0 && height > 0) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = (int) ((((float) (i * height)) * 1.0f) / ((float) width));
            imageView.setLayoutParams(layoutParams);
        }
    }

    public static final class DialogBuilder {
        private Context mBizCtx;
        private OneImageInfo mDialogInfo;
        private FragmentManager mFragmentMgr;
        /* access modifiers changed from: private */
        public IDialog.DialogListener mListener;

        public DialogBuilder(Context context, FragmentManager fragmentManager) {
            this.mBizCtx = context;
            this.mFragmentMgr = fragmentManager;
        }

        public void setDialogInfo(OneImageInfo oneImageInfo) {
            this.mDialogInfo = oneImageInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public OneImageDialog build() {
            final OneImageDialog oneImageDialog = new OneImageDialog(this.mDialogInfo.f47134a);
            Context unused = oneImageDialog.f47137b = this.mBizCtx;
            FragmentManager unused2 = oneImageDialog.f47138c = this.mFragmentMgr;
            String string = this.mBizCtx.getString(R.string.oc_high_light_text, new Object[]{this.mDialogInfo.positiveBtnText});
            View inflate = LayoutInflater.from(this.mBizCtx).inflate(R.layout.oc_unified_pay_dialog_image_hint, (ViewGroup) null);
            AlertDialogFragment unused3 = oneImageDialog.f47139d = new AlertDialogFragment.Builder(this.mBizCtx).setContentView(inflate).setPositiveButton(HighlightUtil.highlight(string), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    DialogBuilder.this.mListener.onAction(2);
                    oneImageDialog.dismiss();
                }
            }).setNegativeButton((CharSequence) this.mDialogInfo.negativeBtnText, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    DialogBuilder.this.mListener.onAction(4);
                    oneImageDialog.dismiss();
                }
            }).setCancelable(this.mDialogInfo.f47135b).hideDiverContentLine().create();
            oneImageDialog.m35076a(this.mDialogInfo, inflate);
            return oneImageDialog;
        }
    }
}
