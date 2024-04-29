package com.example.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Project.Util.ResponseStruture;
import com.example.Project.dao.ClientsDao;
import com.example.Project.dto.Clients;
import com.example.Project.dto.Courses;
import com.example.Project.exception.ClientsIdNotFound;
import com.example.Project.repo.ClientsRepo;

@Service
public class ClientsService {

	@Autowired
	ClientsDao clientsDao;

	@Autowired
	ClientsRepo clientsRepo;

	public ResponseEntity<ResponseStruture<Clients>> saveClient(Clients clients) {

		ResponseStruture<Clients> responseStruture = new ResponseStruture<Clients>();
		responseStruture.setStatus(HttpStatus.CREATED.value());

		responseStruture.setMesaage("Succesfully Clients inserted into DB");

		responseStruture.setData(clientsDao.saveClient(clients));

		return new ResponseEntity<ResponseStruture<Clients>>(responseStruture, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStruture<Clients>> fetchClientsById(int id) {

		Clients clients = clientsDao.fetchClientsById(id);
		if (clients != null) {
			ResponseStruture<Clients> responseStruture = new ResponseStruture<Clients>();

			responseStruture.setStatus(HttpStatus.FOUND.value());

			responseStruture.setMesaage("Succesfully Clients fetched from DB");

			responseStruture.setData(clientsDao.fetchClientsById(id));

			return new ResponseEntity<ResponseStruture<Clients>>(responseStruture, HttpStatus.FOUND);
		} else {
			throw new ClientsIdNotFound();
		}

	}

	public Clients addExistingCoursesToaddExistingClients(int courseId, int clientId) {

		return clientsDao.addExistingCoursesToExistingClients(courseId, clientId);

	}

	public Clients addNewCoursesToExistingClient(int clientId, Courses courses) {
		return clientsDao.addNewCoursesToExistingClient(clientId, courses);
	}

	public ResponseEntity<ResponseStruture<Clients>> fetchByclientName(String clientName) {
		Clients clients = clientsDao.fetchByClientName(clientName);
		if (clients != null) {
			ResponseStruture<Clients> responseStruture = new ResponseStruture<Clients>();

			responseStruture.setStatus(HttpStatus.FOUND.value());

			responseStruture.setMesaage("Succesfully Clients fetched from DB");

			responseStruture.setData(clientsDao.fetchByClientName(clientName));

			return new ResponseEntity<ResponseStruture<Clients>>(responseStruture, HttpStatus.FOUND);
		} else {
			throw new ClientsIdNotFound();
		}

	}

	public Clients addExistingCoursesToaddExistingClients(String ClientName, int courseId) {

		return clientsDao.addExistingCoursesToaddExistingClients(ClientName, courseId);

	}

	public List<Clients> getAllUserDetails() {
		return clientsDao.FindAll();
	}

	public Clients inActive(int ClientId, Clients clients) {

		return clientsDao.inActive(ClientId, clients);
	}

}
