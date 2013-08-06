package com.dynamicwicket.core.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.basic.Label;

public class TableCellBehavior extends Behavior {
	
	@Override
	public void beforeRender(Component component) {
		String clazz = component instanceof Label ? "labelCell" : "inputCell";
		component.getResponse().write("<td class=\"" + clazz + "\">");
	}
	
	@Override
	public void afterRender(Component component) {
		component.getResponse().write("</td>");
	}

}
