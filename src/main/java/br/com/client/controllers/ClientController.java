package br.com.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.client.models.Client;
import br.com.client.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/{username:.+}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody Client client, @PathVariable("username") String username) {
		if(clientService.findByCpf(client.getCpf(), client.getId()) == null){
			clientService.save(client, username);
		}else{
			throw new RuntimeException("Cliente já existente");
		}
	}
	
	@RequestMapping(value="/{username:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Client> get(@PathVariable("username") String username, @RequestParam("pag") int pag) {
		Sort sort = new Sort(new Sort.Order(Direction.ASC, "name"));
		Pageable pageable = new PageRequest(pag, 5, sort);
		return clientService.findByUser(username, pageable);
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Long id) {
		clientService.delete(id);
	}
	
	@RequestMapping(value="/findClient/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Client get(@PathVariable("id") Long id) {
		return clientService.findById(id);
	}

}
