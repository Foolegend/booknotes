package cn.lh.restful.api;

import cn.lh.restful.db.DbDaoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerBookInfoDao {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String getBookInfos() {
        List<BookInfo> resList = new ArrayList<BookInfo>();
        List<BookInfo> bookInfoList = DbDaoService.getBookInfos();
        Map<String, BookInfo> bookInfoMap = new HashMap<String, BookInfo>(bookInfoList.size());
        for(BookInfo bookInfo : bookInfoList){
            bookInfoMap.put(bookInfo.getId(), bookInfo);
        }
        for(BookInfo bookInfo : bookInfoList){
            if(bookInfo.getLevel() == 0){
                resList.add(bookInfo);
            }else{
                BookInfo parentBookInfo = bookInfoMap.get(bookInfo.getGroupid());
                bookInfo.setLevel(parentBookInfo.getLevel() + 1);
                parentBookInfo.addBookInfo(bookInfo);
            }
        }
        return gson.toJson(resList);
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
        book.setGroupid(bookInfo.getGroupid());
        book.setLevel(book.getLevel() + 1);
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
