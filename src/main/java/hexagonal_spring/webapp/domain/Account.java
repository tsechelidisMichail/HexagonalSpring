package hexagonal_spring.webapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class Account {

	@NotNull
	private Integer id;

	@NotNull
	private Integer balance;

	public boolean deposit(int data) {
		if(data>0) {
			balance += data;
			return true;
		}
		return false;
	}
	
	public boolean withdraw(int data) {
		if(data>=0 && data<=balance) {
			balance -= data;
			return true;
		}
		return false;
	}

}
