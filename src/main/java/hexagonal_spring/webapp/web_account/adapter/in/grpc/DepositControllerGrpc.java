package hexagonal_spring.webapp.web_account.adapter.in.grpc;

import hexagonal_spring.webapp.web_account.adapter.in.grpc.grpc_generated.DepositRequest;
import hexagonal_spring.webapp.web_account.adapter.in.grpc.grpc_generated.DepositResponse;
import hexagonal_spring.webapp.web_account.application.dto.CommandBalanceDTO;
import hexagonal_spring.webapp.web_account.application.port.in.DepositUseCase;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@GrpcService
class DepositControllerGrpc extends hexagonal_spring.webapp.web_account.adapter.in.grpc.grpc_generated.DepositControllerGrpc.DepositControllerImplBase {
    private final DepositUseCase depositUseCase;

    @Override
    public void deposit(DepositRequest request, StreamObserver<DepositResponse> responseObserver) {
        CommandBalanceDTO data = new CommandBalanceDTO(request.getId(), request.getAmount());
        String result = depositUseCase.deposit(data);

        DepositResponse response = DepositResponse.newBuilder().setResponse(result).build();

        //set the response object
        responseObserver.onNext(response);

        //mark process is completed
        responseObserver.onCompleted();
    }
}
