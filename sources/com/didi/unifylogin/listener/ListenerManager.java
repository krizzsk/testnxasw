package com.didi.unifylogin.listener;

import com.didi.unifylogin.listener.LoginListeners;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListenerManager {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<LoginListeners.LoginListener> f47449a = new ConcurrentLinkedQueue<>();

    /* renamed from: b */
    private static ConcurrentLinkedQueue<LoginListeners.LoginJumpListener> f47450b = new ConcurrentLinkedQueue<>();

    /* renamed from: c */
    private static ConcurrentLinkedQueue<LoginListeners.LoginOutListener> f47451c = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    private static ConcurrentLinkedQueue<LoginListeners.TokenListener> f47452d = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    private static LoginListeners.LoginInterceptor f47453e;

    /* renamed from: f */
    private static LoginListeners.CancelAccFinishListener f47454f;

    /* renamed from: g */
    private static LoginListeners.LocationListener f47455g;

    /* renamed from: h */
    private static LoginListeners.GlobalizationListener f47456h;

    /* renamed from: i */
    private static LoginListeners.WebViewListener f47457i;

    /* renamed from: j */
    private static LoginListeners.CustomStateFragment f47458j;

    /* renamed from: k */
    private static LoginListeners.ModifyPasswordListener f47459k;

    /* renamed from: l */
    private static LoginListeners.SetCellListener f47460l;

    /* renamed from: m */
    private static LoginListeners.InputCPFListener f47461m;

    /* renamed from: n */
    private static LoginListeners.ModifyEmailListener f47462n;

    /* renamed from: o */
    private static LoginListeners.VerifyCodeListener f47463o;

    /* renamed from: p */
    private static LoginListeners.LoginBaseActivityDelegate f47464p;

    /* renamed from: q */
    private static LoginListeners.GuidePermissionsDelegate f47465q;

    /* renamed from: r */
    private static LoginListeners.LoadingViewListener f47466r;

    /* renamed from: s */
    private static LoginListeners.FaceListener f47467s;

    /* renamed from: t */
    private static LoginListeners.WhatsAppListener f47468t;

    /* renamed from: u */
    private static LoginListeners.GetParamsListener f47469u;

    /* renamed from: v */
    private static LoginListeners.FirstInstallListener f47470v;

    /* renamed from: w */
    private static LoginListeners.InfoAutoFillListener f47471w;

    /* renamed from: x */
    private static LoginListeners.ShowSkipListener f47472x;

    /* renamed from: y */
    private static LoginListeners.IPreLoginListener f47473y;

    /* renamed from: z */
    private static LoginListeners.ShowEmailSuffixListener f47474z;

    public static LoginListeners.ShowEmailSuffixListener getEmailSuffixListener() {
        return f47474z;
    }

    public static void setEmailSuffixListener(LoginListeners.ShowEmailSuffixListener showEmailSuffixListener) {
        f47474z = showEmailSuffixListener;
    }

    public static LoginListeners.WhatsAppListener getWhatsAppListener() {
        return f47468t;
    }

    public static void setParamsListener(LoginListeners.GetParamsListener getParamsListener) {
        f47469u = getParamsListener;
    }

    public static LoginListeners.GetParamsListener getParamsListener() {
        return f47469u;
    }

    public static void setWhatsAppListener(LoginListeners.WhatsAppListener whatsAppListener) {
        f47468t = whatsAppListener;
    }

    public static LoginListeners.LoadingViewListener getLoadingViewListener() {
        return f47466r;
    }

    public static void setLoadingViewListener(LoginListeners.LoadingViewListener loadingViewListener) {
        f47466r = loadingViewListener;
    }

    public static void addLoginListener(LoginListeners.LoginListener loginListener) {
        f47449a.add(loginListener);
    }

    public static void removeLoginListener(LoginListeners.LoginListener loginListener) {
        f47449a.remove(loginListener);
    }

    public static void addLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener) {
        f47450b.add(loginJumpListener);
    }

    public static void removeLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener) {
        f47450b.remove(loginJumpListener);
    }

    public static LoginListeners.InputCPFListener getCpfInputListener() {
        return f47461m;
    }

    public static void setCpfInputListener(LoginListeners.InputCPFListener inputCPFListener) {
        f47461m = inputCPFListener;
    }

    public static void addTokenListener(LoginListeners.TokenListener tokenListener) {
        f47452d.add(tokenListener);
    }

    public static void removeTokenListener(LoginListeners.TokenListener tokenListener) {
        f47452d.remove(tokenListener);
    }

    public static ConcurrentLinkedQueue<LoginListeners.LoginListener> getLoginListeners() {
        return f47449a;
    }

    public static ConcurrentLinkedQueue<LoginListeners.LoginJumpListener> getLoginJumpListeners() {
        return f47450b;
    }

    public static ConcurrentLinkedQueue<LoginListeners.TokenListener> getTokenListeners() {
        return f47452d;
    }

    public static LoginListeners.CancelAccFinishListener getCAFinishListener() {
        return f47454f;
    }

    public static void setCAFinishListener(LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        f47454f = cancelAccFinishListener;
    }

    public static LoginListeners.CustomStateFragment getCustomStateFragment() {
        return f47458j;
    }

    public static void setCustomStateFragmen(LoginListeners.CustomStateFragment customStateFragment) {
        f47458j = customStateFragment;
    }

    public static LoginListeners.LocationListener getLocationListener() {
        return f47455g;
    }

    public static LoginListeners.GlobalizationListener getGlobalizationListener() {
        return f47456h;
    }

    public static void setLocationListener(LoginListeners.LocationListener locationListener) {
        f47455g = locationListener;
    }

    public static void setGlobalizationListener(LoginListeners.GlobalizationListener globalizationListener) {
        f47456h = globalizationListener;
    }

    public static LoginListeners.LoginInterceptor getLoginInterceptor() {
        return f47453e;
    }

    public static void setLoginInterceptor(LoginListeners.LoginInterceptor loginInterceptor) {
        f47453e = loginInterceptor;
    }

    public static LoginListeners.WebViewListener getWebViewListener() {
        return f47457i;
    }

    public static void setWebViewListener(LoginListeners.WebViewListener webViewListener) {
        f47457i = webViewListener;
    }

    public static LoginListeners.ModifyPasswordListener getModifyPasswordListener() {
        return f47459k;
    }

    public static void setModifyPasswordListener(LoginListeners.ModifyPasswordListener modifyPasswordListener) {
        f47459k = modifyPasswordListener;
    }

    public static ConcurrentLinkedQueue<LoginListeners.LoginOutListener> getLoginOutListeners() {
        return f47451c;
    }

    public static void addLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        f47451c.add(loginOutListener);
    }

    public static void removeLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        f47451c.remove(loginOutListener);
    }

    public static LoginListeners.SetCellListener getSetCellListener() {
        return f47460l;
    }

    public static void setSetCellListener(LoginListeners.SetCellListener setCellListener) {
        f47460l = setCellListener;
    }

    public static void setActivityDelegate(LoginListeners.LoginBaseActivityDelegate loginBaseActivityDelegate) {
        f47464p = loginBaseActivityDelegate;
    }

    public static LoginListeners.LoginBaseActivityDelegate getActivityDelegate() {
        return f47464p;
    }

    public static void setModifyEmailListener(LoginListeners.ModifyEmailListener modifyEmailListener) {
        f47462n = modifyEmailListener;
    }

    public static LoginListeners.ModifyEmailListener getModifyEmailListener() {
        return f47462n;
    }

    public static LoginListeners.VerifyCodeListener getVerifyCodeListener() {
        return f47463o;
    }

    public static void setVerifyCodeListener(LoginListeners.VerifyCodeListener verifyCodeListener) {
        f47463o = verifyCodeListener;
    }

    public static void setGuidePermissionsDelegate(LoginListeners.GuidePermissionsDelegate guidePermissionsDelegate) {
        f47465q = guidePermissionsDelegate;
    }

    public static LoginListeners.GuidePermissionsDelegate getGuidePermissionsDelegate() {
        return f47465q;
    }

    public static void setFaceListener(LoginListeners.FaceListener faceListener) {
        f47467s = faceListener;
    }

    public static LoginListeners.FaceListener getFaceListener() {
        return f47467s;
    }

    public static void setFirstInstallListener(LoginListeners.FirstInstallListener firstInstallListener) {
        f47470v = firstInstallListener;
    }

    public static LoginListeners.FirstInstallListener getFirstInstallListener() {
        return f47470v;
    }

    public static LoginListeners.InfoAutoFillListener getInfoAutoFillListener() {
        return f47471w;
    }

    public static void setInfoAutoFillListener(LoginListeners.InfoAutoFillListener infoAutoFillListener) {
        f47471w = infoAutoFillListener;
    }

    public static void setShowSkipListener(LoginListeners.ShowSkipListener showSkipListener) {
        f47472x = showSkipListener;
    }

    public static LoginListeners.ShowSkipListener getShowSkipListener() {
        return f47472x;
    }

    public static LoginListeners.IPreLoginListener getPreLoginListener() {
        return f47473y;
    }

    public static void setPreLoginListener(LoginListeners.IPreLoginListener iPreLoginListener) {
        f47473y = iPreLoginListener;
    }
}
