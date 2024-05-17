package com.flamingo.quiosco.transformadores;

import java.util.StringTokenizer;

import com.flamingo.quiosco.util.Util;

public class TramaInToParameters {
	private StringTokenizer tokens = null;
	private StringTokenizer parametros = null;
	
	public TramaInToParameters(String tramaIn)
	{
		setTokens(tramaIn);
		setParametros(this.tokens.nextToken());
		
	}

	public StringTokenizer getTokens() {
		return tokens;
	}

	public void setTokens(String tramaIn) {
		this.tokens = new StringTokenizer(tramaIn, "|");
	}

	public StringTokenizer getParametros() {
		return parametros;
	}

	public void setParametros(String parametrosIN) {
	    // Agrega los campos: Tienda y caja a la trama:
		parametrosIN = parametrosIN + Util.getTienda();
		parametrosIN = parametrosIN + "~" + Util.getTerminal();
		System.out.println("ParametrosIN: " + parametrosIN);
		this.parametros = new StringTokenizer(parametrosIN, "~");
	      
	}

}
