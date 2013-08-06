package com.dynamicwicket.examples;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TestObject implements Serializable {
	
	@NotNull
	@Min(0)
	@Max(100)
	private Integer integer;
	
	@NotNull
	@Size(min = 5, max = 10)
	private String string;

	private String string2;
	private Boolean bool;
	
	@Min(100)
	@Max(200)
	private int i;

	@AssertTrue
	private boolean b;

	private TestEnum testEnum;
	
	public Integer getInteger() {
		return integer;
	}
	
	public void setInteger(Integer integer) {
		this.integer = integer;
	}
	
	public String getString() {
		return string;
	}
	
	public void setString(String string) {
		this.string = string;
	}
	
	public String getString2() {
		return string2;
	}
	
	public void setString2(String string2) {
		this.string2 = string2;
	}
	
	public Boolean getBool() {
		return bool;
	}
	
	public void setBool(Boolean bool) {
		this.bool = bool;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public boolean isB() {
		return b;
	}
	
	public void setB(boolean b) {
		this.b = b;
	}
	
	public TestEnum getTestEnum() {
		return testEnum;
	}
	
	public void setTestEnum(TestEnum testEnum) {
		this.testEnum = testEnum;
	}

}