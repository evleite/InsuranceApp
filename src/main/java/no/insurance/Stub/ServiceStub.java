package no.insurance.Stub;

import no.insurance.domain.Service;
import no.insurance.helper.Insurance;
import no.insurance.helper.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by p on 22/10/2016.
 */
public class ServiceStub {

    private static Map<Long, Service> services = new HashMap<Long, Service>();
    private static Long idIndex = 3L;

    private static Long userId1 = 1L;
    private static Long userId2 = 2L;
    private static Long userId3 = 3L;

    static {
        Service service = new Service(1L, userId1, Insurance.CAR.getValue(), "product got for my car", State.SEND.getValue(), 3450.5);
        services.put(1L, service);

        service = new Service(2L, userId2, Insurance.HOME.getValue(), "product got for my home", State.PAY.getValue(), 3450.5);
        services.put(2L, service);

        service = new Service(3L, userId3, Insurance.BOAT.getValue(), "product got for my boat", State.ACTIVE.getValue(), 3450.5);
        services.put(3L, service);

        /*
            Long Id;
            Integer userId;
            Integer type;
            String product;
            Integer state;
            Double price;
         */

    }

    public static List<Service> list() {

        return new ArrayList<Service>(services.values());

    }

    public static Service create(Service wreck) {

        idIndex += idIndex;
        wreck.setId(idIndex);
        services.put(idIndex, wreck);
        return wreck;
    }

    public static Service get(Long id) {

        return services.get(id);
    }

    public static Service update(Long id, Service service) {

        services.put(id, service);
        return service;

    }

    public static Service delete(Long id) {

        return services.remove(id);
    }





}
