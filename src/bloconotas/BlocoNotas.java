package bloconotas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BlocoNotas extends Application 
{

    public static void main(String[] args) 
    {
        launch();
    }
    
    @Override
    public void start(Stage palco) 
    {
        MyPane painel=new MyPane();
        painel.setStyle("-fx-background-color: linear-gradient(silver 0%, white 40%,white 40%, WhiteSmoke 50%,white 60%, WhiteSmoke 50%,  white 60%, silver 100%)");
                
        Scene cenario=new Scene(painel);
        palco.setScene(cenario);
        palco.setWidth(800);
        palco.setHeight(585);
        palco.show();
    }
}
