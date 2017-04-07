package com.takucin.aceeci.frame.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParameterModel implements Map<String, Object>  {

	private Map<String,Object> maps = new HashMap<String, Object>();
	
	public void clear() {
		maps.clear();
	}

	public boolean containsKey(Object key) {
		return maps.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return maps.containsValue(value);
	}

	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return maps.entrySet();
	}

	public Object get(Object key) {
		return maps.get(key);
	}

	public boolean isEmpty() {
		return maps.isEmpty();
	}

	public Set<String> keySet() {
		return maps.keySet();
	}

	public Object put(String key, Object value) {
		if(value == null){
			return null;
		}
		return maps.put(key, value);
	}
	
	public Object putAllowNull(String key) {
		return maps.put(key, null);
	}

	public void putAll(Map<? extends String, ? extends Object> t) {
		maps.putAll(t);
	}

	public Object remove(Object key) {
		return maps.remove(key);
	}

	public int size() {
		return maps.size();
	}

	public Collection<Object> values() {
		return maps.values();
	}

	
}
