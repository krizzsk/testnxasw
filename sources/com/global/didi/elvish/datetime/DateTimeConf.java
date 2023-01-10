package com.global.didi.elvish.datetime;

import android.content.Context;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.base.BaseConf;
import com.global.didi.elvish.datetime.model.DTPattern;
import com.global.didi.elvish.datetime.model.DTPatternsModel;
import com.global.didi.elvish.datetime.model.OffsetModel;
import com.global.didi.elvish.datetime.model.TimezoneOffsetModel;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dJ \u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170 2\u0006\u0010\u001c\u001a\u00020\u0007J\u0018\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010\t\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0018J\u0019\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dJ\u0010\u0010%\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\b\u0010&\u001a\u00020'H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo148868d2 = {"Lcom/global/didi/elvish/datetime/DateTimeConf;", "Lcom/global/didi/elvish/base/BaseConf;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "city2TimezoneMap", "", "", "", "cityId", "getCityId", "()Ljava/lang/String;", "setCityId", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "dtPattern", "Lcom/global/didi/elvish/datetime/model/DTPatternsModel;", "timezoneOffsetModel", "Lcom/global/didi/elvish/datetime/model/TimezoneOffsetModel;", "binarySearch", "", "arr", "", "", "key", "([Ljava/lang/Long;J)I", "getAmPmMarks", "locale", "(Ljava/lang/String;)[Ljava/lang/String;", "getDurationsByLocale", "getIs24", "Lkotlin/Pair;", "", "getOffset", "timestamp", "getPatternsByLocale", "getTimeZone", "loadData", "", "elvish_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: DateTimeConf.kt */
public final class DateTimeConf extends BaseConf {

    /* renamed from: a */
    private String f55111a = "";

    /* renamed from: b */
    private Map<String, ? extends Object> f55112b = new LinkedHashMap();

    /* renamed from: c */
    private TimezoneOffsetModel f55113c = new TimezoneOffsetModel(0, 1, (DefaultConstructorMarker) null);

    /* renamed from: d */
    private DTPatternsModel f55114d = new DTPatternsModel(new HashMap());

    /* renamed from: e */
    private final Context f55115e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DateTimeConf(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f55115e = context;
        m40734a();
    }

    public final Context getContext() {
        return this.f55115e;
    }

    public final String getCityId() {
        return this.f55111a;
    }

    public final void setCityId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f55111a = str;
    }

    public static /* synthetic */ String getTimeZone$default(DateTimeConf dateTimeConf, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return dateTimeConf.getTimeZone(str);
    }

    public final String getTimeZone(String str) {
        Intrinsics.checkParameterIsNotNull(str, "cityId");
        try {
            int parseInt = Integer.parseInt(str);
            if (!(parseInt > 370 || 358 == parseInt || 357 == parseInt)) {
                str = "1";
            }
        } catch (NumberFormatException unused) {
        }
        if (!this.f55112b.containsKey(str)) {
            return "";
        }
        Object obj = this.f55112b.get(str);
        if (obj != null) {
            return (String) obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    public static /* synthetic */ int getOffset$default(DateTimeConf dateTimeConf, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return dateTimeConf.getOffset(str, j);
    }

    public final int getOffset(String str, long j) {
        int a;
        Intrinsics.checkParameterIsNotNull(str, "cityId");
        if (!Intrinsics.areEqual((Object) str, (Object) this.f55111a)) {
            this.f55111a = str;
            m40734a();
        }
        if (this.f55112b.containsKey(str)) {
            Object obj = this.f55112b.get(str);
            if (obj != null) {
                OffsetModel offsetModel = this.f55113c.getOffsetMap().get((String) obj);
                if (offsetModel != null && (a = m40733a(offsetModel.getInterval(), j - this.f55113c.getOffset())) >= 0) {
                    int numericValue = Character.getNumericValue(offsetModel.getMapping().charAt(a));
                    Integer[] offset = offsetModel.getOffset();
                    int i = numericValue * 2;
                    return offset[i].intValue() + offset[i + 1].intValue();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
        }
        return -1;
    }

    public final Pair<Boolean, String[]> getIs24(String str) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        DTPattern patternModel = this.f55114d.getPatternModel(str);
        boolean z = false;
        if (patternModel == null) {
            return new Pair<>(false, new String[0]);
        }
        if (patternModel.is24() == 1) {
            z = true;
        }
        return new Pair<>(Boolean.valueOf(z), patternModel.getAmPmMarkers());
    }

    public final String[] getAmPmMarks(String str) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        DTPattern patternModel = this.f55114d.getPatternModel(str);
        return patternModel != null ? patternModel.getAmPmMarkers() : new String[0];
    }

    public final String[] getPatternsByLocale(String str) {
        String[] patterns;
        Intrinsics.checkParameterIsNotNull(str, "locale");
        DTPattern patternModel = this.f55114d.getPatternModel(str);
        if (patternModel != null) {
            if (!(patternModel.getPatterns().length == 8)) {
                patternModel = null;
            }
            if (!(patternModel == null || (patterns = patternModel.getPatterns()) == null)) {
                return patterns;
            }
        }
        return new String[]{"HH:mm:ss", "HH:mm", "dd/MM/yyyy", "dd/MM/yy", "MMM yyyy", "EEE,dd MMM", "dd MMM", "{1},{0}"};
    }

    public final String[] getDurationsByLocale(String str) {
        String[] duration;
        Intrinsics.checkParameterIsNotNull(str, "locale");
        DTPattern patternModel = this.f55114d.getPatternModel(str);
        if (patternModel != null) {
            if (!(patternModel.getDuration().length == 7)) {
                patternModel = null;
            }
            if (!(patternModel == null || (duration = patternModel.getDuration()) == null)) {
                return duration;
            }
        }
        return new String[]{"{0}s", "{0} min", "{0}h", "{0}day", "{1}m {0}s", "{1}h {0}m", "{1}day {0}h"};
    }

    /* renamed from: a */
    private final int m40733a(Long[] lArr, long j) {
        int length = lArr.length - 1;
        int i = 0;
        if (j >= lArr[0].longValue() && j <= lArr[length].longValue() && length >= 0) {
            while (i <= length) {
                int i2 = (i + length) / 2;
                if (lArr[i2].longValue() > j) {
                    length = i2 - 1;
                } else if (lArr[i2].longValue() >= j) {
                    return i2;
                } else {
                    i = i2 + 1;
                }
                if (j >= lArr[i].longValue() && lArr[i + 1].longValue() > j) {
                    return i;
                }
                if (j >= lArr[length].longValue() && lArr[length + 1].longValue() > j) {
                    return length;
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    private final void m40734a() {
        DateTimeLoader dateTimeLoader = new DateTimeLoader();
        this.f55112b = dateTimeLoader.loadCityConf(this.f55115e);
        TimezoneOffsetModel loadTimezoneOffset = dateTimeLoader.loadTimezoneOffset(this.f55115e);
        if (loadTimezoneOffset == null) {
            loadTimezoneOffset = new TimezoneOffsetModel(0, 1, (DefaultConstructorMarker) null);
        }
        this.f55113c = loadTimezoneOffset;
        if (Elvish.Companion.getLocalCustomRuleConf().containsKey("datetime")) {
            Type type = new DateTimeConf$loadData$type$1().getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeToken<Map<S…, DTPattern?>?>() {}.type");
            DTPatternsModel dTPatternsModel = this.f55114d;
            Gson gson = new Gson();
            Gson gson2 = new Gson();
            Object obj = Elvish.Companion.getLocalCustomRuleConf().get("datetime");
            if (obj == null) {
                obj = "";
            }
            Object fromJson = gson.fromJson(gson2.toJson(obj), type);
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<Map<Stri…: \"\"), type\n            )");
            dTPatternsModel.setPatternMap((Map) fromJson);
        }
    }
}
