package com.didi.beatles.p101im.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.style.custom.IMCustomContext;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.access.utils.Parser;
import com.didi.beatles.p101im.activity.IMMessageActivity;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.common.IMMessageList;
import com.didi.beatles.p101im.event.IMMessageEmptyEvent;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p101im.module.IMMessageCallback;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMUser;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.plugin.IMPluginCardViewProvider;
import com.didi.beatles.p101im.plugin.IMPluginFactory;
import com.didi.beatles.p101im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p101im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p101im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p101im.protocol.plugin.IMPluginService;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMDateUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMParseUtil;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.IMToastHelper;
import com.didi.beatles.p101im.views.IMDynamicRegisterCardView;
import com.didi.beatles.p101im.views.IMPluginCardView;
import com.didi.beatles.p101im.views.IMViewHolder;
import com.didi.beatles.p101im.views.custom.IMCradViewStatusCallback;
import com.didi.beatles.p101im.views.custom.IMCustomCardViewBaseProvider;
import com.didi.beatles.p101im.views.custom.IMDynamicRegisterCard;
import com.didi.beatles.p101im.views.messageCard.IMAudioRenderView;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;
import com.didi.beatles.p101im.views.messageCard.IMGifImageRenderView;
import com.didi.beatles.p101im.views.messageCard.IMImageRenderView;
import com.didi.beatles.p101im.views.messageCard.IMLocationRenderView;
import com.didi.beatles.p101im.views.messageCard.IMOrderMsgRenderView;
import com.didi.beatles.p101im.views.messageCard.IMRichInfoRenderView;
import com.didi.beatles.p101im.views.messageCard.IMSingleTextRender;
import com.didi.beatles.p101im.views.messageCard.IMSysAudioMsgRenderView;
import com.didi.beatles.p101im.views.messageCard.IMSysMsgRenderView;
import com.didi.beatles.p101im.views.messageCard.IMTextRenderView;
import com.didi.beatles.p101im.views.messageCard.IMTimeRenderView;
import com.didi.beatles.p101im.views.messageCard.IMloadRenderView;
import com.didi.beatles.p101im.views.popup.IMMessageOperatePopup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.adapter.MessageAdapter */
public class MessageAdapter extends RecyclerView.Adapter implements IMBaseRenderView.MessageListItemListener {

    /* renamed from: H */
    private static final String f10919H = "im_register_card";

    /* renamed from: N */
    private static final int f10920N = 16384;

    /* renamed from: O */
    private static final int f10921O = 32768;
    public static final int TYPE_TIME_TITLE = 107;

    /* renamed from: a */
    private static final int f10922a = 0;

    /* renamed from: b */
    private static final int f10923b = 101;

    /* renamed from: c */
    private static final int f10924c = 102;

    /* renamed from: d */
    private static final int f10925d = 103;

    /* renamed from: e */
    private static final int f10926e = 111;

    /* renamed from: f */
    private static final int f10927f = 116;

    /* renamed from: g */
    private static final int f10928g = 118;

    /* renamed from: h */
    private static final int f10929h = 104;

    /* renamed from: i */
    private static final int f10930i = 105;

    /* renamed from: j */
    private static final int f10931j = 112;

    /* renamed from: k */
    private static final int f10932k = 106;

    /* renamed from: l */
    private static final int f10933l = 117;

    /* renamed from: m */
    private static final int f10934m = 119;

    /* renamed from: n */
    private static final int f10935n = 108;

    /* renamed from: o */
    private static final int f10936o = 109;

    /* renamed from: p */
    private static final int f10937p = 110;

    /* renamed from: q */
    private static final int f10938q = 113;

    /* renamed from: r */
    private static final int f10939r = 114;

    /* renamed from: s */
    private static final int f10940s = 115;

    /* renamed from: A */
    private IMCustomCardViewBaseProvider f10941A = null;

    /* renamed from: B */
    private List<Integer> f10942B = new ArrayList();

    /* renamed from: C */
    private IMCradViewStatusCallback f10943C;

    /* renamed from: D */
    private IMPluginCardViewProvider f10944D = null;

    /* renamed from: E */
    private Set<Integer> f10945E = new HashSet();

    /* renamed from: F */
    private IMMessageViewStatusCallback f10946F;

    /* renamed from: G */
    private int f10947G;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public MessageAdapterListener f10948I;

    /* renamed from: J */
    private boolean f10949J;

    /* renamed from: K */
    private boolean f10950K;

    /* renamed from: L */
    private IMMessageOperatePopup f10951L;

    /* renamed from: M */
    private IMRenderCardEnv f10952M;

    /* renamed from: P */
    private boolean f10953P = false;
    public Map<Long, Integer> audioRenderStatusStore = new HashMap();
    public Set<IMAudioRenderView> audioRenderViewStore = new HashSet(0);
    public IMCustomContext imCustomContext;
    public boolean isUberMode;
    public int mBusinessid;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public IMMessageList<IMMessage> f10954t = new IMMessageList<>();

    /* renamed from: u */
    private HashMap<Long, IMUser> f10955u = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public IMMessageActivity f10956v;

    /* renamed from: w */
    private boolean f10957w;

    /* renamed from: x */
    private int f10958x;

    /* renamed from: y */
    private ViewGroup f10959y;

    /* renamed from: z */
    private boolean f10960z;

    /* renamed from: com.didi.beatles.im.adapter.MessageAdapter$MessageAdapterListener */
    public interface MessageAdapterListener {
        void displayEggs(IMConfig.EggsInfo eggsInfo);

        boolean interceptMessageUrl(String str);

        void onResendMessage(IMMessage iMMessage);

        void showAddCustomWordDialog(String str, int i);
    }

    /* renamed from: a */
    private int m9563a(int i, int i2) {
        return i | i2;
    }

    /* renamed from: b */
    private int m9572b(int i, int i2) {
        return i ^ i2;
    }

    /* renamed from: c */
    private boolean m9581c(int i) {
        return (i & 16384) != 0;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public MessageAdapter(IMMessageActivity iMMessageActivity, MessageAdapterListener messageAdapterListener, int i, int i2, IMSession iMSession, IMCustomContext iMCustomContext) {
        this.f10948I = messageAdapterListener;
        this.f10956v = iMMessageActivity;
        this.f10958x = i;
        m9577b();
        this.mBusinessid = i2;
        this.f10947G = iMSession.getType();
        this.imCustomContext = iMCustomContext;
        this.f10944D = new IMPluginCardViewProvider();
        m9580c();
        initPluginCardViewProvider();
    }

    public void updateRenderCardEnv(long j, String str, Map<String, String> map) {
        IMRenderCardEnv iMRenderCardEnv = this.f10952M;
        if (iMRenderCardEnv == null) {
            this.f10952M = new IMRenderCardEnv(j, str, map);
            return;
        }
        iMRenderCardEnv.setOrderId(str);
        this.f10952M.setExtraTraceMap(map);
    }

    public void initPluginCardViewProvider() {
        List<Integer> pluginList = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(this.f10947G, this.mBusinessid).getPluginList();
        if (pluginList == null) {
            this.f10944D.clear();
            IMLog.m10020d(f10919H, C4786I.m9980t("[initPluginCardViewProvider] NULL plugin list"));
            return;
        }
        for (Integer next : pluginList) {
            if (next == null || next.intValue() <= 0) {
                IMLog.m10020d(f10919H, C4786I.m9980t("[initPluginCardViewProvider] invalid plugin id:", next));
            } else {
                IMPluginService plugin = IMPluginFactory.getPlugin(next.intValue());
                if (plugin != null) {
                    Class<? extends View> messageViewClazz = plugin.getMessageViewClazz();
                    if (messageViewClazz != null) {
                        int parsePluginViewType = Parser.parsePluginViewType(next.intValue());
                        IMLog.m10020d(f10919H, C4786I.m9980t("[initPluginCardViewProvider] #REGISTER# viewType=", Integer.valueOf(parsePluginViewType), " |clazz=", messageViewClazz));
                        this.f10944D.registerPluginMessageView(parsePluginViewType, messageViewClazz);
                    }
                } else {
                    IMLog.m10021e(f10919H, C4786I.m9980t("[initPluginCardViewProvider] no plugin service implement for plugin id:", next));
                }
            }
        }
    }

    public boolean canLoadHistory() {
        return this.f10957w;
    }

    public void loadAudio(int i, int i2) {
        while (i < i2) {
            IMMessage item = getItem(i);
            if (item instanceof IMMessage) {
                IMMessage iMMessage = item;
                if (iMMessage.getType() == 131072 && IMTextUtil.isEmpty(iMMessage.getFile_name()) && IMModelProvider.getInstance().getMessageModule() != null) {
                    IMModelProvider.getInstance().getMessageModule().loadAudioMessage(iMMessage, iMMessage.getSid(), (IMMessageCallback) null);
                }
            }
            i++;
        }
    }

    public void addItem(List<IMMessage> list) {
        int size = this.f10954t.size();
        Iterator<IMMessage> it = list.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                IMMessage next = it.next();
                Long valueOf = Long.valueOf(next.getCreateTime());
                long senderUid = next.getSenderUid();
                if (getItemCount() > 0) {
                    IMMessage item = getItem(getItemCount() - 1);
                    if (item instanceof IMMessage) {
                        IMMessage iMMessage = item;
                        Long valueOf2 = Long.valueOf(iMMessage.getCreateTime());
                        long senderUid2 = iMMessage.getSenderUid();
                        boolean needDisplayTime = IMDateUtil.needDisplayTime(valueOf2, valueOf);
                        if (needDisplayTime) {
                            IMMessage iMMessage2 = new IMMessage(107);
                            iMMessage2.setCreateTime(valueOf.longValue());
                            this.f10954t.add(iMMessage2);
                        }
                        if (!needDisplayTime && senderUid == senderUid2) {
                            if (next.getType() != 327680) {
                                z = false;
                            }
                            next.isShowHead = z;
                        }
                    }
                } else {
                    Long valueOf3 = Long.valueOf(next.getCreateTime());
                    IMMessage iMMessage3 = new IMMessage(107);
                    iMMessage3.setCreateTime(valueOf3.longValue());
                    this.f10954t.add(iMMessage3);
                }
                this.f10954t.add(next);
            } else {
                notifyItemRangeInserted(size + 1, list.size());
                return;
            }
        }
    }

    public void setUsers(HashMap<Long, IMUser> hashMap) {
        this.f10955u.putAll(hashMap);
    }

    public void isShowPeerAvatar(boolean z) {
        this.f10960z = z;
    }

    public void isUber(boolean z) {
        this.isUberMode = z;
    }

    public Long getListMinPosition() {
        IMMessageList<IMMessage> iMMessageList = this.f10954t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return 0L;
        }
        if (((IMMessage) this.f10954t.get(0)).getType() != 107) {
            return Long.valueOf(((IMMessage) this.f10954t.get(0)).getId());
        }
        if (this.f10954t.size() > 1) {
            return Long.valueOf(((IMMessage) this.f10954t.get(1)).getId());
        }
        return 0L;
    }

    public Long getListMaxPosition() {
        IMMessageList<IMMessage> iMMessageList = this.f10954t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return 0L;
        }
        IMMessageList<IMMessage> iMMessageList2 = this.f10954t;
        if (((IMMessage) iMMessageList2.get(iMMessageList2.size() - 1)).getType() != 107) {
            IMMessageList<IMMessage> iMMessageList3 = this.f10954t;
            return Long.valueOf(((IMMessage) iMMessageList3.get(iMMessageList3.size() - 1)).getId());
        } else if (this.f10954t.size() <= 2) {
            return 0L;
        } else {
            IMMessageList<IMMessage> iMMessageList4 = this.f10954t;
            return Long.valueOf(((IMMessage) iMMessageList4.get(iMMessageList4.size() - 2)).getId());
        }
    }

    public void changeMsgReadStatus(List<IMMessage> list) {
        if (list != null && list.size() != 0) {
            int[] iArr = new int[list.size()];
            int i = 0;
            for (IMMessage location : list) {
                int location2 = this.f10954t.getLocation(location);
                int i2 = i + 1;
                iArr[i] = location2;
                if (location2 != -1) {
                    ((IMMessage) this.f10954t.get(location2)).setIsRead(true);
                }
                i = i2;
            }
            if (list.size() <= 1 || iArr[1] == 0) {
                IMLog.m10019d("changeMsgReadStatus  " + m9562a(iArr[0]));
                notifyItemChanged(m9562a(iArr[0]));
                return;
            }
            notifyDataSetChanged();
            IMLog.m10019d("changeMsgReadStatus  notifyDataSetChanged");
        }
    }

    public IMMessage getLastMessage() {
        IMUser iMUser;
        IMMessageList<IMMessage> iMMessageList = this.f10954t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return null;
        }
        IMMessageList<IMMessage> iMMessageList2 = this.f10954t;
        IMMessage iMMessage = (IMMessage) iMMessageList2.get(iMMessageList2.size() - 1);
        if (iMMessage == null) {
            return null;
        }
        if (this.f10947G == 2 && (iMUser = this.f10955u.get(Long.valueOf(iMMessage.getSenderUid()))) != null) {
            iMMessage.setNickName(iMUser.getNickName());
        }
        return iMMessage;
    }

    public List<IMMessage> getMessagesWithType(int i) {
        IMMessageList<IMMessage> iMMessageList = this.f10954t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f10954t.iterator();
        while (it.hasNext()) {
            IMMessage iMMessage = (IMMessage) it.next();
            if (iMMessage.getType() == i) {
                arrayList.add(iMMessage);
            }
        }
        return arrayList;
    }

    public void hidePopup() {
        IMMessageOperatePopup iMMessageOperatePopup = this.f10951L;
        if (iMMessageOperatePopup != null) {
            iMMessageOperatePopup.hidePopup();
        }
    }

    public static List<IMMessage> removeDuplicate(List<IMMessage> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(list);
        list.clear();
        list.addAll(linkedHashSet);
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.beatles.p101im.common.IMMessageList<com.didi.beatles.p101im.module.entity.IMMessage> loadHistoryList(java.util.List<com.didi.beatles.p101im.module.entity.IMMessage> r19, boolean r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            if (r1 == 0) goto L_0x00e4
            int r3 = r19.size()
            if (r3 > 0) goto L_0x000e
            goto L_0x00e4
        L_0x000e:
            com.didi.beatles.im.adapter.MessageAdapter$MessageTimeComparator r3 = new com.didi.beatles.im.adapter.MessageAdapter$MessageTimeComparator
            r3.<init>()
            java.util.Collections.sort(r1, r3)
            com.didi.beatles.im.common.IMMessageList r3 = new com.didi.beatles.im.common.IMMessageList
            r3.<init>()
            r4 = 0
            r6 = 1
            if (r20 == 0) goto L_0x0038
            int r7 = r18.getItemCount()
            int r7 = r7 - r6
            com.didi.beatles.im.module.entity.IMMessage r7 = r0.getItem(r7)
            boolean r8 = r7 instanceof com.didi.beatles.p101im.module.entity.IMMessage
            if (r8 == 0) goto L_0x0038
            com.didi.beatles.im.module.entity.IMMessage r7 = (com.didi.beatles.p101im.module.entity.IMMessage) r7
            long r4 = r7.getCreateTime()
            long r7 = r7.getSenderUid()
            goto L_0x0039
        L_0x0038:
            r7 = r4
        L_0x0039:
            java.util.Iterator r9 = r19.iterator()
        L_0x003d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00c5
            java.lang.Object r10 = r9.next()
            com.didi.beatles.im.module.entity.IMMessage r10 = (com.didi.beatles.p101im.module.entity.IMMessage) r10
            long r11 = r10.getCreateTime()
            long r13 = r10.getSenderUid()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Long r5 = java.lang.Long.valueOf(r11)
            boolean r4 = com.didi.beatles.p101im.utils.IMDateUtil.needDisplayTime(r4, r5)
            if (r4 == 0) goto L_0x0077
            java.lang.Long r5 = java.lang.Long.valueOf(r11)
            com.didi.beatles.im.module.entity.IMMessage r15 = new com.didi.beatles.im.module.entity.IMMessage
            r2 = 107(0x6b, float:1.5E-43)
            r15.<init>((int) r2)
            r16 = r7
            long r6 = r5.longValue()
            r15.setCreateTime(r6)
            r3.add((com.didi.beatles.p101im.module.entity.IMMessage) r15)
            goto L_0x0079
        L_0x0077:
            r16 = r7
        L_0x0079:
            if (r4 != 0) goto L_0x008f
            int r4 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x008f
            int r4 = r10.getType()
            r5 = 327680(0x50000, float:4.59177E-40)
            if (r4 != r5) goto L_0x008b
            r2 = 1
            r10.isShowHead = r2
            goto L_0x0090
        L_0x008b:
            r2 = 1
            r10.isShowHead = r2
            goto L_0x0090
        L_0x008f:
            r2 = 1
        L_0x0090:
            r3.add((com.didi.beatles.p101im.module.entity.IMMessage) r10)
            int r4 = r10.getType()
            r5 = 196608(0x30000, float:2.75506E-40)
            if (r4 != r5) goto L_0x00c0
            int r4 = r10.getStatus()
            r5 = 100
            if (r4 != r5) goto L_0x00c0
            long r4 = r10.getSenderUid()
            long r6 = com.didi.beatles.p101im.IMContextInfoHelper.getUid()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00c0
            com.didi.beatles.im.task.IMUploadQueue r4 = com.didi.beatles.p101im.task.IMUploadQueue.getInstance()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00c0
            if (r20 != 0) goto L_0x00c0
            r4 = 300(0x12c, float:4.2E-43)
            r10.setStatus(r4)
        L_0x00c0:
            r4 = r11
            r7 = r13
            r6 = 1
            goto L_0x003d
        L_0x00c5:
            r2 = 1
            if (r20 != 0) goto L_0x00db
            com.didi.beatles.im.common.IMMessageList<com.didi.beatles.im.module.entity.IMMessage> r4 = r0.f10954t
            r5 = 0
            r4.addAll(r5, r3)
            int r1 = r19.size()
            int r4 = r0.f10958x
            if (r1 < r4) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r2 = 0
        L_0x00d8:
            r0.f10957w = r2
            goto L_0x00e0
        L_0x00db:
            com.didi.beatles.im.common.IMMessageList<com.didi.beatles.im.module.entity.IMMessage> r1 = r0.f10954t
            r1.addAll(r3)
        L_0x00e0:
            r18.notifyDataSetChanged()
            return r3
        L_0x00e4:
            if (r20 != 0) goto L_0x00ec
            r1 = 0
            r0.f10957w = r1
            r18.notifyDataSetChanged()
        L_0x00ec:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.adapter.MessageAdapter.loadHistoryList(java.util.List, boolean):com.didi.beatles.im.common.IMMessageList");
    }

    /* renamed from: a */
    private void m9570a(IMMessage iMMessage) {
        MessageAdapterListener messageAdapterListener;
        if (iMMessage != null && (messageAdapterListener = this.f10948I) != null) {
            messageAdapterListener.onResendMessage(iMMessage);
        }
    }

    public void onResendClick(IMMessage iMMessage) {
        m9570a(iMMessage);
    }

    public boolean onBubbleClick(IMMessage iMMessage) {
        if (iMMessage == null || this.f10948I == null) {
            return false;
        }
        String str = null;
        if (iMMessage.getType() == 393217 && iMMessage.getMessageExtendInfo() != null) {
            str = iMMessage.getMessageExtendInfo().light_link;
        }
        if (TextUtils.isEmpty(str) || !this.f10948I.interceptMessageUrl(str)) {
            return false;
        }
        return true;
    }

    public void onBubbleLongClick(View view, int i, IMMessage iMMessage) {
        if (iMMessage.getType() != 393217 && iMMessage.getType() != 393219 && iMMessage.getType() != 107 && iMMessage.getType() != 393224) {
            boolean z = false;
            IMLog.m10024i("onBubbleLongClick " + iMMessage.getType(), new Object[0]);
            if (iMMessage.getType() == 528385 && !TextUtils.isEmpty(iMMessage.getContent())) {
                String parseSubType = Parser.parseSubType(iMMessage.getContent());
                if (!TextUtils.isEmpty(parseSubType) && "private_order".equals(parseSubType)) {
                    return;
                }
            }
            boolean z2 = iMMessage.getSenderUid() == IMContextInfoHelper.getUid();
            IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(this.f10947G, this.mBusinessid);
            if (iMMessage.getType() != 65537 && currentBusinessConfig.isShowUsefulExpression()) {
                z = z2;
            }
            IMBtsAudioHelper.stopPlaying();
            m9568a(this.f10959y, (IMMessageOperatePopup.OnItemClickListener) new OperateItemClickListener(iMMessage, i)).show(view, iMMessage.getType(), z);
        }
    }

    public void onEggsMsgRender(IMConfig.EggsInfo eggsInfo) {
        MessageAdapterListener messageAdapterListener = this.f10948I;
        if (messageAdapterListener != null && eggsInfo != null) {
            messageAdapterListener.displayEggs(eggsInfo);
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.MessageAdapter$MessageTimeComparator */
    public static class MessageTimeComparator implements Comparator<IMMessage> {
        public int compare(IMMessage iMMessage, IMMessage iMMessage2) {
            return IMParseUtil.parseInt(iMMessage.getId() - iMMessage2.getId());
        }
    }

    public void updateItemState(IMMessage iMMessage) {
        long id = iMMessage.getId();
        Long valueOf = Long.valueOf(iMMessage.getMid());
        int size = this.f10954t.size();
        while (true) {
            size--;
            if (size <= 0) {
                size = -1;
                break;
            }
            IMMessage iMMessage2 = (IMMessage) this.f10954t.get(size);
            if (iMMessage2.getId() == id && iMMessage2.getMid() == valueOf.longValue()) {
                this.f10954t.set(size, iMMessage);
                break;
            }
        }
        if (size != -1) {
            notifyItemChanged(m9562a(size));
        }
    }

    /* renamed from: a */
    private int m9562a(int i) {
        return this.f10957w ? i + 1 : i;
    }

    public IMUser getUserModel(long j) {
        HashMap<Long, IMUser> hashMap = this.f10955u;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        return this.f10955u.get(Long.valueOf(j));
    }

    /* renamed from: a */
    private IMMessageOperatePopup m9568a(ViewGroup viewGroup, IMMessageOperatePopup.OnItemClickListener onItemClickListener) {
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(this.mBusinessid);
        IMMessageOperatePopup instance = IMMessageOperatePopup.instance(viewGroup, currentBusinessConfig != null ? currentBusinessConfig.isShowUsefulExpression() : false);
        this.f10951L = instance;
        instance.setOnItemClickListener(onItemClickListener);
        return instance;
    }

    /* renamed from: com.didi.beatles.im.adapter.MessageAdapter$OperateItemClickListener */
    private class OperateItemClickListener implements IMMessageOperatePopup.OnItemClickListener {
        /* access modifiers changed from: private */
        public IMMessage mMsgInfo;
        /* access modifiers changed from: private */
        public int mPostion;

        public OperateItemClickListener(IMMessage iMMessage, int i) {
            this.mMsgInfo = iMMessage;
            this.mPostion = i;
        }

        public void onCopyClick() {
            IMLog.m10024i("onCopyClick", new Object[0]);
            try {
                ClipboardManager clipboardManager = (ClipboardManager) MessageAdapter.this.f10956v.getSystemService("clipboard");
                if (Build.VERSION.SDK_INT >= 11) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("data", this.mMsgInfo.getContent()));
                } else {
                    clipboardManager.setText(this.mMsgInfo.getContent());
                }
            } catch (Exception e) {
                IMLog.m10020d("copy_err", e.getMessage());
            }
        }

        public void onDelClick() {
            IMLog.m10024i("onDelClick", new Object[0]);
            IMManager.getInstance().deleteMessage(this.mMsgInfo, new IMMessageCallback() {
                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                }

                public void onReceive(List<IMMessage> list) {
                }

                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    if (i == 401) {
                        try {
                            MessageAdapter.this.m9571a(OperateItemClickListener.this.mMsgInfo, OperateItemClickListener.this.mPostion);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (MessageAdapter.this.getLastMessage() == null) {
                            IMMessage iMMessage2 = new IMMessage(65536);
                            iMMessage2.setContent("");
                            iMMessage2.setCreateTime(iMMessage.getCreateTime());
                            iMMessage2.setSid(iMMessage.getSid());
                            IMManager.getInstance().updateSession(iMMessage2);
                            return;
                        }
                        return;
                    }
                    IMToastHelper.showLongError((Context) MessageAdapter.this.f10956v, MessageAdapter.this.f10956v.getString(R.string.bts_im_delete_msg_fail));
                }
            });
        }

        public void onAddWordClick() {
            IMLog.m10024i("onAddWordClick", new Object[0]);
            if (MessageAdapter.this.f10948I != null) {
                MessageAdapter.this.f10948I.showAddCustomWordDialog(this.mMsgInfo.getContent(), 3);
                IMMsgOmega.getInstance().track("ddim_dy_all_buble_ck", (Map<String, Object>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m9571a(IMMessage iMMessage, int i) {
        int i2;
        int size = this.f10954t.size();
        int i3 = i - 1;
        if (i3 >= 0 && ((IMMessage) this.f10954t.get(i3)).getType() == 107) {
            int i4 = i + 1;
            if (i4 >= size) {
                this.f10954t.remove(i3);
            } else if (((IMMessage) this.f10954t.get(i4)).getType() == 107) {
                this.f10954t.remove(i3);
            } else {
                ((IMMessage) this.f10954t.get(i3)).setCreateTime(((IMMessage) this.f10954t.get(i4)).getCreateTime());
            }
        } else if (i3 >= 0 && ((IMMessage) this.f10954t.get(i3)).getType() != 107 && (i2 = i + 1) < size && ((IMMessage) this.f10954t.get(i2)).getType() != 107 && IMDateUtil.needDisplayTime(Long.valueOf(((IMMessage) this.f10954t.get(i3)).getCreateTime()), Long.valueOf(((IMMessage) this.f10954t.get(i2)).getCreateTime()))) {
            IMMessage iMMessage2 = new IMMessage(107);
            iMMessage2.setCreateTime(((IMMessage) this.f10954t.get(i2)).getCreateTime());
            this.f10954t.add(i, iMMessage2);
        }
        this.f10954t.remove(iMMessage);
        if (this.f10954t.size() == 0) {
            EventBus.getDefault().post(new IMMessageEmptyEvent());
        }
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IMViewHolder iMViewHolder;
        this.f10959y = viewGroup;
        IMMessageActivity iMMessageActivity = this.f10956v;
        if (this.f10942B.contains(Integer.valueOf(i)) && m9567a() != null) {
            boolean c = m9581c(i);
            if (c) {
                i = m9572b(i, 16384);
            } else {
                i = m9572b(i, 32768);
            }
            IMLog.m10020d(f10919H, "get view by type " + i);
            IMViewHolder a = m9565a(i, c);
            if (!(a == null || a.mRenderView == null)) {
                a.mRenderView.setShowUserAvatar(this.f10960z);
            }
            if (a != null) {
                return a;
            }
        }
        Set<Integer> set = this.f10945E;
        if (!(set == null || !set.contains(Integer.valueOf(i)) || this.f10944D == null)) {
            boolean c2 = m9581c(i);
            if (c2) {
                r8 = m9572b(i, 16384);
            } else {
                r8 = m9572b(i, 32768);
            }
            IMLog.m10020d(f10919H, "[onCreateViewHolder] #MsgTypePlugin# get view by type " + i);
            IMViewHolder b = m9576b(i, c2);
            if (!(b == null || b.mRenderView == null)) {
                b.mRenderView.setShowUserAvatar(this.f10960z);
            }
            if (b != null) {
                return b;
            }
        }
        switch (i) {
            case 101:
                iMViewHolder = m9566a((IMBaseRenderView) new IMTextRenderView(iMMessageActivity, 2, this, this.f10950K));
                break;
            case 102:
                iMViewHolder = m9566a((IMBaseRenderView) new IMGifImageRenderView(iMMessageActivity, 2, this));
                break;
            case 103:
                iMViewHolder = m9566a((IMBaseRenderView) new IMAudioRenderView(iMMessageActivity, 2, this));
                break;
            case 104:
                iMViewHolder = m9566a((IMBaseRenderView) new IMTextRenderView(iMMessageActivity, 0, this, this.f10950K));
                break;
            case 105:
                iMViewHolder = m9566a((IMBaseRenderView) new IMGifImageRenderView(iMMessageActivity, 0, this));
                break;
            case 106:
                iMViewHolder = m9566a((IMBaseRenderView) new IMAudioRenderView(iMMessageActivity, 0, this));
                break;
            case 107:
                iMViewHolder = m9566a((IMBaseRenderView) new IMTimeRenderView(iMMessageActivity, this));
                break;
            case 108:
                iMViewHolder = m9566a((IMBaseRenderView) new IMOrderMsgRenderView(iMMessageActivity, 1, this));
                break;
            case 109:
                iMViewHolder = m9566a((IMBaseRenderView) new IMloadRenderView(iMMessageActivity, this));
                break;
            case 110:
                iMViewHolder = m9566a((IMBaseRenderView) new IMSingleTextRender(iMMessageActivity, 1, this));
                break;
            case 111:
                iMViewHolder = m9566a((IMBaseRenderView) new IMLocationRenderView(iMMessageActivity, 2, this));
                break;
            case 112:
                iMViewHolder = m9566a((IMBaseRenderView) new IMLocationRenderView(iMMessageActivity, 0, this));
                break;
            case 113:
                iMViewHolder = m9566a((IMBaseRenderView) new IMSysMsgRenderView(iMMessageActivity, 1, this, false));
                break;
            case 114:
                iMViewHolder = m9566a((IMBaseRenderView) new IMSysAudioMsgRenderView(iMMessageActivity, 1, this));
                break;
            default:
                switch (i) {
                    case 116:
                        iMViewHolder = m9566a((IMBaseRenderView) new IMImageRenderView(iMMessageActivity, 2, this));
                        break;
                    case 117:
                        iMViewHolder = m9566a((IMBaseRenderView) new IMImageRenderView(iMMessageActivity, 0, this));
                        break;
                    case 118:
                        iMViewHolder = m9566a((IMBaseRenderView) new IMRichInfoRenderView(iMMessageActivity, 2, this));
                        break;
                    case 119:
                        iMViewHolder = m9566a((IMBaseRenderView) new IMRichInfoRenderView(iMMessageActivity, 0, this));
                        break;
                    default:
                        switch (i) {
                            case 501:
                            case 502:
                            case 503:
                            case 504:
                                iMViewHolder = m9575b(i);
                                break;
                            default:
                                iMViewHolder = m9566a((IMBaseRenderView) new IMSysMsgRenderView(iMMessageActivity, 1, this, true));
                                break;
                        }
                }
        }
        if (!(iMViewHolder == null || iMViewHolder.mRenderView == null)) {
            iMViewHolder.mRenderView.setShowUserAvatar(this.f10960z);
        }
        return iMViewHolder;
    }

    /* renamed from: a */
    private IMViewHolder m9565a(int i, boolean z) {
        int i2 = 0;
        if (m9567a() == null) {
            IMLog.m10021e(f10919H, "cardProvider is null ! did you register the provider?");
            return null;
        }
        IMDynamicRegisterCardView iMDynamicRegisterCardView = new IMDynamicRegisterCardView(this.f10956v, 0, this, true);
        View view = m9567a().getView(this.f10956v, iMDynamicRegisterCardView, i);
        if (view == null) {
            IMLog.m10021e(f10919H, "the card view is null while datatype is " + i + "! please register non-empty view");
            return null;
        }
        if (!(view instanceof IMDynamicRegisterCard) || !((IMDynamicRegisterCard) view).isShowAvatar()) {
            i2 = 1;
        } else if (z) {
            i2 = 2;
        }
        iMDynamicRegisterCardView.addRegisterView(view, i2);
        IMViewHolder a = m9566a((IMBaseRenderView) iMDynamicRegisterCardView);
        a.setType(1);
        return a;
    }

    /* renamed from: b */
    private IMViewHolder m9576b(int i, boolean z) {
        int i2 = 1;
        if (this.f10944D == null) {
            IMLog.m10021e(f10919H, "[getPluginCardViewHolder] NULL plugin card view provider");
            return null;
        }
        IMPluginCardView iMPluginCardView = new IMPluginCardView(this.f10956v, 0, this, true);
        View view = this.f10944D.getView(this.f10956v, iMPluginCardView, i);
        if (view == null) {
            IMLog.m10021e(f10919H, "[getPluginCardViewHolder] the card view is null while datatype is " + i + "! please register non-empty view");
            return null;
        }
        if ((view instanceof IIMPluginCardView) && !((IIMPluginCardView) view).isShowInMiddle()) {
            i2 = z ? 2 : 0;
        }
        iMPluginCardView.addRegisterView(view, i2);
        IMViewHolder a = m9566a((IMBaseRenderView) iMPluginCardView);
        a.setType(2);
        return a;
    }

    /* renamed from: b */
    private IMViewHolder m9575b(int i) {
        IMBaseRenderView customChatRow;
        if (IMContextInfoHelper.getRegisterMessageCardView() == null || (customChatRow = IMContextInfoHelper.getRegisterMessageCardView().getCustomChatRow(i, this)) == null) {
            return null;
        }
        return new IMViewHolder(customChatRow);
    }

    /* renamed from: a */
    private IMViewHolder m9566a(IMBaseRenderView iMBaseRenderView) {
        return new IMViewHolder(iMBaseRenderView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IMMessage item;
        IMViewHolder iMViewHolder = (IMViewHolder) viewHolder;
        if (iMViewHolder != null && iMViewHolder.mRenderView != null && this.f10954t != null && (item = getItem(i)) != null) {
            IMUser userModel = getUserModel(item.getSenderUid());
            if (iMViewHolder.isExtendType()) {
                if (m9567a() != null) {
                    IMLog.m10020d(f10919H, "[onBindViewHolder] #MsgTypeExtend# bind extend card data");
                    m9567a().bindData(i, iMViewHolder.mRenderView.getCardView(), item.getContent(), item, this.f10952M);
                    iMViewHolder.mRenderView.setUpView(item, userModel, this, i);
                    m9567a().setCardViewStatusCallback(this.f10943C);
                }
            } else if (!iMViewHolder.isPluginType()) {
                iMViewHolder.mRenderView.setUpView(item, userModel, this, i);
            } else if (this.f10944D != null) {
                IMLog.m10020d(f10919H, "[onBindViewHolder] #MsgTypePlugin# bind extend card data");
                this.f10944D.bindData(i, iMViewHolder.mRenderView.getCardView(), item.getContent(), item, this.f10952M);
                iMViewHolder.mRenderView.setUpView(item, userModel, this, i);
                this.f10944D.setMessageViewStatusCallback(this.f10946F);
            }
        }
    }

    public IMMessage getItem(int i) {
        IMMessageList<IMMessage> iMMessageList = this.f10954t;
        if (iMMessageList == null || iMMessageList.size() == 0) {
            return null;
        }
        if (!this.f10957w && i >= this.f10954t.size()) {
            return null;
        }
        if (!this.f10957w || i <= 0) {
            return (IMMessage) this.f10954t.get(i);
        }
        return (IMMessage) this.f10954t.get(i - 1);
    }

    public IMMessage getItemNext(IMMessage iMMessage) {
        int indexOf;
        int i;
        IMMessageList<IMMessage> iMMessageList = this.f10954t;
        if (iMMessageList == null || iMMessageList.size() == 0 || (indexOf = this.f10954t.indexOf(iMMessage)) < 0 || (i = indexOf + 1) >= this.f10954t.size()) {
            return null;
        }
        return (IMMessage) this.f10954t.get(i);
    }

    public int getItemViewType(int i) {
        int i2;
        int i3;
        IMMessage item = getItem(i);
        if (item == null) {
            return -1;
        }
        if (i == 0 && this.f10957w) {
            return 109;
        }
        boolean z = item.getSenderUid() == IMContextInfoHelper.getUid();
        if (this.f10949J && !z && !item.isRead() && item.isMarkReadAsShown()) {
            IMMessageReadStatusManager.getInstance().addHasReadMsg(item);
            item.setIsRead(true);
        }
        if (item.getType() == 528385) {
            if (IMContextInfoHelper.getRegisterMessageCardView() == null) {
                return -1;
            }
            if (IMContextInfoHelper.getRegisterMessageCardView().getCustomChatRowType(item) > 0) {
                return IMContextInfoHelper.getRegisterMessageCardView().getCustomChatRowType(item);
            }
            int b = m9573b(item);
            if (z) {
                i3 = m9563a(b, 16384);
            } else {
                i3 = m9563a(b, 32768);
            }
            IMLog.m10021e(f10919H, C4786I.m9980t("[getItemViewType] #MsgTypeExtend# type=", Integer.valueOf(i3), " |isMine=", Boolean.valueOf(z)));
            if (i3 != -1) {
                this.f10942B.add(Integer.valueOf(i3));
                return i3;
            }
            IMLog.m10021e(f10919H, "register card failed! the type is -1,please check your type!");
        }
        if (item.getType() == 393223) {
            if (this.f10944D == null) {
                IMLog.m10021e(f10919H, C4786I.m9980t("[getItemViewType] #MsgTypePlugin# Null plugin card view provider."));
                return -1;
            }
            int c = m9578c(item);
            if (z) {
                i2 = m9563a(c, 16384);
            } else {
                i2 = m9563a(c, 32768);
            }
            IMLog.m10021e(f10919H, C4786I.m9980t("[getItemViewType] #MsgTypePlugin# pluginViewType=", Integer.valueOf(c), " |type=", Integer.valueOf(i2), " |isMine=", Boolean.valueOf(z)));
            if (i2 != -1) {
                this.f10945E.add(Integer.valueOf(i2));
                return i2;
            }
            IMLog.m10021e(f10919H, C4786I.m9980t("[getItemViewType] #MsgTypePlugin# register card failed! the type is -1,please check your type!"));
        }
        if (item.getType() == 10486017) {
            return z ? 111 : 112;
        }
        if (item.getType() == 65536 || item.getType() == 65537) {
            return z ? 101 : 104;
        }
        if (item.getType() == 393217) {
            return 113;
        }
        if (item.getType() == 393224) {
            return 114;
        }
        if (item.getType() == 107) {
            return 107;
        }
        if (item.getType() == 131072) {
            return z ? 103 : 106;
        }
        if (item.getType() == 327680) {
            return z ? 102 : 105;
        }
        if (item.getType() == 393220 || item.getType() == 393219) {
            return 108;
        }
        if (item.getType() == 196608) {
            return z ? 116 : 117;
        }
        if (item.getType() == 458752) {
            return z ? 118 : 119;
        }
        return 0;
    }

    public int getItemCount() {
        int i;
        IMMessageList<IMMessage> iMMessageList = this.f10954t;
        if (iMMessageList == null) {
            i = 0;
        } else {
            i = iMMessageList.size();
        }
        return this.f10957w ? i + 1 : i;
    }

    /* renamed from: a */
    private IMCustomCardViewBaseProvider m9567a() {
        IMMessageActivity iMMessageActivity;
        if (this.f10941A == null && (iMMessageActivity = this.f10956v) != null) {
            this.f10941A = IMEngine.getInstance(iMMessageActivity).getCurrentBusinessConfig(this.f10947G, this.mBusinessid).getCardViewProvider();
        }
        return this.f10941A;
    }

    /* renamed from: b */
    private int m9573b(IMMessage iMMessage) {
        String content;
        if (iMMessage == null || iMMessage.getType() != 528385 || (content = iMMessage.getContent()) == null) {
            return -1;
        }
        return Parser.parseViewType(content);
    }

    /* renamed from: c */
    private int m9578c(IMMessage iMMessage) {
        if (iMMessage == null || iMMessage.getType() != 393223) {
            return -1;
        }
        IMMessageDownExtend parsedMessageExtend = iMMessage.getParsedMessageExtend();
        if (parsedMessageExtend == null) {
            IMLog.m10021e(f10919H, C4786I.m9980t("[getPluginViewType] Invalid extend info"));
            return -1;
        }
        int pluginId = parsedMessageExtend.getPluginId();
        if (pluginId > 0) {
            return Parser.parsePluginViewType(pluginId);
        }
        IMLog.m10021e(f10919H, C4786I.m9980t("[getPluginViewType] Invalid plugin id : " + pluginId));
        return -1;
    }

    /* renamed from: b */
    private void m9577b() {
        this.f10943C = new IMCradViewStatusCallback() {
            public void onUpdate(int i, String str) {
                if (MessageAdapter.this.f10954t != null) {
                    IMMessage iMMessage = (IMMessage) MessageAdapter.this.f10954t.get(i);
                    iMMessage.setContent(str);
                    MessageAdapter.this.f10954t.remove(i);
                    MessageAdapter.this.f10954t.add(i, iMMessage);
                    MessageAdapter.this.notifyItemChanged(i);
                }
            }

            public void removeView(int i) {
                if (MessageAdapter.this.f10954t != null) {
                    MessageAdapter.this.f10954t.remove(i);
                    MessageAdapter.this.notifyItemChanged(i);
                }
            }
        };
    }

    /* renamed from: c */
    private void m9580c() {
        this.f10946F = new IMMessageViewStatusCallback() {
            public void onUpdate(int i, String str) {
                IMLog.m10020d(MessageAdapter.f10919H, C4786I.m9980t("[IMMessageViewStatusCallback] #onUpdate# position=", Integer.valueOf(i), " |data=", str));
            }

            public void deleteMessage(int i) {
                IMLog.m10020d(MessageAdapter.f10919H, C4786I.m9980t("[IMMessageViewStatusCallback] #deleteMessage# position=", Integer.valueOf(i)));
            }
        };
    }

    public void clearData() {
        if (m9567a() != null) {
            m9567a().removeCardViewStatusCallback(this.f10943C);
            m9567a().clear();
        }
        IMPluginCardViewProvider iMPluginCardViewProvider = this.f10944D;
        if (iMPluginCardViewProvider != null) {
            iMPluginCardViewProvider.removeMessageViewStatusCallback(this.f10946F);
            this.f10944D.clear();
        }
        List<Integer> list = this.f10942B;
        if (list != null) {
            list.clear();
        }
        Set<Integer> set = this.f10945E;
        if (set != null) {
            set.clear();
        }
    }

    public void setSessionInfo(boolean z, boolean z2) {
        this.f10949J = z;
        this.f10950K = z2;
    }

    public boolean getSupportStatus() {
        return this.f10949J;
    }

    public int getSessionType() {
        return this.f10947G;
    }

    public IMRenderCardEnv getRenderCardEnv() {
        return this.f10952M;
    }
}
