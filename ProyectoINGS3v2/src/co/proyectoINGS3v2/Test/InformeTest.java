package co.proyectoINGS3v2.Test;

import static org.junit.Assert.assertNotEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.proyectoINGS3v2.dao.InformeDao;
import co.proyectoINGS3v2.modelo.Informe;
import co.proyectoINGS3v2.modelo.Venta;

public class InformeTest {
	
	private Venta v;
	private Informe i;
	private Informe i2;
	private InformeDao inf;
	private List<Informe> listaTest;
	private List<Informe> listaTest2;

	@Test
	public void debeTraerUnaListaConElInformePorFechas() throws Exception {
		
		v = new Venta();
		inf = new InformeDao();
		listaTest = new ArrayList<Informe>();
		listaTest2 = new ArrayList<Informe>();
		
		i = new Informe();
		i2 = new Informe();
		
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		String strdate1 = "2018-05-10 13:17:44";
		String strdate2 = "2018-05-22 13:17:31";

		Date fecha1 = dateformat2.parse(strdate1);
		Date fecha2 = dateformat2.parse(strdate2);
		
		v.setFecha(fecha1);
		v.setFecha2(fecha2);
		
		i.setPersonaNombre("david");
		i.setProductoNombre("zapato");
		i.setProductoCantidad(2);
		i.setMonto(2000.00);
		
		i2.setPersonaNombre("alejandro");
		i2.setProductoNombre("chancla");
		i2.setProductoCantidad(1);
		i2.setMonto(1500.00);
		
		listaTest.add(i);
		listaTest.add(i2);
		
		listaTest2 = inf.informe(v);
		
		assertNotEquals(listaTest, listaTest2);
		
	}

}
