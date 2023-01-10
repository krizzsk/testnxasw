package com.didi.beatles.p101im.views.feed;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.card.HighlightHelper;
import com.didi.beatles.p101im.access.msg.OperationMsgT2;
import com.didi.beatles.p101im.access.utils.Parser;
import com.didi.beatles.p101im.api.entity.IMHelperBody;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMUserInfoCallback;
import com.didi.beatles.p101im.module.entity.IMFeedMessage;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMUser;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMDateUtil;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.views.imageView.IMCircleImageView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder */
public class IMListFeedVHolder extends IMListTraceVHolder {

    /* renamed from: a */
    private static final int f12106a = 2;

    /* renamed from: b */
    private static final String f12107b = "IMListFeedVHolder";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f12108c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlagCallback<IMSession> f12109d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlagCallback<IMFeedMessage> f12110e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LinearLayout f12111f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IMCircleImageView f12112g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f12113h;

    /* renamed from: i */
    private TextView f12114i;

    /* renamed from: j */
    private TabloidItem f12115j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMSession f12116k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public FeedListener f12117l;

    /* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder$FeedListener */
    public interface FeedListener {
        void clickMessage(IMFeedMessage iMFeedMessage, String str);

        void clickSession(IMSession iMSession);
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder$FlagCallback */
    public interface FlagCallback<T> {
        void addFlag(T t);

        void clear();

        boolean isFlag(T t);

        void removeFlag(T t);
    }

    public IMListFeedVHolder(Activity activity, ViewGroup viewGroup, FlagCallback<IMSession> flagCallback, FlagCallback<IMFeedMessage> flagCallback2) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item_feed, viewGroup, false));
        this.f12108c = activity;
        this.f12109d = flagCallback;
        this.f12110e = flagCallback2;
        m10388a();
    }

    /* renamed from: a */
    private void m10388a() {
        this.f12111f = (LinearLayout) this.itemView.findViewById(R.id.feed_item_group);
        this.f12112g = (IMCircleImageView) this.itemView.findViewById(R.id.feed_title_avatar);
        this.f12113h = (TextView) this.itemView.findViewById(R.id.feed_title_name);
        this.f12114i = (TextView) this.itemView.findViewById(R.id.feed_title_time);
        this.itemView.findViewById(R.id.feed_title_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMTraceUtil.addBusinessEvent("ddim_service_convergecard_title_ck").add("product_id", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("no_appid", Long.valueOf(IMListFeedVHolder.this.f12116k.getPeerUid())).report();
                if (IMListFeedVHolder.this.f12117l != null) {
                    IMListFeedVHolder.this.f12117l.clickSession(IMListFeedVHolder.this.f12116k);
                }
            }
        });
    }

    public void bindData(IMSession iMSession, FeedListener feedListener) {
        ArrayList arrayList;
        int i;
        OperationMsgT2 operationMsgT2;
        this.f12116k = iMSession;
        this.f12117l = feedListener;
        m10394b();
        this.f12111f.removeAllViews();
        List<IMFeedMessage> recentMessageList = iMSession.getRecentMessageList();
        ArrayList arrayList2 = null;
        if (recentMessageList == null || recentMessageList.isEmpty()) {
            arrayList = null;
        } else {
            arrayList2 = new ArrayList(recentMessageList.size());
            arrayList = new ArrayList(recentMessageList.size());
            for (IMFeedMessage next : recentMessageList) {
                String content = next.getContent();
                if (!TextUtils.isEmpty(content) && Parser.parseType(content) == 1) {
                    int parseTemplate = Parser.parseTemplate(content);
                    if ((parseTemplate == 1 || parseTemplate == 2) && (operationMsgT2 = (OperationMsgT2) IMJsonUtil.objectFromJson(content, OperationMsgT2.class)) != null) {
                        arrayList2.add(next);
                        arrayList.add(operationMsgT2);
                    }
                }
            }
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            m10396c();
            return;
        }
        OperationMsgT2 operationMsgT22 = (OperationMsgT2) arrayList.get(0);
        if (TextUtils.isEmpty(operationMsgT22.image) || TextUtils.isEmpty(operationMsgT22.action)) {
            i = 0;
        } else {
            m10389a(0, (IMFeedMessage) arrayList2.get(0), (OperationMsgT2) arrayList.get(0));
            i = 1;
        }
        while (i < 2 && i < arrayList2.size()) {
            m10390a(i, (IMFeedMessage) arrayList2.get(i), (OperationMsgT2) arrayList.get(i), i == arrayList2.size() - 1);
            i++;
        }
        if (i < arrayList2.size()) {
            m10391a(i, (List<IMFeedMessage>) arrayList2.subList(i, arrayList2.size()), (List<OperationMsgT2>) arrayList.subList(i, arrayList2.size()));
        }
    }

    /* renamed from: b */
    private void m10394b() {
        List<Long> userIds = this.f12116k.getUserIds();
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userIds.size() == 2 && userModel != null) {
            userModel.getUserInfo(new long[]{userIds.get(0).longValue(), userIds.get(1).longValue()}, (IMUserInfoCallback) new IMUserInfoCallback() {
                public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
                    if (jArr.length == 2 && IMListFeedVHolder.this.f12116k.getUserIds().size() == 2 && jArr[0] == IMListFeedVHolder.this.f12116k.getUserIds().get(0).longValue() && jArr[1] == IMListFeedVHolder.this.f12116k.getUserIds().get(1).longValue() && IMListFeedVHolder.this.f12108c != null && !IMListFeedVHolder.this.f12108c.isFinishing()) {
                        IMUser iMUser = null;
                        if (hashMap != null) {
                            iMUser = hashMap.get(IMSession.getPeerId(IMListFeedVHolder.this.f12116k.getUserIds()));
                        }
                        if (iMUser == null) {
                            IMListFeedVHolder.this.f12113h.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_helper_name_default));
                            IMListFeedVHolder.this.f12112g.setImageResource(R.drawable.bts_im_general_default_avatar);
                            return;
                        }
                        if (!TextUtils.isEmpty(iMUser.getNickName())) {
                            IMListFeedVHolder.this.f12113h.setText(iMUser.getNickName());
                        } else {
                            IMListFeedVHolder.this.f12113h.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_helper_name_default));
                        }
                        if (!TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                            BtsImageLoader.getInstance().loadInto((Object) iMUser.getAvatarUrl(), (View) IMListFeedVHolder.this.f12112g, (int) R.drawable.bts_im_general_default_avatar);
                            return;
                        }
                        IMListFeedVHolder.this.f12112g.setImageResource(R.drawable.bts_im_general_default_avatar);
                    }
                }
            }, false);
            this.f12114i.setText(IMDateUtil.getFeedTimeDiffDesc(new Date(this.f12116k.getLastModifyTime())));
        }
    }

    /* renamed from: c */
    private void m10396c() {
        this.f12111f.addView(new SimpleItem().bindData());
    }

    /* renamed from: a */
    private void m10389a(int i, IMFeedMessage iMFeedMessage, OperationMsgT2 operationMsgT2) {
        if (this.f12115j == null) {
            this.f12115j = new TabloidItem();
        }
        this.f12111f.addView(this.f12115j.bindData(i, iMFeedMessage, operationMsgT2));
    }

    /* renamed from: a */
    private void m10390a(int i, IMFeedMessage iMFeedMessage, OperationMsgT2 operationMsgT2, boolean z) {
        if (TextUtils.isEmpty(operationMsgT2.action)) {
            this.f12111f.addView(new FullItem().bindData(i, iMFeedMessage, operationMsgT2, z));
        } else {
            this.f12111f.addView(new TextItem().bindData(i, iMFeedMessage, operationMsgT2, z));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10391a(int i, List<IMFeedMessage> list, List<OperationMsgT2> list2) {
        if (this.f12109d.isFlag(this.f12116k)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                int i3 = i + i2;
                IMFeedMessage iMFeedMessage = list.get(i2);
                OperationMsgT2 operationMsgT2 = list2.get(i2);
                boolean z = true;
                if (i2 != list.size() - 1) {
                    z = false;
                }
                m10390a(i3, iMFeedMessage, operationMsgT2, z);
            }
            return;
        }
        this.f12111f.addView(new MoreItem().bindData(i, list, list2));
    }

    public void traceHolder() {
        String str;
        List<IMFeedMessage> recentMessageList = this.f12116k.getRecentMessageList();
        String str2 = "";
        if (recentMessageList != null) {
            if (!this.f12109d.isFlag(this.f12116k)) {
                recentMessageList = recentMessageList.subList(0, Math.min(2, recentMessageList.size()));
            }
            ArrayList arrayList = new ArrayList(recentMessageList.size());
            ArrayList arrayList2 = new ArrayList(recentMessageList.size());
            for (IMFeedMessage next : recentMessageList) {
                arrayList.add(next.getActivityId() + str2);
                arrayList2.add(next.getCloudUniqueMsgId() + str2);
            }
            str2 = mo49144a(arrayList);
            str = mo49144a(arrayList2);
        } else {
            str = str2;
        }
        IMTraceUtil.addBusinessEvent("ddim_service_convergecard_sw").add("product_id", Integer.valueOf(this.f12116k.getBusinessId())).add("no_appid", Long.valueOf(this.f12116k.getPeerUid())).add("activity_id", str2).add("uniq_msg_id_list", str).report();
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder$SimpleItem */
    private class SimpleItem extends TextItem {
        SimpleItem() {
            super();
            this.item.setOnClickListener((View.OnClickListener) null);
            this.arrow.setVisibility(8);
            this.line.setVisibility(8);
        }

        /* access modifiers changed from: package-private */
        public View bindData() {
            String str;
            IMHelperBody iMHelperBody = (IMHelperBody) IMJsonUtil.objectFromJson(IMListFeedVHolder.this.f12116k.getLastMessage(), IMHelperBody.class);
            if (iMHelperBody != null) {
                str = iMHelperBody.title;
            } else if (TextUtils.isEmpty(IMListFeedVHolder.this.f12116k.getLastMessage())) {
                str = IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_last_msg);
            } else {
                str = IMListFeedVHolder.this.f12116k.getLastMessage();
            }
            this.txt.setText(str);
            return this.item;
        }
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder$TabloidItem */
    private class TabloidItem {
        private ImageView img;
        /* access modifiers changed from: private */
        public int index;
        private View item;
        /* access modifiers changed from: private */
        public IMFeedMessage message;
        /* access modifiers changed from: private */
        public OperationMsgT2 operation;
        private TextView tip = ((TextView) this.item.findViewById(R.id.im_feed_op_txt));

        TabloidItem() {
            View inflate = LayoutInflater.from(IMListFeedVHolder.this.itemView.getContext()).inflate(R.layout.im_list_item_feed_tabloid, IMListFeedVHolder.this.f12111f, false);
            this.item = inflate;
            this.img = (ImageView) inflate.findViewById(R.id.im_feed_op_img);
            this.item.setOnClickListener(new View.OnClickListener(IMListFeedVHolder.this) {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMTraceUtil.addBusinessEvent("ddim_service_convergecard_ck").add("product_id", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("no_appid", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("activity_id", Long.valueOf(TabloidItem.this.message.getActivityId())).add("uniq_msg_id", TabloidItem.this.message.getCloudUniqueMsgId()).add("position", Integer.valueOf(TabloidItem.this.index)).report();
                    if (IMListFeedVHolder.this.f12117l != null) {
                        IMListFeedVHolder.this.f12117l.clickMessage(TabloidItem.this.message, TabloidItem.this.operation.action);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public View bindData(int i, IMFeedMessage iMFeedMessage, OperationMsgT2 operationMsgT2) {
            this.index = i;
            this.message = iMFeedMessage;
            this.operation = operationMsgT2;
            this.tip.setText(operationMsgT2.title);
            int windowWidth = IMViewUtil.getWindowWidth(IMListFeedVHolder.this.itemView.getContext());
            ViewGroup.LayoutParams layoutParams = this.img.getLayoutParams();
            layoutParams.width = windowWidth;
            if (operationMsgT2.imageWidth == 0 || operationMsgT2.imageHeight == 0) {
                layoutParams.height = (windowWidth * 278) / 750;
            } else {
                layoutParams.height = (int) (((float) windowWidth) * (((float) operationMsgT2.imageHeight) / ((float) operationMsgT2.imageWidth)));
            }
            this.img.setLayoutParams(layoutParams);
            this.img.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_onemessage_imagebg));
            if (operationMsgT2.image.endsWith(".gif")) {
                BtsImageLoader.getInstance().loadIntoAsGif(operationMsgT2.image, this.img, new Callback() {
                    public void onFailed() {
                    }

                    public void onStart() {
                    }

                    public void onSuccess(Bitmap bitmap) {
                    }
                });
            } else {
                BtsImageLoader.getInstance().loadInto((Object) operationMsgT2.image, (View) this.img, IMResource.getDrawableID(R.drawable.im_nomix_onemessage_imagebg));
            }
            return this.item;
        }
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder$FullItem */
    private class FullItem {
        private final int LIMIT_LINE = 2;
        private TextView btn;
        private TextView content;
        /* access modifiers changed from: private */
        public int index;
        private View item;
        private View line;
        /* access modifiers changed from: private */
        public IMFeedMessage message;
        private TextView title;

        FullItem() {
            View inflate = LayoutInflater.from(IMListFeedVHolder.this.itemView.getContext()).inflate(R.layout.im_list_item_feed_full, IMListFeedVHolder.this.f12111f, false);
            this.item = inflate;
            this.title = (TextView) inflate.findViewById(R.id.im_feed_full_title);
            this.content = (TextView) this.item.findViewById(R.id.im_feed_full_content);
            this.line = this.item.findViewById(R.id.im_feed_btm_line);
            this.btn = (TextView) this.item.findViewById(R.id.im_feed_full_btn);
            this.item.setOnClickListener(new View.OnClickListener(IMListFeedVHolder.this) {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMTraceUtil.addBusinessEvent("ddim_service_convergecard_ck").add("product_id", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("no_appid", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("activity_id", Long.valueOf(FullItem.this.message.getActivityId())).add("uniq_msg_id", FullItem.this.message.getCloudUniqueMsgId()).add("position", Integer.valueOf(FullItem.this.index)).report();
                }
            });
            this.btn.setOnClickListener(new View.OnClickListener(IMListFeedVHolder.this) {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMTraceUtil.addBusinessEvent(IMListFeedVHolder.this.f12110e.isFlag(FullItem.this.message) ? "ddim_service_convergecard_retract_ck" : "ddim_service_convergecard_whole_ck").add("product_id", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("no_appid", Long.valueOf(IMListFeedVHolder.this.f12116k.getPeerUid())).add("activity_id", Long.valueOf(FullItem.this.message.getActivityId())).report();
                    if (IMListFeedVHolder.this.f12110e.isFlag(FullItem.this.message)) {
                        IMListFeedVHolder.this.f12110e.removeFlag(FullItem.this.message);
                        FullItem.this.limitContent();
                        return;
                    }
                    IMListFeedVHolder.this.f12110e.addFlag(FullItem.this.message);
                    FullItem.this.limitContent();
                }
            });
        }

        /* access modifiers changed from: package-private */
        public View bindData(int i, IMFeedMessage iMFeedMessage, OperationMsgT2 operationMsgT2, boolean z) {
            this.index = i;
            this.message = iMFeedMessage;
            this.title.setText(operationMsgT2.title);
            this.content.setText(HighlightHelper.processHighlight(operationMsgT2.content));
            this.line.setVisibility(z ? 8 : 0);
            if (!isNeedLimit(operationMsgT2.content)) {
                IMListFeedVHolder.this.f12110e.addFlag(iMFeedMessage);
                this.btn.setVisibility(8);
            } else {
                this.btn.setVisibility(0);
            }
            limitContent();
            return this.item;
        }

        private boolean isNeedLimit(String str) {
            return new StaticLayout(str, this.content.getPaint(), IMViewUtil.getWindowWidth(this.content.getContext()) - IMViewUtil.dp2px(this.content.getContext(), 40.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() > 2;
        }

        /* access modifiers changed from: private */
        public void limitContent() {
            if (IMListFeedVHolder.this.f12110e.isFlag(this.message)) {
                this.content.setMaxLines(Integer.MAX_VALUE);
                this.content.setEllipsize((TextUtils.TruncateAt) null);
                this.btn.setText(this.item.getResources().getString(R.string.im_feed_limit_text));
                return;
            }
            this.content.setMaxLines(2);
            this.content.setEllipsize(TextUtils.TruncateAt.END);
            this.btn.setText(this.item.getResources().getString(R.string.im_feed_full_text));
        }
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder$TextItem */
    private class TextItem {
        View arrow = this.item.findViewById(R.id.im_feed_arrow);
        /* access modifiers changed from: private */
        public int index;
        View item;
        View line = this.item.findViewById(R.id.im_feed_line);
        /* access modifiers changed from: private */
        public IMFeedMessage message;
        /* access modifiers changed from: private */
        public OperationMsgT2 operation;
        TextView txt;

        TextItem() {
            View inflate = LayoutInflater.from(IMListFeedVHolder.this.itemView.getContext()).inflate(R.layout.im_list_item_feed_text, IMListFeedVHolder.this.f12111f, false);
            this.item = inflate;
            this.txt = (TextView) inflate.findViewById(R.id.im_feed_txt);
            this.item.setOnClickListener(new View.OnClickListener(IMListFeedVHolder.this) {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMTraceUtil.addBusinessEvent("ddim_service_convergecard_ck").add("product_id", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("no_appid", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("activity_id", Long.valueOf(TextItem.this.message.getActivityId())).add("uniq_msg_id", TextItem.this.message.getCloudUniqueMsgId()).add("position", Integer.valueOf(TextItem.this.index)).report();
                    if (IMListFeedVHolder.this.f12117l != null) {
                        IMListFeedVHolder.this.f12117l.clickMessage(TextItem.this.message, TextItem.this.operation.action);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public View bindData(int i, IMFeedMessage iMFeedMessage, OperationMsgT2 operationMsgT2, boolean z) {
            this.index = i;
            this.message = iMFeedMessage;
            this.operation = operationMsgT2;
            this.txt.setText(operationMsgT2.title);
            this.line.setVisibility(z ? 8 : 0);
            return this.item;
        }
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListFeedVHolder$MoreItem */
    private class MoreItem implements View.OnClickListener {
        private int index;
        private View item;
        private List<IMFeedMessage> messageList;
        private TextView more = ((TextView) this.item.findViewById(R.id.im_feed_more));
        private List<OperationMsgT2> operationList;

        MoreItem() {
            View inflate = LayoutInflater.from(IMListFeedVHolder.this.itemView.getContext()).inflate(R.layout.im_list_item_feed_more, IMListFeedVHolder.this.f12111f, false);
            this.item = inflate;
            inflate.setOnClickListener(this);
        }

        /* access modifiers changed from: package-private */
        public View bindData(int i, List<IMFeedMessage> list, List<OperationMsgT2> list2) {
            this.index = i;
            this.messageList = list;
            this.operationList = list2;
            if (list.size() == 1) {
                this.more.setText(IMListFeedVHolder.this.itemView.getResources().getString(R.string.im_feed_more_one));
            } else {
                this.more.setText(IMListFeedVHolder.this.itemView.getResources().getString(R.string.im_feed_more, new Object[]{String.valueOf(list.size())}));
            }
            return this.item;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            IMTraceUtil.addBusinessEvent("ddim_service_convergecard_more_ck").add("product_id", Integer.valueOf(IMListFeedVHolder.this.f12116k.getBusinessId())).add("no_appid", Long.valueOf(IMListFeedVHolder.this.f12116k.getPeerUid())).report();
            IMListFeedVHolder.this.f12109d.addFlag(IMListFeedVHolder.this.f12116k);
            IMListFeedVHolder.this.f12111f.removeViewAt(IMListFeedVHolder.this.f12111f.getChildCount() - 1);
            IMListFeedVHolder.this.m10391a(this.index, this.messageList, this.operationList);
        }
    }
}
