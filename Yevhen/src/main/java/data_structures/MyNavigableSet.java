package data_structures;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public interface MyNavigableSet<T> extends MySortedSet<T> {
    T lower(T t);
    T floor(T t);
    T ceiling(T t);
    T higher(T t);
    T pollFirst();
    T pollLast();
}
