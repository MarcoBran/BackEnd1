package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "biglietto")
@Getter
@Setter


public class biglietto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TicketCode;
	private LocalDate dataEm = LocalDate.now();
	private LocalDate dataTim;
	private boolean val = false;
	
	public biglietto() {}
	
}
