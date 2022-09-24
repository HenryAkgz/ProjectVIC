/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ShowDetails;

import controlador.Conexion;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelo.Estudiante;
import modelo.Investigador;
import resources.utils;

/**
 *
 * @author calld
 */
public class ShowDetails extends javax.swing.JFrame {

    /**
     * Creates new form ShowDetails
     */
    
     Conexion conn = new Conexion();
     int x,y;
    public ShowDetails(int tipo, String data) {
        initComponents();
        lbl_title.setText("Mostrando detalles de " + (tipo==1? "Investigador" : "Estudiante"));
        setLocationRelativeTo(null);
        load_frame(tipo==1 ? pn_investigador : pn_estudiante);
        loadData(tipo, data);
    }
    
     private void load_frame(JPanel panel) {
        panel.setSize(pn_formContainer.getSize());
        pn_formContainer.removeAll();
        pn_formContainer.add(panel);
        pn_formContainer.updateUI();
        
    }
     
     private void loadData(int tipo, String item){
     
      if(tipo==1){
          
      Investigador inves = conn.getInvestigador(Integer.parseInt(item));    
      
      lbl_foto_inves.setIcon(utils.getImageWithScaleFromBytes(inves.getFoto(), 130, 130));
      lbl_clave_inves.setText(Integer.toString(inves.getClave()));
      lbl_correo_inves.setText(inves.getCorreo());
      lbl_estado_inves.setText(inves.getEstado());
      lbl_genero_inves.setText(inves.getGenero());
      lbl_nombre_inves.setText(inves.getNombre());
      lbl_linea_inves.setText(inves.getLinea());
      lbl_institucion_inves.setText(inves.getInstitucion());
      lbl_grado_inves.setText(inves.getGrado());
      
      }else{
      
      Estudiante estu = conn.getEstudiante(item);    
       lbl_foto_estu.setIcon(utils.getImageWithScaleFromBytes(estu.getFoto(), 130, 130));    
       lbl_matricula_estu.setText(estu.getMatricula());
       lbl_promedio_estu.setText(Float.toString(estu.getPromedio()));
       lbl_nombre_estu.setText(estu.getNombre());
       lbl_correo_estu.setText(estu.getCorreo());
       lbl_licenciatura_estu.setText(estu.getLicenciatura());
       lbl_division_estu.setText(estu.getDivision());
       lbl_investigador_estu.setText(estu.getInvestigador());
       lbl_genero_estu.setText(estu.getGenero());
       lbl_avance_estu.setText(Float.toString(estu.getAvance()) + "%");
      }   
         
     
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_investigador = new javax.swing.JPanel();
        lbl_foto_inves = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_clave_inves = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_grado_inves = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_nombre_inves = new javax.swing.JLabel();
        lbl_genero_inves = new javax.swing.JLabel();
        lbl_correo_inves = new javax.swing.JLabel();
        lbl_estado_inves = new javax.swing.JLabel();
        lbl_linea_inves = new javax.swing.JLabel();
        lbl_institucion_inves = new javax.swing.JLabel();
        pn_estudiante = new javax.swing.JPanel();
        lbl_foto_estu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_matricula_estu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_promedio_estu = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_nombre_estu = new javax.swing.JLabel();
        lbl_genero_estu = new javax.swing.JLabel();
        lbl_correo_estu = new javax.swing.JLabel();
        lbl_avance_estu = new javax.swing.JLabel();
        lbl_investigador_estu = new javax.swing.JLabel();
        lbl_licenciatura_estu = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_division_estu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        lbl_minimize = new javax.swing.JLabel();
        pn_formContainer = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();

        pn_investigador.setOpaque(false);

        lbl_foto_inves.setText("jLabel1");
        lbl_foto_inves.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel2.setText("Clave del investigador:");

        lbl_clave_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_clave_inves.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel4.setText("Grado:");

        lbl_grado_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_grado_inves.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel6.setText("Nombre: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel7.setText("Correo:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel8.setText("Genero:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel9.setText("Institución:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel10.setText("Linea de investigacion:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel11.setText("Estado:");

        lbl_nombre_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre_inves.setText("jLabel3");

        lbl_genero_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_genero_inves.setText("jLabel3");

        lbl_correo_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_correo_inves.setText("jLabel3");

        lbl_estado_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_estado_inves.setText("jLabel3");

        lbl_linea_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_linea_inves.setText("jLabel3");

        lbl_institucion_inves.setForeground(new java.awt.Color(255, 255, 255));
        lbl_institucion_inves.setText("jLabel3");

        javax.swing.GroupLayout pn_investigadorLayout = new javax.swing.GroupLayout(pn_investigador);
        pn_investigador.setLayout(pn_investigadorLayout);
        pn_investigadorLayout.setHorizontalGroup(
            pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_investigadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_investigadorLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_correo_inves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_investigadorLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_institucion_inves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_investigadorLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_linea_inves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_investigadorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_clave_inves, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_grado_inves, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_investigadorLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_genero_inves, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_estado_inves, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pn_investigadorLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_nombre_inves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addGroup(pn_investigadorLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lbl_foto_inves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_investigadorLayout.setVerticalGroup(
            pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_investigadorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_foto_inves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_clave_inves)
                    .addComponent(jLabel4)
                    .addComponent(lbl_grado_inves))
                .addGap(18, 18, 18)
                .addGroup(pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_nombre_inves))
                .addGap(18, 18, 18)
                .addGroup(pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_correo_inves))
                .addGap(18, 18, 18)
                .addGroup(pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbl_institucion_inves))
                .addGap(18, 18, 18)
                .addGroup(pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbl_linea_inves))
                .addGap(18, 18, 18)
                .addGroup(pn_investigadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_genero_inves)
                    .addComponent(jLabel11)
                    .addComponent(lbl_estado_inves))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pn_estudiante.setOpaque(false);

        lbl_foto_estu.setText("jLabel1");
        lbl_foto_estu.setPreferredSize(new java.awt.Dimension(130, 130));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel3.setText("Matricula:");

        lbl_matricula_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_matricula_estu.setText("jLabel3");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel5.setText("Promedio:");

        lbl_promedio_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_promedio_estu.setText("jLabel5");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel12.setText("Nombre: ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel13.setText("Correo:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel14.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel14.setText("Genero:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel15.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel15.setText("Licenciatura:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel16.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel16.setText("Investigador:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel17.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel17.setText("Avance:");

        lbl_nombre_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre_estu.setText("jLabel3");

        lbl_genero_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_genero_estu.setText("jLabel3");

        lbl_correo_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_correo_estu.setText("jLabel3");

        lbl_avance_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_avance_estu.setText("jLabel3");

        lbl_investigador_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_investigador_estu.setText("jLabel3");

        lbl_licenciatura_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_licenciatura_estu.setText("jLabel3");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel18.setForeground(utils.COLOR_VERDE_AGUA);
        jLabel18.setText("Division:");

        lbl_division_estu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_division_estu.setText("jLabel3");

        javax.swing.GroupLayout pn_estudianteLayout = new javax.swing.GroupLayout(pn_estudiante);
        pn_estudiante.setLayout(pn_estudianteLayout);
        pn_estudianteLayout.setHorizontalGroup(
            pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_estudianteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_estudianteLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_correo_estu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_estudianteLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_licenciatura_estu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_division_estu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_estudianteLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_investigador_estu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_estudianteLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_nombre_estu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_estudianteLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_genero_estu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_avance_estu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_estudianteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_matricula_estu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_promedio_estu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pn_estudianteLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lbl_foto_estu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_estudianteLayout.setVerticalGroup(
            pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_estudianteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_foto_estu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_matricula_estu)
                    .addComponent(jLabel5)
                    .addComponent(lbl_promedio_estu))
                .addGap(18, 18, 18)
                .addGroup(pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbl_nombre_estu))
                .addGap(18, 18, 18)
                .addGroup(pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbl_correo_estu))
                .addGap(18, 18, 18)
                .addGroup(pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbl_licenciatura_estu)
                    .addComponent(jLabel18)
                    .addComponent(lbl_division_estu))
                .addGap(18, 18, 18)
                .addGroup(pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbl_investigador_estu))
                .addGap(18, 18, 18)
                .addGroup(pn_estudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbl_genero_estu)
                    .addComponent(jLabel17)
                    .addComponent(lbl_avance_estu))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(utils.COLOR_MENU_BACKGROUND);

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

        pn_formContainer.setOpaque(false);
        pn_formContainer.setPreferredSize(new java.awt.Dimension(400, 375));

        javax.swing.GroupLayout pn_formContainerLayout = new javax.swing.GroupLayout(pn_formContainer);
        pn_formContainer.setLayout(pn_formContainerLayout);
        pn_formContainerLayout.setHorizontalGroup(
            pn_formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pn_formContainerLayout.setVerticalGroup(
            pn_formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("jLabel1");
        lbl_title.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_titleMouseDragged(evt);
            }
        });
        lbl_title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_titleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_titleMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pn_formContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_formContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
       this.dispose();
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void lbl_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseEntered
        lbl_close.setIcon(new ImageIcon(utils.close_red_Icon));
    }//GEN-LAST:event_lbl_closeMouseEntered

    private void lbl_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseExited
        lbl_close.setIcon(new ImageIcon(utils.close_white_Icon));
    }//GEN-LAST:event_lbl_closeMouseExited

    private void lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_lbl_minimizeMouseClicked

    private void lbl_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseEntered
        lbl_minimize.setIcon(new ImageIcon(utils.minimize_color_Icon));
    }//GEN-LAST:event_lbl_minimizeMouseEntered

    private void lbl_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseExited
        lbl_minimize.setIcon(new ImageIcon(utils.minimize_white_Icon));
    }//GEN-LAST:event_lbl_minimizeMouseExited

    private void lbl_titleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_titleMouseClicked
     
    }//GEN-LAST:event_lbl_titleMouseClicked

    private void lbl_titleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_titleMousePressed
    x = evt.getX();
      y = evt.getY();
    }//GEN-LAST:event_lbl_titleMousePressed

    private void lbl_titleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_titleMouseDragged
        setLocation(getLocation().x + evt.getX() - x, getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_lbl_titleMouseDragged

 
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_avance_estu;
    private javax.swing.JLabel lbl_clave_inves;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_correo_estu;
    private javax.swing.JLabel lbl_correo_inves;
    private javax.swing.JLabel lbl_division_estu;
    private javax.swing.JLabel lbl_estado_inves;
    private javax.swing.JLabel lbl_foto_estu;
    private javax.swing.JLabel lbl_foto_inves;
    private javax.swing.JLabel lbl_genero_estu;
    private javax.swing.JLabel lbl_genero_inves;
    private javax.swing.JLabel lbl_grado_inves;
    private javax.swing.JLabel lbl_institucion_inves;
    private javax.swing.JLabel lbl_investigador_estu;
    private javax.swing.JLabel lbl_licenciatura_estu;
    private javax.swing.JLabel lbl_linea_inves;
    private javax.swing.JLabel lbl_matricula_estu;
    private javax.swing.JLabel lbl_minimize;
    private javax.swing.JLabel lbl_nombre_estu;
    private javax.swing.JLabel lbl_nombre_inves;
    private javax.swing.JLabel lbl_promedio_estu;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pn_estudiante;
    private javax.swing.JPanel pn_formContainer;
    private javax.swing.JPanel pn_investigador;
    // End of variables declaration//GEN-END:variables
}