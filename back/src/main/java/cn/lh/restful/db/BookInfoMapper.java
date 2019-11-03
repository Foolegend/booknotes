package cn.lh.restful.db;

import cn.lh.restful.api.BookInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookInfoMapper {
    @Insert("insert into book(id,name,author,price, groupid, level) values(#{id},#{name},#{author},#{price},#{groupid}, #{level})")
    int addBookInfo(BookInfo bookInfo);

    @Select("select * from book where id = #{id}")
    BookInfo getBookInfo(String id);

    @Update("update book set name=#{name},author=#{author},price=#{price} where id = #{id}")
    int updateBookInfo(BookInfo bookInfo);

    @Delete("delete from book where id=#{id} or groupid=#{id}")
    int deleteBookInfo(String id);

    @Select("select * from  book")
    List<BookInfo> getBookInfos();

    @Delete("delete from book where groupid=#{groupid}")
    int deleteBookInfos(String groupid);
}
