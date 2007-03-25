/**
 * This file is part of Grindyproject
 * (c) 2007
 *
 * $Id$
 */
package org.grindyproject.generic.data.ibatis;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Sergey S. Akberov
 * @version 1.0
 */
public class SqlMapUtils {

	/**
	 * Helper method which help to get PK field name
	 * 
	 * @param o
	 *            the object
	 * @return PK field name
	 */
	protected static String getPrimaryKeyFieldName(Object o) {
		String fieldName = null;
		Field fieldList[] = o.getClass().getDeclaredFields();

		for (int i = 0; i < fieldList.length; i++) {
			Field field = fieldList[i];
			if (field.getName().equals("id")
					|| field.getName().indexOf("Id") > -1) {
				fieldName = field.getName();
				break;
			}
		}
		return fieldName;
	}

	/**
	 * Helper method which help to get PK value
	 * 
	 * @param o
	 *            the object
	 * @return PK value
	 */
	protected static Object getPrimaryKeyFieldValue(Object o) {
		String fieldName = getPrimaryKeyFieldName(o);
		String getter = "get" + Character.toUpperCase(fieldName.charAt(0))
				+ fieldName.substring(1);

		try {
			Method method = o.getClass().getMethod(getter, null);
			return method.invoke(o, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	protected static void setPrimaryKeyFieldValue(Object o, Class clazz,
			Object value) {
		String fieldName = getPrimaryKeyFieldName(o);
		String setter = "set" + Character.toUpperCase(fieldName.charAt(0))
				+ fieldName.substring(1);

		try {
			Method setMethod = o.getClass().getMethod(setter, clazz);

			if (value != null) {
				setMethod.invoke(o, value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	protected static String getSelectQuery(String className) {
		return "get" + className + "s";
	}

	protected static String getFindQuery(String className) {
		return "get" + className;
	}

	protected static String getInsertQuery(String className) {
		return "add" + className;
	}

	protected static String getUpdateQuery(String className) {
		return "update" + className;
	}

	protected static String getDeleteQuery(String className) {
		return "delete" + className;
	}

	protected static String getAllQueryUsingQP(String className) {
		return "get" + className + "sByParameters";
	}

	protected static String getCountQuery(String className) {
		return "get" + className + "CountByParameters";
	}
}
