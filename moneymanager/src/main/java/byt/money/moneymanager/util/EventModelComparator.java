package byt.money.moneymanager.util;

import byt.money.moneymanager.model.EventModel;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Lukasz
 */
public class EventModelComparator implements Comparator<EventModel> {

    @Override
    public int compare(EventModel o1, EventModel o2) {
        Date date1 = (Date) o1.getValue(EventModel.Key.DATE);
        Date date2 = (Date) o2.getValue(EventModel.Key.DATE);
        return date2.compareTo(date1);
    }

}
