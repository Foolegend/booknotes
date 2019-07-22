package cn.lh.restful.db;

import cn.lh.restful.api.BookInfo;
import cn.lh.restful.api.GroupBookInfo;
import cn.lh.restful.api.GroupInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class DbDaoService {
    private static SqlSession session;
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //加载 mybatis 配置文件
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("conf/mybatis-configuration.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("load mybatis config failed.");
        }
        //构建sqlSession的工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    public static List<GroupBookInfo> getGroupBookInfos(){
        openSession(sqlSessionFactory);
        GroupInfoMapper mapper = session.getMapper(GroupInfoMapper.class);
        //返回书列表
        List<GroupBookInfo> groupBookInfos = mapper.getGroupInfos();
        closeSession();
        return groupBookInfos;
    }

    public static BookInfo getBookInfo(String id){
        openSession(sqlSessionFactory);
        BookInfoMapper mapper = session.getMapper(BookInfoMapper.class);
        //返回书列表
        BookInfo bookInfo = mapper.getBookInfo(id);
        closeSession();
        return bookInfo;
    }


    public  static void addBookInfo(BookInfo bookInfo){
        openSession(sqlSessionFactory);
        BookInfoMapper mapper = session.getMapper(BookInfoMapper.class);
        mapper.addBookInfo(bookInfo);
        closeSession();
    }

    public  static void updateBookInfo(BookInfo bookInfo){
        openSession(sqlSessionFactory);
        BookInfoMapper mapper = session.getMapper(BookInfoMapper.class);
        //调用增加方法
        mapper.updateBookInfo(bookInfo);
        closeSession();
    }


    public static void deleteBookInfo(String id){
        openSession(sqlSessionFactory);
        BookInfoMapper mapper = session.getMapper(BookInfoMapper.class);
        mapper.deleteBookInfo(id);
        closeSession();
    }

    private static void openSession(SqlSessionFactory sqlSessionFactory){
        //根据 sqlSessionFactory 产生 session
        session =  sqlSessionFactory.openSession();
    }

    private static void closeSession(){
        session.commit();
        session.close();
    }


}
