package com.seubanco.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.seubanco.model.Conta;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContaJsonUtil {

    private static final String FILE_PATH = "com.seubanco.contas.json";
    private static final Gson gson = new Gson();
    private static final Type CONTA_LIST_TYPE = new TypeToken<List<Conta>>() {}.getType();

    public static void salvarContasNoJson(List<Conta> contas) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(contas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Conta> lerContasDoJson() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, CONTA_LIST_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}