package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TipoAnimal;

@Generated(value="EclipseLink-2.7.9.v20220616-rNA", date="2022-12-07T19:41:49")
@StaticMetamodel(Veterinario.class)
public class Veterinario_ { 

    public static volatile SingularAttribute<Veterinario, TipoAnimal> especialidade;
    public static volatile SingularAttribute<Veterinario, String> crmv;
    public static volatile SingularAttribute<Veterinario, String> nome;
    public static volatile SingularAttribute<Veterinario, Long> id;
    public static volatile SingularAttribute<Veterinario, String> email;

}