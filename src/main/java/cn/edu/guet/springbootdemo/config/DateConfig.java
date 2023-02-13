package cn.edu.guet.springbootdemo.config;

/**
 * @Author liwei
 * @Date 2023/2/13 12:35
 * @Version 1.0
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class DateConfig {

    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverterConfiguration() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper om = new ObjectMapper();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("China"));
        //全局修改josn时间格式
        om.setDateFormat(sdf);
        converter.setObjectMapper(om);
        return converter;
    }
}

