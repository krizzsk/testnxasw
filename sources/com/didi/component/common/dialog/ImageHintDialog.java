package com.didi.component.common.dialog;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.common.util.ImageFetcherUtil;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class ImageHintDialog implements IDialog {

    /* renamed from: a */
    private final int f13396a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BusinessContext f13397b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialogFragment f13398c;

    /* renamed from: d */
    private boolean f13399d;

    public boolean cancelable() {
        return false;
    }

    private ImageHintDialog(int i) {
        this.f13396a = i;
    }

    public int getId() {
        return this.f13396a;
    }

    public void show() {
        this.f13399d = true;
        this.f13397b.getNavigation().showDialog(this.f13398c);
    }

    public boolean isShowing() {
        return this.f13399d;
    }

    public void dismiss() {
        this.f13397b.getNavigation().dismissDialog(this.f13398c);
        this.f13399d = false;
    }

    public void update(DialogInfo dialogInfo) {
        m11228a((ImageHintDialogInfo) dialogInfo, this.f13398c.getView());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11228a(ImageHintDialogInfo imageHintDialogInfo, View view) {
        if (view != null) {
            final ImageView imageView = (ImageView) view.findViewById(R.id.dialog_top_image);
            if (imageHintDialogInfo.f13404e == 1) {
                imageView.setBackgroundResource(R.drawable.brazil_comp_image_holder_with_top_corners);
            } else if (imageHintDialogInfo.f13404e != -1) {
                imageView.setBackgroundResource(imageHintDialogInfo.f13404e);
            }
            ImageFetcherUtil.getInstance().fetchCallback(this.f13397b.getContext(), imageHintDialogInfo.f13400a, (ImageFetcherUtil.ImageLoadCallback) new ImageFetcherUtil.ImageLoadCallback() {
                public void onSuccess(Bitmap bitmap) {
                    if (bitmap != null) {
                        imageView.setBackgroundResource(0);
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
            ((TextView) view.findViewById(R.id.dialog_title)).setText(imageHintDialogInfo.f13401b);
            ((TextView) view.findViewById(R.id.dialog_subtitle)).setText(imageHintDialogInfo.f13402c);
        }
    }

    public static final class DialogBuilder {
        private BusinessContext mBizCtx;
        private ImageHintDialogInfo mDialogInfo;
        /* access modifiers changed from: private */
        public IDialog.DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public void setDialogInfo(ImageHintDialogInfo imageHintDialogInfo) {
            this.mDialogInfo = imageHintDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public ImageHintDialog build() {
            ImageHintDialog imageHintDialog = new ImageHintDialog(this.mDialogInfo.dialogId);
            BusinessContext unused = imageHintDialog.f13397b = this.mBizCtx;
            View inflate = LayoutInflater.from(this.mBizCtx.getContext()).inflate(R.layout.comp_dialog_image_hint, (ViewGroup) null);
            AlertDialogFragment unused2 = imageHintDialog.f13398c = new AlertDialogFragment.Builder(this.mBizCtx.getContext()).setContentView(inflate).setPositiveButton((CharSequence) this.mDialogInfo.f13403d, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    DialogBuilder.this.mListener.onAction(4);
                }
            }).setPositiveButtonDefault().setCancelable(this.mDialogInfo.cancelable).create();
            imageHintDialog.m11228a(this.mDialogInfo, inflate);
            return imageHintDialog;
        }
    }
}
