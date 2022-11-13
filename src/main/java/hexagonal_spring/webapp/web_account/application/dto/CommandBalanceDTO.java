package hexagonal_spring.webapp.web_account.application.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommandBalanceDTO {

	/*
		Must reflect the Controller pathing, due to @RequiredArgs - from top to bottom id->balance.
	 */
	@NotNull
	private final int id;

	@NotNull
	private final int balance;

}
