package com.didi.zxing.barcodescanner;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinarizerEnum;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.util.DecodeConfigUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class DefaultDecoderFactory implements DecoderFactory {

    /* renamed from: a */
    private Collection<BarcodeFormat> f47942a;

    /* renamed from: b */
    private Map<DecodeHintType, Object> f47943b;

    /* renamed from: c */
    private String f47944c;

    /* renamed from: d */
    private boolean f47945d;

    public DefaultDecoderFactory() {
        this("");
    }

    public DefaultDecoderFactory(String str) {
        this.f47944c = "utf-8";
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        this.f47943b = enumMap;
        enumMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        ArrayList arrayList = new ArrayList();
        this.f47942a = arrayList;
        arrayList.add(BarcodeFormat.QR_CODE);
        C15738Util.addExtraBarcodeFormats(str, this.f47942a);
    }

    public DefaultDecoderFactory(Collection<BarcodeFormat> collection, Map<DecodeHintType, Object> map, String str, boolean z) {
        this.f47942a = collection;
        this.f47943b = map;
        this.f47944c = str;
        this.f47945d = z;
    }

    public Decoder createDecoder(Map<DecodeHintType, ?> map) {
        int binarizerType;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map<DecodeHintType, Object> map2 = this.f47943b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        if (this.f47942a != null) {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, this.f47942a);
        } else {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, new ArrayList());
        }
        if (this.f47944c != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, this.f47944c);
        }
        DecodeOptions decodeOptions = new DecodeOptions();
        DecodeConfig config = DecodeConfigUtil.getConfig();
        decodeOptions.binarizer = BinarizerEnum.CommixtureWithOpenCV;
        if (config != null && (binarizerType = config.binarizerType()) > -1 && binarizerType < BinarizerEnum.values().length) {
            decodeOptions.binarizer = BinarizerEnum.values()[binarizerType];
        }
        decodeOptions.baseHints = enumMap;
        decodeOptions.decodeFormats = this.f47942a;
        return new Decoder(decodeOptions, this.f47945d);
    }

    public void setDecodeFormats(Collection<BarcodeFormat> collection) {
        this.f47942a = collection;
    }
}
