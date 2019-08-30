package cn.lh.restful;


import cn.lh.restful.application.HelloWorldApplication;
import cn.lh.restful.db.util.DBUtil;

/**
 * 修改备注：
 * @since V1.0
 */
public class BookOrderMain {

    public static void main(String[] args) throws Exception {
        DBUtil.createTable();
        //启动helloworld
        new HelloWorldApplication().run(args);
    }
}