/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ut2.examen;

import ut2.examen.modelo.SistemaCritico;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Guille
 */
public class EXAMENBINDING {
 
    public static void main(String[] args) {
        hacerBinding();
    }
 
    public static void hacerBinding(){
        
        File fichero = new File("objetivo_urgente.xml");
        File entrada = new File("estado_sistemas.txt");
        
        // Lista donde se guardan los sistemas en estado critico
        ArrayList<SistemaCritico> listaCriticos = new ArrayList<>();
        
        // Leo el fichero estado_sistemas línea a línea
        try (BufferedReader br = new BufferedReader(new FileReader(entrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    // El estado es el último campo;
                    String estado = partes[partes.length - 1].trim();
                    if (estado.equalsIgnoreCase("Critico")){
                        // Instancia del sistema crítico
                        listaCriticos.add(new SistemaCritico(partes[0].trim(), partes[1].trim()));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo el fichero: " + e.getMessage());
        }
        
        if (listaCriticos.isEmpty()) {
            System.out.println("No se ha detectado ningún sistema crítico.");
            return;
        }
        
        // Primer sistema crítico detectado
        SistemaCritico objetivo = listaCriticos.get(0);
 
        try {
            // Instanciamos el contexto pasándole nuestra clase anotada
            JAXBContext contexto = JAXBContext.newInstance(SistemaCritico.class);
            Marshaller marshaller = contexto.createMarshaller();
 
            // Configuración para que el XML de salida tenga tabulaciones y saltos de línea legibles
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            // Vuelco el objeto al fichero
            marshaller.marshal(objetivo, fichero);
            
 
            //Se muestra por consola
            marshaller.marshal(objetivo, System.out);
 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        

    }
}
