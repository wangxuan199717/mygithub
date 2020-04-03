package com.principle.openclose;

import javax.print.attribute.standard.MediaSize;

public class OpenClose {
    public static void main(String[] args) {
        GraphyEditor graphyEditor = new GraphyEditor();
        graphyEditor.DrawGrapgh(new Round());
        graphyEditor.DrawGrapgh(new Rec());
        graphyEditor.DrawGrapgh(new OtherGraph());
    }
}

class Shape{
    public int type;
}


//分析，不符合开闭原则：对扩展打开对使用闭合
class GraphyEditor{
    public void DrawGrapgh(Shape s){
        if(s.type==1){
            DrawRound();
        }else if(s.type==2){
            DrawRec();
        }else if(s.type==3){
            //添加处1
            DrawOther();
        }
    }

    private void DrawRound(){
        System.out.println("绘制圆形");
    }
    private void DrawRec(){
        System.out.println("绘制三角形");
    }
    //添加2
    private void DrawOther(){
        System.out.println("绘制其他图形");
    }
}

class Round extends Shape{
    Round(){
        super.type=1;
    }
}
class Rec extends Shape{
    Rec(){
        super.type=2;
    }
}
//例如需要增加一个图像的绘制需要修改增加多个地方


class OtherGraph extends Shape{
    OtherGraph(){
        super.type=3;
    }
}