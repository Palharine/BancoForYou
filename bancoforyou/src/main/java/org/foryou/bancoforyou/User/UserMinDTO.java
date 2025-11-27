package org.foryou.bancoforyou.User;

import org.bson.types.ObjectId;

public class UserMinDTO{

    protected ObjectId id;

    protected String name;

    protected int idade;

    protected Double saldo;

    protected String email;

    protected Boolean contaPJ;

    public UserMinDTO(){}

    public UserMinDTO(Usuarios entity){
        id = entity.getId();
        name = entity.getName();
        idade = entity.getIdade();
        saldo = entity.getSaldo();
        email = entity.getEmail();
        contaPJ = entity.getContaPJ();
    }
    public ObjectId getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }

    public int getIdade(){
        return idade;
    }

    public Double getSaldo(){
        return saldo;
    }

    public String getEmail(){
        return email;
    }

    public Boolean getContaPJ(){
        return contaPJ;
    }
}
