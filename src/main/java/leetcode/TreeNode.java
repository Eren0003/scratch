package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static void main(String[] args) {
        TreeNode l = new TreeNode(3);
        TreeNode m = new TreeNode(4, l, null);
        TreeNode n = new TreeNode(1);
        TreeNode o = new TreeNode(2, n, m);
        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(10);
        TreeNode r = new TreeNode(9, p, q);
//        TreeNode r = new TreeNode(7, p, null);
        TreeNode s = new TreeNode(6);
        TreeNode t = new TreeNode(7, s, r);
        TreeNode head = new TreeNode(5, o, t);
        TreeNode temp = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, temp);
        TreeNode sl = new TreeNode(3);
        TreeNode sr = new TreeNode(3);
        TreeNode ml = new TreeNode(4);
        TreeNode mr = new TreeNode(4);
        TreeNode nl = new TreeNode(2, sl, ml);
        TreeNode nr = new TreeNode(2, mr, sr);
        TreeNode sym = new TreeNode(1, nl, nr);
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2,b1,null);
        TreeNode b4 = new TreeNode(4);
        TreeNode b3 = new TreeNode(3,b2,b4);
        TreeNode b5 = new TreeNode(6);
        TreeNode bst = new TreeNode(5,b3,b5);
        List<List<Integer>> list = new ArrayList<>();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(7);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(7);
//        treeNode.right.right = new TreeNode(11);
//        treeNode.left.left.left = new TreeNode(3);
//        treeNode.left.left.right = new TreeNode(-2);
        treeNode.left.right = new TreeNode(-8);
//        treeNode.left.right.right = new TreeNode(1);
//        inOrder(treeNode);
//        System.out.println(maxLevelSum(treeNode));
//        System.out.println(largestvalueInRow(head));
//        System.out.println(kthElement(head,3));
//        System.out.println(list);
//        System.out.println(print(bst));
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(8);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);
        node.right.right = new TreeNode(6);
        System.out.println(averageOfSubTree(node));
    }
    static int averageOfSubTree(TreeNode root){

        int[] result = rec(root,0,0);
        return result[2];
    }
    static int[] rec(TreeNode root,int sum,int visited){
        if(root == null){
            return new int[3];
        }
        int[] result = rec(root.left,sum,visited);
        int[] temp = rec(root.right,sum,visited);
        result[0] += temp[0];
        result[1] += temp[1];
        result[2] += temp[2];
        result [0]+= root.val;
        result[1] += 1;
        if(result[0]/result[1] == root.val){
            result[2] += 1;
        }
        return result;
    }

    static List<Integer> largestValueInRow(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            Queue<TreeNode> innerQueue = new LinkedList<>();
            int max = 0 ;
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    innerQueue.offer(temp.left);
                }if(temp.right != null) {
                    innerQueue.offer(temp.right);
                }
            }
            while(!innerQueue.isEmpty()){
                TreeNode t = innerQueue.poll();
                max = Math.max(max,t.val);
                queue.offer(t);
            }
            list.add(max);
        }
        if(list.size() > 1 && list.get(list.size()-1) == 0){
            list.remove(list.size()-1);
        }
        return list;
    }
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
    static List<Integer> print(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        pre(node,3 ,list);
        System.out.println(result1);
        return list;
    }
    static void println(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inOrder(root);
    }
    static void inOrder( TreeNode root){
        if(root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    private static int result = 0;
    static void pre(TreeNode node,int k,List<Integer> list) {
        if (node == null || k <  list.size()) {
            return;
        }
        pre(node.left,k,list);
        list.add(node.val);
        if(k == list.size()){
            result1 = node.val;
            return;
        }
        pre(node.right,k,list);
    }

    static void preOrder(TreeNode node, List<String> list) {
        if (node == null) {
            return;
        }
        list.add(node.val + "");
        if (node.left != null) {
            list.add("(");
            preOrder(node.left, list);
            list.add(")");
        }
        if (node.right != null) {
            list.add("(");
            preOrder(node.right, list);
            list.add(")");
        }
    }

    static void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    static void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
        invert(node.left);
        invert(node.right);
    }

    static boolean hasPathSum(TreeNode root, int targetSum) {
        return sum(root, targetSum, 0);
    }

    static boolean sum(TreeNode root, int targetSum, int sum) {
        if (root.left == null && root.right == null && targetSum == sum) {
            return true;
        } else if (root == null || sum > targetSum) {
            return false;
        }
        return sum(root.left, targetSum, sum + root.val) ||
                sum(root.right, targetSum, sum + root.val);
    }

    static void preOrderString(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }
        result.append(node.val);
        if (node.left == null && node.right != null) {
            result.append("()");
        }
        if (node.left != null) {
            result.append("(");
            preOrderString(node.left, result);
            result.append(")");
        }
        if (node.right != null) {
            result.append("(");
            preOrderString(node.right, result);
            result.append(")");
        }
    }

    static boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        return symmetric(root.left, root.right);
    }

    static boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }

    static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (equal(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static boolean equal(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return equal(root.left, subRoot.left) && equal(root.right, subRoot.right);
    }

    static void levelOrder(TreeNode root, List<List<Integer>> list) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        list.add(l);
        while (!linkedList.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> inner = new LinkedList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                if (linkedList.peekFirst().left != null) {
                    inner.add(linkedList.peekFirst().left);
                }
                if (linkedList.peekFirst().right != null) {
                    inner.add(linkedList.peekFirst().right);
                }
                linkedList.poll();
            }
            while (!inner.isEmpty()) {
                TreeNode poll = inner.poll();
                temp.add(poll.val);
                linkedList.add(poll);
            }
            if (!temp.isEmpty()) {
                list.add(temp);
            }
        }
    }

    static List<Integer> rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        view(root, list, 1, set);
        return list;
    }

    static void view(TreeNode root, List<Integer> list, int level, Set<Integer> set) {
        if (root == null) {
            return;
        }
        if (!set.contains(level)) {
            list.add(root.val);
            set.add(level);
        }
        view(root.right, list, level + 1, set);
        view(root.left, list, level + 1, set);
    }

    static int sumNumber(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sum(root, list, 0);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    static void sum(TreeNode root, List<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum = sum * 10 + root.val;
            list.add(sum);
            return;
        }
        sum = (sum * 10) + root.val;
        sum(root.left, list, sum);
        sum(root.right, list, sum);
    }

    static List<List<Integer>> zigzagOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        list.add(List.of(root.val));
        while(!linkedList.isEmpty()){
            LinkedList<TreeNode> inner = new LinkedList<>();
            List<Integer> innerList = new ArrayList<>();
            while(!linkedList.isEmpty()){
                if(linkedList.peekFirst().left != null){
                    inner.addFirst(linkedList.peekFirst().left);
                }if(linkedList.peekFirst().right != null){
                    inner.addFirst(linkedList.peekFirst().right);
                }
                linkedList.poll();
            }
            while(!inner.isEmpty()){
                TreeNode node = inner.pop();
                innerList.add(node.val);
                linkedList.addFirst(node);
            }
            list.add(innerList);
        }
        return list;
    }
    static boolean isValid(TreeNode root){
     if(root == null){
         return true;
     }
     if(root.left != null && root.right != null && (root.left.val > root.val || root.right.val < root.val)){
         return false;
     }
     return isValid(root.left) && isValid(root.right);
    }
    static int kThElement(TreeNode root , int k){
        List<Integer> list =new ArrayList<>();
        element(root,list);
        list = list.stream().sorted().collect(Collectors.toList());
        return list.get(k-1);
    }
    static void element(TreeNode root, List<Integer> list ){
        if(root == null){
            return ;
        }
        list.add(root.val);
        element(root.left, list);
        element(root.right, list);
    }
    static int  length =  0;
    static int kthElement(TreeNode root,int k){
        leftLength(root.left);
        return length;
    }
    static void leftLength(TreeNode root){
        if(root == null){
            return;
        }
        length += 1;
        leftLength(root.left);
        leftLength(root.right);
    }
    private static int max =  -1;
    static int findBottomLeft (TreeNode root){
        HashMap<Integer,Integer> map = new HashMap<>();
        bottomLeft(root,map,1);
        int temp = max;
        Stack<Integer> stack = new Stack<>();
        max = -1;
        return map.get(temp);
    }
    static void bottomLeft (TreeNode root , HashMap<Integer,Integer> map , int level){
        if(root == null){
            return ;
        }
        if(!map.containsKey(level)){
            map.put(level,root.val);
        }if(level > max){
            max = level;
        }
        bottomLeft(root.left,map,level+1);
        bottomLeft(root.right,map,level+1);
    }
    static int result1 = 0 ;
    static int pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        dfs(root,targetSum,list,0);
        return result1/2;
    }
    static void dfs(TreeNode root,int targetSum ,List<Integer> list ,int sum){
        if(list.contains(sum-targetSum)){
            result1 += 1;
        }if(sum == targetSum){
            result1 += 1;
        }
        if(root == null){
            return;
        }
        list.add(sum+root.val);
        dfs(root.left,targetSum,list,sum+root.val);
        dfs(root.right,targetSum,list,sum+root.val);
    }
    static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.right != null && root.val >= root.right.val){
            return false;
        }if(root.left != null && root.val <= root.left.val){
            return false;
        }
        return dfs(root.left, root.val, "left" ) && dfs(root.right ,root.val,"right");
    }
    static boolean dfs(TreeNode root,int rootVal,String direction){
        if(root == null){
            return true;
        }
        if(direction.equals("left")){
            if((root.left != null && root.left.val >= rootVal) ||(root.right != null && root.right.val >= rootVal)){
                return false;
            }
        }else{
            if((root.left != null && root.left.val <= rootVal) ||( root.right != null && root.right.val <= rootVal)){
                return false;
            }
        }
        if(root.left != null && root.left.val >= root.val){
            return false;
        }
        if(root.right != null && root.right.val <= root.val){
            return false;
        }
        return dfs(root.left,rootVal,direction) && dfs(root.right,rootVal,direction);
    }
    static int maxLevelSum(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = -Integer.MAX_VALUE;
        int level = 1 ;
        int index =  level;
        while(!queue.isEmpty()){
            Queue<TreeNode> innerQueue = new LinkedList<>(queue);
            queue.removeAll(queue);
            int sum = 0 ;
            while(!innerQueue.isEmpty()){
                if(innerQueue.peek().left != null){
                    queue.add(innerQueue.peek().left);
                }if(innerQueue.peek().right != null){
                    queue.add(innerQueue.peek().right);
                }
                sum += innerQueue.poll().val;
            }
            if(sum > max){
                max = sum;
                index = level;
            }
            level++;
        }
        return index;
    }
    static long kthLargestSum(TreeNode root,int k){
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1 ;
        while(!queue.isEmpty()){
            Queue<TreeNode> innerQueue = new LinkedList<>(queue);
            queue.removeAll(queue);
            long sum = 0 ;
            while(!innerQueue.isEmpty()){
                if(innerQueue.peek().left != null){
                    queue.add(innerQueue.peek().left);
                }if(innerQueue.peek().right != null){
                    queue.add(innerQueue.peek().right);
                }
                sum += innerQueue.poll().val;
            }
            list.add(sum);
            level++;
        }
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(k >= level) return -1;
        return list.get(k-1);
    }
}