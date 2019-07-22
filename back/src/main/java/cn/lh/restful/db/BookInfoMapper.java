package cn.lh.restful.db;

import cn.lh.restful.api.BookInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookInfoMapper {
    @Insert("insert into book(id,name,author,price) values(#{id},#{name},#{author},#{price})")
    public int addBookInfo(BookInfo bookInfo);


    @Select("select * from book where id = #{id}")
    public BookInfo getBookInfo(String id);

    @Select("select * from book")
    public List<BookInfo> getBookInfos();

    @Select("select * from book where groupid=#{groupid}")
    public List<BookInfo> getBookInfosByGroupid(String groupid);

    @Update("update book set name=#{name},author=#{author},price=#{price} where id = #{id}")
    public int updateBookInfo(BookInfo bookInfo);

    @Delete("delete from book where id=#{id}")
    public int deleteBookInfo(String id);
}
