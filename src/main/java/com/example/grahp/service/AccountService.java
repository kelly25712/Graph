package com.example.grahp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.grahp.model.Account;
import com.example.grahp.repository.AccountRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository repo;

	public List<Account> getAll() {
		return repo.findAll();
	}

	public List<Account> getAllPagination(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Account> accounts = repo.findAll(pageReq);
		return accounts.getContent();
	}

	public Account save(Account account) {
		return repo.save(account);
	}

	public Account getById(Integer idAccount) {
		return repo.findById(idAccount).get();
	}


	public void delete(Integer idAccount) {
		repo.deleteById(idAccount);
	}
	
	
}

