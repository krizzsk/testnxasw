package com.google.maps.android.data.kml;

import com.didi.dimina.container.p065ui.custom.SameLayerRenderingUtil;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import rui.config.RConfigConstants;

class KmlStyleParser {
    private static final String COLOR_STYLE_COLOR = "color";
    private static final String COLOR_STYLE_MODE = "colorMode";
    private static final String ICON_STYLE_HEADING = "heading";
    private static final String ICON_STYLE_HOTSPOT = "hotSpot";
    private static final String ICON_STYLE_SCALE = "scale";
    private static final String ICON_STYLE_URL = "Icon";
    private static final String LINE_STYLE_WIDTH = "width";
    private static final String POLY_STYLE_FILL = "fill";
    private static final String POLY_STYLE_OUTLINE = "outline";
    private static final String STYLE_MAP_KEY = "key";
    private static final String STYLE_MAP_NORMAL_STYLE = "normal";
    private static final String STYLE_TAG = "styleUrl";

    KmlStyleParser() {
    }

    static KmlStyle createStyle(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        KmlStyle kmlStyle = new KmlStyle();
        setStyleId(xmlPullParser.getAttributeValue((String) null, "id"), kmlStyle);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Style")) {
                return kmlStyle;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("IconStyle")) {
                    createIconStyle(xmlPullParser, kmlStyle);
                } else if (xmlPullParser.getName().equals("LineStyle")) {
                    createLineStyle(xmlPullParser, kmlStyle);
                } else if (xmlPullParser.getName().equals("PolyStyle")) {
                    createPolyStyle(xmlPullParser, kmlStyle);
                } else if (xmlPullParser.getName().equals("BalloonStyle")) {
                    createBalloonStyle(xmlPullParser, kmlStyle);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static void setStyleId(String str, KmlStyle kmlStyle) {
        if (str != null) {
            kmlStyle.setStyleId(RConfigConstants.KEYWORD_COLOR_SIGN + str);
        }
    }

    private static void createIconStyle(XmlPullParser xmlPullParser, KmlStyle kmlStyle) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("IconStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals(ICON_STYLE_HEADING)) {
                        kmlStyle.setHeading(Float.parseFloat(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals(ICON_STYLE_URL)) {
                        setIconUrl(xmlPullParser, kmlStyle);
                    } else if (xmlPullParser.getName().equals(ICON_STYLE_HOTSPOT)) {
                        setIconHotSpot(xmlPullParser, kmlStyle);
                    } else if (xmlPullParser.getName().equals("scale")) {
                        kmlStyle.setIconScale(Double.parseDouble(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("color")) {
                        kmlStyle.setMarkerColor(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals(COLOR_STYLE_MODE)) {
                        kmlStyle.setIconColorMode(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    static HashMap<String, String> createStyleMap(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = RConfigConstants.KEYWORD_COLOR_SIGN + xmlPullParser.getAttributeValue((String) null, "id");
        int eventType = xmlPullParser.getEventType();
        boolean z = false;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("StyleMap")) {
                return hashMap;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("key") && xmlPullParser.nextText().equals("normal")) {
                    z = true;
                } else if (xmlPullParser.getName().equals(STYLE_TAG) && z) {
                    hashMap.put(str, xmlPullParser.nextText());
                    z = false;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static void createBalloonStyle(XmlPullParser xmlPullParser, KmlStyle kmlStyle) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("BalloonStyle")) {
                if (eventType == 2 && xmlPullParser.getName().equals("text")) {
                    kmlStyle.setInfoWindowText(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    private static void setIconUrl(XmlPullParser xmlPullParser, KmlStyle kmlStyle) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals(ICON_STYLE_URL)) {
                if (eventType == 2 && xmlPullParser.getName().equals(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                    kmlStyle.setIconUrl(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    private static void setIconHotSpot(XmlPullParser xmlPullParser, KmlStyle kmlStyle) throws XmlPullParserException {
        if (!xmlPullParser.isEmptyElementTag()) {
            kmlStyle.setHotSpot(Float.parseFloat(xmlPullParser.getAttributeValue((String) null, "x")), Float.parseFloat(xmlPullParser.getAttributeValue((String) null, SameLayerRenderingUtil.KEY_COMP_Y)), xmlPullParser.getAttributeValue((String) null, "xunits"), xmlPullParser.getAttributeValue((String) null, "yunits"));
        }
    }

    private static void createLineStyle(XmlPullParser xmlPullParser, KmlStyle kmlStyle) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("LineStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("color")) {
                        kmlStyle.setOutlineColor(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("width")) {
                        kmlStyle.setWidth(Float.valueOf(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals(COLOR_STYLE_MODE)) {
                        kmlStyle.setLineColorMode(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    private static void createPolyStyle(XmlPullParser xmlPullParser, KmlStyle kmlStyle) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("PolyStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("color")) {
                        kmlStyle.setFillColor(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals(POLY_STYLE_OUTLINE)) {
                        kmlStyle.setOutline(KmlBoolean.parseBoolean(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals(POLY_STYLE_FILL)) {
                        kmlStyle.setFill(KmlBoolean.parseBoolean(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals(COLOR_STYLE_MODE)) {
                        kmlStyle.setPolyColorMode(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }
}
