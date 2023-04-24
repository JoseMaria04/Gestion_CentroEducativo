package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.jmgl.centroEducativo.controller.ControladorValoracionMateriaJPA;
import com.jmgl.centroEducativo.modelJPA.Estudiante;
import com.jmgl.centroEducativo.modelJPA.Materia;
import com.jmgl.centroEducativo.modelJPA.Profesor;
import com.jmgl.centroEducativo.modelJPA.Valoracionmateria;

import java.awt.Insets;
import java.awt.Color;

public class PanelCargarALumno extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTextField textField;
	private Estudiante estudiante;

	/**
	 * Create the panel.
	 */
	public PanelCargarALumno(Estudiante estudiante, Profesor p, Materia m) {
		setBackground(new Color(255, 255, 128));
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{153, 308};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel(estudiante.getNombre() + " " + estudiante.getApellido1() + " " + estudiante.getApellido2());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(10, 10, 10, 10);
		gbc_textField.weightx = 1.0;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		this.estudiante = estudiante;
		
		setCalificaciones(p.getId(), m.getId());
	}

	/**
	 * 
	 * @param idProfesor
	 * @param idMateria
	 */
	public  void setCalificaciones(int idProfesor, int idMateria) {
		Valoracionmateria va = (Valoracionmateria) ControladorValoracionMateriaJPA.findByProfesorAndMateriaAndEstudiante(idProfesor, idMateria, this.estudiante.getId());
		if(va != null) {
			textField.setText("" + va.getValoracion());
		}
		else {
			textField.setText("");
		}
	}
	
	/**
	 * 
	 * @param p
	 * @param m
	 */
	public void  guardar(Profesor p, Materia m) {
		Valoracionmateria va = (Valoracionmateria) ControladorValoracionMateriaJPA.findByProfesorAndMateriaAndEstudiante(m.getId(), p.getId(), this.estudiante.getId());
		
		if(va != null) {
			update(va);
		}
		else if(!textField.getText().isBlank() || !textField.getText().isEmpty()){
			va = new Valoracionmateria();
			va.setProfesor(p);
			va.setMateria(m);
			va.setEstudiante(estudiante);
			insert(va);
		}
	}
	
	/**
	 * 
	 * @param va
	 */
	private  void update(Valoracionmateria va) {
		if(! textField.getText().isEmpty()) {
			va.setValoracion(Float.parseFloat(textField.getText()));
			ControladorValoracionMateriaJPA.modificarValoracionMateria(va);
		}
	}
	
	private void insert(Valoracionmateria va) {
		va.setValoracion(Float.parseFloat(textField.getText()));
		ControladorValoracionMateriaJPA.creacionValoracionMateria(va);
	}
}
