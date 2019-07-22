package cn.lh.restful.api;

import java.util.Objects;

public class GroupInfo {
    private String id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupInfo)) return false;
        GroupInfo groupInfo = (GroupInfo) o;
        return Objects.equals(id, groupInfo.id) &&
                Objects.equals(name, groupInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
