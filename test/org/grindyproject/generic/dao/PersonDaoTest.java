/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.grindyproject.generic.data.GenericDao;
import org.grindyproject.generic.data.GenericDaoLocal;
import org.grindyproject.generic.model.Lang;
import org.grindyproject.generic.model.Localizable;
import org.grindyproject.generic.model.Person;
import org.grindyproject.generic.model.PersonLocal;
import org.grindyproject.generic.model.QueryParameters;
import org.grindyproject.generic.test.GrindyTestCase;
import org.springframework.dao.DataAccessException;

/**
 * @author Sergey S. Akberov
 *
 */
public class PersonDaoTest extends GrindyTestCase{

	private GenericDaoLocal<Person, Long, PersonLocal> personDao;
	
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * @param personDao the personDao to set
	 */
	public void setPersonDao(GenericDaoLocal<Person, Long, PersonLocal> personDao) {
		this.personDao = personDao;
	}		
	
	public void testLocal() throws Exception {
		/*Person person = new Person();
		Lang lang_en = new Lang(1L, "English");
		Lang lang_ru = new Lang(2L, "Russian");
		Lang lang_az = new Lang(3L, "Azeri");
		List<Lang> list = new ArrayList<Lang>();
		list.add(lang_en);
		list.add(lang_ru);
		list.add(lang_az);
		
		PersonLocal pr = new PersonLocal();
		pr.setId(2L);
		pr.setLanguage(lang_ru);
		pr.setTitle("Hi");
		List<PersonLocal> ls = new ArrayList<PersonLocal>();
		ls.add(pr);
		person.setLocal(ls);
		
		person.prepare(list, pr);
		
		for(PersonLocal pl : person.getLocal()) {
			log.info("Lang is " + pl.getLanguage().getFullName());
			log.info("Title is " + pl.getTitle());
		}*/
		List<Person> list = personDao.getAll();
		for(Person person : list) {
			log.info("Object" + person.getName() + ", title is ");
			for(PersonLocal pl : person.getLocal()) {
				log.info("Title:" + pl.getTitle());
			}
		}
	}
	
	/*public void testGetPageableData() throws Exception {
		QueryParameters qp = new QueryParameters(1, 10);
		qp.addParam("id", 20);
		List<Person> t = personDao.getAll(qp);
		Integer i = personDao.getAllCount(qp);
		log.info("Total size is "+i);
		assertEquals(7, t.size());
		for(Person person : t) {
			log.info(person);
		}
		
	}
	
	public void testAddAndRemovePerson() throws Exception {
		Person person = new Person();
		person.setName("Sergey");
		personDao.save(person);
		setComplete();
		endTransaction();		
		
		assertNotNull(person.getId());
		
		log.info("Id is:"+person.getId());
		
		personDao.delete(person.getId());
		
		try {
			person = personDao.get(person.getId());
			fail("getUser didn't throw DataAccessException");
		} catch (DataAccessException e) {
			assertNotNull(e);
		}
	}*/
	
}
