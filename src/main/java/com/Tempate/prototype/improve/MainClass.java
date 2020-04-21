package com.Tempate.prototype.improve;

public class MainClass {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",2);
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();

        RISResult risResult = RISResult.I;
        System.out.println(risResult.getId()+"+"+risResult.getResult()+risResult.name());

    }
}

enum RISResult {
    R(1,"耐药(R)"),I(2,"中介(I)"),
    S(3, "敏感(S)"),X(4, "X"),
    NOT_EXIST(5, "-");


    private long id;
    private String result;

    RISResult(long id, String result) {
        this.id = id;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    public static String getResultById(Long id) {
        if (id == 1) {
            return R.result;
        } else if (id == 2) {
            return I.result;
        } else if (id == 3) {
            return S.result;
        } else if (id == 4) {
            return X.result;
        } else if (id == 5) {
            return NOT_EXIST.result;
        } else {
            return null;
        }
    }
}
