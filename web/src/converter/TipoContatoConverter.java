package converter;

import javax.faces.convert.FacesConverter;

import model.dao.TipoContatoDAO;
import model.entity.TipoContato;

@FacesConverter(value = "tipoContatoConverter")
public class TipoContatoConverter extends GenericConverter<TipoContato, TipoContatoDAO> {

	public TipoContatoConverter() {
		super(new TipoContato(), new TipoContatoDAO());
	}

}