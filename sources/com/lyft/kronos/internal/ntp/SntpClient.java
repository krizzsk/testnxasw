package com.lyft.kronos.internal.ntp;

import com.google.common.base.Ascii;
import com.lyft.kronos.Clock;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class SntpClient {

    /* renamed from: a */
    private static final int f58505a = 24;

    /* renamed from: b */
    private static final int f58506b = 32;

    /* renamed from: c */
    private static final int f58507c = 40;

    /* renamed from: d */
    private static final int f58508d = 48;

    /* renamed from: e */
    private static final int f58509e = 123;

    /* renamed from: f */
    private static final int f58510f = 3;

    /* renamed from: g */
    private static final int f58511g = 4;

    /* renamed from: h */
    private static final int f58512h = 5;

    /* renamed from: i */
    private static final int f58513i = 3;

    /* renamed from: j */
    private static final int f58514j = 3;

    /* renamed from: k */
    private static final int f58515k = 0;

    /* renamed from: l */
    private static final int f58516l = 15;

    /* renamed from: m */
    private static final long f58517m = 2208988800L;

    /* renamed from: n */
    private static final long f58518n = 1000;

    /* renamed from: o */
    private final Clock f58519o;

    /* renamed from: p */
    private final DnsResolver f58520p;

    /* renamed from: q */
    private final DatagramFactory f58521q;

    private static class InvalidServerReplyException extends IOException {
        public InvalidServerReplyException(String str) {
            super(str);
        }
    }

    public SntpClient(Clock clock, DnsResolver dnsResolver, DatagramFactory datagramFactory) {
        this.f58519o = clock;
        this.f58520p = dnsResolver;
        this.f58521q = datagramFactory;
    }

    public Response requestTime(String str, Long l) throws IOException {
        DatagramSocket datagramSocket = null;
        try {
            InetAddress resolve = this.f58520p.resolve(str);
            datagramSocket = this.f58521q.createSocket();
            datagramSocket.setSoTimeout(l.intValue());
            byte[] bArr = new byte[48];
            DatagramPacket createPacket = this.f58521q.createPacket(bArr, resolve, 123);
            bArr[0] = Ascii.ESC;
            long currentTimeMs = this.f58519o.getCurrentTimeMs();
            long elapsedTimeMs = this.f58519o.getElapsedTimeMs();
            m44321a(bArr, 40, currentTimeMs);
            datagramSocket.send(createPacket);
            byte[] copyOf = Arrays.copyOf(bArr, 48);
            datagramSocket.receive(this.f58521q.createPacket(copyOf));
            long elapsedTimeMs2 = this.f58519o.getElapsedTimeMs();
            long j = currentTimeMs + (elapsedTimeMs2 - elapsedTimeMs);
            long a = m44319a(copyOf, 24);
            long a2 = m44319a(copyOf, 32);
            long j2 = elapsedTimeMs2;
            long a3 = m44319a(copyOf, 40);
            m44320a((byte) ((copyOf[0] >> 6) & 3), (byte) (copyOf[0] & 7), copyOf[1] & 255, a3);
            return new Response(j, j2, ((a2 - a) + (a3 - j)) / 2, this.f58519o);
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }

    /* renamed from: a */
    private static void m44320a(byte b, byte b2, int i, long j) throws InvalidServerReplyException {
        if (b == 3) {
            throw new InvalidServerReplyException("unsynchronized server");
        } else if (b2 != 4 && b2 != 5) {
            throw new InvalidServerReplyException("untrusted mode: " + b2);
        } else if (i == 0 || i > 15) {
            throw new InvalidServerReplyException("untrusted stratum: " + i);
        } else if (j == 0) {
            throw new InvalidServerReplyException("zero transmitTime");
        }
    }

    /* renamed from: b */
    private static long m44322b(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = b & true;
        int i2 = b;
        if (b5 == true) {
            i2 = (b & Byte.MAX_VALUE) + 128;
        }
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + 128;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + 128;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + 128;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    /* renamed from: a */
    static long m44319a(byte[] bArr, int i) {
        return ((m44322b(bArr, i) - f58517m) * 1000) + ((m44322b(bArr, i + 4) * 1000) / 4294967296L);
    }

    /* renamed from: a */
    private static void m44321a(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + f58517m;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j4 >> 24));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j4 >> 16));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j4 >> 8));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j4 >> 0));
        long j5 = (j3 * 4294967296L) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j5 >> 24));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j5 >> 16));
        bArr[i7] = (byte) ((int) (j5 >> 8));
        bArr[i7 + 1] = (byte) ((int) (Math.random() * 255.0d));
    }

    public static final class Response {
        private final Clock deviceClock;
        private final long deviceCurrentTimestampMs;
        private final long deviceElapsedTimestampMs;
        private final long offsetMs;

        Response(long j, long j2, long j3, Clock clock) {
            this.deviceCurrentTimestampMs = j;
            this.deviceElapsedTimestampMs = j2;
            this.offsetMs = j3;
            this.deviceClock = clock;
        }

        /* access modifiers changed from: package-private */
        public long getDeviceCurrentTimestampMs() {
            return this.deviceCurrentTimestampMs;
        }

        /* access modifiers changed from: package-private */
        public long getDeviceElapsedTimestampMs() {
            return this.deviceElapsedTimestampMs;
        }

        public long getCurrentTimeMs() {
            return this.deviceCurrentTimestampMs + this.offsetMs + getResponseAge();
        }

        public long getOffsetMs() {
            return this.offsetMs;
        }

        public long getResponseAge() {
            return this.deviceClock.getElapsedTimeMs() - this.deviceElapsedTimestampMs;
        }

        /* access modifiers changed from: package-private */
        public boolean isFromSameBoot() {
            return Math.abs((this.deviceCurrentTimestampMs - this.deviceElapsedTimestampMs) - (this.deviceClock.getCurrentTimeMs() - this.deviceClock.getElapsedTimeMs())) < 1000;
        }
    }
}
