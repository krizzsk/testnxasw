package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import com.didi.sdk.apm.SystemUtils;
import java.io.FileNotFoundException;

public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = (Build.VERSION.SDK_INT < 20 || Build.VERSION.SDK_INT > 23);
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode = 2;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions = null;
    final Object mLock = new Object();
    int mOrientation = 1;
    int mScaleMode = 2;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT != 23) {
            z = true;
        }
        IS_MIN_MARGINS_HANDLING_CORRECT = z;
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public PrintHelper(Context context) {
        this.mContext = context;
    }

    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public void setColorMode(int i) {
        this.mColorMode = i;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public int getOrientation() {
        if (Build.VERSION.SDK_INT < 19 || this.mOrientation != 0) {
            return this.mOrientation;
        }
        return 1;
    }

    public void printBitmap(String str, Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (Build.VERSION.SDK_INT >= 19 && bitmap != null) {
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            if (isPortrait(bitmap)) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new PrintBitmapAdapter(str, this.mScaleMode, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build());
        }
    }

    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;

        PrintBitmapAdapter(String str, int i, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.mJobName = str;
            this.mFittingMode = i;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.mAttributes = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }

        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 19) {
            PrintUriAdapter printUriAdapter = new PrintUriAdapter(str, uri, onPrintFinishCallback, this.mScaleMode);
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            PrintAttributes.Builder builder = new PrintAttributes.Builder();
            builder.setColorMode(this.mColorMode);
            int i = this.mOrientation;
            if (i == 1 || i == 0) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
            } else if (i == 2) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
            }
            printManager.print(str, printUriAdapter, builder.build());
        }
    }

    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap = null;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

        PrintUriAdapter(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.mJobName = str;
            this.mImageFile = uri;
            this.mCallback = onPrintFinishCallback;
            this.mFittingMode = i;
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.mAttributes = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.mBitmap != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                final CancellationSignal cancellationSignal2 = cancellationSignal;
                final PrintAttributes printAttributes3 = printAttributes2;
                final PrintAttributes printAttributes4 = printAttributes;
                final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                this.mLoadBitmap = new AsyncTask<Uri, Boolean, Bitmap>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        cancellationSignal2.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                            public void onCancel() {
                                PrintUriAdapter.this.cancelLoad();
                                C06381.this.cancel(false);
                            }
                        });
                    }

                    /* access modifiers changed from: protected */
                    public Bitmap doInBackground(Uri... uriArr) {
                        try {
                            return PrintHelper.this.loadConstrainedBitmap(PrintUriAdapter.this.mImageFile);
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Bitmap bitmap) {
                        PrintAttributes.MediaSize mediaSize;
                        super.onPostExecute(bitmap);
                        if (bitmap != null && (!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION || PrintHelper.this.mOrientation == 0)) {
                            synchronized (this) {
                                mediaSize = PrintUriAdapter.this.mAttributes.getMediaSize();
                            }
                            if (!(mediaSize == null || mediaSize.isPortrait() == PrintHelper.isPortrait(bitmap))) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90.0f);
                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            }
                        }
                        PrintUriAdapter.this.mBitmap = bitmap;
                        if (bitmap != null) {
                            layoutResultCallback2.onLayoutFinished(new PrintDocumentInfo.Builder(PrintUriAdapter.this.mJobName).setContentType(1).setPageCount(1).build(), true ^ printAttributes3.equals(printAttributes4));
                        } else {
                            layoutResultCallback2.onLayoutFailed((CharSequence) null);
                        }
                        PrintUriAdapter.this.mLoadBitmap = null;
                    }

                    /* access modifiers changed from: protected */
                    public void onCancelled(Bitmap bitmap) {
                        layoutResultCallback2.onLayoutCancelled();
                        PrintUriAdapter.this.mLoadBitmap = null;
                    }
                }.execute(new Uri[0]);
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelLoad() {
            synchronized (PrintHelper.this.mLock) {
                if (PrintHelper.this.mDecodeOptions != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        PrintHelper.this.mDecodeOptions.requestCancelDecode();
                    }
                    PrintHelper.this.mDecodeOptions = null;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.mLoadBitmap;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static boolean isPortrait(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (Build.VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix getMatrix(int i, int i2, RectF rectF, int i3) {
        float f;
        Matrix matrix = new Matrix();
        float f2 = (float) i;
        float width = rectF.width() / f2;
        if (i3 == 2) {
            f = Math.max(width, rectF.height() / ((float) i2));
        } else {
            f = Math.min(width, rectF.height() / ((float) i2));
        }
        matrix.postScale(f, f);
        matrix.postTranslate((rectF.width() - (f2 * f)) / 2.0f, (rectF.height() - (((float) i2) * f)) / 2.0f);
        return matrix;
    }

    /* access modifiers changed from: package-private */
    public void writeBitmap(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes printAttributes2;
        if (IS_MIN_MARGINS_HANDLING_CORRECT) {
            printAttributes2 = printAttributes;
        } else {
            printAttributes2 = copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        final CancellationSignal cancellationSignal2 = cancellationSignal;
        final Bitmap bitmap2 = bitmap;
        final PrintAttributes printAttributes3 = printAttributes;
        final int i2 = i;
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        final PrintDocumentAdapter.WriteResultCallback writeResultCallback2 = writeResultCallback;
        new AsyncTask<Void, Void, Throwable>() {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x00de, code lost:
                r1.recycle();
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00a3 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00c5 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00da */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7 A[Catch:{ all -> 0x00cd, all -> 0x00e2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9 A[Catch:{ all -> 0x00cd, all -> 0x00e2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00de A[Catch:{ all -> 0x00cd, all -> 0x00e2 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Throwable doInBackground(java.lang.Void... r8) {
                /*
                    r7 = this;
                    android.os.CancellationSignal r8 = r4     // Catch:{ all -> 0x00e2 }
                    boolean r8 = r8.isCanceled()     // Catch:{ all -> 0x00e2 }
                    r0 = 0
                    if (r8 == 0) goto L_0x000a
                    return r0
                L_0x000a:
                    android.print.pdf.PrintedPdfDocument r8 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00e2 }
                    androidx.print.PrintHelper r1 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00e2 }
                    android.content.Context r1 = r1.mContext     // Catch:{ all -> 0x00e2 }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00e2 }
                    r8.<init>(r1, r2)     // Catch:{ all -> 0x00e2 }
                    android.graphics.Bitmap r1 = r6     // Catch:{ all -> 0x00e2 }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00e2 }
                    int r2 = r2.getColorMode()     // Catch:{ all -> 0x00e2 }
                    android.graphics.Bitmap r1 = androidx.print.PrintHelper.convertBitmapForColorMode(r1, r2)     // Catch:{ all -> 0x00e2 }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x00e2 }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00e2 }
                    if (r2 == 0) goto L_0x002a
                    return r0
                L_0x002a:
                    r2 = 1
                    android.graphics.pdf.PdfDocument$Page r3 = r8.startPage(r2)     // Catch:{ all -> 0x00cd }
                    boolean r4 = androidx.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT     // Catch:{ all -> 0x00cd }
                    if (r4 == 0) goto L_0x0041
                    android.graphics.RectF r2 = new android.graphics.RectF     // Catch:{ all -> 0x00cd }
                    android.graphics.pdf.PdfDocument$PageInfo r4 = r3.getInfo()     // Catch:{ all -> 0x00cd }
                    android.graphics.Rect r4 = r4.getContentRect()     // Catch:{ all -> 0x00cd }
                    r2.<init>(r4)     // Catch:{ all -> 0x00cd }
                    goto L_0x0064
                L_0x0041:
                    android.print.pdf.PrintedPdfDocument r4 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00cd }
                    androidx.print.PrintHelper r5 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00cd }
                    android.content.Context r5 = r5.mContext     // Catch:{ all -> 0x00cd }
                    android.print.PrintAttributes r6 = r7     // Catch:{ all -> 0x00cd }
                    r4.<init>(r5, r6)     // Catch:{ all -> 0x00cd }
                    android.graphics.pdf.PdfDocument$Page r2 = r4.startPage(r2)     // Catch:{ all -> 0x00cd }
                    android.graphics.RectF r5 = new android.graphics.RectF     // Catch:{ all -> 0x00cd }
                    android.graphics.pdf.PdfDocument$PageInfo r6 = r2.getInfo()     // Catch:{ all -> 0x00cd }
                    android.graphics.Rect r6 = r6.getContentRect()     // Catch:{ all -> 0x00cd }
                    r5.<init>(r6)     // Catch:{ all -> 0x00cd }
                    r4.finishPage(r2)     // Catch:{ all -> 0x00cd }
                    r4.close()     // Catch:{ all -> 0x00cd }
                    r2 = r5
                L_0x0064:
                    int r4 = r1.getWidth()     // Catch:{ all -> 0x00cd }
                    int r5 = r1.getHeight()     // Catch:{ all -> 0x00cd }
                    int r6 = r8     // Catch:{ all -> 0x00cd }
                    android.graphics.Matrix r4 = androidx.print.PrintHelper.getMatrix(r4, r5, r2, r6)     // Catch:{ all -> 0x00cd }
                    boolean r5 = androidx.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT     // Catch:{ all -> 0x00cd }
                    if (r5 == 0) goto L_0x0077
                    goto L_0x0085
                L_0x0077:
                    float r5 = r2.left     // Catch:{ all -> 0x00cd }
                    float r6 = r2.top     // Catch:{ all -> 0x00cd }
                    r4.postTranslate(r5, r6)     // Catch:{ all -> 0x00cd }
                    android.graphics.Canvas r5 = r3.getCanvas()     // Catch:{ all -> 0x00cd }
                    r5.clipRect(r2)     // Catch:{ all -> 0x00cd }
                L_0x0085:
                    android.graphics.Canvas r2 = r3.getCanvas()     // Catch:{ all -> 0x00cd }
                    r2.drawBitmap(r1, r4, r0)     // Catch:{ all -> 0x00cd }
                    r8.finishPage(r3)     // Catch:{ all -> 0x00cd }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x00cd }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00cd }
                    if (r2 == 0) goto L_0x00ab
                    r8.close()     // Catch:{ all -> 0x00e2 }
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ all -> 0x00e2 }
                    if (r8 == 0) goto L_0x00a3
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ IOException -> 0x00a3 }
                    r8.close()     // Catch:{ IOException -> 0x00a3 }
                L_0x00a3:
                    android.graphics.Bitmap r8 = r6     // Catch:{ all -> 0x00e2 }
                    if (r1 == r8) goto L_0x00aa
                    r1.recycle()     // Catch:{ all -> 0x00e2 }
                L_0x00aa:
                    return r0
                L_0x00ab:
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00cd }
                    android.os.ParcelFileDescriptor r3 = r9     // Catch:{ all -> 0x00cd }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x00cd }
                    r2.<init>(r3)     // Catch:{ all -> 0x00cd }
                    r8.writeTo(r2)     // Catch:{ all -> 0x00cd }
                    r8.close()     // Catch:{ all -> 0x00e2 }
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ all -> 0x00e2 }
                    if (r8 == 0) goto L_0x00c5
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ IOException -> 0x00c5 }
                    r8.close()     // Catch:{ IOException -> 0x00c5 }
                L_0x00c5:
                    android.graphics.Bitmap r8 = r6     // Catch:{ all -> 0x00e2 }
                    if (r1 == r8) goto L_0x00cc
                    r1.recycle()     // Catch:{ all -> 0x00e2 }
                L_0x00cc:
                    return r0
                L_0x00cd:
                    r0 = move-exception
                    r8.close()     // Catch:{ all -> 0x00e2 }
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ all -> 0x00e2 }
                    if (r8 == 0) goto L_0x00da
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ IOException -> 0x00da }
                    r8.close()     // Catch:{ IOException -> 0x00da }
                L_0x00da:
                    android.graphics.Bitmap r8 = r6     // Catch:{ all -> 0x00e2 }
                    if (r1 == r8) goto L_0x00e1
                    r1.recycle()     // Catch:{ all -> 0x00e2 }
                L_0x00e1:
                    throw r0     // Catch:{ all -> 0x00e2 }
                L_0x00e2:
                    r8 = move-exception
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.C06371.doInBackground(java.lang.Void[]):java.lang.Throwable");
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Throwable th) {
                if (cancellationSignal2.isCanceled()) {
                    writeResultCallback2.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    SystemUtils.log(6, PrintHelper.LOG_TAG, "Error writing printed content", th, "androidx.print.PrintHelper$1", 730);
                    writeResultCallback2.onWriteFailed((CharSequence) null);
                }
            }
        }.execute(new Void[0]);
    }

    /* access modifiers changed from: package-private */
    public Bitmap loadConstrainedBitmap(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        loadBitmap(uri, options2);
        int i = options2.outWidth;
        int i2 = options2.outHeight;
        if (i > 0 && i2 > 0) {
            int max = Math.max(i, i2);
            int i3 = 1;
            while (max > 3500) {
                max >>>= 1;
                i3 <<= 1;
            }
            if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                synchronized (this.mLock) {
                    BitmapFactory.Options options3 = new BitmapFactory.Options();
                    this.mDecodeOptions = options3;
                    options3.inMutable = true;
                    this.mDecodeOptions.inSampleSize = i3;
                    options = this.mDecodeOptions;
                }
                try {
                    Bitmap loadBitmap = loadBitmap(uri, options);
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    return loadBitmap;
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d A[SYNTHETIC, Splitter:B:18:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap loadBitmap(android.net.Uri r9, android.graphics.BitmapFactory.Options r10) throws java.io.FileNotFoundException {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x003f
            android.content.Context r0 = r8.mContext
            if (r0 == 0) goto L_0x003f
            r1 = 0
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x002a }
            java.io.InputStream r9 = r0.openInputStream(r9)     // Catch:{ all -> 0x002a }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r9, r1, r10)     // Catch:{ all -> 0x0027 }
            if (r9 == 0) goto L_0x0026
            r9.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x0026
        L_0x0019:
            r3 = move-exception
            r0 = 5
            r5 = 808(0x328, float:1.132E-42)
            java.lang.String r1 = "PrintHelper"
            java.lang.String r2 = "close fail "
            java.lang.String r4 = "androidx.print.PrintHelper"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0026:
            return r10
        L_0x0027:
            r10 = move-exception
            r1 = r9
            goto L_0x002b
        L_0x002a:
            r10 = move-exception
        L_0x002b:
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x003e
        L_0x0031:
            r5 = move-exception
            r2 = 5
            r7 = 808(0x328, float:1.132E-42)
            java.lang.String r3 = "PrintHelper"
            java.lang.String r4 = "close fail "
            java.lang.String r6 = "androidx.print.PrintHelper"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x003e:
            throw r10
        L_0x003f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "bad argument to loadBitmap"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.loadBitmap(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    static Bitmap convertBitmapForColorMode(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }
}
