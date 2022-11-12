package main.webapp.web_account.adapter.out.persistense;

import lombok.RequiredArgsConstructor;
import main.webapp.web_account.application.port.out.LoadAccount;
import main.webapp.web_account.application.port.out.UpdateAccount;
import main.webapp.domain.Account;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
class AccountAdapter implements LoadAccount, UpdateAccount{
	private final AccountJpaRepository accountJpaRepository;
	
	@Override
	public Account loadAccount(int id) {
		AccountJpaEntity account = accountJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		return new Account(account.getId(), account.getBalance());
	}

	@Override
	public void updateAccount(Account account) {
		accountJpaRepository.save(new AccountJpaEntity(account.getId(), account.getBalance()));
	}
	
}
