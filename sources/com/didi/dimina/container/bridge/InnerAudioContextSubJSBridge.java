package com.didi.dimina.container.bridge;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.MediaPlayerManager;
import com.didi.dimina.container.util.ViewUtil;
import com.didi.sdk.component.search.city.p149db.DIDIDbTables;
import com.didi.soda.blocks.constant.Const;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class InnerAudioContextSubJSBridge {

    /* renamed from: a */
    private static final String f18466a = "InnerAudioContext";

    /* renamed from: b */
    private static final NetworkService f18467b = Dimina.getConfig().getAdapterConfig().getHttpService();

    /* renamed from: c */
    private final String f18468c = (FileUtil.getDownloadDir() + File.separator + "Audio" + File.separator);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MediaPlayerManager f18469d;

    /* renamed from: e */
    private final DMMina f18470e;

    /* renamed from: f */
    private String f18471f = "";

    /* renamed from: g */
    private boolean f18472g = false;

    /* renamed from: h */
    private Long f18473h = 0L;

    /* renamed from: i */
    private Long f18474i = 0L;

    /* renamed from: j */
    private Long f18475j = 0L;

    /* renamed from: k */
    private boolean f18476k = false;

    /* renamed from: l */
    private boolean f18477l = false;

    /* renamed from: m */
    private boolean f18478m = false;

    /* renamed from: n */
    private final float f18479n = 1.0f;

    /* renamed from: o */
    private final Integer f18480o = 0;

    /* renamed from: p */
    private String f18481p = "";

    /* renamed from: q */
    private String f18482q = "";

    /* renamed from: r */
    private final long f18483r = 200;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Set<String> f18484s = new HashSet();

    public InnerAudioContextSubJSBridge(DMMina dMMina) {
        LogUtil.m16838d(f18466a, "InnerAudioContextSubJSBridge init ");
        this.f18470e = dMMina;
        this.f18469d = new MediaPlayerManager();
    }

    public void updateAudioState(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16838d(f18466a, "updateAudioState " + jSONObject);
        this.f18471f = jSONObject.optString("audioId");
        this.f18472g = jSONObject.optBoolean("paused");
        this.f18473h = Long.valueOf(jSONObject.optLong(DIDIDbTables.BaseSideBarNewColumn.START_TIME));
        this.f18474i = Long.valueOf(jSONObject.optLong("currentTime"));
        this.f18475j = Long.valueOf(jSONObject.optLong("duration"));
        this.f18476k = jSONObject.optBoolean("obeyMuteSwitch");
        this.f18477l = jSONObject.optBoolean("autoplay");
        this.f18478m = jSONObject.optBoolean("loop");
        this.f18481p = jSONObject.optString(Const.BlockParamConst.SRC);
    }

    public void play(JSONObject jSONObject, CallbackFunction callbackFunction) {
        updateAudioState(jSONObject, callbackFunction);
        final String str = this.f18468c + FileUtil.getFileName(this.f18481p);
        LogUtil.m16838d(f18466a, "filePath " + str);
        if (m15642a(str)) {
            LogUtil.m16838d(f18466a, "音频文件已经存在");
            onPlay(str);
        } else {
            LogUtil.m16838d(f18466a, "音频文件不存在，开始下载");
            final String str2 = this.f18481p;
            if (this.f18484s.contains(str2)) {
                LogUtil.m16838d(f18466a, "已经在下载音频url：" + str2);
                return;
            }
            this.f18484s.add(str2);
            m15641a(this.f18481p, str, new NetworkService.ITaskCallback() {
                public void onFailure(Exception exc) {
                    LogUtil.m16838d(InnerAudioContextSubJSBridge.f18466a, "downloadFile onFailure " + exc.toString());
                    InnerAudioContextSubJSBridge.this.f18484s.remove(str2);
                    InnerAudioContextSubJSBridge.this.onPlay(str2);
                }

                public void onSuccess(JSONObject jSONObject) {
                    LogUtil.m16838d(InnerAudioContextSubJSBridge.f18466a, "downloadFile onSuccess");
                    InnerAudioContextSubJSBridge.this.f18484s.remove(str2);
                    InnerAudioContextSubJSBridge.this.onPlay(str);
                }
            });
        }
        this.f18469d.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                LogUtil.m16838d(InnerAudioContextSubJSBridge.f18466a, "onCompletion stopPlay " + InnerAudioContextSubJSBridge.this.f18469d.isPlaying());
                InnerAudioContextSubJSBridge.this.onEnded();
            }
        });
        CallBackUtil.onSuccess(callbackFunction);
    }

    public void onPlay(String str) {
        if (!TextUtils.equals(this.f18482q, str) || !ViewUtil.isFastDoubleInvoke(200)) {
            this.f18482q = str;
            this.f18469d.startPlay(str, new MediaPlayerManager.OnMusicStartPlayListener() {
                public final void onStartPlay() {
                    InnerAudioContextSubJSBridge.this.m15640a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15640a() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "emitFunctionName", (Object) "onPlay");
        JSONUtil.put(jSONObject, "audioId", (Object) this.f18471f);
        this.f18470e.getMessageTransfer().sendMessageToServiceFromNative("audioInstanceStateChanged", new MessageWrapperBuilder().data(jSONObject).build());
    }

    public void onEnded() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "emitFunctionName", (Object) "onEnded");
        JSONUtil.put(jSONObject, "audioId", (Object) this.f18471f);
        this.f18470e.getMessageTransfer().sendMessageToServiceFromNative("audioInstanceStateChanged", new MessageWrapperBuilder().data(jSONObject).build());
    }

    public void onStop() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "emitFunctionName", (Object) "onStop");
        JSONUtil.put(jSONObject, "audioId", (Object) this.f18471f);
        this.f18470e.getMessageTransfer().sendMessageToServiceFromNative("audioInstanceStateChanged", new MessageWrapperBuilder().data(jSONObject).build());
    }

    public void stop(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f18469d.stopPlay();
        onStop();
        CallBackUtil.onSuccess(callbackFunction);
    }

    public void onDestroy() {
        MediaPlayerManager mediaPlayerManager = this.f18469d;
        if (mediaPlayerManager != null) {
            mediaPlayerManager.stopPlay();
            this.f18469d.release();
        }
    }

    /* renamed from: a */
    private void m15641a(String str, String str2, NetworkService.ITaskCallback iTaskCallback) {
        NetworkService.NetworkTaskModel.Download download = new NetworkService.NetworkTaskModel.Download();
        download.url = str;
        download.timeout = 3000;
        download.filePath = str2;
        f18467b.downloadFile(download, iTaskCallback);
    }

    /* renamed from: a */
    private boolean m15642a(String str) {
        File file = new File(this.f18468c);
        File file2 = new File(str);
        if (file.exists() && file2.exists()) {
            return true;
        }
        FileUtil.mkdirs(this.f18468c);
        return false;
    }
}
