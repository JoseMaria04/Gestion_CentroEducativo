package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;

import com.jmgl.centroEducativo.controller.ControladorEstudiante;
import com.jmgl.centroEducativo.controller.ControladorEstudianteJPA;
import com.jmgl.centroEducativo.controller.ControladorValoracionMateriaJPA;
import com.jmgl.centroEducativo.controller.ControladorMateriaJPA;
import com.jmgl.centroEducativo.controller.ControladorProfesorJPA;
import com.jmgl.centroEducativo.modelJPA.Estudiante;
import com.jmgl.centroEducativo.modelJPA.Materia;
import com.jmgl.centroEducativo.modelJPA.Profesor;
import com.jmgl.centroEducativo.modelJPA.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelValoracionMateriaJPA extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelValoracionMateriaJPA() {
		setBackground(new Color(199, 224, 223));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 366, 162 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0 };
//		gridBagLayout.columnWidths = new int[]{0, 227, 361};
//		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.weightx = 1.0;
		gbc_jcbMateria.insets = new Insets(10, 10, 10, 10);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(10, 10, 10, 10);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);

		JButton btnNewButton = new JButton("Refrescar Alumnado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(10, 10, 10, 10);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.weighty = 1.0;
		gbc_panel.insets = new Insets(10, 10, 10, 10);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 148, 0 };
//		gbl_panel.rowWeights = new double[]{0.0, 1.0};
//		gbl_panel.columnWidths = new int[]{169, 0};
//		gbl_panel.columnWeights = new double[]{1.0, 1.0};
//		gbl_panel.columnWidths = new int[]{0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		cargarMateria();
		cargarProfesor();
	}

	private void cargarMateria() {
		for (Materia m : ControladorMateriaJPA.findAllMateria()) {
			jcbMateria.addItem(m);
		}
	}

	private void cargarProfesor() {
		for (Profesor p : ControladorProfesorJPA.findAllProfesor()) {
			jcbProfesor.addItem(p);
		}
	}

}
