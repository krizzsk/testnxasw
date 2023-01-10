package com.didichuxing.mas.sdk.quality.collect.perfromacedetect.cpu;

import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.math.BigDecimal;

public class CpuUtils {

    /* renamed from: a */
    private static boolean f50769a = true;

    /* renamed from: b */
    private static double f50770b;

    /* renamed from: c */
    private static double f50771c;

    /* renamed from: d */
    private static double f50772d;

    /* renamed from: e */
    private static double f50773e;

    /* renamed from: f */
    private static double f50774f;

    /* renamed from: g */
    private static double f50775g;

    /* renamed from: h */
    private static double f50776h;

    public static long getJif() {
        return (long) f50772d;
    }

    public static double getCpuUsage() {
        RandomAccessFile randomAccessFile = null;
        double d = 0.0d;
        if (f50769a) {
            f50769a = false;
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/stat", "r");
                try {
                    String[] split = randomAccessFile2.readLine().split(" ");
                    f50771c = Double.parseDouble(split[5]);
                    f50770b = Double.parseDouble(split[2]) + Double.parseDouble(split[3]) + Double.parseDouble(split[4]) + Double.parseDouble(split[6]) + Double.parseDouble(split[8]) + Double.parseDouble(split[7]);
                    FileUtil.closeRandomAccessFile(randomAccessFile2);
                } catch (IOException e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    try {
                        e.printStackTrace();
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        return d;
                    } catch (Throwable th) {
                        th = th;
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    FileUtil.closeRandomAccessFile(randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                FileUtil.closeRandomAccessFile(randomAccessFile);
                return d;
            }
        } else {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile("/proc/stat", "r");
                try {
                    String[] split2 = randomAccessFile3.readLine().split(" ");
                    double parseDouble = Double.parseDouble(split2[5]);
                    double parseDouble2 = Double.parseDouble(split2[2]) + Double.parseDouble(split2[3]) + Double.parseDouble(split2[4]) + Double.parseDouble(split2[6]) + Double.parseDouble(split2[8]) + Double.parseDouble(split2[7]);
                    double d2 = parseDouble2 + parseDouble;
                    if (0.0d != d2 - (f50770b + f50771c)) {
                        double div = div((parseDouble2 - f50770b) * 100.0d, d2 - (f50770b + f50771c), 2);
                        if (div >= 0.0d) {
                            d = div > 100.0d ? 100.0d : div;
                        }
                    }
                    f50770b = parseDouble2;
                    f50771c = parseDouble;
                    FileUtil.closeRandomAccessFile(randomAccessFile3);
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile3;
                    try {
                        e.printStackTrace();
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        return d;
                    } catch (Throwable th3) {
                        th = th3;
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = randomAccessFile3;
                    FileUtil.closeRandomAccessFile(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                FileUtil.closeRandomAccessFile(randomAccessFile);
                return d;
            }
        }
        return d;
    }

    public static String[] getProcessCpuAction(int i) {
        BufferedReader bufferedReader;
        Exception e;
        String[] strArr = new String[3];
        File file = new File("/proc/" + i + "/stat");
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(" ");
                        strArr[0] = split[1];
                        strArr[1] = split[13];
                        strArr[2] = split[14];
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                }
            } catch (Exception e3) {
                Exception exc = e3;
                bufferedReader = null;
                e = exc;
                e.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            }
            FileUtil.closeReader(bufferedReader);
        }
        return strArr;
    }

    public CpuUtils() {
        m37795a();
    }

    /* renamed from: a */
    private void m37795a() {
        f50775g = 0.0d;
        f50773e = 0.0d;
        f50776h = 0.0d;
        f50774f = 0.0d;
    }

    public static double getProcessCpuUsage(int i) {
        double d = 0.0d;
        if (i >= 0) {
            try {
                String[] processCpuAction = getProcessCpuAction(i);
                if (processCpuAction != null) {
                    f50773e = Double.parseDouble(processCpuAction[1]) + Double.parseDouble(processCpuAction[2]);
                }
                String[] cpuAction = getCpuAction();
                if (cpuAction != null) {
                    f50774f = 0.0d;
                    for (int i2 = 2; i2 < cpuAction.length; i2++) {
                        if (cpuAction[i2] != null) {
                            f50774f += Double.parseDouble(cpuAction[i2]);
                        }
                    }
                }
                if (f50774f - f50776h != 0.0d) {
                    double div = div((f50773e - f50775g) * 100.0d, f50774f - f50776h, 2);
                    if (div >= 0.0d) {
                        d = div > 100.0d ? 100.0d : div;
                    }
                }
                f50775g = f50773e;
                f50776h = f50774f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        f50772d = f50773e;
        return d;
    }

    public static String[] getCpuAction() {
        BufferedReader bufferedReader;
        FileNotFoundException e;
        IOException e2;
        Exception e3;
        String[] strArr = new String[7];
        File file = new File("/proc/stat");
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        strArr = readLine.split(" ");
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                } catch (IOException e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                } catch (Exception e6) {
                    e3 = e6;
                    e3.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedReader = null;
                e.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            } catch (IOException e8) {
                e2 = e8;
                bufferedReader = null;
                e2.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            } catch (Exception e9) {
                e3 = e9;
                bufferedReader = null;
                e3.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            }
            FileUtil.closeReader(bufferedReader);
        }
        return strArr;
    }

    public static synchronized String getTopCpuUseThreadInfo() {
        String sb;
        synchronized (CpuUtils.class) {
            StringBuilder sb2 = new StringBuilder();
            try {
                InputStream inputStream = Runtime.getRuntime().exec("top -m 10 -t -s cpu -n 1").getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        if (!readLine.contains("top")) {
                            sb2.append(readLine);
                            sb2.append("\r\n");
                        }
                    }
                }
                if (inputStream != null) {
                    bufferedReader.close();
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static double div(double d, double d2, int i) {
        try {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 1).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }
}
