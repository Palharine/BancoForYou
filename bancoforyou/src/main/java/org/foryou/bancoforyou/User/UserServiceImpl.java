package org.foryou.bancoforyou.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


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

    //public List<Transacoes> findAllTransacoes(){}
}
