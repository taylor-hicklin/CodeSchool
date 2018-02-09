package service;

import dao.VendingMachineDao;
import dao.VendingMachinePersistenceException;
import dto.VendingMachineChange;
import dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineDao dao;
    private VendingMachineChange remainingChange;
    private BigDecimal remainingMoney = new BigDecimal("0");

    public VendingMachineServiceLayerImpl(VendingMachineDao dao){
        this.dao = dao;
    }

    @Override
    public List<VendingMachineItem> retrieveAllVendingMachineItems() throws VendingMachinePersistenceException {
        return dao.retrieveAllVendingMachineItems();
    }

    @Override
    public BigDecimal addMoneyToMemory(BigDecimal amount) {
        remainingMoney = remainingMoney.add(amount);
        return remainingMoney;
    }

    @Override
    public VendingMachineItem purchaseItem(String itemId) {
        return null;
    }

    @Override
    public VendingMachineChange convertDollarsToChange() {
        return null;
    }

    @Override
    public BigDecimal retrieveRemainingMoney() {
        return remainingMoney;
    }

    private void validateItemChoice(String itemId){

    }

    private void validateFunds(VendingMachineItem item){

    }

    private void resetRemainingMoneyToZero(){

    }

    private BigDecimal updateMoneyAmountInMemory(BigDecimal amount){
        return null;
    }

    private void updateItemQuantity(int quantity){

    }
}
