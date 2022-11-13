package hexagonal_spring.webapp.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {

	@NotNull
	private int id;

	@NotNull
	private int balance;

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
