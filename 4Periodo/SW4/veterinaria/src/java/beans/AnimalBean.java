package beans;

import dao.AnimalDAO;
import dao.ConsultaDAO;
import entidade.Animal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@Named(value = "animalBean")
@ApplicationScoped
public class AnimalBean {

    
    AnimalDAO animalDAO;
   
    ConsultaDAO consultaDAO;

    public AnimalBean() {
    }

    @Produces
    public AnimalDAO getAnimalDAO() {
        if (animalDAO == null) {
            animalDAO = new AnimalDAO();
        }
        return animalDAO;
    }

    @Produces
    public ConsultaDAO getCosultaDAO() {
        if (consultaDAO == null) {
            consultaDAO = new ConsultaDAO();
        }
        return consultaDAO;
    }

    @PostConstruct
    public void iniciar() {
        try {
            FileInputStream fis = new FileInputStream("animal.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList<Animal> animais = (LinkedList<Animal>) ois.readObject();
            consultaDAO = (ConsultaDAO) ois.readObject();
            AnimalDAO.setAnimal(animais);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void finalizar() {
        System.out.println("Este é o ponto para salvar os objetos em um arquivo...");
        try {
            FileOutputStream fos = new FileOutputStream("animal.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject( animalDAO.getAnimais());
            oos.writeObject( consultaDAO );
            oos.flush();
            fos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
