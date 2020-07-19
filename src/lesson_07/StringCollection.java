package lesson_07;

public class StringCollection {
    private String [] ar;
    private int count;

    public StringCollection() {
        int n = 5;
        this.initialization(n);
    }
    public StringCollection(int n){
        this.initialization(n);
    }

    private void initialization(int n){
        this.ar = new String[n];
        this.count = 0;
    }

    public int length(){
        return this.count;
    }

    public void print() {
        int stringSize = 10;
        for (int i = 0; i < this.length() ; i++) {
            System.out.print(this.getByIndex(i));
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

    public String getByIndex(int i){
        if (i>=0 && i<this.length()){
            return this.ar[i];
        }
        else {
            System.out.println("Wrong index");
            return "";
        }
    }
    public int getIndex(String value){
        for (int i = 0; i < this.length(); i++) {
            if (this.getByIndex(i) == value) {
                return i;
            }
        }
        return -1;
    }

    public void add(String value){
        this.insertNewValue(-1,value);
    }
    public void add(int i, String value){
        this.insertNewValue(i,value);
    }
    public void delete(int i){
        arrayDelete(i);
    }
    public void delete(String value){
        int i = this.getIndex(value);
        if (i != -1){
            this.delete(i);
        }
    }

    private void insertNewValue(int i, String value){
        if(this.length() == this.ar.length){
            String [] newAr = this.ar;
            this.initialization(this.ar.length * 3 / 2);
            for (String st: newAr){
                this.add(st);
            }
        }
        this.arrayInsert(i, value);
    }

    private void arrayInsert(int i, String value){
        if (i==-1 || i == this.length()){
            this.ar[this.length()] = value;
        }
        else
        {
            for (int j = this.length(); j > i; j--) {
                this.ar[j] = this.ar[j-1];
            }
            this.ar[i] = value;
        }
        this.count++;
    }
    private void arrayDelete(int i){
        if (i>=0 && i<this.length()){
            for (int j = i; j < this.length()-1; j++) {
                this.ar[j] = this.ar[j+1];
            }
            this.count--;
        }
        else{
            System.out.println("Wrong index");
        }
    }

}
