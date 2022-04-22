package com.tolgacobanoglu.carservicecentralcarpolicy.crypto;

public class Encryption
{
    /**
     *
     * @param text
     * @param index
     * @param shift
     * @return
     */
    private static char encryptChar(String text, int index, int shift)
    {
        char encryptedChar = text.charAt(index);

        if (encryptedChar >= 'a' && encryptedChar <= 'z') // case for between a and z
        {
            encryptedChar += shift;
            if (encryptedChar > 'z')
            {
                encryptedChar = (char)((int)encryptedChar - (int)'z' + (int)'a' - 1);
            }
        }
        else if (encryptedChar >= 'A' && encryptedChar <= 'Z') // case for between A and Z
        {
            encryptedChar += shift;
            if (encryptedChar > 'Z')
            {
                encryptedChar = (char)((int)encryptedChar - (int)'Z' + (int)'A' - 1);
            }
        }

        return encryptedChar;
    }

    /**
     *
     * @param text
     * @return
     */
    public static String encryptString(String text)
    {
        StringBuilder encryptedText = new StringBuilder();
        int index;
        for (index = 0 ; index < text.length() ; index++)
        {
            encryptedText.append(encryptChar(text,index,index));
        }

        return encryptedText.toString();
    }

}
