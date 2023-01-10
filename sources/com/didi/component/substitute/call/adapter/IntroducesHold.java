package com.didi.component.substitute.call.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/component/substitute/call/adapter/IntroducesHold;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mtv", "Landroid/widget/TextView;", "getMtv", "()Landroid/widget/TextView;", "setMtv", "(Landroid/widget/TextView;)V", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IntroducesHold.kt */
public final class IntroducesHold extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private TextView f17919a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntroducesHold(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_introduce);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_introduce)");
        this.f17919a = (TextView) findViewById;
    }

    public final TextView getMtv() {
        return this.f17919a;
    }

    public final void setMtv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f17919a = textView;
    }
}
