package com.didi.soda.home.topgun.manager;

import com.didi.app.nova.skeleton.repo.Repo;

public class HomeFeedRefreshRepo extends Repo<Integer> {

    /* renamed from: a */
    private CityInfo f45486a;

    public void setCityInfo(CityInfo cityInfo) {
        this.f45486a = cityInfo;
    }

    public CityInfo getCityInfo() {
        return this.f45486a;
    }

    public static class CityInfo {
        public int mCityId;
        public double mLat;
        public double mLng;

        public static CityInfo create(double d, double d2, String str) {
            CityInfo cityInfo = new CityInfo();
            try {
                cityInfo.mCityId = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                cityInfo.mCityId = 0;
            }
            cityInfo.mLat = d;
            cityInfo.mLng = d2;
            return cityInfo;
        }
    }
}
