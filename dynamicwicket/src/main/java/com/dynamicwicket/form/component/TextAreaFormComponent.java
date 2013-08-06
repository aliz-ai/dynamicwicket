package com.dynamicwicket.form.component;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;

public class TextAreaFormComponent<T> extends AbstractDynamicFormComponent<T> {
	
	public TextAreaFormComponent(String id, IModel<T> model) {
		super(id, model);
	}

	@Override
	protected FormComponent<T> createFormComponent() {
		return new TextArea<T>("textArea", getModel());
	}

}
