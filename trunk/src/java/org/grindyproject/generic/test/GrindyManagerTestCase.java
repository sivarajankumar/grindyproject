/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmock.MockObjectTestCase;

/**
 * Base class for all test methods
 * @author Sergey S. Akberov
 * @version 1.0
 */
public abstract class GrindyManagerTestCase extends MockObjectTestCase {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public GrindyManagerTestCase() {
		super();		
	}
	
	
}
