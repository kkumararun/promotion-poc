package com.bbby.poc.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbby.poc.dbservice.model.ShoppingCartItem;
import com.bbby.poc.dbservice.repository.ShoppingCartRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private ShoppingCartRepository quotesRepository;

    public DbServiceResource(ShoppingCartRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{productID}")
    public List<String> getQuotes(@PathVariable("productID") final String productID) {

        return getQuotesByUserName(productID);
    }

    /*@PostMapping("/add")
    public List<String> add(@RequestBody final ShoppingCart quotes) {

        quotes.getQuotes()
                .stream()
                .map(quote -> new ShoppingCartItem(quotes.getUserName(), quote))
                .forEach(quote -> quotesRepository.save(quote));
        return getQuotesByUserName(quotes.getUserName());
    }*/


    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("productID") final String productID) {

        List<ShoppingCartItem> quotes = quotesRepository.findByProductID(productID);
        quotesRepository.delete(quotes);

        return getQuotesByUserName(productID);
    }


    private List<String> getQuotesByUserName(@PathVariable("productID") String productID) {
        return quotesRepository.findByProductID(productID)
                .stream()
                .map(ShoppingCartItem::getProductName)
                .collect(Collectors.toList());
    }



}
