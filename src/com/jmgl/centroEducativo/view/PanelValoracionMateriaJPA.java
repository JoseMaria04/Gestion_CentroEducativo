package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;

import com.jmgl.centroEducativo.controller.ControladorEstudianteJPA;
import com.jmgl.centroEducativo.controller.ControladorMateriaJPA;
import com.jmgl.centroEducativo.controller.ControladorProfesorJPA;
import com.jmgl.centroEducativo.modelJPA.Estudiante;
import com.jmgl.centroEducativo.modelJPA.Materia;
import com.jmgl.centroEducativo.modelJPA.Profesor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PanelValoracionMateriaJPA extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JPanel JPaPanelExterior;
	JPanel JPaPanelInterior;
	List<PanelCargarALumno> panelCargarAlumno = new ArrayList<PanelCargarALumno>();
	private JButton btnNewButton_1;
	private int i = 0;

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
				actualizarEstudiantes(JPaPanelInterior);
				repaint();
				revalidate();

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(10, 10, 10, 10);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		JPaPanelExterior = new JPanel();
		GridBagConstraints gbc_JPaPanelExterior = new GridBagConstraints();
		gbc_JPaPanelExterior.gridwidth = 3;
		gbc_JPaPanelExterior.insets = new Insets(10, 10, 10, 10);
		gbc_JPaPanelExterior.fill = GridBagConstraints.BOTH;
		gbc_JPaPanelExterior.gridx = 0;
		gbc_JPaPanelExterior.gridy = 2;
		add(JPaPanelExterior, gbc_JPaPanelExterior);
		GridBagLayout gbl_JPaPanelExterior = new GridBagLayout();
		gbl_JPaPanelExterior.rowHeights = new int[]{106, 0};
		gbl_JPaPanelExterior.columnWidths = new int[] { 148 };
//		gbl_panel.rowWeights = new double[]{0.0, 1.0};
//		gbl_panel.columnWidths = new int[]{169, 0};
//		gbl_panel.columnWeights = new double[]{1.0, 1.0};
//		gbl_panel.columnWidths = new int[]{0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		JPaPanelExterior.setLayout(gbl_JPaPanelExterior);
		
		JPaPanelInterior = new JPanel();
		JPaPanelInterior.setBackground(new Color(255, 255, 128));
		GridBagConstraints gbc_JPaPanelInterior = new GridBagConstraints();
		gbc_JPaPanelInterior.insets = new Insets(50, 100, 10, 100);
		gbc_JPaPanelInterior.weightx = 1.0;
		gbc_JPaPanelInterior.weighty = 1.0;
		gbc_JPaPanelInterior.fill = GridBagConstraints.BOTH;
		gbc_JPaPanelInterior.gridx = 0;
		gbc_JPaPanelInterior.gridy = 0;
		JPaPanelExterior.add(JPaPanelInterior, gbc_JPaPanelInterior);
		
		btnNewButton_1 = new JButton("Guardar las notas de todos los alumnos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.insets = new Insets(10, 10, 40, 100);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		JPaPanelExterior.add(btnNewButton_1, gbc_btnNewButton_1);
		
		

		cargarMateria();
		cargarProfesor();
	}

	/**
	 * 
	 */
	private void cargarMateria() {
		for (Materia m : ControladorMateriaJPA.findAllMateria()) {
			jcbMateria.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void cargarProfesor() {
		for (Profesor p : ControladorProfesorJPA.findAllProfesor()) {
			jcbProfesor.addItem(p);
		}
	}

	/**
	 * 
	 */
	public void actualizarEstudiantes(JPanel panel) {
		
		if (this.i == 0) {
			List<Estudiante> e = (List<Estudiante>) ControladorEstudianteJPA.findAll();
			Materia m = (Materia) jcbMateria.getSelectedItem();
			Profesor p = (Profesor) jcbProfesor.getSelectedItem();
			
			for (Estudiante estudiante : e) {
				PanelCargarALumno panelCargar = new PanelCargarALumno(estudiante, p, m);
				panelCargarAlumno.add(panelCargar);
			}
			
			for (PanelCargarALumno ca : panelCargarAlumno) {
				BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
				panel.setLayout(boxLayout);
				panel.add(ca);
			}
			
			i++;
		}	
	}
	
	private void guardar() {
		Profesor p = (Profesor) jcbProfesor.getSelectedItem();
		Materia m = (Materia) jcbMateria.getSelectedItem();
		
		for (PanelCargarALumno pca : panelCargarAlumno) {
			pca.guardar(p, m);
		}
	}
	
}
