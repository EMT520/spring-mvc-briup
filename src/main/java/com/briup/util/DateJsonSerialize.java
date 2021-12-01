package com.briup.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将Date对象转换为指定格式的json字符串
 */
public class DateJsonSerialize extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        System.out.println("将日期对象转换为指定字符串格式返回前端页面");
        //1.设置时间转换格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        jsonGenerator.writeString(format.format(date));
        //将Date()对象转换为yyyy-MM-dd格式的字符串 拼接到Studentjson字符串
    }
}
