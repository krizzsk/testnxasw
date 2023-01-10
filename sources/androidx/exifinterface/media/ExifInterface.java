package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterfaceUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.C14360R2;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p074io.IOUtils;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, C14360R2.styleable.jumio_jumio_secondary_button_background, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, 49};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(ASCII);
    private static final ExifTag[] IFD_EXIF_TAGS = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new ExifTag(TAG_ISO_SPEED, 34867, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_OFFSET_TIME, 36880, 2), new ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, C14360R2.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 10), new ExifTag(TAG_APERTURE_VALUE, C14360R2.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, C14360R2.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, C14360R2.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, C14360R2.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, 5), new ExifTag(TAG_SUBJECT_DISTANCE, C14360R2.styleable.CollapsingToolbarLayout_maxLines, 5), new ExifTag(TAG_METERING_MODE, C14360R2.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 3), new ExifTag(TAG_LIGHT_SOURCE, C14360R2.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, 3), new ExifTag(TAG_FLASH, C14360R2.styleable.CollapsingToolbarLayout_statusBarScrim, 3), new ExifTag(TAG_FOCAL_LENGTH, C14360R2.styleable.CollapsingToolbarLayout_title, 5), new ExifTag(TAG_SUBJECT_AREA, C14360R2.styleable.ColorStateListItem_lStar, 3), new ExifTag(TAG_MAKER_NOTE, C14360R2.styleable.Constraint_layout_constraintHeight_percent, 7), new ExifTag(TAG_USER_COMMENT, C14360R2.styleable.Constraint_layout_constraintStart_toEndOf, 7), new ExifTag(TAG_SUBSEC_TIME, C14360R2.styleable.Constraint_layout_constraintWidth_default, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, C14360R2.styleable.Constraint_layout_constraintWidth_max, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, C14360R2.styleable.Constraint_layout_constraintWidth_min, 2), new ExifTag(TAG_FLASHPIX_VERSION, C14360R2.styleable.jumio_jumio_scanview_foreground, 7), new ExifTag(TAG_COLOR_SPACE, C14360R2.styleable.jumio_jumio_scanview_shutter, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, C14360R2.styleable.jumio_jumio_scanview_shutter_pressed, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, C14360R2.styleable.jumio_jumio_search_bubble_background, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, C14360R2.styleable.jumio_jumio_search_bubble_foreground, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, C14360R2.styleable.jumio_jumio_secondary_button_background, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new ExifTag(TAG_LENS_SPECIFICATION, 42034, 5), new ExifTag(TAG_LENS_MAKE, 42035, 2), new ExifTag(TAG_LENS_MODEL, 42036, 2), new ExifTag(TAG_GAMMA, 42240, 5), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5, 10), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5, 10), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3), new ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag("Model", 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_XMP, 700, 1), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    private static final ExifTag[] IFD_TIFF_TAGS = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag("Model", 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifTag(TAG_XMP, 700, 1)};
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    static final int IMAGE_TYPE_ARW = 1;
    static final int IMAGE_TYPE_CR2 = 2;
    static final int IMAGE_TYPE_DNG = 3;
    static final int IMAGE_TYPE_HEIF = 12;
    static final int IMAGE_TYPE_JPEG = 4;
    static final int IMAGE_TYPE_NEF = 5;
    static final int IMAGE_TYPE_NRW = 6;
    static final int IMAGE_TYPE_ORF = 7;
    static final int IMAGE_TYPE_PEF = 8;
    static final int IMAGE_TYPE_PNG = 13;
    static final int IMAGE_TYPE_RAF = 9;
    static final int IMAGE_TYPE_RW2 = 10;
    static final int IMAGE_TYPE_SRW = 11;
    static final int IMAGE_TYPE_UNKNOWN = 0;
    static final int IMAGE_TYPE_WEBP = 14;
    static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, Ascii.f55139CR, 10, Ascii.SUB, 10};
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    private static final int SKIP_BUFFER_SIZE = 8192;
    static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    private static boolean isSupportedFormatForSavingAttributes(int i) {
        return i == 4 || i == 13 || i == 14 || i == 3 || i == 0;
    }

    private static boolean shouldSupportSeek(int i) {
        return (i == 4 || i == 9 || i == 13 || i == 14) ? false : true;
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = IFD_TIFF_TAGS;
        EXIF_TAGS = new ExifTag[][]{exifTagArr2, IFD_EXIF_TAGS, IFD_GPS_TAGS, IFD_INTEROPERABILITY_TAGS, IFD_THUMBNAIL_TAGS, exifTagArr2, ORF_MAKER_NOTE_TAGS, ORF_CAMERA_SETTINGS_TAGS, ORF_IMAGE_PROCESSING_TAGS, exifTagArr};
        ExifTag[][] exifTagArr3 = EXIF_TAGS;
        sExifTagMapsForReading = new HashMap[exifTagArr3.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr3.length];
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            sExifTagMapsForReading[i] = new HashMap<>();
            sExifTagMapsForWriting[i] = new HashMap<>();
            for (ExifTag exifTag : EXIF_TAGS[i]) {
                sExifTagMapsForReading[i].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
            }
        }
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[0].number), 5);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[1].number), 1);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[2].number), 2);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[3].number), 3);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[4].number), 7);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[5].number), 8);
    }

    private static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double d) {
            this((long) (d * 10000.0d), 10000);
        }

        Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }
    }

    private static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i, int i2, byte[] bArr) {
            this(i, i2, -1, bArr);
        }

        ExifAttribute(int i, int i2, long j, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytesOffset = j;
            this.bytes = bArr;
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes2 = str.getBytes(ExifInterface.ASCII);
                return new ExifAttribute(1, bytes2.length, bytes2);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes2 = (str + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes2.length, bytes2);
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:159:0x0213 A[SYNTHETIC, Splitter:B:159:0x0213] */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x022b A[SYNTHETIC, Splitter:B:167:0x022b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object getValue(java.nio.ByteOrder r15) {
            /*
                r14 = this;
                r0 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x0202, all -> 0x0200 }
                byte[] r2 = r14.bytes     // Catch:{ IOException -> 0x0202, all -> 0x0200 }
                r1.<init>((byte[]) r2)     // Catch:{ IOException -> 0x0202, all -> 0x0200 }
                r1.setByteOrder(r15)     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r15 = r14.format     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r2 = 1
                r3 = 0
                switch(r15) {
                    case 1: goto L_0x0199;
                    case 2: goto L_0x0141;
                    case 3: goto L_0x011e;
                    case 4: goto L_0x00fb;
                    case 5: goto L_0x00cf;
                    case 6: goto L_0x0199;
                    case 7: goto L_0x0141;
                    case 8: goto L_0x00ac;
                    case 9: goto L_0x0089;
                    case 10: goto L_0x005b;
                    case 11: goto L_0x0037;
                    case 12: goto L_0x0014;
                    default: goto L_0x0012;
                }     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x0012:
                goto L_0x01e7
            L_0x0014:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                double[] r15 = new double[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x0018:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x0025
                double r4 = r1.readDouble()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r4     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x0018
            L_0x0025:
                r1.close()     // Catch:{ IOException -> 0x0029 }
                goto L_0x0036
            L_0x0029:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x0036:
                return r15
            L_0x0037:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                double[] r15 = new double[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x003b:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x0049
                float r2 = r1.readFloat()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                double r4 = (double) r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r4     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x003b
            L_0x0049:
                r1.close()     // Catch:{ IOException -> 0x004d }
                goto L_0x005a
            L_0x004d:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x005a:
                return r15
            L_0x005b:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                androidx.exifinterface.media.ExifInterface$Rational[] r15 = new androidx.exifinterface.media.ExifInterface.Rational[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x005f:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x0077
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                long r4 = (long) r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                long r6 = (long) r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                androidx.exifinterface.media.ExifInterface$Rational r2 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x005f
            L_0x0077:
                r1.close()     // Catch:{ IOException -> 0x007b }
                goto L_0x0088
            L_0x007b:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x0088:
                return r15
            L_0x0089:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int[] r15 = new int[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x008d:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x009a
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x008d
            L_0x009a:
                r1.close()     // Catch:{ IOException -> 0x009e }
                goto L_0x00ab
            L_0x009e:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x00ab:
                return r15
            L_0x00ac:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int[] r15 = new int[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x00b0:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x00bd
                short r2 = r1.readShort()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x00b0
            L_0x00bd:
                r1.close()     // Catch:{ IOException -> 0x00c1 }
                goto L_0x00ce
            L_0x00c1:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x00ce:
                return r15
            L_0x00cf:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                androidx.exifinterface.media.ExifInterface$Rational[] r15 = new androidx.exifinterface.media.ExifInterface.Rational[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x00d3:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x00e9
                long r4 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                long r6 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                androidx.exifinterface.media.ExifInterface$Rational r2 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x00d3
            L_0x00e9:
                r1.close()     // Catch:{ IOException -> 0x00ed }
                goto L_0x00fa
            L_0x00ed:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x00fa:
                return r15
            L_0x00fb:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                long[] r15 = new long[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x00ff:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x010c
                long r4 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r4     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x00ff
            L_0x010c:
                r1.close()     // Catch:{ IOException -> 0x0110 }
                goto L_0x011d
            L_0x0110:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x011d:
                return r15
            L_0x011e:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int[] r15 = new int[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x0122:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x012f
                int r2 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15[r3] = r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r3 + 1
                goto L_0x0122
            L_0x012f:
                r1.close()     // Catch:{ IOException -> 0x0133 }
                goto L_0x0140
            L_0x0133:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x0140:
                return r15
            L_0x0141:
                int r15 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte[] r4 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r4 = r4.length     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r15 < r4) goto L_0x0162
                r15 = 0
            L_0x0149:
                byte[] r4 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r4 = r4.length     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r15 >= r4) goto L_0x015d
                byte[] r4 = r14.bytes     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte r4 = r4[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte[] r5 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte r5 = r5[r15]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r4 == r5) goto L_0x015a
                r2 = 0
                goto L_0x015d
            L_0x015a:
                int r15 = r15 + 1
                goto L_0x0149
            L_0x015d:
                if (r2 == 0) goto L_0x0162
                byte[] r15 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r3 = r15.length     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x0162:
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15.<init>()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x0167:
                int r2 = r14.numberOfComponents     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r3 >= r2) goto L_0x0183
                byte[] r2 = r14.bytes     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte r2 = r2[r3]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r2 != 0) goto L_0x0172
                goto L_0x0183
            L_0x0172:
                r4 = 32
                if (r2 < r4) goto L_0x017b
                char r2 = (char) r2     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15.append(r2)     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                goto L_0x0180
            L_0x017b:
                r2 = 63
                r15.append(r2)     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
            L_0x0180:
                int r3 = r3 + 1
                goto L_0x0167
            L_0x0183:
                java.lang.String r15 = r15.toString()     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r1.close()     // Catch:{ IOException -> 0x018b }
                goto L_0x0198
            L_0x018b:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x0198:
                return r15
            L_0x0199:
                byte[] r15 = r14.bytes     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r15 = r15.length     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r15 != r2) goto L_0x01cc
                byte[] r15 = r14.bytes     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte r15 = r15[r3]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r15 < 0) goto L_0x01cc
                byte[] r15 = r14.bytes     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte r15 = r15[r3]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                if (r15 > r2) goto L_0x01cc
                java.lang.String r15 = new java.lang.String     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                char[] r2 = new char[r2]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte[] r4 = r14.bytes     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte r4 = r4[r3]     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                int r4 = r4 + 48
                char r4 = (char) r4     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r2[r3] = r4     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15.<init>(r2)     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r1.close()     // Catch:{ IOException -> 0x01be }
                goto L_0x01cb
            L_0x01be:
                r8 = move-exception
                r5 = 6
                r10 = 3347(0xd13, float:4.69E-42)
                java.lang.String r6 = "ExifInterface"
                java.lang.String r7 = "IOException occurred while closing InputStream"
                java.lang.String r9 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
            L_0x01cb:
                return r15
            L_0x01cc:
                java.lang.String r15 = new java.lang.String     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                byte[] r2 = r14.bytes     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                java.nio.charset.Charset r3 = androidx.exifinterface.media.ExifInterface.ASCII     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r15.<init>(r2, r3)     // Catch:{ IOException -> 0x01fc, all -> 0x01f9 }
                r1.close()     // Catch:{ IOException -> 0x01d9 }
                goto L_0x01e6
            L_0x01d9:
                r7 = move-exception
                r4 = 6
                r9 = 3347(0xd13, float:4.69E-42)
                java.lang.String r5 = "ExifInterface"
                java.lang.String r6 = "IOException occurred while closing InputStream"
                java.lang.String r8 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            L_0x01e6:
                return r15
            L_0x01e7:
                r1.close()     // Catch:{ IOException -> 0x01eb }
                goto L_0x01f8
            L_0x01eb:
                r5 = move-exception
                r2 = 6
                r7 = 3347(0xd13, float:4.69E-42)
                java.lang.String r3 = "ExifInterface"
                java.lang.String r4 = "IOException occurred while closing InputStream"
                java.lang.String r6 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            L_0x01f8:
                return r0
            L_0x01f9:
                r15 = move-exception
                r0 = r1
                goto L_0x0229
            L_0x01fc:
                r15 = move-exception
                r4 = r15
                r15 = r1
                goto L_0x0205
            L_0x0200:
                r15 = move-exception
                goto L_0x0229
            L_0x0202:
                r15 = move-exception
                r4 = r15
                r15 = r0
            L_0x0205:
                java.lang.String r2 = "ExifInterface"
                java.lang.String r3 = "IOException occurred during reading a value"
                r1 = 5
                java.lang.String r5 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                r6 = 3340(0xd0c, float:4.68E-42)
                com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0225 }
                if (r15 == 0) goto L_0x0224
                r15.close()     // Catch:{ IOException -> 0x0217 }
                goto L_0x0224
            L_0x0217:
                r10 = move-exception
                r7 = 6
                r12 = 3347(0xd13, float:4.69E-42)
                java.lang.String r8 = "ExifInterface"
                java.lang.String r9 = "IOException occurred while closing InputStream"
                java.lang.String r11 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
            L_0x0224:
                return r0
            L_0x0225:
                r0 = move-exception
                r13 = r0
                r0 = r15
                r15 = r13
            L_0x0229:
                if (r0 == 0) goto L_0x023c
                r0.close()     // Catch:{ IOException -> 0x022f }
                goto L_0x023c
            L_0x022f:
                r4 = move-exception
                r1 = 6
                r6 = 3347(0xd13, float:4.69E-42)
                java.lang.String r2 = "ExifInterface"
                java.lang.String r3 = "IOException occurred while closing InputStream"
                java.lang.String r5 = "androidx.exifinterface.media.ExifInterface$ExifAttribute"
                com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            L_0x023c:
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (value instanceof String) {
                return Double.parseDouble((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (value instanceof String) {
                return Integer.parseInt((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(value instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) value;
                while (i < rationalArr.length) {
                    sb.append(rationalArr[i].numerator);
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb.append(rationalArr[i].denominator);
                    i++;
                    if (i != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }
    }

    static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        ExifTag(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }

        /* access modifiers changed from: package-private */
        public boolean isFormatCompatible(int i) {
            int i2;
            int i3 = this.primaryFormat;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && i == 8) {
                return true;
            }
            if ((this.primaryFormat == 12 || this.secondaryFormat == 12) && i == 11) {
                return true;
            }
            return false;
        }
    }

    public ExifInterface(File file) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            initForFilename(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    public ExifInterface(String str) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            initForFilename(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(java.io.FileDescriptor r6) throws java.io.IOException {
        /*
            r5 = this;
            r5.<init>()
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r0 = EXIF_TAGS
            int r0 = r0.length
            java.util.HashMap[] r0 = new java.util.HashMap[r0]
            r5.mAttributes = r0
            java.util.HashSet r0 = new java.util.HashSet
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r1 = EXIF_TAGS
            int r1 = r1.length
            r0.<init>(r1)
            r5.mAttributesOffsets = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r5.mExifByteOrder = r0
            if (r6 == 0) goto L_0x005f
            r0 = 0
            r5.mAssetInputStream = r0
            r5.mFilename = r0
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x003d
            boolean r2 = isSeekableFD(r6)
            if (r2 == 0) goto L_0x003d
            r5.mSeekableFileDescriptor = r6
            java.io.FileDescriptor r6 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.dup(r6)     // Catch:{ Exception -> 0x0034 }
            r1 = 1
            goto L_0x003f
        L_0x0034:
            r6 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r6)
            throw r0
        L_0x003d:
            r5.mSeekableFileDescriptor = r0
        L_0x003f:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0052 }
            r2.<init>(r6)     // Catch:{ all -> 0x0052 }
            r5.loadAttributes(r2)     // Catch:{ all -> 0x0050 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r2)
            if (r1 == 0) goto L_0x004f
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r6)
        L_0x004f:
            return
        L_0x0050:
            r0 = move-exception
            goto L_0x0056
        L_0x0052:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x0056:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r2)
            if (r1 == 0) goto L_0x005e
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r6)
        L_0x005e:
            throw r0
        L_0x005f:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "fileDescriptor cannot be null"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.FileDescriptor):void");
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(InputStream inputStream, int i) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (i == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, IDENTIFIER_EXIF_APP1.length);
                if (!isExifDataOnly(bufferedInputStream)) {
                    SystemUtils.log(5, TAG, "Given data does not follow the structure of an Exif-only data.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4034);
                    return;
                }
                this.mIsExifDataOnly = true;
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public static boolean isSupportedMimeType(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c = 10;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c = 9;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals("image/heic")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals("image/heif")) {
                        c = 12;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals("image/jpeg")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals("image/webp")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c = 1;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c = 6;
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals("image/png")) {
                        c = CharUtils.f7473CR;
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new NullPointerException("mimeType shouldn't be null");
        }
    }

    private ExifAttribute getExifAttribute(String str) {
        if (str != null) {
            if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                if (DEBUG) {
                    SystemUtils.log(3, TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4104);
                }
                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i = 0; i < EXIF_TAGS.length; i++) {
                ExifAttribute exifAttribute = this.mAttributes[i].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public String getAttribute(String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                if (!sTagSetForCompatibility.contains(str)) {
                    return exifAttribute.getStringValue(this.mExifByteOrder);
                }
                if (!str.equals(TAG_GPS_TIMESTAMP)) {
                    try {
                        return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
                    } catch (NumberFormatException unused) {
                    }
                } else if (exifAttribute.format == 5 || exifAttribute.format == 10) {
                    Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                    if (rationalArr == null || rationalArr.length != 3) {
                        SystemUtils.log(5, TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4145);
                        return null;
                    }
                    return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) rationalArr[0].numerator) / ((float) rationalArr[0].denominator))), Integer.valueOf((int) (((float) rationalArr[1].numerator) / ((float) rationalArr[1].denominator))), Integer.valueOf((int) (((float) rationalArr[2].numerator) / ((float) rationalArr[2].denominator)))});
                } else {
                    SystemUtils.log(5, TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4140);
                    return null;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public int getAttributeInt(String str, int i) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return i;
            }
            try {
                return exifAttribute.getIntValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return i;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public double getAttributeDouble(String str, double d) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return d;
            }
            try {
                return exifAttribute.getDoubleValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return d;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public void setAttribute(String str, String str2) {
        ExifTag exifTag;
        int i;
        String str3;
        String str4 = str;
        String str5 = str2;
        if (str4 != null) {
            if ((TAG_DATETIME.equals(str4) || TAG_DATETIME_ORIGINAL.equals(str4) || TAG_DATETIME_DIGITIZED.equals(str4)) && str5 != null) {
                boolean find = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(str5).find();
                boolean find2 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(str5).find();
                if (str2.length() != 19 || (!find && !find2)) {
                    SystemUtils.log(5, TAG, "Invalid value for " + str4 + " : " + str5, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4230);
                    return;
                } else if (find2) {
                    str5 = str5.replaceAll("-", ":");
                }
            }
            if (TAG_ISO_SPEED_RATINGS.equals(str4)) {
                if (DEBUG) {
                    SystemUtils.log(3, TAG, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4246);
                }
                str4 = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            int i2 = 2;
            int i3 = 1;
            if (str5 != null && sTagSetForCompatibility.contains(str4)) {
                if (str4.equals(TAG_GPS_TIMESTAMP)) {
                    Matcher matcher = GPS_TIMESTAMP_PATTERN.matcher(str5);
                    if (!matcher.find()) {
                        SystemUtils.log(5, TAG, "Invalid value for " + str4 + " : " + str5, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4256);
                        return;
                    }
                    str5 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    try {
                        str5 = new Rational(Double.parseDouble(str5)).toString();
                    } catch (NumberFormatException unused) {
                        SystemUtils.log(5, TAG, "Invalid value for " + str4 + " : " + str5, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4266);
                        return;
                    }
                }
            }
            char c = 0;
            int i4 = 0;
            while (i4 < EXIF_TAGS.length) {
                if ((i4 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i4].get(str4)) != null) {
                    if (str5 == null) {
                        this.mAttributes[i4].remove(str4);
                    } else {
                        Pair<Integer, Integer> guessDataFormat = guessDataFormat(str5);
                        if (exifTag.primaryFormat == ((Integer) guessDataFormat.first).intValue() || exifTag.primaryFormat == ((Integer) guessDataFormat.second).intValue()) {
                            i = exifTag.primaryFormat;
                        } else if (exifTag.secondaryFormat != -1 && (exifTag.secondaryFormat == ((Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((Integer) guessDataFormat.second).intValue())) {
                            i = exifTag.secondaryFormat;
                        } else if (exifTag.primaryFormat == i3 || exifTag.primaryFormat == 7 || exifTag.primaryFormat == i2) {
                            i = exifTag.primaryFormat;
                        } else if (DEBUG) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Given tag (");
                            sb.append(str4);
                            sb.append(") value didn't match with one of expected formats: ");
                            sb.append(IFD_FORMAT_NAMES[exifTag.primaryFormat]);
                            String str6 = "";
                            if (exifTag.secondaryFormat == -1) {
                                str3 = str6;
                            } else {
                                str3 = ", " + IFD_FORMAT_NAMES[exifTag.secondaryFormat];
                            }
                            sb.append(str3);
                            sb.append(" (guess: ");
                            sb.append(IFD_FORMAT_NAMES[((Integer) guessDataFormat.first).intValue()]);
                            if (((Integer) guessDataFormat.second).intValue() != -1) {
                                str6 = ", " + IFD_FORMAT_NAMES[((Integer) guessDataFormat.second).intValue()];
                            }
                            sb.append(str6);
                            sb.append(")");
                            SystemUtils.log(3, TAG, sb.toString(), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4295);
                        }
                        switch (i) {
                            case 1:
                                this.mAttributes[i4].put(str4, ExifAttribute.createByte(str5));
                                continue;
                            case 2:
                            case 7:
                                this.mAttributes[i4].put(str4, ExifAttribute.createString(str5));
                                continue;
                            case 3:
                                String[] split = str5.split(",", -1);
                                int[] iArr = new int[split.length];
                                for (int i5 = 0; i5 < split.length; i5++) {
                                    iArr[i5] = Integer.parseInt(split[i5]);
                                }
                                this.mAttributes[i4].put(str4, ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                                continue;
                            case 4:
                                String[] split2 = str5.split(",", -1);
                                long[] jArr = new long[split2.length];
                                for (int i6 = 0; i6 < split2.length; i6++) {
                                    jArr[i6] = Long.parseLong(split2[i6]);
                                }
                                this.mAttributes[i4].put(str4, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                                continue;
                            case 5:
                                String[] split3 = str5.split(",", -1);
                                Rational[] rationalArr = new Rational[split3.length];
                                int i7 = 0;
                                while (i7 < split3.length) {
                                    String[] split4 = split3[i7].split("/", -1);
                                    rationalArr[i7] = new Rational((long) Double.parseDouble(split4[c]), (long) Double.parseDouble(split4[1]));
                                    i7++;
                                    c = 0;
                                }
                                this.mAttributes[i4].put(str4, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                                continue;
                            case 9:
                                String[] split5 = str5.split(",", -1);
                                int[] iArr2 = new int[split5.length];
                                for (int i8 = 0; i8 < split5.length; i8++) {
                                    iArr2[i8] = Integer.parseInt(split5[i8]);
                                }
                                this.mAttributes[i4].put(str4, ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                                break;
                            case 10:
                                String[] split6 = str5.split(",", -1);
                                Rational[] rationalArr2 = new Rational[split6.length];
                                int i9 = 0;
                                while (i9 < split6.length) {
                                    String[] split7 = split6[i9].split("/", -1);
                                    rationalArr2[i9] = new Rational((long) Double.parseDouble(split7[c]), (long) Double.parseDouble(split7[i3]));
                                    i9++;
                                    split6 = split6;
                                    i3 = 1;
                                }
                                this.mAttributes[i4].put(str4, ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                                break;
                            case 12:
                                String[] split8 = str5.split(",", -1);
                                double[] dArr = new double[split8.length];
                                for (int i10 = 0; i10 < split8.length; i10++) {
                                    dArr[i10] = Double.parseDouble(split8[i10]);
                                }
                                this.mAttributes[i4].put(str4, ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                                break;
                            default:
                                if (DEBUG) {
                                    SystemUtils.log(3, TAG, "Data format isn't one of expected formats: " + i, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4381);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                i4++;
                i2 = 2;
                c = 0;
                i3 = 1;
            }
            return;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i) {
        if (i % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            int i2 = 0;
            if (ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                if (indexOf < 0) {
                    i2 = 4;
                }
                i2 = ROTATION_ORDER.get(indexOf + i2).intValue();
            } else if (FLIPPED_ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                int indexOf2 = (FLIPPED_ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                if (indexOf2 < 0) {
                    i2 = 4;
                }
                i2 = FLIPPED_ROTATION_ORDER.get(indexOf2 + i2).intValue();
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i2));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    private void loadAttributes(InputStream inputStream) {
        if (inputStream != null) {
            int i = 0;
            while (i < EXIF_TAGS.length) {
                try {
                    this.mAttributes[i] = new HashMap<>();
                    i++;
                } catch (IOException | UnsupportedOperationException e) {
                    Throwable th = e;
                    if (DEBUG) {
                        SystemUtils.log(5, TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", th, "androidx.exifinterface.media.ExifInterface", 4621);
                    }
                    addDefaultValuesForCompatibility();
                    if (!DEBUG) {
                        return;
                    }
                } catch (Throwable th2) {
                    addDefaultValuesForCompatibility();
                    if (DEBUG) {
                        printAttributes();
                    }
                    throw th2;
                }
            }
            if (!this.mIsExifDataOnly) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.mMimeType = getMimeType(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (shouldSupportSeek(this.mMimeType)) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(inputStream);
                if (this.mIsExifDataOnly) {
                    getStandaloneAttributes(seekableByteOrderedDataInputStream);
                } else if (this.mMimeType == 12) {
                    getHeifAttributes(seekableByteOrderedDataInputStream);
                } else if (this.mMimeType == 7) {
                    getOrfAttributes(seekableByteOrderedDataInputStream);
                } else if (this.mMimeType == 10) {
                    getRw2Attributes(seekableByteOrderedDataInputStream);
                } else {
                    getRawAttributes(seekableByteOrderedDataInputStream);
                }
                seekableByteOrderedDataInputStream.seek((long) this.mOffsetToExifData);
                setThumbnailData(seekableByteOrderedDataInputStream);
            } else {
                ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
                if (this.mMimeType == 4) {
                    getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                } else if (this.mMimeType == 13) {
                    getPngAttributes(byteOrderedDataInputStream);
                } else if (this.mMimeType == 9) {
                    getRafAttributes(byteOrderedDataInputStream);
                } else if (this.mMimeType == 14) {
                    getWebpAttributes(byteOrderedDataInputStream);
                }
            }
            addDefaultValuesForCompatibility();
            if (!DEBUG) {
                return;
            }
            printAttributes();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                ExifInterfaceUtils.Api21Impl.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
                if (DEBUG) {
                    SystemUtils.log(3, TAG, "The file descriptor for the given input is not seekable", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4641);
                }
            }
        }
        return false;
    }

    private void printAttributes() {
        for (int i = 0; i < this.mAttributes.length; i++) {
            SystemUtils.log(3, TAG, "The size of tag group[" + i + "]: " + this.mAttributes[i].size(), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4652);
            for (Map.Entry next : this.mAttributes[i].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                SystemUtils.log(3, TAG, "tagName: " + ((String) next.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.getStringValue(this.mExifByteOrder) + "'", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 4655);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0170, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ed, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ee, code lost:
        r10 = null;
        r1 = r7;
        r7 = r9;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00f3, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f4, code lost:
        r9 = null;
        r10 = null;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f9, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x010c, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 21) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x010e, code lost:
        androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r14.mSeekableFileDescriptor, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r14.mSeekableFileDescriptor);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x011d, code lost:
        r1 = new java.io.FileOutputStream(r14.mFilename);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:30:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010a A[Catch:{ Exception -> 0x0139, all -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011d A[Catch:{ Exception -> 0x0139, all -> 0x0136 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveAttributes() throws java.io.IOException {
        /*
            r14 = this;
            int r0 = r14.mMimeType
            boolean r0 = isSupportedFormatForSavingAttributes(r0)
            if (r0 == 0) goto L_0x0195
            java.io.FileDescriptor r0 = r14.mSeekableFileDescriptor
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r14.mFilename
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r0 = r14.mHasThumbnail
            if (r0 == 0) goto L_0x002e
            boolean r0 = r14.mHasThumbnailStrips
            if (r0 == 0) goto L_0x002e
            boolean r0 = r14.mAreThumbnailStripsConsecutive
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            r0 = 1
            r14.mModified = r0
            byte[] r1 = r14.getThumbnail()
            r14.mThumbnailBytes = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            java.lang.String r3 = r14.mFilename     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            r4 = 0
            r6 = 21
            if (r3 == 0) goto L_0x0050
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            java.lang.String r7 = r14.mFilename     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            goto L_0x0064
        L_0x0050:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            if (r3 < r6) goto L_0x0063
            java.io.FileDescriptor r3 = r14.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            int r7 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r3, r4, r7)     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            java.io.FileDescriptor r7 = r14.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0183, all -> 0x0180 }
            goto L_0x0064
        L_0x0063:
            r3 = r1
        L_0x0064:
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r3, r7)     // Catch:{ Exception -> 0x0176, all -> 0x0174 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r3)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r7)
            r3 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00fc, all -> 0x00f8 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00fc, all -> 0x00f8 }
            java.lang.String r8 = r14.mFilename     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            if (r8 == 0) goto L_0x0084
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            java.lang.String r9 = r14.mFilename     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            goto L_0x0098
        L_0x0084:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            if (r8 < r6) goto L_0x0097
            java.io.FileDescriptor r8 = r14.mSeekableFileDescriptor     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            int r9 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r8, r4, r9)     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            java.io.FileDescriptor r9 = r14.mSeekableFileDescriptor     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00f3, all -> 0x00f8 }
            goto L_0x0098
        L_0x0097:
            r8 = r1
        L_0x0098:
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ed, all -> 0x00f8 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00ed, all -> 0x00f8 }
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00e7, all -> 0x00e3 }
            r10.<init>(r8)     // Catch:{ Exception -> 0x00e7, all -> 0x00e3 }
            int r11 = r14.mMimeType     // Catch:{ Exception -> 0x00de }
            r12 = 4
            if (r11 != r12) goto L_0x00ab
            r14.saveJpegAttributes(r9, r10)     // Catch:{ Exception -> 0x00de }
            goto L_0x00d2
        L_0x00ab:
            int r11 = r14.mMimeType     // Catch:{ Exception -> 0x00de }
            r12 = 13
            if (r11 != r12) goto L_0x00b5
            r14.savePngAttributes(r9, r10)     // Catch:{ Exception -> 0x00de }
            goto L_0x00d2
        L_0x00b5:
            int r11 = r14.mMimeType     // Catch:{ Exception -> 0x00de }
            r12 = 14
            if (r11 != r12) goto L_0x00bf
            r14.saveWebpAttributes(r9, r10)     // Catch:{ Exception -> 0x00de }
            goto L_0x00d2
        L_0x00bf:
            int r11 = r14.mMimeType     // Catch:{ Exception -> 0x00de }
            r12 = 3
            if (r11 == r12) goto L_0x00c8
            int r11 = r14.mMimeType     // Catch:{ Exception -> 0x00de }
            if (r11 != 0) goto L_0x00d2
        L_0x00c8:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream r11 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream     // Catch:{ Exception -> 0x00de }
            java.nio.ByteOrder r12 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ Exception -> 0x00de }
            r11.<init>(r10, r12)     // Catch:{ Exception -> 0x00de }
            r14.writeExifSegment(r11)     // Catch:{ Exception -> 0x00de }
        L_0x00d2:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r9)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r10)
            r2.delete()
            r14.mThumbnailBytes = r1
            return
        L_0x00de:
            r1 = move-exception
            r13 = r7
            r7 = r1
            r1 = r13
            goto L_0x0101
        L_0x00e3:
            r0 = move-exception
            r10 = r1
            goto L_0x0167
        L_0x00e7:
            r10 = move-exception
            r13 = r10
            r10 = r1
            r1 = r7
            r7 = r13
            goto L_0x0101
        L_0x00ed:
            r9 = move-exception
            r10 = r1
            r1 = r7
            r7 = r9
            r9 = r10
            goto L_0x0101
        L_0x00f3:
            r8 = move-exception
            r9 = r1
            r10 = r9
            r1 = r7
            goto L_0x00ff
        L_0x00f8:
            r0 = move-exception
            r10 = r1
            goto L_0x0168
        L_0x00fc:
            r8 = move-exception
            r9 = r1
            r10 = r9
        L_0x00ff:
            r7 = r8
            r8 = r10
        L_0x0101:
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x013d, all -> 0x013b }
            r11.<init>(r2)     // Catch:{ Exception -> 0x013d, all -> 0x013b }
            java.lang.String r1 = r14.mFilename     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            if (r1 != 0) goto L_0x011d
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            if (r1 < r6) goto L_0x0125
            java.io.FileDescriptor r1 = r14.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r1, r4, r6)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.io.FileDescriptor r4 = r14.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            goto L_0x0124
        L_0x011d:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.lang.String r4 = r14.mFilename     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
        L_0x0124:
            r8 = r1
        L_0x0125:
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r11, r8)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r11)     // Catch:{ all -> 0x0166 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r8)     // Catch:{ all -> 0x0166 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0166 }
            java.lang.String r1 = "Failed to save new file"
            r0.<init>(r1, r7)     // Catch:{ all -> 0x0166 }
            throw r0     // Catch:{ all -> 0x0166 }
        L_0x0136:
            r0 = move-exception
            r1 = r11
            goto L_0x015f
        L_0x0139:
            r1 = move-exception
            goto L_0x0140
        L_0x013b:
            r0 = move-exception
            goto L_0x015f
        L_0x013d:
            r3 = move-exception
            r11 = r1
            r1 = r3
        L_0x0140:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            r4.<init>()     // Catch:{ all -> 0x015b }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x015b }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x015b }
            r4.append(r5)     // Catch:{ all -> 0x015b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015b }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x015b }
            throw r3     // Catch:{ all -> 0x015b }
        L_0x015b:
            r1 = move-exception
            r0 = r1
            r1 = r11
            r3 = 1
        L_0x015f:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)     // Catch:{ all -> 0x0166 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r8)     // Catch:{ all -> 0x0166 }
            throw r0     // Catch:{ all -> 0x0166 }
        L_0x0166:
            r0 = move-exception
        L_0x0167:
            r1 = r9
        L_0x0168:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r10)
            if (r3 != 0) goto L_0x0173
            r2.delete()
        L_0x0173:
            throw r0
        L_0x0174:
            r0 = move-exception
            goto L_0x017a
        L_0x0176:
            r0 = move-exception
            goto L_0x017e
        L_0x0178:
            r0 = move-exception
            r7 = r1
        L_0x017a:
            r1 = r3
            goto L_0x018e
        L_0x017c:
            r0 = move-exception
            r7 = r1
        L_0x017e:
            r1 = r3
            goto L_0x0185
        L_0x0180:
            r0 = move-exception
            r7 = r1
            goto L_0x018e
        L_0x0183:
            r0 = move-exception
            r7 = r1
        L_0x0185:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x018d }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x018d }
            throw r2     // Catch:{ all -> 0x018d }
        L_0x018d:
            r0 = move-exception
        L_0x018e:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r7)
            throw r0
        L_0x0195:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes for JPEG, PNG, WebP, and DNG formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveAttributes():void");
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean hasAttribute(String str) {
        return getExifAttribute(str) != null;
    }

    public byte[] getThumbnail() {
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x006f A[SYNTHETIC, Splitter:B:39:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab A[Catch:{ Exception -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getThumbnailBytes() {
        /*
            r10 = this;
            boolean r0 = r10.mHasThumbnail
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            byte[] r0 = r10.mThumbnailBytes
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            android.content.res.AssetManager$AssetInputStream r0 = r10.mAssetInputStream     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            if (r0 == 0) goto L_0x0039
            android.content.res.AssetManager$AssetInputStream r0 = r10.mAssetInputStream     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            boolean r2 = r0.markSupported()     // Catch:{ Exception -> 0x0034, all -> 0x002d }
            if (r2 == 0) goto L_0x001c
            r0.reset()     // Catch:{ Exception -> 0x0034, all -> 0x002d }
        L_0x001a:
            r2 = r1
            goto L_0x006d
        L_0x001c:
            java.lang.String r4 = "ExifInterface"
            java.lang.String r5 = "Cannot read thumbnail from inputstream without mark/reset support"
            r3 = 3
            r6 = 0
            java.lang.String r7 = "androidx.exifinterface.media.ExifInterface"
            r8 = 4843(0x12eb, float:6.786E-42)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0034, all -> 0x002d }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r0)
            return r1
        L_0x002d:
            r2 = move-exception
            r9 = r1
            r1 = r0
            r0 = r2
            r2 = r9
            goto L_0x00d2
        L_0x0034:
            r2 = move-exception
            r6 = r2
            r2 = r1
            goto L_0x00b9
        L_0x0039:
            java.lang.String r0 = r10.mFilename     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            if (r0 == 0) goto L_0x0045
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            java.lang.String r2 = r10.mFilename     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            goto L_0x001a
        L_0x0045:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            r2 = 21
            if (r0 < r2) goto L_0x006b
            java.io.FileDescriptor r0 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            java.io.FileDescriptor r0 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.dup(r0)     // Catch:{ Exception -> 0x00b5, all -> 0x00b1 }
            r2 = 0
            int r4 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0066, all -> 0x0061 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r0, r2, r4)     // Catch:{ Exception -> 0x0066, all -> 0x0061 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0066, all -> 0x0061 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0066, all -> 0x0061 }
            r9 = r2
            r2 = r0
            r0 = r9
            goto L_0x006d
        L_0x0061:
            r2 = move-exception
            r9 = r2
            r2 = r0
            goto L_0x00d1
        L_0x0066:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r1
            goto L_0x00b9
        L_0x006b:
            r0 = r1
            r2 = r0
        L_0x006d:
            if (r0 == 0) goto L_0x00ab
            int r3 = r10.mThumbnailOffset     // Catch:{ Exception -> 0x00a8 }
            int r4 = r10.mOffsetToExifData     // Catch:{ Exception -> 0x00a8 }
            int r3 = r3 + r4
            long r3 = (long) r3     // Catch:{ Exception -> 0x00a8 }
            long r3 = r0.skip(r3)     // Catch:{ Exception -> 0x00a8 }
            int r5 = r10.mThumbnailOffset     // Catch:{ Exception -> 0x00a8 }
            int r6 = r10.mOffsetToExifData     // Catch:{ Exception -> 0x00a8 }
            int r5 = r5 + r6
            long r5 = (long) r5
            java.lang.String r7 = "Corrupted image"
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x00a2
            int r3 = r10.mThumbnailLength     // Catch:{ Exception -> 0x00a8 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x00a8 }
            int r4 = r0.read(r3)     // Catch:{ Exception -> 0x00a8 }
            int r5 = r10.mThumbnailLength     // Catch:{ Exception -> 0x00a8 }
            if (r4 != r5) goto L_0x009c
            r10.mThumbnailBytes = r3     // Catch:{ Exception -> 0x00a8 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r0)
            if (r2 == 0) goto L_0x009b
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r2)
        L_0x009b:
            return r3
        L_0x009c:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x00a8 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00a8 }
            throw r3     // Catch:{ Exception -> 0x00a8 }
        L_0x00a2:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x00a8 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00a8 }
            throw r3     // Catch:{ Exception -> 0x00a8 }
        L_0x00a8:
            r3 = move-exception
            r6 = r3
            goto L_0x00b9
        L_0x00ab:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException     // Catch:{ Exception -> 0x00a8 }
            r3.<init>()     // Catch:{ Exception -> 0x00a8 }
            throw r3     // Catch:{ Exception -> 0x00a8 }
        L_0x00b1:
            r2 = move-exception
            r0 = r2
            r2 = r1
            goto L_0x00d2
        L_0x00b5:
            r2 = move-exception
            r0 = r1
            r6 = r2
            r2 = r0
        L_0x00b9:
            java.lang.String r4 = "ExifInterface"
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            r3 = 3
            java.lang.String r7 = "androidx.exifinterface.media.ExifInterface"
            r8 = 4875(0x130b, float:6.831E-42)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ce }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r0)
            if (r2 == 0) goto L_0x00cd
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r2)
        L_0x00cd:
            return r1
        L_0x00ce:
            r1 = move-exception
            r9 = r1
            r1 = r0
        L_0x00d1:
            r0 = r9
        L_0x00d2:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            if (r2 == 0) goto L_0x00da
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r2)
        L_0x00da:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getThumbnailBytes():byte[]");
    }

    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte[] bArr = this.mThumbnailBytes;
                int i3 = i2 * 3;
                iArr[i2] = (bArr[i3] << 16) + 0 + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
            }
            ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_WIDTH);
            if (!(exifAttribute == null || exifAttribute2 == null)) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return true;
        }
        return false;
    }

    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        } else if (!this.mHasThumbnail) {
            return null;
        } else {
            if (this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
                return null;
            }
            return new long[]{(long) (this.mThumbnailOffset + this.mOffsetToExifData), (long) this.mThumbnailLength};
        }
    }

    public long[] getAttributeRange(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        } else if (!this.mModified) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return null;
            }
            return new long[]{exifAttribute.bytesOffset, (long) exifAttribute.bytes.length};
        } else {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
    }

    public byte[] getAttributeBytes(String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                return exifAttribute.bytes;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            SystemUtils.log(5, TAG, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4}), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 5049);
            return null;
        }
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute(TAG_GPS_SPEED_REF, "K");
            setAttribute(TAG_GPS_SPEED, new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = sFormatterPrimary.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute(TAG_GPS_DATESTAMP, split[0]);
            setAttribute(TAG_GPS_TIMESTAMP, split[1]);
        }
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
            throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
        } else if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        } else {
            setAttribute(TAG_GPS_LATITUDE_REF, d >= 0.0d ? "N" : LATITUDE_SOUTH);
            setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d)));
            setAttribute(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
            setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d2)));
        }
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d;
        }
        if (attributeInt != 1) {
            i = 1;
        }
        return attributeDouble * ((double) i);
    }

    public void setAltitude(double d) {
        String str = d >= 0.0d ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    public void setDateTime(Long l) {
        if (l == null) {
            throw new NullPointerException("Timestamp should not be null.");
        } else if (l.longValue() >= 0) {
            String l2 = Long.toString(l.longValue() % 1000);
            for (int length = l2.length(); length < 3; length++) {
                l2 = "0" + l2;
            }
            setAttribute(TAG_DATETIME, sFormatterPrimary.format(new Date(l.longValue())));
            setAttribute(TAG_SUBSEC_TIME, l2);
        } else {
            throw new IllegalArgumentException("Timestamp should a positive value.");
        }
    }

    public Long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if ("-".equals(r1) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Long parseDateTime(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0085
            java.util.regex.Pattern r1 = NON_ZERO_TIME_PATTERN
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x0011
            goto L_0x0085
        L_0x0011:
            java.text.ParsePosition r1 = new java.text.ParsePosition
            r2 = 0
            r1.<init>(r2)
            java.text.SimpleDateFormat r3 = sFormatterPrimary     // Catch:{ IllegalArgumentException -> 0x0085 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0085 }
            if (r3 != 0) goto L_0x0028
            java.text.SimpleDateFormat r3 = sFormatterSecondary     // Catch:{ IllegalArgumentException -> 0x0085 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0085 }
            if (r3 != 0) goto L_0x0028
            return r0
        L_0x0028:
            long r3 = r3.getTime()     // Catch:{ IllegalArgumentException -> 0x0085 }
            if (r12 == 0) goto L_0x0079
            r10 = 1
            java.lang.String r1 = r12.substring(r2, r10)     // Catch:{ IllegalArgumentException -> 0x0085 }
            r2 = 3
            java.lang.String r5 = r12.substring(r10, r2)     // Catch:{ IllegalArgumentException -> 0x0085 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x0085 }
            r6 = 6
            r7 = 4
            java.lang.String r6 = r12.substring(r7, r6)     // Catch:{ IllegalArgumentException -> 0x0085 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x0085 }
            java.lang.String r8 = "+"
            boolean r8 = r8.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0085 }
            java.lang.String r9 = "-"
            if (r8 != 0) goto L_0x0056
            boolean r8 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0085 }
            if (r8 == 0) goto L_0x0079
        L_0x0056:
            java.lang.String r8 = ":"
            java.lang.String r12 = r12.substring(r2, r7)     // Catch:{ IllegalArgumentException -> 0x0085 }
            boolean r12 = r8.equals(r12)     // Catch:{ IllegalArgumentException -> 0x0085 }
            if (r12 == 0) goto L_0x0079
            r12 = 14
            if (r5 > r12) goto L_0x0079
            int r5 = r5 * 60
            int r5 = r5 + r6
            int r5 = r5 * 60
            int r5 = r5 * 1000
            boolean r12 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0085 }
            if (r12 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r10 = -1
        L_0x0075:
            int r5 = r5 * r10
            long r1 = (long) r5     // Catch:{ IllegalArgumentException -> 0x0085 }
            long r3 = r3 + r1
        L_0x0079:
            if (r11 == 0) goto L_0x0080
            long r10 = androidx.exifinterface.media.ExifInterfaceUtils.parseSubSeconds(r11)     // Catch:{ IllegalArgumentException -> 0x0085 }
            long r3 = r3 + r10
        L_0x0080:
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0085 }
            return r10
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.parseDateTime(java.lang.String, java.lang.String, java.lang.String):java.lang.Long");
    }

    public Long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (!(attribute == null || attribute2 == null || (!NON_ZERO_TIME_PATTERN.matcher(attribute).matches() && !NON_ZERO_TIME_PATTERN.matcher(attribute2).matches()))) {
            String str = attribute + ' ' + attribute2;
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                Date parse = sFormatterPrimary.parse(str, parsePosition);
                if (parse == null && (parse = sFormatterSecondary.parse(str, parsePosition)) == null) {
                    return null;
                }
                return Long.valueOf(parse.getTime());
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    private void initForFilename(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (isSeekableFD(fileInputStream2.getFD())) {
                        this.mSeekableFileDescriptor = fileInputStream2.getFD();
                    } else {
                        this.mSeekableFileDescriptor = null;
                    }
                    loadAttributes(fileInputStream2);
                    ExifInterfaceUtils.closeQuietly(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    ExifInterfaceUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                ExifInterfaceUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH)) {
                if (!str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(LONGITUDE_EAST)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - ((double) j);
        long j2 = (long) (d2 * 60.0d);
        long round = Math.round((d2 - (((double) j2) / 60.0d)) * 3600.0d * 1.0E7d);
        return j + "/1," + j2 + "/1," + round + "/10000000";
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        return isWebpFormat(bArr) ? 14 : 0;
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0094 A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isHeifFormat(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x008e }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008e }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = HEIF_TYPE_FTYP     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 16
            r7 = 8
            r9 = 1
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r11 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r11 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r5 = r7
        L_0x0035:
            int r11 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r11 = (long) r11     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r5
            int r15 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = HEIF_BRAND_MIF1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r7 = 1
            goto L_0x0077
        L_0x006e:
            byte[] r11 = HEIF_BRAND_HEIC     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r8 = 1
        L_0x0077:
            if (r7 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r5 = r5 + r9
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x00a5
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x00a6
        L_0x0088:
            r15 = move-exception
            r5 = r15
            r1 = r2
            goto L_0x0090
        L_0x008c:
            r15 = move-exception
            goto L_0x00a6
        L_0x008e:
            r15 = move-exception
            r5 = r15
        L_0x0090:
            boolean r15 = DEBUG     // Catch:{ all -> 0x008c }
            if (r15 == 0) goto L_0x00a0
            java.lang.String r3 = "ExifInterface"
            java.lang.String r4 = "Exception parsing HEIF file type box."
            r2 = 3
            java.lang.String r6 = "androidx.exifinterface.media.ExifInterface"
            r7 = 5454(0x154e, float:7.643E-42)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x008c }
        L_0x00a0:
            if (r1 == 0) goto L_0x00a5
            r1.close()
        L_0x00a5:
            return r0
        L_0x00a6:
            if (r1 == 0) goto L_0x00ab
            r1.close()
        L_0x00ab:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isHeifFormat(byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isOrfFormat(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002e
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
        L_0x002e:
            if (r1 == 0) goto L_0x0033
            r1.close()
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isOrfFormat(byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isRw2Format(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x002a
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isRw2Format(byte[]):boolean");
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else if (bArr[i] != bArr2[i]) {
                return false;
            } else {
                i++;
            }
        }
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(IDENTIFIER_EXIF_APP1.length);
        byte[] bArr = new byte[IDENTIFIER_EXIF_APP1.length];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr2 = IDENTIFIER_EXIF_APP1;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0197 A[LOOP:0: B:8:0x003e->B:57:0x0197, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x019f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r20, int r21, int r22) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0026
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getJpegAttributes starting with: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r7 = r3.toString()
            r5 = 3
            r8 = 0
            r10 = 5583(0x15cf, float:7.823E-42)
            java.lang.String r6 = "ExifInterface"
            java.lang.String r9 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
        L_0x0026:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.setByteOrder(r3)
            byte r3 = r20.readByte()
            java.lang.String r4 = "Invalid marker: "
            r5 = -1
            if (r3 != r5) goto L_0x01e9
            byte r6 = r20.readByte()
            r7 = -40
            if (r6 != r7) goto L_0x01ce
            r3 = 2
            r4 = 2
        L_0x003e:
            byte r6 = r20.readByte()
            if (r6 != r5) goto L_0x01b1
            r6 = 1
            int r4 = r4 + r6
            byte r7 = r20.readByte()
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x0070
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Found JPEG segment indicator: "
            r8.append(r9)
            r9 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)
            r8.append(r9)
            java.lang.String r12 = r8.toString()
            r10 = 3
            r13 = 0
            r15 = 5607(0x15e7, float:7.857E-42)
            java.lang.String r11 = "ExifInterface"
            java.lang.String r14 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
        L_0x0070:
            int r4 = r4 + r6
            r8 = -39
            if (r7 == r8) goto L_0x01ab
            r8 = -38
            if (r7 != r8) goto L_0x007b
            goto L_0x01ab
        L_0x007b:
            int r8 = r20.readUnsignedShort()
            int r8 = r8 - r3
            int r4 = r4 + r3
            boolean r9 = DEBUG
            if (r9 == 0) goto L_0x00b6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "JPEG segment: "
            r9.append(r10)
            r10 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r9.append(r10)
            java.lang.String r10 = " (length: "
            r9.append(r10)
            int r10 = r8 + 2
            r9.append(r10)
            java.lang.String r10 = ")"
            r9.append(r10)
            java.lang.String r13 = r9.toString()
            r11 = 3
            r14 = 0
            r16 = 5619(0x15f3, float:7.874E-42)
            java.lang.String r12 = "ExifInterface"
            java.lang.String r15 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)
        L_0x00b6:
            java.lang.String r9 = "Invalid length"
            if (r8 < 0) goto L_0x01a5
            r10 = -31
            r11 = 0
            if (r7 == r10) goto L_0x0135
            r10 = -2
            if (r7 == r10) goto L_0x010a
            switch(r7) {
                case -64: goto L_0x00d0;
                case -63: goto L_0x00d0;
                case -62: goto L_0x00d0;
                case -61: goto L_0x00d0;
                default: goto L_0x00c5;
            }
        L_0x00c5:
            switch(r7) {
                case -59: goto L_0x00d0;
                case -58: goto L_0x00d0;
                case -57: goto L_0x00d0;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            switch(r7) {
                case -55: goto L_0x00d0;
                case -54: goto L_0x00d0;
                case -53: goto L_0x00d0;
                default: goto L_0x00cb;
            }
        L_0x00cb:
            switch(r7) {
                case -51: goto L_0x00d0;
                case -50: goto L_0x00d0;
                case -49: goto L_0x00d0;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            goto L_0x0195
        L_0x00d0:
            r1.skipFully(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r2]
            r7 = 4
            if (r2 == r7) goto L_0x00dd
            java.lang.String r10 = "ImageLength"
            goto L_0x00df
        L_0x00dd:
            java.lang.String r10 = "ThumbnailImageLength"
        L_0x00df:
            int r11 = r20.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r11, (java.nio.ByteOrder) r13)
            r6.put(r10, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r2]
            if (r2 == r7) goto L_0x00f6
            java.lang.String r7 = "ImageWidth"
            goto L_0x00f8
        L_0x00f6:
            java.lang.String r7 = "ThumbnailImageWidth"
        L_0x00f8:
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r10 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r10, (java.nio.ByteOrder) r12)
            r6.put(r7, r10)
            int r8 = r8 + -5
            goto L_0x0195
        L_0x010a:
            byte[] r7 = new byte[r8]
            int r10 = r1.read(r7)
            if (r10 != r8) goto L_0x012d
            java.lang.String r8 = "UserComment"
            java.lang.String r10 = r0.getAttribute(r8)
            if (r10 != 0) goto L_0x0194
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r10 = r0.mAttributes
            r6 = r10[r6]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r12 = ASCII
            r10.<init>(r7, r12)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r7 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r10)
            r6.put(r8, r7)
            goto L_0x0194
        L_0x012d:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0135:
            byte[] r7 = new byte[r8]
            r1.readFully(r7)
            int r10 = r4 + r8
            byte[] r12 = IDENTIFIER_EXIF_APP1
            boolean r12 = androidx.exifinterface.media.ExifInterfaceUtils.startsWith(r7, r12)
            if (r12 == 0) goto L_0x015f
            byte[] r6 = IDENTIFIER_EXIF_APP1
            int r6 = r6.length
            byte[] r6 = java.util.Arrays.copyOfRange(r7, r6, r8)
            int r4 = r21 + r4
            byte[] r7 = IDENTIFIER_EXIF_APP1
            int r7 = r7.length
            int r4 = r4 + r7
            r0.mOffsetToExifData = r4
            r0.readExifSegment(r6, r2)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r4 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r4.<init>((byte[]) r6)
            r0.setThumbnailData(r4)
            goto L_0x0193
        L_0x015f:
            byte[] r12 = IDENTIFIER_XMP_APP1
            boolean r12 = androidx.exifinterface.media.ExifInterfaceUtils.startsWith(r7, r12)
            if (r12 == 0) goto L_0x0193
            byte[] r12 = IDENTIFIER_XMP_APP1
            int r13 = r12.length
            int r4 = r4 + r13
            int r12 = r12.length
            byte[] r7 = java.util.Arrays.copyOfRange(r7, r12, r8)
            java.lang.String r8 = "Xmp"
            java.lang.String r12 = r0.getAttribute(r8)
            if (r12 != 0) goto L_0x0193
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r12 = r0.mAttributes
            r12 = r12[r11]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r15 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            r14 = 1
            int r13 = r7.length
            long r3 = (long) r4
            r16 = r13
            r13 = r15
            r5 = r15
            r15 = r16
            r16 = r3
            r18 = r7
            r13.<init>(r14, r15, r16, r18)
            r12.put(r8, r5)
            r0.mXmpIsFromSeparateMarker = r6
        L_0x0193:
            r4 = r10
        L_0x0194:
            r8 = 0
        L_0x0195:
            if (r8 < 0) goto L_0x019f
            r1.skipFully(r8)
            int r4 = r4 + r8
            r3 = 2
            r5 = -1
            goto L_0x003e
        L_0x019f:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x01a5:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x01ab:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            r1.setByteOrder(r2)
            return
        L_0x01b1:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r6 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01ce:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01e9:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private void getRawAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType == 8 && (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            seekableByteOrderedDataInputStream2.skipFully(6);
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
            if (exifAttribute2 != null) {
                this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            SystemUtils.log(3, TAG, "getRafAttributes starting with: " + byteOrderedDataInputStream, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 5763);
        }
        byteOrderedDataInputStream.skipFully(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        byteOrderedDataInputStream.skipFully(i - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.read(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i, 5);
        byteOrderedDataInputStream.skipFully(i3 - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (DEBUG) {
            SystemUtils.log(3, TAG, "numberOfDirectoryEntry: " + readInt, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 5792);
        }
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort((int) readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort((int) readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                if (DEBUG) {
                    SystemUtils.log(3, TAG, "Updated to length: " + readShort + ", width: " + readShort2, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 5810);
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipFully(readUnsignedShort2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013e, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0147, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0148, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x014b, code lost:
        throw r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0140 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getHeifAttributes(final androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x014c
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.ExifInterface$1 r2 = new androidx.exifinterface.media.ExifInterface$1     // Catch:{ RuntimeException -> 0x0140 }
            r2.<init>(r14)     // Catch:{ RuntimeException -> 0x0140 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api23Impl.setDataSource(r1, r2)     // Catch:{ RuntimeException -> 0x0140 }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x0140 }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x0140 }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0140 }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0140 }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x0140 }
            r6 = 0
            if (r4 == 0) goto L_0x0047
            r0 = 29
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0140 }
            r0 = 30
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0140 }
            r4 = 31
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0140 }
            goto L_0x0062
        L_0x0047:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x0140 }
            if (r0 == 0) goto L_0x0060
            r0 = 18
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0140 }
            r0 = 19
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0140 }
            r4 = 24
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0140 }
            goto L_0x0062
        L_0x0060:
            r0 = r6
            r4 = r0
        L_0x0062:
            r5 = 0
            if (r6 == 0) goto L_0x0078
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r13.mAttributes     // Catch:{ RuntimeException -> 0x0140 }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r6)     // Catch:{ RuntimeException -> 0x0140 }
            java.nio.ByteOrder r10 = r13.mExifByteOrder     // Catch:{ RuntimeException -> 0x0140 }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r9, (java.nio.ByteOrder) r10)     // Catch:{ RuntimeException -> 0x0140 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0140 }
        L_0x0078:
            if (r0 == 0) goto L_0x008d
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r13.mAttributes     // Catch:{ RuntimeException -> 0x0140 }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x0140 }
            java.nio.ByteOrder r10 = r13.mExifByteOrder     // Catch:{ RuntimeException -> 0x0140 }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r9, (java.nio.ByteOrder) r10)     // Catch:{ RuntimeException -> 0x0140 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0140 }
        L_0x008d:
            r7 = 6
            if (r4 == 0) goto L_0x00b7
            r8 = 1
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x0140 }
            r10 = 90
            if (r9 == r10) goto L_0x00a7
            r10 = 180(0xb4, float:2.52E-43)
            if (r9 == r10) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            if (r9 == r10) goto L_0x00a2
            goto L_0x00a8
        L_0x00a2:
            r8 = 8
            goto L_0x00a8
        L_0x00a5:
            r8 = 3
            goto L_0x00a8
        L_0x00a7:
            r8 = 6
        L_0x00a8:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r9 = r13.mAttributes     // Catch:{ RuntimeException -> 0x0140 }
            r9 = r9[r5]     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r13.mExifByteOrder     // Catch:{ RuntimeException -> 0x0140 }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r8, (java.nio.ByteOrder) r11)     // Catch:{ RuntimeException -> 0x0140 }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x0140 }
        L_0x00b7:
            if (r2 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x0140 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x0140 }
            if (r3 <= r7) goto L_0x0102
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x0140 }
            r14.seek(r8)     // Catch:{ RuntimeException -> 0x0140 }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x0140 }
            int r9 = r14.read(r8)     // Catch:{ RuntimeException -> 0x0140 }
            if (r9 != r7) goto L_0x00fa
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = IDENTIFIER_EXIF_APP1     // Catch:{ RuntimeException -> 0x0140 }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x0140 }
            if (r7 == 0) goto L_0x00f2
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x0140 }
            int r14 = r14.read(r7)     // Catch:{ RuntimeException -> 0x0140 }
            if (r14 != r3) goto L_0x00ea
            r13.mOffsetToExifData = r2     // Catch:{ RuntimeException -> 0x0140 }
            r13.readExifSegment(r7, r5)     // Catch:{ RuntimeException -> 0x0140 }
            goto L_0x010a
        L_0x00ea:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r0 = "Can't read exif"
            r14.<init>(r0)     // Catch:{ RuntimeException -> 0x0140 }
            throw r14     // Catch:{ RuntimeException -> 0x0140 }
        L_0x00f2:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r0 = "Invalid identifier"
            r14.<init>(r0)     // Catch:{ RuntimeException -> 0x0140 }
            throw r14     // Catch:{ RuntimeException -> 0x0140 }
        L_0x00fa:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r0 = "Can't read identifier"
            r14.<init>(r0)     // Catch:{ RuntimeException -> 0x0140 }
            throw r14     // Catch:{ RuntimeException -> 0x0140 }
        L_0x0102:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r0 = "Invalid exif length"
            r14.<init>(r0)     // Catch:{ RuntimeException -> 0x0140 }
            throw r14     // Catch:{ RuntimeException -> 0x0140 }
        L_0x010a:
            boolean r14 = DEBUG     // Catch:{ RuntimeException -> 0x0140 }
            if (r14 == 0) goto L_0x013a
            java.lang.String r8 = "ExifInterface"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0140 }
            r14.<init>()     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r2 = "Heif meta: "
            r14.append(r2)     // Catch:{ RuntimeException -> 0x0140 }
            r14.append(r6)     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r2 = "x"
            r14.append(r2)     // Catch:{ RuntimeException -> 0x0140 }
            r14.append(r0)     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r0 = ", rotation "
            r14.append(r0)     // Catch:{ RuntimeException -> 0x0140 }
            r14.append(r4)     // Catch:{ RuntimeException -> 0x0140 }
            java.lang.String r9 = r14.toString()     // Catch:{ RuntimeException -> 0x0140 }
            r7 = 3
            r10 = 0
            java.lang.String r11 = "androidx.exifinterface.media.ExifInterface"
            r12 = 5967(0x174f, float:8.362E-42)
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)     // Catch:{ RuntimeException -> 0x0140 }
        L_0x013a:
            r1.release()
            return
        L_0x013e:
            r14 = move-exception
            goto L_0x0148
        L_0x0140:
            java.lang.UnsupportedOperationException r14 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x013e }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r14.<init>(r0)     // Catch:{ all -> 0x013e }
            throw r14     // Catch:{ all -> 0x013e }
        L_0x0148:
            r1.release()
            throw r14
        L_0x014c:
            java.lang.UnsupportedOperationException r14 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getHeifAttributes(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream):void");
    }

    private void getStandaloneAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        seekableByteOrderedDataInputStream.skipFully(IDENTIFIER_EXIF_APP1.length);
        byte[] bArr = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr);
        this.mOffsetToExifData = IDENTIFIER_EXIF_APP1.length;
        readExifSegment(bArr, 0);
    }

    private void getOrfAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = new byte[ORF_MAKER_NOTE_HEADER_1.length];
            seekableByteOrderedDataInputStream2.readFully(bArr);
            seekableByteOrderedDataInputStream2.seek(0);
            byte[] bArr2 = new byte[ORF_MAKER_NOTE_HEADER_2.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            if (Arrays.equals(bArr, ORF_MAKER_NOTE_HEADER_1)) {
                seekableByteOrderedDataInputStream2.seek(8);
            } else if (Arrays.equals(bArr2, ORF_MAKER_NOTE_HEADER_2)) {
                seekableByteOrderedDataInputStream2.seek(12);
            }
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    SystemUtils.log(5, TAG, "Invalid aspect frame values. frame=" + Arrays.toString(iArr), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6055);
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i2, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
                }
            }
        }
    }

    private void getRw2Attributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            SystemUtils.log(3, TAG, "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6086);
        }
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute3 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute2);
        }
    }

    private void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            SystemUtils.log(3, TAG, "getPngAttributes starting with: " + byteOrderedDataInputStream, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6115);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byteOrderedDataInputStream.skipFully(PNG_SIGNATURE.length);
        int length = PNG_SIGNATURE.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i = length + 4;
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) == 4) {
                    int i2 = i + 4;
                    if (i2 == 16) {
                        if (!Arrays.equals(bArr, PNG_CHUNK_TYPE_IHDR)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr, PNG_CHUNK_TYPE_IEND)) {
                        if (Arrays.equals(bArr, PNG_CHUNK_TYPE_EXIF)) {
                            byte[] bArr2 = new byte[readInt];
                            if (byteOrderedDataInputStream.read(bArr2) == readInt) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr);
                                crc32.update(bArr2);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.mOffsetToExifData = i2;
                                    readExifSegment(bArr2, 0);
                                    validateImages();
                                    setThumbnailData(new ByteOrderedDataInputStream(bArr2));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(bArr));
                        }
                        int i3 = readInt + 4;
                        byteOrderedDataInputStream.skipFully(i3);
                        length = i2 + i3;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            SystemUtils.log(3, TAG, "getWebpAttributes starting with: " + byteOrderedDataInputStream, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6203);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_2.length);
        int length = WEBP_SIGNATURE_2.length + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i = length + 4 + 4;
                    if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr2) == readInt2) {
                            this.mOffsetToExifData = i;
                            readExifSegment(bArr2, 0);
                            setThumbnailData(new ByteOrderedDataInputStream(bArr2));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(bArr));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            byteOrderedDataInputStream.skipFully(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            SystemUtils.log(3, TAG, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6282);
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (byteOrderedDataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.writeByte(-40);
                ExifAttribute exifAttribute = null;
                if (getAttribute(TAG_XMP) != null && this.mXmpIsFromSeparateMarker) {
                    exifAttribute = this.mAttributes[0].remove(TAG_XMP);
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(-31);
                writeExifSegment(byteOrderedDataOutputStream);
                if (exifAttribute != null) {
                    this.mAttributes[0].put(TAG_XMP, exifAttribute);
                }
                byte[] bArr = new byte[4096];
                while (byteOrderedDataInputStream.readByte() == -1) {
                    byte readByte = byteOrderedDataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                        return;
                    } else if (readByte != -31) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                        byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                        int i = readUnsignedShort - 2;
                        if (i >= 0) {
                            while (i > 0) {
                                int read = byteOrderedDataInputStream.read(bArr, 0, Math.min(i, 4096));
                                if (read < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read);
                                i -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (byteOrderedDataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                    byteOrderedDataInputStream.skipFully(readUnsignedShort2 - 6);
                                }
                            }
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                byteOrderedDataOutputStream.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = byteOrderedDataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            SystemUtils.log(3, TAG, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6389);
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, PNG_SIGNATURE.length);
        int i = this.mOffsetToExifData;
        if (i == 0) {
            int readInt = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.writeInt(readInt);
            ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt + 4 + 4);
        } else {
            ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, ((i - PNG_SIGNATURE.length) - 4) - 4);
            byteOrderedDataInputStream.skipFully(byteOrderedDataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, ByteOrder.BIG_ENDIAN);
                writeExifSegment(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.mOutputStream).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream2);
                ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x01bf A[Catch:{ Exception -> 0x0206, all -> 0x0203 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01cb A[Catch:{ Exception -> 0x0206, all -> 0x0203 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void saveWebpAttributes(java.io.InputStream r20, java.io.OutputStream r21) throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0033
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "saveWebpAttributes starting with (inputStream: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = ", outputStream: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r7 = r3.toString()
            r5 = 3
            r8 = 0
            r10 = 6489(0x1959, float:9.093E-42)
            java.lang.String r6 = "ExifInterface"
            java.lang.String r9 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
        L_0x0033:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r3 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
            r3.<init>(r0, r4)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream r4 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream
            java.nio.ByteOrder r5 = java.nio.ByteOrder.LITTLE_ENDIAN
            r4.<init>(r2, r5)
            byte[] r2 = WEBP_SIGNATURE_1
            int r2 = r2.length
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r3, r4, r2)
            byte[] r2 = WEBP_SIGNATURE_2
            int r2 = r2.length
            r5 = 4
            int r2 = r2 + r5
            r3.skipFully(r2)
            r2 = 0
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x020b }
            r6.<init>()     // Catch:{ Exception -> 0x020b }
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream r7 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.<init>(r6, r8)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r8 = r1.mOffsetToExifData     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r8 == 0) goto L_0x007f
            byte[] r0 = WEBP_SIGNATURE_1     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r0 = r0.length     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r0 = r0 + r5
            byte[] r2 = WEBP_SIGNATURE_2     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r2 = r2.length     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r0 = r0 + r2
            int r2 = r1.mOffsetToExifData     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r2 = r2 - r0
            int r2 = r2 - r5
            int r2 = r2 - r5
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r3, r7, r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r3.skipFully(r5)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r0 = r3.readInt()     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r3.skipFully(r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            goto L_0x01e1
        L_0x007f:
            byte[] r8 = new byte[r5]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r9 = r3.read(r8)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r9 != r5) goto L_0x01fb
            byte[] r9 = WEBP_CHUNK_TYPE_VP8X     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r9 = java.util.Arrays.equals(r8, r9)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r10 = 8
            r11 = 1
            r12 = 0
            if (r9 == 0) goto L_0x00e6
            int r8 = r3.readInt()     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r9 = r8 % 2
            if (r9 != r11) goto L_0x009e
            int r9 = r8 + 1
            goto L_0x009f
        L_0x009e:
            r9 = r8
        L_0x009f:
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r3.read(r9)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte r13 = r9[r12]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r10 = r10 | r13
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r9[r12] = r10     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte r10 = r9[r12]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r10 = r10 >> r11
            r10 = r10 & r11
            if (r10 != r11) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r11 = 0
        L_0x00b2:
            byte[] r10 = WEBP_CHUNK_TYPE_VP8X     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.write(r10)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.writeInt(r8)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.write(r9)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r11 == 0) goto L_0x00da
            byte[] r8 = WEBP_CHUNK_TYPE_ANIM     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r1.copyChunksUpToGivenChunkType(r3, r7, r8, r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
        L_0x00c4:
            byte[] r2 = new byte[r5]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r0.read(r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r8 = WEBP_CHUNK_TYPE_ANMF     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r8 = java.util.Arrays.equals(r2, r8)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r8 != 0) goto L_0x00d6
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            goto L_0x01e1
        L_0x00d6:
            r1.copyWebPChunk(r3, r7, r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            goto L_0x00c4
        L_0x00da:
            byte[] r0 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r2 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r1.copyChunksUpToGivenChunkType(r3, r7, r0, r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            goto L_0x01e1
        L_0x00e6:
            byte[] r0 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r0 != 0) goto L_0x00f6
            byte[] r0 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r0 == 0) goto L_0x01e1
        L_0x00f6:
            int r0 = r3.readInt()     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r2 = r0 % 2
            if (r2 != r11) goto L_0x0101
            int r2 = r0 + 1
            goto L_0x0102
        L_0x0101:
            r2 = r0
        L_0x0102:
            r9 = 3
            byte[] r13 = new byte[r9]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r14 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r14 = java.util.Arrays.equals(r8, r14)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15 = 47
            if (r14 == 0) goto L_0x0139
            r3.read(r13)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r11 = new byte[r9]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r14 = r3.read(r11)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r14 != r9) goto L_0x0131
            byte[] r9 = WEBP_VP8_SIGNATURE     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r9 = java.util.Arrays.equals(r9, r11)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r9 == 0) goto L_0x0131
            int r9 = r3.readInt()     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r11 = r9 << 18
            int r11 = r11 >> 18
            int r14 = r9 << 2
            int r14 = r14 >> 18
            int r2 = r2 + -10
            goto L_0x016b
        L_0x0131:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            java.lang.String r2 = "Encountered error while checking VP8 signature"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            throw r0     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
        L_0x0139:
            byte[] r9 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r9 = java.util.Arrays.equals(r8, r9)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r9 == 0) goto L_0x0168
            byte r9 = r3.readByte()     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r9 != r15) goto L_0x0160
            int r9 = r3.readInt()     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r14 = r9 << 18
            int r14 = r14 >> 18
            int r14 = r14 + r11
            int r16 = r9 << 4
            int r16 = r16 >> 18
            int r11 = r16 + 1
            r16 = r9 & 8
            int r2 = r2 + -5
            r18 = r14
            r14 = r11
            r11 = r18
            goto L_0x016d
        L_0x0160:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            java.lang.String r2 = "Encountered error while checking VP8L signature"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            throw r0     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
        L_0x0168:
            r9 = 0
            r11 = 0
            r14 = 0
        L_0x016b:
            r16 = 0
        L_0x016d:
            byte[] r15 = WEBP_CHUNK_TYPE_VP8X     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.write(r15)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15 = 10
            r7.writeInt(r15)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r15 = new byte[r15]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte r17 = r15[r12]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r5 = r17 | 8
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r12] = r5     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte r5 = r15[r12]     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r17 = 4
            int r16 = r16 << 4
            r5 = r5 | r16
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r12] = r5     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r11 = r11 + -1
            int r14 = r14 + -1
            byte r5 = (byte) r11     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r17] = r5     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r5 = 5
            int r12 = r11 >> 8
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r5] = r12     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r5 = 6
            int r11 = r11 >> 16
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r5] = r11     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r5 = 7
            byte r11 = (byte) r14     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r5] = r11     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r5 = r14 >> 8
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r10] = r5     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r5 = 9
            int r10 = r14 >> 16
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r15[r5] = r10     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.write(r15)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.write(r8)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.writeInt(r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r0 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r0 == 0) goto L_0x01cb
            r7.write(r13)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r0 = WEBP_VP8_SIGNATURE     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.write(r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.writeInt(r9)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            goto L_0x01db
        L_0x01cb:
            byte[] r0 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            if (r0 == 0) goto L_0x01db
            r0 = 47
            r7.write(r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r7.writeInt(r9)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
        L_0x01db:
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r3, r7, r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
        L_0x01e1:
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r3, r7)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r0 = r6.size()     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r2 = WEBP_SIGNATURE_2     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r2 = r2.length     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            int r0 = r0 + r2
            r4.writeInt(r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            byte[] r0 = WEBP_SIGNATURE_2     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r4.write(r0)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            r6.writeTo(r4)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r6)
            return
        L_0x01fb:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            java.lang.String r2 = "Encountered invalid length while parsing WebP chunk type"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
            throw r0     // Catch:{ Exception -> 0x0206, all -> 0x0203 }
        L_0x0203:
            r0 = move-exception
            r2 = r6
            goto L_0x0214
        L_0x0206:
            r0 = move-exception
            r2 = r6
            goto L_0x020c
        L_0x0209:
            r0 = move-exception
            goto L_0x0214
        L_0x020b:
            r0 = move-exception
        L_0x020c:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0209 }
            java.lang.String r4 = "Failed to save WebP file"
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0209 }
            throw r3     // Catch:{ all -> 0x0209 }
        L_0x0214:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveWebpAttributes(java.io.InputStream, java.io.OutputStream):void");
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                sb.append(new String(bArr, ASCII));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, ASCII);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.writeInt(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    private void readExifSegment(byte[] bArr, int i) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, i);
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            if (DEBUG) {
                SystemUtils.log(3, TAG, "readExifSegment: Byte Align II", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6758);
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (DEBUG) {
                SystemUtils.log(3, TAG, "readExifSegment: Byte Align MM", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 6763);
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i = this.mMimeType;
        if (i == 7 || i == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt >= 8) {
                int i2 = readInt - 8;
                if (i2 > 0) {
                    byteOrderedDataInputStream.skipFully(i2);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r34, int r35) throws java.io.IOException {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            r2 = r35
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r4 = r1.mPosition
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r34.readShort()
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x0035
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "numberOfDirectoryEntry: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r8 = r4.toString()
            r6 = 3
            r9 = 0
            r11 = 6803(0x1a93, float:9.533E-42)
            java.lang.String r7 = "ExifInterface"
            java.lang.String r10 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
        L_0x0035:
            if (r3 > 0) goto L_0x0038
            return
        L_0x0038:
            r4 = 0
            r5 = 0
        L_0x003a:
            r6 = 5
            r9 = 1
            if (r5 >= r3) goto L_0x0388
            int r11 = r34.readUnsignedShort()
            int r12 = r34.readUnsignedShort()
            int r15 = r34.readInt()
            int r13 = r34.position()
            long r13 = (long) r13
            r16 = 4
            long r13 = r13 + r16
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r18 = sExifTagMapsForReading
            r7 = r18[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            java.lang.Object r7 = r7.get(r8)
            androidx.exifinterface.media.ExifInterface$ExifTag r7 = (androidx.exifinterface.media.ExifInterface.ExifTag) r7
            boolean r8 = DEBUG
            r10 = 3
            if (r8 == 0) goto L_0x009f
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r35)
            r6[r4] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            r6[r9] = r8
            if (r7 == 0) goto L_0x0079
            java.lang.String r8 = r7.name
            goto L_0x007a
        L_0x0079:
            r8 = 0
        L_0x007a:
            r19 = 2
            r6[r19] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r6[r10] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r15)
            r18 = 4
            r6[r18] = r8
            java.lang.String r8 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r22 = java.lang.String.format(r8, r6)
            r20 = 3
            r23 = 0
            r25 = 6822(0x1aa6, float:9.56E-42)
            java.lang.String r21 = "ExifInterface"
            java.lang.String r24 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r20, r21, r22, r23, r24, r25)
        L_0x009f:
            r6 = 7
            if (r7 != 0) goto L_0x00c8
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x00c4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Skip the tag entry since tag number is not defined: "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r23 = r8.toString()
            r21 = 3
            r24 = 0
            r26 = 6831(0x1aaf, float:9.572E-42)
            java.lang.String r22 = "ExifInterface"
            java.lang.String r25 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)
        L_0x00c4:
            r21 = r11
            goto L_0x016e
        L_0x00c8:
            if (r12 <= 0) goto L_0x014a
            int[] r8 = IFD_FORMAT_BYTES_PER_FORMAT
            int r8 = r8.length
            if (r12 < r8) goto L_0x00d1
            goto L_0x014a
        L_0x00d1:
            boolean r8 = r7.isFormatCompatible(r12)
            if (r8 != 0) goto L_0x0108
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x00c4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Skip the tag entry since data format ("
            r8.append(r9)
            java.lang.String[] r9 = IFD_FORMAT_NAMES
            r9 = r9[r12]
            r8.append(r9)
            java.lang.String r9 = ") is unexpected for tag: "
            r8.append(r9)
            java.lang.String r9 = r7.name
            r8.append(r9)
            java.lang.String r23 = r8.toString()
            r21 = 3
            r24 = 0
            r26 = 6839(0x1ab7, float:9.583E-42)
            java.lang.String r22 = "ExifInterface"
            java.lang.String r25 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)
            goto L_0x00c4
        L_0x0108:
            if (r12 != r6) goto L_0x010c
            int r12 = r7.primaryFormat
        L_0x010c:
            long r8 = (long) r15
            int[] r21 = IFD_FORMAT_BYTES_PER_FORMAT
            r4 = r21[r12]
            r21 = r11
            long r10 = (long) r4
            long r8 = r8 * r10
            r10 = 0
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x0126
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0124
            goto L_0x0126
        L_0x0124:
            r4 = 1
            goto L_0x0171
        L_0x0126:
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x0148
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = "Skip the tag entry since the number of components is invalid: "
            r4.append(r10)
            r4.append(r15)
            java.lang.String r26 = r4.toString()
            r24 = 3
            r27 = 0
            r29 = 6850(0x1ac2, float:9.599E-42)
            java.lang.String r25 = "ExifInterface"
            java.lang.String r28 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r24, r25, r26, r27, r28, r29)
        L_0x0148:
            r4 = 0
            goto L_0x0171
        L_0x014a:
            r21 = r11
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x016e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "Skip the tag entry since data format is invalid: "
            r4.append(r8)
            r4.append(r12)
            java.lang.String r26 = r4.toString()
            r24 = 3
            r27 = 0
            r29 = 6835(0x1ab3, float:9.578E-42)
            java.lang.String r25 = "ExifInterface"
            java.lang.String r28 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r24, r25, r26, r27, r28, r29)
        L_0x016e:
            r4 = 0
            r8 = 0
        L_0x0171:
            if (r4 != 0) goto L_0x017a
            r1.seek(r13)
            r24 = r3
            goto L_0x037e
        L_0x017a:
            java.lang.String r4 = "Compression"
            int r10 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x020a
            int r10 = r34.readInt()
            boolean r11 = DEBUG
            if (r11 == 0) goto L_0x01a6
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r6 = "seek to data offset: "
            r11.append(r6)
            r11.append(r10)
            java.lang.String r26 = r11.toString()
            r24 = 3
            r27 = 0
            r29 = 6867(0x1ad3, float:9.623E-42)
            java.lang.String r25 = "ExifInterface"
            java.lang.String r28 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r24, r25, r26, r27, r28, r29)
        L_0x01a6:
            int r6 = r0.mMimeType
            r11 = 7
            if (r6 != r11) goto L_0x0201
            java.lang.String r6 = r7.name
            java.lang.String r11 = "MakerNote"
            boolean r6 = r11.equals(r6)
            if (r6 == 0) goto L_0x01b8
            r0.mOrfMakerNoteOffset = r10
            goto L_0x0201
        L_0x01b8:
            r6 = 6
            if (r2 != r6) goto L_0x0201
            java.lang.String r11 = r7.name
            java.lang.String r6 = "ThumbnailImage"
            boolean r6 = r6.equals(r11)
            if (r6 == 0) goto L_0x0201
            r0.mOrfThumbnailOffset = r10
            r0.mOrfThumbnailLength = r15
            java.nio.ByteOrder r6 = r0.mExifByteOrder
            r11 = 6
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r11, (java.nio.ByteOrder) r6)
            int r11 = r0.mOrfThumbnailOffset
            r24 = r3
            long r2 = (long) r11
            java.nio.ByteOrder r11 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r2, (java.nio.ByteOrder) r11)
            int r3 = r0.mOrfThumbnailLength
            r16 = r13
            long r13 = (long) r3
            java.nio.ByteOrder r3 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r13, (java.nio.ByteOrder) r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r11 = r0.mAttributes
            r13 = 4
            r11 = r11[r13]
            r11.put(r4, r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r13]
            java.lang.String r11 = "JPEGInterchangeFormat"
            r6.put(r11, r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r13]
            java.lang.String r6 = "JPEGInterchangeFormatLength"
            r2.put(r6, r3)
            goto L_0x0205
        L_0x0201:
            r24 = r3
            r16 = r13
        L_0x0205:
            long r2 = (long) r10
            r1.seek(r2)
            goto L_0x020e
        L_0x020a:
            r24 = r3
            r16 = r13
        L_0x020e:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = sExifPointerTagMap
            java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0244
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "nextIfdType: "
            r3.append(r6)
            r3.append(r2)
            java.lang.String r6 = " byteCount: "
            r3.append(r6)
            r3.append(r8)
            java.lang.String r27 = r3.toString()
            r25 = 3
            r28 = 0
            r30 = 6899(0x1af3, float:9.668E-42)
            java.lang.String r26 = "ExifInterface"
            java.lang.String r29 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r25, r26, r27, r28, r29, r30)
        L_0x0244:
            r3 = 8
            if (r2 == 0) goto L_0x0306
            r8 = -1
            r4 = 3
            if (r12 == r4) goto L_0x026a
            r4 = 4
            if (r12 == r4) goto L_0x0265
            if (r12 == r3) goto L_0x0260
            r3 = 9
            if (r12 == r3) goto L_0x025b
            r3 = 13
            if (r12 == r3) goto L_0x025b
            goto L_0x026f
        L_0x025b:
            int r3 = r34.readInt()
            goto L_0x026e
        L_0x0260:
            short r3 = r34.readShort()
            goto L_0x026e
        L_0x0265:
            long r8 = r34.readUnsignedInt()
            goto L_0x026f
        L_0x026a:
            int r3 = r34.readUnsignedShort()
        L_0x026e:
            long r8 = (long) r3
        L_0x026f:
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0293
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            r6 = 0
            r3[r6] = r4
            java.lang.String r4 = r7.name
            r6 = 1
            r3[r6] = r4
            java.lang.String r4 = "Offset: %d, tagName: %s"
            java.lang.String r12 = java.lang.String.format(r4, r3)
            r10 = 3
            r13 = 0
            r15 = 6929(0x1b11, float:9.71E-42)
            java.lang.String r11 = "ExifInterface"
            java.lang.String r14 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
        L_0x0293:
            r3 = 0
            int r6 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x02df
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r4 = (int) r8
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x02b1
            r1.seek(r8)
            int r2 = r2.intValue()
            r0.readImageFileDirectory(r1, r2)
            goto L_0x02ff
        L_0x02b1:
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x02ff
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r8)
            java.lang.String r2 = ")"
            r3.append(r2)
            java.lang.String r8 = r3.toString()
            r6 = 3
            r9 = 0
            r11 = 6941(0x1b1d, float:9.726E-42)
            java.lang.String r7 = "ExifInterface"
            java.lang.String r10 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
            goto L_0x02ff
        L_0x02df:
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x02ff
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r12 = r2.toString()
            r10 = 3
            r13 = 0
            r15 = 6947(0x1b23, float:9.735E-42)
            java.lang.String r11 = "ExifInterface"
            java.lang.String r14 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
        L_0x02ff:
            r13 = r16
            r1.seek(r13)
            goto L_0x037e
        L_0x0306:
            r13 = r16
            int r2 = r34.position()
            int r6 = r0.mOffsetToExifData
            int r2 = r2 + r6
            int r6 = (int) r8
            byte[] r6 = new byte[r6]
            r1.readFully(r6)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            long r9 = (long) r2
            r31 = r13
            r13 = r8
            r14 = r12
            r16 = r9
            r18 = r6
            r13.<init>(r14, r15, r16, r18)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r35]
            java.lang.String r6 = r7.name
            r2.put(r6, r8)
            java.lang.String r2 = r7.name
            java.lang.String r6 = "DNGVersion"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x0339
            r2 = 3
            r0.mMimeType = r2
        L_0x0339:
            java.lang.String r2 = r7.name
            java.lang.String r6 = "Make"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L_0x034d
            java.lang.String r2 = r7.name
            java.lang.String r6 = "Model"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x035b
        L_0x034d:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            java.lang.String r2 = r8.getStringValue(r2)
            java.lang.String r6 = "PENTAX"
            boolean r2 = r2.contains(r6)
            if (r2 != 0) goto L_0x036e
        L_0x035b:
            java.lang.String r2 = r7.name
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0370
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            int r2 = r8.getIntValue(r2)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r4) goto L_0x0370
        L_0x036e:
            r0.mMimeType = r3
        L_0x0370:
            int r2 = r34.position()
            long r2 = (long) r2
            r13 = r31
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x037e
            r1.seek(r13)
        L_0x037e:
            int r5 = r5 + 1
            short r5 = (short) r5
            r2 = r35
            r3 = r24
            r4 = 0
            goto L_0x003a
        L_0x0388:
            int r2 = r34.readInt()
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x03ab
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "nextIfdOffset: %d"
            java.lang.String r9 = java.lang.String.format(r4, r3)
            r7 = 3
            r10 = 0
            r12 = 6987(0x1b4b, float:9.791E-42)
            java.lang.String r8 = "ExifInterface"
            java.lang.String r11 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
        L_0x03ab:
            long r3 = (long) r2
            r7 = 0
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x03ff
            java.util.Set<java.lang.Integer> r5 = r0.mAttributesOffsets
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            boolean r5 = r5.contains(r7)
            if (r5 != 0) goto L_0x03de
            r1.seek(r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03d0
            r0.readImageFileDirectory(r1, r3)
            goto L_0x041f
        L_0x03d0:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r6]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x041f
            r0.readImageFileDirectory(r1, r6)
            goto L_0x041f
        L_0x03de:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x041f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r6 = r1.toString()
            r4 = 3
            r7 = 0
            r9 = 7003(0x1b5b, float:9.813E-42)
            java.lang.String r5 = "ExifInterface"
            java.lang.String r8 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            goto L_0x041f
        L_0x03ff:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x041f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r6 = r1.toString()
            r4 = 3
            r7 = 0
            r9 = 7009(0x1b61, float:9.822E-42)
            java.lang.String r5 = "ExifInterface"
            java.lang.String r8 = "androidx.exifinterface.media.ExifInterface"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x041f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.readImageFileDirectory(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    private void retrieveJpegImageSize(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
            ExifAttribute exifAttribute4 = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute3.getIntValue(this.mExifByteOrder);
                seekableByteOrderedDataInputStream.seek((long) intValue);
                byte[] bArr = new byte[intValue2];
                seekableByteOrderedDataInputStream.read(bArr);
                getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue, i);
            }
        }
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue == 6) {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    return;
                } else if (intValue != 7) {
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (this.mMimeType == 7) {
                intValue += this.mOrfMakerNoteOffset;
            }
            if (intValue > 0 && intValue2 > 0) {
                this.mHasThumbnail = true;
                if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                    byte[] bArr = new byte[intValue2];
                    byteOrderedDataInputStream.skip((long) intValue);
                    byteOrderedDataInputStream.read(bArr);
                    this.mThumbnailBytes = bArr;
                }
                this.mThumbnailOffset = intValue;
                this.mThumbnailLength = intValue2;
            }
            if (DEBUG) {
                SystemUtils.log(3, TAG, "Setting thumbnail attributes with offset: " + intValue + ", length: " + intValue2, (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7113);
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = byteOrderedDataInputStream;
        HashMap hashMap2 = hashMap;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap2.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap2.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] convertToLongArray = ExifInterfaceUtils.convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
            long[] convertToLongArray2 = ExifInterfaceUtils.convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
            if (convertToLongArray == null || convertToLongArray.length == 0) {
                SystemUtils.log(5, TAG, "stripOffsets should not be null or have zero length.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7134);
            } else if (convertToLongArray2 == null || convertToLongArray2.length == 0) {
                SystemUtils.log(5, TAG, "stripByteCounts should not be null or have zero length.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7138);
            } else if (convertToLongArray.length != convertToLongArray2.length) {
                SystemUtils.log(5, TAG, "stripOffsets and stripByteCounts should have same length.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7142);
            } else {
                long j = 0;
                for (long j2 : convertToLongArray2) {
                    j += j2;
                }
                int i = (int) j;
                byte[] bArr = new byte[i];
                int i2 = 1;
                this.mAreThumbnailStripsConsecutive = true;
                this.mHasThumbnailStrips = true;
                this.mHasThumbnail = true;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < convertToLongArray.length) {
                    int i6 = (int) convertToLongArray[i3];
                    int i7 = (int) convertToLongArray2[i3];
                    if (i3 < convertToLongArray.length - i2 && ((long) (i6 + i7)) != convertToLongArray[i3 + 1]) {
                        this.mAreThumbnailStripsConsecutive = false;
                    }
                    int i8 = i6 - i4;
                    if (i8 < 0) {
                        SystemUtils.log(3, TAG, "Invalid strip offset value", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7172);
                        return;
                    }
                    long j3 = (long) i8;
                    if (byteOrderedDataInputStream2.skip(j3) != j3) {
                        SystemUtils.log(3, TAG, "Failed to skip " + i8 + " bytes.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7176);
                        return;
                    }
                    int i9 = i4 + i8;
                    byte[] bArr2 = new byte[i7];
                    if (byteOrderedDataInputStream2.read(bArr2) != i7) {
                        SystemUtils.log(3, TAG, "Failed to read " + i7 + " bytes.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7183);
                        return;
                    }
                    i4 = i9 + i7;
                    System.arraycopy(bArr2, 0, bArr, i5, i7);
                    i5 += i7;
                    i3++;
                    i2 = 1;
                }
                this.mThumbnailBytes = bArr;
                if (this.mAreThumbnailStripsConsecutive) {
                    this.mThumbnailOffset = (int) convertToLongArray[0];
                    this.mThumbnailLength = i;
                }
            }
        }
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int intValue;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
            if (Arrays.equals(BITS_PER_SAMPLE_RGB, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, BITS_PER_SAMPLE_RGB)))) {
                return true;
            }
        }
        if (!DEBUG) {
            return false;
        }
        SystemUtils.log(3, TAG, "Unsupported data type value", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7232);
        return false;
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private void validateImages() throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            SystemUtils.log(3, TAG, "No image meets the size requirements of a thumbnail image.", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7284);
        }
        replaceInvalidTags(0, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(4, TAG_ORIENTATION, TAG_THUMBNAIL_ORIENTATION);
        replaceInvalidTags(4, TAG_IMAGE_LENGTH, TAG_THUMBNAIL_IMAGE_LENGTH);
        replaceInvalidTags(4, TAG_IMAGE_WIDTH, TAG_THUMBNAIL_IMAGE_WIDTH);
    }

    private void updateImageSizeValues(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute4 = this.mAttributes[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute5 = this.mAttributes[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute6 = this.mAttributes[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute7 = this.mAttributes[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute3 != null) {
            if (exifAttribute3.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    SystemUtils.log(5, TAG, "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7331);
                    return;
                }
                exifAttribute2 = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
            } else {
                int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    SystemUtils.log(5, TAG, "Invalid crop size values. cropSize=" + Arrays.toString(iArr), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7343);
                    return;
                }
                exifAttribute2 = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            this.mAttributes[i].put(TAG_IMAGE_WIDTH, exifAttribute2);
            this.mAttributes[i].put(TAG_IMAGE_LENGTH, exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            retrieveJpegImageSize(seekableByteOrderedDataInputStream, i);
        } else {
            int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute6.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute7.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute5.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[i].put(TAG_IMAGE_WIDTH, createUShort2);
            }
        }
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = byteOrderedDataOutputStream;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                removeAttribute(TAG_STRIP_OFFSETS);
                removeAttribute(TAG_STRIP_BYTE_COUNTS);
            } else {
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT);
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            }
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            for (Object obj : this.mAttributes[i].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_STRIP_BYTE_COUNTS, ExifAttribute.createUShort(this.mThumbnailLength, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifAttribute.createULong((long) this.mThumbnailLength, this.mExifByteOrder));
            }
        }
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            int i3 = 0;
            for (Map.Entry<String, ExifAttribute> value : this.mAttributes[i2].entrySet()) {
                int size = ((ExifAttribute) value.getValue()).size();
                if (size > 4) {
                    i3 += size;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int i4 = 8;
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            if (!this.mAttributes[i5].isEmpty()) {
                iArr[i5] = i4;
                i4 += (this.mAttributes[i5].size() * 12) + 2 + 4 + iArr2[i5];
            }
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(i4, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong((long) i4, this.mExifByteOrder));
            }
            this.mThumbnailOffset = i4;
            i4 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            i4 += 8;
        }
        if (DEBUG) {
            for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
                SystemUtils.log(3, TAG, String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i6), Integer.valueOf(iArr[i6]), Integer.valueOf(this.mAttributes[i6].size()), Integer.valueOf(iArr2[i6]), Integer.valueOf(i4)}), (Throwable) null, "androidx.exifinterface.media.ExifInterface", 7479);
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long) iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long) iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long) iArr[3], this.mExifByteOrder));
        }
        int i7 = this.mMimeType;
        if (i7 == 4) {
            byteOrderedDataOutputStream2.writeUnsignedShort(i4);
            byteOrderedDataOutputStream2.write(IDENTIFIER_EXIF_APP1);
        } else if (i7 == 13) {
            byteOrderedDataOutputStream2.writeInt(i4);
            byteOrderedDataOutputStream2.write(PNG_CHUNK_TYPE_EXIF);
        } else if (i7 == 14) {
            byteOrderedDataOutputStream2.write(WEBP_CHUNK_TYPE_EXIF);
            byteOrderedDataOutputStream2.writeInt(i4);
        }
        byteOrderedDataOutputStream2.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        byteOrderedDataOutputStream2.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream2.writeUnsignedShort(42);
        byteOrderedDataOutputStream2.writeUnsignedInt(8);
        for (int i8 = 0; i8 < EXIF_TAGS.length; i8++) {
            if (!this.mAttributes[i8].isEmpty()) {
                byteOrderedDataOutputStream2.writeUnsignedShort(this.mAttributes[i8].size());
                int size2 = iArr[i8] + 2 + (this.mAttributes[i8].size() * 12) + 4;
                for (Map.Entry next : this.mAttributes[i8].entrySet()) {
                    int i9 = sExifTagMapsForWriting[i8].get(next.getKey()).number;
                    ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                    int size3 = exifAttribute.size();
                    byteOrderedDataOutputStream2.writeUnsignedShort(i9);
                    byteOrderedDataOutputStream2.writeUnsignedShort(exifAttribute.format);
                    byteOrderedDataOutputStream2.writeInt(exifAttribute.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream2.writeUnsignedInt((long) size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream2.write(exifAttribute.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream2.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i8 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream2.writeUnsignedInt(0);
                } else {
                    byteOrderedDataOutputStream2.writeUnsignedInt((long) iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> value2 : this.mAttributes[i8].entrySet()) {
                    ExifAttribute exifAttribute2 = (ExifAttribute) value2.getValue();
                    if (exifAttribute2.bytes.length > 4) {
                        byteOrderedDataOutputStream2.write(exifAttribute2.bytes, 0, exifAttribute2.bytes.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream2.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && i4 % 2 == 1) {
            byteOrderedDataOutputStream2.writeByte(0);
        }
        byteOrderedDataOutputStream2.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i4;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r12) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r12.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r12 = r12.split(r0, r6)
            r0 = r12[r2]
            android.util.Pair r0 = guessDataFormat(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r12.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r12[r3]
            android.util.Pair r1 = guessDataFormat(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = -1
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = -1
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r12.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r12 = r12.split(r0, r6)
            int r0 = r12.length
            if (r0 != r4) goto L_0x00ff
            r0 = r12[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = r12[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = 10
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x00f5
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r4 = 5
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x00eb
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r0.<init>(r12, r1)     // Catch:{ NumberFormatException -> 0x00ff }
            return r0
        L_0x00eb:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00f5:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            r0.<init>(r12, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r0
        L_0x00ff:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014e }
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r3 = 4
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0130
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r10 = 65535(0xffff, double:3.23786E-319)
            int r4 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r4 > 0) goto L_0x0130
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0130:
            long r0 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0144
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0144:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x014e:
            java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x015d }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x015d }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x015d }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x015d }
            return r12
        L_0x015d:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.guessDataFormat(java.lang.String):android.util.Pair");
    }

    private static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
            super(bArr);
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }

        SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.mDataInputStream.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }

        public void seek(long j) throws IOException {
            if (((long) this.mPosition) > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
            } else {
                j -= (long) this.mPosition;
            }
            skipFully((int) j);
        }
    }

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private ByteOrder mByteOrder;
        final DataInputStream mDataInputStream;
        int mPosition;
        private byte[] mSkipBuffer;

        ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            dataInputStream.mark(0);
            this.mPosition = 0;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public int position() {
            return this.mPosition;
        }

        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public String readLine() throws IOException {
            SystemUtils.log(3, ExifInterface.TAG, "Currently unsupported", (Throwable) null, "androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream", 7777);
            return null;
        }

        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.mPosition += i2;
            this.mDataInputStream.readFully(bArr, i, i2);
        }

        public void readFully(byte[] bArr) throws IOException {
            this.mPosition += bArr.length;
            this.mDataInputStream.readFully(bArr);
        }

        public byte readByte() throws IOException {
            this.mPosition++;
            int read = this.mDataInputStream.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.mPosition += 2;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public int readInt() throws IOException {
            this.mPosition += 4;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public int skipBytes(int i) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public void skipFully(int i) throws IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int skip = (int) this.mDataInputStream.skip((long) i3);
                if (skip <= 0) {
                    if (this.mSkipBuffer == null) {
                        this.mSkipBuffer = new byte[8192];
                    }
                    skip = this.mDataInputStream.read(this.mSkipBuffer, 0, Math.min(8192, i3));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i + " bytes.");
                    }
                }
                i2 += skip;
            }
            this.mPosition += i2;
        }

        public int readUnsignedShort() throws IOException {
            this.mPosition += 2;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }

        public long readLong() throws IOException {
            this.mPosition += 8;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            int read5 = this.mDataInputStream.read();
            int read6 = this.mDataInputStream.read();
            int read7 = this.mDataInputStream.read();
            int read8 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i = read2;
                if (byteOrder == BIG_ENDIAN) {
                    return (((long) read) << 56) + (((long) i) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }
    }

    private static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        public void writeByte(int i) throws IOException {
            this.mOutputStream.write(i);
        }

        public void writeShort(short s) throws IOException {
            if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((s >>> 0) & 255);
                this.mOutputStream.write((s >>> 8) & 255);
            } else if (this.mByteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s >>> 8) & 255);
                this.mOutputStream.write((s >>> 0) & 255);
            }
        }

        public void writeInt(int i) throws IOException {
            if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((i >>> 0) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 24) & 255);
            } else if (this.mByteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i >>> 24) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 0) & 255);
            }
        }

        public void writeUnsignedShort(int i) throws IOException {
            writeShort((short) i);
        }

        public void writeUnsignedInt(long j) throws IOException {
            writeInt((int) j);
        }
    }

    private void swapBasedOnImageSize(int i, int i2) throws IOException {
        if (!this.mAttributes[i].isEmpty() && !this.mAttributes[i2].isEmpty()) {
            ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
            ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute4 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
            if (exifAttribute == null || exifAttribute2 == null) {
                if (DEBUG) {
                    SystemUtils.log(3, TAG, "First image does not contain valid size information", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 8034);
                }
            } else if (exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                if (intValue < intValue3 && intValue2 < intValue4) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i2];
                    hashMapArr[i2] = hashMap;
                }
            } else if (DEBUG) {
                SystemUtils.log(3, TAG, "Second image does not contain valid size information", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 8038);
            }
        } else if (DEBUG) {
            SystemUtils.log(3, TAG, "Cannot perform swap since only one image data exists", (Throwable) null, "androidx.exifinterface.media.ExifInterface", 8018);
        }
    }

    private void replaceInvalidTags(int i, String str, String str2) {
        if (!this.mAttributes[i].isEmpty() && this.mAttributes[i].get(str) != null) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[i].put(str2, hashMapArr[i].get(str));
            this.mAttributes[i].remove(str);
        }
    }
}
