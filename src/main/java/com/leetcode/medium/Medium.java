package com.leetcode.medium;

import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class Medium {

    public boolean isHappy(int n) {
        int result=0;
        while(true){

        }
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> booleans = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max)
                max=candies[i];
            candies[i]+=extraCandies;
        }
        for(int i=0;i<candies.length;i++)
            booleans.add(i,candies[i]>=max);
        return booleans;
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
    public boolean canJump(int[] nums) {
        int distance=nums[0];
        int i=0;
        while(i<distance){
            if(nums[i]+i>distance)
                distance=nums[i]+i;
        }
        return distance>=nums.length;
    }
    public void setZeroes(int[][] matrix) {
        int MODIFIED = -1000000;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 0) {
                    for (int k = 0; k < C; k++) {
                        if (matrix[r][k] != 0) {
                            matrix[r][k] = MODIFIED;
                        }
                    }
                    for (int k = 0; k < R; k++) {
                        if (matrix[k][c] != 0) {
                            matrix[k][c] = MODIFIED;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == MODIFIED) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode root= head;
        int num=0;
        while(head.next!=null) {head=head.next; num++;}
        head.next=root;
        k=num-k%num;
        while(k--!=0){
            root=root.next;
        }
        ListNode listNode = root.next;
        root.next=null;
        return listNode;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.empty()){
            if(root!=null){
                stack.push(root);
                list.add(root.val);
                root=root.right;
            }else root=stack.pop().left;
        }
        Collections.reverse(list);
        return list;
    }
    public int candy(int[] ratings) {
        int i=0;
        int result=0;
        int[] nums = new int[ratings.length];
        int[] nums1 = new int[ratings.length];
        nums[0]=1;
        for(i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) nums[i]=nums[i-1]+1;
            else nums[i]=1;
        }
        nums1[ratings.length-1]=1;
        for(i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) nums1[i]=nums[i+1]+1;
            else nums1[i]=1;
        }
        for(i=0;i<ratings.length;i++){
            result += Math.max(nums[i],nums1[i]);
        }
        return result;
    }
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(right!=left){
            if(target>nums[(right+left)/2])
                left=(right+left)/2+1;
             else if(target<nums[(right+left)/2])
                right=(right+left)/2-1;
            if (target==nums[(right+left)/2])
                return (right+left)/2;
        }
        return left;
    }

    public String decodeString(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                int j=i;
                int n=0;
                while(j<s.length()){
                    if(s.charAt(j)=='[')
                        n++;
                    if(s.charAt(j)==']')
                        n--;
                    if(n==0)
                        break;
                    j++;
                }
                String tmp = decodeString(s.substring(i,j));
                for(j=0;j<s.charAt(i);j++)
                    stringBuilder.append(tmp);
            }else
                stringBuilder.append(s.indexOf(i));
        }
        return stringBuilder.toString();
    }

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public int maximalSquare(char[][] matrix) {
        int cow = matrix.length;
        int col = matrix[0].length;
        int[][] area = new int[cow][col];
        int max=0;

        for(int i=0;i<cow;i++){
            for(int j=0;j<col;j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 && j == 0)
                        area[0][0] = 1;
                    else
                        area[i][j] = Math.min(Math.min(
                                (i-1)<0 ? 0 : area[i - 1][j],
                                (j-1)<0 ? 0 : area[i][j - 1]),
                                (j-1)<0 || (i-1)<0 ? 0 : area[i - 1][j - 1]) + 1;
                    max = Math.max(area[i][j], max);
                }
            }
        }
        return max*max;
    }

    public int jump(int[] nums) {

        if(nums.length==0 || nums.length==1)
            return 0;

        int step=0;
        int max=0;
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max,i+nums[i]);
            if(i==end){
                step++;
                end=max;
            }
        }
        return step;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 邻接表法表示图
        List<List<Integer>> graphic = new ArrayList<>();
        // 存储每个节点的入度
        int[] inDegree = new int[numCourses];
        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            graphic.add(new ArrayList<>());
        }
        // 完成邻接表并记录每个节点的入度
        for (int[] pre : prerequisites) {
            graphic.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 度为0的节点先入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        int[] result = new int[numCourses];
        // 根据拓扑排序，每次遍历需要剔除度为0的节点，并且该节点指向的节点入度-1
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[idx++] = course;
            for (Integer theNext : graphic.get(course)) {
                if (--inDegree[theNext] == 0) {
                    queue.add(theNext);
                }
            }
        }
        return  idx == numCourses ? result : new int[]{};
    }

    public int maxProduct(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;
        int max=nums[0];
        int max1=nums[0];
        int min1=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=max1;
            int temp1=min1;
            max1=Math.max(nums[i],Math.max(temp*nums[i],temp1*nums[i]));
            min1=Math.min(nums[i],Math.min(temp*nums[i],temp1*nums[i]));
            max = Math.max(max1,max);
        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int max1=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max+nums[i],nums[i]);
            max1=Math.max(max1,max);
        }
        for(int n:nums){
            max=Math.max(max+n,n);
        }
        return max;
    }
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        List num = new ArrayList();
        while(x!=0){
            num.add(x%10);
            x/=10;
        }
        int i=0;
        int j=num.size()-1;
        while(i!=j){
            if(num.get(i++)!=num.get(j--))
                return false;
        }
        return true;
    }

    public int longestValidParentheses(String s) {

        int max=0;
        int max1=0;
        int i=0;
        char[] stack = new char[s.length()];
        while(s.charAt(i++)==')');
        stack[0]=s.charAt(--i);
        int top=0;
        for(i++;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack[++top]='(';
            else{
                if(stack[top]=='('){
                    max1+=2;
                    top-=1;
                }else {
                    top=0;
                    max1=0;
                    max=Math.max(max1,max);
                }
            }
        }
        return Math.max(max1,max);
    }
    public int maxArea(int[] height) {

        int max=0;
        int left=0;
        int right=height.length-1;

        while(left!=right){
            if(height[left]>height[right]){
                max=Math.max(height[right]*(right-left),max);
                right--;
            }else {
                max=Math.max(height[left]*(right-left),max);
                left++;
            }
        }
        return max;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<m+1;i++)
            dp[i][n]=Integer.MAX_VALUE;
        for(int i=0;i<n+1;i++)
            dp[m][i]=Integer.MAX_VALUE;
        dp[m][n-1] = dp[m-1][n] = 1;
        for (int i = m-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                int minn = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, minn-dungeon[i][j]);
            }
        }
        return dp[0][0]+1;
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    public int removeElement(int[] nums, int val) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            while(nums[i]==val) i++;
            nums[num++]=nums[i];
        }
        return num;

    }
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        for ( ; i < j && s.charAt(i) == s.charAt(j); ++i, --j);


        return palindrome(s, i, j - 1) || palindrome(s, i + 1, j);
    }
    boolean palindrome(String s, int i, int j)
    {
        for ( ; i < j && s.charAt(i) == s.charAt(j); ++i, --j);
        return i >= j;
    }

    public String longestPalindrome(String s) {
        int max=0;
        int maxi=0;
        int maxj=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s,i,j)){
                    if(max<j-i){
                        maxi=i;
                        maxj=j;
                        max=Math.max(max,j-i);
                    }
                }
            }
        }
        return s.substring(maxi,maxj+1);
    }
    boolean isPalindrome(String s,int start,int end){
        while(start != end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public String longestPalindrome2(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int low=0;
        int high=0;

        for(int i=0;i<nums.length;i++){
            int now=nums[i];
            low=i+1;
            high=nums.length-1;

            while(now+nums[low]+nums[high]>0)   high--;
            while(now+nums[low]+nums[high]<0)   low++;

            if(now+nums[low]+nums[high]==0) {
                List<Integer> list = new ArrayList<>();
                list.add(now);
                list.add(nums[low]);
                list.add(nums[high]);
                lists.add(list);
            }
        }
        return lists;
    }

    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);

        return rob1(nums,n-1);
        //return rob1(Arrays.copyOfRange(nums,0,n-1),n-2);
    }
    public int rob1(int[] nums,int n){
        if(n==0)
            return nums[0];
        if(n==1)
            return Math.max(nums[0],nums[1]);
        int a=rob1(nums,n-2)+nums[n];
        int b=rob1(nums,n-1);
        return Math.max(a,b);
    }
}
class Foo {

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while (true)
            printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (true)
            printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (true)
            printThird.run();
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
