package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.RetryStrategy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class FirebaseJobDispatcher {
    public static final int CANCEL_RESULT_NO_DRIVER_AVAILABLE = 2;
    public static final int CANCEL_RESULT_SUCCESS = 0;
    public static final int CANCEL_RESULT_UNKNOWN_ERROR = 1;
    public static final int SCHEDULE_RESULT_BAD_SERVICE = 4;
    public static final int SCHEDULE_RESULT_NO_DRIVER_AVAILABLE = 2;
    public static final int SCHEDULE_RESULT_SUCCESS = 0;
    public static final int SCHEDULE_RESULT_UNKNOWN_ERROR = 1;
    public static final int SCHEDULE_RESULT_UNSUPPORTED_TRIGGER = 3;

    /* renamed from: a */
    private final Driver f54623a;

    /* renamed from: b */
    private final ValidationEnforcer f54624b;

    /* renamed from: c */
    private final RetryStrategy.Builder f54625c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CancelResult {
    }

    public static final class ScheduleFailedException extends RuntimeException {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScheduleResult {
    }

    public FirebaseJobDispatcher(Driver driver) {
        this.f54623a = driver;
        ValidationEnforcer validationEnforcer = new ValidationEnforcer(driver.getValidator());
        this.f54624b = validationEnforcer;
        this.f54625c = new RetryStrategy.Builder(validationEnforcer);
    }

    public int schedule(Job job) {
        if (!this.f54623a.isAvailable()) {
            return 2;
        }
        return this.f54623a.schedule(job);
    }

    public int cancel(String str) {
        if (!this.f54623a.isAvailable()) {
            return 2;
        }
        return this.f54623a.cancel(str);
    }

    public int cancelAll() {
        if (!this.f54623a.isAvailable()) {
            return 2;
        }
        return this.f54623a.cancelAll();
    }

    public void mustSchedule(Job job) {
        if (schedule(job) != 0) {
            throw new ScheduleFailedException();
        }
    }

    public ValidationEnforcer getValidator() {
        return this.f54624b;
    }

    public Job.Builder newJobBuilder() {
        return new Job.Builder(this.f54624b);
    }

    public RetryStrategy newRetryStrategy(int i, int i2, int i3) {
        return this.f54625c.build(i, i2, i3);
    }
}
