package com.example.hashapp.generator;

import jakarta.ejb.Stateful;
import jakarta.xml.bind.DatatypeConverter;
import org.bouncycastle.crypto.digests.SHAKEDigest;

@Stateful
public class HashGenerator {

    public String generateHash(byte[] bytes, int length) {
            final SHAKEDigest digest = new SHAKEDigest(128);
            int byteLength = length / 8;
            if (byteLength <= 0) return null;
            final byte[] hashBytes = new byte[byteLength];
            digest.update(bytes, 0, bytes.length);
            digest.doOutput(hashBytes, 0, hashBytes.length);
            return DatatypeConverter.printHexBinary(hashBytes).toLowerCase();
    }

}
