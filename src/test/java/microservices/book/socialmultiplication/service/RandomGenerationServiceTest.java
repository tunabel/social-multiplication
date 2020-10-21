package microservices.book.socialmultiplication.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RandomGenerationServiceTest {

    @InjectMocks
    RandomGenerationService randomGenerationService = new RandomGenerationServiceImpl();

    @Test
    public void generateRandomFactor_IsBetweenExpectedLimits() {

        //when a considerable sample of randomly generated factors is created
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> randomGenerationService.generateRandomFactor())
                .boxed()
                .collect(Collectors.toList());

        //then all of the factors should be between 11 and 100

        assertThat(randomFactors).containsAll(IntStream.range(11,100).boxed().collect(Collectors.toList()));
    }



}