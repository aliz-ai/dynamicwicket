package com.dynamicwicket.form.core.metacontextprocessor;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;

import com.dynamicwicket.core.MetaComponent;

public class CssClassMetaContextProcessor extends AbstractDefaultMetaContextProcessor {

	@Override
	protected void processMetaComponent(MetaComponent metaComponent) {
		String name = metaComponent.getName();
		Component component = metaComponent.getComponentInstance();
		
		if (component != null && name != null) {
			component.add(AttributeModifier.append("class", name));
		}
	}

}
