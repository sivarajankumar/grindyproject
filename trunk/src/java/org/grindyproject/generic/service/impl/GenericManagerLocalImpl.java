/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.service.impl;

import java.io.Serializable;
import java.util.List;

import org.grindyproject.generic.data.GenericDao;
import org.grindyproject.generic.data.GenericDaoLocal;
import org.grindyproject.generic.model.Lang;
import org.grindyproject.generic.model.Localizable;
import org.grindyproject.generic.model.QueryParameters;
import org.grindyproject.generic.service.GenericManagerLocal;

/**
 * GenericManagerLocal interface implementation
 * 
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public class GenericManagerLocalImpl<T, PK extends Serializable, K extends Localizable>
	extends GenericManagerImpl<T, PK> implements GenericManagerLocal<T, PK, K> {
	
	protected GenericDaoLocal<T, PK, K> genericDaoLocal;
	
	/**
	 * @param genericDao
	 */
	public GenericManagerLocalImpl(GenericDaoLocal<T, PK, K> genericDaoLocal) {
		super(genericDaoLocal);		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.service.GenericManagerLocal#getAllByLanguage(org.grindyproject.generic.model.Lang)
	 */
	public List<T> getAllByLanguage(Lang lang) {
		return genericDaoLocal.getAllByLanguage(lang);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.service.GenericManagerLocal#getAllByLanguage(org.grindyproject.generic.model.QueryParameters)
	 */
	public List<T> getAllByLanguage(QueryParameters qp) {		
		return genericDaoLocal.getAllByLanguage(qp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.service.GenericManagerLocal#getAllByLangugageCount(org.grindyproject.generic.model.QueryParameters)
	 */
	public Integer getAllByLangugageCount(QueryParameters qp) {		
		return genericDaoLocal.getAllByLangugageCount(qp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.service.GenericManagerLocal#getByLanguage(java.io.Serializable)
	 */
	public T getByLanguage(PK id) {
		return getByLanguage(id);
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.service.GenericManager#getAll()
	 */
	@Override
	public List<T> getAll() {
		return genericDaoLocal.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.service.GenericManager#getAll(org.grindyproject.generic.model.QueryParameters)
	 */
	@Override
	public List<T> getAll(QueryParameters qp) {
		return genericDaoLocal.getAll(qp);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.service.GenericManager#save(java.lang.Object)
	 */
	@Override
	public void save(final T object) {
		genericDaoLocal.save(object);
	}

}
