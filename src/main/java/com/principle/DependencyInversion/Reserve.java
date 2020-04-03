package com.principle.DependencyInversion;

public class Reserve {
    public static void main(String[] args) {
        Person person = new Person();
        person.Speak(new Email());
    }
}


//分析：由于person类的方法依赖于一个email类，违反了依赖倒转原则
class Email{
    public void GetInfo(){
        System.out.println("邮件获取到了信息！");
    }
}

class Person{
    public void Speak(Email email){
        email.GetInfo();
    }
}
