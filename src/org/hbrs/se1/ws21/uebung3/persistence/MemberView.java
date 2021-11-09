package org.hbrs.se1.ws21.uebung3.persistence;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.List;

public class MemberView {

    public void dump(List<Member> liste){
        /*     for (int i = 0; i < this.liste.size(); i++) {
            System.out.println(liste.get(i));
        }*/
        for (Member x:liste) {
            System.out.println(x.toString());
        }
    }
    public List<Member> getCurrentList(){
        return Container.getInstance().liste;
    }
}

