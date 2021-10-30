public class Crypto
{
    public static char
    encryptChar(String text,int index,int shift)
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


    public static String
    encryptText(String text)
    {
        StringBuilder encryptedText = new StringBuilder();
        int index;
        for (index = 0 ; index < text.length() ; index++)
        {
            encryptedText.append(encryptChar(text,index,index));
        }

        return encryptedText.toString();
    }

    public static char
    decryptChar(String text,int index,int shift)
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

    public static String
    decryptText(String text)
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
