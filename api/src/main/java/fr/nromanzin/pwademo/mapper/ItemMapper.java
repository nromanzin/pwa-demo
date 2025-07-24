package fr.nromanzin.pwademo.mapper;

import fr.nromanzin.pwademo.controller.dto.CreateItemDTO;
import fr.nromanzin.pwademo.controller.dto.GetItemDTO;
import fr.nromanzin.pwademo.domain.ItemBO;
import fr.nromanzin.pwademo.repository.entity.Item;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemMapper {
    public ItemBO fromGetItemDto(GetItemDTO dto) {
        return new ItemBO(
                UUID.fromString(dto.getUuid()),
                dto.getName(),
                dto.getQuantity());
    }

    public ItemBO fromCreateItemDTO(CreateItemDTO dto) {
        return new ItemBO(
                UUID.randomUUID(),
                dto.getName(),
                dto.getQuantity()
        );
    }

    public GetItemDTO toGetItemDto(ItemBO item) {
        GetItemDTO dto = new GetItemDTO();
        dto.setUuid(item.uuid().toString());
        dto.setName(item.name());
        dto.setQuantity(item.quantity());
        return dto;
    }

    public Item toEntity(ItemBO bo) {
        return new Item(bo.name(), bo.quantity());
    }

    public ItemBO fromEntity(Item item) {
        return new ItemBO(item.getUuid(), item.getName(), item.getQuantity());
    }
}
