package org.foryou.bancoforyou.User;

import java.math.BigDecimal;

import org.bson.types.ObjectId;

public class UserMinDTO{

    protected ObjectId id;

    protected String name;

    protected int idade;

    protected BigDecimal saldo;

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

    public BigDecimal getSaldo(){
        return saldo;
    }

    public String getEmail(){
        return email;
    }

    public Boolean getContaPJ(){
        return contaPJ;
    }
}
