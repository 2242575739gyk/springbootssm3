package cn.jiyun.ssm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class FileContig implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private  String filepath;
    @Value("${file.upload.relative.path}")
    private  String relativePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //虚拟路径
        registry.addResourceHandler(relativePath).
                //此为真实路径
                addResourceLocations("file:/"+filepath);
    }
}
