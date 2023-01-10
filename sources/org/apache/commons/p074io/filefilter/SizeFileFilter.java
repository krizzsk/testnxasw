package org.apache.commons.p074io.filefilter;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.SizeFileFilter */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    public SizeFileFilter(long j, boolean z) {
        if (j >= 0) {
            this.size = j;
            this.acceptLarger = z;
            return;
        }
        throw new IllegalArgumentException("The size must be non-negative");
    }

    public boolean accept(File file) {
        boolean z = file.length() < this.size;
        if (!this.acceptLarger) {
            return z;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = this.acceptLarger ? ">=" : IMTextUtils.STREET_IMAGE_TAG_START;
        return super.toString() + "(" + str + this.size + ")";
    }
}
