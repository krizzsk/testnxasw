package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.MarkerGroupControl;
import java.util.List;

public class MarkerGroup {

    /* renamed from: a */
    private String f30427a = "";

    /* renamed from: b */
    private MarkerGroupControl f30428b;

    public MarkerGroup(MarkerGroupControl markerGroupControl, String str) {
        this.f30428b = markerGroupControl;
        this.f30427a = str;
    }

    public String getId() {
        return this.f30427a;
    }

    public void addMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            markerGroupControl.addMarkerById(this.f30427a, str);
        }
    }

    public void addMarker(Marker marker) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            markerGroupControl.addMarker(this.f30427a, marker);
        }
    }

    public void addMarkerList(List<Marker> list) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            markerGroupControl.addMarkerList(this.f30427a, list);
        }
    }

    public boolean removeMarker(Marker marker) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.removeMarker(this.f30427a, marker);
        }
        return false;
    }

    public boolean removeMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.removeMarkerById(this.f30427a, str);
        }
        return false;
    }

    public void clear() {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            markerGroupControl.clear(this.f30427a);
        }
    }

    public Marker findMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.findMarkerById(this.f30427a, str);
        }
        return null;
    }

    public List<Marker> getMarkerList() {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.getMarkerList(this.f30427a);
        }
        return null;
    }

    public List<String> getMarkerIdList() {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.getMarkerIdList(this.f30427a);
        }
        return null;
    }

    public boolean containMarker(Marker marker) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.containMarker(this.f30427a, marker);
        }
        return false;
    }

    public boolean containMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.containMarkerById(this.f30427a, str);
        }
        return false;
    }

    public boolean updateMarkerOptionById(String str, MarkerOptions markerOptions) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.updateMarkerOptionById(this.f30427a, str, markerOptions);
        }
        return false;
    }

    public void setMarkerGroupOnTapMapInfoWindowHidden(boolean z) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            markerGroupControl.setMarkerGroupOnTapMapInfoWindowHidden(this.f30427a, z);
        }
    }

    public void setMarkerGroupOnTapMapBubblesHidden(boolean z) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            markerGroupControl.setMarkerGroupOnTapMapBubblesHidden(this.f30427a, z);
        }
    }

    public boolean setMarkerOnTapMapBubblesHidden(Marker marker, boolean z) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.setMarkerOnTapMapBubblesHidden(this.f30427a, marker, z);
        }
        return false;
    }

    public boolean setOnTapMapBubblesHiddenById(String str, boolean z) {
        MarkerGroupControl markerGroupControl = this.f30428b;
        if (markerGroupControl != null) {
            return markerGroupControl.setOnTapMapBubblesHiddenById(this.f30427a, str, z);
        }
        return false;
    }
}
