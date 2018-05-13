package co.proyectoINGS3v2.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.proyectoINGS3v2.dao.InformeDao;
import co.proyectoINGS3v2.modelo.Informe;
import co.proyectoINGS3v2.modelo.Venta;

@ManagedBean
@ViewScoped
public class InformeBean {

	private Venta ven = new Venta();
	private List<Informe> lstInforme;
	
	public Venta getVen() {
		return ven;
	}

	public void setVen(Venta ven) {
		this.ven = ven;
	}

	public List<Informe> getLstInforme() {
		return lstInforme;
	}

	public void setLstInforme(List<Informe> lstInforme) {
		this.lstInforme = lstInforme;
	}

	public void informe() throws Exception {
		InformeDao dao;
		try {
			dao = new InformeDao();
			lstInforme = dao.informe(ven);
		} catch (Exception e) {
			throw e;
		}
	}
}
