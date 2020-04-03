package com.principle.openclose.improve;

public class ImproveOpenClose {
    public static void main(String[] args) {
        GraphyEditor graphyEditor = new GraphyEditor();
        graphyEditor.DrawGrapgh(new Round());
        graphyEditor.DrawGrapgh(new Rec());
        graphyEditor.DrawGrapgh(new OtherGraph());
    }
}

abstract class Shape{
    abstract public void Draw();
}


//分析，不符合开闭原则：对扩展打开对使用闭合
class GraphyEditor{
    public void DrawGrapgh(Shape s){
       s.Draw();
    }
}

class Round extends Shape {
    @Override
    public void Draw() {
        System.out.println("绘制圆图形");
    }
}
class Rec extends Shape {
    @Override
    public void Draw() {
        System.out.println("绘制三角图形");
    }
}
//例如需要增加一个图像的绘制需要修改增加多个地方


class OtherGraph extends Shape {
    @Override
    public void Draw() {
        System.out.println("绘制其他图形");
    }
}