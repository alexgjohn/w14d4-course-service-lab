package com.example.CourseService.others;

import com.example.CourseService.models.Booking;
import com.example.CourseService.models.Course;
import com.example.CourseService.models.Customer;
import com.example.CourseService.models.StarRating;
import com.example.CourseService.repositories.BookingRepository;
import com.example.CourseService.repositories.CourseRepository;
import com.example.CourseService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        bookingRepository.deleteAll();
        customerRepository.deleteAll();
        courseRepository.deleteAll();

        Course course1 = new Course("Maths 101", "Edinburgh", StarRating.FIVE);
        courseRepository.save(course1);

        Course course2 = new Course("Science", "Glasgow", StarRating.THREE);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Ben Bendington", "Edinburgh", 28);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Janet Janitor", "Glasgow", 43);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("17-07-23", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("04-08-23", course2, customer2);
        bookingRepository.save(booking2);
    }
}
