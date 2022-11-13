package hexagonal_spring.webapp.web_account.application.port.out;

import hexagonal_spring.webapp.domain.Account;

public interface LoadAccount {
	Account loadAccount(int id);
}
