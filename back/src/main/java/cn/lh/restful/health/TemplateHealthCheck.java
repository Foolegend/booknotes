package cn.lh.restful.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * <b>TODO(com.demo1.helloworld.health @TODO)</b><br>
 * 版权所有 <a href="http://www.whndj.com">中国，華少</a><br>
 * 本软件仅对本次教程负责，其版权归属cnHuaShao，如需引用，请申明其版权所有人。
 *
 * @Description: TODO 创建人：toplion
 * @CreateDate 2017 2017/11/4 11:37 11 修改人：toplion
 * <a href="mailto:lz2392504@gmail.com">cnHuaShao</a>
 * 修改备注：
 * @since V1.0
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "模板测试");
        if (!saying.contains("模板测试")) {
            return Result.unhealthy("该模板不包含名称");
        }
        return Result.healthy();
    }


}