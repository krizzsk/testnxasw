package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;
import org.json.JSONObject;

public class LottieCompositionFactory {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map<String, LottieTask<LottieComposition>> f1136a = new HashMap();

    private LottieCompositionFactory() {
    }

    public static void setMaxCacheSize(int i) {
        LottieCompositionCache.getInstance().resize(i);
    }

    public static void clearCache(Context context) {
        f1136a.clear();
        LottieCompositionCache.getInstance().clear();
        new NetworkCache(context).clear();
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieTask<LottieComposition> fromUrl(final Context context, final String str, final String str2) {
        return m1231a(str2, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return NetworkFetcher.fetchSync(context, str, str2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, String str2) {
        return NetworkFetcher.fetchSync(context, str, str2);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return m1231a(str2, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str, str2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, String str2) {
        try {
            if (str.endsWith(PmFileConstant.ZIP_SUFFIX)) {
                return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return fromJsonInputStreamSync(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i) {
        return fromRawRes(context, i, m1232a(context, i));
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i, String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return m1231a(str, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                Context context = (Context) weakReference.get();
                if (context == null) {
                    context = applicationContext;
                }
                return LottieCompositionFactory.fromRawResSync(context, i);
            }
        });
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i) {
        return fromRawResSync(context, i, m1232a(context, i));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i, String str) {
        try {
            return fromJsonInputStreamSync(context.getResources().openRawResource(i), str);
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: a */
    private static String m1232a(Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(m1234a(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m1234a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str) {
        return m1231a(str, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return m1229a(inputStream, str, true);
    }

    /* renamed from: a */
    private static LottieResult<LottieComposition> m1229a(InputStream inputStream, String str, boolean z) {
        try {
            return fromJsonReaderSync(JsonReader.m1433of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject jSONObject, final String str) {
        return m1231a(str, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str);
            }
        });
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromJsonString(final String str, final String str2) {
        return m1231a(str2, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(JsonReader.m1433of(Okio.buffer(Okio.source((InputStream) new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader jsonReader, final String str) {
        return m1231a(str, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonReaderSync(JsonReader.this, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return m1228a(jsonReader, str, true);
    }

    /* renamed from: a */
    private static LottieResult<LottieComposition> m1228a(JsonReader jsonReader, String str, boolean z) {
        try {
            LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, parse);
            }
            LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult;
        } catch (Exception e) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>((Throwable) e);
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult2;
        } catch (Throwable th) {
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromZipStream(final ZipInputStream zipInputStream, final String str) {
        return m1231a(str, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return m1230a(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    /* renamed from: a */
    private static LottieResult<LottieComposition> m1230a(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = m1228a(JsonReader.m1433of(Okio.buffer(Okio.source((InputStream) zipInputStream))), (String) null, false).getValue();
                } else {
                    if (!name.contains(IMPictureMimeType.PNG)) {
                        if (!name.contains(".webp")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset a = m1227a(lottieComposition, (String) entry.getKey());
                if (a != null) {
                    a.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), a.getWidth(), a.getHeight()));
                }
            }
            for (Map.Entry next : lottieComposition.getImages().entrySet()) {
                if (((LottieImageAsset) next.getValue()).getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + ((LottieImageAsset) next.getValue()).getFileName()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: a */
    private static LottieImageAsset m1227a(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset next : lottieComposition.getImages().values()) {
            if (next.getFileName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static LottieTask<LottieComposition> m1231a(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() {
                public LottieResult<LottieComposition> call() {
                    return new LottieResult<>(LottieComposition.this);
                }
            });
        }
        if (str != null && f1136a.containsKey(str)) {
            return f1136a.get(str);
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            lottieTask.addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition lottieComposition) {
                    LottieCompositionFactory.f1136a.remove(str);
                }
            });
            lottieTask.addFailureListener(new LottieListener<Throwable>() {
                public void onResult(Throwable th) {
                    LottieCompositionFactory.f1136a.remove(str);
                }
            });
            f1136a.put(str, lottieTask);
        }
        return lottieTask;
    }
}
