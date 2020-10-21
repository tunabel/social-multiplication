package microservices.book.socialmultiplication.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class MultiplicationResultAttempt {

    private final User user;
    private final Multiplication multiplication;
    private final long resultAttempt;

    public MultiplicationResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
    }
}
