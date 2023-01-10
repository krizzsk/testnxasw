package com.google.android.gms.internal.instantapps;

import org.apache.commons.p074io.IOUtils;

final class zzfi {
    static String zzd(zzbp zzbp) {
        zzfl zzfl = new zzfl(zzbp);
        StringBuilder sb = new StringBuilder(zzfl.size());
        for (int i = 0; i < zzfl.size(); i++) {
            byte zzj = zzfl.zzj(i);
            if (zzj == 34) {
                sb.append("\\\"");
            } else if (zzj == 39) {
                sb.append("\\'");
            } else if (zzj != 92) {
                switch (zzj) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzj >= 32 && zzj <= 126) {
                            sb.append((char) zzj);
                            break;
                        } else {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((zzj >>> 6) & 3) + 48));
                            sb.append((char) (((zzj >>> 3) & 7) + 48));
                            sb.append((char) ((zzj & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
