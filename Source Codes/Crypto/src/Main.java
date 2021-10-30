public class Main
{
    public static void main(String[] args)
    {
        String x = "ABCDZ";
        String y = "abcdz";

        System.out.println(y);
        System.out.println(Crypto.encryptText(y));
        System.out.println(Crypto.decryptText(Crypto.encryptText(y)));
    }
}