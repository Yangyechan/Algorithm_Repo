package algorithm.tree;

public class TreeTraverse {
    private int nodes;
    private int[] arr;

    // {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11}
    public void setArr(int[] arr) {
        this.arr = arr;
        this.nodes = nodes;
    }

    // 전위 순회 V -> L -> R
    // preorder(): System.out.print(V) -> preorder(L) -> preorder(R)
    public void travelPreorder(int node) {
        if (node < this.nodes && arr[node] != 0) {
            System.out.println(arr[node] + ", ");
            this.travelPreorder(node * 2);
            this.travelPreorder(node * 2 + 1);
        }
    }

    public static void main(String[] args) {
        TreeTraverse tree = new TreeTraverse();
        tree.setArr(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11});

        tree.travelPreorder(1);
        System.out.println();
    }
}
