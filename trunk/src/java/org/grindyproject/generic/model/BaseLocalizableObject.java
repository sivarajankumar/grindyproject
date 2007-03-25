/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all localizable objects
 * 
 * @author Sergey S. Akberov
 * @version 1.0
 */
public abstract class BaseLocalizableObject<T extends Localizable> extends Entity{

	public List<T> local;

	/**
	 * Default constructor for BaseObject
	 */
	public BaseLocalizableObject() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected T createNewObject(Lang lang) {
		//
		return null;
	}

	public void prepare(List<Lang> langs) {
		List<T> tmp = new ArrayList<T>();

		if (local == null || local.size() == 0) {
			for (Lang lang : langs) {
				tmp.add(createNewObject(lang));
			}
		} else {
			for (Lang lang : langs) {
				boolean result = false;
				T localTmp = null;
				
				for (T locals : getLocal()) {
					if (lang == locals.getLanguage()) {
						result = true;
						localTmp = locals;
						break;
					}
				}
				
				if (result) {
					tmp.add(localTmp);
				} else {
					tmp.add(createNewObject(lang));
				}

			}
		}
		setLocal(tmp);
	}

	/**
	 * @return the local
	 */
	public List<T> getLocal() {
		return local;
	}

	/**
	 * @param local
	 *            the local to set
	 */
	public void setLocal(List<T> local) {
		this.local = local;
	}

}
