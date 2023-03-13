package com.jmgl.centroEducativo.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;

import com.jmgl.centroEducativo.controller.ControladorCurso;
import com.jmgl.centroEducativo.controller.ControladorMateria;
import com.jmgl.centroEducativo.model.Curso;
import com.jmgl.centroEducativo.model.Materia;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMateria extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel_2;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfAcronimo;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	JComboBox<Curso> jcbCurso;

	

	/**
	 * 
	 */
	public PanelMateria() {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
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
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(10, 10, 10, 10);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(10, 10, 10, 10);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Acronimo: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfAcronimo = new JTextField();
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.insets = new Insets(10, 10, 10, 10);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 2;
		gbc_jtfAcronimo.gridy = 3;
		add(jtfAcronimo, gbc_jtfAcronimo);
		jtfAcronimo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID Curso: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbCurso = new JComboBox<Curso>();
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(10, 10, 10, 10);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 2;
		gbc_jcbCurso.gridy = 4;
		add(jcbCurso, gbc_jcbCurso);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
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
				cargarEnPantalla(ControladorMateria.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorMateria.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorMateria.findLast());

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
		
		btnNewButton_7 = new JButton("Eliminar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		panel.add(btnNewButton_7);
		
		btnNewButton_6 = new JButton("Borrar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		panel.add(btnNewButton_6);
		
		cargarCursosEnJCombo();
		cargarPrimero();
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
	    	int actualId = Integer.parseInt(this.jtfId.getText());
		    if (ControladorMateria.eliminar(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	Materia mAnterior = ControladorMateria.findPrevious(actualId);
		    	if (mAnterior != null) {
		    		cargarEnPantalla(mAnterior);
		    	}
		    	else {
		    		Materia mSiguiente = ControladorMateria.findNext(actualId);
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
	private void limpiarDatos() {
		this.jtfId.setText("0");
		this.jtfNombre.setText("");
		this.jtfAcronimo.setText("");
		if (this.jcbCurso.getItemCount() > 0) {
			this.jcbCurso.setSelectedIndex(0);
		}
	}
	
	/**
	 * 
	 */
	private void guardar() {
		Materia m = new Materia();
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setNombre(this.jtfNombre.getText());
		m.setAcronimo(this.jtfAcronimo.getText());
		
		Curso c = (Curso) this.jcbCurso.getSelectedItem();
		m.setCurso_id(c.getId());
		
		String strError = "No se ha podido guardar";
		if (m.getId() == 0) {
			int nuevoIdInsertado = ControladorMateria.insertar(m);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		}
		else {
			if (ControladorMateria.modificar(m) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}
		
	}
	
	/**
	 * 
	 */
	private void cargarCursosEnJCombo() {
		List<Curso> cursos = ControladorCurso.findAll();
		for (Curso curso : cursos) {
			this.jcbCurso.addItem(curso);
		}
	}
	
	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorMateria.findFirst());
	}
	
	
	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (Materia m) {
		if (m != null) {
			this.jtfId.setText("" + m.getId());
			this.jtfNombre.setText(m.getNombre());
			this.jtfAcronimo.setText(m.getAcronimo());
			
			for (int i = 0; i < this.jcbCurso.getItemCount(); i++) {
				Curso c = this.jcbCurso.getItemAt(i);
				if (m.getCurso_id() == c.getId()) {
					this.jcbCurso.setSelectedIndex(i);
				}
			}
		}
		
		// Habilito y deshabilito botones de navegación
		if (ControladorMateria.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		}
		else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorMateria.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		}
		else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}
	
	}
}
