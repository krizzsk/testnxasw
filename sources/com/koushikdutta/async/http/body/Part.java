package com.koushikdutta.async.http.body;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import java.io.File;
import java.util.List;
import java.util.Locale;

public class Part {
    public static final String CONTENT_DISPOSITION = "Content-Disposition";

    /* renamed from: d */
    static final /* synthetic */ boolean f58171d = (!Part.class.desiredAssertionStatus());

    /* renamed from: a */
    private long f58172a = -1;

    /* renamed from: b */
    Headers f58173b;

    /* renamed from: c */
    Multimap f58174c;

    public Part(Headers headers) {
        this.f58173b = headers;
        this.f58174c = Multimap.parseSemicolonDelimited(headers.get("Content-Disposition"));
    }

    public String getName() {
        return this.f58174c.getString("name");
    }

    public Part(String str, long j, List<NameValuePair> list) {
        this.f58172a = j;
        this.f58173b = new Headers();
        StringBuilder sb = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", new Object[]{str}));
        if (list != null) {
            for (NameValuePair next : list) {
                sb.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", new Object[]{next.getName(), next.getValue()}));
            }
        }
        this.f58173b.set("Content-Disposition", sb.toString());
        this.f58174c = Multimap.parseSemicolonDelimited(this.f58173b.get("Content-Disposition"));
    }

    public Headers getRawHeaders() {
        return this.f58173b;
    }

    public String getContentType() {
        return this.f58173b.get("Content-Type");
    }

    public void setContentType(String str) {
        this.f58173b.set("Content-Type", str);
    }

    public String getFilename() {
        String string = this.f58174c.getString(SDKConsts.TAG_KEY_FILENAME);
        if (string == null) {
            return null;
        }
        return new File(string).getName();
    }

    public boolean isFile() {
        return this.f58174c.containsKey(SDKConsts.TAG_KEY_FILENAME);
    }

    public long length() {
        return this.f58172a;
    }

    public void write(DataSink dataSink, CompletedCallback completedCallback) {
        if (!f58171d) {
            throw new AssertionError();
        }
    }
}
