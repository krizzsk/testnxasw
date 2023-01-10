package com.didi.soda.globalcart.anim;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011JV\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0014\u001a\u00020\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J^\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010 \u001a\u00020\u001b26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J+\u0010!\u001a\u00020\u00112#\u0010\"\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00110#J\b\u0010%\u001a\u00020\u0003H\u0002R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didi/soda/globalcart/anim/TotalPriceAnim;", "", "targetPriceDisplay", "", "lastPriceDisplay", "(Ljava/lang/String;Ljava/lang/String;)V", "changeMethod", "Lkotlin/Function2;", "currNumList", "Ljava/util/LinkedList;", "isCompleteEarly", "", "regex", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "cancel", "", "changePrices", "oldList", "dstStr", "change", "Lkotlin/ParameterName;", "name", "a", "b", "findCount", "", "str", "findNumFromStr", "replaceNumber", "list", "start", "run", "setTextBlock", "Lkotlin/Function1;", "text", "runOnce", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TotalPriceAnim.kt */
public final class TotalPriceAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f44840a;

    /* renamed from: b */
    private final LinkedList<String> f44841b;

    /* renamed from: c */
    private final String f44842c = "\\d";

    /* renamed from: d */
    private final ValueAnimator f44843d = ValueAnimator.ofInt(new int[]{0, 5});

    /* renamed from: e */
    private boolean f44844e;

    /* renamed from: f */
    private final Function2<String, String, String> f44845f;

    public TotalPriceAnim(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "targetPriceDisplay");
        Intrinsics.checkNotNullParameter(str2, "lastPriceDisplay");
        this.f44840a = str;
        this.f44841b = m33244b(str2);
        this.f44845f = TotalPriceAnim$changeMethod$1.INSTANCE;
    }

    public final void run(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setTextBlock");
        this.f44843d.setDuration(300);
        this.f44843d.setInterpolator(new LinearInterpolator());
        this.f44843d.addUpdateListener(new TotalPriceAnim$run$1(function1, this));
        this.f44843d.addListener(new TotalPriceAnim$run$2(function1, this));
        this.f44843d.start();
    }

    public final void cancel() {
        if (this.f44843d.isStarted()) {
            this.f44843d.cancel();
        }
        this.f44843d.removeAllUpdateListeners();
        this.f44843d.removeAllListeners();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final String m33241a() {
        return m33243a(this.f44841b, this.f44840a, this.f44845f);
    }

    /* renamed from: a */
    private final String m33243a(LinkedList<String> linkedList, String str, Function2<? super String, ? super String, String> function2) {
        int i;
        int a = m33240a(str);
        if (a > linkedList.size()) {
            i = a - linkedList.size();
        } else {
            while (a < linkedList.size()) {
                linkedList.removeFirst();
            }
            i = 0;
        }
        return m33242a(str, linkedList, i, function2);
    }

    /* renamed from: a */
    private final String m33242a(String str, LinkedList<String> linkedList, int i, Function2<? super String, ? super String, String> function2) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(this.f44842c).matcher(str);
        while (matcher.find() && (!linkedList.isEmpty())) {
            if (i > 0) {
                i--;
            } else {
                String group = matcher.group();
                int i2 = -i;
                String str2 = linkedList.get(i2);
                Intrinsics.checkNotNullExpressionValue(str2, "list[-startCount]");
                Intrinsics.checkNotNullExpressionValue(group, "group");
                String invoke = function2.invoke(str2, group);
                linkedList.set(i2, invoke);
                i--;
                if (this.f44844e && !invoke.equals(group)) {
                    this.f44844e = false;
                }
                matcher.appendReplacement(stringBuffer, invoke);
            }
        }
        matcher.appendTail(stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }

    /* renamed from: a */
    private final int m33240a(String str) {
        int i = 0;
        while (Pattern.compile(this.f44842c).matcher(str).find()) {
            i++;
        }
        return i;
    }

    /* renamed from: b */
    private final LinkedList<String> m33244b(String str) {
        LinkedList<String> linkedList = new LinkedList<>();
        Matcher matcher = Pattern.compile(this.f44842c).matcher(str);
        while (matcher.find()) {
            linkedList.add(matcher.group());
        }
        return linkedList;
    }
}
