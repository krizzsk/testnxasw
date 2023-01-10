package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Rect;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.bubble.BlockBubbleBitmapLoader;
import com.didi.map.base.bubble.BlockBubbleBitmapOpt;
import com.didi.map.base.bubble.BlockBubbleSetting;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.core.element.ClickBlockBubbleParam;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerOptions;
import java.util.ArrayList;

public class BlockBubbleManager {

    /* renamed from: a */
    private static final String f26719a = "BlockBubbleManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LableMarkerManager_v3 f26720b;

    /* renamed from: c */
    private final BubbleManager f26721c;

    /* renamed from: d */
    private final BlockLableBubble f26722d;

    /* renamed from: e */
    private Bubble f26723e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BlockBubbleSetting f26724f = null;

    /* renamed from: a */
    private boolean m21159a(int i) {
        return i == 0 || i == 3 || i == 4 || i == 5;
    }

    public BlockBubbleManager(LableMarkerManager_v3 lableMarkerManager_v3, BlockLableBubble blockLableBubble) {
        this.f26720b = lableMarkerManager_v3;
        this.f26721c = lableMarkerManager_v3.getBubbleManager();
        this.f26722d = blockLableBubble;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77549a(BlockBubbleSetting blockBubbleSetting) {
        m21161c(blockBubbleSetting);
    }

    /* renamed from: c */
    private void m21161c(BlockBubbleSetting blockBubbleSetting) {
        this.f26724f = blockBubbleSetting;
        TextLableOnRoute textLableOnRoute = blockBubbleSetting.textLableOnRoute;
        Bubble.PointArea pointArea = blockBubbleSetting.pointArea;
        int i = blockBubbleSetting.trafficSectionType;
        mo77548a();
        LatLng e = m21163e(blockBubbleSetting);
        HWLog.m20433i(f26719a, "addBlockBubble latLng = " + e);
        Bubble bubble = new Bubble(new MarkerOptions(e));
        bubble.position(e);
        bubble.setzIndex(i == 1 ? 17 : 15);
        if (i == 1) {
            bubble.setNeedSelectBottomRect(true);
        }
        if (ApolloHawaii.USE_NEW_BLOCK_BUBBLE) {
            bubble.setType(8192);
            bubble.setCollisionType(BubbleManager.getCollisionType(8192));
        } else {
            bubble.setType(16);
            bubble.setCollisionType(BubbleManager.getCollisionType(16));
        }
        bubble.setPriority(400);
        bubble.setInnerType(textLableOnRoute.type);
        m21158a(bubble, blockBubbleSetting);
        if (m21159a(i) && pointArea != null) {
            bubble.setPointArea(pointArea);
        }
        this.f26721c.addBubble(bubble);
        if (i != 0) {
            m21157a(bubble);
        }
        boolean z = this.f26720b.bubblesSwitch.congestRoadBubbleVisible;
        bubble.setVisible(z);
        HWLog.m20433i(f26719a, "addBlockRouteBubble = " + bubble.getId() + ", currentBlockBubbleType = " + this.f26724f.trafficSectionType + ", visible = " + z);
        this.f26723e = bubble;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo77551b(BlockBubbleSetting blockBubbleSetting) {
        m21162d(blockBubbleSetting);
    }

    /* renamed from: d */
    private void m21162d(BlockBubbleSetting blockBubbleSetting) {
        if (this.f26723e == null || this.f26724f == null) {
            HWLog.m20433i(f26719a, "cacheBlockBubble == null || currentBlockBubbleSetting == null");
        } else if (blockBubbleSetting.trafficSectionType != this.f26724f.trafficSectionType) {
            HWLog.m20433i(f26719a, "refresh bubble , because blockBubbleSetting is different.");
            mo77549a(blockBubbleSetting);
        } else {
            this.f26724f = blockBubbleSetting;
            int i = blockBubbleSetting.trafficSectionType;
            Bubble bubble = this.f26723e;
            HWLog.m20433i(f26719a, "updateBlockBubbleInternal  visible = " + this.f26720b.bubblesSwitch.congestRoadBubbleVisible);
            if (m21159a(blockBubbleSetting.trafficSectionType) && blockBubbleSetting.pointArea != null) {
                bubble.setPointArea(blockBubbleSetting.pointArea);
            }
            if (i == 1) {
                LatLng e = m21163e(blockBubbleSetting);
                bubble.position(e);
                HWLog.m20433i("updateBlockBubble", "latLng = " + e);
            }
            m21158a(bubble, blockBubbleSetting);
            this.f26721c.updateBubble(bubble);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77548a() {
        Bubble bubble = this.f26723e;
        if (bubble != null) {
            this.f26721c.removeBubble(bubble.getId());
            this.f26723e = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77550a(boolean z) {
        Bubble bubble = this.f26723e;
        if (bubble != null && bubble.isVisible() != z) {
            this.f26723e.setVisible(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo77552b() {
        return this.f26723e != null;
    }

    /* renamed from: e */
    private LatLng m21163e(BlockBubbleSetting blockBubbleSetting) {
        TextLableOnRoute textLableOnRoute = blockBubbleSetting.textLableOnRoute;
        if (blockBubbleSetting.trafficSectionType != 1) {
            return new LatLng(textLableOnRoute.position.f27005y, textLableOnRoute.position.f27004x);
        }
        if (blockBubbleSetting.mapTrafficIcon == null || blockBubbleSetting.mapTrafficIcon.getLatLng() == null) {
            return new LatLng(textLableOnRoute.position.f27005y, textLableOnRoute.position.f27004x);
        }
        return blockBubbleSetting.mapTrafficIcon.getLatLng();
    }

    /* renamed from: a */
    private void m21158a(Bubble bubble, BlockBubbleSetting blockBubbleSetting) {
        TextLableOnRoute textLableOnRoute = blockBubbleSetting.textLableOnRoute;
        int i = blockBubbleSetting.trafficSectionType;
        Context context = this.f26720b.context;
        String str = textLableOnRoute.name.split(";")[0];
        bubble.setShowInfo(str + System.currentTimeMillis());
        String markerFileName = this.f26722d.getMarkerFileName(this.f26720b.isNight, str, 1, i);
        LableMarkerManager.BlockBubbleParams blockBubbleParams = new LableMarkerManager.BlockBubbleParams();
        blockBubbleParams.blockBubbleType = i;
        blockBubbleParams.fileName = markerFileName;
        blockBubbleParams.text = str;
        if (i == 5 && blockBubbleSetting.blockBubbleParam != null && blockBubbleSetting.blockBubbleParam.thumbUrl.size() > 0) {
            blockBubbleParams.thumbUrl = blockBubbleSetting.blockBubbleParam.thumbUrl.get(0);
        }
        int[] bitmapWh = this.f26722d.getBitmapWh(context, 0, blockBubbleParams);
        int i2 = bitmapWh[0];
        int i3 = bitmapWh[1];
        bubble.clearOverlayRect();
        Bubble bubble2 = bubble;
        int i4 = i2;
        int i5 = i3;
        LableMarkerManager.BlockBubbleParams blockBubbleParams2 = blockBubbleParams;
        bubble.addOverlayRect(m21156a(bubble2, i4, i5, 1, blockBubbleParams2));
        bubble.addOverlayRect(m21156a(bubble2, i4, i5, 2, blockBubbleParams2));
        if (blockBubbleParams.blockBubbleType == 1) {
            Bubble bubble3 = bubble;
            int i6 = i2;
            int i7 = i3;
            LableMarkerManager.BlockBubbleParams blockBubbleParams3 = blockBubbleParams;
            bubble.addOverlayRect(m21156a(bubble3, i6, i7, 3, blockBubbleParams3));
            bubble.addOverlayRect(m21156a(bubble3, i6, i7, 4, blockBubbleParams3));
        }
    }

    /* renamed from: a */
    private Bubble.OverlayRect m21156a(Bubble bubble, int i, int i2, int i3, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        float f;
        float f2;
        float f3;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        LableMarkerManager.BlockBubbleParams blockBubbleParams2 = blockBubbleParams;
        boolean z = this.f26720b.isNight;
        Context context = this.f26720b.context;
        String str = blockBubbleParams2.text;
        int i7 = blockBubbleParams2.blockBubbleType;
        Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
        BlockBubbleBitmapOpt blockBubbleBitmapOpt = new BlockBubbleBitmapOpt(BlockBubbleBitmapLoader.TAG, bubble.getId(), str);
        blockBubbleBitmapOpt.setBlockBubbleType(i7);
        String markerFileName = this.f26722d.getMarkerFileName(z, str, i6, i7);
        if (markerFileName.isEmpty()) {
            return null;
        }
        blockBubbleBitmapOpt.setNight(z);
        ArrayList arrayList = new ArrayList();
        arrayList.add(markerFileName);
        blockBubbleBitmapOpt.setFileNams(arrayList);
        if (i7 == 5) {
            blockBubbleBitmapOpt.thumbUrl = blockBubbleParams2.thumbUrl;
        }
        int dip2px = DisplayUtils.dip2px(context, 15.0f);
        float f4 = 1.0f;
        if (i6 == 1) {
            f3 = 0.0f;
            if (i7 == 0) {
                f4 = 1.0f - (13.0f / ((float) i5));
            } else if (i7 == 5) {
                f4 = 1.0f - (20.0f / ((float) i5));
                f3 = 25.0f / ((float) i4);
            }
            overlayRect.paddingCollision = new Rect(dip2px, 0, 0, dip2px);
        } else {
            if (i6 == 2) {
                if (i7 == 0) {
                    f2 = 1.0f - (13.0f / ((float) i5));
                } else if (i7 == 5) {
                    f4 = 1.0f - (25.0f / ((float) i4));
                    f2 = 1.0f - (20.0f / ((float) i5));
                } else {
                    f2 = 1.0f;
                }
                overlayRect.paddingCollision = new Rect(0, 0, dip2px, dip2px);
                f = f4;
            } else if (i6 == 3) {
                if (i7 != 1) {
                    return null;
                }
                f3 = 15.0f / ((float) i4);
                f4 = 15.0f / ((float) i5);
                overlayRect.paddingCollision = new Rect(dip2px, dip2px, 0, 0);
            } else if (i6 != 4) {
                f2 = 1.0f;
                f = 0.5f;
            } else if (i7 != 1) {
                return null;
            } else {
                f3 = 1.0f - (15.0f / ((float) i4));
                f4 = 15.0f / ((float) i5);
                overlayRect.paddingCollision = new Rect(0, dip2px, dip2px, 0);
            }
            overlayRect.anchorX = f;
            overlayRect.anchorY = f2;
            overlayRect.width = i4;
            overlayRect.height = i5;
            overlayRect.resourcePaths = blockBubbleBitmapOpt;
            return overlayRect;
        }
        f = f3;
        f2 = f4;
        overlayRect.anchorX = f;
        overlayRect.anchorY = f2;
        overlayRect.width = i4;
        overlayRect.height = i5;
        overlayRect.resourcePaths = blockBubbleBitmapOpt;
        return overlayRect;
    }

    /* renamed from: a */
    private void m21157a(Bubble bubble) {
        bubble.setOnClickListener(new DidiMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                DidiMap didiMap = BlockBubbleManager.this.f26720b.didiMap;
                if (!(didiMap == null || BlockBubbleManager.this.f26724f == null)) {
                    int i = BlockBubbleManager.this.f26724f.trafficSectionType;
                    OnMapElementClickListener mapElementClickListener = ((DidiMapExt) didiMap).getMapElementClickListener();
                    if (mapElementClickListener != null) {
                        if (i == 5) {
                            ClickBlockBubbleParam clickBlockBubbleParam = BlockBubbleManager.this.f26724f.blockBubbleParam;
                            if (clickBlockBubbleParam == null) {
                                HWLog.m20433i(BlockBubbleManager.f26719a, "click blockBubbleParam == null");
                                return true;
                            }
                            mapElementClickListener.onClickBubble(clickBlockBubbleParam);
                        } else {
                            MapTrafficIcon mapTrafficIcon = BlockBubbleManager.this.f26724f.mapTrafficIcon;
                            if (mapTrafficIcon == null) {
                                HWLog.m20433i(BlockBubbleManager.f26719a, "click trafficIcon == null");
                                return true;
                            }
                            mapTrafficIcon.setBlockType(1);
                            mapTrafficIcon.setBlockBubbleStatus(i);
                            mapTrafficIcon.setFromBubble(true);
                            mapElementClickListener.onTrafficIconClick(mapTrafficIcon);
                        }
                    }
                }
                return true;
            }
        });
    }
}
