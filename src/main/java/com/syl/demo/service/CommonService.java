package com.syl.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *
 */
abstract class CommonService {
    public String ObjectToJson(Object object){

        return  JSON.toJSONString(object,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.PrettyFormat,
                SerializerFeature.SortField);

    }
}
