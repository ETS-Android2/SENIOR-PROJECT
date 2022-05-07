package regex;

import model.LicensePlate;

public class LicensePlateChecker
{
    public static boolean validLicensePlateChecker(LicensePlate licensePlate)
    {
        boolean isValid = true;

        if (((licensePlate.getCityCode().length() + licensePlate.getLetterGroup().length() + licensePlate.getDigitGroup().length()) == 7) || ((licensePlate.getCityCode().length() + licensePlate.getLetterGroup().length() + licensePlate.getDigitGroup().length()) == 8)) // it must be 7 or 8 element
        {
            int numberOfLetters = licensePlate.getLetterGroup().length();

            switch (numberOfLetters)
            {
                case 1: //case for 1 letter 4 digit
                    if (licensePlate.getDigitGroup().length() != 4)
                    {
                        isValid = false;
                    }
                    break;
                case 2: //case for 2 letter 3-4 digit
                    if ((licensePlate.getDigitGroup().length() != 3) && (licensePlate.getDigitGroup().length() != 4))
                    {
                        isValid = false;
                    }
                    break;
                case 3: //case for 3 letter 2 digit
                    if (licensePlate.getDigitGroup().length() != 2)
                    {
                        isValid = false;
                    }
                    break;
                default:
                    isValid = false;
            }
        }
        else
        {
            isValid = false;
        }

        return isValid;
    }

    //Türk plaka standartlarına uyan sivil plakaların karakter sayısı 7 veya 8' dir. Karakter sayısı, plakanın 2. kısmını oluşturan harf sayısıyla doğrudan ilişkilidir. kinci kısım 1,2 veya 3 harften oluşmaktadır. 2. kısımda 1 harf varsa 3. kısımda 4 rakam, 2 harf varsa 3 veya 4 rakam, 3 harf varsa 2 rakam olur.
    //https://dergipark.org.tr/tr/download/article-file/75232#:~:text=T%C3%BCrk%20plaka%20standartlar%C4%B1na%20uyan%20sivil%20plakalar%C4%B1n%20karakter%20say%C4%B1s%C4%B1%207%20veya,harf%20varsa%202%20rakam%20olur.
    public static boolean cityCodeChecker(String cityCode)
    {
        return cityCode.matches("[1-7][0-9]") || cityCode.matches(  "[8][0-1]") || cityCode.matches(  "[0][1-9]");
    }

    public static boolean letterGroupChecker(String letterGroup)
    {
        return letterGroup.matches("[A-Z&&[^WXQİŞÜĞ]]{1,3}");
    }



}