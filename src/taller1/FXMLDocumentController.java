/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author ricky.mosquera
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas Lienzo;
    private GraphicsContext g;
    @FXML
    private Label ptoX;
    @FXML
    private Label ptoY;
    @FXML
    private Circle Circle;
    
    
    @FXML
    private void crearCuadrado(ActionEvent event) {

        g.setStroke(Color.RED);
        g.setLineWidth(1);
        g.strokeRect(100, 100, 70, 70);
    }
    
    @FXML
    private void crearCirculo(ActionEvent event) {

        g.setStroke(Color.BLUEVIOLET);
        g.setLineWidth(1);
        g.strokeOval(350, 50, 80, 80);
        
    }
    
    @FXML
    private void crearTrriangulo(ActionEvent event) {
        
    double x[] = {25, 145, 25};
    double y[] = {25, 25, 145};
    

    g.fillPolygon(x, y, 3);
    }
    
    @FXML
    private void Mouse(MouseEvent event) {
        
        double x = event.getX();
        double y = event.getY();
        
        String m = Double.toString(x);
        String n = Double.toString(y);
        
        ptoX.setText(m);
        ptoY.setText(n);
 
    }
    @FXML
    private void Limpiar(ActionEvent event) {
        
        g.clearRect(0, 0, Lienzo.getWidth(), Lienzo.getHeight());

    }
    
    @FXML
    private void CambiarColor(ActionEvent event) {

        g.setFill(Color.rgb((int) (Math.random()*225), (int) (Math.random()*225), (int) (Math.random()*225)));
        g.fillOval(350, 50, 80, 80);
        g.fillRect(100, 100, 70, 70);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         g = Lienzo.getGraphicsContext2D();
        
        double w = Lienzo.getWidth();
        double h = Lienzo.getHeight();
        
        Circle c = new Circle(50);
        Rectangle r = new Rectangle(100, 100);
        
        PathTransition transition = new PathTransition();
        transition.setNode(Circle);
        transition.setDuration(Duration.seconds(5));
        transition.setPath(c);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.play();
    }    
    
}
