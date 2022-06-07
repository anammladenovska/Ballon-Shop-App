package mk.ukim.finki.wp.lab.service.impl;



import mk.ukim.finki.wp.lab.model.ShoppingCart;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.wp.lab.model.exceptions.BalloonAlreadyInShoppingCartException;
import mk.ukim.finki.wp.lab.model.exceptions.BalloonNotFoundException;
import mk.ukim.finki.wp.lab.model.exceptions.ShoppingCartNotFound;
import mk.ukim.finki.wp.lab.model.exceptions.UserNotFoundException;
import mk.ukim.finki.wp.lab.repository.jpa.ShoppingCartRepository;
import mk.ukim.finki.wp.lab.repository.jpa.UserRepository;
import mk.ukim.finki.wp.lab.service.ShoppingCartService;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final BalloonService balloonService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, BalloonService balloonService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.balloonService = balloonService;
    }
//
//    @Override
//    public List<Balloon> listAllBalloonsInShoppingCart(Long cartId) {
//        if(!this.shoppingCartRepository.findById(cartId).isPresent())
//            throw new ShoppingCartNotFound(cartId);
//        return this.shoppingCartRepository.findById(cartId).get().getBalloons();
//    }
//
//    @Override
//    public ShoppingCart getActiveShoppingCart(String username) {
//        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
//        ShoppingCart shoppingCart = new ShoppingCart(user);
//
//        return this.shoppingCartRepository.findByUserAndStatus(user, ShoppingCartStatus.CREATED )
//                .orElseGet(() -> {
//                    ShoppingCart cart = new ShoppingCart(user);
//                    return this.shoppingCartRepository.save(cart);
//                });
//
//    }
//
//    @Override
//    public ShoppingCart addBalloonToShoppingCart(String username, Long balloonId) {
//        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
//        Balloon balloon = this.balloonService.findById(balloonId).orElseThrow(() -> new UserNotFoundException(username));
//        if(shoppingCart.getBalloons().stream().filter(r->r.getId().equals(balloonId))
//                .collect(Collectors.toList()).size() > 0) throw new BalloonAlreadyInShoppingCartException(username,balloonId);
//        shoppingCart.getBalloons().add(balloon);
//        return this.shoppingCartRepository.save(shoppingCart);
//    }
}
