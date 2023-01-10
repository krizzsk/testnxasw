package jumio.core;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import okio.Utf8;
import org.bouncycastle.crypto.signers.PSSSigner;

/* renamed from: jumio.core.b0 */
/* compiled from: PinningConfig */
public class C19465b0 {

    /* renamed from: a */
    public static final byte[][] f55328a = {m41119a(new byte[]{-83, -111, -98, 73, 107, 60, -76, 2, -110, Utf8.REPLACEMENT_BYTE, Ascii.f55149SO, -124, Ascii.DC4, 107, 62, 114, 91, -91, 62, 93, 33, -74, 1, -14, SignedBytes.MAX_POWER_OF_TWO, Ascii.f55141FF, -10, 80, 104, 55, -90, -121, 88, 84, -75, -84, -33, -98, Ascii.NAK, -104, -127, -31, 8, -113, -17, 52, Ascii.ESC, Ascii.SUB, 115, -53, -55, -15, 0, 78, -32, 32, -109, 102, 37, 71, 16, 76, -122, -60, -74, -43, 19, 48, -81, -50, -20, -38, -60, -106, -62, 68, -23, 10, 81, -87, 78, 9, -10, -79, Ascii.SYN, -123, 47, 91, 9, 79, 67, Ascii.ESC, 81, PSSSigner.TRAILER_IMPLICIT, 97, -90, -112, 68, 33, -96, -63, -53, 66, 105, Ascii.f55141FF, -79, 50, 11, 79, 6, -44, -93, -32, 9, -13, -90, -11, -38, -99, 82, -86, -63, 109, -71, 61, -19, -20, -17, 119, -42, Ascii.f55151US, Ascii.DC4, 19, -3, -112, -109, 32, -116, 39, 19, -83, 52, -52, Ascii.f55148SI, 16, -119, -84, -66, 122, 52, -57, 37, 95, -6, 89, -84, -64, Ascii.f55147RS, 1, Utf8.REPLACEMENT_BYTE, Ascii.f55141FF, -47, 4, 72, 82, 122, -95, -39, -73, 114, 68, 72, -72, -58, -6, -83, 52, 57, -69, 2, 87, 33, Ascii.f55139CR, -58, 5, 2, -126, Ascii.DC2, 85, 101, 36, -34, -2, -81, -30, 108, 85, Utf8.REPLACEMENT_BYTE, 55, -105, 126, -4, 86, -56, -61, 109, -126, -125, Ascii.SUB, -28, -51, 76, -47, -7, -94, 2, 62, -58, 4, -10, Ascii.f55151US, 93, -40, 112, 36, Ascii.f55140EM, -51, -24, 61, 71, -18, 116, 65, 74, 81, -48, PSSSigner.TRAILER_IMPLICIT, -32, Ascii.f55139CR, -113, 82, -127, -71, 110, -34, -118, 65, -5, 67, 77, 123, 44, -27, -66, -45, -22, Ascii.ETB, Ascii.f55147RS, 85, 51, 74, -109, 33, 124, -102, -56, -105, -22, Ascii.SUB, -49, -28, Ascii.DC2, Ascii.SUB, 78, 70, -96, Ascii.DC4, -54, 68, -16, -55, -83, 4, 89, Byte.MAX_VALUE, -32, -111, -35, -37, 116, -118, 1, 53, -61, -7, -112, 110, 67, -58, 5, -1, -57, -4, PSSSigner.TRAILER_IMPLICIT, -62, 112, -110, 39, -33, Ascii.f55148SI, -55, 124, -118, -86, 114, 62, -27, -40, 81, 114, 5, -15, 66, 95, 0, -43, -60, -52, Ascii.f55149SO, -33, Byte.MIN_VALUE, -91, Ascii.f55141FF, Ascii.f55142FS, 110, -114, 66, -101, -43, Ascii.f55147RS, 58, -81, 89, -92, 52, -6, 120, Ascii.DC4, -121, 41, 76, 70, 120, 33, -1, 9, -104, Ascii.NAK, -106, -58, 1, -76, Utf8.REPLACEMENT_BYTE, -8, 17, -25, -66, 89, 104, -40, 85, -7, -59, -39, -126, Ascii.SYN, 11, 53, -30, 124, 122, 113, -73, -73, 92, -52, -109, -125, -76, -73, -85, 86}, -1725431839737024503L), m41119a(new byte[]{37, -23, 89, 99, -69, 83, Ascii.f55148SI, -92, 60, 53, 95, -39, -79, 33, 57, -60, 100, Ascii.f55140EM, 123, -5, 38, -46, Ascii.f55142FS, 87, -41, 81, -55, 42, SignedBytes.MAX_POWER_OF_TWO, -48, 90, -89, 38, 4, 40, -35, -114, Ascii.SUB, -59, -46, -83, 95, -67, -67, 37, 2, 60, 81, -16, 0, 9, -111, 66, 80, -29, 19, 117, 98, 84, 83, 73, -53, Ascii.f55151US, Ascii.CAN, -36, 97, -15, Ascii.SUB, -110, 16, -43, -25, 33, 88, -80, 58, -67, 46, -2, -34, -98, -56, 16, -11, 106, -50, -31, -39, 123, Ascii.DC4, 95, 16, 8, -15, -49, 90, -2, -9, 99, -122, 112, 9, 11, -69, -78, -100, Ascii.ESC, 10, 86, -11, -58, -121, -95, -6, Utf8.REPLACEMENT_BYTE, 119, 51, 19, 88, 92, 4, -25, 70, Ascii.f55143GS, -96, -75, 58, Utf8.REPLACEMENT_BYTE, -116, 74, -48, -123, -93, Ascii.f55147RS, 119, 19, -45, Byte.MAX_VALUE, -94, 124, -6, 113, -28, SignedBytes.MAX_POWER_OF_TWO, 5, 60, -31, 82, -36, 74, -116, 126, -39, -4, 98, 8, -37, -75, Ascii.f55140EM, -6, -19, -90, 72, 118, 62, 37, -119, 41, Ascii.f55139CR, -72, 3, 78, -2, -22, 96, 75, -91, -63, -89, 105, -15, -10, -80, Ascii.DC2, -10, 103, 40, 121, -58, 56, 117, -17, -18, -123, 117, 41, 95, -109, 74, 39, -84, -84, -100, -126, -21, 35, -124, -61, -114, -88, -2, Ascii.f55151US, 95, -71, Ascii.f55148SI, -114, 88, 44, -3, -85, 80, -58, 3, 81, 49, 7, 84, 97, Ascii.ETB, 74, Ascii.f55139CR, 81, -61, -78, 75, -127, Utf8.REPLACEMENT_BYTE, -49, 104, -107, -109, -30, 46, -119, 117, -46, -35, -10, 101, -69, 52, 57, -81, 34, 69, -91, -53, -78, 50, -25, -111, -86, 44, 7, -81, 88, 83, -82, 126, -127, -14, -40, 97, -29, 126, 93, 6, 32, -75, 98, -62, 45, -110, Ascii.DC2, -111, 53, -24, 123, 84, 51, Ascii.CAN, 38, 55, 68, 102, -82, 59, -122, 79, 78, 71, -83, Ascii.ESC, -48, 70, 16, -30, -75, -115, Ascii.ESC, -92, -52, 120, Ascii.f55143GS, -89, -105, -115, -61, 80, -74, -24, 45, -58, 78, 93, -18, 2, Ascii.DC4, -76, -112, -110, -106, 90, 52, -112, -90, -16, Ascii.f55140EM, 96, 89, 71, -20, 38, 89, -77, 38, 106, 38, -61, -19, -94, 53, -74, 71, -62, -104, -108, -42, -3, -79, 56, -32, 84, -12, -103, -106, SignedBytes.MAX_POWER_OF_TWO, 115, 94, -4, Ascii.f55149SO, -61, -120, Ascii.f55147RS, -104, -37, -14, Ascii.f55149SO, 80, 17, -84, 50, Ascii.f55143GS, 99, -17, 8, 33, 110, -5, -69, 38, -59, -56, -75, 39, -60, 68, 109, 73, 86, 72, -50, -36, -91, 73, -48, -2, 41, -30, 59, 107, -57, -74, Ascii.DC2, -84, 91, -19, -122, Ascii.SUB, -18, 0, -72, 52, 7, 46, 110, -94, 43, 41, Ascii.f55139CR, 94, 124, -22, -102, -14, 7, 122, 49, -120, 46, 103, -80, 49, 84, -113, -98, -64, 36, 84, 1, Ascii.f55141FF, 62, 36, -126, 88, -27, 76, 78, 102, -50, 67, -34, -124, -105, 93, -27, 99, 72, 100, -69, 104, -14, -62, 118, -41, -70, 121, -82, 80, -65, 125, -21, -31, Ascii.SUB, -102, -125, -18, 49, -2, 93, 54, 10, -95, -118, -85, 47, Ascii.NAK, -10, -108, Ascii.f55151US, -35, -8, 72, -5, 90, 54, 91, -97, -17, -64, 57, 47, 80, -95, -92, -38, 52, -38, 103, -28, -27, 113, 123, -67, -63, 69, 1, Ascii.f55141FF, Utf8.REPLACEMENT_BYTE, -83, -34, Ascii.f55147RS, -66, 107, -44, -117, 69, Ascii.ETB, -79, 35, 115, 96, 38, 35, 118, 5, -30, 123, -103, -81, Ascii.f55149SO, -119, -17, -112, 93, Ascii.SYN, Ascii.f55139CR, -26, -64, -48, 86, 7, -29, -79, 53, 65, -80, 55, -89, 98, -111, -80, 54, 117, -107, -19, 61, -65, 94, 75, -111, -116, 52, -4, -3, -126, 0, Ascii.SYN, -111, 125, 83, 76, 109, -116, SignedBytes.MAX_POWER_OF_TWO, 125, -61, 49, 87, 35, -17, -72, -88, 100, 1, 80, Ascii.ESC, -81, -14, -69, 62, -40, -73, 43, 55, 121, Ascii.SUB, -123, -1, -16, 114, 124, Ascii.ETB, -29, 101, 51, -111, 72, 67, 90, 118, 84, 46, 58, 91, -58, 9, Ascii.f55151US, Ascii.ESC, 16, -31, 82, 66, -31, Ascii.f55141FF, -74, 38, -14, 122, 86, -62, Ascii.CAN, -23, 36, Ascii.f55140EM, -85, Ascii.DC4, 1, -7, -73, Ascii.CAN, 91, -35, -71, 106, 81, 116, -64, -16, -122, Utf8.REPLACEMENT_BYTE, 106, -23, 17, -61, -78, 116, 116, -49, 35, 125, 65, 57, -3, -20, -66, 118, Ascii.NAK, Ascii.ESC, 33, 126, 39, -72, -117, Ascii.f55143GS, 46, -81, 76, -12, -91, -103, -77, 54, -48, -109, -58, Ascii.f55139CR, 125, 112, -19, Ascii.f55147RS, 102, -127, 103, 100, 73, -93, Ascii.f55140EM, 52, PSSSigner.TRAILER_IMPLICIT, 66, -107, 45, 118, -61, -18, -32, -72, 35, 112, -74, 82, -114, -119, 97, -103}, -8950841949370151793L), m41119a(new byte[]{-83, Utf8.REPLACEMENT_BYTE, -56, 4, -37, 102, -38, -15, 33, 37, 107, -103, Ascii.f55149SO, 90, 101, -44, -126, Ascii.DC4, -111, -102, -84, -60, -81, 37, -123, 16, Ascii.f55148SI, -23, -97, -125, -76, -112, -3, -102, 68, -103, 108, 98, -87, 100, -27, -31, 108, -12, -105, 57, 83, -92, 44, -57, 125, -55, -14, 118, -6, 76, -93, 92, -65, 47, 80, Ascii.NAK, 17, -38, 80, 106, Byte.MAX_VALUE, Ascii.ETB, 95, -74, -70, -74, -27, 111, 54, 106, 125, -84, -10, 114, -55, -123, -55, -91, 50, -94, -11, -71, -19, 67, -10, -70, -78, -1, -74, -78, -124, -10, 58, 5, -63, 1, -66, -8, 125, 98, 41, -79, -111, 5, 97, -124, -88, -25, 90, 61, 36, 83, -37, 82, 6, 48, 116, -123, Ascii.NAK, 8, Ascii.f55142FS, Ascii.SYN, -53, -63, 45, -115, 44, -31, -5, -84, 76, 52, 69, 57, 78, -56, -127, -4, -123, 124, -48, 45, 49, 121, -44, 97, -106, 2, -75, 72, -16, -43, -53, 40, -19, -34, 48, 8, -125, -60, -6, 109, -75, -97, 116, 82, -11, 7, -26, -47, 8, -111, 2, 90, 114, 66, Ascii.f55141FF, 124, -51, 6, -48, 115, -17, -126, 5, -12, -75, Ascii.DC4, 100, 52, 94, 42, 111, 112, -30, 125, -86, 103, -52, -39, -109, 100, -2, -9, 102, 5, -12, 108, -89, -110, 101, -15, 50, 72, -3, -105, 76, 4, 11, 35, -101, 124, -98, 96, -63, 2, 40, 40, -92, 74, 96, -113, 53, -7, 87, 11, 53, -77, -70, 45, Ascii.f55140EM, 39, -49, -112, 57, -32, -43, 99, -28, 114, -24, -64, 109, -31, -126, 51, -125, -32, -66, -96, -99, -45, -2, 7, SignedBytes.MAX_POWER_OF_TWO, 95, -32, 40, -2, -1, 91, -103, Ascii.CAN, 50, -117, -48, 80, -103, 109, 60, -85, -105, -6, -35, 72, 37, -115, -95, 65, -105, -105, 52, 1, -107, -28, 61, -5, -66, 55, 16, -108, -5, 118, -113, -71, 43, -119, Byte.MIN_VALUE, 86, -16, 0, -64, -22, -35, -27, Ascii.f55148SI, 82, -56, -84, -46, 37, 100, -17, 94, -1, -80, 45, -7, Ascii.ETB, -20, 50, 107, -10, -116, -96, -54, -61, -110, 95, -71, 124, 69, -21, 54, Ascii.f55143GS, 40, Byte.MAX_VALUE, -53, 45, -125, 126, 82, -117, -102, 56, 105, -30, 54, -48, Ascii.f55149SO, 94, -116, 11, 65, -11, 103, 90, 89, -46, Ascii.CAN, -45, -104, -28, -99, -39, -107, 54, 116, 16, -26, -19, 32, -77, -123, -107, 81, -25, Ascii.SUB, -7, 58, 67, -9, -111, -4, -65, -30, Ascii.f55141FF, -53, 11, -111, -32, 65, 2, 126, 66, -56, -95, -119, 117, 86, -17, -95, 93, 94, -27, 52, -21, -118, -72, -69, -64, 68, -79, 75, -33, 95, 89, -89, -120, -122, 100, -79, -2, 46, -100, 97, Ascii.f55142FS, -62, -97, 113, -8, 7, 39, 125, -35, -73, 4, -70, -67, 1, -97, Byte.MAX_VALUE, 0, 72, -123, Ascii.ESC, 103, -59, -10, -96, 78, Ascii.SUB, 81, 86, 40, 6, 126, 34, -7, 69, -27, Ascii.DC2, -78, Ascii.ETB, 90, -34, -7, 8, Ascii.f55148SI, 74, -119, 16, -95, 83, -75, 107, -115, 48, Ascii.ESC, 88, -77, 32, 44, -30, -112, -104, -70, Ascii.DC2, 71, 97, -127, 71, 41, -74, -41, 122, 2, -26, 83, -40, 88, -3, -12, 107, 106, -2, -105, 19, -81, 110, -82, 0, -44, 94, -37, 91, -14, -119, Ascii.f55141FF, -118, -35, -23, -25, -75, 46, -118, 72, -108, -25, -44, 68, -110, -55, 81, Ascii.f55143GS, Ascii.f55140EM, -83, 41, 7, 50, 111, 88, -40, Ascii.NAK, -17, Ascii.f55147RS, -70, -104, Ascii.NAK, -48, -52, -19, 51, -57, -127, -117, 11, Ascii.f55142FS, 111, 66, PSSSigner.TRAILER_IMPLICIT, 58, -51, 89, -110, -79, -113, 104, 100, -97, 49, 4, 110, 6, Ascii.ESC, -89, 40, Ascii.ETB, 88, Utf8.REPLACEMENT_BYTE, -35, -29, 99, 82, -46, -42, -102, 109, 34, 108, 8, 36, 114, 111, Ascii.NAK, -49, -55, -57, Ascii.NAK, -57, 50, 16, 89, Ascii.f55141FF, 38, Ascii.f55143GS, -111, 68, Ascii.SUB, 44, -21, 110, -62, 77, 95, -123, -114, 40, 87, 100, 61, -39, -67, 56, 40, -117, -118, 126, -49, -83, 38, 17, 9, 34, 6, -8, 119, -103, -95, -82, 60, 94, -81, -64, 52, 108, -35, 92, 73, -118, -85, Ascii.ESC, -21, -10, 9, -120, Byte.MIN_VALUE, Ascii.ESC, 106, -62, Ascii.DC2, 107, -88, -81, -123, 9, 45, 113, 46, 3, -53, -86, -82, 125, -97, Ascii.ETB, -104, -85, -64, -123, -44, -1, 57, 83, 68, -102, -27, -62, -113, -83, -1, 35, -47, 3, 97, -85, -13, -27, 78, -60, 5, -76, -90, 112, 122, 87, -46, 17, -108, -36, 37, -60, -108, 119, 80, -25, 51, -45, Ascii.f55148SI, -30}, -2988457372327901074L)};

    /* renamed from: b */
    public static final byte[][] f55329b = {m41119a(new byte[]{-28, 75, Ascii.f55148SI, -53, Utf8.REPLACEMENT_BYTE, 94, -115, -125, -56, Ascii.DC4, -110, 103, 53, 41, -27, -110, -111, -54, 107, SignedBytes.MAX_POWER_OF_TWO, -2, -127, -14, -40, 90, 40, -83, 76, -100, -107, Ascii.f55139CR, 108, 92, -20, -91, 55, Ascii.f55151US, 17, -88, Ascii.ESC, -114, -39, -82, 107, 114, 40, 36, -114, 65, -85, 69, 99, -71, 65, -97, 96, 36, -30, 98, -120, 9, 98, 52, -114, Ascii.f55142FS, Utf8.REPLACEMENT_BYTE, Ascii.NAK, Ascii.f55147RS, 1, -127, -46, -54, Ascii.NAK, 85, -117, -56, 58, -7, -104, Ascii.DC2, 88, -11, -121, Ascii.f55140EM, 39, -95, 80, 104, -96, 40, -16, -1, -84, Ascii.CAN, -82, 56, -37, 116, 90, -69, -114, -31, Ascii.f55142FS, 52, 0, -19, 108, -37, -78, 11, -82, -97, 91, -114, 122, -93, -67, -33, 103, -64, -127, Ascii.f55142FS, Ascii.f55143GS, -122, -27, -87, Ascii.f55151US, -86, 45, -77, -10, 45, -15, 103, -95, 107, -42, 112, -44, 44, 38, 4, -26, 66, -40, 8, Ascii.NAK, -67, 39, -58, 0, -100, -105, -3, -14, 98, Ascii.f55148SI, Ascii.ETB, 48, -31, 115, 40, 116, 108, -125, -7, -54, -83, -78, -60, 91, 36, -47, 67, Ascii.SUB, 62, -41, Ascii.f55142FS, 10, Ascii.f55139CR, -4, 17, -127, 46, 42, -80, Ascii.ESC, 111, -112, -24, 105, -8, -41, Ascii.SYN, -35, -79, 50, 118, -75, -123, 10, 115, -9, -65, 95, 121, -91, Ascii.f55139CR, -3, -29, 2, 90, 3, SignedBytes.MAX_POWER_OF_TWO, -83, -76, -72, 34, 106, -31, -31, 87, -54, 38, 107, -54, -79, 89, 122, -4, -75, -95, -2, Ascii.f55141FF, -119, -19, Ascii.f55147RS, -14, -21, 83, -95, Ascii.f55141FF, 2, -118, 99, 57, Ascii.f55141FF, -20, 107, -7, 76, 114, 56, Ascii.f55141FF, -78, -19, -54, Ascii.f55141FF, 110, -116, -48, 60, 87, 52, -122, -5, -94, -83, 112, 113, -112, -3, 117, 81, -61, 4, -27, -87, -101, 122, 119, -109, 110, -33, 74, 56, -58, -61, -71, 122, 126, 112, -15, 35, -123, 114, -104, 114, 52, -72, 56, -16, -106, 92, -15, 117, 107, 0, -41, -13, 83, 9, Ascii.NAK, 65, 117, -66, 48, 48, -38, -12, -25, 120, -14, -76, -123, 91, -45, -127, 102, 105, -90, 72, 78, -19, -76, -73, 62, -122, -101, 84, -109, -28, -42, 44, -104, -95, 59, -6, -26, -30, 81, 117, -64, PSSSigner.TRAILER_IMPLICIT, 11, 51, 44, 58, -73, -38, 49, 38, 115, 109, Ascii.ETB, -59, 100, 82, 85, -51, -7, -118, 101, -58, -46, -55, 49, -24, 41, -8, -1, -112, 74, 72, 114, 52, 59, 43, -4, -103, -3, Ascii.DC2}, 890235491509898690L), m41119a(new byte[]{102, 94, -36, 52, 71, 104, 122, -10, -41, -11, 6, 42, 110, 103, 37, -7, 125, Ascii.SUB, 119, 79, -13, 80, 101, -74, -14, -119, 81, -76, 93, -13, -4, Ascii.f55140EM, 125, 44, -52, 56, -9, 86, 16, -44, 57, -78, -1, 95, -85, 88, 126, 2, Ascii.f55148SI, -114, -89, -7, -10, -80, 48, 116, -17, -20, -17, -24, Ascii.ETB, 103, 121, Byte.MAX_VALUE, -105, 120, 50, -39, 58, -66, Ascii.ESC, -89, 73, 68, -55, -1, 124, -43, 99, 100, -56, -43, -30, 88, 45, -20, -33, 2, 120, Ascii.NAK, 55, 45, Byte.MIN_VALUE, -47, -2, Ascii.f55149SO, 65, 44, 120, 68, -27, 54, 75, -88, 114, -18, Ascii.f55142FS, -28, -38, -77, 97, Ascii.f55143GS, -111, 61, -57, -76, 67, 78, -65, -109, -77, -93, 94, -50, -15, 70, -110, Ascii.CAN, 71, Ascii.SUB, Ascii.ESC, 82, Ascii.SUB, -12, -10, 75, -5, -56, -89, -18, -115, 16, 55, -10, Ascii.DC2, 56, -4, 74, -3, 60, 54, -50, -60, 71, -85, -17, -60, -44, -125, -63, 44, 114, -58, 39, -51, -5, -27, -5, 83, -45, -69, Ascii.DC4, 51, 53, -1, 11, -96, 88, -92, -75, -34, 75, -3, -13, -1, -42, -109, -55, 72, Ascii.f55142FS, -123, 41, 49, 125, -69, -110, -47, -111, 32, -5, -117, -16, 50, -25, SignedBytes.MAX_POWER_OF_TWO, -70, -4, -15, 42, 114, -95, -51, 58, 36, 69, 5, -13, -111, 43, -19, 112, -25, -71, 58, 67, Ascii.ESC, -36, -51, 4, -111, -73, Ascii.f55148SI, -10, 6, 120, -26, -83, 106, -15, -12, 81, -84, 108, -100, -30, -78, 56, 3, -34, 75, Byte.MAX_VALUE, -91, 100, -81, -7, 116, -92, 61, Ascii.f55142FS, -95, 121, 115, 40, 19, 37, -51, 84, 53, 86, Ascii.f55149SO, -53, -21, -89, 5, 57, -29, 90, 66, 38, Byte.MAX_VALUE, -24, -59, PSSSigner.TRAILER_IMPLICIT, -83, 79, 89, -4, -84, 116, -31, -92, 107, -83, -23, -15, -36, Ascii.f55148SI, 56, -1, -88, 55, 43, -70, Ascii.f55142FS, -43, 35, -123, -51, -98, -22, 122, 126, 33, -26, -9, -61, -61, 100, -7, 116, 89, -93, -47, 88, 92, -46, 90, 106, 95, -79, 70, -109, -98, -13, -74, -39, 113, 5, -99, 61, -7, -27, 74, Ascii.f55149SO, -77, Ascii.NAK, 56, 76, 0, Ascii.SYN, 62, 121, 2, 70, -71, -107, 62, 74, -69, -106, 113, 113, 87, 79, 94, -85, 99, -50, Ascii.f55141FF, 105, -18, -53, 42, -41, 10, -86, 85, 48, 89, 9, -110, Ascii.CAN, 108, -4, -123, -1, 72, -39, -124, 111, -51, 44, -85, 58, -44, -92, -34, -120, Ascii.ESC, 80, 107, 58, 85, 123, 60, -73, -102, 48, -93, -125, 59, Ascii.ETB, -5, -5, -32, 95, -105, -65, Ascii.f55148SI, -106, -48, 10, -80, -2, 106, -57, 16, 58, 66, -78, -101, 44, -116, -116, 66, 53, 33, 71, SignedBytes.MAX_POWER_OF_TWO, 115, -99, 109, 126, -45, 82, 117, 80, -62, -107, -67, 79, 108, -114, -109, -83, 37, 45, 57, -81, -19, -41, 40, 35, 53, 61, 116, -79, 65, 57, -110, -119, 82, -19, Ascii.ESC, -98, -116, 88, 102, -70, -105, -113, 39, 96, Ascii.f55148SI, -117, -27, -122, 6, 62, Ascii.f55149SO, -15, 55, Ascii.f55142FS, Ascii.SYN, -73, -8, -116, 84, 94, 19, -124, -1, 17, 61, 43, -30, 60, 70, 88, -86, 74, -23, -21, Ascii.f55151US, Ascii.f55151US, 9, 118, Ascii.f55140EM, 81, 84, 52, 53, -6, -53, 48, -113, -74, 94, -122, 89, 103, 123, -76, -45, -57, 19, 102, 74, Ascii.f55142FS, -112, 109, -101, -109, -63, -65, Ascii.SYN, 126, -124, -36, -113, -121, -87, 72, -16, 71, -110, -80, 88, 59, -114, 36, -54, -19, -121, Ascii.f55143GS, -37, SignedBytes.MAX_POWER_OF_TWO, 3, 91, -115, -25, 19, Byte.MIN_VALUE, -116, -43, 53, 118, 58, -116, -57, -114, 36, -100, 91, 116, 53, 51, -5, 3, -11, Ascii.f55147RS, 47, SignedBytes.MAX_POWER_OF_TWO, -9, -25, 43, 51, -52, -2, -75, -126, -78, -66, 73, 44, Ascii.f55147RS, Ascii.f55139CR, -87, 52, 109, -98, 111, -98, Ascii.SUB, 42, 43, 48, -8, -58, 16, -19, -106, -49, 73, Ascii.f55148SI, -18, -105, Ascii.f55142FS, 1, 104, 41, -85, 91, -119, 102, -127, -90, 50, -10, -82, 106, -83, Byte.MAX_VALUE, -112, Ascii.f55141FF, -7, -124, 86, -64, -95, -104, 85, Byte.MIN_VALUE, 79, -104, 71, 47, 126, -15, -29, -114, Byte.MIN_VALUE, -36, -63, 52, Ascii.ETB, 90, -100, 32, 122, Ascii.f55140EM, 81, 6, -58, Ascii.f55147RS, -56, 113, -108, 70, 35, -58, 17, 40, -108, 110, 3, -80, 121, 59, Ascii.SUB, Ascii.SUB, Ascii.ESC, 6, 43, -113, Ascii.f55148SI, -114, 6, 72, 116, -25, Utf8.REPLACEMENT_BYTE, -83, 19, -47, -49, 77, -70, 10, 8, -58, 76, -4, 98, Ascii.ETB, -98, 81, 3, -53, -70, -123, -6, -105, 113, -14, 2, -78, -33, -62, -121, 33, 60, -46, 87, 97, 113}, -4965248247064750375L), m41119a(new byte[]{93, -82, 8, 51, -86, -45, 110, 93, -98, 97, 116, 54, -28, -126, 8, -47, 44, -22, -112, -122, -11, -107, -79, 108, -56, -91, -71, 65, -50, -75, 1, -102, 55, -59, 110, 124, 74, Utf8.REPLACEMENT_BYTE, Ascii.f55143GS, 76, 104, -115, -125, -57, 125, -108, -34, 66, Utf8.REPLACEMENT_BYTE, -76, -21, 3, 55, 96, -110, -12, -40, -13, Ascii.ESC, 125, -111, -47, 108, -46, -121, Ascii.CAN, -61, -50, -32, -1, -107, 98, Ascii.f55148SI, 93, -82, -122, -96, -73, 87, -73, -89, 105, -50, 102, -118, 112, -21, 55, 89, -59, 54, -33, 86, 82, -96, -21, 117, -33, -22, 44, -40, 120, 80, -100, 44, -109, 68, -31, 43, -11, -125, -54, -82, -27, -9, -39, Byte.MAX_VALUE, -101, 68, -72, Ascii.f55140EM, 49, 123, 90, -121, -108, 4, 41, 70, 58, Ascii.f55139CR, 126, 112, 108, Byte.MIN_VALUE, -11, -125, -15, 70, 110, -94, Ascii.f55148SI, 124, 61, 109, -124, -96, 36, -108, -122, -73, -121, 103, -30, 111, 100, -111, -124, -3, -76, PSSSigner.TRAILER_IMPLICIT, 52, -100, 48, -38, 47, -28, -51, -90, Ascii.DC4, 99, 119, 2, 62, 113, -37, 79, -53, -94, 92, -61, -77, 37, 103, 37, -46, -54, -121, -82, Ascii.SYN, 73, -87, -79, -15, 83, 16, Ascii.SUB, Ascii.f55143GS, 34, -96, 3, 96, -117, Ascii.DC4, -3, 123, -28, -114, 120, 9, Ascii.f55139CR, 88, -108, 49, Ascii.f55151US, 32, 101, -108, Ascii.f55143GS, -77, -67, 92, 38, -117, 2, 89, -63, -1, -21, -106, 56, Ascii.DC4, 65, -78, 50, 60, -66, Ascii.DC2, 110, 36, -101, Byte.MIN_VALUE, -21, 105, -104, -60, -70, 111, 17, Ascii.CAN, 126, 37, 124, 50, -56, 19, -122, 88, -73, -99, -27, 90, -99, 75, 68, 99, 2, -14, 112, -46, -74, -41, 37, -125, 122, 126, -108, Ascii.SUB, Ascii.CAN, 93, 126, 73, 89, -57, -1, 39, 76, 61, -45, 84, 59, -60, -34, Ascii.ETB, -45, -125, 98, -97, Ascii.f55148SI, Utf8.REPLACEMENT_BYTE, 77, -81, -39, -102, -3, 17, -76, -114, 33, 106, 72, Ascii.ETB, -17, -89, 60, -81, 100, 2, -105, 88, 57, 118, 86, -43, -57, -95, -61, -102, -21, 96, 107, -66, -36, 91, 57, -37, 67, Utf8.REPLACEMENT_BYTE, 119, -55, 122, -40, -90, 10, -67, 5, 115, 86, -107, -31, -2, 123, 112, -34, SignedBytes.MAX_POWER_OF_TWO, 39, -64, -40, 49, -83, -79, -116, 116, Ascii.f55151US, 16, -60, 105, -71, Ascii.SUB, -106, 1, Ascii.f55140EM, -92, -16, 70, -38, -44, 72, -69, -12, 116, -54, 120, 68, -39, -41, -79, 104, 41, 32, -122, -88, -17, 33, 81, Ascii.f55139CR, -58, -92, Ascii.CAN, 117, -118, 46, 120, -75, 121, -14, -74, -56, 72, 103, 94, -55, 118, -108, 19, Ascii.ETB, 61, -114, 119, Ascii.f55149SO, -51, -46, -39, 46, Ascii.SYN, -45, -108, 80, -62, -96, 114, 119, -43, -88, 97, -85, -89, -17, Ascii.SUB, Byte.MIN_VALUE, 81, 73, 104, 19, 57, 70, 54, 57, 116, -6, 122, 39, 104, -12, -108, -75, 62, 70, -117, -31, 119, -103, -106, 87, -79, 79, -76, -56, Utf8.REPLACEMENT_BYTE, 39, -92, 124, 96, -102, -111, 59, 119, 40, 67, -50, 57, Ascii.f55143GS, -45, Byte.MIN_VALUE, Ascii.f55143GS, Ascii.f55141FF, Ascii.SYN, -55, 59, Ascii.f55142FS, 70, -63, -18, Ascii.DC2, -97, 125, 32, -32, -19, -72, 86, -93, 116, Ascii.DC2, -123, -124, Ascii.f55151US, SignedBytes.MAX_POWER_OF_TWO, 108, -31, 118, 7, 98, -33, 8, Byte.MAX_VALUE, 42, Ascii.f55147RS, -32, -15, -87, -19, 83, 105, 105, 83, 2, -78, -71, -58, 58, -83, 106, Ascii.ETB, -13, -121, Byte.MAX_VALUE, -43, 58, -125, -23, -18, 3, 125, 94, 1, -74, 44, -79, Ascii.ESC, -104, -50, -36, -125, 81, Ascii.NAK, -17, 72, 99, -21, -125, -32, 67, 16, -106, -92, -17, 73, -31, 43, Byte.MIN_VALUE, -112, -81, -15, 17, -70, -74, 98, 52, 62, -106, 35, -21, 94, -86, -96, -22, 62, 101, -57, -27, -84, -78, -17, -17, 88, -54, 61, -64, -110, -51, -59, 3, -41, -20, Ascii.f55141FF, 69, -7, 50, -106, -110, -93, -84, 70, -32, 77, -62, 57, -75, -115, 53, -38, -61, -108, 114, -123, -41, 68, -28, 106, 66, Ascii.f55139CR, 38, Ascii.CAN, -85, 7, 43, 8, -119, -19, 105, 78, 69, -77, Ascii.f55143GS, Ascii.f55149SO, Byte.MIN_VALUE, -67, 107, -14, -89, 82, Ascii.f55142FS, -24, -55, -1, -108, 32, -86, 4, -48, Ascii.f55147RS, 106, 60, -36, -117, -107, -115, 0, -62, 75, 3, -18, 106, -78, -39, 7, -27, 80, Ascii.f55142FS, 80, -59, 10, -36, 33, 82, -109, -69, -84, -105, 47, -109, -118, -120, 86, -80, -3, -75, 114, 75, -112, 53, 47, -40, 57, PSSSigner.TRAILER_IMPLICIT, 117, 99, -54, 40, -16, -48, -62, 47, -122, -25, 77, -37, Byte.MIN_VALUE, 69, -101, Ascii.f55149SO, -21, -50, -118, -103, 70, SignedBytes.MAX_POWER_OF_TWO, Ascii.f55151US, -4, -31, -24, 5, -89, -29, -4}, -6027516599036360798L)};

    /* renamed from: c */
    public static final byte[][] f55330c = {m41119a(new byte[]{-116, -90, -5, 62, 94, 19, Ascii.SYN, -116, 116, -29, -16, 102, -109, -23, -106, 8, -121, 78, -56, 77, 44, -42, -96, -72, -114, 71, Ascii.DC4, 91, 107, -54, 41, 105, -89, Ascii.ETB, -125, -4, -1, -32, -62, 45, 77, -99, -80, 69, -78, -95, 11, 32, 55, Ascii.f55140EM, -41, 6, -115, -53, -82, Ascii.DC2, 101, -85, -73, 6, -55, -51, 84, 7, -109, -13, 122, -66, 107, -83, -29, -61, 115, -34, 69, Ascii.f55143GS, 2, 32, 126, -51, 41, 53, Ascii.SYN, 83, 1, 94, 71, -94, Ascii.f55139CR, 36, -113, -78, -77, -62, 102, -84, 38, 107, 84, -60, 7, -43, 105, 111, -115, Utf8.REPLACEMENT_BYTE, 95, 76, -111, Ascii.DC4, -67, 120, -125, 5, 121, -101, 77, 71, 109, -111, -74, -120, -66, -103, 34, -104, -23, 51, -99, 121, -116, -31, Ascii.f55142FS, 11, 92, 103, 16, -49, 106, 107, -109, -37, 39, 83, -124, -73, 110, -64, -76, 69, -12, 35, -96, 48, Ascii.NAK, -51, -72, Ascii.NAK, 107, -73, Ascii.ETB, Ascii.DC2, -40, -102, 45, -88, 35, -14, 114, -114, 121, -99, 41, 111, -45, Ascii.f55142FS, -121, -104, -94, 120, -33, -22, -126, -73, -127, 112, -90, 47, -6, 43, -124, -69, 118, -65, -73, -56, -62, 110, 0, Ascii.f55147RS, 107, 53, -62, 103, Ascii.f55140EM, -60, -121, -65, 4, -20, -73, 54, Ascii.f55142FS, 75, -43, -1, -125, -80, 11, -119, -11, -121, -97, 76, -51, -89, -105, 61, 37, 98, 122, 33, -89, 121, 101, 44, 54, Utf8.REPLACEMENT_BYTE, -15, -10, -56, 71, -70, 121, -87, 88, -115, Ascii.f55151US, 46, -44, -38, -66, 42, -108, 122, -56, -76, -94, -122, 41, -110, -81, -93, -14, 38, -117, Ascii.DC4, -74, 90, 105, 43, Ascii.f55147RS, 83, -63, Byte.MAX_VALUE, -34, -111, Ascii.ETB, 115, SignedBytes.MAX_POWER_OF_TWO, Byte.MAX_VALUE, 5, -83, 36, -22, -77, 79, -58, -105, 103, 51, 0, -18, 41, -51, -70, -15, -41, 97, 2, 40, -57, 49, 122, Ascii.NAK, 16, -7, 59, -88, -79, -62, -73, 67, Ascii.f55142FS, Ascii.DC4, Ascii.f55151US, -113, -121, 38, Byte.MIN_VALUE, -35, -103, 98, 110, 52, -107, -103, -7, -90, Ascii.f55139CR, 33, 55, 118, -78, -23, 34, -25, 19, 61, -53, -13, -100, -60, -125, 49, -103, -83, -24, -26, 50, -109, -118, 78, -81, 84, 107, 16, 53, -16, -44, -40, 95, -51, -53, PSSSigner.TRAILER_IMPLICIT, -77, Ascii.ESC, 61, -77, 85, -108, -4, -69, 35, 37, 98, 118, -45, -60, -19, Ascii.DC4, -26, 101, Ascii.CAN, -67, 98, -31, -33, -50, SignedBytes.MAX_POWER_OF_TWO, -113, -124}, 1605432896040326015L), m41119a(new byte[]{80, 44, 0, -42, 78, 67, 62, 46, -49, -124, -10, -55, 114, 57, 81, -17, -90, -98, 60, 68, PSSSigner.TRAILER_IMPLICIT, Ascii.f55142FS, 62, -125, 65, Ascii.NAK, -126, Byte.MIN_VALUE, 124, 119, -89, -3, -15, 44, 75, 55, 42, Ascii.f55148SI, 72, -65, -65, -42, -5, 124, Ascii.NAK, Ascii.f55149SO, -126, -75, -111, Ascii.SUB, -85, 104, -49, 85, -65, 96, -56, 40, 62, 43, 81, 8, -106, -93, 114, -73, -84, 78, -103, -122, -66, 39, 78, 19, 53, -33, 32, -110, -24, -72, -53, -10, -16, 33, -20, 10, 88, -31, -32, 10, -10, -76, -94, -107, 83, 61, -101, -4, -86, Ascii.DC4, -111, 98, PSSSigner.TRAILER_IMPLICIT, -114, 67, -15, 59, -108, 113, 7, 9, -11, -113, -15, -96, Ascii.SUB, -124, 117, 75, -41, -17, -17, -52, -112, Byte.MAX_VALUE, -7, Ascii.f55141FF, -114, 10, -90, -105, -53, -105, Ascii.ETB, -70, 42, -79, 73, 105, -76, 78, PSSSigner.TRAILER_IMPLICIT, 106, -28, 2, 40, -19, 92, 120, -122, 119, 76, 78, 6, -101, -42, 16, 34, 43, 35, 32, 97, -63, 65, -91, 19, -35, Byte.MIN_VALUE, 56, -36, Ascii.f55139CR, -108, 124, 55, Ascii.DC4, -57, -125, 60, 114, -72, 3, -108, -102, -38, -116, -108, -113, -40, 113, -59, Ascii.f55139CR, 34, 45, -84, -52, -125, 96, 48, 10, 42, -91, -106, -117, Ascii.DC4, 83, -24, -38, -87, -116, -76, -82, -118, -50, 73, -53, Utf8.REPLACEMENT_BYTE, 109, 44, -73, -82, 67, -76, 77, -22, -116, -87, -105, -79, 83, -108, -38, Ascii.NAK, -41, 5, 102, -25, -71, 51, 120, -34, -99, 75, -105, -55, 47, 119, 119, 87, -115, 7, 32, -111, 91, Ascii.CAN, -13, 42, 10, 103, 38, 101, 2, Ascii.f55142FS, -83, -123, -121, -40, 19, 113, 4, 125, 68, -49, -95, -37, -45, 96, 126, 112, -65, -92, 39, 36, -122, 0, Utf8.REPLACEMENT_BYTE, 43, -102, 81, -92, -75, -5, 38, -119, 126, -39, -47, -9, -87, -100, 44, -40, 97, -98, 49, -43, -66, 83, -126, 102, -73, 49, 119, -39, 67, Ascii.f55142FS, 54, 113, -28, -5, 53, 73, 32, -80, -32, 126, 54, -47, -61, -66, 83, Ascii.f55148SI, Ascii.DC4, -113, -99, SignedBytes.MAX_POWER_OF_TWO, 126, 86, -37, -24, 54, -11, -104, -76, PSSSigner.TRAILER_IMPLICIT, -125, -116, -26, -39, 35, -55, -1, Ascii.SYN, -40, -15, 106, 34, -102, -44, PSSSigner.TRAILER_IMPLICIT, -31, -61, -88, 113, -88, -7, Ascii.CAN, 47, 74, 71, -89, 116, Ascii.CAN, -29, 44, 2, -122, 16, -96, 16, 78, 33, 104, -43, -9, 62, 81, 113, -108, -103, -34, Ascii.NAK, -37}, -8670525661889632208L), m41119a(new byte[]{-126, -54, -54, 9, -57, -5, 32, 37, 89, 7, 54, -24, Byte.MIN_VALUE, 4, -89, -96, -88, -79, 94, 59, -89, -74, 114, 36, 90, -107, -56, -108, 120, 35, 79, -37, 86, 51, 125, -105, -106, -4, 57, 90, -85, -91, -115, -114, -41, 19, Ascii.NAK, -38, Utf8.REPLACEMENT_BYTE, Ascii.DC4, 112, -73, -75, -94, 35, -78, 19, -47, -86, -102, -16, 48, -104, 79, -78, -51, -83, -126, -51, -57, -89, 10, -65, -4, -120, -50, -79, 42, 109, 74, 6, -122, -75, 93, -64, -118, 103, Ascii.f55149SO, -121, PSSSigner.TRAILER_IMPLICIT, -90, -93, -70, Ascii.f55151US, 111, -116, 66, -39, 69, 49, -117, 96, -65, 0, -105, -84, 76, -120, 0, -78, -75, -2, SignedBytes.MAX_POWER_OF_TWO, 92, -67, -44, -113, 53, 36, 98, -92, -116, -22, -57, Utf8.REPLACEMENT_BYTE, -111, -32, -61, -88, 97, 55, 43, 113, -116, -112, -52, Ascii.SYN, 62, 55, -1, 43, -47, 93, -57, -127, 107, -98, 111, 77, Byte.MIN_VALUE, SignedBytes.MAX_POWER_OF_TWO, -26, -88, -88, 125, -90, 119, -112, -89, -1, 112, 46, 82, -12, 121, -107, -112, -24, 126, Ascii.f55140EM, Ascii.f55142FS, -25, 44, -118, -82, 113, 10, -44, -79, 88, 95, -69, -59, 44, 6, 77, -72, 6, 32, -93, -89, 42, 57, -65, 80, -114, -86, 124, -67, -88, Utf8.REPLACEMENT_BYTE, 54, -67, 115, -46, -99, -80, 97, 119, -18, -118, -52, -87, -108, 8, 81, 71, -126, 80, 70, 2, -31, 105, -97, 40, 49, -65, -112, -12, 84, 89, -100, 122, -15, -32, -30, 65, -92, -67, -3, -101, -13, 62, -105, -64, Ascii.DC4, -105, -107, -77, -90, -56, 62, 56, -90, -24, 67, -121, 103, 32, -16, -36, 111, -78, -112, 38, 126, -63, -102, 7, 87, -73, 118, -106, -60, 114, -94, 0, -88, 110, -83, -46, 42, -10, -95, -43, -103, Ascii.f55140EM, -105, -118, -81, -53, 60, -41, 48, 38, 121, 80, 45, -54, -22, -63, 86, -30, 55, -50, 35, 33, -49, 0, Ascii.SUB, 77, -22, -20, 96, 60, -71, 100, -35, Utf8.REPLACEMENT_BYTE, 69, -125, 4, -16, 52, -81, -26, -115, 87, 95, Ascii.SUB, 95, -55, Ascii.CAN, -15, 112, -61, 82, -87, 96, -60, 56, 53, 16, 97, 109, -22, 125, 84, 6, Ascii.f55140EM, -24, 94, 87, 80, -107, -63, -2, 61, 110, 52, 0, -92, -40, 47, -112, -104, -23, -29, -104, -72, -33, 66, -116, 113, -43, Ascii.f55140EM, 73, -53, -76, -2, -58, -28, -89, 58, SignedBytes.MAX_POWER_OF_TWO, 38, 100, 104, 48, -120, Ascii.CAN, -35}, 290932728613225452L)};

    /* renamed from: a */
    public static byte[] m41119a(byte[] bArr, long j) {
        return Base64.decode(StringDeobfuscator.deobfuscate(bArr, j), 0);
    }
}
