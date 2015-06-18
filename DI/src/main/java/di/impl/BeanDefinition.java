package di.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import di.api.Injected;

public class BeanDefinition {
	private Class<?> beanType;

	private List<Field> beanFields;

	public BeanDefinition(Class<?> beanType) {
		super();
		this.beanType = beanType;
		this.beanFields = new ArrayList<>();
		findFieldTypes();
	}

	private void findFieldTypes() {
		for (Field f : beanType.getDeclaredFields()) {
			if (f.getAnnotation(Injected.class) != null) {
				beanFields.add(f);
			}
		}
	}

	public Class<?> getBeanType() {
		return beanType;
	}

	public Object createFullBean() {
		Object bean = instantiateBeanWithoutFields(beanType);
		injectFields(bean);
		return bean;
	}

	private void injectFields(Object bean) {
		for (Field field : beanFields) {
			Class<?> fieldType = field.getDeclaringClass();
		}
	}

	public void setBeanType(Class<?> beanType) {
		this.beanType = beanType;
	}

	public Object instantiateBeanWithoutFields(Class<?> beanType) {
		try {
			Constructor<?>[] cxtors = beanType.getDeclaredConstructors();
			cxtors[0].setAccessible(true);
			return cxtors[0].newInstance();
		} catch (SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new BeanException(e);
		}
	}
}
