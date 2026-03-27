package collections;

public class CharacterDemo {

    public static void main(String[] args) {

        String string = "Hello";
        char[] ch = string.toCharArray();
        char cha = ch[0];

        System.out.println(Character.isAlphabetic(cha));
    }
}
