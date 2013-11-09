package com.dynamicwicket.examples;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

import com.dynamicwicket.core.ClassBasedMetaContextInitializer;
import com.dynamicwicket.core.ComponentClassProvider;
import com.dynamicwicket.core.DynamicProcessor;
import com.dynamicwicket.form.component.CheckBoxFormComponent;
import com.dynamicwicket.form.component.EnumDropDownChoiceFormComponent;
import com.dynamicwicket.form.component.TextAreaFormComponent;
import com.dynamicwicket.form.component.TextFieldFormComponent;
import com.dynamicwicket.form.core.metacontextprocessor.ClassBasedComponentClassProviderMetaContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.CssClassMetaContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.MarkupContainerDecoratorMetaContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.PropertyValidatorContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.RepeatingViewComponentInstantiatorMetaContextProcessor;
import com.dynamicwicket.form.core.metacontextprocessor.TableCellMetaContextProcessor;

public class TestPage2 extends WebPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Model<TestObject> model = Model.of(new TestObject());
		Form<TestObject> testForm = new TestForm("testForm", model);
		add(testForm);

		ComponentClassProvider componentClassProvider = new ComponentClassProvider();
		componentClassProvider.registerComponentClass(int.class, TextFieldFormComponent.class);
		componentClassProvider.registerComponentClass(Integer.class, TextFieldFormComponent.class);
		componentClassProvider.registerComponentClass(String.class, TextFieldFormComponent.class);
		componentClassProvider.registerComponentClass(TestEnum.class, EnumDropDownChoiceFormComponent.class);
		componentClassProvider.registerComponentClass(TestObject.class, "string2", TextAreaFormComponent.class);
		componentClassProvider.registerComponentClass(Boolean.class, CheckBoxFormComponent.class);
		componentClassProvider.registerComponentClass(boolean.class, CheckBoxFormComponent.class);

		ClassBasedMetaContextInitializer metaContextInitializer =
			new ClassBasedMetaContextInitializer(TestObject.class);

		RepeatingView repeatingView = new RepeatingView("formLine");
		testForm.add(repeatingView);

		DynamicProcessor dynamicProcessor = new DynamicProcessor(metaContextInitializer);
		dynamicProcessor.addDynamicProcessors(
			new ClassBasedComponentClassProviderMetaContextProcessor(TestObject.class, componentClassProvider),
			new RepeatingViewComponentInstantiatorMetaContextProcessor(model, repeatingView),
			new MarkupContainerDecoratorMetaContextProcessor(repeatingView),
			new PropertyValidatorContextProcessor(),
			new CssClassMetaContextProcessor(),
			new TableCellMetaContextProcessor());

		dynamicProcessor.process();
	}

}
