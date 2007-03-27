/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.exception;

/**
 * ParametricException
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 * @version 1.0
 */
public class ParametricException extends RuntimeException {

	private static final long serialVersionUID = -5897886719923028250L;

	/**
	 * Default constructor
	 */
	public ParametricException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public ParametricException(String message) {
		super(message);	
	}
	

	
}
