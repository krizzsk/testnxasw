package com.didi.soda.business;

import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.facebook.GraphRequest;
import java.io.Serializable;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0016J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0002J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0016J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0018J\b\u0010 \u001a\u00020\u0018H\u0002J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, mo148868d2 = {"Lcom/didi/soda/business/BusinessOpen;", "", "shopId", "", "(Ljava/lang/String;)V", "actionInfoDict", "anchorInfo", "biData", "businessAnimationSource", "", "Ljava/lang/Integer;", "businessType", "fromType", "needSynergyShop", "orderId", "sceneType", "searchInfo", "shopInfoEntity", "Ljava/io/Serializable;", "transitionName", "url", "wineConfirm", "(Ljava/lang/Integer;)Lcom/didi/soda/business/BusinessOpen;", "checkNullAndAddByType", "", "builder", "Lcom/didi/soda/router/Request$Builder;", "key", "toAdd", "boolean", "", "open", "openBusiness", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessOpen.kt */
public final class BusinessOpen {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final String f42051a;

    /* renamed from: b */
    private int f42052b;

    /* renamed from: c */
    private String f42053c;
    @ParamsKey(key = "orderId")

    /* renamed from: d */
    private String f42054d;
    @ParamsKey(key = "sceneType")

    /* renamed from: e */
    private Integer f42055e;
    @ParamsKey(key = "fromType")

    /* renamed from: f */
    private Integer f42056f;
    @ParamsKey(key = "wineConfirm")

    /* renamed from: g */
    private Integer f42057g;
    @ParamsKey(key = "transitionname")

    /* renamed from: h */
    private Serializable f42058h;
    @ParamsKey(key = "businessanimationsource")

    /* renamed from: i */
    private Integer f42059i;
    @ParamsKey(key = "anchorInfoDict")

    /* renamed from: j */
    private String f42060j;
    @ParamsKey(key = "actionInfoDict")

    /* renamed from: k */
    private String f42061k;
    @ParamsKey(key = "shopinfoentity")

    /* renamed from: l */
    private Serializable f42062l;
    @ParamsKey(key = "searchInfo")

    /* renamed from: m */
    private String f42063m;
    @ParamsKey(key = "bi_data")

    /* renamed from: n */
    private String f42064n;
    @ParamsKey(key = "issynergyshop")

    /* renamed from: o */
    private String f42065o;

    public /* synthetic */ BusinessOpen(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private BusinessOpen(String str) {
        this.f42051a = str;
        this.f42065o = SDKConsts.BOOLEAN_FALSE;
    }

    public final BusinessOpen orderId(String str) {
        this.f42054d = str;
        return this;
    }

    public final BusinessOpen sceneType(Integer num) {
        this.f42055e = num;
        return this;
    }

    public final BusinessOpen fromType(Integer num) {
        this.f42056f = num;
        return this;
    }

    public final BusinessOpen wineConfirm(Integer num) {
        this.f42057g = num;
        return this;
    }

    public final BusinessOpen transitionName(Serializable serializable) {
        this.f42058h = serializable;
        return this;
    }

    public final BusinessOpen businessAnimationSource(Integer num) {
        this.f42059i = num;
        return this;
    }

    public final BusinessOpen anchorInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "anchorInfo");
        this.f42060j = str;
        return this;
    }

    public final BusinessOpen actionInfoDict(String str) {
        Intrinsics.checkNotNullParameter(str, Const.PageParams.ACTION_INFO_DICT);
        this.f42061k = str;
        return this;
    }

    public final BusinessOpen shopInfoEntity(Serializable serializable) {
        this.f42062l = serializable;
        return this;
    }

    public final BusinessOpen searchInfo(String str) {
        this.f42063m = str;
        return this;
    }

    public final BusinessOpen biData(String str) {
        this.f42064n = str;
        return this;
    }

    public final BusinessOpen needSynergyShop(boolean z) {
        this.f42065o = z ? "true" : SDKConsts.BOOLEAN_FALSE;
        return this;
    }

    public final BusinessOpen businessType(int i) {
        this.f42052b = i;
        return this;
    }

    public final BusinessOpen url(String str) {
        this.f42053c = str;
        return this;
    }

    /* renamed from: a */
    private final void m31533a(Request.Builder builder, String str, Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                builder.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                builder.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Serializable) {
                builder.putSerializable(str, (Serializable) obj);
            } else {
                LogUtil.m32588i("BusinessOpen", " >>>> 变量 " + obj.getClass().getName() + " 类型不支持传参。");
            }
        }
    }

    /* renamed from: a */
    private final void m31532a() {
        Request.Builder path = DiRouter.request().path(RoutePath.BUSINESS_HOME);
        path.putString(Const.PageParams.SHOP_ID, this.f42051a);
        Field[] declaredFields = getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, GraphRequest.FIELDS_PARAM);
        for (Field field : declaredFields) {
            ParamsKey paramsKey = (ParamsKey) field.getAnnotation(ParamsKey.class);
            String key = paramsKey == null ? null : paramsKey.key();
            CharSequence charSequence = key;
            if (!(charSequence == null || charSequence.length() == 0)) {
                Object obj = field.get(this);
                Intrinsics.checkNotNullExpressionValue(path, "builder");
                m31533a(path, key, obj);
            } else {
                LogUtil.m32584d("BusinessOpen", " >>>> 变量 " + field.getName() + " 没有设置 注解ParamsKey");
            }
        }
        path.open();
    }

    public final void open() {
        if (GroceryHelper.Companion.isGrocery(Integer.valueOf(this.f42052b))) {
            GroceryHelper.Companion.openGrocery(this.f42053c);
        } else {
            m31532a();
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/business/BusinessOpen$Companion;", "", "()V", "create", "Lcom/didi/soda/business/BusinessOpen;", "shopId", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BusinessOpen.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BusinessOpen create(String str) {
            return new BusinessOpen(str, (DefaultConstructorMarker) null);
        }
    }
}
