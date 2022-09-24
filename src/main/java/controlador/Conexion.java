/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serial;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import modelo.Division;
import modelo.Investigador;
import modelo.Estudiante;
import resources.utils;


public class Conexion {
     public Connection getConexion() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:datos_vic.db");
            return conexion;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
     
   public String[] getLineas(){
   
   Connection conexion = getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT linea FROM investigador");
           
            ArrayList<String> lista = new ArrayList<>();
            
            while (resultado.next()) {
                if(!lista.contains(resultado.getString(1))){
                lista.add(resultado.getString(1));
                }
            }
            resultado.close();
            conexion.close();
            
            String[] array = new String[lista.size()];
            
            for (int i = 0; i < lista.size(); i++) {
                array[i] = lista.get(i);
            }
            
            return array;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
   
   
   }  
   
   public String[] getInstituciones(){
   
   Connection conexion = getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT institucion FROM investigador");
           
            ArrayList<String> lista = new ArrayList<>();
            
            while (resultado.next()) {
                if(!lista.contains(resultado.getString(1))){
                lista.add(resultado.getString(1));
                }
            }
            resultado.close();
            conexion.close();
            
            String[] array = new String[lista.size()];
            
            for (int i = 0; i < lista.size(); i++) {
                array[i] = lista.get(i);
            }
            
            return array;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
   
   
   }  
   
   public boolean registrarInvestigador(Investigador inves){
       Connection conexion = getConexion();
        System.out.println("entro registro");
       try {
           
           String query = "INSERT INTO investigador (clave, grado, nombre, correo, genero, institucion, linea, estado, foto) VALUES ('"+inves.getClave()+"', '"+inves.getGrado()+"', '"+inves.getNombre().toUpperCase()+"', '"+inves.getCorreo()+"', '"+inves.getGenero()+"', '"+inves.getInstitucion()+"', '"+inves.getLinea()+"', '"+inves.getEstado()+"', ?)";
          
           PreparedStatement statement = conexion.prepareStatement(query);
           
           statement.setBytes(1, inves.getFoto());
           
           System.out.println("ejecutando query");
           
          statement.execute();
           
            statement.close();
            conexion.close();
           System.out.println("termino registro");
           return true;
       } catch (Exception e) {
           e.printStackTrace();
       return false;
       }
   
   }
   
   
   public Investigador getInvestigador(int clave){
      Connection conexion = getConexion();
   
       
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM investigador WHERE clave = "+clave);
           
            Investigador inves = new Investigador();
            
            inves.setClave(resultado.getInt(1));
            inves.setGrado(resultado.getString(2));
            inves.setNombre(resultado.getString(3));
            inves.setCorreo(resultado.getString(4));
            inves.setGenero(resultado.getString(5));
            inves.setInstitucion(resultado.getString(6));
            inves.setLinea(resultado.getString(7));
            inves.setEstado(resultado.getString(8));
            inves.setFoto(resultado.getBytes(9));
            
            resultado.close();
            conexion.close();
            
   
            return inves;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
   
   } 
   
       public ArrayList<Division> getDivisiones() {
        Connection conexion = this.getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM division_academica");
            
            ArrayList<Division> lista = new ArrayList<>();
            
            while (resultado.next()) {
               
                lista.add(new Division(resultado.getString(1), resultado.getString(2)));
            }
            
            resultado.close();
            conexion.close();
            return lista;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
       
       
        public List<String> getCarrerasByDivisiones(String division) {
        Connection conexion = this.getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT nombre FROM licenciatura WHERE division =\"" + division + "\"");
            List<String> lista = new ArrayList<>();
            while (resultado.next()) {
                String nombre = resultado.getString(1);
                lista.add(nombre);
            }
            resultado.close();
            conexion.close();
            return lista;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
   

     public String[] getInvestigadores() {
        Connection conexion = this.getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT nombre FROM investigador");
            List<String> lista = new ArrayList<>();
            while (resultado.next()) {
                String nombre = resultado.getString(1);
                lista.add(nombre);
            }
          
         String[] array = new String[lista.size()];   
            
          for(int i=0; i<lista.size(); i++){
          array[i] = lista.get(i);
          }  
            
            resultado.close();
            conexion.close();
            return array;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
     
     public boolean registrarEstudiante(Estudiante e){
      Connection conexion = this.getConexion();
        try {
            PreparedStatement psInsert = conexion.prepareStatement("INSERT INTO estudiante (matricula,nombre,genero,correo,promedio,avance,division,licenciatura,investigador, foto) VALUES(?,?,?,?,?,?,?,?,?,?)");
            psInsert.setString(1, e.matricula);
            psInsert.setString(2, e.nombre);
            psInsert.setString(3, e.genero);
            psInsert.setString(4, e.correo);
            psInsert.setFloat(5, e.promedio);
            psInsert.setFloat(6, e.avance);
            psInsert.setString(7, e.division);
            psInsert.setString(8, e.licenciatura);
            psInsert.setString(9, e.investigador);
            psInsert.setBytes(10, e.getFoto());
            psInsert.executeUpdate();
            psInsert.close();
            conexion.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
 
     }
     
      public ArrayList<Estudiante> getArrayEstudiantes() {
        Connection conexion = this.getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM estudiante");
            ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
           
            while (resultado.next()) {
                Estudiante e = new Estudiante();
                e.setMatricula(resultado.getString(1));
                e.setNombre(resultado.getString(2));
                e.setGenero(resultado.getString(3));
                e.setCorreo(resultado.getString(4));
                e.setPromedio(resultado.getFloat(5));
                e.setAvance(resultado.getFloat(6));
                e.setDivision(resultado.getString(7));
                e.setLicenciatura(resultado.getString(8));
                e.setInvestigador(resultado.getString(9));
                e.setFoto(resultado.getBytes(10));
                lista.add(e);
            }
            resultado.close();
            conexion.close();
            return lista;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
      
      
      public ArrayList<Investigador> getArrayInvestigadores() {
        Connection conexion = this.getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM investigador");
            ArrayList<Investigador> lista = new ArrayList<>();
            
            while (resultado.next()) {
                Investigador e = new Investigador();
                
                e.setClave(resultado.getInt(1));
                e.setGrado(resultado.getString(2));
                e.setNombre(resultado.getString(3));
                e.setCorreo(resultado.getString(4));
                e.setGenero(resultado.getString(5));
                e.setInstitucion(resultado.getString(6));
                e.setLinea(resultado.getString(7));
                e.setEstado(resultado.getString(8));
                e.setFoto(resultado.getBytes(9));
                
                lista.add(e);
            }
          
        return lista;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
     
  public Estudiante getEstudiante(String matricula) {
        Connection conexion = this.getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM estudiante WHERE matricula = '"+matricula+"'");
           
            Estudiante e = new Estudiante();
           
            if(resultado.next()) {
                e.setMatricula(resultado.getString(1));
                e.setNombre(resultado.getString(2));
                e.setGenero(resultado.getString(3));
                e.setCorreo(resultado.getString(4));
                e.setPromedio(resultado.getFloat(5));
                e.setAvance(resultado.getFloat(6));
                e.setDivision(resultado.getString(7));
                e.setLicenciatura(resultado.getString(8));
                e.setInvestigador(resultado.getString(9));
                e.setFoto(resultado.getBytes(10));
            }
            resultado.close();
            conexion.close();
            return e;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }    
      
}
