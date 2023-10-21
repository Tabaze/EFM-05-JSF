package com.crjj.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.service.spi.InjectService;

import com.crjj.dao.DaoModule;
import com.crjj.dao.IDAO;
import com.crjj.model.Module;

@ManagedBean
@SessionScoped
public class ModuleBean {

	IDAO<Module> serviceModule = new DaoModule();

	private List<Module> modules;
	private String titre;
	private String nb;
	private String fil;

	@PostConstruct
	public void init() {
		modules = serviceModule.getAll();
	}

	public List<Module> getCustomers() {
		return modules;
	}

	public void add() {
		Module module = new Module(0, titre, nb, fil);
		if(serviceModule.save(module)) {
			addSuccessMessage(new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucess","Ajouter Avec Success"));
		}
		else {
			addSuccessMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error"));
		}
	}
	
	 public void addSuccessMessage(FacesMessage messageType) {
	        FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, messageType);
	    }
}
