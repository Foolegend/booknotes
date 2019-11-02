package cn.lh.restful.db;

import cn.lh.restful.api.GroupBookInfo;
import cn.lh.restful.api.GroupInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GroupInfoMapper {
    @Insert("insert into bookgroup(id,name) values(#{id},#{name}")
    public int addGroupInfo(GroupInfo groupInfo);

    @Select("select * from bookgroup where id = #{id}")
    public GroupInfo getGroupInfo(String id);

    @Results({@Result(property = "id", column = "id"),
            @Result(property="bookInfos",column="id",many=@Many(select="cn.lh.restful.db.BookInfoMapper.getBookInfosByGroupid"))
    })
    @Select("select * from  book")
    public List<GroupBookInfo> getGroupInfos();

    @Update("update bookgroup set name=#{name} where id = #{id}")
    public int updateGroupInfo(GroupInfo groupInfo);

    @Delete("delete from bookgroup where id=#{id}")
    public int deleteGroupInfo(String id);
}
