package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo148868d2 = {"<anonymous>", "", "Lkshark/AndroidBuildMirror;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: AndroidReferenceMatchers.kt */
final class AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$7 extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
    public static final AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$7 INSTANCE = new AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$7();

    AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$7() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
    }

    public final boolean invoke(AndroidBuildMirror androidBuildMirror) {
        Intrinsics.checkParameterIsNotNull(androidBuildMirror, "$receiver");
        return androidBuildMirror.getSdkInt() == 28;
    }
}
