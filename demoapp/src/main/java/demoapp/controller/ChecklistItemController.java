package demoapp.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demoapp.domain.ChecklistItem;
import demoapp.service.ChecklistItemService;

@Controller
@RequestMapping("/api/checklistitem")
public class ChecklistItemController{
	
	@Inject
	private ChecklistItemService checklistItemService;
	
	@RequestMapping(value={"/delete/{id}", "/delete/{id}/"}, method=RequestMethod.DELETE)
	public @ResponseBody boolean deleteChecklist(@PathVariable int id){
		return checklistItemService.deleteChecklist(id);
	}
	
	@RequestMapping(value={"/{id}", "/{id}/"}, method=RequestMethod.GET)
	public @ResponseBody ChecklistItem getChecklistItem(@PathVariable int id){
		return checklistItemService.getChecklistItemById(id);
	}
	
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public @ResponseBody List<ChecklistItem> getAllChecklistItems(@RequestParam(value="checklistId", defaultValue="0") Integer id){
		
		if(id!=0){
			return checklistItemService.getChecklistItemsForChecklist(id);
		}
		
		return checklistItemService.getAllChecklistItems();
	}
	
	@RequestMapping(value={"/post", "/post/"}, method=RequestMethod.POST)
	public @ResponseBody ChecklistItem createChecklist(@RequestBody ChecklistItem checklistItem){
		checklistItem.setLastModified(new Date());
		checklistItemService.saveChecklist(checklistItem);
		
		return checklistItem;
	}
	
	@RequestMapping(value={"/put/{id}", "/put/{id}/"}, method=RequestMethod.PUT)
	public @ResponseBody ChecklistItem updateChecklist(@PathVariable int id, @RequestBody ChecklistItem checklistItem){
		ChecklistItem model = checklistItemService.getChecklistItemById(id);
		
		if(model.getId() == null){
			return model;
		}
		
		if(checklistItem.getChecklistId() != null){
			model.setChecklistId(checklistItem.getChecklistId());
		}
		if(checklistItem.getName() != null){
			model.setName(checklistItem.getName());
		}
		
		model.setLastModified(new Date());
		checklistItemService.saveChecklist(model);
		
		return model;
	}

}
