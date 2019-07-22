package cn.lh.restful.api;

import cn.lh.restful.db.DbDaoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HandlerBookInfoDao {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String getBookInfos() {
        return gson.toJson(DbDaoService.getGroupBookInfos());
    }


    public static String modifyBookInfo(String message){
        BookInfo bookInfo = gson.fromJson(message, BookInfo.class);
        if(DbDaoService.getBookInfo(bookInfo.getId()) != null){
            DbDaoService.updateBookInfo(bookInfo);
            return "sucess update book in database";
        }else{
            return "book not exist in database.id=" + bookInfo.getId();

        }
    }

    public static String addBookInfo(String message){
        BookInfo bookInfo = gson.fromJson(message, BookInfo.class);
        BookInfo book = new BookInfo();
        book.setId(bookInfo.getId());
        book.setAuthor(bookInfo.getAuthor());
        book.setName(bookInfo.getName());
        book.setPrice(bookInfo.getPrice());
        if(DbDaoService.getBookInfo(book.getId()) == null){
            DbDaoService.addBookInfo(bookInfo);
            return "sucess insert book into database";
        }else{
            return "book has exist in database.id=" + bookInfo.getId();

        }
    }

    public static String deleteBookInfo(String id){
        DbDaoService.deleteBookInfo(id);
        return "success to delete bookinfo.id=" + id;
    }
}
