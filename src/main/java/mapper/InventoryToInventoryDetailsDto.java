package mapper;

import dto.InventoryDetailsDto;
import entity.Inventory;

public class InventoryToInventoryDetailsDto {
    public static InventoryDetailsDto convert(Inventory inventory) {
        if(inventory == null) return null;
        return new InventoryDetailsDto(inventory.getId(), inventory.getBookDetails().getId(), inventory.getBookDetails().getTitle(), inventory.getQuantity());
    }
}
