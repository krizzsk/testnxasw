package com.didi.map.global.sdk.movement.sensor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.util.DLog;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.sdk.movement.apollo.MovementApolloUtil;
import java.util.ArrayList;
import java.util.List;

public class StepDetection implements OrientationListener {

    /* renamed from: a */
    private static final float f30202a = MovementApolloUtil.getEngineStepLength();

    /* renamed from: b */
    private static final long f30203b = 400;

    /* renamed from: c */
    private static final long f30204c = 1000;

    /* renamed from: d */
    private static final float f30205d = 11.0f;

    /* renamed from: e */
    private static final float f30206e = 16.0f;

    /* renamed from: f */
    private static final float f30207f = 0.01f;

    /* renamed from: g */
    private static final float f30208g = 8.61f;

    /* renamed from: h */
    private Context f30209h;

    /* renamed from: i */
    private List<Acceleration> f30210i;

    /* renamed from: j */
    private WorkThread f30211j;

    /* renamed from: k */
    private long f30212k;

    /* renamed from: l */
    private long f30213l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public onDidiMovementListener f30214m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Acceleration f30215n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Acceleration f30216o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f30217p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Movement f30218q = Movement.STAY;

    /* renamed from: r */
    private PdrPoint f30219r;

    /* renamed from: s */
    private int f30220s;

    /* renamed from: t */
    private long f30221t;

    /* renamed from: u */
    private float f30222u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Handler f30223v = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            Movement movement;
            super.handleMessage(message);
            if (message.what == 0 && StepDetection.this.f30214m != null) {
                StepDetection.m23486b(StepDetection.this);
                StepDetection.this.f30214m.onNewStep(StepDetection.this.f30217p);
                StepDetection.this.m23485a();
            }
            if (!(message.what != 1 || StepDetection.this.f30214m == null || (movement = (Movement) message.obj) == StepDetection.this.f30218q || movement == null)) {
                Movement unused = StepDetection.this.f30218q = movement;
                StepDetection.this.f30214m.onPrintLog(StepDetection.this.f30218q.toString());
                StepDetection.this.f30214m.onMovementChanged(StepDetection.this.f30218q);
            }
            if (message.what == 2 && StepDetection.this.f30214m != null) {
                StepDetection.this.f30214m.onPrintLog((String) message.obj);
            }
        }
    };

    /* renamed from: b */
    static /* synthetic */ int m23486b(StepDetection stepDetection) {
        int i = stepDetection.f30217p;
        stepDetection.f30217p = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23485a() {
        DLog.m10773d("StepDetection", "onNew PdrPoint：" + this.f30219r, new Object[0]);
        if (this.f30219r == null) {
            this.f30219r = new PdrPoint(0.0f, 0.0f);
            this.f30220s = this.f30217p;
            this.f30221t = System.currentTimeMillis();
            onDidiMovementListener ondidimovementlistener = this.f30214m;
            if (ondidimovementlistener != null) {
                ondidimovementlistener.onPdrPointChanged(this.f30219r);
                return;
            }
            return;
        }
        int i = this.f30217p;
        int i2 = this.f30220s;
        if (i > i2) {
            float f = f30202a * ((float) (i - i2));
            DLog.m10773d("StepDetection", "步行速度：" + ((f / ((float) (System.currentTimeMillis() - this.f30221t))) * 1000.0f), new Object[0]);
            this.f30219r = PdrPoint.getNextPoint(this.f30219r, f, this.f30222u);
            this.f30220s = this.f30217p;
            this.f30221t = System.currentTimeMillis();
            onDidiMovementListener ondidimovementlistener2 = this.f30214m;
            if (ondidimovementlistener2 != null) {
                ondidimovementlistener2.onPdrPointChanged(this.f30219r);
            }
        }
    }

    public StepDetection(Context context, long j, onDidiMovementListener ondidimovementlistener) {
        this.f30213l = j;
        this.f30214m = ondidimovementlistener;
        this.f30211j = new WorkThread();
        this.f30212k = System.currentTimeMillis();
        this.f30209h = context;
        OrientationManager.getInstance(context).addOrientationListener(this);
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        this.f30222u = (f + 360.0f) % 360.0f;
    }

    public void onReceiveAcceleration(Acceleration acceleration) {
        WorkThread workThread;
        if (acceleration != null) {
            if (this.f30210i == null) {
                this.f30210i = new ArrayList();
            }
            onDidiMovementListener ondidimovementlistener = this.f30214m;
            if (ondidimovementlistener != null) {
                ondidimovementlistener.onShowLine(acceleration.data);
            }
            this.f30210i.add(acceleration);
            if (System.currentTimeMillis() - this.f30212k > this.f30213l && (workThread = this.f30211j) != null) {
                workThread.executeTask(new MyTask(this.f30210i));
                this.f30210i = null;
                this.f30212k = System.currentTimeMillis();
            }
        }
    }

    public void destroy() {
        WorkThread workThread = this.f30211j;
        if (workThread != null) {
            workThread.destroy();
            this.f30211j = null;
        }
        this.f30214m = null;
        Handler handler = this.f30223v;
        if (handler != null) {
            handler.removeMessages(0);
            this.f30223v.removeMessages(1);
            this.f30223v.removeMessages(2);
            this.f30223v = null;
        }
        List<Acceleration> list = this.f30210i;
        if (list != null) {
            list.clear();
            this.f30210i = null;
        }
        OrientationManager.getInstance(this.f30209h).removeOrientationListener(this);
        this.f30209h = null;
    }

    private class MyTask implements Runnable {
        private List<Acceleration> values;

        public MyTask(List<Acceleration> list) {
            this.values = list;
        }

        public void run() {
            int i;
            List<Acceleration> list = this.values;
            if (list == null || !list.isEmpty()) {
                int size = this.values.size();
                int[] iArr = new int[size];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    i = size - 1;
                    if (i3 >= i) {
                        break;
                    }
                    int i4 = i3 + 1;
                    if (this.values.get(i4).data - this.values.get(i3).data > 0.0f) {
                        iArr[i3] = 1;
                    } else if (this.values.get(i4).data - this.values.get(i3).data < 0.0f) {
                        iArr[i3] = -1;
                    } else {
                        iArr[i3] = 0;
                    }
                    i3 = i4;
                }
                for (int i5 = 1; i5 < i; i5++) {
                    if (iArr[i5] == 0) {
                        if (i5 == size - 2) {
                            if (iArr[i5 - 1] >= 0) {
                                iArr[i5] = 1;
                            } else {
                                iArr[i5] = -1;
                            }
                        } else if (iArr[i5 + 1] >= 0) {
                            iArr[i5] = 1;
                        } else {
                            iArr[i5] = -1;
                        }
                    }
                }
                while (i2 < i) {
                    int i6 = i2 + 1;
                    int i7 = iArr[i6] - iArr[i2];
                    Acceleration acceleration = this.values.get(i6);
                    if (i7 == -2) {
                        if (checkThresholdTop(acceleration)) {
                            callBackNewStep();
                        }
                    } else if (i7 == 2) {
                        checkThresholdBom(acceleration);
                    }
                    i2 = i6;
                }
                if (StepDetection.this.f30215n == null || System.currentTimeMillis() - StepDetection.this.f30215n.time > 2000) {
                    callBackMovement(Movement.STAY);
                }
            }
        }

        private void checkThresholdBom(Acceleration acceleration) {
            if (acceleration == null) {
                callBackLog("checkThresholdBom 入参: null ");
            } else if (acceleration.data < StepDetection.f30207f || acceleration.data > StepDetection.f30208g) {
                callBackLog("checkThresholdBom : 不符合阈值，伪波谷： " + acceleration.data);
            } else if (StepDetection.this.f30215n != null) {
                Acceleration unused = StepDetection.this.f30216o = acceleration;
                callBackLog("checkThresholdBom : 新波谷： " + acceleration.data);
            } else {
                callBackLog("checkThresholdBom : 等待波峰： " + acceleration.data);
            }
        }

        private boolean checkThresholdTop(Acceleration acceleration) {
            if (acceleration == null) {
                callBackLog("checkThresholdTop 入参: null ");
                return false;
            } else if (acceleration.data < StepDetection.f30205d || acceleration.data > StepDetection.f30206e) {
                callBackLog("checkThreshold 超出阈值，伪波峰, " + acceleration.data);
                return false;
            } else if (StepDetection.this.f30215n != null) {
                float f = (float) (acceleration.time - StepDetection.this.f30215n.time);
                if (f < 400.0f) {
                    callBackLog("checkThreshold 时间太短，伪波峰, " + acceleration.data + "," + f);
                    return false;
                } else if (f > 1000.0f) {
                    Acceleration unused = StepDetection.this.f30215n = acceleration;
                    Acceleration unused2 = StepDetection.this.f30216o = null;
                    callBackLog("checkThreshold 时间太长,重置， 新波峰, " + acceleration.data + "," + f);
                    return false;
                } else if (StepDetection.this.f30216o == null || StepDetection.this.f30215n.time >= StepDetection.this.f30216o.time) {
                    callBackLog("checkThreshold 连续波峰,丢弃 " + acceleration.data + "," + f);
                    return false;
                } else {
                    Acceleration unused3 = StepDetection.this.f30215n = acceleration;
                    callBackLog("2个波峰＋一个波谷， 走了一步," + acceleration.data + "," + f);
                    return true;
                }
            } else {
                callBackLog("checkThreshold 首个波峰, " + acceleration.data);
                Acceleration unused4 = StepDetection.this.f30215n = acceleration;
                Acceleration unused5 = StepDetection.this.f30216o = null;
                return false;
            }
        }

        private void callBackLog(String str) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            StepDetection.this.f30223v.sendMessage(obtain);
        }

        private void callBackNewStep() {
            Message obtain = Message.obtain();
            obtain.what = 0;
            StepDetection.this.f30223v.sendMessage(obtain);
            callBackMovement(Movement.WALKING);
        }

        private void callBackMovement(Movement movement) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = movement;
            StepDetection.this.f30223v.sendMessage(obtain);
        }
    }

    public static class Acceleration {
        float data;
        long time;

        public Acceleration(float f, long j) {
            this.data = f;
            this.time = j;
        }

        public String toString() {
            return "data: " + this.data + "-----time= " + this.time;
        }
    }
}
