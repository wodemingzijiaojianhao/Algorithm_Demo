import java.util.Arrays;

public class Quick_union {
    private int[] id;
    public Quick_union (int n) {
        id = new int [n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    public int count () {
        return this.id.length;
    }
    public int root (int n) {
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
        id[rootB] = rootA;
    }
    public void printOutArray () {
        System.out.println(Arrays.toString(id));
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
        System.out.println(a.connected(0,3));
    }
}
