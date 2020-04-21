package com.Tempate.Proxy.Static;

public class TeacherDaoProxy implements ITeacherDao {
    ITeacherDao iTeacherDao;
    public TeacherDaoProxy(ITeacherDao iTeacherDao){
        this.iTeacherDao= iTeacherDao;
    }
    public void teach() {
        System.out.println("代理老师来了");
        iTeacherDao.teach();
        System.out.println("代理走了");
    }
}
