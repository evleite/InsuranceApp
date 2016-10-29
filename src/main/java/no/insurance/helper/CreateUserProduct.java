package no.insurance.helper;

import no.insurance.domain.Product;
import no.insurance.domain.User;
import no.insurance.repository.LetterRepository;
import no.insurance.repository.ProductRepository;
import no.insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by p on 29/10/2016.
 */
public class CreateUserProduct {
    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private ProductRepository _productRepository;

    @Autowired
    private LetterRepository _letterRepository;


    private Future<User> user;
    private Future<Product> product;

    public IdUserProduct createUserProduct(User u, Product p) {

        IdUserProduct idUserProduct = new IdUserProduct();
        try {
            user = createUser(u);
            product = createProduct(p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!(user.isDone() && product.isDone())) {
            try {
                idUserProduct.setUserid(user.get().getId());
                idUserProduct.setProductId(product.get().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return idUserProduct;
    }

    @Async
    private Future<User> createUser(User user) throws InterruptedException {
        User results = _userRepository.save(user);
        // Artificial delay of 2s for demonstration purposes
        Thread.sleep(2000L);
        return new AsyncResult<User>(results);
    }

    @Async
    private Future<Product> createProduct(Product product) throws InterruptedException {
        Product results = _productRepository.save(product);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<Product>(results);
    }




}
