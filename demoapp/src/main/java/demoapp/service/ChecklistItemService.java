package demoapp.service;

import java.util.List;

import demoapp.domain.ChecklistItem;

public interface ChecklistItemService {
	public boolean deleteChecklist(int id);
	public void saveChecklist(ChecklistItem model);
	public ChecklistItem getChecklistItemById(int id);
	public List<ChecklistItem> getAllChecklistItems();
	public List<ChecklistItem> getChecklistItemsForChecklist(int id);
}
