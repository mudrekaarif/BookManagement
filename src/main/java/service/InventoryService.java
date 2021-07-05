package service;

import dto.InventoryDetailsDto;

public interface InventoryService {

    public InventoryDetailsDto getInventoryDetailById(long id);

    public InventoryDetailsDto createInventoryDetail(long bookId, long quantity);

    public InventoryDetailsDto updateInventoryDetail(long id, long quantity);

    public void deleteInventoryDetailById(long id);

}
