package main.webapp.web_account.application.port.in;

import main.webapp.web_account.application.dto.CommandBalanceDTO;

public interface WithdrawUseCase {
    String withdraw(CommandBalanceDTO commandBalanceDTO);
}
