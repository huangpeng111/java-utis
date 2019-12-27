package com.cy.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	/**
	 * 对象转json
	 */
	public static String toJson(Object obj) {
		String json = null;
		try {
			json = MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return json;
	}
	
	public static <T>T toObject(String json , Class<T> targetClass) {
		T t;
		try {
			t = MAPPER.readValue(json, targetClass);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return t;
	}

	public static <T>T toObject(String json, TypeReference typeReference) {
	  T t;
		try {
			t = MAPPER.readValue(json, typeReference);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return t;
	}

}
