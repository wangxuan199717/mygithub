package Test;

import org.junit.Test;

public class TestCacu {
    public static void main(String[] args) {
        Cacu cacu = new Cacu();
        System.out.println(cacu.Add(1,2));
    }
    @Test
    public void testadd(){
        System.out.println(new Cacu().Add(1,5));
    }
}

class Cacu{
    public int Add(int a,int b){
        return a+b;
    }
}