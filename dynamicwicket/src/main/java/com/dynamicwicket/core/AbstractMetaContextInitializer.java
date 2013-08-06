package com.dynamicwicket.core;

public abstract class AbstractMetaContextInitializer implements MetaContextInitializer {
	
	protected MetaComponent createMetaComponent(String name) {
		return new MetaComponent(name);
	}
	
}
