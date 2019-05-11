int INF = 1000000000;
int nMax = 4000010;
int n;
int m;
int id_cnt = 0;

int max(int a, int b)
{
    if(a > b)
        return a;
    return b;
}

class Node
{
    int id;
    int v;
    int siz;
    int sum;
    int ch_tag;
    int ch;
    int ro_tag;
    int l_M;
    int r_M;
    int M;
    Node[] son;
    Node fa;
    void copy(Node ob)
    {
        id = ob.id;
        v = ob.v;
        siz = ob.siz;
        sum = ob.sum;
        ch_tag = ob.ch_tag;
        ch = ob.ch;
        ro_tag = ob.ro_tag;
        l_M = ob.l_M;
        r_M = ob.r_M;
        M = ob.M;
        son[0] = ob.son[0];
        son[1] = ob.son[1];
        fa = ob.fa;
    }
    void init(int a, int ida)
    {
        id = ida;
        siz = 1;
        ch_tag = 0;
        ro_tag = 0;
        ch = 0;
        sum = a;
        v = a;
        l_M = a;
        r_M = a;
        M = a;
        son = new Node[2];
        son[0] = null;
        son[1] = null;
        fa = null;
    }
    int judge(Node a)
    {
        if(equ(son[0], a))
            return 0;
        else
            return 1;
    }
    void push_up()
    {
        siz = 1;
        sum = v;
        int i;
        for(i = 0; i < 2; ++i)
            if(son[i] != null)
            {
                siz = siz + son[i].siz;
                sum = sum + son[i].sum;
            }
        l_M = v;
        r_M = v;
        M = v;
        int lsum = v;
        int rsum = v;
        if(son[0] != null)
        {
            l_M = son[0].l_M;
            lsum = lsum + son[0].sum;
            rsum = rsum + max(son[0].r_M, 0);
        }
        if(son[1] != null)
        {
            r_M = son[1].r_M;
            rsum = rsum + son[1].sum;
            lsum = lsum + max(son[1].l_M, 0);
        }
        l_M = max(l_M, lsum);
        r_M = max(r_M, rsum);
        for(i = 0; i < 2; ++i)
            if(son[i] != null)
                M = max(M, son[i].M);
        int ls = v;
        if(son[0] != null)
            ls = ls + max(son[0].r_M, 0);
        if(son[1] != null)
            ls = ls + max(son[1].l_M, 0);
        M = max(M, ls);
    }
    void addtag_ch(int a)
    {
        v = a;
        sum = siz * a;
        if(a >= 0)
        {
            l_M = sum;
            r_M = sum;
            M = sum;
        }
        else
        {
            l_M = a;
            r_M = a;
            M = a;
        }
        ch_tag = 1;
        ch = a;
    }
    void addtag_ro()
    {
        Node tmp;
        tmp = son[0];
        son[0] = son[1];
        son[1] = tmp;
        int t;
        t = l_M;
        l_M = r_M;
        r_M = t;
        ro_tag = ro_tag ^ 1;
    }
    void push_down()
    {
        int i;
        if(ch_tag == 1)
        {
            for(i = 0; i < 2; ++i)
                if(son[i] != null)
                    son[i].addtag_ch(ch);
            ch_tag = 0;
        }
        if(ro_tag == 1)
        {
            for(i = 0; i < 2; ++i)
                if(son[i] != null)
                    son[i].addtag_ro();
            ro_tag = 0;
        }
    }
    void rot()
    {
        Node fat = fa;
        int kind = fat.judge(this);
        fat.son[kind] = son[kind ^ 1];
        son[kind ^ 1] = fat;
        if(fat.son[kind] != null)
            fat.son[kind].fa = fat;
        fa = fat.fa;
        fat.fa = this;
        if(fa != null)
            fa.son[fa.judge(fat)]=this;
        fat.push_up();
    }
    void rotto(Node to)
    {
        Node fat;
        while(!equ(fa, to))
        {
            fat = fa;
            if(equ(fat.fa, to))
            {
                rot();
                continue;
            }
            if(fat.fa.judge(fat) == fat.judge(this))
            {
                fat.rot();
                rot();
            }
            else
            {
                rot();
                rot();
            }
        }
        push_up();
        if(fa != null)
            fa.push_up();
    }
}

int[] din = new int[nMax];

class splay_tree
{
    Node root;
    splay_tree()
    {
        root = null;
    }
    void build(Node now, Node fat, int l, int r)
    {
        int mid = (l + r) >> 1;
        Node a = new Node;
        a.init(din[mid], ++id_cnt);
        now.copy(a);
        now.fa = fat;
        if(l < mid)
        {
            now.son[0] = new Node;
            now.son[0].init(0, ++id_cnt);
            build(now.son[0], now, l, mid-1);
        }
        if(r > mid)
        {
            now.son[1] = new Node;
            now.son[1].init(0, ++id_cnt);
            build(now.son[1], now, mid + 1, r);
        }
        now.push_up();
    }
    void build_tree(int l, int r)
    {
        root = new Node;
        root.init(0, ++id_cnt);
        build(root, null, l, r);
    }
    Node find(int a)
    {
        Node now = root;
        int rank = 0;
        int ls;
        if(now.son[0] != null)
            ls = now.son[0].siz + 1;
        else
            ls = 1;
        while(rank + ls != a)
        {
            if(a < rank + ls)
            {
                now = now.son[0];
            }
            else
            {
                rank = rank + ls;
                now = now.son[1];
            }
            now.push_down();

            if(now.son[0] != null)
                ls = now.son[0].siz + 1;
            else
                ls = 1;
        }
        return now;
    }

    void dfs(Node now)
    {
        int i;
        for(i = 0; i < 2; i++)
        {
            if(now.son[i] != null)
                dfs(now.son[i]);
        }
        //delete now;
    }

    void del(int l, int r)
    {
        Node ls;
        ls = find(r + 1);
        ls.rotto(null);
        root = ls;
        ls = find(l - 1);
        ls.rotto(root);
        if(ls.son[1] != null)
            dfs(ls.son[1]);
        ls.son[1] = null;
        ls.rotto(null);
        root = ls;
    }

    void change(int l, int r, int a)
    {
        Node ls;
        ls = find(r + 1);
        ls.rotto(null);
        root = ls;
        ls = find(l - 1);
        ls.rotto(root);
        ls = ls.son[1];
        ls.push_down();
        ls.addtag_ch(a);
        ls.push_down();
        ls.rotto(null);
        root = ls;
    }

    void rol(int l, int r)
    {
        Node ls;
        ls = find(r + 1);
        ls.rotto(null);
        root = ls;
        ls = find(l - 1);
        ls.rotto(root);
        ls = ls.son[1];
        ls.push_down();
        ls.addtag_ro();
        ls.push_down();
        ls.rotto(null);
        root = ls;
    }

    int getsum(int l, int r)
    {
        Node ls;
        ls = find(r + 1);
        ls.rotto(null);
        root = ls;
        ls = find(l - 1);
        ls.rotto(root);
        ls = ls.son[1];
        ls.push_down();
        int ans = ls.sum;
        ls.rotto(null);
        root = ls;
        return ans;
    }

    int getMax()
    {
        root.push_down();
        return root.M;
    }
}

bool equ(Node a, Node b)
{
    if(a == null)
    {
        if(b == null)
            return true;
        return false;
    }
    if(b == null)
        return false;
    return a.id == b.id;
}

void merge(int a, splay_tree b, splay_tree c)
{
    Node ls = b.find(a + 1);
    ls.rotto(null);
    b.root = ls;
    ls = b.find(a);
    ls.rotto(b.root);
    ls.son[1] = c.root;
    c.root.fa = ls;
    ls.rotto(null);
    b.root = ls;
}

splay_tree sp;
splay_tree dintree;

string char_ID = "ID";

int main()
{
    n = getInt();
    m = getInt();
    sp = new splay_tree;
    dintree = new splay_tree;
    din[0] = -INF;
    din[n + 1] = -INF;
    int i;
    for(i = 1; i <= n; i++)
        din[i] = getInt();
    sp.build_tree(0, n + 1);
    int cg;
    for(i = 1; i <= m; ++i)
    {
        string str;
        str = getString();
        if(str.ord(0) == char_ID.ord(0))
        {
            int a;
            int b;
            a = getInt();
            b = getInt();
            int i;
            for(i = 1; i <= b; ++i)
                din[i] = getInt();
            dintree.build_tree(1, b);
            merge(a + 1, sp, dintree);
        }
        if(str.ord(0) == char_ID.ord(1))
        {
            int a;
            int b;
            a = getInt();
            b = getInt();
            sp.del(a + 1, a + b);
        }
        if(str.ord(0) == 82)
        {
            int a;
            int b;
            a = getInt();
            b = getInt();
            sp.rol(a + 1, a + b);
        }
        if(str.ord(0) == 71)
        {
            int a;
            int b;
            a = getInt();
            b = getInt();
            if(b > 0)
                println(toString(sp.getsum(a + 1, a + b)));
            else
                print("0\n");
        }
        if(str.ord(0) == 77)
        {
            if(str.ord(2) == 75)
            {
                int a;
                int b;
                int c;
                a = getInt();
                b = getInt();
                c = getInt();
                sp.change(a + 1, a + b, c);
            }
            else
            {
                print(toString(sp.getMax()) + "\n");
            }
        }
    }
    return 0;
}