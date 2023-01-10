package com.threatmetrix.TrustDefender;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

public class yqyyyq {
    private static final String b0061aa00610061a = yyyyqy.b0074t007400740074t(yqyyyq.class);
    private volatile boolean b00610061006100610061a = false;
    private volatile boolean b00610061a00610061a = false;
    private volatile boolean b0061a006100610061a = false;
    @Nullable
    private CountDownLatch b0061aaaa0061 = null;
    private volatile boolean ba0061006100610061a = false;
    private volatile boolean ba0061a00610061a = false;
    private volatile boolean baa006100610061a = false;
    private final ReentrantReadWriteLock baaa00610061a = new ReentrantReadWriteLock();
    @Nullable
    private CountDownLatch baaaaa0061 = null;

    private CountDownLatch b0078xxxx0078(boolean z) {
        this.baaa00610061a.readLock().lock();
        try {
            if (this.ba0061006100610061a && this.b0061aaaa0061 != null && (!z || this.b00610061006100610061a)) {
                return this.b0061aaaa0061;
            }
            this.baaa00610061a.readLock().unlock();
            return null;
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public void b00780078007800780078x() {
        this.baaa00610061a.writeLock().lock();
        try {
            this.b00610061a00610061a = false;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public boolean b0078007800780078x0078(boolean z, @Nullable Long l) {
        CountDownLatch b0078xxxx0078 = b0078xxxx0078(z);
        boolean z2 = true;
        if (b0078xxxx0078 == null) {
            return true;
        }
        yyyyqy.bt0074007400740074t(b0061aa00610061a, "waitForScan: Waiting for scan to complete");
        if (l == null) {
            try {
                b0078xxxx0078.await();
            } catch (InterruptedException unused) {
                yyyyqy.bt0074007400740074t(b0061aa00610061a, "waitForScan was interrupted");
                return false;
            }
        } else {
            z2 = b0078xxxx0078.await(l.longValue(), TimeUnit.MILLISECONDS);
        }
        return z2;
    }

    public boolean b007800780078xx0078(boolean z) {
        CountDownLatch b0078xxxx0078 = b0078xxxx0078(z);
        return b0078xxxx0078 != null && b0078xxxx0078.getCount() > 0;
    }

    public boolean b00780078x0078x0078() {
        boolean z;
        this.baaa00610061a.writeLock().lock();
        try {
            if (!this.ba0061a00610061a) {
                z = true;
                this.ba0061a00610061a = true;
                this.baaaaa0061 = new CountDownLatch(1);
            } else {
                z = false;
            }
            return z;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public boolean b00780078xxx0078() {
        this.baaa00610061a.readLock().lock();
        try {
            CountDownLatch countDownLatch = this.baaaaa0061;
            return this.ba0061a00610061a && countDownLatch != null && countDownLatch.getCount() == 0;
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public boolean b0078x007800780078x() {
        this.baaa00610061a.writeLock().lock();
        try {
            if (this.b0061a006100610061a) {
                this.b0061a006100610061a = false;
                return true;
            }
            this.baaa00610061a.writeLock().unlock();
            return false;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public boolean b0078x00780078x0078(boolean z) {
        this.baaa00610061a.writeLock().lock();
        try {
            if (!this.ba0061006100610061a) {
                if (this.b0061a006100610061a) {
                    yyyyqy.bt0074007400740074t(b0061aa00610061a, "startScanning: aborted, marked as cancelled");
                    this.b0061a006100610061a = false;
                } else {
                    this.ba0061006100610061a = true;
                    this.b0061aaaa0061 = new CountDownLatch(1);
                    this.b00610061006100610061a = z;
                    this.baaa00610061a.writeLock().unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public boolean b0078x0078xx0078() {
        this.baaa00610061a.readLock().lock();
        try {
            return this.ba0061a00610061a;
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public boolean b0078xx0078x0078() {
        boolean z;
        this.baaa00610061a.writeLock().lock();
        try {
            if (!this.baa006100610061a) {
                z = true;
                this.baa006100610061a = true;
            } else {
                z = false;
            }
            return z;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public void bx0078007800780078x(boolean z) {
        this.baaa00610061a.readLock().lock();
        try {
            this.ba0061a00610061a = z;
            CountDownLatch countDownLatch = this.baaaaa0061;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public boolean bx007800780078x0078(int i) {
        boolean z;
        this.baaa00610061a.readLock().lock();
        try {
            boolean z2 = false;
            if (this.ba0061a00610061a) {
                if (this.baaaaa0061 != null) {
                    CountDownLatch countDownLatch = this.baaaaa0061;
                    this.baaa00610061a.readLock().unlock();
                    yyyyqy.bt0074007400740074t(b0061aa00610061a, "Waiting for init to complete");
                    try {
                        z = countDownLatch.await((long) i, TimeUnit.MILLISECONDS);
                        if (!z) {
                            try {
                                yyyyqy.bt0074t00740074t(b0061aa00610061a, "Timed out waiting for init to complete");
                            } catch (InterruptedException e) {
                                e = e;
                            }
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        z = false;
                        yyyyqy.b00740074t00740074t(b0061aa00610061a, "Waiting for init to complete interrupted", e);
                        this.baaa00610061a.readLock().lock();
                        z2 = true;
                        return z2;
                    }
                    this.baaa00610061a.readLock().lock();
                    try {
                        if (this.ba0061a00610061a && z) {
                            z2 = true;
                        }
                        return z2;
                    } finally {
                        this.baaa00610061a.readLock().unlock();
                    }
                }
            }
            yyyyqy.bt0074007400740074t(b0061aa00610061a, "init not in progress, nothing to wait for");
            return false;
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public boolean bx00780078xx0078() {
        this.baaa00610061a.readLock().lock();
        try {
            return this.b00610061a00610061a;
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public boolean bx0078x0078x0078() {
        boolean z;
        yyyyqy.bt0074007400740074t(b0061aa00610061a, "Attempting to cancel scanPackages");
        this.baaa00610061a.writeLock().lock();
        try {
            if (!this.b0061a006100610061a) {
                this.b0061a006100610061a = true;
                z = this.ba0061006100610061a;
            } else {
                z = false;
            }
            return z;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public boolean bx0078xxx0078() {
        this.baaa00610061a.readLock().lock();
        try {
            return this.baa006100610061a;
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public boolean bxx007800780078x() {
        this.baaa00610061a.writeLock().lock();
        try {
            if (this.baa006100610061a) {
                this.baa006100610061a = false;
                return true;
            }
            this.baaa00610061a.writeLock().unlock();
            return false;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public boolean bxx00780078x0078() {
        this.baaa00610061a.writeLock().lock();
        try {
            if (!this.b00610061a00610061a) {
                this.b00610061a00610061a = true;
                this.baa006100610061a = false;
                return true;
            }
            this.baaa00610061a.writeLock().unlock();
            return false;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public boolean bxx0078xx0078() {
        this.baaa00610061a.readLock().lock();
        try {
            CountDownLatch countDownLatch = this.ba0061a00610061a ? this.baaaaa0061 : null;
            return countDownLatch != null && countDownLatch.getCount() > 0;
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }

    public void bxxx0078x0078() {
        this.baaa00610061a.writeLock().lock();
        try {
            this.ba0061a00610061a = false;
            this.b00610061a00610061a = false;
            this.ba0061006100610061a = false;
            this.b00610061006100610061a = false;
            this.b0061a006100610061a = false;
            this.baa006100610061a = false;
        } finally {
            this.baaa00610061a.writeLock().unlock();
        }
    }

    public void bxxxxx0078() {
        CountDownLatch countDownLatch;
        this.baaa00610061a.readLock().lock();
        try {
            if (this.ba0061006100610061a) {
                this.ba0061006100610061a = false;
                this.b0061a006100610061a = false;
                this.b00610061006100610061a = false;
                countDownLatch = this.b0061aaaa0061;
            } else {
                countDownLatch = null;
            }
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } finally {
            this.baaa00610061a.readLock().unlock();
        }
    }
}
