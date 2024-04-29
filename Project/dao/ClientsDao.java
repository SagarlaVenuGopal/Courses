package com.example.Project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Project.dto.Clients;
import com.example.Project.dto.Courses;
import com.example.Project.repo.ClientsRepo;


@Repository
public class ClientsDao {

	@Autowired
	ClientsRepo clientsRepo;

	@Autowired
	CoursesDao coursesDao;

	public Clients saveClient(Clients clients) {
		return clientsRepo.save(clients);
	}

	public Clients fetchClientsById(int id) {
		Optional<Clients> optional = clientsRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}
	

	public Clients addExistingCoursesToExistingClients(int CourseId, int ClientId) {

		Courses courses = coursesDao.fetchCoursesById(CourseId);
		Clients clients = fetchClientsById(ClientId);
		clients.getCourses().add(courses);
		return saveClient(clients);
	}

	public Clients addNewCoursesToExistingClient(int clientId, Courses courses) {

		Clients clients = fetchClientsById(clientId);

		clients.getCourses().add(courses);
		return saveClient(clients);
	}
	
//    public List<Clients> searchClientsByNameAndActiveStatus(String clientName, boolean isActive) {
//        return clientsRepo.findByNameAndActive(clientName, isActive);
//    }

	
	public  Clients fetchByClientName(String ClientName) {
		
		 Optional<Clients> optional=clientsRepo.findByName(ClientName);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 else {
			return null;
		}

	}
	
	public Clients addExistingCoursesToaddExistingClients(String ClientName,int courseId) {

		Courses courses=coursesDao.fetchCoursesById(courseId);
		Clients clients  = fetchByClientName(ClientName);
		clients.getCourses().add(courses);

		return  saveClient(clients);

	}
	

	public List<Clients> FindAll(){
		List<Clients>AllActives=new ArrayList<Clients>();
		List<Clients>list= clientsRepo.findAll();
		for(Clients clients:list) {
			if((clients.isActive()?1:0)==0)
				AllActives.add(clients);
		}
		return AllActives;
//		return clientsRepo.findAll();
	}
	
	public Clients inActive(int ClientId,Clients clients) {
		
		Clients clients2=fetchClientsById(ClientId);
		
		clients2.setActive(clients.isActive());
		
//		clients2.setClientEmail(clients.getClientEmail());
		
		return clientsRepo.save(clients2);
		
		
	}
	


	

}
