package com.Tempate.Bridge;

import com.Tempate.Bridge.Brand.XiaoMi;
import com.Tempate.Bridge.Phone.FoldedPhone;

public class Client {
    public static void main(String[] args) {
        FoldedPhone foldedPhone = new FoldedPhone(new XiaoMi());
        foldedPhone.FoldCall();


    }
}
