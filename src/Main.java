public class Main {
    public static void main(String[] args) {
        String s = "W Vяz";
        //System.out.println(Integer.toHexString(s.charAt(0)));

        System.out.println("Исходная строка: " + s);
        s = CaesarCipher.encode(s, 2);
        System.out.println("Закодированная строка: " + s);
        s = CaesarCipher.decode(s, 2);
        System.out.println("Декодированная строка: " + s);
    }
}
