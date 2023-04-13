package com.jmgl.centroEducativo.view;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.jmgl.centroEducativo.controller.ControladorEstudiante;
import com.jmgl.centroEducativo.controller.ControladorMateria;
import com.jmgl.centroEducativo.controller.ControladorProfesor;
import com.jmgl.centroEducativo.controller.ControladorValoracionMateria;
import com.jmgl.centroEducativo.model.Estudiante;
import com.jmgl.centroEducativo.model.Materia;
import com.jmgl.centroEducativo.model.Profesor;
import com.jmgl.centroEducativo.model.ValoracionMateria;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelValoracionMateria extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_4;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Estudiante> jcbEstudiante;
	JComboBox<Materia> jcbMateria;
	private JButton btnNewButton_7;

	
	public PanelValoracionMateria() {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblNewLabel_2 = new JLabel("Gestion de Materia");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(20, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(10, 10, 10, 10);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID del Profesor: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(10, 10, 10, 10);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 2;
		gbc_jcbProfesor.gridy = 2;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_3 = new JLabel("ID del Estudiante: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbEstudiante = new JComboBox<Estudiante>();
		jcbEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				  Object selected = jcbEstudiante.getSelectedItem();
//			        if (selected != null) {
//			        	jcbMateria.setVisible(true);
//			        }			
			}
		});
		GridBagConstraints gbc_jcbEstudiante = new GridBagConstraints();
		gbc_jcbEstudiante.insets = new Insets(10, 10, 10, 10);
		gbc_jcbEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEstudiante.gridx = 2;
		gbc_jcbEstudiante.gridy = 3;
		add(jcbEstudiante, gbc_jcbEstudiante);
		
		JLabel lblNewLabel_4 = new JLabel("ID de la Materia: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbMateria = new JComboBox<Materia>();
//		jcbMateria.setVisible(false);
		jcbMateria.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(10, 10, 10, 10);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 2;
		gbc_jcbMateria.gridy = 4;
		add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_5 = new JLabel("Valoracion: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(10, 10, 10, 10);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 5;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorValoracionMateria.findPrevious(Integer.parseInt(textField.getText())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorValoracionMateria.findNext(Integer.parseInt(textField.getText())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorValoracionMateria.findLast());
			}
		});
		panel.add(btnUltimo);
		
		btnNewButton_4 = new JButton("Guardar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Modificar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Eliminar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		panel.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("Borrar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		panel.add(btnNewButton_7);
		
		cargarPrimero();
		cargarProfesorEstudianteMateriaEnJCombo();
	}
	
	/**
	 * 
	 */
	private void cargarProfesorEstudianteMateriaEnJCombo() {
		List<Profesor> profesor = ControladorProfesor.findAll();
		for (Profesor profesor1 : profesor) {
			this.jcbProfesor.addItem(profesor1);
		}
		
		List<Estudiante> estudiante = ControladorEstudiante.findAll();
		for (Estudiante estudiante1 : estudiante) {
			this.jcbEstudiante.addItem(estudiante1);
		}
		
		List<Materia> materia = ControladorMateria.findAll();
		for (Materia materia1 : materia) {
			this.jcbMateria.addItem(materia1);
		}
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", 
				"Eliminación", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	int actualId = Integer.parseInt(this.textField.getText());
		    if (ControladorMateria.eliminar(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	ValoracionMateria mAnterior = ControladorValoracionMateria.findPrevious(actualId);
		    	if (mAnterior != null) {
		    		cargarEnPantalla(mAnterior);
		    	}
		    	else {
		    		ValoracionMateria mSiguiente = ControladorValoracionMateria.findNext(actualId);
		    		if (mSiguiente != null) {
		    			cargarEnPantalla(mSiguiente);
		    		}
		    		else { // No quedan registros, has eliminado el único
		    			limpiarDatos();
		    		}
		    	}
		    }
	    }
		
	}
	
	/**
	 * 
	 */
	private void guardar() {
		ValoracionMateria va = new ValoracionMateria();
		va.setId(Integer.parseInt(this.textField.getText()));
		va.setValoracion(Float.parseFloat(this.textField_4.getText()));
		
		Estudiante e = (Estudiante) this.jcbEstudiante.getSelectedItem();
		va.setIdEstudiante(e.getId());
		
		Profesor p = (Profesor) this.jcbProfesor.getSelectedItem();
		va.setIdProfesor(p.getId());
		
		Materia m = (Materia) this.jcbMateria.getSelectedItem();
		va.setIdMateria(m.getId());
		
		String strError = "No se ha podido guardar";
		if (va.getId() == 0) {
			int nuevoIdInsertado = ControladorValoracionMateria.insertar(va);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				this.textField.setText("" + nuevoIdInsertado);
			}
		}
		else {
			if (ControladorValoracionMateria.modificar(va) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}
		
	}
	
	/**
	 * 
	 */
	private void limpiarDatos() {
		this.textField.setText("0");
		this.textField_4.setText("");
		if (this.jcbEstudiante.getItemCount() > 0) {
			this.jcbEstudiante.setSelectedIndex(0);
		}
		if (this.jcbMateria.getItemCount() > 0) {
			this.jcbMateria.setSelectedIndex(0);
		}
		if (this.jcbProfesor.getItemCount() > 0) {
			this.jcbProfesor.setSelectedIndex(0);
		}
	}
	
	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorValoracionMateria.findFirst());
	}
	
	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (ValoracionMateria mAnterior) {
		if (mAnterior != null) {
			this.textField.setText("" + mAnterior.getId());
			this.textField_4.setText("" + mAnterior.getValoracion());
			
			for (int i = 0; i < this.jcbEstudiante.getItemCount(); i++) {
				Estudiante e = this.jcbEstudiante.getItemAt(i);
				if (mAnterior.getIdEstudiante() == e.getId()) {
					this.jcbEstudiante.setSelectedIndex(i);
				}
			}
			
			for (int i = 0; i < this.jcbMateria.getItemCount(); i++) {
				Materia m = this.jcbMateria.getItemAt(i);
				if (mAnterior.getIdMateria() == m.getId()) {
					this.jcbMateria.setSelectedIndex(i);
				}
			}
			
			for (int i = 0; i < this.jcbProfesor.getItemCount(); i++) {
				Profesor p = this.jcbProfesor.getItemAt(i);
				if (mAnterior.getIdProfesor() == p.getId()) {
					this.jcbProfesor.setSelectedIndex(i);
				}
			}
		}
		
		// Habilito y deshabilito botones de navegación
		if (ControladorValoracionMateria.findPrevious(Integer.parseInt(textField.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		}
		else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorValoracionMateria.findNext(Integer.parseInt(textField.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		}
		else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}
	
	}

}
