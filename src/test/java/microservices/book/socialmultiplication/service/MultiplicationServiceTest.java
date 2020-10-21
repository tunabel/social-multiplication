package microservices.book.socialmultiplication.service;

import microservices.book.socialmultiplication.domain.Multiplication;
import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class MultiplicationServiceTest {

    @Mock
    private RandomGenerationService randomGenerationService;

    @InjectMocks
    private MultiplicationService multiplicationService = new MultiplicationServiceImpl();

    @Test
    public void createRandomMultiplicationTest() {
        // given generator service will return 50 first, and then 40
        given(randomGenerationService.generateRandomFactor()).willReturn(50, 40);

        // when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        // then:
        assertEquals(50, multiplication.getFactorA());
        assertEquals(40, multiplication.getFactorB());
        assertEquals(2000, multiplication.getResult());
    }

    @Test
    public void checkResultAttempt_shouldBeTrueIfCorrect() {
        // given
        Multiplication multiplication = new Multiplication(40,50);
        User user = new User("Tuan");
        MultiplicationResultAttempt correctAttempt = new MultiplicationResultAttempt(user, multiplication, 2000);

        // when
        boolean resultAttempt = multiplicationService.checkResultAttempt(correctAttempt);

        // then
        assertThat(resultAttempt).isTrue();
    }

    @Test
    public void checkResultAttempt_shouldBeFalseIfIncorrect() {
        // given
        Multiplication multiplication = new Multiplication(40,50);
        User user = new User("Tuan");
        MultiplicationResultAttempt correctAttempt = new MultiplicationResultAttempt(user, multiplication, 10000);

        // when
        boolean resultAttempt = multiplicationService.checkResultAttempt(correctAttempt);

        // then
        assertThat(resultAttempt).isFalse();
    }

}