/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut2.examen.modelo;

 
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 *
 * @author Guille
 */

@XmlRootElement(name = "sistema")
@XmlType(propOrder = {"componente"})
public class SistemaCritico implements Serializable {
 
    private String nombre;
    private String componente;
 
    public SistemaCritico() {
    }
 
    public SistemaCritico(String nombre, String componente) {
        this.nombre = nombre;
        this.componente = componente;
    }
 
 
    @XmlAttribute(name = "nombre")
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
 
    @XmlElement(name = "componente")
    public String getComponente() {
        return componente;
    }
 
    public void setComponente(String componente) {
        this.componente = componente;
    }
 
    @Override
    public String toString() {
        return "Sistema: " + nombre + " | Componente: (" + componente + ")";
    }
}