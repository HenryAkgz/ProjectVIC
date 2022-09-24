package main;

import ShowDetails.ShowDetails;
import controlador.Conexion;
import framesControllers.FrameBienvenida;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Investigador;
import resources.utils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Division;
import modelo.Estudiante;

public class MainMenu extends javax.swing.JFrame {

    int x, y;
    JLabel optionSelected;
    boolean showListLinea = false, showListInstitucion = false, showListInvestigador = false;

    FrameBienvenida bienvenida;
    Conexion conn = new Conexion();
    String[] lista_linea, lista_institucion, lista_investigador;
    String ruta_foto = "";
    ArrayList<Division> listaDivision;

    ArrayList<Estudiante> listaEstudiantes;
    ArrayList<Investigador> listaInvestigadores;
    
    
    int consultaOpcion=1;
    String consultaData;
    
    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
        bienvenida = new FrameBienvenida(pn_bienvenida, lbl_textoPrincipal, lbl_texto_secundario, lbl_Slide);
        load_frame(pn_bienvenida);

        pn_container_list_institucion.setVisible(false);
        pn_container_list_linea.setVisible(false);

        lista_institucion = conn.getInstituciones();
        lt_institucion.setListData(lista_institucion);
        lista_linea = conn.getLineas();
        lt_linea.setListData(lista_linea);

        pn_message_error_estudiante.setVisible(false);
        pn_list_estu_investigador.setVisible(false);
        btn_reg_estudiante_ok.setVisible(false);
       
        pn_consultasbotones.setVisible(false);
       
    }

    private void hover_options(JLabel label, boolean active) {
        if (optionSelected != label) {
            label.setOpaque(active);
            label.setBackground(active ? utils.COLOR_HOVER : utils.COLOR_MENU_BACKGROUND);
        }
    }

    private void load_frame(JPanel panel) {
        if (bienvenida.changeContent.isRunning() && optionSelected != null ) {
            bienvenida.changeContent.stop();
            System.out.println("slide detenido");
        }
        panel.setSize(pn_formContainer.getSize());
        pn_formContainer.removeAll();
        pn_formContainer.add(panel);
        pn_formContainer.updateUI();
        btn_reg_inves_ok.setVisible(false);
    }

    private void selectOption(JLabel label) {

        if (optionSelected != null) {
            optionSelected.setBackground(utils.COLOR_MENU_BACKGROUND);
            optionSelected.setForeground(Color.white);
        }
        optionSelected = label;
        label.setForeground(utils.COLOR_MENU_BACKGROUND);
        label.setBackground(Color.white);
    }

    private void validarForm() {
        btn_reg_inves_ok.setVisible(!(txt_reg_inves_nombre.getText().trim().isEmpty() || txt_reg_inves_email.getText().trim().isEmpty() || txt_reg_inves_linea.getText().trim().isEmpty() || txt_reg_inves_institucion.getText().trim().isEmpty() || ruta_foto.isEmpty()));
    }

    private void validarFormEstudiante() {

        if ((float) spn_reg_estudiante_promedio.getValue() < utils.PROMEDIO_MINIMO) {
            pn_message_error_estudiante.setVisible(true);
            lbl_message_error_text.setText("Lo sentimos. tu promedio es mas bajo de lo permitido");
        } else if ((float) spn_reg_estudiante_avance.getValue() < utils.AVANCE_CURRICULAR_MINIMO) {
            pn_message_error_estudiante.setVisible(true);
            lbl_message_error_text.setText("Lo sentimos. Debes tener un minimo de 65% de avance curricular para participar en el programa.");
        } else {
            pn_message_error_estudiante.setVisible(false);
        }

        btn_reg_estudiante_ok.setVisible(!(txt_reg_estudiante_matricula.getText().trim().isEmpty() || txt_reg_estudiante_nombre.getText().trim().isEmpty() || txt_reg_estudiante_correo.getText().trim().isEmpty() || txt_reg_estu_investigador.getText().trim().isEmpty() || ruta_foto.isEmpty()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_bienvenida = new javax.swing.JPanel();
        lbl_textoPrincipal = new javax.swing.JLabel();
        lbl_Slide = new javax.swing.JLabel();
        lbl_texto_secundario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_reg_investigadores = new javax.swing.JPanel();
        lbl_foto_reg_investigador = new javax.swing.JLabel();
        btn_reg_inves_selec_foto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_reg_inves_nombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_reg_inves_email = new javax.swing.JTextField();
        cbx_reg_inves_genero = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbx_reg_inves_grado = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txt_reg_inves_institucion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_reg_inves_linea = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbx_reg_inves_estado = new javax.swing.JComboBox<>();
        btn_reg_inves_ok = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_show_list_institucion = new javax.swing.JLabel();
        btn_show_list_linea = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pn_container_list_institucion = new javax.swing.JPanel();
        js_container_list_institucion = new javax.swing.JScrollPane();
        lt_institucion = new javax.swing.JList<>();
        jPanel9 = new javax.swing.JPanel();
        pn_container_list_linea = new javax.swing.JPanel();
        js_container_list_linea = new javax.swing.JScrollPane();
        lt_linea = new javax.swing.JList<>();
        pn_reg_estudiantes = new javax.swing.JPanel();
        lbl_foto_reg_estudiante = new javax.swing.JLabel();
        btn_reg_estu_selec_foto = new javax.swing.JLabel();
        txt_reg_estudiante_matricula = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_reg_estudiante_nombre = new javax.swing.JTextField();
        cbx_reg_estudiante_genero = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_reg_estudiante_correo = new javax.swing.JTextField();
        spn_reg_estudiante_promedio = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        spn_reg_estudiante_avance = new javax.swing.JSpinner();
        cbx_reg_estudiante_division = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbx_reg_estudiante_licenciatura = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txt_reg_estu_investigador = new javax.swing.JTextField();
        btn_reg_estudiante_ok = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_show_list_investigador = new javax.swing.JLabel();
        pn_list_container_estudiante = new javax.swing.JPanel();
        pn_list_estu_investigador = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lt_investigador = new javax.swing.JList<>();
        pn_message_error_estudiante = new javax.swing.JPanel();
        lbl_message_error_information = new javax.swing.JLabel();
        lbl_message_error_text = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pn_consultas = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_consultas = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        pn_consultasbotones = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pn_about = new javax.swing.JPanel();
        pn_registro_form_ok = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_foto_ok = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        lbl_minimize = new javax.swing.JLabel();
        pn_move = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_reg_investigadores = new javax.swing.JLabel();
        lbl_about = new javax.swing.JLabel();
        lbl_reg_estudiantes = new javax.swing.JLabel();
        lbl_consultas = new javax.swing.JLabel();
        pn_formContainer = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        pn_bienvenida.setBackground(new java.awt.Color(255, 255, 255));
        pn_bienvenida.setMaximumSize(new java.awt.Dimension(981, 659));
        pn_bienvenida.setPreferredSize(new java.awt.Dimension(981, 659));

        lbl_textoPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_textoPrincipal.setForeground(utils.COLOR_MENU_BACKGROUND);
        lbl_textoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_textoPrincipal.setText("jLabel1");

        lbl_Slide.setText("jLabel3");

        lbl_texto_secundario.setBackground(utils.COLOR_HOVER);
        lbl_texto_secundario.setForeground(new java.awt.Color(102, 102, 102));
        lbl_texto_secundario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_texto_secundario.setText("jLabel1");
        lbl_texto_secundario.setToolTipText("");
        lbl_texto_secundario.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(utils.COLOR_BUTTON_CONOCER);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Conocer más");
        jLabel3.setBorder(new javax.swing.border.LineBorder(utils.COLOR_BUTTON_CONOCER, 2, true));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_bienvenidaLayout = new javax.swing.GroupLayout(pn_bienvenida);
        pn_bienvenida.setLayout(pn_bienvenidaLayout);
        pn_bienvenidaLayout.setHorizontalGroup(
            pn_bienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_bienvenidaLayout.createSequentialGroup()
                .addGroup(pn_bienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_bienvenidaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pn_bienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_texto_secundario, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_textoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(pn_bienvenidaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)))
                .addComponent(lbl_Slide, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        pn_bienvenidaLayout.setVerticalGroup(
            pn_bienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_bienvenidaLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(pn_bienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_bienvenidaLayout.createSequentialGroup()
                        .addComponent(lbl_textoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_texto_secundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(pn_bienvenidaLayout.createSequentialGroup()
                        .addComponent(lbl_Slide, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        pn_reg_investigadores.setBackground(new java.awt.Color(255, 255, 255));

        lbl_foto_reg_investigador.setBackground(new java.awt.Color(204, 204, 204));
        lbl_foto_reg_investigador.setOpaque(true);

        btn_reg_inves_selec_foto.setBackground(new java.awt.Color(255, 255, 255));
        btn_reg_inves_selec_foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_reg_inves_selec_foto.setText("Seleccionar foto");
        btn_reg_inves_selec_foto.setBorder(new javax.swing.border.LineBorder(utils.COLOR_HOVER, 2, true));
        btn_reg_inves_selec_foto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reg_inves_selec_foto.setOpaque(true);
        btn_reg_inves_selec_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reg_inves_selec_fotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reg_inves_selec_fotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reg_inves_selec_fotoMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Nombre completo:");

        txt_reg_inves_nombre.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_inves_nombreCaretUpdate(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Correo electronico:");

        txt_reg_inves_email.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_inves_emailCaretUpdate(evt);
            }
        });

        cbx_reg_inves_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otro" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Genero:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Grado:");

        cbx_reg_inves_grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LIC.", "MTRO.", "MTRA.", "DR.", "DRA." }));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Institucion:");

        txt_reg_inves_institucion.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_inves_institucionCaretUpdate(evt);
            }
        });
        txt_reg_inves_institucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_reg_inves_institucionKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText("Linea:");

        txt_reg_inves_linea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_inves_lineaCaretUpdate(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("Estado:");

        cbx_reg_inves_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Ciudad de México", "Coahuila", "Colima", "Durango", "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));

        btn_reg_inves_ok.setBackground(new java.awt.Color(255, 255, 255));
        btn_reg_inves_ok.setForeground(utils.COLOR_HOVER);
        btn_reg_inves_ok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_reg_inves_ok.setText("Registrarse");
        btn_reg_inves_ok.setBorder(new javax.swing.border.LineBorder(utils.COLOR_HOVER, 2, true));
        btn_reg_inves_ok.setOpaque(true);
        btn_reg_inves_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reg_inves_okMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reg_inves_okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reg_inves_okMouseExited(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(utils.COLOR_DARK_RED);
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cancelar");
        jLabel17.setBorder(new javax.swing.border.LineBorder(utils.COLOR_DARK_RED, 2, true));
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });

        btn_show_list_institucion.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30)
        );
        btn_show_list_institucion.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_show_list_institucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_show_list_institucionMouseClicked(evt);
            }
        });

        btn_show_list_linea.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30)
        );
        btn_show_list_linea.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_show_list_linea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_show_list_lineaMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(283, 174));
        jPanel5.setMinimumSize(new java.awt.Dimension(283, 174));

        pn_container_list_institucion.setBackground(new java.awt.Color(255, 255, 255));

        js_container_list_institucion.setBackground(new java.awt.Color(255, 255, 255));
        js_container_list_institucion.setBorder(null);
        js_container_list_institucion.setAutoscrolls(true);

        lt_institucion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lt_institucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_institucionMouseClicked(evt);
            }
        });
        js_container_list_institucion.setViewportView(lt_institucion);

        javax.swing.GroupLayout pn_container_list_institucionLayout = new javax.swing.GroupLayout(pn_container_list_institucion);
        pn_container_list_institucion.setLayout(pn_container_list_institucionLayout);
        pn_container_list_institucionLayout.setHorizontalGroup(
            pn_container_list_institucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(js_container_list_institucion, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        pn_container_list_institucionLayout.setVerticalGroup(
            pn_container_list_institucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_container_list_institucionLayout.createSequentialGroup()
                .addComponent(js_container_list_institucion, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_container_list_institucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_container_list_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMaximumSize(new java.awt.Dimension(283, 174));
        jPanel9.setMinimumSize(new java.awt.Dimension(283, 174));

        pn_container_list_linea.setBackground(new java.awt.Color(255, 255, 255));

        js_container_list_linea.setBackground(new java.awt.Color(255, 255, 255));
        js_container_list_linea.setBorder(null);
        js_container_list_linea.setAutoscrolls(true);

        lt_linea.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lt_linea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_lineaMouseClicked(evt);
            }
        });
        js_container_list_linea.setViewportView(lt_linea);

        javax.swing.GroupLayout pn_container_list_lineaLayout = new javax.swing.GroupLayout(pn_container_list_linea);
        pn_container_list_linea.setLayout(pn_container_list_lineaLayout);
        pn_container_list_lineaLayout.setHorizontalGroup(
            pn_container_list_lineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(js_container_list_linea, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        pn_container_list_lineaLayout.setVerticalGroup(
            pn_container_list_lineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_container_list_lineaLayout.createSequentialGroup()
                .addComponent(js_container_list_linea, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_container_list_linea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_container_list_linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_reg_investigadoresLayout = new javax.swing.GroupLayout(pn_reg_investigadores);
        pn_reg_investigadores.setLayout(pn_reg_investigadoresLayout);
        pn_reg_investigadoresLayout.setHorizontalGroup(
            pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                            .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(txt_reg_inves_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_reg_inves_email, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addGap(18, 18, 18)
                                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(cbx_reg_inves_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(cbx_reg_inves_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(cbx_reg_inves_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                                            .addComponent(txt_reg_inves_linea, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(btn_show_list_linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_foto_reg_investigador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reg_inves_selec_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                            .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                                    .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_reg_inves_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_show_list_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_reg_inves_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel14))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pn_reg_investigadoresLayout.setVerticalGroup(
            pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl_foto_reg_investigador, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reg_inves_selec_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_reg_inves_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_show_list_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(btn_reg_inves_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                        .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_reg_inves_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_reg_inves_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_reg_inves_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(pn_reg_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_reg_inves_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_reg_inves_linea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_reg_investigadoresLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_reg_inves_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_show_list_linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_reg_estudiantes.setBackground(new java.awt.Color(255, 255, 255));
        pn_reg_estudiantes.setPreferredSize(new java.awt.Dimension(981, 659));

        lbl_foto_reg_estudiante.setBackground(new java.awt.Color(204, 204, 204));
        lbl_foto_reg_estudiante.setOpaque(true);

        btn_reg_estu_selec_foto.setBackground(new java.awt.Color(255, 255, 255));
        btn_reg_estu_selec_foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_reg_estu_selec_foto.setText("Seleccionar foto");
        btn_reg_estu_selec_foto.setBorder(new javax.swing.border.LineBorder(utils.COLOR_HOVER, 2, true));
        btn_reg_estu_selec_foto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reg_estu_selec_foto.setOpaque(true);
        btn_reg_estu_selec_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reg_estu_selec_fotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reg_estu_selec_fotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reg_estu_selec_fotoMouseExited(evt);
            }
        });

        txt_reg_estudiante_matricula.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_estudiante_matriculaCaretUpdate(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("Matricula");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setText("Nombre completo");

        txt_reg_estudiante_nombre.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_estudiante_nombreCaretUpdate(evt);
            }
        });

        cbx_reg_estudiante_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otro" }));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 153));
        jLabel20.setText("Genero:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 153));
        jLabel21.setText("Correo electronico");

        txt_reg_estudiante_correo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_estudiante_correoCaretUpdate(evt);
            }
        });

        spn_reg_estudiante_promedio.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(8.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(0.1f)));
        spn_reg_estudiante_promedio.setPreferredSize(new java.awt.Dimension(64, 30));
        spn_reg_estudiante_promedio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spn_reg_estudiante_promedioStateChanged(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 153));
        jLabel22.setText("Promedio");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 153));
        jLabel23.setText("Av.Curricular");

        spn_reg_estudiante_avance.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(65.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        spn_reg_estudiante_avance.setPreferredSize(new java.awt.Dimension(64, 30));
        spn_reg_estudiante_avance.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spn_reg_estudiante_avanceStateChanged(evt);
            }
        });

        cbx_reg_estudiante_division.setToolTipText("");
        cbx_reg_estudiante_division.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_reg_estudiante_divisionActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 153));
        jLabel24.setText("Division");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 153));
        jLabel25.setText("Licenciatura");

        cbx_reg_estudiante_licenciatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_reg_estudiante_licenciaturaActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 153));
        jLabel26.setText("Investigador");

        txt_reg_estu_investigador.setPreferredSize(new java.awt.Dimension(281, 22));
        txt_reg_estu_investigador.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reg_estu_investigadorCaretUpdate(evt);
            }
        });

        btn_reg_estudiante_ok.setBackground(new java.awt.Color(255, 255, 255));
        btn_reg_estudiante_ok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_reg_estudiante_ok.setForeground(utils.COLOR_MENU_BACKGROUND);
        btn_reg_estudiante_ok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_reg_estudiante_ok.setText("Registrarse");
        btn_reg_estudiante_ok.setBorder(new javax.swing.border.LineBorder(utils.COLOR_MENU_BACKGROUND, 2, true));
        btn_reg_estudiante_ok.setOpaque(true);
        btn_reg_estudiante_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reg_estudiante_okMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reg_estudiante_okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reg_estudiante_okMouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(utils.COLOR_DARK_RED);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cancelar");
        jLabel7.setBorder(new javax.swing.border.LineBorder(utils.COLOR_DARK_RED, 2, true));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        btn_show_list_investigador.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30)
        );
        btn_show_list_investigador.setPreferredSize(new java.awt.Dimension(30, 30));
        btn_show_list_investigador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_show_list_investigadorMouseClicked(evt);
            }
        });

        pn_list_container_estudiante.setBackground(new java.awt.Color(255, 255, 255));
        pn_list_container_estudiante.setOpaque(false);

        pn_list_estu_investigador.setOpaque(false);

        lt_investigador.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lt_investigador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_investigadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lt_investigador);

        javax.swing.GroupLayout pn_list_estu_investigadorLayout = new javax.swing.GroupLayout(pn_list_estu_investigador);
        pn_list_estu_investigador.setLayout(pn_list_estu_investigadorLayout);
        pn_list_estu_investigadorLayout.setHorizontalGroup(
            pn_list_estu_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_list_estu_investigadorLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_list_estu_investigadorLayout.setVerticalGroup(
            pn_list_estu_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_list_estu_investigadorLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_list_container_estudianteLayout = new javax.swing.GroupLayout(pn_list_container_estudiante);
        pn_list_container_estudiante.setLayout(pn_list_container_estudianteLayout);
        pn_list_container_estudianteLayout.setHorizontalGroup(
            pn_list_container_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_list_container_estudianteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_list_estu_investigador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_list_container_estudianteLayout.setVerticalGroup(
            pn_list_container_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_list_container_estudianteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_list_estu_investigador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_message_error_estudiante.setBackground(utils.COLOR_DARK_RED);

        lbl_message_error_information.setBackground(new java.awt.Color(255, 255, 255));
        lbl_message_error_information.setForeground(new java.awt.Color(255, 255, 255));
        lbl_message_error_information.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_message_error_information.setText("Para mas informacion consulta");

        lbl_message_error_text.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_message_error_text.setForeground(new java.awt.Color(255, 255, 255));
        lbl_message_error_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_message_error_text.setText("jLabel8");

        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("lineamientos del programa.");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_message_error_estudianteLayout = new javax.swing.GroupLayout(pn_message_error_estudiante);
        pn_message_error_estudiante.setLayout(pn_message_error_estudianteLayout);
        pn_message_error_estudianteLayout.setHorizontalGroup(
            pn_message_error_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_message_error_estudianteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pn_message_error_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_message_error_text, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_message_error_estudianteLayout.createSequentialGroup()
                        .addComponent(lbl_message_error_information, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pn_message_error_estudianteLayout.setVerticalGroup(
            pn_message_error_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_message_error_estudianteLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lbl_message_error_text, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_message_error_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_message_error_information)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_reg_estudiantesLayout = new javax.swing.GroupLayout(pn_reg_estudiantes);
        pn_reg_estudiantes.setLayout(pn_reg_estudiantesLayout);
        pn_reg_estudiantesLayout.setHorizontalGroup(
            pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_reg_estudiantesLayout.createSequentialGroup()
                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reg_estudiante_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(txt_reg_estudiante_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(txt_reg_estudiante_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(txt_reg_estudiante_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbx_reg_estudiante_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20))
                                        .addGap(18, 18, 18)
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(spn_reg_estudiante_promedio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(spn_reg_estudiante_avance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(cbx_reg_estudiante_division, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_foto_reg_estudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_reg_estu_selec_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19))
                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(cbx_reg_estudiante_licenciatura, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(pn_list_container_estudiante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_reg_estu_investigador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_show_list_investigador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(pn_message_error_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pn_reg_estudiantesLayout.setVerticalGroup(
            pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_foto_reg_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_reg_estu_selec_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_reg_estudiante_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_reg_estudiante_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_reg_estudiante_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbx_reg_estudiante_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_reg_estudiante_promedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spn_reg_estudiante_avance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx_reg_estudiante_division, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26)
                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_reg_estudiante_licenciatura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_reg_estudiantesLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_reg_estu_investigador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_show_list_investigador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_list_container_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(pn_message_error_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_reg_estudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reg_estudiante_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn_consultas.setBackground(new java.awt.Color(255, 255, 255));
        pn_consultas.setPreferredSize(new java.awt.Dimension(981, 659));

        jPanel7.setBackground(utils.COLOR_VERDE_AGUA);
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Investigadores");

        jLabel9.setIcon(utils.getImageWithScale(utils.INVESTIGADOR_ICON, 64, 64)
        );

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("12 Registados");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel8.setBackground(utils.COLOR_MORADO_DARK);
        jPanel8.setPreferredSize(new java.awt.Dimension(309, 141));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Estudiantes");

        jLabel29.setIcon(utils.getImageWithScale(utils.ESTUDIANTE_ICON, 64, 64)
        );

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("12 Registados");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tbl_consultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_consultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_consultasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_consultas);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel31.setText("Buscar:");

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        pn_consultasbotones.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setIcon(utils.getImageWithScale(utils.DELETE_ICON, 25, 25)
        );
        jLabel32.setText("Eliminar");
        jLabel32.setMaximumSize(new java.awt.Dimension(43, 30));
        jLabel32.setMinimumSize(new java.awt.Dimension(43, 30));
        jLabel32.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel33.setIcon(utils.getImageWithScale(utils.UPDATE_ICON, 25, 25)
        );
        jLabel33.setText("Actualizar");
        jLabel33.setMaximumSize(new java.awt.Dimension(43, 30));
        jLabel33.setMinimumSize(new java.awt.Dimension(43, 30));
        jLabel33.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel34.setIcon(utils.getImageWithScale(utils.DETAILS_ICON, 25, 25)
        );
        jLabel34.setText("Ver detalles");
        jLabel34.setMaximumSize(new java.awt.Dimension(43, 30));
        jLabel34.setMinimumSize(new java.awt.Dimension(43, 30));
        jLabel34.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_consultasbotonesLayout = new javax.swing.GroupLayout(pn_consultasbotones);
        pn_consultasbotones.setLayout(pn_consultasbotonesLayout);
        pn_consultasbotonesLayout.setHorizontalGroup(
            pn_consultasbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_consultasbotonesLayout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
        pn_consultasbotonesLayout.setVerticalGroup(
            pn_consultasbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_consultasbotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_consultasbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pn_consultasLayout = new javax.swing.GroupLayout(pn_consultas);
        pn_consultas.setLayout(pn_consultasLayout);
        pn_consultasLayout.setHorizontalGroup(
            pn_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_consultasLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pn_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_consultasLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_consultasLayout.createSequentialGroup()
                        .addGroup(pn_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_consultasLayout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(pn_consultasbotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))))
        );
        pn_consultasLayout.setVerticalGroup(
            pn_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_consultasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pn_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pn_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_consultasbotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pn_about.setBackground(new java.awt.Color(204, 102, 0));
        pn_about.setPreferredSize(new java.awt.Dimension(981, 659));

        javax.swing.GroupLayout pn_aboutLayout = new javax.swing.GroupLayout(pn_about);
        pn_about.setLayout(pn_aboutLayout);
        pn_aboutLayout.setHorizontalGroup(
            pn_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
        );
        pn_aboutLayout.setVerticalGroup(
            pn_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );

        pn_registro_form_ok.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registro exitoso!");

        lbl_foto_ok.setPreferredSize(new java.awt.Dimension(152, 152));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(utils.COLOR_MENU_BACKGROUND);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ir al inicio");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(utils.COLOR_MENU_BACKGROUND, 2));
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_registro_form_okLayout = new javax.swing.GroupLayout(pn_registro_form_ok);
        pn_registro_form_ok.setLayout(pn_registro_form_okLayout);
        pn_registro_form_okLayout.setHorizontalGroup(
            pn_registro_form_okLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_registro_form_okLayout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(pn_registro_form_okLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_registro_form_okLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_registro_form_okLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_registro_form_okLayout.createSequentialGroup()
                        .addComponent(lbl_foto_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(396, 396, 396))))
        );
        pn_registro_form_okLayout.setVerticalGroup(
            pn_registro_form_okLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_registro_form_okLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_foto_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(utils.COLOR_MENU_BACKGROUND);
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(110, 30));

        lbl_close.setIcon(new ImageIcon(utils.close_white_Icon));
        lbl_close.setToolTipText("");
        lbl_close.setPreferredSize(new java.awt.Dimension(29, 29));
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_closeMouseExited(evt);
            }
        });

        lbl_minimize.setIcon(new ImageIcon(utils.minimize_white_Icon));
        lbl_minimize.setToolTipText("");
        lbl_minimize.setPreferredSize(new java.awt.Dimension(29, 29));
        lbl_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_minimizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lbl_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_minimize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn_move.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        pn_move.setOpaque(false);
        pn_move.setPreferredSize(new java.awt.Dimension(100, 30));
        pn_move.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pn_moveMouseDragged(evt);
            }
        });
        pn_move.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_moveMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pn_moveLayout = new javax.swing.GroupLayout(pn_move);
        pn_move.setLayout(pn_moveLayout);
        pn_moveLayout.setHorizontalGroup(
            pn_moveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 887, Short.MAX_VALUE)
        );
        pn_moveLayout.setVerticalGroup(
            pn_moveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel3.setBackground(utils.COLOR_MENU_BACKGROUND);

        lbl_reg_investigadores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_reg_investigadores.setForeground(new java.awt.Color(255, 255, 255));
        lbl_reg_investigadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_reg_investigadores.setText("Registro de investigadores");
        lbl_reg_investigadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_reg_investigadoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_reg_investigadoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_reg_investigadoresMouseExited(evt);
            }
        });

        lbl_about.setBackground(utils.COLOR_MENU_BACKGROUND);
        lbl_about.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_about.setForeground(new java.awt.Color(255, 255, 255));
        lbl_about.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_about.setText("Acerca de");
        lbl_about.setOpaque(true);
        lbl_about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_aboutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_aboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_aboutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_aboutMousePressed(evt);
            }
        });

        lbl_reg_estudiantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_reg_estudiantes.setForeground(new java.awt.Color(255, 255, 255));
        lbl_reg_estudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_reg_estudiantes.setText("Registro de estudiantes");
        lbl_reg_estudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_reg_estudiantesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_reg_estudiantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_reg_estudiantesMouseExited(evt);
            }
        });

        lbl_consultas.setBackground(new java.awt.Color(153, 0, 153));
        lbl_consultas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_consultas.setForeground(new java.awt.Color(255, 255, 255));
        lbl_consultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_consultas.setText("Consultar datos");
        lbl_consultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_consultasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_consultasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_consultasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_about, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(lbl_reg_investigadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_reg_estudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_consultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(lbl_reg_investigadores, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lbl_reg_estudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lbl_consultas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(lbl_about, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_formContainerLayout = new javax.swing.GroupLayout(pn_formContainer);
        pn_formContainer.setLayout(pn_formContainerLayout);
        pn_formContainerLayout.setHorizontalGroup(
            pn_formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
        );
        pn_formContainerLayout.setVerticalGroup(
            pn_formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jPanel4.setBackground(utils.COLOR_MENU_BACKGROUND);

        jLabel1.setIcon(utils.getImageWithScale(utils.ujat_logo_white_Icon, 286, 79));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Verano de la Investigación Científica UJAT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_move, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pn_formContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_move, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_formContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseEntered
        lbl_close.setIcon(new ImageIcon(utils.close_red_Icon));
    }//GEN-LAST:event_lbl_closeMouseEntered

    private void lbl_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseExited
        lbl_close.setIcon(new ImageIcon(utils.close_white_Icon));
    }//GEN-LAST:event_lbl_closeMouseExited

    private void lbl_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseEntered
        lbl_minimize.setIcon(new ImageIcon(utils.minimize_color_Icon));
    }//GEN-LAST:event_lbl_minimizeMouseEntered

    private void lbl_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseExited
        lbl_minimize.setIcon(new ImageIcon(utils.minimize_white_Icon));
    }//GEN-LAST:event_lbl_minimizeMouseExited

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_lbl_minimizeMouseClicked

    private void pn_moveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_moveMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_pn_moveMousePressed

    private void pn_moveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_moveMouseDragged
        setLocation(getLocation().x + evt.getX() - x, getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_pn_moveMouseDragged

    private void lbl_reg_investigadoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_reg_investigadoresMouseEntered
        hover_options(lbl_reg_investigadores, true);
    }//GEN-LAST:event_lbl_reg_investigadoresMouseEntered

    private void lbl_reg_estudiantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_reg_estudiantesMouseEntered
        hover_options(lbl_reg_estudiantes, true);        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_reg_estudiantesMouseEntered

    private void lbl_consultasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_consultasMouseEntered
        hover_options(lbl_consultas, true);
    }//GEN-LAST:event_lbl_consultasMouseEntered

    private void lbl_reg_investigadoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_reg_investigadoresMouseExited
        hover_options(lbl_reg_investigadores, false);
    }//GEN-LAST:event_lbl_reg_investigadoresMouseExited

    private void lbl_reg_estudiantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_reg_estudiantesMouseExited
        hover_options(lbl_reg_estudiantes, false);
    }//GEN-LAST:event_lbl_reg_estudiantesMouseExited

    private void lbl_consultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_consultasMouseExited
        hover_options(lbl_consultas, false);
    }//GEN-LAST:event_lbl_consultasMouseExited

    private void lbl_aboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_aboutMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_aboutMousePressed

    private void lbl_aboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_aboutMouseEntered
        if (optionSelected != lbl_about) {
            lbl_about.setBackground(utils.COLOR_HOVER_ABOUT);
        }
    }//GEN-LAST:event_lbl_aboutMouseEntered

    private void lbl_aboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_aboutMouseExited
        if (optionSelected != lbl_about) {
            lbl_about.setBackground(utils.COLOR_MENU_BACKGROUND);
        }
    }//GEN-LAST:event_lbl_aboutMouseExited

    private void lbl_reg_investigadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_reg_investigadoresMouseClicked
        load_frame(pn_reg_investigadores);
        selectOption(lbl_reg_investigadores);
        ruta_foto = "";
    }//GEN-LAST:event_lbl_reg_investigadoresMouseClicked

    private void lbl_reg_estudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_reg_estudiantesMouseClicked
        load_frame(pn_reg_estudiantes);
        selectOption(lbl_reg_estudiantes);
        ruta_foto = "";
        listaDivision = conn.getDivisiones();

        List<String> listaStringDivision = new ArrayList<>();

        listaDivision.forEach(item -> {
            listaStringDivision.add(item.getAcronimo() + " " + item.getNombre());
        });

        DefaultComboBoxModel modeloDivision = new DefaultComboBoxModel(listaStringDivision.toArray());
        cbx_reg_estudiante_division.setModel(modeloDivision);

        lista_investigador = conn.getInvestigadores();
        lt_investigador.setListData(lista_investigador);

        List<String> listaLicenciaturas = conn.getCarrerasByDivisiones(listaDivision.get(cbx_reg_estudiante_division.getSelectedIndex()).getAcronimo());
        DefaultComboBoxModel modelLicenciatura = new DefaultComboBoxModel(listaLicenciaturas.toArray());
        cbx_reg_estudiante_licenciatura.setModel(modelLicenciatura);

    }//GEN-LAST:event_lbl_reg_estudiantesMouseClicked

    private void lbl_consultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_consultasMouseClicked
        load_frame(pn_consultas);
        selectOption(lbl_consultas);

        listaEstudiantes = conn.getArrayEstudiantes();
        listaInvestigadores = conn.getArrayInvestigadores();

        jLabel27.setText(listaInvestigadores.size() + " Registrados");
        jLabel30.setText(listaEstudiantes.size() + " Registrados");

    }//GEN-LAST:event_lbl_consultasMouseClicked

    private void lbl_aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_aboutMouseClicked
        load_frame(pn_about);
        selectOption(lbl_about);
    }//GEN-LAST:event_lbl_aboutMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setBackground(utils.COLOR_BUTTON_CONOCER);
        jLabel3.setForeground(Color.white);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setBackground(Color.white);
        jLabel3.setForeground(utils.COLOR_BUTTON_CONOCER);
    }//GEN-LAST:event_jLabel3MouseExited

    private void btn_reg_inves_selec_fotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_inves_selec_fotoMouseEntered
        btn_reg_inves_selec_foto.setBackground(utils.COLOR_HOVER);
        btn_reg_inves_selec_foto.setForeground(Color.white);
    }//GEN-LAST:event_btn_reg_inves_selec_fotoMouseEntered

    private void btn_reg_inves_selec_fotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_inves_selec_fotoMouseExited
        btn_reg_inves_selec_foto.setBackground(Color.white);
        btn_reg_inves_selec_foto.setForeground(utils.COLOR_HOVER);
    }//GEN-LAST:event_btn_reg_inves_selec_fotoMouseExited

    private void btn_reg_inves_selec_fotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_inves_selec_fotoMouseClicked
        ruta_foto = utils.getImageFromFile();
        if (!ruta_foto.isEmpty()) {
            lbl_foto_reg_investigador.setIcon(utils.getImageWithScale(ruta_foto, 132, 132));
        } else {
            JOptionPane.showMessageDialog(this, "Usted debe seleccionar una foto de perfil para continuar con el registro", "Seleccione una foto de perfil", JOptionPane.ERROR_MESSAGE);
        }

        validarForm();
    }//GEN-LAST:event_btn_reg_inves_selec_fotoMouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setBackground(utils.COLOR_DARK_RED);
        jLabel17.setForeground(Color.white);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setBackground(Color.white);
        jLabel17.setForeground(utils.COLOR_DARK_RED);
    }//GEN-LAST:event_jLabel17MouseExited

    private void btn_reg_inves_okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_inves_okMouseEntered
        btn_reg_inves_ok.setForeground(Color.white);
        btn_reg_inves_ok.setBackground(utils.COLOR_HOVER);
    }//GEN-LAST:event_btn_reg_inves_okMouseEntered

    private void btn_reg_inves_okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_inves_okMouseExited
        btn_reg_inves_ok.setForeground(utils.COLOR_HOVER);
        btn_reg_inves_ok.setBackground(Color.white);
    }//GEN-LAST:event_btn_reg_inves_okMouseExited

    private void txt_reg_inves_institucionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_reg_inves_institucionKeyTyped

    }//GEN-LAST:event_txt_reg_inves_institucionKeyTyped

    private void btn_show_list_institucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_show_list_institucionMouseClicked

        if (showListInstitucion) {
            btn_show_list_institucion.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
            showListInstitucion = false;
        } else {
            btn_show_list_institucion.setIcon(utils.getImageWithScale(utils.ARROW_UP, 30, 30));
            showListInstitucion = true;
        }

        pn_container_list_institucion.setVisible(showListInstitucion);


    }//GEN-LAST:event_btn_show_list_institucionMouseClicked

    private void txt_reg_inves_institucionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_inves_institucionCaretUpdate
        if (txt_reg_inves_institucion.getText().isEmpty()) {
            btn_show_list_institucion.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
            showListInstitucion = false;
        } else {
            lt_institucion.setListData(utils.getListWithFilter(lista_institucion, txt_reg_inves_institucion.getText().toUpperCase()));
            btn_show_list_institucion.setIcon(utils.getImageWithScale(utils.ARROW_UP, 30, 30));
            showListInstitucion = true;
        }

        pn_container_list_institucion.setVisible(showListInstitucion);
        validarForm();
    }//GEN-LAST:event_txt_reg_inves_institucionCaretUpdate

    private void btn_show_list_lineaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_show_list_lineaMouseClicked
        if (showListLinea) {
            btn_show_list_linea.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
            showListLinea = false;
        } else {
            btn_show_list_linea.setIcon(utils.getImageWithScale(utils.ARROW_UP, 30, 30));
            showListLinea = true;
        }

        pn_container_list_linea.setVisible(showListLinea);

    }//GEN-LAST:event_btn_show_list_lineaMouseClicked

    private void txt_reg_inves_lineaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_inves_lineaCaretUpdate
        if (txt_reg_inves_linea.getText().isEmpty()) {
            btn_show_list_linea.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
            showListLinea = false;
        } else {
            lt_linea.setListData(utils.getListWithFilter(lista_linea, txt_reg_inves_linea.getText().toUpperCase()));
            btn_show_list_linea.setIcon(utils.getImageWithScale(utils.ARROW_UP, 30, 30));
            showListLinea = true;
        }

        pn_container_list_linea.setVisible(showListLinea);
        validarForm();
    }//GEN-LAST:event_txt_reg_inves_lineaCaretUpdate

    private void btn_reg_inves_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_inves_okMouseClicked
        try {
            System.out.println("Clic en registro");
            Investigador inves = new Investigador();
            inves.setNombre(txt_reg_inves_nombre.getText());
            inves.setCorreo(txt_reg_inves_email.getText());
            inves.setEstado(cbx_reg_inves_estado.getSelectedItem().toString());
            inves.setLinea(txt_reg_inves_linea.getText());
            inves.setInstitucion(txt_reg_inves_institucion.getText());
            inves.setGrado(cbx_reg_inves_grado.getSelectedItem().toString());

            inves.setFoto(utils.readFile(ruta_foto));

            switch (cbx_reg_inves_genero.getSelectedIndex()) {
                case 0:
                    inves.setGenero(utils.MASCULINO);
                    break;

                case 1:
                    inves.setGenero(utils.FEMENINO);
                    break;

                case 2:
                    inves.setGenero(utils.OTRO);
                    break;

                default:
                    inves.setGenero(utils.OTRO);
                    break;
            }

            if (conn.registrarInvestigador(inves)) {
                load_frame(pn_registro_form_ok);
                lbl_foto_ok.setIcon(utils.getImageWithScaleFromBytes(inves.getFoto(), lbl_foto_reg_investigador.getWidth(), lbl_foto_reg_investigador.getHeight()));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_reg_inves_okMouseClicked

    private void lt_institucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_institucionMouseClicked
        txt_reg_inves_institucion.setText(lt_institucion.getSelectedValue());
        pn_container_list_institucion.setVisible(false);
        btn_show_list_institucion.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
        showListInstitucion = false;
    }//GEN-LAST:event_lt_institucionMouseClicked

    private void lt_lineaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_lineaMouseClicked
        txt_reg_inves_linea.setText(lt_linea.getSelectedValue());
        pn_container_list_linea.setVisible(false);
        btn_show_list_linea.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
        showListLinea = false;
    }//GEN-LAST:event_lt_lineaMouseClicked

    private void txt_reg_inves_nombreCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_inves_nombreCaretUpdate
        validarForm();
    }//GEN-LAST:event_txt_reg_inves_nombreCaretUpdate

    private void txt_reg_inves_emailCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_inves_emailCaretUpdate
        validarForm();
    }//GEN-LAST:event_txt_reg_inves_emailCaretUpdate

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        load_frame(pn_bienvenida);
        bienvenida.changeContent.start();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        utils.hover(jLabel5, Color.WHITE, utils.COLOR_MENU_BACKGROUND, false);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered

        utils.hover(jLabel5, Color.WHITE, utils.COLOR_MENU_BACKGROUND, true);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void btn_reg_estu_selec_fotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_estu_selec_fotoMouseClicked
        ruta_foto = utils.getImageFromFile();
        lbl_foto_reg_estudiante.setIcon(utils.getImageWithScale(ruta_foto, lbl_foto_reg_estudiante.getWidth(), lbl_foto_reg_estudiante.getHeight()));
        validarFormEstudiante();
    }//GEN-LAST:event_btn_reg_estu_selec_fotoMouseClicked

    private void btn_reg_estu_selec_fotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_estu_selec_fotoMouseEntered
        utils.hover(btn_reg_estu_selec_foto, Color.WHITE, utils.COLOR_MENU_BACKGROUND, true);
    }//GEN-LAST:event_btn_reg_estu_selec_fotoMouseEntered

    private void btn_reg_estu_selec_fotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_estu_selec_fotoMouseExited
        utils.hover(btn_reg_estu_selec_foto, Color.WHITE, utils.COLOR_MENU_BACKGROUND, false);
    }//GEN-LAST:event_btn_reg_estu_selec_fotoMouseExited

    private void txt_reg_estudiante_matriculaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_estudiante_matriculaCaretUpdate
        validarFormEstudiante();
    }//GEN-LAST:event_txt_reg_estudiante_matriculaCaretUpdate

    private void txt_reg_estudiante_nombreCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_estudiante_nombreCaretUpdate
        validarFormEstudiante();
    }//GEN-LAST:event_txt_reg_estudiante_nombreCaretUpdate

    private void txt_reg_estudiante_correoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_estudiante_correoCaretUpdate
        validarFormEstudiante();
    }//GEN-LAST:event_txt_reg_estudiante_correoCaretUpdate

    private void cbx_reg_estudiante_licenciaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_reg_estudiante_licenciaturaActionPerformed
        validarFormEstudiante();
    }//GEN-LAST:event_cbx_reg_estudiante_licenciaturaActionPerformed

    private void txt_reg_estu_investigadorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reg_estu_investigadorCaretUpdate
        if (txt_reg_estu_investigador.getText().isEmpty()) {
            showListInvestigador = false;
            btn_show_list_investigador.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
            lt_investigador.setListData(lista_investigador);
        } else {

            showListInvestigador = true;
            btn_show_list_investigador.setIcon(utils.getImageWithScale(utils.ARROW_UP, 30, 30));
            pn_list_container_estudiante.setVisible(true);
            pn_list_estu_investigador.setVisible(true);
            lt_investigador.setListData(utils.getListWithFilter(lista_investigador, txt_reg_estu_investigador.getText().toUpperCase()));

        }

        pn_list_estu_investigador.setVisible(showListInvestigador);

        validarFormEstudiante();

        if (pn_message_error_estudiante.isVisible()) {
            pn_message_error_estudiante.setVisible(false);
        }
    }//GEN-LAST:event_txt_reg_estu_investigadorCaretUpdate

    private void btn_show_list_investigadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_show_list_investigadorMouseClicked
        if (showListInvestigador) {
            btn_show_list_investigador.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
            pn_list_estu_investigador.setVisible(false);
            validarFormEstudiante();
        } else {
            btn_show_list_investigador.setIcon(utils.getImageWithScale(utils.ARROW_UP, 30, 30));

            pn_list_container_estudiante.setVisible(true);
            pn_list_estu_investigador.setVisible(true);

            if (pn_message_error_estudiante.isVisible()) {
                pn_message_error_estudiante.setVisible(false);
            }

        }

        showListInvestigador = !showListInvestigador;
    }//GEN-LAST:event_btn_show_list_investigadorMouseClicked

    private void cbx_reg_estudiante_divisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_reg_estudiante_divisionActionPerformed
        List<String> listaLicenciaturas = conn.getCarrerasByDivisiones(listaDivision.get(cbx_reg_estudiante_division.getSelectedIndex()).getAcronimo());
        DefaultComboBoxModel modelLicenciatura = new DefaultComboBoxModel(listaLicenciaturas.toArray());
        cbx_reg_estudiante_licenciatura.setModel(modelLicenciatura);
        validarFormEstudiante();
    }//GEN-LAST:event_cbx_reg_estudiante_divisionActionPerformed

    private void lt_investigadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_investigadorMouseClicked
        txt_reg_estu_investigador.setText(lt_investigador.getSelectedValue());
        pn_list_estu_investigador.setVisible(false);
        btn_show_list_investigador.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
        showListInvestigador = false;
        validarFormEstudiante();
    }//GEN-LAST:event_lt_investigadorMouseClicked

    private void btn_reg_estudiante_okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_estudiante_okMouseEntered
        utils.hover(btn_reg_estudiante_ok, Color.WHITE, utils.COLOR_MENU_BACKGROUND, true);
    }//GEN-LAST:event_btn_reg_estudiante_okMouseEntered

    private void btn_reg_estudiante_okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_estudiante_okMouseExited
        utils.hover(btn_reg_estudiante_ok, Color.WHITE, utils.COLOR_MENU_BACKGROUND, false);
    }//GEN-LAST:event_btn_reg_estudiante_okMouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        utils.hover(jLabel7, Color.WHITE, utils.COLOR_DARK_RED, true);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        utils.hover(jLabel7, Color.WHITE, utils.COLOR_DARK_RED, false);
    }//GEN-LAST:event_jLabel7MouseExited

    private void spn_reg_estudiante_promedioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spn_reg_estudiante_promedioStateChanged
        validarFormEstudiante();

        if (pn_list_container_estudiante.isVisible()) {
            pn_list_container_estudiante.setVisible(false);
            showListInvestigador = false;
            btn_show_list_investigador.setIcon(utils.getImageWithScale(utils.ARROW_DOWN, 30, 30));
        }
    }//GEN-LAST:event_spn_reg_estudiante_promedioStateChanged

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try {
            utils.abrirWeb("https://veranocientifico.ujat.mx/Content/Doctos/LINEAMIENTOS%20XVIII%20VIC%202022ajs.pdf");
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void spn_reg_estudiante_avanceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spn_reg_estudiante_avanceStateChanged
        validarFormEstudiante();

    }//GEN-LAST:event_spn_reg_estudiante_avanceStateChanged

    private void btn_reg_estudiante_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reg_estudiante_okMouseClicked

        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(txt_reg_estudiante_matricula.getText().toUpperCase());
        estudiante.setNombre(txt_reg_estudiante_nombre.getText().toLowerCase());
        estudiante.setCorreo(txt_reg_estudiante_correo.getText());
        estudiante.setGenero(cbx_reg_estudiante_genero.getSelectedItem().toString());
        estudiante.setPromedio((float) spn_reg_estudiante_promedio.getValue());
        estudiante.setAvance((float) spn_reg_estudiante_avance.getValue());
        estudiante.setDivision(listaDivision.get(cbx_reg_estudiante_division.getSelectedIndex()).getAcronimo());
        estudiante.setLicenciatura(cbx_reg_estudiante_licenciatura.getSelectedItem().toString());
        estudiante.setInvestigador(txt_reg_estu_investigador.getText());
        estudiante.setFoto(utils.readFile(ruta_foto));

        if (conn.registrarEstudiante(estudiante)) {
            load_frame(pn_registro_form_ok);
            lbl_foto_ok.setIcon(utils.getImageWithScaleFromBytes(utils.readFile(ruta_foto), 152, 152));
        }


    }//GEN-LAST:event_btn_reg_estudiante_okMouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        consultaOpcion = 1;
         String[] columns = {"Clave", "Grado", "Nombre", "Institucion", "linea", "Estado"};
        String[][] datos = new String[listaInvestigadores.size()][columns.length];
       

        for (int i = 0; i < listaInvestigadores.size(); i++) {
            Investigador e = listaInvestigadores.get(i);
            datos[i][0] = Integer.toString(e.getClave());
            datos[i][1] = e.getGrado();
            datos[i][2] = e.getNombre();
            datos[i][3] = e.getInstitucion();
            datos[i][4] = e.getLinea();
            datos[i][5] = e.getEstado();
            System.out.println(e.getNombre());
        }
        DefaultTableModel modelo = new DefaultTableModel(datos, columns);
        tbl_consultas.setModel(modelo);

    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
consultaOpcion = 2;
       
        String[] columns = {"Matricula", "Nombre", "Division", "Licenciatura", "Division"};
 String[][] datos = new String[listaInvestigadores.size()][columns.length];
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante e = listaEstudiantes.get(i);
            datos[i][0] = e.getMatricula();
            datos[i][1] = e.getNombre();
            datos[i][2] = e.getDivision();
            datos[i][3] = e.getLicenciatura();
            datos[i][4] = e.getDivision();

        }

        DefaultTableModel modelo = new DefaultTableModel(datos, columns);
        tbl_consultas.setModel(modelo);

    }//GEN-LAST:event_jPanel8MouseClicked

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
       String busqueda = jTextField1.getText();
       DefaultTableModel modelo;
       
       
       

       String datos[][];
       
       if(consultaOpcion == 1){
           
         ArrayList<Investigador> elementos = utils.buscarEnLaListaConsultaInvestigador(listaInvestigadores, busqueda);  
         String[] columns = {"Clave", "Grado", "Nombre", "Institucion", "linea", "Estado"};  
        datos= new String[elementos.size()][columns.length];   
           
       for (int i = 0; i<elementos.size(); i++) {
           
            Investigador e = elementos.get(i);
             
            datos[i][0] = Integer.toString(e.getClave());
            datos[i][1] = e.getGrado();
            datos[i][2] = e.getNombre();
            datos[i][3] = e.getInstitucion();
            datos[i][4] = e.getLinea();
            datos[i][5] = e.getEstado();

        }
               modelo = new DefaultTableModel(datos, columns);
       
       }else{
           
       ArrayList<Estudiante> elementos = utils.buscarEnLaListaConsultaEstudiante(listaEstudiantes, busqueda);  
               String[] columns = {"Matricula", "Nombre", "Division", "Licenciatura", "Division"};    
        datos= new String[elementos.size()][columns.length];   
       
       for (int i = 0; i<elementos.size(); i++) {
          
            Estudiante e = elementos.get(i);
            
            datos[i][0] = e.getMatricula();
            datos[i][1] = e.getNombre();
            datos[i][2] = e.getDivision();
            datos[i][3] = e.getLicenciatura();
            datos[i][4] = e.getDivision();

        }
       
             modelo = new DefaultTableModel(datos, columns);
       
       }
       

        tbl_consultas.setModel(modelo);
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void tbl_consultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_consultasMouseClicked
            
       consultaData = tbl_consultas.getValueAt(tbl_consultas.getSelectedRow(),  0).toString();
        
        pn_consultasbotones.setVisible(true);
    }//GEN-LAST:event_tbl_consultasMouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
     
      ShowDetails details= new ShowDetails(consultaOpcion, consultaData);
      details.setVisible(true);
    }//GEN-LAST:event_jLabel34MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_reg_estu_selec_foto;
    private javax.swing.JLabel btn_reg_estudiante_ok;
    private javax.swing.JLabel btn_reg_inves_ok;
    private javax.swing.JLabel btn_reg_inves_selec_foto;
    private javax.swing.JLabel btn_show_list_institucion;
    private javax.swing.JLabel btn_show_list_investigador;
    private javax.swing.JLabel btn_show_list_linea;
    private javax.swing.JComboBox<String> cbx_reg_estudiante_division;
    private javax.swing.JComboBox<String> cbx_reg_estudiante_genero;
    private javax.swing.JComboBox<String> cbx_reg_estudiante_licenciatura;
    private javax.swing.JComboBox<String> cbx_reg_inves_estado;
    private javax.swing.JComboBox<String> cbx_reg_inves_genero;
    private javax.swing.JComboBox<String> cbx_reg_inves_grado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane js_container_list_institucion;
    private javax.swing.JScrollPane js_container_list_linea;
    private javax.swing.JLabel lbl_Slide;
    private javax.swing.JLabel lbl_about;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_consultas;
    private javax.swing.JLabel lbl_foto_ok;
    private javax.swing.JLabel lbl_foto_reg_estudiante;
    private javax.swing.JLabel lbl_foto_reg_investigador;
    private javax.swing.JLabel lbl_message_error_information;
    private javax.swing.JLabel lbl_message_error_text;
    private javax.swing.JLabel lbl_minimize;
    private javax.swing.JLabel lbl_reg_estudiantes;
    private javax.swing.JLabel lbl_reg_investigadores;
    private javax.swing.JLabel lbl_textoPrincipal;
    private javax.swing.JLabel lbl_texto_secundario;
    private javax.swing.JList<String> lt_institucion;
    private javax.swing.JList<String> lt_investigador;
    private javax.swing.JList<String> lt_linea;
    private javax.swing.JPanel pn_about;
    private javax.swing.JPanel pn_bienvenida;
    private javax.swing.JPanel pn_consultas;
    private javax.swing.JPanel pn_consultasbotones;
    private javax.swing.JPanel pn_container_list_institucion;
    private javax.swing.JPanel pn_container_list_linea;
    private javax.swing.JPanel pn_formContainer;
    private javax.swing.JPanel pn_list_container_estudiante;
    private javax.swing.JPanel pn_list_estu_investigador;
    private javax.swing.JPanel pn_message_error_estudiante;
    private javax.swing.JPanel pn_move;
    private javax.swing.JPanel pn_reg_estudiantes;
    private javax.swing.JPanel pn_reg_investigadores;
    private javax.swing.JPanel pn_registro_form_ok;
    private javax.swing.JSpinner spn_reg_estudiante_avance;
    private javax.swing.JSpinner spn_reg_estudiante_promedio;
    private javax.swing.JTable tbl_consultas;
    private javax.swing.JTextField txt_reg_estu_investigador;
    private javax.swing.JTextField txt_reg_estudiante_correo;
    private javax.swing.JTextField txt_reg_estudiante_matricula;
    private javax.swing.JTextField txt_reg_estudiante_nombre;
    private javax.swing.JTextField txt_reg_inves_email;
    private javax.swing.JTextField txt_reg_inves_institucion;
    private javax.swing.JTextField txt_reg_inves_linea;
    private javax.swing.JTextField txt_reg_inves_nombre;
    // End of variables declaration//GEN-END:variables
}
