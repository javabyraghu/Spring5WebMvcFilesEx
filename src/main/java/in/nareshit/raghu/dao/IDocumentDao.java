package in.nareshit.raghu.dao;

import java.util.List;

import in.nareshit.raghu.model.Document;

public interface IDocumentDao {

	public void saveDocument(Document doc);
	public List<Object[]> getFileIdAndNames();
	
	public Document getDocumentById(Integer id);
}
