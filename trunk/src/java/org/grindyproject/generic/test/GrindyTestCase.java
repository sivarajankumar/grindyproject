/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.test;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public class GrindyTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {
	
	/* (non-Javadoc)
	 * @see org.springframework.test.AbstractSingleSpringContextTests#getConfigLocations()
	 */	
	protected String[] getConfigLocations() {
		return new String[] {"classpath:applicationContext-*.xml"};
	}
}
