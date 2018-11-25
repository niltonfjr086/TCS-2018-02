package model.filter;

//import java.lang.reflect.Field;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.Column;
//import javax.persistence.Table;

public class FilterBuilder<T extends Object> {

	// private T t;
	// private Class<T> c;
	//
	// private int limite;
	// private int pagina;
	//
	//
	// public FilterBuilder(T t, int limite, int pagina) {
	// super();
	// this.t = t;
	// this.limite = limite;
	// this.pagina = pagina;
	// }
	//
	// public FilterBuilder(Class<T> c, int limite, int pagina) {
	// super();
	// this.c = c;
	// this.limite = limite;
	// this.pagina = pagina;
	// }

	// public static FilterBuilder<Class<?>> buildWithoutWhereCondition(int limit,
	// int page) {
	//
	// return null;
	// }
	//
	// public static FilterBuilder<Object> buildWithWhereCondition(int limit, int
	// page) {
	//
	// return null;
	// }
	//
	//
	// public StringBuilder buildSQLCommand(T entity) {
	//
	// if(entity != null) {
	//
	// Class<? extends Object> c = entity.getClass();
	//
	// Map<String, String> mappedEntity = paramsCorverter(entity);
	//
	// Table table = c.getAnnotation(Table.class);
	// StringBuilder jpql = new StringBuilder("SELECT t FROM " + table.name() + "
	// t");
	//
	// if (mappedEntity != null && mappedEntity.size() > 0) {
	//
	// jpql.append(" WHERE ");
	//
	// boolean frst = true;
	// for (Map.Entry<String, String> entry : mappedEntity.entrySet()) {
	//
	// if (!frst) {
	// jpql.append(" AND ");
	// } else {
	// frst = false;
	// }
	//
	// jpql.append("'" + entry.getKey() + "'" + " = " + "'" + entry.getValue() +
	// "'");
	// }
	// }
	// return jpql;
	// }
	// return null;
	// }
	//
	// private Map<String, String> paramsCorverter(T entity) {
	//
	// Class<? extends Object> c = entity.getClass();
	//
	// Map<String, String> mappedEntity = null;
	// Field[] fields = c.getDeclaredFields();
	//
	// for (Field f : fields) {
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
	// o = f.get(entity);
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
	// if (mappedEntity != null) {
	// mappedEntity.put(column, value);
	//
	// } else {
	// mappedEntity = new HashMap<>();
	// mappedEntity.put(column, value);
	// }
	// }
	// }
	// return mappedEntity;
	// }

}