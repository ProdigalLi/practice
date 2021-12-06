package com.yuan.practice.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author Yuan
 */
public class SecretKeyUtil {
    public static final String KEY_ALGORITHM = "RSA";
    public static final int KEY_SIZE = 1024;
    private static volatile RSA256Key rsa256Key;

    public static RSA256Key getRsa256Key() {
        if (rsa256Key == null) {
            synchronized (RSA256Key.class) {
                if (rsa256Key == null) {
                    KeyPairGenerator keyPairGen;
                    try {
                        keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    keyPairGen.initialize(KEY_SIZE);
                    KeyPair keyPair = keyPairGen.generateKeyPair();
                    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
                    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
                    rsa256Key = new RSA256Key(publicKey, privateKey);
                }
            }
        }
        return rsa256Key;
    }
}
