package com.flamingo.quiosco.controladores;

import com.flamingo.quiosco.servicios.ClienteQueryDB;
import com.flamingo.quiosco.transformadores.TramaInToParameters;
import org.apache.log4j.Logger;
import com.flamingo.quiosco.util.Util;

public class ControladorPeticiones {
	private Logger log = Util.getLogger();

	private final String VERSION = "1.0.0";

	public ControladorPeticiones() throws Exception {
		System.out.println("[QuioscoPOS] - Iniciando Modulo version: " + VERSION);
		log.debug("[QuioscoPOS] - Iniciando Modulo version: " + VERSION);
	}

	public String procesar(String trama) {
		try {
			System.out.println("[QuioscoPOS] - Procesando trama-> " + trama);
			this.log.debug("[QuioscoPOS] - Procesando trama-> " + trama);

			// Pasa la trama de entrada a tokens:
			TramaInToParameters parameters = new TramaInToParameters(trama);

			return ("999|" + ClienteQueryDB.runQuery(parameters) + " `0");
		} catch (Exception e) {
			this.log.error("[QuioscoPOS] - Error en Consulta -> " + e.getMessage(), e);
			return "300|Error en Consulta";
		}
	}
}
