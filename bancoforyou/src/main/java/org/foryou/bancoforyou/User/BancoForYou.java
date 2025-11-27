package org.foryou.bancoforyou.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BancoForYou{
	
	public static void main(String[] args) {
		SpringApplication.run(BancoForYou.class, args);}
			//O GetMapping não pode estar dentro do main
			@GetMapping("/root")
			public String apiRoot(){
				return "Hello World";
	}
}
//To do: Criar usuários dentro do mongodb para testar
//to Do: Criar um banco SQL para criar as realões de transições
//To do: Criar páginas especificas para tipos de niveis
//To do: Criar limitações para que crianças não consigam usar as transições sem ser autorizadas pelos pais ou resposáveis
//To do: Criar um chat com a IA para que ela consiga auxiliar o usuário com uma decisão de investimento dentro do /investimentos
//To do: Criar o Front-End
//To do: Controle de gastos
//To do: Extratos claros e inteligivel
//To do: Pix,pagamentos, cashback ou recarga

