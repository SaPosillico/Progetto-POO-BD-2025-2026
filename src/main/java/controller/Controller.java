package controller;

import javax.swing.*;

public class Controller {
    private JFrame frameAttuale;

    public Controller(JFrame frameHome){
        frameAttuale = frameHome;
    }

    public void changeFrame(JFrame nuovoFrame){
        if(nuovoFrame!=null){
            nuovoFrame.setVisible(true);
            frameAttuale.dispose();
            frameAttuale = nuovoFrame;
        }
    }

}
