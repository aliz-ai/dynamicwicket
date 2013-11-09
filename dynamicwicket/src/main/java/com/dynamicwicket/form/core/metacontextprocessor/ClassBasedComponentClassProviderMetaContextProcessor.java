package com.dynamicwicket.form.core.metacontextprocessor;

import java.lang.reflect.Method;

import org.apache.wicket.Component;

import com.dynamicwicket.core.ComponentClassProvider;
import com.dynamicwicket.core.MetaComponent;
import com.dynamicwicket.util.ReflectionUtil;

public class ClassBasedComponentClassProviderMetaContextProcessor extends AbstractDefaultMetaContextProcessor {
	
	private final Class<?> clazz;
	private final ComponentClassProvider componentClassProvider;

	public ClassBasedComponentClassProviderMetaContextProcessor(
			Class<?> clazz,	ComponentClassProvider componentClassProvider)
	{
		this.clazz = clazz;
		this.componentClassProvider = componentClassProvider;
	}
	
	public ClassBasedComponentClassProviderMetaContextProcessor(Object object,
		ComponentClassProvider componentClassProvider)
	{
		this(object.getClass(), componentClassProvider);
	}
	
	@Override
	protected void processMetaComponent(MetaComponent metaComponent) {
		String metaComponentName = metaComponent.getName();
		
		Class<? extends Component> componentClass = componentClassProvider.getComponentClass(clazz, metaComponentName);

		Method readMethod = ReflectionUtil.getReadMethod(clazz, metaComponentName);
		if (readMethod == null) {
			return;
		}

		if (componentClass == null) {
			componentClass = componentClassProvider.getComponentClass(readMethod.getReturnType());
		}

		metaComponent.setComponentClass(componentClass);
	}
	
}
