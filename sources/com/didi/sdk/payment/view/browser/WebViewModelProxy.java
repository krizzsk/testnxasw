package com.didi.sdk.payment.view.browser;

import android.app.Activity;
import androidx.fragment.app.Fragment;

public class WebViewModelProxy {

    /* renamed from: a */
    private Activity f39729a;

    /* renamed from: b */
    private Fragment f39730b;

    /* renamed from: c */
    private String f39731c;

    /* renamed from: d */
    private String f39732d;

    /* renamed from: e */
    private String f39733e;

    /* renamed from: f */
    private String f39734f;

    /* renamed from: g */
    private String f39735g;

    /* renamed from: h */
    private int f39736h;

    /* renamed from: i */
    private int f39737i;

    /* renamed from: j */
    private boolean f39738j = true;

    /* renamed from: k */
    private boolean f39739k = true;

    /* renamed from: l */
    private boolean f39740l;

    public String getTitle() {
        return this.f39731c;
    }

    public void setTitle(String str) {
        this.f39731c = str;
    }

    public String getUrl() {
        return this.f39732d;
    }

    public void setUrl(String str) {
        this.f39732d = str;
    }

    public Activity getActivity() {
        return this.f39729a;
    }

    public void setActivity(Activity activity) {
        this.f39729a = activity;
    }

    public String getPostData() {
        return this.f39733e;
    }

    public void setPostData(String str) {
        this.f39733e = str;
    }

    public String getBackUrl() {
        return this.f39734f;
    }

    public void setBackUrl(String str) {
        this.f39734f = str;
    }

    public String getCancelUrl() {
        return this.f39735g;
    }

    public void setCancelUrl(String str) {
        this.f39735g = str;
    }

    public int getRequestCode() {
        return this.f39736h;
    }

    public void setRequestCode(int i) {
        this.f39736h = i;
    }

    public Fragment getFragment() {
        return this.f39730b;
    }

    public void setFragment(Fragment fragment) {
        this.f39730b = fragment;
    }

    public int getType() {
        return this.f39737i;
    }

    public void setType(int i) {
        this.f39737i = i;
    }

    public boolean isCanChangeWebViewTitle() {
        return this.f39738j;
    }

    public void setCanChangeWebViewTitle(boolean z) {
        this.f39738j = z;
    }

    public boolean isSupportCache() {
        return this.f39739k;
    }

    public void setSupportCache(boolean z) {
        this.f39739k = z;
    }

    public boolean isPostBaseParams() {
        return this.f39740l;
    }

    public void setPostBaseParams(boolean z) {
        this.f39740l = z;
    }
}
