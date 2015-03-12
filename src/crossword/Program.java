package crossword;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Grid grid = new Grid(12,12);
        WordsDic dic = new WordsDic();

        List<String> words = new ArrayList<String>(dic.getDictionary().keySet());

        Generator gen = new Generator(grid, words);

        int usedCount = gen.generate();
        grid.show();

        Hashtable<Integer, List<String>> horizontalAnnex = gen.getHorizontalAnnex();
        Hashtable<Integer, List<String>> verticalAnnex = gen.getVerticalAnnex();

        System.out.println("Used : ( " + usedCount + " / " + words.size() + " )");
        System.out.println("Horizontal annex :");
        printAnnex(horizontalAnnex, dic);
        System.out.println("Vertical annex :");
        printAnnex(verticalAnnex, dic);

    }

    private static void printAnnex(Hashtable<Integer, List<String>> annex, WordsDic dic){

        List<Integer> list = new ArrayList<Integer>(annex.keySet());
        Collections.sort(list);

        for(Integer key : list){

            System.out.print(key + " : ");

            for(String word : annex.get(key)){
                System.out.print(dic.getDictionary().get(word) + " | ");
            }

            System.out.println();
        }
    }
}
