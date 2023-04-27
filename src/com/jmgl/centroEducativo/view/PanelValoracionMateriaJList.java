package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;

import com.jmgl.centroEducativo.controller.ControladorEstudianteJPA;
import com.jmgl.centroEducativo.controller.ControladorMateriaJPA;
import com.jmgl.centroEducativo.controller.ControladorProfesorJPA;
import com.jmgl.centroEducativo.controller.ControladorValoracionMateriaJPA;
import com.jmgl.centroEducativo.modelJPA.Estudiante;
import com.jmgl.centroEducativo.modelJPA.Materia;
import com.jmgl.centroEducativo.modelJPA.Profesor;
import com.jmgl.centroEducativo.modelJPA.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelValoracionMateriaJList extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Float> jcbNota;
	JList<Estudiante> jLsAlumnoNoSelecionado;
	JList<Estudiante> jListAlumnoSelecionado;
	private DefaultListModel<Estudiante> listModelEstudianteIzquierda = null;
	private DefaultListModel<Estudiante> listModelEstudianteDerecha = null;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelValoracionMateriaJList() {
		setBackground(new Color(194, 199, 228));
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
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
		
		JLabel lblNewLabel_1 = new JLabel("Profesor: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
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
		
		JLabel lblNewLabel_2 = new JLabel("Nota: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox<Float>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(10, 10, 10, 10);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		add(jcbNota, gbc_jcbNota);
		
		JButton jBtnActualizarAlumnado = new JButton("Actualizar Alumnado");
		jBtnActualizarAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    listModelEstudianteDerecha.removeAllElements();
			    listModelEstudianteIzquierda.removeAllElements();

				agregarAlumnosIzquierda();
			}
		});
		GridBagConstraints gbc_jBtnActualizarAlumnado = new GridBagConstraints();
		gbc_jBtnActualizarAlumnado.insets = new Insets(10, 10, 10, 10);
		gbc_jBtnActualizarAlumnado.anchor = GridBagConstraints.EAST;
		gbc_jBtnActualizarAlumnado.gridx = 1;
		gbc_jBtnActualizarAlumnado.gridy = 3;
		add(jBtnActualizarAlumnado, gbc_jBtnActualizarAlumnado);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(10, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 231, 192));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(30, 10, 30, 10);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0};
//		gbl_panel_1.columnWidths = new int[]{0, 0};
//		gbl_panel_1.rowHeights = new int[]{0, 0};
//		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnado no selecionado:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alumnado selecionado:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(5, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jLsAlumnoNoSelecionado = new JList(getDefaultListModel(true));
		jLsAlumnoNoSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_jLsAlumnoNoSelecionado = new GridBagConstraints();
		gbc_jLsAlumnoNoSelecionado.weightx = 1.0;
		gbc_jLsAlumnoNoSelecionado.insets = new Insets(10, 10, 15, 10);
		gbc_jLsAlumnoNoSelecionado.fill = GridBagConstraints.BOTH;
		gbc_jLsAlumnoNoSelecionado.gridx = 0;
		gbc_jLsAlumnoNoSelecionado.gridy = 1;
		panel_1.add(jLsAlumnoNoSelecionado, gbc_jLsAlumnoNoSelecionado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(253, 172, 113));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(10, 10, 15, 10);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
//		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
//		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
//		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
//		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton jBtnTodosADerecha = new JButton("<<");
		jBtnTodosADerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosIzquierda();
			}
		});
		GridBagConstraints gbc_jBtnTodosADerecha = new GridBagConstraints();
		gbc_jBtnTodosADerecha.insets = new Insets(0, 0, 5, 0);
		gbc_jBtnTodosADerecha.gridx = 0;
		gbc_jBtnTodosADerecha.gridy = 0;
		panel_2.add(jBtnTodosADerecha, gbc_jBtnTodosADerecha);
		
		JButton jBtnSelecionadosADerecha = new JButton("<");
		jBtnSelecionadosADerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionadoIzquierda();
			}
		});
		GridBagConstraints gbc_jBtnSelecionadosADerecha = new GridBagConstraints();
		gbc_jBtnSelecionadosADerecha.insets = new Insets(0, 0, 5, 0);
		gbc_jBtnSelecionadosADerecha.gridx = 0;
		gbc_jBtnSelecionadosADerecha.gridy = 1;
		panel_2.add(jBtnSelecionadosADerecha, gbc_jBtnSelecionadosADerecha);
		
		JButton jBtnSelecionadosAIzquierda = new JButton(">");
		jBtnSelecionadosAIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionadoDerecha();
			}
		});
		GridBagConstraints gbc_jBtnSelecionadosAIzquierda = new GridBagConstraints();
		gbc_jBtnSelecionadosAIzquierda.insets = new Insets(0, 0, 5, 0);
		gbc_jBtnSelecionadosAIzquierda.gridx = 0;
		gbc_jBtnSelecionadosAIzquierda.gridy = 2;
		panel_2.add(jBtnSelecionadosAIzquierda, gbc_jBtnSelecionadosAIzquierda);
		
		JButton jBtnTodosAIzquierda = new JButton(">>");
		jBtnTodosAIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosDerecha();
			}
		});
		GridBagConstraints gbc_jBtnTodosAIzquierda = new GridBagConstraints();
		gbc_jBtnTodosAIzquierda.gridx = 0;
		gbc_jBtnTodosAIzquierda.gridy = 3;
		panel_2.add(jBtnTodosAIzquierda, gbc_jBtnTodosAIzquierda);
		
		jListAlumnoSelecionado = new JList(getDefaultListModel(false));
		jListAlumnoSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_jListAlumnoSelecionado = new GridBagConstraints();
		gbc_jListAlumnoSelecionado.weightx = 1.0;
		gbc_jListAlumnoSelecionado.insets = new Insets(10, 10, 15, 10);
		gbc_jListAlumnoSelecionado.fill = GridBagConstraints.BOTH;
		gbc_jListAlumnoSelecionado.gridx = 2;
		gbc_jListAlumnoSelecionado.gridy = 1;
		panel_1.add(jListAlumnoSelecionado, gbc_jListAlumnoSelecionado);
		
		JButton jbtGuardar = new JButton("Guardar Nota de todos los alumnos selecionados");
		jbtGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_jbtGuardar = new GridBagConstraints();
		gbc_jbtGuardar.gridwidth = 3;
		gbc_jbtGuardar.anchor = GridBagConstraints.EAST;
		gbc_jbtGuardar.insets = new Insets(10, 10, 10, 10);
		gbc_jbtGuardar.gridx = 0;
		gbc_jbtGuardar.gridy = 2;
		panel_1.add(jbtGuardar, gbc_jbtGuardar);
		
		cargarMateria();
		cargarProfesor();
		cargarNota();
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
	private void cargarNota() {
		String[] numerosNota = new String[] {"0.0", "1.0", "2.0", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0",};
		
		for(int i = 0; i < numerosNota.length; i++) {
			jcbNota.addItem(Float.parseFloat(numerosNota[i]));
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModel(boolean isIzquierda) {
		if(isIzquierda) {
			this.listModelEstudianteIzquierda = new DefaultListModel<Estudiante>();
			return this.listModelEstudianteIzquierda;
		}
		else {
			this.listModelEstudianteDerecha = new DefaultListModel<Estudiante>();
			return this.listModelEstudianteDerecha;
		}
	}
	
	/**
	 * 
	 */
	private void agregarAlumnosIzquierda() {
		this.listModelEstudianteIzquierda.removeAllElements();
		
		for (Estudiante e : ControladorEstudianteJPA.findAll()) {
			this.listModelEstudianteIzquierda.addElement(e);

		}
	}
	
	/**
	 * 
	 */
	private void todosIzquierda() {
		for (int i = 0; i < this.listModelEstudianteDerecha.size(); i++) {
		    this.listModelEstudianteIzquierda.addElement(this.listModelEstudianteDerecha.getElementAt(i));
		}
		
	    this.listModelEstudianteDerecha.removeAllElements();
	}
	
	/**
	 * 
	 */
	private void selecionadoIzquierda() {
		this.listModelEstudianteIzquierda.addElement(this.jListAlumnoSelecionado.getSelectedValue());
		this.listModelEstudianteDerecha.removeElement(this.jListAlumnoSelecionado.getSelectedValue());
	}
	
	/**
	 * 
	 */
	private void todosDerecha() {
		for (int i = 0; i < this.listModelEstudianteIzquierda.size(); i++) {
		    this.listModelEstudianteDerecha.addElement(this.listModelEstudianteIzquierda.getElementAt(i));
		}
		
	    this.listModelEstudianteIzquierda.removeAllElements();
	}
	
	/**
	 * 
	 */
	private void selecionadoDerecha() {
		this.listModelEstudianteDerecha.addElement(this.jLsAlumnoNoSelecionado.getSelectedValue());
		this.listModelEstudianteIzquierda.removeElement(this.jLsAlumnoNoSelecionado.getSelectedValue());
	}
	
	@SuppressWarnings("null")
	private void guardar() {
		Profesor p = (Profesor) jcbProfesor.getSelectedItem();
		Materia m = (Materia) jcbMateria.getSelectedItem();
		
		List<Estudiante> le = new ArrayList<Estudiante>();
		for (int i = 0; i < this.listModelEstudianteDerecha.size(); i++) {
			le.add(this.listModelEstudianteDerecha.getElementAt(i));
		}
		
		for (Estudiante e : le) {
			Valoracionmateria vm = ControladorValoracionMateriaJPA.findByProfesorAndMateriaAndEstudiante(p.getId(), m.getId(), e.getId());
		
			if(vm != null) {
				vm.setValoracion((Float) jcbNota.getSelectedItem());
				ControladorValoracionMateriaJPA.modificarValoracionMateria(vm);
			}
			else {
				vm = new Valoracionmateria();
				vm.setProfesor(p);
				vm.setEstudiante(e);
				vm.setMateria(m);
				vm.setValoracion((float) jcbNota.getSelectedItem());
				ControladorValoracionMateriaJPA.creacionValoracionMateria(vm);
			}
		}
	}
}
