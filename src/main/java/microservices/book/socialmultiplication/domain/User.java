package microservices.book.socialmultiplication.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class User {
    private final String alias;

    protected User() {
        alias = null;
    }
}
