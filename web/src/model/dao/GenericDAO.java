package model.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.metadata.ClassMetadata;

import model.filter.FilterBuilder;

import static model.FactoryDAO.openInstance;

public class GenericDAO<T, PK> {

	protected Class<?> manipulada;

	protected FilterBuilder<T> filter;

	public GenericDAO() {
		super();
		this.manipulada = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Class<?> getManipulada() {
		return manipulada;
	}

	protected void setManipulada(Class<?> manipulada) {
		this.manipulada = manipulada;
	}

	// CRUD

	public T insert(T entity) {
		try {
			openInstance().beginTransaction();
			openInstance().persist(entity);
			openInstance().refresh(entity);
			openInstance().getTransaction().commit();

		} catch (Exception e) {
			openInstance().getTransaction().rollback();
			throw e;
		} finally {
			// closeInstance();
		}
		return entity;
	}

	public T save(T entity) {
		try {
			openInstance().beginTransaction();
			openInstance().merge(entity);
			openInstance().getTransaction().commit();

		} catch (Exception e) {
			openInstance().getTransaction().rollback();
			throw e;
		} finally {
			// closeInstance();
		}
		return entity;
	}

	public void delete(PK pk) {
		try {
			openInstance().beginTransaction();

			T entity = findById(pk);

			openInstance().remove(entity);
			openInstance().getTransaction().commit();
			// return true;

		} catch (Exception e) {
			openInstance().getTransaction().rollback();
			throw e;

		} finally {
			// closeInstance();
		}

	}

	public Object executeQuery(String query, Object... params) {
		Query createQuery = openInstance().createQuery(query);

		for (int i = 0; i < params.length; i++) {
			createQuery.setParameter(i, params[i]);
		}

		return createQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		List<T> retorno = openInstance().createQuery(("FROM " + this.manipulada.getName())).getResultList();
		// closeInstance();

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(FilterBuilder<T> selector) {
		return null;
	}

	public StringBuilder buildSQLCommand(T entityInit, T entityEnd) {

		if (entityInit == null)
			entityInit = entityEnd;
		if (entityEnd == null)
			entityEnd = entityInit;

		if (entityInit != null && entityEnd != null) {

			Class<? extends Object> c = entityInit.getClass();

			int counter = 0;
			// Map<String, String> mappedEntityInit = paramsCorverter(entityInit);
			// Map<String, String> mappedEntityEnd = paramsCorverter(entityEnd);

			List<Map<String, String>> mappedEntities = paramsCorverter(entityInit, entityEnd);

			Table table = c.getAnnotation(Table.class);
			StringBuilder jpql = new StringBuilder("SELECT t FROM " + table.name() + " t");

			if (mappedEntities != null && mappedEntities.size() > 0) {

				for (Map<String, String> mpe : mappedEntities) {

				}
				jpql.append(" WHERE ");

				boolean frst = true;
				// for (Map.Entry<String, String> entry : mappedEntityInit.entrySet()) {
				//
				// if (!frst) {
				// jpql.append(" AND ");
				// } else {
				// frst = false;
				// }
				//
				// jpql.append("'" + entry.getKey() + "'" + " >= " + "'" + entry.getValue() +
				// "'");
				// }
			}
			return jpql;
		}
		return null;
	}

	private List<Map<String, String>> paramsCorverter(T entityInit, T entityEnd) {

		Class<? extends Object> c1 = entityInit.getClass();
		Class<? extends Object> c2 = entityEnd.getClass();

		Map<String, String> mappedEntityInit = null;
		Map<String, String> mappedEntityEnd = null;

		List<Map<String, String>> mappedEntities = new ArrayList<>();

		Field[] fields1 = c1.getDeclaredFields();
		Field[] fields2 = c2.getDeclaredFields();

		for (int i = 0; i < fields1.length || i < fields2.length; i++) {

			fields1[i].setAccessible(true);
			fields2[i].setAccessible(true);

			Column col1 = fields1[i].getAnnotation(Column.class);
			Column col2 = fields2[i].getAnnotation(Column.class);

			String column1, column2 = null;
			String value1, value2 = null;

			if (col1 != null && !col1.name().equals("")) {
				column1 = col1.name();
			} else {
				if (!fields1[i].getName().equals("serialVersionUID")) {
					column1 = fields1[i].getName();
				}
			}

			if (col2 != null && !col2.name().equals("")) {
				column2 = col2.name();
			} else {
				if (!fields2[i].getName().equals("serialVersionUID")) {
					column2 = fields2[i].getName();
				}
			}

		}

		// for (Field f : fields1) {
		// f.setAccessible(true);
		//
		// String column = null;
		// String value = null;
		//
		// Column col = f.getAnnotation(Column.class);
		//
		// if (col != null && !col.name().equals("")) {
		// column = col.name();
		// } else {
		// if (!f.getName().equals("serialVersionUID")) {
		// column = f.getName();
		// }
		// }
		//
		// Object o = null;
		// try {
		// o = f.get(entityInit);
		// } catch (IllegalArgumentException | IllegalAccessException e) {
		// e.printStackTrace();
		// }
		// if (o != null) {
		// if (f.getType() == Calendar.class) {
		//
		// SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		// Calendar cc = (Calendar) o;
		// String formatted = simple.format(cc.getTime());
		// value = formatted;
		//
		// } else {
		// if (f.getType() != List.class && f.getType() != ArrayList.class) {
		// value = String.valueOf(o);
		// }
		// }
		// }
		//
		// if (column != null && value != null) {
		//
		// if (mappedEntityInit != null) {
		// mappedEntityInit.put(column, value);
		//
		// } else {
		// mappedEntityInit = new HashMap<>();
		// mappedEntityInit.put(column, value);
		// }
		// }
		// }
		return mappedEntities;
	}

	@SuppressWarnings("unchecked")
	public T findById(PK pk) {
		T retorno;

		try {
			retorno = (T) openInstance().find(this.manipulada, pk);
		} catch (Exception e) {
			throw e;
		} finally {
			// closeInstance();
		}

		return retorno;
	}

}
