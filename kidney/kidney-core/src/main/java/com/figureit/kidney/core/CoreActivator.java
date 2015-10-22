package com.figureit.kidney.core;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.figureit.kidney.core.model.PersonLoader;


public class CoreActivator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		IEclipseContext ctx = EclipseContextFactory.getServiceContext(context);
		PersonLoader personsLoader = new PersonLoader();
		ctx.set(PersonLoader.class.getName(), personsLoader);
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
