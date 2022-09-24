/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package framesControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import resources.utils;

/**
 *
 * @author calld
 */
public class FrameBienvenida {

    JPanel pn_main;
    JLabel textoPrincipal, texto_secundario, Slide;
    int count_slide = 1;

    public FrameBienvenida(JPanel pn_main, JLabel textoPrincipal, JLabel texto_secundario, JLabel Slide) {

        this.pn_main = pn_main;
        this.textoPrincipal = textoPrincipal;
        this.texto_secundario = texto_secundario;
        this.Slide = Slide;
        setContentFrame(count_slide);
        count_slide++;
        changeContent.start();
    }

    public Timer changeContent = new Timer(10000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
         setContentFrame(count_slide);
            
         if(count_slide==5){
         count_slide = 1;
         }else{
         count_slide++;
         }
        
        }
    });

    private void setContentFrame(int count) {
        String textMain, textSecondary, path;

        switch (count) {
            case 1:
                 textMain = "Un <span style=\"color: green;\">científico</span> tiene en su mano el destino de los humanos, pues en sus manos está que vivamos más y mejor.";
                textSecondary = "Se convoca a las y los estudiantes de los programas educativos de licenciatura de la Universidad Juárez Autónoma de Tabasco a participar en el XVIII Verano de la Investigación Científica UJAT 2022, integrándose a un equipo de trabajo para el desarrollo de sus competencias y formar parte de un trabajo colaborativo de proyectos de investigación vigentes.";
                path = utils.SCIENCE_ICON_1;
                break;
            case 2:
                 textMain = " “Si decides hacer solo las cosas que sabes que van a funcionar, dejarás un montón de oportunidades encima de la mesa”.";
                textSecondary = "Se convoca a las y los profesores PTC registrados en los Cuerpos Académicos y Grupos de Investigación de la Universidad Juárez Autónoma de Tabasco a participar en el XVIII Verano de la Investigación Científica UJAT 2022, inscribiendo máximo tres proyectos de investigación de forma individual o en colaboración con otra profesora o profesor, y máximo dos estudiantes por proyecto.";
                path = utils.SCIENCE_ICON_2;
                break;
            case 3:
                 textMain = "“Cualquier tecnología suficientemente avanzada es equivalente a la magia”.";
                textSecondary = "A todos los veranenates les recordamos que tienen hasta el 30 de septiembre del 2022 para adjuntar su reporte final F-DI-01 y fotografías en la plataforma.";
                path = utils.SCIENCE_ICON_3;
                break;
            case 4:
                 textMain = "“Una máquina puede hacer el trabajo de cincuenta hombres ordinarios. Ninguna máquina puede hacer el trabajo de un hombre extraordinario”. ";
                textSecondary = "Estimados participantes del XVIII Verano de la Investigación Científica virtual 2022 UJAT, con la finalidad de divulgar sus logros en la estancia de este año, la Secretaría de Investigación, Posgrado y Vinculación, a través de la Dirección de Investigación, está organizando el segundo Congreso de productos y resultados del VIC 2022 que se llevará a cabo los días 29 y 30 de septiembre en modalidad virtual.";
                path = utils.SCIENCE_ICON_4;
                break;
            case 5:
               textMain = "“La duda es la madre del descubrimiento”.";
                textSecondary = "El Congreso es una oportunidad para que expongan, expresen y compartan su talento y creatividad con otros veraneantes en un marco inclusivo y de respeto, que al igual que tú, también aceptaron invertir sus vacaciones por el deseo ávido de aprender y experimentar en este proyecto anual de vocaciones científicas. También, el congreso es un reconocimiento a su tenacidad y capacidad para resolver problemas vinculados a las actividades científicas.";
                path = utils.SCIENCE_ICON_5;
                break;

            default:
                   textMain = "Texo numero 1";
                textSecondary = "sub texto numero 1";
                path = utils.SCIENCE_ICON_1;
                break;
        }

        textoPrincipal.setText("<html><h1 style=\"text-align: center;\">"+textMain+"</h1></html>");
        texto_secundario.setText("<html><p style=\"text-align: center; font-size: 10px;\">"+textSecondary+"</p></html>");
        Slide.setIcon(utils.getImageWithScale(path, 460, 460));
        System.out.println("slide activo");
    }

}
