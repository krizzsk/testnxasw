package org.webrtc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class EncodedImage implements RefCounted {
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final boolean completeFrame;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;

    /* renamed from: qp */
    public final Integer f8541qp;
    private final RefCountDelegate refCountDelegate;
    public final int rotation;
    private final boolean supportsRetain;

    public enum FrameType {
        EmptyFrame(0),
        VideoFrameKey(3),
        VideoFrameDelta(4);
        
        private final int nativeIndex;

        private FrameType(int i) {
            this.nativeIndex = i;
        }

        public int getNative() {
            return this.nativeIndex;
        }

        static FrameType fromNativeIndex(int i) {
            for (FrameType frameType : values()) {
                if (frameType.getNative() == i) {
                    return frameType;
                }
            }
            throw new IllegalArgumentException("Unknown native frame type: " + i);
        }
    }

    public void retain() {
        this.refCountDelegate.retain();
    }

    public void release() {
        this.refCountDelegate.release();
    }

    /* access modifiers changed from: package-private */
    public boolean maybeRetain() {
        if (!this.supportsRetain) {
            return false;
        }
        retain();
        return true;
    }

    private EncodedImage(ByteBuffer byteBuffer, boolean z, Runnable runnable, int i, int i2, long j, FrameType frameType2, int i3, boolean z2, Integer num) {
        this.buffer = byteBuffer;
        this.encodedWidth = i;
        this.encodedHeight = i2;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(j);
        this.captureTimeNs = j;
        this.frameType = frameType2;
        this.rotation = i3;
        this.completeFrame = z2;
        this.f8541qp = num;
        this.supportsRetain = z;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    private ByteBuffer getBuffer() {
        return this.buffer;
    }

    private int getEncodedWidth() {
        return this.encodedWidth;
    }

    private int getEncodedHeight() {
        return this.encodedHeight;
    }

    private long getCaptureTimeNs() {
        return this.captureTimeNs;
    }

    private int getFrameType() {
        return this.frameType.getNative();
    }

    private int getRotation() {
        return this.rotation;
    }

    private boolean getCompleteFrame() {
        return this.completeFrame;
    }

    private Integer getQp() {
        return this.f8541qp;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ByteBuffer buffer;
        private long captureTimeNs;
        private boolean completeFrame;
        private int encodedHeight;
        private int encodedWidth;
        private FrameType frameType;

        /* renamed from: qp */
        private Integer f8542qp;
        private Runnable releaseCallback;
        private int rotation;
        private boolean supportsRetain;

        private Builder() {
        }

        @Deprecated
        public Builder setBuffer(ByteBuffer byteBuffer) {
            this.buffer = byteBuffer;
            this.releaseCallback = null;
            this.supportsRetain = false;
            return this;
        }

        public Builder setBuffer(ByteBuffer byteBuffer, Runnable runnable) {
            this.buffer = byteBuffer;
            this.releaseCallback = runnable;
            this.supportsRetain = true;
            return this;
        }

        public Builder setEncodedWidth(int i) {
            this.encodedWidth = i;
            return this;
        }

        public Builder setEncodedHeight(int i) {
            this.encodedHeight = i;
            return this;
        }

        @Deprecated
        public Builder setCaptureTimeMs(long j) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j);
            return this;
        }

        public Builder setCaptureTimeNs(long j) {
            this.captureTimeNs = j;
            return this;
        }

        public Builder setFrameType(FrameType frameType2) {
            this.frameType = frameType2;
            return this;
        }

        public Builder setRotation(int i) {
            this.rotation = i;
            return this;
        }

        public Builder setCompleteFrame(boolean z) {
            this.completeFrame = z;
            return this;
        }

        public Builder setQp(Integer num) {
            this.f8542qp = num;
            return this;
        }

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.supportsRetain, this.releaseCallback, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.f8542qp);
        }
    }
}
