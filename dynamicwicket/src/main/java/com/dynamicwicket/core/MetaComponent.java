package com.dynamicwicket.core;

import org.apache.wicket.Component;

public class MetaComponent {
	
	private final String name;
	private Class<? extends Component> componentClass;
	private Component componentInstance;
	
	public MetaComponent(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends Component> getComponentClass() {
		return componentClass;
	}
	
	public void setComponentClass(Class<? extends Component> componentClass) {
		this.componentClass = componentClass;
	}
	
	public Component getComponentInstance() {
		return componentInstance;
	}
	
	public void setComponentInstance(Component componentInstance) {
		this.componentInstance = componentInstance;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
