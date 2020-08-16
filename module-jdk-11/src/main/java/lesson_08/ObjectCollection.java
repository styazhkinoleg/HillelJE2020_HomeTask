package lesson_08;

public class ObjectCollection implements Collection{
    private Object [] ar;
    private int count;

    public ObjectCollection() {
        int n = 5;
        initialization(n);
    }
    public ObjectCollection(int n){
        initialization(n);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean clear() {
        initialization(0);
        return true;
    }

    @Override
    public boolean add(Object o) {
        return insertNewValue(-1,o);
    }

    @Override
    public boolean add(int index, Object o) {
        return insertNewValue(index,o);
    }

    @Override
    public boolean delete(Object o) {
        int i = getIndex(o);
        if (i != -1){
            return arrayDelete(i);
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return getByIndex(index);
    }

    @Override
    public boolean contain(Object o) {
        return !(getIndex(o) == -1);
    }

    @Override
    public boolean equals(Collection str) {
        if (this == str) {
            return true;
        }
        if (count < str.size()) {
            return false;
        }
        for (int i = 0; i < str.size(); i++){
            if (get(i) != str.get(i)){
                return false;
            }
        }
        return true;
    }

    public void print() {
        int stringSize = 10;
        for (int i = 0; i < count ; i++) {
            String str = getByIndex(i).toString();
            System.out.print(str);
            if((i+1) % stringSize == 0){
                System.out.println();
            }else {
                if (i < count - 1) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    private void initialization(int n){
        ar = new Object[n];
        count = 0;
    }

    private Object getByIndex(int i){
        if (i>=0 && i<count){
            return ar[i];
        }
        else {
            System.out.println("Wrong index");
            return null;
        }
    }
    private int getIndex(Object o){
        for (int i = 0; i < count; i++) {
            if (getByIndex(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    private boolean insertNewValue(int i, Object o){
        if(count == ar.length){
            Object [] newAr = ar;
            initialization(ar.length * 3 / 2 + 1);
            for (Object ob: newAr){
                add(ob);
            }
        }
        return arrayInsert(i, o);
    }

    private boolean arrayInsert(int i, Object o){
        if (i==-1 || i == count){
            ar[count] = o;
        }
        else
        {
            for (int j = count; j > i; j--) {
                ar[j] = ar[j-1];
            }
            ar[i] = o;
        }
        count++;
        return true;
    }
    private boolean arrayDelete(int i){
        if (i>=0 && i<count){
            for (int j = i; j < count-1; j++) {
                ar[j] = ar[j+1];
            }
            count--;
            return true;
        }
        else{
            System.out.println("Wrong index");
            return false;
        }
    }

}
