package com.principle.DependencyInversion.improve;

public class ImproveReserve {
    public static void main(String[] args) {
        Person person = new Person();
        person.Speak(new Email());
        person.Speak(new WeiXin());
    }
}

//由于使用了接口使得依赖回转，我们再添加其他功能变得十分简单
interface receive{
    void GetInfo();
}

class Email implements receive{
    public void GetInfo(){
        System.out.println("邮件获取到了信息！");
    }
}
class WeiXin implements receive{

    @Override
    public void GetInfo() {
        System.out.println("微信获取到了信息！");
    }
}

class Person{
    public void Speak(receive medth){
        medth.GetInfo();
    }
}
