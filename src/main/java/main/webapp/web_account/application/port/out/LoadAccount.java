package main.webapp.web_account.application.port.out;

import main.webapp.domain.Account;

public interface LoadAccount {
	Account loadAccount(int id);
}
