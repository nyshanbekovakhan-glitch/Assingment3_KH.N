import java.util.*;

public class BinarySearchTree<K extends Comparable<K>,V> implements Iterable<BinarySearchTree.Node<K,V>>{
    public static class Node<K,V>{
        K key;
        V value;
        Node<K,V> left,right;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
    private Node<K,V> root;
    private int size;
    public int size(){
        return size;
    }
    public void put(K key,V value){
        if(root == null){
            root = new Node<>(key,value);
            size++;
            return;
        }
        Node<K,V> current = root;
        while(current != null){
            int cmp = key.compareTo(current.getKey());
            if(cmp < 0){
                if(current.left == null){
                    current.left = new Node<>(key,value);
                    size++;
                    return;
                }
                current = current.left;
            }else if(cmp > 0){
                if(current.right == null){
                    current.right = new Node<>(key,value);
                    size++;
                    return;
                }
                current = current.right;
            }else{
                current.value = value;
                return;
            }
        }
    }
    @Override
    public Iterator<Node<K,V>> iterator(){
        List<Node<K,V>> list = new ArrayList<>();
        Stack<Node<K,V>> stack = new Stack<>();
        Node<K,V> current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current);
            current = current.right;
        }
        return list.iterator();
    }
}
