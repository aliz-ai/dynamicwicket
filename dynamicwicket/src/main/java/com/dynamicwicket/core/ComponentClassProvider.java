
package com.dynamicwicket.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;

public class ComponentClassProvider {
	
	private final Map<String, Class<? extends Component>> componentClasses =
		new HashMap<String, Class<? extends Component>>();
	
	private String getKey( final Class<?> keyClass ) {
		return keyClass.getSimpleName();
	}
	
	private String getKey( final Class<?> keyClass, final String propertyName ) {
		return getKey( keyClass ) + "." + propertyName;
	}
	
	public Class<? extends Component> getComponentClass( final String key ) {
		return componentClasses.get( key );
	}
	
	public Class<? extends Component> getComponentClass( final Class<?> keyClass ) {
		return componentClasses.get( getKey( keyClass ) );
	}
	
	public Class<? extends Component> getComponentClass( final Class<?> keyClass, final String propertyName ) {
		return componentClasses.get( getKey( keyClass, propertyName ) );
	}
	
	public ComponentClassProvider registerComponentClass( final String key, final Class<? extends Component> componentClass ) {
		componentClasses.put( key, componentClass );
		
		return this;
	}
	
	public ComponentClassProvider registerComponentClass( final Class<?> keyClass, final String propertyName,
		final Class<? extends Component> componentClass ) {
		
		return registerComponentClass( getKey( keyClass, propertyName ), componentClass );
	}
	
	public ComponentClassProvider registerComponentClass( final Class<?> keyClass, final Class<? extends Component> componentClass ) {
		
		return registerComponentClass( getKey( keyClass ), componentClass );
	}
	
}
