package com.ly.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class FastJsonUtils {
	/**
	 * json字符串转map集合
	 * 
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, String> json2Map(String jsonStr) {
		return JSON.parseObject(jsonStr, new HashMap<String, String>().getClass());
	}

	/**
	 * map转json字符串
	 * 
	 * @param map
	 * @return
	 */
	public static String map2Json(Map<String, String> map) {
		String jsonStr = JSON.toJSONString(map);
		return jsonStr;
	}

	/**
	 * json字符串转换成对象
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T json2Bean(String jsonString, Class<T> cls) {
		T t = null;
		try {
			t = JSON.parseObject(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 对象转换成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String bean2Json(Object obj) {
		return JSON.toJSONString(obj);
	}

	/**
	 * json字符串转换成List集合 (需要实体类)
	 * 
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> json2List(String jsonString, Class cls) {
		List<T> list = null;
		try {
			list = JSON.parseArray(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * json字符串转换成ArrayList集合 (需要实体类)
	 * 
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ArrayList<T> json2ArrayList(String jsonString, Class cls) {
		ArrayList<T> list = null;
		try {
			list = (ArrayList<T>) JSON.parseArray(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * List集合转换成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String list2Json(Object obj) {
		return JSONArray.toJSONString(obj, true);
	}

	/**
	 * json转List (不需要实体类)
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static JSONArray json2List(String jsonStr) {
		return JSON.parseArray(jsonStr);
	}
	
	public static void main(String[] args) throws IOException {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("tag", "data");
		dataMap.put("hospitalName", "宜都市妇幼保健院");
		dataMap.put("name", "欧阳夏凡");
		dataMap.put("gender", "女");
		dataMap.put("age", "28");
		dataMap.put("code", "420502042");
		dataMap.put("examineDoc", "杨林");
		dataMap.put("examineDate", "2016-05-10");
		dataMap.put("verifyDoc", "王菲");
		
 
		Map<String,Object> dataMap2 = new HashMap<String,Object>();
		dataMap2.put("no", "340812");
		dataMap2.put("name", "古夕旸");
		 
//		
		String jsonString=JSON.toJSONString(dataMap);
		System.out.println(jsonString);
		list.add(dataMap);
		list.add(dataMap2);
//		String jsonString2=mapper.writeValueAsString(list);
		String jsonString2=JSON.toJSONString(list);
		System.out.println(jsonString2);
		
		
		
		
	}
}
