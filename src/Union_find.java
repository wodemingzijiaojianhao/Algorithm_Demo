import java.util.Arrays;

public class Union_find {
    private int[] id;
    public Union_find (int n) {
        id = new int [n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    public int count () {
        return this.id.length;
    }
    public int find(int a) {
        return id[a];
    }
    public boolean connected (int a, int b) {
        return find(a) == find(b);
    }
    public void union (int a, int b) {
        int idA = id[a];
        int idB = id[b];
        if (idA == idB) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i] == idB) {
                id[i] = idA;
            }
        }
    }
    public void printOutArray () {
        System.out.println(Arrays.toString(id));
    }

}
