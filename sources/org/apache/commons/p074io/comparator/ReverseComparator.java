package org.apache.commons.p074io.comparator;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: org.apache.commons.io.comparator.ReverseComparator */
class ReverseComparator extends AbstractFileComparator implements Serializable {
    private final Comparator<File> delegate;

    public ReverseComparator(Comparator<File> comparator) {
        if (comparator != null) {
            this.delegate = comparator;
            return;
        }
        throw new IllegalArgumentException("Delegate comparator is missing");
    }

    public int compare(File file, File file2) {
        return this.delegate.compare(file2, file);
    }

    public String toString() {
        return super.toString() + Const.jaLeft + this.delegate.toString() + Const.jaRight;
    }
}
