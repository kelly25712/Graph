package com.example.grahp.controller;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import com.example.grahp.dto.AccountDTO;
import com.example.grahp.model.Account;
import com.example.grahp.model.User;
import com.example.grahp.repository.UserRepository;
import com.example.grahp.service.AccountService;
import com.example.grahp.service.UserService;

@Controller
public class AccountController {
    @Autowired
	private AccountService service;
    
    private User User;

    @Autowired
    private UserService userService;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

    @QueryMapping
    public List<Account> getAll() {
        return service.getAll();
    }

    @QueryMapping
    public Account getById(@Argument Integer idAccount) {
        return service.getById(idAccount);
    }

 
        @MutationMapping
        public Account add(@Argument(value = "account") AccountDTO accountDTO) {
            // Verificar si el usuario existe antes de continuar
            Integer idUser = accountDTO.getIdUser();
            if (idUser == null) {
                idUser = 1;  // Asigna 1 si es nulo
            }
            
            // Verificar si el usuario existe
            if (!userRepository.existsById(idUser)) {
                throw new IllegalArgumentException("User with id " + idUser + " does not exist.");
            }
        
            // Crear una nueva instancia de la entidad Account
            Account account = new Account();
        
            // Asignar propiedades con las conversiones necesarias
            account.setAccountNumber(accountDTO.getAccountNumber().floatValue()); // Convertir long a Float
            account.setBalance(accountDTO.getBalance());
        
            // Buscar y asignar el objeto User si idUser en Account espera un User
            User user = userRepository.findById(idUser)
                    .orElseThrow(() -> new IllegalArgumentException("User not found")); 
            account.setIdUser(user); // Asignar objeto User
        
            account.setPointBBVA(accountDTO.getPointBBVA());
            account.setKeyAccount(accountDTO.getKeyAccount());
        
            // Guardar la cuenta utilizando el servicio correspondiente
            return service.save(account);
    }

	

    public Account convertToEntity(AccountDTO accountDTO) {
        ModelMapper modelMapper = new ModelMapper();
        
        // Configuración del mapeo de la relación idUser
        modelMapper.addMappings(new PropertyMap<AccountDTO, Account>() {
            @Override
            protected void configure() {
                // Mapea el ID de usuario de AccountDTO a un objeto User
                using(ctx -> userService.findUserById((Integer) ctx.getSource())).map(source.getIdUser(), destination.getIdUser());
            }
        });
    
        // Mapear el resto de las propiedades
        return modelMapper.map(accountDTO, Account.class);
    }
}