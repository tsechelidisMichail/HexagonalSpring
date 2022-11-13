package hexagonal_spring.webapp.web_account.application.service;

import hexagonal_spring.webapp.domain.Account;
import hexagonal_spring.webapp.web_account.application.dto.CommandBalanceDTO;
import hexagonal_spring.webapp.web_account.application.port.in.DepositUseCase;
import hexagonal_spring.webapp.web_account.application.port.out.LoadAccount;
import hexagonal_spring.webapp.web_account.application.port.out.UpdateAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
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
