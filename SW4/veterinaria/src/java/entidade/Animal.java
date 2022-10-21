package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

public class Animal implements Serializable {

    private int id;
    private String especie;
    private LinkedList<Veterinario> veterinarios;

    public Animal(int id, String especie) {
        this.id = id;
        this.especie = especie;
        veterinarios =  new LinkedList<>();
    }

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LinkedList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(LinkedList<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
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
        final Animal other = (Animal) obj;
        if (this.id != other.id) {
            return false;
        }
       
        return true;
    }
    
     public void adicionarVeterinario(int idVeterinario, String nome) {
        Veterinario m = new Veterinario(idVeterinario, nome, this);
        veterinarios.add( m );
    }
    
                      
    
    
    
}