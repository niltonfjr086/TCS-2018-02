package converter;

import javax.faces.convert.FacesConverter;

import model.dao.NichoDAO;
import model.entity.Nicho;


@FacesConverter(value = "nichoConverter")
public class NichoConverter extends GenericConverter<Nicho, NichoDAO>{

	public NichoConverter() {
		super(new Nicho(), new NichoDAO());
	}

}



