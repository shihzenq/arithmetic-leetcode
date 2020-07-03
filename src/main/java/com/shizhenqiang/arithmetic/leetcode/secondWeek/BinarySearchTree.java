package com.shizhenqiang.arithmetic.leetcode.secondWeek;

import java.util.Objects;

/**
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<T>> {

    // 根节点
     BinaryNodeTree<T> mRoot;


    public class BinaryNodeTree<T extends Comparable<T>> {
         T key;

         BinaryNodeTree<T> left;
         BinaryNodeTree<T> right;
         BinaryNodeTree<T> parent;

        public BinaryNodeTree(T key, BinaryNodeTree<T> left, BinaryNodeTree<T> right, BinaryNodeTree<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "key：" + key;
        }
    }

    public BinarySearchTree() {
        mRoot = null;
    }


    /**
     * 前序遍历二叉树
     *
     * @param tree
     */
    private void preOrder(BinaryNodeTree<T> tree) {
        if (Objects.nonNull(tree)) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    private void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 中序遍历
     *
     * @param tree
     */
    private void inOrder(BinaryNodeTree<T> tree) {
        if (Objects.nonNull(tree)) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    private void inOrder() {
        inOrder(mRoot);
    }


    /**
     * 后序遍历
     *
     * @param tree
     */
    private void postOrder(BinaryNodeTree<T> tree) {
        if (Objects.nonNull(tree)) {
            inOrder(tree.left);
            inOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    private void postOrder() {
        preOrder(mRoot);
    }


    /**
     * 递归实现查找二叉树 x中键值为key的节点
     *
     * @param x
     * @param key
     * @return
     */
    private BinaryNodeTree<T> search(BinaryNodeTree<T> x, T key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        } else if (cmp > 0) {
            return search(x.right, key);
        } else return x;
    }

    public BinaryNodeTree<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * 非递归查找二叉树 x中键值为key的节点
     *
     * @param x
     * @param key
     * @return
     */
    public BinaryNodeTree<T> iterativeSearch(BinaryNodeTree<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return null;
    }

    private BinaryNodeTree<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找最小的节点
     *
     * @param tree
     * @return
     */
    private BinaryNodeTree<T> minNode(BinaryNodeTree<T> tree) {
        if (tree == null) {
            return null;
        }

        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public T minNode() {
        BinaryNodeTree<T> tBinaryNodeTree = minNode(mRoot);
        if (null != tBinaryNodeTree) {
            return tBinaryNodeTree.key;
        }
        return null;
    }


    /**
     * 查找最大的节点
     *
     * @param tree
     * @return
     */
    private BinaryNodeTree<T> maxNode(BinaryNodeTree<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    public T maxNode() {
        BinaryNodeTree<T> tBinaryNodeTree = maxNode(mRoot);
        if (null != tBinaryNodeTree) {
            return tBinaryNodeTree.key;
        }
        return null;
    }

    /**
     * 找节点（X）的后继节点，查找 二叉树中数据值大于该节点的最小节点
     *
     * @param x
     * @return
     */
    public BinaryNodeTree<T> successor(BinaryNodeTree<T> x) {
        if (x.right != null) {
            return minNode(x.right);
        }

        /**
         * 如果x没有右孩子，则x有以下两种可能：
         * 1、x是左孩子，则x的后继节点为它的父节点
         * 2、x是右孩子，则查找x的最低的父节点，并且该父节点要具有左孩子，找到这个最低的父节点就是x的后继节点
         */
        BinaryNodeTree<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 找节点x的前驱节点，查找二叉树中数据值小于该节点的最大节点
     *
     * @param x
     * @return
     */
    public BinaryNodeTree<T> predecessor(BinaryNodeTree<T> x) {
        // 如果x存在左孩子，则x的前驱节点为以其左孩子为根的子树的最大节点
        if (x.left != null) {
            return maxNode(x.left);
        }
        /**
         * 如果x没有左孩子，则x有以下两种可能
         * 1、x 是一个右孩子，则x的前驱节点为它的父节点
         * 2、x是一个左孩子，则查找的x的最低的父节点，并且没有该父节点要具有右孩子，找到的这个最低的父节点就是x的前驱节点。
         */
        BinaryNodeTree<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }


    /**
     * 将节点插入到二叉树中
     *
     * @param bst
     * @param z   插入的节点
     */
    private void insert(BinarySearchTree<T> bst, BinaryNodeTree<T> z) {
        int cmp;
        BinaryNodeTree<T> y = null;
        BinaryNodeTree<T> x = bst.mRoot;
        while (x != null) {
            y = x;
            cmp = z.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else x = x.right;
        }

        z.parent = y;
        if (y == null) {
            bst.mRoot = z;
        } else {
            cmp = z.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = z;
            } else y.right = z;
        }
    }

    /**
     * 新建节点，并将其插入到二叉树中
     *
     * @param key
     */
    public void insert(T key) {
        BinaryNodeTree<T> z = new BinaryNodeTree<T>(key, null, null, null);
        // 如果新建节点失败，则返回
        if (z != null) {
            insert(this, z);
        }
    }

    //删除指定的值
    public void delete(T key) {
        //获取要删除的节点
        BinaryNodeTree<T> node = search(mRoot, key);
        //如果存在就删除
        if (node!= null)
            delete(node);
    }

    private BinaryNodeTree<T> delete(BinaryNodeTree<T> node) {
        //第 3 种情况，如果同时存在左右子节点
        if (node.left != null && node.right != null){
            //获取后继结点
            BinaryNodeTree<T> successor = successor(node);
            //转移后继结点值到当前节点
            node.key = successor.key;
            //把要删除的当前节点设置为后继结点
            node = successor;
        }
        //经过前一步处理，下面只有前两种情况，只能是一个节点或者没有节点
        //不管是否有子节点，都获取子节点
        BinaryNodeTree<T> child;
        if (node.left != null)
            child = node.left;
        else
            child = node.right;
        //如果 child != null，就说明是有一个节点的情况
        if (child != null)
            //将子节点和父节点关联上
            child.parent = node.parent;
        //如果当前节点没有父节点（后继情况到这儿时一定有父节点）
        //说明要删除的就是根节点
        if (node.parent == null)
            //根节点设置为子节点
            //按照前面逻辑，根只有一个或者没有节点，所以直接赋值 child 即可
            mRoot = child;
        else if (node == node.parent.left)//存在父节点，并且当前节点是左节点时
            //将父节点的左节点设置为 child
            node.parent.left = child;
        else//右节点时
            //将父节点的右节点设置为 child
            node.parent.right = child;
        //返回被删除的节点
        return node;
    }

    /*
     * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明：
     *     bst 二叉树
     *     z 删除的结点
     */
    private BinaryNodeTree<T> remove(BinarySearchTree<T> bst, BinaryNodeTree<T> z) {
        // x 就是子节点 child
        BinaryNodeTree<T> x = null;
        //这里的 y 节点就是要删除的节点 delete
        BinaryNodeTree<T> y = null;
        //这个写法理解比较绕，不如反转后容易理解
        //只有一个节点或者没有节点时
        if ((z.left == null) || (z.right == null))
            //z 就是要删除的节点
            y = z;
        else
            //当有两个子节点时，删除后继结点
            y = successor(z);
        //获取子节点，不管是左是右
        if (y.left != null)
            x = y.left;
        else
            x = y.right;
        //如果存在子节点，就关联被删节点的父节点
        if (x != null)
            x.parent = y.parent;
        //如果父节点是空，说明要删的是根节点
        if (y.parent == null)
            //设置根为 child（此时根只有一个或没有节点）
            bst.mRoot = x;
        else if (y == y.parent.left)//要删的是左节点
            y.parent.left = x;//左节点关联子节点
        else//要删的是右节点
            y.parent.right = x;//右节点关联子节点
        //如果要删的节点和一开始传入的不一样，就是后继的情况
        if (y != z)
            z.key = y.key;//后继的值传给本来要删除的节点
        //返回被删除的节点
        return y;
    }

    /*
     * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明：
     *     tree 二叉树的根结点
     *     z 删除的结点
     */
    public void remove(T key) {
        BinaryNodeTree<T> z, node;

        if ((z = search(mRoot, key)) != null)
            if ((node = remove(this, z)) != null)
                node = null;
    }

    /*
     * 销毁二叉树
     */
    private void destroy(BinaryNodeTree<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(BinaryNodeTree<T> tree, T key, int direction) {

        if (tree != null) {

            if (direction == 0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }


}
