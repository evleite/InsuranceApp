package no.insurance.controller;

import no.insurance.domain.Product;
import no.insurance.domain.Service;
import no.insurance.domain.User;
import no.insurance.repository.ProductRepository;
import no.insurance.repository.ServiceRepository;
import no.insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Created by p on 20/10/2016.
 */
@RestController
public class HomeController {

    @Autowired
    private ServiceRepository _serviceRepository;

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private ProductRepository _productRepository;


    @RequestMapping("/")
    public String home() {

        ImplementAllTransaction();

        return "Case insurance contract project for Spring Boot";
    }

    private void ImplementAllTransaction() {
        //TODO: create user and deal by user name if it do not exist in database
        Integer id = 1;
        long userid = id.longValue();
        long productid = id.longValue();
        //TODO: I will do later

        //TODO: Send to user for he/she pay it

        //TODO: Send to user that service is active after user paid it
        long serviceid = id.longValue();


        //Example how to wait for several request to send answer to user
        Future<User> user = null;
        Future<Product> product = null;
        Future<Service> service = null;

        try {
            user = findUser(userid);
            product = findProduct(productid);
            service = findService(serviceid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!(user.isDone() && product.isDone() && service.isDone())) {
            //Information available to send to user
            user.toString();
            service.toString();
            service.toString();
        }
    }

    @Async
    public Future<Product> findProduct(Long productid) throws InterruptedException {
        Product results = _productRepository.getOne(productid);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<Product>(results);
    }

    @Async
    public Future<User> findUser(Long userid) throws InterruptedException {
        User results = _userRepository.getOne(userid);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<User>(results);
    }


    @Async
    public Future<Service> findService(Long serviceid) throws InterruptedException {
        Service results = _serviceRepository.getOne(serviceid);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<Service>(results);
    }


}