package microservices.book.socialmultiplication.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGenerationServiceImpl implements RandomGenerationService {
    @Override
    public int generateRandomFactor() {
        return new Random().nextInt(91)+10;
    }
}
