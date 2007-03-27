/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.model;

/**
 * ILocalizable interface
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public interface Localizable<T> {
	
	public Lang getLanguage();
	
	public void setLanguage(Lang language);	
	
	public T createObject();
	
	public Long getParentId();
	
	public void setParentId(Long parentId);	
}
