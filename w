//Elsie Urena
package wordcount3;

import java.util.*;
import java.io.*;
public class WordCount3 {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
      // Create a list from elements of HashMap
      List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
      // Sort the list
      Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
      	public int compare(Map.Entry<String, Integer> anything1,
                           Map.Entry<String, Integer> anything2) {
        	return (anything2.getValue()).compareTo(anything1.getValue());
        }
      });
      // put data from sorted list to hashmap
      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
      for (Map.Entry<String, Integer> anything : list) {
      	temp.put(anything.getKey(), anything.getValue());
      }
      return temp;
    }
    public static void main(String[] args) throws FileNotFoundException {
        // open the file
        java.io.File myFile;
        myFile=new java.io.File("C:\\Users\\reneg\\Desktop\\LostInLoveByAirSupply.txt");
        System.out.println("Does this file exist?"+" "+ myFile.exists());
        Scanner input = new Scanner(myFile);
        // count occurrences
        HashMap<String, Integer> Counts = new HashMap<String, Integer>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            String clean = next.replaceAll("\\p{Punct}","").toLowerCase();
            if (!Counts.containsKey(clean)) {
                // TODO: remove symbols: ), ?, etc
                Counts.put(clean, 1);
            } else {
                Counts.put(clean, Counts.get(clean) + 1);
            }
        }
        System.out.println("Total words = " + Counts.size());
        HashMap<String, Integer> sortedMapAsc = sortByValue(Counts);
        // Report frequencies
        for (String word : sortedMapAsc.keySet()) {
            int count = sortedMapAsc.get(word);
            System.out.println(count + ":\t" + word);
        }
    }
}
