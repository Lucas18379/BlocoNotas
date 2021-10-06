package bloconotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;


public class MyPane extends Pane
{
    private TextArea tadigitacao;
    private Button bAumenta, bDiminui, bNovo, bAbrir, bSalvar;
    private int fontSize;
    
    public MyPane()
    {
        this.fontSize = 15;
        inicializaComponentes();
    }
    
    private void inicializaComponentes()
    {
        tadigitacao = new TextArea();
        tadigitacao.setPrefWidth(700);
        tadigitacao.setPrefHeight(425);
        tadigitacao.setLayoutX(50);
        tadigitacao.setLayoutY(45);
        tadigitacao.setStyle("-fx-background-insets: 0,1,4,5,6;"
                           + "-fx-background-radius: 9,8,5,4,3;"
                           + "-fx-padding: 10;"
                           + "-fx-background-color: #4A708B;");
        
        bAumenta = new Button("+");
        bAumenta.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                                                "linear-gradient(#020b02, #3a3a3a),\n" +
                                                "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                                                "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                                                "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
                        + "-fx-background-insets: 0,1,4,5,6;"
                        + "-fx-background-radius: 9,8,5,4,3;"+
                          "-fx-font-family: \"Helvetica\";\n" +
                          "-fx-font-size: 15px;\n" +
                          "-fx-font-weight: bold;\n" +
                          "-fx-text-fill: white;\n" +
                          "-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        bAumenta.setPrefWidth(40);
        bAumenta.setPrefHeight(35);
        bAumenta.setLayoutX(650);
        bAumenta.setLayoutY(5);
        bAumenta.setOnAction(e->{
            aumentaFont();
        });
        
        bDiminui = new Button("-");
        bDiminui.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                                                "linear-gradient(#020b02, #3a3a3a),\n" +
                                                "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                                                "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                                                "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
                        + "-fx-background-insets: 0,1,4,5,6;"
                        + "-fx-background-radius: 9,8,5,4,3;"+
                          "-fx-font-family: \"Helvetica\";\n" +
                          "-fx-font-size: 15px;\n" +
                          "-fx-font-weight: bold;\n" +
                          "-fx-text-fill: white;\n" +
                          "-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        bDiminui.setPrefWidth(40);
        bDiminui.setPrefHeight(35);
        bDiminui.setLayoutX(710);
        bDiminui.setLayoutY(5);
        bDiminui.setOnAction(e->{
            diminuiFont();
        });
        
        bNovo = new Button("Novo");
        bNovo.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                                                "linear-gradient(#020b02, #3a3a3a),\n" +
                                                "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                                                "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                                                "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
                        + "-fx-background-insets: 0,1,4,5,6;"
                        + "-fx-background-radius: 9,8,5,4,3;"+
                          "-fx-font-family: \"Helvetica\";\n" +
                          "-fx-font-size: 15px;\n" +
                          "-fx-font-weight: bold;\n" +
                          "-fx-text-fill: white;\n" +
                          "-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        bNovo.setPrefWidth(100);
        bNovo.setPrefHeight(50);
        bNovo.setLayoutX(200);
        bNovo.setLayoutY(485);
        bNovo.setOnAction(e->{
            aparaTA();
        });
        
        bAbrir = new Button("Abrir");
        bAbrir.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                                                "linear-gradient(#020b02, #3a3a3a),\n" +
                                                "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                                                "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                                                "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
                        + "-fx-background-insets: 0,1,4,5,6;"
                        + "-fx-background-radius: 9,8,5,4,3;"+
                          "-fx-font-family: \"Helvetica\";\n" +
                          "-fx-font-size: 15px;\n" +
                          "-fx-font-weight: bold;\n" +
                          "-fx-text-fill: white;\n" +
                          "-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        bAbrir.setPrefWidth(100);
        bAbrir.setPrefHeight(50);
        bAbrir.setLayoutX(350);
        bAbrir.setLayoutY(485);
        bAbrir.setOnAction(e->{
            abrir();
        });
        
        bSalvar = new Button("Salvar");
        bSalvar.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                                                "linear-gradient(#020b02, #3a3a3a),\n" +
                                                "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                                                "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                                                "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
                        + "-fx-background-insets: 0,1,4,5,6;"
                        + "-fx-background-radius: 9,8,5,4,3;"+
                          "-fx-font-family: \"Helvetica\";\n" +
                          "-fx-font-size: 15px;\n" +
                          "-fx-font-weight: bold;\n" +
                          "-fx-text-fill: white;\n" +
                          "-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        bSalvar.setPrefWidth(100);
        bSalvar.setPrefHeight(50);
        bSalvar.setLayoutX(500);
        bSalvar.setLayoutY(485);
        bSalvar.setOnAction(e->{
            armazenar();
        });
        
        this.getChildren().addAll(tadigitacao, bAumenta, bDiminui, bNovo, bAbrir, bSalvar);
    }
    private void aumentaFont()
    {
        fontSize+=3;
                String tam = String.format("%d px",(int)fontSize);
                tadigitacao.setStyle("-fx-background-insets: 0,1,4,5,6;"
                           + "-fx-background-radius: 9,8,5,4,3;"
                           + "-fx-padding: 10;"
                           + "-fx-background-color: #4A708B;"
                           + "-fx-font-size: "+tam);
    }
    private void diminuiFont()
    {
        fontSize-=3;
                String tam = String.format("%d px",(int)fontSize);
                tadigitacao.setStyle("-fx-background-insets: 0,1,4,5,6;"
                           + "-fx-background-radius: 9,8,5,4,3;"
                           + "-fx-padding: 10;"
                           + "-fx-background-color: #4A708B;"
                           + "-fx-font-size: "+tam);
    }
    private void aparaTA()
    {
        tadigitacao.clear();
    }
    private void armazenar()
    {
        FileChooser fc = new FileChooser();
        fc.setTitle("Escolha um local para salvar o arquivo");
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter( "TXT files (*.txt)", "*.txt");       
        fc.getExtensionFilters().add(extFilter);
        File file = fc.showSaveDialog(null);
        if(file != null)
        {
            BufferedWriter bw;
            try {
                bw = new BufferedWriter(new FileWriter(file,false));
                bw.write(tadigitacao.getText());
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(MyPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    private void abrir()
    {
        FileChooser fc = new FileChooser();
        fc.setTitle("Escolha um arquivo para abrir");
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter( "TXT files (*.txt)", "*.txt");       
        fc.getExtensionFilters().add(extFilter);
        File file = fc.showOpenDialog(null);
        if(file != null)
        {
            String linhas = "",linha;
            try(BufferedReader buffRead = new BufferedReader(new FileReader(file)))
            {       
                linha = buffRead.readLine();
                while (linha != null) 
                {
                    linhas += linha; 
                    linha = buffRead.readLine();
                }
                tadigitacao.setText(linhas);
            }
            catch (IOException ex) {
                Logger.getLogger(MyPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
