package crossword;

import java.util.Comparator;

public class WordCoordinateComparator implements Comparator<WordCoordinate> {

    @Override
    public int compare(WordCoordinate o1, WordCoordinate o2) {
        return o2.getScore() - o1.getScore();
    }
}
