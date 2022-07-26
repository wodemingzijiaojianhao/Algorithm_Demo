import java.util.Arrays;

public class Quick_union {
    private int[] id;
    private int[] size;
    public Quick_union (int n) {
        id = new int [n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }
    public int count () {
        return this.id.length;
    }
    public int root (int n) {
        if (id[n] != id[id[n]]) {
            size[id[n]] -= 1;
            id[n] = id[id[n]];
        }
        while (id[n] != n) {n = id[n];}
        return n;
    }
    public boolean connected (int a, int b) {
        return root(a) == root(b);
    }
    public void union (int a, int b) {
        int rootA = root(a);
        int rootB = root(b);
        if (rootA == rootB) {return;}
        if (size[rootA] < size[rootB]) {
            id[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            id[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }
    public void printOutArray () {
        System.out.println("id: "+Arrays.toString(id));
        System.out.println("size: "+Arrays.toString(size));
    }

    public static void main (String[] arg) {
        Quick_union a = new Quick_union(10);
        System.out.println(a.root(3));
        System.out.println(a.root(4));
        a.printOutArray();
        a.union(2,4);
        a.printOutArray();
        a.union(3,4);
        a.printOutArray();
        a.union(6,8);
        a.printOutArray();
        a.union(8,9);
        a.printOutArray();
        a.union(2,9);
        a.printOutArray();
        a.union(7,9);
        a.printOutArray();
        a.union(5,8);
        a.printOutArray();
        System.out.println(a.connected(0,3));
        System.out.println(a.connected(9,3));
    }
}
