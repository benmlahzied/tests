package com.zbm.test;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Car extends Vehicle {

	@Override
	public String toString() {
		return "Car [Annotations" + Arrays.toString(getClass().getAnnotations()) + "]";
	}

}
