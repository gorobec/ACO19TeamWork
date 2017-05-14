package data_structures;

import java.util.Comparator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public interface MySortedSet<T> extends MySet<T> {
    Comparator<? super T> comparator();
    T first();
    T last();
}
