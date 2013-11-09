package com.dynamicwicket.form.core.metacontextprocessor;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.lang.Args;

import com.dynamicwicket.core.MetaComponent;

public class RepeatingViewComponentInstantiatorMetaContextProcessor extends ComponentInstantiatorMetaContextProcessor {
	
	private RepeatingView repeatingView;
	
	public RepeatingViewComponentInstantiatorMetaContextProcessor(IModel<?> model, RepeatingView repeatingView) {
		super(model);

		Args.notNull(repeatingView, "repeatingView");

		this.repeatingView = repeatingView;
	}

	@Override
	protected String createComponentId(MetaComponent metaComponent) {
		return repeatingView.newChildId();
	}

}
