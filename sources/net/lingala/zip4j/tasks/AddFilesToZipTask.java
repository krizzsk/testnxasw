package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class AddFilesToZipTask extends AbstractAddFileToZipTask<AddFilesToZipTaskParameters> {
    public AddFilesToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* access modifiers changed from: protected */
    public void executeTask(AddFilesToZipTaskParameters addFilesToZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        mo29730a(addFilesToZipTaskParameters.zipParameters);
        mo29727a((List<File>) addFilesToZipTaskParameters.filesToAdd, progressMonitor, addFilesToZipTaskParameters.zipParameters, addFilesToZipTaskParameters.zip4jConfig);
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(AddFilesToZipTaskParameters addFilesToZipTaskParameters) throws ZipException {
        return mo29725a((List<File>) addFilesToZipTaskParameters.filesToAdd, addFilesToZipTaskParameters.zipParameters);
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task getTask() {
        return super.getTask();
    }

    public static class AddFilesToZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */
        public List<File> filesToAdd;
        /* access modifiers changed from: private */
        public ZipParameters zipParameters;

        public AddFilesToZipTaskParameters(List<File> list, ZipParameters zipParameters2, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.filesToAdd = list;
            this.zipParameters = zipParameters2;
        }
    }
}
