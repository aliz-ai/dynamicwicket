
package com.dynamicwicket.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dynamicwicket.form.component.filter.MetaComponentFilter;

public class DynamicProcessor {
	
	private final MetaContextInitializer metaContextInitializer;
	private final List<MetaContextProcessor> metaContextProcessors = new ArrayList<MetaContextProcessor>();
	
	private List<MetaComponentFilter> filters;
	
	public List<MetaContextProcessor> getDynamicFormMetaProcessors() {
		return metaContextProcessors;
	}
	
	public void addDynamicProcessors( final MetaContextProcessor dynamicFormMetaProcessor,
		final MetaContextProcessor... dynamicFormMetaProcessors ) {
		this.metaContextProcessors.add( dynamicFormMetaProcessor );
		this.metaContextProcessors.addAll( Arrays.asList( dynamicFormMetaProcessors ) );
	}
	
	public DynamicProcessor( final MetaContextInitializer dynamicFormMetaInitializator ) {
		this.metaContextInitializer = dynamicFormMetaInitializator;
	}
	
	protected MetaContext getDynamicFormContext() {
		if (filters != null) {
			metaContextInitializer.filters( filters );
		}
		
		return metaContextInitializer.initialize();
	}
	
	public MetaContext process() {
		MetaContext FormMetaContext = getDynamicFormContext();
		
		for (MetaContextProcessor dynamicFormMetaProcessor : metaContextProcessors) {
			dynamicFormMetaProcessor.process( FormMetaContext );
		}
		
		return FormMetaContext;
	}
	
	private void addFilter( final MetaComponentFilter componentFilter ) {
		if (filters == null) {
			filters = new ArrayList<MetaComponentFilter>();
		}
		
		filters.add( componentFilter );
	}
	
	public DynamicProcessor addFilter( final MetaComponentFilter componentFilter,
		final MetaComponentFilter... componentFilters ) {
		addFilter( componentFilter );
		
		if (componentFilters != null && componentFilters.length != 0) {
			
			for (MetaComponentFilter filter : componentFilters) {
				addFilter( filter );
			}
			
		}
		
		return this;
	}
	
}
