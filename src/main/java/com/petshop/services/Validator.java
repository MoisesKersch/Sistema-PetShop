package com.petshop.services;

import org.springframework.validation.Errors;

public interface Validator
{
	public boolean supports(Class<?> aClass);
	public void validate(Object o, Errors errors);
}
