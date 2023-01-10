package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.card.HighlightHelper;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.style.custom.IMCustomContext;
import com.didi.beatles.p101im.access.style.custom.IMCustomViewHelper;
import com.didi.beatles.p101im.access.style.custom.msgcard.IMSysOrderCusView;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.activity.IMMessageActivity;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.entity.IMHelperBody;
import com.didi.beatles.p101im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p101im.api.entity.IMRichInfo;
import com.didi.beatles.p101im.event.IMMessageSysCardShowEvent;
import com.didi.beatles.p101im.event.IMViewStreetImageEvent;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMExpoMtaManager;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMScreenUtil;
import com.didi.beatles.p101im.utils.IMStreetUtils;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.views.widget.richinfo.IMClickSpanListener;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.taxis99.R;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOrderMsgRenderView */
public class IMOrderMsgRenderView extends IMBaseRenderView<IMSysOrderCusView> {

    /* renamed from: a */
    private TextView f12178a;

    /* renamed from: b */
    private TextView f12179b;

    /* renamed from: c */
    private TextView f12180c;

    /* renamed from: d */
    private TextView f12181d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f12182e;

    /* renamed from: f */
    private LinearLayout f12183f;

    /* renamed from: g */
    private View f12184g;

    /* renamed from: h */
    private ImageView f12185h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMOrderStatusChangeBody f12186i;

    /* renamed from: j */
    private LinearLayout f12187j;

    /* renamed from: k */
    private ImageView f12188k;

    /* renamed from: l */
    private View f12189l;

    /* renamed from: m */
    private TextView f12190m;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMOrderMsgRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public IMSysOrderCusView createCustomView(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return IMCustomViewHelper.createSysOrder(iMBusinessConfig, iMCustomContext);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        tryLoadCustomView(viewGroup);
        if (this.mCusContentView != null) {
            return this.mCusContentView;
        }
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            return this.inflater.inflate(R.layout.bts_im_message_sys_global_psg, viewGroup, false);
        }
        return this.inflater.inflate(R.layout.bts_im_message_sys, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        if (!isCustomView()) {
            this.f12187j = (LinearLayout) findViewById(R.id.im_order_message_root);
            this.f12178a = (TextView) findViewById(R.id.im_order_message_title);
            this.f12179b = (TextView) findViewById(R.id.im_order_message_subtitle);
            this.f12180c = (TextView) findViewById(R.id.im_order_message_text);
            this.f12181d = (TextView) findViewById(R.id.im_order_message_text_to);
            this.f12182e = (TextView) findViewById(R.id.im_order_message_link);
            this.f12183f = (LinearLayout) findViewById(R.id.im_order_message_link_linear);
            this.f12184g = findViewById(R.id.divider);
            this.f12185h = (ImageView) findViewById(R.id.im_order_message_icon);
            this.f12179b.setTextColor(IMResource.getColor(R.color.im_color_sys_msg_sub_title));
            this.f12188k = (ImageView) findViewById(R.id.im_order_message_street_image);
            this.f12189l = findViewById(R.id.img_expired_street_view);
            this.f12190m = (TextView) findViewById(R.id.illegalTextOnPicture);
        }
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        if (this.message.getType() == 393219) {
            String content = this.message.getContent();
            if (!TextUtils.isEmpty(content)) {
                content = content.replace("\\n", "\n");
            }
            IMOrderStatusChangeBody iMOrderStatusChangeBody = (IMOrderStatusChangeBody) IMJsonUtil.objectFromJson(content, IMOrderStatusChangeBody.class);
            if (iMOrderStatusChangeBody == null) {
                iMOrderStatusChangeBody = new IMOrderStatusChangeBody().getDefaultBody();
            }
            setBody(iMOrderStatusChangeBody);
        } else if (this.message.getType() == 393220) {
            setBody(helpBodyToOrderBody((IMHelperBody) IMJsonUtil.objectFromJson(this.message.getContent(), IMHelperBody.class)));
        } else {
            IMOrderStatusChangeBody iMOrderStatusChangeBody2 = new IMOrderStatusChangeBody();
            iMOrderStatusChangeBody2.format_type = 1;
            iMOrderStatusChangeBody2.block.text = this.message.getContent();
            setBody(iMOrderStatusChangeBody2);
        }
        IMOrderStatusChangeBody iMOrderStatusChangeBody3 = this.f12186i;
        if (iMOrderStatusChangeBody3 != null) {
            iMMessage.linkType = iMOrderStatusChangeBody3.link_type;
        }
        EventBus.getDefault().post(new IMMessageSysCardShowEvent(iMMessage));
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        String str;
        if (!isCustomView()) {
            int i = 1;
            if (this.f12186i.alignStyle == 1 && this.f12186i.clickType == 1) {
                if (!this.message.isRead()) {
                    this.message.setIsRead(true);
                    this.adapter.updateItemState(this.message);
                    if (IMModelProvider.getInstance().getMessageModule() != null) {
                        IMModelProvider.getInstance().getMessageModule().updateMessageAsync(this.message);
                    }
                } else {
                    return;
                }
            }
            if (this.f12186i.link_type > 0) {
                if (this.f12186i.link_type == 1) {
                    int sourceId = ((IMMessageActivity) this.context).getSourceId();
                    if (this.f12186i.to_user_role == 1) {
                        String routeId = ((IMMessageActivity) this.context).getRouteId();
                        String string = this.context.getString(R.string.im_driver_detail_uri);
                        str = String.format(string, new Object[]{this.f12186i.oid + "", routeId, sourceId + ""});
                    } else {
                        String string2 = this.context.getString(R.string.im_passenger_detail_uri);
                        str = String.format(string2, new Object[]{this.f12186i.oid + "", sourceId + ""});
                    }
                } else if (this.f12186i.link_type == 2) {
                    String encode = Uri.encode(this.f12186i.link);
                    str = String.format(getResources().getString(R.string.im_web_uri), new Object[]{encode});
                } else if (this.f12186i.link_type == 5) {
                    str = this.f12186i.link;
                } else {
                    str = this.f12186i.link;
                }
                IMCommonUtil.startUriActivity(this.context, str, this.f12186i.extend);
            }
            if (this.f12186i.streetImage != null && !TextUtils.isEmpty(this.f12186i.streetImage.imageUrl) && !IMStreetUtils.isExpiredPic(this.message, this.f12186i)) {
                EventBus.getDefault().post(new IMViewStreetImageEvent(this.f12186i));
            }
            IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("ddim_message_sys_item_ck").add("product_id", Integer.valueOf(this.message.getBusinessId())).add("client_type", IMContextInfoHelper.getPackageName()).add("msg_type", Integer.valueOf(this.message.getType()));
            if (this.f12186i.link_type <= 0) {
                i = 0;
            }
            add.add("msg_link", Integer.valueOf(i)).add("send_uid", Long.valueOf(this.message.getSenderUid())).add("activity_id", Long.valueOf(this.message.getActivityId())).report();
        }
    }

    public void setBody(IMOrderStatusChangeBody iMOrderStatusChangeBody) {
        if (isCustomView()) {
            ((IMSysOrderCusView) this.mCusViewRender).bindSysContent(this.message, iMOrderStatusChangeBody);
            return;
        }
        this.f12186i = iMOrderStatusChangeBody;
        if (iMOrderStatusChangeBody != null && iMOrderStatusChangeBody.block != null) {
            if (!TextUtils.isEmpty(this.f12186i.icon)) {
                IMViewUtil.show((View) this.f12185h);
                BtsImageLoader.getInstance().loadInto(this.f12186i.icon, this.f12185h);
            } else {
                IMViewUtil.hide((View) this.f12185h);
            }
            if (!TextUtils.isEmpty(this.f12186i.title)) {
                this.f12178a.setText(this.f12186i.title);
                this.f12178a.setVisibility(0);
            } else {
                this.f12178a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f12186i.subtitle)) {
                this.f12179b.setText(this.f12186i.subtitle);
                this.f12179b.setVisibility(0);
            } else {
                this.f12179b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f12186i.tcolor)) {
                this.f12178a.setTextColor(Color.parseColor(this.f12186i.tcolor));
            } else {
                this.f12178a.setTextColor(IMResource.getColor(R.color.im_color_sys_msg_title));
            }
            if (this.f12186i.format_type == 1) {
                m10454a(false);
                this.f12180c.setVisibility(8);
                this.f12181d.setPadding(IMViewUtil.dp2px(getContext(), 16.0f), IMViewUtil.dp2px(getContext(), 7.0f), IMViewUtil.dp2px(getContext(), 18.0f), 0);
                this.f12181d.setSingleLine(false);
                this.f12181d.setMaxLines(Integer.MAX_VALUE);
                if (!TextUtils.isEmpty(this.f12186i.block.ext_text)) {
                    this.f12181d.setText(HighlightHelper.processIMHighlight(this.f12186i.block.ext_text));
                } else {
                    this.f12181d.setText(this.f12186i.block.text);
                }
            } else if (this.f12186i.format_type == 2) {
                m10454a(true);
                this.f12180c.setVisibility(0);
                this.f12181d.setPadding(IMViewUtil.dp2px(getContext(), 18.0f), 0, IMViewUtil.dp2px(getContext(), 18.0f), 0);
                this.f12181d.setSingleLine(true);
                this.f12181d.setEllipsize(TextUtils.TruncateAt.END);
                this.f12180c.setText(this.f12186i.block.from);
                this.f12181d.setText(this.f12186i.block.f10964to);
            }
            m10457c();
            m10453a();
        }
    }

    /* renamed from: a */
    private void m10453a() {
        if (this.f12186i.streetImage == null || this.message == null) {
            IMViewUtil.hide((View) this.f12188k);
        } else if (!TextUtils.isEmpty(this.f12186i.streetImage.imageUrl)) {
            this.f12187j.setClickable(true);
            int screenWidth = IMScreenUtil.instance(this.context).getScreenWidth();
            if (IMStreetUtils.isExpiredPic(this.message, this.f12186i)) {
                IMViewUtil.hide((View) this.f12188k);
                IMViewUtil.show(this.f12189l);
                IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.message.getBusinessId());
                if (currentBusinessConfig != null && !TextUtils.isEmpty(currentBusinessConfig.getIllegalTextOnPicture())) {
                    this.f12190m.setText(currentBusinessConfig.getIllegalTextOnPicture());
                }
                if (this.f12186i.streetImage.width != 0) {
                    this.f12189l.getLayoutParams().height = (screenWidth * this.f12186i.streetImage.height) / this.f12186i.streetImage.width;
                    return;
                }
                return;
            }
            IMViewUtil.show((View) this.f12188k);
            IMViewUtil.hide(this.f12189l);
            try {
                if (this.f12186i.streetImage.width != 0) {
                    this.f12188k.getLayoutParams().height = (screenWidth * this.f12186i.streetImage.height) / this.f12186i.streetImage.width;
                }
            } catch (Exception e) {
                String str = TAG;
                IMLog.m10020d(str, "IMOrderMsgRenderView Can't parse streetImage's height Exception " + e.getMessage());
            }
            BtsImageLoader.getInstance().loadInto((Object) this.f12186i.streetImage.imageUrl, (View) this.f12188k, (int) R.drawable.im_picture_ic_image);
            m10456b();
        } else {
            IMViewUtil.hide(this.f12189l);
            IMViewUtil.hide((View) this.f12188k);
        }
    }

    /* renamed from: b */
    private void m10456b() {
        HashMap hashMap = new HashMap();
        hashMap.put("client_type", IMContextInfoHelper.getPackageName());
        IMExpoMtaManager.getInstance().mtaExpo("wyc_ddim_sysmsg_streetview_sw", hashMap);
    }

    /* renamed from: c */
    private void m10457c() {
        if (this.f12186i.alignStyle == 2) {
            m10458d();
            return;
        }
        LinearLayout linearLayout = this.f12183f;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (this.f12186i.link_type <= 0 || TextUtils.isEmpty(this.f12186i.link)) {
            m10460f();
            this.f12187j.setClickable(false);
            return;
        }
        m10459e();
        this.f12182e.setText(this.f12186i.anchor_text);
        this.f12182e.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12182e.getLayoutParams();
        if (this.f12186i.alignStyle == 1) {
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            if (!TextUtils.isEmpty(this.f12186i.anchorIcon) && this.f12186i.clickType == 0) {
                BtsImageLoader.getInstance().download(this.f12186i.anchorIcon, new Callback() {
                    public void onFailed() {
                    }

                    public void onStart() {
                    }

                    public void onSuccess(Bitmap bitmap) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(IMOrderMsgRenderView.this.getResources(), bitmap);
                        bitmapDrawable.setBounds(0, 0, IMViewUtil.dp2px(IMOrderMsgRenderView.this.getContext(), 15.0f), IMViewUtil.dp2px(IMOrderMsgRenderView.this.getContext(), 15.0f));
                        IMOrderMsgRenderView.this.f12182e.setCompoundDrawablePadding(IMViewUtil.dp2px(IMOrderMsgRenderView.this.getContext(), 8.0f));
                        IMOrderMsgRenderView.this.f12182e.setCompoundDrawables(bitmapDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                });
            }
            this.f12182e.setLayoutParams(layoutParams);
            this.f12182e.setTextColor(getResources().getColorStateList(R.color.im_system_action_color_select));
        } else if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            layoutParams.width = -2;
            layoutParams.gravity = 16;
            this.f12182e.setLayoutParams(layoutParams);
            Drawable drawable = getResources().getDrawable(R.drawable.bts_im_order_status_link_global_psg);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f12182e.setCompoundDrawablePadding(IMViewUtil.dp2px(getContext(), 4.0f));
            this.f12182e.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.f12182e.setTextColor(Color.parseColor("#5C6166"));
        } else {
            layoutParams.width = -1;
            layoutParams.gravity = 16;
            this.f12182e.setLayoutParams(layoutParams);
            Drawable drawable2 = getResources().getDrawable(R.drawable.bts_im_order_status_link);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f12182e.setCompoundDrawablePadding(IMViewUtil.dp2px(getContext(), 8.0f));
            this.f12182e.setCompoundDrawables((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
            this.f12182e.setTextColor(IMResource.getColor(R.color.im_tv_gray_light));
        }
        if (this.message.isRead()) {
            this.f12182e.setEnabled(false);
            this.f12187j.setClickable(false);
            return;
        }
        this.f12182e.setEnabled(true);
        this.f12187j.setClickable(true);
    }

    /* renamed from: d */
    private void m10458d() {
        this.f12182e.setVisibility(8);
        LinearLayout linearLayout = this.f12183f;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.f12183f.removeAllViews();
            if (this.f12186i.btnGroup != null) {
                for (int i = 0; i < this.f12186i.btnGroup.size(); i++) {
                    IMRichInfo iMRichInfo = this.f12186i.btnGroup.get(i);
                    if (iMRichInfo != null) {
                        if (i != 0) {
                            View view = new View(this.context);
                            view.setBackgroundColor(Color.parseColor("#f5f5f5"));
                            this.f12183f.addView(view, new LinearLayout.LayoutParams(2, -1));
                        }
                        TextView textView = new TextView(this.context);
                        iMRichInfo.bindView(textView);
                        textView.setGravity(17);
                        this.f12183f.addView(textView, new LinearLayout.LayoutParams(0, -1, 1.0f));
                        final String str = i + "";
                        iMRichInfo.setClickSpanListener(new IMClickSpanListener() {
                            public void spanClicked(View view, String str) {
                                IMTraceUtil.addBusinessEvent("beat_p_imrpt_succard_ck").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add("anal_txt", IMOrderMsgRenderView.this.f12186i.extend != null ? IMOrderMsgRenderView.this.f12186i.extend.analTxt : "").add(ParamConst.SUG_CK_INDEX, str).report();
                            }
                        });
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private void m10459e() {
        View view = this.f12184g;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f12182e.setVisibility(0);
    }

    /* renamed from: f */
    private void m10460f() {
        View view = this.f12184g;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f12182e.setVisibility(8);
    }

    /* renamed from: a */
    private void m10454a(boolean z) {
        Resources resources = getResources();
        if (z) {
            Drawable drawable = resources.getDrawable(R.drawable.bts_im_homepage_start_address);
            Drawable drawable2 = resources.getDrawable(R.drawable.bts_im_homepage_end_address);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f12180c.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f12181d.setCompoundDrawables(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.f12181d.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f12180c.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public IMOrderStatusChangeBody helpBodyToOrderBody(IMHelperBody iMHelperBody) {
        IMOrderStatusChangeBody iMOrderStatusChangeBody = new IMOrderStatusChangeBody();
        iMOrderStatusChangeBody.title = iMHelperBody.title;
        iMOrderStatusChangeBody.link_type = iMHelperBody.link_type;
        iMOrderStatusChangeBody.anchor_text = iMHelperBody.anchor_text;
        iMOrderStatusChangeBody.link = iMHelperBody.link;
        iMOrderStatusChangeBody.block.text = iMHelperBody.text;
        iMOrderStatusChangeBody.format_type = 1;
        iMOrderStatusChangeBody.alignStyle = 0;
        return iMOrderStatusChangeBody;
    }
}
