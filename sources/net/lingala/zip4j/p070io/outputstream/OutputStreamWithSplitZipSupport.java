package net.lingala.zip4j.p070io.outputstream;

import java.io.IOException;

/* renamed from: net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport */
public interface OutputStreamWithSplitZipSupport {
    int getCurrentSplitFileCounter();

    long getFilePointer() throws IOException;
}
