package com.didichuxing.omega.sdk.analysis;

public class AnalysisDelegater {
    private static boolean appIn = true;
    private static String currentPageName = "";
    private static String fragmentName = "";

    public static void setFragmentName(String str) {
        fragmentName = str;
    }

    public static void setCurrentPageName(String str) {
        currentPageName = str;
    }

    public static synchronized void setAppIn(boolean z) {
        synchronized (AnalysisDelegater.class) {
            appIn = z;
        }
    }

    public static String getCurrentFramentName() {
        return fragmentName;
    }

    public static String getCurrentPageName() {
        return currentPageName;
    }

    public static synchronized boolean isAppIn() {
        boolean z;
        synchronized (AnalysisDelegater.class) {
            z = appIn;
        }
        return z;
    }
}
