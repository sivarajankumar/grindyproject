/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.model;

import org.grindyproject.generic.exception.ParametricException;

import java.util.HashMap;
import java.util.Map;

/**
 * IParameter interface implementation
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public class QueryParameters implements IParameter{
	
	private Map<String, Object> params = new HashMap<String, Object>();	
	
	private static final Integer LIMIT = 10;
	
	private static final Integer PAGE = 1;
	
	public QueryParameters() {
		super();
		setLimit(LIMIT);
		setPage(PAGE);
	}
	
	public QueryParameters(Integer page, Integer limit) {
		setLimit(limit);
		setPage(page);
	}
	
	public QueryParameters(Integer page) {
		setPage(page);
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.IParameter#addParam()
	 */
	public void addParam(String key, Object value) {
		params.put(key, value);		
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.IParameter#getLimit()
	 */
	public Integer getLimit() {
		if(params.containsKey("limit")) {
			return (Integer)params.get("limit");
		} else {
			throw new ParametricException("Could not get limit parameter");
		}
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.IParameter#getPage()
	 */
	public Integer getPage() {
		if(params.containsKey("page")) {
			return (Integer)params.get("page");
		} else {
			throw new ParametricException("Could not get page parameter");
		}
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.IParameter#getParams()
	 */
	public Map<String, Object> getParams() {
		return params;	
	}
	
	
	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.IParameter#setLimit()
	 */
	public void setLimit(Integer limit) {		
		params.put("limit", limit);		
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.IParameter#setPage()
	 */
	public void setPage(Integer page) {
		params.put("page", page);
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.IParameter#getOffset()
	 */
	public Integer getOffset() {
		return (getPage()-1)*getLimit();
	}
	
	
	
}
