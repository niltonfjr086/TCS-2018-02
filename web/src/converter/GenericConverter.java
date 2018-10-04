package converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import model.dao.GenericDAO;

/**
 * Esta classe resolve a conversão genérica das entidades que herdam do DAO genérico desse projeto para 
 * componentes de interface gráfica usados em projetos com JSF
 * @author main
 *
 * @param <T> - Recebe o ojeto construído da entidade
 * @param <DAO> - Recebe o ojeto construído da classe DAO correspondente
 */
public abstract class GenericConverter<T, DAO extends GenericDAO<T, Long>> implements Converter {

	private T t;
	private DAO dao;

	public GenericConverter(T objetoT, DAO objetoDAO) {
		super();
		this.t = objetoT;
		this.dao = objetoDAO;
	}

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

		if (string != null) {
			
			List<T> lista = dao.findAll();

			for (T objeto : lista) {
				if (objeto.toString().equalsIgnoreCase(string)) {
					return (T) objeto;
				}
			}
		}
		return this.t;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {

		if (objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
