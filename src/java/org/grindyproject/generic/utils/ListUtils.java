/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.utils;

import java.util.List;

import org.grindyproject.generic.model.BaseLocalizableObject;

/**
 * Helper listutils method
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public class ListUtils {

	public static <T extends BaseLocalizableObject> Integer findElement(List<T> list, Long id) {
		Integer result = -1;
		
		Integer i = 0;
		for(T element : list) {			
			if(element.getId().longValue() == id.longValue()) {
				return i;				
			}
			i++;
		}
		
		return result;
	}
}
