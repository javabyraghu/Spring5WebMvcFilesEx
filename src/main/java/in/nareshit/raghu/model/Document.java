package in.nareshit.raghu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doctab")
public class Document {
	
	@Id
	@Column(name="fid")
	private Integer fileId;
	@Column(name="fname")
	private String fileName;
	
	@Lob // BLOB = byte[] + @Lob
	@Column(name="fdata")
	private byte[] fileData;
}
