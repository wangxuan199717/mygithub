package com.Tempate.Adapter.DispatchAdapter;

public interface HandlerAdapter {
   boolean Support(Controller controller);
   void Handler(Controller controller);
}
class HttpHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean Support(Controller controller) {
        if(controller instanceof HttpController)
            return true;
        return false;
    }

    @Override
    public void Handler(Controller controller) {
        HttpController httpController = (HttpController)controller;
        httpController.Http();
    }

}
class SimpleHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean Support(Controller controller) {
        if(controller instanceof SimpleController)
            return true;
        return false;
    }

    @Override
    public void Handler(Controller controller) {
        SimpleController simpleController = (SimpleController)controller;
        simpleController.Simple();
    }

}
class OtherHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean Support(Controller controller) {
        if(controller instanceof OtherController)
            return true;
        return false;
    }

    @Override
    public void Handler(Controller controller) {
        OtherController otherController = (OtherController)controller;
        otherController.Other();
    }

}

