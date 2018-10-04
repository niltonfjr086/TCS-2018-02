package converter;

import javax.faces.convert.FacesConverter;

import model.dao.TipoPessoaDAO;
import model.entity.TipoPessoa;

@FacesConverter(value = "tipoPessoaConverter")
public class TipoPessoaConverter extends GenericConverter<TipoPessoa, TipoPessoaDAO> {

	public TipoPessoaConverter() {
		super(new TipoPessoa(), new TipoPessoaDAO());
	}

}