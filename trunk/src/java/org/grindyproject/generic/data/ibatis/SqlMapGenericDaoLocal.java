/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.data.ibatis;

import java.io.Serializable;
import java.util.List;

import org.grindyproject.generic.data.GenericDaoLocal;
import org.grindyproject.generic.model.BaseLocalizableObject;
import org.grindyproject.generic.model.Localizable;
import org.grindyproject.generic.model.QueryParameters;
import org.grindyproject.generic.utils.ListUtils;

/**
 * @author Sergey S. Akberov
 * 
 */
public class SqlMapGenericDaoLocal<T extends BaseLocalizableObject, PK extends Serializable, K extends Localizable>
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getAllByLanguage()
	 */
	public List<T> getAllByLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getAllByLanguage(org.grindyproject.generic.model.QueryParameters)
	 */
	public List<T> getAllByLanguage(QueryParameters qp) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getAllByLangugageCount(org.grindyproject.generic.model.QueryParameters)
	 */
	public Integer getAllByLangugageCount(QueryParameters qp) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.grindyproject.generic.data.GenericDaoLocal#getByLanguage()
	 */
	public T getByLanguage() {
		// TODO Auto-generated method stub
		return null;
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
