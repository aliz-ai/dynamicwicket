
package com.dynamicwicket.form.core.metacontextprocessor;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;

import com.dynamicwicket.core.MetaComponent;

public class MarkupContainerDecoratorMetaContextProcessor extends AbstractDefaultMetaContextProcessor {
	
	private final WebMarkupContainer container;
	
	public MarkupContainerDecoratorMetaContextProcessor( final WebMarkupContainer container ) {
		this.container = container;
	}
	
	@Override
	protected void processMetaComponent( final MetaComponent metaComponent ) {
		Component componentInstance = metaComponent.getComponentInstance();
		
		if (componentInstance != null) {
			container.add( componentInstance );
		}
	}
	
}
