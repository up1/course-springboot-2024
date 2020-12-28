package com.workshop.day1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public interface Promotion {
    void calculate();
}
@Component
class Promotion1 implements Promotion {
    @Override
    public void calculate() {
    }
}

@Component
class Promotion2 implements Promotion {
    @Override
    public void calculate() {
    }
}
