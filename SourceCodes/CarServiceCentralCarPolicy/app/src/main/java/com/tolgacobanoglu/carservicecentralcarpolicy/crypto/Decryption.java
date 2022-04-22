package com.tolgacobanoglu.carservicecentralcarpolicy.crypto;

public class Decryption
{
    /**
     *
     * @param text
     * @param index
     * @param shift
     * @return
     */
    private static char decryptChar(String text,int index,int shift)
    {
        char decryptedChar = text.charAt(index);

        if (decryptedChar >= 'a' && decryptedChar <= 'z') // case for between a and z
        {
            decryptedChar -= shift;
            if (decryptedChar < 'a')
            {
                decryptedChar = (char)((int)decryptedChar + (int)'z' - (int)'a' + 1);
            }
        }
        else if (decryptedChar >= 'A' && decryptedChar <= 'Z') // case for between A and Z
        {
            decryptedChar -= shift;
            if (decryptedChar > 'a')
            {
                decryptedChar = (char)((int)decryptedChar + (int)'Z' - (int)'A' + 1);
            }
        }

        return decryptedChar;
    }

    /**
     *
     * @param text
     * @return
     */
    public static String decryptString(String text)
    {
        StringBuilder decryptedText = new StringBuilder();
        int index;
        for (index = 0 ; index < text.length() ; index++)
        {
            decryptedText.append(decryptChar(text,index,index));
        }

        return decryptedText.toString();
    }

}
