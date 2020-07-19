package lesson_08;

public class ObjectCollection implements Collection{
    private Object [] ar;
    private int count;

    public ObjectCollection() {
        int n = 5;
        this.initialization(n);
    }
    public ObjectCollection(int n){
        this.initialization(n);
    }

    private void initialization(int n){
        this.ar = new Object[n];
        this.count = 0;
    }

    @Override
    public int size() {
        return this.length();
    }

    @Override
    public boolean clear() {
        this.initialization(0);
        return true;
    }

    @Override
    public boolean add(Object o) {
        return this.insertNewValue(-1,o);
    }

    @Override
    public boolean add(int index, Object o) {
        return this.insertNewValue(index,o);
    }

    @Override
    public boolean delete(Object o) {
        int i = this.getIndex(o);
        if (i != -1){
            return this.arrayDelete(i);
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return this.getByIndex(index);
    }

    @Override
    public boolean contain(Object o) {
        return !(this.getIndex(o) == -1);
    }

    @Override
    public boolean equals(Collection str) {
        if (this == str) {
            return true;
        }
        if (this.length() < str.size()) {
            return false;
        }
        for (int i = 0; i < str.size(); i++){
            if (!this.contain(str.get(i))){
                return false;
            }
        }
        return true;
    }

    private int length(){
        return this.count;
    }

    public void print() {
        int stringSize = 10;
        for (int i = 0; i < this.length() ; i++) {
            String str = this.getByIndex(i).toString();
            System.out.print(str);
            if((i+1) % stringSize == 0){
                System.out.println();
            }else {
                if (i < this.length() - 1) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    private Object getByIndex(int i){
        if (i>=0 && i<this.length()){
            return this.ar[i];
        }
        else {
            System.out.println("Wrong index");
            return null;
        }
    }
    private int getIndex(Object o){
        for (int i = 0; i < this.length(); i++) {
            if (this.getByIndex(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    private boolean insertNewValue(int i, Object o){
        if(this.length() == this.ar.length){
            Object [] newAr = this.ar;
            this.initialization(this.ar.length * 3 / 2);
            for (Object ob: newAr){
                this.add(ob);
            }
        }
        return this.arrayInsert(i, o);
    }

    private boolean arrayInsert(int i, Object o){
        if (i==-1 || i == this.length()){
            this.ar[this.length()] = o;
        }
        else
        {
            for (int j = this.length(); j > i; j--) {
                this.ar[j] = this.ar[j-1];
            }
            this.ar[i] = o;
        }
        this.count++;
        return true;
    }
    private boolean arrayDelete(int i){
        if (i>=0 && i<this.length()){
            for (int j = i; j < this.length()-1; j++) {
                this.ar[j] = this.ar[j+1];
            }
            this.count--;
            return true;
        }
        else{
            System.out.println("Wrong index");
            return false;
        }
    }

}
