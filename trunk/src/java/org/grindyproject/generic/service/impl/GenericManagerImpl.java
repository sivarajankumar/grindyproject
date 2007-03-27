/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.grindyproject.generic.data.GenericDao;
import org.grindyproject.generic.model.QueryParameters;
import org.grindyproject.generic.service.GenericManager;

/**
 * GenericManagerImpl
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {
	
	protected final Log log = LogFactory.getLog(getClass());

	protected GenericDao<T, PK> genericDao;	
	
	/**
	 * @param genericDao
	 */
	public GenericManagerImpl(GenericDao<T, PK> genericDao) {
		super();
		this.genericDao = genericDao;
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.service.GenericManager#delete(java.io.Serializable)
	 */
	public void delete(PK id) {
		genericDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.service.GenericManager#get(java.io.Serializable)
	 */
	public T get(PK id) {
		return genericDao.get(id);
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.service.GenericManager#getAll()
	 */
	public List<T> getAll() {
		return genericDao.getAll();
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.service.GenericManager#getAll(org.grindyproject.generic.model.QueryParameters)
	 */
	public List<T> getAll(QueryParameters qp) {
		return genericDao.getAll(qp);
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.service.GenericManager#getAllCount(org.grindyproject.generic.model.QueryParameters)
	 */
	public Integer getAllCount(QueryParameters qp) {
		return genericDao.getAllCount(qp);
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.service.GenericManager#save(java.lang.Object)
	 */
	public void save(T object) {
		genericDao.save(object);
	}

}
