package main.webapp.web_account.application.service;

import lombok.RequiredArgsConstructor;
import main.webapp.web_account.application.dto.CommandBalanceDTO;
import main.webapp.web_account.application.port.in.DepositUseCase;
import main.webapp.web_account.application.port.out.LoadAccount;
import main.webapp.web_account.application.port.out.UpdateAccount;
import main.webapp.domain.Account;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Component
class DepositService implements DepositUseCase{
	private final LoadAccount loadAccount;
	private final UpdateAccount updateAccount;

	@Override
	public String deposit(CommandBalanceDTO data) {
		int money = data.getBalance();
		int id = data.getId();
		
		Account account = loadAccount.loadAccount(id);

		if (account.deposit(money)) {
			updateAccount.updateAccount(account);
			int balanceResult = account.getBalance();
			return "Success! " + balanceResult;
		}
		return "failed";
	}

}
