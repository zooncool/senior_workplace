package src.java.basic.practice.other;

/**
 * Created by linzh on 2016/7/5.
 */
public interface CollectionTest<E> {

    int size(int i);

    boolean isEmpty();

    boolean add(E e);

    boolean remove(E e);

    default void clear(){
        System.out.println("are u killing me");
    };
}
