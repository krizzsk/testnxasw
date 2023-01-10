package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.style.custom.IMCustomContext;
import com.didi.beatles.p101im.access.style.custom.IMCustomViewHelper;
import com.didi.beatles.p101im.access.style.custom.msgcard.IMTextRenderCusView;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p101im.api.entity.IMTransBody;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IIMGlobalModule;
import com.didi.beatles.p101im.module.IMMessageCallBackImp;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.resource.IMThemeConstant;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMLinkMovementClickMethod;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.messageCard.IMTextRenderView */
public class IMTextRenderView extends IMBaseRenderView<IMTextRenderCusView> {

    /* renamed from: i */
    private static final String f12224i = "IMTextRenderView";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TextView f12225a;

    /* renamed from: b */
    private View f12226b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f12227c;

    /* renamed from: d */
    private TextView f12228d;

    /* renamed from: e */
    private boolean f12229e;

    /* renamed from: f */
    private ImageView f12230f;

    /* renamed from: g */
    private ProgressBar f12231g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LinearLayout f12232h;

    /* renamed from: j */
    private int f12233j = 0;

    /* renamed from: k */
    private int f12234k = 60;

    /* renamed from: l */
    private int f12235l = 56;

    /* renamed from: m */
    private int f12236m = 58;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f12237n = 57;

    /* renamed from: o */
    private List<View> f12238o = new ArrayList();

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    public IMTextRenderView(Context context, int i, MessageAdapter messageAdapter, boolean z) {
        super(context, i, messageAdapter);
        this.f12229e = z;
    }

    /* access modifiers changed from: protected */
    public IMTextRenderCusView createCustomView(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return IMCustomViewHelper.createTextRender(iMBusinessConfig, iMCustomContext);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        View tryLoadCustomView = tryLoadCustomView(viewGroup);
        if (tryLoadCustomView != null) {
            return tryLoadCustomView;
        }
        IMStyleManager.Style curBusinessStyle = IMStyleManager.getCurBusinessStyle();
        IMStyleManager.Style style = IMStyleManager.Style.GLOBAL_PSG;
        int i = R.layout.bts_im_mine_text_message_item;
        if (curBusinessStyle == style) {
            LayoutInflater layoutInflater = this.inflater;
            if (!this.isMine) {
                i = R.layout.bts_im_other_text_message_item_global_psg;
            }
            return layoutInflater.inflate(i, viewGroup, false);
        }
        LayoutInflater layoutInflater2 = this.inflater;
        if (!this.isMine) {
            i = R.layout.bts_im_other_text_message_item;
        }
        return layoutInflater2.inflate(i, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        if (!isCustomView()) {
            onFindViewByIdImpl();
        }
    }

    /* access modifiers changed from: protected */
    public void onFindViewByIdImpl() {
        this.f12225a = (TextView) findViewById(R.id.message_content);
        if (!this.isMine) {
            this.f12226b = findViewById(R.id.im_translate_divider);
            this.f12228d = (TextView) findViewById(R.id.im_translate_source_tv);
            this.f12227c = (TextView) findViewById(R.id.im_translate_text_tv);
            this.f12230f = (ImageView) findViewById(R.id.message_transtate_failed);
            this.f12231g = (ProgressBar) findViewById(R.id.message_transtate_progressBar);
            this.f12232h = (LinearLayout) findViewById(R.id.translate_ll);
        }
        if (this.isMine) {
            this.f12225a.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_black_bubble_selector));
            this.f12225a.setPadding(IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 9.0f), IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 9.0f));
            return;
        }
        findViewById(R.id.rl_bg).setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
        findViewById(R.id.rl_bg).setPadding(0, 0, 0, 0);
        this.f12225a.setPadding(IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 9.0f), IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 9.0f));
    }

    /* access modifiers changed from: protected */
    public void onUpdateView() {
        this.adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        if (isCustomView()) {
            ((IMTextRenderCusView) this.mCusViewRender).bindContent(iMMessage);
            this.mCusContentView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (IMTextRenderView.this.getClickListener() == null) {
                        return false;
                    }
                    IMTextRenderView.this.getClickListener().onBubbleLongClick(IMTextRenderView.this.mCusContentView, IMTextRenderView.this.position, IMTextRenderView.this.message);
                    return false;
                }
            });
            m10471a();
            return;
        }
        onSetUpViewImpl(iMMessage);
    }

    /* access modifiers changed from: protected */
    public void onSetUpViewImpl(IMMessage iMMessage) {
        String content = this.message.getContent();
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.message.getBusinessId());
        if (TextUtils.isEmpty(content)) {
            IMLog.m10026w("message content is empty!", new Object[0]);
            return;
        }
        if (this.isMine) {
            if (currentBusinessConfig.isUber()) {
                this.f12225a.setBackgroundResource(R.drawable.ub_other_imme_right_bg);
            } else {
                if (currentBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_SELF_TEXT_BG) != -1) {
                    this.f12225a.setBackgroundResource(currentBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_SELF_TEXT_BG));
                }
                if (currentBusinessConfig.getExtendColorResource(IMThemeConstant.IM_SELF_TEXT_FONT_COLOR) != -1) {
                    this.f12225a.setTextColor(getContext().getResources().getColor(currentBusinessConfig.getExtendColorResource(IMThemeConstant.IM_SELF_TEXT_FONT_COLOR)));
                }
            }
        }
        this.f12225a.setText(content);
        this.f12225a.setTextSize(0, (float) IMViewUtil.dp2px(this.context, (float) IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.adapter.getSessionType(), this.message.getBusinessId()).getTextSize()));
        this.f12225a.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (IMTextRenderView.this.getClickListener() == null) {
                    return false;
                }
                IMTextRenderView.this.getClickListener().onBubbleLongClick(IMTextRenderView.this.f12225a, IMTextRenderView.this.position, IMTextRenderView.this.message);
                return false;
            }
        });
        try {
            this.f12225a.setMovementMethod(IMLinkMovementClickMethod.getInstance());
            Linkify.addLinks(this.f12225a, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m10471a();
        if (!this.isMine) {
            m10477b();
            if (!this.f12229e || iMMessage.getMessageExtendInfo() == null || iMMessage.getMessageExtendInfo().trans == null) {
                m10472a(this.f12233j);
            } else {
                m10473a(iMMessage.getMessageExtendInfo().trans);
            }
        }
    }

    /* renamed from: a */
    private void m10471a() {
        IIMGlobalModule globalModel;
        IMMessageDownExtend parsedMessageExtend = this.message.getParsedMessageExtend();
        if (parsedMessageExtend != null && parsedMessageExtend.getEid() > 0 && parsedMessageExtend.getEggsDisplayCount() <= 0 && (globalModel = IMManager.getInstance().getGlobalModel()) != null) {
            IMLog.m10026w("handleEggsEffect!", new Object[0]);
            IMConfig.EggsInfo businessEggsInfo = globalModel.getBusinessEggsInfo(this.message.getBusinessId(), parsedMessageExtend.eid);
            parsedMessageExtend.setEggsDisplayCount(1);
            this.message.setMessageExtendInfo(parsedMessageExtend);
            IMManager.getInstance().updateMessage(this.message);
            if (businessEggsInfo != null && this.itemListener != null) {
                this.itemListener.onEggsMsgRender(businessEggsInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10473a(final IMTransBody iMTransBody) {
        if (iMTransBody == null) {
            m10472a(this.f12233j);
        } else if (iMTransBody.errno != 0) {
            m10472a(this.f12236m);
            this.f12227c.setSelected(true);
            this.f12227c.setText(IMResource.getString(R.string.im_translate_failed));
            this.f12232h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMMsgOmega.getInstance().track("ddim_hand_all_detail_ck", (Map<String, Object>) null);
                    IMTextRenderView.this.f12232h.setOnClickListener((View.OnClickListener) null);
                    if (IMManager.getInstance().getMessageModel() == null) {
                        IMLog.m10021e(IMTextRenderView.f12224i, "messagemodel is null while need translate by hand");
                        return;
                    }
                    IMManager.getInstance().getMessageModel().translateByHand(IMTextRenderView.this.message.getContent(), IMTextRenderView.this.message.getSid(), IMTextRenderView.this.message.getMid(), new IMMessageCallBackImp() {
                        public void onTranslateSucceed(IMTransBody iMTransBody) {
                            if (iMTransBody != null) {
                                IMTextRenderView.this.m10473a(iMTransBody);
                                return;
                            }
                            IMTransBody iMTransBody2 = new IMTransBody();
                            iMTransBody2.errno = 1;
                            IMTextRenderView.this.m10473a(iMTransBody2);
                        }
                    });
                    IMTextRenderView iMTextRenderView = IMTextRenderView.this;
                    iMTextRenderView.m10472a(iMTextRenderView.f12237n);
                    IMTextRenderView.this.f12227c.setText(IMResource.getString(R.string.im_translating));
                }
            });
        } else {
            this.f12227c.setSelected(false);
            if (TextUtils.isEmpty(iMTransBody.text)) {
                IMLog.m10020d(f12224i, "translate text is null ");
                m10472a(this.f12233j);
                return;
            }
            IMMessageDownExtend messageExtendInfo = this.message.getMessageExtendInfo();
            if (messageExtendInfo != null) {
                messageExtendInfo.trans = iMTransBody;
                this.message.setMessageExtendInfo(messageExtendInfo);
            }
            this.f12227c.setText(iMTransBody.text);
            if (IMStyleManager.getCurBusinessStyle() != IMStyleManager.Style.GLOBAL_PSG) {
                this.f12225a.setTextSize(0, IMResource.getDimension(R.dimen.im_12_sp, 12));
                this.f12227c.setTextSize(0, IMResource.getDimension(R.dimen.im_15_sp, 15));
            }
            if (TextUtils.isEmpty(iMTransBody.declare)) {
                m10472a(this.f12235l);
                IMLog.m10020d(f12224i, "translate declare is null");
                return;
            }
            m10472a(this.f12234k);
            this.f12228d.setText(iMTransBody.declare);
            this.f12228d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!TextUtils.isEmpty(iMTransBody.site)) {
                        IMCommonUtil.startUriActivity(IMTextRenderView.this.getContext(), iMTransBody.site);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private void m10477b() {
        if (this.f12238o.size() == 0) {
            this.f12238o.add(this.f12231g);
            this.f12238o.add(this.f12230f);
            this.f12238o.add(this.f12228d);
            this.f12238o.add(this.f12226b);
            this.f12238o.add(this.f12227c);
            this.f12238o.add(this.f12232h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10472a(int i) {
        List<View> list = this.f12238o;
        if (list != null && list.size() != 0) {
            int size = this.f12238o.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((i >> i2) & 1) == 1) {
                    this.f12238o.get(i2).setVisibility(0);
                } else {
                    this.f12238o.get(i2).setVisibility(8);
                }
            }
        }
    }
}
