package org.foryou.bancoforyou.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;


public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    
    @Override
    public void save(UserMinDTO userMinDTO){
        
    }
	public List<UserMinDTO> findAll(){
        List<UserMinDTO> result = userRepository.findAll();
        return result;
    }
	public Optional<UserMinDTO> findUserByName(String name){
        if(name == null){
            ResourceNotFoundException("Infelizmente não encontramos essa conta!");
        }
        return userRepository.findUserByName(name);
    }
    
    public Optional<UserMinDTO> findById(ObjectId id){
        Optional<UserMinDTO> result = userRepository.findById(id);
        return result;
    }
    
    @Transactional
    public void pagar(ObjectId paganteId, ObjectId receptanteId, String chave, BigDecimal valor){

        Usuarios pagante = new Usuarios();

        Usuarios receptante = new Usuarios();


        if(chave == receptante.getCPF()){
            throw new ResourceNotFoundException("Não encontramos essa pessoa");
        }

        if (pagante.getSaldo().compareTo(valor) < 0) {
            throw new IllegalStateException("Saldo insuficiente!");
        }

        
        pagante.setSaldo(pagante.getSaldo().subtract(valor));
        
        receptante.setSaldo(receptante.getSaldo().add(valor));
        
        UserMinDTO paganteDTO = new UserMinDTO(pagante);
        UserMinDTO receptanteDTO = new UserMinDTO(receptante);
        
        userRepository.save(paganteDTO);
        userRepository.save(receptanteDTO);
        
    }
    
}
