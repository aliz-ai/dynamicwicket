package com.dynamicwicket.form.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.form.AbstractChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.IObjectClassAwareModel;

public class EnumDropDownChoiceFormComponent<E extends Enum<E>> extends DropDownChoiceFormComponent<E> {
	
	public EnumDropDownChoiceFormComponent(String id, IModel<E> model) {
		super(id, model);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected FormComponent<E> createFormComponent() {
		AbstractChoice<E, E> abstractChoice = (AbstractChoice<E, E>) super.createFormComponent();		
		((AbstractChoice<E, E>) abstractChoice).setChoiceRenderer(new EnumChoiceRenderer<E>());
		abstractChoice.setChoices(getChoices());
		return abstractChoice;
	}
	
	protected List<E> getChoices() {
		if (getModel() instanceof IObjectClassAwareModel) {
			Class<?> objectClass = ((IObjectClassAwareModel<?>) getModel()).getObjectClass();
			if (Enum.class.isAssignableFrom(objectClass)) {
				try {
					@SuppressWarnings("unchecked")
					E[] values = (E[]) objectClass.getMethod("values").invoke(null);
					return Arrays.asList(values);
				} catch (Exception e) {
					throw new WicketRuntimeException(e);
				}
			}
		}
		return new ArrayList<E>();
	}

}
