package com.didi.beatles.p101im.access.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.action.IMActionItem;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.style.custom.IMCustomResBuilder;
import com.didi.beatles.p101im.access.style.custom.IMCustomViewBuilder;
import com.didi.beatles.p101im.access.utils.ConfigLoadListener;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.custom.IMCustomCardViewBaseProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.access.utils.IMBusinessConfig */
public class IMBusinessConfig {
    public static final int COMMON_WORD_TYPE_DEFAULT = 1;
    public static final int COMMON_WORD_TYPE_DRIVER = 2;

    /* renamed from: d */
    private static final String f10689d = "IMBusinessConfig";

    /* renamed from: A */
    private String f10690A;

    /* renamed from: B */
    private String f10691B;

    /* renamed from: C */
    private IMCustomViewBuilder f10692C;

    /* renamed from: D */
    private IMCustomResBuilder f10693D;

    /* renamed from: E */
    private IMStyleManager.Style f10694E = IMStyleManager.Style.UNDEFINED;

    /* renamed from: F */
    private List<Integer> f10695F = new ArrayList<Integer>(5) {
        {
            add(3);
            add(7);
        }
    };

    /* renamed from: a */
    ConfigLoadListener f10696a;

    /* renamed from: b */
    List<String> f10697b = new ArrayList();

    /* renamed from: c */
    String f10698c;
    @ConfigField(tag = 0)

    /* renamed from: e */
    private boolean f10699e = true;
    @ConfigField(tag = 1)

    /* renamed from: f */
    private boolean f10700f = false;
    @ConfigField(tag = 2)
    @Deprecated

    /* renamed from: g */
    private boolean f10701g = false;
    @ConfigField(tag = 3)

    /* renamed from: h */
    private boolean f10702h = false;
    @ConfigField(tag = 4)

    /* renamed from: i */
    private boolean f10703i = false;
    @ConfigField(tag = 5)

    /* renamed from: j */
    private boolean f10704j = true;
    @ConfigField(tag = 6)

    /* renamed from: k */
    private boolean f10705k = true;
    @ConfigField(tag = 7)

    /* renamed from: l */
    private boolean f10706l = true;
    @ConfigField(tag = 8)

    /* renamed from: m */
    private boolean f10707m = true;
    @ConfigField(tag = 9)

    /* renamed from: n */
    private boolean f10708n = true;
    @ConfigField(tag = 10)

    /* renamed from: o */
    private boolean f10709o = true;
    @ConfigField(tag = 11)

    /* renamed from: p */
    private boolean f10710p = true;

    /* renamed from: q */
    private boolean f10711q = true;

    /* renamed from: r */
    private int f10712r = 16;

    /* renamed from: s */
    private boolean f10713s = false;

    /* renamed from: t */
    private boolean f10714t = false;

    /* renamed from: u */
    private Map<String, Integer> f10715u = new HashMap();

    /* renamed from: v */
    private int f10716v = 1;

    /* renamed from: w */
    private boolean f10717w = false;

    /* renamed from: x */
    private String f10718x;

    /* renamed from: y */
    private String f10719y;

    /* renamed from: z */
    private boolean f10720z = false;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.access.utils.IMBusinessConfig$TypeCommonWord */
    public @interface TypeCommonWord {
    }

    public IMBusinessConfig() {
    }

    public void injectCommonUseMsgs(List<String> list) {
        this.f10697b = list;
    }

    public IMBusinessConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.f10699e = z;
        this.f10700f = z2;
        this.f10701g = z3;
        this.f10702h = z4;
        this.f10703i = z5;
        this.f10704j = z6;
        this.f10705k = z7;
        this.f10706l = z8;
        this.f10707m = z9;
        this.f10708n = z10;
        this.f10709o = z11;
        this.f10710p = z12;
    }

    public IMBusinessConfig(int i) {
        try {
            this.f10699e = (i & 1) > 0;
            this.f10700f = (i & 2) > 0;
            this.f10701g = (i & 4) > 0;
            this.f10702h = (i & 8) > 0;
            this.f10703i = (i & 16) > 0;
            this.f10704j = (i & 32) > 0;
            this.f10705k = (i & 64) > 0;
            this.f10706l = (i & 128) > 0;
            this.f10707m = (i & 256) > 0;
            this.f10708n = (i & 512) > 0;
            this.f10709o = (i & 1024) > 0;
            this.f10710p = (i & 2048) > 0;
        } catch (Exception e) {
            IMLog.m10021e("", "MBusinessConfig initError", e);
        }
    }

    public String getBottomBarClass() {
        return this.f10719y;
    }

    public void setBottomBarClass(String str) {
        IMLog.m10020d("IMEngine", "设置的类 " + str);
        this.f10719y = str;
    }

    public boolean isNeedSceneCommonWord() {
        return this.f10717w;
    }

    public void setNeedSceneCommonWord(boolean z) {
        this.f10717w = z;
    }

    public int getCommonWordType() {
        return this.f10716v;
    }

    public void setCommonWordType(int i) {
        this.f10716v = i;
    }

    public String getIllegalTextOnPicture() {
        return this.f10718x;
    }

    public void setIllegalTextOnPicture(String str) {
        this.f10718x = str;
    }

    public boolean isNeedMsgString() {
        return this.f10720z;
    }

    public void setNeedMsgString(boolean z) {
        this.f10720z = z;
    }

    public void setOpenGlobalAlert(boolean z) {
        this.f10709o = z;
    }

    public void setTitleShowNickName(boolean z) {
        this.f10699e = z;
    }

    public void setShowProfile(boolean z) {
        this.f10700f = z;
    }

    public void setAvatarCanClick(boolean z) {
        this.f10701g = z;
    }

    public void setShowEmoji(boolean z) {
        this.f10702h = z;
    }

    public void setShowExtendIcon(boolean z) {
        this.f10703i = z;
    }

    public void setShowUsefulExpression(boolean z) {
        this.f10704j = z;
    }

    public void setDefaultOpenUsefulExpression(boolean z) {
        this.f10705k = z;
    }

    public void setClientCreateSession(boolean z) {
        this.f10706l = z;
    }

    public void setOpenInnerNotification(boolean z) {
        this.f10707m = z;
    }

    public void setOpenOuterNotification(boolean z) {
        this.f10708n = z;
    }

    public boolean isTitleShowNickName() {
        return this.f10699e;
    }

    public boolean isShowProfile() {
        return this.f10700f;
    }

    public boolean isAvatarCanClick() {
        return this.f10701g;
    }

    public boolean isShowEmoji() {
        return this.f10702h;
    }

    public boolean isShowExtendIcon() {
        return this.f10703i;
    }

    public boolean isShowUsefulExpression() {
        return this.f10704j;
    }

    public boolean isDefaultOpenUsefulExpression() {
        return this.f10705k;
    }

    public boolean isClientCreateSession() {
        return this.f10706l;
    }

    public boolean isOpenInnerNotification() {
        return this.f10707m;
    }

    public boolean isOpenOuterNotification() {
        return this.f10708n;
    }

    public boolean isOpenGlobalAlert() {
        return this.f10709o;
    }

    public boolean isShowPeerAvatar() {
        return this.f10710p;
    }

    public void setShowPeerAvatar(boolean z) {
        this.f10710p = z;
    }

    public boolean isUseAudioMessage() {
        return this.f10711q;
    }

    public void setUseAudioMessage(boolean z) {
        this.f10711q = z;
    }

    public int getTextSize() {
        return this.f10712r;
    }

    public IMBusinessConfig setTextSize(int i) {
        this.f10712r = i;
        return this;
    }

    public IMBusinessConfig setIsUber(boolean z) {
        this.f10713s = z;
        return this;
    }

    public boolean isUber() {
        return this.f10713s;
    }

    public IMBusinessConfig setIsFloatShowQuickButton(boolean z) {
        this.f10714t = z;
        return this;
    }

    public boolean isFloatShowQuickButton() {
        return this.f10714t;
    }

    @Deprecated
    public IMBusinessConfig registerDrawable(String str, int i) {
        Map<String, Integer> map = this.f10715u;
        if (map != null) {
            map.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public int getExtendDrawableResource(String str) {
        Integer num;
        Map<String, Integer> map = this.f10715u;
        if (map == null || map.isEmpty() || (num = this.f10715u.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public IMBusinessConfig registerImResource(Map<String, Integer> map) {
        if (map != null && map.size() > 0) {
            this.f10715u.putAll(map);
        }
        return this;
    }

    @Deprecated
    public IMBusinessConfig registerColor(String str, int i) {
        Map<String, Integer> map = this.f10715u;
        if (map != null) {
            map.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public int getExtendColorResource(String str) {
        Integer num;
        Map<String, Integer> map = this.f10715u;
        if (map == null || map.isEmpty() || (num = this.f10715u.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public IMBusinessConfig registerImResource(String str, int i) {
        Map<String, Integer> map = this.f10715u;
        if (map != null) {
            map.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public int getExtendResource(String str) {
        Integer num;
        Map<String, Integer> map = this.f10715u;
        if (map == null || map.isEmpty() || (num = this.f10715u.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public Map<String, Integer> getResourceMap() {
        return this.f10715u;
    }

    public void setConfigListener(ConfigLoadListener configLoadListener) {
        this.f10696a = configLoadListener;
    }

    public ArrayList<String> getQuickMessages(String str, int i) {
        ArrayList<String> onQuickMessageLoaded;
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener == null || (onQuickMessageLoaded = configLoadListener.onQuickMessageLoaded(str)) == null || onQuickMessageLoaded.isEmpty()) {
            return IMContextInfoHelper.getQuickReplyList(i);
        }
        return onQuickMessageLoaded;
    }

    @Deprecated
    public boolean showBottomExtendView(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            return configLoadListener.dispatchShowBottomExtendView(context, iMSession, iMBusinessParam);
        }
        return false;
    }

    public ConfigLoadListener.IMGuideAction showBottomGuideView(Context context, IMSession iMSession, String str, Map<String, View> map) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            return configLoadListener.showBottomBarGuide(context, iMSession, str, map);
        }
        return null;
    }

    public boolean interceptMessageUrl(Context context, IMSession iMSession, String str) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            return configLoadListener.onGoLinkUrl(context, iMSession, str);
        }
        return false;
    }

    public void getIMEmojiList(String str, int i, ConfigLoadListener.IMGetEmojiListCallback iMGetEmojiListCallback) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            configLoadListener.getEmojiList(str, iMGetEmojiListCallback);
        }
    }

    public List<IMActionItem> getIMMoreAction(String str) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            return configLoadListener.getMoreAction(str);
        }
        return null;
    }

    @Deprecated
    public void onClickPhone(Context context, String str) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            configLoadListener.onClickPhone(context, str);
        }
    }

    public void onChatTitleRightIconClick(Activity activity, View view) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            configLoadListener.onChatTitleRightIconClick(activity, view);
        }
    }

    public void onMoreButtonShow(IMSession iMSession, IMBusinessParam iMBusinessParam) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            configLoadListener.onMoreButtonShow(iMSession, iMBusinessParam);
        }
    }

    public void onBottomBarExpandViewShow(int i, IMSession iMSession, IMBusinessParam iMBusinessParam) {
        ConfigLoadListener configLoadListener = this.f10696a;
        if (configLoadListener != null) {
            configLoadListener.onBottomBarExpandViewShow(i, iMSession, iMBusinessParam);
        }
    }

    public void registCradViewProvider(String str) {
        this.f10698c = str;
    }

    public void registerPlugin(Integer num) {
        if (this.f10695F == null) {
            this.f10695F = new ArrayList();
        }
        this.f10695F.add(num);
    }

    public void registerPlugin(List<Integer> list) {
        if (this.f10695F == null) {
            this.f10695F = new ArrayList();
        }
        this.f10695F.addAll(list);
    }

    public List<Integer> getPluginList() {
        return this.f10695F;
    }

    public String getSchemeHost() {
        return this.f10690A;
    }

    public void setSchemeHost(String str) {
        this.f10690A = str;
    }

    public IMCustomCardViewBaseProvider getCardViewProvider() {
        if (!TextUtils.isEmpty(this.f10698c)) {
            try {
                return (IMCustomCardViewBaseProvider) Class.forName(this.f10698c).newInstance();
            } catch (Exception e) {
                IMLog.m10021e("im_register_card", "reflect fail with the name is" + this.f10698c);
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setIMStyle(IMStyleManager.Style style) {
        this.f10694E = style;
    }

    public IMStyleManager.Style getIMStyle() {
        return this.f10694E;
    }

    public void setCustomViewBuilder(IMCustomViewBuilder iMCustomViewBuilder) {
        this.f10692C = iMCustomViewBuilder;
    }

    public IMCustomViewBuilder getCustomBuilder() {
        return this.f10692C;
    }

    public void setCustomResBuilder(IMCustomResBuilder iMCustomResBuilder) {
        this.f10693D = iMCustomResBuilder;
    }

    public IMCustomResBuilder getCustomResBuilder() {
        return this.f10693D;
    }

    public void setLocationTopScheme(String str) {
        this.f10691B = str;
    }

    public String getLocationTopScheme() {
        return this.f10691B;
    }

    public String toString() {
        return "IMBusinessConfig{titleShowNickName=" + this.f10699e + ", showProfile=" + this.f10700f + ", avatarCanClick=" + this.f10701g + ", showEmoji=" + this.f10702h + ", showExtendIcon=" + this.f10703i + ", showUsefulExpression=" + this.f10704j + ", defaultOpenUsefulExpression=" + this.f10705k + ", clientCreateSession=" + this.f10706l + ", openInnerNotification=" + this.f10707m + ", openOuterNotification=" + this.f10708n + ", openGlobalAlert=" + this.f10709o + ", showPeerAvatar=" + this.f10710p + ", textSize=" + this.f10712r + ", isUber=" + this.f10713s + ", isFolatShowQuickButton=" + this.f10714t + ", mCradViewProviderName='" + this.f10698c + '\'' + ", bottombarclass= " + this.f10719y + ", schemeHost = " + this.f10690A + ", style = " + this.f10694E + '}';
    }
}
