package com.didi.trackupload.sdk;

import com.didi.trackupload.sdk.datachannel.IDataChannel;
import java.io.File;
import java.util.Locale;

public class TrackInitParams {

    /* renamed from: a */
    private IDataChannel f46540a;

    /* renamed from: b */
    private ICommonInfoDelegate f46541b;

    /* renamed from: c */
    private boolean f46542c;

    /* renamed from: d */
    private File f46543d;

    TrackInitParams(IDataChannel iDataChannel, ICommonInfoDelegate iCommonInfoDelegate, boolean z, File file) {
        this.f46540a = iDataChannel;
        this.f46541b = iCommonInfoDelegate;
        this.f46542c = z;
        this.f46543d = file;
    }

    public IDataChannel getDataChannel() {
        return this.f46540a;
    }

    public ICommonInfoDelegate getCommonInfoDelegate() {
        return this.f46541b;
    }

    public boolean isDirectUploadModeEnabled() {
        return this.f46542c;
    }

    public File getBaMaiLogPath() {
        return this.f46543d;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "TrackInitParams@%s{dataChannel=%s, commonDelegate=%s, directUpload=%s, bmLogPath=%s}", new Object[]{Integer.toHexString(hashCode()), this.f46540a, this.f46541b, Boolean.valueOf(this.f46542c), this.f46543d});
    }

    public static class Builder {
        private File mBaMaiLogPath;
        private ICommonInfoDelegate mCommonInfoDelegate;
        private IDataChannel mDataChannel;
        private boolean mDirectUploadModeEnabled;

        public Builder dataChannel(IDataChannel iDataChannel) {
            this.mDataChannel = iDataChannel;
            return this;
        }

        public Builder commonInfoDelegate(ICommonInfoDelegate iCommonInfoDelegate) {
            this.mCommonInfoDelegate = iCommonInfoDelegate;
            return this;
        }

        public Builder enableDirectUploadMode() {
            this.mDirectUploadModeEnabled = true;
            return this;
        }

        public Builder setBaMaiLogPath(File file) {
            this.mBaMaiLogPath = file;
            return this;
        }

        public TrackInitParams build() {
            return new TrackInitParams(this.mDataChannel, this.mCommonInfoDelegate, this.mDirectUploadModeEnabled, this.mBaMaiLogPath);
        }
    }
}
