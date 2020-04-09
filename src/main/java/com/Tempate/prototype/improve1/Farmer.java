package com.Tempate.prototype.improve1;

import java.io.*;

public class Farmer implements Serializable {
    String name;
    Sheep sheep;

    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", sheep=" + sheep +
                '}';
    }

    public Farmer(String name){
        this.name=name;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        //序列化
        bos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //反序列化
        bis = new ByteArrayInputStream(bos.toByteArray());
        ois = new ObjectInputStream(bis);
        Farmer farmer = (Farmer) ois.readObject();
        return  farmer;
    }

}
