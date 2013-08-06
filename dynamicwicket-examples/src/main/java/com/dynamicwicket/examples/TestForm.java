package com.dynamicwicket.examples;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;

public class TestForm extends Form<TestObject> {

	private FeedbackPanel feedback;

	public TestForm(String id, IModel<TestObject> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		addFeedback();
		addSubmit();
	}

	private void addFeedback() {
		feedback = new FeedbackPanel("feedback");
		feedback.setOutputMarkupPlaceholderTag(true);
		add(feedback);
	}

	private void addSubmit() {
		add(new AjaxButton("submit") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				TestForm.this.setModelObject(new TestObject());
				feedback.info("Done!");
				target.add(feedback);
				target.add(TestForm.this);
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				target.add(feedback);
			}
			
		});
	}

}
