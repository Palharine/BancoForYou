package org.foryou.bancoforyou.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Mudar o mapping do site nessa parte
@RequestMapping("/conta")
//Serve para receber os métodos do repository, contendo a lógica de negócio da aplicação
@Service
public interface UserService{
	public void save(UserMinDTO userMinDTO);
	public List<UserMinDTO> findAll();
	public Optional<UserMinDTO> findUserByName(String name);
    public Optional<UserMinDTO> findById(ObjectId id);
    public void pagar(ObjectId paganteId, ObjectId receptanteId, String chave, BigDecimal valor);
    //public List<Transacoes> findAllTransacoes();
}
