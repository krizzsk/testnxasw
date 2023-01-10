package com.didi.soda.home.topgun.manager;

import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.home.topgun.model.HomeFeedbackModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0016\u001a\u00020\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/manager/HomeFeedbackConfigHelper;", "", "()V", "homeFeedbackBtnConfigStr", "", "getHomeFeedbackBtnConfigStr", "()Ljava/lang/String;", "setHomeFeedbackBtnConfigStr", "(Ljava/lang/String;)V", "mCacheHomeFeedbackModel", "Lcom/didi/soda/home/topgun/model/HomeFeedbackModel;", "getMCacheHomeFeedbackModel", "()Lcom/didi/soda/home/topgun/model/HomeFeedbackModel;", "setMCacheHomeFeedbackModel", "(Lcom/didi/soda/home/topgun/model/HomeFeedbackModel;)V", "mIsFirstGetConfig", "", "getMIsFirstGetConfig", "()Z", "setMIsFirstGetConfig", "(Z)V", "getHomeFeedbackConfig", "isShowFeedBack", "Companion", "Holder", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeFeedbackConfigHelper.kt */
public final class HomeFeedbackConfigHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "HomeFeedbackConfigHelper";

    /* renamed from: a */
    private String f45494a;

    /* renamed from: b */
    private boolean f45495b;

    /* renamed from: c */
    private HomeFeedbackModel f45496c;

    public /* synthetic */ HomeFeedbackConfigHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HomeFeedbackConfigHelper() {
        this.f45495b = true;
    }

    public final String getHomeFeedbackBtnConfigStr() {
        return this.f45494a;
    }

    public final void setHomeFeedbackBtnConfigStr(String str) {
        this.f45494a = str;
    }

    public final boolean getMIsFirstGetConfig() {
        return this.f45495b;
    }

    public final void setMIsFirstGetConfig(boolean z) {
        this.f45495b = z;
    }

    public final HomeFeedbackModel getMCacheHomeFeedbackModel() {
        return this.f45496c;
    }

    public final void setMCacheHomeFeedbackModel(HomeFeedbackModel homeFeedbackModel) {
        this.f45496c = homeFeedbackModel;
    }

    public final boolean isShowFeedBack() {
        HomeFeedbackModel homeFeedbackConfig = Companion.getInstance().getHomeFeedbackConfig();
        return homeFeedbackConfig != null && !CollectionsUtil.isEmpty(homeFeedbackConfig.getBtnList()) && LoginUtil.isLogin();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081 A[Catch:{ Exception -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d A[Catch:{ Exception -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008e A[Catch:{ Exception -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.home.topgun.model.HomeFeedbackModel getHomeFeedbackConfig() {
        /*
            r13 = this;
            boolean r0 = r13.f45495b     // Catch:{ Exception -> 0x00af }
            if (r0 == 0) goto L_0x00bb
            java.lang.String r0 = com.didi.soda.customer.foundation.util.CustomerApolloUtil.getHomeFeedbackBtnConfig()     // Catch:{ Exception -> 0x00af }
            r13.f45494a = r0     // Catch:{ Exception -> 0x00af }
            r1 = 0
            r13.f45495b = r1     // Catch:{ Exception -> 0x00af }
            if (r0 != 0) goto L_0x0011
            goto L_0x00bb
        L_0x0011:
            java.lang.String r2 = r13.getHomeFeedbackBtnConfigStr()     // Catch:{ Exception -> 0x00af }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x00af }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00af }
            r3 = 0
            if (r2 == 0) goto L_0x001f
            return r3
        L_0x001f:
            com.didi.soda.home.topgun.model.HomeFeedbackModel r2 = new com.didi.soda.home.topgun.model.HomeFeedbackModel     // Catch:{ Exception -> 0x00af }
            r4 = 1
            r2.<init>(r3, r4, r3)     // Catch:{ Exception -> 0x00af }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x00af }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00af }
            java.lang.Class<com.didi.soda.customer.service.ILocaleService> r0 = com.didi.soda.customer.service.ILocaleService.class
            com.didi.soda.customer.service.IService r0 = com.didi.soda.customer.service.CustomerServiceManager.getService(r0)     // Catch:{ Exception -> 0x00af }
            com.didi.soda.customer.service.ILocaleService r0 = (com.didi.soda.customer.service.ILocaleService) r0     // Catch:{ Exception -> 0x00af }
            java.lang.String r0 = r0.getLangTag()     // Catch:{ Exception -> 0x00af }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x00af }
            r6.<init>()     // Catch:{ Exception -> 0x00af }
            int r7 = r5.length()     // Catch:{ Exception -> 0x00af }
            if (r7 <= 0) goto L_0x00a6
            r8 = 0
        L_0x0042:
            int r9 = r8 + 1
            java.lang.Object r8 = r5.get(r8)     // Catch:{ Exception -> 0x00af }
            boolean r10 = r8 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00af }
            if (r10 == 0) goto L_0x00a1
            r10 = r8
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = "issueNo"
            int r10 = r10.optInt(r11)     // Catch:{ Exception -> 0x00af }
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = "btnText"
            org.json.JSONObject r8 = r8.optJSONObject(r11)     // Catch:{ Exception -> 0x00af }
            if (r8 == 0) goto L_0x00a1
            r11 = r0
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x00af }
            if (r11 == 0) goto L_0x006d
            int r11 = r11.length()     // Catch:{ Exception -> 0x00af }
            if (r11 != 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r11 = 0
            goto L_0x006e
        L_0x006d:
            r11 = 1
        L_0x006e:
            if (r11 != 0) goto L_0x00a1
            org.json.JSONObject r8 = r8.optJSONObject(r0)     // Catch:{ Exception -> 0x00af }
            if (r8 == 0) goto L_0x00a1
            java.lang.String r11 = "text"
            java.lang.String r8 = r8.optString(r11)     // Catch:{ Exception -> 0x00af }
            r11 = r8
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x00af }
            if (r11 == 0) goto L_0x008a
            int r11 = r11.length()     // Catch:{ Exception -> 0x00af }
            if (r11 != 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            r11 = 0
            goto L_0x008b
        L_0x008a:
            r11 = 1
        L_0x008b:
            if (r11 == 0) goto L_0x008e
            goto L_0x00a1
        L_0x008e:
            com.didi.soda.home.topgun.model.HomeFeedbackButtonModel r11 = new com.didi.soda.home.topgun.model.HomeFeedbackButtonModel     // Catch:{ Exception -> 0x00af }
            r12 = 3
            r11.<init>(r3, r3, r12, r3)     // Catch:{ Exception -> 0x00af }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00af }
            r11.setIssueNo(r10)     // Catch:{ Exception -> 0x00af }
            r11.setText(r8)     // Catch:{ Exception -> 0x00af }
            r6.add(r11)     // Catch:{ Exception -> 0x00af }
        L_0x00a1:
            if (r9 < r7) goto L_0x00a4
            goto L_0x00a6
        L_0x00a4:
            r8 = r9
            goto L_0x0042
        L_0x00a6:
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x00af }
            r2.setBtnList(r6)     // Catch:{ Exception -> 0x00af }
            r13.setMCacheHomeFeedbackModel(r2)     // Catch:{ Exception -> 0x00af }
            return r2
        L_0x00af:
            r0 = move-exception
            java.lang.String r1 = "feedback json parse error: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            java.lang.String r1 = "HomeFeedbackConfigHelper"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32588i((java.lang.String) r1, (java.lang.String) r0)
        L_0x00bb:
            com.didi.soda.home.topgun.model.HomeFeedbackModel r0 = r13.f45496c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.manager.HomeFeedbackConfigHelper.getHomeFeedbackConfig():com.didi.soda.home.topgun.model.HomeFeedbackModel");
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/manager/HomeFeedbackConfigHelper$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/didi/soda/home/topgun/manager/HomeFeedbackConfigHelper;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeFeedbackConfigHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeFeedbackConfigHelper getInstance() {
            return Holder.INSTANCE.getInstance();
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/manager/HomeFeedbackConfigHelper$Holder;", "", "()V", "instance", "Lcom/didi/soda/home/topgun/manager/HomeFeedbackConfigHelper;", "getInstance", "()Lcom/didi/soda/home/topgun/manager/HomeFeedbackConfigHelper;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeFeedbackConfigHelper.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static final HomeFeedbackConfigHelper instance = new HomeFeedbackConfigHelper((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final HomeFeedbackConfigHelper getInstance() {
            return instance;
        }
    }
}
