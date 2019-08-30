package cn.lh.restful.application;

import cn.lh.restful.configuration.HelloWorldConfiguration;
import cn.lh.restful.resources.BookInfoResource;
import cn.lh.restful.health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * <b>TODO(com.demo1.helloworld.application @TODO)</b><br>
 * 版权所有 <a href="http://www.whndj.com">中国，華少</a><br>
 * 本软件仅对本次教程负责，其版权归属cnHuaShao，如需引用，请申明其版权所有人。
 *
 * @Description: TODO 创建人：toplion
 * @CreateDate 2017 2017/11/4 10:58 11 修改人：toplion
 * <a href="mailto:lz2392504@gmail.com">cnHuaShao</a>
 * 修改备注：
 * @since V1.0
 */
public class HelloWorldApplication  extends Application<HelloWorldConfiguration> {

    /**
     * 基础核心启动方法。dropwizard应用的核心方法。主要进行处理具体的业务逻辑的类
     * @param configuration
     * @param environment
     * @throws Exception
     */
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        //声明一个resource，并传入初始化的值，该值由configuration读取的yml配置文件中的值。
        //可以启动多个resource
        final BookInfoResource resource = new BookInfoResource();

        environment.jersey().register(resource);
    }

    @Override
    public String getName() {
        return "hello-world";
    }


}