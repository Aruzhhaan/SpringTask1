package kz.bitlab.SpringTask.controllers;

import kz.bitlab.SpringTask.objects.Item;
import kz.bitlab.SpringTask.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/item")
public class HomeController {
    @Autowired
    private ItemRepository itemRepository;
    @GetMapping(value="/add-item")
    public String openAddItem(){
        return "add-item";
    }
    @PostMapping(value="/add-item")
    public String addItemPost(@RequestParam(name="item-name") String name,
                              @RequestParam(name="item-description") String description,
                              @RequestParam(name="item-price") int price
    ){
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:home";
    }
    @GetMapping(value="/home")
    public String openHome(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "home";
    }
    @GetMapping(value="/details/{id}")
    public String openDetails(@PathVariable("id") Long id, Model model){
        Item item = itemRepository.findAllById(id);
        model.addAttribute("item",item);
        return "details";
    }
}

