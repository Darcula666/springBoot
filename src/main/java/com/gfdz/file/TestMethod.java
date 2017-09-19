package com.gfdz.file;

public class TestMethod {
    public TestMethod() { //xx/weblogic60b2_win.exe
        try {
            //SiteInfoBean bean = new SiteInfoBean("http://localhost:8080/down.zip","L:\\temp","weblogic60b2_win.exe", 5);
            SiteInfoBean bean = new SiteInfoBean("http://220.163.128.18:9096//plug-in/drive/IE11.exe", "E:\\temp", "333.exe", 10);
            SiteFileFetch fileFetch = new SiteFileFetch(bean);
            fileFetch.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new TestMethod();
    }
}
