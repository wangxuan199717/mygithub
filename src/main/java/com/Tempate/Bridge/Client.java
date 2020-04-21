package com.Tempate.Bridge;

import com.Tempate.Bridge.Brand.XiaoMi;
import com.Tempate.Bridge.Phone.FoldedPhone;
import com.Tempate.Bridge.Phone.Phone;

public class Client {
    public static void main(String[] args) {
        Phone foldedPhone = new FoldedPhone(new XiaoMi());
        foldedPhone.Call();
    }
}
