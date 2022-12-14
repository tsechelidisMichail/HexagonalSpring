package hexagonal_spring.webapp.web_account.adapter.out.persistense;

import hexagonal_spring.webapp.domain.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
class AccountJpaEntity {

	@Version
	@GeneratedValue
	private Integer version;

	@Id
	@GeneratedValue
	private int id;

	@Column
	private int balance;

	public AccountJpaEntity update(Account accountUpdated) {
		this.balance = accountUpdated.getBalance();
		this.id = accountUpdated.getId();
		return this;
	}
}
