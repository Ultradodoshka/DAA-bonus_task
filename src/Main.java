import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] testSizes={100,1000,10000};
        Random random =new Random();
        for (int n : testSizes) {
            int[] data = random.ints(n, 1, n * 10).distinct().toArray();

            BST bst = new BST();
            long t0 = System.nanoTime();
            for (int x : data) bst.insert(x);
            double bstInsert = (System.nanoTime() - t0) / 1e6;

            t0 = System.nanoTime();
            for (int x : data) bst.search(x);
            double bstSearch = (System.nanoTime() - t0) / 1e6;

            t0 = System.nanoTime();
            for (int x : data) bst.delete(x);
            double bstDelete = (System.nanoTime() - t0) / 1e6;

            System.out.println("Size: "+n+" | Binary Search Tree | Insert(ms):"+bstInsert+" |  Search(ms):"+bstSearch+" | Delete(ms):"+bstDelete);

            // Benchmark Hash Table
            HashTable ht = new HashTable();
            t0 = System.nanoTime();
            for (int x : data) ht.insert(x);
            double htInsert = (System.nanoTime() - t0) / 1e6;

            t0 = System.nanoTime();
            for (int x : data) ht.search(x);
            double htSearch = (System.nanoTime() - t0) / 1e6;

            t0 = System.nanoTime();
            for (int x : data) ht.delete(x);
            double htDelete = (System.nanoTime() - t0) / 1e6;

            System.out.println("Size: "+n+" | Hash Table | Insert(ms):"+htInsert+" |  Search(ms):"+htSearch+" | Delete(ms):"+htDelete);
            System.out.println();
        }
    }
}
