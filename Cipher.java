/*
* Stefanie Elling
* CSCI 221
* Dr. McCauley
*
* I certify that this is my own personal work,
* but I did receive assistance from tutors in the CS Lab.
*
* This project decodes different types of substitution ciphers.
 *  Class that encodes and decodes individual characters using the "Caesar cipher".
 *    @author Dave Reed
 */
import java.util.*;
public class Cipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static String KEY; //= "defghijklmnopqrstuvwxyzabc";
    //private static int count = 0;

    /**
     *  Constructs a Cipher object.
     */
    public Cipher() {
        // currently, does nothing
        // to  be modified in part 2
        KEY = "defghijklmnopqrstuvwxyzabc";

    }

    public Cipher(String key){
        KEY = key;
    }
    /**
     * Encodes a single character.
     *   @param ch the character to be encoded
     *   @return the character three later in the alphabet, with wrap-around
     */
    public char encode(char ch) {
        if (!Character.isLetter(ch)){
            rotate(true);
            //count++;
            return ch;
        }
        if (Character.isLetter(ch) && Character.isUpperCase(ch)){
            char temp = Character.toLowerCase(ch);
            int index = Cipher.ALPHABET.indexOf(temp);
            rotate(true);
            //count++;
            return Character.toUpperCase(Cipher.KEY.charAt(index));
        }
        int index = Cipher.ALPHABET.indexOf(ch);
        rotate(true);
        //count++;
        return Cipher.KEY.charAt(index);
    }

    /**
     * Decodes a single character.
     *   @param ch the character to be decoded
     *   @return the character three earlier in the alphabet, with wrap-around
     */
    public char decode(char ch) {
        //while (count > 1){
         //   rotate(false);
         //   count--;
        //}
        if (!Character.isLetter(ch)){
            rotate(true);
            return ch;
        }
        if (Character.isLetter(ch) && Character.isUpperCase(ch)){
            char temp = Character.toLowerCase(ch);
            int index = Cipher.KEY.indexOf(temp);
            rotate(true);
            return Character.toUpperCase(Cipher.ALPHABET.charAt(index));
        }
        int index = Cipher.KEY.indexOf(ch);
        rotate(true);
        return Cipher.ALPHABET.charAt(index);
    }

    private void rotate (boolean forward) {
        if (forward) {
            char temp = KEY.charAt(0);
            KEY = KEY.substring(1, 26);
            KEY = KEY + temp;
        }
        if (!forward) {
            char temp = KEY.charAt(25);
            KEY = KEY.substring(0, 25);
            KEY = temp + KEY;
        }
    }

    /* Used for my own testing purposes - files weren't being read through the Encrypt
    public static void main (String [] args) {
        Cipher cipher = new Cipher("qwertyuiopasdfghjklzxcvbnm");
        System.out.println(ALPHABET);
        System.out.println(KEY);
        Scanner input = new Scanner(System.in);
        System.out.println("Type in a message: ");
        String message = input.nextLine();

        int i;
        *//*for (i = 0; i < message.length(); i++){
            System.out.println(cipher.encode(message.charAt(i)));
            System.out.println(KEY);
        }*//*
        //System.out.println(secret);
           *//* for (i = 0; i < message.length(); i++){
            System.out.println(cipher.decode(message.charAt(i)));
            System.out.println(KEY);}
        }*/
    }

