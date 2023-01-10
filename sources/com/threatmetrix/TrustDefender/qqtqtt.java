package com.threatmetrix.TrustDefender;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.threatmetrix.TrustDefender.jjkjkj;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class qqtqtt implements jjkjkj.kjjjjk {
    /* access modifiers changed from: private */
    public static final String b0072rrrr0072 = yyyyqy.b0074t007400740074t(qqtqtt.class);
    @Nonnull
    private final tqtqtt b00720072rrr0072;
    @Nonnull
    private final CountDownLatch br0072rrr0072;

    public private static class tqtqtt implements ServiceConnection {
        private final CountDownLatch b0072r0072rr0072;
        @Nullable
        private volatile IBinder brr0072rr0072 = null;

        public tqtqtt(CountDownLatch countDownLatch) {
            this.b0072r0072rr0072 = countDownLatch;
        }

        /* JADX INFO: finally extract failed */
        @Nullable
        private static String b00790079007900790079y(@Nonnull IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception e) {
                yyyyqy.qyyyqy.b00740074tttt(qqtqtt.b0072rrrr0072, "Failed to obtain Advertising ID {}", e.toString());
                obtain2.recycle();
                obtain.recycle();
                return null;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        @Nullable
        public String by0079007900790079y() {
            IBinder iBinder = this.brr0072rr0072;
            if (iBinder != null) {
                return b00790079007900790079y(iBinder);
            }
            return null;
        }

        public void onServiceConnected(ComponentName componentName, @Nullable IBinder iBinder) {
            if (iBinder != null) {
                this.brr0072rr0072 = iBinder;
                this.b0072r0072rr0072.countDown();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.brr0072rr0072 = null;
        }
    }

    public qqtqtt() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.br0072rrr0072 = countDownLatch;
        this.b00720072rrr0072 = new tqtqtt(countDownLatch);
    }

    public boolean bindToGooglePlayService(@Nonnull tqtqqt tqtqqt) {
        if (tqtqqt == null || tqtqqt.bll006C006C006C006C == null) {
            yyyyqy.b007400740074tt0074(b0072rrrr0072, "Null context");
            return false;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        return tqtqqt.bll006C006C006C006C.bindService(intent, this.b00720072rrr0072, 1);
    }

    @Nullable
    public String getAdvertisingId(int i) {
        try {
            if (this.br0072rrr0072.await((long) i, TimeUnit.MILLISECONDS)) {
                return this.b00720072rrr0072.by0079007900790079y();
            }
            yyyyqy.qyyyqy.bt0074tttt(b0072rrrr0072, "Failed to get Google Advertising ID, Time out");
            return null;
        } catch (InterruptedException e) {
            yyyyqy.qyyyqy.b00740074tttt(b0072rrrr0072, "Failed to get Google Advertising ID {}", e.toString());
            return null;
        } catch (Exception e2) {
            yyyyqy.bt0074007400740074t(b0072rrrr0072, e2.toString());
            return null;
        }
    }
}
