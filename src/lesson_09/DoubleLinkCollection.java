package lesson_09;

public class DoubleLinkCollection implements CustomCollection{
    private int size;
    private Node first;
    private Node last;
    @Override
    public boolean add(String str) {
        addLast(str);
        return true;
    }
    @Override
    public boolean addAll(String[] strArr) {
        for (String str : strArr) {
            addLast(str);
        }
        return true;
    }
    @Override
    public boolean addAll(DoubleLinkCollection strColl) {
        Node current = strColl.first;
        while (current != null){
            add(current.value);
            current = current.next;
        }
        return true;
    }
    @Override
    public boolean delete(int index) {
        Node mustDie = getByIndex(index);
        if(mustDie == null) {
            return false;
        }
        killNode(mustDie);
        return true;
    }
    @Override
    public boolean delete(String str) {
        Node mustDie = getByValue(str);
        if(mustDie == null) {
            return false;
        }
        killNode(mustDie);
        return true;
    }
    @Override
    public String get(int index) {
        Node ob = getByIndex(index);
        if (ob == null) {
            return null;
        }
        return ob.value;
    }
    @Override
    public boolean contains(String str) {
        Node current = first;
        while (current != null){
            if (current.value == str) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public boolean clear() {
        while (!isEmpty()) {
            deleteLast();
        }
        return true;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean trim() {
        while (contains((String) null)) {
            delete((String) null);
        }
        return true;
    }
    @Override
    public boolean compare(DoubleLinkCollection coll) {
        if(size != coll.size()){
            return false;
        }
        Node current = first;
        Node currentColl = coll.first;
        while (current != null){
            if (current.value != currentColl.value) {
                return false;
            }
            current = current.next;
            currentColl = currentColl.next;
        }
        return true;
    }
    private static class Node {
        String value;
        Node next;
        Node perv;
        public Node (Node perv, String s, Node next){
            this.value = s;
            this.next = next;
            this.perv = perv;
        }
        @Override
        public String toString() {
            return value;
        }
    }
    private void addLast(String s){
        Node last = this.last;
        Node newElement = new Node(last, s, (DoubleLinkCollection.Node) null);
        this.last = newElement;
        if(last == null){
            this.first = newElement;
        } else {
            last.next = newElement;
        }
        ++size;
    }
    private void deleteLast(){
        killNode(last);
    }
    private Node getByIndex(int index){
        if ((index < 0) || index > size-1) {
            return null;
        }
        Node current = first;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current;
    }
    private Node getByValue(String str) {
        Node current = first;
        while (current != null){
            if (current.value == str) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    private void killNode(Node ob){
        if(ob != null) {
            if (ob != first) {
                ob.perv.next = ob.next;
            }
            else {
                first = ob.next;
            }
            if (ob!= last){
                ob.next.perv = ob.perv;
            }
            else {
                last = ob.perv;
            }
            ob.value = null;
            ob.next = null;
            ob.perv = null;
            --size;
        }
    }
    private boolean isEmpty(){
        return size == 0;
    }
}