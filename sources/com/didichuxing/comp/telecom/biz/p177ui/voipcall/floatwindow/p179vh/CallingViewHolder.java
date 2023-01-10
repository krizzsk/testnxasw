package com.didichuxing.comp.telecom.biz.p177ui.voipcall.floatwindow.p179vh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/CallingViewHolder;", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/ACallFloatViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mCurCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "mRootView", "Landroid/view/View;", "bindView", "", "voipCall", "getView", "performDestroy", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.CallingViewHolder */
/* compiled from: CallingViewHolder.kt */
public final class CallingViewHolder extends ACallFloatViewHolder {

    /* renamed from: a */
    private final String f49006a = "CallingViewHolder";

    /* renamed from: b */
    private View f49007b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public VoipAudioCall f49008c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallingViewHolder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.voip_floatview_calling, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…_floatview_calling, null)");
        this.f49007b = inflate;
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.f49006a;
    }

    public View getView() {
        return this.f49007b;
    }

    public void performDestroy() {
        this.f49008c = null;
    }

    public void bindView(VoipAudioCall voipAudioCall) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipCall");
        this.f49008c = voipAudioCall;
        this.f49007b.setOnClickListener(new CallingViewHolder$bindView$1(this, voipAudioCall));
    }
}
