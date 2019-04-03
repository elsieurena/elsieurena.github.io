package wordcount4;
import java.util.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.*;
public class WordCount4 {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
      // Create a list from elements of HashMap
      List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
      // Sort the list
      Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
       public int compare(Map.Entry<String, Integer> o1,
                           Map.Entry<String, Integer> o2) {
         return (o2.getValue()).compareTo(o1.getValue());
        }
      });
      // put data from sorted list to hashmap
      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
      for (Map.Entry<String, Integer> aa : list) {
       temp.put(aa.getKey(), aa.getValue());
      }
      return temp;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // open the file
        //java.io.File myFile;
        //myFile=new java.io.File("C:\\Users\\reneg\\Desktop\\LostInLoveByAirSupply.txt");
        //System.out.println("Does this file exist?"+" "+ myFile.exists());
        //Scanner input = new Scanner(myFile);
        Scanner console= new Scanner(System.in);
        String filename = "LostInLoveByAirSupply.txt";
        Scanner input = new Scanner(new File(filename));
        // count occurrences
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            String clean = next.replaceAll("\\p{Punct}","").toLowerCase();
            if (!wordCounts.containsKey(clean)) {
                // TODO: remove symbols: ), ?, etc
                wordCounts.put(clean, 1);
            } else {
                wordCounts.put(clean, wordCounts.get(clean) + 1);
            }
        }
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println("Total words = " + wordCounts.size());
        
        HashMap<String, Integer> sortedMapAsc = sortByValue(wordCounts);
        // Report frequencies
        for (String word : sortedMapAsc.keySet()) {
            int count = sortedMapAsc.get(word);
            writer.println(count + ":\t" + word);
        }
        writer.close();
   }
}