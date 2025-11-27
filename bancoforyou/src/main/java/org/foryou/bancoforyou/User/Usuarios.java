package org.foryou.bancoforyou.User;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
//Serve para pegar as informações pelo banco de dados e pela collection
@Document(collection="usuarios")
//Cria getters, setters e to strings 
@Data
public class Usuarios{
	@Id
	protected ObjectId id;
	
	protected String name;
	
	//1: Gerente 2:Usuário Padrão e 3:Usuários menor de idade
	protected int nivel;
	
	protected int idade;

	protected Double saldo;
	
	protected Boolean contaPJ;
	
	protected String email;
	
	protected String genero;
	
	//public List<acoes> historico;
	
	public Usuarios(){}

    public Usuarios(ObjectId id, String name, int nivel, int idade, double saldo, boolean ContaPJ, String email, String genero){
        this.id = id;
        this.name = name;
        this.nivel = nivel;
        this.idade = idade;
        this.saldo = saldo;
        this.contaPJ = ContaPJ;
        this.email = email;
        this.genero = genero;
    }
    
    public ObjectId getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getNivel(){
        return nivel;
    }

    public int getIdade(){
        return idade;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean getContaPJ(){
        return contaPJ;
    }

    public String getEmail(){
        return email;
    }

    public String getGenero(){
        return genero;
    }

    public void setId(ObjectId id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setContaPJ(boolean contaPJ){
        this.contaPJ = contaPJ;
    }

    public void setEmail(String email){
        this.email = email;
    }
	
    public void setGenero(String genero){
        this.genero = genero;
    }
}
