package dao;

import entidade.Animal;
import entidade.Veterinario;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.model.SelectItem;

public class AnimalDAO implements Serializable {

    private static LinkedList<Animal> animal;
    private static LinkedList<SelectItem> animais;

    public AnimalDAO() {
        System.out.println("Criando MarcaDAO");
        System.out.flush();
        if (animal == null) {
            animal = new LinkedList<>();
            Animal a = new Animal("Gato");
            a.adicionarVeterinario("Lucas");
            a.adicionarVeterinario("Thiago");
            a.adicionarVeterinario("Kamila");
            a.adicionarVeterinario("Marco");
            animal.add(a);

            a = new Animal("Cachorro");
            a.adicionarVeterinario("Diogo");
            a.adicionarVeterinario("Eduarda");
            a.adicionarVeterinario("Flavia");
            a.adicionarVeterinario("Marcelo");
            animal.add(a);

            a = new Animal("Aves");
            a.adicionarVeterinario("Jessica");
            a.adicionarVeterinario("Rose");
            a.adicionarVeterinario("Patrick");
            a.adicionarVeterinario("Leticia");
            animal.add(a);
        }
        animais = new LinkedList<>();
        animais.add(new SelectItem(null, "Selecion um Animal"));
        for (Animal a : animal) {
            animais.add(new SelectItem(a, a.getEspecie()));
        }
    }

    public Animal buscarAnimal(int id) {
        for (Animal a : animal) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Veterinario buscarVeterinario(int id) {
        for (Animal a : animal) {
            for (Veterinario vet : a.getVeterinarios()) {
                if (vet.getId() == id) {
                    return vet;
                }
            }
        }
        return null;
    }

    public void incluir(Animal a) throws AnimalJaCadastrado {
            if (animal.contains(a)) {
                throw new AnimalJaCadastrado();
            }
            animal.add(a); 
            animais.add(new SelectItem(a, a.getEspecie()));
    }
    
     public void incluirVet(Animal a,String vet){
         a.adicionarVeterinario(vet);
     }

    public LinkedList<SelectItem> getAnimais() {
        return animais;
    }

    public static LinkedList<Animal> getAnimal() {
        return animal;
    }

    public static void setAnimal(LinkedList<Animal> animal) {
        AnimalDAO.animal = animal;
    }

}
