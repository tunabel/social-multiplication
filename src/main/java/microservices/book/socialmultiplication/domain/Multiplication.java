package microservices.book.socialmultiplication.domain;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
public final class Multiplication {

    private final int factorA;
    private final int factorB;

    private long result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = factorA * factorB;
    }

    public Multiplication() {
        this(0,0);
    }
}
