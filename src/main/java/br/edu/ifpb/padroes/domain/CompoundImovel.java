package br.edu.ifpb.padroes.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundImovel implements Property {

    protected List<Property> children = new ArrayList<>();

    public CompoundImovel(Property... components){
        add(components);
    }

    public void add(Property componente){
        children.add(componente);
    }

    public void add(Property... componentes){
        children.addAll(Arrays.asList(componentes));
    }

    public void remove(Property child){
        children.remove(child);
    }

    public void remove(Property... child){
        children.removeAll(Arrays.asList(child));
    }


    @Override
    public float getPrice() {
        if (children.size() == 0){
            return 0;
        }

        float total = 0;

        for (Property imovel : children){
            total = total + imovel.getPrice();
        }

        return total;
    }
}
