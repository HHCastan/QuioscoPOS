package com.flamingo.quiosco.servicios;

import java.util.Properties;
import java.util.StringTokenizer;
import java.sql.*;

import com.flamingo.quiosco.transformadores.ResultSetToTramaOut;
import com.flamingo.quiosco.transformadores.TramaInToParameters;

public class ClienteQueryDB {

	public static String runQuery(TramaInToParameters tramaToken) {
		StringTokenizer arTokens = tramaToken.getTokens();
		StringTokenizer arParametros = tramaToken.getParametros();
		int i = 0;
		int k = arParametros.countTokens();
		String[] stListaParametros = new String[k];
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		String tramaOut = null;

		String stSQL = "";
		while (arParametros.hasMoreTokens()) {
			stListaParametros[i] = arParametros.nextToken();
			System.out.println("stListaParametros[" + i + "]: " + stListaParametros[i]);
			stSQL = stSQL + " '" + stListaParametros[i] + "',";
			i++;
		}

		if (arTokens.hasMoreTokens()) {
			System.out.println("Tiene tokens: " + arTokens.countTokens());
		}
		String stConexion_DB = arTokens.nextToken();
		System.out.println("stConexion_DB: " + stConexion_DB);
		String stDriver_DB = arTokens.nextToken();
		System.out.println("stDriver_DB: " + stDriver_DB);
		String stVistaQuery = arTokens.nextToken();
		System.out.println("stVistaQuery: " + stVistaQuery);

		// Arma la consulta y quita la ultima coma a la derecha de los
		// parametros:
		stSQL = stVistaQuery + stSQL.substring(0, stSQL.length() - 1);
		System.out.println("stSQL: " + stSQL);

		// Extrae el usuario del string de conexion:
		int iIni = stConexion_DB.indexOf("=") + 1;
		int iFin = stConexion_DB.indexOf(";p");
		String userID = stConexion_DB.substring(iIni, iFin);
		System.out.println("Usuario: " + userID);

		// Extrae el password del string de conexion:
		iIni = stConexion_DB.indexOf("d=") + 2;
		iFin = stConexion_DB.length();
		String passwd = stConexion_DB.substring(iIni, iFin);
		System.out.println("Usuario: " + passwd);

		// Registrar el controlador JDBC nativo. Si el controlador no puede
		// registrarse, la prueba no puede continuar.
		try {
			Class.forName(stDriver_DB);
		} catch (ClassNotFoundException ex) {
			return "Error registrando controlador: " + ex.toString();
		} catch (Exception e) {
			return "Error registrando controlador: " + e.getMessage();
		} catch (Throwable t) {
			return "Error registrando controlador: " + t.getMessage();
		}
		// return "Despues de registrar driver: " + userID + ", " + passwd;
		// }

		// Crear las propiedades de conexión.
		Properties properties = new Properties();
		properties.put("user", userID);
		properties.put("password", passwd);

		// Conectar con la base de datos indicada:
		try {
			c = DriverManager.getConnection(stConexion_DB, properties);
		} catch (SQLException sqle) {
			System.out.println("El proceso de base de datos ha fallado.");
			System.out.println("Razón: " + sqle.getMessage());
		} finally {
			// Se cierran los recursos de base de datos.
			try {
				if (s != null) {
					s.close();
				}
			} catch (SQLException e) {
				System.out.println("No se ha podido cerrar Statement.");
			}
		}

		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(stSQL);

			// ps.setInt(1, 5);

			// Se ejecuta una consulta SQL en la tabla.
			rs = ps.executeQuery();
			tramaOut = ResultSetToTramaOut.ResultSetToTramaout(rs);
			return tramaOut;

		} catch (SQLException sqle) {
			System.out.println("El proceso de base de datos ha fallado..");
			System.out.println("Razón: " + sqle.getMessage());
		} finally {
			// Se cierran los recursos de base de datos.
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				System.out.println("El borrado no ha podido cerrar Statement.");
			}

			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException e) {
				System.out.println("El borrado no ha podido cerrar Connection.");
			}

		}

		return null;

	}
}
