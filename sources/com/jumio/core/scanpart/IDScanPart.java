package com.jumio.core.scanpart;

import com.jumio.commons.camera.PreviewProperties;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.DocumentPart;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.model.InvokeOnUiThread;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.DocumentDataModel;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.C20991a;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.views.ScanView;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.taxis99.R;
import jumio.core.C19462a;
import jumio.core.C19505t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¨\u0006\u0013"}, mo148868d2 = {"Lcom/jumio/core/scanpart/IDScanPart;", "Lcom/jumio/core/scanpart/JVisionScanPart;", "Lcom/jumio/core/models/IDScanPartModel;", "Lcom/jumio/core/model/StaticModel;", "result", "", "onResult", "", "error", "onError", "Lcom/jumio/core/Controller;", "controller", "Lcom/jumio/sdk/credentials/JumioIDCredential;", "credential", "scanPartModel", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "<init>", "(Lcom/jumio/core/Controller;Lcom/jumio/sdk/credentials/JumioIDCredential;Lcom/jumio/core/models/IDScanPartModel;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: IDScanPart.kt */
public final class IDScanPart extends JVisionScanPart<IDScanPartModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IDScanPart(Controller controller, JumioIDCredential jumioIDCredential, IDScanPartModel iDScanPartModel, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioIDCredential, iDScanPartModel, jumioScanPartInterface);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(jumioIDCredential, "credential");
        Intrinsics.checkNotNullParameter(iDScanPartModel, "scanPartModel");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
    }

    /* renamed from: a */
    public ExtractionPlugin mo172457a(ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "scanMode");
        ExtractionPlugin extractionPlugin = (ExtractionPlugin) C20991a.m43783b(getScanPluginMode(scanMode));
        while (true) {
            if (extractionPlugin != null && extractionPlugin.isUsable(getController(), getScanPartModel())) {
                return extractionPlugin;
            }
            scanMode = mo172460q().getFallbackAfter(scanMode);
            C20991a.C20994c scanPluginMode = getScanPluginMode(scanMode);
            ((IDScanPartModel) getScanPartModel()).setMode(scanMode);
            extractionPlugin = (ExtractionPlugin) C20991a.m43783b(scanPluginMode);
        }
    }

    public void checkForAddon(Function1<? super JumioScanPart, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "complete");
        ScanPartPlugin scanPartPlugin = (ScanPartPlugin) getController().getPluginManager().mo148608a(C20991a.C20994c.NFC);
        boolean z = true;
        if (scanPartPlugin == null || !scanPartPlugin.isUsable(getController(), getScanPartModel())) {
            z = false;
        }
        if (z) {
            IDScanPartModel iDScanPartModel = new IDScanPartModel(JumioScanSide.NFC, ScanMode.NFC, ((IDScanPartModel) getScanPartModel()).getFormat(), ((IDScanPartModel) getScanPartModel()).getSelectionModel());
            iDScanPartModel.setDocumentData(((IDScanPartModel) getScanPartModel()).getDocumentData());
            function1.invoke(new JumioScanPart(scanPartPlugin.getScanPart(getController(), getCredential(), iDScanPartModel, getScanPartInterface())));
            ScanPart.sendScanStep$default(this, JumioScanStep.ADDON_SCAN_PART, (Object) null, (Object) null, 6, (Object) null);
            return;
        }
        function1.invoke(null);
    }

    public void fallback() {
        if (getHasFallback() && mo172473p() != null) {
            if (((IDScanPartModel) getScanPartModel()).getScanStep() == JumioScanStep.SCAN_VIEW || ((IDScanPartModel) getScanPartModel()).getScanStep() == JumioScanStep.STARTED) {
                super.fallback();
                ScanMode fallbackAfter = mo172460q().getFallbackAfter(((IDScanPartModel) getScanPartModel()).getMode());
                ExtractionClient l = mo172468l();
                if (l != null) {
                    l.setDataExtractionActive(false);
                }
                ExtractionClient l2 = mo172468l();
                if (l2 != null) {
                    l2.unsubscribe(this);
                }
                ExtractionClient l3 = mo172468l();
                if (l3 != null) {
                    l3.destroy();
                }
                ((IDScanPartModel) getScanPartModel()).setMode(fallbackAfter);
                mo172464a(mo172457a(fallbackAfter));
                ExtractionClient extractionClient = mo172470n().getExtractionClient(getController().getContext());
                extractionClient.configure(getController().getDataManager(), getScanPartModel());
                extractionClient.subscribe(this);
                ScanView p = mo172473p();
                extractionClient.setPreviewProperties(p == null ? null : p.getPreviewProperties$jumio_core_release());
                ScanView p2 = mo172473p();
                extractionClient.setExtractionArea(p2 == null ? null : p2.getExtractionArea$jumio_core_release());
                extractionClient.reinit();
                Unit unit = Unit.INSTANCE;
                mo172462a(extractionClient);
                if (mo172469m() != null) {
                    Overlay m = mo172469m();
                    if (m != null) {
                        m.setVisible(8);
                    }
                    mo172463a(mo172470n().getOverlay(getController().getContext()));
                    Overlay m2 = mo172469m();
                    if (m2 != null) {
                        ScanView p3 = mo172473p();
                        if (p3 != null) {
                            C19505t drawView$jumio_core_release = p3.getDrawView$jumio_core_release();
                            if (drawView$jumio_core_release != null) {
                                m2.addViews(drawView$jumio_core_release);
                            }
                            m2.setScanPart(getScanPartModel());
                            m2.calculate(p3.getExtractionArea$jumio_core_release());
                            m2.prepareDraw(p3.getCameraFacing() == JumioCameraFacing.FRONT);
                        }
                        m2.setVisible(0);
                    }
                }
                ScanView p4 = mo172473p();
                if (p4 != null) {
                    p4.update$jumio_core_release(false);
                }
                ExtractionClient l4 = mo172468l();
                if (l4 != null) {
                    l4.setDataExtractionActive(true);
                }
                ScanPart.sendUpdate$default(this, JumioScanUpdate.FALLBACK, (Object) null, 2, (Object) null);
            }
        }
    }

    public void finish() {
        super.finish();
        ((C19462a) getController().getDataManager().get(C19462a.class)).mo148598a((IDScanPartModel) getScanPartModel());
    }

    public boolean getHasFallback() {
        return mo172460q().hasFallbackAfter(((IDScanPartModel) getScanPartModel()).getMode());
    }

    @InvokeOnUiThread(true)
    public void onError(Throwable th) {
        super.onError(th);
    }

    /* renamed from: q */
    public final DocumentPart mo172460q() {
        return ((IDScanPartModel) getScanPartModel()).getSelectionModel().getVariant().getPart(((IDScanPartModel) getScanPartModel()).getSide());
    }

    /* renamed from: r */
    public final int mo172461r() {
        String isoCode = ((IDScanPartModel) getScanPartModel()).getSelectionModel().getCountry().getIsoCode();
        int hashCode = isoCode.hashCode();
        if (hashCode != 67572) {
            if (hashCode != 74606) {
                if (hashCode == 77382 && isoCode.equals("NLD")) {
                    return R.string.jumio_id_scan_prompt_redact_nld;
                }
            } else if (!isoCode.equals("KOR")) {
                return 0;
            } else {
                return R.string.jumio_id_scan_prompt_redact_kor;
            }
        } else if (isoCode.equals("DEU")) {
            if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getDocumentType().getIdType() == JumioDocumentType.PASSPORT) {
                return R.string.jumio_id_scan_prompt_redact_deu_passport;
            }
            if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getDocumentType().getIdType() == JumioDocumentType.ID_CARD) {
                if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getVariant().getVariant() == JumioDocumentVariant.PLASTIC) {
                    return R.string.jumio_id_scan_prompt_redact_deu_id_plastic;
                }
                if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getVariant().getVariant() == JumioDocumentVariant.PAPER) {
                    return R.string.jumio_id_scan_prompt_redact_deu_id_paper;
                }
            }
        }
        return 0;
    }

    public void reset() {
        ScanMode scanMode = mo172460q().getExtraction().get(0);
        Intrinsics.checkNotNullExpressionValue(scanMode, "documentPart.extraction[0]");
        ((IDScanPartModel) getScanPartModel()).setMode(scanMode);
        ((IDScanPartModel) getScanPartModel()).setDocumentData((DocumentDataModel) null);
        super.reset();
    }

    public void onResult(StaticModel staticModel) {
        ((IDScanPartModel) getScanPartModel()).setDocumentData(staticModel instanceof DocumentDataModel ? (DocumentDataModel) staticModel : new DocumentDataModel());
        super.onResult(staticModel);
    }

    /* renamed from: a */
    public void mo148693a(PreviewProperties previewProperties) {
        int r;
        Intrinsics.checkNotNullParameter(previewProperties, "properties");
        super.mo148693a(previewProperties);
        if (mo172460q().getMasking() && (r = mo172461r()) != 0) {
            sendUpdate(JumioScanUpdate.LEGAL_HINT, getController().getContext().getString(r));
        }
    }
}
