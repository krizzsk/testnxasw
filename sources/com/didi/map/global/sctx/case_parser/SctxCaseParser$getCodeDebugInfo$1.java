package com.didi.map.global.sctx.case_parser;

import com.didi.map.global.sctx.case_parser.model.SctxCaseCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Lcom/didi/map/global/sctx/case_parser/model/SctxCaseCode;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SctxCaseParser.kt */
final class SctxCaseParser$getCodeDebugInfo$1 extends Lambda implements Function1<SctxCaseCode, CharSequence> {
    public static final SctxCaseParser$getCodeDebugInfo$1 INSTANCE = new SctxCaseParser$getCodeDebugInfo$1();

    SctxCaseParser$getCodeDebugInfo$1() {
        super(1);
    }

    public final CharSequence invoke(SctxCaseCode sctxCaseCode) {
        Intrinsics.checkNotNullParameter(sctxCaseCode, "it");
        return sctxCaseCode.getPrimaryMsg();
    }
}
