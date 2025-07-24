package fr.nromanzin.pwademo.service;

import fr.nromanzin.pwademo.domain.ItemBO;
import fr.nromanzin.pwademo.mapper.ItemMapper;
import fr.nromanzin.pwademo.repository.ItemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemBO> getItems() {
        List<ItemBO> items = new ArrayList<>();
        itemRepository.findAll().forEach(item -> items.add(itemMapper.fromEntity(item)));
        return items;
    }

    public void addItem(ItemBO item) {
        if (itemRepository.existsById(item.uuid())) {
            return;
        }
        itemRepository.save(itemMapper.toEntity(item));
    }

    public void removeItem(UUID uuid) {
        itemRepository.deleteById(uuid);
    }
}
