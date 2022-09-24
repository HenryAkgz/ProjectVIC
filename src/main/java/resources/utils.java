package resources;

import java.awt.Color;
import java.awt.Component;
import static java.awt.Desktop.getDesktop;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import java.net.URI;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Estudiante;
import modelo.Investigador;

public class utils {

    private static String resources_location = "src\\main\\java\\resources\\images\\";
    
    public static String URL_UJAT_VERANO = "https://veranocientifico.ujat.mx/";
    public static String ujat_logo_white_Icon = resources_location + "escudo_white.png";
    public static String close_white_Icon = resources_location + "close_white.png";
    public static String close_red_Icon = resources_location + "close_red.png";
    public static String minimize_white_Icon = resources_location + "minimize_white.png";
    public static String minimize_color_Icon = resources_location + "minimize_color.png";
    public static String INVESTIGADOR_ICON = resources_location + "investigador.png";
    public static String ESTUDIANTE_ICON = resources_location + "estudiante.png";
    public static String DELETE_ICON = resources_location + "delete.png";
    public static String UPDATE_ICON = resources_location + "update.png";
    public static String DETAILS_ICON = resources_location + "information.png";
    public static String SCIENCE_ICON_1 = resources_location + "science_1.jpg";
    public static String SCIENCE_ICON_2 = resources_location + "science_2.jpg";
    public static String SCIENCE_ICON_3 = resources_location + "science_3.jpg";
    public static String SCIENCE_ICON_4 = resources_location + "science_4.jpg";
    public static String SCIENCE_ICON_5 = resources_location + "science_5.jpg";
    public static String ARROW_UP = resources_location + "arrow_up.png";
    public static String ARROW_DOWN = resources_location + "arrow_DOWN.png";
    
    
    public static Color COLOR_HOVER = new Color(24, 49, 79);
    public static Color COLOR_MENU_BACKGROUND = new Color(13, 6, 48);
    public static Color COLOR_HOVER_ABOUT = new Color(56, 78, 119);
    public static Color COLOR_BUTTON_CONOCER = new Color(24, 49, 79);//new Color(51, 115, 87);
     public static Color COLOR_DARK_RED =new Color(78, 1, 16);
      public static Color COLOR_VERDE_AGUA =  new Color(0, 169, 165);
      public static Color COLOR_MORADO_DARK = new Color(75, 33, 66);
    public static final String MASCULINO = "MASCULINO";
    public static final String FEMENINO = "FEMENINO";
    public static final String OTRO = "OTRO";
    
    public static int PROMEDIO_MINIMO = 8;
    public static int AVANCE_CURRICULAR_MINIMO = 65;
    
    public static void hover(JLabel label, Color color1, Color color2, boolean entered){
  if(entered){
    label.setForeground(color1);
    label.setBackground(color2);
  }else{
    label.setForeground(color2);
    label.setBackground(color1);
  }
    }

    public static ImageIcon getImageWithScale(String path, int x, int y) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
    }
    
    public static ImageIcon getImageWithScaleFromBytes(byte[] foto, int x, int y){
    return new ImageIcon(new ImageIcon(foto).getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
    }
    
    public static void abrirWeb(String url) throws IOException{
        getDesktop().browse(URI.create(url));
    }
    
    public static String getImageFromFile(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes JPG & PNG", "jpg", "png");
        chooser.setFileFilter(filter);
        
        int return_value=chooser.showOpenDialog(null);
        
        if(return_value == JFileChooser.APPROVE_OPTION){
          return chooser.getSelectedFile().getAbsolutePath();
        }
        
        return null;
    }
   
    public static String[] getListWithFilter(String[] lista, String busqueda){
        System.out.println("entro a metodo bsucando "+busqueda);
      Object[] tempList =Arrays.stream(lista).filter(item -> item.contains(busqueda)).toArray();  
       System.out.println(tempList.length +" Elementos encontrados en una lista de " +lista.length + " elementos");
       
       
    //   =Arrays.stream(lista).filter(item -> item.contains(busqueda)).toArray(); 
    return Arrays.copyOf(tempList, tempList.length, String[].class);
    }
    

    
     public static byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
     
  public static ArrayList<Investigador> buscarEnLaListaConsultaInvestigador(ArrayList<Investigador> inves, String busqueda){
  
     ArrayList<Investigador> listaFiltrados = new ArrayList<>();
      
 
   
      for(int i=0; i<inves.size(); i++){
         
         Investigador e = inves.get(i);
          
        if (Integer.toString(e.getClave()).contains(busqueda) || e.getNombre().contains(busqueda) ||  e.getNombre().contains(busqueda.toUpperCase()) || e.getInstitucion().contains(busqueda)){
        listaFiltrados.add(e);
        }
      }
      
 
 
  return listaFiltrados;
  }
  
  public static ArrayList<Estudiante> buscarEnLaListaConsultaEstudiante(ArrayList<Estudiante> estu, String busqueda){
  
     ArrayList<Estudiante> listaFiltrados = new ArrayList<>();
      
 
   
      for(int i=0; i<estu.size(); i++){
         
         Estudiante e = estu.get(i);
          
        if (e.getMatricula().contains(busqueda) || e.getNombre().contains(busqueda) ||  e.getNombre().contains(busqueda.toUpperCase())  || e.getLicenciatura().contains(busqueda) || e.getDivision().contains(busqueda)){
        listaFiltrados.add(e);
        }
      }
      
 
 
  return listaFiltrados;
  }
}
