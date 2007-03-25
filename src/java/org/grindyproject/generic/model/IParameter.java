/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.model;

import java.util.Map;

/**
 * Parametrizable interface
 * @author Sergey S. Akberov
 * @version 1.0
 */
public interface IParameter {
	
	public void addParam(String key, Object value);
	
	public Map<String, Object> getParams();
	
	public void setLimit(Integer limit);
	
	public Integer getLimit();
	
	public void setPage(Integer limit);
	
	public Integer getPage();
	
	public Integer getOffset();
}
