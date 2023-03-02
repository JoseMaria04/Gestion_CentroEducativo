package com.jmgl.centroEducativo.view;

import javax.swing.JFrame;

import com.jmgl.centroEducativo.utils.Apariencia;


public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int ANCHO = 800;
	public static int ALTO = 600;
	public static String TITULO_APLICACION = "Gestion Centro Educativo";
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	/**
	 * 
	 */
	public VentanaPrincipal() {
		super(TITULO_APLICACION);
		setDimensionesBasicas();
		
	}
	
	/**
	 * 
	 */
	private void setDimensionesBasicas() {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, ANCHO, ALTO);
	}
	
}
