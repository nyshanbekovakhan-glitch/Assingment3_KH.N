public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(11);
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i, "name" + i);
            table.put(key, "value" + i);
        }
        System.out.println("Total size: " + table.size());
        table.printBuckets();
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(5, "A");
        tree.put(2, "B");
        tree.put(8, "C");
        tree.put(1, "D");
        tree.put(3, "E");
        System.out.println("\nBST size: " + tree.size());
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() +
                    " and value is " + elem.getValue());
        }
    }
}