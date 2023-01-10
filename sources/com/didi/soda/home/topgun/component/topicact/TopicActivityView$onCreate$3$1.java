package com.didi.soda.home.topgun.component.topicact;

import android.view.View;
import com.didi.soda.home.topgun.component.topicact.title.ITitleLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TopicActivityView.kt */
final class TopicActivityView$onCreate$3$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ TopicActivityView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicActivityView$onCreate$3$1(TopicActivityView topicActivityView) {
        super(0);
        this.this$0 = topicActivityView;
    }

    public final Integer invoke() {
        View titleLayout;
        ITitleLayout access$getTitleLayout$p = this.this$0.f45435c;
        int i = 0;
        if (!(access$getTitleLayout$p == null || (titleLayout = access$getTitleLayout$p.getTitleLayout()) == null)) {
            i = titleLayout.getHeight();
        }
        return Integer.valueOf(i);
    }
}
