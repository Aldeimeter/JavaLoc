package com.vava;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.util.Locale;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.text.NumberFormat;
import java.util.Currency;
public class LocalizationController{

    private App app;
    
    public void setApp(App app){
      this.app = app;
    }

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;

    @FXML
    private Button ChangeLocaleBtn;

    @FXML
    private TextField CurrencyField;

    @FXML
    private TextField DateField;

    @FXML
    private TextArea DescriptionField;

    @FXML
    private TextField MessageField;

    @FXML
    private TextField NumberField;

    @FXML
    private TextField TimeField;
    
    @FXML
    private AnchorPane anchorPane;


    @FXML
    void initialize() {
        // date
      DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
      DateField.setText(LocalDate.now().format(dateFormatter));
      
        //time
      DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
      TimeField.setText(LocalTime.now().format(timeFormatter)); 

        //number
      NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
      NumberField.setText(numberFormat.format(123456.789));

        //currency
      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
      currencyFormat.setCurrency(Currency.getInstance("USD"));
      CurrencyField.setText(currencyFormat.format(987.37));


      Label newLabel = new Label(resources.getString("labelText"));
      anchorPane.getChildren().add(newLabel);
    }
    @FXML
    void handleChangeLocaleBtn(ActionEvent event){
      Locale.setDefault(Locale.getDefault() == Locale.US ? new Locale("sk","SK") : Locale.US);
        try {
            app.reloadScene();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
