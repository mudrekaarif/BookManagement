package resources;

import dto.InventoryDetailsDto;
import dto.MessageDto;
import entity.Inventory;
import io.dropwizard.hibernate.UnitOfWork;
import service.InventoryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
public class InventoryResource {
    private InventoryService inventoryService;

    public InventoryResource(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GET
    @UnitOfWork
    public InventoryDetailsDto getInventoryDetailsById(@QueryParam("id") long id) {
        return inventoryService.getInventoryDetailById(id);
    }

    @POST
    @UnitOfWork
    public InventoryDetailsDto createNewInventory(InventoryDetailsDto inventoryDetailsDto) {
        return inventoryService.createInventoryDetail(inventoryDetailsDto.getBookId(), inventoryDetailsDto.getQuantity());
    }

    @PUT
    @UnitOfWork
    public InventoryDetailsDto updateInventoryById(@QueryParam("id") long id, InventoryDetailsDto inventoryDetailsDto) {
        return inventoryService.updateInventoryDetail(id, inventoryDetailsDto.getQuantity());
    }

    @DELETE
    @UnitOfWork
    public MessageDto deleteInventoryDetailsById(@QueryParam("id") long id) {
        inventoryService.deleteInventoryDetailById(id);
        return new MessageDto("Successfully deleted");
    }
}
