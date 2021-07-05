package service;

import dao.BookDetailsDAO;
import dao.InventoryDAO;
import dto.InventoryDetailsDto;
import entity.Inventory;
import exceptions.BookNotFoundException;
import exceptions.InventoryAlreadyExistsException;
import exceptions.InventoryNotFoundException;
import mapper.InventoryToInventoryDetailsDto;

public class InventoryServiceImpl implements InventoryService{
    private InventoryDAO inventoryDAO;
    private BookDetailsDAO bookDetailsDAO;

    public InventoryServiceImpl(InventoryDAO inventoryDAO, BookDetailsDAO bookDetailsDAO) {
        this.inventoryDAO = inventoryDAO;
        this.bookDetailsDAO = bookDetailsDAO;
    }

    @Override
    public InventoryDetailsDto getInventoryDetailById(long id) {
        Inventory inventory = inventoryDAO.findById(id);
        if(inventory == null) throw new InventoryNotFoundException("Inventory id is incorrect");
        return InventoryToInventoryDetailsDto.convert(inventory);
    }

    @Override
    public InventoryDetailsDto createInventoryDetail(long bookId, long quantity) {
        if(bookDetailsDAO.findById(bookId) == null) throw new BookNotFoundException("Book id is incorrect");
        if(inventoryDAO.findByBookId(bookId) != null)
            throw new InventoryAlreadyExistsException("The inventory of this book already exists");
        Inventory persist = new Inventory(bookDetailsDAO.findById(bookId), quantity);
        Inventory inventory = inventoryDAO.create(persist);
        return InventoryToInventoryDetailsDto.convert(inventory);
    }

    @Override
    public InventoryDetailsDto updateInventoryDetail(long id, long quantity) {
        inventoryDAO.update(new Inventory(id, quantity));
        return getInventoryDetailById(id);
    }

    @Override
    public void deleteInventoryDetailById(long id) {
        getInventoryDetailById(id);
        inventoryDAO.delete(id);
    }
}
