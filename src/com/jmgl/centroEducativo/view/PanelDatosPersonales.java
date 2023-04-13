package com.jmgl.centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import com.jmgl.centroEducativo.model.Sexo;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class PanelDatosPersonales extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	JComboBox<Sexo> jcbSexo;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	byte[] imagenEnArrayDeBytes;
	private JTextField jtfColor;
	private JButton btnNewButton_1;
	JColorChooser jColorChooser;
	private  Color color;
	String strColor;
	
	private static List<CambiaColorListenner> listeners = new ArrayList<CambiaColorListenner>();

	/**
	 * 
	 * @param l
	 */
	public static void addPersonas(CambiaColorListenner l) {
		listeners.add(l);
	}
	

	/**
	 * 
	 * @param l
	 */
	public static void removePersonas(CambiaColorListenner l) {
		listeners.remove(l);
	}
	
	/**
	 * 
	 * @param color
	 */
	public void procesarColor(Color color, boolean esProfesor) {
		CambiaColorEvent c = new CambiaColorEvent();
		c.setColor(color);
		c.setEsProfesor(esProfesor);
		fireColor(c);
	}
	
	
	/**
	 * 
	 */
	private static void fireColor(CambiaColorEvent e) {
		for (CambiaColorListenner l : listeners) {
			l.cambiarColor(e);
		}
	}
	
	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales(Boolean esProfesor) {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowHeights = new int[]{182, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWidths = new int[]{127, 0};
//		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(100, 157));
		scrollPane.setMaximumSize(new Dimension(100, 157));
		scrollPane.setPreferredSize(new Dimension(100, 157));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(10, 10, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		btnNewButton = new JButton("Cargar Imagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(50, 20, 50, 10);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(10, 10, 10, 10);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(10, 10, 10, 10);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido1:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(10, 10, 10, 10);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido2:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(10, 10, 10, 10);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbSexo = new JComboBox<Sexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(10, 10, 10, 10);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 5;
		add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblNewLabel_5 = new JLabel("DNI: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(10, 10, 10, 10);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 6;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Direccion: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(10, 10, 10, 10);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email: ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(10, 10, 10, 10);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 8;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Telefono: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(10, 10, 10, 10);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 9;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		btnNewButton_1 = new JButton("Color");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor (esProfesor);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(10, 10, 10, 10);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 10;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		jtfColor = new JTextField();
		jtfColor.setEnabled(false);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(10, 10, 10, 10);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 10;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		
	}

	/**
	 * @return the jtfId
	 */
	public String getJtfId() {
		return jtfId.getText();
	}

	/**
	 * @param jtfId the jtfId to set
	 */
	public void setJtfId(String id) {
		this.jtfId.setText(id); 
	}

	/**
	 * @return the jtfNombre
	 */
	public String getJtfNombre() {
		return jtfNombre.getText();
	}

	/**
	 * @param jtfNombre the jtfNombre to set
	 */
	public void setJtfNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}

	/**
	 * @return the jtfApellido1
	 */
	public String getJtfApellido1() {
		return jtfApellido1.getText();
	}

	/**
	 * @param jtfApellido1 the jtfApellido1 to set
	 */
	public void setJtfApellido1(String Apellido) {
		this.jtfApellido1.setText(Apellido);
	}

	/**
	 * @return the jtfApellido2
	 */
	public String getJtfApellido2() {
		return jtfApellido2.getText();
	}

	/**
	 * @param jtfApellido2 the jtfApellido2 to set
	 */
	public void setJtfApellido2(String apellido2) {
		this.jtfApellido2.setText(apellido2);
	}

	/**
	 * @return the jtfDni
	 */
	public String getJtfDni() {
		return jtfDni.getText();
	}

	/**
	 * @param jtfDni the jtfDni to set
	 */
	public void setJtfDni(String jtfDni) {
		this.jtfDni.setText(jtfDni);
	}

	/**
	 * @return the jtfDireccion
	 */
	public String getJtfDireccion() {
		return jtfDireccion.getText();
	}

	/**
	 * @param jtfDireccion the jtfDireccion to set
	 */
	public void setJtfDireccion(String jtfDireccion) {
		this.jtfDireccion.setText(jtfDireccion);
	}

	/**
	 * @return the jtfEmail
	 */
	public String getJtfEmail() {
		return jtfEmail.getText();
	}

	/**
	 * @param jtfEmail the jtfEmail to set
	 */
	public void setJtfEmail(String jtfEmail) {
		this.jtfEmail.setText(jtfEmail);
	}

	/**
	 * @return the jtfTelefono
	 */
	public String getJtfTelefono() {
		return jtfTelefono.getText();
	}

	/**
	 * @param jtfTelefono the jtfTelefono to set
	 */
	public void setJtfTelefono(String jtfTelefono) {
		this.jtfTelefono.setText(jtfTelefono);
	}
	
	/**
	 * 
	 * @return
	 */
	public byte[] getImagen() {
		return imagenEnArrayDeBytes;
	}
	
	/**
	 * 
	 * @param imagen
	 */
	public void setImagen(byte[] imagen) {
		this.imagenEnArrayDeBytes = imagen;
		mostrarImagen();
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setJcbSexo(List<Sexo> s) {
		this.jcbSexo.removeAllItems();
		for (Sexo o : s) {
			this.jcbSexo.addItem(o);
		}

	}
	
	/**
	 * 
	 * @return
	 */
	public int getJcbSexo() {
		Sexo c =(Sexo) jcbSexo.getSelectedItem();
		return c.getId();
	}
	
	/**
	 * @return the jtfTelefono
	 */
	public String getJtfColor() {
		return jtfColor.getText();
	}

	/**
	 * @param jtfTelefono the jtfTelefono to set
	 */
	public void setJtfColor(String jtfColor) {
		this.jtfColor.setText(jtfColor);
	}
	
	/**
	 * 
	 */
	private void seleccionaImagen () {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().toLowerCase().endsWith(".jpg") || 
								f.getAbsolutePath().toLowerCase().endsWith(".jpeg")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".png")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					mostrarImagen();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private void mostrarImagen () {
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}

	}

	/**
	 * 
	 */
	private void seleccionaColor (boolean esProfesor) {
		color = JColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			cargarColor(esProfesor);

		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getColor() {
		return strColor;
	}
	
	public void setColor(String color, boolean esProfesor) {
		this.color = Color.decode(color);
		cargarColor(esProfesor);
	}
	
	private void cargarColor(boolean esProfesor) {
		this.setBackground(color);
		procesarColor(color, esProfesor);
	}
}
