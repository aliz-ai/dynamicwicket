
package com.dynamicwicket.core;

import java.beans.PropertyDescriptor;
import java.util.List;

import com.dynamicwicket.form.component.filter.MetaComponentFilter;

public abstract class AbstractMetaContextInitializer implements MetaContextInitializer {
	
	private List<MetaComponentFilter> filters;
	
	protected MetaComponent createMetaComponent( final PropertyDescriptor propertyDescriptor ) {
		for (MetaComponentFilter filter : filters) {
			
			if (filter.filter( propertyDescriptor )) {
				return null;
			}
			
		}
		
		return new MetaComponent( propertyDescriptor.getName() );
	}
	
	public void filters( final List<MetaComponentFilter> filters ) {
		this.filters = filters;
	}
	
}
