package org.bouncycastle.asn1.nist;

import androidx.room.RoomMasterTable;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface NISTObjectIdentifiers {
    public static final ASN1ObjectIdentifier aes;
    public static final ASN1ObjectIdentifier dsa_with_sha224;
    public static final ASN1ObjectIdentifier dsa_with_sha256 = sigAlgs.branch("2");
    public static final ASN1ObjectIdentifier dsa_with_sha384 = sigAlgs.branch("3");
    public static final ASN1ObjectIdentifier dsa_with_sha512 = sigAlgs.branch("4");
    public static final ASN1ObjectIdentifier hashAlgs;
    public static final ASN1ObjectIdentifier id_KmacWithSHAKE128 = hashAlgs.branch(DiFaceLogger.EVENT_ID_APPEAL_DIALOG_CANCEL);
    public static final ASN1ObjectIdentifier id_KmacWithSHAKE256 = hashAlgs.branch("20");
    public static final ASN1ObjectIdentifier id_aes128_CBC = aes.branch("2");
    public static final ASN1ObjectIdentifier id_aes128_CCM = aes.branch("7");
    public static final ASN1ObjectIdentifier id_aes128_CFB = aes.branch("4");
    public static final ASN1ObjectIdentifier id_aes128_ECB;
    public static final ASN1ObjectIdentifier id_aes128_GCM = aes.branch("6");
    public static final ASN1ObjectIdentifier id_aes128_OFB = aes.branch("3");
    public static final ASN1ObjectIdentifier id_aes128_wrap = aes.branch("5");
    public static final ASN1ObjectIdentifier id_aes128_wrap_pad = aes.branch("8");
    public static final ASN1ObjectIdentifier id_aes192_CBC = aes.branch(ScarShareReportModel.CHANNEL_WHATSAPP);
    public static final ASN1ObjectIdentifier id_aes192_CCM = aes.branch("27");
    public static final ASN1ObjectIdentifier id_aes192_CFB = aes.branch(ScarShareReportModel.CHANNEL_MESSENGER);
    public static final ASN1ObjectIdentifier id_aes192_ECB = aes.branch(ScarShareReportModel.CHANNEL_FACEBOOK);
    public static final ASN1ObjectIdentifier id_aes192_GCM = aes.branch(ScarShareReportModel.CHANNEL_LINE);
    public static final ASN1ObjectIdentifier id_aes192_OFB = aes.branch(ScarShareReportModel.CHANNEL_TWITTER);
    public static final ASN1ObjectIdentifier id_aes192_wrap = aes.branch(ScarShareReportModel.CHANNEL_EMAIL);
    public static final ASN1ObjectIdentifier id_aes192_wrap_pad = aes.branch("28");
    public static final ASN1ObjectIdentifier id_aes256_CBC = aes.branch(RoomMasterTable.DEFAULT_ID);
    public static final ASN1ObjectIdentifier id_aes256_CCM = aes.branch(DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CONFIRM);
    public static final ASN1ObjectIdentifier id_aes256_CFB = aes.branch("44");
    public static final ASN1ObjectIdentifier id_aes256_ECB = aes.branch("41");
    public static final ASN1ObjectIdentifier id_aes256_GCM = aes.branch(DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CANCEL);
    public static final ASN1ObjectIdentifier id_aes256_OFB = aes.branch("43");
    public static final ASN1ObjectIdentifier id_aes256_wrap = aes.branch("45");
    public static final ASN1ObjectIdentifier id_aes256_wrap_pad = aes.branch(DiFaceLogger.EVENT_ID_PERMISSION_PARTIAL_GRANTED_IN_APPEAL);
    public static final ASN1ObjectIdentifier id_dsa_with_sha2;
    public static final ASN1ObjectIdentifier id_dsa_with_sha3_224 = sigAlgs.branch("5");
    public static final ASN1ObjectIdentifier id_dsa_with_sha3_256 = sigAlgs.branch("6");
    public static final ASN1ObjectIdentifier id_dsa_with_sha3_384 = sigAlgs.branch("7");
    public static final ASN1ObjectIdentifier id_dsa_with_sha3_512 = sigAlgs.branch("8");
    public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_224 = sigAlgs.branch("9");
    public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_256 = sigAlgs.branch("10");
    public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_384 = sigAlgs.branch("11");
    public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_512 = sigAlgs.branch("12");
    public static final ASN1ObjectIdentifier id_hmacWithSHA3_224 = hashAlgs.branch(DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
    public static final ASN1ObjectIdentifier id_hmacWithSHA3_256 = hashAlgs.branch("14");
    public static final ASN1ObjectIdentifier id_hmacWithSHA3_384 = hashAlgs.branch(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
    public static final ASN1ObjectIdentifier id_hmacWithSHA3_512;
    public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_224 = sigAlgs.branch(DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
    public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_256 = sigAlgs.branch("14");
    public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_384;
    public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_512 = sigAlgs.branch("16");
    public static final ASN1ObjectIdentifier id_sha224 = hashAlgs.branch("4");
    public static final ASN1ObjectIdentifier id_sha256;
    public static final ASN1ObjectIdentifier id_sha384 = hashAlgs.branch("2");
    public static final ASN1ObjectIdentifier id_sha3_224 = hashAlgs.branch("7");
    public static final ASN1ObjectIdentifier id_sha3_256 = hashAlgs.branch("8");
    public static final ASN1ObjectIdentifier id_sha3_384 = hashAlgs.branch("9");
    public static final ASN1ObjectIdentifier id_sha3_512 = hashAlgs.branch("10");
    public static final ASN1ObjectIdentifier id_sha512 = hashAlgs.branch("3");
    public static final ASN1ObjectIdentifier id_sha512_224 = hashAlgs.branch("5");
    public static final ASN1ObjectIdentifier id_sha512_256 = hashAlgs.branch("6");
    public static final ASN1ObjectIdentifier id_shake128 = hashAlgs.branch("11");
    public static final ASN1ObjectIdentifier id_shake128_len = hashAlgs.branch(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
    public static final ASN1ObjectIdentifier id_shake256 = hashAlgs.branch("12");
    public static final ASN1ObjectIdentifier id_shake256_len = hashAlgs.branch(DiFaceLogger.EVENT_ID_ENTER_APPEAL_DIALOG);
    public static final ASN1ObjectIdentifier nistAlgorithm;
    public static final ASN1ObjectIdentifier sigAlgs;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.101.3.4");
        nistAlgorithm = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("2");
        hashAlgs = branch;
        id_sha256 = branch.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = hashAlgs;
        String str = DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH;
        id_hmacWithSHA3_512 = aSN1ObjectIdentifier2.branch("16");
        ASN1ObjectIdentifier branch2 = nistAlgorithm.branch("1");
        aes = branch2;
        id_aes128_ECB = branch2.branch("1");
        ASN1ObjectIdentifier branch3 = nistAlgorithm.branch("3");
        sigAlgs = branch3;
        id_dsa_with_sha2 = branch3;
        dsa_with_sha224 = branch3.branch("1");
        id_rsassa_pkcs1_v1_5_with_sha3_384 = sigAlgs.branch(str);
    }
}
