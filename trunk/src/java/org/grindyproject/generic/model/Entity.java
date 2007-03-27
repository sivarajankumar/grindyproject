/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.model;

/**
 * EntityClass for all objects
 * @author Sergey S. Akberov 
 * @version 1.0
 */
public class Entity {
	
	/**
	 * Entity's primary key
	 */
	protected Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Check if new object or already exists
	 * @return if object is new or exists in DB
	 */
	public boolean isNew() {
		return (this.id == null);
	}	
	
	/**
	 * Overrided equals method
	 */
	public boolean equals(Object o) {
		if(o == null) return false;
		return ((Entity)o).getId().equals(this.id);
	}
}
