package converter;

import javax.faces.convert.FacesConverter;

import model.dao.NichoDAO;
import model.entity.Nicho;


@FacesConverter(value = "nichoConverter")
public class NichoConverter extends GenericConverter<Nicho, NichoDAO>{

	public NichoConverter(Nicho objetoT, NichoDAO objetoDAO) {
		super(objetoT, objetoDAO);
		// TODO Auto-generated constructor stub
	}

}



