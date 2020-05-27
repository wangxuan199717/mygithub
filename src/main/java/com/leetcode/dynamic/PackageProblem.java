package com.leetcode.dynamic;

public class PackageProblem {
    public int BasePackage(int cost[],int weight[],int V){

        /*
        dp[i][v] 前i件物品放入v大小的包中最大的价值
        * */
        int[][] dp = new int[cost.length][V];

        for(int i=0;i<cost.length;i++){
            for(int j=0;j<V;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+cost[i]);
            }
        }

        return dp[cost.length][V];
    }
    public void knapsackOptimal(int c, int[] weight, int[] value) {
        int n = weight.length; //物品数量
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            w[i] = weight[i - 1];
            v[i] = value[i - 1];
        }
        int[] values = new int[c + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int t = c; t >= w[i]; t--) {
                if (values[t] < values[t - w[i]] + v[i]) {
                    values[t] = values[t - w[i]] + v[i];
                }
            }
        }
        System.out.println("最大价值为： " + values[c]);
        System.out.print("装入背包的物品编号为： ");
    }
    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }

}
