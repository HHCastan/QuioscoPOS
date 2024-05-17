package com.flamingo.quiosco.transformadores;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetToTramaOut {

	public static String ResultSetToTramaout(ResultSet rs) {
		String result = "`";
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			int realColumnsNbr = 0;

			// Procesa el primer registro como campos independientes
			rs.next();
			for (int l = 1; l <= columnsNumber; l++) {
				String columnValue = rs.getString(l);
				if (columnValue.compareTo("*") != 0) {
					result = result + columnValue + "`";
					realColumnsNbr++;
				}
			}
			
			// Completa los parmetros hasta llegar a 10
			for (int i = realColumnsNbr; i < 10; i++) 
				result = result + " `";

			// Inicia el proceso del detalle
			int k = 0;
			while (rs.next())
			{
				for (int l = 1; l <= columnsNumber; l++) {
					String columnValue = rs.getString(l);
					if (columnValue.compareTo("*") != 0)
						result = result + columnValue.replace('$', '-') + ";";
				}
				// Quita el ultimo punto y coma
				result = result.substring(0, result.length() - 1);
				result = result + "~";
				k++;
			}
			// Si hay detalle, quita la ultima ~
			if (k != 0)
				result = result.substring(0, result.length() - 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

}
