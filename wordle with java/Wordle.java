import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class Wordle {
    public static void main(String[] args) {
        Random random = new Random();
        String[] words = new String[2317];
        int index = 0;
        File file = new File("dict.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String word = scan.nextLine();
                words[index] = word;
                index += 1;
            }
            scan.close();
        }catch (FileNotFoundException error) {
            System.out.println("There is no file");
            error.printStackTrace();
        }
        // In here, being random I took a word from our words array.
        int indexOfKeyWord = random.nextInt(words.length);
        String keyWord = words[indexOfKeyWord];
        for (int i = 0; i < args.length;i++) {
            args[i] = args[i].toUpperCase();
        }
        int numberTry = 1;
        String[] counters = new String[]{"st","nd","rd","th","th","th"};
        // *** I used the args array directly without assigning the 6 words we received from the user to a new array. ***
        for (int i = 0; i < 7; i++) {
            if(i == 6) {
                System.out.println("You exceeded maximum try shot!");
                System.out.println("You failed! The key word is "+keyWord+".");
            }
            else {
                if (args[i].length() != 5) {
                    System.out.println("Try" + numberTry + " (" + args[i] + "): The length of word must be five!");
                    numberTry += 1;
                } else if (args[i].length() == 5) {
                    boolean check = false; // I used it to check if the word is in the words array.
                    for (int x = 0; x < words.length; ++x) {
                        if (args[i].equals(words[x])) {
                            check = true;
                        }
                    }
                    if (!check) {
                        System.out.println("Try" + numberTry + " (" + args[i] + "): The word does not exist in the dictionary!");
                        numberTry += 1;
                    } else {
                        if (args[i].equals(keyWord)) {
                            System.out.println("Try" + numberTry + " (" + args[i] + "): Congratulations! You guess right in " + numberTry + counters[numberTry - 1] + " shot!");
                            break;
                        } else {
                            System.out.println("Try" + numberTry + " (" + args[i] + "):");
                            numberTry += 1;
                            for (int k = 0; k < keyWord.length(); k++) {
                                //I wrote this code block to help me check letters one by one.
                                String letterKeyWord = String.valueOf(keyWord.charAt(k));
                                String letterOurWord = String.valueOf(args[i].charAt(k));
                                if ((keyWord.contains(letterOurWord)) && (letterOurWord.equals(letterKeyWord))) {
                                    System.out.println((k + 1) + ". letter exists and located in right position.");
                                } else if ((keyWord.contains(letterOurWord))) {
                                    System.out.println((k + 1) + ". letter exists but located in wrong position.");
                                } else {
                                    System.out.println((k + 1) + ". letter does not exist.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}