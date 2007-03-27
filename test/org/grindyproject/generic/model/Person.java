/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.model;

/**
 * @author Sergey S. Akberov
 *
 */
public class Person extends BaseLocalizableObject<PersonLocal>{	
	private String name;	
	
	/**
	 * Default constructor
	 */
	public Person() {
		super();		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Person {id="+getId()+", name="+getName()+"}";
	}	
	
}
