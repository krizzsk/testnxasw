package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.didi.entrega.customer.foundation.rpc.ApiErrorConst;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzho;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzel {
    public static final zzek zzA = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbh.zza);
    public static final zzek zzB = zza("measurement.upload.retry_count", 6, 6, zzbj.zza);
    public static final zzek zzC = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbk.zza);
    public static final zzek zzD = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbl.zza);
    public static final zzek zzE = zza("measurement.audience.filter_result_max_count", 200, 200, zzbn.zza);
    public static final zzek zzF = zza("measurement.upload.max_public_user_properties", 25, 25, (zzeh) null);
    public static final zzek zzG = zza("measurement.upload.max_event_name_cardinality", 500, 500, (zzeh) null);
    public static final zzek zzH = zza("measurement.upload.max_public_event_params", 25, 25, (zzeh) null);
    public static final zzek zzI = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbo.zza);
    public static final zzek zzJ = zza("measurement.test.boolean_flag", false, false, zzbp.zza);
    public static final zzek zzK = zza("measurement.test.string_flag", "---", "---", zzbq.zza);
    public static final zzek zzL = zza("measurement.test.long_flag", -1L, -1L, zzbr.zza);
    public static final zzek zzM = zza("measurement.test.int_flag", -2, -2, zzbs.zza);
    public static final zzek zzN;
    public static final zzek zzO = zza("measurement.experiment.max_ids", 50, 50, zzbv.zza);
    public static final zzek zzP = zza("measurement.max_bundles_per_iteration", 100, 100, zzbw.zza);
    public static final zzek zzQ;
    public static final zzek zzR = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, zzbz.zza);
    public static final zzek zzS = zza("measurement.validation.internal_limits_internal_event_params", true, true, zzca.zza);
    public static final zzek zzT = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcb.zza);
    public static final zzek zzU = zza("measurement.quality.checksum", false, false, (zzeh) null);
    public static final zzek zzV = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzcc.zza);
    public static final zzek zzW = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzcd.zza);
    public static final zzek zzX = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzcf.zza);
    public static final zzek zzY = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcg.zza);
    public static final zzek zzZ = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzch.zza);
    public static final zzek zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzax.zza);
    public static final zzek zzaA = zza("measurement.redaction.no_aiid_in_config_request", true, true, zzdo.zza);
    public static final zzek zzaB = zza("measurement.redaction.config_redacted_fields", true, true, zzdp.zza);
    public static final zzek zzaC = zza("measurement.redaction.upload_redacted_fields", true, true, zzdq.zza);
    public static final zzek zzaD = zza("measurement.redaction.upload_subdomain_override", true, true, zzdr.zza);
    public static final zzek zzaE = zza("measurement.redaction.device_info", true, true, zzds.zza);
    public static final zzek zzaF = zza("measurement.redaction.user_id", true, true, zzdt.zza);
    public static final zzek zzaG = zza("measurement.redaction.google_signals", true, true, zzdv.zza);
    public static final zzek zzaH = zza("measurement.collection.enable_session_stitching_token.service", false, false, zzdx.zza);
    public static final zzek zzaI = zza("measurement.collection.enable_session_stitching_token.client.dev", false, false, zzdy.zza);
    public static final zzek zzaJ = zza("measurement.redaction.app_instance_id", true, true, zzdz.zza);
    public static final zzek zzaK = zza("measurement.redaction.populate_ephemeral_app_instance_id", true, true, zzea.zza);
    public static final zzek zzaL = zza("measurement.redaction.enhanced_uid", true, true, zzeb.zza);
    public static final zzek zzaM = zza("measurement.redaction.e_tag", true, true, zzec.zza);
    public static final zzek zzaN = zza("measurement.redaction.client_ephemeral_aiid_generation", true, true, zzed.zza);
    /* access modifiers changed from: private */
    public static final List zzaO = Collections.synchronizedList(new ArrayList());
    private static final Set zzaP = Collections.synchronizedSet(new HashSet());
    public static final zzek zzaa = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzci.zza);
    public static final zzek zzab = zza("measurement.integration.disable_firebase_instance_id", false, false, zzcj.zza);
    public static final zzek zzac = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzcl.zza);
    public static final zzek zzad = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzcm.zza);
    public static final zzek zzae = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzcn.zza);
    public static final zzek zzaf = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzco.zza);
    public static final zzek zzag = zza("measurement.collection.synthetic_data_mitigation", false, false, zzcq.zza);
    public static final zzek zzah = zza("measurement.androidId.delete_feature", true, true, zzcr.zza);
    public static final zzek zzai = zza("measurement.service.storage_consent_support_version", 203600, 203600, zzcs.zza);
    public static final zzek zzaj = zza("measurement.client.click_identifier_control.dev", false, false, zzct.zza);
    public static final zzek zzak = zza("measurement.service.click_identifier_control", false, false, zzcu.zza);
    public static final zzek zzal = zza("measurement.client.consent.gmpappid_worker_thread_fix", true, true, zzcv.zza);
    public static final zzek zzam = zza("measurement.module.pixie.fix_array", true, true, zzcx.zza);
    public static final zzek zzan = zza("measurement.adid_zero.service", true, true, zzcy.zza);
    public static final zzek zzao = zza("measurement.adid_zero.remove_lair_if_adidzero_false", true, true, zzcz.zza);
    public static final zzek zzap = zza("measurement.adid_zero.remove_lair_if_userid_cleared", true, true, zzdb.zza);
    public static final zzek zzaq = zza("measurement.adid_zero.remove_lair_on_id_value_change_only", true, true, zzdc.zza);
    public static final zzek zzar = zza("measurement.adid_zero.adid_uid", true, true, zzdd.zza);
    public static final zzek zzas = zza("measurement.adid_zero.app_instance_id_fix", true, true, zzde.zza);
    public static final zzek zzat = zza("measurement.service.refactor.package_side_screen", true, true, zzdf.zza);
    public static final zzek zzau = zza("measurement.enhanced_campaign.service", true, true, zzdg.zza);
    public static final zzek zzav = zza("measurement.enhanced_campaign.client", true, true, zzdh.zza);
    public static final zzek zzaw = zza("measurement.enhanced_campaign.srsltid.client", false, false, zzdj.zza);
    public static final zzek zzax = zza("measurement.enhanced_campaign.srsltid.service", false, false, zzdk.zza);
    public static final zzek zzay = zza("measurement.service.store_null_safelist", true, true, zzdm.zza);
    public static final zzek zzaz = zza("measurement.service.store_safelist", true, true, zzdn.zza);
    public static final zzek zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzbi.zza);
    public static final zzek zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzba.zza);
    public static final zzek zzd = zza("measurement.config.url_scheme", "https", "https", zzbm.zza);
    public static final zzek zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzby.zza);
    public static final zzek zzf = zza("measurement.upload.max_bundles", 100, 100, zzck.zza);
    public static final zzek zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzcw.zza);
    public static final zzek zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdi.zza);
    public static final zzek zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzdu.zza);
    public static final zzek zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzee.zza);
    public static final zzek zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzbt.zza);
    public static final zzek zzl;
    public static final zzek zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzcp.zza);
    public static final zzek zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzda.zza);
    public static final zzek zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzdl.zza);
    public static final zzek zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzdw.zza);
    public static final zzek zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzef.zza);
    public static final zzek zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzeg.zza);
    public static final zzek zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzay.zza);
    public static final zzek zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzaz.zza);
    public static final zzek zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbb.zza);
    public static final zzek zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbc.zza);
    public static final zzek zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbd.zza);
    public static final zzek zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbe.zza);
    public static final zzek zzy;
    public static final zzek zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbg.zza);

    static {
        Integer valueOf = Integer.valueOf(ApiErrorConst.Code.ERROR_50000);
        zzl = zza("measurement.upload.max_public_events_per_day", valueOf, valueOf, zzce.zza);
        Long valueOf2 = Long.valueOf(GlobalBubbleShowHelper.ONE_WEEK);
        zzy = zza("measurement.upload.refresh_blacklisted_config_interval", valueOf2, valueOf2, zzbf.zza);
        Double valueOf3 = Double.valueOf(-3.0d);
        zzN = zza("measurement.test.double_flag", valueOf3, valueOf3, zzbu.zza);
        zzQ = zza("measurement.sdk.attribution.cache.ttl", valueOf2, valueOf2, zzbx.zza);
    }

    static zzek zza(String str, Object obj, Object obj2, zzeh zzeh) {
        zzek zzek = new zzek(str, obj, obj2, zzeh, (zzej) null);
        zzaO.add(zzek);
        return zzek;
    }

    public static Map zzc(Context context) {
        zzhe zza2 = zzhe.zza(context.getContentResolver(), zzho.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zzc();
    }
}
