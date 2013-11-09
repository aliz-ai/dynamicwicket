package com.dynamicwicket.form.component;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

public abstract class AbstractDynamicFormComponent<T> extends GenericPanel<T> {
	
	public AbstractDynamicFormComponent(String id, IModel<T> model) {
		super(id, model);
	}
	
	protected void onInitialize() {
		super.onInitialize();
		
		IModel<String> labelModel = getLabelModel();

		FormComponent<T> formComponent = createFormComponent();
		formComponent.setLabel(labelModel);
		add(formComponent);
		
		Label label = new Label("label", labelModel);
		label.add(AttributeModifier.replace("for", formComponent.getMarkupId()));
		add(label);
	}
	
	protected IModel<String> getLabelModel() {
		IModel<T> model = getModel();
		if (model instanceof AbstractPropertyModel) {
			String propertyExpression = ((AbstractPropertyModel<T>) model).getPropertyExpression();
			return new ResourceModel(createLabelResourceKey(propertyExpression));
		}

		throw new WicketRuntimeException();
	}
	
	protected abstract FormComponent<T> createFormComponent();
	
	protected String createLabelResourceKey(String propertyExpression) {
		return propertyExpression + ".label";
	}
	
}
