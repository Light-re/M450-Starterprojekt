package ch.wiss.m450.starter_project.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(), false)
                .toList();
    }

    public Item addItem(String name) {
        Item item = new Item(name);
        return itemRepository.save(item);
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }

    public boolean itemExists(int id) {
        return itemRepository.existsById(id);
    }
}