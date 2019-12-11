package com.gkd;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("开挂！GOGOGOGO");
        btn.setOnAction(event -> {

        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label x = new Label("x");
        Label y = new Label("y");

        // 添加各种坐标
        this.createLabel("PVP菜单坐标：", grid, 0, 1);
        this.createLabel("x", grid, 1, 1);
        this.createText(grid, 1, 1);
        this.createLabel("y", grid, 2, 1);
        this.createText(grid, 2, 1);

        Label joinLabel = new Label("加入战斗坐标：");
        grid.add(joinLabel, 0, 2);

        TextField joinText = new TextField();
        grid.add(joinText, 1, 2);

        Label closeLabel = new Label("关闭PVP菜单坐标：");
        grid.add(closeLabel, 0, 3);

        TextField closeText = new TextField();
        grid.add(closeText, 1, 3);

        Label enterLabel = new Label("进入战场坐标：");
        grid.add(enterLabel, 0, 4);

        TextField enterText = new TextField();
        grid.add(enterText, 1, 4);

        Label leaveLabel = new Label("离开战场坐标：");
        grid.add(leaveLabel, 0, 5);

        TextField leaveText = new TextField();
        grid.add(leaveText, 1, 5);

        // 添加按钮
        grid.add(btn, 0, 6);
        Scene scene = new Scene(grid, 300, 250);

        primaryStage.setTitle("挂一挂");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createLabel(String labelName, GridPane grid, int col, int row) {
        Label l = new Label(labelName);
        grid.add(l, col, row);
    }

    private void createText(GridPane grid, int col, int row) {
        TextField txt = new TextField();
        grid.add(txt, col, row);
    }
}
