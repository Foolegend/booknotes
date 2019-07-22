package cn.lh.restful.api;

import java.util.Objects;

public class BookInfo {
    private String id;
    private String name;
    private String author;
    private  String price;
    private String  groupid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookInfo)) return false;
        BookInfo bookInfo = (BookInfo) o;
        return Objects.equals(id, bookInfo.id) &&
                Objects.equals(name, bookInfo.name) &&
                Objects.equals(author, bookInfo.author) &&
                Objects.equals(price, bookInfo.price) &&
                Objects.equals(groupid, bookInfo.groupid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, price, groupid);
    }
}