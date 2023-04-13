package com.jmgl.centroEducativo.view;

import java.awt.Color;

public class CambiaColorEvent {
	private Color color;
	private boolean esProfesor;

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the esProfesor
	 */
	public boolean isEsProfesor() {
		return esProfesor;
	}

	/**
	 * @param esProfesor the esProfesor to set
	 */
	public void setEsProfesor(boolean esProfesor) {
		this.esProfesor = esProfesor;
	}
}
