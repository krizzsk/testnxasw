package com.didi.soda.web;

import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.page.WebPage;
import java.util.HashMap;

public class WebPageBuilder {

    /* renamed from: a */
    private Page f46429a;

    /* renamed from: b */
    private PageInstrument f46430b;

    /* renamed from: c */
    private WebConfig f46431c = new WebConfig();

    private WebPageBuilder() {
    }

    public static WebPageBuilder with(Page page) {
        WebPageBuilder webPageBuilder = new WebPageBuilder();
        webPageBuilder.f46429a = page;
        return webPageBuilder;
    }

    public static WebPageBuilder with(PageInstrument pageInstrument) {
        WebPageBuilder webPageBuilder = new WebPageBuilder();
        webPageBuilder.f46430b = pageInstrument;
        return webPageBuilder;
    }

    public WebPageBuilder setUrl(String str) {
        this.f46431c.url = str;
        return this;
    }

    public WebPageBuilder setTitle(String str) {
        this.f46431c.title = str;
        return this;
    }

    public WebPageBuilder canChangeTitle(boolean z) {
        this.f46431c.canChangeTitle = z;
        return this;
    }

    public WebPageBuilder isSupportCache(boolean z) {
        this.f46431c.isSupportCache = z;
        return this;
    }

    @Deprecated
    public WebPageBuilder addCustomerParameters(HashMap hashMap) {
        this.f46431c.mCustomerParameters = hashMap;
        return this;
    }

    /* renamed from: go */
    public WebPage mo115681go() {
        WebPage webPage = new WebPage(this.f46431c);
        PageInstrument pageInstrument = this.f46430b;
        if (pageInstrument == null || pageInstrument.hasRootPage()) {
            Page page = this.f46429a;
            if (page != null) {
                page.push(new WebPage(this.f46431c));
            }
        } else {
            this.f46430b.setRootPage(webPage);
        }
        return webPage;
    }
}
