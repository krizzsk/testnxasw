package com.didi.beatles.p101im.picture.luban;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import com.didi.beatles.p101im.utils.IMLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.luban.Luban */
public class Luban implements Handler.Callback {
    public static final String TAG_LUBAN = "IM-Luban";

    /* renamed from: a */
    private static final String f11254a = "im_image_disk_cache";

    /* renamed from: b */
    private static final int f11255b = 0;

    /* renamed from: c */
    private static final int f11256c = 1;

    /* renamed from: d */
    private static final int f11257d = 2;

    /* renamed from: e */
    private String f11258e;

    /* renamed from: f */
    private boolean f11259f;

    /* renamed from: g */
    private int f11260g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f11261h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public List<IMLocalMedia> f11262i;

    /* renamed from: j */
    private OnRenameListener f11263j;

    /* renamed from: k */
    private OnCompressListener f11264k;

    /* renamed from: l */
    private CompressionPredicate f11265l;

    /* renamed from: m */
    private List<InputStreamProvider> f11266m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f11267n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Handler f11268o;

    /* renamed from: a */
    static /* synthetic */ int m9787a(Luban luban) {
        int i = luban.f11267n;
        luban.f11267n = i + 1;
        return i;
    }

    private Luban(Builder builder) {
        this.f11267n = -1;
        this.f11258e = builder.mTargetDir;
        this.f11262i = builder.mMediaList;
        this.f11263j = builder.mRenameListener;
        this.f11266m = builder.mStreamProviders;
        this.f11264k = builder.mCompressListener;
        this.f11260g = builder.mLeastCompressSize;
        this.f11261h = builder.maxImageSize;
        this.f11265l = builder.mCompressionPredicate;
        this.f11268o = new Handler(Looper.getMainLooper(), this);
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }

    /* renamed from: a */
    private File m9793a(Context context, String str) {
        File a;
        if (TextUtils.isEmpty(this.f11258e) && (a = m9792a(context)) != null) {
            this.f11258e = a.getAbsolutePath();
        }
        if (!TextUtils.isEmpty(this.f11258e)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11258e);
            sb.append("/");
            sb.append(System.currentTimeMillis());
            sb.append((int) (Math.random() * 1000.0d));
            if (TextUtils.isEmpty(str)) {
                str = ".jpg";
            }
            sb.append(str);
            return new File(sb.toString());
        }
        IMLog.m10021e(TAG_LUBAN, "[getImageCacheFile] get error image cache file");
        return null;
    }

    /* renamed from: b */
    private File m9797b(Context context, String str) {
        File a;
        if (TextUtils.isEmpty(this.f11258e) && (a = m9792a(context)) != null) {
            this.f11258e = a.getAbsolutePath();
        }
        if (TextUtils.isEmpty(this.f11258e)) {
            return null;
        }
        return new File(this.f11258e + "/" + str);
    }

    /* renamed from: a */
    private File m9792a(Context context) {
        return m9801c(context, f11254a);
    }

    /* renamed from: c */
    private static File m9801c(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            IMLog.m10021e(TAG_LUBAN, "[getImageCacheDir] fail mkdirs");
            return null;
        }
        IMLog.m10021e(TAG_LUBAN, "default disk cache dir is null");
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9799b(final Context context) {
        List<InputStreamProvider> list = this.f11266m;
        if (list == null || (list.size() == 0 && this.f11264k != null)) {
            throw new NullPointerException("image file cannot be null");
        } else if (this.f11261h != 0 || this.f11264k == null) {
            Iterator<InputStreamProvider> it = this.f11266m.iterator();
            this.f11267n = -1;
            while (it.hasNext()) {
                final InputStreamProvider next = it.next();
                AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {
                    public void run() {
                        try {
                            Luban.m9787a(Luban.this);
                            boolean z = true;
                            Luban.this.f11268o.sendMessage(Luban.this.f11268o.obtainMessage(1));
                            LubanOutput a = Luban.this.m9788a(context, Luban.this.f11261h, next);
                            if (Luban.this.f11262i == null || Luban.this.f11262i.size() <= 0) {
                                Luban.this.f11268o.sendMessage(Luban.this.f11268o.obtainMessage(2, new IOException()));
                                return;
                            }
                            IMLocalMedia iMLocalMedia = (IMLocalMedia) Luban.this.f11262i.get(Luban.this.f11267n);
                            IMTraceUtil.addBusinessEvent("im_image_compress").add("com_count", Integer.valueOf(a.getCompressCount())).add("com_qua", Integer.valueOf(a.getCompressQuality())).add("in_w", Integer.valueOf(iMLocalMedia.getWidth())).add("in_h", Integer.valueOf(iMLocalMedia.getHeight())).add("in_size", Long.valueOf(iMLocalMedia.getSize())).add("in_path", iMLocalMedia.getPath()).add("out_w", Integer.valueOf(a.getWidth())).add("out_h", Integer.valueOf(a.getHeight())).add("out_size", Long.valueOf(a.getSize())).add("out_path", a.getFile().getAbsolutePath()).report();
                            String absolutePath = a.getFile().getAbsolutePath();
                            boolean isHttp = IMPictureMimeType.isHttp(absolutePath);
                            iMLocalMedia.setCompressed(!isHttp);
                            if (isHttp) {
                                absolutePath = "";
                            }
                            iMLocalMedia.setCompressPath(absolutePath);
                            if (a.getWidth() > 0) {
                                iMLocalMedia.setWidth(a.getWidth());
                            }
                            if (a.getHeight() > 0) {
                                iMLocalMedia.setHeight(a.getHeight());
                            }
                            if (a.getSize() > 0) {
                                iMLocalMedia.setSize(a.getSize());
                            }
                            if (Luban.this.f11267n != Luban.this.f11262i.size() - 1) {
                                z = false;
                            }
                            if (z) {
                                Luban.this.f11268o.sendMessage(Luban.this.f11268o.obtainMessage(0, Luban.this.f11262i));
                            }
                        } catch (IOException e) {
                            Luban.this.f11268o.sendMessage(Luban.this.f11268o.obtainMessage(2, e));
                        }
                    }
                });
                it.remove();
            }
        } else {
            throw new IllegalArgumentException("Must set max image size.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LubanOutput m9789a(InputStreamProvider inputStreamProvider, int i, Context context) throws IOException {
        try {
            return new C4721a(inputStreamProvider, m9793a(context, Checker.SINGLE.extSuffix(inputStreamProvider)), this.f11259f).mo48024a(i);
        } finally {
            inputStreamProvider.close();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<LubanOutput> m9802c(Context context) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator<InputStreamProvider> it = this.f11266m.iterator();
        while (it.hasNext()) {
            arrayList.add(m9788a(context, this.f11261h, it.next()));
            it.remove();
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LubanOutput m9788a(Context context, int i, InputStreamProvider inputStreamProvider) throws IOException {
        try {
            return m9796b(context, i, inputStreamProvider);
        } finally {
            inputStreamProvider.close();
        }
    }

    /* renamed from: b */
    private LubanOutput m9796b(Context context, int i, InputStreamProvider inputStreamProvider) throws IOException {
        LubanOutput lubanOutput;
        File a = m9793a(context, Checker.SINGLE.extSuffix(inputStreamProvider));
        OnRenameListener onRenameListener = this.f11263j;
        if (onRenameListener != null) {
            a = m9797b(context, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        CompressionPredicate compressionPredicate = this.f11265l;
        if (compressionPredicate != null) {
            if (compressionPredicate.apply(inputStreamProvider.getPath()) && Checker.SINGLE.needCompress(context, this.f11260g, inputStreamProvider.getPath())) {
                lubanOutput = new C4721a(inputStreamProvider, a, this.f11259f).mo48024a(i);
            } else if (Build.VERSION.SDK_INT <= 28 || !IMPictureFileUtils.isImageUriFormat(inputStreamProvider.getPath())) {
                lubanOutput = new LubanOutput(new File(inputStreamProvider.getPath()));
            } else {
                lubanOutput = new LubanOutput(getFileOnTarget29(context, inputStreamProvider, a));
            }
        } else if (Checker.SINGLE.needCompress(context, this.f11260g, inputStreamProvider.getPath())) {
            lubanOutput = new C4721a(inputStreamProvider, a, this.f11259f).mo48024a(i);
        } else if (Build.VERSION.SDK_INT <= 28 || !IMPictureFileUtils.isImageUriFormat(inputStreamProvider.getPath())) {
            lubanOutput = new LubanOutput(new File(inputStreamProvider.getPath()));
        } else {
            lubanOutput = new LubanOutput(getFileOnTarget29(context, inputStreamProvider, a));
        }
        if (lubanOutput != null) {
            return lubanOutput;
        }
        if (Build.VERSION.SDK_INT <= 28 || !IMPictureFileUtils.isImageUriFormat(inputStreamProvider.getPath())) {
            return new LubanOutput(new File(inputStreamProvider.getPath()));
        }
        return new LubanOutput(getFileOnTarget29(context, inputStreamProvider, a));
    }

    public File getFileOnTarget29(Context context, InputStreamProvider inputStreamProvider, File file) throws IOException {
        InputStream openInputStream = context.getContentResolver().openInputStream(Uri.parse(inputStreamProvider.getPath()));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[4096];
        while (openInputStream != null) {
            int read = openInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        return file;
    }

    public boolean handleMessage(Message message) {
        if (this.f11264k == null) {
            return false;
        }
        int i = message.what;
        if (i == 0) {
            this.f11264k.onSuccess((List) message.obj);
        } else if (i == 1) {
            this.f11264k.onStart();
        } else if (i == 2) {
            this.f11264k.onError((Throwable) message.obj);
        }
        return false;
    }

    /* renamed from: com.didi.beatles.im.picture.luban.Luban$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public Context context;
        private boolean focusAlpha;
        /* access modifiers changed from: private */
        public OnCompressListener mCompressListener;
        /* access modifiers changed from: private */
        public CompressionPredicate mCompressionPredicate;
        /* access modifiers changed from: private */
        public int mLeastCompressSize = 100;
        /* access modifiers changed from: private */
        public List<IMLocalMedia> mMediaList;
        /* access modifiers changed from: private */
        public OnRenameListener mRenameListener;
        /* access modifiers changed from: private */
        public List<InputStreamProvider> mStreamProviders;
        /* access modifiers changed from: private */
        public String mTargetDir;
        /* access modifiers changed from: private */
        public int maxImageSize;

        public Builder putGear(int i) {
            return this;
        }

        Builder(Context context2) {
            this.context = context2;
            this.mStreamProviders = new ArrayList();
        }

        private Luban build() {
            return new Luban(this);
        }

        private Builder load(final String str) {
            this.mStreamProviders.add(new InputStreamAdapter() {
                public InputStream openInternal() throws IOException {
                    if (Build.VERSION.SDK_INT <= 28 || !IMPictureFileUtils.isImageUriFormat(str)) {
                        return new FileInputStream(str);
                    }
                    return Builder.this.context.getContentResolver().openInputStream(Uri.parse(str));
                }

                public String getPath() {
                    return str;
                }
            });
            return this;
        }

        public Builder load(List<IMLocalMedia> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.mMediaList = list;
            for (IMLocalMedia next : list) {
                load(next.isCut() ? next.getCutPath() : next.getPath());
            }
            return this;
        }

        public Builder setRenameListener(OnRenameListener onRenameListener) {
            this.mRenameListener = onRenameListener;
            return this;
        }

        public Builder setCompressListener(OnCompressListener onCompressListener) {
            this.mCompressListener = onCompressListener;
            return this;
        }

        public Builder setTargetDir(String str) {
            this.mTargetDir = str;
            return this;
        }

        public Builder setFocusAlpha(boolean z) {
            this.focusAlpha = z;
            return this;
        }

        public Builder ignoreBy(int i) {
            this.mLeastCompressSize = i;
            return this;
        }

        public Builder maxImageSize(int i) {
            this.maxImageSize = i;
            return this;
        }

        public Builder filter(CompressionPredicate compressionPredicate) {
            this.mCompressionPredicate = compressionPredicate;
            return this;
        }

        public void launch() {
            try {
                build().m9799b(this.context);
            } catch (Exception e) {
                OnCompressListener onCompressListener = this.mCompressListener;
                if (onCompressListener != null) {
                    onCompressListener.onError(e);
                }
            }
        }

        public LubanOutput get(final String str) throws IOException {
            if (this.maxImageSize != 0) {
                return build().m9789a((InputStreamProvider) new InputStreamAdapter() {
                    public InputStream openInternal() throws IOException {
                        if (Build.VERSION.SDK_INT <= 28 || !IMPictureFileUtils.isImageUriFormat(str)) {
                            return new FileInputStream(str);
                        }
                        return Builder.this.context.getContentResolver().openInputStream(Uri.parse(str));
                    }

                    public String getPath() {
                        return str;
                    }
                }, this.maxImageSize, this.context);
            }
            OnCompressListener onCompressListener = this.mCompressListener;
            if (onCompressListener == null) {
                return null;
            }
            onCompressListener.onError(new IllegalArgumentException("Must set max image size."));
            return null;
        }

        public List<LubanOutput> get() throws IOException {
            if (this.maxImageSize != 0) {
                return build().m9802c(this.context);
            }
            OnCompressListener onCompressListener = this.mCompressListener;
            if (onCompressListener == null) {
                return null;
            }
            onCompressListener.onError(new IllegalArgumentException("Must set max image size."));
            return null;
        }
    }
}
