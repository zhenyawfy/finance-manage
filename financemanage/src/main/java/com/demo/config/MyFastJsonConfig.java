package com.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.demo.base.ConstantUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import java.nio.charset.Charset;

@Configuration
public class MyFastJsonConfig {
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat(ConstantUtils.DATE_FORMAT);
        config.setCharset(Charset.forName(ConstantUtils.CHARSET_UTF_8));
        config.setSerializerFeatures(SerializerFeature.WriteClassName, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
        return converter;
    }
}
