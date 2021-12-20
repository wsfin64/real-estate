package br.edu.ifpb.padroes.payment;

import br.edu.ifpb.padroes.domain.Property;

public abstract class PaymentProcessor implements PaymentProcessorHandler {

    private PaymentProcessor next;

    public PaymentProcessor linkWith(PaymentProcessor next){
        this.next = next;
        return next;
    }

    public abstract void process(Property property);

    protected boolean checkNext(Property property){

        if (next == null){
            return true;
        }
        next.process(property);

        return false;
    }

}
