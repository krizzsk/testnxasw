package org.webrtc;

import org.webrtc.EncodedImage;

public interface VideoEncoder {

    /* renamed from: org.webrtc.VideoEncoder$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$createNativeVideoEncoder(VideoEncoder videoEncoder) {
            return 0;
        }

        public static ResolutionBitrateLimits[] $default$getResolutionBitrateLimits(VideoEncoder videoEncoder) {
            return new ResolutionBitrateLimits[0];
        }

        public static boolean $default$isHardwareEncoder(VideoEncoder videoEncoder) {
            return true;
        }
    }

    public interface Callback {
        void onEncodedFrame(EncodedImage encodedImage, CodecSpecificInfo codecSpecificInfo);
    }

    public static class CodecSpecificInfo {
    }

    public static class CodecSpecificInfoH264 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoVP8 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoVP9 extends CodecSpecificInfo {
    }

    long createNativeVideoEncoder();

    VideoCodecStatus encode(VideoFrame videoFrame, EncodeInfo encodeInfo);

    String getImplementationName();

    ResolutionBitrateLimits[] getResolutionBitrateLimits();

    ScalingSettings getScalingSettings();

    VideoCodecStatus initEncode(Settings settings, Callback callback);

    boolean isHardwareEncoder();

    VideoCodecStatus release();

    VideoCodecStatus setRateAllocation(BitrateAllocation bitrateAllocation, int i);

    public static class Settings {
        public final boolean automaticResizeOn;
        public final Capabilities capabilities;
        public final int height;
        public final int maxFramerate;
        public final int numberOfCores;
        public final int numberOfSimulcastStreams;
        public final int startBitrate;
        public final int width;

        @Deprecated
        public Settings(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            this(i, i2, i3, i4, i5, i6, z, new Capabilities(false));
        }

        public Settings(int i, int i2, int i3, int i4, int i5, int i6, boolean z, Capabilities capabilities2) {
            this.numberOfCores = i;
            this.width = i2;
            this.height = i3;
            this.startBitrate = i4;
            this.maxFramerate = i5;
            this.numberOfSimulcastStreams = i6;
            this.automaticResizeOn = z;
            this.capabilities = capabilities2;
        }
    }

    public static class Capabilities {
        public final boolean lossNotification;

        public Capabilities(boolean z) {
            this.lossNotification = z;
        }
    }

    public static class EncodeInfo {
        public final EncodedImage.FrameType[] frameTypes;

        public EncodeInfo(EncodedImage.FrameType[] frameTypeArr) {
            this.frameTypes = frameTypeArr;
        }
    }

    public static class BitrateAllocation {
        public final int[][] bitratesBbs;

        public BitrateAllocation(int[][] iArr) {
            this.bitratesBbs = iArr;
        }

        public int getSum() {
            int i = 0;
            for (int[] iArr : this.bitratesBbs) {
                for (int i2 : r0[r3]) {
                    i += i2;
                }
            }
            return i;
        }
    }

    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();
        public final Integer high;
        public final Integer low;

        /* renamed from: on */
        public final boolean f8550on;

        public ScalingSettings(int i, int i2) {
            this.f8550on = true;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }

        private ScalingSettings() {
            this.f8550on = false;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z) {
            this.f8550on = z;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z, int i, int i2) {
            this.f8550on = z;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }

        public String toString() {
            if (!this.f8550on) {
                return "OFF";
            }
            return "[ " + this.low + ", " + this.high + " ]";
        }
    }

    public static class ResolutionBitrateLimits {
        public final int frameSizePixels;
        public final int maxBitrateBps;
        public final int minBitrateBps;
        public final int minStartBitrateBps;

        public ResolutionBitrateLimits(int i, int i2, int i3, int i4) {
            this.frameSizePixels = i;
            this.minStartBitrateBps = i2;
            this.minBitrateBps = i3;
            this.maxBitrateBps = i4;
        }

        public int getFrameSizePixels() {
            return this.frameSizePixels;
        }

        public int getMinStartBitrateBps() {
            return this.minStartBitrateBps;
        }

        public int getMinBitrateBps() {
            return this.minBitrateBps;
        }

        public int getMaxBitrateBps() {
            return this.maxBitrateBps;
        }
    }
}
