/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.model;

/**
 * @author <a href="mailto:sergey@linux.az">Sergey S. Akberov</a>
 *
 */
public class PersonLocal extends Entity implements Localizable<PersonLocal>{
	
	private String title;
	private Lang language;	
	private Long parentId;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the language
	 */
	public Lang getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Lang language) {
		this.language = language;
	}

	/* (non-Javadoc)
	 * @see org.grindyproject.generic.model.Localizable#createObject()
	 */
	public PersonLocal createObject() {
		return new PersonLocal();
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
	
	
}
