package converter;

import javax.faces.convert.FacesConverter;

import model.dao.UnidadeMedidaDAO;
import model.entity.UnidadeMedida;

@FacesConverter(value = "unidadeConverter")
public class UnidadeConverter extends GenericConverter<UnidadeMedida, UnidadeMedidaDAO>{
	public UnidadeConverter() {
		super(new UnidadeMedida(), new UnidadeMedidaDAO());
	}

}
