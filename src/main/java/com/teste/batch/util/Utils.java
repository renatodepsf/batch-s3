package com.teste.batch.util;

import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {

    public List<Object> csvParaObjeto(Class<?> classe, S3Object s3Object) {
        List<Object> listObject = new ArrayList<>();
        try {
            Object objeto = classe.getDeclaredConstructor().newInstance();
            listObject = mapeiaCampos(objeto, s3Object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObject;
    }

    public <T> List<T> mapeiaCampos(T instancia, S3Object object) throws Exception {
        List<T> lsObjetos = new ArrayList<>();
        S3ObjectInputStream conteudoArquivo = object.getObjectContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conteudoArquivo));
        String linha = null;
        while ((linha = reader.readLine()) != null) {
            String[] values = linha.split(",");

            T obj = (T) instancia.getClass().getDeclaredConstructor().newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length && i < values.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].getType().isArray()) {
                    fields[i].set(obj, values[i].split(";"));
                } else {
                    fields[i].set(obj, values[i]);
                }
            }
            lsObjetos.add(obj);
        }

        reader.close();
        return lsObjetos;
    }
}