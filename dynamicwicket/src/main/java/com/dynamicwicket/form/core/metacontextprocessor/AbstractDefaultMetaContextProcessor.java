package com.dynamicwicket.form.core.metacontextprocessor;

import com.dynamicwicket.core.MetaComponent;
import com.dynamicwicket.core.MetaContext;
import com.dynamicwicket.core.MetaContextProcessor;

public abstract class AbstractDefaultMetaContextProcessor implements MetaContextProcessor {

	protected MetaContext formMetaContext;

	@Override
	public void process(MetaContext metaContext) {
		this.formMetaContext = metaContext;

		for (MetaComponent metaComponent : metaContext.getMetaComponents()) {
			processMetaComponent(metaComponent);
		}
	}

	protected abstract void processMetaComponent(MetaComponent metaComponent);

}
