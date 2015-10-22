package com.figureit.kidney.rcp.part.person.list;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.figureit.kidney.core.model.PersonLoader;

public class PersonList {
	
	private Text text;
	private Table personsTable;
	@Inject
	private PersonLoader personLoader;
	
	/**	 */
	@Inject
	public PersonList() {
		System.err.println("personsLoader" + personLoader);
	}

	/**
	 * 
	 * @param parent
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

	    text = new Text(parent, SWT.BORDER);
	    text.setMessage("Enter Name");
	    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    
	    Button button = new Button(parent, SWT.PUSH);
	    button.setText("Search");
	    
	    initializePersonsTable(parent);
	}

	private void initializePersonsTable(Composite parent) {
		
		personsTable = new Table(parent, SWT.NONE);
		personsTable.setHeaderVisible(true);
		
	}

	@Focus
	public void onFocus() {
		personsTable.setFocus();
	}


}