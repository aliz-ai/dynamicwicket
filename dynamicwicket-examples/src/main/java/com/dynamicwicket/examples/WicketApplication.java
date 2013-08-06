
package com.dynamicwicket.examples;

import org.apache.wicket.bean.validation.BeanValidationConfiguration;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {
	
	@Override
	public Class<TestPage> getHomePage() {
		return TestPage.class;
	}
	
	@Override
	public void init() {
		super.init();
		
		new BeanValidationConfiguration().configure(this);
		
		mountPage("testPage", TestPage.class);
		mountPage("testPage2", TestPage2.class);
	}
	
}
