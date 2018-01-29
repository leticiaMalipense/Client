package br.com.client.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.client.models.ApplicationUser;

public interface UserRepository extends CrudRepository<ApplicationUser, Long>{
	 ApplicationUser findByUsername(String username);
}
