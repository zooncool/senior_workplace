package src.java.basic.practice.other;

/**
 * Created by linzh on 2016/7/5.
 */
public abstract class AbstractCollectionTest implements  CollectionTest<String>{
    public abstract boolean contains(String s);
}

class AbstractCollectionTestDemo extends AbstractCollectionTest{


    public boolean contains(String s) {
        return false;
    }

    @Override
    public int size(int i) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(String s) {
        return false;
    }

    @Override
    public boolean remove(String s) {
        return false;
    }

}
