package hexagonal_spring.webapp.web_account.application.port.out;

import hexagonal_spring.webapp.domain.Account;

public interface UpdateAccount {
	void updateAccount(Account account);

}
