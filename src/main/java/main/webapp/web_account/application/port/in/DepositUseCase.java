package main.webapp.web_account.application.port.in;

import main.webapp.web_account.application.dto.CommandBalanceDTO;

public interface DepositUseCase {
	String deposit(CommandBalanceDTO commandBalanceDTO);
}
