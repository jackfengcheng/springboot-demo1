package com.xwtech.demo.util;


import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

@Slf4j
public class JsonMapper {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    }

    public static <T> String objToString(T src){
        if (src == null){
            return  null;
        }
        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        }catch (Exception e){
            log.warn("parse Object to  String exception,errors:{}",e);
            return null;
        }
    }

    public static <T> T stringToObject(String src, TypeReference<T> tTypeReference){
        if (src == null || tTypeReference ==null){
            return  null;
        }
        try {
            return (T) (tTypeReference.getType().equals(String.class) ? src : objectMapper.readValue(src,tTypeReference));
        }catch (Exception e){
            log.warn("parse String to  Object exception,String:{},tTypeReference:{},errors:{}",src,tTypeReference.getType(),e);
            return null;
        }
    }
}
