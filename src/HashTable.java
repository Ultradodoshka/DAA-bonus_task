public class HashTable {
    static class HashNode{
        int key;
        HashNode next;
        HashNode(int key){this.key=key;}
    }

    private HashNode[] table;
    private int capacity;
    private int size;
    private static final double loadFactor = 0.75;

    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new HashNode[capacity];
        this.size = 0;
    }
    public HashTable(){this(16);}

    private int hash(int key){return key%capacity;}

    public void insert(int key) {
        if((double) (size+1)/capacity>loadFactor){resize();}
        int idx=hash(key);
        HashNode curr=table[idx];
        while (curr!=null) {
            if(curr.key==key) return;
            curr=curr.next;
        }
        HashNode newNode = new HashNode(key);
        newNode.next = table[idx];
        table[idx] = newNode;
        size++;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        HashNode[] newTable = new HashNode[newCapacity];
        for(int i=0; i<capacity; i++) {
            HashNode curr=table[i];
            while (curr!=null) {
                HashNode next = curr.next;
                int newIdx=curr.key % newCapacity;
                curr.next=newTable[newIdx];
                newTable[newIdx]=curr;
                curr = next;
            }
        }
        this.table=newTable;
        this.capacity=newCapacity;
    }

    public boolean search(int key) {
        int idx = hash(key);
        HashNode curr=table[idx];
        while (curr!=null) {
            if(curr.key==key) return true;
            curr=curr.next;
        }
        return false;
    }

    public boolean delete(int key) {
        int idx = hash(key);
        HashNode curr = table[idx];
        HashNode prev = null;

        while (curr!=null) {
            if (curr.key==key) {
                if(prev==null){table[idx]=curr.next;}
                else {prev.next = curr.next;}
                size--;
                return true;
            }
            prev=curr;
            curr=curr.next;
        }
        return false;
    }
}
