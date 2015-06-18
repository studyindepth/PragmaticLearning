package di.impl;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import di.api.Bean;
import di.api.Container;

public class ContainerImpl implements Container {

	private String[] scanPackages;

	private Map<Class<?>, Object> beans = new HashMap<>();

	private List<Class<?>> beanClasses = new ArrayList<Class<?>>();

	private static final char DOT = '.';

	private static final char SLASH = '/';

	private static final String CLASS_SUFFIX = ".class";

	private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

	private List<Class<?>> find(String scannedPackage) {
		String scannedPath = scannedPackage.replace(DOT, SLASH);
		URL scannedUrl = Thread.currentThread().getContextClassLoader()
				.getResource(scannedPath);
		if (scannedUrl == null) {
			throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR,
					scannedPath, scannedPackage));
		}
		File scannedDir = new File(scannedUrl.getFile());
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (File file : scannedDir.listFiles()) {
			classes.addAll(find(file, scannedPackage));
		}
		return classes;
	}

	private List<Class<?>> find(File file, String scannedPackage) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		String resource = scannedPackage + DOT + file.getName();
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				classes.addAll(find(child, resource));
			}
		} else if (resource.endsWith(CLASS_SUFFIX)) {
			int endIndex = resource.length() - CLASS_SUFFIX.length();
			String className = resource.substring(0, endIndex);
			try {
				classes.add(Class.forName(className));
			} catch (ClassNotFoundException ignore) {
			}
		}
		return classes;
	}

	public ContainerImpl(String... scanPackages) {
		this.scanPackages = scanPackages;
	}

	private void scanForBeans() {
		scanBeanClasses();
		initBeans();
	}

	private void initBeans() {
		for (Class<?> class1 : beanClasses) {
			BeanDefinition def = new BeanDefinition(class1);
		}
	}

	private void scanBeanClasses() {
		for (String pack : scanPackages) {
			List<Class<?>> classes = find(pack);
			beanClasses.addAll(findBeanClasses(classes));
		}
	}

	private Collection<? extends Class<?>> findBeanClasses(
			List<Class<?>> classes) {
		List<Class<?>> result = new ArrayList<Class<?>>();
		for (Class<?> class1 : classes) {
			if (class1.getAnnotation(Bean.class) != null) {
				result.add(class1);
			}
		}
		return result;
	}

	@Override
	public <T> T getBean(Class<T> clazz) {
		return null;
	}

	public static void main(String[] args) {
		ContainerImpl containerImpl = new ContainerImpl("di.demo");
		containerImpl.scanForBeans();
		for (Class<?> cl : containerImpl.beanClasses) {
			System.out.println(cl);

		}
	}
}
