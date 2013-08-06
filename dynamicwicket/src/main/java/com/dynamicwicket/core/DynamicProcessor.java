package com.dynamicwicket.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProcessor {
	
	private final MetaContextInitializer metaContextInitializer;
	private final List<MetaContextProcessor> metaContextProcessors = new ArrayList<MetaContextProcessor>();
	
	public List<MetaContextProcessor> getDynamicFormMetaProcessors() {
		return metaContextProcessors;
	}
	
	public void addDynamicProcessors(MetaContextProcessor dynamicFormMetaProcessor, MetaContextProcessor... dynamicFormMetaProcessors) {
		this.metaContextProcessors.add(dynamicFormMetaProcessor);
		this.metaContextProcessors.addAll(Arrays.asList(dynamicFormMetaProcessors));
	}
	
	public DynamicProcessor(MetaContextInitializer dynamicFormMetaInitializator) {
		this.metaContextInitializer = dynamicFormMetaInitializator;
	}
	
	protected MetaContext getDynamicFormContext() {
		return metaContextInitializer.initialize();
	}
	
	public MetaContext process() {
		MetaContext FormMetaContext = getDynamicFormContext();
		
		for (MetaContextProcessor dynamicFormMetaProcessor : metaContextProcessors) {
			dynamicFormMetaProcessor.process(FormMetaContext);
		}
		
		return FormMetaContext;
	}
	
}
