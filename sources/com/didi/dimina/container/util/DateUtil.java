package com.didi.dimina.container.util;

import com.datadog.android.log.LogAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/dimina/container/util/DateUtil;", "", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "hourFormat", "monthFormat", "yearFormat", "parseDate", "", "date", "Ljava/util/Date;", "time", "", "parseMonthDate", "parseTime", "datetime", "parseYearDate", "container_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: DateUtil.kt */
public final class DateUtil {
    public static final DateUtil INSTANCE = new DateUtil();

    /* renamed from: a */
    private static SimpleDateFormat f19802a = new SimpleDateFormat("HH:mm", Locale.getDefault());

    /* renamed from: b */
    private static SimpleDateFormat f19803b = new SimpleDateFormat("yyyy-MM", Locale.getDefault());

    /* renamed from: c */
    private static SimpleDateFormat f19804c = new SimpleDateFormat("yyyy", Locale.getDefault());

    /* renamed from: d */
    private static SimpleDateFormat f19805d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    private DateUtil() {
    }

    public final String parseDate(long j) {
        return parseDate(new Date(j));
    }

    public final String parseDate(Date date) {
        Intrinsics.checkParameterIsNotNull(date, LogAttributes.DATE);
        String format = f19805d.format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "dateFormat.format(date)");
        return format;
    }

    public final Date parseDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, LogAttributes.DATE);
        Date parse = f19805d.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(date)");
        return parse;
    }

    public final String parseMonthDate(Date date) {
        Intrinsics.checkParameterIsNotNull(date, LogAttributes.DATE);
        String format = f19803b.format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "monthFormat.format(date)");
        return format;
    }

    public final Date parseMonthDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, LogAttributes.DATE);
        Date parse = f19803b.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "monthFormat.parse(date)");
        return parse;
    }

    public final String parseYearDate(Date date) {
        Intrinsics.checkParameterIsNotNull(date, LogAttributes.DATE);
        String format = f19804c.format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "yearFormat.format(date)");
        return format;
    }

    public final Date parseYearDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, LogAttributes.DATE);
        Date parse = f19804c.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "yearFormat.parse(date)");
        return parse;
    }

    public final String parseTime(long j) {
        return parseTime(new Date(j));
    }

    public final String parseTime(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "datetime");
        String format = f19802a.format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "hourFormat.format(datetime)");
        return format;
    }

    public final Date parseTime(String str) {
        Intrinsics.checkParameterIsNotNull(str, "datetime");
        Date parse = f19802a.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "hourFormat.parse(datetime)");
        return parse;
    }
}
