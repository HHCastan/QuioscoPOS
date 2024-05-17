package com.flamingo.quiosco.test;

import com.flamingo.quiosco.controladores.ControladorPeticiones;

public class Prueba {
	public static void main(String[] args) {
		System.out.println("Iniciando Quiosco...");

		 String tramaIN = "770158102112~|jdbc:jtds:sqlserver://172.16.8.150:1433/engage;user=engage;password=flamingo|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_PROMOSxEAN|VoucherConsultaProductos";
//		 String tramaIN = "3573862~|jdbc:jtds:sqlserver://172.16.8.115:1433/DB_SICAF;user=consultapos;password=nzcs6urC|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_SALDOS_CLIENTE_ORACLE|VoucherConsultaProductos";
//		 String tramaIN = "41951766~|jdbc:jtds:sqlserver://172.16.8.115:1433/DB_SICAF;user=consultapos;password=nzcs6urC|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_SALDOS_CLIENTE_ORACLE|VoucherConsultaProductos";
//		String tramaIN = "770213813821~|jdbc:jtds:sqlserver://172.16.8.115:1433/DB_SICAF;user=consultapos;password=nzcs6urC|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_PRECIOS|VoucherConsultaProductos";
//		 String tramaIN = "770200704915~|jdbc:jtds:sqlserver://172.16.8.115:1433/DB_SICAF;user=consultapos;password=nzcs6urC|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_INVENTARIO|VoucherConsultaProductos";
//		 String tramaIN = "01~71682912~123654789~3005324216~1236987415~1~|jdbc:jtds:sqlserver://172.16.8.123:1433/MERCADEO;user=consultapos;password=KHEnUQag|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_CLIENTE_PREAPROBADO|VoucherConsultaProductos";
//		String tramaIN = "770211301270~|jdbc:jtds:sqlserver://172.16.8.55:1433/engagepruebas;user=engage;password=flamingo|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_PROMOSxEAN";
//		String tramaIN = "121212~1128434956~AGUIRRE~ZORRILLA~ALEXANDER~ ~4545454~alex@lds.com~1~|jdbc:jtds:sqlserver://172.16.8.246:1433/ProspectosXcanal;user=consultapos;password=nzcs6urC|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_CLIENTE_NUEVO_ORACLE";
//		String tramaIN = "123~88224266~rivera~a~jjjjj~ss~545454~hghjggj~2~|jdbc:jtds:sqlserver://172.16.8.246:1433/ProspectosXcanal;user=consultapos;password=nzcs6urC|net.sourceforge.jtds.jdbc.Driver|PRC_QUIOSCO_CLIENTE_NUEVO_ORACLE_PRESELECTA";
		   
		String prueba = null;
		try {
			prueba = new ControladorPeticiones().procesar(tramaIN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(prueba);

	}
}