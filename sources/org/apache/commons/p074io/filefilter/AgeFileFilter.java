package org.apache.commons.p074io.filefilter;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.p074io.FileUtils;

/* renamed from: org.apache.commons.io.filefilter.AgeFileFilter */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long j) {
        this(j, true);
    }

    public AgeFileFilter(long j, boolean z) {
        this.acceptOlder = z;
        this.cutoff = j;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z) {
        this(date.getTime(), z);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z) {
        this(file.lastModified(), z);
    }

    public boolean accept(File file) {
        boolean isFileNewer = FileUtils.isFileNewer(file, this.cutoff);
        if (this.acceptOlder) {
            return !isFileNewer;
        }
        return isFileNewer;
    }

    public String toString() {
        String str = this.acceptOlder ? "<=" : IMTextUtils.STREET_IMAGE_TAG_END;
        return super.toString() + "(" + str + this.cutoff + ")";
    }
}
