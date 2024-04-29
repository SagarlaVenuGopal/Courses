package com.example.Project.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Service.ClientsService;
import com.example.Project.Util.ResponseStruture;
import com.example.Project.dto.Clients;
import com.example.Project.dto.Courses;

@RestController
public class ClientsController {

	@Autowired
	ClientsService clientsService;

	@PostMapping("/saveClient")
	public ResponseEntity<ResponseStruture<Clients>> saveClient(@RequestBody Clients clients) {
		return clientsService.saveClient(clients);
	}

	@GetMapping("/fetchClientById")
	public ResponseEntity<ResponseStruture<Clients>> fetchClientById(int id) {
		return clientsService.fetchClientsById(id);
	}

	@PutMapping("/addExistingCoursesToaddExistingClients")
	public Clients addExistingCoursesToaddExistingClients(int courseId, int clientId) {

		return clientsService.addExistingCoursesToaddExistingClients(courseId, clientId);

	}

	@PostMapping("/addNewCoursesToExistingClient")
	public Clients addNewCoursesToExistingClient(int clientId, @RequestBody Courses courses) {
		return clientsService.addNewCoursesToExistingClient(clientId, courses);
	}

//	@GetMapping("/searchClientsByNameAndActiveStatus")
//	public List<Clients> searchClientsByNameAndActiveStatus(String clientName, boolean isActive) {
//        return clientsService.searchClientsByNameAndActiveStatus(clientName, isActive);
//    }

	@GetMapping("/fetchByClientName")
	public ResponseEntity<ResponseStruture<Clients>> fetchByClientName(String ClientName) {

		return clientsService.fetchByclientName(ClientName);
	}

	@PutMapping("/addExistingCourseToaddExistingClients")
	public Clients addExistingCourseToaddExistingClients(@RequestParam String ClientName, int courseId) {

		return clientsService.addExistingCoursesToaddExistingClients(ClientName, courseId);

	}

	@GetMapping("/getClientByActiveState")
	public List<Clients> getClientByActiveState(){
		return clientsService.getAllUserDetails();
	}
	@PatchMapping("/inActive")
	public Clients inActive(int ClientId,@RequestBody Clients clients) {
       clients.setClientId(ClientId);
		return clientsService.inActive(ClientId, clients);
	}
}
