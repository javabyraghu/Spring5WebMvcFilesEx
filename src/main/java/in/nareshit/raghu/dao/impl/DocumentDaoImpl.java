package in.nareshit.raghu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nareshit.raghu.dao.IDocumentDao;
import in.nareshit.raghu.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;
	
	public void saveDocument(Document doc) {
		ht.save(doc);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> getFileIdAndNames() {
		String hql = "SELECT fileId, fileName FROM " + Document.class.getName(); 
		return (List<Object[]>) ht.find(hql);
	}
	
	public Document getDocumentById(Integer id) {
		return ht.get(Document.class, id);
	}

}
