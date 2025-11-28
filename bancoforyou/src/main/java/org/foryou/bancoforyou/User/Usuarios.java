package org.foryou.bancoforyou.User;

import java.math.BigDecimal;

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

	protected BigDecimal saldo;
	
	protected Boolean contaPJ;
	
	protected String email;
	
	protected String genero;
	
    protected String cpf;

    protected String cnpj;

    protected String nomeBanco;

	public Usuarios(){}

    public Usuarios(ObjectId id, String name, int nivel, int idade, BigDecimal saldo, boolean ContaPJ, String email, String genero, String cpf, String cnpj,String nomeBanco ){
        this.id = id;
        this.name = name;
        this.nivel = nivel;
        this.idade = idade;
        this.saldo = saldo;
        this.contaPJ = ContaPJ;
        this.email = email;
        this.genero = genero;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nomeBanco = nomeBanco;
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

    public BigDecimal getSaldo(){
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

    public String getCPF(){
        return cpf;
    }
    
    public String getCNPJ(){
        return cnpj;
    }

    public String getNomeBanco(){
        return nomeBanco;
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

    public void setCPF(String cpf){
       this.cpf = cpf;
    }
    
    public void setCNPJ(String cnpj){
        this.cnpj = cnpj;
    }

    public void setNomeBanco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }
    public void setSaldo(BigDecimal saldo){
        this.saldo = saldo;
    }
}
