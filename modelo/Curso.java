package edu.ucam.rmi.academia.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Salvador
 */
public class Curso implements Serializable {

    private static final long serialVersionUID = 6L;

    private String identificador;
    private String descripcion;

    public Curso(String identificador, String descripcion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
    }

    public String getId() {
        return identificador;
    }

    public void setId(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + identificador + ", descripcion=" + descripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.identificador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        return true;
    }

}
