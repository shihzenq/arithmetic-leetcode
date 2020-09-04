package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day49;

public class UnionFind {

    private int count = 0;
    private int [] parent;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i =0; i < n; i ++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    public int getCount() {
        return count;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
