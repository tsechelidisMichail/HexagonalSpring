package hexagonal_spring.webapp.web_account.adapter.in.grpc;

import hexagonal_spring.webapp.web_account.adapter.in.grpc.grpc_generated.WithdrawRequest;
import hexagonal_spring.webapp.web_account.adapter.in.grpc.grpc_generated.WithdrawResponse;
import hexagonal_spring.webapp.web_account.application.dto.CommandBalanceDTO;
import hexagonal_spring.webapp.web_account.application.port.in.WithdrawUseCase;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@GrpcService
class WithdrawControllerGrpc extends hexagonal_spring.webapp.web_account.adapter.in.grpc.grpc_generated.WithdrawControllerGrpc.WithdrawControllerImplBase {
    private final WithdrawUseCase withdrawUseCase;

    @Override
    public void withdraw(WithdrawRequest request, StreamObserver<WithdrawResponse> responseObserver) {
        CommandBalanceDTO data = new CommandBalanceDTO(request.getId(), request.getAmount());
        String result = withdrawUseCase.withdraw(data);

        WithdrawResponse response = WithdrawResponse.newBuilder().setResponse(result).build();

        //set the response object
        responseObserver.onNext(response);

        //mark process is completed
        responseObserver.onCompleted();
    }
}
