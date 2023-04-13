package com.jmgl.centroEducativo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jmgl.centroEducativo.controller.ControladorProfesor;
import com.jmgl.centroEducativo.controller.ControladorSexo;
import com.jmgl.centroEducativo.model.Profesor;

public class PanelProfesor2 extends JPanel implements CambiaColorListenner{
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
	JPanel panel;
	Color c;
	

	/**
	 * 
	 * 
	 */
	public  PanelProfesor2() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion Profesor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(20, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		datosPersonales = new PanelDatosPersonales(true);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(datosPersonales, gbc_textField);
		PanelDatosPersonales.addPersonas(this);
		
		panel = new JPanel();
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
				cargarEnPantalla(ControladorProfesor.findPrevious(Integer.parseInt(datosPersonales.getJtfId())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findNext(Integer.parseInt(datosPersonales.getJtfId())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findLast());
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
		cargarEnPantalla(ControladorProfesor.findFirst());
	}

	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (Profesor e) {
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
				datosPersonales.setColor(e.getColor(), true);
				datosPersonales.setJtfColor(e.getColor());
				c = Color.decode(e.getColor());
				datosPersonales.procesarColor(c, true);
			}
			else {
				c = Color.white;
				datosPersonales.setColor("#FFFFFF", true);
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
		datosPersonales.setColor("#FFFFFF", true);
		datosPersonales.setJtfColor("#FFFFFF");
	}
	
	/**
	 * 
	 */
	private void guardar() {
		Profesor e = new Profesor();
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
			int nuevoIdInsertado = ControladorProfesor.insertar(e);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				datosPersonales.setJtfId("" + nuevoIdInsertado);
			}
		}
		else {
			if (ControladorProfesor.modificar(e) != 1) {
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
		    if (ControladorProfesor.eliminar(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	Profesor mAnterior = ControladorProfesor.findPrevious(actualId);
		    	if (mAnterior != null) {
		    		cargarEnPantalla(mAnterior);
		    	}
		    	else {
		    		Profesor mSiguiente = ControladorProfesor.findNext(actualId);
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

	/**
	 * 
	 */
	@Override
	public void cambiarColor(CambiaColorEvent c) {
		if(c.isEsProfesor())	{
			this.c = c.getColor();
			cambiarColor();	
			
		}
	}
}
