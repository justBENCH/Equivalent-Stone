package ru.bench.equivalentstone;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers(Main instance) {
        instance.elements.forEach(element -> element.registerRenderers());
    }
}