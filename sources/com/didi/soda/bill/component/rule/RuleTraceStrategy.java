package com.didi.soda.bill.component.rule;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/soda/bill/component/rule/RuleTraceStrategy;", "", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "traceBackClick", "", "traceBtnClick", "type", "", "traceClosed", "traceCreate", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RuleTraceStrategy.kt */
public class RuleTraceStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Bundle f41671a;

    public void traceBackClick() {
    }

    public void traceBtnClick(int i) {
    }

    public void traceClosed() {
    }

    public void traceCreate() {
    }

    public RuleTraceStrategy(Bundle bundle) {
        this.f41671a = bundle;
    }

    public final Bundle getBundle() {
        return this.f41671a;
    }

    public static /* synthetic */ void traceBtnClick$default(RuleTraceStrategy ruleTraceStrategy, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            ruleTraceStrategy.traceBtnClick(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: traceBtnClick");
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/bill/component/rule/RuleTraceStrategy$Companion;", "", "()V", "getStrategyByType", "Lcom/didi/soda/bill/component/rule/RuleTraceStrategy;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "pageAlias", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: RuleTraceStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RuleTraceStrategy getStrategyByType(ScopeContext scopeContext, String str) {
            Intrinsics.checkNotNullParameter(str, "pageAlias");
            Integer num = null;
            Bundle bundle = scopeContext == null ? null : scopeContext.getBundle();
            if (bundle != null) {
                num = Integer.valueOf(bundle.getInt("from"));
            }
            if (num != null && num.intValue() == 1) {
                return new BusinessRuleTraceStrategy(bundle);
            }
            if (num != null && num.intValue() == 2) {
                return new RefundRuleTraceStrategy(bundle, str);
            }
            return new RuleTraceStrategy(bundle);
        }
    }
}
