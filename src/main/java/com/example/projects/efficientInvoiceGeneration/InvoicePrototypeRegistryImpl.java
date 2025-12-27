package com.example.projects.efficientInvoiceGeneration;

import java.util.HashMap;
import java.util.Map;

public class InvoicePrototypeRegistryImpl implements InvoicePrototypeRegistry {
    Map<InvoiceType, Invoice> prototypes;

    public InvoicePrototypeRegistryImpl() {
        prototypes = new HashMap<>();
    }

    public void addPrototype(Invoice user) {
        prototypes.put(user.getType(), user);
    }

    public Invoice getPrototype(InvoiceType type) {
        return prototypes.get(type);
    }

    public Invoice clone(InvoiceType type) {
        Invoice prototype = prototypes.get(type);
        return prototype.cloneObject();
    }
}