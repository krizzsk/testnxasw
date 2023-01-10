package com.datadog.android.core.configuration;

import com.datadog.android.core.configuration.Configuration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Configuration.kt */
final class Configuration$Builder$useCustomCrashReportsEndpoint$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $endpoint;
    final /* synthetic */ Configuration.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Configuration$Builder$useCustomCrashReportsEndpoint$1(Configuration.Builder builder, String str) {
        super(0);
        this.this$0 = builder;
        this.$endpoint = str;
    }

    public final void invoke() {
        Configuration.Builder builder = this.this$0;
        builder.crashReportConfig = Configuration.Feature.CrashReport.copy$default(builder.crashReportConfig, this.$endpoint, (List) null, 2, (Object) null);
        this.this$0.checkCustomEndpoint(this.$endpoint);
    }
}
