package com.didi.payment.utilities;

import com.didi.payment.base.utils.WalletApolloUtil;
import java.util.Arrays;
import java.util.List;

public class CsInputFilter {

    /* renamed from: a */
    private static final String f34082a = "[^0-9]";

    /* renamed from: b */
    private List<Integer> f34083b;

    /* renamed from: c */
    private List<Integer> f34084c;

    /* renamed from: d */
    private char f34085d;

    /* renamed from: e */
    private char f34086e;

    public CsInputFilter() {
        if (WalletApolloUtil.isBoletoScanOptEnable()) {
            this.f34085d = '-';
            this.f34086e = 10;
            this.f34083b = Arrays.asList(new Integer[]{11, 23, 35, 47});
            this.f34084c = Arrays.asList(new Integer[]{12, 24, 36});
            return;
        }
        this.f34085d = '.';
        this.f34086e = ' ';
        this.f34083b = Arrays.asList(new Integer[]{5, 15, 25});
        this.f34084c = Arrays.asList(new Integer[]{10, 21, 32, 33});
    }

    public CsInputFilter(char c, char c2) {
        this(c, Arrays.asList(new Integer[]{11, 23, 35, 47}), c2, Arrays.asList(new Integer[]{12, 24, 36}));
    }

    public CsInputFilter(char c, List<Integer> list, char c2, List<Integer> list2) {
        this.f34085d = c;
        this.f34086e = c2;
        this.f34083b = list;
        this.f34084c = list2;
    }

    public String wrapperString(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (this.f34083b.contains(Integer.valueOf(i))) {
                sb.append(this.f34085d);
            }
            if (this.f34084c.contains(Integer.valueOf(i))) {
                sb.append(this.f34086e);
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String removeNonNumber(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(f34082a, "");
    }
}
