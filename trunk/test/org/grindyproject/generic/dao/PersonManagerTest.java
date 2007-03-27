/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.dao;

import org.grindyproject.generic.model.Person;
import org.grindyproject.generic.model.QueryParameters;
import org.grindyproject.generic.service.GenericManager;
import org.grindyproject.generic.test.GrindyTestCase;

/**
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 *
 */
public class PersonManagerTest extends GrindyTestCase {
	
	private GenericManager<Person, Long> personManager;	

	/**
	 * @param personManager the personManager to set
	 */
	public void setPersonManager(GenericManager<Person, Long> personManager) {
		this.personManager = personManager;
	}
	
	public void testGetValues() {		
		QueryParameters qp = new QueryParameters();
		qp.addParam("name", "Ruslan");
		qp.addParam("id", 19);
		Person p = personManager.get(19L);
		logger.info("Person" + p);		
	}
}
