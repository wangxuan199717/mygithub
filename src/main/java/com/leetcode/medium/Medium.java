package com.leetcode.medium;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 class TreeNode1 {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode1() {
     }

     TreeNode1(int val) {
         this.val = val;
     }

     TreeNode1(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class Solution {
    public List<List<Integer>> res = new LinkedList();

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.combinationSum(new int[]{8,7,4,3},11);
//        solution.permute(new int[]{1,2,3,4});
        solution.getPermutation(4,9);
        solution.removeDuplicatesk(new int[]{1,2,2,3,3,3,3,4,4,4,4,4,5},3);
        solution.divide1(100,3);
        solution.searchRange(new int[]{1,2,3,4,6,6,6,8,8,8},6);
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
        solution.largestRectangleArea1(new int[]{2,1,5,6,2,3});
        solution.addBinary("111","110");
        //solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        solution.singleNumber(new int[]{1,1,2,2,3,3,4});

        ListNode head = new ListNode(9);
        head.next = new ListNode(7);
        head.next.next = new ListNode(10);
        solution.insertionSortList(head);

        solution.moveZeroes(new int[]{0,0,1,0,2,3,4});
        solution.minEatingSpeed(new int[]{3,6,7,11},8);
        solution.asteroidCollision(new int[]{1,-1,-2,-2});

        solution.numRabbits1(new int[]{2,2,2,3,3,3,3,3});
        int tri = solution.tribonacci(25);
    }

    public int tribonacci(int n) {
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }

    public int numRabbits1(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;

        int ans = 0;
        for (int k = 0; k < 1000; ++k)
            ans += Math.floorMod(-count[k], k+1) + count[k];
        return ans;
    }

    public int numRabbits(int[] answers) {
        int result = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<answers.length;i++)
            hashMap.put(answers[i],hashMap.get(answers[i])==null?1:(hashMap.get(answers[i])+1));
        for(int i=0;i<hashMap.size();i++){
            result += hashMap.get(answers[i])/(answers[i]+1) * (answers[i]+1);
            result += hashMap.get(answers[i])%(answers[i]+1)==0?0:hashMap.get(answers[i])%(answers[i]+1);
        }
        return result;
    }

    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids==null) return null;
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
            boolean flag =false;
            if(stack.empty() || asteroids[i]>0 || asteroids[i]*stack.peek()>0 || asteroids[i]>0 && stack.peek()<0)
                stack.push(asteroids[i]);
            while(!stack.empty() && asteroids[i]<0 && stack.peek()>0){
                if(stack.peek()>Math.abs(asteroids[i])){
                    flag = false;
                    break;
                }
                if(stack.peek()<Math.abs(asteroids[i])){
                    stack.pop();
                    flag = true;
                    continue;
                }
                if(stack.peek()==Math.abs(asteroids[i])){
                    stack.pop();
                    flag = false;
                    break;
                }
            }
            if(flag) stack.push(asteroids[i]);
        }
        return stack.stream().mapToInt(Integer::valueOf).toArray();
    }


    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles)
            maxVal = Math.max(maxVal, pile);
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (canEat(piles, mid, H))
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private boolean canEat(int[] piles, int speed, int H) {
        int sum = 0;
        for (int pile : piles)
            sum += Math.ceil(pile * 1.0 / speed);
        return sum > H;
    }

    public int minEatingSpeed1(int[] piles, int H) {
        Arrays.sort(piles);
        int minspeed=1;
        int left=0;
        int right = piles.length-1;
        int mid = (right-left)/2;

        while(right>left){
            int time=mid;
            minspeed = piles[mid];
            for(int i=mid+1;i<piles.length;i++)
                time+=piles[i]%minspeed==0?piles[i]/minspeed:piles[i]/minspeed+1;
            if(H==time) return minspeed;
            if(H>time) right = mid;
            if(H<time) left = +1;
        }
        return minspeed;
    }

    public int primePalindrome(int N) {
        while (true) {
            N = getNextPalindrome(N); // 获取>=N的回文数
            if(isPrime(N)) return N; // 判断是不是素数
            N++;
        }
    }

    // 获取下一个>=n的回文数
    private int getNextPalindrome(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int mid = s.length/2;
        while (true) {
            // 制造回文数：把前半段翻转一下复制到后半段
            for (int i = 0; i < mid; i++) {
                s[s.length -1 - i] = s[i];
            }
            // 判断制造出来的数是否>=n
            int tmp = Integer.valueOf(String.valueOf(s));
            if (tmp >= n) return tmp; // 如果>=n，返回这个造出来的数
                // 如果比n小，那前半段+1
            else {
                int j = s.length % 2 == 1? mid: mid-1; // 如果是奇数长度，最靠近中轴的是s[mid]；如果是偶数长度，最靠近中轴的是s[mid-1]
                // 有9要进位（不用考虑999xxx这样首位要进位的，因为999999这个回文数肯定>=所有999xxx形式的n）
                while (s[j] == '9'){
                    s[j--] = '0';
                }
                s[j]++;
            }
        }
    }

    // 判断是否是素数
    private boolean isPrime(int num){
        // 一般从2找到n/2，判断是否能被整除。从5开始，n/2>√n，这样可以减少运算量。
        if(num <= 5) {
            return num == 2 || num == 3 || num == 5;
        }

        // 从2找到√num
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public void moveZeroes(int[] nums) {
        if(nums.length==1 || nums.length==0) return;
        int zero=0;
        int nonezero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zero++;
            else
                nums[nonezero++]=nums[i];
        }
        for(int i=0;i<zero;i++)
            nums[nums.length-i-1]=0;
    }

    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;

        ListNode sorted = null;
        while(head!=null){
            if(sorted==null){
                sorted = new ListNode(head.val);
                sorted.next = null;
                head = head.next;
                continue;
            }
            ListNode temp = sorted;
            ListNode pre = sorted;
            ListNode x = new ListNode(head.val);
            while(temp!=null && temp.val<head.val){
                pre = temp;
                temp = temp.next;
            }
            if(temp == sorted){
                x.next = sorted;
                sorted = x;
            }else {
                pre.next = x;
                x.next = temp;
            }
            head = head.next;
        }
        return sorted;
    }
    public int singleNumber(int[] nums) {
        if(nums.length<=1)
            return nums[0];
        for(int i=1;i<nums.length;i++)
            nums[0] = nums[0]^nums[i];
        return nums[0];
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[1];
        int[] result = new int[nums.length];

        int[] queue = new int[nums.length];
        queue[0]=nums[0];
        int head=0;
        int rear=1;

        for(int i=1;i<k;i++){
            //if()
        }
        for(int i=0;i<nums.length;i++){
            //if(i!=0)
        }
        return null;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,0,target,new LinkedList<>());
        return res;
    }
    private void backtrack(int[] candidates, int start,int target, LinkedList<Integer> track) {
        if(target<0)
            return;
        if (target == 0){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(target < candidates[i]) continue;
            track.add(candidates[i]);
            backtrack(candidates,i,target-candidates[i],track);
            track.removeLast();
        }
    }

    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute_num(nums,new LinkedList<>());
        return result;
    }
    public void permute_num(int[] nums,LinkedList<Integer> path){
        if (path.size() == nums.length) {
            result.add(new LinkedList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            permute_num(nums, path);
            path.removeLast();
        }
    }


    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList() {{add(1);}};

        factorials[0] = 1;
        for(int i = 1; i < n; ++i) {
            factorials[i] = factorials[i - 1] * i;
            nums.add(i + 1);
        }
        --k;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > -1; --i) {
            int idx = k / factorials[i];
            k -= idx * factorials[i];

            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
    public int removeDuplicatesk(int[] nums,int k) {
        int index=k-1;
        for(int i=k;i<nums.length;i++){
            if(nums[i]!=nums[index-k+1]){
                index++;
                nums[index]=nums[i];
            }
        }
        return index+1;
    }
    public int removeDuplicates(int[] nums) {
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[index-1]){
                index++;
                nums[index]=nums[i];
            }
        }
        return index;
    }
    public int divide(int dividend, int divisor) {
        boolean flag =false;
        if(dividend>0 && divisor>0 || dividend<0 && divisor<0) flag =true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result=0;
        int s=1;
        while(dividend>divisor){
            if(dividend>divisor*s)
            {
                dividend -= divisor*s;
                result+=s;
                s++;
            }else {
                s--;
            }
        }
        return flag?result:-result;
    }
    public int divide1(int dividend, int divisor) {
        int result=0;
        boolean flag = dividend>0 ^ divisor>0;
        dividend = dividend>0?dividend:-dividend;
        divisor = divisor>0?divisor:-divisor;

        while(dividend>divisor){
            int temp_divisor=divisor;
            int temp_result=1;
            while(dividend>=(temp_divisor<<1)){
                temp_divisor = temp_divisor<<1;
                temp_result = temp_result<<1;
            }
            dividend-=temp_divisor;
            result+=temp_result;
        }
        return flag?result:-result;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid = (end-start)/2;
            if(target == nums[mid]){
                while(nums[mid--]==target);
                result[0]=mid;
                while(nums[mid++]==target);
                result[1]=mid;
                return result;
            }
            if(target > nums[mid]) start=mid-1;
            if(target <nums[mid]) end= mid+1;
        }
        return result;
    }
    public int[] searchRange1(int[] nums, int target) {
        int l =0,r = nums.length-1;
        while(l <= r){
            int mid = l +(r-l)/2;
            if(nums[mid] > target) r = mid-1;
            if(nums[mid] < target) l = mid+1;
            if(nums[mid] == target){
                l = mid;
                r = mid;
                while(r+1<nums.length && nums[r+1] == target) r++;
                while(l-1>=0 && nums[l-1] == target) l--;
                return new int[]{l,r};
            }
        }
        return new int[]{-1,-1};
    }
    List<List<String>>  Queues = new ArrayList<>();
    public boolean isAvliable(int n,List<String> broad,int x,int y){
        return false;
    }
    public void Queue(int n,List<String> broad,int n1){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<n;i++){
            stringBuffer.replace(i,i,"Q");
            broad.add(stringBuffer.toString());
            if(isAvliable(n,broad,i,n1)){
                if(n1+1==n)
                    Queues.add(broad);
                Queue(n,broad,n1+1);
            }
            broad.get(i).replace("Q",".");
        }
    }
    public List<List<String>> solveNQueens(int n) {
        Queue(n,new ArrayList<>(),0);
        return Queues;
    }
    public int getMin(int[] heights,int start,int end){
        int min =Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            if(heights[i]<=min)
                min=heights[i];
        }
        return min==Integer.MAX_VALUE?heights[start]:min;
    }
    public int largestRectangleArea(int[] heights) {
        int result=heights[0];
        int[] min = new int[heights.length];
        min[0]=heights[0];

        for(int i=1;i<heights.length;i++){
            for(int j=i;j>0;j--){
                if(getMin(heights,j,i)*(i-j)>result)
                    result=getMin(heights,j,i)*(i-j);
            }
        }
        return result;
    }
    public int largestRectangleArea1(int[] heights) {
        int[] front = new int[heights.length];
        int[] back  = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();

        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                front[i]=0;
                stack.push(i);
            }else {
                int top=-1;
                while(!stack.isEmpty() && (heights[top=stack.pop()])>=heights[i]);
                stack.push(top);
                if(stack.isEmpty()) front[i]=0;
                else front[i]=top;
                stack.push(i);
            }

            if(stack1.isEmpty()){
                back[heights.length-1-i]=heights.length-1;
                stack1.push(heights.length-1-i);
            }else {
                int top=-1;
                while(!stack1.isEmpty() && (heights[top=stack1.pop()])>=heights[heights.length-1-i]);
                stack1.push(top);
                if(stack1.isEmpty()) back[heights.length-1-i]=0;
                else back[heights.length-1-i]=top;
                stack1.push(heights.length-1-i);
            }
        }

        int result=-1;
        for(int i=0;i<heights.length;i++){
            if(Math.abs(back[i]-front[i])*heights[i]>result)
                result = Math.abs(back[i]-front[i])*heights[i];
        }
        return result;
    }
    public int firstMissingPositive(int[] nums) {
        int result=1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums.length-1 || nums[i]<=0) nums[i]=-1;
            else {
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        return result;
    }
    public int convey(String num){
        int result=0;
        int x=1;
        for(int i=0;i<num.length();i++){
            if(num.charAt(num.length()-i-1)=='1')
                result+=x;
            x*=2;
        }
        return result;
    }
    public int addBinary(String a, String b) {
        return convey(a)+convey(b);
    }
}
public class Medium {
    public TreeNode recoverFromPreorder(String S) {
        int num = 0;
        List<TreeNode> pre = new ArrayList<>();
        TreeNode root = new TreeNode(S.charAt(0)-48);
        pre.add(root);
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)=='-') num++;
            else {
                TreeNode tmp = pre.get(num-1);
                TreeNode tmp1 = new TreeNode(S.charAt(i)-48);
                if(tmp.left==null) {
                    tmp.left = tmp1;
                    pre.add(tmp1);
                }
                else {
                    tmp.right = tmp1;
                    pre.set(num,tmp1);
                }
                num=0;
            }
        }
        return root;
    }
    public int getResult(int n){
        int result = 1;
        while(n>0){
            result *= n;
            n--;
        }
        return result;
    }
    public int uniquePaths(int m, int n) {
        int result = getResult(m)/getResult(n-1);
        return result+m;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int prev = 0, cur;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> rows = triangle.get(i);
            dp[0] = dp[0] + rows.get(0);
            dp[i-1] = dp[i-1] + rows.get(i-1);
            for (int j = 1; j <= i-1; j++) {
                cur = dp[j];
                dp[j] = Math.min(cur, prev) + rows.get(j);
                prev = cur;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
    public int reverseBits(int n) {
        n = n>>16 | n<<16;
        n = (n & 0xff00ff00)>>8 | (n & 0x00ff00ff)<<8;
        n = (n & 0x0f0f0f0f)>>4 | (n & 0xf0f0f0f0)<<4;
        n = (n & 0xcccccccc)>>2 | (n & 0x33333333)<<2;
        n = (n & 0xaaaaaaaa)>>1 | (n & 0x55555555)<<1;
        return n;
    }
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root!=null){
            flatten(root.right);
            flatten(root.left);
            root.right=pre;
            root.left=null;
            pre = root;
        }
    }
    public int[] spiralOrder1(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
    public int[] spiralOrder(int[][] matrix) {
        int[][] dir={
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        int direction=0;
        int posx=0;
        int posy=0;
        int width = matrix.length;
        int height = matrix[0].length;
        int[] result = new int[width*height];

        for(int i=0;i<width*height;i++){

            result[i]=matrix[posy][posx];
            matrix[posy][posx]=Integer.MIN_VALUE;
            posx+=dir[direction][0];
            posy+=dir[direction][1];
            if(matrix[posx][posy]==Integer.MIN_VALUE){
                if(direction==0){
                    direction=1;
                    continue;
                }
                if(direction==1){
                    direction=2;
                    continue;
                }
                if(direction==2){
                    direction=3;
                    continue;
                }
                if(direction==3){
                    direction=0;
                    continue;
                }
            }
        }
        return result;
    }
    public List<List<Integer>> generate1(int numRows){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        list.add(1);
        result.add(list);
        if(numRows==1){
            return result;
        }
        list.add(1);
        result.add(list);
        if(numRows==2){
            return result;
        }

        for(int i=3;i<numRows;i++){
            list=result.get(i-1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=0;j<i;j++){
                temp.add(list.get(j)+list.get(j+1));
            }
            result.add(temp);
        }
        return result;
    }
    public String removeDuplicates1(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
    public String removeDuplicates(String S) {
        int top=0;
        char[] stack = S.toCharArray();
        for(int i=0;i<S.length();i++){
            if(top>=1 && stack[top-1]==S.charAt(i)){
                top-=2;
            }
            stack[top++]=S.charAt(i);
        }
        return new String(stack);
    }
    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            left[i]*=nums[i-1];
            right[nums.length-i-1]*=nums[nums.length-i-1];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        char[] charArray = s.toCharArray();

        if (len == 0 ||charArray[0] == '0' )   return 0;

        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0')
                dp[i] = dp[i - 1];
            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26)
                if (i == 1)     dp[i]++;
                else    dp[i] += dp[i - 2];
        }
        return dp[len - 1];
    }

    public int maxProfit(int[] prices) {
        int max=0;
        int max1=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            max=max1-prices[i]>max?max1-prices[i]:max;
            if(prices[i]>max1)
                max1=prices[i];
        }
        return max;
    }
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
