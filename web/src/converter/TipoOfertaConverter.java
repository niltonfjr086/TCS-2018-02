package converter;

import javax.faces.convert.FacesConverter;

import model.dao.TipoOfertaDAO;
import model.entity.TipoOferta;

@FacesConverter(value = "tipoOfertaConverter")
public class TipoOfertaConverter extends GenericConverter<TipoOferta, TipoOfertaDAO> {
	public TipoOfertaConverter() {
		super(new TipoOferta(), new TipoOfertaDAO());

	}
}
