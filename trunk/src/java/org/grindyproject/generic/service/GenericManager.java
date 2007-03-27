/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.service;

import java.io.Serializable;
import java.util.List;

import org.grindyproject.generic.model.QueryParameters;

/**
 * GenericManager
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public interface GenericManager<T, PK extends Serializable> {
	
	/**
	 * Common method to get all object of a particular type.
	 * @return 	List of populated objects
	 */
	public List<T> getAll();
	
	/**
	 * Generic method to get an object based on identifier. An ObjectRetirevalFailureException
	 * Runtime Exception is thrown if nothing is found
	 * @param id primary key of the object to get
	 * @return a populated object
	 */
	public T get(PK id);
	
	/**
	 * Common method to save an object
	 * @param object the object to save
	 */
	public void save(T object);	
	
	
	/**
	 * Common method to delete an object based on identifier
	 * @param id primary key of the object to get
	 */
	public void delete(PK id);
	
	public List<T> getAll(QueryParameters qp);
	
	public Integer getAllCount(QueryParameters qp);
}
