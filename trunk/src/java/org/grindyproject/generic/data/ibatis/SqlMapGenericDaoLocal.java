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
import org.grindyproject.generic.data.GenericDaoLocal;
import org.grindyproject.generic.model.BaseLocalizableObject;
import org.grindyproject.generic.model.Lang;
import org.grindyproject.generic.model.Localizable;
import org.grindyproject.generic.model.QueryParameters;
import org.grindyproject.generic.utils.ListUtils;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.util.ClassUtils;

/**
 * GenericDaoLocal interface
 * @author Sergey S. Akberov
 * @version 1.0
 */
public class SqlMapGenericDaoLocal<T extends BaseLocalizableObject<K>, PK extends Serializable, K extends Localizable>
		extends SqlMapGenericDao<T, PK> implements GenericDaoLocal<T, PK, K> {

	/**
	 * @param clazz
	 */
	public SqlMapGenericDaoLocal(Class<T> clazz) {
		super(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.data.ibatis.SqlMapGenericDao#getAll()
	 */
	@Override
	public List<T> getAll() {
		List<T> list = super.getAll();
		getRelatedObjects(list);

		return list;
	}	
	
	
	/* (non-Javadoc)
	 * @see org.grindyproject.generic.data.ibatis.SqlMapGenericDao#getAll(org.grindyproject.generic.model.QueryParameters)
	 */
	@Override
	public List<T> getAll(QueryParameters qp) {		
		List<T> list = super.getAll(qp);
		
		getRelatedObjects(list);
		
		return list;	
	}	
	

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.data.ibatis.SqlMapGenericDao#save(java.lang.Object)
	 */
	@Override
	public void save(final T object) {		
		super.save(object);
		
		for(K obj : object.getLocal()) {
			obj.setParentId(object.getId());
			saveRelated(obj);
		}
	}
	
	public void saveRelated(final K object) {
		
		String className = ClassUtils.getShortName(object.getClass());
		Object pk = SqlMapUtils.getPrimaryKeyFieldValue(object);
		String key = null;
		
		if(pk != null) {
			key = pk.toString();
		}
		
		if(StringUtils.isBlank(key)) {
			pk = getSqlMapClientTemplate().insert(
					SqlMapUtils.getInsertLocalQuery(getShortName()), object);			
			
			if(pk != null) {
				key = pk.toString();
			}		
			
			SqlMapUtils.setPrimaryKeyFieldValue(object, Long.class, new Long(key));
		} else {
			getSqlMapClientTemplate().update(
					SqlMapUtils.getUpdateLocalQuery(getShortName()), object);
		}
		
		if(SqlMapUtils.getPrimaryKeyFieldValue(object) == null) {
			throw new ObjectRetrievalFailureException(className, object);
		}
	}

	/*
	 * (non-Javadoc)
	 * Ibatis usage: where lang=#value.id#
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getAllByLanguage()
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAllByLanguage(Lang lang) {
		return getSqlMapClientTemplate().queryForList(
				SqlMapUtils.getSelectByLanguage(getShortName()), lang);
	}

	/*
	 * (non-Javadoc)
	 * Ibatis usage: where lang=#params.lang.id#
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getAllByLanguage(org.grindyproject.generic.model.QueryParameters)
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAllByLanguage(QueryParameters qp) {
		return getSqlMapClientTemplate().queryForList(
				SqlMapUtils.getFindByLanguage(getShortName()), qp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getAllByLangugageCount(org.grindyproject.generic.model.QueryParameters)
	 */
	public Integer getAllByLangugageCount(QueryParameters qp) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				SqlMapUtils.getLocalCountQuery(getShortName()), qp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getByLanguage()
	 */
	@SuppressWarnings("unchecked")
	public T getByLanguage(PK id) {
		T object = (T)getSqlMapClientTemplate().queryForObject(
				SqlMapUtils.getFindByLanguage(getShortName()), id);
		
		if(object == null) {
			throw new ObjectRetrievalFailureException(getShortName(), id);
		}
		
		return object;
	}

	@SuppressWarnings("unchecked")
	private void getRelatedObjects(List<T> objects) {
		QueryParameters qp = new QueryParameters();
		qp.addParam("objectList", objects);
		List<K> list = getSqlMapClientTemplate().queryForList(
				SqlMapUtils.getRelatedQuery(getShortName()), qp);

		for (int i = 0; i < list.size(); i++) {
			K obj = list.get(i);
			Integer tmpId = ListUtils.<T> findElement(objects, obj
					.getParentId());
			if (-1 != tmpId.intValue()) {
				objects.get(tmpId.intValue()).getLocal().add(obj);
			}
		}

	}

}
