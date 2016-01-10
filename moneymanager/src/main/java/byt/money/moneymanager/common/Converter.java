package byt.money.moneymanager.common;

import byt.money.moneymanager.model.Event;
import byt.money.moneymanager.entity.Deposit;
import byt.money.moneymanager.entity.Expense;
import byt.money.moneymanager.entity.IEntity;
import byt.money.moneymanager.entity.Inflow;
import byt.money.moneymanager.entity.Person;
import byt.money.moneymanager.model.EventModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class Converter {

    private Converter() {
    }

    public static IEntity convert(EventModel eventModel, Event event) {
        IEntity result;
        switch (event) {
            case DEPOSIT:
                result = convert(eventModel);
                break;
            case EXPENSES:
                result = convertToExpense(eventModel);
                break;
            case INFLOW:
                result = convertToInflow(eventModel);
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }

    public static <T extends IEntity> List<EventModel> convert(List<T> entities, Event event) {
        List<EventModel> result = new ArrayList<>();
        for (T entity : entities) {
            EventModel model = convert(entity, event);
            result.add(model);
        }
        return result;
    }

    private static Deposit convert(EventModel model) {
        BigDecimal amount = (BigDecimal) model.getValue(EventModel.Key.AMOUNT);
        Date date = (Date) model.getValue(EventModel.Key.DATE);
        int duration = (int) model.getValue(EventModel.Key.DURATION);
        BigDecimal interest = (BigDecimal) model.getValue(EventModel.Key.INTEREST);
        Person person = (Person) model.getValue(EventModel.Key.PERSON);
        Deposit result = new Deposit();
        result.setAmount(amount);
        if (date != null) {
            result.setDate(convert(date));
        }
        result.setDuration(duration);
        result.setInterest(interest);
        result.setPersonId(person);
        return result;
    }

    private static Inflow convertToInflow(EventModel model) {
        BigDecimal amount = (BigDecimal) model.getValue(EventModel.Key.AMOUNT);
        Date date = (Date) model.getValue(EventModel.Key.DATE);
        String name = (String) model.getValue(EventModel.Key.NAME);
        String details = (String) model.getValue(EventModel.Key.DETAILS);
        Person person = (Person) model.getValue(EventModel.Key.PERSON);
        Inflow result = new Inflow();
        result.setAmount(amount);
        if (date != null) {
            result.setDate(convert(date));
        }
        result.setName(name);
        result.setDetails(details);
        result.setPerson(person);
        return result;
    }

    private static Expense convertToExpense(EventModel model) {
        BigDecimal amount = (BigDecimal) model.getValue(EventModel.Key.AMOUNT);
        Date date = (Date) model.getValue(EventModel.Key.DATE);
        String name = (String) model.getValue(EventModel.Key.NAME);
        String details = (String) model.getValue(EventModel.Key.DETAILS);
        Person person = (Person) model.getValue(EventModel.Key.PERSON);
        Expense result = new Expense();
        result.setAmount(amount);
        if (date != null) {
            result.setDate(convert(date));
        }
        result.setName(name);
        result.setDetails(details);
        result.setPerson(person);
        return result;
    }

    private static EventModel convert(Inflow entity) {
        Event event = Event.INFLOW;
        long id = entity.getId();
        BigDecimal amount = entity.getAmount();
        Date date = convert(entity.getDate());
        String name = entity.getName();
        String details = entity.getDetails();
        EventModel result = new EventModel();
        result.setData(EventModel.Key.EVENT, event);
        result.setData(EventModel.Key.AMOUNT, amount);
        result.setData(EventModel.Key.DATE, date);
        result.setData(EventModel.Key.NAME, name);
        result.setData(EventModel.Key.DETAILS, details);
        result.setData(EventModel.Key.ID, id);
        return result;
    }

    private static EventModel convert(Expense entity) {
        Event event = Event.EXPENSES;
        long id = entity.getId();
        BigDecimal amount = entity.getAmount();
        Date date = convert(entity.getDateExpense());
        String name = entity.getName();
        String details = entity.getDetails();
        EventModel result = new EventModel();
        result.setData(EventModel.Key.EVENT, event);
        result.setData(EventModel.Key.AMOUNT, amount);
        result.setData(EventModel.Key.DATE, date);
        result.setData(EventModel.Key.NAME, name);
        result.setData(EventModel.Key.DETAILS, details);
        result.setData(EventModel.Key.ID, id);
        return result;
    }

    private static EventModel convert(Deposit entity) {
        Event event = Event.DEPOSIT;
        long id = entity.getId();
        Date date = convert(entity.getDate());
        int duration = entity.getDuration();
        BigDecimal interest = entity.getInterest();
        BigDecimal amount = entity.getAmount();
        EventModel result = new EventModel();
        result.setData(EventModel.Key.EVENT, event);
        result.setData(EventModel.Key.AMOUNT, amount);
        result.setData(EventModel.Key.DATE, date);
        result.setData(EventModel.Key.DURATION, duration);
        result.setData(EventModel.Key.INTEREST, interest);
        result.setData(EventModel.Key.ID, id);
        return result;
    }

    private static <T extends IEntity> EventModel convert(T entity, Event event) {
        EventModel result = null;
        switch (event) {
            case DEPOSIT:
                result = convert((Deposit) entity);
                break;
            case EXPENSES:
                result = convert((Expense) entity);
                break;
            case INFLOW:
                result = convert((Inflow) entity);
                break;
            default:
        }
        return result;
    }

    private static Date convert(java.sql.Date date) {
        return new Date(date.getTime());
    }

    private static java.sql.Date convert(Date date) {
        return new java.sql.Date(date.getTime());
    }

}
