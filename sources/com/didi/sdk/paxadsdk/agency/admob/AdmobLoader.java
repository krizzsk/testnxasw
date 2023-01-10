package com.didi.sdk.paxadsdk.agency.admob;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.didi.sdk.paxadsdk.GlobalAdManager;
import com.didi.sdk.paxadsdk.NativeAdStyle;
import com.didi.sdk.paxadsdk.agency.AdAgency;
import com.didi.sdk.paxadsdk.listener.AdLoadListenner;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;
import com.didi.sdk.paxadsdk.utils.AdLogger;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class AdmobLoader implements AdAgency {

    /* renamed from: a */
    private Map<String, AdLoader> f39689a = new HashMap();

    /* renamed from: b */
    private boolean f39690b = false;

    public String getName() {
        return "admob";
    }

    public void init(Context context) {
    }

    public void lazyInit(Context context) {
        if (!this.f39690b) {
            final long currentTimeMillis = System.currentTimeMillis();
            MobileAds.initialize(context, new OnInitializationCompleteListener() {
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    AdLogger.m29886i("AdMob init takes time: " + currentTimeMillis);
                    if (initializationStatus != null) {
                        AdLogger.m29886i("AdMob init rst:" + initializationStatus.getAdapterStatusMap());
                    }
                }
            });
            this.f39690b = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Activity m29880b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m29880b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public void loadNativeAD(Context context, NativeAdStyle nativeAdStyle, String str, final AdTraceInfo adTraceInfo, final AdLoadListenner adLoadListenner) {
        NativeAdOptions nativeAdOptions;
        lazyInit(context);
        if (!this.f39689a.containsKey(str) || this.f39689a.get(str) == null) {
            AdLoader.Builder builder = new AdLoader.Builder(context, str);
            final Context context2 = context;
            final NativeAdStyle nativeAdStyle2 = nativeAdStyle;
            final String str2 = str;
            final AdLoadListenner adLoadListenner2 = adLoadListenner;
            final AdTraceInfo adTraceInfo2 = adTraceInfo;
            builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    View view;
                    AdLogger.m29883d("onUnifiedNativeAdLoaded: onsuccess ");
                    if (nativeAd != null) {
                        Context context = context2;
                        if (context == null) {
                            nativeAd.destroy();
                            return;
                        }
                        Activity a = AdmobLoader.m29880b(context);
                        if (a == null) {
                            nativeAd.destroy();
                            return;
                        }
                        boolean z = false;
                        if (Build.VERSION.SDK_INT >= 17) {
                            z = a.isDestroyed();
                        }
                        if (z || a.isFinishing() || a.isDestroyed() || a.isChangingConfigurations()) {
                            nativeAd.destroy();
                            return;
                        }
                        if (C135616.$SwitchMap$com$didi$sdk$paxadsdk$NativeAdStyle[nativeAdStyle2.ordinal()] != 1) {
                            view = AdmobLoader.this.m29878a(context2, nativeAd, str2);
                        } else {
                            view = AdmobLoader.this.m29881b(context2, nativeAd, str2);
                        }
                        AdLoadListenner adLoadListenner = adLoadListenner2;
                        if (adLoadListenner != null) {
                            adLoadListenner.onSuccess(view, adTraceInfo2);
                        }
                    }
                }
            });
            builder.withAdListener(new AdListener() {
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    AdLogger.m29886i("onAdFailedToLoad: " + loadAdError);
                    AdLoadListenner adLoadListenner = adLoadListenner;
                    if (adLoadListenner == null) {
                        return;
                    }
                    if (loadAdError != null) {
                        adLoadListenner.onFailed(loadAdError.getCode() + "", loadAdError.getMessage(), adTraceInfo);
                        return;
                    }
                    adLoadListenner.onFailed("-10001", "onAdFailedToLoad: empty loadAdError", adTraceInfo);
                }

                public void onAdClicked() {
                    AdLogger.m29883d("onAdClicked: ");
                    AdLoadListenner adLoadListenner = adLoadListenner;
                    if (adLoadListenner != null) {
                        adLoadListenner.onAdClicked(adTraceInfo);
                    }
                }

                public void onAdClosed() {
                    AdLogger.m29883d("onAdClosed: ");
                    AdLoadListenner adLoadListenner = adLoadListenner;
                    if (adLoadListenner != null) {
                        adLoadListenner.onAdClosed(adTraceInfo);
                    }
                }

                public void onAdImpression() {
                    AdLogger.m29883d("onAdImpression: ");
                    AdLoadListenner adLoadListenner = adLoadListenner;
                    if (adLoadListenner != null) {
                        adLoadListenner.onAdImpression(adTraceInfo);
                    }
                }

                public void onAdLoaded() {
                    AdLogger.m29883d("onAdLoaded: ");
                    AdLoadListenner adLoadListenner = adLoadListenner;
                    if (adLoadListenner != null) {
                        adLoadListenner.onAdLoaded(adTraceInfo);
                    }
                }

                public void onAdOpened() {
                    AdLogger.m29883d("onAdOpened: ");
                    AdLoadListenner adLoadListenner = adLoadListenner;
                    if (adLoadListenner != null) {
                        adLoadListenner.onAdOpened(adTraceInfo);
                    }
                }
            });
            VideoOptions build = new VideoOptions.Builder().setStartMuted(true).build();
            if (nativeAdStyle == NativeAdStyle.Dialog) {
                nativeAdOptions = new NativeAdOptions.Builder().setVideoOptions(build).setAdChoicesPlacement(2).build();
            } else {
                nativeAdOptions = new NativeAdOptions.Builder().setVideoOptions(build).build();
            }
            builder.withNativeAdOptions(nativeAdOptions);
            AdLoader build2 = builder.build();
            this.f39689a.put(str, build2);
            build2.loadAd(new AdRequest.Builder().build());
        } else if (!this.f39689a.get(str).isLoading()) {
            this.f39689a.get(str).loadAd(new AdRequest.Builder().build());
        }
    }

    /* renamed from: com.didi.sdk.paxadsdk.agency.admob.AdmobLoader$6 */
    static /* synthetic */ class C135616 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$paxadsdk$NativeAdStyle;

        static {
            int[] iArr = new int[NativeAdStyle.values().length];
            $SwitchMap$com$didi$sdk$paxadsdk$NativeAdStyle = iArr;
            try {
                iArr[NativeAdStyle.Dialog.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public boolean isLoading(String str) {
        if (!this.f39689a.containsKey(str) || this.f39689a.get(str) == null) {
            return false;
        }
        return this.f39689a.get(str).isLoading();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m29878a(Context context, NativeAd nativeAd, String str) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pax_ad_native_small_card, (ViewGroup) null);
        NativeAdView nativeAdView = (NativeAdView) linearLayout.findViewById(R.id.ad_view);
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(8);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            ((TextView) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(4);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(0);
        }
        if (nativeAd.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(8);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(0);
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.debug_text);
        if (GlobalAdManager.getInstance().getConfig().isShowIndicatorOnView()) {
            if (str != null && str.length() > 4) {
                str = str.substring(str.length() - 4);
            }
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        nativeAdView.setNativeAd(nativeAd);
        if (nativeAd.getMediaContent() != null) {
            VideoController videoController = nativeAd.getMediaContent().getVideoController();
            if (videoController.hasVideoContent()) {
                nativeAd.getMediaContent().getAspectRatio();
                videoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                    public void onVideoEnd() {
                        super.onVideoEnd();
                    }
                });
            }
        }
        return linearLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public View m29881b(Context context, NativeAd nativeAd, String str) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pax_ad_native_dialog, (ViewGroup) null);
        NativeAdView nativeAdView = (NativeAdView) linearLayout.findViewById(R.id.ad_view);
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        nativeAdView.getMediaView().setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            ((TextView) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            nativeAdView.findViewById(R.id.icon_wrapper).setVisibility(8);
            nativeAdView.getIconView().setVisibility(8);
        } else {
            nativeAdView.findViewById(R.id.icon_wrapper).setVisibility(0);
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(0);
        }
        if (nativeAd.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(8);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(0);
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.debug_text);
        if (GlobalAdManager.getInstance().getConfig().isShowIndicatorOnView()) {
            if (str != null && str.length() > 4) {
                str = str.substring(str.length() - 4);
            }
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        nativeAdView.setNativeAd(nativeAd);
        if (nativeAd.getMediaContent() != null) {
            VideoController videoController = nativeAd.getMediaContent().getVideoController();
            if (videoController.hasVideoContent()) {
                nativeAd.getMediaContent().getAspectRatio();
                videoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                    public void onVideoEnd() {
                        super.onVideoEnd();
                    }
                });
            }
        }
        return linearLayout;
    }
}
