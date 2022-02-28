package com.lakshay.work;


import com.lakshay.work.entity.User;
import com.lakshay.work.exception.SearchCriteria;
import com.lakshay.work.exception.UserSpecification;
import com.lakshay.work.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional

public class JPASpecificationsTest {


    public UserRepository repository;

    private User userJohn;
    private User userTom;

    @Before
    public void init() {
        userJohn = new User();
        userJohn.setFirstName("John");
        userJohn.setLastName("Doe");
        userJohn.setEmail("john@doe.com");
        userJohn.setAge(22);
        repository.save(userJohn);

        userTom = new User();
        userTom.setFirstName("Tom");
        userTom.setLastName("Doe");
        userTom.setEmail("tom@doe.com");
        userTom.setAge(26);
        repository.save(userTom);
    }


    @Test
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        UserSpecification spec =
                new UserSpecification(new SearchCriteria("lastName", ":", "doe"));

        List<User> results = repository.findAll(spec);

        assertTrue(results.contains(userJohn));
        assertTrue(results.contains(userTom));
    }
    @Test
    public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
        UserSpecification spec1 =
                new UserSpecification(new SearchCriteria("firstName", ":", "john"));
        UserSpecification spec2 =
                new UserSpecification(new SearchCriteria("lastName", ":", "doe"));

        List<User> results = repository.findAll(Specification.where(spec1).and(spec2));

        assertTrue(results.contains(userJohn));
        assertTrue(results.contains(not(userTom)));
    }
        @Test
        public void givenLastAndAge_whenGettingListOfUsers_thenCorrect () {
            UserSpecification spec1 =
                    new UserSpecification(new SearchCriteria("age", ">", "25"));
            UserSpecification spec2 =
                    new UserSpecification(new SearchCriteria("lastName", ":", "doe"));

            List<User> results =
                    repository.findAll(Specification.where(spec1).and(spec2));

            assertTrue(results.contains(userTom));
            assertTrue(results.contains(not(userJohn)));
        }
        @Test
        public void givenWrongFirstAndLast_whenGettingListOfUsers_thenCorrect () {
            UserSpecification spec1 =
                    new UserSpecification(new SearchCriteria("firstName", ":", "Adam"));
            UserSpecification spec2 =
                    new UserSpecification(new SearchCriteria("lastName", ":", "Fox"));

            List<User> results =
                    repository.findAll(Specification.where(spec1).and(spec2));

            assertTrue(results.contains(not(userJohn)));
            assertTrue(results.contains(not(userTom)));
        }
        @Test
        public void givenPartialFirst_whenGettingListOfUsers_thenCorrect () {
            UserSpecification spec =
                    new UserSpecification(new SearchCriteria("firstName", ":", "jo"));

            List<User> results = repository.findAll(spec);

            assertTrue(results.contains(userJohn));
            assertTrue(results.contains(not(userTom)));
        }
    }