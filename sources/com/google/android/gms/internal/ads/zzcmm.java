package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcmm implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult zza;
    final /* synthetic */ EditText zzb;

    zzcmm(JsPromptResult jsPromptResult, EditText editText) {
        this.zza = jsPromptResult;
        this.zzb = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zza.confirm(this.zzb.getText().toString());
    }
}
