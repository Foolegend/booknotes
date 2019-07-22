package cn.lh.restful.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HandlerBookInfoJson {
    private static List<BookInfo> bookInfoList = new ArrayList<BookInfo>();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String BOOKINFO_PATH = "bookinfo.json";

    public static String getBookInfo() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(BOOKINFO_PATH), "UTF-8"));
            bookInfoList = gson.fromJson(reader, new TypeToken<List<BookInfo>>(){}.getType());
            return gson.toJson(bookInfoList);
        } catch (FileNotFoundException ex) {
            System.out.println("文件找不到");
        } catch (UnsupportedEncodingException e) {
            System.out.println("无法解析的字符集");
        } finally {
            System.out.println("处理结束");
        }
        return "";
    }

    public static void modifyBookInfo(String message){
        BookInfo bookInfo = gson.fromJson(message, BookInfo.class);
        for(BookInfo book : bookInfoList){
            if(book.getId().equals(bookInfo.getId())){
                book.setAuthor(bookInfo.getAuthor());
                book.setName(bookInfo.getName());
                book.setPrice(bookInfo.getPrice());
                break;
            }
        }
        updateBookInfos();
    }

    public static void addBookInfo(String message){
        BookInfo bookInfo = gson.fromJson(message, BookInfo.class);
        BookInfo book = new BookInfo();
        book.setId(bookInfo.getId());
        book.setAuthor(bookInfo.getAuthor());
        book.setName(bookInfo.getName());
        book.setPrice(bookInfo.getPrice());
        bookInfoList.add(book);
        updateBookInfos();
    }

    public static void deleteBookInfo(String id){
        Iterator<BookInfo> iter = bookInfoList.iterator();
        while(iter.hasNext()){
            BookInfo bookInfo = iter.next();
            if(bookInfo.getId().equals(id)){
               bookInfoList.remove(bookInfo);
            }
        }
        updateBookInfos();
    }

    private static void updateBookInfos(){
        OutputStreamWriter writer = null;

        try{
            writer = new OutputStreamWriter(new FileOutputStream(BOOKINFO_PATH), "UTF-8");
            writer.write(gson.toJson(bookInfoList));
        } catch (UnsupportedEncodingException e) {
            System.out.println("无法解析的字符集");
        } catch (FileNotFoundException e) {
            System.out.println("文件找不到");
        } catch (IOException e) {
            System.out.println("output File failed");
        }finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
