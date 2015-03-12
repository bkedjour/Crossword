package crossword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsDic {

    private Hashtable<String, String> dictionary;

    public WordsDic(){

        dictionary = new Hashtable<String, String>();

        try{

            readDictionary();

        } catch (IOException e) {

            dictionary = new Hashtable<String, String>();
        }
    }

    private void readDictionary() throws IOException{

        String fileName = "dictionary.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str;

        while ((str=reader.readLine()) != null) {

            String[] line = str.split(";");

            dictionary.put(line[0].trim(), line[1].trim());
        }
        reader.close();
    }

    public Hashtable<String, String> getDictionary() {
        return dictionary;
    }

}
