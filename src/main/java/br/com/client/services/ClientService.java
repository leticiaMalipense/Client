package br.com.client.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.client.models.ApplicationUser;
import br.com.client.models.Client;
import br.com.client.repository.AddressRepository;
import br.com.client.repository.ClientRespository;
import br.com.client.repository.UserRepository;

@Service
public class ClientService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRespository clientRespository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Transactional
	public void save(Client client, String username){
		ApplicationUser user = userRepository.findByUsername(username);
		client.setApplicationUser(user);
		
		addressRepository.save(client.getAddress());
		clientRespository.save(client);
	}
	
	public Client findByNameAndCpf(String name, String cpf) {
		return clientRespository.findByNameAndCpf(name, cpf);
	}
	
	public Client findByCpf(String cpf, Long id) {
		return clientRespository.findByCpf(cpf, id);
	}
	
	
	@Transactional
	public void delete(Long id) {
		clientRespository.delete(id);
	}

	public Page<Client> findByUser(String username, Pageable pageable) {
		return clientRespository.findByUser(username, pageable);
	}

	public Client findById(Long id) {
		return clientRespository.findById(id);
	}

	public Client find(Long id) {
		return clientRespository.findById(id);
	}
}
