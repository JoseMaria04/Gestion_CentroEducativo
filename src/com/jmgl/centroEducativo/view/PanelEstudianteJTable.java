package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;

import com.jmgl.centroEducativo.controller.ControladorEstudianteJTable;
import com.jmgl.centroEducativo.controller.ControladorSexoJPA;
import com.jmgl.centroEducativo.modelJPA.Estudiante;
import com.jmgl.centroEducativo.modelJPA.Tipologiasexo;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEstudianteJTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField jtfID;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfTelefono;
	private JTextField jtfEmail;
	JComboBox<Tipologiasexo> sexo;

	/**
	 * Create the panel.
	 */
	public PanelEstudianteJTable() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{1.0};
		gridBagLayout.columnWeights = new double[]{1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		add(splitPane, gbc_splitPane);
		
		table = new JTable(ControladorEstudianteJTable.datosTabla(), ControladorEstudianteJTable.cabeceraTabla());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarDatosInferior((int) ControladorEstudianteJTable.datosTabla()[table.getSelectedRow()][0]);
			}
		});
		splitPane.setLeftComponent(table);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0};
//		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
//		gbl_panel.columnWidths = new int[]{73, 0, 0, 0, 0, 0, 0, 0, 0};
//		gbl_panel.columnWidths = new int[]{0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido2");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 0;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_6.gridx = 6;
		gbc_lblNewLabel_6.gridy = 0;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Telefono");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_7.gridx = 7;
		gbc_lblNewLabel_7.gridy = 0;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_8.gridx = 8;
		gbc_lblNewLabel_8.gridy = 0;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfID = new JTextField();
		jtfID.setEnabled(false);
		GridBagConstraints gbc_jtfID = new GridBagConstraints();
		gbc_jtfID.weightx = 1.0;
		gbc_jtfID.insets = new Insets(10, 10, 10, 10);
		gbc_jtfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfID.gridx = 0;
		gbc_jtfID.gridy = 1;
		panel.add(jtfID, gbc_jtfID);
		jtfID.setColumns(10);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNopmbre = new GridBagConstraints();
		gbc_jtfNopmbre.weightx = 2.0;
		gbc_jtfNopmbre.insets = new Insets(10, 10, 10, 10);
		gbc_jtfNopmbre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNopmbre.gridx = 1;
		gbc_jtfNopmbre.gridy = 1;
		panel.add(jtfNombre, gbc_jtfNopmbre);
		jtfNombre.setColumns(10);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.weightx = 2.0;
		gbc_jtfApellido1.insets = new Insets(10, 10, 10, 10);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 2;
		gbc_jtfApellido1.gridy = 1;
		panel.add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.weightx = 2.0;
		gbc_jtfApellido2.insets = new Insets(10, 10, 10, 10);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 3;
		gbc_jtfApellido2.gridy = 1;
		panel.add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.weightx = 2.0;
		gbc_jtfDni.insets = new Insets(10, 10, 10, 10);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 4;
		gbc_jtfDni.gridy = 1;
		panel.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.weightx = 1.0;
		gbc_jtfDireccion.insets = new Insets(10, 10, 10, 10);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 5;
		gbc_jtfDireccion.gridy = 1;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.weightx = 2.0;
		gbc_jtfEmail.insets = new Insets(10, 10, 10, 10);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 6;
		gbc_jtfEmail.gridy = 1;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.weightx = 2.0;
		gbc_jtfTelefono.insets = new Insets(10, 10, 10, 10);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 7;
		gbc_jtfTelefono.gridy = 1;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		sexo = new JComboBox<Tipologiasexo>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.weightx = 2.0;
		gbc_comboBox.insets = new Insets(10, 10, 10, 10);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 8;
		gbc_comboBox.gridy = 1;
		panel.add(sexo, gbc_comboBox);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.gridwidth = 9;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel_1.add(guardar);

	}

	public void cargarDatosInferior(int id) {
		Estudiante e = ControladorEstudianteJTable.findbyId(id);
		jtfID.setText(e.getId() + "");
		jtfNombre.setText(e.getNombre());
		jtfApellido1.setText(e.getApellido1());
		jtfApellido2.setText(e.getApellido2());
		jtfDni.setText(e.getDni());
		jtfDireccion.setText(e.getDireccion());
		jtfEmail.setText(e.getEmail());
		jtfTelefono.setText(e.getTelefono());
		
		for (Tipologiasexo ts : ControladorSexoJPA.findbyId(e.getTipologiasexo().getId())) {
			sexo.addItem(ts);
		}
	}
	
	public void guardar() {
		Estudiante e = new Estudiante();
		e.setId(Integer.parseInt(jtfID.getText())); System.out.println(e.getId());
		e.setNombre(jtfNombre.getText());
		e.setApellido1(jtfApellido1.getText());
		e.setApellido2(jtfApellido2.getText());
		e.setDni(jtfDni.getText());
		e.setDireccion(jtfDireccion.getText());
		e.setEmail(jtfEmail.getText());
		e.setTipologiasexo((Tipologiasexo) sexo.getSelectedItem());
		
		ControladorEstudianteJTable.modificarEntidad(e);
	}
}
