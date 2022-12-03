package hexagonal_spring.webapp.web_account.adapter.in.kafka.withdraw;

import hexagonal_spring.webapp.web_account.application.dto.CommandBalanceDTO;
import hexagonal_spring.webapp.web_account.application.port.in.WithdrawUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WithdrawControllerKafka {
    private final WithdrawUseCase withdrawUseCase;

    @Autowired
    private KafkaTemplate<String, CommandBalanceDTO> kafkaTemplate;

    @PostMapping(path = "/kafka/account/withdraw/{id}/{amount}")
    void withdraw(@PathVariable int id, @PathVariable int amount) {
        ListenableFuture<SendResult<String, CommandBalanceDTO>> future =
                kafkaTemplate.send("withdraw-kafka", new CommandBalanceDTO(id, amount));

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, CommandBalanceDTO> result) {
                System.out.println("kafka success");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("kafka failed");
            }
        });
    }

    @KafkaListener(topics = "withdraw-kafka", groupId = "group1", containerFactory = "factory")
    void listener(CommandBalanceDTO data) {
        String result = withdrawUseCase.withdraw(data);
        System.out.println("kafka listener " + result);
    }
}
