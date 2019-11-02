package cn.lh.restful.resources;

import cn.lh.restful.api.HandlerBookInfoDao;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")//跳转地址
@Produces(MediaType.APPLICATION_JSON)//返回的数据类型
public class BookInfoResource {

    @GET//客户端访问时只能通过get方法访问
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