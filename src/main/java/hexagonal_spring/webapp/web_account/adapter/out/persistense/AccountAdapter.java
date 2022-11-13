package hexagonal_spring.webapp.web_account.adapter.out.persistense;

import hexagonal_spring.webapp.domain.Account;
import hexagonal_spring.webapp.web_account.application.port.out.LoadAccount;
import hexagonal_spring.webapp.web_account.application.port.out.UpdateAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Repository
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
