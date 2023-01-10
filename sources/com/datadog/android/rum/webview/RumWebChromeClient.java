package com.datadog.android.rum.webview;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo148868d2 = {"Lcom/datadog/android/rum/webview/RumWebChromeClient;", "Landroid/webkit/WebChromeClient;", "()V", "logger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/log/Logger;)V", "onConsoleMessage", "", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "toLogLevel", "", "Landroid/webkit/ConsoleMessage$MessageLevel;", "Companion", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RumWebChromeClient.kt */
public class RumWebChromeClient extends WebChromeClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOGGER_NAME = "WebChromeClient";
    public static final String SOURCE_ID = "source.id";
    public static final String SOURCE_LINE = "source.line";

    /* renamed from: a */
    private final Logger f4040a;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: RumWebChromeClient.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            iArr[ConsoleMessage.MessageLevel.LOG.ordinal()] = 1;
            iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 2;
            iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 3;
            iArr[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 4;
            iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RumWebChromeClient(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f4040a = logger;
    }

    public RumWebChromeClient() {
        this(new Logger.Builder().setLoggerName(LOGGER_NAME).setNetworkInfoEnabled(true).build());
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage != null) {
            String message = consoleMessage.message();
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            Map mapOf = MapsKt.mapOf(TuplesKt.m41339to(SOURCE_ID, consoleMessage.sourceId()), TuplesKt.m41339to(SOURCE_LINE, Integer.valueOf(consoleMessage.lineNumber())));
            if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                RumMonitor rumMonitor = GlobalRum.get();
                Intrinsics.checkNotNullExpressionValue(message, "message");
                rumMonitor.addError(message, RumErrorSource.WEBVIEW, (Throwable) null, mapOf);
            } else {
                Logger logger = this.f4040a;
                Intrinsics.checkNotNullExpressionValue(messageLevel, "level");
                int a = m2530a(messageLevel);
                Intrinsics.checkNotNullExpressionValue(message, "message");
                logger.log(a, message, (Throwable) null, mapOf);
            }
        }
        return false;
    }

    /* renamed from: a */
    private final int m2530a(ConsoleMessage.MessageLevel messageLevel) {
        int i = WhenMappings.$EnumSwitchMapping$0[messageLevel.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/datadog/android/rum/webview/RumWebChromeClient$Companion;", "", "()V", "LOGGER_NAME", "", "SOURCE_ID", "SOURCE_LINE", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: RumWebChromeClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
