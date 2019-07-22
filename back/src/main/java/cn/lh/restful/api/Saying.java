package cn.lh.restful.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * <b>TODO(com.demo1.helloworld.api @TODO)</b><br>
 * 版权所有 <a href="http://www.whndj.com">中国，華少</a><br>
 * 本软件仅对本次教程负责，其版权归属cnHuaShao，如需引用，请申明其版权所有人。
 *
 * @Description: TODO 创建人：toplion
 * @CreateDate 2017 2017/11/4 11:07 11 修改人：toplion
 * <a href="mailto:lz2392504@gmail.com">cnHuaShao</a>
 * 修改备注：
 * @since V1.0
 */
public class Saying {

    private long id;

    /**
     * 内容最大长度不可以超过10
     */
    @Length(max = 10)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}