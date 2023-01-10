package com.didi.beatles.p101im.views;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMAudioDialog */
public class IMAudioDialog {

    /* renamed from: a */
    private ImageView f11678a;

    /* renamed from: b */
    private TextView f11679b;

    /* renamed from: c */
    private TextView f11680c;

    /* renamed from: d */
    private Activity f11681d;

    /* renamed from: e */
    private boolean f11682e;
    public Dialog mDialog;

    public IMAudioDialog(Activity activity) {
        try {
            m10057a(activity);
        } catch (Exception e) {
            Log.d("IMAudioDialog", "constructor", e);
        }
    }

    public void changeBackGroundBySound(int i) {
        try {
            m10056a(i);
        } catch (Exception e) {
            Log.d("IMAudioDialog", "changeBackGroundBySound", e);
        }
    }

    public void showResidueTime(String str) {
        try {
            m10058a(str);
        } catch (Exception e) {
            Log.d("IMAudioDialog", "showResidueTime", e);
        }
    }

    /* renamed from: a */
    private void m10057a(Activity activity) {
        this.f11681d = activity;
        Dialog dialog = new Dialog(activity, R.style.bts_SoundVolumeStyle);
        this.mDialog = dialog;
        dialog.requestWindowFeature(1);
        if (this.mDialog.getWindow() != null) {
            this.mDialog.getWindow().setFlags(1024, 1024);
        }
        this.mDialog.setContentView(R.layout.bts_im_sound_volume_dialog);
        this.mDialog.setCanceledOnTouchOutside(false);
        this.f11678a = (ImageView) this.mDialog.findViewById(R.id.tips_icon);
        this.f11679b = (TextView) this.mDialog.findViewById(R.id.tips_msg);
        this.f11680c = (TextView) this.mDialog.findViewById(R.id.tips_time);
        this.f11678a.setVisibility(0);
        this.f11680c.setVisibility(8);
    }

    public boolean show() {
        Dialog dialog = this.mDialog;
        if (dialog == null || dialog.isShowing()) {
            return false;
        }
        this.f11678a.setVisibility(0);
        this.f11680c.setVisibility(8);
        SystemUtils.showDialog(this.mDialog);
        return true;
    }

    public void dissMissAudioDialog() {
        try {
            if (this.mDialog != null) {
                this.mDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m10058a(String str) {
        ImageView imageView = this.f11678a;
        if (imageView != null && imageView.isShown()) {
            this.f11678a.setVisibility(4);
        }
        TextView textView = this.f11680c;
        if (textView != null) {
            if (!textView.isShown()) {
                this.f11680c.setVisibility(0);
            }
            this.f11680c.setText(str);
        }
    }

    public boolean isShowing() {
        Dialog dialog = this.mDialog;
        return dialog != null && dialog.isShowing();
    }

    public void setTip(boolean z) {
        if (this.mDialog != null) {
            this.f11682e = z;
            if (z) {
                this.f11678a.setImageResource(IMResource.getDrawableID(R.drawable.im_toast_garbage_bin));
                this.f11679b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_record_dialog_tip_cancel_filp));
                this.f11679b.setTextColor(IMResource.getColor(R.color.im_color_text_gray));
                return;
            }
            this.f11678a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_2));
            this.f11679b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_record_dialog_tip_cancel));
            this.f11679b.setTextColor(IMResource.getColor(R.color.im_color_text_gray));
        }
    }

    /* renamed from: a */
    private void m10056a(int i) {
        if (!this.f11682e) {
            switch (i - 1) {
                case 0:
                case 1:
                    this.f11678a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_1));
                    return;
                case 2:
                case 3:
                    this.f11678a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_2));
                    return;
                case 4:
                case 5:
                    this.f11678a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_3));
                    return;
                case 6:
                    this.f11678a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_4));
                    return;
                default:
                    return;
            }
        }
    }

    public TextView getTvVoiceRecordTip() {
        return this.f11679b;
    }
}
