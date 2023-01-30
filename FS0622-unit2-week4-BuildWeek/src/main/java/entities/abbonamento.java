package entities;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enumm.emissione;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abbonamento")
@Getter
@Setter
@NoArgsConstructor

public class abbonamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCode;
	private boolean val = true;
	@Enumerated(EnumType.STRING)
	private emissione type;
	private LocalDate dataEm = LocalDate.now();
	private LocalDate dataScad;
	public abbonamento(emissione type) {
		super();
		this.type = type;
	}
	
	
}
