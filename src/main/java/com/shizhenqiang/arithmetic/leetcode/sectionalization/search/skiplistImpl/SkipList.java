package com.shizhenqiang.arithmetic.leetcode.sectionalization.search.skiplistImpl;

import java.util.Random;

/**
 * https://blog.csdn.net/bohu83/article/details/83654524
 * @param <T>
 */
public class SkipList<T> {

    //  number of entries in the Skip List
    public int n;
    // height
    public int h;
    // 表头
    private SkipListEntry head;
    // 表尾
    private SkipListEntry tail;
    // 生成randomLevel用到的概率值
    private Random r;

    public SkipList() {

        head = new SkipListEntry(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new SkipListEntry(Integer.MAX_VALUE, Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
        n = 0;
        h = 0;
        r = new Random();
    }

    /**
     * 查找
     *
     * @param key
     * @return
     */
    public SkipListEntry findEntry(Integer key) {
        SkipListEntry p;

       /* -----------------
  	   Start at "head"
  	   ----------------- */
        p = head;

        while (true) {
          /* --------------------------------------------
  	   Search RIGHT until you find a LARGER entry
             E.g.: k = 34
                       10 ---> 20 ---> 30 ---> 40
                                        ^
                                        |
                                        p stops here
  		p.right.key = 40
  	   -------------------------------------------- */
            while (p.right.key != Integer.MAX_VALUE && p.right.key < key) {
                p = p.right;
                //    System.out.println(">>>> " + p.key);
            }

  	/* ---------------------------------
  	   Go down one level if you can...
  	   --------------------------------- */
            if (p.down != null) {
                p = p.down;
                // System.out.println("vvvv " + p.key);
            } else
                break;    // We reached the LOWEST level... Exit...
        }

        return (p);         // p.key <= k
    }

    public Integer get(int key) {

        SkipListEntry p;

        p = findEntry(key);

        if (p.key == key) {
            return p.value;
        } else {
            return null;
        }

    }

    public Integer insert(int key, int value) {
        SkipListEntry p, q;
        int i = 0;

        // 查找适合插入的位子
        p = findEntry(key);

        // 如果跳跃表中存在含有key值的节点，则进行value的修改操作即可完成
        if (p.key == key) {
            Integer oldValue = p.value;
            p.value = value;
            return oldValue;
        }

        // 如果跳跃表中不存在含有key值的节点，则进行新增操作
        q = new SkipListEntry(key, value);
        /* --------------------------------------------------------------
        Insert q into the lowest level after SkipListEntry p:
                         p   put q here           p        q
                         |     |                  |        |
	 	                 V     V                  V        V        V
        Lower level:    [ ] <------> [ ]    ==>  [ ] <--> [ ] <--> [ ]
        --------------------------------------------------------------- */
        q.left = p;
        q.right = p.right;
        p.right.left = q;
        p.right = q;

        //本层操作完毕，看更高层操作
        //抛硬币随机决定是否上层插入
        while (r.nextDouble() < 0.5 /* Coin toss */) {
            if (i >= h)   // We reached the top level !!!
            {
                //Create a new empty TOP layer
                addEmptyLevel();
            }
    	 /* ------------------------------------
         Find first element with an UP-link
         ------------------------------------ */
            while (p.up == null) {
                p = p.left;
            }
      /* --------------------------------
	   Make p point to this UP element
	   -------------------------------- */
            p = p.up;

	/* ---------------------------------------------------
          Add one more (k,*) to the column
	   Schema for making the linkage:
               p <--> e(k,*) <--> p.right
                         ^
		          |
		          v
		          q
	   ---------------------------------------------------- */
            SkipListEntry e;
            // 这里需要注意的是除底层节点之外的节点对象是不需要value值的
            e = new SkipListEntry(key, null);
  	/* ---------------------------------------
	   Initialize links of e
	   --------------------------------------- */
            e.left = p;
            e.right = p.right;
            e.down = q;
	/* ---------------------------------------
	   Change the neighboring links..
	   --------------------------------------- */
            p.right.left = e;
            p.right = e;
            q.up = e;

            //把q执行新插入的节点：
            q = e;
            // level增加
            i = i + 1;


        }
        n = n + 1; //更新链表长度
        return null;
    }


    private void addEmptyLevel() {

        SkipListEntry p1, p2;

        p1 = new SkipListEntry(Integer.MIN_VALUE, null);
        p2 = new SkipListEntry(Integer.MAX_VALUE, null);

        p1.right = p2;
        p1.down = head;

        p2.left = p1;
        p2.down = tail;

        head.up = p1;
        tail.up = p2;

        head = p1;
        tail = p2;

        h = h + 1;
    }

    public Integer remove(int key) {

        SkipListEntry p, q;

        p = findEntry(key);

        if (!p.key.equals(key)) {
            return null;
        }

        Integer oldValue = p.value;
        while (p != null) {
            q = p.up;
            p.left.right = p.right;
            p.right.left = p.left;
            p = q;
        }

        return oldValue;
    }

    public void printHorizontal() {
        String s = "";
        int i;

        SkipListEntry p;

	     /* ----------------------------------
		Record the position of each entry
		---------------------------------- */
        p = head;

        while (p.down != null) {
            p = p.down;
        }

        i = 0;
        while (p != null) {
            p.pos = i++;
            p = p.right;
        }

	     /* -------------------
		Print...
		------------------- */
        p = head;

        while (p != null) {
            s = getOneRow(p);
            System.out.println(s);

            p = p.down;
        }
    }

    public String getOneRow(SkipListEntry p) {
        String s;
        int a, b, i;

        a = 0;

        s = "" + p.key;
        p = p.right;


        while (p != null) {
            SkipListEntry q;

            q = p;
            while (q.down != null)
                q = q.down;
            b = q.pos;

            s = s + " <-";


            for (i = a + 1; i < b; i++)
                s = s + "--------";

            s = s + "> " + p.key;

            a = b;

            p = p.right;
        }

        return (s);
    }

    public static void main(String[] args) {

        SkipList l = new SkipList();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int tmp = r.nextInt(100);
            System.out.println("add:" + tmp);
            l.insert(tmp, tmp);
            l.printHorizontal();
        }

        System.out.println("over");

    }
}
