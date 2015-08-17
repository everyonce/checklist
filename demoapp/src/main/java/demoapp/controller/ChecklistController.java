package demoapp.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demoapp.domain.Checklist;
import demoapp.service.ChecklistService;

@Controller
@RequestMapping("/api/checklist")
public class ChecklistController {

	@Inject
	private ChecklistService checklistService;
	
	@RequestMapping(value={"/delete/{id}", "/delete/{id}/"}, method=RequestMethod.DELETE)
	public @ResponseBody boolean deleteChecklist(@PathVariable int id){
		return checklistService.deleteChecklist(id);
	}
	
	@RequestMapping(value={"/{id}","/{id}/"}, method=RequestMethod.GET)
	public @ResponseBody Checklist getChecklist(@PathVariable int id){
		return checklistService.getChecklistById(id);
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public @ResponseBody List<Checklist> getAllChecklists(){
		return checklistService.getAllChecklists();
	}
	
	@RequestMapping(value={"/post","/post/"}, method=RequestMethod.POST)
	public @ResponseBody Checklist createChecklist(@RequestBody Checklist checklist){
		checklist.setLastModified(new Date());
		checklistService.saveChecklist(checklist);
		
		return checklist;
	}
	
	@RequestMapping(value={"/put/{id}","/put/{id}/"}, method=RequestMethod.PUT)
	public @ResponseBody Checklist updateChecklist(@PathVariable int id, @RequestBody Checklist checklist){
		
		Checklist model = checklistService.getChecklistById(id);
		model.setLastModified(new Date());
		
		if(checklist.getName() != null){
			model.setName(checklist.getName());
		}
		
		checklistService.saveChecklist(model);
		
		return model;
	}

}
