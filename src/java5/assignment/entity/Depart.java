package java5.assignment.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Departs")
public class Depart {
	@Id
	@NotBlank(message = "Không để trống mã phòng ban!")
	private String id;
	@NotBlank(message = "Không để trống tên phòng ban!")
	private String name;
	
	@OneToMany(mappedBy = "depart", fetch =FetchType.EAGER )
	private Collection<Staff> staffs;
	public Depart() {
		
	}
	public Depart(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Collection<Staff> staffs) {
		this.staffs = staffs;
	}
	
}
