package fr.nromanzin.pwademo.controller;

import fr.nromanzin.pwademo.controller.dto.CreateItemDTO;
import fr.nromanzin.pwademo.controller.dto.GetItemDTO;
import fr.nromanzin.pwademo.mapper.ItemMapper;
import fr.nromanzin.pwademo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ItemMapper itemMapper;
    @GetMapping
    public List<GetItemDTO> getAll() {
        return itemService.getItems().stream()
                .map(itemMapper::toGetItemDto)
                .toList();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody CreateItemDTO item) {
        itemService.addItem(itemMapper.fromCreateItemDTO(item));
    }
    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("uuid") String uuid) {
        itemService.removeItem(UUID.fromString(uuid));
    }
}
