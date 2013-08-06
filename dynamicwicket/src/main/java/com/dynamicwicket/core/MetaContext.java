package com.dynamicwicket.core;

import java.util.ArrayList;
import java.util.List;

public class MetaContext {
	
	private List<MetaComponent> metaComponents = new ArrayList<MetaComponent>();
	
	public List<MetaComponent> getMetaComponents() {
		return metaComponents;
	}
	
	public void setMetaComponents(List<MetaComponent> metaComponents) {
		this.metaComponents = metaComponents;
	}
	
}
