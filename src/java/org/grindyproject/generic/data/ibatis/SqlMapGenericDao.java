/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.data.ibatis;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.grindyproject.generic.data.GenericDao;
import org.grindyproject.generic.model.QueryParameters;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.util.ClassUtils;

/**
 * @author Sergey S. Akberov
 * @version 1.0
 */
public class SqlMapGenericDao<T, PK extends Serializable> extends
		SqlMapClientDaoSupport implements GenericDao<T, PK> {

	protected final Log log = LogFactory.getLog(getClass());

	private Class<T> clazz;

	/**
	 * @param clazz
	 */
	public SqlMapGenericDao(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.GenericDao#delete(java.io.Serializable)
	 */
	public void delete(PK id) {
		getSqlMapClientTemplate().delete(
				SqlMapUtils.getDeleteQuery(getShortName()), id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.GenericDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getSqlMapClientTemplate().queryForList(
				SqlMapUtils.getSelectQuery(getShortName()), null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.GenericDao#getByPK(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		T object = (T)getSqlMapClientTemplate().queryForObject(
				SqlMapUtils.getFindQuery(getShortName()), id);
		
		if(object == null) {
			throw new ObjectRetrievalFailureException(getShortName(), id);
		}
		
		return object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.GenericDao#save(java.lang.Object)
	 */
	public void save(final T object) {
		String className = ClassUtils.getShortName(object.getClass());
		Object pk = SqlMapUtils.getPrimaryKeyFieldValue(object);
		String key = null;
		
		if(pk != null) {
			key = pk.toString();
		}
		
		if(StringUtils.isBlank(key)) {
			pk = getSqlMapClientTemplate().insert(
					SqlMapUtils.getInsertQuery(getShortName()), object);			
			
			if(pk != null) {
				key = pk.toString();
			}			
			SqlMapUtils.setPrimaryKeyFieldValue(object, Long.class, new Long(key));
		} else {
			getSqlMapClientTemplate().update(
					SqlMapUtils.getUpdateQuery(getShortName()), object);
		}
		
		if(SqlMapUtils.getPrimaryKeyFieldValue(object) == null) {
			throw new ObjectRetrievalFailureException(className, object);
		}

	}

	
	/* (non-Javadoc)
	 * @see org.grindyproject.generic.data.GenericDao#getAll(org.grindyproject.generic.model.Pager)
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll(QueryParameters qp) {
		return getSqlMapClientTemplate().queryForList(
				SqlMapUtils.getAllQueryUsingQP(getShortName()), qp);
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.data.GenericDao#getAllCount(org.grindyproject.generic.model.Pager)
	 */
	public Integer getAllCount(QueryParameters qp) {
		return (Integer)getSqlMapClientTemplate().queryForObject(
				SqlMapUtils.getCountQuery(getShortName()), qp);
	}	
	

	protected String getShortName() {
		return ClassUtils.getShortName(this.clazz);
	}	
	

}
