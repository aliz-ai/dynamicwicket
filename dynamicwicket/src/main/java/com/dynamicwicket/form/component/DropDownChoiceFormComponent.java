package com.dynamicwicket.form.component;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

public class DropDownChoiceFormComponent<T> extends AbstractDynamicFormComponent<T> {
	
	public DropDownChoiceFormComponent(String id, IModel<T> model) {
		super(id, model);
	}
	
	@Override
	protected FormComponent<T> createFormComponent() {
		DropDownChoice<T> dropDownChoice = new DropDownChoice<T>("dropDownChoice");
		dropDownChoice.setModel(getModel());

		return dropDownChoice;
	}
	
}
