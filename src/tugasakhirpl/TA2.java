/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirpl;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane; //terjadi error karena kurangnya tanda ;

/**
 *
 * @author ASUS
 */
public class TA2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Konversi Suhu"); //terjadi error karena kurangnya tanda ()

        primaryStage.setResizable(false);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        Scene scene = new Scene(grid, 350, 300);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Konversi suhu Celcius");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label panjang = new Label("Suhu ");
        grid.add(panjang, 0, 1);

        TextField panjangText = new TextField();
        panjangText.toString();
        grid.add(panjangText, 0, 2);

        Label suhu = new Label("    Celcius");
        grid.add(suhu, 1, 2);
        
        Button next = new Button("Lanjut");
        HBox hBaru = new HBox(5);
        hBaru.setAlignment(Pos.BOTTOM_CENTER);
        hBaru.getChildren().add(next);

        HBox buttons2 = new HBox(0, next);
        grid.add(buttons2, 0, 3);

        Label kelvin = new Label("Kelvin ");
        grid.add(kelvin, 0, 4);
        TextField kelvinText = new TextField();
        kelvinText.toString();
        kelvinText.setDisable(true);
        grid.add(kelvinText, 1, 4);

        Label farenheit = new Label("Farenheit ");
        grid.add(farenheit, 0, 5);
        TextField farenheitText = new TextField();
        farenheitText.toString();
        farenheitText.setDisable(true);
        grid.add(farenheitText, 1, 5);

        Label reamur = new Label("Reamur  ");
        grid.add(reamur, 0, 6);
        TextField reamurText = new TextField();
        reamurText.toString();
        reamurText.setDisable(true);
        grid.add(reamurText, 1, 6);
        
        Button del = new Button("Delete");
        HBox hbtn = new HBox(5);
        hbtn.setAlignment(Pos.BOTTOM_CENTER);
        hbtn.getChildren().add(del);
        
        HBox buttons3 = new HBox(0, del);
        grid.add(buttons3, 0, 7);

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (panjangText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Inputan tidak boleh kosong");
                }
                else {
                try {
                    double pjjg = Double.valueOf(panjangText.getText());
                    double hasilkelvin = pjjg + 273;
                    double hasilfaren = (9* pjjg/5)+32;
                    double hasilreamur = (4* pjjg/5); 
                    String valuekelvin = String.valueOf(hasilkelvin);
                    String valuefaren = String.valueOf(hasilfaren);
                    String valuereamur = String.valueOf(hasilreamur);
                    kelvinText.setText(valuekelvin);
                    farenheitText.setText(valuefaren);
                    reamurText.setText(valuereamur);
                    panjangText.setDisable(true);
                    newStage nW = new newStage(kelvinText.getText(), farenheitText.getText(), reamurText.getText());
                } catch (Exception e) {
                    System.out.println("Salah");
                }
            }
            }
        });
        
        del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                panjangText.setText("");
                farenheitText.setText("");
                reamurText.setText("");
                kelvinText.setText("");
                panjangText.setDisable(false);
            }
        });
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    class newStage {
    private newStage(String text , String text0, String text1){
        GridPane gBaru = new GridPane();
        gBaru.setHgap(10);
        gBaru.setVgap(10);
        gBaru.setPadding(new Insets(10, 10, 10, 10));
        gBaru.setAlignment(Pos.CENTER);
        Scene s = new Scene(gBaru, 300,400);
        Stage sD = new Stage();
        sD.setResizable(false);
        sD.setTitle("Berhasil Dihitung");
        sD.setScene(s);
        
        Text pesan = new Text("Hasil Perhitungan");
        pesan.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gBaru.add(pesan, 0, 0);
        
        Label kelvinlab = new Label("Kelvin ");
        gBaru.add(kelvinlab, 0, 1);
        
        Text kelvin = new Text(text);
        gBaru.add(kelvin, 1, 1);
        
        Label farenheitlab = new Label("Farenheit ");
        gBaru.add(farenheitlab, 0, 2);
        
        Text farenheit = new Text(text0);
        gBaru.add(farenheit, 1, 2);
        
        Label reamurlab = new Label("Reamur  ");
        gBaru.add(reamurlab, 0, 3);
        
        Text reamur = new Text(text1);
        gBaru.add(reamur, 1, 3);
        sD.show();
        
    }
}
}
