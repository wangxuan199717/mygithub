package com.Tempate.Adapter.DispatchAdapter;

public interface Controller {
}

class HttpController implements Controller{
    public void Http(){
        System.out.println("Http....");
    }
}

class SimpleController implements Controller{
    public void Simple(){
        System.out.println("Simple....");
    }
}

class OtherController implements Controller{
    public void Other(){
        System.out.println("Other....");
    }
}