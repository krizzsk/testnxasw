package com.didi.map.global.sctx.server;

import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.utils.ApolloUtils;

public class SctxDataProviderFactory {

    /* renamed from: a */
    private ISctxDataProvider f30145a;

    public static ISctxDataProvider createSctxDataProvider(ISctxDataProvider.DataSearchOptions dataSearchOptions, RuntimeErrorCollect runtimeErrorCollect, SctxCaseParser sctxCaseParser) {
        return new SctxDataProviderFactory().create(dataSearchOptions, runtimeErrorCollect, sctxCaseParser);
    }

    public ISctxDataProvider create(ISctxDataProvider.DataSearchOptions dataSearchOptions, RuntimeErrorCollect runtimeErrorCollect, SctxCaseParser sctxCaseParser) {
        if (this.f30145a == null) {
            if (ApolloUtils.oraErrorDoSimulate()) {
                this.f30145a = new C10642b(dataSearchOptions, runtimeErrorCollect, sctxCaseParser);
            } else {
                this.f30145a = new C10641a(dataSearchOptions, runtimeErrorCollect, sctxCaseParser);
            }
        }
        return this.f30145a;
    }
}
