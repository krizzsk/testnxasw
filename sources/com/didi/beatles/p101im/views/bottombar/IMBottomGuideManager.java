package com.didi.beatles.p101im.views.bottombar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.beatles.p101im.access.action.IMActionItem;
import com.didi.beatles.p101im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p101im.protocol.view.IMGuideConfig;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMEmotionInputDetector;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.widget.IMSimpleGuideView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.IMBottomGuideManager */
public class IMBottomGuideManager {

    /* renamed from: a */
    private static final String f11805a = "IMBottomGuideManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMConversationBottomBar f11806b;

    /* renamed from: c */
    private boolean f11807c = false;

    public void release() {
    }

    public IMBottomGuideManager(IMConversationBottomBar iMConversationBottomBar) {
        this.f11806b = iMConversationBottomBar;
    }

    public void showBottomGuide() {
        m10111b();
        m10112c();
        m10113d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, View> m10105a() {
        if (this.f11806b.mSession == null || !this.f11806b.mSession.getSessionEnable() || this.f11806b.mBusinessConfig == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("bottom", this.f11806b.f11822e);
        if (this.f11806b.f11824g && this.f11806b.f11820c.getVisibility() == 0) {
            hashMap.put("more", this.f11806b.f11820c.getRealView());
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r0 = r5.f11806b.mBusinessConfig.showBottomGuideView(r5.f11806b.getContext(), r5.f11806b.mSession, r5.f11806b.mo48907a(), r0);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10111b() {
        /*
            r5 = this;
            boolean r0 = r5.f11807c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            com.didi.beatles.im.views.bottombar.IMConversationBottomBar r0 = r5.f11806b
            com.didi.beatles.im.module.entity.IMSession r0 = r0.mSession
            if (r0 == 0) goto L_0x004f
            com.didi.beatles.im.views.bottombar.IMConversationBottomBar r0 = r5.f11806b
            com.didi.beatles.im.module.entity.IMSession r0 = r0.mSession
            boolean r0 = r0.getSessionEnable()
            if (r0 != 0) goto L_0x0016
            goto L_0x004f
        L_0x0016:
            java.util.Map r0 = r5.m10105a()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0021
            return
        L_0x0021:
            com.didi.beatles.im.views.bottombar.IMConversationBottomBar r1 = r5.f11806b
            com.didi.beatles.im.access.utils.IMBusinessConfig r1 = r1.mBusinessConfig
            com.didi.beatles.im.views.bottombar.IMConversationBottomBar r2 = r5.f11806b
            android.content.Context r2 = r2.getContext()
            com.didi.beatles.im.views.bottombar.IMConversationBottomBar r3 = r5.f11806b
            com.didi.beatles.im.module.entity.IMSession r3 = r3.mSession
            com.didi.beatles.im.views.bottombar.IMConversationBottomBar r4 = r5.f11806b
            java.lang.String r4 = r4.mo48907a()
            com.didi.beatles.im.access.utils.ConfigLoadListener$IMGuideAction r0 = r1.showBottomGuideView(r2, r3, r4, r0)
            if (r0 != 0) goto L_0x003c
            return
        L_0x003c:
            r1 = 1
            r5.f11807c = r1
            com.didi.beatles.im.views.bottombar.IMConversationBottomBar r1 = r5.f11806b
            android.view.View r1 = r1.getViewRoot()
            com.didi.beatles.im.views.bottombar.IMBottomGuideManager$1 r2 = new com.didi.beatles.im.views.bottombar.IMBottomGuideManager$1
            r2.<init>(r0)
            r3 = 500(0x1f4, double:2.47E-321)
            r1.postDelayed(r2, r3)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.views.bottombar.IMBottomGuideManager.m10111b():void");
    }

    /* renamed from: c */
    private void m10112c() {
        List<IMActionItem> funcList = this.f11806b.f11826i.getFuncList();
        if (funcList != null && this.f11806b.f11820c.getVisibility() != 8 && !this.f11807c && this.f11806b.mSession != null && this.f11806b.mSession.getSessionEnable() && this.f11806b.mSession.getExtendSessionInfo() != null) {
            for (IMActionItem next : funcList) {
                if (next.enable && next.item != null) {
                    IMExtendActionItem iMExtendActionItem = next.item;
                    Context context = this.f11806b.getContext();
                    IMGuideConfig btmGuideConfig = iMExtendActionItem.getBtmGuideConfig(context, this.f11806b.mSession.getSessionId() + "", this.f11806b.mListener.getBottomGuideConfigList());
                    if (btmGuideConfig != null && !TextUtils.isEmpty(btmGuideConfig.text)) {
                        IMSkinTextView iMSkinTextView = null;
                        String str = btmGuideConfig.position;
                        char c = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != 108417) {
                            if (hashCode == 3357525 && str.equals("more")) {
                                c = 0;
                            }
                        } else if (str.equals("msg")) {
                            c = 1;
                        }
                        if (c == 0) {
                            iMSkinTextView = this.f11806b.f11820c;
                        } else if (c == 1) {
                            iMSkinTextView = this.f11806b.f11821d;
                        }
                        if (m10109a(iMSkinTextView, btmGuideConfig.text)) {
                            IMExtendActionItem iMExtendActionItem2 = next.item;
                            Context context2 = this.f11806b.getContext();
                            iMExtendActionItem2.showBtmGuide(context2, btmGuideConfig, this.f11806b.mSession.getSessionId() + "");
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private void m10113d() {
        List<Integer> list;
        boolean z;
        if (!this.f11807c && this.f11806b.mSession != null && this.f11806b.mSession.getSessionEnable() && this.f11806b.mSession.getExtendSessionInfo() != null && (list = this.f11806b.mSession.getExtendSessionInfo().actionIds) != null && !list.isEmpty()) {
            Iterator<Integer> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().intValue() == 1) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                IMLog.m10020d(f11805a, C4786I.m9980t("[tryShowTakePhotoGuide] Disable take photo"));
            }
        }
    }

    /* renamed from: a */
    private boolean m10109a(final IMSkinTextView iMSkinTextView, final String str) {
        if (this.f11807c || iMSkinTextView.getVisibility() != 0) {
            return false;
        }
        this.f11807c = true;
        this.f11806b.getViewRoot().postDelayed(new Runnable() {
            public void run() {
                final IMSimpleGuideView create = new IMSimpleGuideView.Builder(IMBottomGuideManager.this.f11806b.getContext()).isShowForkView(true).setGuideText(str).setTargetView(iMSkinTextView.getRealView()).setOutsideTouchable(true).setMaxWordNumSingleLine(16).setLayoutGravity(0).setGrivaty(3).create();
                create.show();
                IMBottomGuideManager.this.m10108a((Runnable) new Runnable() {
                    public void run() {
                        if (create.isShow()) {
                            create.dismiss();
                        }
                    }
                });
            }
        }, 500);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10108a(final Runnable runnable) {
        if (this.f11806b.f11823f != null) {
            this.f11806b.f11823f.addListener(new IMEmotionInputDetector.OnHideSoftInputListener() {
                public void onHideSoft(IMEmotionInputDetector iMEmotionInputDetector) {
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                    iMEmotionInputDetector.removeListener(this);
                }
            });
        }
    }
}
