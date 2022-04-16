package test;

import model.LicensePlate;
import org.junit.jupiter.api.Test;
import regex.LicensePlateChecker;

import static org.junit.jupiter.api.Assertions.*;

public class LicensePlateCheckerTest
{
    @Test
    void cityCodeCheckerTest()
    {
        assertFalse(LicensePlateChecker.cityCodeChecker("-5"));
        assertFalse(LicensePlateChecker.cityCodeChecker("00"));
        assertFalse(LicensePlateChecker.cityCodeChecker("0"));
        assertFalse(LicensePlateChecker.cityCodeChecker("82"));

        assertTrue(LicensePlateChecker.cityCodeChecker("06"));
        assertTrue(LicensePlateChecker.cityCodeChecker("35"));
    }

    @Test
    void letterGroupCheckerTest()
    {
        assertFalse(LicensePlateChecker.letterGroupChecker("QQ"));
        assertFalse(LicensePlateChecker.letterGroupChecker("W"));
        assertFalse(LicensePlateChecker.letterGroupChecker("W2"));
        assertFalse(LicensePlateChecker.letterGroupChecker("232"));
        assertFalse(LicensePlateChecker.letterGroupChecker("Aİ"));
        assertFalse(LicensePlateChecker.letterGroupChecker("ĞŞ"));


        assertTrue(LicensePlateChecker.letterGroupChecker("A"));
        assertTrue(LicensePlateChecker.letterGroupChecker("AB"));
        assertTrue(LicensePlateChecker.letterGroupChecker("ACC"));
        assertTrue(LicensePlateChecker.letterGroupChecker("AOP"));

    }

    @Test
    void validLicensePlateCheckerTest()
    {
        LicensePlate licensePlate = new LicensePlate("35","TC","1881","0000","aa",0,"Mercedes",2021);

        assertTrue(LicensePlateChecker.validLicensePlateChecker(licensePlate));
    }


}
