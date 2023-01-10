package com.threatmetrix.TrustDefender;

import android.content.Context;
import javax.annotation.Nullable;

public class NativeGathererHelper {
    public boolean bg0067gg00670067(String str, String str2, boolean z, boolean z2) throws UnsatisfiedLinkError, Throwable {
        System.loadLibrary(str2);
        return init(14, z, z2);
    }

    public native int cancel();

    @Nullable
    public native String[] checkURLs(String[] strArr);

    public void finalize() throws Throwable {
        super.finalize();
        finit();
    }

    public native void finit();

    public native Object getAddresses(Class cls);

    public native long getAppTime(String str);

    @Nullable
    public native String getBinaryArch();

    @Nullable
    public native String getConnections(Context context);

    public native int getCpuCores();

    @Nullable
    public native String[] getFontList(String str);

    public native int getIntConfig(Context context, String str, String str2);

    public native long getLongConfig(Context context, String str, String str2);

    @Nullable
    public native String[] getNetworkInfo();

    @Nullable
    public native String getRandomString(int i);

    public native int getSelinuxMode();

    @Nullable
    public native String getStringConfig(Context context, String str, String str2);

    public native long getTamperCode(int i);

    public native String getTextSectionHash(String str);

    @Nullable
    public native String hashFile(String str, int i);

    public native boolean init(int i, boolean z, boolean z2);

    public native int jniDetectedDebugStatus(String str);

    @Nullable
    public native String md5(String str);

    public native void setInfoLogging(int i);

    public native int setIntConfig(Context context, String str, String str2, int i);

    public native int setLongConfig(Context context, String str, String str2, long j);

    public native int setStringConfig(Context context, String str, String str2, String str3);

    public native String sha1Base32Encode(byte[] bArr);

    @Nullable
    public native String sha1HexEncode(byte[] bArr);

    @Nullable
    public native String sha256HexEncode(byte[] bArr);

    @Nullable
    public native String urlEncode(String str);

    public native String validatePackage(String str);

    public native int waitUntilCancelled();

    @Nullable
    public native String xor(String str, String str2);
}
