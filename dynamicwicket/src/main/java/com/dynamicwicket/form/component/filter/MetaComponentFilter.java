
package com.dynamicwicket.form.component.filter;

import java.beans.PropertyDescriptor;

public interface MetaComponentFilter {
	
	boolean filter( PropertyDescriptor propertyDescriptor );
	
}
