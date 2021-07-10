package com.gale.contsant;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";

	private static final String PROEPERTIESPATH = RESOURCESPATH + "/env.properties";

	public static String getPropertiesPath() {
		return PROEPERTIESPATH;
	}
}
