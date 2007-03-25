/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.data;

import java.io.Serializable;
import java.util.List;

import org.grindyproject.generic.model.QueryParameters;

/**
 * GenericDaoLocal interface
 * @author Sergey S. Akberov
 * @version 1.0
 */
public interface GenericDaoLocal<T, PK extends Serializable> extends GenericDao<T, PK> {
	
	public List<T> getAllByLanguage();
	
	public List<T> getAllByLanguage(QueryParameters qp);
	
	public T getByLanguage();
	
	public Integer getAllByLangugageCount(QueryParameters qp);
}
