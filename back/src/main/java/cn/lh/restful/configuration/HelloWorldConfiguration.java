package cn.lh.restful.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <b>TODO(com.demo1.helloworld.configuration @TODO)</b><br>
 * 版权所有 <a href="http://www.whndj.com">中国，華少</a><br>
 * 本软件仅对本次教程负责，其版权归属cnHuaShao，如需引用，请申明其版权所有人。
 *
 * @Description: TODO 创建人：toplion
 * @CreateDate 2017 2017/11/4 10:31 11 修改人：toplion
 * <a href="mailto:lz2392504@gmail.com">cnHuaShao</a>
 * 修改备注：
 * @since V1.0
 */
public class HelloWorldConfiguration extends Configuration {

    /**
     * NotEmpty注解表示该变量不可以为空，之前我们在demo1.yml中已经编写了该变量对应的值，这个类主要是将其进行反序列化
     */
    @NotEmpty
    private String template;

    /**
     * NotEmpty注解表示该变量不可以为空，之前我们在demo1.yml中已经编写了该变量对应的值，这个类主要是将其进行反序列化
     * 默认值直接写入Stranger，这里根据自己的demo1.yml中defaultName默认值写的是什么就直接赋值什么，当然也可以不赋值，等具体引用时在赋值，不过建议还是写上去一个默认值，防止它出错。
     * 如果这两个值是空，则抛出系统异常
     */
    @NotEmpty
    private String defaultName = "Stranger";

    /**
     * 这里get set进行注解JsonProperty主要是为了对yml进行反序列化使用
     * @return
     */
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

}
