package microservices.book.socialmultiplication.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGenerationServiceImpl implements RandomGenerationService {


    final static int MIN_FACTOR = 11;
    final static int MAX_FACTOR = 99;


    @Override
    public int generateRandomFactor() {
        return new Random().nextInt((MAX_FACTOR - MIN_FACTOR) + 1) + MIN_FACTOR;
    }
}
