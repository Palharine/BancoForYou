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
//Cria um construtor que vai usar todas as propriedades usadas aqui como argumentos
@AllArgsConstructor
//Não precisa de argumentos para o construtor, mas o construtor ta feito
@NoArgsConstructor
public class Usuarios{
	@Id
	protected ObjectId id;
	
	protected String name;
	
	//1: Gerente 2:Usuário Padrão e 3:Usuários menor de idade
	protected int nivel;
	
	protected int idade;

	protected double saldo;
	
	protected boolean contaPJ;
	
	protected String email;
	
	protected String genero;
	
	//public List<acoes> historico;
	
	
	
}
