package kotlin.text;

import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.text.f */
/* compiled from: StringNumberConversionsJVM.kt */
final class C2709f {

    /* renamed from: a */
    public static final Regex f5988a = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + (VersionRange.LEFT_OPEN + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + "[eE][+-]?(\\p{Digit}+)" + ")?)|" + "(\\.(" + "(\\p{Digit}+)" + ")(" + "[eE][+-]?(\\p{Digit}+)" + ")?)|" + "((" + "(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))" + ")[pP][+-]?" + "(\\p{Digit}+)" + VersionRange.RIGHT_OPEN) + ")[fFdD]?))[\\x00-\\x20]*");

    /* renamed from: b */
    public static final C2709f f5989b = new C2709f();

    private C2709f() {
    }
}
