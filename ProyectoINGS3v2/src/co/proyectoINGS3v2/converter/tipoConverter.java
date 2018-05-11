package co.proyectoINGS3v2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoConverter")
public class tipoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int tipoN = 0;
		String tipoS = "";
		
		if(value != null) {
			tipoN = (int) value;
			switch (tipoN) {
			case 1:
				tipoS = "Empleado";
				break;
			case 2:
				tipoS = "Administrador";
				break;
			}
		}
		return tipoS;
	}
	
	

}
