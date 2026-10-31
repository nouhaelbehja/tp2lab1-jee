package com.example;

import com.example.dao.DaoImpl;
import com.example.metier.IMetier;
import com.example.metier.MetierImpl;
import com.example.presentation.Presentation2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class SpringInjectionTest {
    @Test
    public void springInjectsDao2() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(Presentation2.class)) {
            assertEquals(300.0, context.getBean(IMetier.class).calcul(), 0.0);
        }
    }

    @Test
    public void setterAllowsUsingDao() {
        MetierImpl metier = new MetierImpl();
        metier.setDao(new DaoImpl());
        assertEquals(200.0, metier.calcul(), 0.0);
    }
}
