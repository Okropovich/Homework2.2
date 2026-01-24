package org.skypro.skyshop.exceptions;

public class BestResultNotFoundException extends Exception{
    public BestResultNotFoundException(String search){
        super("Для поискового запроса [" + search + "] не нашлось подходящего результата.");
    }
}
