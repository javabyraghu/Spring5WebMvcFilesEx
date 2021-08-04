package in.nareshit.raghu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.nareshit.raghu.model.Document;
import in.nareshit.raghu.service.IDocumentService;

@Controller
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
	private IDocumentService service;

	//1. show Document page
	@GetMapping("/all")
	public String showDocs(Model model) {
		//TODO : send all uploads docs
		List<Object[]> list = service.getFileIdAndNames();
		model.addAttribute("list", list);
		return "Documents";
	}
	
	
	//2. upload doc
	@PostMapping("/upload")
	public String uploadDoc(
			@RequestParam Integer fileId,
			@RequestParam MultipartFile fileOb
			)
	{
		if(fileOb!=null) {
			Document doc = new Document();
			doc.setFileId(fileId);
			doc.setFileName(fileOb.getOriginalFilename());
			try {
				doc.setFileData(fileOb.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			service.saveDocument(doc);
		}
		return "redirect:all";
	}
	
	
	//3. download doc
	/**Do not goto any other page after download*/
	@GetMapping("/dowload")
	public void downloadDoc(
				@RequestParam("fileId") Integer id, //read param
				HttpServletResponse response
			) 
	{
		//call service
		Document doc = service.getDocumentById(id);
		
		//add header
		response.addHeader("Content-Disposition", "attachment;filename=" + doc.getFileName());
		
		// add Body(OS) //from, to
		try {
			FileCopyUtils.copy(doc.getFileData(), response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
