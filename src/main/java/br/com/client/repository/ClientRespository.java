package br.com.client.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.client.models.Client;

public interface ClientRespository extends CrudRepository<Client, Long>{
	Client findByNameAndCpf(String name, String cpf);
	
	@Query("select c from Client c join c.applicationUser a where c.cpf = :cpf and c.id <> :id ")
	Client findByCpf(@Param("cpf")String cpf ,@Param("id") Long id);
	
	@Query("select c from Client c join c.applicationUser a where a.username = :username ")
	Page<Client> findByUser(@Param("username") String username, Pageable pageable);
	
	void delete(Long id);

	Client findById(Long id);

}
