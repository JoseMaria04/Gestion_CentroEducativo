package com.jmgl.centroEducativo.view;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

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
		this.setExtendedState(MAXIMIZED_BOTH);

		
		JTabbedPane tabedPane = new JTabbedPane();
		tabedPane.add("Cursos", new PanelCurso());
		tabedPane.add("Estudiantes", new PanelEstudiante2());
		tabedPane.add("Profesores", new PanelProfesor2());
		tabedPane.add("Materias", new PanelMateria());
		tabedPane.add("Valoracion de la Materia", new PanelValoracionMateria());
		this.setContentPane(tabedPane);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				String [] opciones ={"Aceptar","Cancelar"};
				int eleccion = JOptionPane.showOptionDialog(null,"¿Desea cerrar la aplicación?","Salir de la aplicación",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
				if (eleccion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	
	/**
	 * 
	 */
	private void setDimensionesBasicas() {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, ANCHO, ALTO);
	}
	
	
}
