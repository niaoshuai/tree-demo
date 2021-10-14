import java.util.Stack;

/**
 * 最简单的一个TreeNode
 *
 * 参考文档
 */
public class Diaobao {


    public static void main(String[] args) {
        // initData
        TreeNode root = new TreeNode(1);
        buildTreeData(root);
        // 递归先序
        System.out.println("\nroot = " + root);
        preOrder(root);
        System.out.println("\nroot = " + root);
        // 非递归先序
        preOrder2(root);
        System.out.println("\nroot = " + root);
        // 递归中序
        middleOrder(root);
        System.out.println("\nroot = " + root);
        // 非递归中序
        middleOrder2(root);
        System.out.println("\nroot = " + root);
        // 递归后序
        lastOrder(root);
        System.out.println("\nroot = " + root);
        // 非递归后续
        lastOrder2(root);


        // 思考 --------------------------
        // 1. 从递归代码最容易理解， 先序 中序 后续 主要是通过控制 调用的时机 （先序在递归前调用，中序在递归中调用，后序在递归后调用）
        // 2. 再非递归迭代中，则不容易理解，特别是后序 需要把左边，右边 树 都遍历完成

    }

    /**
     * 建议多打断点 分析
     * @param root
     */
    private static void lastOrder2(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode tmpNode = root;
        TreeNode lastVisit = root;
        while (tmpNode != null || !treeNodeStack.isEmpty()) {
            while (tmpNode != null) {
                treeNodeStack.push(tmpNode);
                tmpNode = tmpNode.left;
            }
            // 查看当前栈顶元素
            tmpNode = treeNodeStack.peek();
            if(tmpNode.right == null || tmpNode.right == lastVisit) {
                System.out.print(tmpNode.val + " ");
                treeNodeStack.pop();
                lastVisit = tmpNode;
                tmpNode = null;
            } else {
                tmpNode = tmpNode.right;
            }
        }
    }

    private static void lastOrder(TreeNode root) {
        if (root != null) {
            lastOrder(root.left);
            lastOrder(root.right);
            System.out.print(root.val + " " );
        }
    }

    /**
     * 非递归中序排列
     * @param root
     */
    private static void middleOrder2(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode tmpNode = root;
        while (tmpNode != null || !treeNodeStack.isEmpty()) {
            while (tmpNode != null) {
                treeNodeStack.push(tmpNode);
                tmpNode = tmpNode.left;
            }

            if (!treeNodeStack.isEmpty()) {
                tmpNode = treeNodeStack.pop();
                System.out.print(tmpNode.val + " ");
                tmpNode = tmpNode.right;
            }

        }
    }

    /**
     * 递归中序排列
     * @param root
     */
    private static void middleOrder(TreeNode root) {
        if (root != null) {
            middleOrder(root.left);
            System.out.print(root.val + " ");
            middleOrder(root.right);
        }
    }

    /**
     * 递归先序
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 非递归先序
     * @param root
     */
    public static void preOrder2(TreeNode root) {
        // 暂存
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 新建一个游标节点
        TreeNode tmpNode = root;
        while (tmpNode != null || !treeNodeStack.isEmpty()) {
            while (tmpNode != null) {
                System.out.print( tmpNode.val + " ");
                treeNodeStack.push(tmpNode);
                tmpNode = tmpNode.left;
            }

            if (!treeNodeStack.isEmpty()) {
                tmpNode = treeNodeStack.pop();
                tmpNode = tmpNode.right;
            }
        }
    }



    /**
     * 初始化数据
     * @param root
     */
    private static void buildTreeData(TreeNode root) {
        // ROOT LEFT
        TreeNode left_7 = new TreeNode(7);
        TreeNode right_8 = new TreeNode(8);

        TreeNode right_6 = new TreeNode(6);
        right_6.left = left_7;
        right_6.right = right_8;

        TreeNode left_4 = new TreeNode(4);
        left_4.right = right_6;

        TreeNode left_2 = new TreeNode(2);
        left_2.left = left_4;
        root.left = left_2;

        // ROOT RIGHT
        TreeNode right_5 = new TreeNode(5);
        TreeNode right_3 = new TreeNode(3);
        right_3.right = right_5;
        root.right=right_3;
    }

    /**
     * 最简单的一个树
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int initVal) {
            this.val = initVal;
        }
    }

}
