package cn.lh.restful.resources;

import cn.lh.restful.api.HandlerBookInfoDao;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <b>TODO(com.demo1.helloworld.resources @TODO)</b><br>
 * 版权所有 <a href="http://www.whndj.com">中国，華少</a><br>
 * 本软件仅对本次教程负责，其版权归属cnHuaShao，如需引用，请申明其版权所有人。
 *
 * @Description: TODO 创建人：toplion
 * @CreateDate 2017 2017/11/4 11:19 11 修改人：toplion
 * <a href="mailto:lz2392504@gmail.com">cnHuaShao</a>
 * 修改备注：
 * @since V1.0
 */
@Path("/api")//跳转地址
@Produces(MediaType.APPLICATION_JSON)//返回的数据类型
public class BookInfoResource {


    public BookInfoResource() {
    }

    /**
     * @Timed dropwizard会自动记录时间和它的调用率作为度量定时器
     * @return
     * @QueryParam 为URL链接后面的参数（url ？{参数名} = {参数值} 的格式）
     */
    @GET//客户端访问时只能通过get方法访问
    @Timed
    @Path("/getbookinfo")
    public String getBookInfo() {
        return HandlerBookInfoDao.getBookInfos();
    }

    @POST
    @Path("/modifybookinfo")
    public String modifyBookInfo(String message) {
        System.out.println("You posted " + message);
        return HandlerBookInfoDao.modifyBookInfo(message);
    }


    @GET
    @Path("/deletebookinfo")
    public String deleteBookInfo(@QueryParam("id") String id) {
        System.out.println("You get " + id);
        return HandlerBookInfoDao.deleteBookInfo(id);
    }

    @POST
    @Path("/addbookinfo")
    public String addBookInfo(String message) {
        System.out.println("You posted " + message);
        return  HandlerBookInfoDao.addBookInfo(message);
    }
}