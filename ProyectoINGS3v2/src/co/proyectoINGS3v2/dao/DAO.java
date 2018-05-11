package co.proyectoINGS3v2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	private Connection cn;

	public Connection getCn() {
		return cn;
	}

	public void setCn(Connection cn) {
		this.cn = cn;
	}

	public void conectar() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bd_ventas?user=root&password=123");
		} catch (Exception e) {
			throw e;
		}

	}

	public void cerrar() throws Exception {
		try {
			if (cn != null) {
				if (cn.isClosed() == false) {
					cn.close();
				}
			}
		} catch (Exception e) {
			throw e;
		}

	}
}
