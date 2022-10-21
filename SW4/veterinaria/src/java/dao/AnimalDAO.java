package dao;

import entidade.Animal;
import entidade.Veterinario;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.model.SelectItem;

public class AnimalDAO implements Serializable {

    private static LinkedList<Animal> animal = null;
    private static LinkedList<SelectItem> animais = null;

    public AnimalDAO() {
        System.out.println("Criando MarcaDAO");
        System.out.flush();
        if (animal == null) {
            animal = new LinkedList<>();
            Animal a = new Animal(1, "Gato");
            a.adicionarVeterinario(1, "Lucas");
            a.adicionarVeterinario(2, "Thiago");
            a.adicionarVeterinario(3, "Kamila");
            a.adicionarVeterinario(4, "Marco");
            animal.add(a);

            a = new Animal(2, "Cachorro");
            a.adicionarVeterinario(10, "Diogo");
            a.adicionarVeterinario(11, "Eduarda");
            a.adicionarVeterinario(12, "Flavia");
            a.adicionarVeterinario(13, "Marcelo");
            animal.add(a);

            a = new Animal(3, "Aves");
            a.adicionarVeterinario(20, "Jessica");
            a.adicionarVeterinario(21, "Rose");
            a.adicionarVeterinario(22, "Patrick");
            a.adicionarVeterinario(23, "Leticia");
            animal.add(a);
        }
        animais = new LinkedList<>();
        animais.add(new SelectItem(null, "Selecione a marca"));
        for (Animal an : animal) {
            animais.add(new SelectItem(an, an.getEspecie()));
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
