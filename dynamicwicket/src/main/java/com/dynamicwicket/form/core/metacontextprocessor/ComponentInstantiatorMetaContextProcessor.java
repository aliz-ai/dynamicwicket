package com.dynamicwicket.form.core.metacontextprocessor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.dynamicwicket.core.MetaComponent;

public class ComponentInstantiatorMetaContextProcessor extends AbstractDefaultMetaContextProcessor {
	
	private IModel<?> model;
	
	public ComponentInstantiatorMetaContextProcessor(IModel<?> model) {
		this.model = model;
	}
	
	protected String createComponentId(MetaComponent metaComponent) {
		return metaComponent.getName();
	}
	
	@Override
	protected void processMetaComponent(MetaComponent metaComponent) {
		Class<? extends Component> componentClass = metaComponent.getComponentClass();
		String componentId = createComponentId(metaComponent);

		if (componentClass == null || componentId == null) {
			return;
		}

		try {
			Constructor<? extends Component> constructor = componentClass.getConstructor(String.class, IModel.class);
			Component component = constructor.newInstance(componentId, new PropertyModel<Object>(model, metaComponent.getName()));
			
			metaComponent.setComponentInstance(component);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
	
}
