
package com.dynamicwicket.core;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class ClassBasedMetaContextInitializer extends AbstractMetaContextInitializer {
	
	private final Class<?> clazz;
	
	public ClassBasedMetaContextInitializer( final Class<?> clazz ) {
		this.clazz = clazz;
	}
	
	public ClassBasedMetaContextInitializer( final Object object ) {
		this( object.getClass() );
	}
	
	public MetaContext initialize() {
		List<MetaComponent> metaComponents = new ArrayList<MetaComponent>();
		
		try {
			
			BeanInfo beanInfo = Introspector.getBeanInfo( clazz );
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				MetaComponent metaComponent = createMetaComponent( propertyDescriptor );
				
				if (metaComponent != null) {
					metaComponents.add( metaComponent );
				}
				
			}
			
		}
		catch (IntrospectionException e) {
			throw new RuntimeException( e );
		}
		
		MetaContext context = new MetaContext();
		context.setMetaComponents( metaComponents );
		
		return context;
	}
	
}
