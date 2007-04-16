/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.service;

import java.io.Serializable;
import java.util.List;

import org.grindyproject.generic.model.Lang;
import org.grindyproject.generic.model.Localizable;
import org.grindyproject.generic.model.QueryParameters;

/**
 * GenericManagerLocal interface
 * 
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public interface GenericManagerLocal<T, PK extends Serializable, K extends Localizable>
		extends GenericManager<T, PK> {

	public List<T> getAllByLanguage(Lang lang);

	public List<T> getAllByLanguage(QueryParameters qp);

	public T getByLanguage(PK id);

	public Integer getAllByLangugageCount(QueryParameters qp);
}
