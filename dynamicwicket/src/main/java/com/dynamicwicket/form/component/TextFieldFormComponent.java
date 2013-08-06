package com.dynamicwicket.form.component;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class TextFieldFormComponent<T> extends AbstractDynamicFormComponent<T> {
	
	public TextFieldFormComponent(String id, IModel<T> model) {
		super(id, model);
	}
	
	@Override
	protected FormComponent<T> createFormComponent() {
		TextField<T> textField = new TextField<T>("textField", getModel());
		return textField;
	}
	
}
