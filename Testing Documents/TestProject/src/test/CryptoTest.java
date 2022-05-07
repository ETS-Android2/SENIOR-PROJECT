package test;

import crypto.SHA256;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;


public class CryptoTest
{
    /**
     * value of "a" hashed taken from https://emn178.github.io/online-tools/sha256.html
     * @throws NoSuchAlgorithmException
     */
    @Test
    void hashTest() throws NoSuchAlgorithmException
    {
        Assertions.assertEquals(SHA256.hashString("a"),"ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb");
    }




}
