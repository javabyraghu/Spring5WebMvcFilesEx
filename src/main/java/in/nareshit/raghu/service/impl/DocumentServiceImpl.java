package in.nareshit.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nareshit.raghu.dao.IDocumentDao;
import in.nareshit.raghu.model.Document;
import in.nareshit.raghu.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {
	
	@Autowired
	private IDocumentDao dao;

	@Transactional
	public void saveDocument(Document doc) {
		dao.saveDocument(doc);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getFileIdAndNames() {
		return dao.getFileIdAndNames();
	}
	
	@Transactional(readOnly = true)
	public Document getDocumentById(Integer id) {
		return dao.getDocumentById(id);
	}

}
