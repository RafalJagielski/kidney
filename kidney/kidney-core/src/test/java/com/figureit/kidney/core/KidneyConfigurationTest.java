package com.figureit.kidney.core;

import org.junit.Test;

import junit.framework.TestCase;


public class KidneyConfigurationTest extends TestCase {
	
	@Test
	public void test1() {
		assertNotNull(KidneyConfiguration.CONFIG.getDbAddress());
	}
}
