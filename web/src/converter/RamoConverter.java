package converter;

import javax.faces.convert.FacesConverter;

import model.dao.RamoDAO;
import model.entity.Ramo;

@FacesConverter(value = "ramoConverter")
public class RamoConverter extends  GenericConverter<Ramo, RamoDAO>{

	public RamoConverter() {
		super(new Ramo(), new RamoDAO());
		// TODO Auto-generated constructor stub
	}
}
	


