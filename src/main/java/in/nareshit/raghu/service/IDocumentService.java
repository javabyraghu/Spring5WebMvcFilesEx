package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.model.Document;

public interface IDocumentService {

	public void saveDocument(Document doc);
	public List<Object[]> getFileIdAndNames();
	
	public Document getDocumentById(Integer id);
}
