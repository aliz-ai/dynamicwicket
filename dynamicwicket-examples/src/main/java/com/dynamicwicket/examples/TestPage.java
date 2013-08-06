package com.dynamicwicket.examples;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import com.dynamicwicket.core.ClassBasedMetaContextInitializer;
import com.dynamicwicket.core.ComponentClassProvider;
import com.dynamicwicket.core.DynamicProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.ClassBasedComponentClassProviderMetaContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.ComponentInstantiatorMetaContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.CssClassMetaContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.MarkupContainerDecoratorMetaContextProcessor;

public class TestPage extends WebPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Model<TestObject> model = Model.of(new TestObject());
		Form<TestObject> testForm = new TestForm("testForm", model);
		add(testForm);

		ComponentClassProvider componentClassProvider = new ComponentClassProvider();
		componentClassProvider.registerComponentClass(Integer.class, TextField.class);
		componentClassProvider.registerComponentClass(int.class, TextField.class);
		componentClassProvider.registerComponentClass(String.class, TextField.class);
		componentClassProvider.registerComponentClass(Boolean.class, CheckBox.class);
		componentClassProvider.registerComponentClass(boolean.class, CheckBox.class);

		ClassBasedMetaContextInitializer initializer =
			new ClassBasedMetaContextInitializer(TestObject.class);

		DynamicProcessor dynamicProcessor = new DynamicProcessor(initializer);
		dynamicProcessor.addDynamicProcessors(
			new ClassBasedComponentClassProviderMetaContextProcessor(TestObject.class, componentClassProvider),
			new ComponentInstantiatorMetaContextProcessor(model),
			new CssClassMetaContextProcessor(),
			new MarkupContainerDecoratorMetaContextProcessor(testForm));

		dynamicProcessor.process();
	}

}
