package com.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class simple {
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

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
