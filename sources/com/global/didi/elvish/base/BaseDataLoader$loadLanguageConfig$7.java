package com.global.didi.elvish.base;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, mo148868d2 = {"<anonymous>", "", "", "", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: BaseDataLoader.kt */
final /* synthetic */ class BaseDataLoader$loadLanguageConfig$7 extends FunctionReference implements Function1<Context, Map<String, Object>> {
    BaseDataLoader$loadLanguageConfig$7(BaseDataLoader baseDataLoader) {
        super(1, baseDataLoader);
    }

    public final String getName() {
        return "loadLocalAssetsLanguageConfData";
    }

    public final KDeclarationContainer getOwner() {
        return C2404Reflection.getOrCreateKotlinClass(BaseDataLoader.class);
    }

    public final String getSignature() {
        return "loadLocalAssetsLanguageConfData(Landroid/content/Context;)Ljava/util/Map;";
    }

    public final Map<String, Object> invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "p1");
        return ((BaseDataLoader) this.receiver).m40723d(context);
    }
}
