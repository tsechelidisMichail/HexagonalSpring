package hexagonal_spring.webapp.web_account.adapter.in.rest;

import hexagonal_spring.webapp.web_account.application.dto.CommandBalanceDTO;
import hexagonal_spring.webapp.web_account.application.port.in.DepositUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class DepositController {
	private final DepositUseCase depositUseCase;

	@PostMapping(path = "/account/deposit/{id}/{amount}")
	String deposit(@PathVariable int id, @PathVariable int amount) {
		CommandBalanceDTO data = new CommandBalanceDTO(id, amount);
		return depositUseCase.deposit(data);
	}
}
