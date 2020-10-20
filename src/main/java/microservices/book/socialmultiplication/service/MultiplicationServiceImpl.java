package microservices.book.socialmultiplication.service;

import microservices.book.socialmultiplication.domain.Multiplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    @Autowired
    private RandomGenerationService randomGenerationService;

    @Override
    public Multiplication createRandomMultiplication() {

        int factorA = randomGenerationService.generateRandomFactor();
        int factorB = randomGenerationService.generateRandomFactor();

        return new Multiplication(factorA, factorB);
    }
}
