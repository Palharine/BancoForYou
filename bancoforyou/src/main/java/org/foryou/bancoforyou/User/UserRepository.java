package org.foryou.bancoforyou.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;

@Repository
//Serve para realizar operações no banco de dados, servindo como um DAO, sempre vai extender um repositório, sendo do JPA ou do banco de dados selecionado, herdando as operações CRUD	
public interface UserRepository extends MongoRepository<UserMinDTO,ObjectId>{
	
	Optional<UserMinDTO> findUserByName(String name);
}
