package com.springboot.ems.exception;

public class DataSourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldvalue;
	public DataSourceNotFoundException(String resourceName, String fieldName, Object fieldvalue) {
		super(String.format("%s not found with %s : '%s'",resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	
}
