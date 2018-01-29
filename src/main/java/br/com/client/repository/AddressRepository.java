package br.com.client.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.client.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{

}
