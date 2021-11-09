package org.hbrs.se1.ws21.uebung2.test;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.ContainerException;
import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung2.MemberImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    private MemberImpl a, b, c ;

    @BeforeEach
    public void init(){
        this.a = new MemberImpl(1);
        this.b = new MemberImpl(2);
        this.c = new MemberImpl(3);
    }

    @Test
    public void containertest() throws ContainerException {
        Container x = new Container();
        assertEquals(0, x.size());
        x.addMember(a);
        assertEquals(1, x.size());
        x.addMember(b);
        assertEquals(2, x.size());
        /*new Executable() {
            @Override
            public void execute() throws Throwable {

            }
        }*/
        assertThrows(ContainerException.class, () -> x.addMember(b));
        assertEquals(2, x.size());
        x.addMember(c);
        assertEquals(3, x.size());
    }

}
