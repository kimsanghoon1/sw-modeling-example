package com.autoinsurance.controller;

import com.autoinsurance.Customer;
import org.metaworks.annotation.ServiceMethod;

import javax.xml.ws.ServiceMode;

/**
 * Created by uengine on 2017. 7. 3..
 */
public class NameAndAddressTab {

    Customer customer;
        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }


    @ServiceMethod
    public VehiclesTab next(){
        return new VehiclesTab();
    }

}
