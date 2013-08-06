package com.dynamicwicket.form.component;

import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

public class CheckBoxFormComponent extends AbstractDynamicFormComponent<Boolean> {
	
	public CheckBoxFormComponent(String id, IModel<Boolean> model) {
		super(id, model);
	}
	
	@Override
	protected FormComponent<Boolean> createFormComponent() {
		return new CheckBox("checkBox", getModel());
	}
	
}
