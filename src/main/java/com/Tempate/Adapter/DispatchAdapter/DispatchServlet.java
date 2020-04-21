package com.Tempate.Adapter.DispatchAdapter;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {
    List<HandlerAdapter> handlerAdapters = new ArrayList<>();
    public DispatchServlet(){
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
        handlerAdapters.add(new OtherHandlerAdapter());
    }

    public void doDispath(){
        HttpController httpController = new HttpController();
        SimpleController simpleController = new SimpleController();
        HandlerAdapter handlerAdapter = getHandler(httpController);
        if(handlerAdapter!=null){
            handlerAdapter.Handler(httpController);
        }

        handlerAdapter = getHandler(simpleController);
        handlerAdapter.Handler(simpleController);
    }
    public HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter adapter:handlerAdapters){
            if(adapter.Support(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DispatchServlet dispatchServlet = new DispatchServlet();
        dispatchServlet.doDispath();
    }
}
