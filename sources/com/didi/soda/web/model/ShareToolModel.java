package com.didi.soda.web.model;

import android.graphics.Bitmap;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.soda.web.config.WebConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareToolModel {

    /* renamed from: a */
    private static final Map<String, String> f46436a;
    public String content = "";
    public String customName = "";
    public HashMap<String, String> extra;
    public Bitmap imageData;
    public String imagePath;
    public String imageUrl;
    public String platformStr = "";
    public List<String> recipients;
    public String smsMessage = "";
    public String title = "";
    public String type;
    public String url;

    static {
        HashMap hashMap = new HashMap();
        f46436a = hashMap;
        hashMap.put("share_weixin_timeline", WebConstant.WXMOMENTS_PLATFORM);
        f46436a.put(InternalJSMethod.SHARE_WEIXIN_TIMELINE, WebConstant.WXMOMENTS_PLATFORM);
        f46436a.put("share_weixin_appmsg", WebConstant.WXCHAT_PLATFORM);
        f46436a.put(InternalJSMethod.SHARE_WEIXIN_APPMSG, WebConstant.WXCHAT_PLATFORM);
        f46436a.put("share_qq_appmsg", WebConstant.QQ_PLATFORM);
        f46436a.put(InternalJSMethod.SHARE_QQ_APPMSG, WebConstant.QQ_PLATFORM);
        f46436a.put(InternalJSMethod.SHARE_QZONE, WebConstant.QZONE_PLATFORM);
        f46436a.put("share_qzone", WebConstant.QZONE_PLATFORM);
        f46436a.put("share_alipay_friend", "ALIPAY_FRIENDS");
        f46436a.put(InternalJSMethod.SHARE_ALIPAY_FRIEND, "ALIPAY_FRIENDS");
        f46436a.put("share_alipay_life", "ALIPAY_TIMELINE");
        f46436a.put(InternalJSMethod.SHARE_ALIPAY_LIFE, "ALIPAY_TIMELINE");
        f46436a.put(InternalJSMethod.SHARE_FACEBOOK, WebConstant.FACEBOOK_PLATFORM);
        f46436a.put("shareFBMessenger", WebConstant.MESSENGER_PLATFORM);
        f46436a.put(InternalJSMethod.SHARE_WHATSAPP, WebConstant.WHATSAPP_PLATFORM);
        f46436a.put("shareTelegram", WebConstant.TELEGRAM_PLATFORM);
        f46436a.put("shareLine", WebConstant.LINE_PLATFORM);
        f46436a.put(InternalJSMethod.SHARE_TWITTER, WebConstant.TWITTER_PLATFORM);
        f46436a.put("shareSysMsg", WebConstant.SYSTEM_MESSAGE);
        f46436a.put(InternalJSMethod.SHARE_EMAIL, WebConstant.EMAIL_PLATFORM);
        f46436a.put("shareSystemEntrance", "system");
        f46436a.put("shareCopyLink", WebConstant.COPY_LINK_PLATFORM);
    }

    public String toString() {
        return "OneKeyShareInfo{platformStr=" + this.platformStr + ", title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", url='" + this.url + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", imagePath='" + this.imagePath + '\'' + ", imageData=" + this.imageData + '\'' + ", smsMessage='" + this.smsMessage + '\'' + ", customName='" + this.customName + '\'' + '}';
    }

    public String getPlatFrom() {
        return f46436a.get(this.type);
    }
}
