public class CaesarCipher {

    public static String encode(String s, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            boolean isLetterAndUpperCase = Character.isLetter(s.charAt(i)) && Character.isUpperCase(s.charAt(i));
            boolean isLetterAndLowerCase = Character.isLetter(s.charAt(i)) && Character.isLowerCase(s.charAt(i));
            if (s.charAt(i) >= 1040 && s.charAt(i) <= 1103) { // ru
                if (isLetterAndUpperCase)
                    builder.append(Character.toString(s.charAt(i) - 1040 + key % 32 + 1040));
                else if (isLetterAndLowerCase)
                    builder.append(Character.toString((s.charAt(i) - 1072 + key) % 32 + 1072));
            }
            else if (s.charAt(i) >= 65 && s.charAt(i) <= 90
                    || s.charAt(i) >= 97 && s.charAt(i) <= 122) { // eng
                if (isLetterAndUpperCase)
                    builder.append(Character.toString(s.charAt(i) - 65 + key % 26 + 65));
                else if (isLetterAndLowerCase)
                    builder.append(Character.toString((s.charAt(i) - 97 + key) % 26 + 97));
            }
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static String decode(String s, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            boolean isLetterAndUpperCase = Character.isLetter(s.charAt(i)) && Character.isUpperCase(s.charAt(i));
            boolean isLetterAndLowerCase = Character.isLetter(s.charAt(i)) && Character.isLowerCase(s.charAt(i));
            if (s.charAt(i) >= 1040 && s.charAt(i) <= 1103) { // ru
                if (isLetterAndUpperCase)
                    builder.append(Character.toString(s.charAt(i) - 1040 - key % 32 + 1040));
                else if (isLetterAndLowerCase)
                    if (s.charAt(i) - 1072 - key < 0)
                        builder.append(Character.toString((s.charAt(i) - 1072 - key) + 32 + 1072));
                    else
                        builder.append(Character.toString((s.charAt(i) - 1072 - key) % 32 + 1072));
            }
            else if (s.charAt(i) >= 65 &&  s.charAt(i) <= 90
                    ||  s.charAt(i) >= 97 &&  s.charAt(i) <= 122) { // eng
                if (isLetterAndUpperCase)
                    builder.append(Character.toString(s.charAt(i) - 65 - key % 26 + 65));
                else if (isLetterAndLowerCase)
                    if (s.charAt(i) - 97 - key < 0)
                        builder.append(Character.toString((s.charAt(i) - 97 - key) + 26 + 97));
                    else
                        builder.append(Character.toString((s.charAt(i) - 97 - key) % 26 + 97));
            }
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
