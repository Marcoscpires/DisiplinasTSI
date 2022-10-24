package entidade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

public class Consulta implements Serializable{
   
    private String tutor;
    private String nomepet;
    private String motivo;
    private Veterinario veterinario;
    private String telefone; 
    private Date data;

    public Consulta(String tutor, String nomepet, String motivo, Veterinario veterinario, String telefone, Date data) {
        this.tutor = tutor;
        this.nomepet = nomepet;
        this.motivo = motivo;
        this.veterinario = veterinario;
        this.telefone = telefone;
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data)  throws ParseException {
        this.data = data;
    }
    
    public Consulta(){
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getNomepet() {
        return nomepet;
    }

    public void setNomepet(String nomepet) {
        this.nomepet = nomepet;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.data);
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
        final Consulta other = (Consulta) obj;
        return Objects.equals(this.data, other.data);
    }

    
    
    
    

    
}
