import java.util.*;

public class WinnerTree {

    static int[] tree;
    static int n;

    // build winner tree
    static void build(int[] arr) {
        n = arr.length;
        tree = new int[2 * n];

        // put elements as leaves
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }

        // build internal nodes
        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }

    // get winner (min)
    static int getWinner() {
        return tree[1];
    }

    // update a value
    static void update(int index, int value) {
        int i = n + index;
        tree[i] = value;

        // update upwards
        while (i > 1) {
            i = i / 2;
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 6};

        build(arr);

        System.out.println("Winner (min): " + getWinner());

        update(3, 10); // change value at index 3

        System.out.println("Winner after update: " + getWinner());
    }
}
