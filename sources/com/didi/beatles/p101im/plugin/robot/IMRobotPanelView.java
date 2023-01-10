package com.didi.beatles.p101im.plugin.robot;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotGetConfigureResponse;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotPraise;
import com.didi.beatles.p101im.plugin.robot.utils.IMRobotTraceUtil;
import com.didi.beatles.p101im.plugin.robot.utils.IMRobotViewUtil;
import com.didi.beatles.p101im.plugin.robot.widget.IMRobotPraiseView;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.widget.IMToast;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotPanelView */
public class IMRobotPanelView extends FrameLayout implements IIMRobotPanelView, IMRobotPraiseView.PraiseActionListener {

    /* renamed from: a */
    private static final String f11338a = IMRobotPanelView.class.getSimpleName();

    /* renamed from: b */
    private static final boolean f11339b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMRobotPraiseView f11340c;

    /* renamed from: d */
    private ViewStub f11341d;

    /* renamed from: e */
    private View f11342e;

    /* renamed from: f */
    private View f11343f;

    /* renamed from: g */
    private ImageView f11344g;

    /* renamed from: h */
    private View f11345h;

    /* renamed from: i */
    private RecyclerView f11346i;

    /* renamed from: j */
    private Button f11347j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMRobotController f11348k;

    /* renamed from: l */
    private final IMActionInvokeEnv f11349l;

    /* renamed from: m */
    private final boolean f11350m;

    /* renamed from: n */
    private BottomTabRecyclerViewAdapter f11351n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f11352o = -1;

    public void onUnlockRobotSuccess(IMRobotGetConfigureResponse.Robot robot) {
    }

    static {
        IToggle toggle = Apollo.getToggle("IM_Config_Robot_Click_Guide");
        f11339b = toggle != null && toggle.allow();
        String str = f11338a;
        IMLog.m10024i(str, "apollo always show click guide=" + f11339b);
    }

    public IMRobotPanelView(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
        super(context);
        this.f11349l = iMActionInvokeEnv;
        this.f11350m = iMActionInvokeEnv.getPluginTheme() != 1 ? false : true;
        inflate(context, R.layout.im_plugin_robot_panel_view, this);
        m9841a();
        IMRobotController iMRobotController = new IMRobotController(this, iMActionInvokeEnv.getBusinessId(), iMActionInvokeEnv.getSessionId(), iMActionInvokeEnv.getOrderId(), iMActionInvokeEnv.getRobotGuideId());
        this.f11348k = iMRobotController;
        iMRobotController.loadConfigure();
    }

    /* renamed from: a */
    private void m9841a() {
        this.f11343f = findViewById(R.id.robot_panel_loading);
        this.f11344g = (ImageView) findViewById(R.id.robot_panel_loading_iv);
        this.f11340c = (IMRobotPraiseView) findViewById(R.id.im_plugin_robot_praise_view);
        this.f11341d = (ViewStub) findViewById(R.id.robot_panel_error_stub);
        this.f11345h = findViewById(R.id.im_plugin_robot_bottom_bar);
        this.f11347j = (Button) findViewById(R.id.im_plugin_robot_bottom_button);
        this.f11346i = (RecyclerView) findViewById(R.id.im_plugin_robot_bottom_recyclerView);
        if (this.f11350m) {
            this.f11344g.setImageResource(R.drawable.im_robot_loading_helper);
        } else {
            this.f11344g.setImageResource(R.drawable.im_robot_loading);
        }
        this.f11340c.setSelected(true);
        this.f11347j.setOnClickListener(new IMOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                IMRobotPanelView.this.m9848b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9848b() {
        this.f11340c.stopPlayAudio();
        IMRobotPraise currentPraise = this.f11340c.getCurrentPraise();
        if (currentPraise != null) {
            int i = currentPraise.type;
            if (i == 1) {
                IMRobotController iMRobotController = this.f11348k;
                if (iMRobotController != null) {
                    iMRobotController.sendRobotMessage(currentPraise, false);
                }
                IMRobotTraceUtil.traceSendRobotPraiseClick(currentPraise.robotId, currentPraise.praiseId);
            } else if (i == 2) {
                IMRobotController iMRobotController2 = this.f11348k;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IMLog.m10020d(f11338a, "[onDetachedFromWindow]");
    }

    public void onLoading() {
        IMRobotViewUtil.hide((View) this.f11340c);
        IMRobotViewUtil.hide(this.f11345h);
        IMRobotViewUtil.hide(this.f11342e);
        IMRobotViewUtil.show(this.f11343f);
    }

    public void onLoadConfigureFail() {
        if (this.f11342e == null) {
            View inflate = this.f11341d.inflate();
            this.f11342e = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.im_plugin_error_icon);
            if (this.f11350m) {
                imageView.setBackgroundResource(R.drawable.im_plugin_robot_icon_error_helper);
            } else {
                imageView.setBackgroundResource(R.drawable.im_plugin_robot_icon_error);
            }
            this.f11342e.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (IMRobotPanelView.this.f11348k != null) {
                        IMRobotPanelView.this.f11348k.loadConfigure();
                    }
                    IMRobotTraceUtil.tracePanelShowRetry();
                }
            });
        }
        IMRobotViewUtil.show(this.f11342e);
        IMRobotViewUtil.hide((View) this.f11340c);
        IMRobotViewUtil.hide(this.f11345h);
        IMRobotViewUtil.hide(this.f11343f);
        IMRobotTraceUtil.tracePanelShowFail();
    }

    public void onLoadConfigureSuccess(IMRobotGetConfigureResponse.Body body) {
        String str;
        IMLog.m10020d(f11338a, "[onLoadConfigureSuccess]");
        IMRobotViewUtil.show((View) this.f11340c);
        IMRobotViewUtil.show(this.f11345h);
        IMRobotViewUtil.hide(this.f11343f);
        IMRobotViewUtil.hide(this.f11342e);
        if (body.robotList != null && !body.robotList.isEmpty()) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(0);
            this.f11346i.setLayoutManager(linearLayoutManager);
            int i = 0;
            while (true) {
                if (i >= body.robotList.size()) {
                    i = 0;
                    break;
                } else if (TextUtils.equals(body.defaultRobotId, body.robotList.get(i).robotId)) {
                    break;
                } else {
                    i++;
                }
            }
            this.f11352o = i;
            BottomTabRecyclerViewAdapter bottomTabRecyclerViewAdapter = new BottomTabRecyclerViewAdapter();
            this.f11351n = bottomTabRecyclerViewAdapter;
            bottomTabRecyclerViewAdapter.setData(body.robotList, i);
            this.f11348k.selectRobotItem(i, true);
            m9843a(i, true);
            this.f11351n.setOnItemClickListener(new BottomTabRecyclerViewAdapter.OnItemClickListener() {
                public void onItemClick(View view, int i) {
                    IMRobotPanelView iMRobotPanelView = IMRobotPanelView.this;
                    iMRobotPanelView.m9842a(iMRobotPanelView.f11352o, i);
                    int unused = IMRobotPanelView.this.f11352o = i;
                    IMRobotPanelView.this.f11348k.selectRobotItem(i, true);
                    IMRobotPanelView.this.f11340c.stopPlayAudio();
                    IMRobotPanelView.this.m9843a(i, false);
                }
            });
            this.f11346i.setAdapter(this.f11351n);
            if (this.f11348k.getCurrentRobot() != null) {
                IMRobotController iMRobotController = this.f11348k;
                IMRobotPraise nextPraise = iMRobotController.nextPraise(iMRobotController.getCurrentRobot(), false);
                if (nextPraise != null) {
                    str = nextPraise.trackingData;
                    IMRobotTraceUtil.tracePanelShow(str);
                }
            }
            str = "";
            IMRobotTraceUtil.tracePanelShow(str);
        }
    }

    public void onLoadPraiseListSuccess() {
        IMLog.m10020d(f11338a, "[onLoadPraiseListSuccess]");
    }

    public void onUnlockRobotFailed() {
        if (getContext() != null) {
            SystemUtils.showToast(IMToast.makeText(getContext(), (CharSequence) getContext().getString(R.string.im_plugin_robot_unlock_error_text), 0));
        }
    }

    public void onUpdatePraise(IMRobotGetConfigureResponse.Robot robot, IMRobotPraise iMRobotPraise, boolean z) {
        if (robot != null && iMRobotPraise != null) {
            IMRobotPraiseView iMRobotPraiseView = this.f11340c;
            if (iMRobotPraiseView != null) {
                iMRobotPraiseView.bind(robot, iMRobotPraise, this);
            }
            IMRobotTraceUtil.traceRobotPraiseShow(iMRobotPraise.robotId, iMRobotPraise.praiseId);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9842a(int i, int i2) {
        IMRobotController iMRobotController = this.f11348k;
        if (iMRobotController != null) {
            IMRobotGetConfigureResponse.Robot robot = iMRobotController.getRobot(i);
            if (robot == null) {
                String str = f11338a;
                IMLog.m10021e(str, "[traceChangeRobot] fromIndex=" + i + " with null robot info.");
                return;
            }
            IMRobotGetConfigureResponse.Robot robot2 = this.f11348k.getRobot(i2);
            if (robot2 == null) {
                String str2 = f11338a;
                IMLog.m10021e(str2, "[traceChangeRobot] destIndex=" + i2 + " with null robot info.");
                return;
            }
            IMRobotTraceUtil.traceRobotChangeClick(robot.robotId, robot2.robotId);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9843a(int i, boolean z) {
        IMRobotController iMRobotController = this.f11348k;
        if (iMRobotController != null) {
            IMRobotGetConfigureResponse.Robot robot = iMRobotController.getRobot(i);
            if (robot == null) {
                String str = f11338a;
                IMLog.m10021e(str, "[traceRobotShow] index=" + i + " with null robot info.");
                return;
            }
            IMRobotTraceUtil.traceRobotShow(robot.robotId, z);
        }
    }

    public void switchPraise() {
        this.f11348k.switchPraise(this.f11352o);
    }

    /* renamed from: com.didi.beatles.im.plugin.robot.IMRobotPanelView$BottomTabRecyclerViewAdapter */
    private static class BottomTabRecyclerViewAdapter extends RecyclerView.Adapter<BottomTabRecyclerViewViewHolder> {
        /* access modifiers changed from: private */
        public OnItemClickListener mOnItemClickListener;
        List<RobotData> robots;

        /* renamed from: com.didi.beatles.im.plugin.robot.IMRobotPanelView$BottomTabRecyclerViewAdapter$OnItemClickListener */
        public interface OnItemClickListener {
            void onItemClick(View view, int i);
        }

        private BottomTabRecyclerViewAdapter() {
            this.robots = new ArrayList();
        }

        /* renamed from: com.didi.beatles.im.plugin.robot.IMRobotPanelView$BottomTabRecyclerViewAdapter$RobotData */
        class RobotData {
            IMRobotGetConfigureResponse.Robot robot;
            boolean selected = false;

            RobotData(IMRobotGetConfigureResponse.Robot robot2, boolean z) {
                this.robot = robot2;
                this.selected = z;
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }

        /* access modifiers changed from: package-private */
        public void setData(List<IMRobotGetConfigureResponse.Robot> list, int i) {
            this.robots.clear();
            int i2 = 0;
            while (i2 < list.size()) {
                this.robots.add(new RobotData(list.get(i2), i2 == i));
                i2++;
            }
        }

        public BottomTabRecyclerViewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new BottomTabRecyclerViewViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_plugin_robot_bottom_bar_item, viewGroup, false));
        }

        public void onBindViewHolder(final BottomTabRecyclerViewViewHolder bottomTabRecyclerViewViewHolder, int i) {
            final RobotData robotData = this.robots.get(i);
            bottomTabRecyclerViewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    Iterator<RobotData> it = BottomTabRecyclerViewAdapter.this.robots.iterator();
                    while (it.hasNext()) {
                        RobotData next = it.next();
                        next.selected = next == robotData;
                    }
                    BottomTabRecyclerViewAdapter.this.mOnItemClickListener.onItemClick(view, bottomTabRecyclerViewViewHolder.getAdapterPosition());
                    BottomTabRecyclerViewAdapter.this.notifyDataSetChanged();
                }
            });
            bottomTabRecyclerViewViewHolder.itemView.setSelected(robotData.selected);
            BtsImageLoader.getInstance().loadInto(robotData.robot.navStarImg, bottomTabRecyclerViewViewHolder.starAvatarImage);
        }

        public int getItemCount() {
            return this.robots.size();
        }

        /* renamed from: com.didi.beatles.im.plugin.robot.IMRobotPanelView$BottomTabRecyclerViewAdapter$BottomTabRecyclerViewViewHolder */
        class BottomTabRecyclerViewViewHolder extends RecyclerView.ViewHolder {
            static final int DEFAULT_ITEM_MARGIN = 10;
            static final int FIX_WIDTH_DP = 80;
            static final int IMAGE_WIDTH_DP = 35;
            static final float TAB_NUM = 5.5f;
            ImageView starAvatarImage;

            BottomTabRecyclerViewViewHolder(View view) {
                super(view);
                this.starAvatarImage = (ImageView) view.findViewById(R.id.robot_star_avatar_image);
                int imageMargin = getImageMargin(view.getContext());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.starAvatarImage.getLayoutParams();
                float f = (float) imageMargin;
                layoutParams.setMargins(IMRobotViewUtil.dp2px(view.getContext(), f), IMRobotViewUtil.dp2px(view.getContext(), 5.0f), IMRobotViewUtil.dp2px(view.getContext(), f), IMRobotViewUtil.dp2px(view.getContext(), 3.0f));
                this.starAvatarImage.setLayoutParams(layoutParams);
            }

            private int getImageMargin(Context context) {
                int screenWidth = (((int) (((float) (IMRobotViewUtil.getScreenWidth(context) - IMRobotViewUtil.dp2px(context, 80.0f))) / 5.5f)) - IMRobotViewUtil.dp2px(context, 35.0f)) / 2;
                if (screenWidth <= 0) {
                    screenWidth = IMRobotViewUtil.dp2px(context, 10.0f);
                }
                return IMRobotViewUtil.px2dp(context, (float) screenWidth);
            }
        }
    }
}
