package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {

    Map<String, Integer> wordsCounter;

    public String wordsCount(File f) {
        try {
            //String result = "";
            wordsCounter = new HashMap<>();  // initialize a new hashmap
            Scanner fileRead = new Scanner(f);
            while (fileRead.hasNext()) { // iter thru the file
                String currWord = fileRead.next().replaceAll("[^a-zA-Z0-9]", "");
                //System.out.println(currWord);
                if (!wordsCounter.containsKey(currWord)) {  // if it doesnt contain the current word add it to hashmap with count = 1
                    wordsCounter.put(currWord, 1);
                } else {    // if it does contain the word, increment count
                    int count = wordsCounter.get(currWord);
                    wordsCounter.put(currWord, count + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // at the end, return a string with all
        //System.out.println(wordsCounter.entrySet());
        return String.valueOf(wordsCounter.entrySet());
    }

    public String abcOrder() {
        String result = ""; // empty string
        ArrayList<String> sorted = new ArrayList<String>(wordsCounter.keySet()); // put a key set into a arraylist
        Collections.sort(sorted); // sort the arraylist
        for (String word : sorted) {
            result += String.format("Appeared %d times\n", wordsCounter.get(word));
        }
        return result;
    }

    public String uniqueWords(){
        String result = ""; // empty string
        ArrayList<String> words = new ArrayList<String>(wordsCounter.keySet()); // put a key set into a arraylist
        for (String word : words) {
            result += String.format("Appeared %d times\n", wordsCounter.get(word));
        }
        return result;
    }

    public int mostFreq(){   // what happens if the mroe than one word have the most frequency?
        int mostFreq = 0;
        ArrayList<String> words = new ArrayList<String>(wordsCounter.keySet()); // put a key set into a arraylist
        for (String word : words) {
            if (wordsCounter.get(word) > mostFreq){
                mostFreq = wordsCounter.get(word);
            }
        }
        return mostFreq;
    }

    public int leastFreq(){     // what happens if the mroe than one word have the least frequency?
        Integer leastFreq = Integer.MAX_VALUE;
        ArrayList<String> leastFreqWords = new ArrayList<>();
        ArrayList<String> words = new ArrayList<String>(wordsCounter.keySet()); // put a key set into a arraylist
        for (String word : words) {
            if (wordsCounter.get(word) < leastFreq){
                leastFreq = wordsCounter.get(word);
            }
        }
        return leastFreq;
    }

    public static void main(String[] args) {

        WordCounter wc = new WordCounter();
        File myObj = new File("TheModernPrometheus.txt");
        System.out.println(wc.wordsCount(myObj));
        //System.out.println(wc.abcOrder()+"\n\n\n---------------\n");
        System.out.println(wc.uniqueWords());
        System.out.printf("most frequent word is: %s appearing %d times\n",
                wc.wordsCounter.get(wc.mostFreq()), wc.mostFreq());
        System.out.printf("least frequent word is: %s appearing %d times\n",
                wc.wordsCounter.get(wc.leastFreq()), wc.leastFreq());

    }
}



// HOW DOES A BASTARD, ORPHAN, SON OF A WHORE, AND A SCOTSMAN
// DROPPED IN THE MIDDLE OF A FORGOTTEN SPOT IN THE CARIBBEAN
// THROUGH POVERISH AND SQUALER, GROW UP TO BE A HERO AND A SCHOLAR?

// THE TEN DOLLAR, FOUNDING FATHER, WITHOUT A FATHER,
// GOT A LOT FARTHER, BY WORKING A LOT HARDER, BY BEING ALOT SMARTER, BY BEING A SELF STARTER
// BY FOURTEEN, THEY PLACED HIM IN CHARGE OF A TRADING CHARTER










