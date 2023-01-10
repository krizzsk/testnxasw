package net.lingala.zip4j.progress;

public class ProgressMonitor {

    /* renamed from: a */
    private State f6874a;

    /* renamed from: b */
    private long f6875b;

    /* renamed from: c */
    private long f6876c;

    /* renamed from: d */
    private int f6877d;

    /* renamed from: e */
    private Task f6878e;

    /* renamed from: f */
    private String f6879f;

    /* renamed from: g */
    private Result f6880g;

    /* renamed from: h */
    private Exception f6881h;

    /* renamed from: i */
    private boolean f6882i;

    /* renamed from: j */
    private boolean f6883j;

    public enum Result {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    public enum State {
        READY,
        BUSY
    }

    public enum Task {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public ProgressMonitor() {
        m6586a();
    }

    public void updateWorkCompleted(long j) {
        long j2 = this.f6876c + j;
        this.f6876c = j2;
        long j3 = this.f6875b;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.f6877d = i;
            if (i > 100) {
                this.f6877d = 100;
            }
        }
        while (this.f6883j) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void endProgressMonitor() {
        this.f6880g = Result.SUCCESS;
        this.f6877d = 100;
        m6586a();
    }

    public void endProgressMonitor(Exception exc) {
        this.f6880g = Result.ERROR;
        this.f6881h = exc;
        m6586a();
    }

    public void fullReset() {
        m6586a();
        this.f6879f = null;
        this.f6875b = 0;
        this.f6876c = 0;
        this.f6877d = 0;
    }

    /* renamed from: a */
    private void m6586a() {
        this.f6878e = Task.NONE;
        this.f6874a = State.READY;
    }

    public State getState() {
        return this.f6874a;
    }

    public void setState(State state) {
        this.f6874a = state;
    }

    public long getTotalWork() {
        return this.f6875b;
    }

    public void setTotalWork(long j) {
        this.f6875b = j;
    }

    public long getWorkCompleted() {
        return this.f6876c;
    }

    public int getPercentDone() {
        return this.f6877d;
    }

    public void setPercentDone(int i) {
        this.f6877d = i;
    }

    public Task getCurrentTask() {
        return this.f6878e;
    }

    public void setCurrentTask(Task task) {
        this.f6878e = task;
    }

    public String getFileName() {
        return this.f6879f;
    }

    public void setFileName(String str) {
        this.f6879f = str;
    }

    public Result getResult() {
        return this.f6880g;
    }

    public void setResult(Result result) {
        this.f6880g = result;
    }

    public Exception getException() {
        return this.f6881h;
    }

    public void setException(Exception exc) {
        this.f6881h = exc;
    }

    public boolean isCancelAllTasks() {
        return this.f6882i;
    }

    public void setCancelAllTasks(boolean z) {
        this.f6882i = z;
    }

    public boolean isPause() {
        return this.f6883j;
    }

    public void setPause(boolean z) {
        this.f6883j = z;
    }
}
