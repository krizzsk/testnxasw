package com.didi.drouter.remote;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.didi.drouter.remote.IHostService;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.SystemUtil;
import com.didi.sdk.apm.SystemUtils;

public class RemoteProvider extends ContentProvider {

    /* renamed from: a */
    static final String f21030a = "field_remote_binder";

    /* renamed from: b */
    static final String f21031b = "field_remote_process";

    /* renamed from: c */
    static final String f21032c = "field_remote_launch_action";

    /* renamed from: d */
    static final String f21033d = "drouter.process.action.";

    /* renamed from: e */
    private static boolean f21034e;

    /* renamed from: f */
    private static final IHostService.Stub f21035f = new IHostService.Stub() {
        public RemoteResult execute(RemoteCommand remoteCommand) {
            try {
                return new C8523a().mo63761a(remoteCommand);
            } catch (RuntimeException e) {
                RouterLogger.getCoreLogger().mo63951e("[Service] exception: %s", e);
                throw e;
            }
        }
    };

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        String processName = SystemUtil.getProcessName();
        if (getContext() instanceof Application) {
            SystemUtil.setApplication((Application) getContext());
            RouterLogger.getCoreLogger().mo63950d("[%s] onCreate | Context: %s | Process: \"%s\"", getClass().getSimpleName(), getContext(), processName);
            if (!f21034e) {
                Intent intent = new Intent(f21033d + processName);
                intent.putExtra(f21032c, processName);
                getContext().sendBroadcast(intent);
                f21034e = true;
            }
        } else {
            SystemUtils.log(6, RouterLogger.NAME, String.format("[%s] onCreate | Context: %s | Process: \"%s\"", new Object[]{getClass().getSimpleName(), getContext(), processName}), (Throwable) null, "com.didi.drouter.remote.RemoteProvider", 61);
        }
        return true;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        RouterLogger.getCoreLogger().mo63950d("[%s] is called by client to get binder, process: \"%s\"", getClass().getSimpleName(), SystemUtil.getProcessName());
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(f21030a, new BinderParcel((IBinder) f21035f));
        bundle2.putString(f21031b, SystemUtil.getProcessName());
        return bundle2;
    }

    static class BinderParcel implements Parcelable {
        public static final Parcelable.Creator<BinderParcel> CREATOR = new Parcelable.Creator<BinderParcel>() {
            public BinderParcel createFromParcel(Parcel parcel) {
                return new BinderParcel(parcel);
            }

            public BinderParcel[] newArray(int i) {
                return new BinderParcel[i];
            }
        };
        private final IBinder mBinder;

        public int describeContents() {
            return 0;
        }

        BinderParcel(Parcel parcel) {
            this.mBinder = parcel.readStrongBinder();
        }

        BinderParcel(IBinder iBinder) {
            this.mBinder = iBinder;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStrongBinder(this.mBinder);
        }

        /* access modifiers changed from: package-private */
        public IBinder getBinder() {
            return this.mBinder;
        }
    }
}
