package com.dynamicwicket.form.core.metacontextprocessor;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;

import com.dynamicwicket.core.MetaComponent;

public class MarkupContainerDecoratorMetaContextProcessor extends AbstractDefaultMetaContextProcessor {
	
	private WebMarkupContainer container;
	
	public MarkupContainerDecoratorMetaContextProcessor(WebMarkupContainer container) {
		this.container = container;
	}

	@Override
	protected void processMetaComponent(MetaComponent metaComponent) {
		Component componentInstance = metaComponent.getComponentInstance();
		if (componentInstance != null) {
			container.add(componentInstance);
		}
	}
	
}
