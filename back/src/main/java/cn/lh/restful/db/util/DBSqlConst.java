package cn.lh.restful.db.util;

public class DBSqlConst {
    public final static String CREATE_BOOK_SQL = "create table book(" +
            "id varchar(200) primary key, " +
            "name varchar(2000)," +
            "author varchar(200)," +
            "price  varchar(200)," +
            "groupid varchar(200))";
}
