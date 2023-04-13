package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;

import com.jmgl.centroEducativo.controller.ControladorEstudiante;
import com.jmgl.centroEducativo.controller.ControladorSexo;
import com.jmgl.centroEducativo.model.Estudiante;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class PanelEstudiante2 extends JPanel implements CambiaColorListenner{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelDatosPersonales datosPersonales;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton;
	Color c;
	JPanel panel;
	/**
	 * Create the panel.
	 */
	public PanelEstudiante2() {
		setBackground(new Color(192, 192, 192));
		setForeground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion Estudiante");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(20, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		datosPersonales = new PanelDatosPersonales(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(datosPersonales, gbc_textField);
		PanelDatosPersonales.addPersonas(this);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
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
				cargarEnPantalla(ControladorEstudiante.findPrevious(Integer.parseInt(datosPersonales.getJtfId())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorEstudiante.findNext(Integer.parseInt(datosPersonales.getJtfId())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorEstudiante.findLast());
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
		
		btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		panel.add(btnNewButton);
		
		cargarPrimero();
		
	}
	
	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorEstudiante.findFirst());
	}

	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (Estudiante e) {
		
		if (e != null) {
			datosPersonales.setJtfId("" + e.getId());
			datosPersonales.setJtfNombre(e.getNombre());
			datosPersonales.setJtfApellido1(e.getApellido1());
			datosPersonales.setJtfApellido2(e.getApellido2());
			datosPersonales.setJtfDni(e.getDni());
			datosPersonales.setJtfDireccion(e.getDireccion());
			datosPersonales.setJtfEmail(e.getEmail());
			datosPersonales.setJtfTelefono(e.getTelefono());
			datosPersonales.setJcbSexo(ControladorSexo.findAll(e.getIdSexo()));
			datosPersonales.setImagen(e.getImagen());
			if(e.getColor() != null) {
				datosPersonales.setJtfColor(e.getColor());
				datosPersonales.setColor(e.getColor(), false);
				c = Color.decode(e.getColor());
				datosPersonales.procesarColor(c, false);
			}
			else {
				c = Color.white;
				datosPersonales.setColor("#FFFFFF", false);
				datosPersonales.setJtfColor(e.getColor());
			}
			cambiarColor();
			
		}
	}
	
	/**
	 * 
	 */
	private void limpiarDatos() {
		datosPersonales.setJtfId("0");
		datosPersonales.setJtfNombre("");
		datosPersonales.setJtfApellido1("");
		datosPersonales.setJtfApellido2("");
		datosPersonales.setJtfDni("");
		datosPersonales.setJtfDireccion("");
		datosPersonales.setJtfEmail("");
		datosPersonales.setJtfTelefono("");
		datosPersonales.setImagen(null);
		datosPersonales.setColor("#FFFFFF", false);
		datosPersonales.setJtfColor("#FFFFFF");
	}
	
	/**
	 * 
	 */
	private void guardar() {
		Estudiante e = new Estudiante();
		e.setId(Integer.parseInt(datosPersonales.getJtfId()));
		e.setNombre(datosPersonales.getJtfNombre());
		e.setApellido1(datosPersonales.getJtfApellido1());
		e.setApellido2(datosPersonales.getJtfApellido2());
		e.setDni(datosPersonales.getJtfDni());
		e.setDireccion(datosPersonales.getJtfDireccion());
		e.setEmail(datosPersonales.getJtfEmail());
		e.setTelefono(datosPersonales.getJtfTelefono());
		e.setIdSexo(datosPersonales.getJcbSexo());
		e.setImagen(datosPersonales.getImagen());
		e.setColor(datosPersonales.getColor());

		
		String strError = "No se ha podido guardar";
		if (e.getId() == 0) {
			int nuevoIdInsertado = ControladorEstudiante.insertar(e);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				datosPersonales.setJtfId("" + nuevoIdInsertado);
			}
		}
		else {
			if (ControladorEstudiante.modificar(e) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
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
	    	int actualId = Integer.parseInt(datosPersonales.getJtfId());
		    if (ControladorEstudiante.eliminar(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	Estudiante mAnterior = ControladorEstudiante.findPrevious(actualId);
		    	if (mAnterior != null) {
		    		cargarEnPantalla(mAnterior);
		    	}
		    	else {
		    		Estudiante mSiguiente = ControladorEstudiante.findNext(actualId);
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
	public void cambiarColor() {
		panel.setBackground(c);
		this.setBackground(c);
	}

	@Override
	public void cambiarColor(CambiaColorEvent c) {
		if(! c.isEsProfesor())	{
			this.c = c.getColor();
			cambiarColor();	
		}
	}
}
