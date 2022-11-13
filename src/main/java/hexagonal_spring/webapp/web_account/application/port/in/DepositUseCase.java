package hexagonal_spring.webapp.web_account.application.port.in;

import hexagonal_spring.webapp.web_account.application.dto.CommandBalanceDTO;

public interface DepositUseCase {
	String deposit(CommandBalanceDTO commandBalanceDTO);
}
