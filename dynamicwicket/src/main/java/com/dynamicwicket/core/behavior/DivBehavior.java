package com.dynamicwicket.core.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.BorderBehavior;

public class DivBehavior extends BorderBehavior {

	@Override
	public void beforeRender(Component component) {
		String clazz = component instanceof Label ? "labelDiv" : "inputDiv";
		component.getResponse().write("<div class=\"" + clazz + "\">");
	}
	
	@Override
	public void afterRender(Component component) {
		component.getResponse().write("</div>");
	}

}