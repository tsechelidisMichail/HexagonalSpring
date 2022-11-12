package main.webapp.web_account.adapter.in.web;

import lombok.RequiredArgsConstructor;
import main.webapp.web_account.application.dto.CommandBalanceDTO;
import main.webapp.web_account.application.port.in.DepositUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Component
class DepositController {
	private final DepositUseCase depositUseCase;

	@PostMapping(path = "/account/deposit/{id}/{amount}")
	String deposit(@PathVariable int id, @PathVariable int amount) {
		CommandBalanceDTO data = new CommandBalanceDTO(id, amount);
		return depositUseCase.deposit(data);
	}
}
