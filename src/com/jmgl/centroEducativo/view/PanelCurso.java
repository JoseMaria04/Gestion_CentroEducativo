package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;


import java.awt.GridBagLayout;
import javax.swing.JTextField;

import com.jmgl.centroEducativo.controller.ControladorCurso;
import com.jmgl.centroEducativo.model.Curso;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCurso extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;

	/**
	 * 
	 */
	public PanelCurso() {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblNewLabel_2 = new JLabel("Gestion de cursos");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(20, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Identificador:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
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
		gbc_textField.weightx = 1.0;
		gbc_textField.insets = new Insets(10, 10, 10, 10);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.weightx = 1.0;
		gbc_textField_1.insets = new Insets(10, 10, 10, 10);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		
		btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorCurso.findFirst());;
			}
		});
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorCurso.findPrevious(Integer.parseInt(textField.getText())));
			}
		});
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorCurso.findNext(Integer.parseInt(textField.getText())));
			}
		});
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorCurso.findLast());
			}
		});
		panel.add(btnNewButton_3);
		
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
			modificar();
			}
		});
		panel.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Borrar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			borrar();
			}
		});
		
		btnNewButton_7 = new JButton("Eliminar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		panel.add(btnNewButton_7);
		panel.add(btnNewButton_6);
		
		cargarPrimero();
	}
	
//	/**
//	 * 
//	 */
//	private void cargarPrimerRegistro() {
//		Curso c = ControladorCurso.findFirst();
//		if (c != null) {
//			this.textField.setText("" + c.getId());
//			this.textField_1.setText((c.getDescripcion()));
//		}
//	}
//	
//	/**
//	 * 
//	 */
//	private void cargarUltimoRegistro() {
//		Curso c = ControladorCurso.findLast();
//		if (c != null) {
//			this.textField.setText("" + c.getId());
//			this.textField_1.setText((c.getDescripcion()));
//		}
//	}
//	
//	/**
//	 * 
//	 */
//	private void cargarProximoRegistro() {
//		int actualId = Integer.parseInt(this.textField.getText());
//		Curso c = ControladorCurso.findNext(actualId);
//		if (c != null) {
//			this.textField.setText("" + c.getId());
//			this.textField_1.setText((c.getDescripcion()));
//		}
//	}
//	
//	/**
//	 * 
//	 */
//	private void cargarAnteriorRegistro() {
//		int actualId = Integer.parseInt(this.textField.getText());
//		Curso c = ControladorCurso.findPrevious(actualId);
//		if (c != null) {
//			this.textField.setText("" + c.getId());
//			this.textField_1.setText((c.getDescripcion()));
//		}
//	}
		
	/**
	 * 
	 */
	private void modificar() {
		Curso c = new Curso();
		c.setId(Integer.parseInt(this.textField.getText()));
		c.setDescripcion(this.textField_1.getText());
		int rowsAffected = ControladorCurso.modificar(c);
		if (rowsAffected == 1) {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Algo ha fallado");
		}
	}
	
	/**
	 * 
	 */
	private void guardar() {
		Curso c = new Curso();
		c.setId(Integer.parseInt(this.textField.getText()));
		c.setDescripcion(this.textField_1.getText());
		if (c.getId() == 0) {
			int nuevoId = ControladorCurso.save(c);
			if (nuevoId < 1) {
				JOptionPane.showMessageDialog(null, "Algo ha fallado");		}
			else {
				this.textField.setText("" + nuevoId);
			}
		}
		else {
			if (ControladorCurso.modificar(c) != 1) {
				JOptionPane.showMessageDialog(null, "Algo ha fallado");
			}
		}
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", 
				"Eliminación", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, posiblesRespuestas, posiblesRespuestas[1]);
		 if(opcionElegida == 0) {
			 int actualId = Integer.parseInt(this.textField.getText());
				int rowsAffected = ControladorCurso.delete(actualId);
				if (rowsAffected == 1) {
					JOptionPane.showConfirmDialog(null, "Guardado correctamente");
					// Cargo otro registro en pantalla
			    	Curso mAnterior = ControladorCurso.findPrevious(actualId);
			    	if (mAnterior != null) {
			    		cargarEnPantalla(mAnterior);
			    	}
			    	else {
			    		Curso mSiguiente = ControladorCurso.findNext(actualId);
			    		if (mSiguiente != null) {
			    			cargarEnPantalla(mSiguiente);
			    		}
			    		else { // No quedan registros, has eliminado el único
			    			borrar();
			    		}
			    	}
				}
				else {
					JOptionPane.showMessageDialog(null, "Algo ha fallado");
				}
		 }
		
	}
	
	/**
	 * 
	 */
	private void borrar() {
		this.textField.setText("0");
		this.textField_1.setText("");
	}
	
	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (Curso c) {
		if (c != null) {
			this.textField.setText("" + c.getId());
			this.textField_1.setText(c.getDescripcion());			
		}
		
		// Habilito y deshabilito botones de navegación
		if (ControladorCurso.findPrevious(Integer.parseInt(textField.getText())) == null) {
			this.btnNewButton.setEnabled(false);
			this.btnNewButton_1.setEnabled(false);
		}
		else {
			this.btnNewButton.setEnabled(true);
			this.btnNewButton_1.setEnabled(true);
		}

		if (ControladorCurso.findNext(Integer.parseInt(textField.getText())) == null) {
			this.btnNewButton_3.setEnabled(false);
			this.btnNewButton_2.setEnabled(false);
		}
		else {
			this.btnNewButton_3.setEnabled(true);
			this.btnNewButton_2.setEnabled(true);
		}
	
	}
	
	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorCurso.findFirst());
	}

}
