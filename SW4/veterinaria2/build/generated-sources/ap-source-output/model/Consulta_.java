package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Veterinario;

@Generated(value="EclipseLink-2.7.9.v20220616-rNA", date="2022-12-05T23:09:34")
@StaticMetamodel(Consulta.class)
public class Consulta_ { 

    public static volatile SingularAttribute<Consulta, Veterinario> veterinario;
    public static volatile SingularAttribute<Consulta, String> telefone;
    public static volatile SingularAttribute<Consulta, String> queixa;
    public static volatile SingularAttribute<Consulta, String> animal;
    public static volatile SingularAttribute<Consulta, Long> id;
    public static volatile SingularAttribute<Consulta, Date> quando;
    public static volatile SingularAttribute<Consulta, String> tutor;

}