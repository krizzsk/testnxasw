package org.bouncycastle.jcajce.provider.asymmetric.p083ec;

import com.didi.travel.p172v2.store.IStoreCallback;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyEncoder;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.IESEngine;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.parsers.ECIESPublicKeyParser;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.ECKey;
import org.bouncycastle.jce.interfaces.IESKey;
import org.bouncycastle.jce.spec.IESParameterSpec;
import org.bouncycastle.util.Strings;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher */
public class IESCipher extends CipherSpi {
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private boolean dhaesMode = false;
    private IESEngine engine;
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineSpec = null;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int ivLength;
    private AsymmetricKeyParameter key;
    private AsymmetricKeyParameter otherKeyParameter = null;
    private SecureRandom random;
    private int state = -1;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES */
    public static class ECIES extends IESCipher {
        public ECIES() {
            this(DigestFactory.createSHA1(), DigestFactory.createSHA1());
        }

        public ECIES(Digest digest, Digest digest2) {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(digest), new HMac(digest2)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC */
    public static class ECIESwithAESCBC extends ECIESwithCipher {
        public ECIESwithAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithCipher */
    public static class ECIESwithCipher extends IESCipher {
        public ECIESwithCipher(BlockCipher blockCipher, int i) {
            this(blockCipher, i, DigestFactory.createSHA1(), DigestFactory.createSHA1());
        }

        public ECIESwithCipher(BlockCipher blockCipher, int i, Digest digest, Digest digest2) {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(digest), new HMac(digest2), new PaddedBufferedBlockCipher(blockCipher)), i);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC */
    public static class ECIESwithDESedeCBC extends ECIESwithCipher {
        public ECIESwithDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256 */
    public static class ECIESwithSHA256 extends ECIES {
        public ECIESwithSHA256() {
            super(DigestFactory.createSHA256(), DigestFactory.createSHA256());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256andAESCBC */
    public static class ECIESwithSHA256andAESCBC extends ECIESwithCipher {
        public ECIESwithSHA256andAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16, DigestFactory.createSHA256(), DigestFactory.createSHA256());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256andDESedeCBC */
    public static class ECIESwithSHA256andDESedeCBC extends ECIESwithCipher {
        public ECIESwithSHA256andDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8, DigestFactory.createSHA256(), DigestFactory.createSHA256());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384 */
    public static class ECIESwithSHA384 extends ECIES {
        public ECIESwithSHA384() {
            super(DigestFactory.createSHA384(), DigestFactory.createSHA384());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384andAESCBC */
    public static class ECIESwithSHA384andAESCBC extends ECIESwithCipher {
        public ECIESwithSHA384andAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16, DigestFactory.createSHA384(), DigestFactory.createSHA384());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384andDESedeCBC */
    public static class ECIESwithSHA384andDESedeCBC extends ECIESwithCipher {
        public ECIESwithSHA384andDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8, DigestFactory.createSHA384(), DigestFactory.createSHA384());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512 */
    public static class ECIESwithSHA512 extends ECIES {
        public ECIESwithSHA512() {
            super(DigestFactory.createSHA512(), DigestFactory.createSHA512());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512andAESCBC */
    public static class ECIESwithSHA512andAESCBC extends ECIESwithCipher {
        public ECIESwithSHA512andAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16, DigestFactory.createSHA512(), DigestFactory.createSHA512());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512andDESedeCBC */
    public static class ECIESwithSHA512andDESedeCBC extends ECIESwithCipher {
        public ECIESwithSHA512andDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8, DigestFactory.createSHA512(), DigestFactory.createSHA512());
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.engine = iESEngine;
        this.ivLength = 0;
    }

    public IESCipher(IESEngine iESEngine, int i) {
        this.engine = iESEngine;
        this.ivLength = i;
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.engineSpec.getDerivationV(), this.engineSpec.getEncodingV(), this.engineSpec.getMacKeySize(), this.engineSpec.getCipherKeySize());
        if (this.engineSpec.getNonce() != null) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, this.engineSpec.getNonce());
        }
        ECDomainParameters parameters = ((ECKeyParameters) this.key).getParameters();
        AsymmetricKeyParameter asymmetricKeyParameter = this.otherKeyParameter;
        if (asymmetricKeyParameter != null) {
            try {
                if (this.state != 1) {
                    if (this.state != 3) {
                        this.engine.init(false, this.key, asymmetricKeyParameter, iESWithCipherParameters);
                        return this.engine.processBlock(byteArray, 0, byteArray.length);
                    }
                }
                this.engine.init(true, this.otherKeyParameter, this.key, iESWithCipherParameters);
                return this.engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e) {
                throw new BadBlockException("unable to process block", e);
            }
        } else {
            int i3 = this.state;
            if (i3 == 1 || i3 == 3) {
                ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                eCKeyPairGenerator.init(new ECKeyGenerationParameters(parameters, this.random));
                final boolean pointCompression = this.engineSpec.getPointCompression();
                try {
                    this.engine.init(this.key, iESWithCipherParameters, new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder() {
                        public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
                            return ((ECPublicKeyParameters) asymmetricKeyParameter).getQ().getEncoded(pointCompression);
                        }
                    }));
                    return this.engine.processBlock(byteArray, 0, byteArray.length);
                } catch (Exception e2) {
                    throw new BadBlockException("unable to process block", e2);
                }
            } else if (i3 == 2 || i3 == 4) {
                try {
                    this.engine.init(this.key, iESWithCipherParameters, (KeyParser) new ECIESPublicKeyParser(parameters));
                    return this.engine.processBlock(byteArray, 0, byteArray.length);
                } catch (InvalidCipherTextException e3) {
                    throw new BadBlockException("unable to process block", e3);
                }
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
        }
    }

    public int engineGetBlockSize() {
        if (this.engine.getCipher() != null) {
            return this.engine.getCipher().getBlockSize();
        }
        return 0;
    }

    public byte[] engineGetIV() {
        IESParameterSpec iESParameterSpec = this.engineSpec;
        if (iESParameterSpec != null) {
            return iESParameterSpec.getNonce();
        }
        return null;
    }

    public int engineGetKeySize(Key key2) {
        if (key2 instanceof ECKey) {
            return ((ECKey) key2).getParameters().getCurve().getFieldSize();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    public int engineGetOutputSize(int i) {
        int size;
        BufferedBlockCipher bufferedBlockCipher;
        if (this.key != null) {
            int macSize = this.engine.getMac().getMacSize();
            int fieldSize = this.otherKeyParameter == null ? ((((ECKeyParameters) this.key).getParameters().getCurve().getFieldSize() + 7) / 8) * 2 : 0;
            if (this.engine.getCipher() != null) {
                int i2 = this.state;
                if (i2 == 1 || i2 == 3) {
                    bufferedBlockCipher = this.engine.getCipher();
                } else if (i2 == 2 || i2 == 4) {
                    bufferedBlockCipher = this.engine.getCipher();
                    i = (i - macSize) - fieldSize;
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
                i = bufferedBlockCipher.getOutputSize(i);
            }
            int i3 = this.state;
            if (i3 == 1 || i3 == 3) {
                size = this.buffer.size() + macSize + 1 + fieldSize;
            } else if (i3 == 2 || i3 == 4) {
                size = (this.buffer.size() - macSize) - fieldSize;
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
            return size + i;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineSpec != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("IES");
                this.engineParam = createAlgorithmParameters;
                createAlgorithmParameters.init(this.engineSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParam;
    }

    public void engineInit(int i, Key key2, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.engineParam = algorithmParameters;
        engineInit(i, key2, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i, Key key2, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key2, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("cannot handle supplied parameter spec: " + e.getMessage());
        }
    }

    public void engineInit(int i, Key key2, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        IESParameterSpec iESParameterSpec;
        AsymmetricKeyParameter asymmetricKeyParameter;
        PrivateKey privateKey;
        byte[] bArr = null;
        this.otherKeyParameter = null;
        if (algorithmParameterSpec == null) {
            int i2 = this.ivLength;
            if (i2 != 0 && i == 1) {
                bArr = new byte[i2];
                secureRandom.nextBytes(bArr);
            }
            iESParameterSpec = IESUtil.guessParameterSpec(this.engine.getCipher(), bArr);
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            iESParameterSpec = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        this.engineSpec = iESParameterSpec;
        byte[] nonce = this.engineSpec.getNonce();
        int i3 = this.ivLength;
        if (i3 == 0 || (nonce != null && nonce.length == i3)) {
            if (i == 1 || i == 3) {
                if (key2 instanceof PublicKey) {
                    asymmetricKeyParameter = ECUtils.generatePublicKeyParameter((PublicKey) key2);
                } else if (key2 instanceof IESKey) {
                    IESKey iESKey = (IESKey) key2;
                    this.key = ECUtils.generatePublicKeyParameter(iESKey.getPublic());
                    this.otherKeyParameter = ECUtil.generatePrivateKeyParameter(iESKey.getPrivate());
                    this.random = secureRandom;
                    this.state = i;
                    this.buffer.reset();
                    return;
                } else {
                    throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
                }
            } else if (i == 2 || i == 4) {
                if (key2 instanceof PrivateKey) {
                    privateKey = (PrivateKey) key2;
                } else if (key2 instanceof IESKey) {
                    IESKey iESKey2 = (IESKey) key2;
                    this.otherKeyParameter = ECUtils.generatePublicKeyParameter(iESKey2.getPublic());
                    privateKey = iESKey2.getPrivate();
                } else {
                    throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
                }
                asymmetricKeyParameter = ECUtil.generatePrivateKeyParameter(privateKey);
            } else {
                throw new InvalidKeyException("must be passed EC key");
            }
            this.key = asymmetricKeyParameter;
            this.random = secureRandom;
            this.state = i;
            this.buffer.reset();
            return;
        }
        throw new InvalidAlgorithmParameterException("NONCE in IES Parameters needs to be " + this.ivLength + " bytes long");
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        boolean z;
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals(IStoreCallback.DEFAULT_API_DETAIL_KEY)) {
            z = false;
        } else if (upperCase.equals("DHAES")) {
            z = true;
        } else {
            throw new IllegalArgumentException("can't support mode " + str);
        }
        this.dhaesMode = z;
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NOPADDING") && !upperCase.equals("PKCS5PADDING") && !upperCase.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.buffer.write(bArr, i, i2);
        return 0;
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        return null;
    }
}
