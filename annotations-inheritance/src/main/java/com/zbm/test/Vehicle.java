package com.zbm.test;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.zbm.test.annotation.InheritedAnnotation;
import com.zbm.test.annotation.UnInheritedAnnotation;

@Component
@InheritedAnnotation
@UnInheritedAnnotation
public class Vehicle {

	@Override
	public String toString() {
		return "Vehicle [Annotations" + Arrays.toString(getClass().getAnnotations()) + "]";
	}

}
