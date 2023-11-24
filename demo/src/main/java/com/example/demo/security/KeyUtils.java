package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Objects;

@Component
public class KeyUtils {

    @Autowired
    Environment environment;
    @Value("access-token-private")
    private String accessTokenPrivateKeyPath;
    @Value("access-token-public")
    private String accessTokenPublicKeyPath;
    @Value("refresh-token-private")
    private String refreshTokenPrivateKeyPath;
    @Value("refresh-token-private")
    private String refreshTokenPublicKeyPath;
    private KeyPair _accessTokenKeyPair;
    private KeyPair _refreshTokenKeyPair;
    private KeyPair getAccessTokenKeyPair() throws IOException {
        if(Objects.isNull(_accessTokenKeyPair)){
            _accessTokenKeyPair = getKeyPair(accessTokenPrivateKeyPath,accessTokenPublicKeyPath);
        }
        return _accessTokenKeyPair;
    }
    private KeyPair getRefreshTokenKeyPair() throws IOException {
        if(Objects.isNull(_refreshTokenKeyPair)){
            _refreshTokenKeyPair = getKeyPair(refreshTokenPrivateKeyPath,refreshTokenPublicKeyPath);
        }
        return _accessTokenKeyPair;
    }

    private KeyPair getKeyPair(String privateKeyPath, String publicKeyPath) throws IOException {

            KeyPair keyPair;
            File publicKeyFile = new File(publicKeyPath);
            File privateKeyFile = new File(privateKeyPath);
            if (publicKeyFile.exists() && privateKeyFile.exists()) {
                try{
                    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

                    byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());
                    EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
                    PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

                    byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());
                    PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
                    PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

                    keyPair = new KeyPair(publicKey, privateKey);
                    return keyPair;
                } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                    throw new RuntimeException(e);
                }


            }
        else{
            if(Arrays.stream(environment.getActiveProfiles()).anyMatch(s->s.equals("prod"))){
                throw new RuntimeException("public and private key does't exists");
            }
        }
        File directory = new File("access-refresh-token-keys");
        if(!directory.exists()){
            directory.mkdirs();
        }
        try{
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            keyPair = generator.generateKeyPair();
            try(FileOutputStream fos = new FileOutputStream(publicKeyPath)){
                X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
                fos.write(keySpec.getEncoded());
            }
            try(FileOutputStream fos = new FileOutputStream(privateKeyPath)){
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
                fos.write(keySpec.getEncoded());
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return keyPair;
    }

    public RSAPublicKey getAccessTokenPublicKey() throws IOException {
        return (RSAPublicKey) getAccessTokenKeyPair().getPublic();
    }
    public RSAPrivateKey getAccessTokenPrivateKey() throws IOException {
        return (RSAPrivateKey) getAccessTokenKeyPair().getPrivate();
    }
    public RSAPublicKey  getRefreshTokenPublicKey() throws IOException {
        return (RSAPublicKey) getRefreshTokenKeyPair().getPublic();
    }
    public RSAPrivateKey getRefreshTokenPrivateKey() throws IOException {
        return (RSAPrivateKey) getRefreshTokenKeyPair().getPrivate();
    }

}
