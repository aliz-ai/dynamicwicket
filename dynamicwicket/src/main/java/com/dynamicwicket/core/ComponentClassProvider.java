package com.dynamicwicket.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;

public class ComponentClassProvider {
	
	private Map<String, Class<? extends Component>> componentClasses =
		new HashMap<String, Class<? extends Component>>();
	
	private String getKey(Class<?> keyClass) {
		return keyClass.getSimpleName();
	}
	
	private String getKey(Class<?> keyClass, String propertyName) {
		return getKey(keyClass) + "." + propertyName;
	}
	
	public Class<? extends Component> getComponentClass(String key) {
		return componentClasses.get(key);
	}
	
	public Class<? extends Component> getComponentClass(Class<?> keyClass) {
		return componentClasses.get(getKey(keyClass));
	}
	
	public Class<? extends Component> getComponentClass(Class<?> keyClass, String propertyName) {
		return componentClasses.get(getKey(keyClass, propertyName));
	}
	
	public ComponentClassProvider registerComponentClass(String key, Class<? extends Component> componentClass) {
		componentClasses.put(key, componentClass);
		
		return this;
	}
	
	public ComponentClassProvider registerComponentClass(Class<?> keyClass, String propertyName,
		Class<? extends Component> componentClass)
	{
		registerComponentClass(getKey(keyClass, propertyName), componentClass);
		
		return this;
	}
	
	public ComponentClassProvider registerComponentClass(Class<?> keyClass, Class<? extends Component> componentClass) {
		registerComponentClass(getKey(keyClass), componentClass);
		
		return this;
	}
	
}
