package com.seubanco.gui;

import com.seubanco.model.Conta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BankGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banco");

        // Criação do TabPane e das Tabs
        TabPane tabPane = new TabPane();

        Tab tabContas = new Tab("Contas", createContaContent());
        tabContas.setClosable(false);

        Tab tabSegurosVida = new Tab("Seguros de Vida", createSeguroVidaContent());
        tabSegurosVida.setClosable(false);

        Tab tabRelatorio = new Tab("Relatório", createRelatorioContent());
        tabRelatorio.setClosable(false);

        tabPane.getTabs().addAll(tabContas, tabSegurosVida, tabRelatorio);

        Scene scene = new Scene(tabPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node createContaContent() {
        // Table setup
        TableView<Conta> table = new TableView<>();
        table.getColumns().addAll(createColumn("Titular", "titular"),
                                  createColumn("Número", "numero"),
                                  createColumn("Agência", "agencia"),
                                  createColumn("Saldo", "saldo"),
                                  createColumn("Tipo", "tipo"));

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Buttons setup
        Button btnNovaConta = new Button("Nova Conta");
        btnNovaConta.setOnAction(e -> createContaForm());

        Button btnSalvarDados = new Button("Salvar Dados");
        // btnSalvarDados.setOnAction(e -> saveData());

        // Button panel setup
        HBox buttonPanel = new HBox(10, btnNovaConta, btnSalvarDados);
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setPadding(new Insets(10));

        // Layout setup
        BorderPane pane = new BorderPane();
        pane.setCenter(table);
        pane.setBottom(buttonPanel);

        return pane;
    }

    private TableColumn<Conta, String> createColumn(String title, String propertyName) {
        TableColumn<Conta, String> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return column;
    }

        private void createContaForm() {
            Stage ContaStage = new Stage();
            ContaStage.setTitle("Criar Nova Conta");

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            grid.add(new Label("Titular:"), 0, 0);
            TextField txtTitular = new TextField();
            grid.add(txtTitular, 1, 0);

            grid.add(new Label("Número:"), 0, 1);
            TextField txtNumero = new TextField();
            grid.add(txtNumero, 1, 1);

            grid.add(new Label("Agência:"), 0, 2);
            TextField txtAgencia = new TextField();
            grid.add(txtAgencia, 1, 2);

            grid.add(new Label("Saldo Inicial:"), 0, 3);
            TextField txtSaldo = new TextField();
            grid.add(txtSaldo, 1, 3);

            grid.add(new Label("Tipo de Conta:"), 0, 4);
            ComboBox<String> cbTipoConta = new ComboBox<>();
            cbTipoConta.getItems().addAll("Corrente", "Investimento", "Poupança");
            grid.add(cbTipoConta, 1, 4);

            Button btnCriarConta = new Button("Criar Conta");
            grid.add(btnCriarConta, 1, 5);

            btnCriarConta.setOnAction(e -> {
                // Aqui você coleta os dados e cria a conta
                // ...
                ContaStage.close();
            });

            Scene scene = new Scene(grid, 300, 275);
            ContaStage.setScene(scene);
            ContaStage.show();
        }


        
        private Node createSeguroVidaContent() {
            // Crie o conteúdo para a aba Seguros de Vida
            return new Label("Conteúdo Seguro de Vida"); // Substitua com o conteúdo real
        }
        
        private Node createRelatorioContent() {
            // Crie o conteúdo para a aba Relatório
            return new Label("Conteúdo Relatório"); // Substitua com o conteúdo real
        }
    }
