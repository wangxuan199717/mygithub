package com.Tempate.Proxy.Dynamic;

public class TeacherDao implements ITeacherDao {
    public void teach() {
        System.out.println("老师在教java课程！");
    }

    @Override
    public void homework() {
        System.out.println("老师布置作业！");
    }
}
