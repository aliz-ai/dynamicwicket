
package com.dynamicwicket.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectionUtil {
	
	private ReflectionUtil() {}
	
	public static Method getReadMethod( final Class<?> clazz, final String methodName ) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo( clazz );
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				if (propertyDescriptor.getName().equals( methodName )) {
					return propertyDescriptor.getReadMethod();
				}
			}
			
		}
		
		catch (IntrospectionException e) {
			throw new RuntimeException( "Unhandled exception!", e );
		}
		
		return null;
	}
	
	public static <T extends Annotation> T getAnnotation( final Class<?> clazz, final Class<T> annotationClass, final String property ) {
		Method readMethod = ReflectionUtil.getReadMethod( clazz, property );
		
		if (readMethod != null) {
			return readMethod.getAnnotation( annotationClass );
		}
		
		return null;
	}
	
}
