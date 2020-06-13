package com.TPM_Network.TPM;

import com.TPM_Network.Utils.Utils;

import java.util.Random;

public class InputStage {
    private int[] inputs = null;
    private int[] weight = null;
    private int weight_size = 0;
    private int output =0;

    public InputStage(int[] inputs,int weight_size){
        this.inputs = inputs;
        this.weight_size = weight_size;
        weight = new int[inputs.length];
    }
    public InputStage(int[] inputs){
        this.inputs = inputs;
        weight_size = 3; //默认为3
        weight = new int[inputs.length];
    }
    public void setInputs(int[] inputs){
        this.inputs = inputs;
    }
    public int cacu(){
        int result=0;
        for(int i=0;i<inputs.length;i++){
            result+=inputs[i]*weight[i];
        }
        output = Utils.sign(result);
        return output;
    }
    public void getWeights(){
        Random random = new Random();
        for(int i=0;i<weight.length;i++){
            weight[i]=random.nextInt(weight_size*2)-weight_size;
        }
    }
}
