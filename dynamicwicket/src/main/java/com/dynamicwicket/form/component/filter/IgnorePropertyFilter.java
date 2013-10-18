
package com.dynamicwicket.form.component.filter;

import java.beans.PropertyDescriptor;

public class IgnorePropertyFilter implements MetaComponentFilter {
	
	private String ignoredPropertyName;
	private Class<?> ignoredPropertyClass;
	
	private IgnorePropertyFilter() {
		super();
	}
	
	public IgnorePropertyFilter( final String ignoredPropertyName ) {
		this();
		this.ignoredPropertyName = ignoredPropertyName;
	}
	
	public IgnorePropertyFilter( final Class<?> ignoredPropertyClass ) {
		this();
		this.ignoredPropertyClass = ignoredPropertyClass;
	}
	
	public IgnorePropertyFilter( final Class<?> ignoredPropertyClass, final String ignoredPropertyName ) {
		this();
		this.ignoredPropertyName = ignoredPropertyName;
		this.ignoredPropertyClass = ignoredPropertyClass;
	}
	
	public boolean filter( final PropertyDescriptor propertyDescriptor ) {
		String propertyName = propertyDescriptor.getName();
		Class<?> propertyClass = propertyDescriptor.getPropertyType();
		
		if (isEmptyString( ignoredPropertyName ) && ignoredPropertyClass != null) {
			
			if (propertyName.equalsIgnoreCase( ignoredPropertyName ) && propertyClass.isAssignableFrom( ignoredPropertyClass )) {
				return true;
			}
			
		}
		
		if (isEmptyString( ignoredPropertyName )) {
			
			if (propertyName.equalsIgnoreCase( ignoredPropertyName )) {
				return true;
			}
			
		}
		
		if (ignoredPropertyClass != null) {
			
			if (propertyClass.isAssignableFrom( ignoredPropertyClass )) {
				return true;
			}
			
		}
		
		return false;
	}
	
	private static boolean isEmptyString( final String obj ) {
		return obj == null || obj.isEmpty();
	}
	
}
