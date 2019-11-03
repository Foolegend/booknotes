package cn.lh.restful.db.util;

public class DBSqlConst {
    public final static String CREATE_BOOK_SQL = "CREATE TABLE BOOK(" +
            "ID VARCHAR(200) PRIMARY KEY, " +
            "NAME VARCHAR(2000)," +
            "AUTHOR VARCHAR(200)," +
            "PRICE  VARCHAR(200)," +
            "GROUPID VARCHAR(200)," +
            "LEVEL  INTEGER," +
            "OPENFLAG BOOLEAN)";
}
