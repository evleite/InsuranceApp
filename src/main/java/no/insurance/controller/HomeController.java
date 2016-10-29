package no.insurance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by p on 20/10/2016.
 */
@RestController
public class HomeController {




    @RequestMapping("/")
    public String home() {

        return "Case insurance contract project for Spring Boot";

    }
/*
    @RequestMapping("/test")
    public String Insurance() {

        CreateUserProduct createUserProduct = new CreateUserProduct();

        //TODO: show form about user + product + submit
        UserProduct up = new UserProduct();

        //TODO: Create user, create product
        up.setFirstname("Pedro");
        up.setLastname("Alves");
        up.setEmail("pa@pa.no");
        up.setType(Insurance.CAR.getValue());
        up.setDescription("Information about my car");

        User user = new User(up.getFirstname(), up.getLastname(), up.getEmail());
        Product product = new Product(up.getType(), up.getDescription() );

        IdUserProduct idUserProduct = createUserProduct.createUserProduct(user, product);

        //TODO: send letter for user confirm

        up.setState(State.SEND.getValue());
        up.setPrice(5000.0);


        //TODO: User confirm
        up.setState(State.PAY.getValue());


        //Create: letter
        _letterRepository.save();


        //TODO: Insurance is active
        up.setState(State.ACTIVE.getValue());
        up.setProductId(idUserProduct.getProductId());
        _letterRepository.save();

        return "TODOS";
    }
*/
}