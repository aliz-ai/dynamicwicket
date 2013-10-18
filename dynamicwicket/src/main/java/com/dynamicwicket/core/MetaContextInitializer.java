
package com.dynamicwicket.core;

import java.util.List;

import com.dynamicwicket.form.component.filter.MetaComponentFilter;

public interface MetaContextInitializer {
	
	MetaContext initialize();
	
	void filters( List<MetaComponentFilter> filters );
	
}
